package com.tencent.mm.plugin.game.d;

import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.gc;
import java.util.LinkedList;

public final class an
  extends blm
{
  public String kRX;
  public String kTb;
  public com.tencent.mm.bv.b kTd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRX == null) {
        throw new d.a.a.b("Not all required fields were included: AppID");
      }
      if (this.kTb == null) {
        throw new d.a.a.b("Not all required fields were included: GroupID");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.kRX != null) {
        paramVarArgs.d(2, this.kRX);
      }
      if (this.kTb != null) {
        paramVarArgs.d(3, this.kTb);
      }
      if (this.kTd != null) {
        paramVarArgs.b(4, this.kTd);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label503;
      }
    }
    label503:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRX != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRX);
      }
      i = paramInt;
      if (this.kTb != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kTb);
      }
      paramInt = i;
      if (this.kTd != null) {
        paramInt = i + d.a.a.a.a(4, this.kTd);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.kRX == null) {
          throw new d.a.a.b("Not all required fields were included: AppID");
        }
        if (this.kTb != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: GroupID");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        an localan = (an)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localan.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localan.kRX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localan.kTb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localan.kTd = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.an
 * JD-Core Version:    0.7.0.1
 */