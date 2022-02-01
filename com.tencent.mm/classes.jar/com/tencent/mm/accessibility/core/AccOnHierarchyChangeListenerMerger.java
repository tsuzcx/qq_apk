package com.tencent.mm.accessibility.core;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/AccOnHierarchyChangeListenerMerger;", "Landroid/view/ViewGroup$OnHierarchyChangeListener;", "l1", "l2", "(Landroid/view/ViewGroup$OnHierarchyChangeListener;Landroid/view/ViewGroup$OnHierarchyChangeListener;)V", "getL1", "()Landroid/view/ViewGroup$OnHierarchyChangeListener;", "getL2", "onChildViewAdded", "", "p0", "Landroid/view/View;", "p1", "onChildViewRemoved", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AccOnHierarchyChangeListenerMerger
  implements ViewGroup.OnHierarchyChangeListener
{
  private final ViewGroup.OnHierarchyChangeListener l1;
  private final ViewGroup.OnHierarchyChangeListener l2;
  
  public AccOnHierarchyChangeListenerMerger(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener1, ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener2)
  {
    this.l1 = paramOnHierarchyChangeListener1;
    this.l2 = paramOnHierarchyChangeListener2;
  }
  
  public final ViewGroup.OnHierarchyChangeListener getL1()
  {
    return this.l1;
  }
  
  public final ViewGroup.OnHierarchyChangeListener getL2()
  {
    return this.l2;
  }
  
  public final void onChildViewAdded(View paramView1, View paramView2)
  {
    AppMethodBeat.i(234144);
    ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = this.l1;
    if (localOnHierarchyChangeListener != null) {
      localOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
    }
    localOnHierarchyChangeListener = this.l2;
    if (localOnHierarchyChangeListener != null) {
      localOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
    }
    AppMethodBeat.o(234144);
  }
  
  public final void onChildViewRemoved(View paramView1, View paramView2)
  {
    AppMethodBeat.i(234152);
    ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = this.l1;
    if (localOnHierarchyChangeListener != null) {
      localOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
    }
    localOnHierarchyChangeListener = this.l2;
    if (localOnHierarchyChangeListener != null) {
      localOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
    }
    AppMethodBeat.o(234152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.AccOnHierarchyChangeListenerMerger
 * JD-Core Version:    0.7.0.1
 */