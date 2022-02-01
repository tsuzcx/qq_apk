package android.support.transition;

import android.view.View;
import android.view.WindowId;

final class an
  implements ao
{
  private final WindowId Ef;
  
  an(View paramView)
  {
    this.Ef = paramView.getWindowId();
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof an)) && (((an)paramObject).Ef.equals(this.Ef));
  }
  
  public final int hashCode()
  {
    return this.Ef.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.an
 * JD-Core Version:    0.7.0.1
 */