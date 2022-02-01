package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.a.d.a;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiLogin
  extends i
{
  public static final int CTRL_INDEX = 52;
  public static final String NAME = "login";
  private final l kyX;
  
  public JsApiLogin()
  {
    AppMethodBeat.i(174774);
    this.kyX = new l();
    AppMethodBeat.o(174774);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(188293);
    try
    {
      if (!paramJSONObject.has("requestInQueue")) {
        paramJSONObject.put("requestInQueue", false);
      }
      super.a(paramd, paramJSONObject, paramInt);
      AppMethodBeat.o(188293);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.e("MicroMsg.JsApiLogin", "invoke put KEY_IN_QUEUE e=%s", new Object[] { localJSONException.getMessage() });
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(188294);
    LoginTask localLoginTask = new LoginTask();
    localLoginTask.appId = paramd.getAppId();
    localLoginTask.kyl = "login";
    Object localObject = paramd.getRuntime().Fh();
    if (localObject != null) {
      localLoginTask.hQh = ((k)localObject).jYh.jIU;
    }
    localObject = a.Kl(paramd.getAppId());
    if (localObject != null) {
      localLoginTask.kub = ((AppBrandStatObject)localObject).scene;
    }
    paramJSONObject = paramJSONObject.toString();
    localLoginTask.kyh = this;
    localLoginTask.kyY = paramd;
    localLoginTask.data = paramJSONObject;
    localLoginTask.kje = paramInt;
    localLoginTask.kyj = parame;
    localLoginTask.kyx = new Bundle();
    if ((paramd instanceof com.tencent.mm.plugin.appbrand.q)) {
      localLoginTask.kyA = 1;
    }
    for (;;)
    {
      localLoginTask.bhN();
      AppBrandMainProcessService.a(localLoginTask);
      AppMethodBeat.o(188294);
      return;
      if ((paramd instanceof aa)) {
        localLoginTask.kyA = 2;
      }
    }
  }
  
  static class LoginTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<LoginTask> CREATOR;
    public String appId;
    public String code;
    public String data;
    public int errCode;
    public String errMsg;
    public int hQh;
    public int jfy;
    public int kje;
    public int kub;
    public String kvP;
    int kyA;
    h kyY;
    i kyh;
    e kyj;
    public ArrayList<String> kyk;
    public String kyl;
    public String kym;
    public int kyn;
    public String kyo;
    public int kyw;
    public Bundle kyx;
    public String mAppName;
    
    static
    {
      AppMethodBeat.i(46061);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46061);
    }
    
    public LoginTask() {}
    
    public LoginTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46052);
      e(paramParcel);
      AppMethodBeat.o(46052);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(46053);
      Object localObject1 = new a()
      {
        public final void a(LinkedList<cxm> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(46046);
          ad.i("MicroMsg.JsApiLogin", "onConfirm !");
          JsApiLogin.LoginTask.this.kyw = paramAnonymousLinkedList.size();
          int i = 0;
          while (i < JsApiLogin.LoginTask.this.kyw)
          {
            cxm localcxm = (cxm)paramAnonymousLinkedList.get(i);
            try
            {
              JsApiLogin.LoginTask.this.kyx.putByteArray(String.valueOf(i), localcxm.toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousLinkedList)
            {
              ad.e("MicroMsg.JsApiLogin", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
              ad.printErrStackTrace("MicroMsg.JsApiLogin", paramAnonymousLinkedList, "", new Object[0]);
              JsApiLogin.LoginTask.this.kym = "fail";
              JsApiLogin.LoginTask.c(JsApiLogin.LoginTask.this);
              AppMethodBeat.o(46046);
              return;
            }
          }
          JsApiLogin.LoginTask.this.kvP = paramAnonymousString3;
          JsApiLogin.LoginTask.this.mAppName = paramAnonymousString1;
          JsApiLogin.LoginTask.this.kyo = paramAnonymousString2;
          JsApiLogin.LoginTask.this.kym = "needConfirm";
          JsApiLogin.LoginTask.d(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46046);
        }
        
        public final void af(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46045);
          ad.i("MicroMsg.JsApiLogin", "onFailure !");
          JsApiLogin.LoginTask.this.kym = "fail";
          JsApiLogin.LoginTask.this.errCode = paramAnonymousInt;
          JsApiLogin.LoginTask.this.errMsg = paramAnonymousString;
          JsApiLogin.LoginTask.b(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46045);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(46044);
          ad.i("MicroMsg.JsApiLogin", "onSuccess !");
          JsApiLogin.LoginTask.this.code = paramAnonymousString;
          JsApiLogin.LoginTask.this.kym = "ok";
          JsApiLogin.LoginTask.a(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46044);
        }
      };
      Object localObject2;
      if (this.kyl.equals("login"))
      {
        ad.i("MicroMsg.JsApiLogin", "start login");
        localObject2 = new LinkedList();
        this.jfy = 1;
        this.kvP = "";
        localObject1 = new com.tencent.mm.ab.a.c(this.appId, (LinkedList)localObject2, this.jfy, "", this.kvP, this.hQh, this.kub, new com.tencent.mm.ab.a.c.a() {});
        if (((com.tencent.mm.ab.a.c)localObject1).aig().GLr == null) {
          ((com.tencent.mm.ab.a.c)localObject1).aig().GLr = new egx();
        }
        ((com.tencent.mm.ab.a.c)localObject1).aig().GLr.HRI = this.kyA;
        g.aiU().a((n)localObject1, 0);
        AppMethodBeat.o(46053);
        return;
      }
      if (this.kyl.equals("loginConfirm"))
      {
        ad.i("MicroMsg.JsApiLogin", "start loginConfirm");
        localObject2 = this.appId;
        ArrayList localArrayList = this.kyk;
        int i = this.jfy;
        String str = this.kvP;
        int j = this.hQh;
        final int k = this.kyn;
        localObject1 = new com.tencent.mm.ab.a.d((String)localObject2, i.v(localArrayList), i, str, j, k, this.kub, new d.a() {});
        if (((com.tencent.mm.ab.a.d)localObject1).aii().GLr == null) {
          ((com.tencent.mm.ab.a.d)localObject1).aii().GLr = new egx();
        }
        ((com.tencent.mm.ab.a.d)localObject1).aii().GLr.HRI = this.kyA;
        g.aiU().a((n)localObject1, 0);
      }
      AppMethodBeat.o(46053);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(46054);
      bhO();
      if (!this.kyY.isRunning())
      {
        this.kyj.biH();
        AppMethodBeat.o(46054);
        return;
      }
      Object localObject;
      if (this.kym.equals("ok"))
      {
        localObject = new HashMap();
        ((Map)localObject).put("code", this.code);
        localObject = this.kyh.m("ok", (Map)localObject);
        this.kyY.h(this.kje, (String)localObject);
        this.kyj.biH();
        AppMethodBeat.o(46054);
        return;
      }
      if (this.kym.equals("fail"))
      {
        if (bt.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.kyh.b(this.kyY, this.kje, (String)localObject);
          this.kyj.biH();
          AppMethodBeat.o(46054);
          return;
        }
      }
      if (this.kym.equals("needConfirm"))
      {
        localObject = new LinkedList();
        int i = 0;
        while (i < this.kyw)
        {
          byte[] arrayOfByte = this.kyx.getByteArray(String.valueOf(i));
          cxm localcxm = new cxm();
          try
          {
            localcxm.parseFrom(arrayOfByte);
            ((LinkedList)localObject).add(localcxm);
            i += 1;
          }
          catch (IOException localIOException)
          {
            ad.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[] { localIOException.getMessage() });
            ad.printErrStackTrace("MicroMsg.JsApiLogin", localIOException, "", new Object[0]);
            this.kyh.b(this.kyY, this.kje, "fail:internal error scope error");
            this.kyj.biH();
            AppMethodBeat.o(46054);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46048);
              com.tencent.mm.plugin.appbrand.widget.dialog.c.a local1 = new com.tencent.mm.plugin.appbrand.widget.dialog.c.a()
              {
                public final void a(int paramAnonymous2Int, ArrayList<String> paramAnonymous2ArrayList)
                {
                  AppMethodBeat.i(46047);
                  ad.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  switch (paramAnonymous2Int)
                  {
                  default: 
                    ad.d("MicroMsg.JsApiLogin", "press back button!");
                    JsApiLogin.LoginTask.this.kyh.b(JsApiLogin.LoginTask.this.kyY, JsApiLogin.LoginTask.this.kje, "fail auth cancel");
                    JsApiLogin.LoginTask.this.kyj.biH();
                  }
                  do
                  {
                    AppMethodBeat.o(46047);
                    return;
                    JsApiLogin.LoginTask.this.kyl = "loginConfirm";
                    JsApiLogin.LoginTask.this.kyk = paramAnonymous2ArrayList;
                    JsApiLogin.LoginTask.this.kyn = paramAnonymous2Int;
                    AppBrandMainProcessService.a(JsApiLogin.LoginTask.this);
                  } while (paramAnonymous2Int != 2);
                  JsApiLogin.LoginTask.this.kyh.b(JsApiLogin.LoginTask.this.kyY, JsApiLogin.LoginTask.this.kje, "fail auth deny");
                  JsApiLogin.LoginTask.this.kyj.biH();
                  AppMethodBeat.o(46047);
                }
              };
              JsApiLogin.LoginTask.this.kyY.aVE().b(new com.tencent.mm.plugin.appbrand.widget.dialog.c(i.b(JsApiLogin.LoginTask.this.kyY), i.y(localIOException), JsApiLogin.LoginTask.this.mAppName, JsApiLogin.LoginTask.this.kyo, local1));
              AppMethodBeat.o(46048);
            }
          });
          AppMethodBeat.o(46054);
          return;
        }
        this.kyh.b(this.kyY, this.kje, "fail:internal error scope empty");
        this.kyj.biH();
      }
      AppMethodBeat.o(46054);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(46055);
      this.data = paramParcel.readString();
      this.kje = paramParcel.readInt();
      this.kyl = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.code = paramParcel.readString();
      this.kym = paramParcel.readString();
      this.kvP = paramParcel.readString();
      this.jfy = paramParcel.readInt();
      this.mAppName = paramParcel.readString();
      this.kyo = paramParcel.readString();
      this.kyw = paramParcel.readInt();
      this.kyx = paramParcel.readBundle(JsApiLogin.class.getClassLoader());
      this.kyk = paramParcel.createStringArrayList();
      this.hQh = paramParcel.readInt();
      this.kyn = paramParcel.readInt();
      this.kub = paramParcel.readInt();
      this.kyA = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      AppMethodBeat.o(46055);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46056);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.kje);
      paramParcel.writeString(this.kyl);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.code);
      paramParcel.writeString(this.kym);
      paramParcel.writeString(this.kvP);
      paramParcel.writeInt(this.jfy);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.kyo);
      paramParcel.writeInt(this.kyw);
      paramParcel.writeBundle(this.kyx);
      paramParcel.writeStringList(this.kyk);
      paramParcel.writeInt(this.hQh);
      paramParcel.writeInt(this.kyn);
      paramParcel.writeInt(this.kub);
      paramParcel.writeInt(this.kyA);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(46056);
    }
    
    static abstract interface a
    {
      public abstract void a(LinkedList<cxm> paramLinkedList, String paramString1, String paramString2, String paramString3);
      
      public abstract void af(int paramInt, String paramString);
      
      public abstract void onSuccess(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin
 * JD-Core Version:    0.7.0.1
 */