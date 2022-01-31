package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;

final class e$a
  extends am
{
  e$a(String paramString)
  {
    super(Looper.getMainLooper(), new am.a()
    {
      public final boolean tC()
      {
        e.uX(e.a.this);
        return false;
      }
    }, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.e.a
 * JD-Core Version:    0.7.0.1
 */