package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends com.tencent.mm.bx.a
{
  public int paJ;
  public int vjc;
  public double vjd;
  public double vje;
  public double vjf;
  public double vjg;
  public String vjh;
  public String vji;
  public String vnU;
  public String vnV;
  public int vnW;
  public String vnX;
  public String vnY;
  public String vnZ;
  public String voa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91252);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.vjc);
      paramVarArgs.e(2, this.vjf);
      if (this.vnU != null) {
        paramVarArgs.d(3, this.vnU);
      }
      if (this.vnV != null) {
        paramVarArgs.d(4, this.vnV);
      }
      paramVarArgs.e(5, this.vjd);
      paramVarArgs.e(6, this.vjg);
      paramVarArgs.e(7, this.vje);
      paramVarArgs.aS(8, this.vnW);
      paramVarArgs.aS(9, this.paJ);
      if (this.vjh != null) {
        paramVarArgs.d(10, this.vjh);
      }
      if (this.vji != null) {
        paramVarArgs.d(11, this.vji);
      }
      if (this.vnX != null) {
        paramVarArgs.d(12, this.vnX);
      }
      if (this.vnY != null) {
        paramVarArgs.d(13, this.vnY);
      }
      if (this.vnZ != null) {
        paramVarArgs.d(14, this.vnZ);
      }
      if (this.voa != null) {
        paramVarArgs.d(15, this.voa);
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.vjc) + 0 + f.a.a.b.b.a.alT(2);
      paramInt = i;
      if (this.vnU != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vnU);
      }
      i = paramInt;
      if (this.vnV != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vnV);
      }
      i = i + f.a.a.b.b.a.alT(5) + f.a.a.b.b.a.alT(6) + f.a.a.b.b.a.alT(7) + f.a.a.b.b.a.bz(8, this.vnW) + f.a.a.b.b.a.bz(9, this.paJ);
      paramInt = i;
      if (this.vjh != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.vjh);
      }
      i = paramInt;
      if (this.vji != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.vji);
      }
      paramInt = i;
      if (this.vnX != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.vnX);
      }
      i = paramInt;
      if (this.vnY != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.vnY);
      }
      paramInt = i;
      if (this.vnZ != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.vnZ);
      }
      i = paramInt;
      if (this.voa != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.voa);
      }
      AppMethodBeat.o(91252);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        localj.vjc = locala.NPN.zc();
        AppMethodBeat.o(91252);
        return 0;
      case 2: 
        localj.vjf = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(91252);
        return 0;
      case 3: 
        localj.vnU = locala.NPN.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 4: 
        localj.vnV = locala.NPN.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 5: 
        localj.vjd = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(91252);
        return 0;
      case 6: 
        localj.vjg = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(91252);
        return 0;
      case 7: 
        localj.vje = Double.longBitsToDouble(locala.NPN.grA());
        AppMethodBeat.o(91252);
        return 0;
      case 8: 
        localj.vnW = locala.NPN.zc();
        AppMethodBeat.o(91252);
        return 0;
      case 9: 
        localj.paJ = locala.NPN.zc();
        AppMethodBeat.o(91252);
        return 0;
      case 10: 
        localj.vjh = locala.NPN.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 11: 
        localj.vji = locala.NPN.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 12: 
        localj.vnX = locala.NPN.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 13: 
        localj.vnY = locala.NPN.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 14: 
        localj.vnZ = locala.NPN.readString();
        AppMethodBeat.o(91252);
        return 0;
      }
      localj.voa = locala.NPN.readString();
      AppMethodBeat.o(91252);
      return 0;
    }
    AppMethodBeat.o(91252);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.j
 * JD-Core Version:    0.7.0.1
 */