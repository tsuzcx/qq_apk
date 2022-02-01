package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class z
  extends com.tencent.mm.cd.a
{
  public String rVv;
  public long rWF;
  public long rWG;
  public String rWH;
  public String rWI;
  public LinkedList<String> rWl;
  
  public z()
  {
    AppMethodBeat.i(22131);
    this.rWl = new LinkedList();
    AppMethodBeat.o(22131);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22132);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rVv == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.rWH == null)
      {
        paramVarArgs = new b("Not all required fields were included: MsgDataID");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.rWI == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(22132);
        throw paramVarArgs;
      }
      if (this.rVv != null) {
        paramVarArgs.f(1, this.rVv);
      }
      paramVarArgs.bm(2, this.rWF);
      paramVarArgs.bm(3, this.rWG);
      if (this.rWH != null) {
        paramVarArgs.f(4, this.rWH);
      }
      if (this.rWI != null) {
        paramVarArgs.f(5, this.rWI);
      }
      paramVarArgs.e(6, 1, this.rWl);
      AppMethodBeat.o(22132);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rVv == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = g.a.a.b.b.a.g(1, this.rVv) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.rWF) + g.a.a.b.b.a.p(3, this.rWG);
      paramInt = i;
      if (this.rWH != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.rWH);
      }
      i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.rWI);
      }
      paramInt = g.a.a.a.c(6, 1, this.rWl);
      AppMethodBeat.o(22132);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rWl.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.rVv == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.rWH == null)
        {
          paramVarArgs = new b("Not all required fields were included: MsgDataID");
          AppMethodBeat.o(22132);
          throw paramVarArgs;
        }
        if (this.rWI == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22132);
          return -1;
        case 1: 
          localz.rVv = locala.abFh.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 2: 
          localz.rWF = locala.abFh.AN();
          AppMethodBeat.o(22132);
          return 0;
        case 3: 
          localz.rWG = locala.abFh.AN();
          AppMethodBeat.o(22132);
          return 0;
        case 4: 
          localz.rWH = locala.abFh.readString();
          AppMethodBeat.o(22132);
          return 0;
        case 5: 
          localz.rWI = locala.abFh.readString();
          AppMethodBeat.o(22132);
          return 0;
        }
        localz.rWl.add(locala.abFh.readString());
        AppMethodBeat.o(22132);
        return 0;
      }
      AppMethodBeat.o(22132);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.z
 * JD-Core Version:    0.7.0.1
 */