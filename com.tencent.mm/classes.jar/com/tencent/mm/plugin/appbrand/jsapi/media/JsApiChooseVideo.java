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
import android.support.v4.app.a.a;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseVideo
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 36;
  public static final String NAME = "chooseVideo";
  private static volatile boolean kym = false;
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46571);
    if (kym)
    {
      paramc.h(paramInt, e("cancel", null));
      AppMethodBeat.o(46571);
      return;
    }
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46571);
      return;
    }
    ChooseRequest localChooseRequest = new ChooseRequest();
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
    String str = paramJSONObject.optString("maxDuration");
    ac.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, maxDuration = %s", new Object[] { localJSONArray, str });
    int i;
    if ((localJSONArray == null) || (localJSONArray.length() == 0))
    {
      localChooseRequest.kxi = true;
      localChooseRequest.kxj = true;
      localChooseRequest.kyo = paramJSONObject.optBoolean("compressed", true);
      if (!localChooseRequest.kxi) {
        break label304;
      }
      o.a(paramc.getAppId(), new a.a()
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
            JsApiChooseVideo.this.a(paramc, paramJSONObject, paramInt);
            AppMethodBeat.o(46546);
            return;
          }
          paramc.h(paramInt, JsApiChooseVideo.this.e("fail:system permission denied", null));
          AppMethodBeat.o(46546);
        }
      });
      paramJSONObject = paramc.getContext();
      if ((paramJSONObject != null) && ((paramJSONObject instanceof Activity))) {
        break label262;
      }
      paramc.h(paramInt, e("fail", null));
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label304;
      }
      AppMethodBeat.o(46571);
      return;
      localChooseRequest.kxi = localJSONArray.toString().contains("camera");
      localChooseRequest.kxj = localJSONArray.toString().contains("album");
      break;
      label262:
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramJSONObject, "android.permission.CAMERA", 115, "", "");
      i = bool;
      if (bool)
      {
        o.Qo(paramc.getAppId());
        i = bool;
      }
    }
    label304:
    kym = true;
    g.a(paramc.getAppId(), new g.c()
    {
      public final void onResume()
      {
        AppMethodBeat.i(46544);
        JsApiChooseVideo.adZ();
        g.b(paramc.getAppId(), this);
        AppMethodBeat.o(46544);
      }
    });
    localChooseRequest.maxDuration = bs.getInt(str, 60);
    localChooseRequest.appId = paramc.getAppId();
    com.tencent.mm.plugin.appbrand.ipc.a.b(localContext, localChooseRequest, new AppBrandProxyUIProcessTask.b() {});
    AppMethodBeat.o(46571);
  }
  
  static final class ChooseRequest
    extends AppBrandProxyUIProcessTask.ProcessRequest
  {
    public static final Parcelable.Creator<ChooseRequest> CREATOR;
    String appId;
    boolean kxi;
    boolean kxj;
    boolean kyo;
    int maxDuration;
    
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
      j(paramParcel);
      AppMethodBeat.o(46550);
    }
    
    public final Class<? extends AppBrandProxyUIProcessTask> bdj()
    {
      return JsApiChooseVideo.a.class;
    }
    
    public final boolean ben()
    {
      return true;
    }
    
    public final String beo()
    {
      return "GalleryChooseVideo";
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46548);
      this.appId = paramParcel.readString();
      this.maxDuration = paramParcel.readInt();
      if (paramParcel.readByte() != 0)
      {
        bool1 = true;
        this.kxi = bool1;
        if (paramParcel.readByte() == 0) {
          break label76;
        }
        bool1 = true;
        label46:
        this.kxj = bool1;
        if (paramParcel.readByte() == 0) {
          break label81;
        }
      }
      label76:
      label81:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kyo = bool1;
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
      if (this.kxi)
      {
        b1 = 1;
        paramParcel.writeByte(b1);
        if (!this.kxj) {
          break label78;
        }
        b1 = 1;
        label47:
        paramParcel.writeByte(b1);
        if (!this.kyo) {
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
    int bPH;
    AppBrandLocalVideoObject kyp;
    
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
      j(paramParcel);
      AppMethodBeat.o(46555);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void j(Parcel paramParcel)
    {
      AppMethodBeat.i(46553);
      this.bPH = paramParcel.readInt();
      this.kyp = ((AppBrandLocalVideoObject)paramParcel.readParcelable(AppBrandLocalVideoObject.class.getClassLoader()));
      AppMethodBeat.o(46553);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46554);
      paramParcel.writeInt(this.bPH);
      paramParcel.writeParcelable(this.kyp, paramInt);
      AppMethodBeat.o(46554);
    }
  }
  
  static final class a
    extends AppBrandProxyUIProcessTask
  {
    private p fxw;
    private String kxN;
    private DialogInterface.OnCancelListener kxv;
    private JsApiChooseVideo.ChooseResult kyq;
    private JsApiChooseVideo.ChooseRequest kyr;
    
    private a()
    {
      AppMethodBeat.i(46560);
      this.kyq = new JsApiChooseVideo.ChooseResult();
      AppMethodBeat.o(46560);
    }
    
    private AppBrandLocalVideoObject ap(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(46565);
      String str1 = paramString;
      if (paramBoolean) {}
      try
      {
        str1 = s.Mx(paramString);
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
            ac.e("MicroMsg.JsApiChooseVideo", "addVideoItem, null meta data");
            AppMethodBeat.o(46565);
            return null;
            localException = localException;
            ac.e("MicroMsg.JsApiChooseVideo", "addVideoItem, remux failed, exp = %s", new Object[] { bs.m(localException) });
            str2 = paramString;
          }
        }
        catch (Exception paramString)
        {
          String str2;
          for (;;)
          {
            ac.e("MicroMsg.JsApiChooseVideo", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[] { paramString });
            paramString = null;
          }
          int i = bs.getInt(paramString.extractMetadata(24), 0);
          int j;
          if ((i == 90) || (i == 270)) {
            j = bs.getInt(paramString.extractMetadata(19), 0);
          }
          int k;
          for (i = bs.getInt(paramString.extractMetadata(18), 0);; i = bs.getInt(paramString.extractMetadata(19), 0))
          {
            k = bs.getInt(paramString.extractMetadata(9), 0);
            paramString.release();
            paramString = AppBrandLocalMediaObjectManager.cj(this.kyr.appId, str2);
            if (paramString != null) {
              break;
            }
            AppMethodBeat.o(46565);
            return null;
            j = bs.getInt(paramString.extractMetadata(18), 0);
          }
          paramString.duration = ((k + 500) / 1000);
          paramString.width = j;
          paramString.height = i;
          paramString.size = ((int)i.aSp(str2));
          ac.i("MicroMsg.JsApiChooseVideo", "addVideoItem, return %s", new Object[] { paramString });
          AppMethodBeat.o(46565);
        }
      }
      return paramString;
    }
    
    private void bhH()
    {
      AppMethodBeat.i(46563);
      this.kxv = new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(46557);
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bPH = 0;
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
          AppMethodBeat.o(46557);
        }
      };
      MMActivity localMMActivity = bef();
      ai.getResources().getString(2131755906);
      this.fxw = h.b(localMMActivity, ai.getResources().getString(2131755360), true, this.kxv);
      AppMethodBeat.o(46563);
    }
    
    public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
    {
      AppMethodBeat.i(46561);
      this.kyr = ((JsApiChooseVideo.ChooseRequest)paramProcessRequest);
      this.kyr.maxDuration = Math.min(Math.max(this.kyr.maxDuration, 60), 0);
      if (bs.iU(bef()) > 200L) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          t.makeText(bef(), ai.getResources().getString(2131755360), 1).show();
        }
        bef().mmSetOnActivityResultCallback(this);
        paramProcessRequest = new Intent();
        paramProcessRequest.putExtra("key_send_raw_image", false);
        paramProcessRequest.putExtra("query_media_type", 2);
        paramProcessRequest.putExtra("GalleryUI_SkipVideoSizeLimit", true);
        paramProcessRequest.putExtra("gallery_report_tag", 16);
        if ((!this.kyr.kxi) || (!this.kyr.kxj)) {
          break;
        }
        this.kxN = i.k(com.tencent.mm.loader.j.b.aps() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
        paramProcessRequest.putExtra("record_video_force_sys_camera", true);
        paramProcessRequest.putExtra("record_video_quality", 1);
        paramProcessRequest.putExtra("record_video_time_limit", this.kyr.maxDuration);
        paramProcessRequest.putExtra("video_full_path", this.kxN);
        q.d(bef(), 1, 7, paramProcessRequest);
        AppMethodBeat.o(46561);
        return;
      }
      if (this.kyr.kxi)
      {
        this.kxN = i.k(com.tencent.mm.loader.j.b.aps() + "microMsg." + System.currentTimeMillis() + ".mp4", false);
        i = this.kyr.maxDuration;
        q.a(bef(), this.kxN, 5, i, 1, false);
        AppMethodBeat.o(46561);
        return;
      }
      if (this.kyr.kxj)
      {
        paramProcessRequest.putExtra("show_header_view", false);
        q.d(bef(), 1, 7, paramProcessRequest);
        AppMethodBeat.o(46561);
        return;
      }
      this.kyq.bPH = -2;
      b(this.kyq);
      AppMethodBeat.o(46561);
    }
    
    public final void bem()
    {
      AppMethodBeat.i(46562);
      super.bem();
      if (this.fxw != null)
      {
        this.fxw.dismiss();
        this.fxw = null;
      }
      AppMethodBeat.o(46562);
    }
    
    public final void c(int paramInt1, int paramInt2, final Intent paramIntent)
    {
      AppMethodBeat.i(46564);
      if (paramInt2 == 0)
      {
        this.kyq.bPH = 0;
        b(this.kyq);
        AppMethodBeat.o(46564);
        return;
      }
      if (-1 != paramInt2)
      {
        this.kyq.bPH = -2;
        b(this.kyq);
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
          this.kyq.bPH = -2;
          b(this.kyq);
          AppMethodBeat.o(46564);
          return;
        } while (bs.isNullOrNil(this.kxN));
        bhH();
        com.tencent.mm.plugin.appbrand.utils.e.bxj().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(46558);
            if (new com.tencent.mm.vfs.e(JsApiChooseVideo.a.b(JsApiChooseVideo.a.this)).exists())
            {
              JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bPH = -1;
              JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).kyp = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, JsApiChooseVideo.a.b(JsApiChooseVideo.a.this), JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).kyo);
              JsApiChooseVideo.a.b(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
              AppMethodBeat.o(46558);
              return;
            }
            JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bPH = -2;
            JsApiChooseVideo.a.c(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
            AppMethodBeat.o(46558);
          }
        });
        AppMethodBeat.o(46564);
        return;
        paramIntent = paramIntent.getStringArrayListExtra("key_select_video_list");
      } while (bs.gY(paramIntent));
      paramIntent = i.k((String)paramIntent.get(0), false);
      bhH();
      com.tencent.mm.plugin.appbrand.utils.e.bxj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(46559);
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).bPH = -1;
          JsApiChooseVideo.a.a(JsApiChooseVideo.a.this).kyp = JsApiChooseVideo.a.a(JsApiChooseVideo.a.this, paramIntent, JsApiChooseVideo.a.c(JsApiChooseVideo.a.this).kyo);
          JsApiChooseVideo.a.d(JsApiChooseVideo.a.this, JsApiChooseVideo.a.a(JsApiChooseVideo.a.this));
          AppMethodBeat.o(46559);
        }
      });
      AppMethodBeat.o(46564);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo
 * JD-Core Version:    0.7.0.1
 */