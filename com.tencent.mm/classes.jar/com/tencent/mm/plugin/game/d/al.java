package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class al
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kSs;
  public String kTJ;
  public LinkedList<cs> kTK = new LinkedList();
  public do kTL;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kTJ != null) {
        paramVarArgs.d(1, this.kTJ);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      paramVarArgs.d(3, 8, this.kTK);
      if (this.kTL != null)
      {
        paramVarArgs.gD(4, this.kTL.btq());
        this.kTL.a(paramVarArgs);
      }
      if (this.kSs != null) {
        paramVarArgs.d(5, this.kSs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kTJ == null) {
        break label571;
      }
    }
    label571:
    for (paramInt = d.a.a.b.b.a.e(1, this.kTJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bGw != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bGw);
      }
      i += d.a.a.a.c(3, 8, this.kTK);
      paramInt = i;
      if (this.kTL != null) {
        paramInt = i + d.a.a.a.gA(4, this.kTL.btq());
      }
      i = paramInt;
      if (this.kSs != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kSs);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kTK.clear();
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
        al localal = (al)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localal.kTJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localal.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cs();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cs)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localal.kTK.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new do();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((do)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localal.kTL = ((do)localObject1);
            paramInt += 1;
          }
        }
        localal.kSs = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.al
 * JD-Core Version:    0.7.0.1
 */