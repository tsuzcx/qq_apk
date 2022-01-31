package com.tencent.mm.plugin.exdevice.e;

import java.util.LinkedList;

public final class l
  extends j
{
  public com.tencent.mm.bv.b hPF;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jxC == null) {
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (this.jxC != null)
      {
        paramVarArgs.gD(1, this.jxC.btq());
        this.jxC.a(paramVarArgs);
      }
      if (this.hPF != null) {
        paramVarArgs.b(2, this.hPF);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.jxC == null) {
        break label357;
      }
    }
    label357:
    for (paramInt = d.a.a.a.gA(1, this.jxC.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hPF != null) {
        i = paramInt + d.a.a.a.a(2, this.hPF);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = j.a(paramVarArgs); paramInt > 0; paramInt = j.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.jxC != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
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
            for (boolean bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, j.a((d.a.a.a.a)localObject2))) {}
            locall.jxC = ((e)localObject1);
            paramInt += 1;
          }
        }
        locall.hPF = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.l
 * JD-Core Version:    0.7.0.1
 */