package android.support.customtabs;

import android.os.IBinder;

public final class c
{
  private final d dJ;
  private final a dK;
  
  c(d paramd)
  {
    this.dJ = paramd;
    this.dK = new c.1(this);
  }
  
  final IBinder aD()
  {
    return this.dJ.asBinder();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {
      return false;
    }
    return ((c)paramObject).aD().equals(this.dJ.asBinder());
  }
  
  public final int hashCode()
  {
    return aD().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.customtabs.c
 * JD-Core Version:    0.7.0.1
 */