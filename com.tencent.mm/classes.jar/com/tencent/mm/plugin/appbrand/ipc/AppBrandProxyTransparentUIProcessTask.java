package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.b;
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
  private static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> ruY = new ConcurrentHashMap();
  private static final Set<Object> ruZ = new HashSet();
  Context mContext;
  private String ppa = Process.myPid() + hashCode();
  private int rva = -1;
  private MMActivity.a rvb = new MMActivity.a()
  {
    public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
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
        paramAnonymousIntent = AppBrandProxyTransparentUIProcessTask.ZD(paramAnonymousIntent.getStringExtra("task_id"));
        if (paramAnonymousIntent == null)
        {
          Log.e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
          AppMethodBeat.o(45411);
          return;
        }
        AppBrandProxyTransparentUIProcessTask.a(localAppBrandProxyTransparentUIProcessTask, paramAnonymousIntent);
        paramAnonymousIntent.cpx();
        paramAnonymousIntent.bQr();
        AppBrandProxyTransparentUIProcessTask.this.mContext = null;
      }
      AppMethodBeat.o(45411);
    }
  };
  
  protected AppBrandProxyTransparentUIProcessTask() {}
  
  public AppBrandProxyTransparentUIProcessTask(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public abstract void a(Context paramContext, AppBrandProxyTransparentUIProcessTask.a parama);
  
  public void bQr() {}
  
  public final void cpv()
  {
    if (this.mContext == null) {
      return;
    }
    ruY.put(this.ppa, new WeakReference(this));
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, AppBrandProxyTransparentUI.class);
    localIntent.putExtra("task_object", this);
    localIntent.putExtra("task_class_name", getClass().getName());
    localIntent.putExtra("task_id", this.ppa);
    localIntent.putExtra("orientation", this.rva);
    e.bt(this.mContext).a(localIntent, new e.b()
    {
      public final void onResult(int paramAnonymousInt, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174743);
        AppBrandProxyTransparentUIProcessTask.a(AppBrandProxyTransparentUIProcessTask.this).mmOnActivityResult(AppBrandProxyTransparentUIProcessTask.this.hashCode() & 0xFFFF, paramAnonymousInt, paramAnonymousIntent);
        AppMethodBeat.o(174743);
      }
    });
  }
  
  public final void cpw()
  {
    ruZ.add(this);
  }
  
  public final void cpx()
  {
    ruZ.remove(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void h(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
 * JD-Core Version:    0.7.0.1
 */