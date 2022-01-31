package com.tencent.c.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class i
{
  private static i bUG = null;
  static f bUH = null;
  public static volatile long bUI = 0L;
  static h bUJ = null;
  public static Context mContext = null;
  public static Handler mHandler = null;
  private g bUK;
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(125771);
    this.bUK = null;
    HandlerThread localHandlerThread = new HandlerThread(i.class.getSimpleName());
    localHandlerThread.start();
    mHandler = new Handler(localHandlerThread.getLooper());
    paramContext = paramContext.getApplicationContext();
    mContext = paramContext;
    bUI = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    AppMethodBeat.o(125771);
  }
  
  public static void a(f paramf)
  {
    bUH = paramf;
  }
  
  public static i aL(Context paramContext)
  {
    AppMethodBeat.i(125772);
    if (bUG == null) {}
    try
    {
      if (bUG == null) {
        bUG = new i(paramContext);
      }
      paramContext = bUG;
      AppMethodBeat.o(125772);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(125772);
    }
  }
  
  public final String zO()
  {
    AppMethodBeat.i(125773);
    if ((this.bUK == null) || (!s.cJ(this.bUK.bUE)))
    {
      this.bUK = r.aN(mContext).zS();
      if (!s.cJ(this.bUK.bUE)) {
        break label112;
      }
    }
    label112:
    for (int i = 2;; i = 1)
    {
      if (mHandler != null) {
        mHandler.post(new n(mContext, i));
      }
      new StringBuilder("wx get mid:").append(this.bUK.bUE);
      String str = this.bUK.bUE;
      AppMethodBeat.o(125773);
      return str;
    }
  }
  
  public final String zP()
  {
    AppMethodBeat.i(125774);
    if ((this.bUK == null) || (!s.cJ(this.bUK.bUE))) {
      this.bUK = r.aN(mContext).zS();
    }
    String str = this.bUK.bUE;
    AppMethodBeat.o(125774);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.c.a.a.i
 * JD-Core Version:    0.7.0.1
 */