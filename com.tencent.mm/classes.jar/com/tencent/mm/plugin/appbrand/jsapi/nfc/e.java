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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
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
  ResultReceiver KS;
  private JSONObject bVY;
  private int bWl;
  boolean gnd;
  Activity jHh;
  private Class<?> kBW;
  Application.ActivityLifecycleCallbacks kBX;
  private int kBY;
  private ResultReceiver kBZ;
  com.tencent.mm.plugin.appbrand.jsapi.c kay;
  final Object mLock;
  long mStartTime;
  Timer mTimer;
  
  public e(Class<?> paramClass)
  {
    AppMethodBeat.i(136114);
    this.kBW = null;
    this.jHh = null;
    this.kBX = null;
    this.kay = null;
    this.bWl = -1;
    this.mStartTime = -1L;
    this.mLock = new Object();
    this.gnd = false;
    this.kBZ = new JsApiNFCStartHCE.6(this, ao.createFreeHandler(Looper.getMainLooper()));
    this.kBW = paramClass;
    AppMethodBeat.o(136114);
  }
  
  final void LV(String paramString)
  {
    AppMethodBeat.i(136116);
    ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[] { paramString });
    if (this.kay != null) {
      this.kay.h(this.bWl, paramString);
    }
    if ((this.jHh != null) && (this.kBX != null))
    {
      ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback unregister lifecycle callback");
      this.jHh.getApplication().unregisterActivityLifecycleCallbacks(this.kBX);
    }
    AppMethodBeat.o(136116);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c arg1, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136115);
    ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[] { paramJSONObject.toString() });
    this.kay = ???;
    this.bWl = paramInt;
    this.bVY = paramJSONObject;
    synchronized (this.mLock)
    {
      this.gnd = false;
      if (this.kBW == null)
      {
        LV(e("fail: HostApduService is nil", null));
        AppMethodBeat.o(136115);
        return;
      }
    }
    this.kBY = this.bVY.optInt("time_limit", 1500);
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
          if (!(paramAnonymousString.kay.getContext() instanceof Activity))
          {
            paramAnonymousString.LV(paramAnonymousString.e("fail: unknown error", null));
            AppMethodBeat.o(136107);
            return;
          }
          paramAnonymousString.jHh = ((Activity)paramAnonymousString.kay.getContext());
          paramAnonymousString.kBX = new e.2(paramAnonymousString);
          paramAnonymousString.jHh.getApplication().registerActivityLifecycleCallbacks(paramAnonymousString.kBX);
          paramAnonymousString.KS = new JsApiNFCStartHCE.3(paramAnonymousString, ao.createFreeHandler(Looper.getMainLooper()));
          a.kCm.a(paramAnonymousString.jHh, paramAnonymousString.KS);
          a.kCm.resetStatus();
          paramAnonymousString = new ComponentName(paramAnonymousString.jHh, HCEService.class.getCanonicalName());
          a.kCm.b(paramAnonymousString);
          a.kCm.bhU();
          AppMethodBeat.o(136107);
          return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.M(e.this.kay.getAppId(), paramAnonymousInt, -1);
        e.this.LV(e.this.k("fail: ".concat(String.valueOf(paramAnonymousString)), localHashMap));
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
      JSONArray localJSONArray = this.bVY.getJSONArray("aid_list");
      int j = localJSONArray.length();
      ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[] { this.bVY.toString(), localJSONArray.toString(), Integer.valueOf(j) });
      int i = 0;
      while (i < j)
      {
        localArrayList.add(localJSONArray.get(i).toString());
        i += 1;
      }
      g.a(this.kay.getAppId(), new g.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(136111);
          ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
          HCEEventLogic.gG(true);
          AppMethodBeat.o(136111);
        }
      });
    }
    catch (Exception localException)
    {
      ((Map)localObject).put("errCode", Integer.valueOf(13003));
      LV(k("fail: aid_list invalid", (Map)localObject));
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.M(this.kay.getAppId(), 13003, -1);
      AppMethodBeat.o(136117);
      return;
    }
    localObject = new Intent(this.jHh, this.kBW);
    ((Intent)localObject).putExtra("HCE_Result_Receiver", this.kBZ);
    ((Intent)localObject).putExtra("key_appid", this.kay.getAppId());
    ((Intent)localObject).putExtra("key_time_limit", this.kBY);
    ((Intent)localObject).putStringArrayListExtra("key_aid_list", localException);
    HCEEventLogic.gG(false);
    this.jHh.startService((Intent)localObject);
    this.mStartTime = System.currentTimeMillis();
    localObject = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(136112);
        e locale = e.this;
        synchronized (locale.mLock)
        {
          boolean bool = locale.gnd;
          if (!bool) {
            locale.gnd = true;
          }
          if (bool)
          {
            ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
            AppMethodBeat.o(136112);
            return;
          }
        }
        if (HCEEventLogic.bhT())
        {
          ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
          AppMethodBeat.o(136112);
          return;
        }
        ac.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[] { Integer.valueOf(10) });
        HCEEventLogic.gG(true);
        if (localObject1.kay != null) {
          com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.M(localObject1.kay.getAppId(), 13007, -2);
        }
        ??? = new HashMap();
        ((Map)???).put("errCode", Integer.valueOf(13007));
        localObject1.LV(localObject1.k("fail: start HCEService failed", (Map)???));
        AppMethodBeat.o(136112);
      }
    };
    this.mTimer = new Timer();
    this.mTimer.schedule((TimerTask)localObject, 10000L);
    AppMethodBeat.o(136117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.e
 * JD-Core Version:    0.7.0.1
 */