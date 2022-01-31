package com.tencent.mm.plugin.game.d;

import d.a.a.b;
import java.util.LinkedList;

public final class q
  extends com.tencent.mm.bv.a
{
  public String kSL;
  public String kSM;
  public String kSN;
  public dp kSO;
  public int kSP;
  public int kSQ;
  public String kSR;
  public int kSS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSL == null) {
        throw new b("Not all required fields were included: DownloadURL");
      }
      if (this.kSL != null) {
        paramVarArgs.d(1, this.kSL);
      }
      if (this.kSM != null) {
        paramVarArgs.d(2, this.kSM);
      }
      if (this.kSN != null) {
        paramVarArgs.d(4, this.kSN);
      }
      if (this.kSO != null)
      {
        paramVarArgs.gD(5, this.kSO.btq());
        this.kSO.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.kSP);
      paramVarArgs.gB(7, this.kSQ);
      if (this.kSR != null) {
        paramVarArgs.d(8, this.kSR);
      }
      paramVarArgs.gB(9, this.kSS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSL == null) {
        break label650;
      }
    }
    label650:
    for (int i = d.a.a.b.b.a.e(1, this.kSL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kSM != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSM);
      }
      i = paramInt;
      if (this.kSN != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kSN);
      }
      paramInt = i;
      if (this.kSO != null) {
        paramInt = i + d.a.a.a.gA(5, this.kSO.btq());
      }
      i = paramInt + d.a.a.a.gy(6, this.kSP) + d.a.a.a.gy(7, this.kSQ);
      paramInt = i;
      if (this.kSR != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.kSR);
      }
      return paramInt + d.a.a.a.gy(9, this.kSS);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.kSL != null) {
          break;
        }
        throw new b("Not all required fields were included: DownloadURL");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          return -1;
        case 1: 
          localq.kSL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localq.kSM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localq.kSN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localq.kSO = ((dp)localObject1);
            paramInt += 1;
          }
        case 6: 
          localq.kSP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localq.kSQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localq.kSR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localq.kSS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.q
 * JD-Core Version:    0.7.0.1
 */