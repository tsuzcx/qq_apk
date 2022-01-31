package android.support.transition;

import android.view.View;
import java.util.ArrayList;

final class g$2
  implements Transition.c
{
  g$2(g paramg, View paramView, ArrayList paramArrayList) {}
  
  public final void a(Transition paramTransition)
  {
    paramTransition.b(this);
    this.qF.setVisibility(8);
    int j = this.qG.size();
    int i = 0;
    while (i < j)
    {
      ((View)this.qG.get(i)).setVisibility(0);
      i += 1;
    }
  }
  
  public final void bq() {}
  
  public final void br() {}
  
  public final void bv() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.g.2
 * JD-Core Version:    0.7.0.1
 */