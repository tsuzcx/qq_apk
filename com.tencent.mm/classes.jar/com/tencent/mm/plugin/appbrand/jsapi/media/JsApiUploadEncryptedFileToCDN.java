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
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.network.ah;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.c.a.a;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.c.d.a;
import com.tencent.mm.plugin.appbrand.c.d.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
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
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46598);
    final Context localContext = paramf.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
      paramf.callback(paramInt, ZP("fail"));
      AppMethodBeat.o(46598);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
      paramf.callback(paramInt, ZP("fail:data is null"));
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
      paramf.callback(paramInt, ZP("fail:tempFilePath is null"));
      AppMethodBeat.o(46598);
      return;
    }
    paramJSONObject = AppBrandLocalMediaObjectManager.cY(str1, str2);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
      paramf.callback(paramInt, ZP("fail:file doesn't exist"));
      AppMethodBeat.o(46598);
      return;
    }
    if (TextUtils.isEmpty(paramJSONObject.onG))
    {
      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
      paramf.callback(paramInt, ZP("fail:fileFullPath is null"));
      AppMethodBeat.o(46598);
      return;
    }
    final JsApiUploadEncryptedMediaFileTask localJsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
    localJsApiUploadEncryptedMediaFileTask.appId = str1;
    localJsApiUploadEncryptedMediaFileTask.hHB = str2;
    localJsApiUploadEncryptedMediaFileTask.shm = bool;
    localJsApiUploadEncryptedMediaFileTask.shq = ((Activity)localContext);
    localJsApiUploadEncryptedMediaFileTask.rzi = paramf;
    localJsApiUploadEncryptedMediaFileTask.mimeType = paramJSONObject.mimeType;
    localJsApiUploadEncryptedMediaFileTask.rxj = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46580);
        HashMap localHashMap = new HashMap();
        localHashMap.put("fileId", localJsApiUploadEncryptedMediaFileTask.fileId);
        localHashMap.put("aesKey", localJsApiUploadEncryptedMediaFileTask.aesKey);
        localHashMap.put("fileUrl", localJsApiUploadEncryptedMediaFileTask.fileUrl);
        localHashMap.put("fileLength", localJsApiUploadEncryptedMediaFileTask.qEw);
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", new Object[] { localJsApiUploadEncryptedMediaFileTask.fileId });
        if (Util.isNullOrNil(localJsApiUploadEncryptedMediaFileTask.fileId))
        {
          Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
          paramf.callback(paramInt, JsApiUploadEncryptedFileToCDN.this.ZP("fail"));
        }
        for (;;)
        {
          localJsApiUploadEncryptedMediaFileTask.cpx();
          AppMethodBeat.o(46580);
          return;
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
          paramf.callback(paramInt, JsApiUploadEncryptedFileToCDN.this.m("ok", localHashMap));
        }
      }
    };
    if (!ah.eb(localContext))
    {
      Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(329359);
          if ((!TextUtils.isEmpty(paramJSONObject.mimeType)) && (paramJSONObject.mimeType.contains("video"))) {}
          for (String str = localContext.getString(ba.i.appbrand_jssdk_video);; str = localContext.getString(ba.i.appbrand_jssdk_image))
          {
            com.tencent.mm.ui.base.k.a(localContext, localContext.getString(ba.i.appbrand_jssdk_upload_media_file_gprs_confirm, new Object[] { str, this.shk }), localContext.getString(ba.i.app_tip), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(329281);
                Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
                JsApiUploadEncryptedFileToCDN.2.this.shh.bQt();
                AppMethodBeat.o(329281);
              }
            }, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(329308);
                Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
                JsApiUploadEncryptedFileToCDN.2.this.erj.callback(JsApiUploadEncryptedFileToCDN.2.this.elZ, JsApiUploadEncryptedFileToCDN.this.ZP("cancel"));
                JsApiUploadEncryptedFileToCDN.2.this.shh.cpx();
                AppMethodBeat.o(329308);
              }
            });
            AppMethodBeat.o(329359);
            return;
          }
        }
      });
      AppMethodBeat.o(46598);
      return;
    }
    Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
    localJsApiUploadEncryptedMediaFileTask.bQt();
    AppMethodBeat.o(46598);
  }
  
  public static class JsApiUploadEncryptedMediaFileTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiUploadEncryptedMediaFileTask> CREATOR;
    public String aesKey;
    public String appId;
    public String fileId;
    public String fileUrl;
    public String hHB;
    private ProgressDialog lzP;
    public String mimeType;
    public int qEw;
    public Runnable rxj;
    f rzi;
    public boolean shm;
    public int shn;
    public int sho;
    public int shp;
    Activity shq;
    d.a shr;
    d.b shs;
    
    static
    {
      AppMethodBeat.i(46597);
      CREATOR = new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.5();
      AppMethodBeat.o(46597);
    }
    
    public JsApiUploadEncryptedMediaFileTask()
    {
      this.shn = 0;
      this.sho = 0;
      this.shp = 0;
      this.lzP = null;
    }
    
    public JsApiUploadEncryptedMediaFileTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46590);
      this.shn = 0;
      this.sho = 0;
      this.shp = 0;
      this.lzP = null;
      h(paramParcel);
      AppMethodBeat.o(46590);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(46591);
      Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", new Object[] { Integer.valueOf(this.sho), Integer.valueOf(this.shp) });
      if (this.sho == 1)
      {
        Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
        n.cfq().a(this.shr);
        n.cfq().a(this.shs);
        n.cfq();
        b.WU(this.hHB);
        this.sho = 0;
        this.shp = 1;
        cpA();
        AppMethodBeat.o(46591);
        return;
      }
      final AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.cY(this.appId, this.hHB);
      if (localAppBrandLocalMediaObject == null)
      {
        Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
        this.shp = 1;
        cpA();
        AppMethodBeat.o(46591);
        return;
      }
      Object localObject1 = new com.tencent.mm.plugin.appbrand.c.a();
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).hHB = localAppBrandLocalMediaObject.hHB;
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).qUK = localAppBrandLocalMediaObject.onG;
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).fileLength = localAppBrandLocalMediaObject.fileLength;
      Object localObject2 = this.hHB;
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).mediaId = h.a("appbrandmediafile", Util.nowMilliSecond(), (String)localObject2, (String)localObject2);
      n.cfp().a((com.tencent.mm.plugin.appbrand.c.a)localObject1);
      this.shr = new d.a()
      {
        public final void am(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46583);
          Log.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shn = paramAnonymousInt;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shp = 3;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
          AppMethodBeat.o(46583);
        }
      };
      this.shs = new d.b()
      {
        public final void b(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(46584);
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString2, paramAnonymousString1, paramAnonymousString3 });
          if ((!Util.isNullOrNil(paramAnonymousString1)) && (paramAnonymousString1.equals(localAppBrandLocalMediaObject.hHB)))
          {
            n.cfq().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shr);
            n.cfq().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shs);
            n.cfq();
            b.WU(localAppBrandLocalMediaObject.hHB);
            if (paramAnonymousBoolean) {
              break label267;
            }
            Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
            paramAnonymousString1 = n.cfp();
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
            if ((paramAnonymousString1 == null) || (paramAnonymousString1.qUM == null)) {
              break label337;
            }
            Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.aesKey = paramAnonymousString1.qUM.field_aesKey;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString1.qUM.field_fileId;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileUrl = paramAnonymousString1.qUM.field_fileUrl;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.qEw = paramAnonymousString1.qUM.field_fileLength;
            Log.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", new Object[] { JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.aesKey, Integer.valueOf(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.qEw) });
          }
          for (;;)
          {
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shp = 1;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.b(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
            AppMethodBeat.o(46584);
            return;
            label267:
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString2;
            Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
            break;
            label285:
            paramAnonymousString3 = paramAnonymousString1.qUV.values().iterator();
            label299:
            if (!paramAnonymousString3.hasNext()) {
              break label135;
            }
            paramAnonymousString1 = (com.tencent.mm.plugin.appbrand.c.a)paramAnonymousString3.next();
            if (!Util.nullAsNil(paramAnonymousString1.qUL).equals(paramAnonymousString2)) {
              break label134;
            }
            break label137;
            label337:
            Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
          }
        }
      };
      localObject1 = n.cfq();
      localObject2 = this.shr;
      if ((((b)localObject1).qUR != null) && (localObject2 != null) && (!((b)localObject1).qUR.contains(localObject2))) {
        ((b)localObject1).qUR.add(localObject2);
      }
      localObject1 = n.cfq();
      Object localObject3 = this.appId;
      localObject2 = localAppBrandLocalMediaObject.hHB;
      int i = com.tencent.mm.g.a.lwf;
      d.b localb = this.shs;
      com.tencent.mm.plugin.appbrand.c.a locala = n.cfp().WV((String)localObject2);
      boolean bool;
      if (locala == null)
      {
        Log.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { localObject2 });
        bool = false;
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
          this.shp = 1;
          n.cfq().a(this.shr);
          n.cfq().a(this.shs);
          n.cfq();
          b.WU(localAppBrandLocalMediaObject.hHB);
          cpA();
          AppMethodBeat.o(46591);
        }
      }
      else
      {
        locala.appId = ((String)localObject3);
        if ((localb != null) && (((b)localObject1).qUQ != null) && (localb != null) && (!((b)localObject1).qUQ.contains(localb))) {
          ((b)localObject1).qUQ.add(localb);
        }
        locala.qUN = true;
        localObject3 = new com.tencent.mm.g.g();
        ((com.tencent.mm.g.g)localObject3).taskName = "task_AppbrandCdnService_1";
        ((com.tencent.mm.g.g)localObject3).lwL = ((b)localObject1).osH;
        ((com.tencent.mm.g.g)localObject3).ihD = true;
        ((com.tencent.mm.g.g)localObject3).field_mediaId = locala.mediaId;
        ((com.tencent.mm.g.g)localObject3).field_fullpath = locala.qUK;
        ((com.tencent.mm.g.g)localObject3).field_fileType = i;
        ((com.tencent.mm.g.g)localObject3).field_talker = "weixin";
        ((com.tencent.mm.g.g)localObject3).field_priority = com.tencent.mm.g.a.lvZ;
        if (i == com.tencent.mm.g.a.lwf) {}
        for (((com.tencent.mm.g.g)localObject3).field_needStorage = true;; ((com.tencent.mm.g.g)localObject3).field_needStorage = false)
        {
          ((com.tencent.mm.g.g)localObject3).field_isStreamMedia = false;
          ((com.tencent.mm.g.g)localObject3).field_appType = 0;
          ((com.tencent.mm.g.g)localObject3).field_bzScene = 0;
          ((com.tencent.mm.g.g)localObject3).field_force_aeskeycdn = true;
          ((com.tencent.mm.g.g)localObject3).field_trysafecdn = false;
          bool = com.tencent.mm.modelcdntran.k.bHW().g((com.tencent.mm.g.g)localObject3);
          Log.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(((com.tencent.mm.g.g)localObject3).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.g.g)localObject3).field_trysafecdn), localObject2 });
          break;
        }
      }
      if (this.shm)
      {
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
        this.shp = 2;
        cpA();
      }
      AppMethodBeat.o(46591);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(46592);
      if (this.shp == 0)
      {
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
        AppMethodBeat.o(46592);
        return;
      }
      if (this.shp == 1)
      {
        Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
        if (this.lzP != null)
        {
          this.lzP.dismiss();
          this.lzP = null;
        }
        if (this.rxj != null)
        {
          this.rxj.run();
          AppMethodBeat.o(46592);
        }
      }
      else
      {
        Object localObject;
        if (this.shp == 2)
        {
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
          localObject = this.shq;
          this.shq.getString(ba.i.app_tip);
          this.lzP = com.tencent.mm.ui.base.k.a((Context)localObject, this.shq.getString(ba.i.appbrand_jssdk_uploading), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(46585);
              Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel uploading the media file");
              paramAnonymousDialogInterface.dismiss();
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.sho = 1;
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shp = 1;
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.bQt();
              AppMethodBeat.o(46585);
            }
          });
          this.lzP.setOnKeyListener(new DialogInterface.OnKeyListener()
          {
            public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(46588);
              if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1))
              {
                if ((!TextUtils.isEmpty(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType)) && (JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType.contains("video"))) {}
                for (paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shq.getString(ba.i.appbrand_jssdk_video);; paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shq.getString(ba.i.appbrand_jssdk_image))
                {
                  com.tencent.mm.ui.base.k.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shq, true, JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shq.getString(ba.i.appbrand_jssdk_media_file_uploading_tips, new Object[] { paramAnonymousDialogInterface }), "", JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shq.getString(ba.i.appbrand_jssdk_upload_video_cancel), JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shq.getString(ba.i.appbrand_jssdk_upload_video_continue), new DialogInterface.OnClickListener()new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4.2
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(46586);
                      Log.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.c(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this).cancel();
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.sho = 1;
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.shp = 1;
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.bQt();
                      AppMethodBeat.o(46586);
                    }
                  }, new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4.2(this));
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
        if (this.shp == 3)
        {
          Log.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
          localObject = new HashMap();
          ((Map)localObject).put("tempFilePath", this.hHB);
          ((Map)localObject).put("percent", Integer.valueOf(this.shn));
          localObject = new JSONObject((Map)localObject).toString();
          new JsApiUploadEncryptedFileToCDN.a((byte)0).h(this.rzi).ZQ((String)localObject).cpV();
        }
      }
      AppMethodBeat.o(46592);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46593);
      this.appId = paramParcel.readString();
      this.hHB = paramParcel.readString();
      this.fileId = paramParcel.readString();
      this.aesKey = paramParcel.readString();
      this.fileUrl = paramParcel.readString();
      this.qEw = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.shm = bool;
        this.shn = paramParcel.readInt();
        this.shp = paramParcel.readInt();
        this.sho = paramParcel.readInt();
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
      paramParcel.writeString(this.hHB);
      paramParcel.writeString(this.fileId);
      paramParcel.writeString(this.aesKey);
      paramParcel.writeString(this.fileUrl);
      paramParcel.writeInt(this.qEw);
      if (this.shm) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.shn);
        paramParcel.writeInt(this.shp);
        paramParcel.writeInt(this.sho);
        paramParcel.writeString(this.mimeType);
        AppMethodBeat.o(46594);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN
 * JD-Core Version:    0.7.0.1
 */