package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import androidx.core.app.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.q;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo
  extends c
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  private static volatile boolean pbg = false;
  
  public final void a(final e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46571);
    if (pbg)
    {
      parame.j(paramInt, h("cancel", null));
      AppMethodBeat.o(46571);
      return;
    }
    Context localContext = parame.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      parame.j(paramInt, h("fail", null));
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
      localChooseRequest.oZX = true;
      localChooseRequest.oZY = true;
      localChooseRequest.pbi = paramJSONObject.optBoolean("compressed", true);
      if (!localChooseRequest.oZX) {
        break label304;
      }
      r.a(parame.getAppId(), new a.a()
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
            JsApiChooseVideo.this.a(parame, paramJSONObject, paramInt);
            AppMethodBeat.o(46546);
            return;
          }
          parame.j(paramInt, JsApiChooseVideo.this.h("fail:system permission denied", null));
          AppMethodBeat.o(46546);
        }
      });
      paramJSONObject = parame.getContext();
      if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
        break label262;
      }
      parame.j(paramInt, h("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label304;
      }
      AppMethodBeat.o(46571);
      return;
      localChooseRequest.oZX = localJSONArray.toString().contains("camera");
      localChooseRequest.oZY = localJSONArray.toString().contains("album");
      break;
      label262:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "android.permission.CAMERA", 115, "", "");
      i = bool;
      if (bool)
      {
        r.amk(parame.getAppId());
        i = bool;
      }
    }
    label304:
    pbg = true;
    k.a(parame.getAppId(), new k.c()
    {
      public final void onResume()
      {
        AppMethodBeat.i(46544);
        JsApiChooseVideo.Yy();
        k.b(parame.getAppId(), this);
        AppMethodBeat.o(46544);
      }
    });
    localChooseRequest.maxDuration = Util.getInt(str, 60);
    localChooseRequest.appId = parame.getAppId();
    a.b(localContext, localChooseRequest, new AppBrandProxyUIProcessTask.b() {});
    AppMethodBeat.o(46571);
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    int maxDuration;
    boolean oZX;
    boolean oZY;
    boolean pbi;
    
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
      k(paramParcel);
      AppMethodBeat.o(46550);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bOe()
    {
      return JsApiChooseVideo.a.class;
    }
    
    public final boolean bPn()
    {
      return true;
    }
    
    public final String bPo()
    {
      return "GalleryChooseVideo";
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void k(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46548);
      this.appId = paramParcel.readString();
      this.maxDuration = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.oZX = bool1;
        if (paramParcel.readByte() == 0) {
          break label76;
        }
        bool1 = true;
        label46:
        this.oZY = bool1;
        if (paramParcel.readByte() == 0) {
          break label81;
        }
      }
      label76:
      label81:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.pbi = bool1;
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
      if (this.oZX)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.oZY) {
          break label78;
        }
        b1 = 1;
        label47:
        paramParcel.writeByte(b1);
        if (!this.pbi) {
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
    AppBrandLocalVideoObject pbj;
    int resultCode;
    
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
      k(paramParcel);
      AppMethodBeat.o(46555);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void k(Parcel paramParcel)
    {
      AppMethodBeat.i(46553);
      this.resultCode = paramParcel.readInt();
      this.pbj = ((AppBrandLocalVideoObject)paramParcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader()));
      AppMethodBeat.o(46553);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46554);
      paramParcel.writeInt(this.resultCode);
      paramParcel.writeParcelable(this.pbj, paramInt);
      AppMethodBeat.o(46554);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private s jhZ;
    private String paD;
    private DialogInterface.OnCancelListener pak;
    private JsApiChooseVideo.ChooseResult pbk;
    private JsApiChooseVideo.ChooseRequest pbl;
    
    private a()
    {
      AppMethodBeat.i(46560);
      this.pbk = new JsApiChooseVideo.ChooseResult();
      AppMethodBeat.o(46560);
    }
    
    private AppBrandLocalVideoObject au(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(46565);
      String str1 = paramString;
      if (paramBoolean) {}
      try
      {
        str1 = t.ahW(paramString);
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
            paramString = AppBrandLocalMediaObjectManager.cE(this.pbl.appId, str2);
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
          paramString.size = com.tencent.mm.vfs.u.bBQ(str2);
          Log.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", new Object[] { paramString });
          AppMethodBeat.o(46565);
        }
      }
      return paramString;
    }
    
    private void bTd()
    {
      AppMethodBeat.i(46563);
      this.pak = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(46557);
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).resultCode = 0;
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
          AppMethodBeat.o(46557);
        }
      };
      MMActivity localMMActivity = bPf();
      int i = au.i.app_tip;
      MMApplicationContext.getResources().getString(i);
      i = au.i.app_brand_choose_media_video_processing;
      this.jhZ = com.tencent.mm.ui.base.h.a(localMMActivity, MMApplicationContext.getResources().getString(i), true, this.pak);
      AppMethodBeat.o(46563);
    }
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(46561);
      this.pbl = ((JsApiChooseVideo.ChooseRequest)paramProcessRequest);
      this.pbl.maxDuration = Math.min(Math.max(this.pbl.maxDuration, 60), 0);
      if (Util.getAvailableMemoryMB(bPf()) > 200L) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          paramProcessRequest = bPf();
          i = au.i.app_brand_choose_media_video_processing;
          w.makeText(paramProcessRequest, MMApplicationContext.getResources().getString(i), 1).show();
        }
        bPf().mmSetOnActivityResultCallback(this);
        paramProcessRequest = new Intent();
        paramProcessRequest.putExtra("key_send_raw_image", false);
        paramProcessRequest.putExtra("query_media_type", 2);
        paramProcessRequest.putExtra("GalleryUI_SkipVideoSizeLimit", true);
        paramProcessRequest.putExtra("gallery_report_tag", 16);
        if ((!this.pbl.oZX) || (!this.pbl.oZY)) {
          break;
        }
        this.paD = com.tencent.mm.vfs.u.n(com.tencent.mm.loader.j.b.aSX() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
        paramProcessRequest.putExtra("record_video_force_sys_camera", true);
        paramProcessRequest.putExtra("record_video_quality", 1);
        paramProcessRequest.putExtra("record_video_time_limit", this.pbl.maxDuration);
        paramProcessRequest.putExtra("video_full_path", this.paD);
        com.tencent.mm.pluginsdk.ui.tools.u.d(bPf(), 1, 7, paramProcessRequest);
        AppMethodBeat.o(46561);
        return;
      }
      if (this.pbl.oZX)
      {
        this.paD = com.tencent.mm.vfs.u.n(com.tencent.mm.loader.j.b.aSX() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
        i = this.pbl.maxDuration;
        com.tencent.mm.pluginsdk.ui.tools.u.a(bPf(), this.paD, 5, i, 1, false);
        AppMethodBeat.o(46561);
        return;
      }
      if (this.pbl.oZY)
      {
        paramProcessRequest.putExtra("show_header_view", false);
        com.tencent.mm.pluginsdk.ui.tools.u.d(bPf(), 1, 16, paramProcessRequest);
        AppMethodBeat.o(46561);
        return;
      }
      this.pbk.resultCode = -2;
      b(this.pbk);
      AppMethodBeat.o(46561);
    }
    
    public final void bPm()
    {
      AppMethodBeat.i(46562);
      super.bPm();
      if (this.jhZ != null)
      {
        this.jhZ.dismiss();
        this.jhZ = null;
      }
      AppMethodBeat.o(46562);
    }
    
    public final void d(int paramInt1, int paramInt2, final Intent paramIntent)
    {
      AppMethodBeat.i(46564);
      if (paramInt2 == 0)
      {
        this.pbk.resultCode = 0;
        b(this.pbk);
        AppMethodBeat.o(46564);
        return;
      }
      if (-1 != paramInt2)
      {
        this.pbk.resultCode = -2;
        b(this.pbk);
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
          this.pbk.resultCode = -2;
          b(this.pbk);
          AppMethodBeat.o(46564);
          return;
        } while (Util.isNullOrNil(this.paD));
        bTd();
        com.tencent.mm.plugin.appbrand.utils.h.clV().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46558);
            if (new q(JsApiChooseVideo.a.b(JsApiChooseVideo.a.this)).ifE())
            {
              JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).resultCode = -1;
              JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).pbj = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.b(JsApiChooseVideo.a.this), JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).pbi);
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
      paramIntent = com.tencent.mm.vfs.u.n((String)paramIntent.get(0), false);
      bTd();
      com.tencent.mm.plugin.appbrand.utils.h.clV().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46559);
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).resultCode = -1;
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).pbj = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, paramIntent, JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).pbi);
          JsApiChooseVideo.a.d(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
          AppMethodBeat.o(46559);
        }
      });
      AppMethodBeat.o(46564);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo
 * JD-Core Version:    0.7.0.1
 */