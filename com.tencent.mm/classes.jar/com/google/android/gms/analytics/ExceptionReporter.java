package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.internal.zztc;
import java.util.ArrayList;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private final Context mContext;
  private final Thread.UncaughtExceptionHandler zzabC;
  private final Tracker zzabD;
  private ExceptionParser zzabE;
  private GoogleAnalytics zzabF;
  
  public ExceptionReporter(Tracker paramTracker, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.zzabC = paramUncaughtExceptionHandler;
    this.zzabD = paramTracker;
    this.zzabE = new StandardExceptionParser(paramContext, new ArrayList());
    this.mContext = paramContext.getApplicationContext();
    if (paramUncaughtExceptionHandler == null)
    {
      paramTracker = "null";
      paramTracker = String.valueOf(paramTracker);
      if (paramTracker.length() == 0) {
        break label111;
      }
    }
    label111:
    for (paramTracker = "ExceptionReporter created, original handler is ".concat(paramTracker);; paramTracker = new String("ExceptionReporter created, original handler is "))
    {
      zztc.v(paramTracker);
      return;
      paramTracker = paramUncaughtExceptionHandler.getClass().getName();
      break;
    }
  }
  
  public ExceptionParser getExceptionParser()
  {
    return this.zzabE;
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.zzabE = paramExceptionParser;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject = "UncaughtException";
    if (this.zzabE != null)
    {
      if (paramThread != null)
      {
        localObject = paramThread.getName();
        localObject = this.zzabE.getDescription((String)localObject, paramThrowable);
      }
    }
    else
    {
      str = String.valueOf(localObject);
      if (str.length() == 0) {
        break label126;
      }
    }
    label126:
    for (String str = "Reporting uncaught exception: ".concat(str);; str = new String("Reporting uncaught exception: "))
    {
      zztc.v(str);
      this.zzabD.send(new HitBuilders.ExceptionBuilder().setDescription((String)localObject).setFatal(true).build());
      localObject = zzmu();
      ((GoogleAnalytics)localObject).dispatchLocalHits();
      ((GoogleAnalytics)localObject).zzmz();
      if (this.zzabC != null)
      {
        zztc.v("Passing exception to the original handler");
        this.zzabC.uncaughtException(paramThread, paramThrowable);
      }
      return;
      localObject = null;
      break;
    }
  }
  
  GoogleAnalytics zzmu()
  {
    if (this.zzabF == null) {
      this.zzabF = GoogleAnalytics.getInstance(this.mContext);
    }
    return this.zzabF;
  }
  
  Thread.UncaughtExceptionHandler zzmv()
  {
    return this.zzabC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.analytics.ExceptionReporter
 * JD-Core Version:    0.7.0.1
 */