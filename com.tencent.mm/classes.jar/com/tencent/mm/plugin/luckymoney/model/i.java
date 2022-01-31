package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.bv.a
{
  public int kNE;
  public int oir;
  public double ois;
  public double oit;
  public double oiu;
  public double oiv;
  public String oiw;
  public String oix;
  public String onj;
  public String onk;
  public int onl;
  public String onm;
  public String onn;
  public String ono;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56609);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.oir);
      paramVarArgs.f(2, this.oiu);
      if (this.onj != null) {
        paramVarArgs.e(3, this.onj);
      }
      if (this.onk != null) {
        paramVarArgs.e(4, this.onk);
      }
      paramVarArgs.f(5, this.ois);
      paramVarArgs.f(6, this.oiv);
      paramVarArgs.f(7, this.oit);
      paramVarArgs.aO(8, this.onl);
      paramVarArgs.aO(9, this.kNE);
      if (this.oiw != null) {
        paramVarArgs.e(10, this.oiw);
      }
      if (this.oix != null) {
        paramVarArgs.e(11, this.oix);
      }
      if (this.onm != null) {
        paramVarArgs.e(12, this.onm);
      }
      if (this.onn != null) {
        paramVarArgs.e(13, this.onn);
      }
      if (this.ono != null) {
        paramVarArgs.e(14, this.ono);
      }
      AppMethodBeat.o(56609);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.oir) + 0 + (e.a.a.b.b.a.eW(2) + 8);
      paramInt = i;
      if (this.onj != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.onj);
      }
      i = paramInt;
      if (this.onk != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.onk);
      }
      i = i + (e.a.a.b.b.a.eW(5) + 8) + (e.a.a.b.b.a.eW(6) + 8) + (e.a.a.b.b.a.eW(7) + 8) + e.a.a.b.b.a.bl(8, this.onl) + e.a.a.b.b.a.bl(9, this.kNE);
      paramInt = i;
      if (this.oiw != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.oiw);
      }
      i = paramInt;
      if (this.oix != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.oix);
      }
      paramInt = i;
      if (this.onm != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.onm);
      }
      i = paramInt;
      if (this.onn != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.onn);
      }
      paramInt = i;
      if (this.ono != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.ono);
      }
      AppMethodBeat.o(56609);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56609);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56609);
        return -1;
      case 1: 
        locali.oir = locala.CLY.sl();
        AppMethodBeat.o(56609);
        return 0;
      case 2: 
        locali.oiu = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(56609);
        return 0;
      case 3: 
        locali.onj = locala.CLY.readString();
        AppMethodBeat.o(56609);
        return 0;
      case 4: 
        locali.onk = locala.CLY.readString();
        AppMethodBeat.o(56609);
        return 0;
      case 5: 
        locali.ois = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(56609);
        return 0;
      case 6: 
        locali.oiv = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(56609);
        return 0;
      case 7: 
        locali.oit = Double.longBitsToDouble(locala.CLY.emy());
        AppMethodBeat.o(56609);
        return 0;
      case 8: 
        locali.onl = locala.CLY.sl();
        AppMethodBeat.o(56609);
        return 0;
      case 9: 
        locali.kNE = locala.CLY.sl();
        AppMethodBeat.o(56609);
        return 0;
      case 10: 
        locali.oiw = locala.CLY.readString();
        AppMethodBeat.o(56609);
        return 0;
      case 11: 
        locali.oix = locala.CLY.readString();
        AppMethodBeat.o(56609);
        return 0;
      case 12: 
        locali.onm = locala.CLY.readString();
        AppMethodBeat.o(56609);
        return 0;
      case 13: 
        locali.onn = locala.CLY.readString();
        AppMethodBeat.o(56609);
        return 0;
      }
      locali.ono = locala.CLY.readString();
      AppMethodBeat.o(56609);
      return 0;
    }
    AppMethodBeat.o(56609);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.i
 * JD-Core Version:    0.7.0.1
 */