package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class n$a
  implements a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(44196);
    if (Log.getLogLevel() > 1)
    {
      AppMethodBeat.o(44196);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(44196);
      return true;
    }
    paramContext = paramArrayOfString[1];
    switch (paramContext.hashCode())
    {
    default: 
      i = -1;
      label63:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(44196);
      return true;
      if (!paramContext.equals("turnon")) {
        break;
      }
      break label63;
      MMApplicationContext.getContext().getSharedPreferences("wcwebview", g.aQe()).edit().putBoolean("m_bEnableLocalDebug", true).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.n.a
 * JD-Core Version:    0.7.0.1
 */