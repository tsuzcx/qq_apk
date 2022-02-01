package android.support.customtabs;

import android.os.IBinder;

public final class c
{
  private final d gF;
  private final a gG;
  
  c(d paramd)
  {
    this.gF = paramd;
    this.gG = new a() {};
  }
  
  final IBinder aS()
  {
    return this.gF.asBinder();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {
      return false;
    }
    return ((c)paramObject).aS().equals(this.gF.asBinder());
  }
  
  public final int hashCode()
  {
    return aS().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.customtabs.c
 * JD-Core Version:    0.7.0.1
 */