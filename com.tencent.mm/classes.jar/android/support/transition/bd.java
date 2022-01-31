package android.support.transition;

import android.os.IBinder;

final class bd
  implements bf
{
  private final IBinder tZ;
  
  bd(IBinder paramIBinder)
  {
    this.tZ = paramIBinder;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof bd)) && (((bd)paramObject).tZ.equals(this.tZ));
  }
  
  public final int hashCode()
  {
    return this.tZ.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.bd
 * JD-Core Version:    0.7.0.1
 */