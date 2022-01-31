package com.tencent.map.swlocation.api;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.d.a.a.q;
import com.d.a.a.t;

public class SwEngine
{
  public static void creatLocationEngine(Context paramContext, q paramq)
  {
    t.a(paramContext, paramq);
  }
  
  public static void onDestroy() {}
  
  public static void setImei(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new NullPointerException("SenseWhereEngine:invalid imei!");
    }
    t.setImei(paramString);
  }
  
  public static void startContinousLocationUpdate(Handler paramHandler, int paramInt1, int paramInt2, LocationUpdateListener paramLocationUpdateListener, ServerMessageListener paramServerMessageListener)
  {
    t.a(paramHandler, paramInt2, paramLocationUpdateListener, paramServerMessageListener);
  }
  
  public static void stopContinousLocationUpdate() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.swlocation.api.SwEngine
 * JD-Core Version:    0.7.0.1
 */