package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class f
  extends i
{
  public b jxn;
  public b jxo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jxB != null)
      {
        paramVarArgs.gD(1, this.jxB.btq());
        this.jxB.a(paramVarArgs);
      }
      if (this.jxn != null) {
        paramVarArgs.b(2, this.jxn);
      }
      if (this.jxo != null) {
        paramVarArgs.b(3, this.jxo);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.jxB == null) {
        break label377;
      }
    }
    label377:
    for (int i = d.a.a.a.gA(1, this.jxB.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jxn != null) {
        paramInt = i + d.a.a.a.a(2, this.jxn);
      }
      i = paramInt;
      if (this.jxo != null) {
        i = paramInt + d.a.a.a.a(3, this.jxo);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = i.a(paramVarArgs); paramInt > 0; paramInt = i.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
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
            localObject1 = new d();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((d)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, i.a((d.a.a.a.a)localObject2))) {}
            localf.jxB = ((d)localObject1);
            paramInt += 1;
          }
        case 2: 
          localf.jxn = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localf.jxo = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.f
 * JD-Core Version:    0.7.0.1
 */