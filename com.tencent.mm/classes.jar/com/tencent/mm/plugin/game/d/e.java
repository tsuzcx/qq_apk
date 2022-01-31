package com.tencent.mm.plugin.game.d;

import d.a.a.b;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bv.a
{
  public int hQQ;
  public int hQq;
  public String kRN;
  public String kRS;
  public String kRU;
  public String kRX;
  public String kRY;
  public String kRZ;
  public String kSa;
  public String kSb;
  public int kSc;
  public q kSd;
  public int kSe;
  public boolean kSf;
  public LinkedList<String> kSg = new LinkedList();
  public boolean kSh;
  public boolean kSi;
  public boolean kSj;
  public boolean kSk;
  public cf kSl;
  public int kSm;
  public bw kSn;
  public LinkedList<String> kSo = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRX == null) {
        throw new b("Not all required fields were included: AppID");
      }
      if (this.kRY == null) {
        throw new b("Not all required fields were included: IconURL");
      }
      if (this.kRX != null) {
        paramVarArgs.d(1, this.kRX);
      }
      if (this.kRY != null) {
        paramVarArgs.d(2, this.kRY);
      }
      if (this.kRZ != null) {
        paramVarArgs.d(3, this.kRZ);
      }
      if (this.kRN != null) {
        paramVarArgs.d(4, this.kRN);
      }
      if (this.kSa != null) {
        paramVarArgs.d(5, this.kSa);
      }
      if (this.kRS != null) {
        paramVarArgs.d(6, this.kRS);
      }
      if (this.kSb != null) {
        paramVarArgs.d(7, this.kSb);
      }
      paramVarArgs.gB(8, this.kSc);
      if (this.kSd != null)
      {
        paramVarArgs.gD(9, this.kSd.btq());
        this.kSd.a(paramVarArgs);
      }
      paramVarArgs.gB(10, this.hQq);
      paramVarArgs.gB(11, this.kSe);
      if (this.kRU != null) {
        paramVarArgs.d(12, this.kRU);
      }
      paramVarArgs.aA(13, this.kSf);
      paramVarArgs.d(14, 1, this.kSg);
      paramVarArgs.aA(15, this.kSh);
      paramVarArgs.gB(16, this.hQQ);
      paramVarArgs.aA(17, this.kSi);
      paramVarArgs.aA(18, this.kSj);
      paramVarArgs.aA(19, this.kSk);
      if (this.kSl != null)
      {
        paramVarArgs.gD(20, this.kSl.btq());
        this.kSl.a(paramVarArgs);
      }
      paramVarArgs.gB(21, this.kSm);
      if (this.kSn != null)
      {
        paramVarArgs.gD(22, this.kSn.btq());
        this.kSn.a(paramVarArgs);
      }
      paramVarArgs.d(23, 1, this.kSo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRX == null) {
        break label1564;
      }
    }
    label1564:
    for (int i = d.a.a.b.b.a.e(1, this.kRX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRY);
      }
      i = paramInt;
      if (this.kRZ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRZ);
      }
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRN);
      }
      i = paramInt;
      if (this.kSa != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kSa);
      }
      paramInt = i;
      if (this.kRS != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kRS);
      }
      i = paramInt;
      if (this.kSb != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.kSb);
      }
      i += d.a.a.a.gy(8, this.kSc);
      paramInt = i;
      if (this.kSd != null) {
        paramInt = i + d.a.a.a.gA(9, this.kSd.btq());
      }
      i = paramInt + d.a.a.a.gy(10, this.hQq) + d.a.a.a.gy(11, this.kSe);
      paramInt = i;
      if (this.kRU != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.kRU);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(13) + 1) + d.a.a.a.c(14, 1, this.kSg) + (d.a.a.b.b.a.dQ(15) + 1) + d.a.a.a.gy(16, this.hQQ) + (d.a.a.b.b.a.dQ(17) + 1) + (d.a.a.b.b.a.dQ(18) + 1) + (d.a.a.b.b.a.dQ(19) + 1);
      paramInt = i;
      if (this.kSl != null) {
        paramInt = i + d.a.a.a.gA(20, this.kSl.btq());
      }
      i = paramInt + d.a.a.a.gy(21, this.kSm);
      paramInt = i;
      if (this.kSn != null) {
        paramInt = i + d.a.a.a.gA(22, this.kSn.btq());
      }
      return paramInt + d.a.a.a.c(23, 1, this.kSo);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kSg.clear();
        this.kSo.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.kRX == null) {
          throw new b("Not all required fields were included: AppID");
        }
        if (this.kRY != null) {
          break;
        }
        throw new b("Not all required fields were included: IconURL");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          locale.kRX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          locale.kRY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          locale.kRZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          locale.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          locale.kSa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          locale.kRS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          locale.kSb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          locale.kSc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new q();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((q)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locale.kSd = ((q)localObject1);
            paramInt += 1;
          }
        case 10: 
          locale.hQq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          locale.kSe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          locale.kRU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          locale.kSf = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 14: 
          locale.kSg.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 15: 
          locale.kSh = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 16: 
          locale.hQQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          locale.kSi = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 18: 
          locale.kSj = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 19: 
          locale.kSk = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 20: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cf();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cf)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locale.kSl = ((cf)localObject1);
            paramInt += 1;
          }
        case 21: 
          locale.kSm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 22: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locale.kSn = ((bw)localObject1);
            paramInt += 1;
          }
        }
        locale.kSo.add(((d.a.a.a.a)localObject1).xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.e
 * JD-Core Version:    0.7.0.1
 */