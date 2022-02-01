package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AppBrandProxyTransparentUIProcessTask
  implements Parcelable
{
  private static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> jUy = new ConcurrentHashMap();
  private static final Set<Object> jVh = new HashSet();
  private String imk = Process.myPid() + hashCode();
  private int jVi = -1;
  private MMActivity.a jVj = new MMActivity.a()
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
        paramAnonymousIntent = AppBrandProxyTransparentUIProcessTask.LF(paramAnonymousIntent.getStringExtra("task_id"));
        if (paramAnonymousIntent == null)
        {
          ac.e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
          AppMethodBeat.o(45411);
          return;
        }
        AppBrandProxyTransparentUIProcessTask.a(localAppBrandProxyTransparentUIProcessTask, paramAnonymousIntent);
        paramAnonymousIntent.bek();
        paramAnonymousIntent.aLr();
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
  
  public void aLr() {}
  
  public final void bei()
  {
    if (this.mContext == null) {
      return;
    }
    jUy.put(this.imk, new WeakReference(this));
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, AppBrandProxyTransparentUI.class);
    localIntent.putExtra("task_object", this);
    localIntent.putExtra("task_class_name", getClass().getName());
    localIntent.putExtra("task_id", this.imk);
    localIntent.putExtra("orientation", this.jVi);
    e.aA(this.mContext).a(localIntent, new e.a()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174743);
        AppBrandProxyTransparentUIProcessTask.a(AppBrandProxyTransparentUIProcessTask.this).c(AppBrandProxyTransparentUIProcessTask.this.hashCode() & 0xFFFF, paramAnonymousInt, paramAnonymousIntent);
        AppMethodBeat.o(174743);
      }
    });
  }
  
  public final void bej()
  {
    jVh.add(this);
  }
  
  public final void bek()
  {
    jVh.remove(this);
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