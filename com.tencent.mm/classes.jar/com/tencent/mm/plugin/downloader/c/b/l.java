package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public boolean qHd;
  public String qHe;
  public String qHf;
  public String qHg;
  public int qHh;
  public boolean qHi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153072);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.qHd);
      if (this.qHe != null) {
        paramVarArgs.e(2, this.qHe);
      }
      if (this.qHf != null) {
        paramVarArgs.e(3, this.qHf);
      }
      if (this.qHg != null) {
        paramVarArgs.e(4, this.qHg);
      }
      paramVarArgs.aM(5, this.qHh);
      paramVarArgs.cc(6, this.qHi);
      AppMethodBeat.o(153072);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0;
      paramInt = i;
      if (this.qHe != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.qHe);
      }
      i = paramInt;
      if (this.qHf != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qHf);
      }
      paramInt = i;
      if (this.qHg != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qHg);
      }
      i = g.a.a.b.b.a.bu(5, this.qHh);
      int j = g.a.a.b.b.a.fS(6);
      AppMethodBeat.o(153072);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
        locall.qHd = locala.UbS.yZ();
        AppMethodBeat.o(153072);
        return 0;
      case 2: 
        locall.qHe = locala.UbS.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 3: 
        locall.qHf = locala.UbS.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 4: 
        locall.qHg = locala.UbS.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 5: 
        locall.qHh = locala.UbS.zi();
        AppMethodBeat.o(153072);
        return 0;
      }
      locall.qHi = locala.UbS.yZ();
      AppMethodBeat.o(153072);
      return 0;
    }
    AppMethodBeat.o(153072);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.l
 * JD-Core Version:    0.7.0.1
 */