package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Method;

public final class k
  implements a
{
  static
  {
    b.a(new k(), new String[] { "//warpgate" });
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    int j = 8888;
    if (y.getLogLevel() > 1) {
      return false;
    }
    if (paramArrayOfString.length < 2) {
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
      com.tencent.mm.platformtools.ae.eTE = true;
      com.tencent.mm.platformtools.ae.eTD = true;
      continue;
      com.tencent.mm.platformtools.ae.eTE = false;
      com.tencent.mm.platformtools.ae.eTD = false;
      continue;
      i = j;
      if (paramArrayOfString.length >= 3) {
        i = bk.getInt(paramArrayOfString[2], 8888);
      }
      try
      {
        Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("startServer", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(i) });
        Toast.makeText(ae.getContext(), "start server on " + i, 1).show();
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.WarpgateCommand", paramContext, "", new Object[0]);
      }
      continue;
      try
      {
        Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("stopServer", new Class[0]).invoke(null, new Object[0]);
        Toast.makeText(ae.getContext(), "stop server", 1).show();
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.WarpgateCommand", paramContext, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.console.a.k
 * JD-Core Version:    0.7.0.1
 */