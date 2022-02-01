package com.tencent.mm.plugin.address.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends com.tencent.mm.bw.a
{
  public int id;
  public String ktg;
  public String kth;
  public String kti;
  public String ktj;
  public String ktk;
  public String ktl;
  public String ktm;
  public String ktn;
  public String kto;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(20827);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.id);
      if (this.ktg != null) {
        paramVarArgs.e(2, this.ktg);
      }
      if (this.kth != null) {
        paramVarArgs.e(3, this.kth);
      }
      if (this.kti != null) {
        paramVarArgs.e(4, this.kti);
      }
      if (this.ktj != null) {
        paramVarArgs.e(5, this.ktj);
      }
      if (this.ktk != null) {
        paramVarArgs.e(6, this.ktk);
      }
      if (this.ktl != null) {
        paramVarArgs.e(7, this.ktl);
      }
      if (this.ktm != null) {
        paramVarArgs.e(8, this.ktm);
      }
      if (this.ktn != null) {
        paramVarArgs.e(9, this.ktn);
      }
      if (this.kto != null) {
        paramVarArgs.e(10, this.kto);
      }
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.id) + 0;
      paramInt = i;
      if (this.ktg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.ktg);
      }
      i = paramInt;
      if (this.kth != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.kth);
      }
      paramInt = i;
      if (this.kti != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.kti);
      }
      i = paramInt;
      if (this.ktj != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.ktj);
      }
      paramInt = i;
      if (this.ktk != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.ktk);
      }
      i = paramInt;
      if (this.ktl != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.ktl);
      }
      paramInt = i;
      if (this.ktm != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.ktm);
      }
      i = paramInt;
      if (this.ktn != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.ktn);
      }
      paramInt = i;
      if (this.kto != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.kto);
      }
      AppMethodBeat.o(20827);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(20827);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(20827);
        return -1;
      case 1: 
        localb.id = locala.UbS.zi();
        AppMethodBeat.o(20827);
        return 0;
      case 2: 
        localb.ktg = locala.UbS.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 3: 
        localb.kth = locala.UbS.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 4: 
        localb.kti = locala.UbS.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 5: 
        localb.ktj = locala.UbS.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 6: 
        localb.ktk = locala.UbS.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 7: 
        localb.ktl = locala.UbS.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 8: 
        localb.ktm = locala.UbS.readString();
        AppMethodBeat.o(20827);
        return 0;
      case 9: 
        localb.ktn = locala.UbS.readString();
        AppMethodBeat.o(20827);
        return 0;
      }
      localb.kto = locala.UbS.readString();
      AppMethodBeat.o(20827);
      return 0;
    }
    AppMethodBeat.o(20827);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.d.b
 * JD-Core Version:    0.7.0.1
 */