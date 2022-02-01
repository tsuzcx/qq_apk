package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.a;
import com.tencent.mm.protocal.protobuf.cnk;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.a;
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
  private final n oCn;
  
  public JsApiLogin()
  {
    AppMethodBeat.i(174774);
    this.oCn = new n();
    AppMethodBeat.o(174774);
  }
  
  public final void a(g paramg, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(284058);
    try
    {
      if (!paramJSONObject.has("requestInQueue")) {
        paramJSONObject.put("requestInQueue", false);
      }
      super.a(paramg, paramJSONObject, paramInt);
      AppMethodBeat.o(284058);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("MicroMsg.JsApiLogin", "invoke put KEY_IN_QUEUE e=%s", new Object[] { localJSONException.getMessage() });
      }
    }
  }
  
  public final void a(g paramg, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(284059);
    LoginTask localLoginTask = new LoginTask();
    localLoginTask.appId = paramg.getAppId();
    localLoginTask.oBs = "login";
    Object localObject = paramg.getRuntime().Sp();
    if (localObject != null) {
      localLoginTask.cBU = ((com.tencent.mm.plugin.appbrand.config.l)localObject).nYR.nHY;
    }
    localObject = com.tencent.mm.plugin.appbrand.d.abC(paramg.getAppId());
    if (localObject != null) {
      localLoginTask.owU = ((AppBrandStatObject)localObject).scene;
    }
    paramJSONObject = paramJSONObject.toString();
    localLoginTask.oBo = this;
    localLoginTask.oCo = paramg;
    localLoginTask.data = paramJSONObject;
    localLoginTask.okO = paramInt;
    localLoginTask.oBq = new JsApiLogin.LoginTask.1(localLoginTask, parame);
    localLoginTask.oBE = new Bundle();
    if ((paramg instanceof v)) {
      localLoginTask.oBH = 1;
    }
    for (;;)
    {
      paramg.getRuntime().keep(new JsApiLogin.LoginTask.2(localLoginTask));
      localLoginTask.bsM();
      AppMethodBeat.o(284059);
      return;
      if ((paramg instanceof ad)) {
        localLoginTask.oBH = 2;
      }
    }
  }
  
  static class LoginTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<LoginTask> CREATOR;
    public String appId;
    public int cBU;
    public String code;
    public String data;
    public int errCode;
    public String errMsg;
    public int loginType;
    public String mAppName;
    public int oBD;
    public Bundle oBE;
    int oBH;
    i oBo;
    e oBq;
    public ArrayList<String> oBr;
    public String oBs;
    public String oBt;
    public int oBu;
    public String oBv;
    j oCo;
    public int okO;
    public int owU;
    public String oyZ;
    
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
      f(paramParcel);
      AppMethodBeat.o(46052);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(46053);
      Object localObject1 = new JsApiLogin.LoginTask.a()
      {
        public final void a(LinkedList<eax> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(276061);
          Log.i("MicroMsg.JsApiLogin", "onConfirm !");
          JsApiLogin.LoginTask.this.oBD = paramAnonymousLinkedList.size();
          int i = 0;
          while (i < JsApiLogin.LoginTask.this.oBD)
          {
            eax localeax = (eax)paramAnonymousLinkedList.get(i);
            try
            {
              JsApiLogin.LoginTask.this.oBE.putByteArray(String.valueOf(i), localeax.toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousLinkedList)
            {
              Log.e("MicroMsg.JsApiLogin", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
              Log.printErrStackTrace("MicroMsg.JsApiLogin", paramAnonymousLinkedList, "", new Object[0]);
              JsApiLogin.LoginTask.this.oBt = "fail";
              JsApiLogin.LoginTask.c(JsApiLogin.LoginTask.this);
              AppMethodBeat.o(276061);
              return;
            }
          }
          JsApiLogin.LoginTask.this.oyZ = paramAnonymousString3;
          JsApiLogin.LoginTask.this.mAppName = paramAnonymousString1;
          JsApiLogin.LoginTask.this.oBv = paramAnonymousString2;
          JsApiLogin.LoginTask.this.oBt = "needConfirm";
          JsApiLogin.LoginTask.d(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(276061);
        }
        
        public final void ak(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(276060);
          Log.i("MicroMsg.JsApiLogin", "onFailure !");
          JsApiLogin.LoginTask.this.oBt = "fail";
          JsApiLogin.LoginTask.this.errCode = paramAnonymousInt;
          JsApiLogin.LoginTask.this.errMsg = paramAnonymousString;
          JsApiLogin.LoginTask.b(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(276060);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(276059);
          Log.i("MicroMsg.JsApiLogin", "onSuccess !");
          JsApiLogin.LoginTask.this.code = paramAnonymousString;
          JsApiLogin.LoginTask.this.oBt = "ok";
          JsApiLogin.LoginTask.a(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(276059);
        }
      };
      Object localObject2;
      if (this.oBs.equals("login"))
      {
        Log.i("MicroMsg.JsApiLogin", "start login");
        localObject2 = new LinkedList();
        this.loginType = 1;
        this.oyZ = "";
        localObject1 = new com.tencent.mm.ac.a.c(this.appId, (LinkedList)localObject2, this.loginType, "", this.oyZ, this.cBU, this.owU, new JsApiLogin.LoginTask.6(this, (JsApiLogin.LoginTask.a)localObject1));
        if (((com.tencent.mm.ac.a.c)localObject1).aGe().TuQ == null) {
          ((com.tencent.mm.ac.a.c)localObject1).aGe().TuQ = new foh();
        }
        ((com.tencent.mm.ac.a.c)localObject1).aGe().TuQ.UMw = this.oBH;
        h.aGY().a((q)localObject1, 0);
        AppMethodBeat.o(46053);
        return;
      }
      if (this.oBs.equals("loginConfirm"))
      {
        Log.i("MicroMsg.JsApiLogin", "start loginConfirm");
        localObject2 = this.appId;
        ArrayList localArrayList = this.oBr;
        int i = this.loginType;
        String str = this.oyZ;
        int j = this.cBU;
        int k = this.oBu;
        localObject1 = new com.tencent.mm.ac.a.d((String)localObject2, i.B(localArrayList), i, str, j, k, this.owU, new JsApiLogin.LoginTask.7(this, (JsApiLogin.LoginTask.a)localObject1, k));
        if (((com.tencent.mm.ac.a.d)localObject1).aGg().TuQ == null) {
          ((com.tencent.mm.ac.a.d)localObject1).aGg().TuQ = new foh();
        }
        ((com.tencent.mm.ac.a.d)localObject1).aGg().TuQ.UMw = this.oBH;
        h.aGY().a((q)localObject1, 0);
      }
      AppMethodBeat.o(46053);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(46054);
      if (!this.oCo.isRunning())
      {
        this.oBq.bQe();
        AppMethodBeat.o(46054);
        return;
      }
      Object localObject;
      if (this.oBt.equals("ok"))
      {
        localObject = new HashMap();
        ((Map)localObject).put("code", this.code);
        localObject = this.oBo.m("ok", (Map)localObject);
        this.oCo.j(this.okO, (String)localObject);
        this.oBq.bQe();
        AppMethodBeat.o(46054);
        return;
      }
      if (this.oBt.equals("fail"))
      {
        if (Util.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.oBo.b(this.oCo, this.okO, (String)localObject);
          this.oBq.bQe();
          AppMethodBeat.o(46054);
          return;
        }
      }
      if (this.oBt.equals("needConfirm"))
      {
        localObject = new LinkedList();
        int i = 0;
        while (i < this.oBD)
        {
          byte[] arrayOfByte = this.oBE.getByteArray(String.valueOf(i));
          eax localeax = new eax();
          try
          {
            localeax.parseFrom(arrayOfByte);
            ((LinkedList)localObject).add(localeax);
            i += 1;
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[] { localIOException.getMessage() });
            Log.printErrStackTrace("MicroMsg.JsApiLogin", localIOException, "", new Object[0]);
            this.oBo.b(this.oCo, this.okO, "fail:internal error scope error");
            this.oBq.bQe();
            AppMethodBeat.o(46054);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(272993);
              c.a local1 = new c.a()
              {
                public final void a(int paramAnonymous2Int, ArrayList<String> paramAnonymous2ArrayList)
                {
                  AppMethodBeat.i(278602);
                  Log.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  switch (paramAnonymous2Int)
                  {
                  default: 
                    Log.d("MicroMsg.JsApiLogin", "press back button!");
                    JsApiLogin.LoginTask.this.oBo.b(JsApiLogin.LoginTask.this.oCo, JsApiLogin.LoginTask.this.okO, "fail auth cancel");
                    JsApiLogin.LoginTask.this.oBq.bQe();
                  }
                  do
                  {
                    AppMethodBeat.o(278602);
                    return;
                    JsApiLogin.LoginTask.this.oBs = "loginConfirm";
                    JsApiLogin.LoginTask.this.oBr = paramAnonymous2ArrayList;
                    JsApiLogin.LoginTask.this.oBu = paramAnonymous2Int;
                    JsApiLogin.LoginTask.this.bsM();
                  } while (paramAnonymous2Int != 2);
                  JsApiLogin.LoginTask.this.oBo.b(JsApiLogin.LoginTask.this.oCo, JsApiLogin.LoginTask.this.okO, "fail auth deny");
                  JsApiLogin.LoginTask.this.oBq.bQe();
                  AppMethodBeat.o(278602);
                }
              };
              JsApiLogin.LoginTask.this.oCo.getDialogContainer().a(new com.tencent.mm.plugin.appbrand.widget.dialog.c(i.b(JsApiLogin.LoginTask.this.oCo), i.z(localIOException), JsApiLogin.LoginTask.this.mAppName, JsApiLogin.LoginTask.this.oBv, local1));
              AppMethodBeat.o(272993);
            }
          });
          AppMethodBeat.o(46054);
          return;
        }
        this.oBo.b(this.oCo, this.okO, "fail:internal error scope empty");
        this.oBq.bQe();
      }
      AppMethodBeat.o(46054);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(46055);
      this.data = paramParcel.readString();
      this.okO = paramParcel.readInt();
      this.oBs = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.code = paramParcel.readString();
      this.oBt = paramParcel.readString();
      this.oyZ = paramParcel.readString();
      this.loginType = paramParcel.readInt();
      this.mAppName = paramParcel.readString();
      this.oBv = paramParcel.readString();
      this.oBD = paramParcel.readInt();
      this.oBE = paramParcel.readBundle(JsApiLogin.class.getClassLoader());
      this.oBr = paramParcel.createStringArrayList();
      this.cBU = paramParcel.readInt();
      this.oBu = paramParcel.readInt();
      this.owU = paramParcel.readInt();
      this.oBH = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      AppMethodBeat.o(46055);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46056);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.okO);
      paramParcel.writeString(this.oBs);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.code);
      paramParcel.writeString(this.oBt);
      paramParcel.writeString(this.oyZ);
      paramParcel.writeInt(this.loginType);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.oBv);
      paramParcel.writeInt(this.oBD);
      paramParcel.writeBundle(this.oBE);
      paramParcel.writeStringList(this.oBr);
      paramParcel.writeInt(this.cBU);
      paramParcel.writeInt(this.oBu);
      paramParcel.writeInt(this.owU);
      paramParcel.writeInt(this.oBH);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(46056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin
 * JD-Core Version:    0.7.0.1
 */