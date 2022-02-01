package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends com.tencent.mm.bx.a
{
  public int dNM;
  public int dNN;
  public int dNO;
  public long dOa;
  public int par;
  public int resourceId;
  public String vjr;
  public String vkl;
  public int vlu;
  public String vlv;
  public String vlw;
  public String vlx;
  public int voA;
  public String voB;
  public String voC;
  public String voc;
  public String vod;
  public String voe;
  public String vof;
  public String vog;
  public String voh;
  public long voi;
  public long voj;
  public long vok;
  public String vol;
  public int vom;
  public int von;
  public int voo;
  public String vop;
  public int voq;
  public f vor;
  public LinkedList<au> vos;
  public au vot;
  public String vou;
  public String vov;
  public int vow;
  public LinkedList<y> vox;
  public String voy;
  public String voz;
  
  public l()
  {
    AppMethodBeat.i(91253);
    this.vos = new LinkedList();
    this.vox = new LinkedList();
    AppMethodBeat.o(91253);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91254);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dNM);
      paramVarArgs.aS(2, this.dNN);
      if (this.voc != null) {
        paramVarArgs.d(3, this.voc);
      }
      if (this.vod != null) {
        paramVarArgs.d(4, this.vod);
      }
      if (this.vjr != null) {
        paramVarArgs.d(5, this.vjr);
      }
      if (this.voe != null) {
        paramVarArgs.d(6, this.voe);
      }
      if (this.vof != null) {
        paramVarArgs.d(7, this.vof);
      }
      if (this.vkl != null) {
        paramVarArgs.d(8, this.vkl);
      }
      if (this.vog != null) {
        paramVarArgs.d(9, this.vog);
      }
      if (this.voh != null) {
        paramVarArgs.d(10, this.voh);
      }
      paramVarArgs.aY(11, this.dOa);
      paramVarArgs.aY(12, this.voi);
      paramVarArgs.aY(13, this.voj);
      paramVarArgs.aS(14, this.par);
      paramVarArgs.aY(15, this.vok);
      if (this.vol != null) {
        paramVarArgs.d(16, this.vol);
      }
      paramVarArgs.aS(17, this.vom);
      paramVarArgs.aS(18, this.von);
      paramVarArgs.aS(19, this.voo);
      if (this.vop != null) {
        paramVarArgs.d(20, this.vop);
      }
      paramVarArgs.aS(21, this.dNO);
      paramVarArgs.aS(22, this.voq);
      if (this.vor != null)
      {
        paramVarArgs.lC(23, this.vor.computeSize());
        this.vor.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(24, this.vlu);
      if (this.vlw != null) {
        paramVarArgs.d(25, this.vlw);
      }
      paramVarArgs.e(26, 8, this.vos);
      if (this.vot != null)
      {
        paramVarArgs.lC(27, this.vot.computeSize());
        this.vot.writeFields(paramVarArgs);
      }
      if (this.vou != null) {
        paramVarArgs.d(28, this.vou);
      }
      if (this.vov != null) {
        paramVarArgs.d(29, this.vov);
      }
      paramVarArgs.aS(30, this.vow);
      paramVarArgs.aS(31, this.resourceId);
      if (this.vlx != null) {
        paramVarArgs.d(32, this.vlx);
      }
      paramVarArgs.e(33, 8, this.vox);
      if (this.vlv != null) {
        paramVarArgs.d(34, this.vlv);
      }
      if (this.voy != null) {
        paramVarArgs.d(35, this.voy);
      }
      if (this.voz != null) {
        paramVarArgs.d(36, this.voz);
      }
      paramVarArgs.aS(37, this.voA);
      if (this.voB != null) {
        paramVarArgs.d(38, this.voB);
      }
      if (this.voC != null) {
        paramVarArgs.d(39, this.voC);
      }
      AppMethodBeat.o(91254);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.dNM) + 0 + f.a.a.b.b.a.bz(2, this.dNN);
      paramInt = i;
      if (this.voc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.voc);
      }
      i = paramInt;
      if (this.vod != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vod);
      }
      paramInt = i;
      if (this.vjr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vjr);
      }
      i = paramInt;
      if (this.voe != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.voe);
      }
      paramInt = i;
      if (this.vof != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vof);
      }
      i = paramInt;
      if (this.vkl != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.vkl);
      }
      paramInt = i;
      if (this.vog != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.vog);
      }
      i = paramInt;
      if (this.voh != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.voh);
      }
      i = i + f.a.a.b.b.a.p(11, this.dOa) + f.a.a.b.b.a.p(12, this.voi) + f.a.a.b.b.a.p(13, this.voj) + f.a.a.b.b.a.bz(14, this.par) + f.a.a.b.b.a.p(15, this.vok);
      paramInt = i;
      if (this.vol != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.vol);
      }
      i = paramInt + f.a.a.b.b.a.bz(17, this.vom) + f.a.a.b.b.a.bz(18, this.von) + f.a.a.b.b.a.bz(19, this.voo);
      paramInt = i;
      if (this.vop != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.vop);
      }
      i = paramInt + f.a.a.b.b.a.bz(21, this.dNO) + f.a.a.b.b.a.bz(22, this.voq);
      paramInt = i;
      if (this.vor != null) {
        paramInt = i + f.a.a.a.lB(23, this.vor.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(24, this.vlu);
      paramInt = i;
      if (this.vlw != null) {
        paramInt = i + f.a.a.b.b.a.e(25, this.vlw);
      }
      i = paramInt + f.a.a.a.c(26, 8, this.vos);
      paramInt = i;
      if (this.vot != null) {
        paramInt = i + f.a.a.a.lB(27, this.vot.computeSize());
      }
      i = paramInt;
      if (this.vou != null) {
        i = paramInt + f.a.a.b.b.a.e(28, this.vou);
      }
      paramInt = i;
      if (this.vov != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.vov);
      }
      i = paramInt + f.a.a.b.b.a.bz(30, this.vow) + f.a.a.b.b.a.bz(31, this.resourceId);
      paramInt = i;
      if (this.vlx != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.vlx);
      }
      i = paramInt + f.a.a.a.c(33, 8, this.vox);
      paramInt = i;
      if (this.vlv != null) {
        paramInt = i + f.a.a.b.b.a.e(34, this.vlv);
      }
      i = paramInt;
      if (this.voy != null) {
        i = paramInt + f.a.a.b.b.a.e(35, this.voy);
      }
      paramInt = i;
      if (this.voz != null) {
        paramInt = i + f.a.a.b.b.a.e(36, this.voz);
      }
      i = paramInt + f.a.a.b.b.a.bz(37, this.voA);
      paramInt = i;
      if (this.voB != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.voB);
      }
      i = paramInt;
      if (this.voC != null) {
        i = paramInt + f.a.a.b.b.a.e(39, this.voC);
      }
      AppMethodBeat.o(91254);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.vos.clear();
      this.vox.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        locall.dNM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 2: 
        locall.dNN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 3: 
        locall.voc = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 4: 
        locall.vod = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 5: 
        locall.vjr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 6: 
        locall.voe = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 7: 
        locall.vof = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 8: 
        locall.vkl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 9: 
        locall.vog = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 10: 
        locall.voh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 11: 
        locall.dOa = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91254);
        return 0;
      case 12: 
        locall.voi = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91254);
        return 0;
      case 13: 
        locall.voj = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91254);
        return 0;
      case 14: 
        locall.par = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 15: 
        locall.vok = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(91254);
        return 0;
      case 16: 
        locall.vol = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 17: 
        locall.vom = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 18: 
        locall.von = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 19: 
        locall.voo = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 20: 
        locall.vop = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 21: 
        locall.dNO = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 22: 
        locall.voq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 23: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.vor = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 24: 
        locall.vlu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 25: 
        locall.vlw = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 26: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new au();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.vos.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 27: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new au();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.vot = ((au)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 28: 
        locall.vou = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 29: 
        locall.vov = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 30: 
        locall.vow = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 31: 
        locall.resourceId = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 32: 
        locall.vlx = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 33: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new y();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((y)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locall.vox.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91254);
        return 0;
      case 34: 
        locall.vlv = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 35: 
        locall.voy = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 36: 
        locall.voz = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      case 37: 
        locall.voA = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91254);
        return 0;
      case 38: 
        locall.voB = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91254);
        return 0;
      }
      locall.voC = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(91254);
      return 0;
    }
    AppMethodBeat.o(91254);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l
 * JD-Core Version:    0.7.0.1
 */