package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.aa.a.d;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.arr;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.protocal.c.cms;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class JsApiLogin$LoginTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<LoginTask> CREATOR = new JsApiLogin.LoginTask.3();
  public String aox;
  public String appId;
  public String code;
  public String data;
  public int errCode;
  public int fJy;
  public String fXS;
  public int fhr;
  public int gfg;
  public int ghm;
  public String gif;
  c gjH;
  f gjI;
  b gjJ;
  public Bundle gjK;
  public String gjL;
  public String gjM;
  public int gjN;
  public int gjO;
  public Bundle gjP;
  int gjQ;
  public String mAppName;
  
  public JsApiLogin$LoginTask() {}
  
  public JsApiLogin$LoginTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  private void a(String paramString1, Bundle paramBundle, int paramInt1, String paramString2, int paramInt2, int paramInt3, a parama)
  {
    Object localObject = (ArrayList)paramBundle.getSerializable("key_scope");
    paramBundle = new LinkedList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramBundle.add((String)((Iterator)localObject).next());
    }
    paramString1 = new d(paramString1, paramBundle, paramInt1, paramString2, paramInt2, paramInt3, this.ghm, new JsApiLogin.LoginTask.5(this, parama, paramInt3));
    if (paramString1.CB().tna == null) {
      paramString1.CB().tna = new cms();
    }
    paramString1.CB().tna.tZu = this.gjQ;
    g.Dk().a(paramString1, 0);
  }
  
  public final void Zu()
  {
    Object localObject = new JsApiLogin.LoginTask.1(this);
    if (this.gjL.equals("login"))
    {
      y.i("MicroMsg.JsApiLogin", "start login");
      localLinkedList = new LinkedList();
      this.fhr = 1;
      this.gif = "";
      localObject = new com.tencent.mm.aa.a.c(this.appId, localLinkedList, this.fhr, "", this.gif, this.fJy, this.ghm, new JsApiLogin.LoginTask.4(this, (a)localObject));
      if (((com.tencent.mm.aa.a.c)localObject).Cz().tna == null) {
        ((com.tencent.mm.aa.a.c)localObject).Cz().tna = new cms();
      }
      ((com.tencent.mm.aa.a.c)localObject).Cz().tna.tZu = this.gjQ;
      g.Dk().a((m)localObject, 0);
    }
    while (!this.gjL.equals("loginConfirm"))
    {
      LinkedList localLinkedList;
      return;
    }
    y.i("MicroMsg.JsApiLogin", "start loginConfirm");
    a(this.appId, this.gjK, this.fhr, this.gif, this.fJy, this.gjN, (a)localObject);
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
        ((Map)localObject).put("code", this.code);
        localObject = this.gjH.h("ok", (Map)localObject);
        this.gjI.C(this.gfg, (String)localObject);
        this.gjJ.aib();
        return;
      }
      if (this.gjM.equals("fail"))
      {
        if (bk.bl(this.aox)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.aox }))
        {
          this.gjH.b(this.gjI, this.gfg, (String)localObject);
          this.gjJ.aib();
          return;
        }
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
        y.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[] { localIOException.getMessage() });
        y.printErrStackTrace("MicroMsg.JsApiLogin", localIOException, "", new Object[0]);
        this.gjH.b(this.gjI, this.gfg, "fail:internal error scope error");
        this.gjJ.aib();
        return;
      }
    }
    if (localIOException.size() > 0)
    {
      ai.d(new JsApiLogin.LoginTask.2(this, localIOException));
      return;
    }
    this.gjH.b(this.gjI, this.gfg, "fail:internal error scope empty");
    this.gjJ.aib();
  }
  
  public final void e(Parcel paramParcel)
  {
    this.data = paramParcel.readString();
    this.gfg = paramParcel.readInt();
    this.gjL = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.code = paramParcel.readString();
    this.gjM = paramParcel.readString();
    this.gif = paramParcel.readString();
    this.fhr = paramParcel.readInt();
    this.mAppName = paramParcel.readString();
    this.fXS = paramParcel.readString();
    this.gjO = paramParcel.readInt();
    this.gjP = paramParcel.readBundle(JsApiLogin.class.getClassLoader());
    this.gjK = paramParcel.readBundle(JsApiLogin.class.getClassLoader());
    this.fJy = paramParcel.readInt();
    this.gjN = paramParcel.readInt();
    this.ghm = paramParcel.readInt();
    this.gjQ = paramParcel.readInt();
    this.errCode = paramParcel.readInt();
    this.aox = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.gfg);
    paramParcel.writeString(this.gjL);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.code);
    paramParcel.writeString(this.gjM);
    paramParcel.writeString(this.gif);
    paramParcel.writeInt(this.fhr);
    paramParcel.writeString(this.mAppName);
    paramParcel.writeString(this.fXS);
    paramParcel.writeInt(this.gjO);
    paramParcel.writeBundle(this.gjP);
    paramParcel.writeBundle(this.gjK);
    paramParcel.writeInt(this.fJy);
    paramParcel.writeInt(this.gjN);
    paramParcel.writeInt(this.ghm);
    paramParcel.writeInt(this.gjQ);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.aox);
  }
  
  static abstract interface a
  {
    public abstract void G(int paramInt, String paramString);
    
    public abstract void a(LinkedList<bna> paramLinkedList, String paramString1, String paramString2, String paramString3);
    
    public abstract void onSuccess(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask
 * JD-Core Version:    0.7.0.1
 */