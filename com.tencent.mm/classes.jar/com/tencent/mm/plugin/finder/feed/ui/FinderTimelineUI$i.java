package com.tencent.mm.plugin.finder.feed.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ay;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class FinderTimelineUI$i
  implements DialogInterface.OnCancelListener
{
  FinderTimelineUI$i(FinderTimelineUI paramFinderTimelineUI, ay paramay) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(166241);
    g.ajj().a((n)this.sqG);
    g.ajj().b(3761, (f)this.sqx);
    AppMethodBeat.o(166241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI.i
 * JD-Core Version:    0.7.0.1
 */