package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.cbf;
import com.tencent.mm.protocal.c.cbg;
import com.tencent.mm.sdk.platformtools.y;

class JsApiUploadWeRunData$UploadMiniAppStepTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<UploadMiniAppStepTask> CREATOR = new JsApiUploadWeRunData.UploadMiniAppStepTask.2();
  private String appId;
  private boolean bJy;
  private i gfG;
  private int gfg;
  private c ggu;
  private int ghE;
  private boolean ghF;
  
  public JsApiUploadWeRunData$UploadMiniAppStepTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiUploadWeRunData$UploadMiniAppStepTask(i parami, c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    y.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask");
    this.gfG = parami;
    this.ggu = paramc;
    this.gfg = paramInt1;
    this.ghE = paramInt2;
    this.ghF = paramBoolean;
    this.appId = paramc.getAppId();
  }
  
  public final void Zu()
  {
    long l2 = bz.Is();
    y.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask currentTime %d", new Object[] { Long.valueOf(l2 / 1000L) });
    long l1 = l2;
    if (l2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    b.a locala = new b.a();
    cbf localcbf = new cbf();
    locala.ecH = localcbf;
    locala.ecI = new cbg();
    locala.uri = "/cgi-bin/mmoc-bin/hardware/uploadminiappstep";
    locala.ecG = 1949;
    locala.ecJ = 0;
    locala.ecK = 0;
    localcbf.euK = this.appId;
    localcbf.hQP = this.ghE;
    localcbf.tQo = this.ghF;
    localcbf.kTR = ((int)(l1 / 1000L));
    w.a(locala.Kt(), new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, m paramAnonymousm)
      {
        if (paramAnonymousm.getType() != 1949) {
          return 0;
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
        {
          JsApiUploadWeRunData.UploadMiniAppStepTask.a(JsApiUploadWeRunData.UploadMiniAppStepTask.this, true);
          y.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask ok.");
        }
        for (;;)
        {
          JsApiUploadWeRunData.UploadMiniAppStepTask.a(JsApiUploadWeRunData.UploadMiniAppStepTask.this);
          return 0;
          JsApiUploadWeRunData.UploadMiniAppStepTask.a(JsApiUploadWeRunData.UploadMiniAppStepTask.this, false);
          y.i("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask fail: errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        }
      }
    }, true);
  }
  
  public final void Zv()
  {
    if (this.bJy) {
      this.ggu.C(this.gfg, this.gfG.h("ok", null));
    }
    for (;;)
    {
      ahD();
      return;
      this.ggu.C(this.gfg, this.gfG.h("fail", null));
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.ghE = paramParcel.readInt();
    if (paramParcel.readByte() != 0)
    {
      bool1 = true;
      this.ghF = bool1;
      if (paramParcel.readByte() == 0) {
        break label52;
      }
    }
    label52:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.bJy = bool1;
      this.appId = paramParcel.readString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    paramParcel.writeInt(this.ghE);
    if (this.ghF)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.bJy) {
        break label54;
      }
    }
    label54:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      paramParcel.writeString(this.appId);
      return;
      b1 = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData.UploadMiniAppStepTask
 * JD-Core Version:    0.7.0.1
 */