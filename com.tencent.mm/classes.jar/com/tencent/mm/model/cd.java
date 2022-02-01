package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cd
  extends com.tencent.mm.bw.a
{
  public long hwQ;
  public String iFF;
  public int key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143730);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.key);
      if (this.iFF != null) {
        paramVarArgs.e(2, this.iFF);
      }
      paramVarArgs.bb(3, this.hwQ);
      AppMethodBeat.o(143730);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.key) + 0;
      paramInt = i;
      if (this.iFF != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.iFF);
      }
      i = g.a.a.b.b.a.r(3, this.hwQ);
      AppMethodBeat.o(143730);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143730);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cd localcd = (cd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143730);
        return -1;
      case 1: 
        localcd.key = locala.UbS.zi();
        AppMethodBeat.o(143730);
        return 0;
      case 2: 
        localcd.iFF = locala.UbS.readString();
        AppMethodBeat.o(143730);
        return 0;
      }
      localcd.hwQ = locala.UbS.zl();
      AppMethodBeat.o(143730);
      return 0;
    }
    AppMethodBeat.o(143730);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.cd
 * JD-Core Version:    0.7.0.1
 */