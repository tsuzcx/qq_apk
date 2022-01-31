package com.tencent.c.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;

public class i
{
  private static i btw = null;
  static f btx = null;
  public static volatile long bty = 0L;
  static h btz = null;
  public static Context mContext = null;
  public static Handler mHandler = null;
  private g btA = null;
  
  private i(Context paramContext)
  {
    HandlerThread localHandlerThread = new HandlerThread(i.class.getSimpleName());
    localHandlerThread.start();
    mHandler = new Handler(localHandlerThread.getLooper());
    paramContext = paramContext.getApplicationContext();
    mContext = paramContext;
    bty = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
  }
  
  public static void a(f paramf)
  {
    btx = paramf;
  }
  
  public static i an(Context paramContext)
  {
    if (btw == null) {}
    try
    {
      if (btw == null) {
        btw = new i(paramContext);
      }
      return btw;
    }
    finally {}
  }
  
  public final String ry()
  {
    if ((this.btA == null) || (!s.bG(this.btA.btu)))
    {
      this.btA = r.ap(mContext).rD();
      if (!s.bG(this.btA.btu)) {
        break label100;
      }
    }
    label100:
    for (int i = 2;; i = 1)
    {
      if (mHandler != null) {
        mHandler.post(new n(mContext, i));
      }
      new StringBuilder("wx get mid:").append(this.btA.btu);
      return this.btA.btu;
    }
  }
  
  public final String rz()
  {
    if ((this.btA == null) || (!s.bG(this.btA.btu))) {
      this.btA = r.ap(mContext).rD();
    }
    return this.btA.btu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.c.a.a.i
 * JD-Core Version:    0.7.0.1
 */