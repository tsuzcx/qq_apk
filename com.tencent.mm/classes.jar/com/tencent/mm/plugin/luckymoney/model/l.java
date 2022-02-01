package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends com.tencent.mm.bx.a
{
  public int dDN;
  public int dDO;
  public int dDP;
  public long dEb;
  public int nTB;
  public int resourceId;
  public String sYt;
  public String sZn;
  public String taA;
  public int tax;
  public String tay;
  public String taz;
  public String tdA;
  public int tdB;
  public LinkedList<y> tdC;
  public String tdD;
  public String tdE;
  public int tdF;
  public String tdG;
  public String tdH;
  public String tdh;
  public String tdi;
  public String tdj;
  public String tdk;
  public String tdl;
  public String tdm;
  public long tdn;
  public long tdo;
  public long tdp;
  public String tdq;
  public int tdr;
  public int tds;
  public int tdt;
  public String tdu;
  public int tdv;
  public f tdw;
  public LinkedList<au> tdx;
  public au tdy;
  public String tdz;
  
  public l()
  {
    AppMethodBeat.i(91253);
    this.tdx = new LinkedList();
    this.tdC = new LinkedList();
    AppMethodBeat.o(91253);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91254);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dDN);
      paramVarArgs.aR(2, this.dDO);
      if (this.tdh != null) {
        paramVarArgs.d(3, this.tdh);
      }
      if (this.tdi != null) {
        paramVarArgs.d(4, this.tdi);
      }
      if (this.sYt != null) {
        paramVarArgs.d(5, this.sYt);
      }
      if (this.tdj != null) {
        paramVarArgs.d(6, this.tdj);
      }
      if (this.tdk != null) {
        paramVarArgs.d(7, this.tdk);
      }
      if (this.sZn != null) {
        paramVarArgs.d(8, this.sZn);
      }
      if (this.tdl != null) {
        paramVarArgs.d(9, this.tdl);
      }
      if (this.tdm != null) {
        paramVarArgs.d(10, this.tdm);
      }
      paramVarArgs.aG(11, this.dEb);
      paramVarArgs.aG(12, this.tdn);
      paramVarArgs.aG(13, this.tdo);
      paramVarArgs.aR(14, this.nTB);
      paramVarArgs.aG(15, this.tdp);
      if (this.tdq != null) {
        paramVarArgs.d(16, this.tdq);
      }
      paramVarArgs.aR(17, this.tdr);
      paramVarArgs.aR(18, this.tds);
      paramVarArgs.aR(19, this.tdt);
      if (this.tdu != null) {
        paramVarArgs.d(20, this.tdu);
      }
      paramVarArgs.aR(21, this.dDP);
      paramVarArgs.aR(22, this.tdv);
      if (this.tdw != null)
      {
        paramVarArgs.kX(23, this.tdw.computeSize());
        this.tdw.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(24, this.tax);
      if (this.taz != null) {
        paramVarArgs.d(25, this.taz);
      }
      paramVarArgs.e(26, 8, this.tdx);
      if (this.tdy != null)
      {
        paramVarArgs.kX(27, this.tdy.computeSize());
        this.tdy.writeFields(paramVarArgs);
      }
      if (this.tdz != null) {
        paramVarArgs.d(28, this.tdz);
      }
      if (this.tdA != null) {
        paramVarArgs.d(29, this.tdA);
      }
      paramVarArgs.aR(30, this.tdB);
      paramVarArgs.aR(31, this.resourceId);
      if (this.taA != null) {
        paramVarArgs.d(32, this.taA);
      }
      paramVarArgs.e(33, 8, this.tdC);
      if (this.tay != null) {
        paramVarArgs.d(34, this.tay);
      }
      if (this.tdD != null) {
        paramVarArgs.d(35, this.tdD);
      }
      if (this.tdE != null) {
        paramVarArgs.d(36, this.tdE);
      }
      paramVarArgs.aR(37, this.tdF);
      if (this.tdG != null) {
        paramVarArgs.d(38, this.tdG);
      }
      if (this.tdH != null) {
        paramVarArgs.d(39, this.tdH);
      }
      AppMethodBeat.o(91254);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.dDN) + 0 + f.a.a.b.b.a.bA(2, this.dDO);
      paramInt = i;
      if (this.tdh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.tdh);
      }
      i = paramInt;
      if (this.tdi != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.tdi);
      }
      paramInt = i;
      if (this.sYt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sYt);
      }
      i = paramInt;
      if (this.tdj != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.tdj);
      }
      paramInt = i;
      if (this.tdk != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.tdk);
      }
      i = paramInt;
      if (this.sZn != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.sZn);
      }
      paramInt = i;
      if (this.tdl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.tdl);
      }
      i = paramInt;
      if (this.tdm != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.tdm);
      }
      i = i + f.a.a.b.b.a.q(11, this.dEb) + f.a.a.b.b.a.q(12, this.tdn) + f.a.a.b.b.a.q(13, this.tdo) + f.a.a.b.b.a.bA(14, this.nTB) + f.a.a.b.b.a.q(15, this.tdp);
      paramInt = i;
      if (this.tdq != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.tdq);
      }
      i = paramInt + f.a.a.b.b.a.bA(17, this.tdr) + f.a.a.b.b.a.bA(18, this.tds) + f.a.a.b.b.a.bA(19, this.tdt);
      paramInt = i;
      if (this.tdu != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.tdu);
      }
      i = paramInt + f.a.a.b.b.a.bA(21, this.dDP) + f.a.a.b.b.a.bA(22, this.tdv);
      paramInt = i;
      if (this.tdw != null) {
        paramInt = i + f.a.a.a.kW(23, this.tdw.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(24, this.tax);
      paramInt = i;
      if (this.taz != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.taz);
      }
      i = paramInt + f.a.a.a.c(26, 8, this.tdx);
      paramInt = i;
      if (this.tdy != null) {
        paramInt = i + f.a.a.a.kW(27, this.tdy.computeSize());
      }
      i = paramInt;
      if (this.tdz != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.tdz);
      }
      paramInt = i;
      if (this.tdA != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.tdA);
      }
      i = paramInt + f.a.a.b.b.a.bA(30, this.tdB) + f.a.a.b.b.a.bA(31, this.resourceId);
      paramInt = i;
      if (this.taA != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.taA);
      }
      i = paramInt + f.a.a.a.c(33, 8, this.tdC);
      paramInt = i;
      if (this.tay != null) {
        paramInt = i + f.a.a.b.b.a.e(34, this.tay);
      }
      i = paramInt;
      if (this.tdD != null) {
        i = paramInt + f.a.a.b.b.a.e(35, this.tdD);
      }
      paramInt = i;
      if (this.tdE != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.tdE);
      }
      i = paramInt + f.a.a.b.b.a.bA(37, this.tdF);
      paramInt = i;
      if (this.tdG != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.tdG);
      }
      i = paramInt;
      if (this.tdH != null) {
        i = paramInt + f.a.a.b.b.a.e(39, this.tdH);
      }
      AppMethodBeat.o(91254);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tdx.clear();
      this.tdC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        locall.dDN = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 2: 
        locall.dDO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 3: 
        locall.tdh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 4: 
        locall.tdi = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 5: 
        locall.sYt = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 6: 
        locall.tdj = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 7: 
        locall.tdk = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 8: 
        locall.sZn = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 9: 
        locall.tdl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 10: 
        locall.tdm = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 11: 
        locall.dEb = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91254);
        return 0;
      case 12: 
        locall.tdn = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91254);
        return 0;
      case 13: 
        locall.tdo = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91254);
        return 0;
      case 14: 
        locall.nTB = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 15: 
        locall.tdp = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91254);
        return 0;
      case 16: 
        locall.tdq = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 17: 
        locall.tdr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 18: 
        locall.tds = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 19: 
        locall.tdt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 20: 
        locall.tdu = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 21: 
        locall.dDP = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 22: 
        locall.tdv = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 23: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.tdw = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 24: 
        locall.tax = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 25: 
        locall.taz = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 26: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new au();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.tdx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 27: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new au();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.tdy = ((au)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 28: 
        locall.tdz = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 29: 
        locall.tdA = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 30: 
        locall.tdB = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 31: 
        locall.resourceId = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 32: 
        locall.taA = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 33: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new y();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((y)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.tdC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 34: 
        locall.tay = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 35: 
        locall.tdD = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 36: 
        locall.tdE = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 37: 
        locall.tdF = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91254);
        return 0;
      case 38: 
        locall.tdG = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91254);
        return 0;
      }
      locall.tdH = ((f.a.a.a.a)localObject1).KhF.readString();
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