package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.ceq;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
  private final l lGF;
  
  public JsApiLogin()
  {
    AppMethodBeat.i(174774);
    this.lGF = new l();
    AppMethodBeat.o(174774);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(226702);
    try
    {
      if (!paramJSONObject.has("requestInQueue")) {
        paramJSONObject.put("requestInQueue", false);
      }
      super.a(paramd, paramJSONObject, paramInt);
      AppMethodBeat.o(226702);
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
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(226703);
    LoginTask localLoginTask = new LoginTask();
    localLoginTask.appId = paramd.getAppId();
    localLoginTask.lFR = "login";
    Object localObject = paramd.getRuntime().OT();
    if (localObject != null) {
      localLoginTask.iOo = ((com.tencent.mm.plugin.appbrand.config.l)localObject).leE.kNW;
    }
    localObject = a.TS(paramd.getAppId());
    if (localObject != null) {
      localLoginTask.lBE = ((AppBrandStatObject)localObject).scene;
    }
    paramJSONObject = paramJSONObject.toString();
    localLoginTask.lFN = this;
    localLoginTask.lGG = paramd;
    localLoginTask.data = paramJSONObject;
    localLoginTask.lqe = paramInt;
    localLoginTask.lFP = parame;
    localLoginTask.lGd = new Bundle();
    if ((paramd instanceof s)) {
      localLoginTask.lGg = 1;
    }
    for (;;)
    {
      localLoginTask.bDJ();
      AppBrandMainProcessService.a(localLoginTask);
      AppMethodBeat.o(226703);
      return;
      if ((paramd instanceof ac)) {
        localLoginTask.lGg = 2;
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
    public int iOo;
    public int lBE;
    public String lDx;
    i lFN;
    e lFP;
    public ArrayList<String> lFQ;
    public String lFR;
    public String lFS;
    public int lFT;
    public String lFU;
    k lGG;
    public int lGc;
    public Bundle lGd;
    int lGg;
    public int loginType;
    public int lqe;
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
      f(paramParcel);
      AppMethodBeat.o(46052);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(46053);
      Object localObject1 = new a()
      {
        public final void a(LinkedList<drb> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(46046);
          Log.i("MicroMsg.JsApiLogin", "onConfirm !");
          JsApiLogin.LoginTask.this.lGc = paramAnonymousLinkedList.size();
          int i = 0;
          while (i < JsApiLogin.LoginTask.this.lGc)
          {
            drb localdrb = (drb)paramAnonymousLinkedList.get(i);
            try
            {
              JsApiLogin.LoginTask.this.lGd.putByteArray(String.valueOf(i), localdrb.toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousLinkedList)
            {
              Log.e("MicroMsg.JsApiLogin", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
              Log.printErrStackTrace("MicroMsg.JsApiLogin", paramAnonymousLinkedList, "", new Object[0]);
              JsApiLogin.LoginTask.this.lFS = "fail";
              JsApiLogin.LoginTask.c(JsApiLogin.LoginTask.this);
              AppMethodBeat.o(46046);
              return;
            }
          }
          JsApiLogin.LoginTask.this.lDx = paramAnonymousString3;
          JsApiLogin.LoginTask.this.mAppName = paramAnonymousString1;
          JsApiLogin.LoginTask.this.lFU = paramAnonymousString2;
          JsApiLogin.LoginTask.this.lFS = "needConfirm";
          JsApiLogin.LoginTask.d(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46046);
        }
        
        public final void ai(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46045);
          Log.i("MicroMsg.JsApiLogin", "onFailure !");
          JsApiLogin.LoginTask.this.lFS = "fail";
          JsApiLogin.LoginTask.this.errCode = paramAnonymousInt;
          JsApiLogin.LoginTask.this.errMsg = paramAnonymousString;
          JsApiLogin.LoginTask.b(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46045);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(46044);
          Log.i("MicroMsg.JsApiLogin", "onSuccess !");
          JsApiLogin.LoginTask.this.code = paramAnonymousString;
          JsApiLogin.LoginTask.this.lFS = "ok";
          JsApiLogin.LoginTask.a(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46044);
        }
      };
      Object localObject2;
      if (this.lFR.equals("login"))
      {
        Log.i("MicroMsg.JsApiLogin", "start login");
        localObject2 = new LinkedList();
        this.loginType = 1;
        this.lDx = "";
        localObject1 = new com.tencent.mm.aa.a.c(this.appId, (LinkedList)localObject2, this.loginType, "", this.lDx, this.iOo, this.lBE, new com.tencent.mm.aa.a.c.a() {});
        if (((com.tencent.mm.aa.a.c)localObject1).ayL().Mka == null) {
          ((com.tencent.mm.aa.a.c)localObject1).ayL().Mka = new fdg();
        }
        ((com.tencent.mm.aa.a.c)localObject1).ayL().Mka.NyS = this.lGg;
        g.azz().a((q)localObject1, 0);
        AppMethodBeat.o(46053);
        return;
      }
      if (this.lFR.equals("loginConfirm"))
      {
        Log.i("MicroMsg.JsApiLogin", "start loginConfirm");
        localObject2 = this.appId;
        ArrayList localArrayList = this.lFQ;
        int i = this.loginType;
        String str = this.lDx;
        int j = this.iOo;
        final int k = this.lFT;
        localObject1 = new com.tencent.mm.aa.a.d((String)localObject2, i.A(localArrayList), i, str, j, k, this.lBE, new d.a() {});
        if (((com.tencent.mm.aa.a.d)localObject1).ayN().Mka == null) {
          ((com.tencent.mm.aa.a.d)localObject1).ayN().Mka = new fdg();
        }
        ((com.tencent.mm.aa.a.d)localObject1).ayN().Mka.NyS = this.lGg;
        g.azz().a((q)localObject1, 0);
      }
      AppMethodBeat.o(46053);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(46054);
      bDK();
      if (!this.lGG.isRunning())
      {
        this.lFP.bEE();
        AppMethodBeat.o(46054);
        return;
      }
      Object localObject;
      if (this.lFS.equals("ok"))
      {
        localObject = new HashMap();
        ((Map)localObject).put("code", this.code);
        localObject = this.lFN.n("ok", (Map)localObject);
        this.lGG.i(this.lqe, (String)localObject);
        this.lFP.bEE();
        AppMethodBeat.o(46054);
        return;
      }
      if (this.lFS.equals("fail"))
      {
        if (Util.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.lFN.b(this.lGG, this.lqe, (String)localObject);
          this.lFP.bEE();
          AppMethodBeat.o(46054);
          return;
        }
      }
      if (this.lFS.equals("needConfirm"))
      {
        localObject = new LinkedList();
        int i = 0;
        while (i < this.lGc)
        {
          byte[] arrayOfByte = this.lGd.getByteArray(String.valueOf(i));
          drb localdrb = new drb();
          try
          {
            localdrb.parseFrom(arrayOfByte);
            ((LinkedList)localObject).add(localdrb);
            i += 1;
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[] { localIOException.getMessage() });
            Log.printErrStackTrace("MicroMsg.JsApiLogin", localIOException, "", new Object[0]);
            this.lFN.b(this.lGG, this.lqe, "fail:internal error scope error");
            this.lFP.bEE();
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
              AppMethodBeat.i(46048);
              com.tencent.mm.plugin.appbrand.widget.dialog.c.a local1 = new com.tencent.mm.plugin.appbrand.widget.dialog.c.a()
              {
                public final void a(int paramAnonymous2Int, ArrayList<String> paramAnonymous2ArrayList)
                {
                  AppMethodBeat.i(46047);
                  Log.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  switch (paramAnonymous2Int)
                  {
                  default: 
                    Log.d("MicroMsg.JsApiLogin", "press back button!");
                    JsApiLogin.LoginTask.this.lFN.b(JsApiLogin.LoginTask.this.lGG, JsApiLogin.LoginTask.this.lqe, "fail auth cancel");
                    JsApiLogin.LoginTask.this.lFP.bEE();
                  }
                  do
                  {
                    AppMethodBeat.o(46047);
                    return;
                    JsApiLogin.LoginTask.this.lFR = "loginConfirm";
                    JsApiLogin.LoginTask.this.lFQ = paramAnonymous2ArrayList;
                    JsApiLogin.LoginTask.this.lFT = paramAnonymous2Int;
                    AppBrandMainProcessService.a(JsApiLogin.LoginTask.this);
                  } while (paramAnonymous2Int != 2);
                  JsApiLogin.LoginTask.this.lFN.b(JsApiLogin.LoginTask.this.lGG, JsApiLogin.LoginTask.this.lqe, "fail auth deny");
                  JsApiLogin.LoginTask.this.lFP.bEE();
                  AppMethodBeat.o(46047);
                }
              };
              JsApiLogin.LoginTask.this.lGG.getDialogContainer().b(new com.tencent.mm.plugin.appbrand.widget.dialog.c(i.b(JsApiLogin.LoginTask.this.lGG), i.y(localIOException), JsApiLogin.LoginTask.this.mAppName, JsApiLogin.LoginTask.this.lFU, local1));
              AppMethodBeat.o(46048);
            }
          });
          AppMethodBeat.o(46054);
          return;
        }
        this.lFN.b(this.lGG, this.lqe, "fail:internal error scope empty");
        this.lFP.bEE();
      }
      AppMethodBeat.o(46054);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(46055);
      this.data = paramParcel.readString();
      this.lqe = paramParcel.readInt();
      this.lFR = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.code = paramParcel.readString();
      this.lFS = paramParcel.readString();
      this.lDx = paramParcel.readString();
      this.loginType = paramParcel.readInt();
      this.mAppName = paramParcel.readString();
      this.lFU = paramParcel.readString();
      this.lGc = paramParcel.readInt();
      this.lGd = paramParcel.readBundle(JsApiLogin.class.getClassLoader());
      this.lFQ = paramParcel.createStringArrayList();
      this.iOo = paramParcel.readInt();
      this.lFT = paramParcel.readInt();
      this.lBE = paramParcel.readInt();
      this.lGg = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      AppMethodBeat.o(46055);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46056);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.lqe);
      paramParcel.writeString(this.lFR);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.code);
      paramParcel.writeString(this.lFS);
      paramParcel.writeString(this.lDx);
      paramParcel.writeInt(this.loginType);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.lFU);
      paramParcel.writeInt(this.lGc);
      paramParcel.writeBundle(this.lGd);
      paramParcel.writeStringList(this.lFQ);
      paramParcel.writeInt(this.iOo);
      paramParcel.writeInt(this.lFT);
      paramParcel.writeInt(this.lBE);
      paramParcel.writeInt(this.lGg);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(46056);
    }
    
    static abstract interface a
    {
      public abstract void a(LinkedList<drb> paramLinkedList, String paramString1, String paramString2, String paramString3);
      
      public abstract void ai(int paramInt, String paramString);
      
      public abstract void onSuccess(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin
 * JD-Core Version:    0.7.0.1
 */