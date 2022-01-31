package com.tencent.mm.plugin.game.d;

import d.a.a.b;
import java.util.LinkedList;

public final class br
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public LinkedList<bs> kVf = new LinkedList();
  public String kVg;
  public String kVh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      paramVarArgs.d(2, 8, this.kVf);
      if (this.kVg != null) {
        paramVarArgs.d(3, this.kVg);
      }
      if (this.kVh != null) {
        paramVarArgs.d(4, this.kVh);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = d.a.a.b.b.a.e(1, this.bGw) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.kVf);
      paramInt = i;
      if (this.kVg != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.kVg);
      }
      i = paramInt;
      if (this.kVh != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kVh);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kVf.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.bGw != null) {
          break;
        }
        throw new b("Not all required fields were included: Title");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        br localbr = (br)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbr.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bs();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bs)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbr.kVf.add(localObject1);
            paramInt += 1;
          }
        case 3: 
          localbr.kVg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbr.kVh = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.br
 * JD-Core Version:    0.7.0.1
 */