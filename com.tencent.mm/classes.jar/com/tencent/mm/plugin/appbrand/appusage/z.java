package com.tencent.mm.plugin.appbrand.appusage;

import a.d.b.g;
import a.p;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.protocal.c.bvi;
import com.tencent.mm.protocal.c.bvj;
import com.tencent.mm.protocal.c.cah;
import com.tencent.mm.protocal.c.cai;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public final class z
  extends com.tencent.mm.ah.a<cai>
{
  private static final int[] fJD = { 1, 2, 3, 4 };
  public static final z.a fJE = new z.a((byte)0);
  
  public z(List<? extends bvj> paramList, int paramInt)
  {
    if (z.a.adx())
    {
      if (!paramList.isEmpty())
      {
        localObject = fJD;
        g.k(localObject, "$receiver");
        if (a.a.a.i((int[])localObject, paramInt) >= 0)
        {
          i = 1;
          if (i == 0) {
            break label86;
          }
        }
      }
      label86:
      for (int i = j;; i = 0)
      {
        if ((!p.xoi) || (i != 0)) {
          break label91;
        }
        throw ((Throwable)new AssertionError("Assertion failed"));
        i = 0;
        break;
      }
    }
    label91:
    Object localObject = new b.a();
    ((b.a)localObject).b((com.tencent.mm.bv.a)new cai());
    ((b.a)localObject).kr("/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord");
    ((b.a)localObject).ig(1839);
    cah localcah = new cah();
    localcah.tPE.addAll((Collection)paramList);
    localcah.aQw = paramInt;
    ((b.a)localObject).a((com.tencent.mm.bv.a)localcah);
    a(((b.a)localObject).Kt());
  }
  
  public static final bvj a(bvi parambvi)
  {
    return z.a.a(parambvi, null, null);
  }
  
  public static final bvj b(bvi parambvi)
  {
    return z.a.b(parambvi);
  }
  
  public static enum b
  {
    final int fJL;
    
    static
    {
      b localb1 = new b("None", 0, 0);
      fJF = localb1;
      b localb2 = new b("Timeout", 1, 1);
      fJG = localb2;
      b localb3 = new b("ClosePullDown", 2, 2);
      fJH = localb3;
      b localb4 = new b("CloseCollectionList", 3, 3);
      fJI = localb4;
      b localb5 = new b("History", 4, 4);
      fJJ = localb5;
      fJK = new b[] { localb1, localb2, localb3, localb4, localb5 };
    }
    
    private b(int paramInt)
    {
      this.fJL = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.z
 * JD-Core Version:    0.7.0.1
 */