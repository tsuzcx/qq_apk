package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.protocal.protobuf.dec;
import com.tencent.mm.protocal.protobuf.dee;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.protocal.protobuf.glg;
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
  extends j
{
  public static final int CTRL_INDEX = 52;
  public static final String NAME = "login";
  private final n rFJ;
  
  public JsApiLogin()
  {
    AppMethodBeat.i(174774);
    this.rFJ = new n();
    AppMethodBeat.o(174774);
  }
  
  public final void a(dh<g> paramdh)
  {
    AppMethodBeat.i(326884);
    JSONObject localJSONObject = paramdh.rmi;
    try
    {
      if (!localJSONObject.has("requestInQueue")) {
        localJSONObject.put("requestInQueue", false);
      }
      super.a(paramdh);
      AppMethodBeat.o(326884);
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
  
  public final void a(dh<g> paramdh, e parame)
  {
    AppMethodBeat.i(326890);
    g localg = (g)paramdh.rBv;
    Object localObject1 = paramdh.rmi;
    int i = paramdh.ror;
    paramdh = new LoginTask();
    paramdh.appId = localg.getAppId();
    paramdh.rFc = "login";
    Object localObject2 = localg.getRuntime().asG();
    if (localObject2 != null) {
      paramdh.euz = ((com.tencent.mm.plugin.appbrand.config.n)localObject2).qYY.qHO;
    }
    localObject2 = com.tencent.mm.plugin.appbrand.d.Ue(localg.getAppId());
    if (localObject2 != null) {
      paramdh.rAv = ((AppBrandStatObject)localObject2).scene;
    }
    localObject1 = ((JSONObject)localObject1).toString();
    paramdh.rEY = this;
    paramdh.rFK = localg;
    paramdh.data = ((String)localObject1);
    paramdh.ror = i;
    paramdh.rFa = new JsApiLogin.LoginTask.1(paramdh, parame);
    paramdh.rFq = new Bundle();
    if ((localg instanceof y)) {
      paramdh.rFt = 1;
    }
    for (;;)
    {
      localg.getRuntime().keep(new JsApiLogin.LoginTask.2(paramdh));
      paramdh.bQt();
      AppMethodBeat.o(326890);
      return;
      if ((localg instanceof ad)) {
        paramdh.rFt = 2;
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
    public int euz;
    public int loginType;
    public String mAppName;
    public int rAv;
    public String rCR;
    j rEY;
    k rFK;
    e rFa;
    public ArrayList<String> rFb;
    public String rFc;
    public String rFe;
    public int rFf;
    public String rFh;
    public int rFp;
    public Bundle rFq;
    int rFt;
    public int ror;
    
    static
    {
      AppMethodBeat.i(46061);
      CREATOR = new JsApiLogin.LoginTask.5();
      AppMethodBeat.o(46061);
    }
    
    public LoginTask() {}
    
    public LoginTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46052);
      h(paramParcel);
      AppMethodBeat.o(46052);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(46053);
      Object localObject1 = new JsApiLogin.LoginTask.a()
      {
        public final void a(LinkedList<eul> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(326823);
          Log.i("MicroMsg.JsApiLogin", "onConfirm !");
          JsApiLogin.LoginTask.this.rFp = paramAnonymousLinkedList.size();
          int i = 0;
          while (i < JsApiLogin.LoginTask.this.rFp)
          {
            eul localeul = (eul)paramAnonymousLinkedList.get(i);
            try
            {
              JsApiLogin.LoginTask.this.rFq.putByteArray(String.valueOf(i), localeul.toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousLinkedList)
            {
              Log.e("MicroMsg.JsApiLogin", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
              Log.printErrStackTrace("MicroMsg.JsApiLogin", paramAnonymousLinkedList, "", new Object[0]);
              JsApiLogin.LoginTask.this.rFe = "fail";
              JsApiLogin.LoginTask.c(JsApiLogin.LoginTask.this);
              AppMethodBeat.o(326823);
              return;
            }
          }
          JsApiLogin.LoginTask.this.rCR = paramAnonymousString3;
          JsApiLogin.LoginTask.this.mAppName = paramAnonymousString1;
          JsApiLogin.LoginTask.this.rFh = paramAnonymousString2;
          JsApiLogin.LoginTask.this.rFe = "needConfirm";
          JsApiLogin.LoginTask.d(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(326823);
        }
        
        public final void au(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(326817);
          Log.i("MicroMsg.JsApiLogin", "onFailure !");
          JsApiLogin.LoginTask.this.rFe = "fail";
          JsApiLogin.LoginTask.this.errCode = paramAnonymousInt;
          JsApiLogin.LoginTask.this.errMsg = paramAnonymousString;
          JsApiLogin.LoginTask.b(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(326817);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(326809);
          Log.i("MicroMsg.JsApiLogin", "onSuccess !");
          JsApiLogin.LoginTask.this.code = paramAnonymousString;
          JsApiLogin.LoginTask.this.rFe = "ok";
          JsApiLogin.LoginTask.a(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(326809);
        }
      };
      Object localObject2;
      if (this.rFc.equals("login"))
      {
        Log.i("MicroMsg.JsApiLogin", "start login");
        localObject2 = new LinkedList();
        this.loginType = 1;
        this.rCR = "";
        localObject1 = new com.tencent.mm.ac.a.c(this.appId, (LinkedList)localObject2, this.loginType, "", this.rCR, this.euz, this.rAv, new JsApiLogin.LoginTask.6(this, (JsApiLogin.LoginTask.a)localObject1));
        if (((com.tencent.mm.ac.a.c)localObject1).aZd().aaJv == null) {
          ((com.tencent.mm.ac.a.c)localObject1).aZd().aaJv = new glg();
        }
        ((com.tencent.mm.ac.a.c)localObject1).aZd().aaJv.acgQ = this.rFt;
        h.aZW().a((p)localObject1, 0);
        AppMethodBeat.o(46053);
        return;
      }
      if (this.rFc.equals("loginConfirm"))
      {
        Log.i("MicroMsg.JsApiLogin", "start loginConfirm");
        localObject2 = this.appId;
        ArrayList localArrayList = this.rFb;
        int i = this.loginType;
        String str = this.rCR;
        int j = this.euz;
        int k = this.rFf;
        localObject1 = new com.tencent.mm.ac.a.d((String)localObject2, j.E(localArrayList), i, str, j, k, this.rAv, new JsApiLogin.LoginTask.7(this, (JsApiLogin.LoginTask.a)localObject1, k));
        if (((com.tencent.mm.ac.a.d)localObject1).aZf().aaJv == null) {
          ((com.tencent.mm.ac.a.d)localObject1).aZf().aaJv = new glg();
        }
        ((com.tencent.mm.ac.a.d)localObject1).aZf().aaJv.acgQ = this.rFt;
        h.aZW().a((p)localObject1, 0);
      }
      AppMethodBeat.o(46053);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(46054);
      if (!this.rFK.isRunning())
      {
        this.rFa.onAuthResult();
        AppMethodBeat.o(46054);
        return;
      }
      Object localObject;
      if (this.rFe.equals("ok"))
      {
        localObject = new HashMap();
        ((Map)localObject).put("code", this.code);
        localObject = this.rEY.m("ok", (Map)localObject);
        this.rFK.callback(this.ror, (String)localObject);
        this.rFa.onAuthResult();
        AppMethodBeat.o(46054);
        return;
      }
      if (this.rFe.equals("fail"))
      {
        if (Util.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.rEY.b(this.rFK, this.ror, (String)localObject);
          this.rFa.onAuthResult();
          AppMethodBeat.o(46054);
          return;
        }
      }
      if (this.rFe.equals("needConfirm"))
      {
        localObject = new LinkedList();
        int i = 0;
        while (i < this.rFp)
        {
          byte[] arrayOfByte = this.rFq.getByteArray(String.valueOf(i));
          eul localeul = new eul();
          try
          {
            localeul.parseFrom(arrayOfByte);
            ((LinkedList)localObject).add(localeul);
            i += 1;
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[] { localIOException.getMessage() });
            Log.printErrStackTrace("MicroMsg.JsApiLogin", localIOException, "", new Object[0]);
            this.rEY.b(this.rFK, this.ror, "fail:internal error scope error");
            this.rFa.onAuthResult();
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
              AppMethodBeat.i(326857);
              c.a local1 = new c.a()
              {
                public final void a(int paramAnonymous2Int, ArrayList<String> paramAnonymous2ArrayList)
                {
                  AppMethodBeat.i(326793);
                  Log.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  switch (paramAnonymous2Int)
                  {
                  default: 
                    Log.d("MicroMsg.JsApiLogin", "press back button!");
                    JsApiLogin.LoginTask.this.rEY.b(JsApiLogin.LoginTask.this.rFK, JsApiLogin.LoginTask.this.ror, "fail auth cancel");
                    JsApiLogin.LoginTask.this.rFa.onAuthResult();
                  }
                  do
                  {
                    AppMethodBeat.o(326793);
                    return;
                    JsApiLogin.LoginTask.this.rFc = "loginConfirm";
                    JsApiLogin.LoginTask.this.rFb = paramAnonymous2ArrayList;
                    JsApiLogin.LoginTask.this.rFf = paramAnonymous2Int;
                    JsApiLogin.LoginTask.this.bQt();
                  } while (paramAnonymous2Int != 2);
                  JsApiLogin.LoginTask.this.rEY.b(JsApiLogin.LoginTask.this.rFK, JsApiLogin.LoginTask.this.ror, "fail auth deny");
                  JsApiLogin.LoginTask.this.rFa.onAuthResult();
                  AppMethodBeat.o(326793);
                }
              };
              JsApiLogin.LoginTask.this.rFK.getDialogContainer().b(new com.tencent.mm.plugin.appbrand.widget.dialog.c(j.a(JsApiLogin.LoginTask.this.rFK), j.C(localIOException), JsApiLogin.LoginTask.this.mAppName, JsApiLogin.LoginTask.this.rFh, local1));
              AppMethodBeat.o(326857);
            }
          });
          AppMethodBeat.o(46054);
          return;
        }
        this.rEY.b(this.rFK, this.ror, "fail:internal error scope empty");
        this.rFa.onAuthResult();
      }
      AppMethodBeat.o(46054);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(46055);
      this.data = paramParcel.readString();
      this.ror = paramParcel.readInt();
      this.rFc = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.code = paramParcel.readString();
      this.rFe = paramParcel.readString();
      this.rCR = paramParcel.readString();
      this.loginType = paramParcel.readInt();
      this.mAppName = paramParcel.readString();
      this.rFh = paramParcel.readString();
      this.rFp = paramParcel.readInt();
      this.rFq = paramParcel.readBundle(JsApiLogin.class.getClassLoader());
      this.rFb = paramParcel.createStringArrayList();
      this.euz = paramParcel.readInt();
      this.rFf = paramParcel.readInt();
      this.rAv = paramParcel.readInt();
      this.rFt = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      AppMethodBeat.o(46055);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46056);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.ror);
      paramParcel.writeString(this.rFc);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.code);
      paramParcel.writeString(this.rFe);
      paramParcel.writeString(this.rCR);
      paramParcel.writeInt(this.loginType);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.rFh);
      paramParcel.writeInt(this.rFp);
      paramParcel.writeBundle(this.rFq);
      paramParcel.writeStringList(this.rFb);
      paramParcel.writeInt(this.euz);
      paramParcel.writeInt(this.rFf);
      paramParcel.writeInt(this.rAv);
      paramParcel.writeInt(this.rFt);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(46056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin
 * JD-Core Version:    0.7.0.1
 */