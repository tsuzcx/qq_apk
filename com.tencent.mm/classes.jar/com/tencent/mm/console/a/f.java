package com.tencent.mm.console.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.jectl.JeVersion.JeService;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class f
  implements a
{
  static
  {
    AppMethodBeat.i(231972);
    b.a(new f(), new String[] { "//jeversion" });
    AppMethodBeat.o(231972);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(231973);
    MMApplicationContext.getContext().startService(new Intent(MMApplicationContext.getContext(), JeVersion.JeService.class));
    AppMethodBeat.o(231973);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.f
 * JD-Core Version:    0.7.0.1
 */