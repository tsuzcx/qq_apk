package android.support.transition;

import android.view.View;
import android.view.WindowId;

final class bd
  implements be
{
  private final WindowId vb;
  
  bd(View paramView)
  {
    this.vb = paramView.getWindowId();
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof bd)) && (((bd)paramObject).vb.equals(this.vb));
  }
  
  public final int hashCode()
  {
    return this.vb.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.bd
 * JD-Core Version:    0.7.0.1
 */