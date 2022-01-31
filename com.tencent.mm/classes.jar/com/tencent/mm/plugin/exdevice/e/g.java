package com.tencent.mm.plugin.exdevice.e;

import d.a.a.b;
import java.util.LinkedList;

public final class g
  extends j
{
  public String hQd;
  public int jxp;
  public int jxq;
  public int jxr;
  public int jxs;
  public int jxt;
  public String jxu;
  public int jxv;
  public String jxw;
  public int jxx;
  public int jxy;
  public String jxz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jxC == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.jxC != null)
      {
        paramVarArgs.gD(1, this.jxC.btq());
        this.jxC.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.jxp);
      paramVarArgs.gB(3, this.jxq);
      paramVarArgs.gB(4, this.jxr);
      paramVarArgs.gB(5, this.jxs);
      paramVarArgs.gB(6, this.jxt);
      if (this.jxu != null) {
        paramVarArgs.d(11, this.jxu);
      }
      paramVarArgs.gB(12, this.jxv);
      if (this.hQd != null) {
        paramVarArgs.d(13, this.hQd);
      }
      if (this.jxw != null) {
        paramVarArgs.d(14, this.jxw);
      }
      paramVarArgs.gB(15, this.jxx);
      paramVarArgs.gB(16, this.jxy);
      if (this.jxz != null) {
        paramVarArgs.d(17, this.jxz);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.jxC == null) {
        break label861;
      }
    }
    label861:
    for (paramInt = d.a.a.a.gA(1, this.jxC.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.jxp) + d.a.a.a.gy(3, this.jxq) + d.a.a.a.gy(4, this.jxr) + d.a.a.a.gy(5, this.jxs) + d.a.a.a.gy(6, this.jxt);
      paramInt = i;
      if (this.jxu != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.jxu);
      }
      i = paramInt + d.a.a.a.gy(12, this.jxv);
      paramInt = i;
      if (this.hQd != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.hQd);
      }
      i = paramInt;
      if (this.jxw != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.jxw);
      }
      i = i + d.a.a.a.gy(15, this.jxx) + d.a.a.a.gy(16, this.jxy);
      paramInt = i;
      if (this.jxz != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.jxz);
      }
      return paramInt;
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
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 7: 
        case 8: 
        case 9: 
        case 10: 
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
            localg.jxC = ((e)localObject1);
            paramInt += 1;
          }
        case 2: 
          localg.jxp = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localg.jxq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localg.jxr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localg.jxs = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localg.jxt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localg.jxu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localg.jxv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localg.hQd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localg.jxw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localg.jxx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localg.jxy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localg.jxz = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.g
 * JD-Core Version:    0.7.0.1
 */