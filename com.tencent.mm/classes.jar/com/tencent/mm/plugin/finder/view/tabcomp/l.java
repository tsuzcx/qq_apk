package com.tencent.mm.plugin.finder.view.tabcomp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/IFinderTabViewAction;", "()V", "onTabClick", "", "context", "Landroid/content/Context;", "tab", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderBaseTab;", "onTabDoubleClick", "onTabSelected", "onTabUnSelected", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class l
  implements m
{
  public static final a GJF;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(345558);
    GJF = new a((byte)0);
    TAG = "Finder.FinderTabViewAction";
    AppMethodBeat.o(345558);
  }
  
  public void a(Context paramContext, g paramg)
  {
    AppMethodBeat.i(345561);
    s.u(paramContext, "context");
    s.u(paramg, "tab");
    Log.i(TAG, s.X("onTabSelected : ", Integer.valueOf(paramg.index)));
    AppMethodBeat.o(345561);
  }
  
  public void b(Context paramContext, g paramg)
  {
    AppMethodBeat.i(345567);
    s.u(paramContext, "context");
    s.u(paramg, "tab");
    Log.i(TAG, s.X("onTabUnSelected : ", Integer.valueOf(paramg.index)));
    AppMethodBeat.o(345567);
  }
  
  public final void c(Context paramContext, g paramg)
  {
    AppMethodBeat.i(345571);
    s.u(paramContext, "context");
    s.u(paramg, "tab");
    Log.i(TAG, s.X("onTabClick : ", Integer.valueOf(paramg.index)));
    AppMethodBeat.o(345571);
  }
  
  public final void d(Context paramContext, g paramg)
  {
    AppMethodBeat.i(345573);
    s.u(paramContext, "context");
    s.u(paramg, "tab");
    Log.i(TAG, s.X("onTabConTabDoubleClicklick : ", Integer.valueOf(paramg.index)));
    AppMethodBeat.o(345573);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTabViewAction$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.tabcomp.l
 * JD-Core Version:    0.7.0.1
 */