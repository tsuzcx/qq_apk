package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.protocal.protobuf.axu;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.a.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class JsApiLogin$LoginTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<LoginTask> CREATOR;
  public String appId;
  public String code;
  public String data;
  public int errCode;
  public String errMsg;
  public int gyZ;
  public String hBt;
  public int hDA;
  public String hDB;
  public int hDH;
  public Bundle hDI;
  int hDJ;
  f hDu;
  h hDv;
  d hDw;
  public ArrayList<String> hDx;
  public String hDy;
  public String hDz;
  public int hcr;
  public int hry;
  public int hzB;
  public String mAppName;
  
  static
  {
    AppMethodBeat.i(130871);
    CREATOR = new JsApiLogin.LoginTask.3();
    AppMethodBeat.o(130871);
  }
  
  public JsApiLogin$LoginTask() {}
  
  public JsApiLogin$LoginTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130862);
    f(paramParcel);
    AppMethodBeat.o(130862);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130863);
    Object localObject1 = new JsApiLogin.LoginTask.1(this);
    Object localObject2;
    if (this.hDy.equals("login"))
    {
      ab.i("MicroMsg.JsApiLogin", "start login");
      localObject2 = new LinkedList();
      this.gyZ = 1;
      this.hBt = "";
      localObject1 = new c(this.appId, (LinkedList)localObject2, this.gyZ, "", this.hBt, this.hcr, this.hzB, new JsApiLogin.LoginTask.4(this, (JsApiLogin.LoginTask.a)localObject1));
      if (((c)localObject1).Qs().xmR == null) {
        ((c)localObject1).Qs().xmR = new dam();
      }
      ((c)localObject1).Qs().xmR.ygT = this.hDJ;
      g.Rc().a((m)localObject1, 0);
      AppMethodBeat.o(130863);
      return;
    }
    if (this.hDy.equals("loginConfirm"))
    {
      ab.i("MicroMsg.JsApiLogin", "start loginConfirm");
      localObject2 = this.appId;
      ArrayList localArrayList = this.hDx;
      int i = this.gyZ;
      String str = this.hBt;
      int j = this.hcr;
      int k = this.hDA;
      localObject1 = new com.tencent.mm.z.a.d((String)localObject2, f.j(localArrayList), i, str, j, k, this.hzB, new JsApiLogin.LoginTask.5(this, (JsApiLogin.LoginTask.a)localObject1, k));
      if (((com.tencent.mm.z.a.d)localObject1).Qu().xmR == null) {
        ((com.tencent.mm.z.a.d)localObject1).Qu().xmR = new dam();
      }
      ((com.tencent.mm.z.a.d)localObject1).Qu().xmR.ygT = this.hDJ;
      g.Rc().a((m)localObject1, 0);
    }
    AppMethodBeat.o(130863);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130864);
    aBk();
    if (!this.hDv.isRunning())
    {
      this.hDw.aBV();
      AppMethodBeat.o(130864);
      return;
    }
    Object localObject;
    if (this.hDz.equals("ok"))
    {
      localObject = new HashMap();
      ((Map)localObject).put("code", this.code);
      localObject = this.hDu.j("ok", (Map)localObject);
      this.hDv.h(this.hry, (String)localObject);
      this.hDw.aBV();
      AppMethodBeat.o(130864);
      return;
    }
    if (this.hDz.equals("fail"))
    {
      if (bo.isNullOrNil(this.errMsg)) {}
      for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
      {
        this.hDu.b(this.hDv, this.hry, (String)localObject);
        this.hDw.aBV();
        AppMethodBeat.o(130864);
        return;
      }
    }
    if (this.hDz.equals("needConfirm"))
    {
      localObject = new LinkedList();
      int i = 0;
      while (i < this.hDH)
      {
        byte[] arrayOfByte = this.hDI.getByteArray(String.valueOf(i));
        bwv localbwv = new bwv();
        try
        {
          localbwv.parseFrom(arrayOfByte);
          ((LinkedList)localObject).add(localbwv);
          i += 1;
        }
        catch (IOException localIOException)
        {
          ab.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[] { localIOException.getMessage() });
          ab.printErrStackTrace("MicroMsg.JsApiLogin", localIOException, "", new Object[0]);
          this.hDu.b(this.hDv, this.hry, "fail:internal error scope error");
          this.hDw.aBV();
          AppMethodBeat.o(130864);
          return;
        }
      }
      if (localIOException.size() > 0)
      {
        al.d(new JsApiLogin.LoginTask.2(this, localIOException));
        AppMethodBeat.o(130864);
        return;
      }
      this.hDu.b(this.hDv, this.hry, "fail:internal error scope empty");
      this.hDw.aBV();
    }
    AppMethodBeat.o(130864);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130865);
    this.data = paramParcel.readString();
    this.hry = paramParcel.readInt();
    this.hDy = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.code = paramParcel.readString();
    this.hDz = paramParcel.readString();
    this.hBt = paramParcel.readString();
    this.gyZ = paramParcel.readInt();
    this.mAppName = paramParcel.readString();
    this.hDB = paramParcel.readString();
    this.hDH = paramParcel.readInt();
    this.hDI = paramParcel.readBundle(JsApiLogin.class.getClassLoader());
    this.hDx = paramParcel.createStringArrayList();
    this.hcr = paramParcel.readInt();
    this.hDA = paramParcel.readInt();
    this.hzB = paramParcel.readInt();
    this.hDJ = paramParcel.readInt();
    this.errCode = paramParcel.readInt();
    this.errMsg = paramParcel.readString();
    AppMethodBeat.o(130865);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130866);
    paramParcel.writeString(this.data);
    paramParcel.writeInt(this.hry);
    paramParcel.writeString(this.hDy);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.code);
    paramParcel.writeString(this.hDz);
    paramParcel.writeString(this.hBt);
    paramParcel.writeInt(this.gyZ);
    paramParcel.writeString(this.mAppName);
    paramParcel.writeString(this.hDB);
    paramParcel.writeInt(this.hDH);
    paramParcel.writeBundle(this.hDI);
    paramParcel.writeStringList(this.hDx);
    paramParcel.writeInt(this.hcr);
    paramParcel.writeInt(this.hDA);
    paramParcel.writeInt(this.hzB);
    paramParcel.writeInt(this.hDJ);
    paramParcel.writeInt(this.errCode);
    paramParcel.writeString(this.errMsg);
    AppMethodBeat.o(130866);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask
 * JD-Core Version:    0.7.0.1
 */