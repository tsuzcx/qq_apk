package com.tencent.mm.plugin.kidswatch.ui.reg;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.kidswatch.model.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class KidsWatchRegRebindUI$e
  implements DialogInterface.OnCancelListener
{
  KidsWatchRegRebindUI$e(KidsWatchRegRebindUI paramKidsWatchRegRebindUI, d paramd) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(256363);
    g.azz().a((q)this.yBG);
    g.azz().b(5888, (i)this.yBI);
    AppMethodBeat.o(256363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.ui.reg.KidsWatchRegRebindUI.e
 * JD-Core Version:    0.7.0.1
 */