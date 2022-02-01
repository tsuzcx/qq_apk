package android.support.transition;

import android.os.IBinder;

final class am
  implements ao
{
  private final IBinder Bo;
  
  am(IBinder paramIBinder)
  {
    this.Bo = paramIBinder;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof am)) && (((am)paramObject).Bo.equals(this.Bo));
  }
  
  public final int hashCode()
  {
    return this.Bo.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.am
 * JD-Core Version:    0.7.0.1
 */