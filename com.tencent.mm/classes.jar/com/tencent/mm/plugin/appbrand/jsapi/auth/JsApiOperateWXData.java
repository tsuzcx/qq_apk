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
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f;
import com.tencent.mm.an.d.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.permission.a.b.b;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.permission.q;
import com.tencent.mm.plugin.appbrand.r.e.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.d;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.x;
import org.json.JSONObject;

public final class JsApiOperateWXData
  extends i
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  private final o oCz;
  
  public JsApiOperateWXData()
  {
    AppMethodBeat.i(174777);
    this.oCz = new o();
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
      OperateWXDataTask.bQp();
      String[] arrayOfString = OperateWXDataTask.bQq().allKeys();
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
          OperateWXDataTask.bQq().remove(str);
        }
        i += 1;
      }
      AppMethodBeat.o(46104);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "clear(%s) e=%s", new Object[] { paramString, localThrowable });
      AppMethodBeat.o(46104);
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.g paramg, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(243182);
    for (;;)
    {
      OperateWXDataTask localOperateWXDataTask;
      try
      {
        paramJSONObject.put("wxdataDequeueTimestamp", Util.nowMilliSecond());
        String str = paramJSONObject.getString("data");
        boolean bool = paramJSONObject.optBoolean("isImportant");
        localOperateWXDataTask = new OperateWXDataTask();
        localOperateWXDataTask.appId = paramg.getAppId();
        localOperateWXDataTask.oBs = "operateWXData";
        l locall = paramg.getRuntime().Sp();
        if (locall != null) {
          localOperateWXDataTask.cBU = locall.nYR.nHY;
        }
        OperateWXDataTask.a(localOperateWXDataTask, this.lBT);
        localOperateWXDataTask.oBo = this;
        localOperateWXDataTask.oBp = paramg;
        localOperateWXDataTask.oCB = str;
        localOperateWXDataTask.oCL = bool;
        localOperateWXDataTask.okO = paramInt;
        localOperateWXDataTask.oBq = new JsApiOperateWXData.OperateWXDataTask.1(localOperateWXDataTask, parame);
        localOperateWXDataTask.oCH = new HashMap();
        parame = com.tencent.mm.plugin.appbrand.d.abC(localOperateWXDataTask.appId);
        if (parame != null) {
          localOperateWXDataTask.owU = parame.scene;
        }
        if ((paramg instanceof v))
        {
          localOperateWXDataTask.oBH = 1;
          paramg.getRuntime().keep(new JsApiOperateWXData.OperateWXDataTask.2(localOperateWXDataTask));
          paramInt = paramJSONObject.optInt("queueLength", -1);
          long l1 = paramJSONObject.optLong("wxdataQueueTimestamp", 9223372036854775807L);
          long l2 = paramJSONObject.optLong("wxdataDequeueTimestamp", 9223372036854775807L);
          localOperateWXDataTask.oCN = paramInt;
          localOperateWXDataTask.oCO = l1;
          localOperateWXDataTask.oCP = l2;
          localOperateWXDataTask.bsM();
          AppMethodBeat.o(243182);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "Exception %s", new Object[] { paramJSONObject.getMessage() });
        paramg.j(paramInt, h("fail", null));
        parame.bQe();
        AppMethodBeat.o(243182);
        return;
      }
      if ((paramg instanceof ad)) {
        localOperateWXDataTask.oBH = 2;
      }
    }
  }
  
  static class OperateWXDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateWXDataTask> CREATOR;
    private static final MultiProcessMMKV oCA;
    public String appId;
    public int cBU;
    public int cgiErrorCode;
    private boolean lBT;
    public String mAppName;
    public String oBA;
    public String oBB;
    public String oBC;
    public int oBD;
    public String oBF;
    int oBH;
    transient i oBo;
    transient com.tencent.mm.plugin.appbrand.g oBp;
    transient e oBq;
    public String oBs;
    public String oBt;
    public int oBu;
    public String oBv;
    public String oBw;
    public String oBx;
    public String oBy;
    public boolean oBz;
    public String oCB;
    public String oCC;
    public String oCD;
    public int oCE;
    public int oCF;
    public String oCG;
    public Map<String, byte[]> oCH;
    public MMUserAvatarInfo oCI;
    int oCJ;
    private boolean oCK;
    boolean oCL;
    private boolean oCM;
    transient int oCN;
    transient long oCO;
    transient long oCP;
    private long oCQ;
    private long oCR;
    private long oCS;
    private long oCT;
    public int okO;
    int owU;
    public String sessionId;
    
    static
    {
      AppMethodBeat.i(46102);
      oCA = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.JsApiOperateWXData");
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46102);
    }
    
    public OperateWXDataTask()
    {
      AppMethodBeat.i(174776);
      this.oCF = 0;
      this.sessionId = "";
      this.oBC = "";
      this.oBB = "";
      this.oCM = false;
      this.oCS = -1L;
      this.oCT = -1L;
      AppMethodBeat.o(174776);
    }
    
    public OperateWXDataTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46085);
      this.oCF = 0;
      this.sessionId = "";
      this.oBC = "";
      this.oBB = "";
      this.oCM = false;
      this.oCS = -1L;
      this.oCT = -1L;
      f(paramParcel);
      AppMethodBeat.o(46085);
    }
    
    private void a(String paramString1, final String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, final a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(46092);
      if (!paramBoolean) {
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateWxData");
      }
      for (paramString1 = new com.tencent.mm.plugin.appbrand.r.e(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.owU, this.lBT, this.sessionId, this.oCF, new e.a() {});; paramString1 = new com.tencent.mm.plugin.appbrand.r.d(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.owU, this.sessionId, this.oCF, new e.a() {}))
      {
        paramString1.Cb(this.oBH);
        h.aGY().a(paramString1, 0);
        AppMethodBeat.o(46092);
        return;
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateImportantWxData");
      }
    }
    
    static void bQp() {}
    
    public final void RW()
    {
      AppMethodBeat.i(46086);
      if (this.oCM) {
        this.oCS = Util.nowMilliSecond();
      }
      a local3;
      for (;;)
      {
        local3 = new a()
        {
          public final void a(LinkedList<eax> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(281445);
            Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onConfirm !");
            JsApiOperateWXData.OperateWXDataTask.this.oBD = paramAnonymousLinkedList.size();
            int i = 0;
            while (i < JsApiOperateWXData.OperateWXDataTask.this.oBD)
            {
              eax localeax = (eax)paramAnonymousLinkedList.get(i);
              try
              {
                JsApiOperateWXData.OperateWXDataTask.this.oCH.put(String.valueOf(i), localeax.toByteArray());
                i += 1;
              }
              catch (IOException paramAnonymousLinkedList)
              {
                Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
                Log.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList, "", new Object[0]);
                JsApiOperateWXData.OperateWXDataTask.this.oBt = "fail";
                JsApiOperateWXData.OperateWXDataTask.d(JsApiOperateWXData.OperateWXDataTask.this);
                AppMethodBeat.o(281445);
                return;
              }
            }
            JsApiOperateWXData.OperateWXDataTask.this.mAppName = paramAnonymousString1;
            JsApiOperateWXData.OperateWXDataTask.this.oBv = paramAnonymousString2;
            JsApiOperateWXData.OperateWXDataTask.this.oBt = "needConfirm";
            if (paramAnonymousLinkedList.size() > 0)
            {
              paramAnonymousString1 = (eax)paramAnonymousLinkedList.get(0);
              paramAnonymousString2 = JsApiOperateWXData.OperateWXDataTask.this;
              if (paramAnonymousString1.UfS == null)
              {
                paramAnonymousLinkedList = "";
                paramAnonymousString2.oBF = paramAnonymousLinkedList;
                if (!"scope.userInfo".equals(paramAnonymousString1.RXY)) {
                  break label299;
                }
                JsApiOperateWXData.OperateWXDataTask.this.oBC = z.bdb();
                paramAnonymousString1 = new StringBuilder("userNickName=");
                if (JsApiOperateWXData.OperateWXDataTask.this.oBC != null) {
                  break label288;
                }
              }
              label288:
              for (paramAnonymousLinkedList = "";; paramAnonymousLinkedList = JsApiOperateWXData.OperateWXDataTask.this.oBC)
              {
                Log.i("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList);
                paramAnonymousLinkedList = z.bcZ();
                paramAnonymousString1 = g.oBe;
                g.a.a(paramAnonymousLinkedList, new g.b()
                {
                  public final void acs(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(272844);
                    JsApiOperateWXData.OperateWXDataTask.this.oBB = paramAnonymous2String;
                    JsApiOperateWXData.OperateWXDataTask.e(JsApiOperateWXData.OperateWXDataTask.this);
                    AppMethodBeat.o(272844);
                  }
                });
                AppMethodBeat.o(281445);
                return;
                paramAnonymousLinkedList = paramAnonymousString1.UfS;
                break;
              }
              label299:
              JsApiOperateWXData.OperateWXDataTask.f(JsApiOperateWXData.OperateWXDataTask.this);
              AppMethodBeat.o(281445);
              return;
            }
            JsApiOperateWXData.OperateWXDataTask.g(JsApiOperateWXData.OperateWXDataTask.this);
            AppMethodBeat.o(281445);
          }
          
          public final void cg(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(281444);
            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "onFailure !");
            JsApiOperateWXData.OperateWXDataTask.this.oBt = "fail:".concat(String.valueOf(paramAnonymousString));
            JsApiOperateWXData.OperateWXDataTask.this.cgiErrorCode = paramAnonymousInt;
            JsApiOperateWXData.OperateWXDataTask.c(JsApiOperateWXData.OperateWXDataTask.this);
            AppMethodBeat.o(281444);
          }
          
          public final void onSuccess(String paramAnonymousString)
          {
            AppMethodBeat.i(281443);
            Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSuccess !");
            try
            {
              JsApiOperateWXData.OperateWXDataTask.this.oCD = org.apache.commons.b.g.a(new String[] { JsApiOperateWXData.OperateWXDataTask.this.appId, JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this), JsApiOperateWXData.OperateWXDataTask.this.okO, Util.currentTicks() }, "$");
              JsApiOperateWXData.OperateWXDataTask.bQq().putString(JsApiOperateWXData.OperateWXDataTask.this.oCD, paramAnonymousString).commit();
              if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.bQq().getString(JsApiOperateWXData.OperateWXDataTask.this.oCD, null)))
              {
                IOException localIOException = new IOException("write data failed");
                AppMethodBeat.o(281443);
                throw localIOException;
              }
            }
            catch (Throwable localThrowable)
            {
              Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInMainProcess::onSuccess, write to XProcessStore failed, appId[%s], callbackId[%d] e=%s", new Object[] { JsApiOperateWXData.OperateWXDataTask.this.appId, Integer.valueOf(JsApiOperateWXData.OperateWXDataTask.this.okO), localThrowable });
              JsApiOperateWXData.OperateWXDataTask.this.oCD = null;
              JsApiOperateWXData.Hs(1L);
              if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.oCD)) {
                JsApiOperateWXData.OperateWXDataTask.this.oCC = paramAnonymousString;
              }
              for (;;)
              {
                JsApiOperateWXData.OperateWXDataTask.this.oBt = "ok";
                JsApiOperateWXData.OperateWXDataTask.b(JsApiOperateWXData.OperateWXDataTask.this);
                AppMethodBeat.o(281443);
                return;
                JsApiOperateWXData.Hs(0L);
                if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.oCD)) {
                  JsApiOperateWXData.OperateWXDataTask.this.oCC = paramAnonymousString;
                }
              }
            }
            finally
            {
              if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.oCD)) {
                JsApiOperateWXData.OperateWXDataTask.this.oCC = paramAnonymousString;
              }
              AppMethodBeat.o(281443);
            }
          }
        };
        if (!this.oBs.equals("operateWXData")) {
          break;
        }
        a(this.appId, this.oCB, "", this.cBU, this.oBu, 0, local3, this.oCL);
        AppMethodBeat.o(46086);
        return;
        this.oCQ = Util.nowMilliSecond();
      }
      if (this.oBs.equals("operateWXDataConfirm")) {
        a(this.appId, this.oCB, this.oCG, this.cBU, this.oBu, this.oCE, local3, this.oCL);
      }
      AppMethodBeat.o(46086);
    }
    
    final void a(int paramInt1, int paramInt2, String paramString1, com.tencent.mm.plugin.appbrand.r.e parame, String paramString2, a parama)
    {
      AppMethodBeat.i(46093);
      Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
      if (this.oCM) {
        this.oCT = Util.nowMilliSecond();
      }
      while ((paramInt1 != 0) || (paramInt2 != 0))
      {
        parama.cg(String.format("cgi fail(%d,%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0);
        AppMethodBeat.o(46093);
        return;
        this.oCR = Util.nowMilliSecond();
      }
      if (parame != null)
      {
        if (this.oBu == 2)
        {
          Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "press reject button");
          AppMethodBeat.o(46093);
          return;
        }
        if (parame.rr == null) {}
        for (paramString1 = null; paramString1.TuR == null; paramString1 = (cnp)d.c.b(parame.rr.lBS))
        {
          Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "JsApiBaseResponse is null, enterData:".concat(String.valueOf(paramString2)));
          parama.cg("cgi fail response null", 0);
          AppMethodBeat.o(46093);
          return;
        }
        paramInt1 = paramString1.TuR.fBP;
        parame = paramString1.TuR.errmsg;
        Object localObject = paramString1.Tvi;
        LinkedList localLinkedList = new LinkedList();
        if (localObject != null) {
          localLinkedList.add(localObject);
        }
        localObject = paramString1.CQz;
        String str = paramString1.RGJ;
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == -12000)
        {
          this.oCM = true;
          this.oBw = paramString1.TuW;
          this.oBy = paramString1.TuV;
          this.oBx = paramString1.TuU;
          if (paramString1.TuX != null)
          {
            this.oBz = paramString1.TuX.RJo;
            this.oBA = paramString1.TuX.RJp;
          }
          if (paramString1.Tvl != null) {
            this.oCI = new MMUserAvatarInfo(paramString1.Tvl);
          }
          parama.a(localLinkedList, (String)localObject, str);
          AppMethodBeat.o(46093);
          return;
        }
        if (paramInt1 == 0)
        {
          if (paramString1.rVk == null)
          {
            Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "Data is null, enterData:".concat(String.valueOf(paramString2)));
            parama.cg("internal error", paramInt1);
            AppMethodBeat.o(46093);
            return;
          }
          paramString1 = paramString1.rVk.Ap();
          Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "resp data %s", new Object[] { paramString1 });
          parama.onSuccess(paramString1);
          AppMethodBeat.o(46093);
          return;
        }
        Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", new Object[] { parame });
        parama.cg(parame, paramInt1);
      }
      AppMethodBeat.o(46093);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(46088);
      if (!this.oBp.isRunning())
      {
        this.oBq.bQe();
        AppMethodBeat.o(46088);
        return;
      }
      Object localObject2;
      Object localObject1;
      if (this.oBt.equals("ok"))
      {
        localObject2 = new HashMap();
        String str = this.oCC;
        localObject1 = str;
        if (!TextUtils.isEmpty(this.oCD)) {
          localObject1 = str;
        }
        try
        {
          str = oCA.getString(this.oCD, "");
          localObject1 = str;
          oCA.remove(this.oCD);
          localObject1 = str;
          JsApiOperateWXData.Hs(2L);
          localObject1 = str;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInClientProcess loginResult ok, get data from XProcessStore failed, appId[%s], callbackId[%d], e=%s", new Object[] { this.appId, Integer.valueOf(this.okO), localThrowable });
            JsApiOperateWXData.Hs(3L);
          }
        }
        ((Map)localObject2).put("data", localObject1);
        localObject1 = new HashMap();
        ((Map)localObject1).put("isConfirm", Boolean.valueOf(this.oCM));
        ((Map)localObject1).put("queueLength", Integer.valueOf(this.oCN));
        ((Map)localObject1).put("wxdataQueueTimestamp", Long.valueOf(this.oCO));
        ((Map)localObject1).put("wxdataDequeueTimestamp", Long.valueOf(this.oCP));
        ((Map)localObject1).put("beginCGITimestamp", Long.valueOf(this.oCQ));
        ((Map)localObject1).put("CGICallbackTimestamp", Long.valueOf(this.oCR));
        ((Map)localObject1).put("beginCGITimestampAfterConfirm", Long.valueOf(this.oCS));
        ((Map)localObject1).put("CGICallbackTimestampAfterConfirm", Long.valueOf(this.oCT));
        ((Map)localObject1).put("wxlibCallbackTimestamp", Long.valueOf(Util.nowMilliSecond()));
        ((Map)localObject2).put("clientInfo", localObject1);
        localObject1 = this.oBo.m("ok", (Map)localObject2);
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "callback data:%s", new Object[] { localObject1 });
        this.oBp.j(this.okO, (String)localObject1);
        this.oBq.bQe();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.oBt.contains("fail"))
      {
        localObject1 = new HashMap();
        ((Map)localObject1).put("err_code", String.valueOf(this.cgiErrorCode));
        this.oBp.j(this.okO, this.oBo.m(this.oBt, (Map)localObject1));
        this.oBq.bQe();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.oBt.equals("needConfirm"))
      {
        localObject1 = new LinkedList();
        int i = 0;
        while (i < this.oBD)
        {
          byte[] arrayOfByte = (byte[])this.oCH.get(String.valueOf(i));
          localObject2 = new eax();
          try
          {
            ((eax)localObject2).parseFrom(arrayOfByte);
            ((LinkedList)localObject1).add(localObject2);
            i += 1;
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { localIOException.getMessage() });
            Log.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", localIOException, "", new Object[0]);
            this.oBo.b(this.oBp, this.okO, "fail");
            this.oBq.bQe();
            AppMethodBeat.o(46088);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.oBp.P(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(272552);
              Object localObject1 = (eax)localIOException.getFirst();
              Object localObject2 = new com.tencent.mm.plugin.appbrand.widget.dialog.g.b()
              {
                public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(270682);
                  Log.i("MicroMsg.AppBrand.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  switch (paramAnonymous2Int1)
                  {
                  default: 
                    Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "press back button!");
                    JsApiOperateWXData.OperateWXDataTask.this.oBo.b(JsApiOperateWXData.OperateWXDataTask.this.oBp, JsApiOperateWXData.OperateWXDataTask.this.okO, "fail auth cancel");
                    JsApiOperateWXData.OperateWXDataTask.this.oBq.bQe();
                    AppMethodBeat.o(270682);
                    return;
                  }
                  JsApiOperateWXData.OperateWXDataTask.this.oBs = "operateWXDataConfirm";
                  JsApiOperateWXData.OperateWXDataTask localOperateWXDataTask = JsApiOperateWXData.OperateWXDataTask.this;
                  if (paramAnonymous2ArrayList.size() > 0) {}
                  for (paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);; paramAnonymous2ArrayList = "")
                  {
                    localOperateWXDataTask.oCG = paramAnonymous2ArrayList;
                    JsApiOperateWXData.OperateWXDataTask.this.oBu = paramAnonymous2Int1;
                    JsApiOperateWXData.OperateWXDataTask.this.oCE = paramAnonymous2Int2;
                    JsApiOperateWXData.OperateWXDataTask.this.bsM();
                    if (paramAnonymous2Int1 != 2) {
                      break;
                    }
                    JsApiOperateWXData.OperateWXDataTask.this.oBo.b(JsApiOperateWXData.OperateWXDataTask.this.oBp, JsApiOperateWXData.OperateWXDataTask.this.okO, "fail auth deny");
                    JsApiOperateWXData.OperateWXDataTask.this.oBq.bQe();
                    AppMethodBeat.o(270682);
                    return;
                  }
                }
              };
              Object localObject3 = JsApiOperateWXData.OperateWXDataTask.this.oBp.getRuntime();
              boolean bool2 = q.a(((eax)localObject1).RXY, ((AppBrandRuntime)localObject3).Sp());
              localObject2 = b.b.a(JsApiOperateWXData.OperateWXDataTask.this.oBp, (b.d)localObject2);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setAppBrandName(JsApiOperateWXData.OperateWXDataTask.this.mAppName);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setRequestDesc(((eax)localObject1).CMB);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setApplyWording(JsApiOperateWXData.OperateWXDataTask.this.oBw);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setNegativeButtonText(JsApiOperateWXData.OperateWXDataTask.this.oBx);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setPositiveButtonText(JsApiOperateWXData.OperateWXDataTask.this.oBy);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setIconUrl(JsApiOperateWXData.OperateWXDataTask.this.oBv);
              if ((localObject3 instanceof com.tencent.mm.plugin.appbrand.t)) {}
              for (boolean bool1 = ((com.tencent.mm.plugin.appbrand.t)localObject3).bDy().nBE.isEnable();; bool1 = false)
              {
                if ((!bool1) && (JsApiOperateWXData.OperateWXDataTask.this.oBz) && (!TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.oBA)))
                {
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).iU(true);
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setExplainOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(278365);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.bn(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                      this.oBQ.a(JsApiOperateWXData.OperateWXDataTask.this.oBp, JsApiOperateWXData.OperateWXDataTask.this.oBA, (ag)JsApiOperateWXData.OperateWXDataTask.this.oBp.K(ag.class)).i(JsApiOperateWXData.OperateWXDataTask.this.oBp);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$4$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(278365);
                    }
                  });
                }
                while (bool2) {
                  if (TextUtils.isEmpty(q.a(((eax)localObject1).RXY, (AppBrandRuntime)localObject3)))
                  {
                    Log.i("MicroMsg.AppBrand.JsApiOperateWXData", "error = fail:require permission desc");
                    JsApiOperateWXData.OperateWXDataTask.this.oBo.b(JsApiOperateWXData.OperateWXDataTask.this.oBp, JsApiOperateWXData.OperateWXDataTask.this.okO, "fail:require permission desc");
                    JsApiOperateWXData.OperateWXDataTask.this.oBq.bQe();
                    AppMethodBeat.o(272552);
                    return;
                    ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).iU(false);
                  }
                  else
                  {
                    ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSimpleDetailDesc(q.a(((eax)localObject1).RXY, (AppBrandRuntime)localObject3));
                    if (!"scope.userInfo".equals(((eax)localObject1).RXY)) {
                      break label580;
                    }
                    if ((JsApiOperateWXData.OperateWXDataTask.this.oBp.getRuntime() instanceof com.tencent.mm.plugin.appbrand.t)) {
                      JsApiOperateWXData.OperateWXDataTask.this.sessionId = ((com.tencent.mm.plugin.appbrand.t)JsApiOperateWXData.OperateWXDataTask.this.oBp.getRuntime()).bDy().cwP;
                    }
                    if (JsApiOperateWXData.OperateWXDataTask.this.oCI == null) {
                      break label505;
                    }
                    localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b(JsApiOperateWXData.OperateWXDataTask.this.oBp.getContext(), JsApiOperateWXData.OperateWXDataTask.this.oCI, ((eax)localObject1).RXY, new b.c()
                    {
                      public final void a(b.c.a paramAnonymous2a)
                      {
                        AppMethodBeat.i(278419);
                        Log.i("MicroMsg.AppBrand.JsApiOperateWXData", "[onCreateUserActionUpdate] action=".concat(String.valueOf(paramAnonymous2a)));
                        JsApiOperateWXData.OperateWXDataTask.this.oCF = paramAnonymous2a.oEk;
                        AppMethodBeat.o(278419);
                      }
                      
                      public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2, m<? super Activity, ? super String, x> paramAnonymous2m)
                      {
                        AppMethodBeat.i(278420);
                        if ((paramAnonymous2Boolean1) || (paramAnonymous2Boolean2))
                        {
                          if (!paramAnonymous2Boolean1)
                          {
                            this.oBQ.setFunctionButtonText(paramAnonymous2String1);
                            this.oBQ.setFunctionButtonTextColor(JsApiOperateWXData.OperateWXDataTask.this.oBp.getContext().getResources().getColor(au.c.BW_0_Alpha_0_3));
                          }
                          for (;;)
                          {
                            JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.oBQ, false, paramAnonymous2m);
                            AppMethodBeat.o(278420);
                            return;
                            this.oBQ.setFunctionButtonText("");
                          }
                        }
                        this.oBQ.setFunctionButtonText(paramAnonymous2String2);
                        this.oBQ.setFunctionButtonTextColor(JsApiOperateWXData.OperateWXDataTask.this.oBp.getContext().getResources().getColor(au.c.link_color));
                        JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.oBQ, true, paramAnonymous2m);
                        AppMethodBeat.o(278420);
                      }
                      
                      public final void bx(List<h.a> paramAnonymous2List)
                      {
                        AppMethodBeat.i(278421);
                        this.oBQ.setSelectListItem(paramAnonymous2List);
                        AppMethodBeat.o(278421);
                      }
                    });
                    ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setItemCheckedListener(new h.b()
                    {
                      public final void a(h.a paramAnonymous2a)
                      {
                        AppMethodBeat.i(267748);
                        this.oCX.b(paramAnonymous2a);
                        AppMethodBeat.o(267748);
                      }
                    });
                    ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setOnListItemLongClickListener(new h.d()
                    {
                      public final void a(View paramAnonymous2View, h.a paramAnonymous2a, int paramAnonymous2Int)
                      {
                        int j = 0;
                        AppMethodBeat.i(244471);
                        paramAnonymous2a = this.oBQ.getLastPointerDownTouchEvent();
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
                          this.oCX.a(paramAnonymous2View, paramAnonymous2Int, i, j);
                          AppMethodBeat.o(244471);
                          return;
                          i = Math.round(paramAnonymous2a.getRawX());
                          break;
                          label60:
                          j = Math.round(paramAnonymous2a.getRawY());
                        }
                      }
                    });
                  }
                }
                for (;;)
                {
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).i(JsApiOperateWXData.OperateWXDataTask.this.oBp);
                  AppMethodBeat.o(272552);
                  return;
                  if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.oBF)) {
                    break;
                  }
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSimpleDetailDesc(JsApiOperateWXData.OperateWXDataTask.this.oBF);
                  break;
                  label505:
                  localObject3 = new ArrayList();
                  ((ArrayList)localObject3).add(new h.a(JsApiOperateWXData.OperateWXDataTask.this.oBC, JsApiOperateWXData.OperateWXDataTask.this.oBp.getContext().getResources().getString(au.i.appbrand_authorize_item_decs_personal_information), ((eax)localObject1).RXY, f.TL(JsApiOperateWXData.OperateWXDataTask.this.oBB), (byte)0));
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSelectListItem((List)localObject3);
                  continue;
                  label580:
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setScope(((eax)localObject1).RXY);
                }
              }
            }
          });
          AppMethodBeat.o(46088);
          return;
        }
        this.oBo.b(this.oBp, this.okO, "fail");
        this.oBq.bQe();
      }
      AppMethodBeat.o(46088);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46090);
      this.appId = paramParcel.readString();
      this.oBt = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.oBv = paramParcel.readString();
      this.oCB = paramParcel.readString();
      this.oCC = paramParcel.readString();
      this.oCD = paramParcel.readString();
      this.okO = paramParcel.readInt();
      this.oBs = paramParcel.readString();
      this.oCG = paramParcel.readString();
      this.oBD = paramParcel.readInt();
      this.oCH = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.cBU = paramParcel.readInt();
      this.oBu = paramParcel.readInt();
      this.owU = paramParcel.readInt();
      this.oBH = paramParcel.readInt();
      this.oBC = paramParcel.readString();
      this.oBB = paramParcel.readString();
      this.oBy = paramParcel.readString();
      this.oBx = paramParcel.readString();
      this.oBw = paramParcel.readString();
      this.oCI = ((MMUserAvatarInfo)paramParcel.readParcelable(MMUserAvatarInfo.class.getClassLoader()));
      this.oCJ = paramParcel.readInt();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.oCK = bool1;
        this.oCE = paramParcel.readInt();
        this.oCF = paramParcel.readInt();
        this.sessionId = paramParcel.readString();
        if (paramParcel.readInt() != 1) {
          break label373;
        }
        bool1 = true;
        label256:
        this.oCL = bool1;
        if (paramParcel.readInt() != 1) {
          break label378;
        }
        bool1 = true;
        label271:
        this.oBz = bool1;
        this.oBA = paramParcel.readString();
        this.oBF = paramParcel.readString();
        this.cgiErrorCode = paramParcel.readInt();
        this.oCQ = paramParcel.readLong();
        this.oCR = paramParcel.readLong();
        this.oCS = paramParcel.readLong();
        this.oCT = paramParcel.readLong();
        if (paramParcel.readInt() != 1) {
          break label383;
        }
        bool1 = true;
        label342:
        this.oCM = bool1;
        if (paramParcel.readInt() <= 0) {
          break label388;
        }
      }
      label388:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.lBT = bool1;
        AppMethodBeat.o(46090);
        return;
        bool1 = false;
        break;
        label373:
        bool1 = false;
        break label256;
        label378:
        bool1 = false;
        break label271;
        label383:
        bool1 = false;
        break label342;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(46091);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.oBt);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.oBv);
      paramParcel.writeString(this.oCB);
      paramParcel.writeString(this.oCC);
      paramParcel.writeString(this.oCD);
      paramParcel.writeInt(this.okO);
      paramParcel.writeString(this.oBs);
      paramParcel.writeString(this.oCG);
      paramParcel.writeInt(this.oBD);
      paramParcel.writeMap(this.oCH);
      paramParcel.writeInt(this.cBU);
      paramParcel.writeInt(this.oBu);
      paramParcel.writeInt(this.owU);
      paramParcel.writeInt(this.oBH);
      paramParcel.writeString(this.oBC);
      paramParcel.writeString(this.oBB);
      paramParcel.writeString(this.oBy);
      paramParcel.writeString(this.oBx);
      paramParcel.writeString(this.oBw);
      paramParcel.writeParcelable(this.oCI, paramInt);
      paramParcel.writeInt(this.oCJ);
      if (this.oCK)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.oCE);
        paramParcel.writeInt(this.oCF);
        paramParcel.writeString(this.sessionId);
        if (!this.oCL) {
          break label355;
        }
        paramInt = 1;
        label240:
        paramParcel.writeInt(paramInt);
        if (!this.oBz) {
          break label360;
        }
        paramInt = 1;
        label254:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.oBA);
        paramParcel.writeString(this.oBF);
        paramParcel.writeInt(this.cgiErrorCode);
        paramParcel.writeLong(this.oCQ);
        paramParcel.writeLong(this.oCR);
        paramParcel.writeLong(this.oCS);
        paramParcel.writeLong(this.oCT);
        if (!this.oCM) {
          break label365;
        }
        paramInt = 1;
        label324:
        paramParcel.writeInt(paramInt);
        if (!this.lBT) {
          break label370;
        }
      }
      label355:
      label360:
      label365:
      label370:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(46091);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label240;
        paramInt = 0;
        break label254;
        paramInt = 0;
        break label324;
      }
    }
    
    public static abstract interface a
    {
      public abstract void a(LinkedList<eax> paramLinkedList, String paramString1, String paramString2);
      
      public abstract void cg(String paramString, int paramInt);
      
      public abstract void onSuccess(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData
 * JD-Core Version:    0.7.0.1
 */