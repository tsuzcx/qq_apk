package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.a.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.biy;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize
  extends h
{
  private static final int CTRL_INDEX = 54;
  private static final String NAME = "authorize";
  private final i jDd;
  
  public JsApiAuthorize()
  {
    AppMethodBeat.i(174773);
    this.jDd = new i();
    AppMethodBeat.o(174773);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(46043);
    ad.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
    AuthorizeTask localAuthorizeTask = new AuthorizeTask();
    localAuthorizeTask.appId = paramh.getAppId();
    localAuthorizeTask.jDi = "authorize";
    Object localObject = paramh.getRuntime().Ef();
    if (localObject != null) {
      localAuthorizeTask.gXn = ((com.tencent.mm.plugin.appbrand.config.k)localObject).jdS.iOQ;
    }
    localObject = com.tencent.mm.plugin.appbrand.a.CT(paramh.getAppId());
    if (localObject != null) {
      AuthorizeTask.a(localAuthorizeTask, ((AppBrandStatObject)localObject).scene);
    }
    paramJSONObject = paramJSONObject.toString();
    localAuthorizeTask.jDe = this;
    localAuthorizeTask.jDf = paramh;
    localAuthorizeTask.data = paramJSONObject;
    localAuthorizeTask.joH = paramInt;
    localAuthorizeTask.jDg = parame;
    localAuthorizeTask.jDu = new Bundle();
    if ((paramh instanceof com.tencent.mm.plugin.appbrand.q)) {
      localAuthorizeTask.jDw = 1;
    }
    for (;;)
    {
      localAuthorizeTask.aXm();
      AppBrandMainProcessService.a(localAuthorizeTask);
      AppMethodBeat.o(46043);
      return;
      if ((paramh instanceof aa)) {
        localAuthorizeTask.jDw = 2;
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
    public int gXn;
    h jDe;
    com.tencent.mm.plugin.appbrand.jsapi.h jDf;
    e jDg;
    public ArrayList<String> jDh;
    public String jDi;
    public String jDj;
    public int jDk;
    public String jDl;
    public String jDm;
    public String jDn;
    public String jDo;
    public boolean jDp;
    public String jDq;
    public String jDr;
    public String jDs;
    public int jDt;
    public Bundle jDu;
    public String jDv;
    int jDw;
    public int joH;
    private int jzi;
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
    
    private void HF(String paramString)
    {
      AppMethodBeat.i(46031);
      if (TextUtils.isEmpty(paramString)) {
        this.jDe.b(this.jDf, this.joH, "fail auth cancel");
      }
      for (;;)
      {
        this.jDg.aYh();
        AppMethodBeat.o(46031);
        return;
        this.jDe.b(this.jDf, this.joH, paramString);
      }
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(46030);
      aXn();
      if (!this.jDf.isRunning())
      {
        this.jDg.aYh();
        AppMethodBeat.o(46030);
        return;
      }
      if (this.jDj.equals("ok"))
      {
        this.jDe.b(this.jDf, this.joH, "ok");
        this.jDg.aYh();
        AppMethodBeat.o(46030);
        return;
      }
      Object localObject;
      if (this.jDj.equals("fail"))
      {
        if (bt.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.jDe.b(this.jDf, this.joH, (String)localObject);
          this.jDg.aYh();
          AppMethodBeat.o(46030);
          return;
        }
      }
      if (this.jDj.equals("needConfirm"))
      {
        localObject = new LinkedList();
        int i = 0;
        while (i < this.jDt)
        {
          byte[] arrayOfByte = this.jDu.getByteArray(String.valueOf(i));
          cmy localcmy = new cmy();
          try
          {
            localcmy.parseFrom(arrayOfByte);
            ((LinkedList)localObject).add(localcmy);
            i += 1;
          }
          catch (IOException localIOException)
          {
            ad.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { localIOException.getMessage() });
            ad.printErrStackTrace("MicroMsg.JsApiAuthorize", localIOException, "", new Object[0]);
            this.jDe.b(this.jDf, this.joH, "fail:internal error scope error");
            this.jDg.aYh();
            AppMethodBeat.o(46030);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.jDf.L(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46024);
              cmy localcmy = (cmy)localIOException.get(0);
              AppBrandRuntime localAppBrandRuntime = JsApiAuthorize.AuthorizeTask.this.jDf.getRuntime();
              boolean bool2 = com.tencent.mm.plugin.appbrand.permission.n.a(localcmy.CLe, localAppBrandRuntime.Ef());
              boolean bool1;
              final com.tencent.mm.plugin.appbrand.widget.dialog.i locali;
              if ((JsApiAuthorize.AuthorizeTask.this.jDf.getRuntime().getWindowAndroid() != null) && (JsApiAuthorize.AuthorizeTask.this.jDf.getRuntime().getWindowAndroid().aMH()))
              {
                bool1 = true;
                locali = new com.tencent.mm.plugin.appbrand.widget.dialog.i(localAppBrandRuntime.aLK().getContext(), new i.b()
                {
                  public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2)
                  {
                    AppMethodBeat.i(46022);
                    if (com.tencent.luggage.h.b.L(paramAnonymous2ArrayList).size() > 0)
                    {
                      paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);
                      switch (paramAnonymous2Int1)
                      {
                      }
                    }
                    for (;;)
                    {
                      AppMethodBeat.o(46022);
                      return;
                      paramAnonymous2ArrayList = "";
                      break;
                      ArrayList localArrayList = new ArrayList();
                      localArrayList.add(paramAnonymous2ArrayList);
                      JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 1, localArrayList);
                      ad.i("MicroMsg.JsApiAuthorize", "click PositiveButton");
                      AppMethodBeat.o(46022);
                      return;
                      localArrayList = new ArrayList();
                      localArrayList.add(paramAnonymous2ArrayList);
                      JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 2, localArrayList);
                      ad.i("MicroMsg.JsApiAuthorize", "click NegativeButton");
                      AppMethodBeat.o(46022);
                      return;
                      JsApiAuthorize.AuthorizeTask.g(JsApiAuthorize.AuthorizeTask.this);
                      ad.i("MicroMsg.JsApiAuthorize", "user cancel");
                    }
                  }
                }, bool1);
                locali.aUE(localAppBrandRuntime.Ef().dfM);
                locali.aUH(JsApiAuthorize.AuthorizeTask.this.jDm);
                locali.aUF(localcmy.Desc);
                locali.aUI(JsApiAuthorize.AuthorizeTask.this.jDn);
                locali.aUJ(JsApiAuthorize.AuthorizeTask.this.jDo);
                locali.nP(JsApiAuthorize.AuthorizeTask.this.jDl);
                if ((!JsApiAuthorize.AuthorizeTask.this.jDp) || (TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.jDq))) {
                  break label358;
                }
                locali.yt(true);
                locali.b(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(46023);
                    JsApiAuthorize.AuthorizeTask.this.jDf.aLB().b(new com.tencent.mm.plugin.appbrand.phonenumber.k(JsApiAuthorize.AuthorizeTask.this.jDf.aLB(), JsApiAuthorize.AuthorizeTask.this.jDf, JsApiAuthorize.AuthorizeTask.this.jDq, h.c(JsApiAuthorize.AuthorizeTask.this.jDf), locali.hIZ.getMeasuredHeight()));
                    AppMethodBeat.o(46023);
                  }
                });
                label227:
                if (!"scope.userInfo".equals(localcmy.CLe)) {
                  break label367;
                }
                Object localObject = g.jDa;
                localObject = JsApiAuthorize.AuthorizeTask.this.jDf.getContext();
                Bitmap localBitmap = com.tencent.mm.ak.e.vY(JsApiAuthorize.AuthorizeTask.this.jDr);
                String str1 = JsApiAuthorize.AuthorizeTask.this.jDs;
                String str2 = localcmy.CLe;
                d.g.b.k.h(localObject, "context");
                d.g.b.k.h(locali, "dialog");
                f.c.a((Context)localObject, localBitmap, str1, str2, locali);
              }
              for (;;)
              {
                if (bool2)
                {
                  if (TextUtils.isEmpty(com.tencent.mm.plugin.appbrand.permission.n.a(localcmy.CLe, localAppBrandRuntime)))
                  {
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, "fail:require permission desc");
                    ad.i("MicroMsg.JsApiAuthorize", "error = fail:require permission desc");
                    AppMethodBeat.o(46024);
                    return;
                    bool1 = false;
                    break;
                    label358:
                    locali.yt(false);
                    break label227;
                    label367:
                    locali.aUL(localcmy.CLe);
                    continue;
                  }
                  locali.aUG(com.tencent.mm.plugin.appbrand.permission.n.a(localcmy.CLe, localAppBrandRuntime));
                }
              }
              for (;;)
              {
                ad.i("MicroMsg.JsApiAuthorize", "Confirm dialog scope=%s desc =%s auth_desc=%s ext_desc=%s", new Object[] { localcmy.CLe, localcmy.Desc, localcmy.DFQ, localcmy.lmb });
                localAppBrandRuntime.hKb.b(locali);
                AppMethodBeat.o(46024);
                return;
                if (!TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.jDv)) {
                  locali.aUG(JsApiAuthorize.AuthorizeTask.this.jDv);
                }
              }
            }
          });
          AppMethodBeat.o(46030);
          return;
        }
        this.jDe.b(this.jDf, this.joH, "fail:internal error scope empty");
        this.jDg.aYh();
      }
      AppMethodBeat.o(46030);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(46029);
      JsApiAuthorize.AuthorizeTask.a local1 = new JsApiAuthorize.AuthorizeTask.a()
      {
        public final void a(biz paramAnonymousbiz)
        {
          AppMethodBeat.i(46021);
          ad.d("MicroMsg.JsApiAuthorize", "onConfirm !");
          Object localObject1 = paramAnonymousbiz.Dqc;
          JsApiAuthorize.AuthorizeTask.this.jDt = ((LinkedList)localObject1).size();
          int i = 0;
          Object localObject2;
          while (i < JsApiAuthorize.AuthorizeTask.this.jDt)
          {
            localObject2 = (cmy)((LinkedList)localObject1).get(i);
            try
            {
              JsApiAuthorize.AuthorizeTask.this.jDu.putByteArray(String.valueOf(i), ((cmy)localObject2).toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousbiz)
            {
              ad.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { paramAnonymousbiz.getMessage() });
              ad.printErrStackTrace("MicroMsg.JsApiAuthorize", paramAnonymousbiz, "", new Object[0]);
              JsApiAuthorize.AuthorizeTask.this.jDj = "fail";
              JsApiAuthorize.AuthorizeTask.c(JsApiAuthorize.AuthorizeTask.this);
              AppMethodBeat.o(46021);
              return;
            }
          }
          JsApiAuthorize.AuthorizeTask.this.mAppName = paramAnonymousbiz.scR;
          JsApiAuthorize.AuthorizeTask.this.jDl = paramAnonymousbiz.CvQ;
          JsApiAuthorize.AuthorizeTask.this.jDm = paramAnonymousbiz.DGD;
          JsApiAuthorize.AuthorizeTask.this.jDo = paramAnonymousbiz.DGC;
          JsApiAuthorize.AuthorizeTask.this.jDn = paramAnonymousbiz.DGB;
          if (paramAnonymousbiz.DGE != null)
          {
            JsApiAuthorize.AuthorizeTask.this.jDp = paramAnonymousbiz.DGE.Cye;
            JsApiAuthorize.AuthorizeTask.this.jDq = paramAnonymousbiz.DGE.Cyf;
          }
          JsApiAuthorize.AuthorizeTask.this.jDj = "needConfirm";
          if (((LinkedList)localObject1).size() > 0)
          {
            localObject1 = (cmy)((LinkedList)localObject1).get(0);
            localObject2 = JsApiAuthorize.AuthorizeTask.this;
            if (((cmy)localObject1).EhI == null)
            {
              paramAnonymousbiz = "";
              ((JsApiAuthorize.AuthorizeTask)localObject2).jDv = paramAnonymousbiz;
              if (!"scope.userInfo".equals(((cmy)localObject1).CLe)) {
                break label371;
              }
              JsApiAuthorize.AuthorizeTask.this.jDs = u.aqI();
              localObject1 = new StringBuilder("userNickName=");
              if (JsApiAuthorize.AuthorizeTask.this.jDs != null) {
                break label360;
              }
            }
            label360:
            for (paramAnonymousbiz = "";; paramAnonymousbiz = JsApiAuthorize.AuthorizeTask.this.jDs)
            {
              ad.i("MicroMsg.JsApiAuthorize", paramAnonymousbiz);
              paramAnonymousbiz = u.aqG();
              localObject1 = g.jDa;
              g.a.a(paramAnonymousbiz, new g.b()
              {
                public final void DD(String paramAnonymous2String)
                {
                  AppMethodBeat.i(46018);
                  JsApiAuthorize.AuthorizeTask.this.jDr = paramAnonymous2String;
                  StringBuilder localStringBuilder = new StringBuilder(" userHeadIconPath=");
                  if (JsApiAuthorize.AuthorizeTask.this.jDr == null) {}
                  for (paramAnonymous2String = "";; paramAnonymous2String = JsApiAuthorize.AuthorizeTask.this.jDr)
                  {
                    ad.i("MicroMsg.JsApiAuthorize", paramAnonymous2String);
                    JsApiAuthorize.AuthorizeTask.d(JsApiAuthorize.AuthorizeTask.this);
                    AppMethodBeat.o(46018);
                    return;
                  }
                }
              });
              AppMethodBeat.o(46021);
              return;
              paramAnonymousbiz = ((cmy)localObject1).EhI;
              break;
            }
            label371:
            JsApiAuthorize.AuthorizeTask.e(JsApiAuthorize.AuthorizeTask.this);
            AppMethodBeat.o(46021);
            return;
          }
          JsApiAuthorize.AuthorizeTask.f(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46021);
        }
        
        public final void ac(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46020);
          ad.e("MicroMsg.JsApiAuthorize", "onFailure !");
          JsApiAuthorize.AuthorizeTask.this.jDj = "fail";
          JsApiAuthorize.AuthorizeTask.this.errCode = paramAnonymousInt;
          JsApiAuthorize.AuthorizeTask.this.errMsg = paramAnonymousString;
          JsApiAuthorize.AuthorizeTask.b(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46020);
        }
        
        public final void onSuccess()
        {
          AppMethodBeat.i(46019);
          ad.d("MicroMsg.JsApiAuthorize", "onSuccess !");
          JsApiAuthorize.AuthorizeTask.this.jDj = "ok";
          JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46019);
        }
      };
      Object localObject2;
      Object localObject3;
      int i;
      Object localObject1;
      if (this.jDi.equals("authorize"))
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
          localObject1 = new com.tencent.mm.ab.a.a(this.appId, (LinkedList)localObject3, this.gXn, this.jzi, new JsApiAuthorize.AuthorizeTask.4(this, localException));
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[] { localException.getMessage() });
          this.jDj = "fail";
          aXw();
          AppMethodBeat.o(46029);
          return;
        }
        if (((com.tencent.mm.ab.a.a)localObject1).aea().DGy == null) {
          ((com.tencent.mm.ab.a.a)localObject1).aea().DGy = new dvc();
        }
        ((com.tencent.mm.ab.a.a)localObject1).aea().DGy.EJj = this.jDw;
        com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject1, 0);
        AppMethodBeat.o(46029);
        return;
      }
      if (this.jDi.equals("authorizeConfirm"))
      {
        localObject2 = this.appId;
        localObject3 = this.jDh;
        i = this.gXn;
        int j = this.jDk;
        localObject1 = new com.tencent.mm.ab.a.b((String)localObject2, h.q((ArrayList)localObject3), i, j, this.jzi, new JsApiAuthorize.AuthorizeTask.5(this, (JsApiAuthorize.AuthorizeTask.a)localObject1, j));
        if (((com.tencent.mm.ab.a.b)localObject1).aec().DGy == null) {
          ((com.tencent.mm.ab.a.b)localObject1).aec().DGy = new dvc();
        }
        ((com.tencent.mm.ab.a.b)localObject1).aec().DGy.EJj = this.jDw;
        com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject1, 0);
      }
      AppMethodBeat.o(46029);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46032);
      this.data = paramParcel.readString();
      this.joH = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.jDj = paramParcel.readString();
      this.jDi = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.jDl = paramParcel.readString();
      this.jDt = paramParcel.readInt();
      this.jDu = paramParcel.readBundle(JsApiAuthorize.class.getClassLoader());
      this.jDh = paramParcel.createStringArrayList();
      this.gXn = paramParcel.readInt();
      this.jDk = paramParcel.readInt();
      this.jzi = paramParcel.readInt();
      this.jDw = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      this.jDo = paramParcel.readString();
      this.jDn = paramParcel.readString();
      this.jDm = paramParcel.readString();
      this.jDr = paramParcel.readString();
      this.jDs = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jDp = bool;
        this.jDq = paramParcel.readString();
        this.jDv = paramParcel.readString();
        AppMethodBeat.o(46032);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46033);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.joH);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.jDj);
      paramParcel.writeString(this.jDi);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.jDl);
      paramParcel.writeInt(this.jDt);
      paramParcel.writeBundle(this.jDu);
      paramParcel.writeStringList(this.jDh);
      paramParcel.writeInt(this.gXn);
      paramParcel.writeInt(this.jDk);
      paramParcel.writeInt(this.jzi);
      paramParcel.writeInt(this.jDw);
      paramParcel.writeInt(this.errCode);
      paramParcel.writeString(this.errMsg);
      paramParcel.writeString(this.jDo);
      paramParcel.writeString(this.jDn);
      paramParcel.writeString(this.jDm);
      paramParcel.writeString(this.jDr);
      paramParcel.writeString(this.jDs);
      if (this.jDp) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jDq);
        paramParcel.writeString(this.jDv);
        AppMethodBeat.o(46033);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize
 * JD-Core Version:    0.7.0.1
 */