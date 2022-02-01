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
  private static i cGq = null;
  static f cGr = null;
  public static volatile long cGs = 0L;
  static h cGt = null;
  public static Context mContext = null;
  public static Handler mHandler = null;
  private g cGu;
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(87653);
    this.cGu = null;
    HandlerThread localHandlerThread = new HandlerThread(i.class.getSimpleName());
    localHandlerThread.start();
    mHandler = new Handler(localHandlerThread.getLooper());
    paramContext = paramContext.getApplicationContext();
    mContext = paramContext;
    cGs = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    AppMethodBeat.o(87653);
  }
  
  public static void a(f paramf)
  {
    cGr = paramf;
  }
  
  public static i aU(Context paramContext)
  {
    AppMethodBeat.i(87654);
    if (cGq == null) {}
    try
    {
      if (cGq == null) {
        cGq = new i(paramContext);
      }
      paramContext = cGq;
      AppMethodBeat.o(87654);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(87654);
    }
  }
  
  public final String Iv()
  {
    AppMethodBeat.i(87655);
    if ((this.cGu == null) || (!s.dA(this.cGu.cGo)))
    {
      this.cGu = r.aW(mContext).Iz();
      if (!s.dA(this.cGu.cGo)) {
        break label112;
      }
    }
    label112:
    for (int i = 2;; i = 1)
    {
      if (mHandler != null) {
        mHandler.post(new n(mContext, i));
      }
      new StringBuilder("wx get mid:").append(this.cGu.cGo);
      String str = this.cGu.cGo;
      AppMethodBeat.o(87655);
      return str;
    }
  }
  
  public final String Iw()
  {
    AppMethodBeat.i(87656);
    if ((this.cGu == null) || (!s.dA(this.cGu.cGo))) {
      this.cGu = r.aW(mContext).Iz();
    }
    String str = this.cGu.cGo;
    AppMethodBeat.o(87656);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */