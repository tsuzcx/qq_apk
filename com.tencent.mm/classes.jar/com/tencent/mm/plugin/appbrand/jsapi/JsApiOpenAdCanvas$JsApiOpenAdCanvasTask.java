package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

class JsApiOpenAdCanvas$JsApiOpenAdCanvasTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiOpenAdCanvasTask> CREATOR;
  private String cAh;
  private int cBU;
  private int cBV;
  private int hry;
  private r hxb;
  private m hxs;
  private WeakReference<Context> hyV;
  private String hyW;
  private String hyX;
  private String hyY;
  
  static
  {
    AppMethodBeat.i(130510);
    CREATOR = new JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.2();
    AppMethodBeat.o(130510);
  }
  
  public JsApiOpenAdCanvas$JsApiOpenAdCanvasTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130504);
    f(paramParcel);
    AppMethodBeat.o(130504);
  }
  
  public JsApiOpenAdCanvas$JsApiOpenAdCanvasTask(m paramm, r paramr, int paramInt1, WeakReference<Context> paramWeakReference, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    this.hxs = paramm;
    this.hxb = paramr;
    this.hry = paramInt1;
    this.hyV = paramWeakReference;
    this.hyW = paramString1;
    this.cBU = paramInt2;
    this.cBV = paramInt3;
    this.cAh = paramString2;
    this.hyX = paramString3;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130506);
    com.tencent.mm.sdk.g.d.post(new JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.1(this), "JsApiOpenAdCanvas");
    AppMethodBeat.o(130506);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130505);
    String str2 = this.hyY;
    if (this.cBU == 0)
    {
      Intent localIntent = new Intent();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localIntent.putExtra("sns_landing_pages_xml", str1);
      localIntent.putExtra("sns_landing_pages_pageid", bo.apW(this.hyW));
      localIntent.putExtra("sns_landig_pages_from_source", 13);
      localIntent.putExtra("sns_landing_pages_extra", this.cAh);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_no_store", this.cBV);
      localIntent.putExtra("sns_landing_pages_ad_info", this.hyX);
      com.tencent.mm.bq.d.b((Context)this.hyV.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
      this.hxb.h(this.hry, this.hxs.j("ok", null));
    }
    for (;;)
    {
      aBk();
      AppMethodBeat.o(130505);
      return;
      if (this.cBU == 1) {
        this.hxb.h(this.hry, this.hxs.j("ok", null));
      } else {
        this.hxb.h(this.hry, this.hxs.j("fail", null));
      }
    }
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130507);
    this.hyW = paramParcel.readString();
    this.cBU = paramParcel.readInt();
    this.cBV = paramParcel.readInt();
    this.cAh = paramParcel.readString();
    this.hyX = paramParcel.readString();
    this.hyY = paramParcel.readString();
    AppMethodBeat.o(130507);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130508);
    paramParcel.writeString(this.hyW);
    paramParcel.writeInt(this.cBU);
    paramParcel.writeInt(this.cBV);
    paramParcel.writeString(this.cAh);
    paramParcel.writeString(this.hyX);
    paramParcel.writeString(this.hyY);
    AppMethodBeat.o(130508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas.JsApiOpenAdCanvasTask
 * JD-Core Version:    0.7.0.1
 */