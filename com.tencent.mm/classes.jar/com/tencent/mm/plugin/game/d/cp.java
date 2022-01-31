package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class cp
  extends com.tencent.mm.bv.a
{
  public LinkedList<cq> kVQ = new LinkedList();
  public String kVR;
  public String kVh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.kVQ);
      if (this.kVh != null) {
        paramVarArgs.d(2, this.kVh);
      }
      if (this.kVR != null) {
        paramVarArgs.d(3, this.kVR);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.c(1, 8, this.kVQ) + 0;
      paramInt = i;
      if (this.kVh != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kVh);
      }
      i = paramInt;
    } while (this.kVR == null);
    return paramInt + d.a.a.b.b.a.e(3, this.kVR);
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.kVQ.clear();
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
      cp localcp = (cp)paramVarArgs[1];
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
          localObject1 = new cq();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcp.kVQ.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        localcp.kVh = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localcp.kVR = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cp
 * JD-Core Version:    0.7.0.1
 */