package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.e.g;
import com.tencent.mm.sdk.e.k.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/config/MStorageProxyForWxaAttrStorage;", "Lcom/tencent/mm/sdk/storage/IStorage;", "()V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "doNotify", "", "p2", "", "lock", "lockCount", "remove", "removeLoadedListener", "unlock", "plugin-appbrand-integration_release"})
public abstract class q
  implements g
{
  public q()
  {
    v localv = j.aVu();
    k.g(localv, "SubCoreAppBrand.getWxaContactStorage()");
    this.jEM = localv;
  }
  
  public void add(k.a parama)
  {
    this.jEM.add(parama);
  }
  
  public void add(k.a parama, Looper paramLooper)
  {
    this.jEM.add(parama, paramLooper);
  }
  
  public void add(String paramString, k.a parama)
  {
    this.jEM.add(paramString, parama);
  }
  
  public void doNotify(String paramString)
  {
    this.jEM.doNotify(paramString);
  }
  
  public final void o(String paramString, Object paramObject)
  {
    this.jEM.doNotify(paramString, 3, paramObject);
  }
  
  public void remove(k.a parama)
  {
    this.jEM.remove(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.q
 * JD-Core Version:    0.7.0.1
 */