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
import com.tencent.mm.ak.n;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize
  extends i
{
  private static final int CTRL_INDEX = 54;
  private static final String NAME = "authorize";
  private final k kBv;
  
  public JsApiAuthorize()
  {
    AppMethodBeat.i(174773);
    this.kBv = new k();
    AppMethodBeat.o(174773);
  }
  
  public final void a(d paramd, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(222418);
    ae.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
    AuthorizeTask localAuthorizeTask = new AuthorizeTask();
    localAuthorizeTask.appId = paramd.getAppId();
    localAuthorizeTask.kBA = "authorize";
    Object localObject = paramd.getRuntime().Fm();
    if (localObject != null) {
      localAuthorizeTask.hSZ = ((com.tencent.mm.plugin.appbrand.config.k)localObject).kbw.jLV;
    }
    localObject = com.tencent.mm.plugin.appbrand.a.KK(paramd.getAppId());
    if (localObject != null) {
      AuthorizeTask.a(localAuthorizeTask, ((AppBrandStatObject)localObject).scene);
    }
    paramJSONObject = paramJSONObject.toString();
    localAuthorizeTask.kBw = this;
    localAuthorizeTask.kBx = paramd;
    localAuthorizeTask.data = paramJSONObject;
    localAuthorizeTask.kmu = paramInt;
    localAuthorizeTask.kBy = parame;
    localAuthorizeTask.kBM = new Bundle();
    if ((paramd instanceof r)) {
      localAuthorizeTask.kBP = 1;
    }
    for (;;)
    {
      localAuthorizeTask.biw();
      AppBrandMainProcessService.a(localAuthorizeTask);
      AppMethodBeat.o(222418);
      return;
      if ((paramd instanceof z)) {
        localAuthorizeTask.kBP = 2;
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
    public int hSZ;
    public String kBA;
    public String kBB;
    public int kBC;
    public String kBD;
    public String kBE;
    public String kBF;
    public String kBG;
    public boolean kBH;
    public String kBI;
    public String kBJ;
    public String kBK;
    public int kBL;
    public Bundle kBM;
    public String kBN;
    public MMAuthScopeRiskInfo kBO;
    int kBP;
    transient i kBw;
    transient d kBx;
    transient e kBy;
    public ArrayList<String> kBz;
    public int kmu;
    private int kxr;
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
      e(paramParcel);
      AppMethodBeat.o(46028);
    }
    
    private void PL(String paramString)
    {
      AppMethodBeat.i(46031);
      if (TextUtils.isEmpty(paramString)) {
        this.kBw.b(this.kBx, this.kmu, "fail auth cancel");
      }
      for (;;)
      {
        this.kBy.bjq();
        AppMethodBeat.o(46031);
        return;
        this.kBw.b(this.kBx, this.kmu, paramString);
      }
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(46029);
      a local1 = new a()
      {
        public final void a(MMAuthScopeRiskInfo paramAnonymousMMAuthScopeRiskInfo)
        {
          AppMethodBeat.i(222406);
          ae.d("MicroMsg.JsApiAuthorize", "onScopeRiskIntercepted !");
          JsApiAuthorize.AuthorizeTask.this.kBB = "risk_intercepted";
          JsApiAuthorize.AuthorizeTask.this.kBO = paramAnonymousMMAuthScopeRiskInfo;
          JsApiAuthorize.AuthorizeTask.b(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(222406);
        }
        
        public final void a(brv paramAnonymousbrv)
        {
          AppMethodBeat.i(46021);
          ae.d("MicroMsg.JsApiAuthorize", "onConfirm !");
          Object localObject1 = paramAnonymousbrv.GNH;
          JsApiAuthorize.AuthorizeTask.this.kBL = ((LinkedList)localObject1).size();
          int i = 0;
          Object localObject2;
          while (i < JsApiAuthorize.AuthorizeTask.this.kBL)
          {
            localObject2 = (cyg)((LinkedList)localObject1).get(i);
            try
            {
              JsApiAuthorize.AuthorizeTask.this.kBM.putByteArray(String.valueOf(i), ((cyg)localObject2).toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousbrv)
            {
              ae.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { paramAnonymousbrv.getMessage() });
              ae.printErrStackTrace("MicroMsg.JsApiAuthorize", paramAnonymousbrv, "", new Object[0]);
              JsApiAuthorize.AuthorizeTask.this.kBB = "fail";
              JsApiAuthorize.AuthorizeTask.d(JsApiAuthorize.AuthorizeTask.this);
              AppMethodBeat.o(46021);
              return;
            }
          }
          JsApiAuthorize.AuthorizeTask.this.mAppName = paramAnonymousbrv.uuo;
          JsApiAuthorize.AuthorizeTask.this.kBD = paramAnonymousbrv.FLQ;
          JsApiAuthorize.AuthorizeTask.this.kBE = paramAnonymousbrv.HeY;
          JsApiAuthorize.AuthorizeTask.this.kBG = paramAnonymousbrv.HeX;
          JsApiAuthorize.AuthorizeTask.this.kBF = paramAnonymousbrv.HeW;
          if (paramAnonymousbrv.HeZ != null)
          {
            JsApiAuthorize.AuthorizeTask.this.kBH = paramAnonymousbrv.HeZ.FOn;
            JsApiAuthorize.AuthorizeTask.this.kBI = paramAnonymousbrv.HeZ.FOo;
          }
          JsApiAuthorize.AuthorizeTask.this.kBB = "needConfirm";
          if (((LinkedList)localObject1).size() > 0)
          {
            localObject1 = (cyg)((LinkedList)localObject1).get(0);
            localObject2 = JsApiAuthorize.AuthorizeTask.this;
            if (((cyg)localObject1).HIy == null)
            {
              paramAnonymousbrv = "";
              ((JsApiAuthorize.AuthorizeTask)localObject2).kBN = paramAnonymousbrv;
              if (!"scope.userInfo".equals(((cyg)localObject1).GcE)) {
                break label371;
              }
              JsApiAuthorize.AuthorizeTask.this.kBK = v.aAE();
              localObject1 = new StringBuilder("userNickName=");
              if (JsApiAuthorize.AuthorizeTask.this.kBK != null) {
                break label360;
              }
            }
            label360:
            for (paramAnonymousbrv = "";; paramAnonymousbrv = JsApiAuthorize.AuthorizeTask.this.kBK)
            {
              ae.i("MicroMsg.JsApiAuthorize", paramAnonymousbrv);
              paramAnonymousbrv = v.aAC();
              localObject1 = g.kBm;
              g.a.a(paramAnonymousbrv, new g.b()
              {
                public final void Lz(String paramAnonymous2String)
                {
                  AppMethodBeat.i(46018);
                  JsApiAuthorize.AuthorizeTask.this.kBJ = paramAnonymous2String;
                  StringBuilder localStringBuilder = new StringBuilder(" userHeadIconPath=");
                  if (JsApiAuthorize.AuthorizeTask.this.kBJ == null) {}
                  for (paramAnonymous2String = "";; paramAnonymous2String = JsApiAuthorize.AuthorizeTask.this.kBJ)
                  {
                    ae.i("MicroMsg.JsApiAuthorize", paramAnonymous2String);
                    JsApiAuthorize.AuthorizeTask.e(JsApiAuthorize.AuthorizeTask.this);
                    AppMethodBeat.o(46018);
                    return;
                  }
                }
              });
              AppMethodBeat.o(46021);
              return;
              paramAnonymousbrv = ((cyg)localObject1).HIy;
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
        
        public final void af(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46020);
          ae.e("MicroMsg.JsApiAuthorize", "onFailure !");
          JsApiAuthorize.AuthorizeTask.this.kBB = "fail";
          JsApiAuthorize.AuthorizeTask.this.errCode = paramAnonymousInt;
          JsApiAuthorize.AuthorizeTask.this.errMsg = paramAnonymousString;
          JsApiAuthorize.AuthorizeTask.c(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46020);
        }
        
        public final void onSuccess()
        {
          AppMethodBeat.i(46019);
          ae.d("MicroMsg.JsApiAuthorize", "onSuccess !");
          JsApiAuthorize.AuthorizeTask.this.kBB = "ok";
          JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46019);
        }
      };
      Object localObject2;
      Object localObject3;
      int i;
      Object localObject1;
      if (this.kBA.equals("authorize"))
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
          localObject1 = new com.tencent.mm.aa.a.a(this.appId, (LinkedList)localObject3, this.hSZ, this.kxr, new a.a() {});
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[] { localException.getMessage() });
          this.kBB = "fail";
          biG();
          AppMethodBeat.o(46029);
          return;
        }
        if (((com.tencent.mm.aa.a.a)localObject1).air().HeS == null) {
          ((com.tencent.mm.aa.a.a)localObject1).air().HeS = new eio();
        }
        ((com.tencent.mm.aa.a.a)localObject1).air().HeS.IlP = this.kBP;
        com.tencent.mm.kernel.g.ajj().a((n)localObject1, 0);
        AppMethodBeat.o(46029);
        return;
      }
      if (this.kBA.equals("authorizeConfirm"))
      {
        localObject2 = this.appId;
        localObject3 = this.kBz;
        i = this.hSZ;
        final int j = this.kBC;
        localObject1 = new com.tencent.mm.aa.a.b((String)localObject2, i.v((ArrayList)localObject3), i, j, this.kxr, new com.tencent.mm.aa.a.b.a() {});
        if (((com.tencent.mm.aa.a.b)localObject1).ait().HeS == null) {
          ((com.tencent.mm.aa.a.b)localObject1).ait().HeS = new eio();
        }
        ((com.tencent.mm.aa.a.b)localObject1).ait().HeS.IlP = this.kBP;
        com.tencent.mm.kernel.g.ajj().a((n)localObject1, 0);
      }
      AppMethodBeat.o(46029);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(46030);
      bix();
      if (!this.kBx.isRunning())
      {
        this.kBy.bjq();
        AppMethodBeat.o(46030);
        return;
      }
      if (this.kBB.equals("ok"))
      {
        this.kBw.b(this.kBx, this.kmu, "ok");
        this.kBy.bjq();
        AppMethodBeat.o(46030);
        return;
      }
      Object localObject;
      if (this.kBB.equals("fail"))
      {
        if (bu.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.kBw.b(this.kBx, this.kmu, (String)localObject);
          this.kBy.bjq();
          AppMethodBeat.o(46030);
          return;
        }
      }
      if (this.kBB.equals("risk_intercepted"))
      {
        if (this.kBO != null) {
          h.a(this.kBx.getContext(), this.kBO.dyI, this.kBO.kDa, this.kBO.kCZ, h.b.a(this.kBx.getContext(), this.kBO), new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(222407);
              JsApiAuthorize.AuthorizeTask.this.kBw.b(JsApiAuthorize.AuthorizeTask.this.kBx, JsApiAuthorize.AuthorizeTask.this.kmu, "fail:risk intercepted");
              AppMethodBeat.o(222407);
            }
          });
        }
        this.kBy.bjq();
        AppMethodBeat.o(46030);
        return;
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
            ae.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { localIOException.getMessage() });
            ae.printErrStackTrace("MicroMsg.JsApiAuthorize", localIOException, "", new Object[0]);
            this.kBw.b(this.kBx, this.kmu, "fail:internal error scope error");
            this.kBy.bjq();
            AppMethodBeat.o(46030);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.kBx.K(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(222410);
              cyg localcyg = (cyg)localIOException.get(0);
              AppBrandRuntime localAppBrandRuntime = JsApiAuthorize.AuthorizeTask.this.kBx.getRuntime();
              boolean bool = com.tencent.mm.plugin.appbrand.permission.q.a(localcyg.GcE, localAppBrandRuntime.Fm());
              final com.tencent.mm.plugin.appbrand.permission.a.b localb = com.tencent.mm.plugin.appbrand.permission.a.b.a.a(JsApiAuthorize.AuthorizeTask.this.kBx, new i.b()
              {
                public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(222408);
                  if (com.tencent.luggage.h.b.C(paramAnonymous2ArrayList).size() > 0)
                  {
                    paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);
                    switch (paramAnonymous2Int1)
                    {
                    }
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(222408);
                    return;
                    paramAnonymous2ArrayList = "";
                    break;
                    ArrayList localArrayList = new ArrayList();
                    localArrayList.add(paramAnonymous2ArrayList);
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 1, localArrayList);
                    ae.i("MicroMsg.JsApiAuthorize", "click PositiveButton");
                    AppMethodBeat.o(222408);
                    return;
                    localArrayList = new ArrayList();
                    localArrayList.add(paramAnonymous2ArrayList);
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 2, localArrayList);
                    ae.i("MicroMsg.JsApiAuthorize", "click NegativeButton");
                    AppMethodBeat.o(222408);
                    return;
                    JsApiAuthorize.AuthorizeTask.h(JsApiAuthorize.AuthorizeTask.this);
                    ae.i("MicroMsg.JsApiAuthorize", "user cancel");
                  }
                }
              });
              localb.setAppBrandName(localAppBrandRuntime.Fm().dpI);
              localb.setApplyWording(JsApiAuthorize.AuthorizeTask.this.kBE);
              localb.setRequestDesc(localcyg.Desc);
              localb.setNegativeButtonText(JsApiAuthorize.AuthorizeTask.this.kBF);
              localb.setPositiveButtonText(JsApiAuthorize.AuthorizeTask.this.kBG);
              localb.setIconUrl(JsApiAuthorize.AuthorizeTask.this.kBD);
              if ((JsApiAuthorize.AuthorizeTask.this.kBH) && (!TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.kBI)))
              {
                localb.hb(true);
                localb.setExplainOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(222409);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                    localb.a(JsApiAuthorize.AuthorizeTask.this.kBx, JsApiAuthorize.AuthorizeTask.this.kBI, (ac)JsApiAuthorize.AuthorizeTask.this.kBx.K(ac.class)).h(JsApiAuthorize.AuthorizeTask.this.kBx);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(222409);
                  }
                });
                if (!"scope.userInfo".equals(localcyg.GcE)) {
                  break label323;
                }
                Object localObject = g.kBm;
                localObject = JsApiAuthorize.AuthorizeTask.this.kBx.getContext();
                Bitmap localBitmap = com.tencent.mm.aj.e.DF(JsApiAuthorize.AuthorizeTask.this.kBJ);
                String str1 = JsApiAuthorize.AuthorizeTask.this.kBK;
                String str2 = localcyg.GcE;
                p.h(localObject, "context");
                p.h(localb, "dialog");
                f.c.a((Context)localObject, localBitmap, str1, str2, localb);
              }
              for (;;)
              {
                if (bool)
                {
                  if (TextUtils.isEmpty(com.tencent.mm.plugin.appbrand.permission.q.a(localcyg.GcE, localAppBrandRuntime)))
                  {
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, "fail:require permission desc");
                    ae.i("MicroMsg.JsApiAuthorize", "error = fail:require permission desc");
                    AppMethodBeat.o(222410);
                    return;
                    localb.hb(false);
                    break;
                    label323:
                    localb.setScope(localcyg.GcE);
                    continue;
                  }
                  localb.setSimpleDetailDesc(com.tencent.mm.plugin.appbrand.permission.q.a(localcyg.GcE, localAppBrandRuntime));
                }
              }
              for (;;)
              {
                ae.i("MicroMsg.JsApiAuthorize", "Confirm dialog scope=%s desc =%s auth_desc=%s ext_desc=%s", new Object[] { localcyg.GcE, localcyg.Desc, localcyg.Hek, localcyg.mqC });
                localb.h(JsApiAuthorize.AuthorizeTask.this.kBx);
                AppMethodBeat.o(222410);
                return;
                if (!TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.kBN)) {
                  localb.setSimpleDetailDesc(JsApiAuthorize.AuthorizeTask.this.kBN);
                }
              }
            }
          });
          AppMethodBeat.o(46030);
          return;
        }
        this.kBw.b(this.kBx, this.kmu, "fail:internal error scope empty");
        this.kBy.bjq();
      }
      AppMethodBeat.o(46030);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46032);
      this.data = paramParcel.readString();
      this.kmu = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.kBB = paramParcel.readString();
      this.kBA = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.kBD = paramParcel.readString();
      this.kBL = paramParcel.readInt();
      this.kBM = paramParcel.readBundle(JsApiAuthorize.class.getClassLoader());
      this.kBz = paramParcel.createStringArrayList();
      this.hSZ = paramParcel.readInt();
      this.kBC = paramParcel.readInt();
      this.kxr = paramParcel.readInt();
      this.kBP = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      this.kBG = paramParcel.readString();
      this.kBF = paramParcel.readString();
      this.kBE = paramParcel.readString();
      this.kBJ = paramParcel.readString();
      this.kBK = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kBH = bool;
        this.kBI = paramParcel.readString();
        this.kBN = paramParcel.readString();
        this.kBO = ((MMAuthScopeRiskInfo)paramParcel.readParcelable(MMAuthScopeRiskInfo.class.getClassLoader()));
        AppMethodBeat.o(46032);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46033);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.kmu);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kBB);
      paramParcel.writeString(this.kBA);
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
      paramParcel.writeString(this.kBG);
      paramParcel.writeString(this.kBF);
      paramParcel.writeString(this.kBE);
      paramParcel.writeString(this.kBJ);
      paramParcel.writeString(this.kBK);
      if (this.kBH) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeInt(i);
        paramParcel.writeString(this.kBI);
        paramParcel.writeString(this.kBN);
        paramParcel.writeParcelable(this.kBO, paramInt);
        AppMethodBeat.o(46033);
        return;
      }
    }
    
    public static abstract interface a
    {
      public abstract void a(MMAuthScopeRiskInfo paramMMAuthScopeRiskInfo);
      
      public abstract void a(brv parambrv);
      
      public abstract void af(int paramInt, String paramString);
      
      public abstract void onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize
 * JD-Core Version:    0.7.0.1
 */