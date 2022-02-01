package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.a.d;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.protocal.protobuf.dvc;
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
  extends h
{
  public static final int CTRL_INDEX = 52;
  public static final String NAME = "login";
  private final j jDS;
  
  public JsApiLogin()
  {
    AppMethodBeat.i(174774);
    this.jDS = new j();
    AppMethodBeat.o(174774);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46062);
    try
    {
      if (!paramJSONObject.has("requestInQueue")) {
        paramJSONObject.put("requestInQueue", false);
      }
      super.a(paramh, paramJSONObject, paramInt);
      AppMethodBeat.o(46062);
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
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(46063);
    LoginTask localLoginTask = new LoginTask();
    localLoginTask.appId = paramh.getAppId();
    localLoginTask.jDi = "login";
    Object localObject = paramh.getRuntime().Ef();
    if (localObject != null) {
      localLoginTask.gXn = ((k)localObject).jdS.iOQ;
    }
    localObject = a.CT(paramh.getAppId());
    if (localObject != null) {
      localLoginTask.jzi = ((AppBrandStatObject)localObject).scene;
    }
    paramJSONObject = paramJSONObject.toString();
    localLoginTask.jDe = this;
    localLoginTask.jDf = paramh;
    localLoginTask.data = paramJSONObject;
    localLoginTask.joH = paramInt;
    localLoginTask.jDg = parame;
    localLoginTask.jDu = new Bundle();
    if ((paramh instanceof com.tencent.mm.plugin.appbrand.q)) {
      localLoginTask.jDw = 1;
    }
    for (;;)
    {
      localLoginTask.aXm();
      AppBrandMainProcessService.a(localLoginTask);
      AppMethodBeat.o(46063);
      return;
      if ((paramh instanceof aa)) {
        localLoginTask.jDw = 2;
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
    public int gXn;
    public int imi;
    public String jAX;
    h jDe;
    com.tencent.mm.plugin.appbrand.jsapi.h jDf;
    e jDg;
    public ArrayList<String> jDh;
    public String jDi;
    public String jDj;
    public int jDk;
    public String jDl;
    public int jDt;
    public Bundle jDu;
    int jDw;
    public int joH;
    public int jzi;
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
    
    public final void aEA()
    {
      AppMethodBeat.i(46054);
      aXn();
      if (!this.jDf.isRunning())
      {
        this.jDg.aYh();
        AppMethodBeat.o(46054);
        return;
      }
      Object localObject;
      if (this.jDj.equals("ok"))
      {
        localObject = new HashMap();
        ((Map)localObject).put("code", this.code);
        localObject = this.jDe.k("ok", (Map)localObject);
        this.jDf.h(this.joH, (String)localObject);
        this.jDg.aYh();
        AppMethodBeat.o(46054);
        return;
      }
      if (this.jDj.equals("fail"))
      {
        if (bt.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.jDe.b(this.jDf, this.joH, (String)localObject);
          this.jDg.aYh();
          AppMethodBeat.o(46054);
          return;
        }
      }
      if (this.jDj.equals("needConfirm"))
      {
        localObject = new LinkedList();
        int i = 0;
        while (i < this.jDt)
        {
          byte[] arrayOfByte = this.jDu.getByteArray(String.valueOf(i));
          cmy localcmy = new cmy();
          try
          {
            localcmy.parseFrom(arrayOfByte);
            ((LinkedList)localObject).add(localcmy);
            i += 1;
          }
          catch (IOException localIOException)
          {
            ad.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[] { localIOException.getMessage() });
            ad.printErrStackTrace("MicroMsg.JsApiLogin", localIOException, "", new Object[0]);
            this.jDe.b(this.jDf, this.joH, "fail:internal error scope error");
            this.jDg.aYh();
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
              c.a local1 = new c.a()
              {
                public final void a(int paramAnonymous2Int, ArrayList<String> paramAnonymous2ArrayList)
                {
                  AppMethodBeat.i(46047);
                  ad.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  switch (paramAnonymous2Int)
                  {
                  default: 
                    ad.d("MicroMsg.JsApiLogin", "press back button!");
                    JsApiLogin.LoginTask.this.jDe.b(JsApiLogin.LoginTask.this.jDf, JsApiLogin.LoginTask.this.joH, "fail auth cancel");
                    JsApiLogin.LoginTask.this.jDg.aYh();
                  }
                  do
                  {
                    AppMethodBeat.o(46047);
                    return;
                    JsApiLogin.LoginTask.this.jDi = "loginConfirm";
                    JsApiLogin.LoginTask.this.jDh = paramAnonymous2ArrayList;
                    JsApiLogin.LoginTask.this.jDk = paramAnonymous2Int;
                    AppBrandMainProcessService.a(JsApiLogin.LoginTask.this);
                  } while (paramAnonymous2Int != 2);
                  JsApiLogin.LoginTask.this.jDe.b(JsApiLogin.LoginTask.this.jDf, JsApiLogin.LoginTask.this.joH, "fail auth deny");
                  JsApiLogin.LoginTask.this.jDg.aYh();
                  AppMethodBeat.o(46047);
                }
              };
              JsApiLogin.LoginTask.this.jDf.aLB().b(new com.tencent.mm.plugin.appbrand.widget.dialog.c(h.c(JsApiLogin.LoginTask.this.jDf), h.y(localIOException), JsApiLogin.LoginTask.this.mAppName, JsApiLogin.LoginTask.this.jDl, local1));
              AppMethodBeat.o(46048);
            }
          });
          AppMethodBeat.o(46054);
          return;
        }
        this.jDe.b(this.jDf, this.joH, "fail:internal error scope empty");
        this.jDg.aYh();
      }
      AppMethodBeat.o(46054);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(46053);
      Object localObject1 = new JsApiLogin.LoginTask.a()
      {
        public final void a(LinkedList<cmy> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(46046);
          ad.i("MicroMsg.JsApiLogin", "onConfirm !");
          JsApiLogin.LoginTask.this.jDt = paramAnonymousLinkedList.size();
          int i = 0;
          while (i < JsApiLogin.LoginTask.this.jDt)
          {
            cmy localcmy = (cmy)paramAnonymousLinkedList.get(i);
            try
            {
              JsApiLogin.LoginTask.this.jDu.putByteArray(String.valueOf(i), localcmy.toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousLinkedList)
            {
              ad.e("MicroMsg.JsApiLogin", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
              ad.printErrStackTrace("MicroMsg.JsApiLogin", paramAnonymousLinkedList, "", new Object[0]);
              JsApiLogin.LoginTask.this.jDj = "fail";
              JsApiLogin.LoginTask.c(JsApiLogin.LoginTask.this);
              AppMethodBeat.o(46046);
              return;
            }
          }
          JsApiLogin.LoginTask.this.jAX = paramAnonymousString3;
          JsApiLogin.LoginTask.this.mAppName = paramAnonymousString1;
          JsApiLogin.LoginTask.this.jDl = paramAnonymousString2;
          JsApiLogin.LoginTask.this.jDj = "needConfirm";
          JsApiLogin.LoginTask.d(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46046);
        }
        
        public final void ac(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46045);
          ad.i("MicroMsg.JsApiLogin", "onFailure !");
          JsApiLogin.LoginTask.this.jDj = "fail";
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
          JsApiLogin.LoginTask.this.jDj = "ok";
          JsApiLogin.LoginTask.a(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46044);
        }
      };
      Object localObject2;
      if (this.jDi.equals("login"))
      {
        ad.i("MicroMsg.JsApiLogin", "start login");
        localObject2 = new LinkedList();
        this.imi = 1;
        this.jAX = "";
        localObject1 = new com.tencent.mm.ab.a.c(this.appId, (LinkedList)localObject2, this.imi, "", this.jAX, this.gXn, this.jzi, new JsApiLogin.LoginTask.4(this, (JsApiLogin.LoginTask.a)localObject1));
        if (((com.tencent.mm.ab.a.c)localObject1).aee().DGy == null) {
          ((com.tencent.mm.ab.a.c)localObject1).aee().DGy = new dvc();
        }
        ((com.tencent.mm.ab.a.c)localObject1).aee().DGy.EJj = this.jDw;
        g.aeS().a((n)localObject1, 0);
        AppMethodBeat.o(46053);
        return;
      }
      if (this.jDi.equals("loginConfirm"))
      {
        ad.i("MicroMsg.JsApiLogin", "start loginConfirm");
        localObject2 = this.appId;
        ArrayList localArrayList = this.jDh;
        int i = this.imi;
        String str = this.jAX;
        int j = this.gXn;
        int k = this.jDk;
        localObject1 = new d((String)localObject2, h.q(localArrayList), i, str, j, k, this.jzi, new JsApiLogin.LoginTask.5(this, (JsApiLogin.LoginTask.a)localObject1, k));
        if (((d)localObject1).aeg().DGy == null) {
          ((d)localObject1).aeg().DGy = new dvc();
        }
        ((d)localObject1).aeg().DGy.EJj = this.jDw;
        g.aeS().a((n)localObject1, 0);
      }
      AppMethodBeat.o(46053);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(46055);
      this.data = paramParcel.readString();
      this.joH = paramParcel.readInt();
      this.jDi = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.code = paramParcel.readString();
      this.jDj = paramParcel.readString();
      this.jAX = paramParcel.readString();
      this.imi = paramParcel.readInt();
      this.mAppName = paramParcel.readString();
      this.jDl = paramParcel.readString();
      this.jDt = paramParcel.readInt();
      this.jDu = paramParcel.readBundle(JsApiLogin.class.getClassLoader());
      this.jDh = paramParcel.createStringArrayList();
      this.gXn = paramParcel.readInt();
      this.jDk = paramParcel.readInt();
      this.jzi = paramParcel.readInt();
      this.jDw = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      AppMethodBeat.o(46055);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46056);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.joH);
      paramParcel.writeString(this.jDi);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.code);
      paramParcel.writeString(this.jDj);
      paramParcel.writeString(this.jAX);
      paramParcel.writeInt(this.imi);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.jDl);
      paramParcel.writeInt(this.jDt);
      paramParcel.writeBundle(this.jDu);
      paramParcel.writeStringList(this.jDh);
      paramParcel.writeInt(this.gXn);
      paramParcel.writeInt(this.jDk);
      paramParcel.writeInt(this.jzi);
      paramParcel.writeInt(this.jDw);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(46056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin
 * JD-Core Version:    0.7.0.1
 */