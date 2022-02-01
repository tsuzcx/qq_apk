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
import com.tencent.mm.ak.q;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.n.e.a;
import com.tencent.mm.plugin.appbrand.permission.a.b.a;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.c;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
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
  private final m kCy;
  
  public JsApiOperateWXData()
  {
    AppMethodBeat.i(174777);
    this.kCy = new m();
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
      OperateWXDataTask.bjA();
      String[] arrayOfString = OperateWXDataTask.ahZ().allKeys();
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
          OperateWXDataTask.ahZ().remove(str);
        }
        i += 1;
      }
      AppMethodBeat.o(46104);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.AppBrand.JsApiOperateWXData", "clear(%s) e=%s", new Object[] { paramString, localThrowable });
      AppMethodBeat.o(46104);
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(222424);
    for (;;)
    {
      try
      {
        String str = paramJSONObject.getString("data");
        boolean bool = paramJSONObject.optBoolean("isImportant");
        paramJSONObject = new OperateWXDataTask();
        paramJSONObject.appId = paramd.getAppId();
        paramJSONObject.kBA = "operateWXData";
        k localk = paramd.getRuntime().Fm();
        if (localk != null) {
          paramJSONObject.hSZ = localk.kbw.jLV;
        }
        paramJSONObject.kBw = this;
        paramJSONObject.kBx = paramd;
        paramJSONObject.kCA = str;
        paramJSONObject.kCJ = bool;
        paramJSONObject.kmu = paramInt;
        paramJSONObject.kBy = parame;
        paramJSONObject.kCF = new HashMap();
        parame = com.tencent.mm.plugin.appbrand.a.KK(paramJSONObject.appId);
        if (parame != null) {
          paramJSONObject.kxr = parame.scene;
        }
        if ((paramd instanceof r))
        {
          paramJSONObject.kBP = 1;
          paramJSONObject.biw();
          AppBrandMainProcessService.a(paramJSONObject);
          AppMethodBeat.o(222424);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        ae.e("MicroMsg.AppBrand.JsApiOperateWXData", "Exception %s", new Object[] { paramJSONObject.getMessage() });
        paramd.h(paramInt, e("fail", null));
        parame.bjq();
        AppMethodBeat.o(222424);
        return;
      }
      if ((paramd instanceof com.tencent.mm.plugin.appbrand.page.z)) {
        paramJSONObject.kBP = 2;
      }
    }
  }
  
  static class OperateWXDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateWXDataTask> CREATOR;
    private static final ay kCz;
    public String appId;
    public int cgiErrorCode;
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
    public String kBN;
    int kBP;
    transient i kBw;
    transient com.tencent.mm.plugin.appbrand.d kBx;
    transient e kBy;
    public String kCA;
    public String kCB;
    public String kCC;
    public int kCD;
    public String kCE;
    public Map<String, byte[]> kCF;
    public MMUserAvatarInfo kCG;
    int kCH;
    private boolean kCI;
    boolean kCJ;
    public int kmu;
    int kxr;
    public String mAppName;
    
    static
    {
      AppMethodBeat.i(46102);
      kCz = ay.aRW("MicroMsg.AppBrand.JsApiOperateWXData");
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46102);
    }
    
    public OperateWXDataTask()
    {
      AppMethodBeat.i(174776);
      this.kBK = "";
      this.kBJ = "";
      AppMethodBeat.o(174776);
    }
    
    public OperateWXDataTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46085);
      this.kBK = "";
      this.kBJ = "";
      e(paramParcel);
      AppMethodBeat.o(46085);
    }
    
    private void a(String paramString1, final String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, final a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(46092);
      if (!paramBoolean) {
        ae.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateWxData");
      }
      for (paramString1 = new com.tencent.mm.plugin.appbrand.n.e(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.kxr, new e.a() {});; paramString1 = new com.tencent.mm.plugin.appbrand.n.d(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.kxr, new e.a() {}))
      {
        paramString1.uK(this.kBP);
        com.tencent.mm.kernel.g.ajj().a(paramString1, 0);
        AppMethodBeat.o(46092);
        return;
        ae.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateImportantWxData");
      }
    }
    
    static void bjA() {}
    
    final void a(int paramInt1, int paramInt2, String paramString1, com.tencent.mm.plugin.appbrand.n.e parame, String paramString2, a parama)
    {
      AppMethodBeat.i(46093);
      ae.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        parama.bF(String.format("cgi fail(%d,%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0);
        AppMethodBeat.o(46093);
        return;
      }
      if (parame != null)
      {
        if (this.kBC == 2)
        {
          ae.d("MicroMsg.AppBrand.JsApiOperateWXData", "press reject button");
          AppMethodBeat.o(46093);
          return;
        }
        if (parame.rr == null) {}
        for (paramString1 = null; paramString1.HeT == null; paramString1 = (bsb)parame.rr.hQE.hQJ)
        {
          ae.d("MicroMsg.AppBrand.JsApiOperateWXData", "JsApiBaseResponse is null, enterData:".concat(String.valueOf(paramString2)));
          parama.bF("cgi fail response null", 0);
          AppMethodBeat.o(46093);
          return;
        }
        paramInt1 = paramString1.HeT.drN;
        parame = paramString1.HeT.drO;
        Object localObject = paramString1.Hfg;
        LinkedList localLinkedList = new LinkedList();
        if (localObject != null) {
          localLinkedList.add(localObject);
        }
        localObject = paramString1.uuo;
        String str = paramString1.FLQ;
        ae.d("MicroMsg.AppBrand.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == -12000)
        {
          this.kBE = paramString1.HeY;
          this.kBG = paramString1.HeX;
          this.kBF = paramString1.HeW;
          if (paramString1.HeZ != null)
          {
            this.kBH = paramString1.HeZ.FOn;
            this.kBI = paramString1.HeZ.FOo;
          }
          if (paramString1.Hfj != null) {
            this.kCG = new MMUserAvatarInfo(paramString1.Hfj);
          }
          parama.a(localLinkedList, (String)localObject, str);
          AppMethodBeat.o(46093);
          return;
        }
        if (paramInt1 == 0)
        {
          if (paramString1.nIq == null)
          {
            ae.d("MicroMsg.AppBrand.JsApiOperateWXData", "Data is null, enterData:".concat(String.valueOf(paramString2)));
            parama.bF("internal error", paramInt1);
            AppMethodBeat.o(46093);
            return;
          }
          paramString1 = paramString1.nIq.fjO();
          ae.d("MicroMsg.AppBrand.JsApiOperateWXData", "resp data %s", new Object[] { paramString1 });
          parama.onSuccess(paramString1);
          AppMethodBeat.o(46093);
          return;
        }
        ae.e("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", new Object[] { parame });
        parama.bF(parame, paramInt1);
      }
      AppMethodBeat.o(46093);
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(46086);
      a local1 = new a()
      {
        public final void a(LinkedList<cyg> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(46068);
          ae.d("MicroMsg.AppBrand.JsApiOperateWXData", "onConfirm !");
          JsApiOperateWXData.OperateWXDataTask.this.kBL = paramAnonymousLinkedList.size();
          int i = 0;
          while (i < JsApiOperateWXData.OperateWXDataTask.this.kBL)
          {
            cyg localcyg = (cyg)paramAnonymousLinkedList.get(i);
            try
            {
              JsApiOperateWXData.OperateWXDataTask.this.kCF.put(String.valueOf(i), localcyg.toByteArray());
              i += 1;
            }
            catch (IOException paramAnonymousLinkedList)
            {
              ae.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
              ae.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList, "", new Object[0]);
              JsApiOperateWXData.OperateWXDataTask.this.kBB = "fail";
              JsApiOperateWXData.OperateWXDataTask.d(JsApiOperateWXData.OperateWXDataTask.this);
              AppMethodBeat.o(46068);
              return;
            }
          }
          JsApiOperateWXData.OperateWXDataTask.this.mAppName = paramAnonymousString1;
          JsApiOperateWXData.OperateWXDataTask.this.kBD = paramAnonymousString2;
          JsApiOperateWXData.OperateWXDataTask.this.kBB = "needConfirm";
          if (paramAnonymousLinkedList.size() > 0)
          {
            paramAnonymousString1 = (cyg)paramAnonymousLinkedList.get(0);
            paramAnonymousString2 = JsApiOperateWXData.OperateWXDataTask.this;
            if (paramAnonymousString1.HIy == null)
            {
              paramAnonymousLinkedList = "";
              paramAnonymousString2.kBN = paramAnonymousLinkedList;
              if (!"scope.userInfo".equals(paramAnonymousString1.GcE)) {
                break label299;
              }
              JsApiOperateWXData.OperateWXDataTask.this.kBK = v.aAE();
              paramAnonymousString1 = new StringBuilder("userNickName=");
              if (JsApiOperateWXData.OperateWXDataTask.this.kBK != null) {
                break label288;
              }
            }
            label288:
            for (paramAnonymousLinkedList = "";; paramAnonymousLinkedList = JsApiOperateWXData.OperateWXDataTask.this.kBK)
            {
              ae.i("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList);
              paramAnonymousLinkedList = v.aAC();
              paramAnonymousString1 = g.kBm;
              g.a.a(paramAnonymousLinkedList, new g.b()
              {
                public final void Lz(String paramAnonymous2String)
                {
                  AppMethodBeat.i(46065);
                  JsApiOperateWXData.OperateWXDataTask.this.kBJ = paramAnonymous2String;
                  JsApiOperateWXData.OperateWXDataTask.e(JsApiOperateWXData.OperateWXDataTask.this);
                  AppMethodBeat.o(46065);
                }
              });
              AppMethodBeat.o(46068);
              return;
              paramAnonymousLinkedList = paramAnonymousString1.HIy;
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
        
        public final void bF(String paramAnonymousString, int paramAnonymousInt)
        {
          AppMethodBeat.i(222421);
          ae.e("MicroMsg.AppBrand.JsApiOperateWXData", "onFailure !");
          JsApiOperateWXData.OperateWXDataTask.this.kBB = "fail:".concat(String.valueOf(paramAnonymousString));
          JsApiOperateWXData.OperateWXDataTask.this.cgiErrorCode = paramAnonymousInt;
          JsApiOperateWXData.OperateWXDataTask.c(JsApiOperateWXData.OperateWXDataTask.this);
          AppMethodBeat.o(222421);
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          AppMethodBeat.i(46066);
          ae.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSuccess !");
          try
          {
            JsApiOperateWXData.OperateWXDataTask.this.kCC = org.apache.commons.b.g.a(new String[] { JsApiOperateWXData.OperateWXDataTask.this.appId, JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this), JsApiOperateWXData.OperateWXDataTask.this.kmu, bu.HQ() }, "$");
            JsApiOperateWXData.OperateWXDataTask.ahZ().putString(JsApiOperateWXData.OperateWXDataTask.this.kCC, paramAnonymousString).commit();
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.ahZ().getString(JsApiOperateWXData.OperateWXDataTask.this.kCC, null)))
            {
              IOException localIOException = new IOException("write data failed");
              AppMethodBeat.o(46066);
              throw localIOException;
            }
          }
          catch (Throwable localThrowable)
          {
            ae.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInMainProcess::onSuccess, write to XProcessStore failed, appId[%s], callbackId[%d] e=%s", new Object[] { JsApiOperateWXData.OperateWXDataTask.this.appId, Integer.valueOf(JsApiOperateWXData.OperateWXDataTask.this.kmu), localThrowable });
            JsApiOperateWXData.OperateWXDataTask.this.kCC = null;
            JsApiOperateWXData.tb(1L);
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kCC)) {
              JsApiOperateWXData.OperateWXDataTask.this.kCB = paramAnonymousString;
            }
            for (;;)
            {
              JsApiOperateWXData.OperateWXDataTask.this.kBB = "ok";
              JsApiOperateWXData.OperateWXDataTask.b(JsApiOperateWXData.OperateWXDataTask.this);
              AppMethodBeat.o(46066);
              return;
              JsApiOperateWXData.tb(0L);
              if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kCC)) {
                JsApiOperateWXData.OperateWXDataTask.this.kCB = paramAnonymousString;
              }
            }
          }
          finally
          {
            if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kCC)) {
              JsApiOperateWXData.OperateWXDataTask.this.kCB = paramAnonymousString;
            }
            AppMethodBeat.o(46066);
          }
        }
      };
      if (this.kBA.equals("operateWXData"))
      {
        a(this.appId, this.kCA, "", this.hSZ, this.kBC, 0, local1, this.kCJ);
        AppMethodBeat.o(46086);
        return;
      }
      if (this.kBA.equals("operateWXDataConfirm")) {
        a(this.appId, this.kCA, this.kCE, this.hSZ, this.kBC, this.kCD, local1, this.kCJ);
      }
      AppMethodBeat.o(46086);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(46088);
      bix();
      if (!this.kBx.isRunning())
      {
        this.kBy.bjq();
        AppMethodBeat.o(46088);
        return;
      }
      Object localObject2;
      Object localObject1;
      if (this.kBB.equals("ok"))
      {
        localObject2 = new HashMap();
        String str = this.kCB;
        localObject1 = str;
        if (!TextUtils.isEmpty(this.kCC)) {
          localObject1 = str;
        }
        try
        {
          str = kCz.getString(this.kCC, "");
          localObject1 = str;
          kCz.remove(this.kCC);
          localObject1 = str;
          JsApiOperateWXData.tb(2L);
          localObject1 = str;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ae.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInClientProcess loginResult ok, get data from XProcessStore failed, appId[%s], callbackId[%d], e=%s", new Object[] { this.appId, Integer.valueOf(this.kmu), localThrowable });
            JsApiOperateWXData.tb(3L);
          }
        }
        ((Map)localObject2).put("data", localObject1);
        this.kBx.h(this.kmu, this.kBw.n("ok", (Map)localObject2));
        this.kBy.bjq();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.kBB.contains("fail"))
      {
        localObject1 = new HashMap();
        ((Map)localObject1).put("err_code", Integer.valueOf(this.cgiErrorCode));
        this.kBx.h(this.kmu, this.kBw.n(this.kBB, (Map)localObject1));
        this.kBy.bjq();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.kBB.equals("needConfirm"))
      {
        localObject1 = new LinkedList();
        int i = 0;
        while (i < this.kBL)
        {
          byte[] arrayOfByte = (byte[])this.kCF.get(String.valueOf(i));
          localObject2 = new cyg();
          try
          {
            ((cyg)localObject2).parseFrom(arrayOfByte);
            ((LinkedList)localObject1).add(localObject2);
            i += 1;
          }
          catch (IOException localIOException)
          {
            ae.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { localIOException.getMessage() });
            ae.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", localIOException, "", new Object[0]);
            this.kBw.b(this.kBx, this.kmu, "fail");
            this.kBy.bjq();
            AppMethodBeat.o(46088);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.kBx.K(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180209);
              Object localObject1 = (cyg)localIOException.getFirst();
              Object localObject2 = new i.b()
              {
                public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(180203);
                  ae.i("MicroMsg.AppBrand.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  switch (paramAnonymous2Int1)
                  {
                  default: 
                    ae.d("MicroMsg.AppBrand.JsApiOperateWXData", "press back button!");
                    JsApiOperateWXData.OperateWXDataTask.this.kBw.b(JsApiOperateWXData.OperateWXDataTask.this.kBx, JsApiOperateWXData.OperateWXDataTask.this.kmu, "fail auth cancel");
                    JsApiOperateWXData.OperateWXDataTask.this.kBy.bjq();
                    AppMethodBeat.o(180203);
                    return;
                  }
                  JsApiOperateWXData.OperateWXDataTask.this.kBA = "operateWXDataConfirm";
                  JsApiOperateWXData.OperateWXDataTask localOperateWXDataTask = JsApiOperateWXData.OperateWXDataTask.this;
                  if (paramAnonymous2ArrayList.size() > 0) {}
                  for (paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);; paramAnonymous2ArrayList = "")
                  {
                    localOperateWXDataTask.kCE = paramAnonymous2ArrayList;
                    JsApiOperateWXData.OperateWXDataTask.this.kBC = paramAnonymous2Int1;
                    JsApiOperateWXData.OperateWXDataTask.this.kCD = paramAnonymous2Int2;
                    AppBrandMainProcessService.a(JsApiOperateWXData.OperateWXDataTask.this);
                    if (paramAnonymous2Int1 != 2) {
                      break;
                    }
                    JsApiOperateWXData.OperateWXDataTask.this.kBw.b(JsApiOperateWXData.OperateWXDataTask.this.kBx, JsApiOperateWXData.OperateWXDataTask.this.kmu, "fail auth deny");
                    JsApiOperateWXData.OperateWXDataTask.this.kBy.bjq();
                    AppMethodBeat.o(180203);
                    return;
                  }
                }
              };
              localObject2 = b.a.a(JsApiOperateWXData.OperateWXDataTask.this.kBx, (com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject2);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setAppBrandName(JsApiOperateWXData.OperateWXDataTask.this.mAppName);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setRequestDesc(((cyg)localObject1).Desc);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setApplyWording(JsApiOperateWXData.OperateWXDataTask.this.kBE);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setNegativeButtonText(JsApiOperateWXData.OperateWXDataTask.this.kBF);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setPositiveButtonText(JsApiOperateWXData.OperateWXDataTask.this.kBG);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setIconUrl(JsApiOperateWXData.OperateWXDataTask.this.kBD);
              if ((JsApiOperateWXData.OperateWXDataTask.this.kBH) && (!TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kBI)))
              {
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).hb(true);
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setExplainOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(180204);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bd(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                    this.kBU.a(JsApiOperateWXData.OperateWXDataTask.this.kBx, JsApiOperateWXData.OperateWXDataTask.this.kBI, (ac)JsApiOperateWXData.OperateWXDataTask.this.kBx.K(ac.class)).h(JsApiOperateWXData.OperateWXDataTask.this.kBx);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(180204);
                  }
                });
                if (!TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.kBN)) {
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSimpleDetailDesc(JsApiOperateWXData.OperateWXDataTask.this.kBN);
                }
                if (!"scope.userInfo".equals(((cyg)localObject1).GcE)) {
                  break label373;
                }
                if (JsApiOperateWXData.OperateWXDataTask.this.kCG == null) {
                  break label303;
                }
                localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b(JsApiOperateWXData.OperateWXDataTask.this.kBx.getContext(), JsApiOperateWXData.OperateWXDataTask.this.kCG, ((cyg)localObject1).GcE, new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c()
                {
                  public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2, d.g.a.m<? super Activity, ? super String, d.z> paramAnonymous2m)
                  {
                    AppMethodBeat.i(180205);
                    if ((paramAnonymous2Boolean1) || (paramAnonymous2Boolean2))
                    {
                      if (!paramAnonymous2Boolean1)
                      {
                        this.kBU.setFunctionButtonText(paramAnonymous2String1);
                        this.kBU.setFunctionButtonTextColor(JsApiOperateWXData.OperateWXDataTask.this.kBx.getContext().getResources().getColor(2131099660));
                      }
                      for (;;)
                      {
                        JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.kBU, false, paramAnonymous2m);
                        AppMethodBeat.o(180205);
                        return;
                        this.kBU.setFunctionButtonText("");
                      }
                    }
                    this.kBU.setFunctionButtonText(paramAnonymous2String2);
                    this.kBU.setFunctionButtonTextColor(JsApiOperateWXData.OperateWXDataTask.this.kBx.getContext().getResources().getColor(2131100547));
                    JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.kBU, true, paramAnonymous2m);
                    AppMethodBeat.o(180205);
                  }
                  
                  public final void bn(List<o.a> paramAnonymous2List)
                  {
                    AppMethodBeat.i(180206);
                    this.kBU.setSelectListItem(paramAnonymous2List);
                    AppMethodBeat.o(180206);
                  }
                });
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setItemCheckedListener(new o.b()
                {
                  public final void a(o.a paramAnonymous2a)
                  {
                    AppMethodBeat.i(180207);
                    this.kCN.b(paramAnonymous2a);
                    AppMethodBeat.o(180207);
                  }
                });
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setOnListItemLongClickListener(new o.c()
                {
                  public final void a(View paramAnonymous2View, o.a paramAnonymous2a, int paramAnonymous2Int)
                  {
                    int j = 0;
                    AppMethodBeat.i(180208);
                    paramAnonymous2a = this.kBU.getLastPointerDownTouchEvent();
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
                      this.kCN.a(paramAnonymous2View, paramAnonymous2Int, i, j);
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
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).h(JsApiOperateWXData.OperateWXDataTask.this.kBx);
                AppMethodBeat.o(180209);
                return;
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).hb(false);
                break;
                label303:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new o.a(JsApiOperateWXData.OperateWXDataTask.this.kBK, JsApiOperateWXData.OperateWXDataTask.this.kBx.getContext().getResources().getString(2131755946), ((cyg)localObject1).GcE, com.tencent.mm.aj.e.DF(JsApiOperateWXData.OperateWXDataTask.this.kBJ), (byte)0));
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSelectListItem(localArrayList);
                continue;
                label373:
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setScope(((cyg)localObject1).GcE);
              }
            }
          });
          AppMethodBeat.o(46088);
          return;
        }
        this.kBw.b(this.kBx, this.kmu, "fail");
        this.kBy.bjq();
      }
      AppMethodBeat.o(46088);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46090);
      this.appId = paramParcel.readString();
      this.kBB = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.kBD = paramParcel.readString();
      this.kCA = paramParcel.readString();
      this.kCB = paramParcel.readString();
      this.kCC = paramParcel.readString();
      this.kmu = paramParcel.readInt();
      this.kBA = paramParcel.readString();
      this.kCE = paramParcel.readString();
      this.kBL = paramParcel.readInt();
      this.kCF = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.hSZ = paramParcel.readInt();
      this.kBC = paramParcel.readInt();
      this.kxr = paramParcel.readInt();
      this.kBP = paramParcel.readInt();
      this.kBK = paramParcel.readString();
      this.kBJ = paramParcel.readString();
      this.kBG = paramParcel.readString();
      this.kBF = paramParcel.readString();
      this.kBE = paramParcel.readString();
      this.kCG = ((MMUserAvatarInfo)paramParcel.readParcelable(MMUserAvatarInfo.class.getClassLoader()));
      this.kCH = paramParcel.readInt();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.kCI = bool1;
        this.kCD = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label296;
        }
        bool1 = true;
        label240:
        this.kCJ = bool1;
        if (paramParcel.readInt() != 1) {
          break label301;
        }
      }
      label296:
      label301:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.kBH = bool1;
        this.kBI = paramParcel.readString();
        this.kBN = paramParcel.readString();
        this.cgiErrorCode = paramParcel.readInt();
        AppMethodBeat.o(46090);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label240;
      }
    }
    
    public final void gj(boolean paramBoolean)
    {
      AppMethodBeat.i(46087);
      super.gj(paramBoolean);
      if (paramBoolean) {}
      for (long l = 4L;; l = 5L)
      {
        JsApiOperateWXData.tb(l);
        AppMethodBeat.o(46087);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(46091);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kBB);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.kBD);
      paramParcel.writeString(this.kCA);
      paramParcel.writeString(this.kCB);
      paramParcel.writeString(this.kCC);
      paramParcel.writeInt(this.kmu);
      paramParcel.writeString(this.kBA);
      paramParcel.writeString(this.kCE);
      paramParcel.writeInt(this.kBL);
      paramParcel.writeMap(this.kCF);
      paramParcel.writeInt(this.hSZ);
      paramParcel.writeInt(this.kBC);
      paramParcel.writeInt(this.kxr);
      paramParcel.writeInt(this.kBP);
      paramParcel.writeString(this.kBK);
      paramParcel.writeString(this.kBJ);
      paramParcel.writeString(this.kBG);
      paramParcel.writeString(this.kBF);
      paramParcel.writeString(this.kBE);
      paramParcel.writeParcelable(this.kCG, paramInt);
      paramParcel.writeInt(this.kCH);
      if (this.kCI)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.kCD);
        if (!this.kCJ) {
          break label279;
        }
        paramInt = 1;
        label224:
        paramParcel.writeInt(paramInt);
        if (!this.kBH) {
          break label284;
        }
      }
      label279:
      label284:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.kBI);
        paramParcel.writeString(this.kBN);
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
      public abstract void a(LinkedList<cyg> paramLinkedList, String paramString1, String paramString2);
      
      public abstract void bF(String paramString, int paramInt);
      
      public abstract void onSuccess(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData
 * JD-Core Version:    0.7.0.1
 */