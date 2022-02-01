package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  implements com.tencent.mm.pluginsdk.cmd.a
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
    if (ad.getLogLevel() > 1)
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
      paramContext = new gw();
      paramContext.dsV.type = 39;
      paramContext.dsV.dte = paramArrayOfString[2];
      paramContext.dsV.dtf = paramArrayOfString[3];
      com.tencent.mm.sdk.b.a.IbL.a(paramContext, Looper.getMainLooper());
      continue;
      paramContext = new gw();
      paramContext.dsV.type = 38;
      paramContext.dsV.dte = paramArrayOfString[2];
      com.tencent.mm.sdk.b.a.IbL.a(paramContext, Looper.getMainLooper());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.d
 * JD-Core Version:    0.7.0.1
 */