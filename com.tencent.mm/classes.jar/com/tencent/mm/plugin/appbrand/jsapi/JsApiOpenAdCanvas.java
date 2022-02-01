package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.pp;
import com.tencent.mm.f.a.pp.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.ref.WeakReference;

public final class JsApiOpenAdCanvas
  extends c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 476;
  public static final String NAME = "openADCanvas";
  private String owb = "";
  private JsApiOpenAdCanvasTask owc = null;
  
  static class JsApiOpenAdCanvasTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiOpenAdCanvasTask> CREATOR;
    private WeakReference<Context> context;
    private String fMh;
    private int fOn;
    private int fOo;
    private v nAz;
    private int okO;
    private o ovN;
    private String owd;
    private int owe;
    private String owf;
    private String owg;
    
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
    
    public JsApiOpenAdCanvasTask(o paramo, v paramv, int paramInt1, WeakReference<Context> paramWeakReference, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, int paramInt4)
    {
      this.ovN = paramo;
      this.nAz = paramv;
      this.okO = paramInt1;
      this.context = paramWeakReference;
      this.owd = paramString1;
      this.fOn = paramInt2;
      this.fOo = paramInt3;
      this.fMh = paramString2;
      this.owf = paramString3;
      this.owe = paramInt4;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45565);
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45561);
          pp localpp = new pp();
          localpp.fOl.pageId = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localpp.fOl.fyu = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.b(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localpp.fOl.fOn = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.c(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localpp.fOl.fOo = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.d(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localpp.fOl.source = 0;
          EventCenter.instance.publish(localpp);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this, localpp.fOm.xml);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.e(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          AppMethodBeat.o(45561);
        }
      }, "JsApiOpenAdCanvas");
      AppMethodBeat.o(45565);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45564);
      String str2 = this.owg;
      boolean bool;
      if (this.fOn == 0)
      {
        Intent localIntent = new Intent();
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localIntent.putExtra("sns_landing_pages_xml", str1);
        localIntent.putExtra("sns_landing_pages_pageid", Util.safeParseLong(this.owd));
        localIntent.putExtra("sns_landig_pages_from_source", 28);
        localIntent.putExtra("sns_landing_pages_extra", this.fMh);
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        localIntent.putExtra("sns_landing_pages_no_store", this.fOo);
        localIntent.putExtra("sns_landing_pages_ad_info", this.owf);
        if (this.owe == 1)
        {
          bool = true;
          localIntent.putExtra("sns_landing_is_native_sight_ad", bool);
          com.tencent.mm.by.c.b((Context)this.context.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
          this.nAz.j(this.okO, this.ovN.h("ok", null));
        }
      }
      for (;;)
      {
        bPk();
        AppMethodBeat.o(45564);
        return;
        bool = false;
        break;
        if (this.fOn == 1) {
          this.nAz.j(this.okO, this.ovN.h("ok", null));
        } else {
          this.nAz.j(this.okO, this.ovN.h("fail", null));
        }
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45566);
      this.owd = paramParcel.readString();
      this.fOn = paramParcel.readInt();
      this.fOo = paramParcel.readInt();
      this.fMh = paramParcel.readString();
      this.owf = paramParcel.readString();
      this.owg = paramParcel.readString();
      this.owe = paramParcel.readInt();
      AppMethodBeat.o(45566);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45567);
      paramParcel.writeString(this.owd);
      paramParcel.writeInt(this.fOn);
      paramParcel.writeInt(this.fOo);
      paramParcel.writeString(this.fMh);
      paramParcel.writeString(this.owf);
      paramParcel.writeString(this.owg);
      paramParcel.writeInt(this.owe);
      AppMethodBeat.o(45567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas
 * JD-Core Version:    0.7.0.1
 */