package com.tencent.mm.plugin.appbrand.config;

import android.os.Looper;
import com.tencent.mm.sdk.storage.IStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageLoaded;
import com.tencent.threadpool.j.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/MStorageProxyForWxaAttrStorage;", "Lcom/tencent/mm/sdk/storage/IStorage;", "()V", "add", "", "p0", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "kotlin.jvm.PlatformType", "p1", "Landroid/os/Looper;", "Lcom/tencent/threadpool/serial/Serial;", "", "addLoadedListener", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageLoaded;", "doNotify", "", "p2", "", "lock", "lockCount", "remove", "removeLoadedListener", "unlock", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class u
  implements IStorage
{
  public void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.raI.add(paramIOnStorageChange);
  }
  
  public void add(MStorage.IOnStorageChange paramIOnStorageChange, Looper paramLooper)
  {
    this.raI.add(paramIOnStorageChange, paramLooper);
  }
  
  public void add(a parama, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.raI.add(parama, paramIOnStorageChange);
  }
  
  public void add(String paramString, MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.raI.add(paramString, paramIOnStorageChange);
  }
  
  public void addLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    this.raI.addLoadedListener(paramIOnStorageLoaded);
  }
  
  public void doNotify()
  {
    this.raI.doNotify();
  }
  
  public void doNotify(String paramString)
  {
    this.raI.doNotify(paramString);
  }
  
  public void doNotify(String paramString, int paramInt, Object paramObject)
  {
    this.raI.doNotify(paramString, paramInt, paramObject);
  }
  
  public void lock()
  {
    this.raI.lock();
  }
  
  public int lockCount()
  {
    return this.raI.lockCount();
  }
  
  public void remove(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    this.raI.remove(paramIOnStorageChange);
  }
  
  public void removeLoadedListener(MStorage.IOnStorageLoaded paramIOnStorageLoaded)
  {
    this.raI.removeLoadedListener(paramIOnStorageLoaded);
  }
  
  public void unlock()
  {
    this.raI.unlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.u
 * JD-Core Version:    0.7.0.1
 */