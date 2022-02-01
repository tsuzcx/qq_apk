package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  extends com.tencent.mm.bx.a
{
  public int dNM;
  public int status;
  public String vkl;
  public String vof;
  public long voi;
  public long vok;
  public String vol;
  public int vow;
  public String vpm;
  public long vpn;
  public String vpo;
  public String vpp;
  public String vpq;
  public long vpr;
  public int vps;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vpm != null) {
        paramVarArgs.d(1, this.vpm);
      }
      if (this.vof != null) {
        paramVarArgs.d(2, this.vof);
      }
      paramVarArgs.aY(3, this.vpn);
      if (this.vpo != null) {
        paramVarArgs.d(4, this.vpo);
      }
      paramVarArgs.aS(5, this.dNM);
      if (this.vpp != null) {
        paramVarArgs.d(6, this.vpp);
      }
      if (this.vpq != null) {
        paramVarArgs.d(7, this.vpq);
      }
      paramVarArgs.aY(8, this.vok);
      paramVarArgs.aY(9, this.vpr);
      paramVarArgs.aY(10, this.voi);
      paramVarArgs.aS(11, this.status);
      paramVarArgs.aS(12, this.vps);
      if (this.vol != null) {
        paramVarArgs.d(13, this.vol);
      }
      if (this.vkl != null) {
        paramVarArgs.d(14, this.vkl);
      }
      paramVarArgs.aS(15, this.vow);
      AppMethodBeat.o(91257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vpm == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = f.a.a.b.b.a.e(1, this.vpm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vof != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.vof);
      }
      i += f.a.a.b.b.a.p(3, this.vpn);
      paramInt = i;
      if (this.vpo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vpo);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.dNM);
      paramInt = i;
      if (this.vpp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.vpp);
      }
      i = paramInt;
      if (this.vpq != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.vpq);
      }
      i = i + f.a.a.b.b.a.p(8, this.vok) + f.a.a.b.b.a.p(9, this.vpr) + f.a.a.b.b.a.p(10, this.voi) + f.a.a.b.b.a.bz(11, this.status) + f.a.a.b.b.a.bz(12, this.vps);
      paramInt = i;
      if (this.vol != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.vol);
      }
      i = paramInt;
      if (this.vkl != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.vkl);
      }
      paramInt = f.a.a.b.b.a.bz(15, this.vow);
      AppMethodBeat.o(91257);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91257);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91257);
          return -1;
        case 1: 
          localt.vpm = locala.NPN.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 2: 
          localt.vof = locala.NPN.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 3: 
          localt.vpn = locala.NPN.zd();
          AppMethodBeat.o(91257);
          return 0;
        case 4: 
          localt.vpo = locala.NPN.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 5: 
          localt.dNM = locala.NPN.zc();
          AppMethodBeat.o(91257);
          return 0;
        case 6: 
          localt.vpp = locala.NPN.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 7: 
          localt.vpq = locala.NPN.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 8: 
          localt.vok = locala.NPN.zd();
          AppMethodBeat.o(91257);
          return 0;
        case 9: 
          localt.vpr = locala.NPN.zd();
          AppMethodBeat.o(91257);
          return 0;
        case 10: 
          localt.voi = locala.NPN.zd();
          AppMethodBeat.o(91257);
          return 0;
        case 11: 
          localt.status = locala.NPN.zc();
          AppMethodBeat.o(91257);
          return 0;
        case 12: 
          localt.vps = locala.NPN.zc();
          AppMethodBeat.o(91257);
          return 0;
        case 13: 
          localt.vol = locala.NPN.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 14: 
          localt.vkl = locala.NPN.readString();
          AppMethodBeat.o(91257);
          return 0;
        }
        localt.vow = locala.NPN.zc();
        AppMethodBeat.o(91257);
        return 0;
      }
      AppMethodBeat.o(91257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.t
 * JD-Core Version:    0.7.0.1
 */