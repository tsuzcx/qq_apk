package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Title;
  public String nqG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111554);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.nqG != null) {
        paramVarArgs.e(3, this.nqG);
      }
      AppMethodBeat.o(111554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.nqG != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.nqG);
      }
      AppMethodBeat.o(111554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111554);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111554);
          return -1;
        case 1: 
          localo.Title = locala.CLY.readString();
          AppMethodBeat.o(111554);
          return 0;
        case 2: 
          localo.Desc = locala.CLY.readString();
          AppMethodBeat.o(111554);
          return 0;
        }
        localo.nqG = locala.CLY.readString();
        AppMethodBeat.o(111554);
        return 0;
      }
      AppMethodBeat.o(111554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.o
 * JD-Core Version:    0.7.0.1
 */