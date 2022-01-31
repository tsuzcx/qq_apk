package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ak
  extends com.tencent.mm.bv.a
{
  public String npR;
  public int nrh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116998);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.nrh);
      if (this.npR != null) {
        paramVarArgs.e(2, this.npR);
      }
      AppMethodBeat.o(116998);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.nrh) + 0;
      paramInt = i;
      if (this.npR != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.npR);
      }
      AppMethodBeat.o(116998);
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
      AppMethodBeat.o(116998);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ak localak = (ak)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116998);
        return -1;
      case 1: 
        localak.nrh = locala.CLY.sl();
        AppMethodBeat.o(116998);
        return 0;
      }
      localak.npR = locala.CLY.readString();
      AppMethodBeat.o(116998);
      return 0;
    }
    AppMethodBeat.o(116998);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ak
 * JD-Core Version:    0.7.0.1
 */