package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;

public final class JsApiOpenAdCanvas
  extends a<c>
{
  public static final int CTRL_INDEX = 476;
  public static final String NAME = "openADCanvas";
  private String kwA = "";
  private JsApiOpenAdCanvasTask kwB = null;
  
  static class JsApiOpenAdCanvasTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiOpenAdCanvasTask> CREATOR;
    private String dAU;
    private int dCV;
    private int dCW;
    private r jFj;
    private int kmu;
    private m kuO;
    private WeakReference<Context> kwC;
    private String kwD;
    private String kwE;
    private String kwF;
    
    static
    {
      AppMethodBeat.i(45569);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45569);
    }
    
    public JsApiOpenAdCanvasTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45563);
      e(paramParcel);
      AppMethodBeat.o(45563);
    }
    
    public JsApiOpenAdCanvasTask(m paramm, r paramr, int paramInt1, WeakReference<Context> paramWeakReference, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
    {
      this.kuO = paramm;
      this.jFj = paramr;
      this.kmu = paramInt1;
      this.kwC = paramWeakReference;
      this.kwD = paramString1;
      this.dCV = paramInt2;
      this.dCW = paramInt3;
      this.dAU = paramString2;
      this.kwE = paramString3;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45565);
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45561);
          oa localoa = new oa();
          localoa.dCT.pageId = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localoa.dCT.dox = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.b(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localoa.dCT.dCV = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.c(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localoa.dCT.dCW = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.d(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localoa.dCT.doj = 0;
          com.tencent.mm.sdk.b.a.IvT.l(localoa);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this, localoa.dCU.dCX);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.e(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          AppMethodBeat.o(45561);
        }
      }, "JsApiOpenAdCanvas");
      AppMethodBeat.o(45565);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(45564);
      String str2 = this.kwF;
      if (this.dCV == 0)
      {
        Intent localIntent = new Intent();
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localIntent.putExtra("sns_landing_pages_xml", str1);
        localIntent.putExtra("sns_landing_pages_pageid", bu.aSC(this.kwD));
        localIntent.putExtra("sns_landig_pages_from_source", 13);
        localIntent.putExtra("sns_landing_pages_extra", this.dAU);
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        localIntent.putExtra("sns_landing_pages_no_store", this.dCW);
        localIntent.putExtra("sns_landing_pages_ad_info", this.kwE);
        d.b((Context)this.kwC.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        this.jFj.h(this.kmu, this.kuO.e("ok", null));
      }
      for (;;)
      {
        bix();
        AppMethodBeat.o(45564);
        return;
        if (this.dCV == 1) {
          this.jFj.h(this.kmu, this.kuO.e("ok", null));
        } else {
          this.jFj.h(this.kmu, this.kuO.e("fail", null));
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45566);
      this.kwD = paramParcel.readString();
      this.dCV = paramParcel.readInt();
      this.dCW = paramParcel.readInt();
      this.dAU = paramParcel.readString();
      this.kwE = paramParcel.readString();
      this.kwF = paramParcel.readString();
      AppMethodBeat.o(45566);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45567);
      paramParcel.writeString(this.kwD);
      paramParcel.writeInt(this.dCV);
      paramParcel.writeInt(this.dCW);
      paramParcel.writeString(this.dAU);
      paramParcel.writeString(this.kwE);
      paramParcel.writeString(this.kwF);
      AppMethodBeat.o(45567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas
 * JD-Core Version:    0.7.0.1
 */