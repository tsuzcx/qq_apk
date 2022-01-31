package com.tencent.mm.plugin.backup.i;

import d.a.a.b;
import java.util.LinkedList;

public final class r
  extends com.tencent.mm.bv.a
{
  public String ID;
  public LinkedList<t> hQH = new LinkedList();
  public LinkedList<t> hQI = new LinkedList();
  public long hQp;
  public int hQs;
  public int hQt;
  public int hQu;
  public long hQv;
  public long hQw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ID == null) {
        throw new b("Not all required fields were included: ID");
      }
      if (this.ID != null) {
        paramVarArgs.d(1, this.ID);
      }
      paramVarArgs.gB(2, this.hQs);
      paramVarArgs.gB(3, this.hQt);
      paramVarArgs.gB(4, this.hQu);
      paramVarArgs.Y(5, this.hQp);
      paramVarArgs.Y(6, this.hQv);
      paramVarArgs.Y(7, this.hQw);
      paramVarArgs.d(8, 8, this.hQH);
      paramVarArgs.d(9, 8, this.hQI);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label707;
      }
    }
    label707:
    for (paramInt = d.a.a.b.b.a.e(1, this.ID) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.hQs) + d.a.a.a.gy(3, this.hQt) + d.a.a.a.gy(4, this.hQu) + d.a.a.a.X(5, this.hQp) + d.a.a.a.X(6, this.hQv) + d.a.a.a.X(7, this.hQw) + d.a.a.a.c(8, 8, this.hQH) + d.a.a.a.c(9, 8, this.hQI);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hQH.clear();
        this.hQI.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.ID != null) {
          break;
        }
        throw new b("Not all required fields were included: ID");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localr.ID = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localr.hQs = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localr.hQt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localr.hQu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localr.hQp = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localr.hQv = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 7: 
          localr.hQw = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localr.hQH.add(localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new t();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((t)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localr.hQI.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.r
 * JD-Core Version:    0.7.0.1
 */