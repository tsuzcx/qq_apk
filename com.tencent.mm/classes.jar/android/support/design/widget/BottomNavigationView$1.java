package android.support.design.widget;

import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.view.MenuItem;

final class BottomNavigationView$1
  implements h.a
{
  BottomNavigationView$1(BottomNavigationView paramBottomNavigationView) {}
  
  public final boolean a(h paramh, MenuItem paramMenuItem)
  {
    if ((BottomNavigationView.a(this.gg) != null) && (paramMenuItem.getItemId() == this.gg.getSelectedItemId())) {
      BottomNavigationView.a(this.gg);
    }
    while ((BottomNavigationView.b(this.gg) != null) && (!BottomNavigationView.b(this.gg).aX())) {
      return true;
    }
    return false;
  }
  
  public final void b(h paramh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.design.widget.BottomNavigationView.1
 * JD-Core Version:    0.7.0.1
 */