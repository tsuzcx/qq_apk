package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o.e;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.b.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper;", "", "()V", "TAG", "", "mWindow", "Landroid/widget/PopupWindow;", "getMWindow", "()Landroid/widget/PopupWindow;", "setMWindow", "(Landroid/widget/PopupWindow;)V", "menu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "getMenu", "()Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "setMenu", "(Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;)V", "dimiss", "", "isShowing", "show", "", "view", "Landroid/view/View;", "listener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateContextMMMenuListener;", "selectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onDimissListener", "Landroid/widget/PopupWindow$OnDismissListener;", "plugin-finder_release"})
public final class i
{
  private static a wnj;
  public static final i wnk;
  
  static
  {
    AppMethodBeat.i(254846);
    wnk = new i();
    AppMethodBeat.o(254846);
  }
  
  public static void a(View paramView, o.e parame, o.g paramg, PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(254843);
    p.h(paramView, "view");
    p.h(parame, "listener");
    p.h(paramg, "selectedListener");
    p.h(paramOnDismissListener, "onDimissListener");
    Object localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    int i = localObject[0] + (int)(paramView.getWidth() / 2.0F);
    int j = localObject[1];
    if ((i > 0) && (j > 0))
    {
      localObject = new a(paramView.getContext());
      wnj = (a)localObject;
      ((a)localObject).hcb();
      localObject = wnj;
      if (localObject == null) {
        p.hyc();
      }
      ((a)localObject).setOnDismissListener(paramOnDismissListener);
      paramOnDismissListener = wnj;
      if (paramOnDismissListener == null) {
        p.hyc();
      }
      paramOnDismissListener.a(paramView, parame, paramg, i, j);
    }
    AppMethodBeat.o(254843);
  }
  
  public static boolean dGO()
  {
    boolean bool2 = true;
    AppMethodBeat.i(254844);
    a locala = wnj;
    boolean bool1;
    if (locala != null)
    {
      if (locala.isShowing() != true) {
        break label52;
      }
      locala = wnj;
      bool1 = bool2;
      if (locala != null)
      {
        locala.gNq();
        bool1 = bool2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(254844);
      return bool1;
      bool1 = false;
      continue;
      label52:
      bool1 = false;
    }
  }
  
  public static boolean isShowing()
  {
    AppMethodBeat.i(254845);
    a locala = wnj;
    if ((locala != null) && (locala.hca() == true))
    {
      AppMethodBeat.o(254845);
      return true;
    }
    AppMethodBeat.o(254845);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.i
 * JD-Core Version:    0.7.0.1
 */