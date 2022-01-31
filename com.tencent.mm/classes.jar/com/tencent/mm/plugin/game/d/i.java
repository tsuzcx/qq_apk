package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bv.a
{
  public String kSs;
  public String kSt;
  public int kSu;
  public a kSv;
  public da kSw;
  public int kSx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSt != null) {
        paramVarArgs.d(1, this.kSt);
      }
      paramVarArgs.gB(2, this.kSu);
      if (this.kSv != null)
      {
        paramVarArgs.gD(3, this.kSv.btq());
        this.kSv.a(paramVarArgs);
      }
      if (this.kSw != null)
      {
        paramVarArgs.gD(4, this.kSw.btq());
        this.kSw.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.kSx);
      if (this.kSs != null) {
        paramVarArgs.d(6, this.kSs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSt == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = d.a.a.b.b.a.e(1, this.kSt) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.kSu);
      paramInt = i;
      if (this.kSv != null) {
        paramInt = i + d.a.a.a.gA(3, this.kSv.btq());
      }
      i = paramInt;
      if (this.kSw != null) {
        i = paramInt + d.a.a.a.gA(4, this.kSw.btq());
      }
      i += d.a.a.a.gy(5, this.kSx);
      paramInt = i;
      if (this.kSs != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kSs);
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
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          locali.kSt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          locali.kSu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locali.kSv = ((a)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new da();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((da)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locali.kSw = ((da)localObject1);
            paramInt += 1;
          }
        case 5: 
          locali.kSx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        locali.kSs = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.i
 * JD-Core Version:    0.7.0.1
 */