package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bw.a
{
  public String gqB;
  public int qHm;
  public String qHn;
  public String qHo;
  public String qHp;
  public String qHq;
  public int qHr;
  public String qHs;
  public String qHt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153075);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.qHm);
      if (this.gqB != null) {
        paramVarArgs.e(2, this.gqB);
      }
      if (this.qHn != null) {
        paramVarArgs.e(3, this.qHn);
      }
      if (this.qHo != null) {
        paramVarArgs.e(4, this.qHo);
      }
      if (this.qHp != null) {
        paramVarArgs.e(5, this.qHp);
      }
      if (this.qHq != null) {
        paramVarArgs.e(6, this.qHq);
      }
      paramVarArgs.aM(7, this.qHr);
      if (this.qHs != null) {
        paramVarArgs.e(8, this.qHs);
      }
      if (this.qHt != null) {
        paramVarArgs.e(9, this.qHt);
      }
      AppMethodBeat.o(153075);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.qHm) + 0;
      paramInt = i;
      if (this.gqB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.gqB);
      }
      i = paramInt;
      if (this.qHn != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.qHn);
      }
      paramInt = i;
      if (this.qHo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.qHo);
      }
      i = paramInt;
      if (this.qHp != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.qHp);
      }
      paramInt = i;
      if (this.qHq != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.qHq);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.qHr);
      paramInt = i;
      if (this.qHs != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.qHs);
      }
      i = paramInt;
      if (this.qHt != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.qHt);
      }
      AppMethodBeat.o(153075);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
        localo.qHm = locala.UbS.zi();
        AppMethodBeat.o(153075);
        return 0;
      case 2: 
        localo.gqB = locala.UbS.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 3: 
        localo.qHn = locala.UbS.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 4: 
        localo.qHo = locala.UbS.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 5: 
        localo.qHp = locala.UbS.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 6: 
        localo.qHq = locala.UbS.readString();
        AppMethodBeat.o(153075);
        return 0;
      case 7: 
        localo.qHr = locala.UbS.zi();
        AppMethodBeat.o(153075);
        return 0;
      case 8: 
        localo.qHs = locala.UbS.readString();
        AppMethodBeat.o(153075);
        return 0;
      }
      localo.qHt = locala.UbS.readString();
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