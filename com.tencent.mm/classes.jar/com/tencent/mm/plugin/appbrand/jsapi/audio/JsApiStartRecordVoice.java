package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.record.a.a;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.a.c.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.b.a;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiStartRecordVoice
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.q>
{
  public static final int CTRL_INDEX = 31;
  public static final String NAME = "startRecord";
  static volatile String jCq = null;
  private aa jBR;
  private c.a jBS;
  private StartRecordVoice jCr;
  
  private void fP(final boolean paramBoolean)
  {
    AppMethodBeat.i(45990);
    if (this.jBR == null)
    {
      AppMethodBeat.o(45990);
      return;
    }
    if (!aq.isMainThread())
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45975);
          JsApiStartRecordVoice.a(JsApiStartRecordVoice.this, paramBoolean);
          AppMethodBeat.o(45975);
        }
      });
      AppMethodBeat.o(45990);
      return;
    }
    if (paramBoolean)
    {
      this.jBS = com.tencent.mm.plugin.appbrand.page.b.ai(this.jBR.getRuntime()).a(b.a.kXD);
      n.Dp(this.jBR.getAppId()).iFO = this.jBS;
      AppMethodBeat.o(45990);
      return;
    }
    if (this.jBS != null)
    {
      this.jBS.dismiss();
      this.jBS = null;
    }
    AppMethodBeat.o(45990);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.q paramq, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45989);
    o.a(paramq.getAppId(), new JsApiStartRecordVoice.4(this, paramq, paramJSONObject, paramInt));
    int k;
    if ((paramq.getContext() instanceof Activity))
    {
      localObject = (Activity)paramq.getContext();
      if (localObject != null) {
        break label91;
      }
      paramq.h(paramInt, e("fail", null));
      k = 0;
    }
    for (;;)
    {
      if (k != 0) {
        break label129;
      }
      paramq.h(paramInt, e("fail", null));
      AppMethodBeat.o(45989);
      return;
      localObject = null;
      break;
      label91:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 116, "", "");
      k = bool;
      if (bool)
      {
        o.Mi(paramq.getAppId());
        k = bool;
      }
    }
    label129:
    Object localObject = paramq.getRuntime().aLK();
    if ((((t)localObject).getCurrentPage() == null) || (((t)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramq.h(paramInt, e("fail", null));
      AppMethodBeat.o(45989);
      return;
    }
    if (jCq != null)
    {
      paramq.h(paramInt, e("fail:audio is recording, don't start record again", null));
      AppMethodBeat.o(45989);
      return;
    }
    this.jBR = ((t)localObject).getCurrentPage().getCurrentPageView();
    int j = paramJSONObject.optInt("duration", 60);
    int i = j;
    if (j <= 0)
    {
      ad.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
      i = 60;
    }
    j = i;
    if (i > 600)
    {
      ad.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", new Object[] { Integer.valueOf(600) });
      j = 600;
    }
    this.jBR.a(new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(45973);
        JsApiStopRecordVoice.m(paramq);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
        AppMethodBeat.o(45973);
      }
    });
    this.jBR.a(new f.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(45974);
        JsApiStopRecordVoice.m(paramq);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
        AppMethodBeat.o(45974);
      }
    });
    this.jCr = new StartRecordVoice(this, paramq, j, paramInt);
    jCq = StartRecordVoice.a(this.jCr);
    AppBrandMainProcessService.a(this.jCr);
    fP(true);
    AppMethodBeat.o(45989);
  }
  
  static class StartRecordVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartRecordVoice> CREATOR;
    private String appId;
    private int duration;
    private String filePath;
    private com.tencent.mm.plugin.appbrand.q iIL;
    private JsApiStartRecordVoice jCt;
    private boolean jCu;
    private int joH;
    private int result;
    
    static
    {
      AppMethodBeat.i(45988);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45988);
    }
    
    StartRecordVoice(Parcel paramParcel)
    {
      AppMethodBeat.i(45981);
      this.jCu = false;
      e(paramParcel);
      AppMethodBeat.o(45981);
    }
    
    StartRecordVoice(JsApiStartRecordVoice paramJsApiStartRecordVoice, com.tencent.mm.plugin.appbrand.q paramq, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(45980);
      this.jCu = false;
      this.jCt = paramJsApiStartRecordVoice;
      this.iIL = paramq;
      this.duration = paramInt1;
      this.joH = paramInt2;
      this.appId = paramq.getAppId();
      paramJsApiStartRecordVoice = w.AI(this.appId);
      i locali = new i();
      if (paramq.Ee().a(locali) == l.iSq)
      {
        this.filePath = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e((String)locali.value, paramJsApiStartRecordVoice).fhU());
        AppMethodBeat.o(45980);
        return;
      }
      this.filePath = com.tencent.mm.vfs.q.B(new com.tencent.mm.vfs.e(paramq.getContext().getCacheDir(), paramJsApiStartRecordVoice).fhU());
      AppMethodBeat.o(45980);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45983);
      if (this.result == -1)
      {
        ad.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
        this.iIL.h(this.joH, this.jCt.e("fail:record_error", null));
        AppMethodBeat.o(45983);
        return;
      }
      HashMap localHashMap;
      if (this.jCu)
      {
        localHashMap = new HashMap(1);
        i locali = new i();
        if (this.iIL.Ee().a(new com.tencent.mm.vfs.e(this.filePath), "silk", true, locali) == l.iSq)
        {
          localHashMap.put("tempFilePath", locali.value);
          this.iIL.h(this.joH, this.jCt.k("ok", localHashMap));
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[] { this.appId, Boolean.valueOf(this.jCu) });
        JsApiStartRecordVoice.a(this.jCt, false);
        AppMethodBeat.o(45983);
        return;
        ad.e("MicroMsg.JsApiStartRecordVoice", "AppBrandLocalMediaObject obj is null");
        localHashMap.put("tempFilePath", "");
        this.iIL.h(this.joH, this.jCt.e("fail", null));
      }
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45982);
      com.tencent.mm.plugin.appbrand.utils.e.bqm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45978);
          JsApiStartRecordVoice.StartRecordVoice.a(JsApiStartRecordVoice.StartRecordVoice.this, com.tencent.mm.plugin.appbrand.media.record.a.a(JsApiStartRecordVoice.StartRecordVoice.a(JsApiStartRecordVoice.StartRecordVoice.this), new a.a()
          {
            public final void rw(int paramAnonymous2Int)
            {
              AppMethodBeat.i(45977);
              JsApiStartRecordVoice.StartRecordVoice.a(JsApiStartRecordVoice.StartRecordVoice.this, paramAnonymous2Int);
              JsApiStartRecordVoice.StartRecordVoice.b(JsApiStartRecordVoice.StartRecordVoice.this);
              AppMethodBeat.o(45977);
            }
          }, JsApiStartRecordVoice.StartRecordVoice.c(JsApiStartRecordVoice.StartRecordVoice.this) * 1000));
          if (!JsApiStartRecordVoice.StartRecordVoice.d(JsApiStartRecordVoice.StartRecordVoice.this)) {
            JsApiStartRecordVoice.StartRecordVoice.e(JsApiStartRecordVoice.StartRecordVoice.this);
          }
          AppMethodBeat.o(45978);
        }
      });
      AppMethodBeat.o(45982);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45984);
      this.joH = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.filePath = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.jCu = bool;
        this.duration = paramParcel.readInt();
        this.result = paramParcel.readInt();
        AppMethodBeat.o(45984);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45985);
      paramParcel.writeInt(this.joH);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.filePath);
      if (this.jCu) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        paramParcel.writeInt(this.duration);
        paramParcel.writeInt(this.result);
        AppMethodBeat.o(45985);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice
 * JD-Core Version:    0.7.0.1
 */