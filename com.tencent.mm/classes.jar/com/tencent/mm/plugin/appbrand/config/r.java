package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import com.tencent.f.j.a;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageLoaded;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/MStorageProxyForWxaAttrStorage;", "Lcom/tencent/mm/sdk/storage/IStorage;", "()V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "doNotify", "", "p2", "", "lock", "lockCount", "remove", "removeLoadedListener", "unlock", "plugin-appbrand-integration_release"})
public abstract class r
  implements IStorage
{
  public r()
  {
    z localz = n.buC();
    p.g(localz, "SubCoreAppBrand.getWxaContactStorage()");
    this.lfG = localz;
  }
  
  public void add(a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.lfG.add(parama, paramIOnStorageChange);
  }
  
  public void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.lfG.add(paramIOnStorageChange);
  }
  
  public void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    this.lfG.add(paramIOnStorageChange, paramLooper);
  }
  
  public void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.lfG.add(paramString, paramIOnStorageChange);
  }
  
  public void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    this.lfG.addLoadedListener(paramIOnStorageLoaded);
  }
  
  public void doNotify()
  {
    this.lfG.doNotify();
  }
  
  public void doNotify(String paramString)
  {
    this.lfG.doNotify(paramString);
  }
  
  public void doNotify(String paramString, int paramInt, Object paramObject)
  {
    this.lfG.doNotify(paramString, paramInt, paramObject);
  }
  
  public void lock()
  {
    this.lfG.lock();
  }
  
  public int lockCount()
  {
    return this.lfG.lockCount();
  }
  
  public void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.lfG.remove(paramIOnStorageChange);
  }
  
  public void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    this.lfG.removeLoadedListener(paramIOnStorageLoaded);
  }
  
  public void unlock()
  {
    this.lfG.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.r
 * JD-Core Version:    0.7.0.1
 */