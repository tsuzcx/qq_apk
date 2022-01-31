package com.tencent.mm.az;

import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bv.a
{
  public int ewA;
  public int ewB;
  public String ewC;
  public String ewD;
  public int ewE;
  public int ewF;
  public int ewG;
  public LinkedList<e> ewx = new LinkedList();
  public int ewy;
  public int ewz;
  public int maxSize;
  public String name;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.ewx);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      paramVarArgs.gB(3, this.ewy);
      paramVarArgs.gB(4, this.ewz);
      paramVarArgs.gB(5, this.ewA);
      paramVarArgs.gB(6, this.ewB);
      if (this.ewC != null) {
        paramVarArgs.d(7, this.ewC);
      }
      if (this.ewD != null) {
        paramVarArgs.d(8, this.ewD);
      }
      paramVarArgs.gB(9, this.ewE);
      paramVarArgs.gB(10, this.ewF);
      paramVarArgs.gB(11, this.ewG);
      paramVarArgs.gB(12, this.maxSize);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.c(1, 8, this.ewx) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt + d.a.a.a.gy(3, this.ewy) + d.a.a.a.gy(4, this.ewz) + d.a.a.a.gy(5, this.ewA) + d.a.a.a.gy(6, this.ewB);
      paramInt = i;
      if (this.ewC != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.ewC);
      }
      i = paramInt;
      if (this.ewD != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.ewD);
      }
      return i + d.a.a.a.gy(9, this.ewE) + d.a.a.a.gy(10, this.ewF) + d.a.a.a.gy(11, this.ewG) + d.a.a.a.gy(12, this.maxSize);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ewx.clear();
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
      d locald = (d)paramVarArgs[1];
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
          localObject1 = new e();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locald.ewx.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        locald.name = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        locald.ewy = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        locald.ewz = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        locald.ewA = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        locald.ewB = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        locald.ewC = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 8: 
        locald.ewD = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 9: 
        locald.ewE = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 10: 
        locald.ewF = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 11: 
        locald.ewG = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      locald.maxSize = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.az.d
 * JD-Core Version:    0.7.0.1
 */