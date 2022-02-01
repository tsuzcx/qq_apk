package android.support.transition;

import android.view.View;
import android.view.WindowId;

final class an
  implements ao
{
  private final WindowId Bp;
  
  an(View paramView)
  {
    this.Bp = paramView.getWindowId();
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof an)) && (((an)paramObject).Bp.equals(this.Bp));
  }
  
  public final int hashCode()
  {
    return this.Bp.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.an
 * JD-Core Version:    0.7.0.1
 */