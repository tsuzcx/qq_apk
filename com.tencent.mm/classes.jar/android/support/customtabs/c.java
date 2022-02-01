package android.support.customtabs;

import android.os.IBinder;

public final class c
{
  private final d gD;
  private final a gE;
  
  c(d paramd)
  {
    this.gD = paramd;
    this.gE = new a() {};
  }
  
  final IBinder aQ()
  {
    return this.gD.asBinder();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {
      return false;
    }
    return ((c)paramObject).aQ().equals(this.gD.asBinder());
  }
  
  public final int hashCode()
  {
    return aQ().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.customtabs.c
 * JD-Core Version:    0.7.0.1
 */