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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.permission.a.b.a;
import com.tencent.mm.plugin.appbrand.r.e.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.d;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.protocal.protobuf.dy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.x;
import org.json.JSONObject;

public final class JsApiOperateWXData
  extends i
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  private final m lGR;
  
  public JsApiOperateWXData()
  {
    AppMethodBeat.i(174777);
    this.lGR = new m();
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
      OperateWXDataTask.bEO();
      String[] arrayOfString = OperateWXDataTask.bEP().allKeys();
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
          OperateWXDataTask.bEP().remove(str);
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
  
  public final void a(com.tencent.mm.plugin.appbrand.d paramd, JSONObject paramJSONObject, int paramInt, e parame)
  {
    AppMethodBeat.i(226709);
    for (;;)
    {
      OperateWXDataTask localOperateWXDataTask;
      try
      {
        paramJSONObject.put("wxdataDequeueTimestamp", Util.nowMilliSecond());
        String str = paramJSONObject.getString("data");
        boolean bool = paramJSONObject.optBoolean("isImportant");
        localOperateWXDataTask = new OperateWXDataTask();
        localOperateWXDataTask.appId = paramd.getAppId();
        localOperateWXDataTask.lFR = "operateWXData";
        l locall = paramd.getRuntime().OT();
        if (locall != null) {
          localOperateWXDataTask.iOo = locall.leE.kNW;
        }
        OperateWXDataTask.a(localOperateWXDataTask, this.iLM);
        localOperateWXDataTask.lFN = this;
        localOperateWXDataTask.lFO = paramd;
        localOperateWXDataTask.lGT = str;
        localOperateWXDataTask.lHc = bool;
        localOperateWXDataTask.lqe = paramInt;
        localOperateWXDataTask.lFP = parame;
        localOperateWXDataTask.lGY = new HashMap();
        parame = com.tencent.mm.plugin.appbrand.a.TS(localOperateWXDataTask.appId);
        if (parame != null) {
          localOperateWXDataTask.lBE = parame.scene;
        }
        if ((paramd instanceof s))
        {
          localOperateWXDataTask.lGg = 1;
          paramInt = paramJSONObject.optInt("queueLength", -1);
          long l1 = paramJSONObject.optLong("wxdataQueueTimestamp", 9223372036854775807L);
          long l2 = paramJSONObject.optLong("wxdataDequeueTimestamp", 9223372036854775807L);
          localOperateWXDataTask.lHe = paramInt;
          localOperateWXDataTask.lHf = l1;
          localOperateWXDataTask.lHg = l2;
          localOperateWXDataTask.bDJ();
          AppBrandMainProcessService.a(localOperateWXDataTask);
          AppMethodBeat.o(226709);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "Exception %s", new Object[] { paramJSONObject.getMessage() });
        paramd.i(paramInt, h("fail", null));
        parame.bEE();
        AppMethodBeat.o(226709);
        return;
      }
      if ((paramd instanceof ac)) {
        localOperateWXDataTask.lGg = 2;
      }
    }
  }
  
  static class OperateWXDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateWXDataTask> CREATOR;
    private static final MultiProcessMMKV lGS;
    public String appId;
    public int cgiErrorCode;
    private boolean iLM;
    public int iOo;
    int lBE;
    transient i lFN;
    transient com.tencent.mm.plugin.appbrand.d lFO;
    transient e lFP;
    public String lFR;
    public String lFS;
    public int lFT;
    public String lFU;
    public String lFV;
    public String lFW;
    public String lFX;
    public boolean lFY;
    public String lFZ;
    public String lGT;
    public String lGU;
    public String lGV;
    public int lGW;
    public String lGX;
    public Map<String, byte[]> lGY;
    public MMUserAvatarInfo lGZ;
    public String lGa;
    public String lGb;
    public int lGc;
    public String lGe;
    int lGg;
    int lHa;
    private boolean lHb;
    boolean lHc;
    private boolean lHd;
    transient int lHe;
    transient long lHf;
    transient long lHg;
    private long lHh;
    private long lHi;
    private long lHj;
    private long lHk;
    public int lqe;
    public String mAppName;
    
    static
    {
      AppMethodBeat.i(46102);
      lGS = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.JsApiOperateWXData");
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46102);
    }
    
    public OperateWXDataTask()
    {
      AppMethodBeat.i(174776);
      this.lGb = "";
      this.lGa = "";
      this.lHd = false;
      this.lHj = -1L;
      this.lHk = -1L;
      AppMethodBeat.o(174776);
    }
    
    public OperateWXDataTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46085);
      this.lGb = "";
      this.lGa = "";
      this.lHd = false;
      this.lHj = -1L;
      this.lHk = -1L;
      f(paramParcel);
      AppMethodBeat.o(46085);
    }
    
    private void a(String paramString1, final String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, final a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(46092);
      if (!paramBoolean) {
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateWxData");
      }
      for (paramString1 = new com.tencent.mm.plugin.appbrand.r.e(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.lBE, this.iLM, new e.a() {});; paramString1 = new com.tencent.mm.plugin.appbrand.r.d(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.lBE, new e.a() {}))
      {
        paramString1.yB(this.lGg);
        com.tencent.mm.kernel.g.azz().a(paramString1, 0);
        AppMethodBeat.o(46092);
        return;
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateImportantWxData");
      }
    }
    
    static void bEO() {}
    
    final void a(int paramInt1, int paramInt2, String paramString1, com.tencent.mm.plugin.appbrand.r.e parame, String paramString2, a parama)
    {
      AppMethodBeat.i(46093);
      Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
      if (this.lHd) {
        this.lHk = Util.nowMilliSecond();
      }
      while ((paramInt1 != 0) || (paramInt2 != 0))
      {
        parama.bK(String.format("cgi fail(%d,%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0);
        AppMethodBeat.o(46093);
        return;
        this.lHi = Util.nowMilliSecond();
      }
      if (parame != null)
      {
        if (this.lFT == 2)
        {
          Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "press reject button");
          AppMethodBeat.o(46093);
          return;
        }
        if (parame.rr == null) {}
        for (paramString1 = null; paramString1.Mkb == null; paramString1 = (cev)parame.rr.iLL.iLR)
        {
          Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "JsApiBaseResponse is null, enterData:".concat(String.valueOf(paramString2)));
          parama.bK("cgi fail response null", 0);
          AppMethodBeat.o(46093);
          return;
        }
        paramInt1 = paramString1.Mkb.dIZ;
        parame = paramString1.Mkb.dJa;
        Object localObject = paramString1.Mkq;
        LinkedList localLinkedList = new LinkedList();
        if (localObject != null) {
          localLinkedList.add(localObject);
        }
        localObject = paramString1.xMq;
        String str = paramString1.KFs;
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == -12000)
        {
          this.lHd = true;
          this.lFV = paramString1.Mkg;
          this.lFX = paramString1.Mkf;
          this.lFW = paramString1.Mke;
          if (paramString1.Mkh != null)
          {
            this.lFY = paramString1.Mkh.KHU;
            this.lFZ = paramString1.Mkh.KHV;
          }
          if (paramString1.Mkt != null) {
            this.lGZ = new MMUserAvatarInfo(paramString1.Mkt);
          }
          parama.a(localLinkedList, (String)localObject, str);
          AppMethodBeat.o(46093);
          return;
        }
        if (paramInt1 == 0)
        {
          if (paramString1.oTm == null)
          {
            Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "Data is null, enterData:".concat(String.valueOf(paramString2)));
            parama.bK("internal error", paramInt1);
            AppMethodBeat.o(46093);
            return;
          }
          paramString1 = paramString1.oTm.yO();
          Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "resp data %s", new Object[] { paramString1 });
          parama.onSuccess(paramString1);
          AppMethodBeat.o(46093);
          return;
        }
        Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", new Object[] { parame });
        parama.bK(parame, paramInt1);
      }
      AppMethodBeat.o(46093);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(46086);
      if (this.lHd) {
        this.lHj = Util.nowMilliSecond();
      }
      a local1;
      for (;;)
      {
        local1 = new a()
        {
          public final void a(LinkedList<drb> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(46068);
            Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onConfirm !");
            JsApiOperateWXData.OperateWXDataTask.this.lGc = paramAnonymousLinkedList.size();
            int i = 0;
            while (i < JsApiOperateWXData.OperateWXDataTask.this.lGc)
            {
              drb localdrb = (drb)paramAnonymousLinkedList.get(i);
              try
              {
                JsApiOperateWXData.OperateWXDataTask.this.lGY.put(String.valueOf(i), localdrb.toByteArray());
                i += 1;
              }
              catch (IOException paramAnonymousLinkedList)
              {
                Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
                Log.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList, "", new Object[0]);
                JsApiOperateWXData.OperateWXDataTask.this.lFS = "fail";
                JsApiOperateWXData.OperateWXDataTask.d(JsApiOperateWXData.OperateWXDataTask.this);
                AppMethodBeat.o(46068);
                return;
              }
            }
            JsApiOperateWXData.OperateWXDataTask.this.mAppName = paramAnonymousString1;
            JsApiOperateWXData.OperateWXDataTask.this.lFU = paramAnonymousString2;
            JsApiOperateWXData.OperateWXDataTask.this.lFS = "needConfirm";
            if (paramAnonymousLinkedList.size() > 0)
            {
              paramAnonymousString1 = (drb)paramAnonymousLinkedList.get(0);
              paramAnonymousString2 = JsApiOperateWXData.OperateWXDataTask.this;
              if (paramAnonymousString1.MTJ == null)
              {
                paramAnonymousLinkedList = "";
                paramAnonymousString2.lGe = paramAnonymousLinkedList;
                if (!"scope.userInfo".equals(paramAnonymousString1.KWK)) {
                  break label299;
                }
                JsApiOperateWXData.OperateWXDataTask.this.lGb = z.aUa();
                paramAnonymousString1 = new StringBuilder("userNickName=");
                if (JsApiOperateWXData.OperateWXDataTask.this.lGb != null) {
                  break label288;
                }
              }
              label288:
              for (paramAnonymousLinkedList = "";; paramAnonymousLinkedList = JsApiOperateWXData.OperateWXDataTask.this.lGb)
              {
                Log.i("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList);
                paramAnonymousLinkedList = z.aTY();
                paramAnonymousString1 = g.lFD;
                g.a.a(paramAnonymousLinkedList, new g.b()
                {
                  public final void UI(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(46065);
                    JsApiOperateWXData.OperateWXDataTask.this.lGa = paramAnonymous2String;
                    JsApiOperateWXData.OperateWXDataTask.e(JsApiOperateWXData.OperateWXDataTask.this);
                    AppMethodBeat.o(46065);
                  }
                });
                AppMethodBeat.o(46068);
                return;
                paramAnonymousLinkedList = paramAnonymousString1.MTJ;
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
          
          public final void bK(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(226704);
            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "onFailure !");
            JsApiOperateWXData.OperateWXDataTask.this.lFS = "fail:".concat(String.valueOf(paramAnonymousString));
            JsApiOperateWXData.OperateWXDataTask.this.cgiErrorCode = paramAnonymousInt;
            JsApiOperateWXData.OperateWXDataTask.c(JsApiOperateWXData.OperateWXDataTask.this);
            AppMethodBeat.o(226704);
          }
          
          public final void onSuccess(String paramAnonymousString)
          {
            AppMethodBeat.i(46066);
            Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSuccess !");
            try
            {
              JsApiOperateWXData.OperateWXDataTask.this.lGV = org.apache.commons.b.g.a(new String[] { JsApiOperateWXData.OperateWXDataTask.this.appId, JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this), JsApiOperateWXData.OperateWXDataTask.this.lqe, Util.currentTicks() }, "$");
              JsApiOperateWXData.OperateWXDataTask.bEP().putString(JsApiOperateWXData.OperateWXDataTask.this.lGV, paramAnonymousString).commit();
              if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.bEP().getString(JsApiOperateWXData.OperateWXDataTask.this.lGV, null)))
              {
                IOException localIOException = new IOException("write data failed");
                AppMethodBeat.o(46066);
                throw localIOException;
              }
            }
            catch (Throwable localThrowable)
            {
              Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInMainProcess::onSuccess, write to XProcessStore failed, appId[%s], callbackId[%d] e=%s", new Object[] { JsApiOperateWXData.OperateWXDataTask.this.appId, Integer.valueOf(JsApiOperateWXData.OperateWXDataTask.this.lqe), localThrowable });
              JsApiOperateWXData.OperateWXDataTask.this.lGV = null;
              JsApiOperateWXData.Bg(1L);
              if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.lGV)) {
                JsApiOperateWXData.OperateWXDataTask.this.lGU = paramAnonymousString;
              }
              for (;;)
              {
                JsApiOperateWXData.OperateWXDataTask.this.lFS = "ok";
                JsApiOperateWXData.OperateWXDataTask.b(JsApiOperateWXData.OperateWXDataTask.this);
                AppMethodBeat.o(46066);
                return;
                JsApiOperateWXData.Bg(0L);
                if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.lGV)) {
                  JsApiOperateWXData.OperateWXDataTask.this.lGU = paramAnonymousString;
                }
              }
            }
            finally
            {
              if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.lGV)) {
                JsApiOperateWXData.OperateWXDataTask.this.lGU = paramAnonymousString;
              }
              AppMethodBeat.o(46066);
            }
          }
        };
        if (!this.lFR.equals("operateWXData")) {
          break;
        }
        a(this.appId, this.lGT, "", this.iOo, this.lFT, 0, local1, this.lHc);
        AppMethodBeat.o(46086);
        return;
        this.lHh = Util.nowMilliSecond();
      }
      if (this.lFR.equals("operateWXDataConfirm")) {
        a(this.appId, this.lGT, this.lGX, this.iOo, this.lFT, this.lGW, local1, this.lHc);
      }
      AppMethodBeat.o(46086);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(46088);
      bDK();
      if (!this.lFO.isRunning())
      {
        this.lFP.bEE();
        AppMethodBeat.o(46088);
        return;
      }
      Object localObject2;
      Object localObject1;
      if (this.lFS.equals("ok"))
      {
        localObject2 = new HashMap();
        String str = this.lGU;
        localObject1 = str;
        if (!TextUtils.isEmpty(this.lGV)) {
          localObject1 = str;
        }
        try
        {
          str = lGS.getString(this.lGV, "");
          localObject1 = str;
          lGS.remove(this.lGV);
          localObject1 = str;
          JsApiOperateWXData.Bg(2L);
          localObject1 = str;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInClientProcess loginResult ok, get data from XProcessStore failed, appId[%s], callbackId[%d], e=%s", new Object[] { this.appId, Integer.valueOf(this.lqe), localThrowable });
            JsApiOperateWXData.Bg(3L);
          }
        }
        ((Map)localObject2).put("data", localObject1);
        localObject1 = new HashMap();
        ((Map)localObject1).put("isConfirm", Boolean.valueOf(this.lHd));
        ((Map)localObject1).put("queueLength", Integer.valueOf(this.lHe));
        ((Map)localObject1).put("wxdataQueueTimestamp", Long.valueOf(this.lHf));
        ((Map)localObject1).put("wxdataDequeueTimestamp", Long.valueOf(this.lHg));
        ((Map)localObject1).put("beginCGITimestamp", Long.valueOf(this.lHh));
        ((Map)localObject1).put("CGICallbackTimestamp", Long.valueOf(this.lHi));
        ((Map)localObject1).put("beginCGITimestampAfterConfirm", Long.valueOf(this.lHj));
        ((Map)localObject1).put("CGICallbackTimestampAfterConfirm", Long.valueOf(this.lHk));
        ((Map)localObject1).put("wxlibCallbackTimestamp", Long.valueOf(Util.nowMilliSecond()));
        ((Map)localObject2).put("clientInfo", localObject1);
        localObject1 = this.lFN.n("ok", (Map)localObject2);
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "callback data:%s", new Object[] { localObject1 });
        this.lFO.i(this.lqe, (String)localObject1);
        this.lFP.bEE();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.lFS.contains("fail"))
      {
        localObject1 = new HashMap();
        ((Map)localObject1).put("err_code", String.valueOf(this.cgiErrorCode));
        this.lFO.i(this.lqe, this.lFN.n(this.lFS, (Map)localObject1));
        this.lFP.bEE();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.lFS.equals("needConfirm"))
      {
        localObject1 = new LinkedList();
        int i = 0;
        while (i < this.lGc)
        {
          byte[] arrayOfByte = (byte[])this.lGY.get(String.valueOf(i));
          localObject2 = new drb();
          try
          {
            ((drb)localObject2).parseFrom(arrayOfByte);
            ((LinkedList)localObject1).add(localObject2);
            i += 1;
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { localIOException.getMessage() });
            Log.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", localIOException, "", new Object[0]);
            this.lFN.b(this.lFO, this.lqe, "fail");
            this.lFP.bEE();
            AppMethodBeat.o(46088);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.lFO.P(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180209);
              Object localObject1 = (drb)localIOException.getFirst();
              Object localObject2 = new h.b()
              {
                public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2)
                {
                  AppMethodBeat.i(180203);
                  Log.i("MicroMsg.AppBrand.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  switch (paramAnonymous2Int1)
                  {
                  default: 
                    Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "press back button!");
                    JsApiOperateWXData.OperateWXDataTask.this.lFN.b(JsApiOperateWXData.OperateWXDataTask.this.lFO, JsApiOperateWXData.OperateWXDataTask.this.lqe, "fail auth cancel");
                    JsApiOperateWXData.OperateWXDataTask.this.lFP.bEE();
                    AppMethodBeat.o(180203);
                    return;
                  }
                  JsApiOperateWXData.OperateWXDataTask.this.lFR = "operateWXDataConfirm";
                  JsApiOperateWXData.OperateWXDataTask localOperateWXDataTask = JsApiOperateWXData.OperateWXDataTask.this;
                  if (paramAnonymous2ArrayList.size() > 0) {}
                  for (paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);; paramAnonymous2ArrayList = "")
                  {
                    localOperateWXDataTask.lGX = paramAnonymous2ArrayList;
                    JsApiOperateWXData.OperateWXDataTask.this.lFT = paramAnonymous2Int1;
                    JsApiOperateWXData.OperateWXDataTask.this.lGW = paramAnonymous2Int2;
                    AppBrandMainProcessService.a(JsApiOperateWXData.OperateWXDataTask.this);
                    if (paramAnonymous2Int1 != 2) {
                      break;
                    }
                    JsApiOperateWXData.OperateWXDataTask.this.lFN.b(JsApiOperateWXData.OperateWXDataTask.this.lFO, JsApiOperateWXData.OperateWXDataTask.this.lqe, "fail auth deny");
                    JsApiOperateWXData.OperateWXDataTask.this.lFP.bEE();
                    AppMethodBeat.o(180203);
                    return;
                  }
                }
              };
              localObject2 = b.a.a(JsApiOperateWXData.OperateWXDataTask.this.lFO, (com.tencent.mm.plugin.appbrand.permission.a.b.c)localObject2);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setAppBrandName(JsApiOperateWXData.OperateWXDataTask.this.mAppName);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setRequestDesc(((drb)localObject1).Desc);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setApplyWording(JsApiOperateWXData.OperateWXDataTask.this.lFV);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setNegativeButtonText(JsApiOperateWXData.OperateWXDataTask.this.lFW);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setPositiveButtonText(JsApiOperateWXData.OperateWXDataTask.this.lFX);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setIconUrl(JsApiOperateWXData.OperateWXDataTask.this.lFU);
              if ((JsApiOperateWXData.OperateWXDataTask.this.lFY) && (!TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.lFZ)))
              {
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).ia(true);
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setExplainOnClickListener(new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymous2View)
                  {
                    AppMethodBeat.i(180204);
                    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                    localb.bm(paramAnonymous2View);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                    this.lGn.a(JsApiOperateWXData.OperateWXDataTask.this.lFO, JsApiOperateWXData.OperateWXDataTask.this.lFZ, (ag)JsApiOperateWXData.OperateWXDataTask.this.lFO.M(ag.class)).h(JsApiOperateWXData.OperateWXDataTask.this.lFO);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(180204);
                  }
                });
                if (!TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.lGe)) {
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSimpleDetailDesc(JsApiOperateWXData.OperateWXDataTask.this.lGe);
                }
                if (!"scope.userInfo".equals(((drb)localObject1).KWK)) {
                  break label373;
                }
                if (JsApiOperateWXData.OperateWXDataTask.this.lGZ == null) {
                  break label303;
                }
                localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b(JsApiOperateWXData.OperateWXDataTask.this.lFO.getContext(), JsApiOperateWXData.OperateWXDataTask.this.lGZ, ((drb)localObject1).KWK, new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c()
                {
                  public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2, kotlin.g.a.m<? super Activity, ? super String, x> paramAnonymous2m)
                  {
                    AppMethodBeat.i(180205);
                    if ((paramAnonymous2Boolean1) || (paramAnonymous2Boolean2))
                    {
                      if (!paramAnonymous2Boolean1)
                      {
                        this.lGn.setFunctionButtonText(paramAnonymous2String1);
                        this.lGn.setFunctionButtonTextColor(JsApiOperateWXData.OperateWXDataTask.this.lFO.getContext().getResources().getColor(2131099662));
                      }
                      for (;;)
                      {
                        JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.lGn, false, paramAnonymous2m);
                        AppMethodBeat.o(180205);
                        return;
                        this.lGn.setFunctionButtonText("");
                      }
                    }
                    this.lGn.setFunctionButtonText(paramAnonymous2String2);
                    this.lGn.setFunctionButtonTextColor(JsApiOperateWXData.OperateWXDataTask.this.lFO.getContext().getResources().getColor(2131100685));
                    JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.lGn, true, paramAnonymous2m);
                    AppMethodBeat.o(180205);
                  }
                  
                  public final void bz(List<i.a> paramAnonymous2List)
                  {
                    AppMethodBeat.i(180206);
                    this.lGn.setSelectListItem(paramAnonymous2List);
                    AppMethodBeat.o(180206);
                  }
                });
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setItemCheckedListener(new i.b()
                {
                  public final void a(i.a paramAnonymous2a)
                  {
                    AppMethodBeat.i(226705);
                    this.lHo.b(paramAnonymous2a);
                    AppMethodBeat.o(226705);
                  }
                });
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setOnListItemLongClickListener(new i.d()
                {
                  public final void a(View paramAnonymous2View, i.a paramAnonymous2a, int paramAnonymous2Int)
                  {
                    int j = 0;
                    AppMethodBeat.i(226706);
                    paramAnonymous2a = this.lGn.getLastPointerDownTouchEvent();
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
                      this.lHo.a(paramAnonymous2View, paramAnonymous2Int, i, j);
                      AppMethodBeat.o(226706);
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
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).h(JsApiOperateWXData.OperateWXDataTask.this.lFO);
                AppMethodBeat.o(180209);
                return;
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).ia(false);
                break;
                label303:
                ArrayList localArrayList = new ArrayList();
                localArrayList.add(new i.a(JsApiOperateWXData.OperateWXDataTask.this.lGb, JsApiOperateWXData.OperateWXDataTask.this.lFO.getContext().getResources().getString(2131756044), ((drb)localObject1).KWK, com.tencent.mm.aj.e.Mq(JsApiOperateWXData.OperateWXDataTask.this.lGa), (byte)0));
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSelectListItem(localArrayList);
                continue;
                label373:
                ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setScope(((drb)localObject1).KWK);
              }
            }
          });
          AppMethodBeat.o(46088);
          return;
        }
        this.lFN.b(this.lFO, this.lqe, "fail");
        this.lFP.bEE();
      }
      AppMethodBeat.o(46088);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46090);
      this.appId = paramParcel.readString();
      this.lFS = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.lFU = paramParcel.readString();
      this.lGT = paramParcel.readString();
      this.lGU = paramParcel.readString();
      this.lGV = paramParcel.readString();
      this.lqe = paramParcel.readInt();
      this.lFR = paramParcel.readString();
      this.lGX = paramParcel.readString();
      this.lGc = paramParcel.readInt();
      this.lGY = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.iOo = paramParcel.readInt();
      this.lFT = paramParcel.readInt();
      this.lBE = paramParcel.readInt();
      this.lGg = paramParcel.readInt();
      this.lGb = paramParcel.readString();
      this.lGa = paramParcel.readString();
      this.lFX = paramParcel.readString();
      this.lFW = paramParcel.readString();
      this.lFV = paramParcel.readString();
      this.lGZ = ((MMUserAvatarInfo)paramParcel.readParcelable(MMUserAvatarInfo.class.getClassLoader()));
      this.lHa = paramParcel.readInt();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.lHb = bool1;
        this.lGW = paramParcel.readInt();
        if (paramParcel.readInt() != 1) {
          break label357;
        }
        bool1 = true;
        label240:
        this.lHc = bool1;
        if (paramParcel.readInt() != 1) {
          break label362;
        }
        bool1 = true;
        label255:
        this.lFY = bool1;
        this.lFZ = paramParcel.readString();
        this.lGe = paramParcel.readString();
        this.cgiErrorCode = paramParcel.readInt();
        this.lHh = paramParcel.readLong();
        this.lHi = paramParcel.readLong();
        this.lHj = paramParcel.readLong();
        this.lHk = paramParcel.readLong();
        if (paramParcel.readInt() != 1) {
          break label367;
        }
        bool1 = true;
        label326:
        this.lHd = bool1;
        if (paramParcel.readInt() <= 0) {
          break label372;
        }
      }
      label357:
      label362:
      label367:
      label372:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.iLM = bool1;
        AppMethodBeat.o(46090);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label240;
        bool1 = false;
        break label255;
        bool1 = false;
        break label326;
      }
    }
    
    public final void hg(boolean paramBoolean)
    {
      AppMethodBeat.i(46087);
      super.hg(paramBoolean);
      if (paramBoolean) {}
      for (long l = 4L;; l = 5L)
      {
        JsApiOperateWXData.Bg(l);
        AppMethodBeat.o(46087);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(46091);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.lFS);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.lFU);
      paramParcel.writeString(this.lGT);
      paramParcel.writeString(this.lGU);
      paramParcel.writeString(this.lGV);
      paramParcel.writeInt(this.lqe);
      paramParcel.writeString(this.lFR);
      paramParcel.writeString(this.lGX);
      paramParcel.writeInt(this.lGc);
      paramParcel.writeMap(this.lGY);
      paramParcel.writeInt(this.iOo);
      paramParcel.writeInt(this.lFT);
      paramParcel.writeInt(this.lBE);
      paramParcel.writeInt(this.lGg);
      paramParcel.writeString(this.lGb);
      paramParcel.writeString(this.lGa);
      paramParcel.writeString(this.lFX);
      paramParcel.writeString(this.lFW);
      paramParcel.writeString(this.lFV);
      paramParcel.writeParcelable(this.lGZ, paramInt);
      paramParcel.writeInt(this.lHa);
      if (this.lHb)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.lGW);
        if (!this.lHc) {
          break label339;
        }
        paramInt = 1;
        label224:
        paramParcel.writeInt(paramInt);
        if (!this.lFY) {
          break label344;
        }
        paramInt = 1;
        label238:
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lFZ);
        paramParcel.writeString(this.lGe);
        paramParcel.writeInt(this.cgiErrorCode);
        paramParcel.writeLong(this.lHh);
        paramParcel.writeLong(this.lHi);
        paramParcel.writeLong(this.lHj);
        paramParcel.writeLong(this.lHk);
        if (!this.lHd) {
          break label349;
        }
        paramInt = 1;
        label308:
        paramParcel.writeInt(paramInt);
        if (!this.iLM) {
          break label354;
        }
      }
      label339:
      label344:
      label349:
      label354:
      for (paramInt = i;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(46091);
        return;
        paramInt = 0;
        break;
        paramInt = 0;
        break label224;
        paramInt = 0;
        break label238;
        paramInt = 0;
        break label308;
      }
    }
    
    public static abstract interface a
    {
      public abstract void a(LinkedList<drb> paramLinkedList, String paramString1, String paramString2);
      
      public abstract void bK(String paramString, int paramInt);
      
      public abstract void onSuccess(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData
 * JD-Core Version:    0.7.0.1
 */