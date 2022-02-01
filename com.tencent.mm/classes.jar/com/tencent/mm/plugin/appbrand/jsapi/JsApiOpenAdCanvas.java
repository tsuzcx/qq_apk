package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ni;
import com.tencent.mm.g.a.ni.b;
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
  private String jyr = "";
  private JsApiOpenAdCanvasTask jys = null;
  
  static class JsApiOpenAdCanvasTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiOpenAdCanvasTask> CREATOR;
    private String dqq;
    private int dss;
    private int dsu;
    private q iIL;
    private int joH;
    private m jwG;
    private WeakReference<Context> jyt;
    private String jyu;
    private String jyv;
    private String jyw;
    
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
      this.jwG = paramm;
      this.iIL = paramq;
      this.joH = paramInt1;
      this.jyt = paramWeakReference;
      this.jyu = paramString1;
      this.dss = paramInt2;
      this.dsu = paramInt3;
      this.dqq = paramString2;
      this.jyv = paramString3;
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45564);
      String str2 = this.jyw;
      if (this.dss == 0)
      {
        Intent localIntent = new Intent();
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localIntent.putExtra("sns_landing_pages_xml", str1);
        localIntent.putExtra("sns_landing_pages_pageid", bt.aGi(this.jyu));
        localIntent.putExtra("sns_landig_pages_from_source", 13);
        localIntent.putExtra("sns_landing_pages_extra", this.dqq);
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        localIntent.putExtra("sns_landing_pages_no_store", this.dsu);
        localIntent.putExtra("sns_landing_pages_ad_info", this.jyv);
        d.b((Context)this.jyt.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        this.iIL.h(this.joH, this.jwG.e("ok", null));
      }
      for (;;)
      {
        aXn();
        AppMethodBeat.o(45564);
        return;
        if (this.dss == 1) {
          this.iIL.h(this.joH, this.jwG.e("ok", null));
        } else {
          this.iIL.h(this.joH, this.jwG.e("fail", null));
        }
      }
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45565);
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45561);
          ni localni = new ni();
          localni.dsq.pageId = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localni.dsq.deE = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.b(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localni.dsq.dss = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.c(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localni.dsq.dsu = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.d(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localni.dsq.dep = 0;
          com.tencent.mm.sdk.b.a.ESL.l(localni);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this, localni.dsr.dsv);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.e(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          AppMethodBeat.o(45561);
        }
      }, "JsApiOpenAdCanvas");
      AppMethodBeat.o(45565);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45566);
      this.jyu = paramParcel.readString();
      this.dss = paramParcel.readInt();
      this.dsu = paramParcel.readInt();
      this.dqq = paramParcel.readString();
      this.jyv = paramParcel.readString();
      this.jyw = paramParcel.readString();
      AppMethodBeat.o(45566);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45567);
      paramParcel.writeString(this.jyu);
      paramParcel.writeInt(this.dss);
      paramParcel.writeInt(this.dsu);
      paramParcel.writeString(this.dqq);
      paramParcel.writeString(this.jyv);
      paramParcel.writeString(this.jyw);
      AppMethodBeat.o(45567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas
 * JD-Core Version:    0.7.0.1
 */