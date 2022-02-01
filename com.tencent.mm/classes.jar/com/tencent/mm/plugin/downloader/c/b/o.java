package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bw.a
{
  public String fLp;
  public int prH;
  public String prI;
  public String prJ;
  public String prK;
  public String prL;
  public int prM;
  public String prN;
  public String prO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153075);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.prH);
      if (this.fLp != null) {
        paramVarArgs.d(2, this.fLp);
      }
      if (this.prI != null) {
        paramVarArgs.d(3, this.prI);
      }
      if (this.prJ != null) {
        paramVarArgs.d(4, this.prJ);
      }
      if (this.prK != null) {
        paramVarArgs.d(5, this.prK);
      }
      if (this.prL != null) {
        paramVarArgs.d(6, this.prL);
      }
      paramVarArgs.aS(7, this.prM);
      if (this.prN != null) {
        paramVarArgs.d(8, this.prN);
      }
      if (this.prO != null) {
        paramVarArgs.d(9, this.prO);
      }
      AppMethodBeat.o(153075);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.prH) + 0;
      paramInt = i;
      if (this.fLp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fLp);
      }
      i = paramInt;
      if (this.prI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.prI);
      }
      paramInt = i;
      if (this.prJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.prJ);
      }
      i = paramInt;
      if (this.prK != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.prK);
      }
      paramInt = i;
      if (this.prL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.prL);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.prM);
      paramInt = i;
      if (this.prN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.prN);
      }
      i = paramInt;
      if (this.prO != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.prO);
      }
      AppMethodBeat.o(153075);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(153075);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153075);
        return -1;
      case 1: 
        localo.prH = locala.OmT.zc();
        AppMethodBeat.o(153075);
        return 0;
      case 2: 
        localo.fLp = locala.OmT.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 3: 
        localo.prI = locala.OmT.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 4: 
        localo.prJ = locala.OmT.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 5: 
        localo.prK = locala.OmT.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 6: 
        localo.prL = locala.OmT.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 7: 
        localo.prM = locala.OmT.zc();
        AppMethodBeat.o(153075);
        return 0;
      case 8: 
        localo.prN = locala.OmT.readString();
        AppMethodBeat.o(153075);
        return 0;
      }
      localo.prO = locala.OmT.readString();
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