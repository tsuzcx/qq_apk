package android.support.transition;

import android.view.View;
import android.view.WindowId;

final class ao
  implements ap
{
  private final WindowId Eo;
  
  ao(View paramView)
  {
    this.Eo = paramView.getWindowId();
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ao)) && (((ao)paramObject).Eo.equals(this.Eo));
  }
  
  public final int hashCode()
  {
    return this.Eo.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ao
 * JD-Core Version:    0.7.0.1
 */