package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class af
  extends com.tencent.mm.bx.a
{
  public String KrU;
  public String KtC;
  public String KtD;
  public String KtE;
  public String KtF;
  public String KtG;
  public String KtH;
  public boolean KtI;
  public long Kth;
  public String Kti;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91258);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.KtC != null) {
        paramVarArgs.g(1, this.KtC);
      }
      if (this.KtD != null) {
        paramVarArgs.g(2, this.KtD);
      }
      paramVarArgs.bv(3, this.Kth);
      if (this.Kti != null) {
        paramVarArgs.g(4, this.Kti);
      }
      if (this.KtE != null) {
        paramVarArgs.g(5, this.KtE);
      }
      if (this.KrU != null) {
        paramVarArgs.g(6, this.KrU);
      }
      if (this.KtF != null) {
        paramVarArgs.g(7, this.KtF);
      }
      if (this.userName != null) {
        paramVarArgs.g(8, this.userName);
      }
      if (this.KtG != null) {
        paramVarArgs.g(9, this.KtG);
      }
      if (this.KtH != null) {
        paramVarArgs.g(10, this.KtH);
      }
      paramVarArgs.di(11, this.KtI);
      AppMethodBeat.o(91258);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KtC == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = i.a.a.b.b.a.h(1, this.KtC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KtD != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.KtD);
      }
      i += i.a.a.b.b.a.q(3, this.Kth);
      paramInt = i;
      if (this.Kti != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Kti);
      }
      i = paramInt;
      if (this.KtE != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.KtE);
      }
      paramInt = i;
      if (this.KrU != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.KrU);
      }
      i = paramInt;
      if (this.KtF != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.KtF);
      }
      paramInt = i;
      if (this.userName != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.userName);
      }
      i = paramInt;
      if (this.KtG != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.KtG);
      }
      paramInt = i;
      if (this.KtH != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.KtH);
      }
      i = i.a.a.b.b.a.ko(11);
      AppMethodBeat.o(91258);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91258);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        af localaf = (af)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91258);
          return -1;
        case 1: 
          localaf.KtC = locala.ajGk.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 2: 
          localaf.KtD = locala.ajGk.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 3: 
          localaf.Kth = locala.ajGk.aaw();
          AppMethodBeat.o(91258);
          return 0;
        case 4: 
          localaf.Kti = locala.ajGk.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 5: 
          localaf.KtE = locala.ajGk.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 6: 
          localaf.KrU = locala.ajGk.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 7: 
          localaf.KtF = locala.ajGk.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 8: 
          localaf.userName = locala.ajGk.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 9: 
          localaf.KtG = locala.ajGk.readString();
          AppMethodBeat.o(91258);
          return 0;
        case 10: 
          localaf.KtH = locala.ajGk.readString();
          AppMethodBeat.o(91258);
          return 0;
        }
        localaf.KtI = locala.ajGk.aai();
        AppMethodBeat.o(91258);
        return 0;
      }
      AppMethodBeat.o(91258);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.af
 * JD-Core Version:    0.7.0.1
 */