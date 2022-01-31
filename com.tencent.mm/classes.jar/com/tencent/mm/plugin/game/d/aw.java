package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.gc;
import d.a.a.b;
import java.util.LinkedList;

public final class aw
  extends blm
{
  public String ffq;
  public String kUa;
  public int kUb;
  public d kUc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kUa == null) {
        throw new b("Not all required fields were included: Lang");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.kUa != null) {
        paramVarArgs.d(2, this.kUa);
      }
      if (this.ffq != null) {
        paramVarArgs.d(3, this.ffq);
      }
      paramVarArgs.gB(4, this.kUb);
      if (this.kUc != null)
      {
        paramVarArgs.gD(5, this.kUc.btq());
        this.kUc.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label603;
      }
    }
    label603:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kUa != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kUa);
      }
      i = paramInt;
      if (this.ffq != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ffq);
      }
      i += d.a.a.a.gy(4, this.kUb);
      paramInt = i;
      if (this.kUc != null) {
        paramInt = i + d.a.a.a.gA(5, this.kUc.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.kUa != null) {
          break;
        }
        throw new b("Not all required fields were included: Lang");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aw localaw = (aw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaw.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaw.kUa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaw.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaw.kUb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((d)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localaw.kUc = ((d)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.aw
 * JD-Core Version:    0.7.0.1
 */