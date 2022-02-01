package com.tencent.mm.plugin.gamelife;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.s;
import kotlin.g.b.aa.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class PluginGameLife$o
  implements Runnable
{
  PluginGameLife$o(aa.f paramf, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(203656);
    this.BbN.aaBC = s.a(this.$context, (CharSequence)this.$context.getResources().getString(d.f.app_waiting), false, 0, (DialogInterface.OnCancelListener)1.Dfo);
    AppMethodBeat.o(203656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.PluginGameLife.o
 * JD-Core Version:    0.7.0.1
 */