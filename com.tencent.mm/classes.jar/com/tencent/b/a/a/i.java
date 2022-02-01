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
  private static i cOD = null;
  static f cOE = null;
  public static volatile long cOF = 0L;
  static h cOG = null;
  public static Context mContext = null;
  public static Handler mHandler = null;
  private g cOH;
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(87653);
    this.cOH = null;
    HandlerThread localHandlerThread = new HandlerThread(i.class.getSimpleName());
    localHandlerThread.start();
    mHandler = new Handler(localHandlerThread.getLooper());
    paramContext = paramContext.getApplicationContext();
    mContext = paramContext;
    cOF = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    AppMethodBeat.o(87653);
  }
  
  public static void a(f paramf)
  {
    cOE = paramf;
  }
  
  public static i aV(Context paramContext)
  {
    AppMethodBeat.i(87654);
    if (cOD == null) {}
    try
    {
      if (cOD == null) {
        cOD = new i(paramContext);
      }
      paramContext = cOD;
      AppMethodBeat.o(87654);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(87654);
    }
  }
  
  public final String JE()
  {
    AppMethodBeat.i(87655);
    if ((this.cOH == null) || (!s.el(this.cOH.cOB)))
    {
      this.cOH = r.aX(mContext).JI();
      if (!s.el(this.cOH.cOB)) {
        break label112;
      }
    }
    label112:
    for (int i = 2;; i = 1)
    {
      if (mHandler != null) {
        mHandler.post(new n(mContext, i));
      }
      new StringBuilder("wx get mid:").append(this.cOH.cOB);
      String str = this.cOH.cOB;
      AppMethodBeat.o(87655);
      return str;
    }
  }
  
  public final String JF()
  {
    AppMethodBeat.i(87656);
    if ((this.cOH == null) || (!s.el(this.cOH.cOB))) {
      this.cOH = r.aX(mContext).JI();
    }
    String str = this.cOH.cOB;
    AppMethodBeat.o(87656);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */