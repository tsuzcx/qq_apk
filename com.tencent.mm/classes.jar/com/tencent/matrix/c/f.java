package com.tencent.matrix.c;

import android.annotation.SuppressLint;
import com.tencent.e.i.k;
import com.tencent.matrix.a.a.a.b.a;
import com.tencent.matrix.a.a.a.j.a.a;
import com.tencent.matrix.a.a.a.j.a.c.b;
import com.tencent.matrix.a.a.b.a.a;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.List;

public final class f
  extends com.tencent.matrix.a.a.a.b
{
  private com.tencent.matrix.report.c cZq;
  private a cZx;
  
  public final void G(List<j.a.a<b.a>> paramList)
  {
    if (this.cZq != null)
    {
      com.tencent.matrix.report.c localc = this.cZq;
      Log.i("Matrix.battery.listener", "#onTraceOverHeat, size = " + paramList.size());
      if (!paramList.isEmpty())
      {
        Object localObject = (j.a.a)paramList.get(0);
        if ((localObject != null) && (((Long)((b.a)((j.a.a)localObject).cWo).cUC.cWu).longValue() > 0L))
        {
          localObject = new b.a.a();
          ((b.a.a)localObject).VV();
          ((b.a.a)localObject).aM("| ThreadPool Task Jiffies Tracing OverHeat").aM("\n");
          localc.a(paramList, com.tencent.matrix.a.a.a.VQ(), (b.a.a)localObject);
          ((b.a.a)localObject).VW();
          ((b.a.a)localObject).Y();
        }
      }
    }
  }
  
  public final void H(String paramString, int paramInt)
  {
    super.H(paramString, paramInt);
  }
  
  public final void I(String paramString, int paramInt)
  {
    super.I(paramString, paramInt);
  }
  
  public final void VZ()
  {
    super.VZ();
    com.tencent.e.c.b.Zwh = new f.a.1(this.cZx);
  }
  
  public final void Wa()
  {
    super.Wa();
    com.tencent.e.c.b.Zwh = this.cZx.cZy;
  }
  
  public final int Wh()
  {
    return 0;
  }
  
  public final void b(int paramInt, String paramString, long paramLong)
  {
    a.Xf();
    super.b(paramInt, paramString, paramLong);
  }
  
  public final void f(d paramd)
  {
    super.f(paramd);
    this.cUx = a.Xd();
    this.cZx = new a(com.tencent.e.c.b.Zwh, (byte)0);
    paramd = paramd.cUb.cTz;
    if ((paramd instanceof com.tencent.matrix.report.c)) {
      this.cZq = ((com.tencent.matrix.report.c)paramd);
    }
  }
  
  @SuppressLint({"RestrictedApi"})
  public final k.c h(int paramInt, long paramLong1, long paramLong2)
  {
    k.c localc = super.h(paramInt, paramLong1, paramLong2);
    a.Xg();
    return localc;
  }
  
  public final boolean i(j.a.a<b.a> parama)
  {
    a.Xf();
    return super.i(parama);
  }
  
  @SuppressLint({"RestrictedApi"})
  public final void j(j.a.a<b.a> parama)
  {
    super.j(parama);
    a.Xg();
  }
  
  public final void js(int paramInt) {}
  
  final class a
  {
    final com.tencent.e.b.c cZy;
    
    private a(com.tencent.e.b.c paramc)
    {
      this.cZy = paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.c.f
 * JD-Core Version:    0.7.0.1
 */