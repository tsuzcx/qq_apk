package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class an
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Title;
  public String fKw;
  public String npR;
  public String nrM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111580);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nrM != null) {
        paramVarArgs.e(1, this.nrM);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      if (this.npR != null) {
        paramVarArgs.e(4, this.npR);
      }
      if (this.fKw != null) {
        paramVarArgs.e(5, this.fKw);
      }
      AppMethodBeat.o(111580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nrM == null) {
        break label454;
      }
    }
    label454:
    for (int i = e.a.a.b.b.a.f(1, this.nrM) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Desc);
      }
      paramInt = i;
      if (this.npR != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.npR);
      }
      i = paramInt;
      if (this.fKw != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.fKw);
      }
      AppMethodBeat.o(111580);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111580);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        an localan = (an)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111580);
          return -1;
        case 1: 
          localan.nrM = locala.CLY.readString();
          AppMethodBeat.o(111580);
          return 0;
        case 2: 
          localan.Title = locala.CLY.readString();
          AppMethodBeat.o(111580);
          return 0;
        case 3: 
          localan.Desc = locala.CLY.readString();
          AppMethodBeat.o(111580);
          return 0;
        case 4: 
          localan.npR = locala.CLY.readString();
          AppMethodBeat.o(111580);
          return 0;
        }
        localan.fKw = locala.CLY.readString();
        AppMethodBeat.o(111580);
        return 0;
      }
      AppMethodBeat.o(111580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.an
 * JD-Core Version:    0.7.0.1
 */