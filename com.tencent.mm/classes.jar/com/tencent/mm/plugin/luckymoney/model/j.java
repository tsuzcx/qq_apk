package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
  extends com.tencent.mm.bw.a
{
  public int phn;
  public String vAa;
  public int vAb;
  public String vAc;
  public String vAd;
  public String vAe;
  public String vAf;
  public int vvh;
  public double vvi;
  public double vvj;
  public double vvk;
  public double vvl;
  public String vvm;
  public String vvn;
  public String vzZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91252);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.vvh);
      paramVarArgs.e(2, this.vvk);
      if (this.vzZ != null) {
        paramVarArgs.d(3, this.vzZ);
      }
      if (this.vAa != null) {
        paramVarArgs.d(4, this.vAa);
      }
      paramVarArgs.e(5, this.vvi);
      paramVarArgs.e(6, this.vvl);
      paramVarArgs.e(7, this.vvj);
      paramVarArgs.aS(8, this.vAb);
      paramVarArgs.aS(9, this.phn);
      if (this.vvm != null) {
        paramVarArgs.d(10, this.vvm);
      }
      if (this.vvn != null) {
        paramVarArgs.d(11, this.vvn);
      }
      if (this.vAc != null) {
        paramVarArgs.d(12, this.vAc);
      }
      if (this.vAd != null) {
        paramVarArgs.d(13, this.vAd);
      }
      if (this.vAe != null) {
        paramVarArgs.d(14, this.vAe);
      }
      if (this.vAf != null) {
        paramVarArgs.d(15, this.vAf);
      }
      AppMethodBeat.o(91252);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.vvh) + 0 + f.a.a.b.b.a.amD(2);
      paramInt = i;
      if (this.vzZ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vzZ);
      }
      i = paramInt;
      if (this.vAa != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vAa);
      }
      i = i + f.a.a.b.b.a.amD(5) + f.a.a.b.b.a.amD(6) + f.a.a.b.b.a.amD(7) + f.a.a.b.b.a.bz(8, this.vAb) + f.a.a.b.b.a.bz(9, this.phn);
      paramInt = i;
      if (this.vvm != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.vvm);
      }
      i = paramInt;
      if (this.vvn != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.vvn);
      }
      paramInt = i;
      if (this.vAc != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.vAc);
      }
      i = paramInt;
      if (this.vAd != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.vAd);
      }
      paramInt = i;
      if (this.vAe != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.vAe);
      }
      i = paramInt;
      if (this.vAf != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.vAf);
      }
      AppMethodBeat.o(91252);
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
        localj.vvh = locala.OmT.zc();
        AppMethodBeat.o(91252);
        return 0;
      case 2: 
        localj.vvk = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(91252);
        return 0;
      case 3: 
        localj.vzZ = locala.OmT.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 4: 
        localj.vAa = locala.OmT.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 5: 
        localj.vvi = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(91252);
        return 0;
      case 6: 
        localj.vvl = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(91252);
        return 0;
      case 7: 
        localj.vvj = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(91252);
        return 0;
      case 8: 
        localj.vAb = locala.OmT.zc();
        AppMethodBeat.o(91252);
        return 0;
      case 9: 
        localj.phn = locala.OmT.zc();
        AppMethodBeat.o(91252);
        return 0;
      case 10: 
        localj.vvm = locala.OmT.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 11: 
        localj.vvn = locala.OmT.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 12: 
        localj.vAc = locala.OmT.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 13: 
        localj.vAd = locala.OmT.readString();
        AppMethodBeat.o(91252);
        return 0;
      case 14: 
        localj.vAe = locala.OmT.readString();
        AppMethodBeat.o(91252);
        return 0;
      }
      localj.vAf = locala.OmT.readString();
      AppMethodBeat.o(91252);
      return 0;
    }
    AppMethodBeat.o(91252);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.j
 * JD-Core Version:    0.7.0.1
 */