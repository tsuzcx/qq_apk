package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.page.capsulebar.m.a;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.permission.s;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.ah;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiStartRecordVoice
  extends c<y>
{
  public static final int CTRL_INDEX = 31;
  public static final String NAME = "startRecord";
  static volatile String rEo = null;
  private ad rDO;
  private m.a rDP;
  private StartRecordVoice rEp;
  
  private void ja(final boolean paramBoolean)
  {
    AppMethodBeat.i(45990);
    if (this.rDO == null)
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
      this.rDP = com.tencent.mm.plugin.appbrand.page.capsulebar.a.a.av(this.rDO.getRuntime()).a(a.b.tBL);
      com.tencent.mm.plugin.appbrand.u.Uy(this.rDO.getAppId()).qva = this.rDP;
      AppMethodBeat.o(45990);
      return;
    }
    if (this.rDP != null)
    {
      this.rDP.dismiss();
      this.rDP = null;
    }
    AppMethodBeat.o(45990);
  }
  
  public final void a(final y paramy, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45989);
    s.a(paramy.getAppId(), new androidx.core.app.a.a()
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
          JsApiStartRecordVoice.this.a(paramy, paramJSONObject, paramInt);
          AppMethodBeat.o(45976);
          return;
        }
        paramy.callback(paramInt, JsApiStartRecordVoice.this.ZP("fail:system permission denied"));
        AppMethodBeat.o(45976);
      }
    });
    int k;
    if ((paramy.getContext() instanceof Activity))
    {
      localObject = (Activity)paramy.getContext();
      if (localObject != null) {
        break label89;
      }
      paramy.callback(paramInt, ZP("fail"));
      k = 0;
    }
    for (;;)
    {
      if (k != 0) {
        break label128;
      }
      paramy.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(45989);
      return;
      localObject = null;
      break;
      label89:
      boolean bool = i.a((Activity)localObject, paramy, "android.permission.RECORD_AUDIO", 116, "", "");
      k = bool;
      if (bool)
      {
        s.afs(paramy.getAppId());
        k = bool;
      }
    }
    label128:
    Object localObject = paramy.getRuntime().getPageContainer();
    if ((((x)localObject).getCurrentPage() == null) || (((x)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramy.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(45989);
      return;
    }
    if (rEo != null)
    {
      paramy.callback(paramInt, ZP("fail:audio is recording, don't start record again"));
      AppMethodBeat.o(45989);
      return;
    }
    this.rDO = ((x)localObject).getCurrentPage().getCurrentPageView();
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
    this.rDO.a(new i.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(45973);
        JsApiStopRecordVoice.o(paramy);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
        AppMethodBeat.o(45973);
      }
    });
    this.rDO.a(new i.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(45974);
        JsApiStopRecordVoice.o(paramy);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
        AppMethodBeat.o(45974);
      }
    });
    this.rEp = new StartRecordVoice(this, paramy, j, paramInt);
    rEo = StartRecordVoice.a(this.rEp);
    this.rEp.bQt();
    ja(true);
    AppMethodBeat.o(45989);
  }
  
  static class StartRecordVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartRecordVoice> CREATOR;
    private String appId;
    private int duration;
    private String filePath;
    private y qqV;
    private JsApiStartRecordVoice rEr;
    private boolean rEs;
    private int result;
    private int ror;
    
    static
    {
      AppMethodBeat.i(45988);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45988);
    }
    
    StartRecordVoice(Parcel paramParcel)
    {
      AppMethodBeat.i(45981);
      this.rEs = false;
      h(paramParcel);
      AppMethodBeat.o(45981);
    }
    
    StartRecordVoice(JsApiStartRecordVoice paramJsApiStartRecordVoice, y paramy, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(45980);
      this.rEs = false;
      this.rEr = paramJsApiStartRecordVoice;
      this.qqV = paramy;
      this.duration = paramInt1;
      this.ror = paramInt2;
      this.appId = paramy.getAppId();
      paramJsApiStartRecordVoice = com.tencent.mm.modelvoice.w.QS(this.appId);
      k localk = new k();
      if (paramy.getFileSystem().a(localk) == r.qML)
      {
        this.filePath = ah.v(new com.tencent.mm.vfs.u((String)localk.value, paramJsApiStartRecordVoice).jKT());
        AppMethodBeat.o(45980);
        return;
      }
      this.filePath = ah.v(new com.tencent.mm.vfs.u(paramy.getContext().getCacheDir(), paramJsApiStartRecordVoice).jKT());
      AppMethodBeat.o(45980);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45982);
      l.cNm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45978);
          JsApiStartRecordVoice.StartRecordVoice.a(JsApiStartRecordVoice.StartRecordVoice.this, com.tencent.mm.plugin.appbrand.media.record.a.a(JsApiStartRecordVoice.StartRecordVoice.a(JsApiStartRecordVoice.StartRecordVoice.this), new com.tencent.mm.plugin.appbrand.media.record.a.a()
          {
            public final void As(int paramAnonymous2Int)
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
    
    public final void bQr()
    {
      AppMethodBeat.i(45983);
      if (this.result == -1)
      {
        Log.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
        this.qqV.callback(this.ror, this.rEr.ZP("fail:record_error"));
        AppMethodBeat.o(45983);
        return;
      }
      HashMap localHashMap;
      if (this.rEs)
      {
        localHashMap = new HashMap(1);
        k localk = new k();
        if (this.qqV.getFileSystem().a(new com.tencent.mm.vfs.u(this.filePath), "silk", true, localk) == r.qML)
        {
          localHashMap.put("tempFilePath", (String)localk.value);
          this.qqV.callback(this.ror, this.rEr.m("ok", localHashMap));
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[] { this.appId, Boolean.valueOf(this.rEs) });
        JsApiStartRecordVoice.a(this.rEr, false);
        AppMethodBeat.o(45983);
        return;
        Log.e("MicroMsg.JsApiStartRecordVoice", "AppBrandLocalMediaObject obj is null");
        localHashMap.put("tempFilePath", "");
        this.qqV.callback(this.ror, this.rEr.ZP("fail"));
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(45984);
      this.ror = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.filePath = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.rEs = bool;
        this.duration = paramParcel.readInt();
        this.result = paramParcel.readInt();
        AppMethodBeat.o(45984);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45985);
      paramParcel.writeInt(this.ror);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.filePath);
      if (this.rEs) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice
 * JD-Core Version:    0.7.0.1
 */