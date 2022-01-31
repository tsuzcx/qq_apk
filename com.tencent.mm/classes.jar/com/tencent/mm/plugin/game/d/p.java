package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.bv.a
{
  public String nqH;
  public String nqI;
  public String nqJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111555);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqH != null) {
        paramVarArgs.e(1, this.nqH);
      }
      if (this.nqI != null) {
        paramVarArgs.e(2, this.nqI);
      }
      if (this.nqJ != null) {
        paramVarArgs.e(3, this.nqJ);
      }
      AppMethodBeat.o(111555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqH == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.nqH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nqI != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nqI);
      }
      i = paramInt;
      if (this.nqJ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nqJ);
      }
      AppMethodBeat.o(111555);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111555);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111555);
          return -1;
        case 1: 
          localp.nqH = locala.CLY.readString();
          AppMethodBeat.o(111555);
          return 0;
        case 2: 
          localp.nqI = locala.CLY.readString();
          AppMethodBeat.o(111555);
          return 0;
        }
        localp.nqJ = locala.CLY.readString();
        AppMethodBeat.o(111555);
        return 0;
      }
      AppMethodBeat.o(111555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.p
 * JD-Core Version:    0.7.0.1
 */