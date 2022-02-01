package com.tencent.mm.plugin.appbrand.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class h
  extends i
{
  private final String[] jOY = { "invokeEnterMethods", "invokeExitMethods", "handleMessage:", "quit" };
  boolean jOZ = false;
  
  public h(String paramString, Looper paramLooper)
  {
    super(paramString, paramLooper);
    super.wU(true);
  }
  
  public abstract void a(g paramg);
  
  public final void log(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String[] arrayOfString = this.jOY;
    int j = arrayOfString.length;
    int i = 0;
    label20:
    if (i < j) {
      if (!paramString.startsWith(arrayOfString[i])) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        ae.i(this.mName, paramString);
      }
      for (;;)
      {
        if (paramString.startsWith("handleMessage: E")) {
          this.jOZ = true;
        }
        if (!paramString.startsWith("handleMessage: X")) {
          break;
        }
        this.jOZ = false;
        return;
        i += 1;
        break label20;
        ae.v(this.mName, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.h
 * JD-Core Version:    0.7.0.1
 */