package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class q
  extends com.tencent.mm.bw.a
{
  public int egY;
  public int egZ;
  public int eha;
  public long eht;
  public int qwe;
  public int resourceId;
  public String yPK;
  public String yQE;
  public int yRN;
  public String yRO;
  public String yRP;
  public String yRQ;
  public String yVA;
  public String yVB;
  public String yVC;
  public String yVD;
  public j yVE;
  public String yVF;
  public String yVb;
  public String yVc;
  public String yVd;
  public String yVe;
  public String yVf;
  public String yVg;
  public long yVh;
  public long yVi;
  public long yVj;
  public String yVk;
  public int yVl;
  public int yVm;
  public int yVn;
  public String yVo;
  public int yVp;
  public i yVq;
  public LinkedList<bg> yVr;
  public bg yVs;
  public String yVt;
  public String yVu;
  public int yVv;
  public LinkedList<ad> yVw;
  public String yVx;
  public String yVy;
  public int yVz;
  
  public q()
  {
    AppMethodBeat.i(91253);
    this.yVr = new LinkedList();
    this.yVw = new LinkedList();
    AppMethodBeat.o(91253);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91254);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.egY);
      paramVarArgs.aM(2, this.egZ);
      if (this.yVb != null) {
        paramVarArgs.e(3, this.yVb);
      }
      if (this.yVc != null) {
        paramVarArgs.e(4, this.yVc);
      }
      if (this.yPK != null) {
        paramVarArgs.e(5, this.yPK);
      }
      if (this.yVd != null) {
        paramVarArgs.e(6, this.yVd);
      }
      if (this.yVe != null) {
        paramVarArgs.e(7, this.yVe);
      }
      if (this.yQE != null) {
        paramVarArgs.e(8, this.yQE);
      }
      if (this.yVf != null) {
        paramVarArgs.e(9, this.yVf);
      }
      if (this.yVg != null) {
        paramVarArgs.e(10, this.yVg);
      }
      paramVarArgs.bb(11, this.eht);
      paramVarArgs.bb(12, this.yVh);
      paramVarArgs.bb(13, this.yVi);
      paramVarArgs.aM(14, this.qwe);
      paramVarArgs.bb(15, this.yVj);
      if (this.yVk != null) {
        paramVarArgs.e(16, this.yVk);
      }
      paramVarArgs.aM(17, this.yVl);
      paramVarArgs.aM(18, this.yVm);
      paramVarArgs.aM(19, this.yVn);
      if (this.yVo != null) {
        paramVarArgs.e(20, this.yVo);
      }
      paramVarArgs.aM(21, this.eha);
      paramVarArgs.aM(22, this.yVp);
      if (this.yVq != null)
      {
        paramVarArgs.ni(23, this.yVq.computeSize());
        this.yVq.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(24, this.yRN);
      if (this.yRP != null) {
        paramVarArgs.e(25, this.yRP);
      }
      paramVarArgs.e(26, 8, this.yVr);
      if (this.yVs != null)
      {
        paramVarArgs.ni(27, this.yVs.computeSize());
        this.yVs.writeFields(paramVarArgs);
      }
      if (this.yVt != null) {
        paramVarArgs.e(28, this.yVt);
      }
      if (this.yVu != null) {
        paramVarArgs.e(29, this.yVu);
      }
      paramVarArgs.aM(30, this.yVv);
      paramVarArgs.aM(31, this.resourceId);
      if (this.yRQ != null) {
        paramVarArgs.e(32, this.yRQ);
      }
      paramVarArgs.e(33, 8, this.yVw);
      if (this.yRO != null) {
        paramVarArgs.e(34, this.yRO);
      }
      if (this.yVx != null) {
        paramVarArgs.e(35, this.yVx);
      }
      if (this.yVy != null) {
        paramVarArgs.e(36, this.yVy);
      }
      paramVarArgs.aM(37, this.yVz);
      if (this.yVA != null) {
        paramVarArgs.e(38, this.yVA);
      }
      if (this.yVB != null) {
        paramVarArgs.e(39, this.yVB);
      }
      if (this.yVC != null) {
        paramVarArgs.e(40, this.yVC);
      }
      if (this.yVD != null) {
        paramVarArgs.e(41, this.yVD);
      }
      if (this.yVE != null)
      {
        paramVarArgs.ni(42, this.yVE.computeSize());
        this.yVE.writeFields(paramVarArgs);
      }
      if (this.yVF != null) {
        paramVarArgs.e(43, this.yVF);
      }
      AppMethodBeat.o(91254);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.egY) + 0 + g.a.a.b.b.a.bu(2, this.egZ);
      paramInt = i;
      if (this.yVb != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.yVb);
      }
      i = paramInt;
      if (this.yVc != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.yVc);
      }
      paramInt = i;
      if (this.yPK != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.yPK);
      }
      i = paramInt;
      if (this.yVd != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.yVd);
      }
      paramInt = i;
      if (this.yVe != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.yVe);
      }
      i = paramInt;
      if (this.yQE != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.yQE);
      }
      paramInt = i;
      if (this.yVf != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.yVf);
      }
      i = paramInt;
      if (this.yVg != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.yVg);
      }
      i = i + g.a.a.b.b.a.r(11, this.eht) + g.a.a.b.b.a.r(12, this.yVh) + g.a.a.b.b.a.r(13, this.yVi) + g.a.a.b.b.a.bu(14, this.qwe) + g.a.a.b.b.a.r(15, this.yVj);
      paramInt = i;
      if (this.yVk != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.yVk);
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.yVl) + g.a.a.b.b.a.bu(18, this.yVm) + g.a.a.b.b.a.bu(19, this.yVn);
      paramInt = i;
      if (this.yVo != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.yVo);
      }
      i = paramInt + g.a.a.b.b.a.bu(21, this.eha) + g.a.a.b.b.a.bu(22, this.yVp);
      paramInt = i;
      if (this.yVq != null) {
        paramInt = i + g.a.a.a.nh(23, this.yVq.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(24, this.yRN);
      paramInt = i;
      if (this.yRP != null) {
        paramInt = i + g.a.a.b.b.a.f(25, this.yRP);
      }
      i = paramInt + g.a.a.a.c(26, 8, this.yVr);
      paramInt = i;
      if (this.yVs != null) {
        paramInt = i + g.a.a.a.nh(27, this.yVs.computeSize());
      }
      i = paramInt;
      if (this.yVt != null) {
        i = paramInt + g.a.a.b.b.a.f(28, this.yVt);
      }
      paramInt = i;
      if (this.yVu != null) {
        paramInt = i + g.a.a.b.b.a.f(29, this.yVu);
      }
      i = paramInt + g.a.a.b.b.a.bu(30, this.yVv) + g.a.a.b.b.a.bu(31, this.resourceId);
      paramInt = i;
      if (this.yRQ != null) {
        paramInt = i + g.a.a.b.b.a.f(32, this.yRQ);
      }
      i = paramInt + g.a.a.a.c(33, 8, this.yVw);
      paramInt = i;
      if (this.yRO != null) {
        paramInt = i + g.a.a.b.b.a.f(34, this.yRO);
      }
      i = paramInt;
      if (this.yVx != null) {
        i = paramInt + g.a.a.b.b.a.f(35, this.yVx);
      }
      paramInt = i;
      if (this.yVy != null) {
        paramInt = i + g.a.a.b.b.a.f(36, this.yVy);
      }
      i = paramInt + g.a.a.b.b.a.bu(37, this.yVz);
      paramInt = i;
      if (this.yVA != null) {
        paramInt = i + g.a.a.b.b.a.f(38, this.yVA);
      }
      i = paramInt;
      if (this.yVB != null) {
        i = paramInt + g.a.a.b.b.a.f(39, this.yVB);
      }
      paramInt = i;
      if (this.yVC != null) {
        paramInt = i + g.a.a.b.b.a.f(40, this.yVC);
      }
      i = paramInt;
      if (this.yVD != null) {
        i = paramInt + g.a.a.b.b.a.f(41, this.yVD);
      }
      paramInt = i;
      if (this.yVE != null) {
        paramInt = i + g.a.a.a.nh(42, this.yVE.computeSize());
      }
      i = paramInt;
      if (this.yVF != null) {
        i = paramInt + g.a.a.b.b.a.f(43, this.yVF);
      }
      AppMethodBeat.o(91254);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.yVr.clear();
      this.yVw.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91254);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      q localq = (q)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91254);
        return -1;
      case 1: 
        localq.egY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 2: 
        localq.egZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 3: 
        localq.yVb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 4: 
        localq.yVc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 5: 
        localq.yPK = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 6: 
        localq.yVd = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 7: 
        localq.yVe = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 8: 
        localq.yQE = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 9: 
        localq.yVf = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 10: 
        localq.yVg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 11: 
        localq.eht = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91254);
        return 0;
      case 12: 
        localq.yVh = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91254);
        return 0;
      case 13: 
        localq.yVi = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91254);
        return 0;
      case 14: 
        localq.qwe = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 15: 
        localq.yVj = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91254);
        return 0;
      case 16: 
        localq.yVk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 17: 
        localq.yVl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 18: 
        localq.yVm = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 19: 
        localq.yVn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 20: 
        localq.yVo = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 21: 
        localq.eha = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 22: 
        localq.yVp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 23: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localq.yVq = ((i)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 24: 
        localq.yRN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 25: 
        localq.yRP = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 26: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localq.yVr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 27: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localq.yVs = ((bg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 28: 
        localq.yVt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 29: 
        localq.yVu = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 30: 
        localq.yVv = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 31: 
        localq.resourceId = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 32: 
        localq.yRQ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 33: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ad();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ad)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localq.yVw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 34: 
        localq.yRO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 35: 
        localq.yVx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 36: 
        localq.yVy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 37: 
        localq.yVz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91254);
        return 0;
      case 38: 
        localq.yVA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 39: 
        localq.yVB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 40: 
        localq.yVC = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 41: 
        localq.yVD = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 42: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new j();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localq.yVE = ((j)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      }
      localq.yVF = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(91254);
      return 0;
    }
    AppMethodBeat.o(91254);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.q
 * JD-Core Version:    0.7.0.1
 */