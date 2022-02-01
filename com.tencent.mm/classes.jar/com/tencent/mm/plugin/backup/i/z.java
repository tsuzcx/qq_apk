package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class z
  extends com.tencent.mm.bw.a
{
  public String ncJ;
  public LinkedList<String> ndA;
  public long ndT;
  public long ndU;
  public String ndV;
  public String ndW;
  
  public z()
  {
    AppMethodBeat.i(22131);
    this.ndA = new LinkedList();
    AppMethodBeat.o(22131);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22132);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.ndV == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.ndW == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.ncJ != null) {
        paramVarArgs.d(1, this.ncJ);
      }
      paramVarArgs.aO(2, this.ndT);
      paramVarArgs.aO(3, this.ndU);
      if (this.ndV != null) {
        paramVarArgs.d(4, this.ndV);
      }
      if (this.ndW != null) {
        paramVarArgs.d(5, this.ndW);
      }
      paramVarArgs.e(6, 1, this.ndA);
      AppMethodBeat.o(22132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncJ == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncJ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.ndT) + f.a.a.b.b.a.p(3, this.ndU);
      paramInt = i;
      if (this.ndV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ndV);
      }
      i = paramInt;
      if (this.ndW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ndW);
      }
      paramInt = f.a.a.a.c(6, 1, this.ndA);
      AppMethodBeat.o(22132);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ndA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.ncJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.ndV == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgDataID");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.ndW == null)
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
          localz.ncJ = locala.LVo.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 2: 
          localz.ndT = locala.LVo.xG();
          AppMethodBeat.o(22132);
          return 0;
        case 3: 
          localz.ndU = locala.LVo.xG();
          AppMethodBeat.o(22132);
          return 0;
        case 4: 
          localz.ndV = locala.LVo.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 5: 
          localz.ndW = locala.LVo.readString();
          AppMethodBeat.o(22132);
          return 0;
        }
        localz.ndA.add(locala.LVo.readString());
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