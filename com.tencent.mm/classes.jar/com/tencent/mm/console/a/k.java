package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Method;

public final class k
  implements a
{
  static
  {
    AppMethodBeat.i(20190);
    b.a(new k(), new String[] { "//warpgate" });
    AppMethodBeat.o(20190);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20189);
    if (ac.getLogLevel() > 1)
    {
      AppMethodBeat.o(20189);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(20189);
      return true;
    }
    paramContext = paramArrayOfString[1];
    int i = -1;
    switch (paramContext.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(20189);
      return true;
      if (!paramContext.equals("on")) {
        break;
      }
      i = 0;
      break;
      if (!paramContext.equals("off")) {
        break;
      }
      i = 1;
      break;
      if (!paramContext.equals("start")) {
        break;
      }
      i = 2;
      break;
      if (!paramContext.equals("stop")) {
        break;
      }
      i = 3;
      break;
      com.tencent.mm.platformtools.ab.iwA = true;
      com.tencent.mm.platformtools.ab.iwz = true;
      continue;
      com.tencent.mm.platformtools.ab.iwA = false;
      com.tencent.mm.platformtools.ab.iwz = false;
      continue;
      i = 8888;
      if (paramArrayOfString.length >= 3) {
        i = bs.getInt(paramArrayOfString[2], 8888);
      }
      try
      {
        Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("startServer", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(i) });
        Toast.makeText(ai.getContext(), "start server on ".concat(String.valueOf(i)), 1).show();
      }
      catch (Exception paramContext)
      {
        ac.printErrStackTrace("MicroMsg.WarpgateCommand", paramContext, "", new Object[0]);
      }
      continue;
      try
      {
        Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("stopServer", new Class[0]).invoke(null, new Object[0]);
        Toast.makeText(ai.getContext(), "stop server", 1).show();
      }
      catch (Exception paramContext)
      {
        ac.printErrStackTrace("MicroMsg.WarpgateCommand", paramContext, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.k
 * JD-Core Version:    0.7.0.1
 */