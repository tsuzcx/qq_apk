package android.support.design.internal;

import android.support.v7.view.menu.h;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

final class BottomNavigationMenuView$1
  implements View.OnClickListener
{
  BottomNavigationMenuView$1(BottomNavigationMenuView paramBottomNavigationMenuView) {}
  
  public final void onClick(View paramView)
  {
    paramView = ((BottomNavigationItemView)paramView).getItemData();
    if (!BottomNavigationMenuView.b(this.er).a(paramView, BottomNavigationMenuView.a(this.er), 0)) {
      paramView.setChecked(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationMenuView.1
 * JD-Core Version:    0.7.0.1
 */