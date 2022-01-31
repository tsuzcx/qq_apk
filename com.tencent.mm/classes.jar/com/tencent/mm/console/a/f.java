package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.mm.h.a.nf;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.y;

public final class f
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    b.a(new f(), new String[] { "//recovery" });
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    int i = 0;
    if (y.getLogLevel() > 1) {
      return false;
    }
    if (paramArrayOfString.length < 2) {
      return true;
    }
    paramContext = paramArrayOfString[1];
    switch (paramContext.hashCode())
    {
    default: 
      i = -1;
      label70:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      return true;
      if (!paramContext.equals("testpush")) {
        break;
      }
      break label70;
      if (!paramContext.equals("testmm")) {
        break;
      }
      i = 1;
      break label70;
      if (!paramContext.equals("testmmonline")) {
        break;
      }
      i = 2;
      break label70;
      if (!paramContext.equals("log")) {
        break;
      }
      i = 3;
      break label70;
      WatchDogPushReceiver.RE();
      continue;
      paramContext = new nf();
      paramContext.bWX.action = 1;
      com.tencent.mm.sdk.b.a.udP.m(paramContext);
      continue;
      paramContext = new nf();
      paramContext.bWX.action = 3;
      com.tencent.mm.sdk.b.a.udP.m(paramContext);
      continue;
      paramContext = new nf();
      paramContext.bWX.action = 2;
      com.tencent.mm.sdk.b.a.udP.m(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.console.a.f
 * JD-Core Version:    0.7.0.1
 */