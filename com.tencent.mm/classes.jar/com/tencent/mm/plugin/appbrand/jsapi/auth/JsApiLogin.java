package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.d.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.brw;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  private final l kCm;
  
  public JsApiLogin()
  {
    AppMethodBeat.i(174774);
    this.kCm = new l();
    AppMethodBeat.o(174774);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(222419);
    try
    {
      if (!paramJSONObject.has("requestInQueue")) {
        paramJSONObject.put("requestInQueue", false);
      }
      super.a(paramd, paramJSONObject, paramInt);
      AppMethodBeat.o(222419);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.e("MicroMsg.JsApiLogin", "invoke put KEY_IN_QUEUE e=%s", new Object[] { localJSONException.getMessage() });
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(222420);
    LoginTask localLoginTask = new LoginTask();
    localLoginTask.appId = paramd.getAppId();
    localLoginTask.kBA = "login";
    Object localObject = paramd.getRuntime().Fm();
    if (localObject != null) {
      localLoginTask.hSZ = ((k)localObject).kbw.jLV;
    }
    localObject = a.KK(paramd.getAppId());
    if (localObject != null) {
      localLoginTask.kxr = ((AppBrandStatObject)localObject).scene;
    }
    paramJSONObject = paramJSONObject.toString();
    localLoginTask.kBw = this;
    localLoginTask.kCn = paramd;
    localLoginTask.data = paramJSONObject;
    localLoginTask.kmu = paramInt;
    localLoginTask.kBy = parame;
    localLoginTask.kBM = new Bundle();
    if ((paramd instanceof r)) {
      localLoginTask.kBP = 1;
    }
    for (;;)
    {
      localLoginTask.biw();
      AppBrandMainProcessService.a(localLoginTask);
      AppMethodBeat.o(222420);
      return;
      if ((paramd instanceof z)) {
        localLoginTask.kBP = 2;
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
    public int hSZ;
    public int jir;
    public String kBA;
    public String kBB;
    public int kBC;
    public String kBD;
    public int kBL;
    public Bundle kBM;
    int kBP;
    i kBw;
    e kBy;
    public ArrayList<String> kBz;
    h kCn;
    public int kmu;
    public int kxr;
    public String kze;
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
    
    public final void aOX()
    {
      AppMethodBeat.i(46053);
      Object localObject1 = new a()
      {
        public final void a(LinkedList<cyg> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(46046);
          ae.i("MicroMsg.JsApiLogin", "onConfirm !");
          JsApiLogin.LoginTask.this.kBL = paramAnonymousLinkedList.size();
          int i = 0;
          while (i < JsApiLogin.LoginTask.this.kBL)
          {
            cyg localcyg = (cyg)paramAnonymousLinkedList.get(i);
            try
            {
              JsApiLogin.LoginTask.this.kBM.putByteArray(String.valueOf(i), localcyg.toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousLinkedList)
            {
              ae.e("MicroMsg.JsApiLogin", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
              ae.printErrStackTrace("MicroMsg.JsApiLogin", paramAnonymousLinkedList, "", new Object[0]);
              JsApiLogin.LoginTask.this.kBB = "fail";
              JsApiLogin.LoginTask.c(JsApiLogin.LoginTask.this);
              AppMethodBeat.o(46046);
              return;
            }
          }
          JsApiLogin.LoginTask.this.kze = paramAnonymousString3;
          JsApiLogin.LoginTask.this.mAppName = paramAnonymousString1;
          JsApiLogin.LoginTask.this.kBD = paramAnonymousString2;
          JsApiLogin.LoginTask.this.kBB = "needConfirm";
          JsApiLogin.LoginTask.d(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46046);
        }
        
        public final void af(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46045);
          ae.i("MicroMsg.JsApiLogin", "onFailure !");
          JsApiLogin.LoginTask.this.kBB = "fail";
          JsApiLogin.LoginTask.this.errCode = paramAnonymousInt;
          JsApiLogin.LoginTask.this.errMsg = paramAnonymousString;
          JsApiLogin.LoginTask.b(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46045);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(46044);
          ae.i("MicroMsg.JsApiLogin", "onSuccess !");
          JsApiLogin.LoginTask.this.code = paramAnonymousString;
          JsApiLogin.LoginTask.this.kBB = "ok";
          JsApiLogin.LoginTask.a(JsApiLogin.LoginTask.this);
          AppMethodBeat.o(46044);
        }
      };
      Object localObject2;
      if (this.kBA.equals("login"))
      {
        ae.i("MicroMsg.JsApiLogin", "start login");
        localObject2 = new LinkedList();
        this.jir = 1;
        this.kze = "";
        localObject1 = new com.tencent.mm.aa.a.c(this.appId, (LinkedList)localObject2, this.jir, "", this.kze, this.hSZ, this.kxr, new com.tencent.mm.aa.a.c.a() {});
        if (((com.tencent.mm.aa.a.c)localObject1).aiv().HeS == null) {
          ((com.tencent.mm.aa.a.c)localObject1).aiv().HeS = new eio();
        }
        ((com.tencent.mm.aa.a.c)localObject1).aiv().HeS.IlP = this.kBP;
        g.ajj().a((n)localObject1, 0);
        AppMethodBeat.o(46053);
        return;
      }
      if (this.kBA.equals("loginConfirm"))
      {
        ae.i("MicroMsg.JsApiLogin", "start loginConfirm");
        localObject2 = this.appId;
        ArrayList localArrayList = this.kBz;
        int i = this.jir;
        String str = this.kze;
        int j = this.hSZ;
        final int k = this.kBC;
        localObject1 = new com.tencent.mm.aa.a.d((String)localObject2, i.v(localArrayList), i, str, j, k, this.kxr, new d.a() {});
        if (((com.tencent.mm.aa.a.d)localObject1).aix().HeS == null) {
          ((com.tencent.mm.aa.a.d)localObject1).aix().HeS = new eio();
        }
        ((com.tencent.mm.aa.a.d)localObject1).aix().HeS.IlP = this.kBP;
        g.ajj().a((n)localObject1, 0);
      }
      AppMethodBeat.o(46053);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(46054);
      bix();
      if (!this.kCn.isRunning())
      {
        this.kBy.bjq();
        AppMethodBeat.o(46054);
        return;
      }
      Object localObject;
      if (this.kBB.equals("ok"))
      {
        localObject = new HashMap();
        ((Map)localObject).put("code", this.code);
        localObject = this.kBw.n("ok", (Map)localObject);
        this.kCn.h(this.kmu, (String)localObject);
        this.kBy.bjq();
        AppMethodBeat.o(46054);
        return;
      }
      if (this.kBB.equals("fail"))
      {
        if (bu.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.kBw.b(this.kCn, this.kmu, (String)localObject);
          this.kBy.bjq();
          AppMethodBeat.o(46054);
          return;
        }
      }
      if (this.kBB.equals("needConfirm"))
      {
        localObject = new LinkedList();
        int i = 0;
        while (i < this.kBL)
        {
          byte[] arrayOfByte = this.kBM.getByteArray(String.valueOf(i));
          cyg localcyg = new cyg();
          try
          {
            localcyg.parseFrom(arrayOfByte);
            ((LinkedList)localObject).add(localcyg);
            i += 1;
          }
          catch (IOException localIOException)
          {
            ae.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[] { localIOException.getMessage() });
            ae.printErrStackTrace("MicroMsg.JsApiLogin", localIOException, "", new Object[0]);
            this.kBw.b(this.kCn, this.kmu, "fail:internal error scope error");
            this.kBy.bjq();
            AppMethodBeat.o(46054);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46048);
              com.tencent.mm.plugin.appbrand.widget.dialog.c.a local1 = new com.tencent.mm.plugin.appbrand.widget.dialog.c.a()
              {
                public final void a(int paramAnonymous2Int, ArrayList<String> paramAnonymous2ArrayList)
                {
                  AppMethodBeat.i(46047);
                  ae.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int) });
                  switch (paramAnonymous2Int)
                  {
                  default: 
                    ae.d("MicroMsg.JsApiLogin", "press back button!");
                    JsApiLogin.LoginTask.this.kBw.b(JsApiLogin.LoginTask.this.kCn, JsApiLogin.LoginTask.this.kmu, "fail auth cancel");
                    JsApiLogin.LoginTask.this.kBy.bjq();
                  }
                  do
                  {
                    AppMethodBeat.o(46047);
                    return;
                    JsApiLogin.LoginTask.this.kBA = "loginConfirm";
                    JsApiLogin.LoginTask.this.kBz = paramAnonymous2ArrayList;
                    JsApiLogin.LoginTask.this.kBC = paramAnonymous2Int;
                    AppBrandMainProcessService.a(JsApiLogin.LoginTask.this);
                  } while (paramAnonymous2Int != 2);
                  JsApiLogin.LoginTask.this.kBw.b(JsApiLogin.LoginTask.this.kCn, JsApiLogin.LoginTask.this.kmu, "fail auth deny");
                  JsApiLogin.LoginTask.this.kBy.bjq();
                  AppMethodBeat.o(46047);
                }
              };
              JsApiLogin.LoginTask.this.kCn.aWd().b(new com.tencent.mm.plugin.appbrand.widget.dialog.c(i.b(JsApiLogin.LoginTask.this.kCn), i.y(localIOException), JsApiLogin.LoginTask.this.mAppName, JsApiLogin.LoginTask.this.kBD, local1));
              AppMethodBeat.o(46048);
            }
          });
          AppMethodBeat.o(46054);
          return;
        }
        this.kBw.b(this.kCn, this.kmu, "fail:internal error scope empty");
        this.kBy.bjq();
      }
      AppMethodBeat.o(46054);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(46055);
      this.data = paramParcel.readString();
      this.kmu = paramParcel.readInt();
      this.kBA = paramParcel.readString();
      this.appId = paramParcel.readString();
      this.code = paramParcel.readString();
      this.kBB = paramParcel.readString();
      this.kze = paramParcel.readString();
      this.jir = paramParcel.readInt();
      this.mAppName = paramParcel.readString();
      this.kBD = paramParcel.readString();
      this.kBL = paramParcel.readInt();
      this.kBM = paramParcel.readBundle(JsApiLogin.class.getClassLoader());
      this.kBz = paramParcel.createStringArrayList();
      this.hSZ = paramParcel.readInt();
      this.kBC = paramParcel.readInt();
      this.kxr = paramParcel.readInt();
      this.kBP = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      AppMethodBeat.o(46055);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46056);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.kmu);
      paramParcel.writeString(this.kBA);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.code);
      paramParcel.writeString(this.kBB);
      paramParcel.writeString(this.kze);
      paramParcel.writeInt(this.jir);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.kBD);
      paramParcel.writeInt(this.kBL);
      paramParcel.writeBundle(this.kBM);
      paramParcel.writeStringList(this.kBz);
      paramParcel.writeInt(this.hSZ);
      paramParcel.writeInt(this.kBC);
      paramParcel.writeInt(this.kxr);
      paramParcel.writeInt(this.kBP);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      AppMethodBeat.o(46056);
    }
    
    static abstract interface a
    {
      public abstract void a(LinkedList<cyg> paramLinkedList, String paramString1, String paramString2, String paramString3);
      
      public abstract void af(int paramInt, String paramString);
      
      public abstract void onSuccess(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin
 * JD-Core Version:    0.7.0.1
 */