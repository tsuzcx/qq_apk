package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.rc;
import com.tencent.mm.autogen.a.rc.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.lang.ref.WeakReference;

public final class JsApiOpenAdCanvas
  extends c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 476;
  public static final String NAME = "openADCanvas";
  private String rzv = "";
  private JsApiOpenAdCanvasTask rzw = null;
  
  static class JsApiOpenAdCanvasTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiOpenAdCanvasTask> CREATOR;
    private WeakReference<Context> context;
    private String hRR;
    private int hUg;
    private int hUh;
    private y qqV;
    private int ror;
    private String rzA;
    private p rzh;
    private String rzx;
    private int rzy;
    private String rzz;
    
    static
    {
      AppMethodBeat.i(45569);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45569);
    }
    
    public JsApiOpenAdCanvasTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45563);
      h(paramParcel);
      AppMethodBeat.o(45563);
    }
    
    public JsApiOpenAdCanvasTask(p paramp, y paramy, int paramInt1, WeakReference<Context> paramWeakReference, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, int paramInt4)
    {
      this.rzh = paramp;
      this.qqV = paramy;
      this.ror = paramInt1;
      this.context = paramWeakReference;
      this.rzx = paramString1;
      this.hUg = paramInt2;
      this.hUh = paramInt3;
      this.hRR = paramString2;
      this.rzz = paramString3;
      this.rzy = paramInt4;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45565);
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45561);
          rc localrc = new rc();
          localrc.hUd.hUf = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localrc.hUd.hDd = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.b(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localrc.hUd.hUg = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.c(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localrc.hUd.hUh = JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.d(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          localrc.hUd.source = 0;
          localrc.publish();
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.a(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this, localrc.hUe.xml);
          JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.e(JsApiOpenAdCanvas.JsApiOpenAdCanvasTask.this);
          AppMethodBeat.o(45561);
        }
      }, "JsApiOpenAdCanvas");
      AppMethodBeat.o(45565);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45564);
      String str2 = this.rzA;
      boolean bool;
      if (this.hUg == 0)
      {
        Intent localIntent = new Intent();
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localIntent.putExtra("sns_landing_pages_xml", str1);
        localIntent.putExtra("sns_landing_pages_pageid", Util.safeParseLong(this.rzx));
        localIntent.putExtra("sns_landig_pages_from_source", 28);
        localIntent.putExtra("sns_landing_pages_extra", this.hRR);
        localIntent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        localIntent.putExtra("sns_landing_pages_no_store", this.hUh);
        localIntent.putExtra("sns_landing_pages_ad_info", this.rzz);
        if (this.rzy == 1)
        {
          bool = true;
          localIntent.putExtra("sns_landing_is_native_sight_ad", bool);
          com.tencent.mm.br.c.b((Context)this.context.get(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", localIntent);
          this.qqV.callback(this.ror, this.rzh.ZP("ok"));
        }
      }
      for (;;)
      {
        cpx();
        AppMethodBeat.o(45564);
        return;
        bool = false;
        break;
        if (this.hUg == 1) {
          this.qqV.callback(this.ror, this.rzh.ZP("ok"));
        } else {
          this.qqV.callback(this.ror, this.rzh.ZP("fail"));
        }
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(45566);
      this.rzx = paramParcel.readString();
      this.hUg = paramParcel.readInt();
      this.hUh = paramParcel.readInt();
      this.hRR = paramParcel.readString();
      this.rzz = paramParcel.readString();
      this.rzA = paramParcel.readString();
      this.rzy = paramParcel.readInt();
      AppMethodBeat.o(45566);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45567);
      paramParcel.writeString(this.rzx);
      paramParcel.writeInt(this.hUg);
      paramParcel.writeInt(this.hUh);
      paramParcel.writeString(this.hRR);
      paramParcel.writeString(this.rzz);
      paramParcel.writeString(this.rzA);
      paramParcel.writeInt(this.rzy);
      AppMethodBeat.o(45567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenAdCanvas
 * JD-Core Version:    0.7.0.1
 */