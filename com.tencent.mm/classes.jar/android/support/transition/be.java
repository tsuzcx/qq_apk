package android.support.transition;

import android.view.View;
import android.view.WindowId;

final class be
  implements bf
{
  private final WindowId ua;
  
  be(View paramView)
  {
    this.ua = paramView.getWindowId();
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof be)) && (((be)paramObject).ua.equals(this.ua));
  }
  
  public final int hashCode()
  {
    return this.ua.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.be
 * JD-Core Version:    0.7.0.1
 */