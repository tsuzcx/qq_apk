package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.gc;
import d.a.a.b;
import java.util.LinkedList;

public final class dd
  extends blm
{
  public String ffq;
  public String kRU;
  public String kRX;
  public boolean kSk;
  public String kUa;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kUa == null) {
        throw new b("Not all required fields were included: Lang");
      }
      if (this.kRX == null) {
        throw new b("Not all required fields were included: AppID");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.kUa != null) {
        paramVarArgs.d(2, this.kUa);
      }
      if (this.kRX != null) {
        paramVarArgs.d(3, this.kRX);
      }
      if (this.kRU != null) {
        paramVarArgs.d(4, this.kRU);
      }
      if (this.ffq != null) {
        paramVarArgs.d(5, this.ffq);
      }
      paramVarArgs.aA(6, this.kSk);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label593;
      }
    }
    label593:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kUa != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kUa);
      }
      i = paramInt;
      if (this.kRX != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRX);
      }
      paramInt = i;
      if (this.kRU != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRU);
      }
      i = paramInt;
      if (this.ffq != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.ffq);
      }
      return i + (d.a.a.b.b.a.dQ(6) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.kUa == null) {
          throw new b("Not all required fields were included: Lang");
        }
        if (this.kRX != null) {
          break;
        }
        throw new b("Not all required fields were included: AppID");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        dd localdd = (dd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localdd.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localdd.kUa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localdd.kRX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localdd.kRU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localdd.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localdd.kSk = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dd
 * JD-Core Version:    0.7.0.1
 */