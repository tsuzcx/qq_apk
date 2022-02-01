package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
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
  ResultReceiver dK;
  private JSONObject eif;
  private int eit;
  boolean isFinished;
  Activity mContext;
  final Object mLock;
  long mStartTime;
  f qNp;
  Future<?> rep;
  private final Class<?> skD;
  Application.ActivityLifecycleCallbacks skE;
  private int skF;
  private ResultReceiver skG;
  
  public g(Class<?> paramClass)
  {
    AppMethodBeat.i(136114);
    this.mContext = null;
    this.skE = null;
    this.qNp = null;
    this.eit = -1;
    this.mStartTime = -1L;
    this.mLock = new Object();
    this.isFinished = false;
    this.skG = new JsApiNFCStartHCE.6(this, MMHandler.createFreeHandler(Looper.getMainLooper()));
    this.skD = paramClass;
    AppMethodBeat.o(136114);
  }
  
  public final void a(f arg1, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136115);
    Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[] { paramJSONObject.toString() });
    this.qNp = ???;
    this.eit = paramInt;
    this.eif = paramJSONObject;
    synchronized (this.mLock)
    {
      this.isFinished = false;
      this.skF = this.eif.optInt("time_limit", 1500);
      a(new JsApiAppBrandNFCBase.a()
      {
        public final void onResult(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(136107);
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousInt));
          if (paramAnonymousInt == 0)
          {
            paramAnonymousString = g.this;
            if (!(paramAnonymousString.qNp.getContext() instanceof Activity))
            {
              paramAnonymousString.aal(paramAnonymousString.ZP("fail: unknown error"));
              AppMethodBeat.o(136107);
              return;
            }
            paramAnonymousString.mContext = ((Activity)paramAnonymousString.qNp.getContext());
            paramAnonymousString.skE = new g.2(paramAnonymousString);
            paramAnonymousString.mContext.getApplication().registerActivityLifecycleCallbacks(paramAnonymousString.skE);
            paramAnonymousString.dK = new JsApiNFCStartHCE.3(paramAnonymousString, MMHandler.createFreeHandler(Looper.getMainLooper()));
            a.skT.a(paramAnonymousString.mContext, paramAnonymousString.dK);
            a.skT.resetStatus();
            paramAnonymousString = new ComponentName(paramAnonymousString.mContext, HCEService.class.getCanonicalName());
            a.skT.c(paramAnonymousString);
            a.skT.ctA();
            AppMethodBeat.o(136107);
            return;
          }
          c.V(g.this.qNp.getAppId(), paramAnonymousInt, -1);
          g.this.aal(j.a(g.this, paramAnonymousInt, "fail: ".concat(String.valueOf(paramAnonymousString)), localHashMap));
          AppMethodBeat.o(136107);
        }
      });
      AppMethodBeat.o(136115);
      return;
    }
  }
  
  final void aal(String paramString)
  {
    AppMethodBeat.i(136116);
    Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[] { paramString });
    if (this.qNp != null) {
      this.qNp.callback(this.eit, paramString);
    }
    if ((this.mContext != null) && (this.skE != null))
    {
      Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback unregister lifecycle callback");
      this.mContext.getApplication().unregisterActivityLifecycleCallbacks(this.skE);
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
      JSONArray localJSONArray = this.eif.getJSONArray("aid_list");
      int j = localJSONArray.length();
      Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[] { this.eif.toString(), localJSONArray.toString(), Integer.valueOf(j) });
      int i = 0;
      while (i < j)
      {
        localArrayList.add(localJSONArray.get(i).toString());
        i += 1;
      }
      k.a(this.qNp.getAppId(), new k.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(136111);
          Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
          HCEEventLogic.jC(true);
          AppMethodBeat.o(136111);
        }
      });
    }
    catch (Exception localException)
    {
      ((Map)localObject).put("errCode", Integer.valueOf(13003));
      aal(j.a(this, 13003, "fail: aid_list invalid", (Map)localObject));
      c.V(this.qNp.getAppId(), 13003, -1);
      AppMethodBeat.o(136117);
      return;
    }
    localObject = new Intent(this.mContext, this.skD);
    ((Intent)localObject).putExtra("HCE_Result_Receiver", this.skG);
    ((Intent)localObject).putExtra("key_appid", this.qNp.getAppId());
    ((Intent)localObject).putExtra("key_time_limit", this.skF);
    ((Intent)localObject).putStringArrayListExtra("key_aid_list", localException);
    HCEEventLogic.jC(false);
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
        if (HCEEventLogic.ctw())
        {
          Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
          AppMethodBeat.o(136112);
          return;
        }
        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[] { Integer.valueOf(10) });
        HCEEventLogic.jC(true);
        if (localp.qNp != null) {
          c.V(localp.qNp.getAppId(), 13007, -2);
        }
        ??? = new HashMap();
        ((Map)???).put("errCode", Integer.valueOf(13007));
        localp.aal(j.a(localp, 13007, "fail: start HCEService failed", (Map)???));
        AppMethodBeat.o(136112);
      }
    };
    this.rep = h.ahAA.p((Runnable)localObject, 10000L);
    AppMethodBeat.o(136117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.g
 * JD-Core Version:    0.7.0.1
 */