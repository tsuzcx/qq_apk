package com.tencent.mm.plugin.finder.record.plugin;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.e;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
final class b$b
  extends u
  implements a<e>
{
  b$b(b paramb)
  {
    super(0);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(337056);
    s.u(paramb, "this$0");
    b.n(paramb);
    AppMethodBeat.o(337056);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(337045);
    s.u(paramb, "this$0");
    paramDialogInterface.dismiss();
    b.n(paramb);
    AppMethodBeat.o(337045);
  }
  
  private static final void b(b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(337052);
    s.u(paramb, "this$0");
    b.o(paramb);
    AppMethodBeat.o(337052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.plugin.b.b
 * JD-Core Version:    0.7.0.1
 */