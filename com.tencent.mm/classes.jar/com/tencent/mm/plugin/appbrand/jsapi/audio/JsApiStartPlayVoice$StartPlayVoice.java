package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.HashMap;
import java.util.Map;

class JsApiStartPlayVoice$StartPlayVoice
  extends MainProcessTask
{
  public static final Parcelable.Creator<StartPlayVoice> CREATOR = new JsApiStartPlayVoice.StartPlayVoice.2();
  public String bMB;
  public boolean error = false;
  public String filePath;
  private i gfG;
  private o gfd;
  private int gfg;
  
  public JsApiStartPlayVoice$StartPlayVoice(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiStartPlayVoice$StartPlayVoice(i parami, o paramo, int paramInt)
  {
    this.gfG = parami;
    this.gfd = paramo;
    this.gfg = paramInt;
  }
  
  public final void Zu()
  {
    ai.d(new Runnable()
    {
      public final void run()
      {
        ((b)g.r(b.class)).a(JsApiStartPlayVoice.StartPlayVoice.this.filePath, new JsApiStartPlayVoice.StartPlayVoice.1.1(this), new JsApiStartPlayVoice.StartPlayVoice.1.2(this));
      }
    });
  }
  
  public final void Zv()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", this.bMB);
    o localo = this.gfd;
    int i = this.gfg;
    i locali = this.gfG;
    if (this.error) {}
    for (String str = "fail";; str = "ok")
    {
      localo.C(i, locali.h(str, localHashMap));
      JsApiStartPlayVoice.gjn = null;
      return;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.bMB = paramParcel.readString();
    this.filePath = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.error = bool;
      return;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.bMB);
    paramParcel.writeString(this.filePath);
    if (this.error) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice.StartPlayVoice
 * JD-Core Version:    0.7.0.1
 */