package com.tencent.mm.plugin.exdevice.e;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class a
  extends i
{
  public String hQc;
  public b jxb;
  public int jxc;
  public int jxd;
  public int jxe;
  public b jxf;
  public b jxg;
  public String jxh;
  public String jxi;
  
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
      if (this.jxb != null) {
        paramVarArgs.b(2, this.jxb);
      }
      paramVarArgs.gB(3, this.jxc);
      paramVarArgs.gB(4, this.jxd);
      paramVarArgs.gB(5, this.jxe);
      if (this.jxf != null) {
        paramVarArgs.b(6, this.jxf);
      }
      if (this.jxg != null) {
        paramVarArgs.b(7, this.jxg);
      }
      if (this.jxh != null) {
        paramVarArgs.d(10, this.jxh);
      }
      if (this.jxi != null) {
        paramVarArgs.d(11, this.jxi);
      }
      if (this.hQc != null) {
        paramVarArgs.d(12, this.hQc);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.jxB == null) {
        break label723;
      }
    }
    label723:
    for (paramInt = d.a.a.a.gA(1, this.jxB.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jxb != null) {
        i = paramInt + d.a.a.a.a(2, this.jxb);
      }
      i = i + d.a.a.a.gy(3, this.jxc) + d.a.a.a.gy(4, this.jxd) + d.a.a.a.gy(5, this.jxe);
      paramInt = i;
      if (this.jxf != null) {
        paramInt = i + d.a.a.a.a(6, this.jxf);
      }
      i = paramInt;
      if (this.jxg != null) {
        i = paramInt + d.a.a.a.a(7, this.jxg);
      }
      paramInt = i;
      if (this.jxh != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.jxh);
      }
      i = paramInt;
      if (this.jxi != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.jxi);
      }
      paramInt = i;
      if (this.hQc != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.hQc);
      }
      return paramInt;
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
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 8: 
        case 9: 
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
            locala.jxB = ((d)localObject1);
            paramInt += 1;
          }
        case 2: 
          locala.jxb = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 3: 
          locala.jxc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          locala.jxd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          locala.jxe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          locala.jxf = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 7: 
          locala.jxg = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 10: 
          locala.jxh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          locala.jxi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        locala.hQc = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.e.a
 * JD-Core Version:    0.7.0.1
 */