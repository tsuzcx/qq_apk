package com.tencent.mm.plugin.finder.view.tabcomp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "()V", "onTabClick", "", "context", "Landroid/content/Context;", "tab", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "onTabDoubleClick", "onTabSelected", "onTabUnSelected", "Companion", "plugin-finder_release"})
public class e
  implements f
{
  private static final String TAG = "Finder.FinderTabViewAction";
  public static final a wtE;
  
  static
  {
    AppMethodBeat.i(255312);
    wtE = new a((byte)0);
    TAG = "Finder.FinderTabViewAction";
    AppMethodBeat.o(255312);
  }
  
  public void a(Context paramContext, a parama)
  {
    AppMethodBeat.i(255308);
    p.h(paramContext, "context");
    p.h(parama, "tab");
    Log.i(TAG, "onTabSelected : " + parama.index);
    AppMethodBeat.o(255308);
  }
  
  public void b(Context paramContext, a parama)
  {
    AppMethodBeat.i(255309);
    p.h(paramContext, "context");
    p.h(parama, "tab");
    Log.i(TAG, "onTabUnSelected : " + parama.index);
    AppMethodBeat.o(255309);
  }
  
  public final void c(Context paramContext, a parama)
  {
    AppMethodBeat.i(255310);
    p.h(paramContext, "context");
    p.h(parama, "tab");
    Log.i(TAG, "onTabClick : " + parama.index);
    AppMethodBeat.o(255310);
  }
  
  public final void d(Context paramContext, a parama)
  {
    AppMethodBeat.i(255311);
    p.h(paramContext, "context");
    p.h(parama, "tab");
    Log.i(TAG, "onTabConTabDoubleClicklick : " + parama.index);
    AppMethodBeat.o(255311);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.e
 * JD-Core Version:    0.7.0.1
 */