package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.os;
import com.tencent.mm.g.a.os.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.ref.WeakReference;

public final class JsApiOpenAdCanvas
  extends d<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 476;
  public static final String NAME = "openADCanvas";
  private String lAK = "";
  private JsApiOpenAdCanvasTask lAL = null;
  
  static class JsApiOpenAdCanvasTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiOpenAdCanvasTask> CREATOR;
    private String dSJ;
    private int dUL;
    private int dUM;
    private s kGT;
    private WeakReference<Context> lAM;
    private String lAN;
    private int lAO;
    private String lAP;
    private String lAQ;
    private p lAw;
    private int lqe;
    
    static
    {
      AppMethodBeat.i(45569);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45569);
    }
    
    public JsApiOpenAdCanvasTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45563);
      f(paramParcel);
      AppMethodBeat.o(45563);
    }
    
    public JsApiOpenAdCanvasTask(p paramp, s params, int paramInt1, WeakReference<Context> paramWeakReference, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, int paramInt4)
    {
      this.lAw = paramp;
      this.kGT = params;
      this.lqe = paramInt1;
      this.lAM = paramWeakReference;
      this.lAN = paramString1;
      this.dUL = paramInt2;
      this.dUM = paramInt3;
      this.dSJ = paramString2;
      this.lAP = paramString3;
      this.lAO = paramInt4;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45565);
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45561);
          os localos = new os();
          localos.dUJ.pageId = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localos.dUJ.dFN = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.b(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localos.dUJ.dUL = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.c(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localos.dUJ.dUM = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.d(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localos.dUJ.source = 0;
          EventCenter.instance.publish(localos);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this, localos.dUK.xml);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.e(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          AppMethodBeat.o(45561);
        }
      }, "JsApiOpenAdCanvas");
      AppMethodBeat.o(45565);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45564);
      String str2 = this.lAQ;
      boolean bool;
      if (this.dUL == 0)
      {
        Intent localIntent = new Intent();
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localIntent.putExtra("sns_landing_pages_xml", str1);
        localIntent.putExtra("sns_landing_pages_pageid", Util.safeParseLong(this.lAN));
        localIntent.putExtra("sns_landig_pages_from_source", 13);
        localIntent.putExtra("sns_landing_pages_extra", this.dSJ);
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        localIntent.putExtra("sns_landing_pages_no_store", this.dUM);
        localIntent.putExtra("sns_landing_pages_ad_info", this.lAP);
        if (this.lAO == 1)
        {
          bool = true;
          localIntent.putExtra("sns_landing_is_native_sight_ad", bool);
          com.tencent.mm.br.c.b((Context)this.lAM.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
          this.kGT.i(this.lqe, this.lAw.h("ok", null));
        }
      }
      for (;;)
      {
        bDK();
        AppMethodBeat.o(45564);
        return;
        bool = false;
        break;
        if (this.dUL == 1) {
          this.kGT.i(this.lqe, this.lAw.h("ok", null));
        } else {
          this.kGT.i(this.lqe, this.lAw.h("fail", null));
        }
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45566);
      this.lAN = paramParcel.readString();
      this.dUL = paramParcel.readInt();
      this.dUM = paramParcel.readInt();
      this.dSJ = paramParcel.readString();
      this.lAP = paramParcel.readString();
      this.lAQ = paramParcel.readString();
      this.lAO = paramParcel.readInt();
      AppMethodBeat.o(45566);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45567);
      paramParcel.writeString(this.lAN);
      paramParcel.writeInt(this.dUL);
      paramParcel.writeInt(this.dUM);
      paramParcel.writeString(this.dSJ);
      paramParcel.writeString(this.lAP);
      paramParcel.writeString(this.lAQ);
      paramParcel.writeInt(this.lAO);
      AppMethodBeat.o(45567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas
 * JD-Core Version:    0.7.0.1
 */