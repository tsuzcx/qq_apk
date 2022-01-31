package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cj
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Title;
  public String npQ;
  public String ntG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111647);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      if (this.npQ != null) {
        paramVarArgs.e(3, this.npQ);
      }
      if (this.ntG != null) {
        paramVarArgs.e(4, this.ntG);
      }
      AppMethodBeat.o(111647);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Desc);
      }
      i = paramInt;
      if (this.npQ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npQ);
      }
      paramInt = i;
      if (this.ntG != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ntG);
      }
      AppMethodBeat.o(111647);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111647);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cj localcj = (cj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111647);
          return -1;
        case 1: 
          localcj.Title = locala.CLY.readString();
          AppMethodBeat.o(111647);
          return 0;
        case 2: 
          localcj.Desc = locala.CLY.readString();
          AppMethodBeat.o(111647);
          return 0;
        case 3: 
          localcj.npQ = locala.CLY.readString();
          AppMethodBeat.o(111647);
          return 0;
        }
        localcj.ntG = locala.CLY.readString();
        AppMethodBeat.o(111647);
        return 0;
      }
      AppMethodBeat.o(111647);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cj
 * JD-Core Version:    0.7.0.1
 */