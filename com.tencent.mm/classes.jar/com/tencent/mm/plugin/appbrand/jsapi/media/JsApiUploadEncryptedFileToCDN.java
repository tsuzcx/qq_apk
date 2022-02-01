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
import com.tencent.mm.an.f;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.b.a.a;
import com.tencent.mm.plugin.appbrand.b.d.a;
import com.tencent.mm.plugin.appbrand.b.d.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import org.json.JSONObject;

public final class JsApiUploadEncryptedFileToCDN
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 194;
  public static final String NAME = "uploadEncryptedFileToCDN";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46598);
    Context localContext = paramc.getContext();
    if ((localContext == null) || (!(localContext instanceof Activity)))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46598);
      return;
    }
    if (paramJSONObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    String str1 = paramc.getAppId();
    String str2 = paramJSONObject.optString("tempFilePath");
    boolean bool = paramJSONObject.optBoolean("isShowProgressTips", false);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", new Object[] { str1, paramJSONObject.toString() });
    if (bu.isNullOrNil(str2))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
      paramc.h(paramInt, e("fail:tempFilePath is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.cm(str1, str2);
    if (localAppBrandLocalMediaObject == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
      paramc.h(paramInt, e("fail:file doesn't exist", null));
      AppMethodBeat.o(46598);
      return;
    }
    if (TextUtils.isEmpty(localAppBrandLocalMediaObject.hLr))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
      paramc.h(paramInt, e("fail:fileFullPath is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    final JsApiUploadEncryptedMediaFileTask localJsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
    localJsApiUploadEncryptedMediaFileTask.appId = str1;
    localJsApiUploadEncryptedMediaFileTask.dsN = str2;
    localJsApiUploadEncryptedMediaFileTask.kYT = bool;
    localJsApiUploadEncryptedMediaFileTask.kYX = ((Activity)localContext);
    localJsApiUploadEncryptedMediaFileTask.kws = paramc;
    localJsApiUploadEncryptedMediaFileTask.mimeType = localAppBrandLocalMediaObject.mimeType;
    localJsApiUploadEncryptedMediaFileTask.kuv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46580);
        HashMap localHashMap = new HashMap();
        localHashMap.put("fileId", localJsApiUploadEncryptedMediaFileTask.fileId);
        localHashMap.put("aesKey", localJsApiUploadEncryptedMediaFileTask.gmb);
        localHashMap.put("fileUrl", localJsApiUploadEncryptedMediaFileTask.fileUrl);
        localHashMap.put("fileLength", localJsApiUploadEncryptedMediaFileTask.jIO);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", new Object[] { localJsApiUploadEncryptedMediaFileTask.fileId });
        if (bu.isNullOrNil(localJsApiUploadEncryptedMediaFileTask.fileId))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
          paramc.h(paramInt, JsApiUploadEncryptedFileToCDN.this.e("fail", null));
        }
        for (;;)
        {
          localJsApiUploadEncryptedMediaFileTask.bix();
          AppMethodBeat.o(46580);
          return;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
          paramc.h(paramInt, JsApiUploadEncryptedFileToCDN.this.n("ok", localHashMap));
        }
      }
    };
    if (!com.tencent.mm.network.ae.cR(localContext))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
      if ((!TextUtils.isEmpty(localAppBrandLocalMediaObject.mimeType)) && (localAppBrandLocalMediaObject.mimeType.contains("video"))) {}
      for (paramJSONObject = localContext.getString(2131755989);; paramJSONObject = localContext.getString(2131755983))
      {
        h.a(localContext, localContext.getString(2131755985, new Object[] { paramJSONObject, bu.DB((int)o.aZR(localAppBrandLocalMediaObject.hLr)) }), localContext.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(46581);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
            localJsApiUploadEncryptedMediaFileTask.biw();
            AppBrandMainProcessService.a(localJsApiUploadEncryptedMediaFileTask);
            AppMethodBeat.o(46581);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(46582);
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
            paramc.h(paramInt, JsApiUploadEncryptedFileToCDN.this.e("cancel", null));
            localJsApiUploadEncryptedMediaFileTask.bix();
            AppMethodBeat.o(46582);
          }
        });
        AppMethodBeat.o(46598);
        return;
      }
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
    localJsApiUploadEncryptedMediaFileTask.biw();
    AppBrandMainProcessService.a(localJsApiUploadEncryptedMediaFileTask);
    AppMethodBeat.o(46598);
  }
  
  public static class JsApiUploadEncryptedMediaFileTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiUploadEncryptedMediaFileTask> CREATOR;
    public String appId;
    public String dsN;
    private ProgressDialog fOC;
    public String fileId;
    public String fileUrl;
    public String gmb;
    public int jIO;
    public boolean kYT;
    public int kYU;
    public int kYV;
    public int kYW;
    Activity kYX;
    d.a kYY;
    d.b kYZ;
    public Runnable kuv;
    com.tencent.mm.plugin.appbrand.jsapi.c kws;
    public String mimeType;
    
    static
    {
      AppMethodBeat.i(46597);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46597);
    }
    
    public JsApiUploadEncryptedMediaFileTask()
    {
      this.kYU = 0;
      this.kYV = 0;
      this.kYW = 0;
      this.fOC = null;
    }
    
    public JsApiUploadEncryptedMediaFileTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46590);
      this.kYU = 0;
      this.kYV = 0;
      this.kYW = 0;
      this.fOC = null;
      e(paramParcel);
      AppMethodBeat.o(46590);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(46591);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", new Object[] { Integer.valueOf(this.kYV), Integer.valueOf(this.kYW) });
      if (this.kYV == 1)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
        j.aZx().a(this.kYY);
        j.aZx().a(this.kYZ);
        j.aZx();
        com.tencent.mm.plugin.appbrand.b.b.Ny(this.dsN);
        this.kYV = 0;
        this.kYW = 1;
        biG();
        AppMethodBeat.o(46591);
        return;
      }
      final AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.cm(this.appId, this.dsN);
      if (localAppBrandLocalMediaObject == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
        this.kYW = 1;
        biG();
        AppMethodBeat.o(46591);
        return;
      }
      Object localObject1 = new com.tencent.mm.plugin.appbrand.b.a();
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).dsN = localAppBrandLocalMediaObject.dsN;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).jXT = localAppBrandLocalMediaObject.hLr;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).iTe = localAppBrandLocalMediaObject.iTe;
      Object localObject2 = this.dsN;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).mediaId = com.tencent.mm.an.c.a("appbrandmediafile", bu.fpO(), (String)localObject2, (String)localObject2);
      j.aZw().a((com.tencent.mm.plugin.appbrand.b.a)localObject1);
      this.kYY = new d.a()
      {
        public final void Y(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46583);
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYU = paramAnonymousInt;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYW = 3;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
          AppMethodBeat.o(46583);
        }
      };
      this.kYZ = new d.b()
      {
        public final void b(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(46584);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString2, paramAnonymousString1, paramAnonymousString3 });
          if ((!bu.isNullOrNil(paramAnonymousString1)) && (paramAnonymousString1.equals(localAppBrandLocalMediaObject.dsN)))
          {
            j.aZx().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYY);
            j.aZx().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYZ);
            j.aZx();
            com.tencent.mm.plugin.appbrand.b.b.Ny(localAppBrandLocalMediaObject.dsN);
            if (paramAnonymousBoolean) {
              break label267;
            }
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
            paramAnonymousString1 = j.aZw();
            paramAnonymousString2 = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId;
            if (!bu.isNullOrNil(paramAnonymousString2)) {
              break label285;
            }
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
            label134:
            break label299;
            label135:
            paramAnonymousString1 = null;
            label137:
            if ((paramAnonymousString1 == null) || (paramAnonymousString1.jXV == null)) {
              break label337;
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.gmb = paramAnonymousString1.jXV.field_aesKey;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString1.jXV.field_fileId;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileUrl = paramAnonymousString1.jXV.field_fileUrl;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.jIO = paramAnonymousString1.jXV.field_fileLength;
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", new Object[] { JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.gmb, Integer.valueOf(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.jIO) });
          }
          for (;;)
          {
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYW = 1;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.b(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
            AppMethodBeat.o(46584);
            return;
            label267:
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString2;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
            break;
            label285:
            paramAnonymousString3 = paramAnonymousString1.jYe.values().iterator();
            label299:
            if (!paramAnonymousString3.hasNext()) {
              break label135;
            }
            paramAnonymousString1 = (com.tencent.mm.plugin.appbrand.b.a)paramAnonymousString3.next();
            if (!bu.nullAsNil(paramAnonymousString1.jXU).equals(paramAnonymousString2)) {
              break label134;
            }
            break label137;
            label337:
            com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
          }
        }
      };
      localObject1 = j.aZx();
      localObject2 = this.kYY;
      if ((((com.tencent.mm.plugin.appbrand.b.b)localObject1).jYa != null) && (localObject2 != null) && (!((com.tencent.mm.plugin.appbrand.b.b)localObject1).jYa.contains(localObject2))) {
        ((com.tencent.mm.plugin.appbrand.b.b)localObject1).jYa.add(localObject2);
      }
      localObject1 = j.aZx();
      Object localObject3 = this.appId;
      localObject2 = localAppBrandLocalMediaObject.dsN;
      int i = com.tencent.mm.i.a.fKG;
      d.b localb = this.kYZ;
      com.tencent.mm.plugin.appbrand.b.a locala = j.aZw().Nz((String)localObject2);
      boolean bool;
      if (locala == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { localObject2 });
        bool = false;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
          this.kYW = 1;
          j.aZx().a(this.kYY);
          j.aZx().a(this.kYZ);
          j.aZx();
          com.tencent.mm.plugin.appbrand.b.b.Ny(localAppBrandLocalMediaObject.dsN);
          biG();
          AppMethodBeat.o(46591);
        }
      }
      else
      {
        locala.appId = ((String)localObject3);
        if ((localb != null) && (((com.tencent.mm.plugin.appbrand.b.b)localObject1).jXZ != null) && (localb != null) && (!((com.tencent.mm.plugin.appbrand.b.b)localObject1).jXZ.contains(localb))) {
          ((com.tencent.mm.plugin.appbrand.b.b)localObject1).jXZ.add(localb);
        }
        locala.jXW = true;
        localObject3 = new g();
        ((g)localObject3).fLl = "task_AppbrandCdnService_1";
        ((g)localObject3).fLm = ((com.tencent.mm.plugin.appbrand.b.b)localObject1).ieg;
        ((g)localObject3).dPh = true;
        ((g)localObject3).field_mediaId = locala.mediaId;
        ((g)localObject3).field_fullpath = locala.jXT;
        ((g)localObject3).field_fileType = i;
        ((g)localObject3).field_talker = "weixin";
        ((g)localObject3).field_priority = com.tencent.mm.i.a.fKA;
        if (i == com.tencent.mm.i.a.fKG) {}
        for (((g)localObject3).field_needStorage = true;; ((g)localObject3).field_needStorage = false)
        {
          ((g)localObject3).field_isStreamMedia = false;
          ((g)localObject3).field_appType = 0;
          ((g)localObject3).field_bzScene = 0;
          ((g)localObject3).field_force_aeskeycdn = true;
          ((g)localObject3).field_trysafecdn = false;
          bool = f.aGZ().f((g)localObject3);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(((g)localObject3).field_force_aeskeycdn), Boolean.valueOf(((g)localObject3).field_trysafecdn), localObject2 });
          break;
        }
      }
      if (this.kYT)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
        this.kYW = 2;
        biG();
      }
      AppMethodBeat.o(46591);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(46592);
      if (this.kYW == 0)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
        AppMethodBeat.o(46592);
        return;
      }
      if (this.kYW == 1)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
        if (this.fOC != null)
        {
          this.fOC.dismiss();
          this.fOC = null;
        }
        if (this.kuv != null)
        {
          this.kuv.run();
          AppMethodBeat.o(46592);
        }
      }
      else
      {
        Object localObject;
        if (this.kYW == 2)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
          localObject = this.kYX;
          this.kYX.getString(2131755906);
          this.fOC = h.b((Context)localObject, this.kYX.getString(2131755988), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(46585);
              com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel uploading the media file");
              paramAnonymousDialogInterface.dismiss();
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYV = 1;
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYW = 1;
              AppBrandMainProcessService.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
              AppMethodBeat.o(46585);
            }
          });
          this.fOC.setOnKeyListener(new DialogInterface.OnKeyListener()
          {
            public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(46588);
              if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1))
              {
                if ((!TextUtils.isEmpty(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType)) && (JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType.contains("video"))) {}
                for (paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYX.getString(2131755989);; paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYX.getString(2131755983))
                {
                  h.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYX, true, JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYX.getString(2131755984, new Object[] { paramAnonymousDialogInterface }), "", JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYX.getString(2131755986), JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYX.getString(2131755987), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(46586);
                      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.c(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this).cancel();
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYV = 1;
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kYW = 1;
                      AppBrandMainProcessService.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
                      AppMethodBeat.o(46586);
                    }
                  }, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(46587);
                      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "user continue upload media file");
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
        if (this.kYW == 3)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
          localObject = new HashMap();
          ((Map)localObject).put("tempFilePath", this.dsN);
          ((Map)localObject).put("percent", Integer.valueOf(this.kYU));
          localObject = new JSONObject((Map)localObject).toString();
          new JsApiUploadEncryptedFileToCDN.a((byte)0).g(this.kws).PP((String)localObject).bja();
        }
      }
      AppMethodBeat.o(46592);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46593);
      this.appId = paramParcel.readString();
      this.dsN = paramParcel.readString();
      this.fileId = paramParcel.readString();
      this.gmb = paramParcel.readString();
      this.fileUrl = paramParcel.readString();
      this.jIO = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kYT = bool;
        this.kYU = paramParcel.readInt();
        this.kYW = paramParcel.readInt();
        this.kYV = paramParcel.readInt();
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
      paramParcel.writeString(this.dsN);
      paramParcel.writeString(this.fileId);
      paramParcel.writeString(this.gmb);
      paramParcel.writeString(this.fileUrl);
      paramParcel.writeInt(this.jIO);
      if (this.kYT) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.kYU);
        paramParcel.writeInt(this.kYW);
        paramParcel.writeInt(this.kYV);
        paramParcel.writeString(this.mimeType);
        AppMethodBeat.o(46594);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN
 * JD-Core Version:    0.7.0.1
 */