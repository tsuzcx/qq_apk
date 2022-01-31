package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AppBrandProxyTransparentUIProcessTask
  implements Parcelable
{
  public static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> gdL = new ConcurrentHashMap();
  private static final Set<Object> gem = new HashSet();
  public int gen = -1;
  public MMActivity.a geo = new MMActivity.a()
  {
    public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
    {
      if ((paramAnonymousInt1 != (AppBrandProxyTransparentUIProcessTask.this.hashCode() & 0xFFFF)) || (paramAnonymousIntent == null)) {
        return;
      }
      AppBrandProxyTransparentUIProcessTask localAppBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask)paramAnonymousIntent.getParcelableExtra("task_object");
      paramAnonymousIntent = AppBrandProxyTransparentUIProcessTask.tH(paramAnonymousIntent.getStringExtra("task_id"));
      if (paramAnonymousIntent == null)
      {
        y.e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
        return;
      }
      AppBrandProxyTransparentUIProcessTask.a(localAppBrandProxyTransparentUIProcessTask, paramAnonymousIntent);
      paramAnonymousIntent.ahD();
      paramAnonymousIntent.Zv();
      AppBrandProxyTransparentUIProcessTask.this.mContext = null;
    }
  };
  public String gep = Process.myPid() + hashCode();
  public Context mContext;
  
  public AppBrandProxyTransparentUIProcessTask() {}
  
  public AppBrandProxyTransparentUIProcessTask(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void Zv() {}
  
  public abstract void a(Context paramContext, AppBrandProxyTransparentUIProcessTask.a parama);
  
  public final void ahC()
  {
    gem.add(this);
  }
  
  public final void ahD()
  {
    gem.remove(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
 * JD-Core Version:    0.7.0.1
 */