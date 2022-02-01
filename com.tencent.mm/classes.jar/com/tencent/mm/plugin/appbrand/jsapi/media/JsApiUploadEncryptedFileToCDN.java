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
import com.tencent.mm.ao.f;
import com.tencent.mm.i.g;
import com.tencent.mm.network.ae;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
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
      ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46598);
      return;
    }
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    String str1 = paramc.getAppId();
    String str2 = paramJSONObject.optString("tempFilePath");
    boolean bool = paramJSONObject.optBoolean("isShowProgressTips", false);
    ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", new Object[] { str1, paramJSONObject.toString() });
    if (bt.isNullOrNil(str2))
    {
      ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
      paramc.h(paramInt, e("fail:tempFilePath is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.cl(str1, str2);
    if (localAppBrandLocalMediaObject == null)
    {
      ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
      paramc.h(paramInt, e("fail:file doesn't exist", null));
      AppMethodBeat.o(46598);
      return;
    }
    if (TextUtils.isEmpty(localAppBrandLocalMediaObject.hIy))
    {
      ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
      paramc.h(paramInt, e("fail:fileFullPath is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    final JsApiUploadEncryptedMediaFileTask localJsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
    localJsApiUploadEncryptedMediaFileTask.appId = str1;
    localJsApiUploadEncryptedMediaFileTask.drH = str2;
    localJsApiUploadEncryptedMediaFileTask.kVl = bool;
    localJsApiUploadEncryptedMediaFileTask.kVp = ((Activity)localContext);
    localJsApiUploadEncryptedMediaFileTask.ktc = paramc;
    localJsApiUploadEncryptedMediaFileTask.mimeType = localAppBrandLocalMediaObject.mimeType;
    localJsApiUploadEncryptedMediaFileTask.krg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46580);
        HashMap localHashMap = new HashMap();
        localHashMap.put("fileId", localJsApiUploadEncryptedMediaFileTask.fileId);
        localHashMap.put("aesKey", localJsApiUploadEncryptedMediaFileTask.gjI);
        localHashMap.put("fileUrl", localJsApiUploadEncryptedMediaFileTask.fileUrl);
        localHashMap.put("fileLength", localJsApiUploadEncryptedMediaFileTask.jFP);
        ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", new Object[] { localJsApiUploadEncryptedMediaFileTask.fileId });
        if (bt.isNullOrNil(localJsApiUploadEncryptedMediaFileTask.fileId))
        {
          ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
          paramc.h(paramInt, JsApiUploadEncryptedFileToCDN.this.e("fail", null));
        }
        for (;;)
        {
          localJsApiUploadEncryptedMediaFileTask.bhO();
          AppMethodBeat.o(46580);
          return;
          ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
          paramc.h(paramInt, JsApiUploadEncryptedFileToCDN.this.m("ok", localHashMap));
        }
      }
    };
    if (!ae.cP(localContext))
    {
      ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
      if ((!TextUtils.isEmpty(localAppBrandLocalMediaObject.mimeType)) && (localAppBrandLocalMediaObject.mimeType.contains("video"))) {}
      for (paramJSONObject = localContext.getString(2131755989);; paramJSONObject = localContext.getString(2131755983))
      {
        h.a(localContext, localContext.getString(2131755985, new Object[] { paramJSONObject, bt.Dd((int)i.aYo(localAppBrandLocalMediaObject.hIy)) }), localContext.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(46581);
            ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
            localJsApiUploadEncryptedMediaFileTask.bhN();
            AppBrandMainProcessService.a(localJsApiUploadEncryptedMediaFileTask);
            AppMethodBeat.o(46581);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(46582);
            ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
            paramc.h(paramInt, JsApiUploadEncryptedFileToCDN.this.e("cancel", null));
            localJsApiUploadEncryptedMediaFileTask.bhO();
            AppMethodBeat.o(46582);
          }
        });
        AppMethodBeat.o(46598);
        return;
      }
    }
    ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
    localJsApiUploadEncryptedMediaFileTask.bhN();
    AppBrandMainProcessService.a(localJsApiUploadEncryptedMediaFileTask);
    AppMethodBeat.o(46598);
  }
  
  public static class JsApiUploadEncryptedMediaFileTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiUploadEncryptedMediaFileTask> CREATOR;
    public String appId;
    public String drH;
    private ProgressDialog fMu;
    public String fileId;
    public String fileUrl;
    public String gjI;
    public int jFP;
    public boolean kVl;
    public int kVm;
    public int kVn;
    public int kVo;
    Activity kVp;
    d.a kVq;
    d.b kVr;
    public Runnable krg;
    com.tencent.mm.plugin.appbrand.jsapi.c ktc;
    public String mimeType;
    
    static
    {
      AppMethodBeat.i(46597);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46597);
    }
    
    public JsApiUploadEncryptedMediaFileTask()
    {
      this.kVm = 0;
      this.kVn = 0;
      this.kVo = 0;
      this.fMu = null;
    }
    
    public JsApiUploadEncryptedMediaFileTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46590);
      this.kVm = 0;
      this.kVn = 0;
      this.kVo = 0;
      this.fMu = null;
      e(paramParcel);
      AppMethodBeat.o(46590);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(46591);
      ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", new Object[] { Integer.valueOf(this.kVn), Integer.valueOf(this.kVo) });
      if (this.kVn == 1)
      {
        ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
        j.aZa().a(this.kVq);
        j.aZa().a(this.kVr);
        j.aZa();
        com.tencent.mm.plugin.appbrand.b.b.MR(this.drH);
        this.kVn = 0;
        this.kVo = 1;
        bhX();
        AppMethodBeat.o(46591);
        return;
      }
      final AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.cl(this.appId, this.drH);
      if (localAppBrandLocalMediaObject == null)
      {
        ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
        this.kVo = 1;
        bhX();
        AppMethodBeat.o(46591);
        return;
      }
      Object localObject1 = new com.tencent.mm.plugin.appbrand.b.a();
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).drH = localAppBrandLocalMediaObject.drH;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).jUC = localAppBrandLocalMediaObject.hIy;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).iQl = localAppBrandLocalMediaObject.iQl;
      Object localObject2 = this.drH;
      ((com.tencent.mm.plugin.appbrand.b.a)localObject1).mediaId = com.tencent.mm.ao.c.a("appbrandmediafile", bt.flT(), (String)localObject2, (String)localObject2);
      j.aYZ().a((com.tencent.mm.plugin.appbrand.b.a)localObject1);
      this.kVq = new d.a()
      {
        public final void Y(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46583);
          ad.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVm = paramAnonymousInt;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVo = 3;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
          AppMethodBeat.o(46583);
        }
      };
      this.kVr = new d.b()
      {
        public final void b(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(46584);
          ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString2, paramAnonymousString1, paramAnonymousString3 });
          if ((!bt.isNullOrNil(paramAnonymousString1)) && (paramAnonymousString1.equals(localAppBrandLocalMediaObject.drH)))
          {
            j.aZa().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVq);
            j.aZa().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVr);
            j.aZa();
            com.tencent.mm.plugin.appbrand.b.b.MR(localAppBrandLocalMediaObject.drH);
            if (paramAnonymousBoolean) {
              break label267;
            }
            ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
            paramAnonymousString1 = j.aYZ();
            paramAnonymousString2 = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId;
            if (!bt.isNullOrNil(paramAnonymousString2)) {
              break label285;
            }
            ad.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
            label134:
            break label299;
            label135:
            paramAnonymousString1 = null;
            label137:
            if ((paramAnonymousString1 == null) || (paramAnonymousString1.jUE == null)) {
              break label337;
            }
            ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.gjI = paramAnonymousString1.jUE.field_aesKey;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString1.jUE.field_fileId;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileUrl = paramAnonymousString1.jUE.field_fileUrl;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.jFP = paramAnonymousString1.jUE.field_fileLength;
            ad.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", new Object[] { JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.gjI, Integer.valueOf(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.jFP) });
          }
          for (;;)
          {
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVo = 1;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.b(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
            AppMethodBeat.o(46584);
            return;
            label267:
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString2;
            ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
            break;
            label285:
            paramAnonymousString3 = paramAnonymousString1.jUN.values().iterator();
            label299:
            if (!paramAnonymousString3.hasNext()) {
              break label135;
            }
            paramAnonymousString1 = (com.tencent.mm.plugin.appbrand.b.a)paramAnonymousString3.next();
            if (!bt.nullAsNil(paramAnonymousString1.jUD).equals(paramAnonymousString2)) {
              break label134;
            }
            break label137;
            label337:
            ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
          }
        }
      };
      localObject1 = j.aZa();
      localObject2 = this.kVq;
      if ((((com.tencent.mm.plugin.appbrand.b.b)localObject1).jUJ != null) && (localObject2 != null) && (!((com.tencent.mm.plugin.appbrand.b.b)localObject1).jUJ.contains(localObject2))) {
        ((com.tencent.mm.plugin.appbrand.b.b)localObject1).jUJ.add(localObject2);
      }
      localObject1 = j.aZa();
      Object localObject3 = this.appId;
      localObject2 = localAppBrandLocalMediaObject.drH;
      int i = com.tencent.mm.i.a.fIC;
      d.b localb = this.kVr;
      com.tencent.mm.plugin.appbrand.b.a locala = j.aYZ().MS((String)localObject2);
      boolean bool;
      if (locala == null)
      {
        ad.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { localObject2 });
        bool = false;
        ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
          this.kVo = 1;
          j.aZa().a(this.kVq);
          j.aZa().a(this.kVr);
          j.aZa();
          com.tencent.mm.plugin.appbrand.b.b.MR(localAppBrandLocalMediaObject.drH);
          bhX();
          AppMethodBeat.o(46591);
        }
      }
      else
      {
        locala.appId = ((String)localObject3);
        if ((localb != null) && (((com.tencent.mm.plugin.appbrand.b.b)localObject1).jUI != null) && (localb != null) && (!((com.tencent.mm.plugin.appbrand.b.b)localObject1).jUI.contains(localb))) {
          ((com.tencent.mm.plugin.appbrand.b.b)localObject1).jUI.add(localb);
        }
        locala.jUF = true;
        localObject3 = new g();
        ((g)localObject3).fJi = "task_AppbrandCdnService_1";
        ((g)localObject3).fJj = ((com.tencent.mm.plugin.appbrand.b.b)localObject1).ibn;
        ((g)localObject3).dNR = true;
        ((g)localObject3).field_mediaId = locala.mediaId;
        ((g)localObject3).field_fullpath = locala.jUC;
        ((g)localObject3).field_fileType = i;
        ((g)localObject3).field_talker = "weixin";
        ((g)localObject3).field_priority = com.tencent.mm.i.a.fIw;
        if (i == com.tencent.mm.i.a.fIC) {}
        for (((g)localObject3).field_needStorage = true;; ((g)localObject3).field_needStorage = false)
        {
          ((g)localObject3).field_isStreamMedia = false;
          ((g)localObject3).field_appType = 0;
          ((g)localObject3).field_bzScene = 0;
          ((g)localObject3).field_force_aeskeycdn = true;
          ((g)localObject3).field_trysafecdn = false;
          bool = f.aGI().f((g)localObject3);
          ad.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(((g)localObject3).field_force_aeskeycdn), Boolean.valueOf(((g)localObject3).field_trysafecdn), localObject2 });
          break;
        }
      }
      if (this.kVl)
      {
        ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
        this.kVo = 2;
        bhX();
      }
      AppMethodBeat.o(46591);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(46592);
      if (this.kVo == 0)
      {
        ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
        AppMethodBeat.o(46592);
        return;
      }
      if (this.kVo == 1)
      {
        ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
        if (this.fMu != null)
        {
          this.fMu.dismiss();
          this.fMu = null;
        }
        if (this.krg != null)
        {
          this.krg.run();
          AppMethodBeat.o(46592);
        }
      }
      else
      {
        Object localObject;
        if (this.kVo == 2)
        {
          ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
          localObject = this.kVp;
          this.kVp.getString(2131755906);
          this.fMu = h.b((Context)localObject, this.kVp.getString(2131755988), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(46585);
              ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel uploading the media file");
              paramAnonymousDialogInterface.dismiss();
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVn = 1;
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVo = 1;
              AppBrandMainProcessService.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
              AppMethodBeat.o(46585);
            }
          });
          this.fMu.setOnKeyListener(new DialogInterface.OnKeyListener()
          {
            public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(46588);
              if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1))
              {
                if ((!TextUtils.isEmpty(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType)) && (JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType.contains("video"))) {}
                for (paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVp.getString(2131755989);; paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVp.getString(2131755983))
                {
                  h.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVp, true, JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVp.getString(2131755984, new Object[] { paramAnonymousDialogInterface }), "", JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVp.getString(2131755986), JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVp.getString(2131755987), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(46586);
                      ad.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.c(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this).cancel();
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVn = 1;
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kVo = 1;
                      AppBrandMainProcessService.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
                      AppMethodBeat.o(46586);
                    }
                  }, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(46587);
                      ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "user continue upload media file");
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
        if (this.kVo == 3)
        {
          ad.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
          localObject = new HashMap();
          ((Map)localObject).put("tempFilePath", this.drH);
          ((Map)localObject).put("percent", Integer.valueOf(this.kVm));
          localObject = new JSONObject((Map)localObject).toString();
          new JsApiUploadEncryptedFileToCDN.a((byte)0).g(this.ktc).Ph((String)localObject).bir();
        }
      }
      AppMethodBeat.o(46592);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46593);
      this.appId = paramParcel.readString();
      this.drH = paramParcel.readString();
      this.fileId = paramParcel.readString();
      this.gjI = paramParcel.readString();
      this.fileUrl = paramParcel.readString();
      this.jFP = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kVl = bool;
        this.kVm = paramParcel.readInt();
        this.kVo = paramParcel.readInt();
        this.kVn = paramParcel.readInt();
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
      paramParcel.writeString(this.drH);
      paramParcel.writeString(this.fileId);
      paramParcel.writeString(this.gjI);
      paramParcel.writeString(this.fileUrl);
      paramParcel.writeInt(this.jFP);
      if (this.kVl) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.kVm);
        paramParcel.writeInt(this.kVo);
        paramParcel.writeInt(this.kVn);
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