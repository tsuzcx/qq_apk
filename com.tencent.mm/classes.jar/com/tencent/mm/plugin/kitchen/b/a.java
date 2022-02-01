package com.tencent.mm.plugin.kitchen.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.kitchen.ui.KvInfoUI;

public final class a
  implements com.tencent.mm.plugin.kitchen.a.a
{
  public final void V(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(153024);
    paramIntent.setClass(paramContext, KvInfoUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.aeD(), "com/tencent/mm/plugin/kitchen/impl/KitchenService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/kitchen/impl/KitchenService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(153024);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.b.a
 * JD-Core Version:    0.7.0.1
 */