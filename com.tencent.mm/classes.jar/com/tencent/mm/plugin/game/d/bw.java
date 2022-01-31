package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class bw
  extends com.tencent.mm.bv.a
{
  public String kRP;
  public String kRX;
  public cf kSl;
  public String kVm;
  public String kVn;
  public String kVo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRX != null) {
        paramVarArgs.d(1, this.kRX);
      }
      if (this.kVm != null) {
        paramVarArgs.d(2, this.kVm);
      }
      if (this.kVn != null) {
        paramVarArgs.d(3, this.kVn);
      }
      if (this.kVo != null) {
        paramVarArgs.d(4, this.kVo);
      }
      if (this.kSl != null)
      {
        paramVarArgs.gD(5, this.kSl.btq());
        this.kSl.a(paramVarArgs);
      }
      if (this.kRP != null) {
        paramVarArgs.d(6, this.kRP);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRX == null) {
        break label548;
      }
    }
    label548:
    for (int i = d.a.a.b.b.a.e(1, this.kRX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kVm != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kVm);
      }
      i = paramInt;
      if (this.kVn != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kVn);
      }
      paramInt = i;
      if (this.kVo != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kVo);
      }
      i = paramInt;
      if (this.kSl != null) {
        i = paramInt + d.a.a.a.gA(5, this.kSl.btq());
      }
      paramInt = i;
      if (this.kRP != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kRP);
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
        bw localbw = (bw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbw.kRX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbw.kVm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbw.kVn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbw.kVo = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cf();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cf)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbw.kSl = ((cf)localObject1);
            paramInt += 1;
          }
        }
        localbw.kRP = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bw
 * JD-Core Version:    0.7.0.1
 */