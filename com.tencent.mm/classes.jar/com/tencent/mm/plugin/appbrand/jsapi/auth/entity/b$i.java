package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.content.Context;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu"})
final class b$i
  implements View.OnCreateContextMenuListener
{
  b$i(View paramView) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(180464);
    paramView = this.kDC.getContext();
    p.g(paramView, "view.context");
    paramContextMenu.add(0, 1, 0, (CharSequence)paramView.getResources().getString(2131755947));
    AppMethodBeat.o(180464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.i
 * JD-Core Version:    0.7.0.1
 */