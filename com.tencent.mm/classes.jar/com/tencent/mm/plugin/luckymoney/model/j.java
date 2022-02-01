package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends com.tencent.mm.bw.a
{
  public int oxo;
  public int ugs;
  public double ugt;
  public double ugu;
  public double ugv;
  public double ugw;
  public String ugx;
  public String ugy;
  public String ulo;
  public String ulp;
  public int ulq;
  public String ulr;
  public String uls;
  public String ult;
  public String ulu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91252);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ugs);
      paramVarArgs.e(2, this.ugv);
      if (this.ulo != null) {
        paramVarArgs.d(3, this.ulo);
      }
      if (this.ulp != null) {
        paramVarArgs.d(4, this.ulp);
      }
      paramVarArgs.e(5, this.ugt);
      paramVarArgs.e(6, this.ugw);
      paramVarArgs.e(7, this.ugu);
      paramVarArgs.aR(8, this.ulq);
      paramVarArgs.aR(9, this.oxo);
      if (this.ugx != null) {
        paramVarArgs.d(10, this.ugx);
      }
      if (this.ugy != null) {
        paramVarArgs.d(11, this.ugy);
      }
      if (this.ulr != null) {
        paramVarArgs.d(12, this.ulr);
      }
      if (this.uls != null) {
        paramVarArgs.d(13, this.uls);
      }
      if (this.ult != null) {
        paramVarArgs.d(14, this.ult);
      }
      if (this.ulu != null) {
        paramVarArgs.d(15, this.ulu);
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ugs) + 0 + (f.a.a.b.b.a.fK(2) + 8);
      paramInt = i;
      if (this.ulo != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ulo);
      }
      i = paramInt;
      if (this.ulp != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ulp);
      }
      i = i + (f.a.a.b.b.a.fK(5) + 8) + (f.a.a.b.b.a.fK(6) + 8) + (f.a.a.b.b.a.fK(7) + 8) + f.a.a.b.b.a.bx(8, this.ulq) + f.a.a.b.b.a.bx(9, this.oxo);
      paramInt = i;
      if (this.ugx != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ugx);
      }
      i = paramInt;
      if (this.ugy != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.ugy);
      }
      paramInt = i;
      if (this.ulr != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ulr);
      }
      i = paramInt;
      if (this.uls != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.uls);
      }
      paramInt = i;
      if (this.ult != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.ult);
      }
      i = paramInt;
      if (this.ulu != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.ulu);
      }
      AppMethodBeat.o(91252);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localj.ugs = locala.LVo.xF();
        AppMethodBeat.o(91252);
        return 0;
      case 2: 
        localj.ugv = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(91252);
        return 0;
      case 3: 
        localj.ulo = locala.LVo.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 4: 
        localj.ulp = locala.LVo.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 5: 
        localj.ugt = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(91252);
        return 0;
      case 6: 
        localj.ugw = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(91252);
        return 0;
      case 7: 
        localj.ugu = Double.longBitsToDouble(locala.LVo.gab());
        AppMethodBeat.o(91252);
        return 0;
      case 8: 
        localj.ulq = locala.LVo.xF();
        AppMethodBeat.o(91252);
        return 0;
      case 9: 
        localj.oxo = locala.LVo.xF();
        AppMethodBeat.o(91252);
        return 0;
      case 10: 
        localj.ugx = locala.LVo.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 11: 
        localj.ugy = locala.LVo.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 12: 
        localj.ulr = locala.LVo.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 13: 
        localj.uls = locala.LVo.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 14: 
        localj.ult = locala.LVo.readString();
        AppMethodBeat.o(91252);
        return 0;
      }
      localj.ulu = locala.LVo.readString();
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