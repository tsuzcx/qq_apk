package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class av
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String euK;
  public String kRO;
  public e kRQ;
  public String kSy;
  public LinkedList<String> kTW = new LinkedList();
  public String kTX;
  public String kTY;
  public String kTZ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kSy != null) {
        paramVarArgs.d(2, this.kSy);
      }
      paramVarArgs.d(3, 1, this.kTW);
      if (this.kTX != null) {
        paramVarArgs.d(4, this.kTX);
      }
      if (this.kRO != null) {
        paramVarArgs.d(5, this.kRO);
      }
      if (this.kTY != null) {
        paramVarArgs.d(6, this.kTY);
      }
      if (this.kTZ != null) {
        paramVarArgs.d(8, this.kTZ);
      }
      if (this.euK != null) {
        paramVarArgs.d(9, this.euK);
      }
      if (this.kRQ != null)
      {
        paramVarArgs.gD(10, this.kRQ.btq());
        this.kRQ.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label721;
      }
    }
    label721:
    for (paramInt = d.a.a.b.b.a.e(1, this.bGw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kSy != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kSy);
      }
      i += d.a.a.a.c(3, 1, this.kTW);
      paramInt = i;
      if (this.kTX != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kTX);
      }
      i = paramInt;
      if (this.kRO != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kRO);
      }
      paramInt = i;
      if (this.kTY != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kTY);
      }
      i = paramInt;
      if (this.kTZ != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.kTZ);
      }
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.euK);
      }
      i = paramInt;
      if (this.kRQ != null) {
        i = paramInt + d.a.a.a.gA(10, this.kRQ.btq());
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kTW.clear();
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
        av localav = (av)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        default: 
          return -1;
        case 1: 
          localav.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localav.kSy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localav.kTW.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 4: 
          localav.kTX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localav.kRO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localav.kTY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localav.kTZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localav.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localav.kRQ = ((e)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.av
 * JD-Core Version:    0.7.0.1
 */