package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.axq;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.protocal.protobuf.dam;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.z.a.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize
  extends f
{
  private static final int CTRL_INDEX = 54;
  private static final String NAME = "authorize";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt, d paramd)
  {
    AppMethodBeat.i(130853);
    ab.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
    AuthorizeTask localAuthorizeTask = new AuthorizeTask();
    localAuthorizeTask.appId = paramh.getAppId();
    localAuthorizeTask.hDy = "authorize";
    Object localObject = paramh.getRuntime().wY();
    if (localObject != null) {
      localAuthorizeTask.hcr = ((com.tencent.mm.plugin.appbrand.config.h)localObject).hiX.gXe;
    }
    localObject = com.tencent.mm.plugin.appbrand.a.xN(paramh.getAppId());
    if (localObject != null) {
      AuthorizeTask.a(localAuthorizeTask, ((AppBrandStatObject)localObject).scene);
    }
    paramJSONObject = paramJSONObject.toString();
    localAuthorizeTask.hDu = this;
    localAuthorizeTask.hDv = paramh;
    localAuthorizeTask.data = paramJSONObject;
    localAuthorizeTask.hry = paramInt;
    localAuthorizeTask.hDw = paramd;
    localAuthorizeTask.hDI = new Bundle();
    if ((paramh instanceof r)) {
      localAuthorizeTask.hDJ = 1;
    }
    for (;;)
    {
      localAuthorizeTask.aBj();
      AppBrandMainProcessService.a(localAuthorizeTask);
      AppMethodBeat.o(130853);
      return;
      if ((paramh instanceof v)) {
        localAuthorizeTask.hDJ = 2;
      }
    }
  }
  
  static class AuthorizeTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AuthorizeTask> CREATOR;
    public String appId;
    public String data;
    public int errCode;
    public String errMsg;
    public int hDA;
    public String hDB;
    public String hDC;
    public String hDD;
    public String hDE;
    public String hDF;
    public String hDG;
    public int hDH;
    public Bundle hDI;
    int hDJ;
    f hDu;
    com.tencent.mm.plugin.appbrand.jsapi.h hDv;
    d hDw;
    public ArrayList<String> hDx;
    public String hDy;
    public String hDz;
    public int hcr;
    public int hry;
    private int hzB;
    public String mAppName;
    
    static
    {
      AppMethodBeat.i(130852);
      CREATOR = new JsApiAuthorize.AuthorizeTask.3();
      AppMethodBeat.o(130852);
    }
    
    public AuthorizeTask() {}
    
    public AuthorizeTask(Parcel paramParcel)
    {
      AppMethodBeat.i(130838);
      f(paramParcel);
      AppMethodBeat.o(130838);
    }
    
    private void BI(String paramString)
    {
      AppMethodBeat.i(130841);
      if (TextUtils.isEmpty(paramString)) {
        this.hDu.b(this.hDv, this.hry, "fail auth cancel");
      }
      for (;;)
      {
        this.hDw.aBV();
        AppMethodBeat.o(130841);
        return;
        this.hDu.b(this.hDv, this.hry, paramString);
      }
    }
    
    public final void ata()
    {
      AppMethodBeat.i(130839);
      JsApiAuthorize.AuthorizeTask.1 local1 = new JsApiAuthorize.AuthorizeTask.1(this);
      Object localObject2;
      Object localObject3;
      int i;
      Object localObject1;
      if (this.hDy.equals("authorize"))
      {
        try
        {
          localObject2 = new JSONArray(new JSONObject(this.data).optString("scope"));
          localObject3 = new LinkedList();
          i = 0;
          while (i < ((JSONArray)localObject2).length())
          {
            ((LinkedList)localObject3).add(((JSONArray)localObject2).optString(i));
            i += 1;
          }
          localObject1 = new com.tencent.mm.z.a.a(this.appId, (LinkedList)localObject3, this.hcr, this.hzB, new JsApiAuthorize.AuthorizeTask.4(this, localException));
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[] { localException.getMessage() });
          this.hDz = "fail";
          aBp();
          AppMethodBeat.o(130839);
          return;
        }
        if (((com.tencent.mm.z.a.a)localObject1).Qo().xmR == null) {
          ((com.tencent.mm.z.a.a)localObject1).Qo().xmR = new dam();
        }
        ((com.tencent.mm.z.a.a)localObject1).Qo().xmR.ygT = this.hDJ;
        g.Rc().a((m)localObject1, 0);
        AppMethodBeat.o(130839);
        return;
      }
      if (this.hDy.equals("authorizeConfirm"))
      {
        localObject2 = this.appId;
        localObject3 = this.hDx;
        i = this.hcr;
        int j = this.hDA;
        localObject1 = new b((String)localObject2, f.j((ArrayList)localObject3), i, j, this.hzB, new JsApiAuthorize.AuthorizeTask.5(this, (JsApiAuthorize.AuthorizeTask.a)localObject1, j));
        if (((b)localObject1).Qq().xmR == null) {
          ((b)localObject1).Qq().xmR = new dam();
        }
        ((b)localObject1).Qq().xmR.ygT = this.hDJ;
        g.Rc().a((m)localObject1, 0);
      }
      AppMethodBeat.o(130839);
    }
    
    public final void atb()
    {
      AppMethodBeat.i(130840);
      aBk();
      if (!this.hDv.isRunning())
      {
        this.hDw.aBV();
        AppMethodBeat.o(130840);
        return;
      }
      if (this.hDz.equals("ok"))
      {
        this.hDu.b(this.hDv, this.hry, "ok");
        this.hDw.aBV();
        AppMethodBeat.o(130840);
        return;
      }
      Object localObject;
      if (this.hDz.equals("fail"))
      {
        if (bo.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.hDu.b(this.hDv, this.hry, (String)localObject);
          this.hDw.aBV();
          AppMethodBeat.o(130840);
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
            ab.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { localIOException.getMessage() });
            ab.printErrStackTrace("MicroMsg.JsApiAuthorize", localIOException, "", new Object[0]);
            this.hDu.b(this.hDv, this.hry, "fail:internal error scope error");
            this.hDw.aBV();
            AppMethodBeat.o(130840);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          al.d(new JsApiAuthorize.AuthorizeTask.2(this, localIOException));
          AppMethodBeat.o(130840);
          return;
        }
        this.hDu.b(this.hDv, this.hry, "fail:internal error scope empty");
        this.hDw.aBV();
      }
      AppMethodBeat.o(130840);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(130842);
      this.data = paramParcel.readString();
      this.hry = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.hDz = paramParcel.readString();
      this.hDy = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.hDB = paramParcel.readString();
      this.hDH = paramParcel.readInt();
      this.hDI = paramParcel.readBundle(JsApiAuthorize.class.getClassLoader());
      this.hDx = paramParcel.createStringArrayList();
      this.hcr = paramParcel.readInt();
      this.hDA = paramParcel.readInt();
      this.hzB = paramParcel.readInt();
      this.hDJ = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      this.hDE = paramParcel.readString();
      this.hDD = paramParcel.readString();
      this.hDC = paramParcel.readString();
      this.hDF = paramParcel.readString();
      this.hDG = paramParcel.readString();
      AppMethodBeat.o(130842);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(130843);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.hry);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.hDz);
      paramParcel.writeString(this.hDy);
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
      paramParcel.writeString(this.hDE);
      paramParcel.writeString(this.hDD);
      paramParcel.writeString(this.hDC);
      paramParcel.writeString(this.hDF);
      paramParcel.writeString(this.hDG);
      AppMethodBeat.o(130843);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize
 * JD-Core Version:    0.7.0.1
 */