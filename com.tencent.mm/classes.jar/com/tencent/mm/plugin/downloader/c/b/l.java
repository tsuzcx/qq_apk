package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.cd.a
{
  public boolean uge;
  public String ugf;
  public String ugg;
  public String ugh;
  public int ugi;
  public boolean ugj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153072);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.uge);
      if (this.ugf != null) {
        paramVarArgs.f(2, this.ugf);
      }
      if (this.ugg != null) {
        paramVarArgs.f(3, this.ugg);
      }
      if (this.ugh != null) {
        paramVarArgs.f(4, this.ugh);
      }
      paramVarArgs.aY(5, this.ugi);
      paramVarArgs.co(6, this.ugj);
      AppMethodBeat.o(153072);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.gL(1) + 1 + 0;
      paramInt = i;
      if (this.ugf != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ugf);
      }
      i = paramInt;
      if (this.ugg != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ugg);
      }
      paramInt = i;
      if (this.ugh != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ugh);
      }
      i = g.a.a.b.b.a.bM(5, this.ugi);
      int j = g.a.a.b.b.a.gL(6);
      AppMethodBeat.o(153072);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(153072);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153072);
        return -1;
      case 1: 
        locall.uge = locala.abFh.AB();
        AppMethodBeat.o(153072);
        return 0;
      case 2: 
        locall.ugf = locala.abFh.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 3: 
        locall.ugg = locala.abFh.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 4: 
        locall.ugh = locala.abFh.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 5: 
        locall.ugi = locala.abFh.AK();
        AppMethodBeat.o(153072);
        return 0;
      }
      locall.ugj = locala.abFh.AB();
      AppMethodBeat.o(153072);
      return 0;
    }
    AppMethodBeat.o(153072);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.l
 * JD-Core Version:    0.7.0.1
 */