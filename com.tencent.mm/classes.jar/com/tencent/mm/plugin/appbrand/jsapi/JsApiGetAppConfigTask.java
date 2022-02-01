package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.config.s.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiGetAppConfigTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetAppConfigTask> CREATOR;
  public String appId;
  public String key;
  public Runnable rxj;
  public int scene;
  public int type;
  public String value;
  
  static
  {
    AppMethodBeat.i(45491);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(45491);
  }
  
  public JsApiGetAppConfigTask() {}
  
  public JsApiGetAppConfigTask(Parcel paramParcel)
  {
    AppMethodBeat.i(45485);
    h(paramParcel);
    AppMethodBeat.o(45485);
  }
  
  public final void asn()
  {
    AppMethodBeat.i(45486);
    if (!h.baC().mBZ)
    {
      AppMethodBeat.o(45486);
      return;
    }
    Pair localPair = ((com.tencent.mm.plugin.appbrand.appcache.predownload.storage.b)n.ag(com.tencent.mm.plugin.appbrand.appcache.predownload.storage.b.class)).N(this.appId, 4, this.scene);
    if (((Boolean)localPair.first).booleanValue())
    {
      a locala = a.qJY;
      a.ac(((Integer)localPair.second).intValue(), 166L);
    }
    if (!((Boolean)localPair.first).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      s.a(this.appId, this.type, 0, new s.c()
      {
        public final void Vv(String paramAnonymousString)
        {
          AppMethodBeat.i(45483);
          JsApiGetAppConfigTask.this.value = paramAnonymousString;
          JsApiGetAppConfigTask.a(JsApiGetAppConfigTask.this);
          AppMethodBeat.o(45483);
        }
      }, bool);
      AppMethodBeat.o(45486);
      return;
    }
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(45487);
    if (this.rxj != null) {
      this.rxj.run();
    }
    AppMethodBeat.o(45487);
  }
  
  public final void h(Parcel paramParcel)
  {
    AppMethodBeat.i(45488);
    this.appId = paramParcel.readString();
    this.key = paramParcel.readString();
    this.value = paramParcel.readString();
    this.type = paramParcel.readInt();
    this.scene = paramParcel.readInt();
    AppMethodBeat.o(45488);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(45489);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.key);
    paramParcel.writeString(this.value);
    paramParcel.writeInt(this.type);
    paramParcel.writeInt(this.scene);
    AppMethodBeat.o(45489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiGetAppConfigTask
 * JD-Core Version:    0.7.0.1
 */