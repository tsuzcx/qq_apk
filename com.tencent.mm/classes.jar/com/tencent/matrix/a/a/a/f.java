package com.tencent.matrix.a.a.a;

import android.content.Context;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.c;
import com.tencent.matrix.a.b.k;
import com.tencent.matrix.a.b.k.a;
import com.tencent.matrix.a.b.k.a.a;
import com.tencent.matrix.a.b.k.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class f
  extends a
{
  Runnable cUy = new Runnable()
  {
    public final void run()
    {
      if (f.this.cVe.size() >= f.this.cSI.cUb.cTG) {}
      try
      {
        k.I(f.this.cVe);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  };
  List<k.a> cVe = Collections.emptyList();
  private c cVw;
  
  public static b Wq()
  {
    b localb = new b();
    try
    {
      localb.cVA = j.a.c.c.r(com.tencent.matrix.a.b.b.WB());
      return localb;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.DeviceStatusMonitorFeature", localThrowable, "#currentCpuFreq error", new Object[0]);
      localb.cVA = j.a.c.c.r(new int[0]);
    }
    return localb;
  }
  
  public static a bi(Context paramContext)
  {
    a locala = new a();
    locala.cVy = j.a.c.b.c(Integer.valueOf(com.tencent.matrix.a.a.d.bh(paramContext)));
    return locala;
  }
  
  public final void VZ()
  {
    super.VZ();
    Object localObject = new k.a(String.valueOf(com.tencent.matrix.a.b.b.bl(com.tencent.matrix.a.a.d.getContext())));
    Context localContext;
    try
    {
      this.cVe = new ArrayList();
      this.cVe.add(0, localObject);
      this.cVw.cVC = new com.tencent.matrix.a.b.d() {};
      if (this.cVw.cVE) {
        return;
      }
      localObject = this.cVw;
      localContext = com.tencent.matrix.a.a.d.getContext();
      if (((c)localObject).cVE) {
        return;
      }
      if (!com.tencent.matrix.a.b.isInit()) {
        throw new IllegalStateException("BatteryEventDelegate is not yet init!");
      }
    }
    finally {}
    localc.cVF = new f.c.2(localc);
    localc.cVD = com.tencent.matrix.a.b.b.bo(localContext);
    com.tencent.matrix.a.b.VJ().a(localc.cVF);
    localc.cVE = true;
  }
  
  public final void Wa()
  {
    super.Wa();
    c localc = this.cVw;
    if (localc.cVE) {}
    try
    {
      if ((localc.cVF != null) && (com.tencent.matrix.a.b.isInit())) {
        com.tencent.matrix.a.b.VJ().b(localc.cVF);
      }
      label39:
      localc.cVE = false;
      return;
    }
    catch (Throwable localThrowable)
    {
      break label39;
    }
  }
  
  public final int Wh()
  {
    return 2147483647;
  }
  
  public final d bp(long paramLong)
  {
    try
    {
      k.c localc = k.a(this.cVe, paramLong, new k.a.a()
      {
        public final k.a eT(String paramAnonymousString)
        {
          return new k.a(String.valueOf(com.tencent.matrix.a.b.b.bl(com.tencent.matrix.a.a.d.getContext())));
        }
      });
      d locald2 = new d();
      locald2.cWl = localc.cWl;
      locald2.cVh = j.a.c.b.c(Long.valueOf(localc.cXW));
      locald2.cVH = j.a.c.b.c(Long.valueOf(localc.fd("1")));
      locald2.cVI = j.a.c.b.c(Long.valueOf(localc.fd("2")));
      locald2.cVJ = j.a.c.b.c(Long.valueOf(localc.fd("3")));
      locald2.cVK = j.a.c.b.c(Long.valueOf(localc.fd("4")));
      return locald2;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.matrix.e.c.w("Matrix.battery.DeviceStatusMonitorFeature", "configureSnapshot fail: " + localThrowable.getMessage(), new Object[0]);
      d locald1 = new d();
      locald1.cWl = false;
      return locald1;
    }
  }
  
  public final void f(com.tencent.matrix.a.a.d paramd)
  {
    super.f(paramd);
    this.cVw = new c();
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.DeviceStatusMonitorFeature";
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
  }
  
  public static final class a
    extends j.a<a>
  {
    public j.a.c.b<Integer> cVy;
  }
  
  public static final class b
    extends j.a<b>
  {
    public j.a.c.c<j.a.c.b<Integer>> cVA;
  }
  
  static final class c
  {
    com.tencent.matrix.a.b.d<Integer> cVC = new com.tencent.matrix.a.b.d() {};
    boolean cVD = true;
    boolean cVE = false;
    b.c cVF;
  }
  
  public static final class d
    extends j.a<d>
  {
    public j.a.c.b<Long> cVH = j.a.c.b.c(Long.valueOf(0L));
    public j.a.c.b<Long> cVI = j.a.c.b.c(Long.valueOf(0L));
    public j.a.c.b<Long> cVJ = j.a.c.b.c(Long.valueOf(0L));
    public j.a.c.b<Long> cVK = j.a.c.b.c(Long.valueOf(0L));
    public j.a.c.b<Long> cVh = j.a.c.b.c(Long.valueOf(0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */