package android.support.transition;

import android.os.IBinder;

final class an
  implements ap
{
  private final IBinder En;
  
  an(IBinder paramIBinder)
  {
    this.En = paramIBinder;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof an)) && (((an)paramObject).En.equals(this.En));
  }
  
  public final int hashCode()
  {
    return this.En.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.an
 * JD-Core Version:    0.7.0.1
 */