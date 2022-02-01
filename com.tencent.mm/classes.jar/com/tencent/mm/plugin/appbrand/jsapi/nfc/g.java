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
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
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
  ResultReceiver MK;
  private int cgA;
  private JSONObject cgn;
  boolean gGM;
  private Class<?> kYd;
  Application.ActivityLifecycleCallbacks kYe;
  private int kYf;
  private ResultReceiver kYg;
  Activity kbt;
  com.tencent.mm.plugin.appbrand.jsapi.c kuU;
  final Object mLock;
  long mStartTime;
  Timer mTimer;
  
  public g(Class<?> paramClass)
  {
    AppMethodBeat.i(136114);
    this.kYd = null;
    this.kbt = null;
    this.kYe = null;
    this.kuU = null;
    this.cgA = -1;
    this.mStartTime = -1L;
    this.mLock = new Object();
    this.gGM = false;
    this.kYg = new JsApiNFCStartHCE.6(this, ap.createFreeHandler(Looper.getMainLooper()));
    this.kYd = paramClass;
    AppMethodBeat.o(136114);
  }
  
  final void Pr(String paramString)
  {
    AppMethodBeat.i(136116);
    ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[] { paramString });
    if (this.kuU != null) {
      this.kuU.h(this.cgA, paramString);
    }
    if ((this.kbt != null) && (this.kYe != null))
    {
      ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback unregister lifecycle callback");
      this.kbt.getApplication().unregisterActivityLifecycleCallbacks(this.kYe);
    }
    AppMethodBeat.o(136116);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c arg1, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136115);
    ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[] { paramJSONObject.toString() });
    this.kuU = ???;
    this.cgA = paramInt;
    this.cgn = paramJSONObject;
    synchronized (this.mLock)
    {
      this.gGM = false;
      if (this.kYd == null)
      {
        Pr(e("fail: HostApduService is nil", null));
        AppMethodBeat.o(136115);
        return;
      }
    }
    this.kYf = this.cgn.optInt("time_limit", 1500);
    a(new JsApiAppBrandNFCBase.a()
    {
      public final void y(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(136107);
        HashMap localHashMap = new HashMap();
        localHashMap.put("errCode", Integer.valueOf(paramAnonymousInt));
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = g.this;
          if (!(paramAnonymousString.kuU.getContext() instanceof Activity))
          {
            paramAnonymousString.Pr(paramAnonymousString.e("fail: unknown error", null));
            AppMethodBeat.o(136107);
            return;
          }
          paramAnonymousString.kbt = ((Activity)paramAnonymousString.kuU.getContext());
          paramAnonymousString.kYe = new g.2(paramAnonymousString);
          paramAnonymousString.kbt.getApplication().registerActivityLifecycleCallbacks(paramAnonymousString.kYe);
          paramAnonymousString.MK = new JsApiNFCStartHCE.3(paramAnonymousString, ap.createFreeHandler(Looper.getMainLooper()));
          a.kYt.a(paramAnonymousString.kbt, paramAnonymousString.MK);
          a.kYt.resetStatus();
          paramAnonymousString = new ComponentName(paramAnonymousString.kbt, HCEService.class.getCanonicalName());
          a.kYt.b(paramAnonymousString);
          a.kYt.blE();
          AppMethodBeat.o(136107);
          return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.O(g.this.kuU.getAppId(), paramAnonymousInt, -1);
        g.this.Pr(g.this.m("fail: ".concat(String.valueOf(paramAnonymousString)), localHashMap));
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
      JSONArray localJSONArray = this.cgn.getJSONArray("aid_list");
      int j = localJSONArray.length();
      ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[] { this.cgn.toString(), localJSONArray.toString(), Integer.valueOf(j) });
      int i = 0;
      while (i < j)
      {
        localArrayList.add(localJSONArray.get(i).toString());
        i += 1;
      }
      com.tencent.mm.plugin.appbrand.g.a(this.kuU.getAppId(), new g.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(136111);
          ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
          HCEEventLogic.gM(true);
          AppMethodBeat.o(136111);
        }
      });
    }
    catch (Exception localException)
    {
      ((Map)localObject).put("errCode", Integer.valueOf(13003));
      Pr(m("fail: aid_list invalid", (Map)localObject));
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.O(this.kuU.getAppId(), 13003, -1);
      AppMethodBeat.o(136117);
      return;
    }
    localObject = new Intent(this.kbt, this.kYd);
    ((Intent)localObject).putExtra("HCE_Result_Receiver", this.kYg);
    ((Intent)localObject).putExtra("key_appid", this.kuU.getAppId());
    ((Intent)localObject).putExtra("key_time_limit", this.kYf);
    ((Intent)localObject).putStringArrayListExtra("key_aid_list", localException);
    HCEEventLogic.gM(false);
    this.kbt.startService((Intent)localObject);
    this.mStartTime = System.currentTimeMillis();
    localObject = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(136112);
        g localg = g.this;
        synchronized (localg.mLock)
        {
          boolean bool = localg.gGM;
          if (!bool) {
            localg.gGM = true;
          }
          if (bool)
          {
            ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
            AppMethodBeat.o(136112);
            return;
          }
        }
        if (HCEEventLogic.blA())
        {
          ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
          AppMethodBeat.o(136112);
          return;
        }
        ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[] { Integer.valueOf(10) });
        HCEEventLogic.gM(true);
        if (localObject1.kuU != null) {
          com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.O(localObject1.kuU.getAppId(), 13007, -2);
        }
        ??? = new HashMap();
        ((Map)???).put("errCode", Integer.valueOf(13007));
        localObject1.Pr(localObject1.m("fail: start HCEService failed", (Map)???));
        AppMethodBeat.o(136112);
      }
    };
    this.mTimer = new Timer();
    this.mTimer.schedule((TimerTask)localObject, 10000L);
    AppMethodBeat.o(136117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.g
 * JD-Core Version:    0.7.0.1
 */