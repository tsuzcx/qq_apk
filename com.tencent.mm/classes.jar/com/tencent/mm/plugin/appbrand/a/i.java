package com.tencent.mm.plugin.appbrand.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statemachine.StateMachine;

public abstract class i
  extends StateMachine
{
  protected i(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
  }
  
  public void log(String paramString)
  {
    Log.d(getName(), paramString);
  }
  
  public void logd(String paramString)
  {
    Log.d(getName(), paramString);
  }
  
  public void loge(String paramString)
  {
    Log.e(getName(), paramString);
  }
  
  public void loge(String paramString, Throwable paramThrowable)
  {
    Log.printErrStackTrace(getName(), paramThrowable, paramString, new Object[0]);
  }
  
  public void logi(String paramString)
  {
    Log.i(getName(), paramString);
  }
  
  public void logv(String paramString)
  {
    Log.v(getName(), paramString);
  }
  
  public void logw(String paramString)
  {
    Log.w(getName(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.i
 * JD-Core Version:    0.7.0.1
 */