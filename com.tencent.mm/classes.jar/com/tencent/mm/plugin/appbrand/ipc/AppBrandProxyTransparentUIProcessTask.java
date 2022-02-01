package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AppBrandProxyTransparentUIProcessTask
  implements Parcelable
{
  private static final Set<Object> ksL = new HashSet();
  private static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> ksc = new ConcurrentHashMap();
  private String iIu = Process.myPid() + hashCode();
  private int ksM = -1;
  private MMActivity.a ksN = new MMActivity.a()
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
        paramAnonymousIntent = AppBrandProxyTransparentUIProcessTask.PH(paramAnonymousIntent.getStringExtra("task_id"));
        if (paramAnonymousIntent == null)
        {
          ae.e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
          AppMethodBeat.o(45411);
          return;
        }
        AppBrandProxyTransparentUIProcessTask.a(localAppBrandProxyTransparentUIProcessTask, paramAnonymousIntent);
        paramAnonymousIntent.bix();
        paramAnonymousIntent.aOY();
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
  
  public void aOY() {}
  
  public final void biv()
  {
    if (this.mContext == null) {
      return;
    }
    ksc.put(this.iIu, new WeakReference(this));
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, AppBrandProxyTransparentUI.class);
    localIntent.putExtra("task_object", this);
    localIntent.putExtra("task_class_name", getClass().getName());
    localIntent.putExtra("task_id", this.iIu);
    localIntent.putExtra("orientation", this.ksM);
    e.aB(this.mContext).a(localIntent, new e.b()
    {
      public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174743);
        AppBrandProxyTransparentUIProcessTask.a(AppBrandProxyTransparentUIProcessTask.this).c(AppBrandProxyTransparentUIProcessTask.this.hashCode() & 0xFFFF, paramAnonymousInt, paramAnonymousIntent);
        AppMethodBeat.o(174743);
      }
    });
  }
  
  public final void biw()
  {
    ksL.add(this);
  }
  
  public final void bix()
  {
    ksL.remove(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void e(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
 * JD-Core Version:    0.7.0.1
 */