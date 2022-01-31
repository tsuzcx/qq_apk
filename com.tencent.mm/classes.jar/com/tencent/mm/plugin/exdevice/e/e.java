package com.tencent.mm.plugin.exdevice.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends com.tencent.mm.bv.a
{
  public int lGK;
  public String lGL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19422);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.lGK);
      if (this.lGL != null) {
        paramVarArgs.e(2, this.lGL);
      }
      AppMethodBeat.o(19422);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.lGK) + 0;
      paramInt = i;
      if (this.lGL != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.lGL);
      }
      AppMethodBeat.o(19422);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(19422);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19422);
        return -1;
      case 1: 
        locale.lGK = locala.CLY.sl();
        AppMethodBeat.o(19422);
        return 0;
      }
      locale.lGL = locala.CLY.readString();
      AppMethodBeat.o(19422);
      return 0;
    }
    AppMethodBeat.o(19422);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.e
 * JD-Core Version:    0.7.0.1
 */