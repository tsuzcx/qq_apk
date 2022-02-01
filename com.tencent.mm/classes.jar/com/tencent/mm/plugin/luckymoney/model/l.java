package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends com.tencent.mm.bw.a
{
  public int dBA;
  public int dBB;
  public long dBN;
  public int dBz;
  public int owW;
  public int resourceId;
  public String ugH;
  public String uhB;
  public int uiM;
  public String uiN;
  public String uiO;
  public String uiP;
  public String ulA;
  public String ulB;
  public long ulC;
  public long ulD;
  public long ulE;
  public String ulF;
  public int ulG;
  public int ulH;
  public int ulI;
  public String ulJ;
  public int ulK;
  public f ulL;
  public LinkedList<au> ulM;
  public au ulN;
  public String ulO;
  public String ulP;
  public int ulQ;
  public LinkedList<y> ulR;
  public String ulS;
  public String ulT;
  public int ulU;
  public String ulV;
  public String ulW;
  public String ulw;
  public String ulx;
  public String uly;
  public String ulz;
  
  public l()
  {
    AppMethodBeat.i(91253);
    this.ulM = new LinkedList();
    this.ulR = new LinkedList();
    AppMethodBeat.o(91253);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91254);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dBz);
      paramVarArgs.aR(2, this.dBA);
      if (this.ulw != null) {
        paramVarArgs.d(3, this.ulw);
      }
      if (this.ulx != null) {
        paramVarArgs.d(4, this.ulx);
      }
      if (this.ugH != null) {
        paramVarArgs.d(5, this.ugH);
      }
      if (this.uly != null) {
        paramVarArgs.d(6, this.uly);
      }
      if (this.ulz != null) {
        paramVarArgs.d(7, this.ulz);
      }
      if (this.uhB != null) {
        paramVarArgs.d(8, this.uhB);
      }
      if (this.ulA != null) {
        paramVarArgs.d(9, this.ulA);
      }
      if (this.ulB != null) {
        paramVarArgs.d(10, this.ulB);
      }
      paramVarArgs.aO(11, this.dBN);
      paramVarArgs.aO(12, this.ulC);
      paramVarArgs.aO(13, this.ulD);
      paramVarArgs.aR(14, this.owW);
      paramVarArgs.aO(15, this.ulE);
      if (this.ulF != null) {
        paramVarArgs.d(16, this.ulF);
      }
      paramVarArgs.aR(17, this.ulG);
      paramVarArgs.aR(18, this.ulH);
      paramVarArgs.aR(19, this.ulI);
      if (this.ulJ != null) {
        paramVarArgs.d(20, this.ulJ);
      }
      paramVarArgs.aR(21, this.dBB);
      paramVarArgs.aR(22, this.ulK);
      if (this.ulL != null)
      {
        paramVarArgs.ln(23, this.ulL.computeSize());
        this.ulL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(24, this.uiM);
      if (this.uiO != null) {
        paramVarArgs.d(25, this.uiO);
      }
      paramVarArgs.e(26, 8, this.ulM);
      if (this.ulN != null)
      {
        paramVarArgs.ln(27, this.ulN.computeSize());
        this.ulN.writeFields(paramVarArgs);
      }
      if (this.ulO != null) {
        paramVarArgs.d(28, this.ulO);
      }
      if (this.ulP != null) {
        paramVarArgs.d(29, this.ulP);
      }
      paramVarArgs.aR(30, this.ulQ);
      paramVarArgs.aR(31, this.resourceId);
      if (this.uiP != null) {
        paramVarArgs.d(32, this.uiP);
      }
      paramVarArgs.e(33, 8, this.ulR);
      if (this.uiN != null) {
        paramVarArgs.d(34, this.uiN);
      }
      if (this.ulS != null) {
        paramVarArgs.d(35, this.ulS);
      }
      if (this.ulT != null) {
        paramVarArgs.d(36, this.ulT);
      }
      paramVarArgs.aR(37, this.ulU);
      if (this.ulV != null) {
        paramVarArgs.d(38, this.ulV);
      }
      if (this.ulW != null) {
        paramVarArgs.d(39, this.ulW);
      }
      AppMethodBeat.o(91254);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.dBz) + 0 + f.a.a.b.b.a.bx(2, this.dBA);
      paramInt = i;
      if (this.ulw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ulw);
      }
      i = paramInt;
      if (this.ulx != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ulx);
      }
      paramInt = i;
      if (this.ugH != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ugH);
      }
      i = paramInt;
      if (this.uly != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.uly);
      }
      paramInt = i;
      if (this.ulz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ulz);
      }
      i = paramInt;
      if (this.uhB != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.uhB);
      }
      paramInt = i;
      if (this.ulA != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ulA);
      }
      i = paramInt;
      if (this.ulB != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.ulB);
      }
      i = i + f.a.a.b.b.a.p(11, this.dBN) + f.a.a.b.b.a.p(12, this.ulC) + f.a.a.b.b.a.p(13, this.ulD) + f.a.a.b.b.a.bx(14, this.owW) + f.a.a.b.b.a.p(15, this.ulE);
      paramInt = i;
      if (this.ulF != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.ulF);
      }
      i = paramInt + f.a.a.b.b.a.bx(17, this.ulG) + f.a.a.b.b.a.bx(18, this.ulH) + f.a.a.b.b.a.bx(19, this.ulI);
      paramInt = i;
      if (this.ulJ != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.ulJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(21, this.dBB) + f.a.a.b.b.a.bx(22, this.ulK);
      paramInt = i;
      if (this.ulL != null) {
        paramInt = i + f.a.a.a.lm(23, this.ulL.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(24, this.uiM);
      paramInt = i;
      if (this.uiO != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.uiO);
      }
      i = paramInt + f.a.a.a.c(26, 8, this.ulM);
      paramInt = i;
      if (this.ulN != null) {
        paramInt = i + f.a.a.a.lm(27, this.ulN.computeSize());
      }
      i = paramInt;
      if (this.ulO != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.ulO);
      }
      paramInt = i;
      if (this.ulP != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.ulP);
      }
      i = paramInt + f.a.a.b.b.a.bx(30, this.ulQ) + f.a.a.b.b.a.bx(31, this.resourceId);
      paramInt = i;
      if (this.uiP != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.uiP);
      }
      i = paramInt + f.a.a.a.c(33, 8, this.ulR);
      paramInt = i;
      if (this.uiN != null) {
        paramInt = i + f.a.a.b.b.a.e(34, this.uiN);
      }
      i = paramInt;
      if (this.ulS != null) {
        i = paramInt + f.a.a.b.b.a.e(35, this.ulS);
      }
      paramInt = i;
      if (this.ulT != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.ulT);
      }
      i = paramInt + f.a.a.b.b.a.bx(37, this.ulU);
      paramInt = i;
      if (this.ulV != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.ulV);
      }
      i = paramInt;
      if (this.ulW != null) {
        i = paramInt + f.a.a.b.b.a.e(39, this.ulW);
      }
      AppMethodBeat.o(91254);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ulM.clear();
      this.ulR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91254);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91254);
        return -1;
      case 1: 
        locall.dBz = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 2: 
        locall.dBA = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 3: 
        locall.ulw = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 4: 
        locall.ulx = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 5: 
        locall.ugH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 6: 
        locall.uly = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 7: 
        locall.ulz = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 8: 
        locall.uhB = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 9: 
        locall.ulA = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 10: 
        locall.ulB = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 11: 
        locall.dBN = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91254);
        return 0;
      case 12: 
        locall.ulC = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91254);
        return 0;
      case 13: 
        locall.ulD = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91254);
        return 0;
      case 14: 
        locall.owW = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 15: 
        locall.ulE = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(91254);
        return 0;
      case 16: 
        locall.ulF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 17: 
        locall.ulG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 18: 
        locall.ulH = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 19: 
        locall.ulI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 20: 
        locall.ulJ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 21: 
        locall.dBB = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 22: 
        locall.ulK = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 23: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.ulL = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 24: 
        locall.uiM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 25: 
        locall.uiO = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 26: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new au();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.ulM.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 27: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new au();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.ulN = ((au)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 28: 
        locall.ulO = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 29: 
        locall.ulP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 30: 
        locall.ulQ = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 31: 
        locall.resourceId = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 32: 
        locall.uiP = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 33: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new y();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((y)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.ulR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 34: 
        locall.uiN = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 35: 
        locall.ulS = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 36: 
        locall.ulT = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 37: 
        locall.ulU = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91254);
        return 0;
      case 38: 
        locall.ulV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91254);
        return 0;
      }
      locall.ulW = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(91254);
      return 0;
    }
    AppMethodBeat.o(91254);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l
 * JD-Core Version:    0.7.0.1
 */