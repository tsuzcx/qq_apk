package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import com.tencent.e.j.a;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageLoaded;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/MStorageProxyForWxaAttrStorage;", "Lcom/tencent/mm/sdk/storage/IStorage;", "()V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "doNotify", "", "p2", "", "lock", "lockCount", "remove", "removeLoadedListener", "unlock", "plugin-appbrand-integration_release"})
public abstract class r
  implements IStorage
{
  public r()
  {
    z localz = m.bFF();
    p.j(localz, "SubCoreAppBrand.getWxaContactStorage()");
    this.oaf = localz;
  }
  
  public void add(a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.oaf.add(parama, paramIOnStorageChange);
  }
  
  public void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.oaf.add(paramIOnStorageChange);
  }
  
  public void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    this.oaf.add(paramIOnStorageChange, paramLooper);
  }
  
  public void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.oaf.add(paramString, paramIOnStorageChange);
  }
  
  public void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    this.oaf.addLoadedListener(paramIOnStorageLoaded);
  }
  
  public void doNotify()
  {
    this.oaf.doNotify();
  }
  
  public void doNotify(String paramString)
  {
    this.oaf.doNotify(paramString);
  }
  
  public void doNotify(String paramString, int paramInt, Object paramObject)
  {
    this.oaf.doNotify(paramString, paramInt, paramObject);
  }
  
  public void lock()
  {
    this.oaf.lock();
  }
  
  public int lockCount()
  {
    return this.oaf.lockCount();
  }
  
  public void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.oaf.remove(paramIOnStorageChange);
  }
  
  public void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    this.oaf.removeLoadedListener(paramIOnStorageLoaded);
  }
  
  public void unlock()
  {
    this.oaf.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.r
 * JD-Core Version:    0.7.0.1
 */