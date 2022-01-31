package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

final class CoordinatorLayout$c
  implements ViewGroup.OnHierarchyChangeListener
{
  CoordinatorLayout$c(CoordinatorLayout paramCoordinatorLayout) {}
  
  public final void onChildViewAdded(View paramView1, View paramView2)
  {
    if (this.hO.hL != null) {
      this.hO.hL.onChildViewAdded(paramView1, paramView2);
    }
  }
  
  public final void onChildViewRemoved(View paramView1, View paramView2)
  {
    this.hO.H(2);
    if (this.hO.hL != null) {
      this.hO.hL.onChildViewRemoved(paramView1, paramView2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.c
 * JD-Core Version:    0.7.0.1
 */