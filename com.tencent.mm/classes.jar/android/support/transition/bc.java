package android.support.transition;

import android.os.IBinder;

final class bc
  implements be
{
  private final IBinder va;
  
  bc(IBinder paramIBinder)
  {
    this.va = paramIBinder;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof bc)) && (((bc)paramObject).va.equals(this.va));
  }
  
  public final int hashCode()
  {
    return this.va.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.bc
 * JD-Core Version:    0.7.0.1
 */