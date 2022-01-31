package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bv.a
{
  public int cMP;
  public int cMQ;
  public int cMR;
  public long cNd;
  public int kNn;
  public String oiG;
  public String ojA;
  public int okJ;
  public String okK;
  public String okL;
  public String okM;
  public int onA;
  public int onB;
  public int onC;
  public String onD;
  public int onE;
  public e onF;
  public LinkedList<as> onG;
  public as onH;
  public String onI;
  public String onJ;
  public int onK;
  public LinkedList<w> onL;
  public String onM;
  public String onN;
  public int onO;
  public String onP;
  public String onQ;
  public String onq;
  public String onr;
  public String ons;
  public String ont;
  public String onu;
  public String onv;
  public long onw;
  public long onx;
  public long ony;
  public String onz;
  public int resourceId;
  
  public k()
  {
    AppMethodBeat.i(56610);
    this.onG = new LinkedList();
    this.onL = new LinkedList();
    AppMethodBeat.o(56610);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56611);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.cMP);
      paramVarArgs.aO(2, this.cMQ);
      if (this.onq != null) {
        paramVarArgs.e(3, this.onq);
      }
      if (this.onr != null) {
        paramVarArgs.e(4, this.onr);
      }
      if (this.oiG != null) {
        paramVarArgs.e(5, this.oiG);
      }
      if (this.ons != null) {
        paramVarArgs.e(6, this.ons);
      }
      if (this.ont != null) {
        paramVarArgs.e(7, this.ont);
      }
      if (this.ojA != null) {
        paramVarArgs.e(8, this.ojA);
      }
      if (this.onu != null) {
        paramVarArgs.e(9, this.onu);
      }
      if (this.onv != null) {
        paramVarArgs.e(10, this.onv);
      }
      paramVarArgs.am(11, this.cNd);
      paramVarArgs.am(12, this.onw);
      paramVarArgs.am(13, this.onx);
      paramVarArgs.aO(14, this.kNn);
      paramVarArgs.am(15, this.ony);
      if (this.onz != null) {
        paramVarArgs.e(16, this.onz);
      }
      paramVarArgs.aO(17, this.onA);
      paramVarArgs.aO(18, this.onB);
      paramVarArgs.aO(19, this.onC);
      if (this.onD != null) {
        paramVarArgs.e(20, this.onD);
      }
      paramVarArgs.aO(21, this.cMR);
      paramVarArgs.aO(22, this.onE);
      if (this.onF != null)
      {
        paramVarArgs.iQ(23, this.onF.computeSize());
        this.onF.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(24, this.okJ);
      if (this.okL != null) {
        paramVarArgs.e(25, this.okL);
      }
      paramVarArgs.e(26, 8, this.onG);
      if (this.onH != null)
      {
        paramVarArgs.iQ(27, this.onH.computeSize());
        this.onH.writeFields(paramVarArgs);
      }
      if (this.onI != null) {
        paramVarArgs.e(28, this.onI);
      }
      if (this.onJ != null) {
        paramVarArgs.e(29, this.onJ);
      }
      paramVarArgs.aO(30, this.onK);
      paramVarArgs.aO(31, this.resourceId);
      if (this.okM != null) {
        paramVarArgs.e(32, this.okM);
      }
      paramVarArgs.e(33, 8, this.onL);
      if (this.okK != null) {
        paramVarArgs.e(34, this.okK);
      }
      if (this.onM != null) {
        paramVarArgs.e(35, this.onM);
      }
      if (this.onN != null) {
        paramVarArgs.e(36, this.onN);
      }
      paramVarArgs.aO(37, this.onO);
      if (this.onP != null) {
        paramVarArgs.e(38, this.onP);
      }
      if (this.onQ != null) {
        paramVarArgs.e(39, this.onQ);
      }
      AppMethodBeat.o(56611);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.cMP) + 0 + e.a.a.b.b.a.bl(2, this.cMQ);
      paramInt = i;
      if (this.onq != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.onq);
      }
      i = paramInt;
      if (this.onr != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.onr);
      }
      paramInt = i;
      if (this.oiG != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.oiG);
      }
      i = paramInt;
      if (this.ons != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.ons);
      }
      paramInt = i;
      if (this.ont != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.ont);
      }
      i = paramInt;
      if (this.ojA != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.ojA);
      }
      paramInt = i;
      if (this.onu != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.onu);
      }
      i = paramInt;
      if (this.onv != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.onv);
      }
      i = i + e.a.a.b.b.a.p(11, this.cNd) + e.a.a.b.b.a.p(12, this.onw) + e.a.a.b.b.a.p(13, this.onx) + e.a.a.b.b.a.bl(14, this.kNn) + e.a.a.b.b.a.p(15, this.ony);
      paramInt = i;
      if (this.onz != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.onz);
      }
      i = paramInt + e.a.a.b.b.a.bl(17, this.onA) + e.a.a.b.b.a.bl(18, this.onB) + e.a.a.b.b.a.bl(19, this.onC);
      paramInt = i;
      if (this.onD != null) {
        paramInt = i + e.a.a.b.b.a.f(20, this.onD);
      }
      i = paramInt + e.a.a.b.b.a.bl(21, this.cMR) + e.a.a.b.b.a.bl(22, this.onE);
      paramInt = i;
      if (this.onF != null) {
        paramInt = i + e.a.a.a.iP(23, this.onF.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(24, this.okJ);
      paramInt = i;
      if (this.okL != null) {
        paramInt = i + e.a.a.b.b.a.f(25, this.okL);
      }
      i = paramInt + e.a.a.a.c(26, 8, this.onG);
      paramInt = i;
      if (this.onH != null) {
        paramInt = i + e.a.a.a.iP(27, this.onH.computeSize());
      }
      i = paramInt;
      if (this.onI != null) {
        i = paramInt + e.a.a.b.b.a.f(28, this.onI);
      }
      paramInt = i;
      if (this.onJ != null) {
        paramInt = i + e.a.a.b.b.a.f(29, this.onJ);
      }
      i = paramInt + e.a.a.b.b.a.bl(30, this.onK) + e.a.a.b.b.a.bl(31, this.resourceId);
      paramInt = i;
      if (this.okM != null) {
        paramInt = i + e.a.a.b.b.a.f(32, this.okM);
      }
      i = paramInt + e.a.a.a.c(33, 8, this.onL);
      paramInt = i;
      if (this.okK != null) {
        paramInt = i + e.a.a.b.b.a.f(34, this.okK);
      }
      i = paramInt;
      if (this.onM != null) {
        i = paramInt + e.a.a.b.b.a.f(35, this.onM);
      }
      paramInt = i;
      if (this.onN != null) {
        paramInt = i + e.a.a.b.b.a.f(36, this.onN);
      }
      i = paramInt + e.a.a.b.b.a.bl(37, this.onO);
      paramInt = i;
      if (this.onP != null) {
        paramInt = i + e.a.a.b.b.a.f(38, this.onP);
      }
      i = paramInt;
      if (this.onQ != null) {
        i = paramInt + e.a.a.b.b.a.f(39, this.onQ);
      }
      AppMethodBeat.o(56611);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.onG.clear();
      this.onL.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56611);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(56611);
        return -1;
      case 1: 
        localk.cMP = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 2: 
        localk.cMQ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 3: 
        localk.onq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 4: 
        localk.onr = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 5: 
        localk.oiG = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 6: 
        localk.ons = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 7: 
        localk.ont = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 8: 
        localk.ojA = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 9: 
        localk.onu = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 10: 
        localk.onv = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 11: 
        localk.cNd = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56611);
        return 0;
      case 12: 
        localk.onw = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56611);
        return 0;
      case 13: 
        localk.onx = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56611);
        return 0;
      case 14: 
        localk.kNn = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 15: 
        localk.ony = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56611);
        return 0;
      case 16: 
        localk.onz = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 17: 
        localk.onA = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 18: 
        localk.onB = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 19: 
        localk.onC = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 20: 
        localk.onD = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 21: 
        localk.cMR = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 22: 
        localk.onE = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 23: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localk.onF = ((e)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56611);
        return 0;
      case 24: 
        localk.okJ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 25: 
        localk.okL = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 26: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new as();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((as)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localk.onG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56611);
        return 0;
      case 27: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new as();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((as)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localk.onH = ((as)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56611);
        return 0;
      case 28: 
        localk.onI = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 29: 
        localk.onJ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 30: 
        localk.onK = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 31: 
        localk.resourceId = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 32: 
        localk.okM = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 33: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new w();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((w)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localk.onL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56611);
        return 0;
      case 34: 
        localk.okK = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 35: 
        localk.onM = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 36: 
        localk.onN = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      case 37: 
        localk.onO = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56611);
        return 0;
      case 38: 
        localk.onP = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56611);
        return 0;
      }
      localk.onQ = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(56611);
      return 0;
    }
    AppMethodBeat.o(56611);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.k
 * JD-Core Version:    0.7.0.1
 */