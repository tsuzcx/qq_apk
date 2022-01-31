package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class ag
  extends com.tencent.mm.bv.a
{
  public String kSs;
  public String kSt;
  public LinkedList<cw> kTw = new LinkedList();
  public String kTx;
  public String kTy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSt != null) {
        paramVarArgs.d(1, this.kSt);
      }
      paramVarArgs.d(2, 8, this.kTw);
      if (this.kTx != null) {
        paramVarArgs.d(3, this.kTx);
      }
      if (this.kTy != null) {
        paramVarArgs.d(4, this.kTy);
      }
      if (this.kSs != null) {
        paramVarArgs.d(5, this.kSs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSt == null) {
        break label477;
      }
    }
    label477:
    for (paramInt = d.a.a.b.b.a.e(1, this.kSt) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.kTw);
      paramInt = i;
      if (this.kTx != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.kTx);
      }
      i = paramInt;
      if (this.kTy != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kTy);
      }
      paramInt = i;
      if (this.kSs != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.kSs);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kTw.clear();
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
        ag localag = (ag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localag.kSt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localag.kTw.add(localObject1);
            paramInt += 1;
          }
        case 3: 
          localag.kTx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localag.kTy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localag.kSs = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ag
 * JD-Core Version:    0.7.0.1
 */