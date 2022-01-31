package android.support.transition;

import android.view.View;

final class ChangeTransform$a
  extends ad
{
  private View mView;
  private j rk;
  
  ChangeTransform$a(View paramView, j paramj)
  {
    this.mView = paramView;
    this.rk = paramj;
  }
  
  public final void a(Transition paramTransition)
  {
    paramTransition.b(this);
    k.A(this.mView);
    this.mView.setTag(2131820686, null);
    this.mView.setTag(2131820648, null);
  }
  
  public final void ce()
  {
    this.rk.setVisibility(4);
  }
  
  public final void cf()
  {
    this.rk.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.ChangeTransform.a
 * JD-Core Version:    0.7.0.1
 */