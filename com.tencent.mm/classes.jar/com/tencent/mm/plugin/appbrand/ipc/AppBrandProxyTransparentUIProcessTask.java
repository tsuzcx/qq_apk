package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AppBrandProxyTransparentUIProcessTask
  implements Parcelable
{
  private static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> lvL = new ConcurrentHashMap();
  private static final Set<Object> lwv = new HashSet();
  private String jEY = Process.myPid() + hashCode();
  private int lww = -1;
  private MMActivity.a lwx = new MMActivity.a()
  {
    public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
    {
      AppMethodBeat.i(45411);
      if (paramAnonymousInt1 == (AppBrandProxyTransparentUIProcessTask.this.hashCode() & 0xFFFF))
      {
        if (paramAnonymousIntent == null)
        {
          AppMethodBeat.o(45411);
          return;
        }
        AppBrandProxyTransparentUIProcessTask localAppBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask)paramAnonymousIntent.getParcelableExtra("task_object");
        paramAnonymousIntent = AppBrandProxyTransparentUIProcessTask.YW(paramAnonymousIntent.getStringExtra("task_id"));
        if (paramAnonymousIntent == null)
        {
          Log.e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
          AppMethodBeat.o(45411);
          return;
        }
        AppBrandProxyTransparentUIProcessTask.a(localAppBrandProxyTransparentUIProcessTask, paramAnonymousIntent);
        paramAnonymousIntent.bDK();
        paramAnonymousIntent.bjk();
        AppBrandProxyTransparentUIProcessTask.this.mContext = null;
      }
      AppMethodBeat.o(45411);
    }
  };
  Context mContext;
  
  protected AppBrandProxyTransparentUIProcessTask() {}
  
  public AppBrandProxyTransparentUIProcessTask(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public abstract void a(Context paramContext, AppBrandProxyTransparentUIProcessTask.a parama);
  
  public final void bDI()
  {
    if (this.mContext == null) {
      return;
    }
    lvL.put(this.jEY, new WeakReference(this));
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, AppBrandProxyTransparentUI.class);
    localIntent.putExtra("task_object", this);
    localIntent.putExtra("task_class_name", getClass().getName());
    localIntent.putExtra("task_id", this.jEY);
    localIntent.putExtra("orientation", this.lww);
    f.aK(this.mContext).a(localIntent, new f.b()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174743);
        AppBrandProxyTransparentUIProcessTask.a(AppBrandProxyTransparentUIProcessTask.this).d(AppBrandProxyTransparentUIProcessTask.this.hashCode() & 0xFFFF, paramAnonymousInt, paramAnonymousIntent);
        AppMethodBeat.o(174743);
      }
    });
  }
  
  public final void bDJ()
  {
    lwv.add(this);
  }
  
  public final void bDK()
  {
    lwv.remove(this);
  }
  
  public void bjk() {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void f(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
 * JD-Core Version:    0.7.0.1
 */