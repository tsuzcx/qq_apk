package com.tencent.mm.ae;

import java.util.LinkedList;

public class j
  extends com.tencent.mm.bv.a
{
  public String bYG;
  public String bYH;
  public String cQF;
  public LinkedList<m> dTx = new LinkedList();
  public int dTy;
  public String name;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.type);
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.bYG != null) {
        paramVarArgs.d(3, this.bYG);
      }
      if (this.bYH != null) {
        paramVarArgs.d(4, this.bYH);
      }
      if (this.cQF != null) {
        paramVarArgs.d(5, this.cQF);
      }
      paramVarArgs.d(6, 8, this.dTx);
      paramVarArgs.gB(7, this.dTy);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.type) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.bYG != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bYG);
      }
      paramInt = i;
      if (this.bYH != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.bYH);
      }
      i = paramInt;
      if (this.cQF != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.cQF);
      }
      return i + d.a.a.a.c(6, 8, this.dTx) + d.a.a.a.gy(7, this.dTy);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.dTx.clear();
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
      j localj = (j)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localj.type = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localj.name = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localj.bYG = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localj.bYH = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        localj.cQF = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new m();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((m)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localj.dTx.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localj.dTy = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ae.j
 * JD-Core Version:    0.7.0.1
 */