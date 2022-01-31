package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.gc;
import d.a.a.b;
import java.util.LinkedList;

public final class bi
  extends blm
{
  public String ffq;
  public LinkedList<String> kUD = new LinkedList();
  public s kUE;
  public int kUF;
  public boolean kUG;
  public String kUa;
  public int kUb;
  
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
      paramVarArgs.d(3, 1, this.kUD);
      if (this.ffq != null) {
        paramVarArgs.d(4, this.ffq);
      }
      if (this.kUE != null)
      {
        paramVarArgs.gD(5, this.kUE.btq());
        this.kUE.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.kUF);
      paramVarArgs.aA(7, this.kUG);
      paramVarArgs.gB(8, this.kUb);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label729;
      }
    }
    label729:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kUa != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kUa);
      }
      i += d.a.a.a.c(3, 1, this.kUD);
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ffq);
      }
      i = paramInt;
      if (this.kUE != null) {
        i = paramInt + d.a.a.a.gA(5, this.kUE.btq());
      }
      return i + d.a.a.a.gy(6, this.kUF) + (d.a.a.b.b.a.dQ(7) + 1) + d.a.a.a.gy(8, this.kUb);
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
        bi localbi = (bi)paramVarArgs[1];
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
            localbi.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbi.kUa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbi.kUD.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 4: 
          localbi.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new s();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((s)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbi.kUE = ((s)localObject1);
            paramInt += 1;
          }
        case 6: 
          localbi.kUF = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbi.kUG = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localbi.kUb = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bi
 * JD-Core Version:    0.7.0.1
 */