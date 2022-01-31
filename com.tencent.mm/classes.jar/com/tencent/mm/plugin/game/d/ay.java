package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.gc;
import d.a.a.b;
import java.util.LinkedList;

public final class ay
  extends blm
{
  public String ffq;
  public String kRX;
  public String kUa;
  public boolean kUm;
  public boolean kUn;
  public boolean kUo;
  
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
      paramVarArgs.aA(4, this.kUm);
      if (this.ffq != null) {
        paramVarArgs.d(5, this.ffq);
      }
      paramVarArgs.aA(6, this.kUn);
      paramVarArgs.aA(7, this.kUo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label606;
      }
    }
    label606:
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
      i += d.a.a.b.b.a.dQ(4) + 1;
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.ffq);
      }
      return paramInt + (d.a.a.b.b.a.dQ(6) + 1) + (d.a.a.b.b.a.dQ(7) + 1);
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
        ay localay = (ay)paramVarArgs[1];
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
            localay.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localay.kUa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localay.kRX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localay.kUm = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 5: 
          localay.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localay.kUn = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localay.kUo = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ay
 * JD-Core Version:    0.7.0.1
 */