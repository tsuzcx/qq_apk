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
    this.rC.setVisibility(8);
    int j = this.rD.size();
    int i = 0;
    while (i < j)
    {
      ((View)this.rD.get(i)).setVisibility(0);
      i += 1;
    }
  }
  
  public final void ce() {}
  
  public final void cf() {}
  
  public final void cj() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.g.2
 * JD-Core Version:    0.7.0.1
 */