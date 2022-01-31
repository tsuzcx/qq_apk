package android.support.transition;

import android.view.View;

final class ChangeTransform$a
  extends ae
{
  private View mView;
  private j qn;
  
  ChangeTransform$a(View paramView, j paramj)
  {
    this.mView = paramView;
    this.qn = paramj;
  }
  
  public final void a(Transition paramTransition)
  {
    paramTransition.b(this);
    k.x(this.mView);
    this.mView.setTag(z.a.transition_transform, null);
    this.mView.setTag(z.a.parent_matrix, null);
  }
  
  public final void bq()
  {
    this.qn.setVisibility(4);
  }
  
  public final void br()
  {
    this.qn.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.ChangeTransform.a
 * JD-Core Version:    0.7.0.1
 */