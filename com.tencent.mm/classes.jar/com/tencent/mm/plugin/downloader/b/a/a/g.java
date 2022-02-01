package com.tencent.mm.plugin.downloader.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public String xkX;
  public String xkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153048);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.xkX != null) {
        paramVarArgs.g(1, this.xkX);
      }
      if (this.xkY != null) {
        paramVarArgs.g(2, this.xkY);
      }
      AppMethodBeat.o(153048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xkX == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.xkX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xkY != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.xkY);
      }
      AppMethodBeat.o(153048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153048);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153048);
          return -1;
        case 1: 
          localg.xkX = locala.ajGk.readString();
          AppMethodBeat.o(153048);
          return 0;
        }
        localg.xkY = locala.ajGk.readString();
        AppMethodBeat.o(153048);
        return 0;
      }
      AppMethodBeat.o(153048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a.a.g
 * JD-Core Version:    0.7.0.1
 */