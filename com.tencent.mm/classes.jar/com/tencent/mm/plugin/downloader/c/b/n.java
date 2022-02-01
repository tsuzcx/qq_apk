package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.cd.a
{
  public String ugl;
  public String ugm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153074);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ugl != null) {
        paramVarArgs.f(1, this.ugl);
      }
      if (this.ugm != null) {
        paramVarArgs.f(2, this.ugm);
      }
      AppMethodBeat.o(153074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ugl == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.ugl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ugm != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.ugm);
      }
      AppMethodBeat.o(153074);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153074);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153074);
          return -1;
        case 1: 
          localn.ugl = locala.abFh.readString();
          AppMethodBeat.o(153074);
          return 0;
        }
        localn.ugm = locala.abFh.readString();
        AppMethodBeat.o(153074);
        return 0;
      }
      AppMethodBeat.o(153074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.n
 * JD-Core Version:    0.7.0.1
 */