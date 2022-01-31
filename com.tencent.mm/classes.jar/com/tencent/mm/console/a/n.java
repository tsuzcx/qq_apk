package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.t;

public final class n
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(16151);
    b.a(new n(), new String[] { "//cleanwx", "//showfile", "//hidefile" });
    AppMethodBeat.o(16151);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(16150);
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
        AppMethodBeat.o(16150);
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
    paramArrayOfString = new bq();
    com.tencent.mm.sdk.b.a.ymk.l(paramArrayOfString);
    t.makeText(paramContext, "clean wx file index now.", 0).show();
    AppMethodBeat.o(16150);
    return true;
    try
    {
      g.RL().Ru().set(ac.a.yHJ, Integer.valueOf(1));
      t.makeText(paramContext, "show file now.", 0).show();
      label193:
      AppMethodBeat.o(16150);
      return true;
      try
      {
        g.RL().Ru().set(ac.a.yHJ, Integer.valueOf(0));
        t.makeText(paramContext, "hide file now.", 0).show();
        label227:
        AppMethodBeat.o(16150);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.console.a.n
 * JD-Core Version:    0.7.0.1
 */