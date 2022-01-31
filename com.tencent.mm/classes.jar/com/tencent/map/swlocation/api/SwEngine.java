package com.tencent.map.swlocation.api;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.b.a.a.q;
import com.b.a.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwEngine
{
  public static void creatLocationEngine(Context paramContext, q paramq)
  {
    AppMethodBeat.i(55533);
    t.a(paramContext, paramq);
    AppMethodBeat.o(55533);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(55535);
    t.finish();
    AppMethodBeat.o(55535);
  }
  
  public static void setImei(String paramString)
  {
    AppMethodBeat.i(55534);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("SenseWhereEngine:invalid imei!");
      AppMethodBeat.o(55534);
      throw paramString;
    }
    t.setImei(paramString);
    AppMethodBeat.o(55534);
  }
  
  public static void startContinousLocationUpdate(Handler paramHandler, int paramInt1, int paramInt2, LocationUpdateListener paramLocationUpdateListener, ServerMessageListener paramServerMessageListener)
  {
    AppMethodBeat.i(55531);
    t.a(paramHandler, paramInt2, paramLocationUpdateListener, paramServerMessageListener);
    AppMethodBeat.o(55531);
  }
  
  public static void stopContinousLocationUpdate()
  {
    AppMethodBeat.i(55532);
    t.tB();
    AppMethodBeat.o(55532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.swlocation.api.SwEngine
 * JD-Core Version:    0.7.0.1
 */