package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
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
  private JSONObject bhk;
  private int bhx = -1;
  Activity fyk = null;
  com.tencent.mm.plugin.appbrand.jsapi.c gfZ = null;
  private Class<?> gxW = null;
  Class<?> gxX = null;
  private int gxY;
  boolean gxZ = false;
  private ResultReceiver gya = new JsApiNFCStartHCE.5(this, ah.fetchFreeHandler(Looper.getMainLooper()));
  final Object mLock = new Object();
  long mStartTime = -1L;
  Timer mTimer;
  
  public d(Class<?> paramClass1, Class<?> paramClass2)
  {
    this.gxW = paramClass1;
    this.gxX = paramClass2;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo appbrand start HCE, data: %s", new Object[] { paramJSONObject.toString() });
    this.gfZ = paramc;
    this.bhx = paramInt;
    this.bhk = paramJSONObject;
    this.gxZ = false;
    if ((this.gxW == null) || (this.gxX == null))
    {
      tT(h("fail: HostApduService or HCETransparentUI is nil", null));
      return;
    }
    this.gxY = this.bhk.optInt("time_limit", 1500);
    a(new d.1(this));
  }
  
  final void onSuccess()
  {
    Object localObject = new HashMap();
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = this.bhk.getJSONArray("aid_list");
      int j = localJSONArray.length();
      y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mData: %s, aidList: %s, length: %d", new Object[] { this.bhk.toString(), localJSONArray.toString(), Integer.valueOf(j) });
      int i = 0;
      while (i < j)
      {
        localArrayList.add(localJSONArray.get(i).toString());
        i += 1;
      }
      g.a(this.gfZ.getAppId(), new d.2(this));
    }
    catch (Exception localException)
    {
      ((Map)localObject).put("errCode", Integer.valueOf(13003));
      tT(h("fail: aid_list invalid", (Map)localObject));
      com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.E(this.gfZ.getAppId(), 13003, -1);
      return;
    }
    localObject = new Intent(this.fyk, this.gxW);
    ((Intent)localObject).putExtra("HCE_Result_Receiver", this.gya);
    ((Intent)localObject).putExtra("key_appid", this.gfZ.getAppId());
    ((Intent)localObject).putExtra("key_time_limit", this.gxY);
    ((Intent)localObject).putStringArrayListExtra("key_aid_list", localException);
    HCEEventLogic.dq(false);
    this.fyk.startService((Intent)localObject);
    this.mStartTime = System.currentTimeMillis();
    localObject = new d.3(this);
    this.mTimer = new Timer();
    this.mTimer.schedule((TimerTask)localObject, 10000L);
  }
  
  final void tT(String paramString)
  {
    y.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCE callback result: %s", new Object[] { paramString });
    if (this.gfZ != null) {
      this.gfZ.C(this.bhx, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.d
 * JD-Core Version:    0.7.0.1
 */