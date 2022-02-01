package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cn;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.aa;

public final class n
  implements a
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
    new cn().publish();
    aa.makeText(paramContext, "clean wx file index now.", 0).show();
    AppMethodBeat.o(20195);
    return true;
    try
    {
      h.baE().ban().set(at.a.acTt, Integer.valueOf(1));
      aa.makeText(paramContext, "show file now.", 0).show();
      label188:
      AppMethodBeat.o(20195);
      return true;
      try
      {
        h.baE().ban().set(at.a.acTt, Integer.valueOf(0));
        aa.makeText(paramContext, "hide file now.", 0).show();
        label222:
        AppMethodBeat.o(20195);
        return true;
      }
      catch (Exception paramContext)
      {
        break label222;
      }
    }
    catch (Exception paramContext)
    {
      break label188;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.console.a.n
 * JD-Core Version:    0.7.0.1
 */