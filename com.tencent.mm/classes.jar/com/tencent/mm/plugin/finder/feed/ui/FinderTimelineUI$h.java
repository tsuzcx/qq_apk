package com.tencent.mm.plugin.finder.feed.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.aq;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class FinderTimelineUI$h
  implements DialogInterface.OnCancelListener
{
  FinderTimelineUI$h(FinderTimelineUI paramFinderTimelineUI, aq paramaq) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(166241);
    com.tencent.mm.kernel.g.agi().a((n)this.rsC);
    com.tencent.mm.kernel.g.agi().b(3761, (com.tencent.mm.ak.g)this.rsu);
    AppMethodBeat.o(166241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI.h
 * JD-Core Version:    0.7.0.1
 */