package com.tencent.mm.plugin.finder.video.plugin;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.ui.widget.a.e;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
final class d$a
  extends u
  implements a<e>
{
  d$a(d paramd)
  {
    super(0);
  }
  
  private static final void a(d paramd, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(335649);
    s.u(paramd, "this$0");
    a.b.a(paramd.GrC, a.c.NNQ);
    AppMethodBeat.o(335649);
  }
  
  private static final void a(d paramd, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(335630);
    s.u(paramd, "this$0");
    paramDialogInterface.dismiss();
    a.b.a(paramd.GrC, a.c.NNQ);
    AppMethodBeat.o(335630);
  }
  
  private static final void b(d paramd, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(335642);
    s.u(paramd, "this$0");
    a.b.a(paramd.GrC, a.c.NNR);
    AppMethodBeat.o(335642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.d.a
 * JD-Core Version:    0.7.0.1
 */