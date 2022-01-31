package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.lh;
import com.tencent.mm.h.a.lh.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.ref.WeakReference;

class JsApiOpenAdCanvas$JsApiOpenAdCanvasTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiOpenAdCanvasTask> CREATOR = new JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.2();
  private int bUp;
  private int bUq;
  private String fPG;
  private i gfG;
  private o gfd;
  private int gfg;
  private String ggA;
  private String ggB;
  private String ggC;
  private WeakReference<Context> ggz;
  
  public JsApiOpenAdCanvas$JsApiOpenAdCanvasTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiOpenAdCanvas$JsApiOpenAdCanvasTask(i parami, o paramo, int paramInt1, WeakReference<Context> paramWeakReference, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    this.gfG = parami;
    this.gfd = paramo;
    this.gfg = paramInt1;
    this.ggz = paramWeakReference;
    this.ggA = paramString1;
    this.bUp = paramInt2;
    this.bUq = paramInt3;
    this.fPG = paramString2;
    this.ggB = paramString3;
  }
  
  public final void Zu()
  {
    e.post(new Runnable()
    {
      public final void run()
      {
        lh locallh = new lh();
        locallh.bUm.bUo = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
        locallh.bUm.bIm = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.b(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
        locallh.bUm.bUp = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.c(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
        locallh.bUm.bUq = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.d(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
        locallh.bUm.source = 0;
        a.udP.m(locallh);
        JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this, locallh.bUn.bUr);
        JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.e(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
      }
    }, "JsApiOpenAdCanvas");
  }
  
  public final void Zv()
  {
    String str2 = this.ggC;
    if (this.bUp == 0)
    {
      Intent localIntent = new Intent();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localIntent.putExtra("sns_landing_pages_xml", str1);
      localIntent.putExtra("sns_landing_pages_pageid", bk.ZS(this.ggA));
      localIntent.putExtra("sns_landig_pages_from_source", 13);
      localIntent.putExtra("sns_landing_pages_extra", this.fPG);
      localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      localIntent.putExtra("sns_landing_pages_no_store", this.bUq);
      localIntent.putExtra("sns_landing_pages_ad_info", this.ggB);
      d.b((Context)this.ggz.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
      this.gfd.C(this.gfg, this.gfG.h("ok", null));
    }
    for (;;)
    {
      ahD();
      return;
      if (this.bUp == 1) {
        this.gfd.C(this.gfg, this.gfG.h("ok", null));
      } else {
        this.gfd.C(this.gfg, this.gfG.h("fail", null));
      }
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.ggA = paramParcel.readString();
    this.bUp = paramParcel.readInt();
    this.bUq = paramParcel.readInt();
    this.fPG = paramParcel.readString();
    this.ggB = paramParcel.readString();
    this.ggC = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ggA);
    paramParcel.writeInt(this.bUp);
    paramParcel.writeInt(this.bUq);
    paramParcel.writeString(this.fPG);
    paramParcel.writeString(this.ggB);
    paramParcel.writeString(this.ggC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas.JsApiOpenAdCanvasTask
 * JD-Core Version:    0.7.0.1
 */