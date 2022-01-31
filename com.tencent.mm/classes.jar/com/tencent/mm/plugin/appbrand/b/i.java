package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;
import android.text.TextUtils;

public abstract class i
  extends j
{
  private final String[] gYW = { "invokeEnterMethods", "invokeExitMethods", "handleMessage:", "quit" };
  protected boolean gYX = false;
  
  public i(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    super.pP(true);
  }
  
  public abstract void a(h paramh);
  
  public final void log(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = this.gYW;
    int j = arrayOfString.length;
    int i = 0;
    label20:
    if (i < j) {
      if (!paramString.startsWith(arrayOfString[i])) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        com.tencent.luggage.g.d.i(this.mName, paramString);
      }
      for (;;)
      {
        if (paramString.startsWith("handleMessage: E")) {
          this.gYX = true;
        }
        if (!paramString.startsWith("handleMessage: X")) {
          break;
        }
        this.gYX = false;
        return;
        i += 1;
        break label20;
        com.tencent.luggage.g.d.v(this.mName, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.i
 * JD-Core Version:    0.7.0.1
 */