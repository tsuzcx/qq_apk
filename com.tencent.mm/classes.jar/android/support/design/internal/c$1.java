package android.support.design.internal;

import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.view.View;
import android.view.View.OnClickListener;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    paramView = (NavigationMenuItemView)paramView;
    this.dT.p(true);
    paramView = paramView.getItemData();
    boolean bool = this.dT.dm.a(paramView, this.dT, 0);
    if ((paramView != null) && (paramView.isCheckable()) && (bool)) {
      this.dT.dM.d(paramView);
    }
    this.dT.p(false);
    this.dT.o(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.internal.c.1
 * JD-Core Version:    0.7.0.1
 */