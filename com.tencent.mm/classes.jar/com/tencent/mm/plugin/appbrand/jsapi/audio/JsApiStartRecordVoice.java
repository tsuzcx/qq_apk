package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.h;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiStartRecordVoice
  extends c<v>
{
  public static final int CTRL_INDEX = 31;
  public static final String NAME = "startRecord";
  static volatile String oAv = null;
  private StartRecordVoice oAw;
  private ad ozV;
  private i.a ozW;
  
  private void ib(final boolean paramBoolean)
  {
    AppMethodBeat.i(45990);
    if (this.ozV == null)
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
      this.ozW = com.tencent.mm.plugin.appbrand.page.capsulebar.a.a.ah(this.ozV.getRuntime()).a(a.b.qwM);
      s.abW(this.ozV.getAppId()).nwd = this.ozW;
      AppMethodBeat.o(45990);
      return;
    }
    if (this.ozW != null)
    {
      this.ozW.dismiss();
      this.ozW = null;
    }
    AppMethodBeat.o(45990);
  }
  
  public final void a(final v paramv, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(45989);
    com.tencent.mm.plugin.appbrand.permission.r.a(paramv.getAppId(), new androidx.core.app.a.a()
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
          JsApiStartRecordVoice.this.a(paramv, paramJSONObject, paramInt);
          AppMethodBeat.o(45976);
          return;
        }
        paramv.j(paramInt, JsApiStartRecordVoice.this.h("fail:system permission denied", null));
        AppMethodBeat.o(45976);
      }
    });
    int k;
    if ((paramv.getContext() instanceof Activity))
    {
      localObject = (Activity)paramv.getContext();
      if (localObject != null) {
        break label91;
      }
      paramv.j(paramInt, h("fail", null));
      k = 0;
    }
    for (;;)
    {
      if (k != 0) {
        break label129;
      }
      paramv.j(paramInt, h("fail", null));
      AppMethodBeat.o(45989);
      return;
      localObject = null;
      break;
      label91:
      boolean bool = b.a((Activity)localObject, "android.permission.RECORD_AUDIO", 116, "", "");
      k = bool;
      if (bool)
      {
        com.tencent.mm.plugin.appbrand.permission.r.amk(paramv.getAppId());
        k = bool;
      }
    }
    label129:
    Object localObject = paramv.getRuntime().bBX();
    if ((((x)localObject).getCurrentPage() == null) || (((x)localObject).getCurrentPage().getCurrentPageView() == null))
    {
      paramv.j(paramInt, h("fail", null));
      AppMethodBeat.o(45989);
      return;
    }
    if (oAv != null)
    {
      paramv.j(paramInt, h("fail:audio is recording, don't start record again", null));
      AppMethodBeat.o(45989);
      return;
    }
    this.ozV = ((x)localObject).getCurrentPage().getCurrentPageView();
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
    this.ozV.a(new h.b()
    {
      public final void onBackground()
      {
        AppMethodBeat.i(45973);
        JsApiStopRecordVoice.o(paramv);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
        AppMethodBeat.o(45973);
      }
    });
    this.ozV.a(new h.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(45974);
        JsApiStopRecordVoice.o(paramv);
        JsApiStartRecordVoice.a(JsApiStartRecordVoice.this).b(this);
        AppMethodBeat.o(45974);
      }
    });
    this.oAw = new StartRecordVoice(this, paramv, j, paramInt);
    oAv = StartRecordVoice.a(this.oAw);
    this.oAw.bsM();
    ib(true);
    AppMethodBeat.o(45989);
  }
  
  static class StartRecordVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartRecordVoice> CREATOR;
    private String appId;
    private int duration;
    private String filePath;
    private v nAz;
    private JsApiStartRecordVoice oAy;
    private boolean oAz;
    private int okO;
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
      this.oAz = false;
      f(paramParcel);
      AppMethodBeat.o(45981);
    }
    
    StartRecordVoice(JsApiStartRecordVoice paramJsApiStartRecordVoice, v paramv, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(45980);
      this.oAz = false;
      this.oAy = paramJsApiStartRecordVoice;
      this.nAz = paramv;
      this.duration = paramInt1;
      this.okO = paramInt2;
      this.appId = paramv.getAppId();
      paramJsApiStartRecordVoice = w.YN(this.appId);
      i locali = new i();
      if (paramv.getFileSystem().a(locali) == m.nMR)
      {
        this.filePath = new q((String)locali.value, paramJsApiStartRecordVoice).bOF();
        AppMethodBeat.o(45980);
        return;
      }
      this.filePath = new q(paramv.getContext().getCacheDir(), paramJsApiStartRecordVoice).bOF();
      AppMethodBeat.o(45980);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45982);
      h.clV().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45978);
          JsApiStartRecordVoice.StartRecordVoice.a(JsApiStartRecordVoice.StartRecordVoice.this, com.tencent.mm.plugin.appbrand.media.record.a.a(JsApiStartRecordVoice.StartRecordVoice.a(JsApiStartRecordVoice.StartRecordVoice.this), new com.tencent.mm.plugin.appbrand.media.record.a.a()
          {
            public final void Ab(int paramAnonymous2Int)
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
    
    public final void bsK()
    {
      AppMethodBeat.i(45983);
      if (this.result == -1)
      {
        Log.e("MicroMsg.JsApiStartRecordVoice", "fail:record_error");
        this.nAz.j(this.okO, this.oAy.h("fail:record_error", null));
        AppMethodBeat.o(45983);
        return;
      }
      HashMap localHashMap;
      if (this.oAz)
      {
        localHashMap = new HashMap(1);
        i locali = new i();
        if (this.nAz.getFileSystem().a(new q(this.filePath), "silk", true, locali) == m.nMR)
        {
          localHashMap.put("tempFilePath", locali.value);
          this.nAz.j(this.okO, this.oAy.m("ok", localHashMap));
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiStartRecordVoice", "runInClientProcess, appId = %s, startRecordOk = %b", new Object[] { this.appId, Boolean.valueOf(this.oAz) });
        JsApiStartRecordVoice.a(this.oAy, false);
        AppMethodBeat.o(45983);
        return;
        Log.e("MicroMsg.JsApiStartRecordVoice", "AppBrandLocalMediaObject obj is null");
        localHashMap.put("tempFilePath", "");
        this.nAz.j(this.okO, this.oAy.h("fail", null));
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45984);
      this.okO = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.filePath = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.oAz = bool;
        this.duration = paramParcel.readInt();
        this.result = paramParcel.readInt();
        AppMethodBeat.o(45984);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45985);
      paramParcel.writeInt(this.okO);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.filePath);
      if (this.oAz) {}
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