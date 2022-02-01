package android.support.transition;

import android.view.View;
import android.view.WindowId;

final class an
  implements ao
{
  private final WindowId Cn;
  
  an(View paramView)
  {
    this.Cn = paramView.getWindowId();
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof an)) && (((an)paramObject).Cn.equals(this.Cn));
  }
  
  public final int hashCode()
  {
    return this.Cn.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.an
 * JD-Core Version:    0.7.0.1
 */