package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AppBrandProxyTransparentUIProcessTask
  implements Parcelable
{
  private static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> hvI = new ConcurrentHashMap();
  private static final Set<Object> hwm = new HashSet();
  private int hwn = -1;
  private MMActivity.a hwo = new AppBrandProxyTransparentUIProcessTask.1(this);
  private String hwp = Process.myPid() + hashCode();
  Context mContext;
  
  protected AppBrandProxyTransparentUIProcessTask() {}
  
  public AppBrandProxyTransparentUIProcessTask(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public abstract void a(Context paramContext, AppBrandProxyTransparentUIProcessTask.a parama);
  
  public final void aBi()
  {
    if (this.mContext == null) {
      return;
    }
    hvI.put(this.hwp, new WeakReference(this));
    Intent localIntent = new Intent();
    localIntent.setClass(this.mContext, AppBrandProxyTransparentUI.class);
    localIntent.putExtra("task_object", this);
    localIntent.putExtra("task_class_name", getClass().getName());
    localIntent.putExtra("task_id", this.hwp);
    localIntent.putExtra("orientation", this.hwn);
    if ((this.mContext instanceof MMActivity))
    {
      aBj();
      ((MMActivity)this.mContext).mmSetOnActivityResultCallback(this.hwo);
      ((MMActivity)this.mContext).startActivityForResult(localIntent, hashCode() & 0xFFFF);
      return;
    }
    localIntent.addFlags(268435456);
    this.mContext.startActivity(localIntent);
  }
  
  public final void aBj()
  {
    hwm.add(this);
  }
  
  public final void aBk()
  {
    hwm.remove(this);
  }
  
  public void atb() {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public void f(Parcel paramParcel) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
 * JD-Core Version:    0.7.0.1
 */