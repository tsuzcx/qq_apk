package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.u.n;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public final class f
  extends com.tencent.mm.sdk.e.j
  implements b, af
{
  private static f fId;
  public static final a fIe = new a((byte)0);
  private final AtomicBoolean fIc = new AtomicBoolean(false);
  
  public final void Ey()
  {
    fId = (f)this;
  }
  
  public final void Ez()
  {
    fId = null;
  }
  
  public final List<? extends LocalUsageInfo> a(int paramInt, af.a parama)
  {
    if (paramInt <= 0) {
      return null;
    }
    return (List)((s)e.G(s.class)).b(paramInt, parama);
  }
  
  public final void a(j.a parama, Looper paramLooper)
  {
    ((s)e.G(s.class)).a(parama, paramLooper);
    e.aaT().a(parama, paramLooper);
  }
  
  public final boolean a(List<? extends LocalUsageInfo> paramList, f.b paramb)
  {
    boolean bool = false;
    if (paramList == null)
    {
      if (bl.csf()) {
        Assert.assertTrue("reorderList is NULL", false);
      }
    }
    else
    {
      this.fIc.set(true);
      paramList = (Runnable)new f.e(this, paramList, paramb);
      if (!ai.isMainThread()) {
        break label58;
      }
      n.DS().O(paramList);
    }
    for (;;)
    {
      bool = true;
      return bool;
      label58:
      paramList.run();
    }
  }
  
  public final void acK()
  {
    if (d.IS_FLAVOR_RED)
    {
      if (this.fIc.get()) {
        y.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, skip fetch when calculating diff");
      }
    }
    else {
      return;
    }
    y.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "refreshOnPullDownOpen, fetch");
    j.acU().a(bk.UY(), true, null, 6, 0);
  }
  
  public final int acL()
  {
    return t.ads();
  }
  
  public final boolean ap(String paramString, int paramInt)
  {
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    localObject = (s)e.G(s.class);
    if (paramString == null) {
      a.d.b.g.cUk();
    }
    return ((s)localObject).at(paramString, paramInt);
  }
  
  public final int aq(String paramString, int paramInt)
  {
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return -1;
    }
    localObject = (s)e.G(s.class);
    if (paramString == null) {
      a.d.b.g.cUk();
    }
    return ((s)localObject).au(paramString, paramInt);
  }
  
  public final boolean ar(String paramString, int paramInt)
  {
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    localObject = (s)e.G(s.class);
    if (paramString == null) {
      a.d.b.g.cUk();
    }
    return ((s)localObject).av(paramString, paramInt);
  }
  
  public final void c(j.a parama)
  {
    a(parama, Looper.getMainLooper());
  }
  
  public final void d(j.a parama)
  {
    ((s)e.G(s.class)).d(parama);
    e.aaT().d(parama);
  }
  
  public final boolean d(List<LocalUsageInfo> paramList, int paramInt)
  {
    y.i("MicroMsg.AppBrandCollectionStorageExport[collection]", "reorder reason = " + paramInt);
    f.b localb;
    switch (paramInt)
    {
    default: 
      localb = null;
    }
    for (;;)
    {
      return a(paramList, localb);
      localb = (f.b)new c();
      continue;
      localb = (f.b)new f.d();
    }
  }
  
  public final int getCount()
  {
    Object localObject = e.G(s.class);
    a.d.b.g.j(localObject, "SubCoreAppBrand.getStora…arAppStorage::class.java)");
    return ((s)localObject).adp();
  }
  
  public static final class a {}
  
  public static final class c
    extends f.b
  {
    public final void acN()
    {
      ((c)com.tencent.mm.kernel.g.r(c.class)).a(z.b.fJH);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.f
 * JD-Core Version:    0.7.0.1
 */