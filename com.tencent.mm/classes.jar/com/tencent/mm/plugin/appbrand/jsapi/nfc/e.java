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
import com.tencent.mm.plugin.appbrand.g;
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

public final class e
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 352;
  public static final String NAME = "startHCE";
  ResultReceiver JX;
  private JSONObject bZb;
  private int bZo;
  boolean goa;
  com.tencent.mm.plugin.appbrand.jsapi.c jAc;
  Activity jgS;
  private Class<?> kbj;
  Application.ActivityLifecycleCallbacks kbk;
  private int kbl;
  private ResultReceiver kbm;
  final Object mLock;
  long mStartTime;
  Timer mTimer;
  
  public e(Class<?> paramClass)
  {
    AppMethodBeat.i(136114);
    this.kbj = null;
    this.jgS = null;
    this.kbk = null;
    this.jAc = null;
    this.bZo = -1;
    this.mStartTime = -1L;
    this.mLock = new Object();
    this.goa = false;
    this.kbm = new JsApiNFCStartHCE.6(this, ap.createFreeHandler(Looper.getMainLooper()));
    this.kbj = paramClass;
    AppMethodBeat.o(136114);
  }
  
  final void HQ(String paramString)
  {
    AppMethodBeat.i(136116);
    ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[] { paramString });
    if (this.jAc != null) {
      this.jAc.h(this.bZo, paramString);
    }
    if ((this.jgS != null) && (this.kbk != null))
    {
      ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback unregister lifecycle callback");
      this.jgS.getApplication().unregisterActivityLifecycleCallbacks(this.kbk);
    }
    AppMethodBeat.o(136116);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c arg1, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136115);
    ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[] { paramJSONObject.toString() });
    this.jAc = ???;
    this.bZo = paramInt;
    this.bZb = paramJSONObject;
    synchronized (this.mLock)
    {
      this.goa = false;
      if (this.kbj == null)
      {
        HQ(e("fail: HostApduService is nil", null));
        AppMethodBeat.o(136115);
        return;
      }
    }
    this.kbl = this.bZb.optInt("time_limit", 1500);
    a(new JsApiAppBrandNFCBase.a()
    {
      public final void y(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(136107);
        HashMap localHashMap = new HashMap();
        localHashMap.put("errCode", Integer.valueOf(paramAnonymousInt));
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = e.this;
          if (!(paramAnonymousString.jAc.getContext() instanceof Activity))
          {
            paramAnonymousString.HQ(paramAnonymousString.e("fail: unknown error", null));
            AppMethodBeat.o(136107);
            return;
          }
          paramAnonymousString.jgS = ((Activity)paramAnonymousString.jAc.getContext());
          paramAnonymousString.kbk = new e.2(paramAnonymousString);
          paramAnonymousString.jgS.getApplication().registerActivityLifecycleCallbacks(paramAnonymousString.kbk);
          paramAnonymousString.JX = new JsApiNFCStartHCE.3(paramAnonymousString, ap.createFreeHandler(Looper.getMainLooper()));
          a.kbz.a(paramAnonymousString.jgS, paramAnonymousString.JX);
          a.kbz.resetStatus();
          paramAnonymousString = new ComponentName(paramAnonymousString.jgS, HCEService.class.getCanonicalName());
          a.kbz.b(paramAnonymousString);
          a.kbz.bbc();
          AppMethodBeat.o(136107);
          return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.N(e.this.jAc.getAppId(), paramAnonymousInt, -1);
        e.this.HQ(e.this.k("fail: ".concat(String.valueOf(paramAnonymousString)), localHashMap));
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
      JSONArray localJSONArray = this.bZb.getJSONArray("aid_list");
      int j = localJSONArray.length();
      ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[] { this.bZb.toString(), localJSONArray.toString(), Integer.valueOf(j) });
      int i = 0;
      while (i < j)
      {
        localArrayList.add(localJSONArray.get(i).toString());
        i += 1;
      }
      g.a(this.jAc.getAppId(), new g.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(136111);
          ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
          HCEEventLogic.gk(true);
          AppMethodBeat.o(136111);
        }
      });
    }
    catch (Exception localException)
    {
      ((Map)localObject).put("errCode", Integer.valueOf(13003));
      HQ(k("fail: aid_list invalid", (Map)localObject));
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.N(this.jAc.getAppId(), 13003, -1);
      AppMethodBeat.o(136117);
      return;
    }
    localObject = new Intent(this.jgS, this.kbj);
    ((Intent)localObject).putExtra("HCE_Result_Receiver", this.kbm);
    ((Intent)localObject).putExtra("key_appid", this.jAc.getAppId());
    ((Intent)localObject).putExtra("key_time_limit", this.kbl);
    ((Intent)localObject).putStringArrayListExtra("key_aid_list", localException);
    HCEEventLogic.gk(false);
    this.jgS.startService((Intent)localObject);
    this.mStartTime = System.currentTimeMillis();
    localObject = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(136112);
        e locale = e.this;
        synchronized (locale.mLock)
        {
          boolean bool = locale.goa;
          if (!bool) {
            locale.goa = true;
          }
          if (bool)
          {
            ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
            AppMethodBeat.o(136112);
            return;
          }
        }
        if (HCEEventLogic.bbb())
        {
          ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
          AppMethodBeat.o(136112);
          return;
        }
        ad.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[] { Integer.valueOf(10) });
        HCEEventLogic.gk(true);
        if (localObject1.jAc != null) {
          com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.N(localObject1.jAc.getAppId(), 13007, -2);
        }
        ??? = new HashMap();
        ((Map)???).put("errCode", Integer.valueOf(13007));
        localObject1.HQ(localObject1.k("fail: start HCEService failed", (Map)???));
        AppMethodBeat.o(136112);
      }
    };
    this.mTimer = new Timer();
    this.mTimer.schedule((TimerTask)localObject, 10000L);
    AppMethodBeat.o(136117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.e
 * JD-Core Version:    0.7.0.1
 */