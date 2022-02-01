package com.tencent.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class i
{
  private static i cPn = null;
  static f cPo = null;
  public static volatile long cPp = 0L;
  static h cPq = null;
  public static Context mContext = null;
  public static Handler mHandler = null;
  private g cPr;
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(87653);
    this.cPr = null;
    HandlerThread localHandlerThread = new HandlerThread(i.class.getSimpleName());
    localHandlerThread.start();
    mHandler = new Handler(localHandlerThread.getLooper());
    paramContext = paramContext.getApplicationContext();
    mContext = paramContext;
    cPp = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    AppMethodBeat.o(87653);
  }
  
  public static void a(f paramf)
  {
    cPo = paramf;
  }
  
  public static i aW(Context paramContext)
  {
    AppMethodBeat.i(87654);
    if (cPn == null) {}
    try
    {
      if (cPn == null) {
        cPn = new i(paramContext);
      }
      paramContext = cPn;
      AppMethodBeat.o(87654);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(87654);
    }
  }
  
  public final String JM()
  {
    AppMethodBeat.i(87655);
    if ((this.cPr == null) || (!s.eq(this.cPr.cPl)))
    {
      this.cPr = r.aY(mContext).JQ();
      if (!s.eq(this.cPr.cPl)) {
        break label112;
      }
    }
    label112:
    for (int i = 2;; i = 1)
    {
      if (mHandler != null) {
        mHandler.post(new n(mContext, i));
      }
      new StringBuilder("wx get mid:").append(this.cPr.cPl);
      String str = this.cPr.cPl;
      AppMethodBeat.o(87655);
      return str;
    }
  }
  
  public final String JN()
  {
    AppMethodBeat.i(87656);
    if ((this.cPr == null) || (!s.eq(this.cPr.cPl))) {
      this.cPr = r.aY(mContext).JQ();
    }
    String str = this.cPr.cPl;
    AppMethodBeat.o(87656);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */