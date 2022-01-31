package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(16129);
    b.a(new c(), new String[] { "//fav" });
    AppMethodBeat.o(16129);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(16128);
    if (ab.getLogLevel() > 1)
    {
      AppMethodBeat.o(16128);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(16128);
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
      AppMethodBeat.o(16128);
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
      paramContext = new gi();
      paramContext.cuX.type = 39;
      paramContext.cuX.cvg = paramArrayOfString[2];
      paramContext.cuX.cvh = paramArrayOfString[3];
      com.tencent.mm.sdk.b.a.ymk.a(paramContext, Looper.getMainLooper());
      continue;
      paramContext = new gi();
      paramContext.cuX.type = 38;
      paramContext.cuX.cvg = paramArrayOfString[2];
      com.tencent.mm.sdk.b.a.ymk.a(paramContext, Looper.getMainLooper());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.console.a.c
 * JD-Core Version:    0.7.0.1
 */