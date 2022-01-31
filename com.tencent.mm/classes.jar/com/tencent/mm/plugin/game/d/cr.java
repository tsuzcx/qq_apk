package com.tencent.mm.plugin.game.d;

import java.util.LinkedList;

public final class cr
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String euK;
  public String kRN;
  public String kRO;
  public e kRQ;
  public String kTZ;
  public String kTa;
  public LinkedList<w> kVS = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      if (this.kRO != null) {
        paramVarArgs.d(3, this.kRO);
      }
      if (this.kRN != null) {
        paramVarArgs.d(4, this.kRN);
      }
      if (this.kTZ != null) {
        paramVarArgs.d(5, this.kTZ);
      }
      if (this.kRQ != null)
      {
        paramVarArgs.gD(6, this.kRQ.btq());
        this.kRQ.a(paramVarArgs);
      }
      paramVarArgs.d(7, 8, this.kVS);
      if (this.kTa != null) {
        paramVarArgs.d(8, this.kTa);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label740;
      }
    }
    label740:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt;
      if (this.kRO != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRO);
      }
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRN);
      }
      i = paramInt;
      if (this.kTZ != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kTZ);
      }
      paramInt = i;
      if (this.kRQ != null) {
        paramInt = i + d.a.a.a.gA(6, this.kRQ.btq());
      }
      i = paramInt + d.a.a.a.c(7, 8, this.kVS);
      paramInt = i;
      if (this.kTa != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.kTa);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kVS.clear();
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
        cr localcr = (cr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localcr.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localcr.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcr.kRO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localcr.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localcr.kTZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcr.kRQ = ((e)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new w();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((w)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcr.kVS.add(localObject1);
            paramInt += 1;
          }
        }
        localcr.kTa = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cr
 * JD-Core Version:    0.7.0.1
 */