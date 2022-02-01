package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class y
  extends com.tencent.mm.bx.a
{
  public String CAf;
  public String KrO;
  public long KrR;
  public long KrT;
  public String KrU;
  public int Ksf;
  public String Ktg;
  public long Kth;
  public String Kti;
  public String Ktj;
  public String Ktk;
  public long Ktl;
  public int Ktm;
  public String Ktn;
  public String Kto;
  public int ihy;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91257);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Ktg != null) {
        paramVarArgs.g(1, this.Ktg);
      }
      if (this.KrO != null) {
        paramVarArgs.g(2, this.KrO);
      }
      paramVarArgs.bv(3, this.Kth);
      if (this.Kti != null) {
        paramVarArgs.g(4, this.Kti);
      }
      paramVarArgs.bS(5, this.ihy);
      if (this.Ktj != null) {
        paramVarArgs.g(6, this.Ktj);
      }
      if (this.Ktk != null) {
        paramVarArgs.g(7, this.Ktk);
      }
      paramVarArgs.bv(8, this.KrT);
      paramVarArgs.bv(9, this.Ktl);
      paramVarArgs.bv(10, this.KrR);
      paramVarArgs.bS(11, this.status);
      paramVarArgs.bS(12, this.Ktm);
      if (this.KrU != null) {
        paramVarArgs.g(13, this.KrU);
      }
      if (this.CAf != null) {
        paramVarArgs.g(14, this.CAf);
      }
      paramVarArgs.bS(15, this.Ksf);
      if (this.Ktn != null) {
        paramVarArgs.g(16, this.Ktn);
      }
      if (this.Kto != null) {
        paramVarArgs.g(17, this.Kto);
      }
      AppMethodBeat.o(91257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ktg == null) {
        break label1058;
      }
    }
    label1058:
    for (paramInt = i.a.a.b.b.a.h(1, this.Ktg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KrO != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.KrO);
      }
      i += i.a.a.b.b.a.q(3, this.Kth);
      paramInt = i;
      if (this.Kti != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Kti);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.ihy);
      paramInt = i;
      if (this.Ktj != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Ktj);
      }
      i = paramInt;
      if (this.Ktk != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Ktk);
      }
      i = i + i.a.a.b.b.a.q(8, this.KrT) + i.a.a.b.b.a.q(9, this.Ktl) + i.a.a.b.b.a.q(10, this.KrR) + i.a.a.b.b.a.cJ(11, this.status) + i.a.a.b.b.a.cJ(12, this.Ktm);
      paramInt = i;
      if (this.KrU != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.KrU);
      }
      i = paramInt;
      if (this.CAf != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.CAf);
      }
      i += i.a.a.b.b.a.cJ(15, this.Ksf);
      paramInt = i;
      if (this.Ktn != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.Ktn);
      }
      i = paramInt;
      if (this.Kto != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.Kto);
      }
      AppMethodBeat.o(91257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91257);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91257);
          return -1;
        case 1: 
          localy.Ktg = locala.ajGk.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 2: 
          localy.KrO = locala.ajGk.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 3: 
          localy.Kth = locala.ajGk.aaw();
          AppMethodBeat.o(91257);
          return 0;
        case 4: 
          localy.Kti = locala.ajGk.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 5: 
          localy.ihy = locala.ajGk.aar();
          AppMethodBeat.o(91257);
          return 0;
        case 6: 
          localy.Ktj = locala.ajGk.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 7: 
          localy.Ktk = locala.ajGk.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 8: 
          localy.KrT = locala.ajGk.aaw();
          AppMethodBeat.o(91257);
          return 0;
        case 9: 
          localy.Ktl = locala.ajGk.aaw();
          AppMethodBeat.o(91257);
          return 0;
        case 10: 
          localy.KrR = locala.ajGk.aaw();
          AppMethodBeat.o(91257);
          return 0;
        case 11: 
          localy.status = locala.ajGk.aar();
          AppMethodBeat.o(91257);
          return 0;
        case 12: 
          localy.Ktm = locala.ajGk.aar();
          AppMethodBeat.o(91257);
          return 0;
        case 13: 
          localy.KrU = locala.ajGk.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 14: 
          localy.CAf = locala.ajGk.readString();
          AppMethodBeat.o(91257);
          return 0;
        case 15: 
          localy.Ksf = locala.ajGk.aar();
          AppMethodBeat.o(91257);
          return 0;
        case 16: 
          localy.Ktn = locala.ajGk.readString();
          AppMethodBeat.o(91257);
          return 0;
        }
        localy.Kto = locala.ajGk.readString();
        AppMethodBeat.o(91257);
        return 0;
      }
      AppMethodBeat.o(91257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.y
 * JD-Core Version:    0.7.0.1
 */