package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class cx
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public LinkedList<am> kSr = new LinkedList();
  public String kTQ;
  public String kTx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      paramVarArgs.d(2, 8, this.kSr);
      if (this.kTx != null) {
        paramVarArgs.d(3, this.kTx);
      }
      if (this.kTQ != null) {
        paramVarArgs.d(4, this.kTQ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = d.a.a.b.b.a.e(1, this.bGw) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.kSr);
      paramInt = i;
      if (this.kTx != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.kTx);
      }
      i = paramInt;
      if (this.kTQ != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kTQ);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kSr.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        cx localcx = (cx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localcx.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new am();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((am)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcx.kSr.add(localObject1);
            paramInt += 1;
          }
        case 3: 
          localcx.kTx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localcx.kTQ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cx
 * JD-Core Version:    0.7.0.1
 */