package com.tencent.mm.plugin.finder.view.tabcomp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "()V", "onTabClick", "", "context", "Landroid/content/Context;", "tab", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "onTabDoubleClick", "onTabSelected", "onTabUnSelected", "Companion", "plugin-finder_release"})
public class e
  implements f
{
  public static final a BfV;
  private static final String TAG = "Finder.FinderTabViewAction";
  
  static
  {
    AppMethodBeat.i(290325);
    BfV = new a((byte)0);
    TAG = "Finder.FinderTabViewAction";
    AppMethodBeat.o(290325);
  }
  
  public void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(290321);
    p.k(paramContext, "context");
    p.k(parama, "tab");
    Log.i(TAG, "onTabSelected : " + parama.index);
    AppMethodBeat.o(290321);
  }
  
  public void b(Context paramContext, a parama)
  {
    AppMethodBeat.i(290322);
    p.k(paramContext, "context");
    p.k(parama, "tab");
    Log.i(TAG, "onTabUnSelected : " + parama.index);
    AppMethodBeat.o(290322);
  }
  
  public final void c(Context paramContext, a parama)
  {
    AppMethodBeat.i(290323);
    p.k(paramContext, "context");
    p.k(parama, "tab");
    Log.i(TAG, "onTabClick : " + parama.index);
    AppMethodBeat.o(290323);
  }
  
  public final void d(Context paramContext, a parama)
  {
    AppMethodBeat.i(290324);
    p.k(paramContext, "context");
    p.k(parama, "tab");
    Log.i(TAG, "onTabConTabDoubleClicklick : " + parama.index);
    AppMethodBeat.o(290324);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.e
 * JD-Core Version:    0.7.0.1
 */