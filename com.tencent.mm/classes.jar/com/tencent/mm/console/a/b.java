package com.tencent.mm.console.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Arrays;

public final class b
  implements com.tencent.mm.pluginsdk.cmd.a
{
  static
  {
    AppMethodBeat.i(20171);
    com.tencent.mm.pluginsdk.cmd.b.a(new b(), new String[] { "//diag" });
    AppMethodBeat.o(20171);
  }
  
  public static void init() {}
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20170);
    Log.d("MicroMsg.DiagnosticCommand", "process Command : %s", new Object[] { Arrays.toString(paramArrayOfString) });
    paramArrayOfString = new Intent();
    paramArrayOfString.setClassName(paramContext, "com.tencent.mm.plugin.performance.diagnostic.DiagnosticSettingsUI");
    paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().bm(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramArrayOfString.aFh(), "com/tencent/mm/console/command/DiagnosticCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramArrayOfString.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/console/command/DiagnosticCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20170);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.b
 * JD-Core Version:    0.7.0.1
 */