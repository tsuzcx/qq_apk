package com.tencent.mm.plugin.exdevice.e;

import java.util.LinkedList;

public final class k
  extends i
{
  public com.tencent.mm.bv.b hPF;
  public int hQR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPF == null) {
        throw new d.a.a.b("Not all required fields were included: Data");
      }
      if (this.jxB != null)
      {
        paramVarArgs.gD(1, this.jxB.btq());
        this.jxB.a(paramVarArgs);
      }
      if (this.hPF != null) {
        paramVarArgs.b(2, this.hPF);
      }
      paramVarArgs.gB(3, this.hQR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jxB == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = d.a.a.a.gA(1, this.jxB.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hPF != null) {
        i = paramInt + d.a.a.a.a(2, this.hPF);
      }
      return i + d.a.a.a.gy(3, this.hQR);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.a(paramVarArgs); paramInt > 0; paramInt = i.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.hPF != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: Data");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
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
            localObject1 = new d();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, i.a((d.a.a.a.a)localObject2))) {}
            localk.jxB = ((d)localObject1);
            paramInt += 1;
          }
        case 2: 
          localk.hPF = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localk.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.k
 * JD-Core Version:    0.7.0.1
 */