package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AppBrandProxyTransparentUIProcessTask
  implements Parcelable
{
  private static final Set<Object> juM = new HashSet();
  private static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> jud = new ConcurrentHashMap();
  private String hLO = Process.myPid() + hashCode();
  private int juN = -1;
  private MMActivity.a juO = new MMActivity.a()
  {
    public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
        paramAnonymousIntent = AppBrandProxyTransparentUIProcessTask.HB(paramAnonymousIntent.getStringExtra("task_id"));
        if (paramAnonymousIntent == null)
        {
          ad.e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
          AppMethodBeat.o(45411);
          return;
        }
        AppBrandProxyTransparentUIProcessTask.a(localAppBrandProxyTransparentUIProcessTask, paramAnonymousIntent);
        paramAnonymousIntent.aXn();
        paramAnonymousIntent.aEA();
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
  
  public void aEA() {}
  
  public final void aXl()
  {
    if (this.mContext == null) {
      return;
    }
    jud.put(this.hLO, new WeakReference(this));
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, AppBrandProxyTransparentUI.class);
    localIntent.putExtra("task_object", this);
    localIntent.putExtra("task_class_name", getClass().getName());
    localIntent.putExtra("task_id", this.hLO);
    localIntent.putExtra("orientation", this.juN);
    e.az(this.mContext).a(localIntent, new e.a()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174743);
        AppBrandProxyTransparentUIProcessTask.a(AppBrandProxyTransparentUIProcessTask.this).c(AppBrandProxyTransparentUIProcessTask.this.hashCode() & 0xFFFF, paramAnonymousInt, paramAnonymousIntent);
        AppMethodBeat.o(174743);
      }
    });
  }
  
  public final void aXm()
  {
    juM.add(this);
  }
  
  public final void aXn()
  {
    juM.remove(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
 * JD-Core Version:    0.7.0.1
 */