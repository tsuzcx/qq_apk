package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.nz;
import com.tencent.mm.g.a.nz.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public final class JsApiOpenAdCanvas
  extends a<c>
{
  public static final int CTRL_INDEX = 476;
  public static final String NAME = "openADCanvas";
  private String ktk = "";
  private JsApiOpenAdCanvasTask ktl = null;
  
  static class JsApiOpenAdCanvasTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiOpenAdCanvasTask> CREATOR;
    private int dBQ;
    private int dBR;
    private String dzP;
    private q jCl;
    private int kje;
    private m kry;
    private WeakReference<Context> ktm;
    private String ktn;
    private String kto;
    private String ktp;
    
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
    
    public JsApiOpenAdCanvasTask(m paramm, q paramq, int paramInt1, WeakReference<Context> paramWeakReference, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3)
    {
      this.kry = paramm;
      this.jCl = paramq;
      this.kje = paramInt1;
      this.ktm = paramWeakReference;
      this.ktn = paramString1;
      this.dBQ = paramInt2;
      this.dBR = paramInt3;
      this.dzP = paramString2;
      this.kto = paramString3;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45565);
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45561);
          nz localnz = new nz();
          localnz.dBO.pageId = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localnz.dBO.dnv = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.b(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localnz.dBO.dBQ = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.c(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localnz.dBO.dBR = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.d(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localnz.dBO.dnh = 0;
          com.tencent.mm.sdk.b.a.IbL.l(localnz);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this, localnz.dBP.dBS);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.e(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          AppMethodBeat.o(45561);
        }
      }, "JsApiOpenAdCanvas");
      AppMethodBeat.o(45565);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45564);
      String str2 = this.ktp;
      if (this.dBQ == 0)
      {
        Intent localIntent = new Intent();
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localIntent.putExtra("sns_landing_pages_xml", str1);
        localIntent.putExtra("sns_landing_pages_pageid", bt.aRf(this.ktn));
        localIntent.putExtra("sns_landig_pages_from_source", 13);
        localIntent.putExtra("sns_landing_pages_extra", this.dzP);
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        localIntent.putExtra("sns_landing_pages_no_store", this.dBR);
        localIntent.putExtra("sns_landing_pages_ad_info", this.kto);
        d.b((Context)this.ktm.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        this.jCl.h(this.kje, this.kry.e("ok", null));
      }
      for (;;)
      {
        bhO();
        AppMethodBeat.o(45564);
        return;
        if (this.dBQ == 1) {
          this.jCl.h(this.kje, this.kry.e("ok", null));
        } else {
          this.jCl.h(this.kje, this.kry.e("fail", null));
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45566);
      this.ktn = paramParcel.readString();
      this.dBQ = paramParcel.readInt();
      this.dBR = paramParcel.readInt();
      this.dzP = paramParcel.readString();
      this.kto = paramParcel.readString();
      this.ktp = paramParcel.readString();
      AppMethodBeat.o(45566);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45567);
      paramParcel.writeString(this.ktn);
      paramParcel.writeInt(this.dBQ);
      paramParcel.writeInt(this.dBR);
      paramParcel.writeString(this.dzP);
      paramParcel.writeString(this.kto);
      paramParcel.writeString(this.ktp);
      AppMethodBeat.o(45567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas
 * JD-Core Version:    0.7.0.1
 */