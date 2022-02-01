package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.cd.a
{
  public String iUJ;
  public int ugn;
  public String ugo;
  public String ugp;
  public String ugq;
  public String ugr;
  public int ugs;
  public String ugt;
  public String ugu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153075);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.ugn);
      if (this.iUJ != null) {
        paramVarArgs.f(2, this.iUJ);
      }
      if (this.ugo != null) {
        paramVarArgs.f(3, this.ugo);
      }
      if (this.ugp != null) {
        paramVarArgs.f(4, this.ugp);
      }
      if (this.ugq != null) {
        paramVarArgs.f(5, this.ugq);
      }
      if (this.ugr != null) {
        paramVarArgs.f(6, this.ugr);
      }
      paramVarArgs.aY(7, this.ugs);
      if (this.ugt != null) {
        paramVarArgs.f(8, this.ugt);
      }
      if (this.ugu != null) {
        paramVarArgs.f(9, this.ugu);
      }
      AppMethodBeat.o(153075);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.ugn) + 0;
      paramInt = i;
      if (this.iUJ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.iUJ);
      }
      i = paramInt;
      if (this.ugo != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ugo);
      }
      paramInt = i;
      if (this.ugp != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ugp);
      }
      i = paramInt;
      if (this.ugq != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.ugq);
      }
      paramInt = i;
      if (this.ugr != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ugr);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.ugs);
      paramInt = i;
      if (this.ugt != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ugt);
      }
      i = paramInt;
      if (this.ugu != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.ugu);
      }
      AppMethodBeat.o(153075);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(153075);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153075);
        return -1;
      case 1: 
        localo.ugn = locala.abFh.AK();
        AppMethodBeat.o(153075);
        return 0;
      case 2: 
        localo.iUJ = locala.abFh.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 3: 
        localo.ugo = locala.abFh.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 4: 
        localo.ugp = locala.abFh.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 5: 
        localo.ugq = locala.abFh.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 6: 
        localo.ugr = locala.abFh.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 7: 
        localo.ugs = locala.abFh.AK();
        AppMethodBeat.o(153075);
        return 0;
      case 8: 
        localo.ugt = locala.abFh.readString();
        AppMethodBeat.o(153075);
        return 0;
      }
      localo.ugu = locala.abFh.readString();
      AppMethodBeat.o(153075);
      return 0;
    }
    AppMethodBeat.o(153075);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.o
 * JD-Core Version:    0.7.0.1
 */