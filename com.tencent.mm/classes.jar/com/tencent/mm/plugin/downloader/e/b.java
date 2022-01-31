package com.tencent.mm.plugin.downloader.e;

import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.gc;
import java.util.LinkedList;

public final class b
  extends blm
{
  public LinkedList<String> iPZ = new LinkedList();
  public boolean iQa;
  public boolean iQb;
  public boolean iQc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.d(2, 1, this.iPZ);
      paramVarArgs.aA(3, this.iQa);
      paramVarArgs.aA(4, this.iQb);
      paramVarArgs.aA(5, this.iQc);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label420;
      }
    }
    label420:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.c(2, 1, this.iPZ) + (d.a.a.b.b.a.dQ(3) + 1) + (d.a.a.b.b.a.dQ(4) + 1) + (d.a.a.b.b.a.dQ(5) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.iPZ.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localb.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localb.iPZ.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 3: 
          localb.iQa = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 4: 
          localb.iQb = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localb.iQc = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.b
 * JD-Core Version:    0.7.0.1
 */