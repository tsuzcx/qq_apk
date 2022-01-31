package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class cn
  extends com.tencent.mm.bv.a
{
  public String kSX;
  public co kVL;
  public co kVM;
  public co kVN;
  public co kVO;
  public co kVP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kVL != null)
      {
        paramVarArgs.gD(1, this.kVL.btq());
        this.kVL.a(paramVarArgs);
      }
      if (this.kVM != null)
      {
        paramVarArgs.gD(2, this.kVM.btq());
        this.kVM.a(paramVarArgs);
      }
      if (this.kVN != null)
      {
        paramVarArgs.gD(3, this.kVN.btq());
        this.kVN.a(paramVarArgs);
      }
      if (this.kVO != null)
      {
        paramVarArgs.gD(4, this.kVO.btq());
        this.kVO.a(paramVarArgs);
      }
      if (this.kVP != null)
      {
        paramVarArgs.gD(6, this.kVP.btq());
        this.kVP.a(paramVarArgs);
      }
      if (this.kSX != null) {
        paramVarArgs.d(5, this.kSX);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kVL == null) {
        break label916;
      }
    }
    label916:
    for (int i = d.a.a.a.gA(1, this.kVL.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kVM != null) {
        paramInt = i + d.a.a.a.gA(2, this.kVM.btq());
      }
      i = paramInt;
      if (this.kVN != null) {
        i = paramInt + d.a.a.a.gA(3, this.kVN.btq());
      }
      paramInt = i;
      if (this.kVO != null) {
        paramInt = i + d.a.a.a.gA(4, this.kVO.btq());
      }
      i = paramInt;
      if (this.kVP != null) {
        i = paramInt + d.a.a.a.gA(6, this.kVP.btq());
      }
      paramInt = i;
      if (this.kSX != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.kSX);
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
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cn localcn = (cn)paramVarArgs[1];
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
            localObject1 = new co();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcn.kVL = ((co)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcn.kVM = ((co)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcn.kVN = ((co)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcn.kVO = ((co)localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcn.kVP = ((co)localObject1);
            paramInt += 1;
          }
        }
        localcn.kSX = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cn
 * JD-Core Version:    0.7.0.1
 */