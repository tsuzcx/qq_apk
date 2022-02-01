package android.support.customtabs;

import android.os.IBinder;

public final class c
{
  private final d eK;
  private final a eL;
  
  c(d paramd)
  {
    this.eK = paramd;
    this.eL = new a() {};
  }
  
  final IBinder aA()
  {
    return this.eK.asBinder();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {
      return false;
    }
    return ((c)paramObject).aA().equals(this.eK.asBinder());
  }
  
  public final int hashCode()
  {
    return aA().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.customtabs.c
 * JD-Core Version:    0.7.0.1
 */