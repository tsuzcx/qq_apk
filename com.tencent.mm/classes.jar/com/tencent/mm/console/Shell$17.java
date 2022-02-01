package com.tencent.mm.console;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recovery.ui.RecoveryUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;

final class Shell$17
  implements Shell.a
{
  @SuppressLint({"VisibleForTests"})
  public final void s(Intent paramIntent)
  {
    AppMethodBeat.i(231511);
    if ((!WeChatEnvironment.hasDebugger()) && (!WeChatEnvironment.isMonkeyEnv()))
    {
      Log.e("MicroMsg.Shell", "Environment denied: not coolassist or monkey env");
      AppMethodBeat.o(231511);
      return;
    }
    Log.i("MicroMsg.Shell", "#RECOVERY_LAUNCH_UI");
    Object localObject = new Intent(MMApplicationContext.getContext(), RecoveryUI.class);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("extra_crash_count", 3);
    paramIntent = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramIntent, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/console/Shell$24", "exec", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramIntent.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramIntent, "com/tencent/mm/console/Shell$24", "exec", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(231511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.console.Shell.17
 * JD-Core Version:    0.7.0.1
 */