package com.tencent.mm.plugin.finder.view.dialog;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/dialog/FinderBottomSheetConfirmDialogHelper;", "", "()V", "showLivePostConfirmDialog", "", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "plugin-finder_release"})
public final class a
{
  public static final a Bey;
  
  static
  {
    AppMethodBeat.i(231219);
    Bey = new a();
    AppMethodBeat.o(231219);
  }
  
  public static void a(Context paramContext, q.g paramg)
  {
    AppMethodBeat.i(231217);
    p.k(paramContext, "context");
    p.k(paramg, "listener");
    paramContext = new b(paramContext, paramg).kCR;
    if (paramContext != null)
    {
      paramContext.eik();
      AppMethodBeat.o(231217);
      return;
    }
    AppMethodBeat.o(231217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.dialog.a
 * JD-Core Version:    0.7.0.1
 */