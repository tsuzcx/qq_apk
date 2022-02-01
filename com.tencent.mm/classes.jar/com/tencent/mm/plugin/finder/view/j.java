package com.tencent.mm.plugin.finder.view;

import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.q.e;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.b.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderIOSFlowWindowHelper;", "", "()V", "TAG", "", "mWindow", "Landroid/widget/PopupWindow;", "getMWindow", "()Landroid/widget/PopupWindow;", "setMWindow", "(Landroid/widget/PopupWindow;)V", "menu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "getMenu", "()Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "setMenu", "(Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;)V", "dimiss", "", "isShowing", "show", "", "view", "Landroid/view/View;", "listener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateContextMMMenuListener;", "selectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onDimissListener", "Landroid/widget/PopupWindow$OnDismissListener;", "plugin-finder_release"})
public final class j
{
  private static a AYp;
  public static final j AYq;
  
  static
  {
    AppMethodBeat.i(271965);
    AYq = new j();
    AppMethodBeat.o(271965);
  }
  
  public static void a(View paramView, q.e parame, q.g paramg, PopupWindow.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(271962);
    p.k(paramView, "view");
    p.k(parame, "listener");
    p.k(paramg, "selectedListener");
    p.k(paramOnDismissListener, "onDimissListener");
    Object localObject = new int[2];
    paramView.getLocationInWindow((int[])localObject);
    int i = localObject[0] + (int)(paramView.getWidth() / 2.0F);
    int j = localObject[1];
    if ((i > 0) && (j > 0))
    {
      localObject = new a(paramView.getContext());
      AYp = (a)localObject;
      ((a)localObject).idk();
      localObject = AYp;
      if (localObject == null) {
        p.iCn();
      }
      ((a)localObject).setOnDismissListener(paramOnDismissListener);
      paramOnDismissListener = AYp;
      if (paramOnDismissListener == null) {
        p.iCn();
      }
      paramOnDismissListener.a(paramView, parame, paramg, i, j);
    }
    AppMethodBeat.o(271962);
  }
  
  public static boolean eiN()
  {
    boolean bool2 = true;
    AppMethodBeat.i(271963);
    a locala = AYp;
    boolean bool1;
    if (locala != null)
    {
      if (locala.isShowing() != true) {
        break label56;
      }
      locala = AYp;
      bool1 = bool2;
      if (locala != null)
      {
        locala.cFD();
        bool1 = bool2;
      }
    }
    for (;;)
    {
      AYp = null;
      AppMethodBeat.o(271963);
      return bool1;
      bool1 = false;
      continue;
      label56:
      bool1 = false;
    }
  }
  
  public static boolean isShowing()
  {
    AppMethodBeat.i(271964);
    a locala = AYp;
    if ((locala != null) && (locala.idj() == true))
    {
      AppMethodBeat.o(271964);
      return true;
    }
    AppMethodBeat.o(271964);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.j
 * JD-Core Version:    0.7.0.1
 */