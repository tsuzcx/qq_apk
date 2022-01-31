package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.gd;
import d.a.a.b;
import java.util.LinkedList;

public final class de
  extends bly
{
  public String bGw;
  public boolean kSf;
  public String kSz;
  public k kWk;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.kSz == null) {
        throw new b("Not all required fields were included: Message");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.aA(2, this.kSf);
      if (this.bGw != null) {
        paramVarArgs.d(3, this.bGw);
      }
      if (this.kSz != null) {
        paramVarArgs.d(4, this.kSz);
      }
      if (this.kWk != null)
      {
        paramVarArgs.gD(5, this.kWk.btq());
        this.kWk.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label664;
      }
    }
    label664:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 1);
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.bGw);
      }
      i = paramInt;
      if (this.kSz != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kSz);
      }
      paramInt = i;
      if (this.kWk != null) {
        paramInt = i + d.a.a.a.gA(5, this.kWk.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.bGw == null) {
          throw new b("Not all required fields were included: Title");
        }
        if (this.kSz != null) {
          break;
        }
        throw new b("Not all required fields were included: Message");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        de localde = (de)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localde.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localde.kSf = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 3: 
          localde.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localde.kSz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localde.kWk = ((k)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.de
 * JD-Core Version:    0.7.0.1
 */