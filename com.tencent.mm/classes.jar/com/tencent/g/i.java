package com.tencent.g;

import android.content.Context;
import com.tencent.g.b.d;
import com.tencent.pb.common.c.c;

public final class i
{
  private static i xck;
  private boolean mStarted;
  private Context ze;
  
  private static i cRh()
  {
    if (xck == null) {}
    try
    {
      if (xck == null) {
        xck = new i();
      }
      return xck;
    }
    finally {}
  }
  
  public static void de(Context paramContext)
  {
    i locali = cRh();
    if (!locali.mStarted)
    {
      locali.ze = paramContext;
      paramContext = new d("EventCenter", com.tencent.g.a.b.class.getName());
    }
    try
    {
      paramContext = f.a(paramContext);
      if (paramContext != null) {
        paramContext.start();
      }
      return;
    }
    catch (Throwable paramContext)
    {
      c.x("service", new Object[] { paramContext });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.g.i
 * JD-Core Version:    0.7.0.1
 */