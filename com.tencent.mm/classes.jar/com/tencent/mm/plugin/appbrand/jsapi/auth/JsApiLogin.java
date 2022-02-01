package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.d;
import com.tencent.mm.ak.n;
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
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private final j keo;
  
  public JsApiLogin()
  {
    AppMethodBeat.i(174774);
    this.keo = new j();
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
        ac.e("MicroMsg.JsApiLogin", "invoke put KEY_IN_QUEUE e=%s", new Object[] { localJSONException.getMessage() });
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(46063);
    LoginTask localLoginTask = new LoginTask();
    localLoginTask.appId = paramh.getAppId();
    localLoginTask.kdE = "login";
    Object localObject = paramh.getRuntime().DI();
    if (localObject != null) {
      localLoginTask.hxM = ((k)localObject).jEg.jpa;
    }
    localObject = a.GW(paramh.getAppId());
    if (localObject != null) {
      localLoginTask.jZF = ((AppBrandStatObject)localObject).scene;
    }
    paramJSONObject = paramJSONObject.toString();
    localLoginTask.kdA = this;
    localLoginTask.kdB = paramh;
    localLoginTask.data = paramJSONObject;
    localLoginTask.jOT = paramInt;
    localLoginTask.kdC = parame;
    localLoginTask.kdQ = new Bundle();
    if ((paramh instanceof com.tencent.mm.plugin.appbrand.q)) {
      localLoginTask.kdS = 1;
    }
    for (;;)
    {
      localLoginTask.bej();
      AppBrandMainProcessService.a(localLoginTask);
      AppMethodBeat.o(46063);
      return;
      if ((paramh instanceof aa)) {
        localLoginTask.kdS = 2;
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
    public int hxM;
    public int iMo;
    public int jOT;
    public int jZF;
    public String kbt;
    h kdA;
    com.tencent.mm.plugin.appbrand.jsapi.h kdB;
    e kdC;
    public ArrayList<String> kdD;
    public String kdE;
    public String kdF;
    public int kdG;
    public String kdH;
    public int kdP;
    public Bundle kdQ;
    int kdS;
    public String mAppName;
    
    static
    {
      AppMethodBeat.i(46061);
      CREATOR = new JsApiLogin.LoginTask.3();
      AppMethodBeat.o(46061);
    }
    
    public LoginTask() {}
    
    public LoginTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46052);
      e(paramParcel);
      AppMethodBeat.o(46052);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(46053);
      Object localObject1 = new JsApiLogin.LoginTask.a()
      {
        public final void a(LinkedList<csf> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(46046);
          ac.i("MicroMsg.JsApiLogin", "onConfirm !");
          JsApiLogin.LoginTask.this.kdP = paramAnonymousLinkedList.size();
          int i = 0;
          while (i < JsApiLogin.LoginTask.this.kdP)
          {
            csf localcsf = (csf)paramAnonymousLinkedList.get(i);
            try
            {
              JsApiLogin.LoginTask.this.kdQ.putByteArray(String.valueOf(i), localcsf.toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousLinkedList)
            {
              ac.e("MicroMsg.JsApiLogin", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
              ac.printErrStackTrace("MicroMsg.JsApiLogin", paramAnonymousLinkedList, "", new Object[0]);
              JsApiLogin.LoginTask.this.kdF = "fail";
              JsApiLogin.LoginTask.c(JsApiLogin.LoginTask.this);
              AppMethodBeat.o(46046);
              return;
            }
          }
          JsApiLogin.LoginTask.this.kbt = paramAnonymousString3;
          JsApiLogin.LoginTask.this.mAppName = paramAnonymousString1;
          JsApiLogin.LoginTask.this.kdH = paramAnonymousString2;
          JsApiLogin.LoginTask.this.kdF = "needConfirm";
          JsApiLogin.LoginTask.d(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46046);
        }
        
        public final void ad(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46045);
          ac.i("MicroMsg.JsApiLogin", "onFailure !");
          JsApiLogin.LoginTask.this.kdF = "fail";
          JsApiLogin.LoginTask.this.errCode = paramAnonymousInt;
          JsApiLogin.LoginTask.this.errMsg = paramAnonymousString;
          JsApiLogin.LoginTask.b(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46045);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(46044);
          ac.i("MicroMsg.JsApiLogin", "onSuccess !");
          JsApiLogin.LoginTask.this.code = paramAnonymousString;
          JsApiLogin.LoginTask.this.kdF = "ok";
          JsApiLogin.LoginTask.a(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46044);
        }
      };
      Object localObject2;
      if (this.kdE.equals("login"))
      {
        ac.i("MicroMsg.JsApiLogin", "start login");
        localObject2 = new LinkedList();
        this.iMo = 1;
        this.kbt = "";
        localObject1 = new com.tencent.mm.aa.a.c(this.appId, (LinkedList)localObject2, this.iMo, "", this.kbt, this.hxM, this.jZF, new JsApiLogin.LoginTask.4(this, (JsApiLogin.LoginTask.a)localObject1));
        if (((com.tencent.mm.aa.a.c)localObject1).afu().FbS == null) {
          ((com.tencent.mm.aa.a.c)localObject1).afu().FbS = new eat();
        }
        ((com.tencent.mm.aa.a.c)localObject1).afu().FbS.Ggv = this.kdS;
        g.agi().a((n)localObject1, 0);
        AppMethodBeat.o(46053);
        return;
      }
      if (this.kdE.equals("loginConfirm"))
      {
        ac.i("MicroMsg.JsApiLogin", "start loginConfirm");
        localObject2 = this.appId;
        ArrayList localArrayList = this.kdD;
        int i = this.iMo;
        String str = this.kbt;
        int j = this.hxM;
        int k = this.kdG;
        localObject1 = new d((String)localObject2, h.v(localArrayList), i, str, j, k, this.jZF, new JsApiLogin.LoginTask.5(this, (JsApiLogin.LoginTask.a)localObject1, k));
        if (((d)localObject1).afw().FbS == null) {
          ((d)localObject1).afw().FbS = new eat();
        }
        ((d)localObject1).afw().FbS.Ggv = this.kdS;
        g.agi().a((n)localObject1, 0);
      }
      AppMethodBeat.o(46053);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(46054);
      bek();
      if (!this.kdB.isRunning())
      {
        this.kdC.bfe();
        AppMethodBeat.o(46054);
        return;
      }
      Object localObject;
      if (this.kdF.equals("ok"))
      {
        localObject = new HashMap();
        ((Map)localObject).put("code", this.code);
        localObject = this.kdA.k("ok", (Map)localObject);
        this.kdB.h(this.jOT, (String)localObject);
        this.kdC.bfe();
        AppMethodBeat.o(46054);
        return;
      }
      if (this.kdF.equals("fail"))
      {
        if (bs.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.kdA.b(this.kdB, this.jOT, (String)localObject);
          this.kdC.bfe();
          AppMethodBeat.o(46054);
          return;
        }
      }
      if (this.kdF.equals("needConfirm"))
      {
        localObject = new LinkedList();
        int i = 0;
        while (i < this.kdP)
        {
          byte[] arrayOfByte = this.kdQ.getByteArray(String.valueOf(i));
          csf localcsf = new csf();
          try
          {
            localcsf.parseFrom(arrayOfByte);
            ((LinkedList)localObject).add(localcsf);
            i += 1;
          }
          catch (IOException localIOException)
          {
            ac.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[] { localIOException.getMessage() });
            ac.printErrStackTrace("MicroMsg.JsApiLogin", localIOException, "", new Object[0]);
            this.kdA.b(this.kdB, this.jOT, "fail:internal error scope error");
            this.kdC.bfe();
            AppMethodBeat.o(46054);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46048);
              c.a local1 = new c.a()
              {
                public final void a(int paramAnonymous2Int, ArrayList<String> paramAnonymous2ArrayList)
                {
                  AppMethodBeat.i(46047);
                  ac.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  switch (paramAnonymous2Int)
                  {
                  default: 
                    ac.d("MicroMsg.JsApiLogin", "press back button!");
                    JsApiLogin.LoginTask.this.kdA.b(JsApiLogin.LoginTask.this.kdB, JsApiLogin.LoginTask.this.jOT, "fail auth cancel");
                    JsApiLogin.LoginTask.this.kdC.bfe();
                  }
                  do
                  {
                    AppMethodBeat.o(46047);
                    return;
                    JsApiLogin.LoginTask.this.kdE = "loginConfirm";
                    JsApiLogin.LoginTask.this.kdD = paramAnonymous2ArrayList;
                    JsApiLogin.LoginTask.this.kdG = paramAnonymous2Int;
                    AppBrandMainProcessService.a(JsApiLogin.LoginTask.this);
                  } while (paramAnonymous2Int != 2);
                  JsApiLogin.LoginTask.this.kdA.b(JsApiLogin.LoginTask.this.kdB, JsApiLogin.LoginTask.this.jOT, "fail auth deny");
                  JsApiLogin.LoginTask.this.kdC.bfe();
                  AppMethodBeat.o(46047);
                }
              };
              JsApiLogin.LoginTask.this.kdB.aSs().b(new com.tencent.mm.plugin.appbrand.widget.dialog.c(h.c(JsApiLogin.LoginTask.this.kdB), h.y(localIOException), JsApiLogin.LoginTask.this.mAppName, JsApiLogin.LoginTask.this.kdH, local1));
              AppMethodBeat.o(46048);
            }
          });
          AppMethodBeat.o(46054);
          return;
        }
        this.kdA.b(this.kdB, this.jOT, "fail:internal error scope empty");
        this.kdC.bfe();
      }
      AppMethodBeat.o(46054);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(46055);
      this.data = paramParcel.readString();
      this.jOT = paramParcel.readInt();
      this.kdE = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.code = paramParcel.readString();
      this.kdF = paramParcel.readString();
      this.kbt = paramParcel.readString();
      this.iMo = paramParcel.readInt();
      this.mAppName = paramParcel.readString();
      this.kdH = paramParcel.readString();
      this.kdP = paramParcel.readInt();
      this.kdQ = paramParcel.readBundle(JsApiLogin.class.getClassLoader());
      this.kdD = paramParcel.createStringArrayList();
      this.hxM = paramParcel.readInt();
      this.kdG = paramParcel.readInt();
      this.jZF = paramParcel.readInt();
      this.kdS = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      AppMethodBeat.o(46055);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46056);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.jOT);
      paramParcel.writeString(this.kdE);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.code);
      paramParcel.writeString(this.kdF);
      paramParcel.writeString(this.kbt);
      paramParcel.writeInt(this.iMo);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.kdH);
      paramParcel.writeInt(this.kdP);
      paramParcel.writeBundle(this.kdQ);
      paramParcel.writeStringList(this.kdD);
      paramParcel.writeInt(this.hxM);
      paramParcel.writeInt(this.kdG);
      paramParcel.writeInt(this.jZF);
      paramParcel.writeInt(this.kdS);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(46056);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin
 * JD-Core Version:    0.7.0.1
 */