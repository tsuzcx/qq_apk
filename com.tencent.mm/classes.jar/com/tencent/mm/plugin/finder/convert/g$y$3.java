package com.tencent.mm.plugin.finder.convert;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
final class g$y$3
  implements View.OnCreateContextMenuListener
{
  public static final 3 raU;
  
  static
  {
    AppMethodBeat.i(165368);
    raU = new 3();
    AppMethodBeat.o(165368);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(165367);
    if (paramContextMenu != null)
    {
      paramContextMenu.add(0, 0, 0, 2131755701);
      paramContextMenu.add(0, 1, 1, 2131755735);
    }
    AppMethodBeat.o(165367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.g.y.3
 * JD-Core Version:    0.7.0.1
 */