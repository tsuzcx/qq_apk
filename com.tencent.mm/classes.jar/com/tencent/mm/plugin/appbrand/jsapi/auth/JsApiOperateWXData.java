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
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.s;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserPrivacyProtectInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.permission.a.b.b;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.e.a;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.dialog.d.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.d;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.ah;
import kotlin.g.a.m;
import org.apache.commons.c.i;
import org.json.JSONObject;

public final class JsApiOperateWXData
  extends j
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  private final o rFS;
  
  public JsApiOperateWXData()
  {
    AppMethodBeat.i(174777);
    this.rFS = new o();
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
      OperateWXDataTask.cqo();
      String[] arrayOfString = OperateWXDataTask.cqp().allKeys();
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
          OperateWXDataTask.cqp().remove(str);
        }
        i += 1;
      }
      AppMethodBeat.o(46104);
      return;
    }
    finally
    {
      Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "clear(%s) e=%s", new Object[] { paramString, localObject });
      AppMethodBeat.o(46104);
    }
  }
  
  public final void a(dh<com.tencent.mm.plugin.appbrand.g> paramdh, e parame)
  {
    AppMethodBeat.i(326862);
    com.tencent.mm.plugin.appbrand.g localg = (com.tencent.mm.plugin.appbrand.g)paramdh.rBv;
    JSONObject localJSONObject = paramdh.rmi;
    int i = paramdh.ror;
    for (;;)
    {
      try
      {
        localJSONObject.put("wxdataDequeueTimestamp", Util.nowMilliSecond());
        String str = localJSONObject.getString("data");
        boolean bool = localJSONObject.optBoolean("isImportant");
        paramdh = new OperateWXDataTask();
        paramdh.appId = localg.getAppId();
        paramdh.rFc = "operateWXData";
        n localn = localg.getRuntime().asG();
        if (localn != null) {
          paramdh.euz = localn.qYY.qHO;
        }
        OperateWXDataTask.a(paramdh, this.otD);
        paramdh.rEY = this;
        paramdh.rEZ = localg;
        paramdh.rFU = str;
        paramdh.rGe = bool;
        paramdh.ror = i;
        paramdh.rFa = new JsApiOperateWXData.OperateWXDataTask.1(paramdh, parame);
        paramdh.rFZ = new HashMap();
        parame = com.tencent.mm.plugin.appbrand.d.Ue(paramdh.appId);
        if (parame != null) {
          paramdh.rAv = parame.scene;
        }
        if ((localg instanceof y))
        {
          paramdh.rFt = 1;
          i = localJSONObject.optInt("queueLength", -1);
          long l1 = localJSONObject.optLong("wxdataQueueTimestamp", 9223372036854775807L);
          long l2 = localJSONObject.optLong("wxdataDequeueTimestamp", 9223372036854775807L);
          paramdh.rGg = i;
          paramdh.rGh = l1;
          paramdh.rGi = l2;
          paramdh.bQt();
          AppMethodBeat.o(326862);
          return;
        }
      }
      catch (Exception paramdh)
      {
        Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "Exception %s", new Object[] { paramdh.getMessage() });
        localg.callback(i, ZP("fail"));
        parame.onAuthResult();
        AppMethodBeat.o(326862);
        return;
      }
      if ((localg instanceof ad)) {
        paramdh.rFt = 2;
      }
    }
  }
  
  static class OperateWXDataTask
    extends MainProcessTask
    implements com.tencent.mm.vending.e.a
  {
    public static final Parcelable.Creator<OperateWXDataTask> CREATOR;
    private static final MultiProcessMMKV rFT;
    public String appId;
    public int cgiErrorCode;
    public String eYt;
    public int euz;
    public String mAppName;
    private boolean otD;
    int rAv;
    transient j rEY;
    transient com.tencent.mm.plugin.appbrand.g rEZ;
    public String rFU;
    public String rFV;
    public String rFW;
    public int rFX;
    public int rFY;
    public Map<String, byte[]> rFZ;
    transient e rFa;
    public String rFc;
    public String rFe;
    public int rFf;
    public boolean rFg;
    public String rFh;
    public String rFi;
    public String rFj;
    public String rFk;
    public boolean rFl;
    public String rFm;
    public String rFn;
    public String rFo;
    public int rFp;
    public String rFr;
    int rFt;
    public MMUserAvatarInfo rGa;
    public MMUserPrivacyProtectInfo rGb;
    int rGc;
    private boolean rGd;
    boolean rGe;
    private boolean rGf;
    transient int rGg;
    transient long rGh;
    transient long rGi;
    private long rGj;
    private long rGk;
    private long rGl;
    private long rGm;
    public int ror;
    public String sessionId;
    
    static
    {
      AppMethodBeat.i(46102);
      rFT = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.JsApiOperateWXData");
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46102);
    }
    
    public OperateWXDataTask()
    {
      AppMethodBeat.i(174776);
      this.rFY = 0;
      this.sessionId = "";
      this.rFo = "";
      this.rFn = "";
      this.rGb = MMUserPrivacyProtectInfo.rHk;
      this.rGf = false;
      this.rGl = -1L;
      this.rGm = -1L;
      AppMethodBeat.o(174776);
    }
    
    public OperateWXDataTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46085);
      this.rFY = 0;
      this.sessionId = "";
      this.rFo = "";
      this.rFn = "";
      this.rGb = MMUserPrivacyProtectInfo.rHk;
      this.rGf = false;
      this.rGl = -1L;
      this.rGm = -1L;
      h(paramParcel);
      AppMethodBeat.o(46085);
    }
    
    private void a(String paramString1, final String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, final a parama, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(326802);
      if (!paramBoolean1) {
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateWxData");
      }
      for (paramString1 = new com.tencent.mm.plugin.appbrand.s.e(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.rAv, this.otD, this.sessionId, this.rFY, paramBoolean2, new e.a() {});; paramString1 = new com.tencent.mm.plugin.appbrand.s.d(paramString1, paramString2, paramString3, paramInt1, paramInt3, paramInt2, this.rAv, this.sessionId, this.rFY, paramBoolean2, new e.a() {}))
      {
        paramString1.Cq(this.rFt);
        com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
        AppMethodBeat.o(326802);
        return;
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateImportantWxData");
      }
    }
    
    static void cqo() {}
    
    final void a(int paramInt1, int paramInt2, String paramString1, com.tencent.mm.plugin.appbrand.s.e parame, String paramString2, a parama)
    {
      AppMethodBeat.i(46093);
      Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1 });
      if (this.rGf) {
        this.rGm = Util.nowMilliSecond();
      }
      while ((paramInt1 != 0) || (paramInt2 != 0))
      {
        parama.cD(String.format("cgi fail(%d,%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), 0);
        AppMethodBeat.o(46093);
        return;
        this.rGk = Util.nowMilliSecond();
      }
      if (parame != null)
      {
        if (this.rFf == 2)
        {
          Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "press reject button");
          AppMethodBeat.o(46093);
          return;
        }
        if (parame.rr == null) {}
        for (paramString1 = null; paramString1.aaJx == null; paramString1 = (deh)c.c.b(parame.rr.otC))
        {
          Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "JsApiBaseResponse is null, enterData:".concat(String.valueOf(paramString2)));
          parama.cD("cgi fail response null", 0);
          AppMethodBeat.o(46093);
          return;
        }
        paramInt1 = paramString1.aaJx.hGE;
        parame = paramString1.aaJx.errmsg;
        Object localObject = paramString1.aaJO;
        LinkedList localLinkedList = new LinkedList();
        if (localObject != null) {
          localLinkedList.add(localObject);
        }
        localObject = paramString1.IKJ;
        String str = paramString1.YDL;
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", new Object[] { Integer.valueOf(paramInt1) });
        if (paramInt1 == -12000)
        {
          this.rGf = true;
          this.rFi = paramString1.aaJD;
          this.rFk = paramString1.aaJC;
          this.rFj = paramString1.aaJB;
          if (paramString1.aaAr != null)
          {
            this.rFl = paramString1.aaAr.YGH;
            this.rFm = paramString1.aaAr.YGI;
          }
          if (paramString1.aaJR != null) {
            this.rGa = new MMUserAvatarInfo(paramString1.aaJR);
          }
          if (paramString1.aaAs != null) {
            this.rGb = new MMUserPrivacyProtectInfo(paramString1.aaAs);
          }
          parama.a(localLinkedList, (String)localObject, str);
          AppMethodBeat.o(46093);
          return;
        }
        if (paramInt1 == 0)
        {
          if (paramString1.vgA == null)
          {
            Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "Data is null, enterData:".concat(String.valueOf(paramString2)));
            parama.cD("internal error", paramInt1);
            AppMethodBeat.o(46093);
            return;
          }
          paramString1 = paramString1.vgA.ZV();
          Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "resp data %s", new Object[] { paramString1 });
          parama.onSuccess(paramString1);
          AppMethodBeat.o(46093);
          return;
        }
        Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", new Object[] { parame });
        parama.cD(parame, paramInt1);
      }
      AppMethodBeat.o(46093);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(46086);
      if (this.rGf) {
        this.rGl = Util.nowMilliSecond();
      }
      a local2;
      for (;;)
      {
        local2 = new a()
        {
          public final void a(LinkedList<eul> paramAnonymousLinkedList, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(326924);
            Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onConfirm !");
            JsApiOperateWXData.OperateWXDataTask.this.rFp = paramAnonymousLinkedList.size();
            int i = 0;
            while (i < JsApiOperateWXData.OperateWXDataTask.this.rFp)
            {
              eul localeul = (eul)paramAnonymousLinkedList.get(i);
              try
              {
                JsApiOperateWXData.OperateWXDataTask.this.rFZ.put(String.valueOf(i), localeul.toByteArray());
                i += 1;
              }
              catch (IOException paramAnonymousLinkedList)
              {
                Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { paramAnonymousLinkedList.getMessage() });
                Log.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList, "", new Object[0]);
                JsApiOperateWXData.OperateWXDataTask.this.rFe = "fail";
                JsApiOperateWXData.OperateWXDataTask.d(JsApiOperateWXData.OperateWXDataTask.this);
                AppMethodBeat.o(326924);
                return;
              }
            }
            JsApiOperateWXData.OperateWXDataTask.this.mAppName = paramAnonymousString1;
            JsApiOperateWXData.OperateWXDataTask.this.rFh = paramAnonymousString2;
            JsApiOperateWXData.OperateWXDataTask.this.rFe = "needConfirm";
            if (paramAnonymousLinkedList.size() > 0)
            {
              paramAnonymousString1 = (eul)paramAnonymousLinkedList.get(0);
              paramAnonymousString2 = JsApiOperateWXData.OperateWXDataTask.this;
              if (paramAnonymousString1.abxn == null)
              {
                paramAnonymousLinkedList = "";
                paramAnonymousString2.rFr = paramAnonymousLinkedList;
                if (!"scope.userInfo".equals(paramAnonymousString1.YVX)) {
                  break label299;
                }
                JsApiOperateWXData.OperateWXDataTask.this.rFo = z.bAO();
                paramAnonymousString1 = new StringBuilder("userNickName=");
                if (JsApiOperateWXData.OperateWXDataTask.this.rFo != null) {
                  break label288;
                }
              }
              label288:
              for (paramAnonymousLinkedList = "";; paramAnonymousLinkedList = JsApiOperateWXData.OperateWXDataTask.this.rFo)
              {
                Log.i("MicroMsg.AppBrand.JsApiOperateWXData", paramAnonymousLinkedList);
                paramAnonymousLinkedList = z.bAM();
                paramAnonymousString1 = h.rET;
                h.a.a(paramAnonymousLinkedList, new h.b()
                {
                  public final void onCallback(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(326783);
                    JsApiOperateWXData.OperateWXDataTask.this.rFn = paramAnonymous2String;
                    JsApiOperateWXData.OperateWXDataTask.e(JsApiOperateWXData.OperateWXDataTask.this);
                    AppMethodBeat.o(326783);
                  }
                });
                AppMethodBeat.o(326924);
                return;
                paramAnonymousLinkedList = paramAnonymousString1.abxn;
                break;
              }
              label299:
              JsApiOperateWXData.OperateWXDataTask.f(JsApiOperateWXData.OperateWXDataTask.this);
              AppMethodBeat.o(326924);
              return;
            }
            JsApiOperateWXData.OperateWXDataTask.g(JsApiOperateWXData.OperateWXDataTask.this);
            AppMethodBeat.o(326924);
          }
          
          public final void cD(String paramAnonymousString, int paramAnonymousInt)
          {
            AppMethodBeat.i(326916);
            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "onFailure !");
            JsApiOperateWXData.OperateWXDataTask.this.rFe = "fail:".concat(String.valueOf(paramAnonymousString));
            JsApiOperateWXData.OperateWXDataTask.this.cgiErrorCode = paramAnonymousInt;
            JsApiOperateWXData.OperateWXDataTask.c(JsApiOperateWXData.OperateWXDataTask.this);
            AppMethodBeat.o(326916);
          }
          
          public final void onSuccess(String paramAnonymousString)
          {
            AppMethodBeat.i(326910);
            Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSuccess !");
            try
            {
              JsApiOperateWXData.OperateWXDataTask.this.rFW = i.b(new String[] { JsApiOperateWXData.OperateWXDataTask.this.appId, JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this), JsApiOperateWXData.OperateWXDataTask.this.ror, Util.currentTicks() }, "$");
              JsApiOperateWXData.OperateWXDataTask.cqp().putString(JsApiOperateWXData.OperateWXDataTask.this.rFW, paramAnonymousString).commit();
              if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.cqp().getString(JsApiOperateWXData.OperateWXDataTask.this.rFW, null)))
              {
                IOException localIOException = new IOException("write data failed");
                AppMethodBeat.o(326910);
                throw localIOException;
              }
            }
            finally
            {
              for (;;)
              {
                try
                {
                  Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInMainProcess::onSuccess, write to XProcessStore failed, appId[%s], callbackId[%d] e=%s", new Object[] { JsApiOperateWXData.OperateWXDataTask.this.appId, Integer.valueOf(JsApiOperateWXData.OperateWXDataTask.this.ror), localObject1 });
                  JsApiOperateWXData.OperateWXDataTask.this.rFW = null;
                  JsApiOperateWXData.jI(1L);
                  if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.rFW)) {
                    JsApiOperateWXData.OperateWXDataTask.this.rFV = paramAnonymousString;
                  }
                  return;
                }
                finally
                {
                  if (!TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.rFW)) {
                    continue;
                  }
                  JsApiOperateWXData.OperateWXDataTask.this.rFV = paramAnonymousString;
                  AppMethodBeat.o(326910);
                }
                JsApiOperateWXData.jI(0L);
                if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.rFW)) {
                  JsApiOperateWXData.OperateWXDataTask.this.rFV = paramAnonymousString;
                }
              }
            }
          }
        };
        if (!this.rFc.equals("operateWXData")) {
          break;
        }
        a(this.appId, this.rFU, "", this.euz, this.rFf, 0, local2, this.rGe, this.rFg);
        AppMethodBeat.o(46086);
        return;
        this.rGj = Util.nowMilliSecond();
      }
      if (this.rFc.equals("operateWXDataConfirm")) {
        a(this.appId, this.rFU, this.eYt, this.euz, this.rFf, this.rFX, local2, this.rGe, this.rFg);
      }
      AppMethodBeat.o(46086);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(46088);
      if (!this.rEZ.isRunning())
      {
        this.rFa.onAuthResult();
        AppMethodBeat.o(46088);
        return;
      }
      Object localObject3;
      Object localObject1;
      if (this.rFe.equals("ok"))
      {
        localObject3 = new HashMap();
        String str = this.rFV;
        localObject1 = str;
        if (!TextUtils.isEmpty(this.rFW)) {
          localObject1 = str;
        }
        try
        {
          str = rFT.getString(this.rFW, "");
          localObject1 = str;
          rFT.remove(this.rFW);
          localObject1 = str;
          JsApiOperateWXData.jI(2L);
          localObject1 = str;
        }
        finally
        {
          for (;;)
          {
            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInClientProcess loginResult ok, get data from XProcessStore failed, appId[%s], callbackId[%d], e=%s", new Object[] { this.appId, Integer.valueOf(this.ror), localObject2 });
            JsApiOperateWXData.jI(3L);
          }
        }
        ((Map)localObject3).put("data", localObject1);
        localObject1 = new HashMap();
        ((Map)localObject1).put("isConfirm", Boolean.valueOf(this.rGf));
        ((Map)localObject1).put("queueLength", Integer.valueOf(this.rGg));
        ((Map)localObject1).put("wxdataQueueTimestamp", Long.valueOf(this.rGh));
        ((Map)localObject1).put("wxdataDequeueTimestamp", Long.valueOf(this.rGi));
        ((Map)localObject1).put("beginCGITimestamp", Long.valueOf(this.rGj));
        ((Map)localObject1).put("CGICallbackTimestamp", Long.valueOf(this.rGk));
        ((Map)localObject1).put("beginCGITimestampAfterConfirm", Long.valueOf(this.rGl));
        ((Map)localObject1).put("CGICallbackTimestampAfterConfirm", Long.valueOf(this.rGm));
        ((Map)localObject1).put("wxlibCallbackTimestamp", Long.valueOf(Util.nowMilliSecond()));
        ((Map)localObject3).put("clientInfo", localObject1);
        localObject1 = this.rEY.m("ok", (Map)localObject3);
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "callback data:%s", new Object[] { localObject1 });
        this.rEZ.callback(this.ror, (String)localObject1);
        this.rFa.onAuthResult();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.rFe.contains("fail"))
      {
        localObject1 = new HashMap();
        ((Map)localObject1).put("err_code", String.valueOf(this.cgiErrorCode));
        this.rEZ.callback(this.ror, this.rEY.m(this.rFe, (Map)localObject1));
        this.rFa.onAuthResult();
        AppMethodBeat.o(46088);
        return;
      }
      if (this.rFe.equals("needConfirm"))
      {
        localObject1 = new LinkedList();
        int i = 0;
        while (i < this.rFp)
        {
          byte[] arrayOfByte = (byte[])this.rFZ.get(String.valueOf(i));
          localObject3 = new eul();
          try
          {
            ((eul)localObject3).parseFrom(arrayOfByte);
            ((LinkedList)localObject1).add(localObject3);
            i += 1;
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", new Object[] { localIOException.getMessage() });
            Log.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", localIOException, "", new Object[0]);
            this.rEY.b(this.rEZ, this.ror, "fail");
            this.rFa.onAuthResult();
            AppMethodBeat.o(46088);
            return;
          }
        }
        if (localIOException.size() > 0)
        {
          this.rEZ.V(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(46079);
              Object localObject1 = (eul)localIOException.getFirst();
              Object localObject2 = new d.b()
              {
                public final void a(int paramAnonymous2Int1, ArrayList<String> paramAnonymous2ArrayList, int paramAnonymous2Int2, boolean paramAnonymous2Boolean)
                {
                  AppMethodBeat.i(326926);
                  Log.i("MicroMsg.AppBrand.JsApiOperateWXData", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous2Int1) });
                  switch (paramAnonymous2Int1)
                  {
                  default: 
                    Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "press back button!");
                    JsApiOperateWXData.OperateWXDataTask.this.rEY.b(JsApiOperateWXData.OperateWXDataTask.this.rEZ, JsApiOperateWXData.OperateWXDataTask.this.ror, "fail auth cancel");
                    JsApiOperateWXData.OperateWXDataTask.this.rFa.onAuthResult();
                    AppMethodBeat.o(326926);
                    return;
                  }
                  JsApiOperateWXData.OperateWXDataTask.this.rFc = "operateWXDataConfirm";
                  JsApiOperateWXData.OperateWXDataTask localOperateWXDataTask = JsApiOperateWXData.OperateWXDataTask.this;
                  if (paramAnonymous2ArrayList.size() > 0) {}
                  for (paramAnonymous2ArrayList = (String)paramAnonymous2ArrayList.get(0);; paramAnonymous2ArrayList = "")
                  {
                    localOperateWXDataTask.eYt = paramAnonymous2ArrayList;
                    JsApiOperateWXData.OperateWXDataTask.this.rFf = paramAnonymous2Int1;
                    JsApiOperateWXData.OperateWXDataTask.this.rFX = paramAnonymous2Int2;
                    JsApiOperateWXData.OperateWXDataTask.this.rFg = paramAnonymous2Boolean;
                    JsApiOperateWXData.OperateWXDataTask.this.bQt();
                    if (paramAnonymous2Int1 != 2) {
                      break;
                    }
                    JsApiOperateWXData.OperateWXDataTask.this.rEY.b(JsApiOperateWXData.OperateWXDataTask.this.rEZ, JsApiOperateWXData.OperateWXDataTask.this.ror, "fail auth deny");
                    JsApiOperateWXData.OperateWXDataTask.this.rFa.onAuthResult();
                    AppMethodBeat.o(326926);
                    return;
                  }
                }
              };
              Object localObject3 = JsApiOperateWXData.OperateWXDataTask.this.rEZ.getRuntime();
              boolean bool2 = r.a(((eul)localObject1).YVX, ((AppBrandRuntime)localObject3).asG());
              localObject2 = b.b.a(JsApiOperateWXData.OperateWXDataTask.this.rEZ, (b.d)localObject2, localIOException);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setAppBrandName(JsApiOperateWXData.OperateWXDataTask.this.mAppName);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setRequestDesc(((eul)localObject1).IGG);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setApplyWording(JsApiOperateWXData.OperateWXDataTask.this.rFi);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setNegativeButtonText(JsApiOperateWXData.OperateWXDataTask.this.rFj);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setPositiveButtonText(JsApiOperateWXData.OperateWXDataTask.this.rFk);
              ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setIconUrl(JsApiOperateWXData.OperateWXDataTask.this.rFh);
              if ((localObject3 instanceof w)) {}
              for (boolean bool1 = ((w)localObject3).getInitConfig().qAT.isEnable();; bool1 = false)
              {
                if ((!bool1) && (JsApiOperateWXData.OperateWXDataTask.this.rFl) && (!TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.rFm)))
                {
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).kb(true);
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setExplainOnClickListener(new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous2View)
                    {
                      AppMethodBeat.i(46072);
                      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                      localb.cH(paramAnonymous2View);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                      this.rFE.a(JsApiOperateWXData.OperateWXDataTask.this.rEZ, JsApiOperateWXData.OperateWXDataTask.this.rFm, (aj)JsApiOperateWXData.OperateWXDataTask.this.rEZ.T(aj.class)).h(JsApiOperateWXData.OperateWXDataTask.this.rEZ);
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$3$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(46072);
                    }
                  });
                  if (TextUtils.isEmpty(JsApiOperateWXData.OperateWXDataTask.this.rFr)) {
                    break label491;
                  }
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSimpleDetailDesc(JsApiOperateWXData.OperateWXDataTask.this.rFr);
                  label252:
                  if ((!"scope.userInfo".equals(((eul)localObject1).YVX)) && (!"scope.userProfileChange".equals(((eul)localObject1).YVX))) {
                    break label657;
                  }
                  if ((JsApiOperateWXData.OperateWXDataTask.this.rEZ.getRuntime() instanceof w)) {
                    JsApiOperateWXData.OperateWXDataTask.this.sessionId = ((w)JsApiOperateWXData.OperateWXDataTask.this.rEZ.getRuntime()).getInitConfig().eoP;
                  }
                  if (JsApiOperateWXData.OperateWXDataTask.this.rGa == null) {
                    break label582;
                  }
                  localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b(JsApiOperateWXData.OperateWXDataTask.this.rEZ.getContext(), JsApiOperateWXData.OperateWXDataTask.this.rGa, ((eul)localObject1).YVX, new b.c()
                  {
                    public final void a(b.c.a paramAnonymous2a)
                    {
                      AppMethodBeat.i(326913);
                      Log.i("MicroMsg.AppBrand.JsApiOperateWXData", "[onCreateUserActionUpdate] action=".concat(String.valueOf(paramAnonymous2a)));
                      JsApiOperateWXData.OperateWXDataTask.this.rFY = paramAnonymous2a.rHu;
                      AppMethodBeat.o(326913);
                    }
                    
                    public final void a(boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2, String paramAnonymous2String1, String paramAnonymous2String2, m<? super Activity, ? super String, ah> paramAnonymous2m)
                    {
                      AppMethodBeat.i(326920);
                      if ((paramAnonymous2Boolean1) || (paramAnonymous2Boolean2))
                      {
                        if (!paramAnonymous2Boolean1)
                        {
                          this.rFE.setFunctionButtonText(paramAnonymous2String1);
                          this.rFE.setFunctionButtonTextColor(JsApiOperateWXData.OperateWXDataTask.this.rEZ.getContext().getResources().getColor(ba.c.BW_0_Alpha_0_3));
                        }
                        for (;;)
                        {
                          JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.rFE, false, paramAnonymous2m);
                          AppMethodBeat.o(326920);
                          return;
                          this.rFE.setFunctionButtonText("");
                        }
                      }
                      this.rFE.setFunctionButtonText(paramAnonymous2String2);
                      this.rFE.setFunctionButtonTextColor(JsApiOperateWXData.OperateWXDataTask.this.rEZ.getContext().getResources().getColor(ba.c.link_color));
                      JsApiOperateWXData.OperateWXDataTask.a(JsApiOperateWXData.OperateWXDataTask.this, this.rFE, true, paramAnonymous2m);
                      AppMethodBeat.o(326920);
                    }
                    
                    public final void di(List<k.a> paramAnonymous2List)
                    {
                      AppMethodBeat.i(326927);
                      this.rFE.setSelectListItem(paramAnonymous2List);
                      AppMethodBeat.o(326927);
                    }
                  });
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setItemCheckedListener(new k.b()
                  {
                    public final void a(k.a paramAnonymous2a)
                    {
                      AppMethodBeat.i(326906);
                      this.rGq.b(paramAnonymous2a);
                      AppMethodBeat.o(326906);
                    }
                  });
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setOnListItemLongClickListener(new k.d()
                  {
                    public final void a(View paramAnonymous2View, k.a paramAnonymous2a, int paramAnonymous2Int)
                    {
                      int j = 0;
                      AppMethodBeat.i(326905);
                      paramAnonymous2a = this.rFE.getLastPointerDownTouchEvent();
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
                        this.rGq.a(paramAnonymous2View, paramAnonymous2Int, i, j);
                        AppMethodBeat.o(326905);
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
                  if (JsApiOperateWXData.OperateWXDataTask.this.rGb.cqt())
                  {
                    ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setUserAgreementCheckBoxWording(JsApiOperateWXData.OperateWXDataTask.this.rGb.wording);
                    ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setIExternalToolsHelper((aj)JsApiOperateWXData.OperateWXDataTask.this.rEZ.T(aj.class));
                  }
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).h(JsApiOperateWXData.OperateWXDataTask.this.rEZ);
                  Log.i("MicroMsg.AppBrand.JsApiOperateWXData", "dialog show");
                  AppMethodBeat.o(46079);
                  return;
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).kb(false);
                  break;
                  label491:
                  if (!bool2) {
                    break label252;
                  }
                  if (TextUtils.isEmpty(r.a(((eul)localObject1).YVX, (AppBrandRuntime)localObject3)))
                  {
                    Log.i("MicroMsg.AppBrand.JsApiOperateWXData", "error = fail:require permission desc");
                    JsApiOperateWXData.OperateWXDataTask.this.rEY.b(JsApiOperateWXData.OperateWXDataTask.this.rEZ, JsApiOperateWXData.OperateWXDataTask.this.ror, "fail:require permission desc");
                    JsApiOperateWXData.OperateWXDataTask.this.rFa.onAuthResult();
                    AppMethodBeat.o(46079);
                    return;
                  }
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSimpleDetailDesc(r.a(((eul)localObject1).YVX, (AppBrandRuntime)localObject3));
                  break label252;
                  label582:
                  localObject3 = new ArrayList();
                  ((ArrayList)localObject3).add(new k.a(JsApiOperateWXData.OperateWXDataTask.this.rFo, JsApiOperateWXData.OperateWXDataTask.this.rEZ.getContext().getResources().getString(ba.i.appbrand_authorize_item_decs_personal_information), ((eul)localObject1).YVX, AvatarStorage.LL(JsApiOperateWXData.OperateWXDataTask.this.rFn), (byte)0));
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setSelectListItem((List)localObject3);
                  continue;
                  label657:
                  ((com.tencent.mm.plugin.appbrand.permission.a.b)localObject2).setScope(((eul)localObject1).YVX);
                }
              }
            }
          });
          AppMethodBeat.o(46088);
          return;
        }
        this.rEY.b(this.rEZ, this.ror, "fail");
        this.rFa.onAuthResult();
      }
      AppMethodBeat.o(46088);
    }
    
    public void dead()
    {
      AppMethodBeat.i(326866);
      cpx();
      AppMethodBeat.o(326866);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool2 = true;
      AppMethodBeat.i(46090);
      this.appId = paramParcel.readString();
      this.rFe = paramParcel.readString();
      this.mAppName = paramParcel.readString();
      this.rFh = paramParcel.readString();
      this.rFU = paramParcel.readString();
      this.rFV = paramParcel.readString();
      this.rFW = paramParcel.readString();
      this.ror = paramParcel.readInt();
      this.rFc = paramParcel.readString();
      this.eYt = paramParcel.readString();
      this.rFp = paramParcel.readInt();
      this.rFZ = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.euz = paramParcel.readInt();
      this.rFf = paramParcel.readInt();
      this.rAv = paramParcel.readInt();
      this.rFt = paramParcel.readInt();
      this.rFo = paramParcel.readString();
      this.rFn = paramParcel.readString();
      this.rFk = paramParcel.readString();
      this.rFj = paramParcel.readString();
      this.rFi = paramParcel.readString();
      this.rGa = ((MMUserAvatarInfo)paramParcel.readParcelable(MMUserAvatarInfo.class.getClassLoader()));
      this.rGc = paramParcel.readInt();
      if (paramParcel.readInt() == 1)
      {
        bool1 = true;
        this.rGd = bool1;
        this.rFX = paramParcel.readInt();
        this.rFY = paramParcel.readInt();
        this.sessionId = paramParcel.readString();
        if (paramParcel.readInt() != 1) {
          break label404;
        }
        bool1 = true;
        label256:
        this.rGe = bool1;
        if (paramParcel.readInt() != 1) {
          break label409;
        }
        bool1 = true;
        label271:
        this.rFl = bool1;
        this.rFm = paramParcel.readString();
        this.rFr = paramParcel.readString();
        this.cgiErrorCode = paramParcel.readInt();
        this.rGj = paramParcel.readLong();
        this.rGk = paramParcel.readLong();
        this.rGl = paramParcel.readLong();
        this.rGm = paramParcel.readLong();
        if (paramParcel.readInt() != 1) {
          break label414;
        }
        bool1 = true;
        label342:
        this.rGf = bool1;
        if (paramParcel.readInt() <= 0) {
          break label419;
        }
        bool1 = true;
        label356:
        this.otD = bool1;
        this.rGb = ((MMUserPrivacyProtectInfo)paramParcel.readParcelable(MMUserPrivacyProtectInfo.class.getClassLoader()));
        if (paramParcel.readInt() != 1) {
          break label424;
        }
      }
      label404:
      label409:
      label414:
      label419:
      label424:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.rFg = bool1;
        AppMethodBeat.o(46090);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label256;
        bool1 = false;
        break label271;
        bool1 = false;
        break label342;
        bool1 = false;
        break label356;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int j = 1;
      AppMethodBeat.i(46091);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.rFe);
      paramParcel.writeString(this.mAppName);
      paramParcel.writeString(this.rFh);
      paramParcel.writeString(this.rFU);
      paramParcel.writeString(this.rFV);
      paramParcel.writeString(this.rFW);
      paramParcel.writeInt(this.ror);
      paramParcel.writeString(this.rFc);
      paramParcel.writeString(this.eYt);
      paramParcel.writeInt(this.rFp);
      paramParcel.writeMap(this.rFZ);
      paramParcel.writeInt(this.euz);
      paramParcel.writeInt(this.rFf);
      paramParcel.writeInt(this.rAv);
      paramParcel.writeInt(this.rFt);
      paramParcel.writeString(this.rFo);
      paramParcel.writeString(this.rFn);
      paramParcel.writeString(this.rFk);
      paramParcel.writeString(this.rFj);
      paramParcel.writeString(this.rFi);
      paramParcel.writeParcelable(this.rGa, paramInt);
      paramParcel.writeInt(this.rGc);
      int i;
      if (this.rGd)
      {
        i = 1;
        paramParcel.writeInt(i);
        paramParcel.writeInt(this.rFX);
        paramParcel.writeInt(this.rFY);
        paramParcel.writeString(this.sessionId);
        if (!this.rGe) {
          break label380;
        }
        i = 1;
        label241:
        paramParcel.writeInt(i);
        if (!this.rFl) {
          break label385;
        }
        i = 1;
        label255:
        paramParcel.writeInt(i);
        paramParcel.writeString(this.rFm);
        paramParcel.writeString(this.rFr);
        paramParcel.writeInt(this.cgiErrorCode);
        paramParcel.writeLong(this.rGj);
        paramParcel.writeLong(this.rGk);
        paramParcel.writeLong(this.rGl);
        paramParcel.writeLong(this.rGm);
        if (!this.rGf) {
          break label390;
        }
        i = 1;
        label325:
        paramParcel.writeInt(i);
        if (!this.otD) {
          break label395;
        }
        i = 1;
        label339:
        paramParcel.writeInt(i);
        paramParcel.writeParcelable(this.rGb, paramInt);
        if (!this.rFg) {
          break label400;
        }
      }
      label385:
      label390:
      label395:
      label400:
      for (paramInt = j;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(46091);
        return;
        i = 0;
        break;
        label380:
        i = 0;
        break label241;
        i = 0;
        break label255;
        i = 0;
        break label325;
        i = 0;
        break label339;
      }
    }
    
    public static abstract interface a
    {
      public abstract void a(LinkedList<eul> paramLinkedList, String paramString1, String paramString2);
      
      public abstract void cD(String paramString, int paramInt);
      
      public abstract void onSuccess(String paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData
 * JD-Core Version:    0.7.0.1
 */