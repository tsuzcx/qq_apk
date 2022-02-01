package com.tencent.mm.plugin.finder.feed.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.y;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class FinderTimelineUI$h
  implements DialogInterface.OnCancelListener
{
  FinderTimelineUI$h(FinderTimelineUI paramFinderTimelineUI, y paramy) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(166241);
    com.tencent.mm.kernel.g.aeS().a((n)this.qBB);
    com.tencent.mm.kernel.g.aeS().b(3761, (com.tencent.mm.al.g)this.qBt);
    AppMethodBeat.o(166241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTimelineUI.h
 * JD-Core Version:    0.7.0.1
 */