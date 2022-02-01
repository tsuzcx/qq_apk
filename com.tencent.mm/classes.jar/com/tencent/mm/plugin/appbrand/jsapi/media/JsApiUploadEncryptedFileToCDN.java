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
import com.tencent.mm.i.g;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.b.a.a;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.plugin.appbrand.b.d.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import org.json.JSONObject;

public final class JsApiUploadEncryptedFileToCDN
  extends d
{
  public static final int CTRL_INDEX = 194;
  public static final String NAME = "uploadEncryptedFileToCDN";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46598);
    final Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
      paramf.i(paramInt, h("fail", null));
      AppMethodBeat.o(46598);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
      paramf.i(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    String str1 = paramf.getAppId();
    String str2 = paramJSONObject.optString("tempFilePath");
    boolean bool = paramJSONObject.optBoolean("isShowProgressTips", false);
    Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", new Object[] { str1, paramJSONObject.toString() });
    if (Util.isNullOrNil(str2))
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
      paramf.i(paramInt, h("fail:tempFilePath is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    paramJSONObject = AppBrandLocalMediaObjectManager.cz(str1, str2);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
      paramf.i(paramInt, h("fail:file doesn't exist", null));
      AppMethodBeat.o(46598);
      return;
    }
    if (TextUtils.isEmpty(paramJSONObject.iGf))
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
      paramf.i(paramInt, h("fail:fileFullPath is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    final JsApiUploadEncryptedMediaFileTask localJsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
    localJsApiUploadEncryptedMediaFileTask.appId = str1;
    localJsApiUploadEncryptedMediaFileTask.dJX = str2;
    localJsApiUploadEncryptedMediaFileTask.meg = bool;
    localJsApiUploadEncryptedMediaFileTask.mek = ((Activity)localContext);
    localJsApiUploadEncryptedMediaFileTask.lAx = paramf;
    localJsApiUploadEncryptedMediaFileTask.mimeType = paramJSONObject.mimeType;
    localJsApiUploadEncryptedMediaFileTask.lyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46580);
        HashMap localHashMap = new HashMap();
        localHashMap.put("fileId", localJsApiUploadEncryptedMediaFileTask.fileId);
        localHashMap.put("aesKey", localJsApiUploadEncryptedMediaFileTask.aesKey);
        localHashMap.put("fileUrl", localJsApiUploadEncryptedMediaFileTask.fileUrl);
        localHashMap.put("fileLength", localJsApiUploadEncryptedMediaFileTask.kKK);
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", new Object[] { localJsApiUploadEncryptedMediaFileTask.fileId });
        if (Util.isNullOrNil(localJsApiUploadEncryptedMediaFileTask.fileId))
        {
          Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
          paramf.i(paramInt, JsApiUploadEncryptedFileToCDN.this.h("fail", null));
        }
        for (;;)
        {
          localJsApiUploadEncryptedMediaFileTask.bDK();
          AppMethodBeat.o(46580);
          return;
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
          paramf.i(paramInt, JsApiUploadEncryptedFileToCDN.this.n("ok", localHashMap));
        }
      }
    };
    if (!ag.dm(localContext))
    {
      Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226906);
          if ((!TextUtils.isEmpty(paramJSONObject.mimeType)) && (paramJSONObject.mimeType.contains("video"))) {}
          for (String str = localContext.getString(2131756099);; str = localContext.getString(2131756093))
          {
            h.a(localContext, localContext.getString(2131756095, new Object[] { str, this.mee }), localContext.getString(2131755998), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(226904);
                Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
                JsApiUploadEncryptedFileToCDN.2.this.meb.bDJ();
                AppBrandMainProcessService.a(JsApiUploadEncryptedFileToCDN.2.this.meb);
                AppMethodBeat.o(226904);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(226905);
                Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
                JsApiUploadEncryptedFileToCDN.2.this.czN.i(JsApiUploadEncryptedFileToCDN.2.this.cvP, JsApiUploadEncryptedFileToCDN.this.h("cancel", null));
                JsApiUploadEncryptedFileToCDN.2.this.meb.bDK();
                AppMethodBeat.o(226905);
              }
            });
            AppMethodBeat.o(226906);
            return;
          }
        }
      });
      AppMethodBeat.o(46598);
      return;
    }
    Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
    localJsApiUploadEncryptedMediaFileTask.bDJ();
    AppBrandMainProcessService.a(localJsApiUploadEncryptedMediaFileTask);
    AppMethodBeat.o(46598);
  }
  
  public static class JsApiUploadEncryptedMediaFileTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiUploadEncryptedMediaFileTask> CREATOR;
    public String aesKey;
    public String appId;
    public String dJX;
    public String fileId;
    public String fileUrl;
    private ProgressDialog gtM;
    public int kKK;
    com.tencent.mm.plugin.appbrand.jsapi.f lAx;
    public Runnable lyv;
    public boolean meg;
    public int meh;
    public int mei;
    public int mej;
    Activity mek;
    d.a mel;
    d.b mem;
    public String mimeType;
    
    static
    {
      AppMethodBeat.i(46597);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46597);
    }
    
    public JsApiUploadEncryptedMediaFileTask()
    {
      this.meh = 0;
      this.mei = 0;
      this.mej = 0;
      this.gtM = null;
    }
    
    public JsApiUploadEncryptedMediaFileTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46590);
      this.meh = 0;
      this.mei = 0;
      this.mej = 0;
      this.gtM = null;
      f(paramParcel);
      AppMethodBeat.o(46590);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(46591);
      Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", new Object[] { Integer.valueOf(this.mei), Integer.valueOf(this.mej) });
      if (this.mei == 1)
      {
        Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
        n.buO().a(this.mel);
        n.buO().a(this.mem);
        n.buO();
        com.tencent.mm.plugin.appbrand.b.b.WG(this.dJX);
        this.mei = 0;
        this.mej = 1;
        bDU();
        AppMethodBeat.o(46591);
        return;
      }
      final AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.cz(this.appId, this.dJX);
      if (localAppBrandLocalMediaObject == null)
      {
        Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
        this.mej = 1;
        bDU();
        AppMethodBeat.o(46591);
        return;
      }
      Object localObject1 = new com.tencent.mm.plugin.appbrand.b.a();
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).dJX = localAppBrandLocalMediaObject.dJX;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).laR = localAppBrandLocalMediaObject.iGf;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).jPY = localAppBrandLocalMediaObject.jPY;
      Object localObject2 = this.dJX;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).mediaId = com.tencent.mm.an.c.a("appbrandmediafile", Util.nowMilliSecond(), (String)localObject2, (String)localObject2);
      n.buN().a((com.tencent.mm.plugin.appbrand.b.a)localObject1);
      this.mel = new d.a()
      {
        public final void ac(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46583);
          Log.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.meh = paramAnonymousInt;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mej = 3;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
          AppMethodBeat.o(46583);
        }
      };
      this.mem = new d.b()
      {
        public final void b(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(46584);
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString2, paramAnonymousString1, paramAnonymousString3 });
          if ((!Util.isNullOrNil(paramAnonymousString1)) && (paramAnonymousString1.equals(localAppBrandLocalMediaObject.dJX)))
          {
            n.buO().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mel);
            n.buO().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mem);
            n.buO();
            com.tencent.mm.plugin.appbrand.b.b.WG(localAppBrandLocalMediaObject.dJX);
            if (paramAnonymousBoolean) {
              break label267;
            }
            Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
            paramAnonymousString1 = n.buN();
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
            if ((paramAnonymousString1 == null) || (paramAnonymousString1.laT == null)) {
              break label337;
            }
            Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.aesKey = paramAnonymousString1.laT.field_aesKey;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString1.laT.field_fileId;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileUrl = paramAnonymousString1.laT.field_fileUrl;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kKK = paramAnonymousString1.laT.field_fileLength;
            Log.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", new Object[] { JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.aesKey, Integer.valueOf(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kKK) });
          }
          for (;;)
          {
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mej = 1;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.b(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
            AppMethodBeat.o(46584);
            return;
            label267:
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString2;
            Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
            break;
            label285:
            paramAnonymousString3 = paramAnonymousString1.lbc.values().iterator();
            label299:
            if (!paramAnonymousString3.hasNext()) {
              break label135;
            }
            paramAnonymousString1 = (com.tencent.mm.plugin.appbrand.b.a)paramAnonymousString3.next();
            if (!Util.nullAsNil(paramAnonymousString1.laS).equals(paramAnonymousString2)) {
              break label134;
            }
            break label137;
            label337:
            Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
          }
        }
      };
      localObject1 = n.buO();
      localObject2 = this.mel;
      if ((((com.tencent.mm.plugin.appbrand.b.b)localObject1).laY != null) && (localObject2 != null) && (!((com.tencent.mm.plugin.appbrand.b.b)localObject1).laY.contains(localObject2))) {
        ((com.tencent.mm.plugin.appbrand.b.b)localObject1).laY.add(localObject2);
      }
      localObject1 = n.buO();
      Object localObject3 = this.appId;
      localObject2 = localAppBrandLocalMediaObject.dJX;
      int i = com.tencent.mm.i.a.gpS;
      d.b localb = this.mem;
      com.tencent.mm.plugin.appbrand.b.a locala = n.buN().WH((String)localObject2);
      boolean bool;
      if (locala == null)
      {
        Log.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { localObject2 });
        bool = false;
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
          this.mej = 1;
          n.buO().a(this.mel);
          n.buO().a(this.mem);
          n.buO();
          com.tencent.mm.plugin.appbrand.b.b.WG(localAppBrandLocalMediaObject.dJX);
          bDU();
          AppMethodBeat.o(46591);
        }
      }
      else
      {
        locala.appId = ((String)localObject3);
        if ((localb != null) && (((com.tencent.mm.plugin.appbrand.b.b)localObject1).laX != null) && (localb != null) && (!((com.tencent.mm.plugin.appbrand.b.b)localObject1).laX.contains(localb))) {
          ((com.tencent.mm.plugin.appbrand.b.b)localObject1).laX.add(localb);
        }
        locala.laU = true;
        localObject3 = new g();
        ((g)localObject3).taskName = "task_AppbrandCdnService_1";
        ((g)localObject3).gqy = ((com.tencent.mm.plugin.appbrand.b.b)localObject1).iZc;
        ((g)localObject3).ehd = true;
        ((g)localObject3).field_mediaId = locala.mediaId;
        ((g)localObject3).field_fullpath = locala.laR;
        ((g)localObject3).field_fileType = i;
        ((g)localObject3).field_talker = "weixin";
        ((g)localObject3).field_priority = com.tencent.mm.i.a.gpM;
        if (i == com.tencent.mm.i.a.gpS) {}
        for (((g)localObject3).field_needStorage = true;; ((g)localObject3).field_needStorage = false)
        {
          ((g)localObject3).field_isStreamMedia = false;
          ((g)localObject3).field_appType = 0;
          ((g)localObject3).field_bzScene = 0;
          ((g)localObject3).field_force_aeskeycdn = true;
          ((g)localObject3).field_trysafecdn = false;
          bool = com.tencent.mm.an.f.baQ().f((g)localObject3);
          Log.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(((g)localObject3).field_force_aeskeycdn), Boolean.valueOf(((g)localObject3).field_trysafecdn), localObject2 });
          break;
        }
      }
      if (this.meg)
      {
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
        this.mej = 2;
        bDU();
      }
      AppMethodBeat.o(46591);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(46592);
      if (this.mej == 0)
      {
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
        AppMethodBeat.o(46592);
        return;
      }
      if (this.mej == 1)
      {
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
        if (this.gtM != null)
        {
          this.gtM.dismiss();
          this.gtM = null;
        }
        if (this.lyv != null)
        {
          this.lyv.run();
          AppMethodBeat.o(46592);
        }
      }
      else
      {
        Object localObject;
        if (this.mej == 2)
        {
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
          localObject = this.mek;
          this.mek.getString(2131755998);
          this.gtM = h.a((Context)localObject, this.mek.getString(2131756098), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(46585);
              Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel uploading the media file");
              paramAnonymousDialogInterface.dismiss();
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mei = 1;
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mej = 1;
              AppBrandMainProcessService.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
              AppMethodBeat.o(46585);
            }
          });
          this.gtM.setOnKeyListener(new DialogInterface.OnKeyListener()
          {
            public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(46588);
              if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1))
              {
                if ((!TextUtils.isEmpty(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType)) && (JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType.contains("video"))) {}
                for (paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mek.getString(2131756099);; paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mek.getString(2131756093))
                {
                  h.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mek, true, JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mek.getString(2131756094, new Object[] { paramAnonymousDialogInterface }), "", JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mek.getString(2131756096), JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mek.getString(2131756097), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(46586);
                      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.c(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this).cancel();
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mei = 1;
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mej = 1;
                      AppBrandMainProcessService.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
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
        if (this.mej == 3)
        {
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
          localObject = new HashMap();
          ((Map)localObject).put("tempFilePath", this.dJX);
          ((Map)localObject).put("percent", Integer.valueOf(this.meh));
          localObject = new JSONObject((Map)localObject).toString();
          new JsApiUploadEncryptedFileToCDN.a((byte)0).g(this.lAx).Zg((String)localObject).bEo();
        }
      }
      AppMethodBeat.o(46592);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46593);
      this.appId = paramParcel.readString();
      this.dJX = paramParcel.readString();
      this.fileId = paramParcel.readString();
      this.aesKey = paramParcel.readString();
      this.fileUrl = paramParcel.readString();
      this.kKK = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.meg = bool;
        this.meh = paramParcel.readInt();
        this.mej = paramParcel.readInt();
        this.mei = paramParcel.readInt();
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
      paramParcel.writeString(this.dJX);
      paramParcel.writeString(this.fileId);
      paramParcel.writeString(this.aesKey);
      paramParcel.writeString(this.fileUrl);
      paramParcel.writeInt(this.kKK);
      if (this.meg) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.meh);
        paramParcel.writeInt(this.mej);
        paramParcel.writeInt(this.mei);
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