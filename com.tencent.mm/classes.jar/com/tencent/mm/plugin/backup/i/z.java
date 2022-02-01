package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class z
  extends com.tencent.mm.bw.a
{
  public String nIB;
  public long nJL;
  public long nJM;
  public String nJN;
  public String nJO;
  public LinkedList<String> nJs;
  
  public z()
  {
    AppMethodBeat.i(22131);
    this.nJs = new LinkedList();
    AppMethodBeat.o(22131);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22132);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIB == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.nJN == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.nJO == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.nIB != null) {
        paramVarArgs.d(1, this.nIB);
      }
      paramVarArgs.aZ(2, this.nJL);
      paramVarArgs.aZ(3, this.nJM);
      if (this.nJN != null) {
        paramVarArgs.d(4, this.nJN);
      }
      if (this.nJO != null) {
        paramVarArgs.d(5, this.nJO);
      }
      paramVarArgs.e(6, 1, this.nJs);
      AppMethodBeat.o(22132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIB == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIB) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.nJL) + f.a.a.b.b.a.p(3, this.nJM);
      paramInt = i;
      if (this.nJN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nJN);
      }
      i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nJO);
      }
      paramInt = f.a.a.a.c(6, 1, this.nJs);
      AppMethodBeat.o(22132);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nJs.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.nIB == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.nJN == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgDataID");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.nJO == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22132);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22132);
          return -1;
        case 1: 
          localz.nIB = locala.OmT.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 2: 
          localz.nJL = locala.OmT.zd();
          AppMethodBeat.o(22132);
          return 0;
        case 3: 
          localz.nJM = locala.OmT.zd();
          AppMethodBeat.o(22132);
          return 0;
        case 4: 
          localz.nJN = locala.OmT.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 5: 
          localz.nJO = locala.OmT.readString();
          AppMethodBeat.o(22132);
          return 0;
        }
        localz.nJs.add(locala.OmT.readString());
        AppMethodBeat.o(22132);
        return 0;
      }
      AppMethodBeat.o(22132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.z
 * JD-Core Version:    0.7.0.1
 */