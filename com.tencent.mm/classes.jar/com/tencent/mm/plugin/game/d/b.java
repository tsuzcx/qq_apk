package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public e kRQ;
  public String kRR;
  public String kRS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRR == null) {
        throw new d.a.a.b("Not all required fields were included: AdURL");
      }
      if (this.kRQ != null)
      {
        paramVarArgs.gD(1, this.kRQ.btq());
        this.kRQ.a(paramVarArgs);
      }
      if (this.kRR != null) {
        paramVarArgs.d(2, this.kRR);
      }
      if (this.kRS != null) {
        paramVarArgs.d(3, this.kRS);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRQ == null) {
        break label415;
      }
    }
    label415:
    for (int i = d.a.a.a.gA(1, this.kRQ.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRR != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRR);
      }
      i = paramInt;
      if (this.kRS != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRS);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.kRR != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: AdURL");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
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
            localObject1 = new e();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localb.kRQ = ((e)localObject1);
            paramInt += 1;
          }
        case 2: 
          localb.kRR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localb.kRS = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.b
 * JD-Core Version:    0.7.0.1
 */