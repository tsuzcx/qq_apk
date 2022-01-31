package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class cg
  extends com.tencent.mm.bv.a
{
  public LinkedList<b> kVA = new LinkedList();
  public cp kVB;
  public LinkedList<l> kVC = new LinkedList();
  public cl kVD;
  public LinkedList<db> kVE = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.kVA);
      if (this.kVB != null)
      {
        paramVarArgs.gD(2, this.kVB.btq());
        this.kVB.a(paramVarArgs);
      }
      paramVarArgs.d(3, 8, this.kVC);
      if (this.kVD != null)
      {
        paramVarArgs.gD(4, this.kVD.btq());
        this.kVD.a(paramVarArgs);
      }
      paramVarArgs.d(5, 8, this.kVE);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.c(1, 8, this.kVA) + 0;
      paramInt = i;
      if (this.kVB != null) {
        paramInt = i + d.a.a.a.gA(2, this.kVB.btq());
      }
      i = paramInt + d.a.a.a.c(3, 8, this.kVC);
      paramInt = i;
      if (this.kVD != null) {
        paramInt = i + d.a.a.a.gA(4, this.kVD.btq());
      }
      return paramInt + d.a.a.a.c(5, 8, this.kVE);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.kVA.clear();
      this.kVC.clear();
      this.kVE.clear();
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
      cg localcg = (cg)paramVarArgs[1];
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
          localObject1 = new b();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcg.kVA.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cp();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcg.kVB = ((cp)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcg.kVC.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cl();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcg.kVD = ((cl)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new db();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((db)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localcg.kVE.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cg
 * JD-Core Version:    0.7.0.1
 */