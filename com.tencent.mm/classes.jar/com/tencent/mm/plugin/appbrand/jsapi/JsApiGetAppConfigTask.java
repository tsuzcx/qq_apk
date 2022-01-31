package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.b.d.b;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiGetAppConfigTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetAppConfigTask> CREATOR = new JsApiGetAppConfigTask.2();
  public String appId;
  public Runnable gfD;
  public String key;
  public int scene;
  public int type;
  public String value;
  
  public JsApiGetAppConfigTask() {}
  
  public JsApiGetAppConfigTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    if (!g.DN().dJH) {
      return;
    }
    Pair localPair = ((b)e.G(b.class)).w(this.appId, 4, this.scene);
    if (((Boolean)localPair.first).booleanValue())
    {
      com.tencent.mm.plugin.appbrand.appcache.b.c.a locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(((Integer)localPair.second).intValue(), 166L);
    }
    if (!((Boolean)localPair.first).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      n.a(this.appId, this.type, 0, new JsApiGetAppConfigTask.1(this), bool);
      return;
    }
  }
  
  public final void Zv()
  {
    if (this.gfD != null) {
      this.gfD.run();
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.key = paramParcel.readString();
    this.value = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.scene = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.value);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.scene);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetAppConfigTask
 * JD-Core Version:    0.7.0.1
 */