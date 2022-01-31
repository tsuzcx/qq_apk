package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cz
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String npR;
  public String nuc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111667);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nuc != null) {
        paramVarArgs.e(1, this.nuc);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(2, this.IconUrl);
      }
      if (this.npR != null) {
        paramVarArgs.e(3, this.npR);
      }
      AppMethodBeat.o(111667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nuc == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.nuc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.IconUrl);
      }
      i = paramInt;
      if (this.npR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npR);
      }
      AppMethodBeat.o(111667);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111667);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cz localcz = (cz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111667);
          return -1;
        case 1: 
          localcz.nuc = locala.CLY.readString();
          AppMethodBeat.o(111667);
          return 0;
        case 2: 
          localcz.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(111667);
          return 0;
        }
        localcz.npR = locala.CLY.readString();
        AppMethodBeat.o(111667);
        return 0;
      }
      AppMethodBeat.o(111667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cz
 * JD-Core Version:    0.7.0.1
 */