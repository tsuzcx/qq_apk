package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends com.tencent.mm.bw.a
{
  public int dPc;
  public int dPd;
  public int dPe;
  public long dPq;
  public int pgV;
  public int resourceId;
  public String vAA;
  public int vAB;
  public LinkedList<y> vAC;
  public String vAD;
  public String vAE;
  public int vAF;
  public String vAG;
  public String vAH;
  public String vAh;
  public String vAi;
  public String vAj;
  public String vAk;
  public String vAl;
  public String vAm;
  public long vAn;
  public long vAo;
  public long vAp;
  public String vAq;
  public int vAr;
  public int vAs;
  public int vAt;
  public String vAu;
  public int vAv;
  public f vAw;
  public LinkedList<au> vAx;
  public au vAy;
  public String vAz;
  public String vvw;
  public String vwq;
  public String vxA;
  public String vxB;
  public String vxC;
  public int vxz;
  
  public l()
  {
    AppMethodBeat.i(91253);
    this.vAx = new LinkedList();
    this.vAC = new LinkedList();
    AppMethodBeat.o(91253);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91254);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dPc);
      paramVarArgs.aS(2, this.dPd);
      if (this.vAh != null) {
        paramVarArgs.d(3, this.vAh);
      }
      if (this.vAi != null) {
        paramVarArgs.d(4, this.vAi);
      }
      if (this.vvw != null) {
        paramVarArgs.d(5, this.vvw);
      }
      if (this.vAj != null) {
        paramVarArgs.d(6, this.vAj);
      }
      if (this.vAk != null) {
        paramVarArgs.d(7, this.vAk);
      }
      if (this.vwq != null) {
        paramVarArgs.d(8, this.vwq);
      }
      if (this.vAl != null) {
        paramVarArgs.d(9, this.vAl);
      }
      if (this.vAm != null) {
        paramVarArgs.d(10, this.vAm);
      }
      paramVarArgs.aZ(11, this.dPq);
      paramVarArgs.aZ(12, this.vAn);
      paramVarArgs.aZ(13, this.vAo);
      paramVarArgs.aS(14, this.pgV);
      paramVarArgs.aZ(15, this.vAp);
      if (this.vAq != null) {
        paramVarArgs.d(16, this.vAq);
      }
      paramVarArgs.aS(17, this.vAr);
      paramVarArgs.aS(18, this.vAs);
      paramVarArgs.aS(19, this.vAt);
      if (this.vAu != null) {
        paramVarArgs.d(20, this.vAu);
      }
      paramVarArgs.aS(21, this.dPe);
      paramVarArgs.aS(22, this.vAv);
      if (this.vAw != null)
      {
        paramVarArgs.lJ(23, this.vAw.computeSize());
        this.vAw.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(24, this.vxz);
      if (this.vxB != null) {
        paramVarArgs.d(25, this.vxB);
      }
      paramVarArgs.e(26, 8, this.vAx);
      if (this.vAy != null)
      {
        paramVarArgs.lJ(27, this.vAy.computeSize());
        this.vAy.writeFields(paramVarArgs);
      }
      if (this.vAz != null) {
        paramVarArgs.d(28, this.vAz);
      }
      if (this.vAA != null) {
        paramVarArgs.d(29, this.vAA);
      }
      paramVarArgs.aS(30, this.vAB);
      paramVarArgs.aS(31, this.resourceId);
      if (this.vxC != null) {
        paramVarArgs.d(32, this.vxC);
      }
      paramVarArgs.e(33, 8, this.vAC);
      if (this.vxA != null) {
        paramVarArgs.d(34, this.vxA);
      }
      if (this.vAD != null) {
        paramVarArgs.d(35, this.vAD);
      }
      if (this.vAE != null) {
        paramVarArgs.d(36, this.vAE);
      }
      paramVarArgs.aS(37, this.vAF);
      if (this.vAG != null) {
        paramVarArgs.d(38, this.vAG);
      }
      if (this.vAH != null) {
        paramVarArgs.d(39, this.vAH);
      }
      AppMethodBeat.o(91254);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.dPc) + 0 + f.a.a.b.b.a.bz(2, this.dPd);
      paramInt = i;
      if (this.vAh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.vAh);
      }
      i = paramInt;
      if (this.vAi != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vAi);
      }
      paramInt = i;
      if (this.vvw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vvw);
      }
      i = paramInt;
      if (this.vAj != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.vAj);
      }
      paramInt = i;
      if (this.vAk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vAk);
      }
      i = paramInt;
      if (this.vwq != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.vwq);
      }
      paramInt = i;
      if (this.vAl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.vAl);
      }
      i = paramInt;
      if (this.vAm != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.vAm);
      }
      i = i + f.a.a.b.b.a.p(11, this.dPq) + f.a.a.b.b.a.p(12, this.vAn) + f.a.a.b.b.a.p(13, this.vAo) + f.a.a.b.b.a.bz(14, this.pgV) + f.a.a.b.b.a.p(15, this.vAp);
      paramInt = i;
      if (this.vAq != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.vAq);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.vAr) + f.a.a.b.b.a.bz(18, this.vAs) + f.a.a.b.b.a.bz(19, this.vAt);
      paramInt = i;
      if (this.vAu != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.vAu);
      }
      i = paramInt + f.a.a.b.b.a.bz(21, this.dPe) + f.a.a.b.b.a.bz(22, this.vAv);
      paramInt = i;
      if (this.vAw != null) {
        paramInt = i + f.a.a.a.lI(23, this.vAw.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.vxz);
      paramInt = i;
      if (this.vxB != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.vxB);
      }
      i = paramInt + f.a.a.a.c(26, 8, this.vAx);
      paramInt = i;
      if (this.vAy != null) {
        paramInt = i + f.a.a.a.lI(27, this.vAy.computeSize());
      }
      i = paramInt;
      if (this.vAz != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.vAz);
      }
      paramInt = i;
      if (this.vAA != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.vAA);
      }
      i = paramInt + f.a.a.b.b.a.bz(30, this.vAB) + f.a.a.b.b.a.bz(31, this.resourceId);
      paramInt = i;
      if (this.vxC != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.vxC);
      }
      i = paramInt + f.a.a.a.c(33, 8, this.vAC);
      paramInt = i;
      if (this.vxA != null) {
        paramInt = i + f.a.a.b.b.a.e(34, this.vxA);
      }
      i = paramInt;
      if (this.vAD != null) {
        i = paramInt + f.a.a.b.b.a.e(35, this.vAD);
      }
      paramInt = i;
      if (this.vAE != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.vAE);
      }
      i = paramInt + f.a.a.b.b.a.bz(37, this.vAF);
      paramInt = i;
      if (this.vAG != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.vAG);
      }
      i = paramInt;
      if (this.vAH != null) {
        i = paramInt + f.a.a.b.b.a.e(39, this.vAH);
      }
      AppMethodBeat.o(91254);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.vAx.clear();
      this.vAC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        locall.dPc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 2: 
        locall.dPd = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 3: 
        locall.vAh = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 4: 
        locall.vAi = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 5: 
        locall.vvw = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 6: 
        locall.vAj = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 7: 
        locall.vAk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 8: 
        locall.vwq = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 9: 
        locall.vAl = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 10: 
        locall.vAm = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 11: 
        locall.dPq = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91254);
        return 0;
      case 12: 
        locall.vAn = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91254);
        return 0;
      case 13: 
        locall.vAo = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91254);
        return 0;
      case 14: 
        locall.pgV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 15: 
        locall.vAp = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91254);
        return 0;
      case 16: 
        locall.vAq = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 17: 
        locall.vAr = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 18: 
        locall.vAs = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 19: 
        locall.vAt = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 20: 
        locall.vAu = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 21: 
        locall.dPe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 22: 
        locall.vAv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 23: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.vAw = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 24: 
        locall.vxz = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 25: 
        locall.vxB = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 26: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new au();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.vAx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 27: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new au();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.vAy = ((au)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 28: 
        locall.vAz = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 29: 
        locall.vAA = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 30: 
        locall.vAB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 31: 
        locall.resourceId = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 32: 
        locall.vxC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 33: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new y();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((y)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.vAC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 34: 
        locall.vxA = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 35: 
        locall.vAD = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 36: 
        locall.vAE = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 37: 
        locall.vAF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 38: 
        locall.vAG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91254);
        return 0;
      }
      locall.vAH = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(91254);
      return 0;
    }
    AppMethodBeat.o(91254);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l
 * JD-Core Version:    0.7.0.1
 */