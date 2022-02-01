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
  private static i dfM = null;
  static f dfN = null;
  public static volatile long dfO = 0L;
  static h dfP = null;
  public static Context mContext = null;
  public static Handler mHandler = null;
  private g dfQ;
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(87653);
    this.dfQ = null;
    HandlerThread localHandlerThread = new HandlerThread(i.class.getSimpleName());
    localHandlerThread.start();
    mHandler = new Handler(localHandlerThread.getLooper());
    paramContext = paramContext.getApplicationContext();
    mContext = paramContext;
    dfO = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
    AppMethodBeat.o(87653);
  }
  
  public static void a(f paramf)
  {
    dfN = paramf;
  }
  
  public static i bq(Context paramContext)
  {
    AppMethodBeat.i(87654);
    if (dfM == null) {}
    try
    {
      if (dfM == null) {
        dfM = new i(paramContext);
      }
      paramContext = dfM;
      AppMethodBeat.o(87654);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(87654);
    }
  }
  
  public final String TZ()
  {
    AppMethodBeat.i(87655);
    if ((this.dfQ == null) || (!s.eZ(this.dfQ.dfK)))
    {
      this.dfQ = r.bs(mContext).Ud();
      if (!s.eZ(this.dfQ.dfK)) {
        break label112;
      }
    }
    label112:
    for (int i = 2;; i = 1)
    {
      if (mHandler != null) {
        mHandler.post(new n(mContext, i));
      }
      new StringBuilder("wx get mid:").append(this.dfQ.dfK);
      String str = this.dfQ.dfK;
      AppMethodBeat.o(87655);
      return str;
    }
  }
  
  public final String Ua()
  {
    AppMethodBeat.i(87656);
    if ((this.dfQ == null) || (!s.eZ(this.dfQ.dfK))) {
      this.dfQ = r.bs(mContext).Ud();
    }
    String str = this.dfQ.dfK;
    AppMethodBeat.o(87656);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */