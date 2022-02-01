package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import androidx.core.app.a.a;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.permission.s;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.y;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo
  extends c
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  private static volatile boolean sgz = false;
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46571);
    if (sgz)
    {
      paramf.callback(paramInt, ZP("cancel"));
      AppMethodBeat.o(46571);
      return;
    }
    Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(46571);
      return;
    }
    ChooseRequest localChooseRequest = new ChooseRequest();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
    String str = paramJSONObject.optString("maxDuration");
    Log.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", new Object[] { localJSONArray, str });
    int i;
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      localChooseRequest.sft = true;
      localChooseRequest.sfu = true;
      localChooseRequest.sgB = paramJSONObject.optBoolean("compressed", true);
      if (!localChooseRequest.sft) {
        break label299;
      }
      s.a(paramf.getAppId(), new a.a()
      {
        public final void onRequestPermissionsResult(int paramAnonymousInt, String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
        {
          AppMethodBeat.i(46546);
          if (paramAnonymousInt != 115)
          {
            AppMethodBeat.o(46546);
            return;
          }
          if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
          {
            JsApiChooseVideo.this.a(paramf, paramJSONObject, paramInt);
            AppMethodBeat.o(46546);
            return;
          }
          paramf.callback(paramInt, JsApiChooseVideo.this.ZP("fail:system permission denied"));
          AppMethodBeat.o(46546);
        }
      });
      paramJSONObject = paramf.getContext();
      if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
        break label259;
      }
      paramf.callback(paramInt, ZP("fail"));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label299;
      }
      AppMethodBeat.o(46571);
      return;
      localChooseRequest.sft = localJSONArray.toString().contains("camera");
      localChooseRequest.sfu = localJSONArray.toString().contains("album");
      break;
      label259:
      boolean bool = i.a((Activity)paramJSONObject, "android.permission.CAMERA", "", "");
      i = bool;
      if (bool)
      {
        s.afs(paramf.getAppId());
        i = bool;
      }
    }
    label299:
    sgz = true;
    com.tencent.mm.plugin.appbrand.k.a(paramf.getAppId(), new k.c()
    {
      public final void onResume()
      {
        AppMethodBeat.i(46544);
        JsApiChooseVideo.aAs();
        com.tencent.mm.plugin.appbrand.k.b(paramf.getAppId(), this);
        AppMethodBeat.o(46544);
      }
    });
    localChooseRequest.maxDuration = Util.getInt(str, 60);
    localChooseRequest.appId = paramf.getAppId();
    a.b(localContext, localChooseRequest, new AppBrandProxyUIProcessTask.b() {});
    AppMethodBeat.o(46571);
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    int maxDuration;
    boolean sft;
    boolean sfu;
    boolean sgB;
    
    static
    {
      AppMethodBeat.i(46551);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46551);
    }
    
    ChooseRequest() {}
    
    ChooseRequest(Parcel paramParcel)
    {
      AppMethodBeat.i(46550);
      readParcel(paramParcel);
      AppMethodBeat.o(46550);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> getTaskClass()
    {
      return JsApiChooseVideo.a.class;
    }
    
    public final String getUIAlias()
    {
      return "GalleryChooseVideo";
    }
    
    public final boolean oneShotForeground()
    {
      return true;
    }
    
    public final void readParcel(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46548);
      this.appId = paramParcel.readString();
      this.maxDuration = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.sft = bool1;
        if (paramParcel.readByte() == 0) {
          break label76;
        }
        bool1 = true;
        label46:
        this.sfu = bool1;
        if (paramParcel.readByte() == 0) {
          break label81;
        }
      }
      label76:
      label81:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.sgB = bool1;
        AppMethodBeat.o(46548);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label46;
      }
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      byte b2 = 1;
      AppMethodBeat.i(46549);
      paramParcel.writeString(this.appId);
      paramParcel.writeInt(this.maxDuration);
      if (this.sft)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.sfu) {
          break label78;
        }
        b1 = 1;
        label47:
        paramParcel.writeByte(b1);
        if (!this.sgB) {
          break label83;
        }
      }
      label78:
      label83:
      for (byte b1 = b2;; b1 = 0)
      {
        paramParcel.writeByte(b1);
        AppMethodBeat.o(46549);
        return;
        b1 = 0;
        break;
        b1 = 0;
        break label47;
      }
    }
  }
  
  static final class ChooseResult
    extends AppBrandProxyUIProcessTask.ProcessResult
  {
    public static final Parcelable.Creator<ChooseResult> CREATOR;
    int resultCode;
    AppBrandLocalVideoObject sgC;
    
    static
    {
      AppMethodBeat.i(46556);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46556);
    }
    
    ChooseResult() {}
    
    ChooseResult(Parcel paramParcel)
    {
      AppMethodBeat.i(46555);
      readParcel(paramParcel);
      AppMethodBeat.o(46555);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void readParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(46553);
      this.resultCode = paramParcel.readInt();
      this.sgC = ((AppBrandLocalVideoObject)paramParcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader()));
      AppMethodBeat.o(46553);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46554);
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeParcelable(this.sgC, paramInt);
      AppMethodBeat.o(46554);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private w lKp;
    private DialogInterface.OnCancelListener sfD;
    private String sfX;
    private JsApiChooseVideo.ChooseResult sgD;
    private JsApiChooseVideo.ChooseRequest sgE;
    
    private a()
    {
      AppMethodBeat.i(46560);
      this.sgD = new JsApiChooseVideo.ChooseResult();
      AppMethodBeat.o(46560);
    }
    
    private AppBrandLocalVideoObject aF(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(46565);
      String str1 = paramString;
      if (paramBoolean) {}
      try
      {
        str1 = u.aaU(paramString);
      }
      catch (Exception localException)
      {
        try
        {
          for (;;)
          {
            paramString = new d();
            paramString.setDataSource(str1);
            if (paramString != null) {
              break;
            }
            Log.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
            AppMethodBeat.o(46565);
            return null;
            localException = localException;
            Log.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", new Object[] { Util.stackTraceToString(localException) });
            str2 = paramString;
          }
        }
        catch (Exception paramString)
        {
          String str2;
          for (;;)
          {
            Log.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
            paramString = null;
          }
          int i = Util.getInt(paramString.extractMetadata(24), 0);
          int j;
          if ((i == 90) || (i == 270)) {
            j = Util.getInt(paramString.extractMetadata(19), 0);
          }
          int k;
          for (i = Util.getInt(paramString.extractMetadata(18), 0);; i = Util.getInt(paramString.extractMetadata(19), 0))
          {
            k = Util.getInt(paramString.extractMetadata(9), 0);
            paramString.release();
            paramString = AppBrandLocalMediaObjectManager.cW(this.sgE.appId, str2);
            if (paramString != null) {
              break;
            }
            AppMethodBeat.o(46565);
            return null;
            j = Util.getInt(paramString.extractMetadata(18), 0);
          }
          paramString.duration = ((k + 500) / 1000);
          paramString.width = j;
          paramString.height = i;
          paramString.size = y.bEl(str2);
          Log.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", new Object[] { paramString });
          AppMethodBeat.o(46565);
        }
      }
      return paramString;
    }
    
    private void ctk()
    {
      AppMethodBeat.i(46563);
      this.sfD = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(46557);
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).resultCode = 0;
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
          AppMethodBeat.o(46557);
        }
      };
      MMActivity localMMActivity = getActivityContext();
      getString(ba.i.app_tip);
      this.lKp = com.tencent.mm.ui.base.k.a(localMMActivity, getString(ba.i.app_brand_choose_media_video_processing), true, this.sfD);
      AppMethodBeat.o(46563);
    }
    
    public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(46561);
      this.sgE = ((JsApiChooseVideo.ChooseRequest)paramProcessRequest);
      this.sgE.maxDuration = Math.min(Math.max(this.sgE.maxDuration, 60), 0);
      if (Util.getAvailableMemoryMB(getActivityContext()) > 200L) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          aa.makeText(getActivityContext(), getString(ba.i.app_brand_choose_media_video_processing), 1).show();
        }
        getActivityContext().mmSetOnActivityResultCallback(this);
        paramProcessRequest = new Intent();
        paramProcessRequest.putExtra("key_send_raw_image", false);
        paramProcessRequest.putExtra("query_media_type", 2);
        paramProcessRequest.putExtra("GalleryUI_SkipVideoSizeLimit", true);
        paramProcessRequest.putExtra("gallery_report_tag", 16);
        if ((!this.sgE.sft) || (!this.sgE.sfu)) {
          break;
        }
        this.sfX = y.n(b.bmL() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
        paramProcessRequest.putExtra("record_video_force_sys_camera", true);
        paramProcessRequest.putExtra("record_video_quality", 1);
        paramProcessRequest.putExtra("record_video_time_limit", this.sgE.maxDuration);
        paramProcessRequest.putExtra("video_full_path", this.sfX);
        t.e(getActivityContext(), 1, 7, paramProcessRequest);
        AppMethodBeat.o(46561);
        return;
      }
      if (this.sgE.sft)
      {
        this.sfX = y.n(b.bmL() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
        i = this.sgE.maxDuration;
        t.a(getActivityContext(), this.sfX, 5, i, 1, false);
        AppMethodBeat.o(46561);
        return;
      }
      if (this.sgE.sfu)
      {
        paramProcessRequest.putExtra("show_header_view", false);
        t.e(getActivityContext(), 1, 16, paramProcessRequest);
        AppMethodBeat.o(46561);
        return;
      }
      this.sgD.resultCode = -2;
      finishProcess(this.sgD);
      AppMethodBeat.o(46561);
    }
    
    public final void mmOnActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
    {
      AppMethodBeat.i(46564);
      if (paramInt2 == 0)
      {
        this.sgD.resultCode = 0;
        finishProcess(this.sgD);
        AppMethodBeat.o(46564);
        return;
      }
      if (-1 != paramInt2)
      {
        this.sgD.resultCode = -2;
        finishProcess(this.sgD);
        AppMethodBeat.o(46564);
        return;
      }
      switch (paramInt1)
      {
      }
      do
      {
        do
        {
          this.sgD.resultCode = -2;
          finishProcess(this.sgD);
          AppMethodBeat.o(46564);
          return;
        } while (Util.isNullOrNil(this.sfX));
        ctk();
        l.cNm().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46558);
            if (new com.tencent.mm.vfs.u(JsApiChooseVideo.a.b(JsApiChooseVideo.a.this)).jKS())
            {
              JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).resultCode = -1;
              JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).sgC = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.b(JsApiChooseVideo.a.this), JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).sgB);
              JsApiChooseVideo.a.b(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
              AppMethodBeat.o(46558);
              return;
            }
            JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).resultCode = -2;
            JsApiChooseVideo.a.c(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
            AppMethodBeat.o(46558);
          }
        });
        AppMethodBeat.o(46564);
        return;
        paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
      } while (Util.isNullOrNil(paramIntent));
      paramIntent = y.n((String)paramIntent.get(0), false);
      ctk();
      l.cNm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46559);
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).resultCode = -1;
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).sgC = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, paramIntent, JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).sgB);
          JsApiChooseVideo.a.d(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
          AppMethodBeat.o(46559);
        }
      });
      AppMethodBeat.o(46564);
    }
    
    public final void onProcessInterrupted()
    {
      AppMethodBeat.i(46562);
      super.onProcessInterrupted();
      if (this.lKp != null)
      {
        this.lKp.dismiss();
        this.lKp = null;
      }
      AppMethodBeat.o(46562);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo
 * JD-Core Version:    0.7.0.1
 */