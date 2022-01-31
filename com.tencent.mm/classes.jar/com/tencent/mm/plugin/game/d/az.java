package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.gd;
import d.a.a.b;
import java.util.LinkedList;

public final class az
  extends bly
{
  public e kRQ;
  public String kUp;
  public LinkedList<u> kUq = new LinkedList();
  public ce kUr;
  public bu kUs;
  public br kUt;
  public cu kUu;
  public LinkedList<v> kUv = new LinkedList();
  public cz kUw;
  public bt kUx;
  public bq kUy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.kRQ == null) {
        throw new b("Not all required fields were included: AppItem");
      }
      if (this.kUp == null) {
        throw new b("Not all required fields were included: BackGroundURL");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.kRQ != null)
      {
        paramVarArgs.gD(2, this.kRQ.btq());
        this.kRQ.a(paramVarArgs);
      }
      if (this.kUp != null) {
        paramVarArgs.d(3, this.kUp);
      }
      paramVarArgs.d(4, 8, this.kUq);
      if (this.kUr != null)
      {
        paramVarArgs.gD(5, this.kUr.btq());
        this.kUr.a(paramVarArgs);
      }
      if (this.kUs != null)
      {
        paramVarArgs.gD(7, this.kUs.btq());
        this.kUs.a(paramVarArgs);
      }
      if (this.kUt != null)
      {
        paramVarArgs.gD(8, this.kUt.btq());
        this.kUt.a(paramVarArgs);
      }
      if (this.kUu != null)
      {
        paramVarArgs.gD(9, this.kUu.btq());
        this.kUu.a(paramVarArgs);
      }
      paramVarArgs.d(10, 8, this.kUv);
      if (this.kUw != null)
      {
        paramVarArgs.gD(11, this.kUw.btq());
        this.kUw.a(paramVarArgs);
      }
      if (this.kUx != null)
      {
        paramVarArgs.gD(12, this.kUx.btq());
        this.kUx.a(paramVarArgs);
      }
      if (this.kUy != null)
      {
        paramVarArgs.gD(13, this.kUy.btq());
        this.kUy.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1890;
      }
    }
    label1890:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRQ != null) {
        paramInt = i + d.a.a.a.gA(2, this.kRQ.btq());
      }
      i = paramInt;
      if (this.kUp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kUp);
      }
      i += d.a.a.a.c(4, 8, this.kUq);
      paramInt = i;
      if (this.kUr != null) {
        paramInt = i + d.a.a.a.gA(5, this.kUr.btq());
      }
      i = paramInt;
      if (this.kUs != null) {
        i = paramInt + d.a.a.a.gA(7, this.kUs.btq());
      }
      paramInt = i;
      if (this.kUt != null) {
        paramInt = i + d.a.a.a.gA(8, this.kUt.btq());
      }
      i = paramInt;
      if (this.kUu != null) {
        i = paramInt + d.a.a.a.gA(9, this.kUu.btq());
      }
      i += d.a.a.a.c(10, 8, this.kUv);
      paramInt = i;
      if (this.kUw != null) {
        paramInt = i + d.a.a.a.gA(11, this.kUw.btq());
      }
      i = paramInt;
      if (this.kUx != null) {
        i = paramInt + d.a.a.a.gA(12, this.kUx.btq());
      }
      paramInt = i;
      if (this.kUy != null) {
        paramInt = i + d.a.a.a.gA(13, this.kUy.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kUq.clear();
        this.kUv.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.kRQ == null) {
          throw new b("Not all required fields were included: AppItem");
        }
        if (this.kUp != null) {
          break;
        }
        throw new b("Not all required fields were included: BackGroundURL");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        az localaz = (az)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 6: 
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
            localaz.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaz.kRQ = ((e)localObject1);
            paramInt += 1;
          }
        case 3: 
          localaz.kUp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new u();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((u)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaz.kUq.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ce();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ce)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaz.kUr = ((ce)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bu();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaz.kUs = ((bu)localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new br();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((br)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaz.kUt = ((br)localObject1);
            paramInt += 1;
          }
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cu();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaz.kUu = ((cu)localObject1);
            paramInt += 1;
          }
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new v();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((v)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaz.kUv.add(localObject1);
            paramInt += 1;
          }
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaz.kUw = ((cz)localObject1);
            paramInt += 1;
          }
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bt();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaz.kUx = ((bt)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bq();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localaz.kUy = ((bq)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.az
 * JD-Core Version:    0.7.0.1
 */