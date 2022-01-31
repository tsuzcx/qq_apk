package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.c.d.a;
import com.tencent.mm.plugin.appbrand.c.d.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import org.json.JSONObject;

public class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<JsApiUploadEncryptedMediaFileTask> CREATOR;
  public String appId;
  public String ctV;
  private ProgressDialog eeN;
  public String ewj;
  public String fileId;
  public String fileUrl;
  public int gVW;
  public boolean hSp;
  public int hSq;
  public int hSr;
  public int hSs;
  Activity hSt;
  d.a hSu;
  d.b hSv;
  public Runnable hxp;
  com.tencent.mm.plugin.appbrand.jsapi.c hyO;
  public String mimeType;
  
  static
  {
    AppMethodBeat.i(131318);
    CREATOR = new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.5();
    AppMethodBeat.o(131318);
  }
  
  public JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask()
  {
    this.hSq = 0;
    this.hSr = 0;
    this.hSs = 0;
    this.eeN = null;
  }
  
  public JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask(Parcel paramParcel)
  {
    AppMethodBeat.i(131311);
    this.hSq = 0;
    this.hSr = 0;
    this.hSs = 0;
    this.eeN = null;
    f(paramParcel);
    AppMethodBeat.o(131311);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(131312);
    ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "runInMainProcess mainEvent:%d, clientEvent:%d", new Object[] { Integer.valueOf(this.hSr), Integer.valueOf(this.hSs) });
    if (this.hSr == 1)
    {
      ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the file, remove callback");
      com.tencent.mm.plugin.appbrand.app.g.auP().a(this.hSu);
      com.tencent.mm.plugin.appbrand.app.g.auP().a(this.hSv);
      com.tencent.mm.plugin.appbrand.app.g.auP();
      com.tencent.mm.plugin.appbrand.c.b.zE(this.ctV);
      this.hSr = 0;
      this.hSs = 1;
      aBp();
      AppMethodBeat.o(131312);
      return;
    }
    AppBrandLocalMediaObject localAppBrandLocalMediaObject = AppBrandLocalMediaObjectManager.bw(this.appId, this.ctV);
    if (localAppBrandLocalMediaObject == null)
    {
      ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "getItemByLocalId return mediaObject is null, ");
      this.hSs = 1;
      aBp();
      AppMethodBeat.o(131312);
      return;
    }
    Object localObject1 = new com.tencent.mm.plugin.appbrand.c.a();
    ((com.tencent.mm.plugin.appbrand.c.a)localObject1).ctV = localAppBrandLocalMediaObject.ctV;
    ((com.tencent.mm.plugin.appbrand.c.a)localObject1).hgj = localAppBrandLocalMediaObject.fod;
    ((com.tencent.mm.plugin.appbrand.c.a)localObject1).gmb = localAppBrandLocalMediaObject.gmb;
    Object localObject2 = this.ctV;
    ((com.tencent.mm.plugin.appbrand.c.a)localObject1).cBO = com.tencent.mm.al.c.a("appbrandmediafile", bo.aoy(), (String)localObject2, (String)localObject2);
    com.tencent.mm.plugin.appbrand.app.g.auO().a((com.tencent.mm.plugin.appbrand.c.a)localObject1);
    this.hSu = new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.1(this);
    this.hSv = new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.2(this, localAppBrandLocalMediaObject);
    localObject1 = com.tencent.mm.plugin.appbrand.app.g.auP();
    localObject2 = this.hSu;
    if ((((com.tencent.mm.plugin.appbrand.c.b)localObject1).hgq != null) && (localObject2 != null) && (!((com.tencent.mm.plugin.appbrand.c.b)localObject1).hgq.contains(localObject2))) {
      ((com.tencent.mm.plugin.appbrand.c.b)localObject1).hgq.add(localObject2);
    }
    localObject1 = com.tencent.mm.plugin.appbrand.app.g.auP();
    Object localObject3 = this.appId;
    localObject2 = localAppBrandLocalMediaObject.ctV;
    int i = com.tencent.mm.i.a.ecK;
    d.b localb = this.hSv;
    com.tencent.mm.plugin.appbrand.c.a locala = com.tencent.mm.plugin.appbrand.app.g.auO().zG((String)localObject2);
    boolean bool;
    if (locala == null)
    {
      ab.e("MicroMsg.AppbrandCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[] { localObject2 });
      bool = false;
      ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask: add cdn upload task result : %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        ab.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "addUploadTask fail");
        this.hSs = 1;
        com.tencent.mm.plugin.appbrand.app.g.auP().a(this.hSu);
        com.tencent.mm.plugin.appbrand.app.g.auP().a(this.hSv);
        com.tencent.mm.plugin.appbrand.app.g.auP();
        com.tencent.mm.plugin.appbrand.c.b.zE(localAppBrandLocalMediaObject.ctV);
        aBp();
        AppMethodBeat.o(131312);
      }
    }
    else
    {
      locala.appId = ((String)localObject3);
      if ((localb != null) && (((com.tencent.mm.plugin.appbrand.c.b)localObject1).hgp != null) && (localb != null) && (!((com.tencent.mm.plugin.appbrand.c.b)localObject1).hgp.contains(localb))) {
        ((com.tencent.mm.plugin.appbrand.c.b)localObject1).hgp.add(localb);
      }
      locala.hgm = true;
      localObject3 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject3).edp = ((com.tencent.mm.plugin.appbrand.c.b)localObject1).fFy;
      ((com.tencent.mm.i.g)localObject3).cMU = true;
      ((com.tencent.mm.i.g)localObject3).field_mediaId = locala.cBO;
      ((com.tencent.mm.i.g)localObject3).field_fullpath = locala.hgj;
      ((com.tencent.mm.i.g)localObject3).field_fileType = i;
      ((com.tencent.mm.i.g)localObject3).field_talker = "weixin";
      ((com.tencent.mm.i.g)localObject3).field_priority = com.tencent.mm.i.a.ecF;
      if (i == com.tencent.mm.i.a.ecK) {}
      for (((com.tencent.mm.i.g)localObject3).field_needStorage = true;; ((com.tencent.mm.i.g)localObject3).field_needStorage = false)
      {
        ((com.tencent.mm.i.g)localObject3).field_isStreamMedia = false;
        ((com.tencent.mm.i.g)localObject3).field_appType = 0;
        ((com.tencent.mm.i.g)localObject3).field_bzScene = 0;
        ((com.tencent.mm.i.g)localObject3).field_force_aeskeycdn = true;
        ((com.tencent.mm.i.g)localObject3).field_trysafecdn = false;
        bool = f.afO().e((com.tencent.mm.i.g)localObject3);
        ab.i("MicroMsg.AppbrandCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject3).field_trysafecdn), localObject2 });
        break;
      }
    }
    if (this.hSp)
    {
      ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "show the process dialog");
      this.hSs = 2;
      aBp();
    }
    AppMethodBeat.o(131312);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(131313);
    if (this.hSs == 0)
    {
      ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_INIT");
      AppMethodBeat.o(131313);
      return;
    }
    if (this.hSs == 1)
    {
      ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_FINISH");
      if (this.eeN != null)
      {
        this.eeN.dismiss();
        this.eeN = null;
      }
      if (this.hxp != null)
      {
        this.hxp.run();
        AppMethodBeat.o(131313);
      }
    }
    else
    {
      Object localObject;
      if (this.hSs == 2)
      {
        ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_SHOW_DIALOG");
        localObject = this.hSt;
        this.hSt.getString(2131297087);
        this.eeN = h.b((Context)localObject, this.hSt.getString(2131297156), true, new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.3(this));
        this.eeN.setOnKeyListener(new JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4(this));
        AppMethodBeat.o(131313);
        return;
      }
      if (this.hSs == 3)
      {
        ab.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "CLIENT_EVENT_PROGRESS");
        localObject = new HashMap();
        ((Map)localObject).put("tempFilePath", this.ctV);
        ((Map)localObject).put("percent", Integer.valueOf(this.hSq));
        localObject = new JSONObject((Map)localObject).toString();
        new JsApiUploadEncryptedFileToCDN.a((byte)0).i(this.hyO).BM((String)localObject).aBz();
      }
    }
    AppMethodBeat.o(131313);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(131314);
    this.appId = paramParcel.readString();
    this.ctV = paramParcel.readString();
    this.fileId = paramParcel.readString();
    this.ewj = paramParcel.readString();
    this.fileUrl = paramParcel.readString();
    this.gVW = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.hSp = bool;
      this.hSq = paramParcel.readInt();
      this.hSs = paramParcel.readInt();
      this.hSr = paramParcel.readInt();
      this.mimeType = paramParcel.readString();
      AppMethodBeat.o(131314);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(131315);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.ctV);
    paramParcel.writeString(this.fileId);
    paramParcel.writeString(this.ewj);
    paramParcel.writeString(this.fileUrl);
    paramParcel.writeInt(this.gVW);
    if (this.hSp) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.hSq);
      paramParcel.writeInt(this.hSs);
      paramParcel.writeInt(this.hSr);
      paramParcel.writeString(this.mimeType);
      AppMethodBeat.o(131315);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask
 * JD-Core Version:    0.7.0.1
 */