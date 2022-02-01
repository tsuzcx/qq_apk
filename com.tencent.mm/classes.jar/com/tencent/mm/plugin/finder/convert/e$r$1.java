package com.tencent.mm.plugin.finder.convert;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
final class e$r$1
  implements View.OnCreateContextMenuListener
{
  public static final 1 qrf;
  
  static
  {
    AppMethodBeat.i(165365);
    qrf = new 1();
    AppMethodBeat.o(165365);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(165364);
    if (paramContextMenu != null)
    {
      paramContextMenu.add(0, 0, 0, 2131755701);
      paramContextMenu.add(0, 1, 1, 2131755707);
    }
    AppMethodBeat.o(165364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.e.r.1
 * JD-Core Version:    0.7.0.1
 */