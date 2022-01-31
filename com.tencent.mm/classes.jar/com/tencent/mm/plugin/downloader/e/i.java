package com.tencent.mm.plugin.downloader.e;

import d.a.a.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bv.a
{
  public g iQA;
  public k iQy;
  public a iQz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.iQy == null) {
        throw new b("Not all required fields were included: app_info");
      }
      if (this.iQy != null)
      {
        paramVarArgs.gD(1, this.iQy.btq());
        this.iQy.a(paramVarArgs);
      }
      if (this.iQz != null)
      {
        paramVarArgs.gD(2, this.iQz.btq());
        this.iQz.a(paramVarArgs);
      }
      if (this.iQA != null)
      {
        paramVarArgs.gD(3, this.iQA.btq());
        this.iQA.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.iQy == null) {
        break label599;
      }
    }
    label599:
    for (int i = d.a.a.a.gA(1, this.iQy.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iQz != null) {
        paramInt = i + d.a.a.a.gA(2, this.iQz.btq());
      }
      i = paramInt;
      if (this.iQA != null) {
        i = paramInt + d.a.a.a.gA(3, this.iQA.btq());
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.iQy != null) {
          break;
        }
        throw new b("Not all required fields were included: app_info");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
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
            localObject1 = new k();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((k)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locali.iQy = ((k)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locali.iQz = ((a)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((g)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locali.iQA = ((g)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.i
 * JD-Core Version:    0.7.0.1
 */