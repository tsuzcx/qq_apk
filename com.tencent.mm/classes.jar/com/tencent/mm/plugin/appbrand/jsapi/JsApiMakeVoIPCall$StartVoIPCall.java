package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

class JsApiMakeVoIPCall$StartVoIPCall
  extends MainProcessTask
{
  public static final Parcelable.Creator<StartVoIPCall> CREATOR = new JsApiMakeVoIPCall.StartVoIPCall.2();
  private i gfG;
  private int gfg;
  private c ggu;
  private com.tencent.mm.sdk.b.c ggv = new JsApiMakeVoIPCall.StartVoIPCall.1(this);
  public int status;
  
  public JsApiMakeVoIPCall$StartVoIPCall(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiMakeVoIPCall$StartVoIPCall(i parami, c paramc, int paramInt)
  {
    this.gfG = parami;
    this.ggu = paramc;
    this.gfg = paramInt;
  }
  
  public final void Zu()
  {
    a.udP.c(this.ggv);
  }
  
  public final void Zv()
  {
    ahD();
    y.i("MicroMsg.JsApiMakeVoIPCall", "makeVoIPCall = %d", new Object[] { Integer.valueOf(this.status) });
    if (this.status == 1)
    {
      this.ggu.C(this.gfg, this.gfG.h("cancel", null));
      return;
    }
    if (this.status == 2)
    {
      this.ggu.C(this.gfg, this.gfG.h("ok", null));
      return;
    }
    if (this.status == 3)
    {
      this.ggu.C(this.gfg, this.gfG.h("fail:network error", null));
      return;
    }
    if (this.status == 4)
    {
      this.ggu.C(this.gfg, this.gfG.h("fail:param not match", null));
      return;
    }
    this.ggu.C(this.gfg, this.gfG.h("fail:unknow", null));
  }
  
  public final void e(Parcel paramParcel)
  {
    this.status = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.status);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall.StartVoIPCall
 * JD-Core Version:    0.7.0.1
 */