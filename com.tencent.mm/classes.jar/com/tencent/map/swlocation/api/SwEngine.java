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
    AppMethodBeat.i(87878);
    t.a(paramContext, paramq);
    AppMethodBeat.o(87878);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(87880);
    t.finish();
    AppMethodBeat.o(87880);
  }
  
  public static void setImei(String paramString)
  {
    AppMethodBeat.i(87879);
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("SenseWhereEngine:invalid imei!");
      AppMethodBeat.o(87879);
      throw paramString;
    }
    t.setImei(paramString);
    AppMethodBeat.o(87879);
  }
  
  public static void startContinousLocationUpdate(Handler paramHandler, int paramInt1, int paramInt2, LocationUpdateListener paramLocationUpdateListener, ServerMessageListener paramServerMessageListener)
  {
    AppMethodBeat.i(87876);
    t.a(paramHandler, paramInt2, paramLocationUpdateListener, paramServerMessageListener);
    AppMethodBeat.o(87876);
  }
  
  public static void stopContinousLocationUpdate()
  {
    AppMethodBeat.i(87877);
    t.Jt();
    AppMethodBeat.o(87877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.map.swlocation.api.SwEngine
 * JD-Core Version:    0.7.0.1
 */