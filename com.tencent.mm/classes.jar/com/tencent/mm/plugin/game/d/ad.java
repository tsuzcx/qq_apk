package com.tencent.mm.plugin.game.d;

import d.a.a.b;
import java.util.LinkedList;

public final class ad
  extends com.tencent.mm.bv.a
{
  public String kRN;
  public e kRQ;
  public af kTu;
  public ae kTv;
  
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
      if (this.kTu != null)
      {
        paramVarArgs.gD(2, this.kTu.btq());
        this.kTu.a(paramVarArgs);
      }
      if (this.kTv != null)
      {
        paramVarArgs.gD(3, this.kTv.btq());
        this.kTv.a(paramVarArgs);
      }
      if (this.kRN != null) {
        paramVarArgs.d(4, this.kRN);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRQ == null) {
        break label654;
      }
    }
    label654:
    for (int i = d.a.a.a.gA(1, this.kRQ.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kTu != null) {
        paramInt = i + d.a.a.a.gA(2, this.kTu.btq());
      }
      i = paramInt;
      if (this.kTv != null) {
        i = paramInt + d.a.a.a.gA(3, this.kTv.btq());
      }
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRN);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        ad localad = (ad)paramVarArgs[1];
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
            localad.kRQ = ((e)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new af();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((af)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localad.kTu = ((af)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ae();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ae)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localad.kTv = ((ae)localObject1);
            paramInt += 1;
          }
        }
        localad.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ad
 * JD-Core Version:    0.7.0.1
 */