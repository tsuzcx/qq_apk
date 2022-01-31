package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dh
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String Title;
  public String npR;
  public String nqt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111674);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.IconUrl != null) {
        paramVarArgs.e(1, this.IconUrl);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.npR != null) {
        paramVarArgs.e(3, this.npR);
      }
      if (this.nqt != null) {
        paramVarArgs.e(4, this.nqt);
      }
      AppMethodBeat.o(111674);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IconUrl == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.IconUrl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.npR != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npR);
      }
      paramInt = i;
      if (this.nqt != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nqt);
      }
      AppMethodBeat.o(111674);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111674);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dh localdh = (dh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111674);
          return -1;
        case 1: 
          localdh.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(111674);
          return 0;
        case 2: 
          localdh.Title = locala.CLY.readString();
          AppMethodBeat.o(111674);
          return 0;
        case 3: 
          localdh.npR = locala.CLY.readString();
          AppMethodBeat.o(111674);
          return 0;
        }
        localdh.nqt = locala.CLY.readString();
        AppMethodBeat.o(111674);
        return 0;
      }
      AppMethodBeat.o(111674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dh
 * JD-Core Version:    0.7.0.1
 */