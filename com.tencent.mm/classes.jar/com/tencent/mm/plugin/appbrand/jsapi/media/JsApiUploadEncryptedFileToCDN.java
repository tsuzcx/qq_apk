package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.f;
import com.tencent.mm.i.g;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.b.a.a;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.plugin.appbrand.b.d.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import org.json.JSONObject;

public final class JsApiUploadEncryptedFileToCDN
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 194;
  public static final String NAME = "uploadEncryptedFileToCDN";
  
  public final void a(final e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46598);
    final Context localContext = parame.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
      parame.j(paramInt, h("fail", null));
      AppMethodBeat.o(46598);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
      parame.j(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    String str1 = parame.getAppId();
    String str2 = paramJSONObject.optString("tempFilePath");
    boolean bool = paramJSONObject.optBoolean("isShowProgressTips", false);
    Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", new Object[] { str1, paramJSONObject.toString() });
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
      parame.j(paramInt, h("fail:tempFilePath is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    paramJSONObject = AppBrandLocalMediaObjectManager.cF(str1, str2);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
      parame.j(paramInt, h("fail:file doesn't exist", null));
      AppMethodBeat.o(46598);
      return;
    }
    if (TextUtils.isEmpty(paramJSONObject.lwh))
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
      parame.j(paramInt, h("fail:fileFullPath is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    final JsApiUploadEncryptedMediaFileTask localJsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
    localJsApiUploadEncryptedMediaFileTask.appId = str1;
    localJsApiUploadEncryptedMediaFileTask.fCM = str2;
    localJsApiUploadEncryptedMediaFileTask.pbY = bool;
    localJsApiUploadEncryptedMediaFileTask.pcc = ((Activity)localContext);
    localJsApiUploadEncryptedMediaFileTask.ovO = parame;
    localJsApiUploadEncryptedMediaFileTask.mimeType = paramJSONObject.mimeType;
    localJsApiUploadEncryptedMediaFileTask.otv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46580);
        HashMap localHashMap = new HashMap();
        localHashMap.put("fileId", localJsApiUploadEncryptedMediaFileTask.fileId);
        localHashMap.put("aesKey", localJsApiUploadEncryptedMediaFileTask.aesKey);
        localHashMap.put("fileUrl", localJsApiUploadEncryptedMediaFileTask.fileUrl);
        localHashMap.put("fileLength", localJsApiUploadEncryptedMediaFileTask.nEz);
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", new Object[] { localJsApiUploadEncryptedMediaFileTask.fileId });
        if (Util.isNullOrNil(localJsApiUploadEncryptedMediaFileTask.fileId))
        {
          Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
          parame.j(paramInt, JsApiUploadEncryptedFileToCDN.this.h("fail", null));
        }
        for (;;)
        {
          localJsApiUploadEncryptedMediaFileTask.bPk();
          AppMethodBeat.o(46580);
          return;
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
          parame.j(paramInt, JsApiUploadEncryptedFileToCDN.this.m("ok", localHashMap));
        }
      }
    };
    if (!ag.dj(localContext))
    {
      Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(275785);
          if ((!TextUtils.isEmpty(paramJSONObject.mimeType)) && (paramJSONObject.mimeType.contains("video"))) {}
          for (String str = localContext.getString(au.i.appbrand_jssdk_video);; str = localContext.getString(au.i.appbrand_jssdk_image))
          {
            h.a(localContext, localContext.getString(au.i.appbrand_jssdk_upload_media_file_gprs_confirm, new Object[] { str, this.pbW }), localContext.getString(au.i.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(272191);
                Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
                JsApiUploadEncryptedFileToCDN.2.this.pbT.bsM();
                AppMethodBeat.o(272191);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(281112);
                Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
                JsApiUploadEncryptedFileToCDN.2.this.cyJ.j(JsApiUploadEncryptedFileToCDN.2.this.cuf, JsApiUploadEncryptedFileToCDN.this.h("cancel", null));
                JsApiUploadEncryptedFileToCDN.2.this.pbT.bPk();
                AppMethodBeat.o(281112);
              }
            });
            AppMethodBeat.o(275785);
            return;
          }
        }
      });
      AppMethodBeat.o(46598);
      return;
    }
    Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
    localJsApiUploadEncryptedMediaFileTask.bsM();
    AppMethodBeat.o(46598);
  }
  
  public static class JsApiUploadEncryptedMediaFileTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiUploadEncryptedMediaFileTask> CREATOR;
    public String aesKey;
    public String appId;
    public String fCM;
    public String fileId;
    public String fileUrl;
    private ProgressDialog iXX;
    public String mimeType;
    public int nEz;
    public Runnable otv;
    e ovO;
    public boolean pbY;
    public int pbZ;
    public int pca;
    public int pcb;
    Activity pcc;
    d.a pcd;
    d.b pce;
    
    static
    {
      AppMethodBeat.i(46597);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46597);
    }
    
    public JsApiUploadEncryptedMediaFileTask()
    {
      this.pbZ = 0;
      this.pca = 0;
      this.pcb = 0;
      this.iXX = null;
    }
    
    public JsApiUploadEncryptedMediaFileTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46590);
      this.pbZ = 0;
      this.pca = 0;
      this.pcb = 0;
      this.iXX = null;
      f(paramParcel);
      AppMethodBeat.o(46590);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(46591);
      Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", new Object[] { Integer.valueOf(this.pca), Integer.valueOf(this.pcb) });
      if (this.pca == 1)
      {
        Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
        m.bFT().a(this.pcd);
        m.bFT().a(this.pce);
        m.bFT();
        com.tencent.mm.plugin.appbrand.b.b.aer(this.fCM);
        this.pca = 0;
        this.pcb = 1;
        bPt();
        AppMethodBeat.o(46591);
        return;
      }
      final AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.cF(this.appId, this.fCM);
      if (localAppBrandLocalMediaObject == null)
      {
        Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
        this.pcb = 1;
        bPt();
        AppMethodBeat.o(46591);
        return;
      }
      Object localObject1 = new com.tencent.mm.plugin.appbrand.b.a();
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).fCM = localAppBrandLocalMediaObject.fCM;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).nVa = localAppBrandLocalMediaObject.lwh;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).mHi = localAppBrandLocalMediaObject.mHi;
      Object localObject2 = this.fCM;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).mediaId = com.tencent.mm.aq.c.a("appbrandmediafile", Util.nowMilliSecond(), (String)localObject2, (String)localObject2);
      m.bFS().a((com.tencent.mm.plugin.appbrand.b.a)localObject1);
      this.pcd = new d.a()
      {
        public final void ae(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46583);
          Log.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pbZ = paramAnonymousInt;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pcb = 3;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
          AppMethodBeat.o(46583);
        }
      };
      this.pce = new d.b()
      {
        public final void b(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(46584);
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString2, paramAnonymousString1, paramAnonymousString3 });
          if ((!Util.isNullOrNil(paramAnonymousString1)) && (paramAnonymousString1.equals(localAppBrandLocalMediaObject.fCM)))
          {
            m.bFT().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pcd);
            m.bFT().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pce);
            m.bFT();
            com.tencent.mm.plugin.appbrand.b.b.aer(localAppBrandLocalMediaObject.fCM);
            if (paramAnonymousBoolean) {
              break label267;
            }
            Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
            paramAnonymousString1 = m.bFS();
            paramAnonymousString2 = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId;
            if (!Util.isNullOrNil(paramAnonymousString2)) {
              break label285;
            }
            Log.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
            label134:
            break label299;
            label135:
            paramAnonymousString1 = null;
            label137:
            if ((paramAnonymousString1 == null) || (paramAnonymousString1.nVc == null)) {
              break label337;
            }
            Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.aesKey = paramAnonymousString1.nVc.field_aesKey;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString1.nVc.field_fileId;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileUrl = paramAnonymousString1.nVc.field_fileUrl;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.nEz = paramAnonymousString1.nVc.field_fileLength;
            Log.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", new Object[] { JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.aesKey, Integer.valueOf(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.nEz) });
          }
          for (;;)
          {
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pcb = 1;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.b(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
            AppMethodBeat.o(46584);
            return;
            label267:
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString2;
            Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
            break;
            label285:
            paramAnonymousString3 = paramAnonymousString1.nVl.values().iterator();
            label299:
            if (!paramAnonymousString3.hasNext()) {
              break label135;
            }
            paramAnonymousString1 = (com.tencent.mm.plugin.appbrand.b.a)paramAnonymousString3.next();
            if (!Util.nullAsNil(paramAnonymousString1.nVb).equals(paramAnonymousString2)) {
              break label134;
            }
            break label137;
            label337:
            Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
          }
        }
      };
      localObject1 = m.bFT();
      localObject2 = this.pcd;
      if ((((com.tencent.mm.plugin.appbrand.b.b)localObject1).nVh != null) && (localObject2 != null) && (!((com.tencent.mm.plugin.appbrand.b.b)localObject1).nVh.contains(localObject2))) {
        ((com.tencent.mm.plugin.appbrand.b.b)localObject1).nVh.add(localObject2);
      }
      localObject1 = m.bFT();
      Object localObject3 = this.appId;
      localObject2 = localAppBrandLocalMediaObject.fCM;
      int i = com.tencent.mm.i.a.iUa;
      d.b localb = this.pce;
      com.tencent.mm.plugin.appbrand.b.a locala = m.bFS().aes((String)localObject2);
      boolean bool;
      if (locala == null)
      {
        Log.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { localObject2 });
        bool = false;
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
          this.pcb = 1;
          m.bFT().a(this.pcd);
          m.bFT().a(this.pce);
          m.bFT();
          com.tencent.mm.plugin.appbrand.b.b.aer(localAppBrandLocalMediaObject.fCM);
          bPt();
          AppMethodBeat.o(46591);
        }
      }
      else
      {
        locala.appId = ((String)localObject3);
        if ((localb != null) && (((com.tencent.mm.plugin.appbrand.b.b)localObject1).nVg != null) && (localb != null) && (!((com.tencent.mm.plugin.appbrand.b.b)localObject1).nVg.contains(localb))) {
          ((com.tencent.mm.plugin.appbrand.b.b)localObject1).nVg.add(localb);
        }
        locala.nVd = true;
        localObject3 = new g();
        ((g)localObject3).taskName = "task_AppbrandCdnService_1";
        ((g)localObject3).iUG = ((com.tencent.mm.plugin.appbrand.b.b)localObject1).lPx;
        ((g)localObject3).gbt = true;
        ((g)localObject3).field_mediaId = locala.mediaId;
        ((g)localObject3).field_fullpath = locala.nVa;
        ((g)localObject3).field_fileType = i;
        ((g)localObject3).field_talker = "weixin";
        ((g)localObject3).field_priority = com.tencent.mm.i.a.iTU;
        if (i == com.tencent.mm.i.a.iUa) {}
        for (((g)localObject3).field_needStorage = true;; ((g)localObject3).field_needStorage = false)
        {
          ((g)localObject3).field_isStreamMedia = false;
          ((g)localObject3).field_appType = 0;
          ((g)localObject3).field_bzScene = 0;
          ((g)localObject3).field_force_aeskeycdn = true;
          ((g)localObject3).field_trysafecdn = false;
          bool = f.bkg().f((g)localObject3);
          Log.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(((g)localObject3).field_force_aeskeycdn), Boolean.valueOf(((g)localObject3).field_trysafecdn), localObject2 });
          break;
        }
      }
      if (this.pbY)
      {
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
        this.pcb = 2;
        bPt();
      }
      AppMethodBeat.o(46591);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(46592);
      if (this.pcb == 0)
      {
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
        AppMethodBeat.o(46592);
        return;
      }
      if (this.pcb == 1)
      {
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
        if (this.iXX != null)
        {
          this.iXX.dismiss();
          this.iXX = null;
        }
        if (this.otv != null)
        {
          this.otv.run();
          AppMethodBeat.o(46592);
        }
      }
      else
      {
        Object localObject;
        if (this.pcb == 2)
        {
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
          localObject = this.pcc;
          this.pcc.getString(au.i.app_tip);
          this.iXX = h.a((Context)localObject, this.pcc.getString(au.i.appbrand_jssdk_uploading), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(46585);
              Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel uploading the media file");
              paramAnonymousDialogInterface.dismiss();
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pca = 1;
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pcb = 1;
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.bsM();
              AppMethodBeat.o(46585);
            }
          });
          this.iXX.setOnKeyListener(new DialogInterface.OnKeyListener()
          {
            public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(46588);
              if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1))
              {
                if ((!TextUtils.isEmpty(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType)) && (JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType.contains("video"))) {}
                for (paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pcc.getString(au.i.appbrand_jssdk_video);; paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pcc.getString(au.i.appbrand_jssdk_image))
                {
                  h.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pcc, true, JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pcc.getString(au.i.appbrand_jssdk_media_file_uploading_tips, new Object[] { paramAnonymousDialogInterface }), "", JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pcc.getString(au.i.appbrand_jssdk_upload_video_cancel), JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pcc.getString(au.i.appbrand_jssdk_upload_video_continue), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(46586);
                      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.c(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this).cancel();
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pca = 1;
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.pcb = 1;
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.bsM();
                      AppMethodBeat.o(46586);
                    }
                  }, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(46587);
                      Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "user continue upload media file");
                      AppMethodBeat.o(46587);
                    }
                  });
                  AppMethodBeat.o(46588);
                  return true;
                }
              }
              AppMethodBeat.o(46588);
              return false;
            }
          });
          AppMethodBeat.o(46592);
          return;
        }
        if (this.pcb == 3)
        {
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
          localObject = new HashMap();
          ((Map)localObject).put("tempFilePath", this.fCM);
          ((Map)localObject).put("percent", Integer.valueOf(this.pbZ));
          localObject = new JSONObject((Map)localObject).toString();
          new JsApiUploadEncryptedFileToCDN.a((byte)0).i(this.ovO).agT((String)localObject).bPO();
        }
      }
      AppMethodBeat.o(46592);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46593);
      this.appId = paramParcel.readString();
      this.fCM = paramParcel.readString();
      this.fileId = paramParcel.readString();
      this.aesKey = paramParcel.readString();
      this.fileUrl = paramParcel.readString();
      this.nEz = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.pbY = bool;
        this.pbZ = paramParcel.readInt();
        this.pcb = paramParcel.readInt();
        this.pca = paramParcel.readInt();
        this.mimeType = paramParcel.readString();
        AppMethodBeat.o(46593);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46594);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.fCM);
      paramParcel.writeString(this.fileId);
      paramParcel.writeString(this.aesKey);
      paramParcel.writeString(this.fileUrl);
      paramParcel.writeInt(this.nEz);
      if (this.pbY) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.pbZ);
        paramParcel.writeInt(this.pcb);
        paramParcel.writeInt(this.pca);
        paramParcel.writeString(this.mimeType);
        AppMethodBeat.o(46594);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN
 * JD-Core Version:    0.7.0.1
 */