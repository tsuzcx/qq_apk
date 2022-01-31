package com.tencent.mm.plugin.backup.i;

import d.a.a.b;
import java.util.LinkedList;

public final class o
  extends com.tencent.mm.bv.a
{
  public String ID;
  public long hQi;
  public m hQl;
  public int hQn;
  public long hQo;
  public long hQp;
  public int hQq;
  public int hQr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ID == null) {
        throw new b("Not all required fields were included: ID");
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.Y(2, this.hQo);
      paramVarArgs.Y(3, this.hQp);
      paramVarArgs.gB(4, this.hQq);
      paramVarArgs.gB(5, this.hQr);
      paramVarArgs.Y(6, this.hQi);
      if (this.hQl != null)
      {
        paramVarArgs.gD(7, this.hQl.btq());
        this.hQl.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.hQn);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = d.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.hQo) + d.a.a.a.X(3, this.hQp) + d.a.a.a.gy(4, this.hQq) + d.a.a.a.gy(5, this.hQr) + d.a.a.a.X(6, this.hQi);
      paramInt = i;
      if (this.hQl != null) {
        paramInt = i + d.a.a.a.gA(7, this.hQl.btq());
      }
      return paramInt + d.a.a.a.gy(8, this.hQn);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.ID != null) {
          break;
        }
        throw new b("Not all required fields were included: ID");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        o localo = (o)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localo.ID = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localo.hQo = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 3: 
          localo.hQp = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localo.hQq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localo.hQr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localo.hQi = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localo.hQl = ((m)localObject1);
            paramInt += 1;
          }
        }
        localo.hQn = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.o
 * JD-Core Version:    0.7.0.1
 */