package com.tencent.mm.k.a.a;

import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bv.a
{
  public int bSZ;
  public int bcw;
  public int dng;
  public LinkedList<b> dtH = new LinkedList();
  public String dtI;
  public int dtJ;
  public int status;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.dtH);
      paramVarArgs.gB(2, this.bcw);
      paramVarArgs.gB(3, this.type);
      paramVarArgs.gB(4, this.status);
      paramVarArgs.gB(5, this.dng);
      if (this.dtI != null) {
        paramVarArgs.d(6, this.dtI);
      }
      paramVarArgs.gB(7, this.bSZ);
      paramVarArgs.gB(8, this.dtJ);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.c(1, 8, this.dtH) + 0 + d.a.a.a.gy(2, this.bcw) + d.a.a.a.gy(3, this.type) + d.a.a.a.gy(4, this.status) + d.a.a.a.gy(5, this.dng);
      paramInt = i;
      if (this.dtI != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.dtI);
      }
      return paramInt + d.a.a.a.gy(7, this.bSZ) + d.a.a.a.gy(8, this.dtJ);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.dtH.clear();
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
      a locala = (a)paramVarArgs[1];
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
          localObject1 = new b();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((b)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locala.dtH.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        locala.bcw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        locala.type = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        locala.status = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        locala.dng = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        locala.dtI = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        locala.bSZ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      locala.dtJ = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.k.a.a.a
 * JD-Core Version:    0.7.0.1
 */