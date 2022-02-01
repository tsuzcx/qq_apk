package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.n.e.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.permission.a.b.a;
import com.tencent.mm.plugin.appbrand.permission.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.brh;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiOperateWXData
  extends i
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  private final m kzj;
  
  public JsApiOperateWXData()
  {
    AppMethodBeat.i(174777);
    this.kzj = new m();
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
      OperateWXDataTask.biR();
      String[] arrayOfString = OperateWXDataTask.ahK().allKeys();
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
          OperateWXDataTask.ahK().remove(str);
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
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(188298);
    for (;;)
    {
      try
      {
        String str = paramJSONObject.getString("data");
        boolean bool = paramJSONObject.optBoolean("isImportant");
        paramJSONObject = new OperateWXDataTask();
        paramJSONObject.appId = paramd.getAppId();
        paramJSONObject.kyl = "operateWXData";
        k localk = paramd.getRuntime().Fh();
        if (localk != null) {
          paramJSONObject.hQh = localk.jYh.jIU;
        }
        paramJSONObject.kyh = this;
        paramJSONObject.kyi = paramd;
        paramJSONObject.kzl = str;
        paramJSONObject.kzu = bool;
        paramJSONObject.kje = paramInt;
        paramJSONObject.kyj = parame;
        paramJSONObject.kzq = new HashMap();
        parame = com.tencent.mm.plugin.appbrand.a.Kl(paramJSONObject.appId);
        if (parame != null) {
          paramJSONObject.kub = parame.scene;
        }
        if ((paramd instanceof com.tencent.mm.plugin.appbrand.q))
        {
          paramJSONObject.kyA = 1;
          paramJSONObject.bhN();
          AppBrandMainProcessService.a(paramJSONObject);
          AppMethodBeat.o(188298);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "Exception %s", new Object[] { paramJSONObject.getMessage() });
        paramd.h(paramInt, e("fail", null));
        parame.biH();
        AppMethodBeat.o(188298);
        return;
      }
      if ((paramd instanceof aa)) {
        paramJSONObject.kyA = 2;
      }
    }
  }
  
  static class OperateWXDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateWXDataTask> CREATOR;
    private static final ax kzk;
    public String appId;
    public int cgiErrorCode;
    public int hQh;
    public int kje;
    int kub;
    int kyA;
    transient i kyh;
    transient com.tencent.mm.plugin.appbrand.d kyi;
    transient e kyj;
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
    public String kyy;
    public String kzl;
    public String kzm;
    public String kzn;
    public int kzo;
    public String kzp;
    public Map<String, byte[]> kzq;
    public MMUserAvatarInfo kzr;
    int kzs;
    private boolean kzt;
    boolean kzu;
    public String mAppName;
    
    static
    {
      AppMethodBeat.i(46102);
      kzk = ax.aQz("MicroMsg.AppBrand.JsApiOperateWXData");
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46102);
    }
    
    public OperateWXDataTask()
    {
      AppMethodBeat.i(174776);
      this.kyv = "";
      this.kyu = "";
      AppMethodBeat.o(174776);
    }
    
    public OperateWXDataTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46085);
      this.kyv = "";
      this.kyu = "";
      e(paramParcel);
      AppMethodBeat.o(46085);
    }
    
    private void a(String paramString1, final String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, final a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(46092);
      if (!paramBoolean) {
        ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateWxData");
      }
      for (paramString1 = new com.tencent.mm.plugin.appbrand.n.e(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.kub, new e.a() {});; paramString1 = new com.tencent.mm.plugin.appbrand.n.d(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.kub, new e.a() {}))
      {
        paramString1.uE(this.kyA);
        com.tencent.mm.kernel.g.aiU().a(paramString1, 0);
        AppMethodBeat.o(46092);
        return;
        ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateImportantWxData");
      }
    }
    
    static void biR() {}
    
    final void a(int paramInt1, int paramInt2, String paramString1, com.tencent.mm.plugin.appbrand.n.e parame, String paramString2, a parama)
    {
      AppMethodBeat.i(46093);
      ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        parama.bC(String.format("cgi fail(%d,%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0);
        AppMethodBeat.o(46093);
        return;
      }
      if (parame != null)
      {
        if (this.kyn == 2)
        {
          ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "press reject button");
          AppMethodBeat.o(46093);
          return;
        }
        if (parame.rr == null) {}
        for (paramString1 = null; paramString1.GLs == null; paramString1 = (brh)parame.rr.hNL.hNQ)
        {
          ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "JsApiBaseResponse is null, enterData:".concat(String.valueOf(paramString2)));
          parama.bC("cgi fail response null", 0);
          AppMethodBeat.o(46093);
          return;
        }
        paramInt1 = paramString1.GLs.dqI;
        parame = paramString1.GLs.dqJ;
        Object localObject = paramString1.GLF;
        LinkedList localLinkedList = new LinkedList();
        if (localObject != null) {
          localLinkedList.add(localObject);
        }
        localObject = paramString1.uiR;
        String str = paramString1.Fts;
        ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == -12000)
        {
          this.kyp = paramString1.GLx;
          this.kyr = paramString1.GLw;
          this.kyq = paramString1.GLv;
          if (paramString1.GLy != null)
          {
            this.kys = paramString1.GLy.FvP;
            this.kyt = paramString1.GLy.FvQ;
          }
          if (paramString1.GLI != null) {
            this.kzr = new MMUserAvatarInfo(paramString1.GLI);
          }
          parama.a(localLinkedList, (String)localObject, str);
          AppMethodBeat.o(46093);
          return;
        }
        if (paramInt1 == 0)
        {
          if (paramString1.nCV == null)
          {
            ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "Data is null, enterData:".concat(String.valueOf(paramString2)));
            parama.bC("internal error", paramInt1);
            AppMethodBeat.o(46093);
            return;
          }
          paramString1 = paramString1.nCV.ffY();
          ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "resp data %s", new Object[] { paramString1 });
          parama.onSuccess(paramString1);
          AppMethodBeat.o(46093);
          return;
        }
        ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", new Object[] { parame });
        parama.bC(parame, paramInt1);
      }
      AppMethodBeat.o(46093);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(46086);
      a local1 = new a()
      {
        public final void a(LinkedList<cxm> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(46068);
          ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "onConfirm !");
          JsApiOperateWXData.OperateWXDataTask.this.kyw = paramAnonymousLinkedList.size();
          int i = 0;
          while (i < JsApiOperateWXData.OperateWXDataTask.this.kyw)
          {
            cxm localcxm = (cxm)paramAnonymousLinkedList.get(i);
            try
            {
              JsApiOperateWXData.OperateWXDataTask.this.kzq.put(String.valueOf(i), localcxm.toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousLinkedList)
            {
              ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
              ad.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList, "", new Object[0]);
              JsApiOperateWXData.OperateWXDataTask.this.kym = "fail";
              JsApiOperateWXData.OperateWXDataTask.d(JsApiOperateWXData.OperateWXDataTask.this);
              AppMethodBeat.o(46068);
              return;
            }
          }
          JsApiOperateWXData.OperateWXDataTask.this.mAppName = paramAnonymousString1;
          JsApiOperateWXData.OperateWXDataTask.this.kyo = paramAnonymousString2;
          JsApiOperateWXData.OperateWXDataTask.this.kym = "needConfirm";
          if (paramAnonymousLinkedList.size() > 0)
          {
            paramAnonymousString1 = (cxm)paramAnonymousLinkedList.get(0);
            paramAnonymousString2 = JsApiOperateWXData.OperateWXDataTask.this;
            if (paramAnonymousString1.HoW == null)
            {
              paramAnonymousLinkedList = "";
              paramAnonymousString2.kyy = paramAnonymousLinkedList;
              if (!"scope.userInfo".equals(paramAnonymousString1.FKf)) {
                break label299;
              }
              JsApiOperateWXData.OperateWXDataTask.this.kyv = u.aAo();
              paramAnonymousString1 = new StringBuilder("userNickName=");
              if (JsApiOperateWXData.OperateWXDataTask.this.kyv != null) {
                break label288;
              }
            }
            label288:
            for (paramAnonymousLinkedList = "";; paramAnonymousLinkedList = JsApiOperateWXData.OperateWXDataTask.this.kyv)
            {
              ad.i("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList);
              paramAnonymousLinkedList = u.aAm();
              paramAnonymousString1 = g.kxX;
              g.a.a(paramAnonymousLinkedList, new g.b()
              {
                public final void KZ(String paramAnonymous2String)
                {
                  AppMethodBeat.i(46065);
                  JsApiOperateWXData.OperateWXDataTask.this.kyu = paramAnonymous2String;
                  JsApiOperateWXData.OperateWXDataTask.e(JsApiOperateWXData.OperateWXDataTask.this);
                  AppMethodBeat.o(46065);
                }
              });
              AppMethodBeat.o(46068);
              return;
              paramAnonymousLinkedList = paramAnonymousString1.HoW;
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
        
        public final void bC(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(188295);
          ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "onFailure !");
          JsApiOperateWXData.OperateWXDataTask.this.kym = "fail:".concat(String.valueOf(paramAnonymousString));
          JsApiOperateWXData.OperateWXDataTask.this.cgiErrorCode = paramAnonymousInt;
          JsApiOperateWXData.OperateWXDataTask.c(JsApiOperateWXData.OperateWXDataTask.this);
          AppMethodBeat.o(188295);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(46066);
          ad.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSuccess !");
          try
          {
            JsApiOperateWXData.OperateWXDataTask.this.kzn = org.apache.commons.b.g.a(new String[] { JsApiOperateWXData.OperateWXDataTask.this.appId, JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this), JsApiOperateWXData.OperateWXDataTask.this.kje, bt.HI() }, "$");
            JsApiOperateWXData.OperateWXDataTask.ahK().putString(JsApiOperateWXData.OperateWXDataTask.this.kzn, paramAnonymousString).commit();
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.ahK().getString(JsApiOperateWXData.OperateWXDataTask.this.kzn, null)))
            {
              IOException localIOException = new IOException("write data failed");
              AppMethodBeat.o(46066);
              throw localIOException;
            }
          }
          catch (Throwable localThrowable)
          {
            ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInMainProcess::onSuccess, write to XProcessStore failed, appId[%s], callbackId[%d] e=%s", new Object[] { JsApiOperateWXData.OperateWXDataTask.this.appId, Integer.valueOf(JsApiOperateWXData.OperateWXDataTask.this.kje), localThrowable });
            JsApiOperateWXData.OperateWXDataTask.this.kzn = null;
            JsApiOperateWXData.sO(1L);
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kzn)) {
              JsApiOperateWXData.OperateWXDataTask.this.kzm = paramAnonymousString;
            }
            for (;;)
            {
              JsApiOperateWXData.OperateWXDataTask.this.kym = "ok";
              JsApiOperateWXData.OperateWXDataTask.b(JsApiOperateWXData.OperateWXDataTask.this);
              AppMethodBeat.o(46066);
              return;
              JsApiOperateWXData.sO(0L);
              if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kzn)) {
                JsApiOperateWXData.OperateWXDataTask.this.kzm = paramAnonymousString;
              }
            }
          }
          finally
          {
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kzn)) {
              JsApiOperateWXData.OperateWXDataTask.this.kzm = paramAnonymousString;
            }
            AppMethodBeat.o(46066);
          }
        }
      };
      if (this.kyl.equals("operateWXData"))
      {
        a(this.appId, this.kzl, "", this.hQh, this.kyn, 0, local1, this.kzu);
        AppMethodBeat.o(46086);
        return;
      }
      if (this.kyl.equals("operateWXDataConfirm")) {
        a(this.appId, this.kzl, this.kzp, this.hQh, this.kyn, this.kzo, local1, this.kzu);
      }
      AppMethodBeat.o(46086);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(46088);
      bhO();
      if (!this.kyi.isRunning())
      {
        this.kyj.biH();
        AppMethodBeat.o(46088);
        return;
      }
      Object localObject2;
      Object localObject1;
      if (this.kym.equals("ok"))
      {
        localObject2 = new HashMap();
        String str = this.kzm;
        localObject1 = str;
        if (!TextUtils.isEmpty(this.kzn)) {
          localObject1 = str;
        }
        try
        {
          str = kzk.getString(this.kzn, "");
          localObject1 = str;
          kzk.remove(this.kzn);
          localObject1 = str;
          JsApiOperateWXData.sO(2L);
          localObject1 = str;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInClientProcess loginResult ok, get data from XProcessStore failed, appId[%s], callbackId[%d], e=%s", new Object[] { this.appId, Integer.valueOf(this.kje), localThrowable });
            JsApiOperateWXData.sO(3L);
          }
        }
        ((Map)localObject2).put("data", localObject1);
        this.kyi.h(this.kje, this.kyh.m("ok", (Map)localObject2));
        this.kyj.biH();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.kym.contains("fail"))
      {
        localObject1 = new HashMap();
        ((Map)localObject1).put("err_code", Integer.valueOf(this.cgiErrorCode));
        this.kyi.h(this.kje, this.kyh.m(this.kym, (Map)localObject1));
        this.kyj.biH();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.kym.equals("needConfirm"))
      {
        localObject1 = new LinkedList();
        int i = 0;
        while (i < this.kyw)
        {
          byte[] arrayOfByte = (byte[])this.kzq.get(String.valueOf(i));
          localObject2 = new cxm();
          try
          {
            ((cxm)localObject2).parseFrom(arrayOfByte);
            ((LinkedList)localObject1).add(localObject2);
            i += 1;
          }
          catch (IOException localIOException)
          {
            ad.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { localIOException.getMessage() });
            ad.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", localIOException, "", new Object[0]);
            this.kyh.b(this.kyi, this.kje, "fail");
            this.kyj.biH();
            AppMethodBeat.o(46088);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.kyi.M(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180209);
              Object localObject1 = (cxm)localIOException.getFirst();
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
                    JsApiOperateWXData.OperateWXDataTask.this.kyh.b(JsApiOperateWXData.OperateWXDataTask.this.kyi, JsApiOperateWXData.OperateWXDataTask.this.kje, "fail auth cancel");
                    JsApiOperateWXData.OperateWXDataTask.this.kyj.biH();
                    AppMethodBeat.o(180203);
                    return;
                  }
                  JsApiOperateWXData.OperateWXDataTask.this.kyl = "operateWXDataConfirm";
                  JsApiOperateWXData.OperateWXDataTask localOperateWXDataTask = JsApiOperateWXData.OperateWXDataTask.this;
                  if (paramAnonymous2ArrayList.size() > 0) {}
                  for (paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);; paramAnonymous2ArrayList = "")
                  {
                    localOperateWXDataTask.kzp = paramAnonymous2ArrayList;
                    JsApiOperateWXData.OperateWXDataTask.this.kyn = paramAnonymous2Int1;
                    JsApiOperateWXData.OperateWXDataTask.this.kzo = paramAnonymous2Int2;
                    AppBrandMainProcessService.a(JsApiOperateWXData.OperateWXDataTask.this);
                    if (paramAnonymous2Int1 != 2) {
                      break;
                    }
                    JsApiOperateWXData.OperateWXDataTask.this.kyh.b(JsApiOperateWXData.OperateWXDataTask.this.kyi, JsApiOperateWXData.OperateWXDataTask.this.kje, "fail auth deny");
                    JsApiOperateWXData.OperateWXDataTask.this.kyj.biH();
                    AppMethodBeat.o(180203);
                    return;
                  }
                }
              };
              localObject2 = b.a.a(JsApiOperateWXData.OperateWXDataTask.this.kyi, (com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject2);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setAppBrandName(JsApiOperateWXData.OperateWXDataTask.this.mAppName);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setRequestDesc(((cxm)localObject1).Desc);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setApplyWording(JsApiOperateWXData.OperateWXDataTask.this.kyp);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setNegativeButtonText(JsApiOperateWXData.OperateWXDataTask.this.kyq);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setPositiveButtonText(JsApiOperateWXData.OperateWXDataTask.this.kyr);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setIconUrl(JsApiOperateWXData.OperateWXDataTask.this.kyo);
              if ((JsApiOperateWXData.OperateWXDataTask.this.kys) && (!TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kyt)))
              {
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).hb(true);
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setExplainOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(180204);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                    this.kyF.a(JsApiOperateWXData.OperateWXDataTask.this.kyi, JsApiOperateWXData.OperateWXDataTask.this.kyt, (ac)JsApiOperateWXData.OperateWXDataTask.this.kyi.K(ac.class)).h(JsApiOperateWXData.OperateWXDataTask.this.kyi);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(180204);
                  }
                });
                if (!TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kyy)) {
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSimpleDetailDesc(JsApiOperateWXData.OperateWXDataTask.this.kyy);
                }
                if (!"scope.userInfo".equals(((cxm)localObject1).FKf)) {
                  break label373;
                }
                if (JsApiOperateWXData.OperateWXDataTask.this.kzr == null) {
                  break label303;
                }
                localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b(JsApiOperateWXData.OperateWXDataTask.this.kyi.getContext(), JsApiOperateWXData.OperateWXDataTask.this.kzr, ((cxm)localObject1).FKf, new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c()
                {
                  public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2, d.g.a.m<? super Activity, ? super String, z> paramAnonymous2m)
                  {
                    AppMethodBeat.i(180205);
                    if ((paramAnonymous2Boolean1) || (paramAnonymous2Boolean2))
                    {
                      if (!paramAnonymous2Boolean1)
                      {
                        this.kyF.setFunctionButtonText(paramAnonymous2String1);
                        this.kyF.setFunctionButtonTextColor(JsApiOperateWXData.OperateWXDataTask.this.kyi.getContext().getResources().getColor(2131099660));
                      }
                      for (;;)
                      {
                        JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.kyF, false, paramAnonymous2m);
                        AppMethodBeat.o(180205);
                        return;
                        this.kyF.setFunctionButtonText("");
                      }
                    }
                    this.kyF.setFunctionButtonText(paramAnonymous2String2);
                    this.kyF.setFunctionButtonTextColor(JsApiOperateWXData.OperateWXDataTask.this.kyi.getContext().getResources().getColor(2131100547));
                    JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.kyF, true, paramAnonymous2m);
                    AppMethodBeat.o(180205);
                  }
                  
                  public final void bl(List<o.a> paramAnonymous2List)
                  {
                    AppMethodBeat.i(180206);
                    this.kyF.setSelectListItem(paramAnonymous2List);
                    AppMethodBeat.o(180206);
                  }
                });
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setItemCheckedListener(new o.b()
                {
                  public final void a(o.a paramAnonymous2a)
                  {
                    AppMethodBeat.i(180207);
                    this.kzy.b(paramAnonymous2a);
                    AppMethodBeat.o(180207);
                  }
                });
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setOnListItemLongClickListener(new o.c()
                {
                  public final void a(View paramAnonymous2View, o.a paramAnonymous2a, int paramAnonymous2Int)
                  {
                    int j = 0;
                    AppMethodBeat.i(180208);
                    paramAnonymous2a = this.kyF.getLastPointerDownTouchEvent();
                    int i;
                    if (paramAnonymous2a == null)
                    {
                      i = 0;
                      if (paramAnonymous2a != null) {
                        break label60;
                      }
                    }
                    for (;;)
                    {
                      this.kzy.a(paramAnonymous2View, paramAnonymous2Int, i, j);
                      AppMethodBeat.o(180208);
                      return;
                      i = Math.round(paramAnonymous2a.getRawX());
                      break;
                      label60:
                      j = Math.round(paramAnonymous2a.getRawY());
                    }
                  }
                });
              }
              for (;;)
              {
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).h(JsApiOperateWXData.OperateWXDataTask.this.kyi);
                AppMethodBeat.o(180209);
                return;
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).hb(false);
                break;
                label303:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new o.a(JsApiOperateWXData.OperateWXDataTask.this.kyv, JsApiOperateWXData.OperateWXDataTask.this.kyi.getContext().getResources().getString(2131755946), ((cxm)localObject1).FKf, com.tencent.mm.ak.e.Dd(JsApiOperateWXData.OperateWXDataTask.this.kyu), (byte)0));
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSelectListItem(localArrayList);
                continue;
                label373:
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setScope(((cxm)localObject1).FKf);
              }
            }
          });
          AppMethodBeat.o(46088);
          return;
        }
        this.kyh.b(this.kyi, this.kje, "fail");
        this.kyj.biH();
      }
      AppMethodBeat.o(46088);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46090);
      this.appId = paramParcel.readString();
      this.kym = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.kyo = paramParcel.readString();
      this.kzl = paramParcel.readString();
      this.kzm = paramParcel.readString();
      this.kzn = paramParcel.readString();
      this.kje = paramParcel.readInt();
      this.kyl = paramParcel.readString();
      this.kzp = paramParcel.readString();
      this.kyw = paramParcel.readInt();
      this.kzq = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.hQh = paramParcel.readInt();
      this.kyn = paramParcel.readInt();
      this.kub = paramParcel.readInt();
      this.kyA = paramParcel.readInt();
      this.kyv = paramParcel.readString();
      this.kyu = paramParcel.readString();
      this.kyr = paramParcel.readString();
      this.kyq = paramParcel.readString();
      this.kyp = paramParcel.readString();
      this.kzr = ((MMUserAvatarInfo)paramParcel.readParcelable(MMUserAvatarInfo.class.getClassLoader()));
      this.kzs = paramParcel.readInt();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.kzt = bool1;
        this.kzo = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label296;
        }
        bool1 = true;
        label240:
        this.kzu = bool1;
        if (paramParcel.readInt() != 1) {
          break label301;
        }
      }
      label296:
      label301:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kys = bool1;
        this.kyt = paramParcel.readString();
        this.kyy = paramParcel.readString();
        this.cgiErrorCode = paramParcel.readInt();
        AppMethodBeat.o(46090);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label240;
      }
    }
    
    public final void gl(boolean paramBoolean)
    {
      AppMethodBeat.i(46087);
      super.gl(paramBoolean);
      if (paramBoolean) {}
      for (long l = 4L;; l = 5L)
      {
        JsApiOperateWXData.sO(l);
        AppMethodBeat.o(46087);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(46091);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kym);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.kyo);
      paramParcel.writeString(this.kzl);
      paramParcel.writeString(this.kzm);
      paramParcel.writeString(this.kzn);
      paramParcel.writeInt(this.kje);
      paramParcel.writeString(this.kyl);
      paramParcel.writeString(this.kzp);
      paramParcel.writeInt(this.kyw);
      paramParcel.writeMap(this.kzq);
      paramParcel.writeInt(this.hQh);
      paramParcel.writeInt(this.kyn);
      paramParcel.writeInt(this.kub);
      paramParcel.writeInt(this.kyA);
      paramParcel.writeString(this.kyv);
      paramParcel.writeString(this.kyu);
      paramParcel.writeString(this.kyr);
      paramParcel.writeString(this.kyq);
      paramParcel.writeString(this.kyp);
      paramParcel.writeParcelable(this.kzr, paramInt);
      paramParcel.writeInt(this.kzs);
      if (this.kzt)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.kzo);
        if (!this.kzu) {
          break label279;
        }
        paramInt = 1;
        label224:
        paramParcel.writeInt(paramInt);
        if (!this.kys) {
          break label284;
        }
      }
      label279:
      label284:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kyt);
        paramParcel.writeString(this.kyy);
        paramParcel.writeInt(this.cgiErrorCode);
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
      public abstract void a(LinkedList<cxm> paramLinkedList, String paramString1, String paramString2);
      
      public abstract void bC(String paramString, int paramInt);
      
      public abstract void onSuccess(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData
 * JD-Core Version:    0.7.0.1
 */