package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class ar
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public LinkedList<x> kSr = new LinkedList();
  public String kTQ;
  public String kTx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.kSr);
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.kTx != null) {
        paramVarArgs.d(3, this.kTx);
      }
      if (this.kTQ != null) {
        paramVarArgs.d(4, this.kTQ);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.c(1, 8, this.kSr) + 0;
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.kTx != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kTx);
      }
      paramInt = i;
    } while (this.kTQ == null);
    return i + d.a.a.b.b.a.e(4, this.kTQ);
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
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      ar localar = (ar)paramVarArgs[1];
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
          localObject1 = new x();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((x)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localar.kSr.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        localar.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localar.kTx = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localar.kTQ = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ar
 * JD-Core Version:    0.7.0.1
 */