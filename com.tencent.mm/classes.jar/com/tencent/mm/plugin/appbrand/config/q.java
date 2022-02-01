package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.e.k.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/config/MStorageProxyForWxaAttrStorage;", "Lcom/tencent/mm/sdk/storage/IStorage;", "()V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "doNotify", "", "p2", "", "lock", "lockCount", "remove", "removeLoadedListener", "unlock", "plugin-appbrand-integration_release"})
public abstract class q
  implements g
{
  public q()
  {
    v localv = j.aOC();
    k.g(localv, "SubCoreAppBrand.getWxaContactStorage()");
    this.jey = localv;
  }
  
  public void add(k.a parama)
  {
    this.jey.add(parama);
  }
  
  public void add(k.a parama, Looper paramLooper)
  {
    this.jey.add(parama, paramLooper);
  }
  
  public void add(String paramString, k.a parama)
  {
    this.jey.add(paramString, parama);
  }
  
  public void doNotify(String paramString)
  {
    this.jey.doNotify(paramString);
  }
  
  public final void p(String paramString, Object paramObject)
  {
    this.jey.doNotify(paramString, 3, paramObject);
  }
  
  public void remove(k.a parama)
  {
    this.jey.remove(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.q
 * JD-Core Version:    0.7.0.1
 */