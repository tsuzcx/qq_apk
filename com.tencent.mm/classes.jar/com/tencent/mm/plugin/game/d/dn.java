package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class dn
  extends com.tencent.mm.bv.a
{
  public String kSs;
  public do kWr;
  public aa kWs;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kWr != null)
      {
        paramVarArgs.gD(1, this.kWr.btq());
        this.kWr.a(paramVarArgs);
      }
      if (this.kWs != null)
      {
        paramVarArgs.gD(2, this.kWs.btq());
        this.kWs.a(paramVarArgs);
      }
      if (this.kSs != null) {
        paramVarArgs.d(3, this.kSs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWr == null) {
        break label473;
      }
    }
    label473:
    for (int i = d.a.a.a.gA(1, this.kWr.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kWs != null) {
        paramInt = i + d.a.a.a.gA(2, this.kWs.btq());
      }
      i = paramInt;
      if (this.kSs != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kSs);
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
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        dn localdn = (dn)paramVarArgs[1];
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
            localObject1 = new do();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((do)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localdn.kWr = ((do)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aa();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aa)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localdn.kWs = ((aa)localObject1);
            paramInt += 1;
          }
        }
        localdn.kSs = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dn
 * JD-Core Version:    0.7.0.1
 */