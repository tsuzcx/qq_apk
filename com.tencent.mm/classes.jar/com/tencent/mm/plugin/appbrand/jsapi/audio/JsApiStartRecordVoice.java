package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.f;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiStartRecordVoice
  extends d<s>
{
  public static final int CTRL_INDEX = 31;
  public static final String NAME = "startRecord";
  static volatile String lEU = null;
  private StartRecordVoice lEV;
  private ac lEu;
  private i.a lEv;
  
  private void hl(final boolean paramBoolean)
  {
    AppMethodBeat.i(45990);
    if (this.lEu == null)
    {
      AppMethodBeat.o(45990);
      return;
    }
    if (!MMHandlerThread.isMainThread())
    {
      MMHandlerThread.postToMainThread(new Runnable()
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
      this.lEv = com.tencent.mm.plugin.appbrand.page.capsulebar.a.a.ah(this.lEu.getRuntime()).a(a.b.nuR);
      com.tencent.mm.plugin.appbrand.p.Un(this.lEu.getAppId()).kCS = this.lEv;
      AppMethodBeat.o(45990);
      return;
    }
    if (this.lEv != null)
    {
      this.lEv.dismiss();
      this.lEv = null;
    }
    AppMethodBeat.o(45990);
  }
  
  public final void a(final s params, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45989);
    r.a(params.getAppId(), new android.support.v4.app.a.a()
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
          JsApiStartRecordVoice.this.a(params, paramJSONObject, paramInt);
          AppMethodBeat.o(45976);
          return;
        }
        params.i(paramInt, JsApiStartRecordVoice.this.h("fail:system permission denied", null));
        AppMethodBeat.o(45976);
      }
    });
    int k;
    if ((params.getContext() instanceof Activity))
    {
      localObject = (Activity)params.getContext();
      if (localObject != null) {
        break label91;
      }
      params.i(paramInt, h("fail", null));
      k = 0;
    }
    for (;;)
    {
      if (k != 0) {
        break label129;
      }
      params.i(paramInt, h("fail", null));
      AppMethodBeat.o(45989);
      return;
      localObject = null;
      break;
      label91:
      boolean bool = b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 116, "", "");
      k = bool;
      if (bool)
      {
        r.aeq(params.getAppId());
        k = bool;
      }
    }
    label129:
    Object localObject = params.getRuntime().brh();
    if ((((com.tencent.mm.plugin.appbrand.page.w)localObject).getCurrentPage() == null) || (((com.tencent.mm.plugin.appbrand.page.w)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      params.i(paramInt, h("fail", null));
      AppMethodBeat.o(45989);
      return;
    }
    if (lEU != null)
    {
      params.i(paramInt, h("fail:audio is recording, don't start record again", null));
      AppMethodBeat.o(45989);
      return;
    }
    this.lEu = ((com.tencent.mm.plugin.appbrand.page.w)localObject).getCurrentPage().getCurrentPageView();
    int j = paramJSONObject.optInt("duration", 60);
    int i = j;
    if (j <= 0)
    {
      Log.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
      i = 60;
    }
    j = i;
    if (i > 600)
    {
      Log.e("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", new Object[] { Integer.valueOf(600) });
      j = 600;
    }
    this.lEu.a(new i.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(45973);
        JsApiStopRecordVoice.o(params);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
        AppMethodBeat.o(45973);
      }
    });
    this.lEu.a(new i.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(45974);
        JsApiStopRecordVoice.o(params);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
        AppMethodBeat.o(45974);
      }
    });
    this.lEV = new StartRecordVoice(this, params, j, paramInt);
    lEU = StartRecordVoice.a(this.lEV);
    AppBrandMainProcessService.a(this.lEV);
    hl(true);
    AppMethodBeat.o(45989);
  }
  
  static class StartRecordVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartRecordVoice> CREATOR;
    private String appId;
    private int duration;
    private String filePath;
    private s kGT;
    private JsApiStartRecordVoice lEX;
    private boolean lEY;
    private int lqe;
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
      this.lEY = false;
      f(paramParcel);
      AppMethodBeat.o(45981);
    }
    
    StartRecordVoice(JsApiStartRecordVoice paramJsApiStartRecordVoice, s params, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(45980);
      this.lEY = false;
      this.lEX = paramJsApiStartRecordVoice;
      this.kGT = params;
      this.duration = paramInt1;
      this.lqe = paramInt2;
      this.appId = params.getAppId();
      paramJsApiStartRecordVoice = com.tencent.mm.modelvoice.w.Rq(this.appId);
      i locali = new i();
      if (params.getFileSystem().a(locali) == m.kSu)
      {
        this.filePath = aa.z(new o((String)locali.value, paramJsApiStartRecordVoice).her());
        AppMethodBeat.o(45980);
        return;
      }
      this.filePath = aa.z(new o(params.getContext().getCacheDir(), paramJsApiStartRecordVoice).her());
      AppMethodBeat.o(45980);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45982);
      f.bZn().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45978);
          JsApiStartRecordVoice.StartRecordVoice.a(JsApiStartRecordVoice.StartRecordVoice.this, com.tencent.mm.plugin.appbrand.media.record.a.a(JsApiStartRecordVoice.StartRecordVoice.a(JsApiStartRecordVoice.StartRecordVoice.this), new com.tencent.mm.plugin.appbrand.media.record.a.a()
          {
            public final void wM(int paramAnonymous2Int)
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
    
    public final void bjk()
    {
      AppMethodBeat.i(45983);
      if (this.result == -1)
      {
        Log.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
        this.kGT.i(this.lqe, this.lEX.h("fail:record_error", null));
        AppMethodBeat.o(45983);
        return;
      }
      HashMap localHashMap;
      if (this.lEY)
      {
        localHashMap = new HashMap(1);
        i locali = new i();
        if (this.kGT.getFileSystem().a(new o(this.filePath), "silk", true, locali) == m.kSu)
        {
          localHashMap.put("tempFilePath", locali.value);
          this.kGT.i(this.lqe, this.lEX.n("ok", localHashMap));
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[] { this.appId, Boolean.valueOf(this.lEY) });
        JsApiStartRecordVoice.a(this.lEX, false);
        AppMethodBeat.o(45983);
        return;
        Log.e("MicroMsg.JsApiStartRecordVoice", "AppBrandLocalMediaObject obj is null");
        localHashMap.put("tempFilePath", "");
        this.kGT.i(this.lqe, this.lEX.h("fail", null));
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45984);
      this.lqe = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.filePath = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.lEY = bool;
        this.duration = paramParcel.readInt();
        this.result = paramParcel.readInt();
        AppMethodBeat.o(45984);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45985);
      paramParcel.writeInt(this.lqe);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.filePath);
      if (this.lEY) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice
 * JD-Core Version:    0.7.0.1
 */