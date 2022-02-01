package android.support.customtabs;

import android.os.IBinder;

public final class c
{
  private final d dK;
  private final a dL;
  
  c(d paramd)
  {
    this.dK = paramd;
    this.dL = new a() {};
  }
  
  final IBinder at()
  {
    return this.dK.asBinder();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof c)) {
      return false;
    }
    return ((c)paramObject).at().equals(this.dK.asBinder());
  }
  
  public final int hashCode()
  {
    return at().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.customtabs.c
 * JD-Core Version:    0.7.0.1
 */