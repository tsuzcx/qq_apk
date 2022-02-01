package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
  extends com.tencent.mm.bw.a
{
  public int dPc;
  public int status;
  public int vAB;
  public String vAk;
  public long vAn;
  public long vAp;
  public String vAq;
  public String vBr;
  public long vBs;
  public String vBt;
  public String vBu;
  public String vBv;
  public long vBw;
  public int vBx;
  public String vwq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vBr != null) {
        paramVarArgs.d(1, this.vBr);
      }
      if (this.vAk != null) {
        paramVarArgs.d(2, this.vAk);
      }
      paramVarArgs.aZ(3, this.vBs);
      if (this.vBt != null) {
        paramVarArgs.d(4, this.vBt);
      }
      paramVarArgs.aS(5, this.dPc);
      if (this.vBu != null) {
        paramVarArgs.d(6, this.vBu);
      }
      if (this.vBv != null) {
        paramVarArgs.d(7, this.vBv);
      }
      paramVarArgs.aZ(8, this.vAp);
      paramVarArgs.aZ(9, this.vBw);
      paramVarArgs.aZ(10, this.vAn);
      paramVarArgs.aS(11, this.status);
      paramVarArgs.aS(12, this.vBx);
      if (this.vAq != null) {
        paramVarArgs.d(13, this.vAq);
      }
      if (this.vwq != null) {
        paramVarArgs.d(14, this.vwq);
      }
      paramVarArgs.aS(15, this.vAB);
      AppMethodBeat.o(91257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vBr == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = f.a.a.b.b.a.e(1, this.vBr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.vAk != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.vAk);
      }
      i += f.a.a.b.b.a.p(3, this.vBs);
      paramInt = i;
      if (this.vBt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.vBt);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.dPc);
      paramInt = i;
      if (this.vBu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.vBu);
      }
      i = paramInt;
      if (this.vBv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.vBv);
      }
      i = i + f.a.a.b.b.a.p(8, this.vAp) + f.a.a.b.b.a.p(9, this.vBw) + f.a.a.b.b.a.p(10, this.vAn) + f.a.a.b.b.a.bz(11, this.status) + f.a.a.b.b.a.bz(12, this.vBx);
      paramInt = i;
      if (this.vAq != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.vAq);
      }
      i = paramInt;
      if (this.vwq != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.vwq);
      }
      paramInt = f.a.a.b.b.a.bz(15, this.vAB);
      AppMethodBeat.o(91257);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localt.vBr = locala.OmT.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 2: 
          localt.vAk = locala.OmT.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 3: 
          localt.vBs = locala.OmT.zd();
          AppMethodBeat.o(91257);
          return 0;
        case 4: 
          localt.vBt = locala.OmT.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 5: 
          localt.dPc = locala.OmT.zc();
          AppMethodBeat.o(91257);
          return 0;
        case 6: 
          localt.vBu = locala.OmT.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 7: 
          localt.vBv = locala.OmT.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 8: 
          localt.vAp = locala.OmT.zd();
          AppMethodBeat.o(91257);
          return 0;
        case 9: 
          localt.vBw = locala.OmT.zd();
          AppMethodBeat.o(91257);
          return 0;
        case 10: 
          localt.vAn = locala.OmT.zd();
          AppMethodBeat.o(91257);
          return 0;
        case 11: 
          localt.status = locala.OmT.zc();
          AppMethodBeat.o(91257);
          return 0;
        case 12: 
          localt.vBx = locala.OmT.zc();
          AppMethodBeat.o(91257);
          return 0;
        case 13: 
          localt.vAq = locala.OmT.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 14: 
          localt.vwq = locala.OmT.readString();
          AppMethodBeat.o(91257);
          return 0;
        }
        localt.vAB = locala.OmT.zc();
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