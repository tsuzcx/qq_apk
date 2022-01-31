package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.gc;
import d.a.a.b;
import java.util.LinkedList;

public final class bk
  extends blm
{
  public String ffq;
  public LinkedList<String> kUD = new LinkedList();
  public int kUT;
  public int kUU;
  public int kUV;
  public boolean kUW;
  public String kUa;
  
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
      paramVarArgs.d(5, 1, this.kUD);
      if (this.ffq != null) {
        paramVarArgs.d(6, this.ffq);
      }
      paramVarArgs.gB(7, this.kUV);
      paramVarArgs.aA(8, this.kUW);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label619;
      }
    }
    label619:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.kUT) + d.a.a.a.gy(3, this.kUU);
      paramInt = i;
      if (this.kUa != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kUa);
      }
      i = paramInt + d.a.a.a.c(5, 1, this.kUD);
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.ffq);
      }
      return paramInt + d.a.a.a.gy(7, this.kUV) + (d.a.a.b.b.a.dQ(8) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kUD.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        bk localbk = (bk)paramVarArgs[1];
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
            localbk.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbk.kUT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbk.kUU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbk.kUa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbk.kUD.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 6: 
          localbk.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbk.kUV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbk.kUW = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bk
 * JD-Core Version:    0.7.0.1
 */