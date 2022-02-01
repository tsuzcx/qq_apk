package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.cd.a
{
  public String ueW;
  public String ueX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153048);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ueW != null) {
        paramVarArgs.f(1, this.ueW);
      }
      if (this.ueX != null) {
        paramVarArgs.f(2, this.ueX);
      }
      AppMethodBeat.o(153048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ueW == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.ueW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ueX != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.ueX);
      }
      AppMethodBeat.o(153048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153048);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153048);
          return -1;
        case 1: 
          localg.ueW = locala.abFh.readString();
          AppMethodBeat.o(153048);
          return 0;
        }
        localg.ueX = locala.abFh.readString();
        AppMethodBeat.o(153048);
        return 0;
      }
      AppMethodBeat.o(153048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.g
 * JD-Core Version:    0.7.0.1
 */