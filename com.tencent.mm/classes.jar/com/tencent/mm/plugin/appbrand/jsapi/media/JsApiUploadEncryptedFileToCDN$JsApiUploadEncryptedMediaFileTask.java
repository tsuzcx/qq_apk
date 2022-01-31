package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.c.a.a;
import com.tencent.mm.plugin.appbrand.c.d.a;
import com.tencent.mm.plugin.appbrand.c.d.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import org.json.JSONObject;

public class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiUploadEncryptedMediaFileTask> CREATOR = new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.5();
  public String appId;
  public String bMB;
  public String dQR;
  private ProgressDialog dnm = null;
  public int fDG;
  public String fileId;
  public String fileUrl;
  public Runnable gfD;
  com.tencent.mm.plugin.appbrand.jsapi.c ggu;
  d.b gwA;
  public boolean gwu;
  public int gwv = 0;
  public int gww = 0;
  public int gwx = 0;
  Activity gwy;
  d.a gwz;
  public String mimeType;
  
  public JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask() {}
  
  public JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", new Object[] { Integer.valueOf(this.gww), Integer.valueOf(this.gwx) });
    if (this.gww == 1)
    {
      y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
      e.abe().a(this.gwz);
      e.abe().a(this.gwA);
      e.abe();
      com.tencent.mm.plugin.appbrand.c.b.rO(this.bMB);
      this.gww = 0;
      this.gwx = 1;
      ahI();
    }
    do
    {
      return;
      final AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.getItemByLocalId(this.appId, this.bMB);
      if (localAppBrandLocalMediaObject == null)
      {
        y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
        this.gwx = 1;
        ahI();
        return;
      }
      Object localObject1 = new com.tencent.mm.plugin.appbrand.c.a();
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).bMB = localAppBrandLocalMediaObject.bMB;
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).fMZ = localAppBrandLocalMediaObject.dXY;
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).eUd = localAppBrandLocalMediaObject.eUd;
      Object localObject2 = this.bMB;
      ((com.tencent.mm.plugin.appbrand.c.a)localObject1).bUi = com.tencent.mm.ak.c.a("appbrandmediafile", bk.UY(), (String)localObject2, (String)localObject2);
      e.abd().a((com.tencent.mm.plugin.appbrand.c.a)localObject1);
      this.gwz = new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.1(this);
      this.gwA = new d.b()
      {
        public final void b(boolean paramAnonymousBoolean, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString2, paramAnonymousString1, paramAnonymousString3 });
          if ((!bk.bl(paramAnonymousString1)) && (paramAnonymousString1.equals(localAppBrandLocalMediaObject.bMB)))
          {
            e.abe().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.gwz);
            e.abe().a(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.gwA);
            e.abe();
            com.tencent.mm.plugin.appbrand.c.b.rO(localAppBrandLocalMediaObject.bMB);
            if (paramAnonymousBoolean) {
              break label257;
            }
            y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
            paramAnonymousString1 = e.abd();
            paramAnonymousString2 = JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId;
            if (!bk.bl(paramAnonymousString2)) {
              break label275;
            }
            y.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
            label129:
            break label289;
            label130:
            paramAnonymousString1 = null;
            label132:
            if ((paramAnonymousString1 == null) || (paramAnonymousString1.fNb == null)) {
              break label327;
            }
            y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.dQR = paramAnonymousString1.fNb.field_aesKey;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString1.fNb.field_fileId;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileUrl = paramAnonymousString1.fNb.field_fileUrl;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fDG = paramAnonymousString1.fNb.field_fileLength;
            y.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", new Object[] { JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.dQR, Integer.valueOf(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fDG) });
          }
          for (;;)
          {
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.gwx = 1;
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.b(JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this);
            return;
            label257:
            JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.this.fileId = paramAnonymousString2;
            y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
            break;
            label275:
            paramAnonymousString3 = paramAnonymousString1.fNk.values().iterator();
            label289:
            if (!paramAnonymousString3.hasNext()) {
              break label130;
            }
            paramAnonymousString1 = (com.tencent.mm.plugin.appbrand.c.a)paramAnonymousString3.next();
            if (!bk.pm(paramAnonymousString1.fNa).equals(paramAnonymousString2)) {
              break label129;
            }
            break label132;
            label327:
            y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
          }
        }
      };
      localObject1 = e.abe();
      localObject2 = this.gwz;
      if ((((com.tencent.mm.plugin.appbrand.c.b)localObject1).fNg != null) && (localObject2 != null) && (!((com.tencent.mm.plugin.appbrand.c.b)localObject1).fNg.contains(localObject2))) {
        ((com.tencent.mm.plugin.appbrand.c.b)localObject1).fNg.add(localObject2);
      }
      localObject1 = e.abe();
      Object localObject3 = this.appId;
      localObject2 = localAppBrandLocalMediaObject.bMB;
      int i = com.tencent.mm.j.a.dlp;
      d.b localb = this.gwA;
      com.tencent.mm.plugin.appbrand.c.a locala = e.abd().rQ((String)localObject2);
      boolean bool;
      if (locala == null)
      {
        y.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { localObject2 });
        bool = false;
        y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool)
        {
          y.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
          this.gwx = 1;
          e.abe().a(this.gwz);
          e.abe().a(this.gwA);
          e.abe();
          com.tencent.mm.plugin.appbrand.c.b.rO(localAppBrandLocalMediaObject.bMB);
          ahI();
        }
      }
      else
      {
        locala.appId = ((String)localObject3);
        if ((localb != null) && (((com.tencent.mm.plugin.appbrand.c.b)localObject1).fNf != null) && (localb != null) && (!((com.tencent.mm.plugin.appbrand.c.b)localObject1).fNf.contains(localb))) {
          ((com.tencent.mm.plugin.appbrand.c.b)localObject1).fNf.add(localb);
        }
        locala.fNc = true;
        localObject3 = new com.tencent.mm.j.f();
        ((com.tencent.mm.j.f)localObject3).dlP = ((com.tencent.mm.plugin.appbrand.c.b)localObject1).epa;
        ((com.tencent.mm.j.f)localObject3).ceg = true;
        ((com.tencent.mm.j.f)localObject3).field_mediaId = locala.bUi;
        ((com.tencent.mm.j.f)localObject3).field_fullpath = locala.fMZ;
        ((com.tencent.mm.j.f)localObject3).field_fileType = i;
        ((com.tencent.mm.j.f)localObject3).field_talker = "weixin";
        ((com.tencent.mm.j.f)localObject3).field_priority = com.tencent.mm.j.a.dlk;
        if (i == com.tencent.mm.j.a.dlp) {}
        for (((com.tencent.mm.j.f)localObject3).field_needStorage = true;; ((com.tencent.mm.j.f)localObject3).field_needStorage = false)
        {
          ((com.tencent.mm.j.f)localObject3).field_isStreamMedia = false;
          ((com.tencent.mm.j.f)localObject3).field_appType = 0;
          ((com.tencent.mm.j.f)localObject3).field_bzScene = 0;
          ((com.tencent.mm.j.f)localObject3).field_force_aeskeycdn = true;
          ((com.tencent.mm.j.f)localObject3).field_trysafecdn = false;
          bool = com.tencent.mm.ak.f.Nd().c((com.tencent.mm.j.f)localObject3);
          y.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(((com.tencent.mm.j.f)localObject3).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.j.f)localObject3).field_trysafecdn), localObject2 });
          break;
        }
      }
    } while (!this.gwu);
    y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
    this.gwx = 2;
    ahI();
  }
  
  public final void Zv()
  {
    if (this.gwx == 0) {
      y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
    }
    do
    {
      do
      {
        return;
        if (this.gwx != 1) {
          break;
        }
        y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
        if (this.dnm != null)
        {
          this.dnm.dismiss();
          this.dnm = null;
        }
      } while (this.gfD == null);
      this.gfD.run();
      return;
      if (this.gwx == 2)
      {
        y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
        localObject = this.gwy;
        this.gwy.getString(y.j.app_tip);
        this.dnm = h.b((Context)localObject, this.gwy.getString(y.j.appbrand_jssdk_uploading), true, new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.3(this));
        this.dnm.setOnKeyListener(new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4(this));
        return;
      }
    } while (this.gwx != 3);
    y.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
    Object localObject = new HashMap();
    ((Map)localObject).put("tempFilePath", this.bMB);
    ((Map)localObject).put("percent", Integer.valueOf(this.gwv));
    localObject = new JSONObject((Map)localObject).toString();
    new JsApiUploadEncryptedFileToCDN.a((byte)0).d(this.ggu).tL((String)localObject).dispatch();
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    this.appId = paramParcel.readString();
    this.bMB = paramParcel.readString();
    this.fileId = paramParcel.readString();
    this.dQR = paramParcel.readString();
    this.fileUrl = paramParcel.readString();
    this.fDG = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.gwu = bool;
      this.gwv = paramParcel.readInt();
      this.gwx = paramParcel.readInt();
      this.gww = paramParcel.readInt();
      this.mimeType = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.bMB);
    paramParcel.writeString(this.fileId);
    paramParcel.writeString(this.dQR);
    paramParcel.writeString(this.fileUrl);
    paramParcel.writeInt(this.fDG);
    if (this.gwu) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.gwv);
      paramParcel.writeInt(this.gwx);
      paramParcel.writeInt(this.gww);
      paramParcel.writeString(this.mimeType);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask
 * JD-Core Version:    0.7.0.1
 */