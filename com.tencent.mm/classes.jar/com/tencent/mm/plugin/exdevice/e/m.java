package com.tencent.mm.plugin.exdevice.e;

import d.a.a.b;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bv.a
{
  public c jxA;
  public int jxD;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jxA == null) {
        throw new b("Not all required fields were included: BasePush");
      }
      if (this.jxA != null)
      {
        paramVarArgs.gD(1, this.jxA.btq());
        this.jxA.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.jxD);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jxA == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = d.a.a.a.gA(1, this.jxA.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.jxD);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.jxA != null) {
          break;
        }
        throw new b("Not all required fields were included: BasePush");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new c();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((c)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localm.jxA = ((c)localObject1);
            paramInt += 1;
          }
        }
        localm.jxD = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.m
 * JD-Core Version:    0.7.0.1
 */