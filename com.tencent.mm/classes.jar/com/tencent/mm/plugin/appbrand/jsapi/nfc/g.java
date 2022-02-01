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
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 352;
  public static final String NAME = "startHCE";
  ResultReceiver MU;
  private JSONObject csi;
  private int csv;
  boolean isFinished;
  f kSY;
  Activity mContext;
  final Object mLock;
  long mStartTime;
  Timer mTimer;
  private Class<?> mhd;
  Application.ActivityLifecycleCallbacks mhe;
  private int mhf;
  private ResultReceiver mhg;
  
  public g(Class<?> paramClass)
  {
    AppMethodBeat.i(136114);
    this.mhd = null;
    this.mContext = null;
    this.mhe = null;
    this.kSY = null;
    this.csv = -1;
    this.mStartTime = -1L;
    this.mLock = new Object();
    this.isFinished = false;
    this.mhg = new JsApiNFCStartHCE.6(this, MMHandler.createFreeHandler(Looper.getMainLooper()));
    this.mhd = paramClass;
    AppMethodBeat.o(136114);
  }
  
  final void ZA(String paramString)
  {
    AppMethodBeat.i(136116);
    Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[] { paramString });
    if (this.kSY != null) {
      this.kSY.i(this.csv, paramString);
    }
    if ((this.mContext != null) && (this.mhe != null))
    {
      Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback unregister lifecycle callback");
      this.mContext.getApplication().unregisterActivityLifecycleCallbacks(this.mhe);
    }
    AppMethodBeat.o(136116);
  }
  
  public final void a(f arg1, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136115);
    Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[] { paramJSONObject.toString() });
    this.kSY = ???;
    this.csv = paramInt;
    this.csi = paramJSONObject;
    synchronized (this.mLock)
    {
      this.isFinished = false;
      if (this.mhd == null)
      {
        ZA(h("fail: HostApduService is nil", null));
        AppMethodBeat.o(136115);
        return;
      }
    }
    this.mhf = this.csi.optInt("time_limit", 1500);
    a(new JsApiAppBrandNFCBase.a()
    {
      public final void A(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(136107);
        HashMap localHashMap = new HashMap();
        localHashMap.put("errCode", Integer.valueOf(paramAnonymousInt));
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = g.this;
          if (!(paramAnonymousString.kSY.getContext() instanceof Activity))
          {
            paramAnonymousString.ZA(paramAnonymousString.h("fail: unknown error", null));
            AppMethodBeat.o(136107);
            return;
          }
          paramAnonymousString.mContext = ((Activity)paramAnonymousString.kSY.getContext());
          paramAnonymousString.mhe = new g.2(paramAnonymousString);
          paramAnonymousString.mContext.getApplication().registerActivityLifecycleCallbacks(paramAnonymousString.mhe);
          paramAnonymousString.MU = new JsApiNFCStartHCE.3(paramAnonymousString, MMHandler.createFreeHandler(Looper.getMainLooper()));
          a.mht.a(paramAnonymousString.mContext, paramAnonymousString.MU);
          a.mht.resetStatus();
          paramAnonymousString = new ComponentName(paramAnonymousString.mContext, HCEService.class.getCanonicalName());
          a.mht.b(paramAnonymousString);
          a.mht.bHM();
          AppMethodBeat.o(136107);
          return;
        }
        c.R(g.this.kSY.getAppId(), paramAnonymousInt, -1);
        g.this.ZA(g.this.n("fail: ".concat(String.valueOf(paramAnonymousString)), localHashMap));
        AppMethodBeat.o(136107);
      }
    });
    AppMethodBeat.o(136115);
  }
  
  final void onSuccess()
  {
    AppMethodBeat.i(136117);
    Object localObject = new HashMap();
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = this.csi.getJSONArray("aid_list");
      int j = localJSONArray.length();
      Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[] { this.csi.toString(), localJSONArray.toString(), Integer.valueOf(j) });
      int i = 0;
      while (i < j)
      {
        localArrayList.add(localJSONArray.get(i).toString());
        i += 1;
      }
      h.a(this.kSY.getAppId(), new h.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(136111);
          Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
          HCEEventLogic.hI(true);
          AppMethodBeat.o(136111);
        }
      });
    }
    catch (Exception localException)
    {
      ((Map)localObject).put("errCode", Integer.valueOf(13003));
      ZA(n("fail: aid_list invalid", (Map)localObject));
      c.R(this.kSY.getAppId(), 13003, -1);
      AppMethodBeat.o(136117);
      return;
    }
    localObject = new Intent(this.mContext, this.mhd);
    ((Intent)localObject).putExtra("HCE_Result_Receiver", this.mhg);
    ((Intent)localObject).putExtra("key_appid", this.kSY.getAppId());
    ((Intent)localObject).putExtra("key_time_limit", this.mhf);
    ((Intent)localObject).putStringArrayListExtra("key_aid_list", localException);
    HCEEventLogic.hI(false);
    this.mContext.startService((Intent)localObject);
    this.mStartTime = System.currentTimeMillis();
    localObject = new TimerTask()
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
        if (HCEEventLogic.bHI())
        {
          Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
          AppMethodBeat.o(136112);
          return;
        }
        Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[] { Integer.valueOf(10) });
        HCEEventLogic.hI(true);
        if (localObject1.kSY != null) {
          c.R(localObject1.kSY.getAppId(), 13007, -2);
        }
        ??? = new HashMap();
        ((Map)???).put("errCode", Integer.valueOf(13007));
        localObject1.ZA(localObject1.n("fail: start HCEService failed", (Map)???));
        AppMethodBeat.o(136112);
      }
    };
    this.mTimer = new Timer();
    this.mTimer.schedule((TimerTask)localObject, 10000L);
    AppMethodBeat.o(136117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.g
 * JD-Core Version:    0.7.0.1
 */