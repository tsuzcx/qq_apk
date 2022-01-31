package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class f
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(16135);
    b.a(new f(), new String[] { "//recovery" });
    AppMethodBeat.o(16135);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(16134);
    if (ab.getLogLevel() > 1)
    {
      AppMethodBeat.o(16134);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(16134);
      return true;
    }
    paramContext = paramArrayOfString[1];
    switch (paramContext.hashCode())
    {
    default: 
      i = -1;
      label91:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(16134);
      return true;
      if (!paramContext.equals("testpush")) {
        break;
      }
      break label91;
      if (!paramContext.equals("testmm")) {
        break;
      }
      i = 1;
      break label91;
      if (!paramContext.equals("testmmonline")) {
        break;
      }
      i = 2;
      break label91;
      if (!paramContext.equals("log")) {
        break;
      }
      i = 3;
      break label91;
      WatchDogPushReceiver.akN();
      continue;
      paramContext = new oc();
      paramContext.cEO.action = 1;
      com.tencent.mm.sdk.b.a.ymk.l(paramContext);
      continue;
      paramContext = new oc();
      paramContext.cEO.action = 3;
      com.tencent.mm.sdk.b.a.ymk.l(paramContext);
      continue;
      paramContext = new oc();
      paramContext.cEO.action = 2;
      com.tencent.mm.sdk.b.a.ymk.l(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.console.a.f
 * JD-Core Version:    0.7.0.1
 */