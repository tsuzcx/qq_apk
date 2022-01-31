package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

final class CoordinatorLayout$c
  implements ViewGroup.OnHierarchyChangeListener
{
  CoordinatorLayout$c(CoordinatorLayout paramCoordinatorLayout) {}
  
  public final void onChildViewAdded(View paramView1, View paramView2)
  {
    if (this.iL.iI != null) {
      this.iL.iI.onChildViewAdded(paramView1, paramView2);
    }
  }
  
  public final void onChildViewRemoved(View paramView1, View paramView2)
  {
    this.iL.G(2);
    if (this.iL.iI != null) {
      this.iL.iI.onChildViewRemoved(paramView1, paramView2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.c
 * JD-Core Version:    0.7.0.1
 */