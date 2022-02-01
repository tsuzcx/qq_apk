package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.tv;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class h
  implements a
{
  static
  {
    AppMethodBeat.i(20182);
    b.a(new h(), new String[] { "//recovery" });
    AppMethodBeat.o(20182);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(20181);
    if (Log.getLogLevel() > 1)
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
      WatchDogPushReceiver.bNm();
      continue;
      paramContext = new tv();
      paramContext.hXK.action = 1;
      paramContext.publish();
      continue;
      paramContext = new tv();
      paramContext.hXK.action = 3;
      paramContext.publish();
      continue;
      paramContext = new tv();
      paramContext.hXK.action = 2;
      paramContext.publish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.a.h
 * JD-Core Version:    0.7.0.1
 */