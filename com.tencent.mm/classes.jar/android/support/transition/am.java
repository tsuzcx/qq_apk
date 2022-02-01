package android.support.transition;

import android.os.IBinder;

final class am
  implements ao
{
  private final IBinder Cm;
  
  am(IBinder paramIBinder)
  {
    this.Cm = paramIBinder;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof am)) && (((am)paramObject).Cm.equals(this.Cm));
  }
  
  public final int hashCode()
  {
    return this.Cm.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.am
 * JD-Core Version:    0.7.0.1
 */