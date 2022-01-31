package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.gd;
import d.a.a.b;
import java.util.LinkedList;

public final class ax
  extends bly
{
  public boolean kUd;
  public aj kUe;
  public String kUf;
  public ab kUg;
  public f kUh;
  public dc kUi;
  public m kUj;
  public dm kUk;
  public r kUl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.aA(2, this.kUd);
      if (this.kUe != null)
      {
        paramVarArgs.gD(3, this.kUe.btq());
        this.kUe.a(paramVarArgs);
      }
      if (this.kUf != null) {
        paramVarArgs.d(4, this.kUf);
      }
      if (this.kUg != null)
      {
        paramVarArgs.gD(6, this.kUg.btq());
        this.kUg.a(paramVarArgs);
      }
      if (this.kUh != null)
      {
        paramVarArgs.gD(7, this.kUh.btq());
        this.kUh.a(paramVarArgs);
      }
      if (this.kUi != null)
      {
        paramVarArgs.gD(8, this.kUi.btq());
        this.kUi.a(paramVarArgs);
      }
      if (this.kUj != null)
      {
        paramVarArgs.gD(11, this.kUj.btq());
        this.kUj.a(paramVarArgs);
      }
      if (this.kUk != null)
      {
        paramVarArgs.gD(12, this.kUk.btq());
        this.kUk.a(paramVarArgs);
      }
      if (this.kUl != null)
      {
        paramVarArgs.gD(13, this.kUl.btq());
        this.kUl.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1447;
      }
    }
    label1447:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 1);
      paramInt = i;
      if (this.kUe != null) {
        paramInt = i + d.a.a.a.gA(3, this.kUe.btq());
      }
      i = paramInt;
      if (this.kUf != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kUf);
      }
      paramInt = i;
      if (this.kUg != null) {
        paramInt = i + d.a.a.a.gA(6, this.kUg.btq());
      }
      i = paramInt;
      if (this.kUh != null) {
        i = paramInt + d.a.a.a.gA(7, this.kUh.btq());
      }
      paramInt = i;
      if (this.kUi != null) {
        paramInt = i + d.a.a.a.gA(8, this.kUi.btq());
      }
      i = paramInt;
      if (this.kUj != null) {
        i = paramInt + d.a.a.a.gA(11, this.kUj.btq());
      }
      paramInt = i;
      if (this.kUk != null) {
        paramInt = i + d.a.a.a.gA(12, this.kUk.btq());
      }
      i = paramInt;
      if (this.kUl != null) {
        i = paramInt + d.a.a.a.gA(13, this.kUl.btq());
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ax localax = (ax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 9: 
        case 10: 
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
            localax.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localax.kUd = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localax.kUe = ((aj)localObject1);
            paramInt += 1;
          }
        case 4: 
          localax.kUf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ab();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ab)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localax.kUg = ((ab)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localax.kUh = ((f)localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localax.kUi = ((dc)localObject1);
            paramInt += 1;
          }
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localax.kUj = ((m)localObject1);
            paramInt += 1;
          }
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dm();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dm)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localax.kUk = ((dm)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new r();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((r)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localax.kUl = ((r)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ax
 * JD-Core Version:    0.7.0.1
 */