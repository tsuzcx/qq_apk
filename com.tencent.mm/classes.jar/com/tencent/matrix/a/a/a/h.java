package com.tencent.matrix.a.a.a;

import android.content.Context;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.c;
import com.tencent.matrix.a.b.o;
import com.tencent.matrix.a.b.o.a;
import com.tencent.matrix.a.b.o.a.a;
import com.tencent.matrix.a.b.o.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class h
  extends a
{
  Runnable ePY = new Runnable()
  {
    public final void run()
    {
      if (h.this.eQE.size() >= h.this.eNY.ePD.ePi) {}
      try
      {
        o.bg(h.this.eQE);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  };
  List<o.a> eQE = Collections.emptyList();
  private c eRn;
  
  public static b axe()
  {
    b localb = new b();
    try
    {
      localb.eRr = m.a.c.c.t(com.tencent.matrix.a.b.b.axq());
      return localb;
    }
    finally
    {
      com.tencent.matrix.e.c.printErrStackTrace("Matrix.battery.DeviceStatusMonitorFeature", localThrowable, "#currentCpuFreq error", new Object[0]);
      localb.eRr = m.a.c.c.t(new int[0]);
    }
    return localb;
  }
  
  public static a bS(Context paramContext)
  {
    a locala = new a();
    locala.eRp = m.a.c.b.c(Integer.valueOf(com.tencent.matrix.a.a.d.bR(paramContext)));
    return locala;
  }
  
  public final void awI()
  {
    super.awI();
    Object localObject = new o.a(String.valueOf(com.tencent.matrix.a.b.b.bW(com.tencent.matrix.a.a.d.getContext())));
    Context localContext;
    try
    {
      this.eQE = new ArrayList();
      this.eQE.add(0, localObject);
      this.eRn.eRt = new com.tencent.matrix.a.b.d() {};
      if (this.eRn.eRv) {
        return;
      }
      localObject = this.eRn;
      localContext = com.tencent.matrix.a.a.d.getContext();
      if (((c)localObject).eRv) {
        return;
      }
      if (!com.tencent.matrix.a.b.isInit()) {
        throw new IllegalStateException("BatteryEventDelegate is not yet init!");
      }
    }
    finally {}
    localc.eRw = new h.c.2(localc);
    localc.eRu = com.tencent.matrix.a.b.b.bZ(localContext);
    com.tencent.matrix.a.b.awt().a(localc.eRw);
    localc.eRv = true;
  }
  
  public final void awJ()
  {
    super.awJ();
    c localc = this.eRn;
    if (localc.eRv) {}
    try
    {
      if ((localc.eRw != null) && (com.tencent.matrix.a.b.isInit())) {
        com.tencent.matrix.a.b.awt().b(localc.eRw);
      }
      label39:
      localc.eRv = false;
      return;
    }
    finally
    {
      break label39;
    }
  }
  
  public final int awQ()
  {
    return 2147483647;
  }
  
  public final List<o.a> axf()
  {
    if (this.eQE.isEmpty()) {
      return Collections.emptyList();
    }
    return new ArrayList(this.eQE);
  }
  
  public final d dH(long paramLong)
  {
    try
    {
      o.c localc = o.a(this.eQE, paramLong, new o.a.a()
      {
        public final o.a gr(String paramAnonymousString)
        {
          return new o.a(String.valueOf(com.tencent.matrix.a.b.b.bW(com.tencent.matrix.a.a.d.getContext())));
        }
      });
      d locald2 = new d();
      locald2.eSe = localc.eSe;
      locald2.eQH = m.a.c.b.c(Long.valueOf(localc.eUv));
      locald2.eRy = m.a.c.b.c(Long.valueOf(localc.gB("1")));
      locald2.eRz = m.a.c.b.c(Long.valueOf(localc.gB("2")));
      locald2.eRA = m.a.c.b.c(Long.valueOf(localc.gB("3")));
      locald2.eRB = m.a.c.b.c(Long.valueOf(localc.gB("4")));
      return locald2;
    }
    finally
    {
      com.tencent.matrix.e.c.w("Matrix.battery.DeviceStatusMonitorFeature", "configureSnapshot fail: " + localObject.getMessage(), new Object[0]);
      d locald1 = new d();
      locald1.eSe = false;
      return locald1;
    }
  }
  
  public final void g(com.tencent.matrix.a.a.d paramd)
  {
    super.g(paramd);
    this.eRn = new c();
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.DeviceStatusMonitorFeature";
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
  }
  
  public static class a
    extends m.a<a>
  {
    public m.a.c.b<Integer> eRp;
  }
  
  public static class b
    extends m.a<b>
  {
    public m.a.c.c<m.a.c.b<Integer>> eRr;
  }
  
  static final class c
  {
    com.tencent.matrix.a.b.d<Integer> eRt = new com.tencent.matrix.a.b.d() {};
    boolean eRu = true;
    boolean eRv = false;
    b.c eRw;
  }
  
  public static final class d
    extends m.a<d>
  {
    public m.a.c.b<Long> eQH = m.a.c.b.c(Long.valueOf(0L));
    public m.a.c.b<Long> eRA = m.a.c.b.c(Long.valueOf(0L));
    public m.a.c.b<Long> eRB = m.a.c.b.c(Long.valueOf(0L));
    public m.a.c.b<Long> eRy = m.a.c.b.c(Long.valueOf(0L));
    public m.a.c.b<Long> eRz = m.a.c.b.c(Long.valueOf(0L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.h
 * JD-Core Version:    0.7.0.1
 */