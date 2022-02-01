package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.nr.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public final class JsApiOpenAdCanvas
  extends a<c>
{
  public static final int CTRL_INDEX = 476;
  public static final String NAME = "openADCanvas";
  private String jYO = "";
  private JsApiOpenAdCanvasTask jYP = null;
  
  static class JsApiOpenAdCanvasTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiOpenAdCanvasTask> CREATOR;
    private String dob;
    private int dqd;
    private int dqe;
    private int jOT;
    private m jXc;
    private WeakReference<Context> jYQ;
    private String jYR;
    private String jYS;
    private String jYT;
    private q jiP;
    
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
      this.jXc = paramm;
      this.jiP = paramq;
      this.jOT = paramInt1;
      this.jYQ = paramWeakReference;
      this.jYR = paramString1;
      this.dqd = paramInt2;
      this.dqe = paramInt3;
      this.dob = paramString2;
      this.jYS = paramString3;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45565);
      b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45561);
          nr localnr = new nr();
          localnr.dqb.pageId = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localnr.dqb.dbZ = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.b(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localnr.dqb.dqd = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.c(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localnr.dqb.dqe = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.d(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localnr.dqb.dbL = 0;
          com.tencent.mm.sdk.b.a.GpY.l(localnr);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this, localnr.dqc.dqf);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.e(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          AppMethodBeat.o(45561);
        }
      }, "JsApiOpenAdCanvas");
      AppMethodBeat.o(45565);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45564);
      String str2 = this.jYT;
      if (this.dqd == 0)
      {
        Intent localIntent = new Intent();
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localIntent.putExtra("sns_landing_pages_xml", str1);
        localIntent.putExtra("sns_landing_pages_pageid", bs.aLz(this.jYR));
        localIntent.putExtra("sns_landig_pages_from_source", 13);
        localIntent.putExtra("sns_landing_pages_extra", this.dob);
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        localIntent.putExtra("sns_landing_pages_no_store", this.dqe);
        localIntent.putExtra("sns_landing_pages_ad_info", this.jYS);
        d.b((Context)this.jYQ.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
        this.jiP.h(this.jOT, this.jXc.e("ok", null));
      }
      for (;;)
      {
        bek();
        AppMethodBeat.o(45564);
        return;
        if (this.dqd == 1) {
          this.jiP.h(this.jOT, this.jXc.e("ok", null));
        } else {
          this.jiP.h(this.jOT, this.jXc.e("fail", null));
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45566);
      this.jYR = paramParcel.readString();
      this.dqd = paramParcel.readInt();
      this.dqe = paramParcel.readInt();
      this.dob = paramParcel.readString();
      this.jYS = paramParcel.readString();
      this.jYT = paramParcel.readString();
      AppMethodBeat.o(45566);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45567);
      paramParcel.writeString(this.jYR);
      paramParcel.writeInt(this.dqd);
      paramParcel.writeInt(this.dqe);
      paramParcel.writeString(this.dob);
      paramParcel.writeString(this.jYS);
      paramParcel.writeString(this.jYT);
      AppMethodBeat.o(45567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas
 * JD-Core Version:    0.7.0.1
 */