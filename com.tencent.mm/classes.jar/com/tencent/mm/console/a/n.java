package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.by;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.t;

public final class n
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(20196);
    b.a(new n(), new String[] { "//cleanwx", "//showfile", "//hidefile" });
    AppMethodBeat.o(20196);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20195);
    paramArrayOfString = paramArrayOfString[0];
    int i = -1;
    switch (paramArrayOfString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(20195);
        return false;
        if (paramArrayOfString.equals("//cleanwx"))
        {
          i = 0;
          continue;
          if (paramArrayOfString.equals("//showfile"))
          {
            i = 1;
            continue;
            if (paramArrayOfString.equals("//hidefile")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    paramArrayOfString = new by();
    com.tencent.mm.sdk.b.a.IvT.l(paramArrayOfString);
    t.makeText(paramContext, "clean wx file index now.", 0).show();
    AppMethodBeat.o(20195);
    return true;
    try
    {
      g.ajR().ajA().set(am.a.IVm, Integer.valueOf(1));
      t.makeText(paramContext, "show file now.", 0).show();
      label193:
      AppMethodBeat.o(20195);
      return true;
      try
      {
        g.ajR().ajA().set(am.a.IVm, Integer.valueOf(0));
        t.makeText(paramContext, "hide file now.", 0).show();
        label227:
        AppMethodBeat.o(20195);
        return true;
      }
      catch (Exception paramContext)
      {
        break label227;
      }
    }
    catch (Exception paramContext)
    {
      break label193;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.n
 * JD-Core Version:    0.7.0.1
 */