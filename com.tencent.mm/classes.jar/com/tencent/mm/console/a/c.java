package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    b.a(new c(), new String[] { "//fav" });
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
      label54:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      return true;
      if (!paramContext.equals("resendfavitem")) {
        break;
      }
      break label54;
      if (!paramContext.equals("uploadfavitem")) {
        break;
      }
      i = 1;
      break label54;
      paramContext = new gf();
      paramContext.bNF.type = 39;
      paramContext.bNF.bNO = paramArrayOfString[2];
      paramContext.bNF.bNP = paramArrayOfString[3];
      com.tencent.mm.sdk.b.a.udP.a(paramContext, Looper.getMainLooper());
      continue;
      paramContext = new gf();
      paramContext.bNF.type = 38;
      paramContext.bNF.bNO = paramArrayOfString[2];
      com.tencent.mm.sdk.b.a.udP.a(paramContext, Looper.getMainLooper());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.console.a.c
 * JD-Core Version:    0.7.0.1
 */