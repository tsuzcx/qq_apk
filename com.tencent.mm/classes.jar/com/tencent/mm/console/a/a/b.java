package com.tencent.mm.console.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20198);
    Log.i("MicroMsg.HCSettingCommand", "hcsetting args[%s] [%s]", new Object[] { Integer.valueOf(paramArrayOfString.length), paramArrayOfString[0] });
    l.gZO();
    paramArrayOfString = new Intent();
    paramArrayOfString.setClassName(paramContext, "com.tencent.mm.ui.tools.HardCoderSettingUI");
    paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().cG(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramArrayOfString.aYi(), "com/tencent/mm/console/command/hardcoder/HCSettingCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramArrayOfString.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/console/command/hardcoder/HCSettingCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20198);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.a.b
 * JD-Core Version:    0.7.0.1
 */