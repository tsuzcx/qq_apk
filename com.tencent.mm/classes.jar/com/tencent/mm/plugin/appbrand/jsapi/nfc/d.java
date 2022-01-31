package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 352;
  public static final String NAME = "startHCE";
  ResultReceiver Di;
  private JSONObject bxK;
  private int bxX;
  boolean eRZ;
  Activity gQx;
  com.tencent.mm.plugin.appbrand.jsapi.c hAC;
  private Class<?> hUw;
  Application.ActivityLifecycleCallbacks hUx;
  private int hUy;
  private ResultReceiver hUz;
  final Object mLock;
  long mStartTime;
  Timer mTimer;
  
  public d(Class<?> paramClass)
  {
    AppMethodBeat.i(141910);
    this.hUw = null;
    this.gQx = null;
    this.hUx = null;
    this.hAC = null;
    this.bxX = -1;
    this.mStartTime = -1L;
    this.mLock = new Object();
    this.eRZ = false;
    this.hUz = new JsApiNFCStartHCE.6(this, ak.fetchFreeHandler(Looper.getMainLooper()));
    if (paramClass == null)
    {
      this.hUw = HCEService.class;
      AppMethodBeat.o(141910);
      return;
    }
    this.hUw = paramClass;
    AppMethodBeat.o(141910);
  }
  
  final void BS(String paramString)
  {
    AppMethodBeat.i(137879);
    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[] { paramString });
    if (this.hAC != null) {
      this.hAC.h(this.bxX, paramString);
    }
    if ((this.gQx != null) && (this.hUx != null))
    {
      ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback unregister lifecycle callback");
      this.gQx.getApplication().unregisterActivityLifecycleCallbacks(this.hUx);
    }
    AppMethodBeat.o(137879);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c arg1, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(137878);
    ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[] { paramJSONObject.toString() });
    this.hAC = ???;
    this.bxX = paramInt;
    this.bxK = paramJSONObject;
    synchronized (this.mLock)
    {
      this.eRZ = false;
      if (this.hUw == null)
      {
        BS(j("fail: HostApduService is nil", null));
        AppMethodBeat.o(137878);
        return;
      }
    }
    this.hUy = this.bxK.optInt("time_limit", 1500);
    a(new d.1(this));
    AppMethodBeat.o(137878);
  }
  
  final void onSuccess()
  {
    AppMethodBeat.i(137880);
    Object localObject = new HashMap();
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = this.bxK.getJSONArray("aid_list");
      int j = localJSONArray.length();
      ab.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[] { this.bxK.toString(), localJSONArray.toString(), Integer.valueOf(j) });
      int i = 0;
      while (i < j)
      {
        localArrayList.add(localJSONArray.get(i).toString());
        i += 1;
      }
      e.a(this.hAC.getAppId(), new d.3(this));
    }
    catch (Exception localException)
    {
      ((Map)localObject).put("errCode", Integer.valueOf(13003));
      BS(j("fail: aid_list invalid", (Map)localObject));
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.Q(this.hAC.getAppId(), 13003, -1);
      AppMethodBeat.o(137880);
      return;
    }
    localObject = new Intent(this.gQx, this.hUw);
    ((Intent)localObject).putExtra("HCE_Result_Receiver", this.hUz);
    ((Intent)localObject).putExtra("key_appid", this.hAC.getAppId());
    ((Intent)localObject).putExtra("key_time_limit", this.hUy);
    ((Intent)localObject).putStringArrayListExtra("key_aid_list", localException);
    HCEEventLogic.ev(false);
    this.gQx.startService((Intent)localObject);
    this.mStartTime = System.currentTimeMillis();
    localObject = new d.4(this);
    this.mTimer = new Timer();
    this.mTimer.schedule((TimerTask)localObject, 10000L);
    AppMethodBeat.o(137880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.d
 * JD-Core Version:    0.7.0.1
 */