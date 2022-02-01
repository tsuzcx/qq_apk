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
import com.tencent.mm.network.ae;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.c.a.a;
import com.tencent.mm.plugin.appbrand.c.d.a;
import com.tencent.mm.plugin.appbrand.c.d.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
      ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
      paramc.h(paramInt, e("fail", null));
      AppMethodBeat.o(46598);
      return;
    }
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
      paramc.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    String str1 = paramc.getAppId();
    String str2 = paramJSONObject.optString("tempFilePath");
    boolean bool = paramJSONObject.optBoolean("isShowProgressTips", false);
    ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", new Object[] { str1, paramJSONObject.toString() });
    if (bs.isNullOrNil(str2))
    {
      ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
      paramc.h(paramInt, e("fail:tempFilePath is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.cl(str1, str2);
    if (localAppBrandLocalMediaObject == null)
    {
      ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
      paramc.h(paramInt, e("fail:file doesn't exist", null));
      AppMethodBeat.o(46598);
      return;
    }
    if (TextUtils.isEmpty(localAppBrandLocalMediaObject.hqg))
    {
      ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
      paramc.h(paramInt, e("fail:fileFullPath is null", null));
      AppMethodBeat.o(46598);
      return;
    }
    final JsApiUploadEncryptedMediaFileTask localJsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
    localJsApiUploadEncryptedMediaFileTask.appId = str1;
    localJsApiUploadEncryptedMediaFileTask.dgl = str2;
    localJsApiUploadEncryptedMediaFileTask.kzb = bool;
    localJsApiUploadEncryptedMediaFileTask.kzf = ((Activity)localContext);
    localJsApiUploadEncryptedMediaFileTask.jYG = paramc;
    localJsApiUploadEncryptedMediaFileTask.mimeType = localAppBrandLocalMediaObject.mimeType;
    localJsApiUploadEncryptedMediaFileTask.jWP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(46580);
        HashMap localHashMap = new HashMap();
        localHashMap.put("fileId", localJsApiUploadEncryptedMediaFileTask.fileId);
        localHashMap.put("aesKey", localJsApiUploadEncryptedMediaFileTask.fQi);
        localHashMap.put("fileUrl", localJsApiUploadEncryptedMediaFileTask.fileUrl);
        localHashMap.put("fileLength", localJsApiUploadEncryptedMediaFileTask.jlZ);
        ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", new Object[] { localJsApiUploadEncryptedMediaFileTask.fileId });
        if (bs.isNullOrNil(localJsApiUploadEncryptedMediaFileTask.fileId))
        {
          ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
          paramc.h(paramInt, JsApiUploadEncryptedFileToCDN.this.e("fail", null));
        }
        for (;;)
        {
          localJsApiUploadEncryptedMediaFileTask.bek();
          AppMethodBeat.o(46580);
          return;
          ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
          paramc.h(paramInt, JsApiUploadEncryptedFileToCDN.this.k("ok", localHashMap));
        }
      }
    };
    if (!ae.cS(localContext))
    {
      ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
      if ((!TextUtils.isEmpty(localAppBrandLocalMediaObject.mimeType)) && (localAppBrandLocalMediaObject.mimeType.contains("video"))) {}
      for (paramJSONObject = localContext.getString(2131755989);; paramJSONObject = localContext.getString(2131755983))
      {
        h.a(localContext, localContext.getString(2131755985, new Object[] { paramJSONObject, bs.An((int)i.aSp(localAppBrandLocalMediaObject.hqg)) }), localContext.getString(2131755906), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(46581);
            ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
            localJsApiUploadEncryptedMediaFileTask.bej();
            AppBrandMainProcessService.a(localJsApiUploadEncryptedMediaFileTask);
            AppMethodBeat.o(46581);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(46582);
            ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
            paramc.h(paramInt, JsApiUploadEncryptedFileToCDN.this.e("cancel", null));
            localJsApiUploadEncryptedMediaFileTask.bek();
            AppMethodBeat.o(46582);
          }
        });
        AppMethodBeat.o(46598);
        return;
      }
    }
    ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
    localJsApiUploadEncryptedMediaFileTask.bej();
    AppBrandMainProcessService.a(localJsApiUploadEncryptedMediaFileTask);
    AppMethodBeat.o(46598);
  }
  
  public static class JsApiUploadEncryptedMediaFileTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<JsApiUploadEncryptedMediaFileTask> CREATOR;
    public String appId;
    public String dgl;
    public String fQi;
    public String fileId;
    public String fileUrl;
    private ProgressDialog fts;
    public Runnable jWP;
    com.tencent.mm.plugin.appbrand.jsapi.c jYG;
    public int jlZ;
    public boolean kzb;
    public int kzc;
    public int kzd;
    public int kze;
    Activity kzf;
    d.a kzg;
    d.b kzh;
    public String mimeType;
    
    static
    {
      AppMethodBeat.i(46597);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46597);
    }
    
    public JsApiUploadEncryptedMediaFileTask()
    {
      this.kzc = 0;
      this.kzd = 0;
      this.kze = 0;
      this.fts = null;
    }
    
    public JsApiUploadEncryptedMediaFileTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46590);
      this.kzc = 0;
      this.kzd = 0;
      this.kze = 0;
      this.fts = null;
      e(paramParcel);
      AppMethodBeat.o(46590);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(46591);
      ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", new Object[] { Integer.valueOf(this.kzd), Integer.valueOf(this.kze) });
      if (this.kzd == 1)
      {
        ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
        j.aVF().a(this.kzg);
        j.aVF().a(this.kzh);
        j.aVF();
        com.tencent.mm.plugin.appbrand.c.b.Jy(this.dgl);
        this.kzd = 0;
        this.kze = 1;
        bet();
        AppMethodBeat.o(46591);
        return;
      }
      final AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.cl(this.appId, this.dgl);
      if (localAppBrandLocalMediaObject == null)
      {
        ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
        this.kze = 1;
        bet();
        AppMethodBeat.o(46591);
        return;
      }
      Object localObject1 = new com.tencent.mm.plugin.appbrand.c.a();
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).dgl = localAppBrandLocalMediaObject.dgl;
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).jAH = localAppBrandLocalMediaObject.hqg;
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).ixc = localAppBrandLocalMediaObject.ixc;
      Object localObject2 = this.dgl;
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).mediaId = com.tencent.mm.an.c.a("appbrandmediafile", bs.eWj(), (String)localObject2, (String)localObject2);
      j.aVE().a((com.tencent.mm.plugin.appbrand.c.a)localObject1);
      this.kzg = new d.a()
      {
        public final void W(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46583);
          ac.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kzc = paramAnonymousInt;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kze = 3;
          JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
          AppMethodBeat.o(46583);
        }
      };
      this.kzh = new d.b()
      {
        public final void b(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(46584);
          ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString2, paramAnonymousString1, paramAnonymousString3 });
          if ((!bs.isNullOrNil(paramAnonymousString1)) && (paramAnonymousString1.equals(localAppBrandLocalMediaObject.dgl)))
          {
            j.aVF().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kzg);
            j.aVF().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kzh);
            j.aVF();
            com.tencent.mm.plugin.appbrand.c.b.Jy(localAppBrandLocalMediaObject.dgl);
            if (paramAnonymousBoolean) {
              break label267;
            }
            ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
            paramAnonymousString1 = j.aVE();
            paramAnonymousString2 = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId;
            if (!bs.isNullOrNil(paramAnonymousString2)) {
              break label285;
            }
            ac.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
            label134:
            break label299;
            label135:
            paramAnonymousString1 = null;
            label137:
            if ((paramAnonymousString1 == null) || (paramAnonymousString1.jAJ == null)) {
              break label337;
            }
            ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fQi = paramAnonymousString1.jAJ.field_aesKey;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString1.jAJ.field_fileId;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileUrl = paramAnonymousString1.jAJ.field_fileUrl;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.jlZ = paramAnonymousString1.jAJ.field_fileLength;
            ac.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", new Object[] { JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fQi, Integer.valueOf(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.jlZ) });
          }
          for (;;)
          {
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kze = 1;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.b(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
            AppMethodBeat.o(46584);
            return;
            label267:
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString2;
            ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
            break;
            label285:
            paramAnonymousString3 = paramAnonymousString1.jAS.values().iterator();
            label299:
            if (!paramAnonymousString3.hasNext()) {
              break label135;
            }
            paramAnonymousString1 = (com.tencent.mm.plugin.appbrand.c.a)paramAnonymousString3.next();
            if (!bs.nullAsNil(paramAnonymousString1.jAI).equals(paramAnonymousString2)) {
              break label134;
            }
            break label137;
            label337:
            ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
          }
        }
      };
      localObject1 = j.aVF();
      localObject2 = this.kzg;
      if ((((com.tencent.mm.plugin.appbrand.c.b)localObject1).jAO != null) && (localObject2 != null) && (!((com.tencent.mm.plugin.appbrand.c.b)localObject1).jAO.contains(localObject2))) {
        ((com.tencent.mm.plugin.appbrand.c.b)localObject1).jAO.add(localObject2);
      }
      localObject1 = j.aVF();
      Object localObject3 = this.appId;
      localObject2 = localAppBrandLocalMediaObject.dgl;
      int i = com.tencent.mm.i.a.fqv;
      d.b localb = this.kzh;
      com.tencent.mm.plugin.appbrand.c.a locala = j.aVE().Jz((String)localObject2);
      boolean bool;
      if (locala == null)
      {
        ac.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { localObject2 });
        bool = false;
        ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
          this.kze = 1;
          j.aVF().a(this.kzg);
          j.aVF().a(this.kzh);
          j.aVF();
          com.tencent.mm.plugin.appbrand.c.b.Jy(localAppBrandLocalMediaObject.dgl);
          bet();
          AppMethodBeat.o(46591);
        }
      }
      else
      {
        locala.appId = ((String)localObject3);
        if ((localb != null) && (((com.tencent.mm.plugin.appbrand.c.b)localObject1).jAN != null) && (localb != null) && (!((com.tencent.mm.plugin.appbrand.c.b)localObject1).jAN.contains(localb))) {
          ((com.tencent.mm.plugin.appbrand.c.b)localObject1).jAN.add(localb);
        }
        locala.jAK = true;
        localObject3 = new g();
        ((g)localObject3).frb = ((com.tencent.mm.plugin.appbrand.c.b)localObject1).hIz;
        ((g)localObject3).dBE = true;
        ((g)localObject3).field_mediaId = locala.mediaId;
        ((g)localObject3).field_fullpath = locala.jAH;
        ((g)localObject3).field_fileType = i;
        ((g)localObject3).field_talker = "weixin";
        ((g)localObject3).field_priority = com.tencent.mm.i.a.fqp;
        if (i == com.tencent.mm.i.a.fqv) {}
        for (((g)localObject3).field_needStorage = true;; ((g)localObject3).field_needStorage = false)
        {
          ((g)localObject3).field_isStreamMedia = false;
          ((g)localObject3).field_appType = 0;
          ((g)localObject3).field_bzScene = 0;
          ((g)localObject3).field_force_aeskeycdn = true;
          ((g)localObject3).field_trysafecdn = false;
          bool = f.aDD().f((g)localObject3);
          ac.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(((g)localObject3).field_force_aeskeycdn), Boolean.valueOf(((g)localObject3).field_trysafecdn), localObject2 });
          break;
        }
      }
      if (this.kzb)
      {
        ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
        this.kze = 2;
        bet();
      }
      AppMethodBeat.o(46591);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(46592);
      if (this.kze == 0)
      {
        ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
        AppMethodBeat.o(46592);
        return;
      }
      if (this.kze == 1)
      {
        ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
        if (this.fts != null)
        {
          this.fts.dismiss();
          this.fts = null;
        }
        if (this.jWP != null)
        {
          this.jWP.run();
          AppMethodBeat.o(46592);
        }
      }
      else
      {
        Object localObject;
        if (this.kze == 2)
        {
          ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
          localObject = this.kzf;
          this.kzf.getString(2131755906);
          this.fts = h.b((Context)localObject, this.kzf.getString(2131755988), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(46585);
              ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel uploading the media file");
              paramAnonymousDialogInterface.dismiss();
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kzd = 1;
              JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kze = 1;
              AppBrandMainProcessService.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
              AppMethodBeat.o(46585);
            }
          });
          this.fts.setOnKeyListener(new DialogInterface.OnKeyListener()
          {
            public final boolean onKey(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
            {
              AppMethodBeat.i(46588);
              if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 1))
              {
                if ((!TextUtils.isEmpty(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType)) && (JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.mimeType.contains("video"))) {}
                for (paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kzf.getString(2131755989);; paramAnonymousDialogInterface = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kzf.getString(2131755983))
                {
                  h.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kzf, true, JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kzf.getString(2131755984, new Object[] { paramAnonymousDialogInterface }), "", JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kzf.getString(2131755986), JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kzf.getString(2131755987), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(46586);
                      ac.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.c(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this).cancel();
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kzd = 1;
                      JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.kze = 1;
                      AppBrandMainProcessService.a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
                      AppMethodBeat.o(46586);
                    }
                  }, new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(46587);
                      ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "user continue upload media file");
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
        if (this.kze == 3)
        {
          ac.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
          localObject = new HashMap();
          ((Map)localObject).put("tempFilePath", this.dgl);
          ((Map)localObject).put("percent", Integer.valueOf(this.kzc));
          localObject = new JSONObject((Map)localObject).toString();
          new JsApiUploadEncryptedFileToCDN.a((byte)0).g(this.jYG).LN((String)localObject).beN();
        }
      }
      AppMethodBeat.o(46592);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46593);
      this.appId = paramParcel.readString();
      this.dgl = paramParcel.readString();
      this.fileId = paramParcel.readString();
      this.fQi = paramParcel.readString();
      this.fileUrl = paramParcel.readString();
      this.jlZ = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kzb = bool;
        this.kzc = paramParcel.readInt();
        this.kze = paramParcel.readInt();
        this.kzd = paramParcel.readInt();
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
      paramParcel.writeString(this.dgl);
      paramParcel.writeString(this.fileId);
      paramParcel.writeString(this.fQi);
      paramParcel.writeString(this.fileUrl);
      paramParcel.writeInt(this.jlZ);
      if (this.kzb) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.kzc);
        paramParcel.writeInt(this.kze);
        paramParcel.writeInt(this.kzd);
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