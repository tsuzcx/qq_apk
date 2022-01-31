package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiGetAppConfigTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetAppConfigTask> CREATOR;
  public String appId;
  public Runnable hxp;
  public String key;
  public int scene;
  public int type;
  public String value;
  
  static
  {
    AppMethodBeat.i(130433);
    CREATOR = new JsApiGetAppConfigTask.2();
    AppMethodBeat.o(130433);
  }
  
  public JsApiGetAppConfigTask() {}
  
  public JsApiGetAppConfigTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130427);
    f(paramParcel);
    AppMethodBeat.o(130427);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130428);
    if (!com.tencent.mm.kernel.g.RJ().eHg)
    {
      AppMethodBeat.o(130428);
      return;
    }
    Pair localPair = ((b)com.tencent.mm.plugin.appbrand.app.g.w(b.class)).I(this.appId, 4, this.scene);
    if (((Boolean)localPair.first).booleanValue())
    {
      com.tencent.mm.plugin.appbrand.appcache.b.c.a locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.gXW;
      com.tencent.mm.plugin.appbrand.appcache.b.c.a.B(((Integer)localPair.second).intValue(), 166L);
    }
    if (!((Boolean)localPair.first).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      m.a(this.appId, this.type, 0, new JsApiGetAppConfigTask.1(this), bool);
      AppMethodBeat.o(130428);
      return;
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130429);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(130429);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130430);
    this.appId = paramParcel.readString();
    this.key = paramParcel.readString();
    this.value = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    AppMethodBeat.o(130430);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130431);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.value);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.scene);
    AppMethodBeat.o(130431);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetAppConfigTask
 * JD-Core Version:    0.7.0.1
 */