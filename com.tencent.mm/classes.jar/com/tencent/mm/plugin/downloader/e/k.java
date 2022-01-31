package com.tencent.mm.plugin.downloader.e;

import d.a.a.b;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.bv.a
{
  public e iQG;
  public f iQH;
  public h iQI;
  public j iQJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.iQG == null) {
        throw new b("Not all required fields were included: base_info");
      }
      if (this.iQG != null)
      {
        paramVarArgs.gD(1, this.iQG.btq());
        this.iQG.a(paramVarArgs);
      }
      if (this.iQH != null)
      {
        paramVarArgs.gD(2, this.iQH.btq());
        this.iQH.a(paramVarArgs);
      }
      if (this.iQI != null)
      {
        paramVarArgs.gD(3, this.iQI.btq());
        this.iQI.a(paramVarArgs);
      }
      if (this.iQJ != null)
      {
        paramVarArgs.gD(4, this.iQJ.btq());
        this.iQJ.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.iQG == null) {
        break label748;
      }
    }
    label748:
    for (int i = d.a.a.a.gA(1, this.iQG.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iQH != null) {
        paramInt = i + d.a.a.a.gA(2, this.iQH.btq());
      }
      i = paramInt;
      if (this.iQI != null) {
        i = paramInt + d.a.a.a.gA(3, this.iQI.btq());
      }
      paramInt = i;
      if (this.iQJ != null) {
        paramInt = i + d.a.a.a.gA(4, this.iQJ.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.iQG != null) {
          break;
        }
        throw new b("Not all required fields were included: base_info");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
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
            localObject1 = new e();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localk.iQG = ((e)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localk.iQH = ((f)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new h();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((h)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localk.iQI = ((h)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new j();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((j)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localk.iQJ = ((j)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.k
 * JD-Core Version:    0.7.0.1
 */