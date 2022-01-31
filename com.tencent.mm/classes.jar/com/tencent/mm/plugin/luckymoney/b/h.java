package com.tencent.mm.plugin.luckymoney.b;

import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bv.a
{
  public int kEe;
  public int lQe;
  public LinkedList<i> lQn = new LinkedList();
  public int lQt;
  public long lQu;
  public int lQv;
  public long lQw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.lQt);
      paramVarArgs.Y(2, this.lQu);
      paramVarArgs.gB(3, this.lQv);
      paramVarArgs.Y(4, this.lQw);
      paramVarArgs.gB(5, this.kEe);
      paramVarArgs.gB(6, this.lQe);
      paramVarArgs.d(7, 8, this.lQn);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.lQt) + 0 + d.a.a.a.X(2, this.lQu) + d.a.a.a.gy(3, this.lQv) + d.a.a.a.X(4, this.lQw) + d.a.a.a.gy(5, this.kEe) + d.a.a.a.gy(6, this.lQe) + d.a.a.a.c(7, 8, this.lQn);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.lQn.clear();
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
      h localh = (h)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localh.lQt = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localh.lQu = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 3: 
        localh.lQv = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localh.lQw = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 5: 
        localh.kEe = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        localh.lQe = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new i();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((i)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localh.lQn.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.h
 * JD-Core Version:    0.7.0.1
 */