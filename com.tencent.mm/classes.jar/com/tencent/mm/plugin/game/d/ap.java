package com.tencent.mm.plugin.game.d;

import d.a.a.b;
import java.util.LinkedList;

public final class ap
  extends com.tencent.mm.bv.a
{
  public e kRQ;
  public String kRU;
  public String kSs;
  public LinkedList<aq> kTO = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRQ == null) {
        throw new b("Not all required fields were included: AppItem");
      }
      if (this.kRQ != null)
      {
        paramVarArgs.gD(1, this.kRQ.btq());
        this.kRQ.a(paramVarArgs);
      }
      if (this.kRU != null) {
        paramVarArgs.d(2, this.kRU);
      }
      paramVarArgs.d(3, 8, this.kTO);
      if (this.kSs != null) {
        paramVarArgs.d(4, this.kSs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRQ == null) {
        break label548;
      }
    }
    label548:
    for (paramInt = d.a.a.a.gA(1, this.kRQ.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kRU != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kRU);
      }
      i += d.a.a.a.c(3, 8, this.kTO);
      paramInt = i;
      if (this.kSs != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSs);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kTO.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.kRQ != null) {
          break;
        }
        throw new b("Not all required fields were included: AppItem");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
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
            localObject1 = new e();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localap.kRQ = ((e)localObject1);
            paramInt += 1;
          }
        case 2: 
          localap.kRU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localap.kTO.add(localObject1);
            paramInt += 1;
          }
        }
        localap.kSs = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ap
 * JD-Core Version:    0.7.0.1
 */