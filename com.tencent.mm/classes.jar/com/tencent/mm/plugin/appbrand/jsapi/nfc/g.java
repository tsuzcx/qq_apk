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
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
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
  boolean gJv;
  com.tencent.mm.plugin.appbrand.jsapi.c jQp;
  Activity keK;
  private Class<?> lbM;
  Application.ActivityLifecycleCallbacks lbN;
  private int lbO;
  private ResultReceiver lbP;
  final Object mLock;
  long mStartTime;
  Timer mTimer;
  
  public g(Class<?> paramClass)
  {
    AppMethodBeat.i(136114);
    this.lbM = null;
    this.keK = null;
    this.lbN = null;
    this.jQp = null;
    this.cgA = -1;
    this.mStartTime = -1L;
    this.mLock = new Object();
    this.gJv = false;
    this.lbP = new JsApiNFCStartHCE.6(this, aq.createFreeHandler(Looper.getMainLooper()));
    this.lbM = paramClass;
    AppMethodBeat.o(136114);
  }
  
  final void PZ(String paramString)
  {
    AppMethodBeat.i(136116);
    ae.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[] { paramString });
    if (this.jQp != null) {
      this.jQp.h(this.cgA, paramString);
    }
    if ((this.keK != null) && (this.lbN != null))
    {
      ae.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback unregister lifecycle callback");
      this.keK.getApplication().unregisterActivityLifecycleCallbacks(this.lbN);
    }
    AppMethodBeat.o(136116);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c arg1, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(136115);
    ae.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[] { paramJSONObject.toString() });
    this.jQp = ???;
    this.cgA = paramInt;
    this.cgn = paramJSONObject;
    synchronized (this.mLock)
    {
      this.gJv = false;
      if (this.lbM == null)
      {
        PZ(e("fail: HostApduService is nil", null));
        AppMethodBeat.o(136115);
        return;
      }
    }
    this.lbO = this.cgn.optInt("time_limit", 1500);
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
          if (!(paramAnonymousString.jQp.getContext() instanceof Activity))
          {
            paramAnonymousString.PZ(paramAnonymousString.e("fail: unknown error", null));
            AppMethodBeat.o(136107);
            return;
          }
          paramAnonymousString.keK = ((Activity)paramAnonymousString.jQp.getContext());
          paramAnonymousString.lbN = new g.2(paramAnonymousString);
          paramAnonymousString.keK.getApplication().registerActivityLifecycleCallbacks(paramAnonymousString.lbN);
          paramAnonymousString.MK = new JsApiNFCStartHCE.3(paramAnonymousString, aq.createFreeHandler(Looper.getMainLooper()));
          a.lcc.a(paramAnonymousString.keK, paramAnonymousString.MK);
          a.lcc.resetStatus();
          paramAnonymousString = new ComponentName(paramAnonymousString.keK, HCEService.class.getCanonicalName());
          a.lcc.b(paramAnonymousString);
          a.lcc.bmn();
          AppMethodBeat.o(136107);
          return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.O(g.this.jQp.getAppId(), paramAnonymousInt, -1);
        g.this.PZ(g.this.n("fail: ".concat(String.valueOf(paramAnonymousString)), localHashMap));
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
      ae.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[] { this.cgn.toString(), localJSONArray.toString(), Integer.valueOf(j) });
      int i = 0;
      while (i < j)
      {
        localArrayList.add(localJSONArray.get(i).toString());
        i += 1;
      }
      h.a(this.jQp.getAppId(), new h.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(136111);
          ae.i("MicroMsg.JsApiNFCStartHCE", "alvinluo AppBrandLifeCycle onDestroy");
          HCEEventLogic.gL(true);
          AppMethodBeat.o(136111);
        }
      });
    }
    catch (Exception localException)
    {
      ((Map)localObject).put("errCode", Integer.valueOf(13003));
      PZ(n("fail: aid_list invalid", (Map)localObject));
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.O(this.jQp.getAppId(), 13003, -1);
      AppMethodBeat.o(136117);
      return;
    }
    localObject = new Intent(this.keK, this.lbM);
    ((Intent)localObject).putExtra("HCE_Result_Receiver", this.lbP);
    ((Intent)localObject).putExtra("key_appid", this.jQp.getAppId());
    ((Intent)localObject).putExtra("key_time_limit", this.lbO);
    ((Intent)localObject).putStringArrayListExtra("key_aid_list", localException);
    HCEEventLogic.gL(false);
    this.keK.startService((Intent)localObject);
    this.mStartTime = System.currentTimeMillis();
    localObject = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(136112);
        g localg = g.this;
        synchronized (localg.mLock)
        {
          boolean bool = localg.gJv;
          if (!bool) {
            localg.gJv = true;
          }
          if (bool)
          {
            ae.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has finished, return");
            AppMethodBeat.o(136112);
            return;
          }
        }
        if (HCEEventLogic.bmj())
        {
          ae.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE onStartHCEOvertime has stop, return");
          AppMethodBeat.o(136112);
          return;
        }
        ae.i("MicroMsg.JsApiNFCStartHCE", "alvinluo start HCEService overtime, expect time limit: %d seconds", new Object[] { Integer.valueOf(10) });
        HCEEventLogic.gL(true);
        if (localObject1.jQp != null) {
          com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.O(localObject1.jQp.getAppId(), 13007, -2);
        }
        ??? = new HashMap();
        ((Map)???).put("errCode", Integer.valueOf(13007));
        localObject1.PZ(localObject1.n("fail: start HCEService failed", (Map)???));
        AppMethodBeat.o(136112);
      }
    };
    this.mTimer = new Timer();
    this.mTimer.schedule((TimerTask)localObject, 10000L);
    AppMethodBeat.o(136117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.g
 * JD-Core Version:    0.7.0.1
 */