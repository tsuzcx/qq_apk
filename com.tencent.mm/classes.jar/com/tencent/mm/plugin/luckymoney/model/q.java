package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class q
  extends com.tencent.mm.bx.a
{
  public String CAf;
  public String Kmq;
  public int Kos;
  public String Kot;
  public String Kou;
  public String Kov;
  public String KrL;
  public String KrM;
  public String KrN;
  public String KrO;
  public String KrP;
  public String KrQ;
  public long KrR;
  public long KrS;
  public long KrT;
  public String KrU;
  public int KrV;
  public int KrW;
  public int KrX;
  public String KrY;
  public int KrZ;
  public j Ksa;
  public LinkedList<bi> Ksb;
  public bi Ksc;
  public String Ksd;
  public String Kse;
  public int Ksf;
  public LinkedList<af> Ksg;
  public String Ksh;
  public String Ksi;
  public int Ksj;
  public String Ksk;
  public String Ksl;
  public String Ksm;
  public String Ksn;
  public k Kso;
  public String Ksp;
  public boolean Ksq;
  public int Ksr;
  public int ihA;
  public long ihV;
  public int ihy;
  public int ihz;
  public int resourceId;
  public int wYz;
  
  public q()
  {
    AppMethodBeat.i(91253);
    this.Ksb = new LinkedList();
    this.Ksg = new LinkedList();
    AppMethodBeat.o(91253);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91254);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ihy);
      paramVarArgs.bS(2, this.ihz);
      if (this.KrL != null) {
        paramVarArgs.g(3, this.KrL);
      }
      if (this.KrM != null) {
        paramVarArgs.g(4, this.KrM);
      }
      if (this.Kmq != null) {
        paramVarArgs.g(5, this.Kmq);
      }
      if (this.KrN != null) {
        paramVarArgs.g(6, this.KrN);
      }
      if (this.KrO != null) {
        paramVarArgs.g(7, this.KrO);
      }
      if (this.CAf != null) {
        paramVarArgs.g(8, this.CAf);
      }
      if (this.KrP != null) {
        paramVarArgs.g(9, this.KrP);
      }
      if (this.KrQ != null) {
        paramVarArgs.g(10, this.KrQ);
      }
      paramVarArgs.bv(11, this.ihV);
      paramVarArgs.bv(12, this.KrR);
      paramVarArgs.bv(13, this.KrS);
      paramVarArgs.bS(14, this.wYz);
      paramVarArgs.bv(15, this.KrT);
      if (this.KrU != null) {
        paramVarArgs.g(16, this.KrU);
      }
      paramVarArgs.bS(17, this.KrV);
      paramVarArgs.bS(18, this.KrW);
      paramVarArgs.bS(19, this.KrX);
      if (this.KrY != null) {
        paramVarArgs.g(20, this.KrY);
      }
      paramVarArgs.bS(21, this.ihA);
      paramVarArgs.bS(22, this.KrZ);
      if (this.Ksa != null)
      {
        paramVarArgs.qD(23, this.Ksa.computeSize());
        this.Ksa.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(24, this.Kos);
      if (this.Kou != null) {
        paramVarArgs.g(25, this.Kou);
      }
      paramVarArgs.e(26, 8, this.Ksb);
      if (this.Ksc != null)
      {
        paramVarArgs.qD(27, this.Ksc.computeSize());
        this.Ksc.writeFields(paramVarArgs);
      }
      if (this.Ksd != null) {
        paramVarArgs.g(28, this.Ksd);
      }
      if (this.Kse != null) {
        paramVarArgs.g(29, this.Kse);
      }
      paramVarArgs.bS(30, this.Ksf);
      paramVarArgs.bS(31, this.resourceId);
      if (this.Kov != null) {
        paramVarArgs.g(32, this.Kov);
      }
      paramVarArgs.e(33, 8, this.Ksg);
      if (this.Kot != null) {
        paramVarArgs.g(34, this.Kot);
      }
      if (this.Ksh != null) {
        paramVarArgs.g(35, this.Ksh);
      }
      if (this.Ksi != null) {
        paramVarArgs.g(36, this.Ksi);
      }
      paramVarArgs.bS(37, this.Ksj);
      if (this.Ksk != null) {
        paramVarArgs.g(38, this.Ksk);
      }
      if (this.Ksl != null) {
        paramVarArgs.g(39, this.Ksl);
      }
      if (this.Ksm != null) {
        paramVarArgs.g(40, this.Ksm);
      }
      if (this.Ksn != null) {
        paramVarArgs.g(41, this.Ksn);
      }
      if (this.Kso != null)
      {
        paramVarArgs.qD(42, this.Kso.computeSize());
        this.Kso.writeFields(paramVarArgs);
      }
      if (this.Ksp != null) {
        paramVarArgs.g(43, this.Ksp);
      }
      paramVarArgs.di(44, this.Ksq);
      paramVarArgs.bS(45, this.Ksr);
      AppMethodBeat.o(91254);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ihy) + 0 + i.a.a.b.b.a.cJ(2, this.ihz);
      paramInt = i;
      if (this.KrL != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.KrL);
      }
      i = paramInt;
      if (this.KrM != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.KrM);
      }
      paramInt = i;
      if (this.Kmq != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Kmq);
      }
      i = paramInt;
      if (this.KrN != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.KrN);
      }
      paramInt = i;
      if (this.KrO != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.KrO);
      }
      i = paramInt;
      if (this.CAf != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.CAf);
      }
      paramInt = i;
      if (this.KrP != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.KrP);
      }
      i = paramInt;
      if (this.KrQ != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.KrQ);
      }
      i = i + i.a.a.b.b.a.q(11, this.ihV) + i.a.a.b.b.a.q(12, this.KrR) + i.a.a.b.b.a.q(13, this.KrS) + i.a.a.b.b.a.cJ(14, this.wYz) + i.a.a.b.b.a.q(15, this.KrT);
      paramInt = i;
      if (this.KrU != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.KrU);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.KrV) + i.a.a.b.b.a.cJ(18, this.KrW) + i.a.a.b.b.a.cJ(19, this.KrX);
      paramInt = i;
      if (this.KrY != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.KrY);
      }
      i = paramInt + i.a.a.b.b.a.cJ(21, this.ihA) + i.a.a.b.b.a.cJ(22, this.KrZ);
      paramInt = i;
      if (this.Ksa != null) {
        paramInt = i + i.a.a.a.qC(23, this.Ksa.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(24, this.Kos);
      paramInt = i;
      if (this.Kou != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.Kou);
      }
      i = paramInt + i.a.a.a.c(26, 8, this.Ksb);
      paramInt = i;
      if (this.Ksc != null) {
        paramInt = i + i.a.a.a.qC(27, this.Ksc.computeSize());
      }
      i = paramInt;
      if (this.Ksd != null) {
        i = paramInt + i.a.a.b.b.a.h(28, this.Ksd);
      }
      paramInt = i;
      if (this.Kse != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.Kse);
      }
      i = paramInt + i.a.a.b.b.a.cJ(30, this.Ksf) + i.a.a.b.b.a.cJ(31, this.resourceId);
      paramInt = i;
      if (this.Kov != null) {
        paramInt = i + i.a.a.b.b.a.h(32, this.Kov);
      }
      i = paramInt + i.a.a.a.c(33, 8, this.Ksg);
      paramInt = i;
      if (this.Kot != null) {
        paramInt = i + i.a.a.b.b.a.h(34, this.Kot);
      }
      i = paramInt;
      if (this.Ksh != null) {
        i = paramInt + i.a.a.b.b.a.h(35, this.Ksh);
      }
      paramInt = i;
      if (this.Ksi != null) {
        paramInt = i + i.a.a.b.b.a.h(36, this.Ksi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(37, this.Ksj);
      paramInt = i;
      if (this.Ksk != null) {
        paramInt = i + i.a.a.b.b.a.h(38, this.Ksk);
      }
      i = paramInt;
      if (this.Ksl != null) {
        i = paramInt + i.a.a.b.b.a.h(39, this.Ksl);
      }
      paramInt = i;
      if (this.Ksm != null) {
        paramInt = i + i.a.a.b.b.a.h(40, this.Ksm);
      }
      i = paramInt;
      if (this.Ksn != null) {
        i = paramInt + i.a.a.b.b.a.h(41, this.Ksn);
      }
      paramInt = i;
      if (this.Kso != null) {
        paramInt = i + i.a.a.a.qC(42, this.Kso.computeSize());
      }
      i = paramInt;
      if (this.Ksp != null) {
        i = paramInt + i.a.a.b.b.a.h(43, this.Ksp);
      }
      paramInt = i.a.a.b.b.a.ko(44);
      int j = i.a.a.b.b.a.cJ(45, this.Ksr);
      AppMethodBeat.o(91254);
      return i + (paramInt + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ksb.clear();
      this.Ksg.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91254);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      q localq = (q)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91254);
        return -1;
      case 1: 
        localq.ihy = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 2: 
        localq.ihz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 3: 
        localq.KrL = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 4: 
        localq.KrM = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 5: 
        localq.Kmq = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 6: 
        localq.KrN = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 7: 
        localq.KrO = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 8: 
        localq.CAf = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 9: 
        localq.KrP = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 10: 
        localq.KrQ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 11: 
        localq.ihV = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(91254);
        return 0;
      case 12: 
        localq.KrR = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(91254);
        return 0;
      case 13: 
        localq.KrS = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(91254);
        return 0;
      case 14: 
        localq.wYz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 15: 
        localq.KrT = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(91254);
        return 0;
      case 16: 
        localq.KrU = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 17: 
        localq.KrV = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 18: 
        localq.KrW = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 19: 
        localq.KrX = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 20: 
        localq.KrY = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 21: 
        localq.ihA = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 22: 
        localq.KrZ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 23: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new j();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((j)localObject2).parseFrom((byte[])localObject1);
          }
          localq.Ksa = ((j)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 24: 
        localq.Kos = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 25: 
        localq.Kou = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 26: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bi)localObject2).parseFrom((byte[])localObject1);
          }
          localq.Ksb.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 27: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bi)localObject2).parseFrom((byte[])localObject1);
          }
          localq.Ksc = ((bi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 28: 
        localq.Ksd = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 29: 
        localq.Kse = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 30: 
        localq.Ksf = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 31: 
        localq.resourceId = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 32: 
        localq.Kov = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 33: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new af();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((af)localObject2).parseFrom((byte[])localObject1);
          }
          localq.Ksg.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 34: 
        localq.Kot = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 35: 
        localq.Ksh = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 36: 
        localq.Ksi = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 37: 
        localq.Ksj = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91254);
        return 0;
      case 38: 
        localq.Ksk = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 39: 
        localq.Ksl = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 40: 
        localq.Ksm = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 41: 
        localq.Ksn = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 42: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new k();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((k)localObject2).parseFrom((byte[])localObject1);
          }
          localq.Kso = ((k)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 43: 
        localq.Ksp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 44: 
        localq.Ksq = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(91254);
        return 0;
      }
      localq.Ksr = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(91254);
      return 0;
    }
    AppMethodBeat.o(91254);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.q
 * JD-Core Version:    0.7.0.1
 */