package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.gc;
import d.a.a.b;
import java.util.LinkedList;

public final class bm
  extends blm
{
  public String ffq;
  public int kUT;
  public int kUU;
  public String kUa;
  public int kVb;
  public int kVc;
  
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
      paramVarArgs.gB(2, this.kUT);
      paramVarArgs.gB(3, this.kUU);
      if (this.kUa != null) {
        paramVarArgs.d(4, this.kUa);
      }
      paramVarArgs.gB(5, this.kVb);
      paramVarArgs.gB(6, this.kVc);
      if (this.ffq != null) {
        paramVarArgs.d(7, this.ffq);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label571;
      }
    }
    label571:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.kUT) + d.a.a.a.gy(3, this.kUU);
      paramInt = i;
      if (this.kUa != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kUa);
      }
      i = paramInt + d.a.a.a.gy(5, this.kVb) + d.a.a.a.gy(6, this.kVc);
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.ffq);
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
        bm localbm = (bm)paramVarArgs[1];
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
            localbm.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbm.kUT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbm.kUU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbm.kUa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbm.kVb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbm.kVc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbm.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bm
 * JD-Core Version:    0.7.0.1
 */