package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  implements a
{
  static
  {
    AppMethodBeat.i(20176);
    b.a(new d(), new String[] { "//fav" });
    AppMethodBeat.o(20176);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(20175);
    if (Log.getLogLevel() > 1)
    {
      AppMethodBeat.o(20175);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(20175);
      return true;
    }
    paramContext = paramArrayOfString[1];
    switch (paramContext.hashCode())
    {
    default: 
      i = -1;
      label75:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(20175);
      return true;
      if (!paramContext.equals("resendfavitem")) {
        break;
      }
      break label75;
      if (!paramContext.equals("uploadfavitem")) {
        break;
      }
      i = 1;
      break label75;
      paramContext = new hb();
      paramContext.dLm.type = 39;
      paramContext.dLm.dLv = paramArrayOfString[2];
      paramContext.dLm.dLw = paramArrayOfString[3];
      EventCenter.instance.asyncPublish(paramContext, Looper.getMainLooper());
      continue;
      paramContext = new hb();
      paramContext.dLm.type = 38;
      paramContext.dLm.dLv = paramArrayOfString[2];
      EventCenter.instance.asyncPublish(paramContext, Looper.getMainLooper());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.a.d
 * JD-Core Version:    0.7.0.1
 */