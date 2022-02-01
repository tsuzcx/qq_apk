package com.tencent.mm.plugin.appbrand.a;

import android.os.Looper;
import android.text.TextUtils;

public abstract class h
  extends i
{
  private final String[] kRG = { "invokeEnterMethods", "invokeExitMethods", "handleMessage:", "quit" };
  boolean kRH = false;
  
  public h(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    super.setDbg(true);
  }
  
  public abstract void a(g paramg);
  
  public void log(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = this.kRG;
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
          this.kRH = true;
        }
        if (!paramString.startsWith("handleMessage: X")) {
          break;
        }
        this.kRH = false;
        return;
        i += 1;
        break label20;
        super.logv(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.h
 * JD-Core Version:    0.7.0.1
 */