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
import com.tencent.mm.am.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.permission.a.b.b;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.a;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.protocal.protobuf.foh;
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
  private final k oBn;
  
  public JsApiAuthorize()
  {
    AppMethodBeat.i(174773);
    this.oBn = new k();
    AppMethodBeat.o(174773);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.g paramg, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(278642);
    Log.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
    AuthorizeTask localAuthorizeTask = new AuthorizeTask();
    localAuthorizeTask.appId = paramg.getAppId();
    localAuthorizeTask.oBs = "authorize";
    Object localObject = paramg.getRuntime().Sp();
    if (localObject != null) {
      localAuthorizeTask.cBU = ((l)localObject).nYR.nHY;
    }
    localObject = d.abC(paramg.getAppId());
    if (localObject != null) {
      AuthorizeTask.a(localAuthorizeTask, ((AppBrandStatObject)localObject).scene);
    }
    paramJSONObject = paramJSONObject.toString();
    localAuthorizeTask.oBo = this;
    localAuthorizeTask.oBp = paramg;
    localAuthorizeTask.data = paramJSONObject;
    localAuthorizeTask.okO = paramInt;
    localAuthorizeTask.oBq = new JsApiAuthorize.AuthorizeTask.1(localAuthorizeTask, parame);
    localAuthorizeTask.oBE = new Bundle();
    if ((paramg instanceof v)) {
      localAuthorizeTask.oBH = 1;
    }
    for (;;)
    {
      paramg.getRuntime().keep(new JsApiAuthorize.AuthorizeTask.2(localAuthorizeTask));
      localAuthorizeTask.bsM();
      AppMethodBeat.o(278642);
      return;
      if ((paramg instanceof ad)) {
        localAuthorizeTask.oBH = 2;
      }
    }
  }
  
  static class AuthorizeTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AuthorizeTask> CREATOR;
    public String appId;
    public int cBU;
    public String data;
    public int errCode;
    public String errMsg;
    public String mAppName;
    public String oBA;
    public String oBB;
    public String oBC;
    public int oBD;
    public Bundle oBE;
    public String oBF;
    public MMAuthScopeRiskInfo oBG;
    int oBH;
    public String oBI;
    public String oBJ;
    transient i oBo;
    transient com.tencent.mm.plugin.appbrand.g oBp;
    transient e oBq;
    public ArrayList<String> oBr;
    public String oBs;
    public String oBt;
    public int oBu;
    public String oBv;
    public String oBw;
    public String oBx;
    public String oBy;
    public boolean oBz;
    public int okO;
    private int owU;
    
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
    
    private void agN(String paramString)
    {
      AppMethodBeat.i(46031);
      if (TextUtils.isEmpty(paramString)) {
        this.oBo.b(this.oBp, this.okO, "fail auth cancel");
      }
      for (;;)
      {
        this.oBq.bQe();
        AppMethodBeat.o(46031);
        return;
        this.oBo.b(this.oBp, this.okO, paramString);
      }
    }
    
    public final void RW()
    {
      AppMethodBeat.i(46029);
      JsApiAuthorize.AuthorizeTask.a local3 = new JsApiAuthorize.AuthorizeTask.a()
      {
        public final void a(MMAuthScopeRiskInfo paramAnonymousMMAuthScopeRiskInfo)
        {
          AppMethodBeat.i(277218);
          Log.d("MicroMsg.JsApiAuthorize", "onScopeRiskIntercepted !");
          JsApiAuthorize.AuthorizeTask.this.oBt = "risk_intercepted";
          JsApiAuthorize.AuthorizeTask.this.oBG = paramAnonymousMMAuthScopeRiskInfo;
          JsApiAuthorize.AuthorizeTask.b(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(277218);
        }
        
        public final void a(cnj paramAnonymouscnj)
        {
          AppMethodBeat.i(277220);
          Log.d("MicroMsg.JsApiAuthorize", "onConfirm !");
          Object localObject1 = paramAnonymouscnj.Tau;
          JsApiAuthorize.AuthorizeTask.this.oBD = ((LinkedList)localObject1).size();
          int i = 0;
          Object localObject2;
          while (i < JsApiAuthorize.AuthorizeTask.this.oBD)
          {
            localObject2 = (eax)((LinkedList)localObject1).get(i);
            try
            {
              JsApiAuthorize.AuthorizeTask.this.oBE.putByteArray(String.valueOf(i), ((eax)localObject2).toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymouscnj)
            {
              Log.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { paramAnonymouscnj.getMessage() });
              Log.printErrStackTrace("MicroMsg.JsApiAuthorize", paramAnonymouscnj, "", new Object[0]);
              JsApiAuthorize.AuthorizeTask.this.oBt = "fail";
              JsApiAuthorize.AuthorizeTask.d(JsApiAuthorize.AuthorizeTask.this);
              AppMethodBeat.o(277220);
              return;
            }
          }
          JsApiAuthorize.AuthorizeTask.this.mAppName = paramAnonymouscnj.CQz;
          JsApiAuthorize.AuthorizeTask.this.oBv = paramAnonymouscnj.RGJ;
          JsApiAuthorize.AuthorizeTask.this.oBw = paramAnonymouscnj.TuW;
          JsApiAuthorize.AuthorizeTask.this.oBy = paramAnonymouscnj.TuV;
          JsApiAuthorize.AuthorizeTask.this.oBx = paramAnonymouscnj.TuU;
          if (paramAnonymouscnj.TuX != null)
          {
            JsApiAuthorize.AuthorizeTask.this.oBz = paramAnonymouscnj.TuX.RJo;
            JsApiAuthorize.AuthorizeTask.this.oBA = paramAnonymouscnj.TuX.RJp;
          }
          JsApiAuthorize.AuthorizeTask.this.oBt = "needConfirm";
          if (((LinkedList)localObject1).size() > 0)
          {
            localObject1 = (eax)((LinkedList)localObject1).get(0);
            localObject2 = JsApiAuthorize.AuthorizeTask.this;
            if (((eax)localObject1).UfS == null)
            {
              paramAnonymouscnj = "";
              ((JsApiAuthorize.AuthorizeTask)localObject2).oBF = paramAnonymouscnj;
              if (!"scope.userInfo".equals(((eax)localObject1).RXY)) {
                break label371;
              }
              JsApiAuthorize.AuthorizeTask.this.oBC = z.bdb();
              localObject1 = new StringBuilder("userNickName=");
              if (JsApiAuthorize.AuthorizeTask.this.oBC != null) {
                break label360;
              }
            }
            label360:
            for (paramAnonymouscnj = "";; paramAnonymouscnj = JsApiAuthorize.AuthorizeTask.this.oBC)
            {
              Log.i("MicroMsg.JsApiAuthorize", paramAnonymouscnj);
              paramAnonymouscnj = z.bcZ();
              localObject1 = g.oBe;
              g.a.a(paramAnonymouscnj, new g.b()
              {
                public final void acs(String paramAnonymous2String)
                {
                  AppMethodBeat.i(271529);
                  JsApiAuthorize.AuthorizeTask.this.oBB = paramAnonymous2String;
                  StringBuilder localStringBuilder = new StringBuilder(" userHeadIconPath=");
                  if (JsApiAuthorize.AuthorizeTask.this.oBB == null) {}
                  for (paramAnonymous2String = "";; paramAnonymous2String = JsApiAuthorize.AuthorizeTask.this.oBB)
                  {
                    Log.i("MicroMsg.JsApiAuthorize", paramAnonymous2String);
                    JsApiAuthorize.AuthorizeTask.e(JsApiAuthorize.AuthorizeTask.this);
                    AppMethodBeat.o(271529);
                    return;
                  }
                }
              });
              AppMethodBeat.o(277220);
              return;
              paramAnonymouscnj = ((eax)localObject1).UfS;
              break;
            }
            label371:
            JsApiAuthorize.AuthorizeTask.f(JsApiAuthorize.AuthorizeTask.this);
            AppMethodBeat.o(277220);
            return;
          }
          JsApiAuthorize.AuthorizeTask.g(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(277220);
        }
        
        public final void ak(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(277219);
          Log.e("MicroMsg.JsApiAuthorize", "onFailure !");
          JsApiAuthorize.AuthorizeTask.this.oBt = "fail";
          JsApiAuthorize.AuthorizeTask.this.errCode = paramAnonymousInt;
          JsApiAuthorize.AuthorizeTask.this.errMsg = paramAnonymousString;
          JsApiAuthorize.AuthorizeTask.c(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(277219);
        }
        
        public final void onSuccess()
        {
          AppMethodBeat.i(277216);
          Log.d("MicroMsg.JsApiAuthorize", "onSuccess !");
          JsApiAuthorize.AuthorizeTask.this.oBt = "ok";
          JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(277216);
        }
      };
      Object localObject2;
      Object localObject3;
      int i;
      label147:
      Object localObject1;
      if (this.oBs.equals("authorize"))
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
          this.oBt = "fail";
          bPt();
          AppMethodBeat.o(46029);
          return;
        }
        this.oBI = ((String)((LinkedList)localObject3).get(0));
        localObject1 = new com.tencent.mm.ac.a.a(this.appId, (LinkedList)localObject3, this.cBU, this.owU, new JsApiAuthorize.AuthorizeTask.7(this, localException));
        if (((com.tencent.mm.ac.a.a)localObject1).aGa().TuQ == null) {
          ((com.tencent.mm.ac.a.a)localObject1).aGa().TuQ = new foh();
        }
        ((com.tencent.mm.ac.a.a)localObject1).aGa().TuQ.UMw = this.oBH;
        com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
        AppMethodBeat.o(46029);
        return;
      }
      if (this.oBs.equals("authorizeConfirm"))
      {
        localObject2 = this.appId;
        localObject3 = this.oBr;
        i = this.cBU;
        int j = this.oBu;
        localObject1 = new com.tencent.mm.ac.a.b((String)localObject2, i.B((ArrayList)localObject3), i, j, this.owU, new JsApiAuthorize.AuthorizeTask.8(this, (JsApiAuthorize.AuthorizeTask.a)localObject1, j));
        if (((com.tencent.mm.ac.a.b)localObject1).aGc().TuQ == null) {
          ((com.tencent.mm.ac.a.b)localObject1).aGc().TuQ = new foh();
        }
        ((com.tencent.mm.ac.a.b)localObject1).aGc().TuQ.UMw = this.oBH;
        com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
      }
      AppMethodBeat.o(46029);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(46030);
      if (!this.oBp.isRunning())
      {
        this.oBq.bQe();
        AppMethodBeat.o(46030);
        return;
      }
      if (this.oBt.equals("ok"))
      {
        if ((this.oBI != null) && (!Util.isNullOrNil(this.oBJ)) && (!this.oBI.equals(this.oBJ)))
        {
          Log.i("MicroMsg.JsApiAuthorize", "targetScope:%s, selectScope:%s", new Object[] { this.oBI, this.oBJ });
          this.oBo.b(this.oBp, this.okO, "fail auth deny");
        }
        for (;;)
        {
          this.oBq.bQe();
          AppMethodBeat.o(46030);
          return;
          this.oBo.b(this.oBp, this.okO, "ok");
        }
      }
      Object localObject;
      if (this.oBt.equals("fail"))
      {
        if (Util.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.oBo.b(this.oBp, this.okO, (String)localObject);
          this.oBq.bQe();
          AppMethodBeat.o(46030);
          return;
        }
      }
      if (this.oBt.equals("risk_intercepted"))
      {
        if (this.oBG != null) {
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(271593);
              h.a(JsApiAuthorize.AuthorizeTask.this.oBp.getContext(), JsApiAuthorize.AuthorizeTask.this.oBG.wording, JsApiAuthorize.AuthorizeTask.this.oBG.oDK, JsApiAuthorize.AuthorizeTask.this.oBG.oDJ, h.b.a(JsApiAuthorize.AuthorizeTask.this.oBp.getContext(), JsApiAuthorize.AuthorizeTask.this.oBG), new DialogInterface.OnDismissListener()
              {
                public final void onDismiss(DialogInterface paramAnonymous2DialogInterface)
                {
                  AppMethodBeat.i(274428);
                  JsApiAuthorize.AuthorizeTask.this.oBo.b(JsApiAuthorize.AuthorizeTask.this.oBp, JsApiAuthorize.AuthorizeTask.this.okO, "fail:risk intercepted");
                  AppMethodBeat.o(274428);
                }
              });
              AppMethodBeat.o(271593);
            }
          });
        }
        this.oBq.bQe();
        AppMethodBeat.o(46030);
        return;
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
            Log.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { localIOException.getMessage() });
            Log.printErrStackTrace("MicroMsg.JsApiAuthorize", localIOException, "", new Object[0]);
            this.oBo.b(this.oBp, this.okO, "fail:internal error scope error");
            this.oBq.bQe();
            AppMethodBeat.o(46030);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.oBp.P(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(256256);
              eax localeax = (eax)localIOException.get(0);
              AppBrandRuntime localAppBrandRuntime = JsApiAuthorize.AuthorizeTask.this.oBp.getRuntime();
              boolean bool2 = com.tencent.mm.plugin.appbrand.permission.q.a(localeax.RXY, localAppBrandRuntime.Sp());
              final com.tencent.mm.plugin.appbrand.permission.a.b localb = b.b.a(JsApiAuthorize.AuthorizeTask.this.oBp, new com.tencent.mm.plugin.appbrand.widget.dialog.g.b()
              {
                public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(242517);
                  JsApiAuthorize.AuthorizeTask localAuthorizeTask = JsApiAuthorize.AuthorizeTask.this;
                  if (com.tencent.luggage.k.b.D(paramAnonymous2ArrayList).size() > 0)
                  {
                    paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);
                    localAuthorizeTask.oBJ = paramAnonymous2ArrayList;
                    switch (paramAnonymous2Int1)
                    {
                    }
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(242517);
                    return;
                    paramAnonymous2ArrayList = "";
                    break;
                    paramAnonymous2ArrayList = new ArrayList();
                    paramAnonymous2ArrayList.add(JsApiAuthorize.AuthorizeTask.this.oBJ);
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 1, paramAnonymous2ArrayList);
                    Log.i("MicroMsg.JsApiAuthorize", "click PositiveButton");
                    AppMethodBeat.o(242517);
                    return;
                    paramAnonymous2ArrayList = new ArrayList();
                    paramAnonymous2ArrayList.add(JsApiAuthorize.AuthorizeTask.this.oBJ);
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 2, paramAnonymous2ArrayList);
                    Log.i("MicroMsg.JsApiAuthorize", "click NegativeButton");
                    AppMethodBeat.o(242517);
                    return;
                    JsApiAuthorize.AuthorizeTask.h(JsApiAuthorize.AuthorizeTask.this);
                    Log.i("MicroMsg.JsApiAuthorize", "user cancel");
                  }
                }
              });
              localb.setAppBrandName(localAppBrandRuntime.Sp().fzM);
              localb.setApplyWording(JsApiAuthorize.AuthorizeTask.this.oBw);
              localb.setRequestDesc(localeax.CMB);
              localb.setNegativeButtonText(JsApiAuthorize.AuthorizeTask.this.oBx);
              localb.setPositiveButtonText(JsApiAuthorize.AuthorizeTask.this.oBy);
              localb.setIconUrl(JsApiAuthorize.AuthorizeTask.this.oBv);
              if ((localAppBrandRuntime instanceof com.tencent.mm.plugin.appbrand.t)) {}
              for (boolean bool1 = ((com.tencent.mm.plugin.appbrand.t)localAppBrandRuntime).bDy().nBE.isEnable();; bool1 = false)
              {
                Object localObject;
                if ((!bool1) && (JsApiAuthorize.AuthorizeTask.this.oBz) && (!TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.oBA)))
                {
                  localb.iU(true);
                  localb.setExplainOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(281972);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.bn(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$5$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                      localb.a(JsApiAuthorize.AuthorizeTask.this.oBp, JsApiAuthorize.AuthorizeTask.this.oBA, (ag)JsApiAuthorize.AuthorizeTask.this.oBp.K(ag.class)).i(JsApiAuthorize.AuthorizeTask.this.oBp);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$5$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(281972);
                    }
                  });
                  if (!"scope.userInfo".equals(localeax.RXY)) {
                    break label360;
                  }
                  localObject = g.oBe;
                  localObject = JsApiAuthorize.AuthorizeTask.this.oBp.getContext();
                  Bitmap localBitmap = f.TL(JsApiAuthorize.AuthorizeTask.this.oBB);
                  String str1 = JsApiAuthorize.AuthorizeTask.this.oBC;
                  String str2 = localeax.RXY;
                  p.k(localObject, "context");
                  p.k(localb, "dialog");
                  f.c.a((Context)localObject, localBitmap, str1, str2, localb);
                }
                for (;;)
                {
                  if (bool2)
                  {
                    if (TextUtils.isEmpty(com.tencent.mm.plugin.appbrand.permission.q.a(localeax.RXY, localAppBrandRuntime)))
                    {
                      JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, "fail:require permission desc");
                      Log.i("MicroMsg.JsApiAuthorize", "error = fail:require permission desc");
                      AppMethodBeat.o(256256);
                      return;
                      localb.iU(false);
                      break;
                      label360:
                      if (localIOException.size() > 1)
                      {
                        localObject = new ArrayList();
                        ((List)localObject).add(new h.a(((eax)localIOException.get(0)).UfT, ((eax)localIOException.get(0)).RXY, true));
                        int i = 1;
                        while (i < localIOException.size())
                        {
                          ((List)localObject).add(new h.a(((eax)localIOException.get(i)).UfT, ((eax)localIOException.get(i)).RXY, false));
                          i += 1;
                        }
                        localb.setFunctionButtonVisibility(8);
                        localb.setSelectListItem((List)localObject);
                        localb.setScope("");
                        continue;
                      }
                      localb.setScope(localeax.RXY);
                      continue;
                    }
                    localb.setSimpleDetailDesc(com.tencent.mm.plugin.appbrand.permission.q.a(localeax.RXY, localAppBrandRuntime));
                  }
                }
                for (;;)
                {
                  Log.i("MicroMsg.JsApiAuthorize", "Confirm dialog scope=%s desc =%s auth_desc=%s ext_desc=%s", new Object[] { localeax.RXY, localeax.CMB, localeax.auth_desc, localeax.qDz });
                  localb.i(JsApiAuthorize.AuthorizeTask.this.oBp);
                  AppMethodBeat.o(256256);
                  return;
                  if (!TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.oBF)) {
                    localb.setSimpleDetailDesc(JsApiAuthorize.AuthorizeTask.this.oBF);
                  }
                }
              }
            }
          });
          AppMethodBeat.o(46030);
          return;
        }
        this.oBo.b(this.oBp, this.okO, "fail:internal error scope empty");
        this.oBq.bQe();
      }
      AppMethodBeat.o(46030);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46032);
      this.data = paramParcel.readString();
      this.okO = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.oBt = paramParcel.readString();
      this.oBs = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.oBv = paramParcel.readString();
      this.oBD = paramParcel.readInt();
      this.oBE = paramParcel.readBundle(JsApiAuthorize.class.getClassLoader());
      this.oBr = paramParcel.createStringArrayList();
      this.cBU = paramParcel.readInt();
      this.oBu = paramParcel.readInt();
      this.owU = paramParcel.readInt();
      this.oBH = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      this.oBy = paramParcel.readString();
      this.oBx = paramParcel.readString();
      this.oBw = paramParcel.readString();
      this.oBB = paramParcel.readString();
      this.oBC = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.oBz = bool;
        this.oBA = paramParcel.readString();
        this.oBF = paramParcel.readString();
        this.oBG = ((MMAuthScopeRiskInfo)paramParcel.readParcelable(MMAuthScopeRiskInfo.class.getClassLoader()));
        this.oBI = paramParcel.readString();
        this.oBJ = paramParcel.readString();
        AppMethodBeat.o(46032);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46033);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.okO);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.oBt);
      paramParcel.writeString(this.oBs);
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
      paramParcel.writeString(this.oBy);
      paramParcel.writeString(this.oBx);
      paramParcel.writeString(this.oBw);
      paramParcel.writeString(this.oBB);
      paramParcel.writeString(this.oBC);
      if (this.oBz) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeInt(i);
        paramParcel.writeString(this.oBA);
        paramParcel.writeString(this.oBF);
        paramParcel.writeParcelable(this.oBG, paramInt);
        paramParcel.writeString(this.oBI);
        paramParcel.writeString(this.oBJ);
        AppMethodBeat.o(46033);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize
 * JD-Core Version:    0.7.0.1
 */