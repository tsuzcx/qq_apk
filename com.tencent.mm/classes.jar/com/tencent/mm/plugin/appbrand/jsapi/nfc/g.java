package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 352;
  public static final String NAME = "startHCE";
  private int cqA;
  private JSONObject cqn;
  ResultReceiver dK;
  boolean isFinished;
  Activity mContext;
  final Object mLock;
  long mStartTime;
  e nNw;
  Future<?> odx;
  private Class<?> pfk;
  Application.ActivityLifecycleCallbacks pfl;
  private int pfm;
  private ResultReceiver pfn;
  
  public g(Class<?> paramClass)
  {
    AppMethodBeat.i(136114);
    this.pfk = null;
    this.mContext = null;
    this.pfl = null;
    this.nNw = null;
    this.cqA = -1;
    this.mStartTime = -1L;
    this.mLock = new Object();
    this.isFinished = false;
    this.pfn = new JsApiNFCStartHCE.6(this, MMHandler.createFreeHandler(Looper.getMainLooper()));
    this.pfk = paramClass;
    AppMethodBeat.o(136114);
  }
  
  public final void a(e arg1, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136115);
    Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[] { paramJSONObject.toString() });
    this.nNw = ???;
    this.cqA = paramInt;
    this.cqn = paramJSONObject;
    synchronized (this.mLock)
    {
      this.isFinished = false;
      if (this.pfk == null)
      {
        aho(h("fail: HostApduService is nil", null));
        AppMethodBeat.o(136115);
        return;
      }
    }
    this.pfm = this.cqn.optInt("time_limit", 1500);
    a(new JsApiAppBrandNFCBase.a()
    {
      public final void B(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(136107);
        HashMap localHashMap = new HashMap();
        localHashMap.put("errCode", Integer.valueOf(paramAnonymousInt));
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = g.this;
          if (!(paramAnonymousString.nNw.getContext() instanceof Activity))
          {
            paramAnonymousString.aho(paramAnonymousString.h("fail: unknown error", null));
            AppMethodBeat.o(136107);
            return;
          }
          paramAnonymousString.mContext = ((Activity)paramAnonymousString.nNw.getContext());
          paramAnonymousString.pfl = new g.2(paramAnonymousString);
          paramAnonymousString.mContext.getApplication().registerActivityLifecycleCallbacks(paramAnonymousString.pfl);
          paramAnonymousString.dK = new JsApiNFCStartHCE.3(paramAnonymousString, MMHandler.createFreeHandler(Looper.getMainLooper()));
          a.pfy.a(paramAnonymousString.mContext, paramAnonymousString.dK);
          a.pfy.resetStatus();
          paramAnonymousString = new ComponentName(paramAnonymousString.mContext, HCEService.class.getCanonicalName());
          a.pfy.c(paramAnonymousString);
          a.pfy.bTv();
          AppMethodBeat.o(136107);
          return;
        }
        c.R(g.this.nNw.getAppId(), paramAnonymousInt, -1);
        g.this.aho(g.this.m("fail: ".concat(String.valueOf(paramAnonymousString)), localHashMap));
        AppMethodBeat.o(136107);
      }
    });
    AppMethodBeat.o(136115);
  }
  
  final void aho(String paramString)
  {
    AppMethodBeat.i(136116);
    Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[] { paramString });
    if (this.nNw != null) {
      this.nNw.j(this.cqA, paramString);
    }
    if ((this.mContext != null) && (this.pfl != null))
    {
      Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback unregister lifecycle callback");
      this.mContext.getApplication().unregisterActivityLifecycleCallbacks(this.pfl);
    }
    AppMethodBeat.o(136116);
  }
  
  final void onSuccess()
  {
    AppMethodBeat.i(136117);
    Object localObject = new HashMap();
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = this.cqn.getJSONArray("aid_list");
      int j = localJSONArray.length();
      Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[] { this.cqn.toString(), localJSONArray.toString(), Integer.valueOf(j) });
      int i = 0;
      while (i < j)
      {
        localArrayList.add(localJSONArray.get(i).toString());
        i += 1;
      }
      k.a(this.nNw.getAppId(), new k.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(136111);
          Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
          HCEEventLogic.iy(true);
          AppMethodBeat.o(136111);
        }
      });
    }
    catch (Exception localException)
    {
      ((Map)localObject).put("errCode", Integer.valueOf(13003));
      aho(m("fail: aid_list invalid", (Map)localObject));
      c.R(this.nNw.getAppId(), 13003, -1);
      AppMethodBeat.o(136117);
      return;
    }
    localObject = new Intent(this.mContext, this.pfk);
    ((Intent)localObject).putExtra("HCE_Result_Receiver", this.pfn);
    ((Intent)localObject).putExtra("key_appid", this.nNw.getAppId());
    ((Intent)localObject).putExtra("key_time_limit", this.pfm);
    ((Intent)localObject).putStringArrayListExtra("key_aid_list", localException);
    HCEEventLogic.iy(false);
    this.mContext.startService((Intent)localObject);
    this.mStartTime = System.currentTimeMillis();
    localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(136112);
        g localg = g.this;
        synchronized (localg.mLock)
        {
          boolean bool = localg.isFinished;
          if (!bool) {
            localg.isFinished = true;
          }
          if (bool)
          {
            Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
            AppMethodBeat.o(136112);
            return;
          }
        }
        if (HCEEventLogic.bTr())
        {
          Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
          AppMethodBeat.o(136112);
          return;
        }
        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[] { Integer.valueOf(10) });
        HCEEventLogic.iy(true);
        if (localObject1.nNw != null) {
          c.R(localObject1.nNw.getAppId(), 13007, -2);
        }
        ??? = new HashMap();
        ((Map)???).put("errCode", Integer.valueOf(13007));
        localObject1.aho(localObject1.m("fail: start HCEService failed", (Map)???));
        AppMethodBeat.o(136112);
      }
    };
    this.odx = h.ZvG.o((Runnable)localObject, 10000L);
    AppMethodBeat.o(136117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.g
 * JD-Core Version:    0.7.0.1
 */