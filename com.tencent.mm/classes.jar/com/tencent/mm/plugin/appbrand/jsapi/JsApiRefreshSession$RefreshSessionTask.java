package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.arv;
import com.tencent.mm.protocal.c.arw;
import com.tencent.mm.protocal.c.cms;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

public class JsApiRefreshSession$RefreshSessionTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<RefreshSessionTask> CREATOR = new Parcelable.Creator() {};
  String appId;
  private String errorMsg;
  private int fJy;
  int gfg;
  i gfh;
  c ggu;
  private int ghj;
  private int ghk;
  private int ghl;
  int ghm;
  
  public JsApiRefreshSession$RefreshSessionTask() {}
  
  public JsApiRefreshSession$RefreshSessionTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    ahC();
    b.a locala = new b.a();
    locala.ecH = new arv();
    locala.ecI = new arw();
    locala.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
    locala.ecG = 1196;
    locala.ecJ = 0;
    locala.ecK = 0;
    arv localarv = new arv();
    localarv.euK = this.appId;
    localarv.tmZ = this.fJy;
    locala.ecH = localarv;
    if (this.ghm > 0)
    {
      localarv.tna = new cms();
      localarv.tna.scene = this.ghm;
    }
    y.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[] { this.appId, Integer.valueOf(this.fJy), Integer.valueOf(this.ghm) });
    w.a(locala.Kt(), new w.a()
    {
      public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb, m paramAnonymousm)
      {
        y.d("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
          JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, "cgi fail");
          JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this);
          return 0;
        }
        paramAnonymousb = (arw)paramAnonymousb.ecF.ecN;
        if (paramAnonymousb == null)
        {
          JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 0);
          y.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest failed, response is null!");
          JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this);
          return 0;
        }
        JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.tnb.bLB);
        JsApiRefreshSession.RefreshSessionTask.a(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.tnb.bLC);
        if (JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this) == 0)
        {
          JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.tnj);
          JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.tnb.bLB);
          JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 1);
          JsApiRefreshSession.RefreshSessionTask.d(JsApiRefreshSession.RefreshSessionTask.this);
          return 0;
        }
        JsApiRefreshSession.RefreshSessionTask.c(JsApiRefreshSession.RefreshSessionTask.this, paramAnonymousb.tnb.bLB);
        JsApiRefreshSession.RefreshSessionTask.b(JsApiRefreshSession.RefreshSessionTask.this, 2);
        y.e("MicroMsg.JsApiRefreshSession", "JSRefreshSessionRequest ERROR %s", new Object[] { paramAnonymousString });
        JsApiRefreshSession.RefreshSessionTask.e(JsApiRefreshSession.RefreshSessionTask.this);
        return 0;
      }
    }, true);
  }
  
  public final void Zv()
  {
    HashMap localHashMap = new HashMap();
    switch (this.ghl)
    {
    default: 
      if (!bk.bl(this.errorMsg)) {
        break;
      }
    }
    for (String str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
    {
      localHashMap.put("errCode", "-1");
      this.ggu.C(this.gfg, this.gfh.h(str, localHashMap));
      for (;;)
      {
        ahD();
        return;
        localHashMap.put("expireIn", this.ghj);
        localHashMap.put("errCode", this.ghk);
        this.ggu.C(this.gfg, this.gfh.h("ok", localHashMap));
      }
      if (bk.bl(this.errorMsg)) {}
      for (str = "fail";; str = String.format("fail:%s", new Object[] { this.errorMsg }))
      {
        localHashMap.put("errCode", this.ghk);
        this.ggu.C(this.gfg, this.gfh.h(str, localHashMap));
        break;
      }
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.ghj = paramParcel.readInt();
    this.ghk = paramParcel.readInt();
    this.ghl = paramParcel.readInt();
    this.gfg = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.fJy = paramParcel.readInt();
    this.ghm = paramParcel.readInt();
    this.errorMsg = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.ghj);
    paramParcel.writeInt(this.ghk);
    paramParcel.writeInt(this.ghl);
    paramParcel.writeInt(this.gfg);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.fJy);
    paramParcel.writeInt(this.ghm);
    paramParcel.writeString(this.errorMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiRefreshSession.RefreshSessionTask
 * JD-Core Version:    0.7.0.1
 */