package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.a.a.a;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.a;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize
  extends i
{
  private static final int CTRL_INDEX = 54;
  private static final String NAME = "authorize";
  private final k lFM;
  
  public JsApiAuthorize()
  {
    AppMethodBeat.i(174773);
    this.lFM = new k();
    AppMethodBeat.o(174773);
  }
  
  public final void a(d paramd, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(226701);
    Log.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
    AuthorizeTask localAuthorizeTask = new AuthorizeTask();
    localAuthorizeTask.appId = paramd.getAppId();
    localAuthorizeTask.lFR = "authorize";
    Object localObject = paramd.getRuntime().OT();
    if (localObject != null) {
      localAuthorizeTask.iOo = ((l)localObject).leE.kNW;
    }
    localObject = com.tencent.mm.plugin.appbrand.a.TS(paramd.getAppId());
    if (localObject != null) {
      AuthorizeTask.a(localAuthorizeTask, ((AppBrandStatObject)localObject).scene);
    }
    paramJSONObject = paramJSONObject.toString();
    localAuthorizeTask.lFN = this;
    localAuthorizeTask.lFO = paramd;
    localAuthorizeTask.data = paramJSONObject;
    localAuthorizeTask.lqe = paramInt;
    localAuthorizeTask.lFP = parame;
    localAuthorizeTask.lGd = new Bundle();
    if ((paramd instanceof s)) {
      localAuthorizeTask.lGg = 1;
    }
    for (;;)
    {
      localAuthorizeTask.bDJ();
      AppBrandMainProcessService.a(localAuthorizeTask);
      AppMethodBeat.o(226701);
      return;
      if ((paramd instanceof ac)) {
        localAuthorizeTask.lGg = 2;
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
    public int iOo;
    private int lBE;
    transient i lFN;
    transient d lFO;
    transient e lFP;
    public ArrayList<String> lFQ;
    public String lFR;
    public String lFS;
    public int lFT;
    public String lFU;
    public String lFV;
    public String lFW;
    public String lFX;
    public boolean lFY;
    public String lFZ;
    public String lGa;
    public String lGb;
    public int lGc;
    public Bundle lGd;
    public String lGe;
    public MMAuthScopeRiskInfo lGf;
    int lGg;
    public String lGh;
    public String lGi;
    public int lqe;
    public String mAppName;
    
    static
    {
      AppMethodBeat.i(46042);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46042);
    }
    
    public AuthorizeTask() {}
    
    public AuthorizeTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46028);
      f(paramParcel);
      AppMethodBeat.o(46028);
    }
    
    private void Zb(String paramString)
    {
      AppMethodBeat.i(46031);
      if (TextUtils.isEmpty(paramString)) {
        this.lFN.b(this.lFO, this.lqe, "fail auth cancel");
      }
      for (;;)
      {
        this.lFP.bEE();
        AppMethodBeat.o(46031);
        return;
        this.lFN.b(this.lFO, this.lqe, paramString);
      }
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(46029);
      a local1 = new a()
      {
        public final void a(MMAuthScopeRiskInfo paramAnonymousMMAuthScopeRiskInfo)
        {
          AppMethodBeat.i(226689);
          Log.d("MicroMsg.JsApiAuthorize", "onScopeRiskIntercepted !");
          JsApiAuthorize.AuthorizeTask.this.lFS = "risk_intercepted";
          JsApiAuthorize.AuthorizeTask.this.lGf = paramAnonymousMMAuthScopeRiskInfo;
          JsApiAuthorize.AuthorizeTask.b(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(226689);
        }
        
        public final void a(cep paramAnonymouscep)
        {
          AppMethodBeat.i(46021);
          Log.d("MicroMsg.JsApiAuthorize", "onConfirm !");
          Object localObject1 = paramAnonymouscep.LRN;
          JsApiAuthorize.AuthorizeTask.this.lGc = ((LinkedList)localObject1).size();
          int i = 0;
          Object localObject2;
          while (i < JsApiAuthorize.AuthorizeTask.this.lGc)
          {
            localObject2 = (drb)((LinkedList)localObject1).get(i);
            try
            {
              JsApiAuthorize.AuthorizeTask.this.lGd.putByteArray(String.valueOf(i), ((drb)localObject2).toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymouscep)
            {
              Log.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { paramAnonymouscep.getMessage() });
              Log.printErrStackTrace("MicroMsg.JsApiAuthorize", paramAnonymouscep, "", new Object[0]);
              JsApiAuthorize.AuthorizeTask.this.lFS = "fail";
              JsApiAuthorize.AuthorizeTask.d(JsApiAuthorize.AuthorizeTask.this);
              AppMethodBeat.o(46021);
              return;
            }
          }
          JsApiAuthorize.AuthorizeTask.this.mAppName = paramAnonymouscep.xMq;
          JsApiAuthorize.AuthorizeTask.this.lFU = paramAnonymouscep.KFs;
          JsApiAuthorize.AuthorizeTask.this.lFV = paramAnonymouscep.Mkg;
          JsApiAuthorize.AuthorizeTask.this.lFX = paramAnonymouscep.Mkf;
          JsApiAuthorize.AuthorizeTask.this.lFW = paramAnonymouscep.Mke;
          if (paramAnonymouscep.Mkh != null)
          {
            JsApiAuthorize.AuthorizeTask.this.lFY = paramAnonymouscep.Mkh.KHU;
            JsApiAuthorize.AuthorizeTask.this.lFZ = paramAnonymouscep.Mkh.KHV;
          }
          JsApiAuthorize.AuthorizeTask.this.lFS = "needConfirm";
          if (((LinkedList)localObject1).size() > 0)
          {
            localObject1 = (drb)((LinkedList)localObject1).get(0);
            localObject2 = JsApiAuthorize.AuthorizeTask.this;
            if (((drb)localObject1).MTJ == null)
            {
              paramAnonymouscep = "";
              ((JsApiAuthorize.AuthorizeTask)localObject2).lGe = paramAnonymouscep;
              if (!"scope.userInfo".equals(((drb)localObject1).KWK)) {
                break label371;
              }
              JsApiAuthorize.AuthorizeTask.this.lGb = z.aUa();
              localObject1 = new StringBuilder("userNickName=");
              if (JsApiAuthorize.AuthorizeTask.this.lGb != null) {
                break label360;
              }
            }
            label360:
            for (paramAnonymouscep = "";; paramAnonymouscep = JsApiAuthorize.AuthorizeTask.this.lGb)
            {
              Log.i("MicroMsg.JsApiAuthorize", paramAnonymouscep);
              paramAnonymouscep = z.aTY();
              localObject1 = g.lFD;
              g.a.a(paramAnonymouscep, new g.b()
              {
                public final void UI(String paramAnonymous2String)
                {
                  AppMethodBeat.i(46018);
                  JsApiAuthorize.AuthorizeTask.this.lGa = paramAnonymous2String;
                  StringBuilder localStringBuilder = new StringBuilder(" userHeadIconPath=");
                  if (JsApiAuthorize.AuthorizeTask.this.lGa == null) {}
                  for (paramAnonymous2String = "";; paramAnonymous2String = JsApiAuthorize.AuthorizeTask.this.lGa)
                  {
                    Log.i("MicroMsg.JsApiAuthorize", paramAnonymous2String);
                    JsApiAuthorize.AuthorizeTask.e(JsApiAuthorize.AuthorizeTask.this);
                    AppMethodBeat.o(46018);
                    return;
                  }
                }
              });
              AppMethodBeat.o(46021);
              return;
              paramAnonymouscep = ((drb)localObject1).MTJ;
              break;
            }
            label371:
            JsApiAuthorize.AuthorizeTask.f(JsApiAuthorize.AuthorizeTask.this);
            AppMethodBeat.o(46021);
            return;
          }
          JsApiAuthorize.AuthorizeTask.g(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46021);
        }
        
        public final void ai(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46020);
          Log.e("MicroMsg.JsApiAuthorize", "onFailure !");
          JsApiAuthorize.AuthorizeTask.this.lFS = "fail";
          JsApiAuthorize.AuthorizeTask.this.errCode = paramAnonymousInt;
          JsApiAuthorize.AuthorizeTask.this.errMsg = paramAnonymousString;
          JsApiAuthorize.AuthorizeTask.c(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46020);
        }
        
        public final void onSuccess()
        {
          AppMethodBeat.i(46019);
          Log.d("MicroMsg.JsApiAuthorize", "onSuccess !");
          JsApiAuthorize.AuthorizeTask.this.lFS = "ok";
          JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46019);
        }
      };
      Object localObject2;
      Object localObject3;
      int i;
      label147:
      Object localObject1;
      if (this.lFR.equals("authorize"))
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
          if (((LinkedList)localObject3).size() <= 0) {
            break label147;
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[] { localException.getMessage() });
          this.lFS = "fail";
          bDU();
          AppMethodBeat.o(46029);
          return;
        }
        this.lGh = ((String)((LinkedList)localObject3).get(0));
        localObject1 = new com.tencent.mm.aa.a.a(this.appId, (LinkedList)localObject3, this.iOo, this.lBE, new a.a() {});
        if (((com.tencent.mm.aa.a.a)localObject1).ayH().Mka == null) {
          ((com.tencent.mm.aa.a.a)localObject1).ayH().Mka = new fdg();
        }
        ((com.tencent.mm.aa.a.a)localObject1).ayH().Mka.NyS = this.lGg;
        com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
        AppMethodBeat.o(46029);
        return;
      }
      if (this.lFR.equals("authorizeConfirm"))
      {
        localObject2 = this.appId;
        localObject3 = this.lFQ;
        i = this.iOo;
        final int j = this.lFT;
        localObject1 = new com.tencent.mm.aa.a.b((String)localObject2, i.A((ArrayList)localObject3), i, j, this.lBE, new com.tencent.mm.aa.a.b.a() {});
        if (((com.tencent.mm.aa.a.b)localObject1).ayJ().Mka == null) {
          ((com.tencent.mm.aa.a.b)localObject1).ayJ().Mka = new fdg();
        }
        ((com.tencent.mm.aa.a.b)localObject1).ayJ().Mka.NyS = this.lGg;
        com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)localObject1, 0);
      }
      AppMethodBeat.o(46029);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(46030);
      bDK();
      if (!this.lFO.isRunning())
      {
        this.lFP.bEE();
        AppMethodBeat.o(46030);
        return;
      }
      if (this.lFS.equals("ok"))
      {
        if ((this.lGh != null) && (!Util.isNullOrNil(this.lGi)) && (!this.lGh.equals(this.lGi)))
        {
          Log.i("MicroMsg.JsApiAuthorize", "targetScope:%s, selectScope:%s", new Object[] { this.lGh, this.lGi });
          this.lFN.b(this.lFO, this.lqe, "fail auth deny");
        }
        for (;;)
        {
          this.lFP.bEE();
          AppMethodBeat.o(46030);
          return;
          this.lFN.b(this.lFO, this.lqe, "ok");
        }
      }
      Object localObject;
      if (this.lFS.equals("fail"))
      {
        if (Util.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.lFN.b(this.lFO, this.lqe, (String)localObject);
          this.lFP.bEE();
          AppMethodBeat.o(46030);
          return;
        }
      }
      if (this.lFS.equals("risk_intercepted"))
      {
        if (this.lGf != null) {
          h.a(this.lFO.getContext(), this.lGf.dQx, this.lGf.lHB, this.lGf.lHA, h.b.a(this.lFO.getContext(), this.lGf), new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(226690);
              JsApiAuthorize.AuthorizeTask.this.lFN.b(JsApiAuthorize.AuthorizeTask.this.lFO, JsApiAuthorize.AuthorizeTask.this.lqe, "fail:risk intercepted");
              AppMethodBeat.o(226690);
            }
          });
        }
        this.lFP.bEE();
        AppMethodBeat.o(46030);
        return;
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
            Log.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { localIOException.getMessage() });
            Log.printErrStackTrace("MicroMsg.JsApiAuthorize", localIOException, "", new Object[0]);
            this.lFN.b(this.lFO, this.lqe, "fail:internal error scope error");
            this.lFP.bEE();
            AppMethodBeat.o(46030);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.lFO.P(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(226693);
              drb localdrb = (drb)localIOException.get(0);
              AppBrandRuntime localAppBrandRuntime = JsApiAuthorize.AuthorizeTask.this.lFO.getRuntime();
              boolean bool = com.tencent.mm.plugin.appbrand.permission.q.a(localdrb.KWK, localAppBrandRuntime.OT());
              final com.tencent.mm.plugin.appbrand.permission.a.b localb = com.tencent.mm.plugin.appbrand.permission.a.b.a.a(JsApiAuthorize.AuthorizeTask.this.lFO, new com.tencent.mm.plugin.appbrand.widget.dialog.h.b()
              {
                public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(226691);
                  JsApiAuthorize.AuthorizeTask localAuthorizeTask = JsApiAuthorize.AuthorizeTask.this;
                  if (com.tencent.luggage.h.b.G(paramAnonymous2ArrayList).size() > 0)
                  {
                    paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);
                    localAuthorizeTask.lGi = paramAnonymous2ArrayList;
                    switch (paramAnonymous2Int1)
                    {
                    }
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(226691);
                    return;
                    paramAnonymous2ArrayList = "";
                    break;
                    paramAnonymous2ArrayList = new ArrayList();
                    paramAnonymous2ArrayList.add(JsApiAuthorize.AuthorizeTask.this.lGi);
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 1, paramAnonymous2ArrayList);
                    Log.i("MicroMsg.JsApiAuthorize", "click PositiveButton");
                    AppMethodBeat.o(226691);
                    return;
                    paramAnonymous2ArrayList = new ArrayList();
                    paramAnonymous2ArrayList.add(JsApiAuthorize.AuthorizeTask.this.lGi);
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 2, paramAnonymous2ArrayList);
                    Log.i("MicroMsg.JsApiAuthorize", "click NegativeButton");
                    AppMethodBeat.o(226691);
                    return;
                    JsApiAuthorize.AuthorizeTask.h(JsApiAuthorize.AuthorizeTask.this);
                    Log.i("MicroMsg.JsApiAuthorize", "user cancel");
                  }
                }
              });
              localb.setAppBrandName(localAppBrandRuntime.OT().brandName);
              localb.setApplyWording(JsApiAuthorize.AuthorizeTask.this.lFV);
              localb.setRequestDesc(localdrb.Desc);
              localb.setNegativeButtonText(JsApiAuthorize.AuthorizeTask.this.lFW);
              localb.setPositiveButtonText(JsApiAuthorize.AuthorizeTask.this.lFX);
              localb.setIconUrl(JsApiAuthorize.AuthorizeTask.this.lFU);
              Object localObject;
              if ((JsApiAuthorize.AuthorizeTask.this.lFY) && (!TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.lFZ)))
              {
                localb.ia(true);
                localb.setExplainOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(226692);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bm(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                    localb.a(JsApiAuthorize.AuthorizeTask.this.lFO, JsApiAuthorize.AuthorizeTask.this.lFZ, (ag)JsApiAuthorize.AuthorizeTask.this.lFO.M(ag.class)).h(JsApiAuthorize.AuthorizeTask.this.lFO);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(226692);
                  }
                });
                if (!"scope.userInfo".equals(localdrb.KWK)) {
                  break label327;
                }
                localObject = g.lFD;
                localObject = JsApiAuthorize.AuthorizeTask.this.lFO.getContext();
                Bitmap localBitmap = com.tencent.mm.aj.e.Mq(JsApiAuthorize.AuthorizeTask.this.lGa);
                String str1 = JsApiAuthorize.AuthorizeTask.this.lGb;
                String str2 = localdrb.KWK;
                p.h(localObject, "context");
                p.h(localb, "dialog");
                f.c.a((Context)localObject, localBitmap, str1, str2, localb);
              }
              for (;;)
              {
                if (bool)
                {
                  if (TextUtils.isEmpty(com.tencent.mm.plugin.appbrand.permission.q.a(localdrb.KWK, localAppBrandRuntime)))
                  {
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, "fail:require permission desc");
                    Log.i("MicroMsg.JsApiAuthorize", "error = fail:require permission desc");
                    AppMethodBeat.o(226693);
                    return;
                    localb.ia(false);
                    break;
                    label327:
                    if (localIOException.size() > 1)
                    {
                      localObject = new ArrayList();
                      ((List)localObject).add(new i.a(((drb)localIOException.get(0)).MTK, ((drb)localIOException.get(0)).KWK, true));
                      int i = 1;
                      while (i < localIOException.size())
                      {
                        ((List)localObject).add(new i.a(((drb)localIOException.get(i)).MTK, ((drb)localIOException.get(i)).KWK, false));
                        i += 1;
                      }
                      localb.setFunctionButtonVisibility(8);
                      localb.setSelectListItem((List)localObject);
                      localb.setScope("");
                      continue;
                    }
                    localb.setScope(localdrb.KWK);
                    continue;
                  }
                  localb.setSimpleDetailDesc(com.tencent.mm.plugin.appbrand.permission.q.a(localdrb.KWK, localAppBrandRuntime));
                }
              }
              for (;;)
              {
                Log.i("MicroMsg.JsApiAuthorize", "Confirm dialog scope=%s desc =%s auth_desc=%s ext_desc=%s", new Object[] { localdrb.KWK, localdrb.Desc, localdrb.Mjt, localdrb.nBo });
                localb.h(JsApiAuthorize.AuthorizeTask.this.lFO);
                AppMethodBeat.o(226693);
                return;
                if (!TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.lGe)) {
                  localb.setSimpleDetailDesc(JsApiAuthorize.AuthorizeTask.this.lGe);
                }
              }
            }
          });
          AppMethodBeat.o(46030);
          return;
        }
        this.lFN.b(this.lFO, this.lqe, "fail:internal error scope empty");
        this.lFP.bEE();
      }
      AppMethodBeat.o(46030);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46032);
      this.data = paramParcel.readString();
      this.lqe = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.lFS = paramParcel.readString();
      this.lFR = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.lFU = paramParcel.readString();
      this.lGc = paramParcel.readInt();
      this.lGd = paramParcel.readBundle(JsApiAuthorize.class.getClassLoader());
      this.lFQ = paramParcel.createStringArrayList();
      this.iOo = paramParcel.readInt();
      this.lFT = paramParcel.readInt();
      this.lBE = paramParcel.readInt();
      this.lGg = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      this.lFX = paramParcel.readString();
      this.lFW = paramParcel.readString();
      this.lFV = paramParcel.readString();
      this.lGa = paramParcel.readString();
      this.lGb = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.lFY = bool;
        this.lFZ = paramParcel.readString();
        this.lGe = paramParcel.readString();
        this.lGf = ((MMAuthScopeRiskInfo)paramParcel.readParcelable(MMAuthScopeRiskInfo.class.getClassLoader()));
        this.lGh = paramParcel.readString();
        this.lGi = paramParcel.readString();
        AppMethodBeat.o(46032);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46033);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.lqe);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.lFS);
      paramParcel.writeString(this.lFR);
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
      paramParcel.writeString(this.lFX);
      paramParcel.writeString(this.lFW);
      paramParcel.writeString(this.lFV);
      paramParcel.writeString(this.lGa);
      paramParcel.writeString(this.lGb);
      if (this.lFY) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeInt(i);
        paramParcel.writeString(this.lFZ);
        paramParcel.writeString(this.lGe);
        paramParcel.writeParcelable(this.lGf, paramInt);
        paramParcel.writeString(this.lGh);
        paramParcel.writeString(this.lGi);
        AppMethodBeat.o(46033);
        return;
      }
    }
    
    public static abstract interface a
    {
      public abstract void a(MMAuthScopeRiskInfo paramMMAuthScopeRiskInfo);
      
      public abstract void a(cep paramcep);
      
      public abstract void ai(int paramInt, String paramString);
      
      public abstract void onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize
 * JD-Core Version:    0.7.0.1
 */