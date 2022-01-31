package com.tencent.mm.plugin.downloader.e;

import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bv.a
{
  public d iQv;
  public boolean iQw;
  public int iQx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.iQv != null)
      {
        paramVarArgs.gD(1, this.iQv.btq());
        this.iQv.a(paramVarArgs);
      }
      paramVarArgs.aA(3, this.iQw);
      paramVarArgs.gB(4, this.iQx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iQv == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = d.a.a.a.gA(1, this.iQv.btq()) + 0;; paramInt = 0)
    {
      return paramInt + (d.a.a.b.b.a.dQ(3) + 1) + d.a.a.a.gy(4, this.iQx);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localh.iQv = ((d)localObject1);
            paramInt += 1;
          }
        case 3: 
          localh.iQw = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localh.iQx = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.h
 * JD-Core Version:    0.7.0.1
 */