package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;
import android.text.TextUtils;

public abstract class h
  extends i
{
  private final String[] qLC = { "invokeEnterMethods", "invokeExitMethods", "handleMessage:", "quit" };
  private boolean qLD = false;
  
  public h(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    super.setDbg(true);
  }
  
  public abstract void a(g paramg);
  
  protected final boolean chP()
  {
    return this.qLD;
  }
  
  public void log(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = this.qLC;
    int j = arrayOfString.length;
    int i = 0;
    label20:
    if (i < j) {
      if (!paramString.startsWith(arrayOfString[i])) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        super.logi(paramString);
      }
      for (;;)
      {
        if (paramString.startsWith("handleMessage: E")) {
          this.qLD = true;
        }
        if (!paramString.startsWith("handleMessage: X")) {
          break;
        }
        this.qLD = false;
        return;
        i += 1;
        break label20;
        super.logv(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.h
 * JD-Core Version:    0.7.0.1
 */