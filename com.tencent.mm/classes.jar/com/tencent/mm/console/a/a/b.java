package com.tencent.mm.console.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(20198);
    ad.i("MicroMsg.HCSettingCommand", "hcsetting args[%s] [%s]", new Object[] { Integer.valueOf(paramArrayOfString.length), paramArrayOfString[0] });
    paramArrayOfString = new Intent();
    paramArrayOfString.setClassName(paramContext, "com.tencent.mm.ui.tools.HardCoderSettingUI");
    paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().bd(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArrayOfString.adn(), "com/tencent/mm/console/command/hardcoder/HCSettingCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramArrayOfString.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/console/command/hardcoder/HCSettingCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(20198);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.a.a.b
 * JD-Core Version:    0.7.0.1
 */