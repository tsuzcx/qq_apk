package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends com.tencent.mm.bv.a
{
  public int eoD;
  public String ona;
  public String onb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56608);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.eoD);
      if (this.ona != null) {
        paramVarArgs.e(2, this.ona);
      }
      if (this.onb != null) {
        paramVarArgs.e(3, this.onb);
      }
      AppMethodBeat.o(56608);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.eoD) + 0;
      paramInt = i;
      if (this.ona != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ona);
      }
      i = paramInt;
      if (this.onb != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.onb);
      }
      AppMethodBeat.o(56608);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56608);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56608);
        return -1;
      case 1: 
        locale.eoD = locala.CLY.sl();
        AppMethodBeat.o(56608);
        return 0;
      case 2: 
        locale.ona = locala.CLY.readString();
        AppMethodBeat.o(56608);
        return 0;
      }
      locale.onb = locala.CLY.readString();
      AppMethodBeat.o(56608);
      return 0;
    }
    AppMethodBeat.o(56608);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.e
 * JD-Core Version:    0.7.0.1
 */