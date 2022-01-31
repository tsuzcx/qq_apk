package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.aa.a.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.protocal.c.cms;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

class JsApiAuthorize$AuthorizeTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<AuthorizeTask> CREATOR = new JsApiAuthorize.AuthorizeTask.3();
  public String aox;
  public String appId;
  public String data;
  public int errCode;
  public int fJy;
  public String fXS;
  public int gfg;
  private int ghm;
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
  
  public JsApiAuthorize$AuthorizeTask() {}
  
  public JsApiAuthorize$AuthorizeTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  private void a(String paramString, Bundle paramBundle, int paramInt1, int paramInt2, JsApiAuthorize.AuthorizeTask.a parama)
  {
    Object localObject = (ArrayList)paramBundle.getSerializable("key_scope");
    paramBundle = new LinkedList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramBundle.add((String)((Iterator)localObject).next());
    }
    paramString = new com.tencent.mm.aa.a.b(paramString, paramBundle, paramInt1, paramInt2, this.ghm, new JsApiAuthorize.AuthorizeTask.5(this, parama, paramInt2));
    if (paramString.Cx().tna == null) {
      paramString.Cx().tna = new cms();
    }
    paramString.Cx().tna.tZu = this.gjQ;
    g.Dk().a(paramString, 0);
  }
  
  public final void Zu()
  {
    JsApiAuthorize.AuthorizeTask.1 local1 = new JsApiAuthorize.AuthorizeTask.1(this);
    if (this.gjL.equals("authorize")) {
      try
      {
        localJSONArray = new JSONArray(new JSONObject(this.data).optString("scope"));
        localLinkedList = new LinkedList();
        i = 0;
        while (i < localJSONArray.length())
        {
          localLinkedList.add(localJSONArray.optString(i));
          i += 1;
          continue;
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[] { localException.getMessage() });
        this.gjM = "fail";
        ahI();
      }
    }
    a locala;
    while (!this.gjL.equals("authorizeConfirm"))
    {
      JSONArray localJSONArray;
      LinkedList localLinkedList;
      int i;
      locala = new a(this.appId, localLinkedList, this.fJy, this.ghm, new JsApiAuthorize.AuthorizeTask.4(this, localException));
      if (locala.Cv().tna == null) {
        locala.Cv().tna = new cms();
      }
      locala.Cv().tna.tZu = this.gjQ;
      g.Dk().a(locala, 0);
      return;
    }
    a(this.appId, this.gjK, this.fJy, this.gjN, locala);
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
        this.gjH.b(this.gjI, this.gfg, "ok");
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
        y.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { localIOException.getMessage() });
        y.printErrStackTrace("MicroMsg.JsApiAuthorize", localIOException, "", new Object[0]);
        this.gjH.b(this.gjI, this.gfg, "fail:internal error scope error");
        this.gjJ.aib();
        return;
      }
    }
    if (localIOException.size() > 0)
    {
      ai.d(new JsApiAuthorize.AuthorizeTask.2(this, localIOException));
      return;
    }
    this.gjH.b(this.gjI, this.gfg, "fail:internal error scope empty");
    this.gjJ.aib();
  }
  
  public final void e(Parcel paramParcel)
  {
    this.data = paramParcel.readString();
    this.gfg = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.gjM = paramParcel.readString();
    this.gjL = paramParcel.readString();
    this.mAppName = paramParcel.readString();
    this.fXS = paramParcel.readString();
    this.gjO = paramParcel.readInt();
    this.gjP = paramParcel.readBundle(JsApiAuthorize.class.getClassLoader());
    this.gjK = paramParcel.readBundle(JsApiAuthorize.class.getClassLoader());
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
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.gjM);
    paramParcel.writeString(this.gjL);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask
 * JD-Core Version:    0.7.0.1
 */