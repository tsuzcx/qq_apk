package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.widget.b.i;
import com.tencent.mm.protocal.c.art;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.protocal.c.cms;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class JsApiOperateWXData$OperateWXDataTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<OperateWXDataTask> CREATOR = new JsApiOperateWXData.OperateWXDataTask.3();
  public String appId;
  public int fJy;
  public String fXS;
  public int gfg;
  int ghm;
  c gjH;
  f gjI;
  b gjJ;
  public String gjL;
  public String gjM;
  public int gjN;
  public int gjO;
  public Bundle gjP;
  int gjQ;
  public String gjX;
  public String gjY;
  public String gjZ;
  public String mAppName;
  
  public JsApiOperateWXData$OperateWXDataTask() {}
  
  public JsApiOperateWXData$OperateWXDataTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, JsApiOperateWXData.OperateWXDataTask.a parama)
  {
    paramString1 = new com.tencent.mm.plugin.appbrand.n.c(paramString1, paramString2, paramString3, paramInt1, paramInt2, this.ghm, new JsApiOperateWXData.OperateWXDataTask.4(this, parama, paramInt2));
    paramInt1 = this.gjQ;
    paramString2 = (art)paramString1.dmK.ecE.ecN;
    if (paramString2.tna == null) {
      paramString2.tna = new cms();
    }
    paramString2.tna.tZu = paramInt1;
    g.Dk().a(paramString1, 0);
  }
  
  public final void Zu()
  {
    JsApiOperateWXData.OperateWXDataTask.1 local1 = new JsApiOperateWXData.OperateWXDataTask.1(this);
    if (this.gjL.equals("operateWXData")) {
      a(this.appId, this.gjX, "", this.fJy, this.gjN, local1);
    }
    while (!this.gjL.equals("operateWXDataConfirm")) {
      return;
    }
    a(this.appId, this.gjX, this.gjZ, this.fJy, this.gjN, local1);
  }
  
  public final void Zv()
  {
    ahD();
    if (!this.gjI.isRunning()) {
      this.gjJ.aib();
    }
    do
    {
      return;
      if (this.gjM.equals("ok"))
      {
        localObject = new HashMap();
        ((Map)localObject).put("data", this.gjY);
        this.gjI.C(this.gfg, this.gjH.h("ok", (Map)localObject));
        this.gjJ.aib();
        return;
      }
      if (this.gjM.contains("fail"))
      {
        this.gjH.b(this.gjI, this.gfg, this.gjM);
        this.gjJ.aib();
        return;
      }
    } while (!this.gjM.equals("needConfirm"));
    Object localObject = new LinkedList();
    int i = 0;
    while (i < this.gjO)
    {
      byte[] arrayOfByte = this.gjP.getByteArray(String.valueOf(i));
      bna localbna = new bna();
      try
      {
        localbna.aH(arrayOfByte);
        ((LinkedList)localObject).add(localbna);
        i += 1;
      }
      catch (IOException localIOException)
      {
        y.e("MicroMsg.JsApiOperateWXData", "IOException %s", new Object[] { localIOException.getMessage() });
        y.printErrStackTrace("MicroMsg.JsApiOperateWXData", localIOException, "", new Object[0]);
        this.gjH.b(this.gjI, this.gfg, "fail");
        this.gjJ.aib();
        return;
      }
    }
    if (localIOException.size() > 0)
    {
      ai.d(new Runnable()
      {
        public final void run()
        {
          JsApiOperateWXData.OperateWXDataTask.2.1 local1 = new JsApiOperateWXData.OperateWXDataTask.2.1(this);
          i locali = JsApiOperateWXData.OperateWXDataTask.this.gjI.Zm();
          c localc = JsApiOperateWXData.OperateWXDataTask.this.gjH;
          locali.b(new com.tencent.mm.plugin.appbrand.widget.b.c(c.a(JsApiOperateWXData.OperateWXDataTask.this.gjI), localIOException, JsApiOperateWXData.OperateWXDataTask.this.mAppName, JsApiOperateWXData.OperateWXDataTask.this.fXS, local1));
        }
      });
      return;
    }
    this.gjH.b(this.gjI, this.gfg, "fail");
    this.gjJ.aib();
  }
  
  public final void e(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.gjM = paramParcel.readString();
    this.mAppName = paramParcel.readString();
    this.fXS = paramParcel.readString();
    this.gjX = paramParcel.readString();
    this.gjY = paramParcel.readString();
    this.gfg = paramParcel.readInt();
    this.gjL = paramParcel.readString();
    this.gjZ = paramParcel.readString();
    this.gjO = paramParcel.readInt();
    this.gjP = paramParcel.readBundle(JsApiOperateWXData.class.getClassLoader());
    this.fJy = paramParcel.readInt();
    this.gjN = paramParcel.readInt();
    this.ghm = paramParcel.readInt();
    this.gjQ = paramParcel.readInt();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.gjM);
    paramParcel.writeString(this.mAppName);
    paramParcel.writeString(this.fXS);
    paramParcel.writeString(this.gjX);
    paramParcel.writeString(this.gjY);
    paramParcel.writeInt(this.gfg);
    paramParcel.writeString(this.gjL);
    paramParcel.writeString(this.gjZ);
    paramParcel.writeInt(this.gjO);
    paramParcel.writeBundle(this.gjP);
    paramParcel.writeInt(this.fJy);
    paramParcel.writeInt(this.gjN);
    paramParcel.writeInt(this.ghm);
    paramParcel.writeInt(this.gjQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask
 * JD-Core Version:    0.7.0.1
 */