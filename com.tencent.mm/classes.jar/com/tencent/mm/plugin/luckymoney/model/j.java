package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends com.tencent.mm.bx.a
{
  public int nTT;
  public int sYe;
  public double sYf;
  public double sYg;
  public double sYh;
  public double sYi;
  public String sYj;
  public String sYk;
  public String tcZ;
  public String tda;
  public int tdb;
  public String tdc;
  public String tdd;
  public String tde;
  public String tdf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91252);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.sYe);
      paramVarArgs.e(2, this.sYh);
      if (this.tcZ != null) {
        paramVarArgs.d(3, this.tcZ);
      }
      if (this.tda != null) {
        paramVarArgs.d(4, this.tda);
      }
      paramVarArgs.e(5, this.sYf);
      paramVarArgs.e(6, this.sYi);
      paramVarArgs.e(7, this.sYg);
      paramVarArgs.aR(8, this.tdb);
      paramVarArgs.aR(9, this.nTT);
      if (this.sYj != null) {
        paramVarArgs.d(10, this.sYj);
      }
      if (this.sYk != null) {
        paramVarArgs.d(11, this.sYk);
      }
      if (this.tdc != null) {
        paramVarArgs.d(12, this.tdc);
      }
      if (this.tdd != null) {
        paramVarArgs.d(13, this.tdd);
      }
      if (this.tde != null) {
        paramVarArgs.d(14, this.tde);
      }
      if (this.tdf != null) {
        paramVarArgs.d(15, this.tdf);
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.sYe) + 0 + (f.a.a.b.b.a.fY(2) + 8);
      paramInt = i;
      if (this.tcZ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.tcZ);
      }
      i = paramInt;
      if (this.tda != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tda);
      }
      i = i + (f.a.a.b.b.a.fY(5) + 8) + (f.a.a.b.b.a.fY(6) + 8) + (f.a.a.b.b.a.fY(7) + 8) + f.a.a.b.b.a.bA(8, this.tdb) + f.a.a.b.b.a.bA(9, this.nTT);
      paramInt = i;
      if (this.sYj != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.sYj);
      }
      i = paramInt;
      if (this.sYk != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.sYk);
      }
      paramInt = i;
      if (this.tdc != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.tdc);
      }
      i = paramInt;
      if (this.tdd != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.tdd);
      }
      paramInt = i;
      if (this.tde != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.tde);
      }
      i = paramInt;
      if (this.tdf != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.tdf);
      }
      AppMethodBeat.o(91252);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      j localj = (j)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91252);
        return -1;
      case 1: 
        localj.sYe = locala.KhF.xS();
        AppMethodBeat.o(91252);
        return 0;
      case 2: 
        localj.sYh = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(91252);
        return 0;
      case 3: 
        localj.tcZ = locala.KhF.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 4: 
        localj.tda = locala.KhF.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 5: 
        localj.sYf = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(91252);
        return 0;
      case 6: 
        localj.sYi = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(91252);
        return 0;
      case 7: 
        localj.sYg = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(91252);
        return 0;
      case 8: 
        localj.tdb = locala.KhF.xS();
        AppMethodBeat.o(91252);
        return 0;
      case 9: 
        localj.nTT = locala.KhF.xS();
        AppMethodBeat.o(91252);
        return 0;
      case 10: 
        localj.sYj = locala.KhF.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 11: 
        localj.sYk = locala.KhF.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 12: 
        localj.tdc = locala.KhF.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 13: 
        localj.tdd = locala.KhF.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 14: 
        localj.tde = locala.KhF.readString();
        AppMethodBeat.o(91252);
        return 0;
      }
      localj.tdf = locala.KhF.readString();
      AppMethodBeat.o(91252);
      return 0;
    }
    AppMethodBeat.o(91252);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.j
 * JD-Core Version:    0.7.0.1
 */