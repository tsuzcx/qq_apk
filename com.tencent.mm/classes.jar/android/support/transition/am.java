package android.support.transition;

import android.os.IBinder;

final class am
  implements ao
{
  private final IBinder Ee;
  
  am(IBinder paramIBinder)
  {
    this.Ee = paramIBinder;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof am)) && (((am)paramObject).Ee.equals(this.Ee));
  }
  
  public final int hashCode()
  {
    return this.Ee.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.am
 * JD-Core Version:    0.7.0.1
 */