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
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.r.a.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
  private final i kdz;
  
  public JsApiAuthorize()
  {
    AppMethodBeat.i(174773);
    this.kdz = new i();
    AppMethodBeat.o(174773);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(46043);
    ac.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
    AuthorizeTask localAuthorizeTask = new AuthorizeTask();
    localAuthorizeTask.appId = paramh.getAppId();
    localAuthorizeTask.kdE = "authorize";
    Object localObject = paramh.getRuntime().DI();
    if (localObject != null) {
      localAuthorizeTask.hxM = ((com.tencent.mm.plugin.appbrand.config.k)localObject).jEg.jpa;
    }
    localObject = com.tencent.mm.plugin.appbrand.a.GW(paramh.getAppId());
    if (localObject != null) {
      AuthorizeTask.a(localAuthorizeTask, ((AppBrandStatObject)localObject).scene);
    }
    paramJSONObject = paramJSONObject.toString();
    localAuthorizeTask.kdA = this;
    localAuthorizeTask.kdB = paramh;
    localAuthorizeTask.data = paramJSONObject;
    localAuthorizeTask.jOT = paramInt;
    localAuthorizeTask.kdC = parame;
    localAuthorizeTask.kdQ = new Bundle();
    if ((paramh instanceof com.tencent.mm.plugin.appbrand.q)) {
      localAuthorizeTask.kdS = 1;
    }
    for (;;)
    {
      localAuthorizeTask.bej();
      AppBrandMainProcessService.a(localAuthorizeTask);
      AppMethodBeat.o(46043);
      return;
      if ((paramh instanceof aa)) {
        localAuthorizeTask.kdS = 2;
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
    public int hxM;
    public int jOT;
    private int jZF;
    h kdA;
    com.tencent.mm.plugin.appbrand.jsapi.h kdB;
    e kdC;
    public ArrayList<String> kdD;
    public String kdE;
    public String kdF;
    public int kdG;
    public String kdH;
    public String kdI;
    public String kdJ;
    public String kdK;
    public boolean kdL;
    public String kdM;
    public String kdN;
    public String kdO;
    public int kdP;
    public Bundle kdQ;
    public String kdR;
    int kdS;
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
    
    private void LJ(String paramString)
    {
      AppMethodBeat.i(46031);
      if (TextUtils.isEmpty(paramString)) {
        this.kdA.b(this.kdB, this.jOT, "fail auth cancel");
      }
      for (;;)
      {
        this.kdC.bfe();
        AppMethodBeat.o(46031);
        return;
        this.kdA.b(this.kdB, this.jOT, paramString);
      }
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(46029);
      JsApiAuthorize.AuthorizeTask.a local1 = new JsApiAuthorize.AuthorizeTask.a()
      {
        public final void a(bmr paramAnonymousbmr)
        {
          AppMethodBeat.i(46021);
          ac.d("MicroMsg.JsApiAuthorize", "onConfirm !");
          Object localObject1 = paramAnonymousbmr.ELf;
          JsApiAuthorize.AuthorizeTask.this.kdP = ((LinkedList)localObject1).size();
          int i = 0;
          Object localObject2;
          while (i < JsApiAuthorize.AuthorizeTask.this.kdP)
          {
            localObject2 = (csf)((LinkedList)localObject1).get(i);
            try
            {
              JsApiAuthorize.AuthorizeTask.this.kdQ.putByteArray(String.valueOf(i), ((csf)localObject2).toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousbmr)
            {
              ac.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { paramAnonymousbmr.getMessage() });
              ac.printErrStackTrace("MicroMsg.JsApiAuthorize", paramAnonymousbmr, "", new Object[0]);
              JsApiAuthorize.AuthorizeTask.this.kdF = "fail";
              JsApiAuthorize.AuthorizeTask.c(JsApiAuthorize.AuthorizeTask.this);
              AppMethodBeat.o(46021);
              return;
            }
          }
          JsApiAuthorize.AuthorizeTask.this.mAppName = paramAnonymousbmr.tkL;
          JsApiAuthorize.AuthorizeTask.this.kdH = paramAnonymousbmr.DOl;
          JsApiAuthorize.AuthorizeTask.this.kdI = paramAnonymousbmr.FbX;
          JsApiAuthorize.AuthorizeTask.this.kdK = paramAnonymousbmr.FbW;
          JsApiAuthorize.AuthorizeTask.this.kdJ = paramAnonymousbmr.FbV;
          if (paramAnonymousbmr.FbY != null)
          {
            JsApiAuthorize.AuthorizeTask.this.kdL = paramAnonymousbmr.FbY.DQA;
            JsApiAuthorize.AuthorizeTask.this.kdM = paramAnonymousbmr.FbY.DQB;
          }
          JsApiAuthorize.AuthorizeTask.this.kdF = "needConfirm";
          if (((LinkedList)localObject1).size() > 0)
          {
            localObject1 = (csf)((LinkedList)localObject1).get(0);
            localObject2 = JsApiAuthorize.AuthorizeTask.this;
            if (((csf)localObject1).FEH == null)
            {
              paramAnonymousbmr = "";
              ((JsApiAuthorize.AuthorizeTask)localObject2).kdR = paramAnonymousbmr;
              if (!"scope.userInfo".equals(((csf)localObject1).EdG)) {
                break label371;
              }
              JsApiAuthorize.AuthorizeTask.this.kdO = com.tencent.mm.model.u.axy();
              localObject1 = new StringBuilder("userNickName=");
              if (JsApiAuthorize.AuthorizeTask.this.kdO != null) {
                break label360;
              }
            }
            label360:
            for (paramAnonymousbmr = "";; paramAnonymousbmr = JsApiAuthorize.AuthorizeTask.this.kdO)
            {
              ac.i("MicroMsg.JsApiAuthorize", paramAnonymousbmr);
              paramAnonymousbmr = com.tencent.mm.model.u.axw();
              localObject1 = g.kdw;
              g.a.a(paramAnonymousbmr, new g.b()
              {
                public final void HH(String paramAnonymous2String)
                {
                  AppMethodBeat.i(46018);
                  JsApiAuthorize.AuthorizeTask.this.kdN = paramAnonymous2String;
                  StringBuilder localStringBuilder = new StringBuilder(" userHeadIconPath=");
                  if (JsApiAuthorize.AuthorizeTask.this.kdN == null) {}
                  for (paramAnonymous2String = "";; paramAnonymous2String = JsApiAuthorize.AuthorizeTask.this.kdN)
                  {
                    ac.i("MicroMsg.JsApiAuthorize", paramAnonymous2String);
                    JsApiAuthorize.AuthorizeTask.d(JsApiAuthorize.AuthorizeTask.this);
                    AppMethodBeat.o(46018);
                    return;
                  }
                }
              });
              AppMethodBeat.o(46021);
              return;
              paramAnonymousbmr = ((csf)localObject1).FEH;
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
        
        public final void ad(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(46020);
          ac.e("MicroMsg.JsApiAuthorize", "onFailure !");
          JsApiAuthorize.AuthorizeTask.this.kdF = "fail";
          JsApiAuthorize.AuthorizeTask.this.errCode = paramAnonymousInt;
          JsApiAuthorize.AuthorizeTask.this.errMsg = paramAnonymousString;
          JsApiAuthorize.AuthorizeTask.b(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46020);
        }
        
        public final void onSuccess()
        {
          AppMethodBeat.i(46019);
          ac.d("MicroMsg.JsApiAuthorize", "onSuccess !");
          JsApiAuthorize.AuthorizeTask.this.kdF = "ok";
          JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this);
          AppMethodBeat.o(46019);
        }
      };
      Object localObject2;
      Object localObject3;
      int i;
      Object localObject1;
      if (this.kdE.equals("authorize"))
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
          localObject1 = new com.tencent.mm.aa.a.a(this.appId, (LinkedList)localObject3, this.hxM, this.jZF, new JsApiAuthorize.AuthorizeTask.4(this, localException));
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[] { localException.getMessage() });
          this.kdF = "fail";
          bet();
          AppMethodBeat.o(46029);
          return;
        }
        if (((com.tencent.mm.aa.a.a)localObject1).afq().FbS == null) {
          ((com.tencent.mm.aa.a.a)localObject1).afq().FbS = new eat();
        }
        ((com.tencent.mm.aa.a.a)localObject1).afq().FbS.Ggv = this.kdS;
        com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject1, 0);
        AppMethodBeat.o(46029);
        return;
      }
      if (this.kdE.equals("authorizeConfirm"))
      {
        localObject2 = this.appId;
        localObject3 = this.kdD;
        i = this.hxM;
        int j = this.kdG;
        localObject1 = new com.tencent.mm.aa.a.b((String)localObject2, h.v((ArrayList)localObject3), i, j, this.jZF, new JsApiAuthorize.AuthorizeTask.5(this, (JsApiAuthorize.AuthorizeTask.a)localObject1, j));
        if (((com.tencent.mm.aa.a.b)localObject1).afs().FbS == null) {
          ((com.tencent.mm.aa.a.b)localObject1).afs().FbS = new eat();
        }
        ((com.tencent.mm.aa.a.b)localObject1).afs().FbS.Ggv = this.kdS;
        com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject1, 0);
      }
      AppMethodBeat.o(46029);
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(46030);
      bek();
      if (!this.kdB.isRunning())
      {
        this.kdC.bfe();
        AppMethodBeat.o(46030);
        return;
      }
      if (this.kdF.equals("ok"))
      {
        this.kdA.b(this.kdB, this.jOT, "ok");
        this.kdC.bfe();
        AppMethodBeat.o(46030);
        return;
      }
      Object localObject;
      if (this.kdF.equals("fail"))
      {
        if (bs.isNullOrNil(this.errMsg)) {}
        for (localObject = String.format("fail:login error %s", new Object[] { Integer.valueOf(this.errCode) });; localObject = String.format("fail:%s", new Object[] { this.errMsg }))
        {
          this.kdA.b(this.kdB, this.jOT, (String)localObject);
          this.kdC.bfe();
          AppMethodBeat.o(46030);
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
            ac.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[] { localIOException.getMessage() });
            ac.printErrStackTrace("MicroMsg.JsApiAuthorize", localIOException, "", new Object[0]);
            this.kdA.b(this.kdB, this.jOT, "fail:internal error scope error");
            this.kdC.bfe();
            AppMethodBeat.o(46030);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.kdB.N(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46024);
              csf localcsf = (csf)localIOException.get(0);
              AppBrandRuntime localAppBrandRuntime = JsApiAuthorize.AuthorizeTask.this.kdB.getRuntime();
              boolean bool2 = com.tencent.mm.plugin.appbrand.permission.n.a(localcsf.EdG, localAppBrandRuntime.DI());
              boolean bool1;
              final com.tencent.mm.plugin.appbrand.widget.dialog.i locali;
              if ((JsApiAuthorize.AuthorizeTask.this.kdB.getRuntime().getWindowAndroid() != null) && (JsApiAuthorize.AuthorizeTask.this.kdB.getRuntime().getWindowAndroid().aTx()))
              {
                bool1 = true;
                locali = new com.tencent.mm.plugin.appbrand.widget.dialog.i(localAppBrandRuntime.aSA().getContext(), new i.b()
                {
                  public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2)
                  {
                    AppMethodBeat.i(46022);
                    if (com.tencent.luggage.h.b.C(paramAnonymous2ArrayList).size() > 0)
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
                      ac.i("MicroMsg.JsApiAuthorize", "click PositiveButton");
                      AppMethodBeat.o(46022);
                      return;
                      localArrayList = new ArrayList();
                      localArrayList.add(paramAnonymous2ArrayList);
                      JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, 2, localArrayList);
                      ac.i("MicroMsg.JsApiAuthorize", "click NegativeButton");
                      AppMethodBeat.o(46022);
                      return;
                      JsApiAuthorize.AuthorizeTask.g(JsApiAuthorize.AuthorizeTask.this);
                      ac.i("MicroMsg.JsApiAuthorize", "user cancel");
                    }
                  }
                }, bool1);
                locali.RP(localAppBrandRuntime.DI().ddh);
                locali.RS(JsApiAuthorize.AuthorizeTask.this.kdI);
                locali.RQ(localcsf.Desc);
                locali.Us(JsApiAuthorize.AuthorizeTask.this.kdJ);
                locali.asC(JsApiAuthorize.AuthorizeTask.this.kdK);
                locali.qV(JsApiAuthorize.AuthorizeTask.this.kdH);
                if ((!JsApiAuthorize.AuthorizeTask.this.kdL) || (TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.kdM))) {
                  break label358;
                }
                locali.hW(true);
                locali.b(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(46023);
                    JsApiAuthorize.AuthorizeTask.this.kdB.aSs().b(new com.tencent.mm.plugin.appbrand.phonenumber.k(JsApiAuthorize.AuthorizeTask.this.kdB.aSs(), JsApiAuthorize.AuthorizeTask.this.kdB, JsApiAuthorize.AuthorizeTask.this.kdM, h.c(JsApiAuthorize.AuthorizeTask.this.kdB), locali.ijA.getMeasuredHeight()));
                    AppMethodBeat.o(46023);
                  }
                });
                label227:
                if (!"scope.userInfo".equals(localcsf.EdG)) {
                  break label367;
                }
                Object localObject = g.kdw;
                localObject = JsApiAuthorize.AuthorizeTask.this.kdB.getContext();
                Bitmap localBitmap = com.tencent.mm.aj.e.Ae(JsApiAuthorize.AuthorizeTask.this.kdN);
                String str1 = JsApiAuthorize.AuthorizeTask.this.kdO;
                String str2 = localcsf.EdG;
                d.g.b.k.h(localObject, "context");
                d.g.b.k.h(locali, "dialog");
                f.c.a((Context)localObject, localBitmap, str1, str2, locali);
              }
              for (;;)
              {
                if (bool2)
                {
                  if (TextUtils.isEmpty(com.tencent.mm.plugin.appbrand.permission.n.a(localcsf.EdG, localAppBrandRuntime)))
                  {
                    JsApiAuthorize.AuthorizeTask.a(JsApiAuthorize.AuthorizeTask.this, "fail:require permission desc");
                    ac.i("MicroMsg.JsApiAuthorize", "error = fail:require permission desc");
                    AppMethodBeat.o(46024);
                    return;
                    bool1 = false;
                    break;
                    label358:
                    locali.hW(false);
                    break label227;
                    label367:
                    locali.aBQ(localcsf.EdG);
                    continue;
                  }
                  locali.RR(com.tencent.mm.plugin.appbrand.permission.n.a(localcsf.EdG, localAppBrandRuntime));
                }
              }
              for (;;)
              {
                ac.i("MicroMsg.JsApiAuthorize", "Confirm dialog scope=%s desc =%s auth_desc=%s ext_desc=%s", new Object[] { localcsf.EdG, localcsf.Desc, localcsf.Fbk, localcsf.lLR });
                localAppBrandRuntime.iky.b(locali);
                AppMethodBeat.o(46024);
                return;
                if (!TextUtils.isEmpty(JsApiAuthorize.AuthorizeTask.this.kdR)) {
                  locali.RR(JsApiAuthorize.AuthorizeTask.this.kdR);
                }
              }
            }
          });
          AppMethodBeat.o(46030);
          return;
        }
        this.kdA.b(this.kdB, this.jOT, "fail:internal error scope empty");
        this.kdC.bfe();
      }
      AppMethodBeat.o(46030);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(46032);
      this.data = paramParcel.readString();
      this.jOT = paramParcel.readInt();
      this.appId = paramParcel.readString();
      this.kdF = paramParcel.readString();
      this.kdE = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.kdH = paramParcel.readString();
      this.kdP = paramParcel.readInt();
      this.kdQ = paramParcel.readBundle(JsApiAuthorize.class.getClassLoader());
      this.kdD = paramParcel.createStringArrayList();
      this.hxM = paramParcel.readInt();
      this.kdG = paramParcel.readInt();
      this.jZF = paramParcel.readInt();
      this.kdS = paramParcel.readInt();
      this.errCode = paramParcel.readInt();
      this.errMsg = paramParcel.readString();
      this.kdK = paramParcel.readString();
      this.kdJ = paramParcel.readString();
      this.kdI = paramParcel.readString();
      this.kdN = paramParcel.readString();
      this.kdO = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.kdL = bool;
        this.kdM = paramParcel.readString();
        this.kdR = paramParcel.readString();
        AppMethodBeat.o(46032);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46033);
      paramParcel.writeString(this.data);
      paramParcel.writeInt(this.jOT);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kdF);
      paramParcel.writeString(this.kdE);
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
      paramParcel.writeString(this.kdK);
      paramParcel.writeString(this.kdJ);
      paramParcel.writeString(this.kdI);
      paramParcel.writeString(this.kdN);
      paramParcel.writeString(this.kdO);
      if (this.kdL) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kdM);
        paramParcel.writeString(this.kdR);
        AppMethodBeat.o(46033);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize
 * JD-Core Version:    0.7.0.1
 */