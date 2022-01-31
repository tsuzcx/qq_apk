package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  extends com.tencent.mm.bv.a
{
  public String fKw;
  public String npW;
  public int nqU;
  public int nqV;
  public int nqW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111557);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.nqU);
      if (this.fKw != null) {
        paramVarArgs.e(2, this.fKw);
      }
      paramVarArgs.aO(3, this.nqV);
      if (this.npW != null) {
        paramVarArgs.e(4, this.npW);
      }
      paramVarArgs.aO(5, this.nqW);
      AppMethodBeat.o(111557);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.nqU) + 0;
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.fKw);
      }
      i = paramInt + e.a.a.b.b.a.bl(3, this.nqV);
      paramInt = i;
      if (this.npW != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.npW);
      }
      i = e.a.a.b.b.a.bl(5, this.nqW);
      AppMethodBeat.o(111557);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(111557);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      t localt = (t)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(111557);
        return -1;
      case 1: 
        localt.nqU = locala.CLY.sl();
        AppMethodBeat.o(111557);
        return 0;
      case 2: 
        localt.fKw = locala.CLY.readString();
        AppMethodBeat.o(111557);
        return 0;
      case 3: 
        localt.nqV = locala.CLY.sl();
        AppMethodBeat.o(111557);
        return 0;
      case 4: 
        localt.npW = locala.CLY.readString();
        AppMethodBeat.o(111557);
        return 0;
      }
      localt.nqW = locala.CLY.sl();
      AppMethodBeat.o(111557);
      return 0;
    }
    AppMethodBeat.o(111557);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.t
 * JD-Core Version:    0.7.0.1
 */