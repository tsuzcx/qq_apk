package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class x
  extends com.tencent.mm.bv.a
{
  public String kRN;
  public e kRQ;
  public LinkedList<String> kSZ = new LinkedList();
  public String kTa;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRQ != null)
      {
        paramVarArgs.gD(1, this.kRQ.btq());
        this.kRQ.a(paramVarArgs);
      }
      paramVarArgs.d(2, 1, this.kSZ);
      if (this.kTa != null) {
        paramVarArgs.d(3, this.kTa);
      }
      if (this.kRN != null) {
        paramVarArgs.d(4, this.kRN);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRQ == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = d.a.a.a.gA(1, this.kRQ.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 1, this.kSZ);
      paramInt = i;
      if (this.kTa != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.kTa);
      }
      i = paramInt;
      if (this.kRN != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kRN);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kSZ.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        x localx = (x)paramVarArgs[1];
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
            localObject1 = new e();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localx.kRQ = ((e)localObject1);
            paramInt += 1;
          }
        case 2: 
          localx.kSZ.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 3: 
          localx.kTa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localx.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.x
 * JD-Core Version:    0.7.0.1
 */