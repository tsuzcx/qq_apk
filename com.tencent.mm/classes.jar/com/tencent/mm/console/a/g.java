package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class g
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(20182);
    b.a(new g(), new String[] { "//recovery" });
    AppMethodBeat.o(20182);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(20181);
    if (ac.getLogLevel() > 1)
    {
      AppMethodBeat.o(20181);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(20181);
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
      AppMethodBeat.o(20181);
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
      WatchDogPushReceiver.aII();
      continue;
      paramContext = new pz();
      paramContext.dtd.action = 1;
      com.tencent.mm.sdk.b.a.GpY.l(paramContext);
      continue;
      paramContext = new pz();
      paramContext.dtd.action = 3;
      com.tencent.mm.sdk.b.a.GpY.l(paramContext);
      continue;
      paramContext = new pz();
      paramContext.dtd.action = 2;
      com.tencent.mm.sdk.b.a.GpY.l(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.console.a.g
 * JD-Core Version:    0.7.0.1
 */