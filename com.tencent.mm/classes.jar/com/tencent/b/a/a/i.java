package com.tencent.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class i
{
  public static volatile long cDA = 0L;
  static h cDB = null;
  private static i cDy;
  static f cDz;
  public static Context mContext = null;
  public static Handler mHandler = null;
  private g cDC;
  
  static
  {
    cDy = null;
    cDz = null;
  }
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(87653);
    this.cDC = null;
    HandlerThread localHandlerThread = new HandlerThread(i.class.getSimpleName());
    localHandlerThread.start();
    mHandler = new Handler(localHandlerThread.getLooper());
    paramContext = paramContext.getApplicationContext();
    mContext = paramContext;
    cDA = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    AppMethodBeat.o(87653);
  }
  
  public static void a(f paramf)
  {
    cDz = paramf;
  }
  
  public static i aV(Context paramContext)
  {
    AppMethodBeat.i(87654);
    if (cDy == null) {}
    try
    {
      if (cDy == null) {
        cDy = new i(paramContext);
      }
      paramContext = cDy;
      AppMethodBeat.o(87654);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(87654);
    }
  }
  
  public final String Ie()
  {
    AppMethodBeat.i(87655);
    if ((this.cDC == null) || (!s.dp(this.cDC.cDw)))
    {
      this.cDC = r.aX(mContext).Ii();
      if (!s.dp(this.cDC.cDw)) {
        break label112;
      }
    }
    label112:
    for (int i = 2;; i = 1)
    {
      if (mHandler != null) {
        mHandler.post(new n(mContext, i));
      }
      new StringBuilder("wx get mid:").append(this.cDC.cDw);
      String str = this.cDC.cDw;
      AppMethodBeat.o(87655);
      return str;
    }
  }
  
  public final String If()
  {
    AppMethodBeat.i(87656);
    if ((this.cDC == null) || (!s.dp(this.cDC.cDw))) {
      this.cDC = r.aX(mContext).Ii();
    }
    String str = this.cDC.cDw;
    AppMethodBeat.o(87656);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */