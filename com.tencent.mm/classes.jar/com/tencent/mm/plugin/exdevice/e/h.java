package com.tencent.mm.plugin.exdevice.e;

import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b hPF;
  public int hQR;
  public c jxA;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jxA == null) {
        throw new d.a.a.b("Not all required fields were included: BasePush");
      }
      if (this.hPF == null) {
        throw new d.a.a.b("Not all required fields were included: Data");
      }
      if (this.jxA != null)
      {
        paramVarArgs.gD(1, this.jxA.btq());
        this.jxA.a(paramVarArgs);
      }
      if (this.hPF != null) {
        paramVarArgs.b(2, this.hPF);
      }
      paramVarArgs.gB(3, this.hQR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jxA == null) {
        break label428;
      }
    }
    label428:
    for (paramInt = d.a.a.a.gA(1, this.jxA.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hPF != null) {
        i = paramInt + d.a.a.a.a(2, this.hPF);
      }
      return i + d.a.a.a.gy(3, this.hQR);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.jxA == null) {
          throw new d.a.a.b("Not all required fields were included: BasePush");
        }
        if (this.hPF != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: Data");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
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
            localObject1 = new c();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((c)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localh.jxA = ((c)localObject1);
            paramInt += 1;
          }
        case 2: 
          localh.hPF = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localh.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.h
 * JD-Core Version:    0.7.0.1
 */