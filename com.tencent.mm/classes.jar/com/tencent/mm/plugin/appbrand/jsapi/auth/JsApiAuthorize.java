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
import com.tencent.mm.ab.a.a.a;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMAuthScopeRiskInfo;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.permission.f;
import com.tencent.mm.plugin.appbrand.permission.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private final k kyg;
  
  public JsApiAuthorize()
  {
    AppMethodBeat.i(174773);
    this.kyg = new k();
    AppMethodBeat.o(174773);
  }
  
  public final void a(d paramd, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(188292);
    ad.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
    AuthorizeTask localAuthorizeTask = new AuthorizeTask();
    localAuthorizeTask.appId = paramd.getAppId();
    localAuthorizeTask.kyl = "authorize";
    Object localObject = paramd.getRuntime().Fh();
    if (localObject != null) {
      localAuthorizeTask.hQh = ((com.tencent.mm.plugin.appbrand.config.k)localObject).jYh.jIU;
    }
    localObject = com.tencent.mm.plugin.appbrand.a.Kl(paramd.getAppId());
    if (localObject != null) {
      AuthorizeTask.a(localAuthorizeTask, ((AppBrandStatObject)localObject).scene);
    }
    paramJSONObject = paramJSONObject.toString();
    localAuthorizeTask.kyh = this;
    localAuthorizeTask.kyi = paramd;
    localAuthorizeTask.data = paramJSONObject;
    localAuthorizeTask.kje = paramInt;
    localAuthorizeTask.kyj = parame;
    localAuthorizeTask.kyx = new Bundle();
    if ((paramd instanceof com.tencent.mm.plugin.appbrand.q)) {
      localAuthorizeTask.kyA = 1;
    }
    for (;;)
    {
      localAuthorizeTask.bhN();
      AppBrandMainProcessService.a(localAuthorizeTask);
      AppMethodBeat.o(188292);
      return;
      if ((paramd instanceof aa)) {
        localAuthorizeTask.kyA = 2;
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
    public int hQh;
    public int kje;
    private int kub;
    int kyA;
    transient i kyh;
    transient d kyi;
    transient e kyj;
    public ArrayList<String> kyk;
    public String kyl;
    public String kym;
    public int kyn;
    public String kyo;
    public String kyp;
    public String kyq;
    public String kyr;
    public boolean kys;
    public String kyt;
    public String kyu;
    public String kyv;
    public int kyw;
    public Bundle kyx;
    public String kyy;
    public MMAuthScopeRiskInfo kyz;
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
    
    private void Pd(String paramString)
    {
      AppMethodBeat.i(46031);
      if (TextUtils.isEmpty(paramString)) {
        this.kyh.b(this.kyi, this.kje, "fail auth cancel");
      }
      for (;;)
      {
        this.kyj.biH();
        AppMethodBeat.o(46031);
        return;
        this.kyh.b(this.kyi, this.kje, paramString);
      }
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(46029);
      a local1 = new a()
      {
        public final void a(MMAuthScopeRiskInfo paramAnonymousMMAuthScopeRiskInfo)
        {
          AppMethodBeat.i(188280);
          ad.d("MicroMsg.JsApiAuthorize", "onScopeRiskIntercepted !");
          JsApiAuthorize.AuthorizeTask.this.kym = "risk_intercepted";
          JsApiAuthorize.AuthorizeTask.this.kyz = paramAnonymousMMAuthScopeRiskInfo;
          JsApiAuthorize.AuthorizeTask.b(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(188280);
        }
        
        public final void a(brb paramAnonymousbrb)
        {
          AppMethodBeat.i(46021);
          ad.d("MicroMsg.JsApiAuthorize", "onConfirm !");
          Object localObject1 = paramAnonymousbrb.Gui;
          JsApiAuthorize.AuthorizeTask.this.kyw = ((LinkedList)localObject1).size();
          int i = 0;
          Object localObject2;
          while (i < JsApiAuthorize.AuthorizeTask.this.kyw)
          {
            localObject2 = (cxm)((LinkedList)localObject1).get(i);
            try
            {
              JsApiAuthorize.AuthorizeTask.this.kyx.putByteArray(String.valueOf(i), ((cxm)localObject2).toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousbrb)
            {
              ad.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { paramAnonymousbrb.getMessage() });
              ad.printErrStackTrace("MicroMsg.JsApiAuthorize", paramAnonymousbrb, "", new Object[0]);
              JsApiAuthorize.AuthorizeTask.this.kym = "fail";
              JsApiAuthorize.AuthorizeTask.d(JsApiAuthorize.AuthorizeTask.this);
              AppMethodBeat.o(46021);
              return;
            }
          }
          JsApiAuthorize.AuthorizeTask.this.mAppName = paramAnonymousbrb.uiR;
          JsApiAuthorize.AuthorizeTask.this.kyo = paramAnonymousbrb.Fts;
          JsApiAuthorize.AuthorizeTask.this.kyp = paramAnonymousbrb.GLx;
          JsApiAuthorize.AuthorizeTask.this.kyr = paramAnonymousbrb.GLw;
          JsApiAuthorize.AuthorizeTask.this.kyq = paramAnonymousbrb.GLv;
          if (paramAnonymousbrb.GLy != null)
          {
            JsApiAuthorize.AuthorizeTask.this.kys = paramAnonymousbrb.GLy.FvP;
            JsApiAuthorize.AuthorizeTask.this.kyt = paramAnonymousbrb.GLy.FvQ;
          }
          JsApiAuthorize.AuthorizeTask.this.kym = "needConfirm";
          if (((LinkedList)localObject1).size() > 0)
          {
            localObject1 = (cxm)((LinkedList)localObject1).get(0);
            localObject2 = JsApiAuthorize.AuthorizeTask.this;
            if (((cxm)localObject1).HoW == null)
            {
              paramAnonymousbrb = "";
              ((JsApiAuthorize.AuthorizeTask)localObject2).kyy = paramAnonymousbrb;
              if (!"scope.userInfo".equals(((cxm)localObject1).FKf)) {
                break label371;
              }
              JsApiAuthorize.AuthorizeTask.this.kyv = u.aAo();
              localObject1 = new StringBuilder("userNickName=");
              if (JsApiAuthorize.AuthorizeTask.this.kyv != null) {
                break label360;
              }
            }
            label360:
            for (paramAnonymousbrb = "";; paramAnonymousbrb = JsApiAuthorize.AuthorizeTask.this.kyv)
            {
              ad.i("MicroMsg.JsApiAuthorize", paramAnonymousbrb);
              paramAnonymousbrb = u.aAm();
              localObject1 = g.kxX;
              g.a.a(paramAnonymousbrb, new g.b()
              {
                public final void KZ(String paramAnonymous2String)
                {
                  AppMethodBeat.i(46018);
                  JsApiAuthorize.AuthorizeTask.this.kyu = paramAnonymous2String;
                  StringBuilder localStringBuilder = new StringBuilder(" userHeadIconPath=");
                  if (JsApiAuthorize.AuthorizeTask.this.kyu == null) {}
                  for (paramAnonymous2String = "";; paramAnonymous2String = JsApiAuthorize.AuthorizeTask.this.kyu)
                  {
                    ad.i("MicroMsg.JsApiAuthorize", paramAnonymous2String);
                    JsApiAuthorize.AuthorizeTask.e(JsApiAuthorize.AuthorizeTask.this);
                    AppMethodBeat.o(46018);
                    return;
                  }
                }
              });
              AppMethodBeat.o(46021);
              return;
              paramAnonymousbrb = ((cxm)localObject1).HoW;
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
          ad.e("MicroMsg.JsApiAuthorize", "onFailure !");
          JsApiAuthorize.AuthorizeTask.this.kym = "fail";
          JsApiAuthorize.AuthorizeTask.this.errCode = paramAnonymousInt;
          JsApiAuthorize.AuthorizeTask.this.errMsg = paramAnonymousString;
          JsApiAuthorize.AuthorizeTask.c(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46020);
        }
        
        public final void onSuccess()
        {
          AppMethodBeat.i(46019);
          ad.d("MicroMsg.JsApiAuthorize", "onSuccess !");
          JsApiAuthorize.AuthorizeTask.this.kym = "ok";
          JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46019);
        }
      };
      Object localObject2;
      Object localObject3;
      int i;
      Object localObject1;
      if (this.kyl.equals("authorize"))
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
          localObject1 = new com.tencent.mm.ab.a.a(this.appId, (LinkedList)localObject3, this.hQh, this.kub, new a.a() {});
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[] { localException.getMessage() });
          this.kym = "fail";
          bhX();
          AppMethodBeat.o(46029);
          return;
        }
        if (((com.tencent.mm.ab.a.a)localObject1).aic().GLr == null) {
          ((com.tencent.mm.ab.a.a)localObject1).aic().GLr = new egx();
        }
        ((com.tencent.mm.ab.a.a)localObject1).aic().GLr.HRI = this.kyA;
        com.tencent.mm.kernel.g.aiU().a((n)localObject1, 0);
        AppMethodBeat.o(46029);
        return;
      }
      if (this.kyl.equals("authorizeConfirm"))
      {
        localObject2 = this.appId;
        localObject3 = this.kyk;
        i = this.hQh;
        final int j = this.kyn;
        localObject1 = new com.tencent.mm.ab.a.b((String)localObject2, i.v((ArrayList)localObject3), i, j, this.kub, new com.tencent.mm.ab.a.b.a() {});
        if (((com.tencent.mm.ab.a.b)localObject1).aie().GLr == null) {
          ((com.tencent.mm.ab.a.b)localObject1).aie().GLr = new egx();
        }
        ((com.tencent.mm.ab.a.b)localObject1).aie().GLr.HRI = this.kyA;
        com.tencent.mm.kernel.g.aiU().a((n)localObject1, 0);
      }
      AppMethodBeat.o(46029);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(46030);
      bhO();
      if (!this.kyi.isRunning())
      {
        this.kyj.biH();
        AppMethodBeat.o(46030);
        return;
      }
      if (this.kym.equals("ok"))
      {
        this.kyh.b(this.kyi, this.kje, "ok");
        this.kyj.biH();
        AppMethodBeat.o(46030);
        return;
      }
      Object localObject;
      if (this.kym.equals("fail"))
      {
        if (bt.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.kyh.b(this.kyi, this.kje, (String)localObject);
          this.kyj.biH();
          AppMethodBeat.o(46030);
          return;
        }
      }
      if (this.kym.equals("risk_intercepted"))
      {
        if (this.kyz != null) {
          h.a(this.kyi.getContext(), this.kyz.dxD, this.kyz.kzL, this.kyz.kzK, h.b.a(this.kyi.getContext(), this.kyz), new DialogInterface.OnDismissListener()
          {
            public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(188281);
              JsApiAuthorize.AuthorizeTask.this.kyh.b(JsApiAuthorize.AuthorizeTask.this.kyi, JsApiAuthorize.AuthorizeTask.this.kje, "fail:risk intercepted");
              AppMethodBeat.o(188281);
            }
          });
        }
        this.kyj.biH();
        AppMethodBeat.o(46030);
        return;
      }
      if (this.kym.equals("needConfirm"))
      {
        localObject = new LinkedList();
        int i = 0;
        while (i < this.kyw)
        {
          byte[] arrayOfByte = this.kyx.getByteArray(String.valueOf(i));
          cxm localcxm = new cxm();
          try
          {
            localcxm.parseFrom(arrayOfByte);
            ((LinkedList)localObject).add(localcxm);
            i += 1;
          }
          catch (IOException localIOException)
          {
            ad.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { localIOException.getMessage() });
            ad.printErrStackTrace("MicroMsg.JsApiAuthorize", localIOException, "", new Object[0]);
            this.kyh.b(this.kyi, this.kje, "fail:internal error scope error");
            this.kyj.biH();
            AppMethodBeat.o(46030);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.kyi.M(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(188284);
              cxm localcxm = (cxm)localIOException.get(0);
              AppBrandRuntime localAppBrandRuntime = JsApiAuthorize.AuthorizeTask.this.kyi.getRuntime();
              boolean bool = o.a(localcxm.FKf, localAppBrandRuntime.Fh());
              final com.tencent.mm.plugin.appbrand.permission.a.b localb = com.tencent.mm.plugin.appbrand.permission.a.b.a.a(JsApiAuthorize.AuthorizeTask.this.kyi, new i.b()
              {
                public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(188282);
                  if (com.tencent.luggage.h.b.C(paramAnonymous2ArrayList).size() > 0)
                  {
                    paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);
                    switch (paramAnonymous2Int1)
                    {
                    }
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(188282);
                    return;
                    paramAnonymous2ArrayList = "";
                    break;
                    ArrayList localArrayList = new ArrayList();
                    localArrayList.add(paramAnonymous2ArrayList);
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 1, localArrayList);
                    ad.i("MicroMsg.JsApiAuthorize", "click PositiveButton");
                    AppMethodBeat.o(188282);
                    return;
                    localArrayList = new ArrayList();
                    localArrayList.add(paramAnonymous2ArrayList);
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 2, localArrayList);
                    ad.i("MicroMsg.JsApiAuthorize", "click NegativeButton");
                    AppMethodBeat.o(188282);
                    return;
                    JsApiAuthorize.AuthorizeTask.h(JsApiAuthorize.AuthorizeTask.this);
                    ad.i("MicroMsg.JsApiAuthorize", "user cancel");
                  }
                }
              });
              localb.setAppBrandName(localAppBrandRuntime.Fh().doD);
              localb.setApplyWording(JsApiAuthorize.AuthorizeTask.this.kyp);
              localb.setRequestDesc(localcxm.Desc);
              localb.setNegativeButtonText(JsApiAuthorize.AuthorizeTask.this.kyq);
              localb.setPositiveButtonText(JsApiAuthorize.AuthorizeTask.this.kyr);
              localb.setIconUrl(JsApiAuthorize.AuthorizeTask.this.kyo);
              if ((JsApiAuthorize.AuthorizeTask.this.kys) && (!TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.kyt)))
              {
                localb.hb(true);
                localb.setExplainOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(188283);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    localb.a(JsApiAuthorize.AuthorizeTask.this.kyi, JsApiAuthorize.AuthorizeTask.this.kyt, (ac)JsApiAuthorize.AuthorizeTask.this.kyi.K(ac.class)).h(JsApiAuthorize.AuthorizeTask.this.kyi);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorize$AuthorizeTask$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(188283);
                  }
                });
                if (!"scope.userInfo".equals(localcxm.FKf)) {
                  break label323;
                }
                Object localObject = g.kxX;
                localObject = JsApiAuthorize.AuthorizeTask.this.kyi.getContext();
                Bitmap localBitmap = com.tencent.mm.ak.e.Dd(JsApiAuthorize.AuthorizeTask.this.kyu);
                String str1 = JsApiAuthorize.AuthorizeTask.this.kyv;
                String str2 = localcxm.FKf;
                p.h(localObject, "context");
                p.h(localb, "dialog");
                f.c.a((Context)localObject, localBitmap, str1, str2, localb);
              }
              for (;;)
              {
                if (bool)
                {
                  if (TextUtils.isEmpty(o.a(localcxm.FKf, localAppBrandRuntime)))
                  {
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, "fail:require permission desc");
                    ad.i("MicroMsg.JsApiAuthorize", "error = fail:require permission desc");
                    AppMethodBeat.o(188284);
                    return;
                    localb.hb(false);
                    break;
                    label323:
                    localb.setScope(localcxm.FKf);
                    continue;
                  }
                  localb.setSimpleDetailDesc(o.a(localcxm.FKf, localAppBrandRuntime));
                }
              }
              for (;;)
              {
                ad.i("MicroMsg.JsApiAuthorize", "Confirm dialog scope=%s desc =%s auth_desc=%s ext_desc=%s", new Object[] { localcxm.FKf, localcxm.Desc, localcxm.GKJ, localcxm.mlF });
                localb.h(JsApiAuthorize.AuthorizeTask.this.kyi);
                AppMethodBeat.o(188284);
                return;
                if (!TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.kyy)) {
                  localb.setSimpleDetailDesc(JsApiAuthorize.AuthorizeTask.this.kyy);
                }
              }
            }
          });
          AppMethodBeat.o(46030);
          return;
        }
        this.kyh.b(this.kyi, this.kje, "fail:internal error scope empty");
        this.kyj.biH();
      }
      AppMethodBeat.o(46030);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46032);
      this.data = paramParcel.readString();
      this.kje = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.kym = paramParcel.readString();
      this.kyl = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.kyo = paramParcel.readString();
      this.kyw = paramParcel.readInt();
      this.kyx = paramParcel.readBundle(JsApiAuthorize.class.getClassLoader());
      this.kyk = paramParcel.createStringArrayList();
      this.hQh = paramParcel.readInt();
      this.kyn = paramParcel.readInt();
      this.kub = paramParcel.readInt();
      this.kyA = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      this.kyr = paramParcel.readString();
      this.kyq = paramParcel.readString();
      this.kyp = paramParcel.readString();
      this.kyu = paramParcel.readString();
      this.kyv = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kys = bool;
        this.kyt = paramParcel.readString();
        this.kyy = paramParcel.readString();
        this.kyz = ((MMAuthScopeRiskInfo)paramParcel.readParcelable(MMAuthScopeRiskInfo.class.getClassLoader()));
        AppMethodBeat.o(46032);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46033);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.kje);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kym);
      paramParcel.writeString(this.kyl);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.kyo);
      paramParcel.writeInt(this.kyw);
      paramParcel.writeBundle(this.kyx);
      paramParcel.writeStringList(this.kyk);
      paramParcel.writeInt(this.hQh);
      paramParcel.writeInt(this.kyn);
      paramParcel.writeInt(this.kub);
      paramParcel.writeInt(this.kyA);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      paramParcel.writeString(this.kyr);
      paramParcel.writeString(this.kyq);
      paramParcel.writeString(this.kyp);
      paramParcel.writeString(this.kyu);
      paramParcel.writeString(this.kyv);
      if (this.kys) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeInt(i);
        paramParcel.writeString(this.kyt);
        paramParcel.writeString(this.kyy);
        paramParcel.writeParcelable(this.kyz, paramInt);
        AppMethodBeat.o(46033);
        return;
      }
    }
    
    public static abstract interface a
    {
      public abstract void a(MMAuthScopeRiskInfo paramMMAuthScopeRiskInfo);
      
      public abstract void a(brb parambrb);
      
      public abstract void af(int paramInt, String paramString);
      
      public abstract void onSuccess();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize
 * JD-Core Version:    0.7.0.1
 */