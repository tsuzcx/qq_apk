package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.q.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiGetAppConfigTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiGetAppConfigTask> CREATOR;
  public String appId;
  public String key;
  public Runnable otv;
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
    f(paramParcel);
    AppMethodBeat.o(45485);
  }
  
  public final void RW()
  {
    AppMethodBeat.i(45486);
    if (!h.aHE().kbT)
    {
      AppMethodBeat.o(45486);
      return;
    }
    Pair localPair = ((com.tencent.mm.plugin.appbrand.appcache.predownload.e.b)m.W(com.tencent.mm.plugin.appbrand.appcache.predownload.e.b.class)).J(this.appId, 4, this.scene);
    if (((Boolean)localPair.first).booleanValue())
    {
      a locala = a.nKB;
      a.F(((Integer)localPair.second).intValue(), 166L);
    }
    if (!((Boolean)localPair.first).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      q.a(this.appId, this.type, 0, new q.c()
      {
        public final void acY(String paramAnonymousString)
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
  
  public final void bsK()
  {
    AppMethodBeat.i(45487);
    if (this.otv != null) {
      this.otv.run();
    }
    AppMethodBeat.o(45487);
  }
  
  public final void f(Parcel paramParcel)
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