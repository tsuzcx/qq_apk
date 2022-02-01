package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.vfs.k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiStartRecordVoice
  extends com.tencent.mm.plugin.appbrand.jsapi.a<com.tencent.mm.plugin.appbrand.r>
{
  public static final int CTRL_INDEX = 31;
  public static final String NAME = "startRecord";
  static volatile String kAB = null;
  private StartRecordVoice kAC;
  private z kAb;
  private i.a kAc;
  
  private void go(final boolean paramBoolean)
  {
    AppMethodBeat.i(45990);
    if (this.kAb == null)
    {
      AppMethodBeat.o(45990);
      return;
    }
    if (!ar.isMainThread())
    {
      ar.f(new Runnable()
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
      this.kAc = com.tencent.mm.plugin.appbrand.page.capsulebar.a.a.ag(this.kAb.getRuntime()).a(a.b.mku);
      o.Le(this.kAb.getAppId()).jBW = this.kAc;
      AppMethodBeat.o(45990);
      return;
    }
    if (this.kAc != null)
    {
      this.kAc.dismiss();
      this.kAc = null;
    }
    AppMethodBeat.o(45990);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.r paramr, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45989);
    com.tencent.mm.plugin.appbrand.permission.r.a(paramr.getAppId(), new android.support.v4.app.a.a()
    {
      public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
      {
        AppMethodBeat.i(45976);
        if (paramAnonymousInt != 116)
        {
          AppMethodBeat.o(45976);
          return;
        }
        if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
        {
          JsApiStartRecordVoice.this.a(paramr, paramJSONObject, paramInt);
          AppMethodBeat.o(45976);
          return;
        }
        paramr.h(paramInt, JsApiStartRecordVoice.this.e("fail:system permission denied", null));
        AppMethodBeat.o(45976);
      }
    });
    int k;
    if ((paramr.getContext() instanceof Activity))
    {
      localObject = (Activity)paramr.getContext();
      if (localObject != null) {
        break label91;
      }
      paramr.h(paramInt, e("fail", null));
      k = 0;
    }
    for (;;)
    {
      if (k != 0) {
        break label129;
      }
      paramr.h(paramInt, e("fail", null));
      AppMethodBeat.o(45989);
      return;
      localObject = null;
      break;
      label91:
      boolean bool = b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 116, "", "");
      k = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.r.UC(paramr.getAppId());
        k = bool;
      }
    }
    label129:
    Object localObject = paramr.getRuntime().aWm();
    if ((((t)localObject).getCurrentPage() == null) || (((t)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramr.h(paramInt, e("fail", null));
      AppMethodBeat.o(45989);
      return;
    }
    if (kAB != null)
    {
      paramr.h(paramInt, e("fail:audio is recording, don't start record again", null));
      AppMethodBeat.o(45989);
      return;
    }
    this.kAb = ((t)localObject).getCurrentPage().getCurrentPageView();
    int j = paramJSONObject.optInt("duration", 60);
    int i = j;
    if (j <= 0)
    {
      ae.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
      i = 60;
    }
    j = i;
    if (i > 600)
    {
      ae.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", new Object[] { Integer.valueOf(600) });
      j = 600;
    }
    this.kAb.a(new f.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(45973);
        JsApiStopRecordVoice.m(paramr);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
        AppMethodBeat.o(45973);
      }
    });
    this.kAb.a(new f.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(45974);
        JsApiStopRecordVoice.m(paramr);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
        AppMethodBeat.o(45974);
      }
    });
    this.kAC = new StartRecordVoice(this, paramr, j, paramInt);
    kAB = StartRecordVoice.a(this.kAC);
    AppBrandMainProcessService.a(this.kAC);
    go(true);
    AppMethodBeat.o(45989);
  }
  
  static class StartRecordVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartRecordVoice> CREATOR;
    private String appId;
    private int duration;
    private String filePath;
    private com.tencent.mm.plugin.appbrand.r jFj;
    private JsApiStartRecordVoice kAE;
    private boolean kAF;
    private int kmu;
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
      this.kAF = false;
      e(paramParcel);
      AppMethodBeat.o(45981);
    }
    
    StartRecordVoice(JsApiStartRecordVoice paramJsApiStartRecordVoice, com.tencent.mm.plugin.appbrand.r paramr, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(45980);
      this.kAF = false;
      this.kAE = paramJsApiStartRecordVoice;
      this.jFj = paramr;
      this.duration = paramInt1;
      this.kmu = paramInt2;
      this.appId = paramr.getAppId();
      paramJsApiStartRecordVoice = com.tencent.mm.modelvoice.w.IE(this.appId);
      i locali = new i();
      if (paramr.Fl().a(locali) == com.tencent.mm.plugin.appbrand.appstorage.m.jPM)
      {
        this.filePath = com.tencent.mm.vfs.w.B(new k((String)locali.value, paramJsApiStartRecordVoice).fTh());
        AppMethodBeat.o(45980);
        return;
      }
      this.filePath = com.tencent.mm.vfs.w.B(new k(paramr.getContext().getCacheDir(), paramJsApiStartRecordVoice).fTh());
      AppMethodBeat.o(45980);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45982);
      f.bCj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45978);
          JsApiStartRecordVoice.StartRecordVoice.a(JsApiStartRecordVoice.StartRecordVoice.this, com.tencent.mm.plugin.appbrand.media.record.a.a(JsApiStartRecordVoice.StartRecordVoice.a(JsApiStartRecordVoice.StartRecordVoice.this), new com.tencent.mm.plugin.appbrand.media.record.a.a()
          {
            public final void sQ(int paramAnonymous2Int)
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
    
    public final void aOY()
    {
      AppMethodBeat.i(45983);
      if (this.result == -1)
      {
        ae.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
        this.jFj.h(this.kmu, this.kAE.e("fail:record_error", null));
        AppMethodBeat.o(45983);
        return;
      }
      HashMap localHashMap;
      if (this.kAF)
      {
        localHashMap = new HashMap(1);
        i locali = new i();
        if (this.jFj.Fl().a(new k(this.filePath), "silk", true, locali) == com.tencent.mm.plugin.appbrand.appstorage.m.jPM)
        {
          localHashMap.put("tempFilePath", locali.value);
          this.jFj.h(this.kmu, this.kAE.n("ok", localHashMap));
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[] { this.appId, Boolean.valueOf(this.kAF) });
        JsApiStartRecordVoice.a(this.kAE, false);
        AppMethodBeat.o(45983);
        return;
        ae.e("MicroMsg.JsApiStartRecordVoice", "AppBrandLocalMediaObject obj is null");
        localHashMap.put("tempFilePath", "");
        this.jFj.h(this.kmu, this.kAE.e("fail", null));
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45984);
      this.kmu = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.filePath = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.kAF = bool;
        this.duration = paramParcel.readInt();
        this.result = paramParcel.readInt();
        AppMethodBeat.o(45984);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45985);
      paramParcel.writeInt(this.kmu);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.filePath);
      if (this.kAF) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice
 * JD-Core Version:    0.7.0.1
 */