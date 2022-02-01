package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.p.d;
import com.tencent.mm.plugin.appbrand.p.e.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.a.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import d.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiOperateWXData
  extends h
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  private final k jEd;
  
  public JsApiOperateWXData()
  {
    AppMethodBeat.i(174777);
    this.jEd = new k();
    AppMethodBeat.o(174777);
  }
  
  public static void clear(String paramString)
  {
    AppMethodBeat.i(46104);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(46104);
      return;
    }
    try
    {
      OperateWXDataTask.aYr();
      String[] arrayOfString = OperateWXDataTask.adI().allKeys();
      if (arrayOfString == null)
      {
        AppMethodBeat.o(46104);
        return;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((!TextUtils.isEmpty(str)) && (str.startsWith(paramString))) {
          OperateWXDataTask.adI().remove(str);
        }
        i += 1;
      }
      AppMethodBeat.o(46104);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "clear(%s) e=%s", new Object[] { paramString, localThrowable });
      AppMethodBeat.o(46104);
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(46103);
    for (;;)
    {
      try
      {
        String str = paramJSONObject.getString("data");
        boolean bool = paramJSONObject.optBoolean("isImportant");
        paramJSONObject = new OperateWXDataTask();
        paramJSONObject.appId = paramh.getAppId();
        paramJSONObject.jDi = "operateWXData";
        com.tencent.mm.plugin.appbrand.config.k localk = paramh.getRuntime().Ef();
        if (localk != null) {
          paramJSONObject.gXn = localk.jdS.iOQ;
        }
        paramJSONObject.jDe = this;
        paramJSONObject.jDf = paramh;
        paramJSONObject.jEf = str;
        paramJSONObject.jEo = bool;
        paramJSONObject.joH = paramInt;
        paramJSONObject.jDg = parame;
        paramJSONObject.jEk = new HashMap();
        parame = a.CT(paramJSONObject.appId);
        if (parame != null) {
          paramJSONObject.jzi = parame.scene;
        }
        if ((paramh instanceof com.tencent.mm.plugin.appbrand.q))
        {
          paramJSONObject.jDw = 1;
          paramJSONObject.aXm();
          AppBrandMainProcessService.a(paramJSONObject);
          AppMethodBeat.o(46103);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "Exception %s", new Object[] { paramJSONObject.getMessage() });
        paramh.h(paramInt, e("fail", null));
        parame.aYh();
        AppMethodBeat.o(46103);
        return;
      }
      if ((paramh instanceof aa)) {
        paramJSONObject.jDw = 2;
      }
    }
  }
  
  static class OperateWXDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateWXDataTask> CREATOR;
    private static final ax jEe;
    public String appId;
    public int gXn;
    h jDe;
    com.tencent.mm.plugin.appbrand.jsapi.h jDf;
    e jDg;
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
    public String jDv;
    int jDw;
    public String jEf;
    public String jEg;
    public String jEh;
    public int jEi;
    public String jEj;
    public Map<String, byte[]> jEk;
    public MMUserAvatarInfo jEl;
    int jEm;
    private boolean jEn;
    boolean jEo;
    public int joH;
    int jzi;
    public String mAppName;
    
    static
    {
      AppMethodBeat.i(46102);
      jEe = ax.aFC("MicroMsg.AppBrand.JsApiOperateWXData");
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46102);
    }
    
    public OperateWXDataTask()
    {
      AppMethodBeat.i(174776);
      this.jDs = "";
      this.jDr = "";
      AppMethodBeat.o(174776);
    }
    
    public OperateWXDataTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46085);
      this.jDs = "";
      this.jDr = "";
      e(paramParcel);
      AppMethodBeat.o(46085);
    }
    
    private void a(String paramString1, final String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, final a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(46092);
      if (!paramBoolean) {
        ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateWxData");
      }
      for (paramString1 = new com.tencent.mm.plugin.appbrand.p.e(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.jzi, new e.a() {});; paramString1 = new d(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.jzi, new e.a() {}))
      {
        paramString1.tj(this.jDw);
        com.tencent.mm.kernel.g.aeS().a(paramString1, 0);
        AppMethodBeat.o(46092);
        return;
        ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateImportantWxData");
      }
    }
    
    static void aYr() {}
    
    final void a(int paramInt1, int paramInt2, String paramString1, com.tencent.mm.plugin.appbrand.p.e parame, String paramString2, a parama)
    {
      AppMethodBeat.i(46093);
      ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        parama.cj(String.format("cgi fail(%d,%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
        AppMethodBeat.o(46093);
        return;
      }
      if (parame != null)
      {
        if (this.jDk == 2)
        {
          ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "press reject button");
          AppMethodBeat.o(46093);
          return;
        }
        if (parame.rr == null) {}
        for (paramString1 = null; paramString1.DGz == null; paramString1 = (bjf)parame.rr.gUT.gUX)
        {
          ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "JsApiBaseResponse is null, enterData:".concat(String.valueOf(paramString2)));
          parama.cj("cgi fail response null");
          AppMethodBeat.o(46093);
          return;
        }
        paramInt1 = paramString1.DGz.dhR;
        parame = paramString1.DGz.dhS;
        Object localObject = paramString1.DGL;
        LinkedList localLinkedList = new LinkedList();
        if (localObject != null) {
          localLinkedList.add(localObject);
        }
        localObject = paramString1.scR;
        String str = paramString1.CvQ;
        ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == -12000)
        {
          this.jDm = paramString1.DGD;
          this.jDo = paramString1.DGC;
          this.jDn = paramString1.DGB;
          if (paramString1.DGE != null)
          {
            this.jDp = paramString1.DGE.Cye;
            this.jDq = paramString1.DGE.Cyf;
          }
          if (paramString1.DGO != null) {
            this.jEl = new MMUserAvatarInfo(paramString1.DGO);
          }
          parama.a(localLinkedList, (String)localObject, str);
          AppMethodBeat.o(46093);
          return;
        }
        if (paramInt1 == 0)
        {
          if (paramString1.mAx == null)
          {
            ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "Data is null, enterData:".concat(String.valueOf(paramString2)));
            parama.cj("internal error");
            AppMethodBeat.o(46093);
            return;
          }
          paramString1 = paramString1.mAx.eBA();
          ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "resp data %s", new Object[] { paramString1 });
          parama.onSuccess(paramString1);
          AppMethodBeat.o(46093);
          return;
        }
        ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", new Object[] { parame });
        parama.cj(parame);
      }
      AppMethodBeat.o(46093);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(46088);
      aXn();
      if (!this.jDf.isRunning())
      {
        this.jDg.aYh();
        AppMethodBeat.o(46088);
        return;
      }
      Object localObject2;
      Object localObject1;
      if (this.jDj.equals("ok"))
      {
        localObject2 = new HashMap();
        String str = this.jEg;
        localObject1 = str;
        if (!TextUtils.isEmpty(this.jEh)) {
          localObject1 = str;
        }
        try
        {
          str = jEe.getString(this.jEh, "");
          localObject1 = str;
          jEe.remove(this.jEh);
          localObject1 = str;
          JsApiOperateWXData.nb(2L);
          localObject1 = str;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInClientProcess loginResult ok, get data from XProcessStore failed, appId[%s], callbackId[%d], e=%s", new Object[] { this.appId, Integer.valueOf(this.joH), localThrowable });
            JsApiOperateWXData.nb(3L);
          }
        }
        ((Map)localObject2).put("data", localObject1);
        this.jDf.h(this.joH, this.jDe.k("ok", (Map)localObject2));
        this.jDg.aYh();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.jDj.contains("fail"))
      {
        this.jDe.b(this.jDf, this.joH, this.jDj);
        this.jDg.aYh();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.jDj.equals("needConfirm"))
      {
        localObject1 = new LinkedList();
        int i = 0;
        while (i < this.jDt)
        {
          byte[] arrayOfByte = (byte[])this.jEk.get(String.valueOf(i));
          localObject2 = new cmy();
          try
          {
            ((cmy)localObject2).parseFrom(arrayOfByte);
            ((LinkedList)localObject1).add(localObject2);
            i += 1;
          }
          catch (IOException localIOException)
          {
            ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { localIOException.getMessage() });
            ad.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", localIOException, "", new Object[0]);
            this.jDe.b(this.jDf, this.joH, "fail");
            this.jDg.aYh();
            AppMethodBeat.o(46088);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180209);
              Object localObject1 = (cmy)localIOException.getFirst();
              Object localObject2 = new i.b()
              {
                public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(180203);
                  ad.i("MicroMsg.AppBrand.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  switch (paramAnonymous2Int1)
                  {
                  default: 
                    ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "press back button!");
                    JsApiOperateWXData.OperateWXDataTask.this.jDe.b(JsApiOperateWXData.OperateWXDataTask.this.jDf, JsApiOperateWXData.OperateWXDataTask.this.joH, "fail auth cancel");
                    JsApiOperateWXData.OperateWXDataTask.this.jDg.aYh();
                    AppMethodBeat.o(180203);
                    return;
                  }
                  JsApiOperateWXData.OperateWXDataTask.this.jDi = "operateWXDataConfirm";
                  JsApiOperateWXData.OperateWXDataTask localOperateWXDataTask = JsApiOperateWXData.OperateWXDataTask.this;
                  if (paramAnonymous2ArrayList.size() > 0) {}
                  for (paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);; paramAnonymous2ArrayList = "")
                  {
                    localOperateWXDataTask.jEj = paramAnonymous2ArrayList;
                    JsApiOperateWXData.OperateWXDataTask.this.jDk = paramAnonymous2Int1;
                    JsApiOperateWXData.OperateWXDataTask.this.jEi = paramAnonymous2Int2;
                    AppBrandMainProcessService.a(JsApiOperateWXData.OperateWXDataTask.this);
                    if (paramAnonymous2Int1 != 2) {
                      break;
                    }
                    JsApiOperateWXData.OperateWXDataTask.this.jDe.b(JsApiOperateWXData.OperateWXDataTask.this.jDf, JsApiOperateWXData.OperateWXDataTask.this.joH, "fail auth deny");
                    JsApiOperateWXData.OperateWXDataTask.this.jDg.aYh();
                    AppMethodBeat.o(180203);
                    return;
                  }
                }
              };
              boolean bool;
              if ((JsApiOperateWXData.OperateWXDataTask.this.jDf.getRuntime().getWindowAndroid() != null) && (JsApiOperateWXData.OperateWXDataTask.this.jDf.getRuntime().getWindowAndroid().aMH()))
              {
                bool = true;
                localObject2 = new i(h.c(JsApiOperateWXData.OperateWXDataTask.this.jDf), (i.b)localObject2, bool);
                ((i)localObject2).aUE(JsApiOperateWXData.OperateWXDataTask.this.mAppName);
                ((i)localObject2).aUF(((cmy)localObject1).Desc);
                ((i)localObject2).aUH(JsApiOperateWXData.OperateWXDataTask.this.jDm);
                ((i)localObject2).aUI(JsApiOperateWXData.OperateWXDataTask.this.jDn);
                ((i)localObject2).aUJ(JsApiOperateWXData.OperateWXDataTask.this.jDo);
                ((i)localObject2).nP(JsApiOperateWXData.OperateWXDataTask.this.jDl);
                if ((!JsApiOperateWXData.OperateWXDataTask.this.jDp) || (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.jDq))) {
                  break label333;
                }
                ((i)localObject2).yt(true);
                ((i)localObject2).b(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(180204);
                    JsApiOperateWXData.OperateWXDataTask.this.jDf.aLB().b(new com.tencent.mm.plugin.appbrand.phonenumber.k(JsApiOperateWXData.OperateWXDataTask.this.jDf.aLB(), JsApiOperateWXData.OperateWXDataTask.this.jDf, JsApiOperateWXData.OperateWXDataTask.this.jDq, h.c(JsApiOperateWXData.OperateWXDataTask.this.jDf), this.jDB.hIZ.getMeasuredHeight()));
                    AppMethodBeat.o(180204);
                  }
                });
                label192:
                if (!TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.jDv)) {
                  ((i)localObject2).aUG(JsApiOperateWXData.OperateWXDataTask.this.jDv);
                }
                if (!"scope.userInfo".equals(((cmy)localObject1).CLe)) {
                  break label414;
                }
                if (JsApiOperateWXData.OperateWXDataTask.this.jEl == null) {
                  break label341;
                }
                localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b(JsApiOperateWXData.OperateWXDataTask.this.jDf.getContext(), JsApiOperateWXData.OperateWXDataTask.this.jEl, ((cmy)localObject1).CLe, new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c()
                {
                  public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2, d.g.a.m<? super Activity, ? super String, y> paramAnonymous2m)
                  {
                    AppMethodBeat.i(180205);
                    if ((paramAnonymous2Boolean1) || (paramAnonymous2Boolean2))
                    {
                      if (!paramAnonymous2Boolean1)
                      {
                        this.jDB.aUK(paramAnonymous2String1);
                        this.jDB.agO(JsApiOperateWXData.OperateWXDataTask.this.jDf.getContext().getResources().getColor(2131099660));
                      }
                      for (;;)
                      {
                        JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.jDB, false, paramAnonymous2m);
                        AppMethodBeat.o(180205);
                        return;
                        this.jDB.aUK("");
                      }
                    }
                    this.jDB.aUK(paramAnonymous2String2);
                    this.jDB.agO(JsApiOperateWXData.OperateWXDataTask.this.jDf.getContext().getResources().getColor(2131100547));
                    JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.jDB, true, paramAnonymous2m);
                    AppMethodBeat.o(180205);
                  }
                  
                  public final void bl(List<o.a> paramAnonymous2List)
                  {
                    AppMethodBeat.i(180206);
                    this.jDB.dA(paramAnonymous2List);
                    AppMethodBeat.o(180206);
                  }
                });
                ((i)localObject2).a(new o.b()
                {
                  public final void a(o.a paramAnonymous2a)
                  {
                    AppMethodBeat.i(180207);
                    this.jEs.b(paramAnonymous2a);
                    AppMethodBeat.o(180207);
                  }
                });
                ((i)localObject2).a(new o.c()
                {
                  public final void a(View paramAnonymous2View, o.a paramAnonymous2a, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(180208);
                    paramAnonymous2a = this.jEs;
                    TouchableLayout.a locala = TouchableLayout.HYe;
                    int i = TouchableLayout.fiK();
                    locala = TouchableLayout.HYe;
                    paramAnonymous2a.a(paramAnonymous2View, paramAnonymous2Int, i, TouchableLayout.fiL());
                    AppMethodBeat.o(180208);
                  }
                });
              }
              for (;;)
              {
                JsApiOperateWXData.OperateWXDataTask.this.jDf.aLB().b((com.tencent.mm.plugin.appbrand.widget.dialog.k)localObject2);
                AppMethodBeat.o(180209);
                return;
                bool = false;
                break;
                label333:
                ((i)localObject2).yt(false);
                break label192;
                label341:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new o.a(JsApiOperateWXData.OperateWXDataTask.this.jDs, JsApiOperateWXData.OperateWXDataTask.this.jDf.getContext().getResources().getString(2131755946), ((cmy)localObject1).CLe, com.tencent.mm.ak.e.vY(JsApiOperateWXData.OperateWXDataTask.this.jDr), (byte)0));
                ((i)localObject2).dA(localArrayList);
                continue;
                label414:
                ((i)localObject2).aUL(((cmy)localObject1).CLe);
              }
            }
          });
          AppMethodBeat.o(46088);
          return;
        }
        this.jDe.b(this.jDf, this.joH, "fail");
        this.jDg.aYh();
      }
      AppMethodBeat.o(46088);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(46086);
      a local1 = new a()
      {
        public final void a(LinkedList<cmy> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(46068);
          ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "onConfirm !");
          JsApiOperateWXData.OperateWXDataTask.this.jDt = paramAnonymousLinkedList.size();
          int i = 0;
          while (i < JsApiOperateWXData.OperateWXDataTask.this.jDt)
          {
            cmy localcmy = (cmy)paramAnonymousLinkedList.get(i);
            try
            {
              JsApiOperateWXData.OperateWXDataTask.this.jEk.put(String.valueOf(i), localcmy.toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousLinkedList)
            {
              ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
              ad.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList, "", new Object[0]);
              JsApiOperateWXData.OperateWXDataTask.this.jDj = "fail";
              JsApiOperateWXData.OperateWXDataTask.d(JsApiOperateWXData.OperateWXDataTask.this);
              AppMethodBeat.o(46068);
              return;
            }
          }
          JsApiOperateWXData.OperateWXDataTask.this.mAppName = paramAnonymousString1;
          JsApiOperateWXData.OperateWXDataTask.this.jDl = paramAnonymousString2;
          JsApiOperateWXData.OperateWXDataTask.this.jDj = "needConfirm";
          if (paramAnonymousLinkedList.size() > 0)
          {
            paramAnonymousString1 = (cmy)paramAnonymousLinkedList.get(0);
            paramAnonymousString2 = JsApiOperateWXData.OperateWXDataTask.this;
            if (paramAnonymousString1.EhI == null)
            {
              paramAnonymousLinkedList = "";
              paramAnonymousString2.jDv = paramAnonymousLinkedList;
              if (!"scope.userInfo".equals(paramAnonymousString1.CLe)) {
                break label299;
              }
              JsApiOperateWXData.OperateWXDataTask.this.jDs = u.aqI();
              paramAnonymousString1 = new StringBuilder("userNickName=");
              if (JsApiOperateWXData.OperateWXDataTask.this.jDs != null) {
                break label288;
              }
            }
            label288:
            for (paramAnonymousLinkedList = "";; paramAnonymousLinkedList = JsApiOperateWXData.OperateWXDataTask.this.jDs)
            {
              ad.i("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList);
              paramAnonymousLinkedList = u.aqG();
              paramAnonymousString1 = g.jDa;
              g.a.a(paramAnonymousLinkedList, new g.b()
              {
                public final void DD(String paramAnonymous2String)
                {
                  AppMethodBeat.i(46065);
                  JsApiOperateWXData.OperateWXDataTask.this.jDr = paramAnonymous2String;
                  JsApiOperateWXData.OperateWXDataTask.e(JsApiOperateWXData.OperateWXDataTask.this);
                  AppMethodBeat.o(46065);
                }
              });
              AppMethodBeat.o(46068);
              return;
              paramAnonymousLinkedList = paramAnonymousString1.EhI;
              break;
            }
            label299:
            JsApiOperateWXData.OperateWXDataTask.f(JsApiOperateWXData.OperateWXDataTask.this);
            AppMethodBeat.o(46068);
            return;
          }
          JsApiOperateWXData.OperateWXDataTask.g(JsApiOperateWXData.OperateWXDataTask.this);
          AppMethodBeat.o(46068);
        }
        
        public final void cj(String paramAnonymousString)
        {
          AppMethodBeat.i(46067);
          ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "onFailure !");
          JsApiOperateWXData.OperateWXDataTask.this.jDj = "fail:".concat(String.valueOf(paramAnonymousString));
          JsApiOperateWXData.OperateWXDataTask.c(JsApiOperateWXData.OperateWXDataTask.this);
          AppMethodBeat.o(46067);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(46066);
          ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSuccess !");
          try
          {
            JsApiOperateWXData.OperateWXDataTask.this.jEh = org.apache.commons.b.g.a(new String[] { JsApiOperateWXData.OperateWXDataTask.this.appId, JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this), JsApiOperateWXData.OperateWXDataTask.this.joH, bt.GC() }, "$");
            JsApiOperateWXData.OperateWXDataTask.adI().putString(JsApiOperateWXData.OperateWXDataTask.this.jEh, paramAnonymousString).commit();
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.adI().getString(JsApiOperateWXData.OperateWXDataTask.this.jEh, null)))
            {
              IOException localIOException = new IOException("write data failed");
              AppMethodBeat.o(46066);
              throw localIOException;
            }
          }
          catch (Throwable localThrowable)
          {
            ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInMainProcess::onSuccess, write to XProcessStore failed, appId[%s], callbackId[%d] e=%s", new Object[] { JsApiOperateWXData.OperateWXDataTask.this.appId, Integer.valueOf(JsApiOperateWXData.OperateWXDataTask.this.joH), localThrowable });
            JsApiOperateWXData.OperateWXDataTask.this.jEh = null;
            JsApiOperateWXData.nb(1L);
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.jEh)) {
              JsApiOperateWXData.OperateWXDataTask.this.jEg = paramAnonymousString;
            }
            for (;;)
            {
              JsApiOperateWXData.OperateWXDataTask.this.jDj = "ok";
              JsApiOperateWXData.OperateWXDataTask.b(JsApiOperateWXData.OperateWXDataTask.this);
              AppMethodBeat.o(46066);
              return;
              JsApiOperateWXData.nb(0L);
              if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.jEh)) {
                JsApiOperateWXData.OperateWXDataTask.this.jEg = paramAnonymousString;
              }
            }
          }
          finally
          {
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.jEh)) {
              JsApiOperateWXData.OperateWXDataTask.this.jEg = paramAnonymousString;
            }
            AppMethodBeat.o(46066);
          }
        }
      };
      if (this.jDi.equals("operateWXData"))
      {
        a(this.appId, this.jEf, "", this.gXn, this.jDk, 0, local1, this.jEo);
        AppMethodBeat.o(46086);
        return;
      }
      if (this.jDi.equals("operateWXDataConfirm")) {
        a(this.appId, this.jEf, this.jEj, this.gXn, this.jDk, this.jEi, local1, this.jEo);
      }
      AppMethodBeat.o(46086);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46090);
      this.appId = paramParcel.readString();
      this.jDj = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.jDl = paramParcel.readString();
      this.jEf = paramParcel.readString();
      this.jEg = paramParcel.readString();
      this.jEh = paramParcel.readString();
      this.joH = paramParcel.readInt();
      this.jDi = paramParcel.readString();
      this.jEj = paramParcel.readString();
      this.jDt = paramParcel.readInt();
      this.jEk = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.gXn = paramParcel.readInt();
      this.jDk = paramParcel.readInt();
      this.jzi = paramParcel.readInt();
      this.jDw = paramParcel.readInt();
      this.jDs = paramParcel.readString();
      this.jDr = paramParcel.readString();
      this.jDo = paramParcel.readString();
      this.jDn = paramParcel.readString();
      this.jDm = paramParcel.readString();
      this.jEl = ((MMUserAvatarInfo)paramParcel.readParcelable(MMUserAvatarInfo.class.getClassLoader()));
      this.jEm = paramParcel.readInt();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.jEn = bool1;
        this.jEi = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label288;
        }
        bool1 = true;
        label240:
        this.jEo = bool1;
        if (paramParcel.readInt() != 1) {
          break label293;
        }
      }
      label288:
      label293:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.jDp = bool1;
        this.jDq = paramParcel.readString();
        this.jDv = paramParcel.readString();
        AppMethodBeat.o(46090);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label240;
      }
    }
    
    public final void fK(boolean paramBoolean)
    {
      AppMethodBeat.i(46087);
      super.fK(paramBoolean);
      if (paramBoolean) {}
      for (long l = 4L;; l = 5L)
      {
        JsApiOperateWXData.nb(l);
        AppMethodBeat.o(46087);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(46091);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.jDj);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.jDl);
      paramParcel.writeString(this.jEf);
      paramParcel.writeString(this.jEg);
      paramParcel.writeString(this.jEh);
      paramParcel.writeInt(this.joH);
      paramParcel.writeString(this.jDi);
      paramParcel.writeString(this.jEj);
      paramParcel.writeInt(this.jDt);
      paramParcel.writeMap(this.jEk);
      paramParcel.writeInt(this.gXn);
      paramParcel.writeInt(this.jDk);
      paramParcel.writeInt(this.jzi);
      paramParcel.writeInt(this.jDw);
      paramParcel.writeString(this.jDs);
      paramParcel.writeString(this.jDr);
      paramParcel.writeString(this.jDo);
      paramParcel.writeString(this.jDn);
      paramParcel.writeString(this.jDm);
      paramParcel.writeParcelable(this.jEl, paramInt);
      paramParcel.writeInt(this.jEm);
      if (this.jEn)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.jEi);
        if (!this.jEo) {
          break label271;
        }
        paramInt = 1;
        label224:
        paramParcel.writeInt(paramInt);
        if (!this.jDp) {
          break label276;
        }
      }
      label271:
      label276:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jDq);
        paramParcel.writeString(this.jDv);
        AppMethodBeat.o(46091);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label224;
      }
    }
    
    public static abstract interface a
    {
      public abstract void a(LinkedList<cmy> paramLinkedList, String paramString1, String paramString2);
      
      public abstract void cj(String paramString);
      
      public abstract void onSuccess(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData
 * JD-Core Version:    0.7.0.1
 */