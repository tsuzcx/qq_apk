package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserPrivacyProtectInfo;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.permission.a.b.b;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.dialog.d.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.dea;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.protocal.protobuf.glg;
import com.tencent.mm.protocal.protobuf.gma;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize
  extends j
{
  private static final int CTRL_INDEX = 54;
  private static final String NAME = "authorize";
  
  public JsApiAuthorize()
  {
    AppMethodBeat.i(174773);
    AppMethodBeat.o(174773);
  }
  
  public final void a(dh<com.tencent.mm.plugin.appbrand.g> paramdh, e parame)
  {
    AppMethodBeat.i(326778);
    com.tencent.mm.plugin.appbrand.g localg = (com.tencent.mm.plugin.appbrand.g)paramdh.rBv;
    JSONObject localJSONObject = paramdh.rmi;
    int i = paramdh.ror;
    Log.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
    AuthorizeTask localAuthorizeTask = new AuthorizeTask();
    localAuthorizeTask.appId = localg.getAppId();
    if (paramdh.qxU != null)
    {
      localAuthorizeTask.rFd = new gma();
      localAuthorizeTask.rFd.aaWC = paramdh.qxU.optString("appId");
      paramdh = (com.tencent.luggage.sdk.config.c)localg.getRuntime().d(com.tencent.luggage.sdk.config.c.class, false);
      if (paramdh != null) {
        localAuthorizeTask.rFd.achq = paramdh.fm(localAuthorizeTask.rFd.aaWC);
      }
    }
    localAuthorizeTask.rFc = "authorize";
    paramdh = localg.getRuntime().asG();
    if (paramdh != null) {
      localAuthorizeTask.euz = paramdh.qYY.qHO;
    }
    paramdh = d.Ue(localg.getAppId());
    if (paramdh != null) {
      AuthorizeTask.a(localAuthorizeTask, paramdh.scene);
    }
    paramdh = localJSONObject.toString();
    localAuthorizeTask.rEY = this;
    localAuthorizeTask.rEZ = localg;
    localAuthorizeTask.data = paramdh;
    localAuthorizeTask.ror = i;
    localAuthorizeTask.rFa = new JsApiAuthorize.AuthorizeTask.1(localAuthorizeTask, parame);
    localAuthorizeTask.rFq = new Bundle();
    if ((localg instanceof y)) {
      localAuthorizeTask.rFt = 1;
    }
    for (;;)
    {
      localg.getRuntime().keep(new JsApiAuthorize.AuthorizeTask.2(localAuthorizeTask));
      localAuthorizeTask.bQt();
      AppMethodBeat.o(326778);
      return;
      if ((localg instanceof ad)) {
        localAuthorizeTask.rFt = 2;
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
    public int euz;
    public String mAppName;
    private int rAv;
    transient j rEY;
    transient com.tencent.mm.plugin.appbrand.g rEZ;
    transient e rFa;
    public ArrayList<String> rFb;
    public String rFc;
    public gma rFd;
    public String rFe;
    public int rFf;
    public boolean rFg;
    public String rFh;
    public String rFi;
    public String rFj;
    public String rFk;
    public boolean rFl;
    public String rFm;
    public String rFn;
    public String rFo;
    public int rFp;
    public Bundle rFq;
    public String rFr;
    public MMAuthScopeRiskInfo rFs;
    int rFt;
    public String rFu;
    public String rFv;
    public MMUserPrivacyProtectInfo rFw;
    public int ror;
    
    static
    {
      AppMethodBeat.i(46042);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46042);
    }
    
    public AuthorizeTask()
    {
      this.rFw = MMUserPrivacyProtectInfo.rHk;
    }
    
    public AuthorizeTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46028);
      this.rFw = MMUserPrivacyProtectInfo.rHk;
      h(paramParcel);
      AppMethodBeat.o(46028);
    }
    
    private void ZJ(String paramString)
    {
      AppMethodBeat.i(46031);
      if (TextUtils.isEmpty(paramString)) {
        this.rEY.b(this.rEZ, this.ror, "fail auth cancel");
      }
      for (;;)
      {
        this.rFa.onAuthResult();
        AppMethodBeat.o(46031);
        return;
        this.rEY.b(this.rEZ, this.ror, paramString);
      }
    }
    
    public final void asn()
    {
      AppMethodBeat.i(46029);
      JsApiAuthorize.AuthorizeTask.a local3 = new JsApiAuthorize.AuthorizeTask.a()
      {
        public final void a(MMAuthScopeRiskInfo paramAnonymousMMAuthScopeRiskInfo)
        {
          AppMethodBeat.i(326757);
          Log.d("MicroMsg.JsApiAuthorize", "onScopeRiskIntercepted !");
          JsApiAuthorize.AuthorizeTask.this.rFe = "risk_intercepted";
          JsApiAuthorize.AuthorizeTask.this.rFs = paramAnonymousMMAuthScopeRiskInfo;
          JsApiAuthorize.AuthorizeTask.b(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(326757);
        }
        
        public final void au(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(326765);
          Log.e("MicroMsg.JsApiAuthorize", "onFailure !");
          JsApiAuthorize.AuthorizeTask.this.rFe = "fail";
          JsApiAuthorize.AuthorizeTask.this.errCode = paramAnonymousInt;
          JsApiAuthorize.AuthorizeTask.this.errMsg = paramAnonymousString;
          JsApiAuthorize.AuthorizeTask.c(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(326765);
        }
        
        public final void b(deb paramAnonymousdeb)
        {
          AppMethodBeat.i(326773);
          Log.d("MicroMsg.JsApiAuthorize", "onConfirm !");
          Object localObject1 = paramAnonymousdeb.aans;
          JsApiAuthorize.AuthorizeTask.this.rFp = ((LinkedList)localObject1).size();
          int i = 0;
          Object localObject2;
          while (i < JsApiAuthorize.AuthorizeTask.this.rFp)
          {
            localObject2 = (eul)((LinkedList)localObject1).get(i);
            try
            {
              JsApiAuthorize.AuthorizeTask.this.rFq.putByteArray(String.valueOf(i), ((eul)localObject2).toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousdeb)
            {
              Log.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { paramAnonymousdeb.getMessage() });
              Log.printErrStackTrace("MicroMsg.JsApiAuthorize", paramAnonymousdeb, "", new Object[0]);
              JsApiAuthorize.AuthorizeTask.this.rFe = "fail";
              JsApiAuthorize.AuthorizeTask.d(JsApiAuthorize.AuthorizeTask.this);
              AppMethodBeat.o(326773);
              return;
            }
          }
          JsApiAuthorize.AuthorizeTask.this.mAppName = paramAnonymousdeb.IKJ;
          JsApiAuthorize.AuthorizeTask.this.rFh = paramAnonymousdeb.YDL;
          JsApiAuthorize.AuthorizeTask.this.rFi = paramAnonymousdeb.aaJD;
          JsApiAuthorize.AuthorizeTask.this.rFk = paramAnonymousdeb.aaJC;
          JsApiAuthorize.AuthorizeTask.this.rFj = paramAnonymousdeb.aaJB;
          if (paramAnonymousdeb.aaAr != null)
          {
            JsApiAuthorize.AuthorizeTask.this.rFl = paramAnonymousdeb.aaAr.YGH;
            JsApiAuthorize.AuthorizeTask.this.rFm = paramAnonymousdeb.aaAr.YGI;
          }
          if (paramAnonymousdeb.aaAs != null) {
            JsApiAuthorize.AuthorizeTask.this.rFw = new MMUserPrivacyProtectInfo(paramAnonymousdeb.aaAs);
          }
          JsApiAuthorize.AuthorizeTask.this.rFe = "needConfirm";
          if (((LinkedList)localObject1).size() > 0)
          {
            localObject1 = (eul)((LinkedList)localObject1).get(0);
            localObject2 = JsApiAuthorize.AuthorizeTask.this;
            if (((eul)localObject1).abxn == null)
            {
              paramAnonymousdeb = "";
              ((JsApiAuthorize.AuthorizeTask)localObject2).rFr = paramAnonymousdeb;
              if (!"scope.userInfo".equals(((eul)localObject1).YVX)) {
                break label396;
              }
              JsApiAuthorize.AuthorizeTask.this.rFo = z.bAO();
              localObject1 = new StringBuilder("userNickName=");
              if (JsApiAuthorize.AuthorizeTask.this.rFo != null) {
                break label385;
              }
            }
            label385:
            for (paramAnonymousdeb = "";; paramAnonymousdeb = JsApiAuthorize.AuthorizeTask.this.rFo)
            {
              Log.i("MicroMsg.JsApiAuthorize", paramAnonymousdeb);
              paramAnonymousdeb = z.bAM();
              localObject1 = h.rET;
              h.a.a(paramAnonymousdeb, new h.b()
              {
                public final void onCallback(String paramAnonymous2String)
                {
                  AppMethodBeat.i(326833);
                  JsApiAuthorize.AuthorizeTask.this.rFn = paramAnonymous2String;
                  StringBuilder localStringBuilder = new StringBuilder(" userHeadIconPath=");
                  if (JsApiAuthorize.AuthorizeTask.this.rFn == null) {}
                  for (paramAnonymous2String = "";; paramAnonymous2String = JsApiAuthorize.AuthorizeTask.this.rFn)
                  {
                    Log.i("MicroMsg.JsApiAuthorize", paramAnonymous2String);
                    JsApiAuthorize.AuthorizeTask.e(JsApiAuthorize.AuthorizeTask.this);
                    AppMethodBeat.o(326833);
                    return;
                  }
                }
              });
              AppMethodBeat.o(326773);
              return;
              paramAnonymousdeb = ((eul)localObject1).abxn;
              break;
            }
            label396:
            JsApiAuthorize.AuthorizeTask.f(JsApiAuthorize.AuthorizeTask.this);
            AppMethodBeat.o(326773);
            return;
          }
          JsApiAuthorize.AuthorizeTask.g(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(326773);
        }
        
        public final void onSuccess()
        {
          AppMethodBeat.i(326752);
          Log.d("MicroMsg.JsApiAuthorize", "onSuccess !");
          JsApiAuthorize.AuthorizeTask.this.rFe = "ok";
          JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(326752);
        }
      };
      Object localObject2;
      Object localObject3;
      int i;
      label156:
      Object localObject1;
      if (this.rFc.equals("authorize"))
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
            break label156;
          }
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[] { localException.getMessage() });
          this.rFe = "fail";
          cpA();
          AppMethodBeat.o(46029);
          return;
        }
        this.rFu = ((String)((LinkedList)localObject3).get(0));
        localObject1 = new com.tencent.mm.ac.a.a(this.appId, this.rFd, (LinkedList)localObject3, this.euz, this.rAv, new JsApiAuthorize.AuthorizeTask.7(this, localException));
        if (((com.tencent.mm.ac.a.a)localObject1).aYZ().aaJv == null) {
          ((com.tencent.mm.ac.a.a)localObject1).aYZ().aaJv = new glg();
        }
        ((com.tencent.mm.ac.a.a)localObject1).aYZ().aaJv.acgQ = this.rFt;
        com.tencent.mm.kernel.h.aZW().a((p)localObject1, 0);
        AppMethodBeat.o(46029);
        return;
      }
      if (this.rFc.equals("authorizeConfirm"))
      {
        localObject2 = this.appId;
        localObject3 = this.rFb;
        i = this.euz;
        int j = this.rFf;
        boolean bool = this.rFg;
        localObject1 = new com.tencent.mm.ac.a.b((String)localObject2, j.E((ArrayList)localObject3), i, j, this.rAv, new JsApiAuthorize.AuthorizeTask..ExternalSyntheticLambda0((JsApiAuthorize.AuthorizeTask.a)localObject1, j));
        if (((com.tencent.mm.ac.a.b)localObject1).aZb().aaJv == null) {
          ((com.tencent.mm.ac.a.b)localObject1).aZb().aaJv = new glg();
        }
        ((com.tencent.mm.ac.a.b)localObject1).aZb().aaJv.acgQ = this.rFt;
        localObject2 = (ddy)c.b.b(((com.tencent.mm.ac.a.b)localObject1).rr.otB);
        if (localObject2 != null) {
          ((ddy)localObject2).aaJw = bool;
        }
        com.tencent.mm.kernel.h.aZW().a((p)localObject1, 0);
      }
      AppMethodBeat.o(46029);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(46030);
      if (!this.rEZ.isRunning())
      {
        this.rFa.onAuthResult();
        AppMethodBeat.o(46030);
        return;
      }
      if (this.rFe.equals("ok"))
      {
        if ((this.rFu != null) && (!Util.isNullOrNil(this.rFv)) && (!this.rFu.equals(this.rFv)))
        {
          Log.i("MicroMsg.JsApiAuthorize", "targetScope:%s, selectScope:%s", new Object[] { this.rFu, this.rFv });
          this.rEY.b(this.rEZ, this.ror, "fail auth deny");
        }
        for (;;)
        {
          this.rFa.onAuthResult();
          AppMethodBeat.o(46030);
          return;
          this.rEY.b(this.rEZ, this.ror, "ok");
        }
      }
      Object localObject;
      if (this.rFe.equals("fail"))
      {
        if (Util.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.rEY.b(this.rEZ, this.ror, (String)localObject);
          this.rFa.onAuthResult();
          AppMethodBeat.o(46030);
          return;
        }
      }
      if (this.rFe.equals("risk_intercepted"))
      {
        if (this.rFs != null) {
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(326747);
              i.a(JsApiAuthorize.AuthorizeTask.this.rEZ.getContext(), JsApiAuthorize.AuthorizeTask.this.rFs.wording, JsApiAuthorize.AuthorizeTask.this.rFs.right_button_wording, JsApiAuthorize.AuthorizeTask.this.rFs.rGU, i.b.a(JsApiAuthorize.AuthorizeTask.this.rEZ.getContext(), JsApiAuthorize.AuthorizeTask.this.rFs), new DialogInterface.OnDismissListener()
              {
                public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(326736);
                  JsApiAuthorize.AuthorizeTask.this.rEY.b(JsApiAuthorize.AuthorizeTask.this.rEZ, JsApiAuthorize.AuthorizeTask.this.ror, "fail:risk intercepted");
                  AppMethodBeat.o(326736);
                }
              });
              AppMethodBeat.o(326747);
            }
          });
        }
        this.rFa.onAuthResult();
        AppMethodBeat.o(46030);
        return;
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
            Log.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { localIOException.getMessage() });
            Log.printErrStackTrace("MicroMsg.JsApiAuthorize", localIOException, "", new Object[0]);
            this.rEY.b(this.rEZ, this.ror, "fail:internal error scope error");
            this.rFa.onAuthResult();
            AppMethodBeat.o(46030);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.rEZ.V(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(326779);
              eul localeul = (eul)localIOException.get(0);
              final g localg = new g(localeul.YVX);
              AppBrandRuntime localAppBrandRuntime = JsApiAuthorize.AuthorizeTask.this.rEZ.getRuntime();
              boolean bool2 = r.a(localeul.YVX, localAppBrandRuntime.asG());
              final com.tencent.mm.plugin.appbrand.permission.a.b localb = b.b.a(JsApiAuthorize.AuthorizeTask.this.rEZ, new d.b()
              {
                public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2, boolean paramAnonymous2Boolean)
                {
                  AppMethodBeat.i(326804);
                  JsApiAuthorize.AuthorizeTask localAuthorizeTask = JsApiAuthorize.AuthorizeTask.this;
                  if (com.tencent.luggage.l.b.bb(paramAnonymous2ArrayList).size() > 0)
                  {
                    paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);
                    localAuthorizeTask.rFv = paramAnonymous2ArrayList;
                    switch (paramAnonymous2Int1)
                    {
                    }
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(326804);
                    return;
                    paramAnonymous2ArrayList = "";
                    break;
                    paramAnonymous2ArrayList = new ArrayList();
                    paramAnonymous2ArrayList.add(JsApiAuthorize.AuthorizeTask.this.rFv);
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 1, paramAnonymous2ArrayList, paramAnonymous2Boolean);
                    localg.n(paramAnonymous2Boolean, 0);
                    Log.i("MicroMsg.JsApiAuthorize", "click PositiveButton");
                    AppMethodBeat.o(326804);
                    return;
                    paramAnonymous2ArrayList = new ArrayList();
                    paramAnonymous2ArrayList.add(JsApiAuthorize.AuthorizeTask.this.rFv);
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 2, paramAnonymous2ArrayList, paramAnonymous2Boolean);
                    localg.n(paramAnonymous2Boolean, 1);
                    Log.i("MicroMsg.JsApiAuthorize", "click NegativeButton");
                    AppMethodBeat.o(326804);
                    return;
                    JsApiAuthorize.AuthorizeTask.h(JsApiAuthorize.AuthorizeTask.this);
                    localg.n(paramAnonymous2Boolean, 2);
                    Log.i("MicroMsg.JsApiAuthorize", "user cancel");
                  }
                }
              }, localIOException);
              localb.setAppBrandName(localAppBrandRuntime.asG().hEy);
              localb.setApplyWording(JsApiAuthorize.AuthorizeTask.this.rFi);
              localb.setRequestDesc(localeul.IGG);
              localb.setNegativeButtonText(JsApiAuthorize.AuthorizeTask.this.rFj);
              localb.setPositiveButtonText(JsApiAuthorize.AuthorizeTask.this.rFk);
              localb.setIconUrl(JsApiAuthorize.AuthorizeTask.this.rFh);
              localb.setIExternalToolsHelper((aj)JsApiAuthorize.AuthorizeTask.this.rEZ.T(aj.class));
              if ((localAppBrandRuntime instanceof w)) {}
              for (boolean bool1 = ((w)localAppBrandRuntime).getInitConfig().qAT.isEnable();; bool1 = false)
              {
                if ((!bool1) && (JsApiAuthorize.AuthorizeTask.this.rFl) && (!TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.rFm)))
                {
                  localb.kb(true);
                  localb.setExplainOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(326799);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.cH(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$5$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                      localb.a(JsApiAuthorize.AuthorizeTask.this.rEZ, JsApiAuthorize.AuthorizeTask.this.rFm, (aj)JsApiAuthorize.AuthorizeTask.this.rEZ.T(aj.class)).h(JsApiAuthorize.AuthorizeTask.this.rEZ);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$5$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(326799);
                    }
                  });
                  if (!"scope.userInfo".equals(localeul.YVX)) {
                    break label472;
                  }
                  f.c.a(h.rET, JsApiAuthorize.AuthorizeTask.this.rEZ.getContext(), AvatarStorage.LL(JsApiAuthorize.AuthorizeTask.this.rFn), JsApiAuthorize.AuthorizeTask.this.rFo, localeul.YVX, localb);
                  label317:
                  if (TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.rFr)) {
                    break label646;
                  }
                  localb.setSimpleDetailDesc(JsApiAuthorize.AuthorizeTask.this.rFr);
                }
                for (;;)
                {
                  if (JsApiAuthorize.AuthorizeTask.this.rFw.cqt())
                  {
                    localb.setUserAgreementCheckBoxWording(JsApiAuthorize.AuthorizeTask.this.rFw.wording);
                    localg.rER = true;
                    localb.setUserAgreementCheckedAlertListener(new JsApiAuthorize.AuthorizeTask.5..ExternalSyntheticLambda0(localg));
                  }
                  Log.i("MicroMsg.JsApiAuthorize", "Confirm dialog scope=%s desc =%s auth_desc=%s ext_desc=%s", new Object[] { localeul.YVX, localeul.IGG, localeul.auth_desc, localeul.tIs });
                  localb.h(JsApiAuthorize.AuthorizeTask.this.rEZ);
                  AppMethodBeat.o(326779);
                  return;
                  localb.kb(false);
                  break;
                  label472:
                  if (localIOException.size() > 1)
                  {
                    ArrayList localArrayList = new ArrayList();
                    localArrayList.add(new k.a(((eul)localIOException.get(0)).YJg, ((eul)localIOException.get(0)).YVX, true));
                    int i = 1;
                    while (i < localIOException.size())
                    {
                      localArrayList.add(new k.a(((eul)localIOException.get(i)).YJg, ((eul)localIOException.get(i)).YVX, false));
                      i += 1;
                    }
                    localb.setFunctionButtonVisibility(8);
                    localb.setSelectListItem(localArrayList);
                    localb.setScope("");
                    break label317;
                  }
                  localb.setScope(localeul.YVX);
                  break label317;
                  label646:
                  if (bool2)
                  {
                    if (TextUtils.isEmpty(r.a(localeul.YVX, localAppBrandRuntime)))
                    {
                      JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, "fail:require permission desc");
                      Log.i("MicroMsg.JsApiAuthorize", "error = fail:require permission desc");
                      AppMethodBeat.o(326779);
                      return;
                    }
                    localb.setSimpleDetailDesc(r.a(localeul.YVX, localAppBrandRuntime));
                  }
                }
              }
            }
          });
          AppMethodBeat.o(46030);
          return;
        }
        this.rEY.b(this.rEZ, this.ror, "fail:internal error scope empty");
        this.rFa.onAuthResult();
      }
      AppMethodBeat.o(46030);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46032);
      this.data = paramParcel.readString();
      this.ror = paramParcel.readInt();
      this.appId = paramParcel.readString();
      int i = paramParcel.readInt();
      byte[] arrayOfByte;
      if (i > 0)
      {
        this.rFd = new gma();
        arrayOfByte = new byte[i];
        paramParcel.readByteArray(arrayOfByte);
      }
      for (;;)
      {
        try
        {
          this.rFd.parseFrom(arrayOfByte);
          this.rFe = paramParcel.readString();
          this.rFc = paramParcel.readString();
          this.mAppName = paramParcel.readString();
          this.rFh = paramParcel.readString();
          this.rFp = paramParcel.readInt();
          this.rFq = paramParcel.readBundle(JsApiAuthorize.class.getClassLoader());
          this.rFb = paramParcel.createStringArrayList();
          this.euz = paramParcel.readInt();
          this.rFf = paramParcel.readInt();
          this.rAv = paramParcel.readInt();
          this.rFt = paramParcel.readInt();
          this.errCode = paramParcel.readInt();
          this.errMsg = paramParcel.readString();
          this.rFk = paramParcel.readString();
          this.rFj = paramParcel.readString();
          this.rFi = paramParcel.readString();
          this.rFn = paramParcel.readString();
          this.rFo = paramParcel.readString();
          if (paramParcel.readInt() != 1) {
            break label352;
          }
          bool1 = true;
          this.rFl = bool1;
          this.rFm = paramParcel.readString();
          this.rFr = paramParcel.readString();
          this.rFs = ((MMAuthScopeRiskInfo)paramParcel.readParcelable(MMAuthScopeRiskInfo.class.getClassLoader()));
          this.rFu = paramParcel.readString();
          this.rFv = paramParcel.readString();
          this.rFw = ((MMUserPrivacyProtectInfo)paramParcel.readParcelable(MMUserPrivacyProtectInfo.class.getClassLoader()));
          if (paramParcel.readInt() != 1) {
            break label357;
          }
          bool1 = bool2;
          this.rFg = bool1;
          AppMethodBeat.o(46032);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.JsApiAuthorize", "AuthorizeTask parse wxaPluginAppInfo get exception:%s", new Object[] { localException });
        }
        this.rFd = null;
        continue;
        label352:
        boolean bool1 = false;
        continue;
        label357:
        bool1 = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int j = 1;
      AppMethodBeat.i(46033);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.ror);
      paramParcel.writeString(this.appId);
      if (this.rFd != null) {}
      for (;;)
      {
        try
        {
          byte[] arrayOfByte1 = this.rFd.toByteArray();
          paramParcel.writeInt(arrayOfByte1.length);
          if (arrayOfByte1.length > 0) {
            paramParcel.writeByteArray(arrayOfByte1);
          }
          paramParcel.writeString(this.rFe);
          paramParcel.writeString(this.rFc);
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
          paramParcel.writeString(this.rFk);
          paramParcel.writeString(this.rFj);
          paramParcel.writeString(this.rFi);
          paramParcel.writeString(this.rFn);
          paramParcel.writeString(this.rFo);
          if (!this.rFl) {
            break label333;
          }
          i = 1;
          paramParcel.writeInt(i);
          paramParcel.writeString(this.rFm);
          paramParcel.writeString(this.rFr);
          paramParcel.writeParcelable(this.rFs, paramInt);
          paramParcel.writeString(this.rFu);
          paramParcel.writeString(this.rFv);
          paramParcel.writeParcelable(this.rFw, paramInt);
          if (!this.rFg) {
            break label338;
          }
          paramInt = j;
          paramParcel.writeInt(paramInt);
          AppMethodBeat.o(46033);
          return;
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.JsApiAuthorize", "AuthorizeTask writeToParcel wxaPluginAppInfo.toByteArray get exception:%s", new Object[] { localIOException });
          byte[] arrayOfByte2 = new byte[0];
          continue;
        }
        paramParcel.writeInt(0);
        continue;
        label333:
        int i = 0;
        continue;
        label338:
        paramInt = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize
 * JD-Core Version:    0.7.0.1
 */