package com.tencent.mm.plugin.appbrand.b;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class h
  extends i
{
  private final String[] jrS = { "invokeEnterMethods", "invokeExitMethods", "handleMessage:", "quit" };
  boolean jrT = false;
  
  public h(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    super.wa(true);
  }
  
  public abstract void a(g paramg);
  
  public final void log(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = this.jrS;
    int j = arrayOfString.length;
    int i = 0;
    label20:
    if (i < j) {
      if (!paramString.startsWith(arrayOfString[i])) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ac.i(this.mName, paramString);
      }
      for (;;)
      {
        if (paramString.startsWith("handleMessage: E")) {
          this.jrT = true;
        }
        if (!paramString.startsWith("handleMessage: X")) {
          break;
        }
        this.jrT = false;
        return;
        i += 1;
        break label20;
        ac.v(this.mName, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.h
 * JD-Core Version:    0.7.0.1
 */