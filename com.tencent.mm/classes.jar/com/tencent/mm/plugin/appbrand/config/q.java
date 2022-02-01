package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.e.k.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/MStorageProxyForWxaAttrStorage;", "Lcom/tencent/mm/sdk/storage/IStorage;", "()V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "doNotify", "", "p2", "", "lock", "lockCount", "remove", "removeLoadedListener", "unlock", "plugin-appbrand-integration_release"})
public abstract class q
  implements g
{
  public q()
  {
    w localw = j.aZl();
    p.g(localw, "SubCoreAppBrand.getWxaContactStorage()");
    this.kcf = localw;
  }
  
  public void add(k.a parama)
  {
    this.kcf.add(parama);
  }
  
  public void add(k.a parama, Looper paramLooper)
  {
    this.kcf.add(parama, paramLooper);
  }
  
  public void add(String paramString, k.a parama)
  {
    this.kcf.add(paramString, parama);
  }
  
  public void doNotify(String paramString)
  {
    this.kcf.doNotify(paramString);
  }
  
  public final void n(String paramString, Object paramObject)
  {
    this.kcf.doNotify(paramString, 3, paramObject);
  }
  
  public void remove(k.a parama)
  {
    this.kcf.remove(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.q
 * JD-Core Version:    0.7.0.1
 */