package b.a.a;

import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bv.a
{
  public String sRh;
  public String sTe;
  public LinkedList<g> sTf = new LinkedList();
  public int sTg;
  public a sTh;
  public int xpn;
  public int xpo;
  public int xpp;
  public e xpq;
  public String xpr;
  public b xps;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.sTf);
      paramVarArgs.gB(2, this.xpn);
      if (this.sRh != null) {
        paramVarArgs.d(3, this.sRh);
      }
      paramVarArgs.gB(4, this.sTg);
      if (this.sTh != null)
      {
        paramVarArgs.gD(5, this.sTh.btq());
        this.sTh.a(paramVarArgs);
      }
      if (this.sTe != null) {
        paramVarArgs.d(6, this.sTe);
      }
      paramVarArgs.gB(7, this.xpo);
      paramVarArgs.gB(8, this.xpp);
      if (this.xpq != null)
      {
        paramVarArgs.gD(9, this.xpq.btq());
        this.xpq.a(paramVarArgs);
      }
      if (this.xpr != null) {
        paramVarArgs.d(10, this.xpr);
      }
      if (this.xps != null)
      {
        paramVarArgs.gD(11, this.xps.btq());
        this.xps.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.c(1, 8, this.sTf) + 0 + d.a.a.a.gy(2, this.xpn);
      paramInt = i;
      if (this.sRh != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sRh);
      }
      i = paramInt + d.a.a.a.gy(4, this.sTg);
      paramInt = i;
      if (this.sTh != null) {
        paramInt = i + d.a.a.a.gA(5, this.sTh.btq());
      }
      i = paramInt;
      if (this.sTe != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sTe);
      }
      i = i + d.a.a.a.gy(7, this.xpo) + d.a.a.a.gy(8, this.xpp);
      paramInt = i;
      if (this.xpq != null) {
        paramInt = i + d.a.a.a.gA(9, this.xpq.btq());
      }
      i = paramInt;
      if (this.xpr != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.xpr);
      }
      paramInt = i;
    } while (this.xps == null);
    return i + d.a.a.a.gA(11, this.xps.btq());
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sTf.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
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
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((g)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localc.sTf.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        localc.xpn = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localc.sRh = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localc.sTg = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localc.sTh = ((a)localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        localc.sTe = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        localc.xpo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localc.xpp = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new e();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localc.xpq = ((e)localObject1);
          paramInt += 1;
        }
        return 0;
      case 10: 
        localc.xpr = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new b();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((b)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localc.xps = ((b)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     b.a.a.c
 * JD-Core Version:    0.7.0.1
 */