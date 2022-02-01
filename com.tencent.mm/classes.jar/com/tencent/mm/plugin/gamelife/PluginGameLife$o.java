package com.tencent.mm.plugin.gamelife;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.q;
import kotlin.g.b.z.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class PluginGameLife$o
  implements Runnable
{
  PluginGameLife$o(z.f paramf, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(241214);
    this.wqe.SYG = q.a(this.$context, (CharSequence)this.$context.getResources().getString(2131756029), false, 0, (DialogInterface.OnCancelListener)1.yaJ);
    AppMethodBeat.o(241214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.o
 * JD-Core Version:    0.7.0.1
 */