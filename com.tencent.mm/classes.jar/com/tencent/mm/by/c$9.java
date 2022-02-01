package com.tencent.mm.by;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class c$9
  implements a
{
  c$9(String paramString1, String paramString2, Intent paramIntent, Context paramContext, Bundle paramBundle) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(133704);
    Log.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s:%s", new Object[] { this.RzJ, this.RzO });
    try
    {
      if (this.val$intent == null)
      {
        localObject1 = new Intent();
        localObject2 = MMApplicationContext.getSourcePackageName() + ".plugin." + this.RzJ;
        if (!this.RzO.startsWith(".")) {
          break label236;
        }
      }
      label236:
      for (Object localObject2 = (String)localObject2 + this.RzO;; localObject2 = this.RzO)
      {
        ((Intent)localObject1).setClassName(MMApplicationContext.getPackageName(), (String)localObject2);
        Class.forName((String)localObject2, false, this.val$context.getClassLoader());
        if (!(this.val$context instanceof Activity)) {
          break label244;
        }
        localObject2 = this.val$context;
        localBundle = this.val$options;
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localBundle).bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0), (Bundle)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(1));
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
        AppMethodBeat.o(133704);
        return;
        localObject1 = this.val$intent;
        break;
      }
      label244:
      ((Intent)localObject1).addFlags(268435456);
      localObject2 = this.val$context;
      Bundle localBundle = this.val$options;
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localBundle).bm(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      ((Context)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0), (Bundle)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(1));
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/pluginstub/PluginHelper$5", "onDone", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
      AppMethodBeat.o(133704);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", new Object[] { localClassNotFoundException });
      AppMethodBeat.o(133704);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.by.c.9
 * JD-Core Version:    0.7.0.1
 */