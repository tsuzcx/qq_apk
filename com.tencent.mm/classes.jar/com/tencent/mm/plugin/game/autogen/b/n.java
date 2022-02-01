package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.cd.a
{
  public int duration;
  public int height;
  public String lpX;
  public String mKO;
  public String title;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40882);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lpX != null) {
        paramVarArgs.f(1, this.lpX);
      }
      if (this.mKO != null) {
        paramVarArgs.f(2, this.mKO);
      }
      paramVarArgs.aY(3, this.height);
      paramVarArgs.aY(4, this.width);
      if (this.title != null) {
        paramVarArgs.f(5, this.title);
      }
      paramVarArgs.aY(6, this.duration);
      AppMethodBeat.o(40882);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lpX == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.b.b.a.g(1, this.lpX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mKO != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.mKO);
      }
      i = i + g.a.a.b.b.a.bM(3, this.height) + g.a.a.b.b.a.bM(4, this.width);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.title);
      }
      i = g.a.a.b.b.a.bM(6, this.duration);
      AppMethodBeat.o(40882);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(40882);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40882);
          return -1;
        case 1: 
          localn.lpX = locala.abFh.readString();
          AppMethodBeat.o(40882);
          return 0;
        case 2: 
          localn.mKO = locala.abFh.readString();
          AppMethodBeat.o(40882);
          return 0;
        case 3: 
          localn.height = locala.abFh.AK();
          AppMethodBeat.o(40882);
          return 0;
        case 4: 
          localn.width = locala.abFh.AK();
          AppMethodBeat.o(40882);
          return 0;
        case 5: 
          localn.title = locala.abFh.readString();
          AppMethodBeat.o(40882);
          return 0;
        }
        localn.duration = locala.abFh.AK();
        AppMethodBeat.o(40882);
        return 0;
      }
      AppMethodBeat.o(40882);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.n
 * JD-Core Version:    0.7.0.1
 */