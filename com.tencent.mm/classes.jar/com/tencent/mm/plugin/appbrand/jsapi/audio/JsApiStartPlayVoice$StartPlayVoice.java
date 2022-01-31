package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;

class JsApiStartPlayVoice$StartPlayVoice
  extends MainProcessTask
{
  public static final Parcelable.Creator<StartPlayVoice> CREATOR;
  public String ctV;
  public boolean error;
  public String filePath;
  private int hry;
  private r hxb;
  private m hxs;
  
  static
  {
    AppMethodBeat.i(130782);
    CREATOR = new JsApiStartPlayVoice.StartPlayVoice.2();
    AppMethodBeat.o(130782);
  }
  
  public JsApiStartPlayVoice$StartPlayVoice(Parcel paramParcel)
  {
    AppMethodBeat.i(130775);
    this.error = false;
    f(paramParcel);
    AppMethodBeat.o(130775);
  }
  
  public JsApiStartPlayVoice$StartPlayVoice(m paramm, r paramr, int paramInt)
  {
    this.error = false;
    this.hxs = paramm;
    this.hxb = paramr;
    this.hry = paramInt;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130776);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130773);
        ((b)g.E(b.class)).a(JsApiStartPlayVoice.StartPlayVoice.this.filePath, new JsApiStartPlayVoice.StartPlayVoice.1.1(this), new JsApiStartPlayVoice.StartPlayVoice.1.2(this));
        AppMethodBeat.o(130773);
      }
    });
    AppMethodBeat.o(130776);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130777);
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", this.ctV);
    r localr = this.hxb;
    int i = this.hry;
    m localm = this.hxs;
    if (this.error) {}
    for (String str = "fail";; str = "ok")
    {
      localr.h(i, localm.j(str, localHashMap));
      JsApiStartPlayVoice.hCH = null;
      AppMethodBeat.o(130777);
      return;
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130778);
    this.ctV = paramParcel.readString();
    this.filePath = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.error = bool;
      AppMethodBeat.o(130778);
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130779);
    paramParcel.writeString(this.ctV);
    paramParcel.writeString(this.filePath);
    if (this.error) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      AppMethodBeat.o(130779);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice
 * JD-Core Version:    0.7.0.1
 */