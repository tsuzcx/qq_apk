package android.support.v4.f;

public final class j<F, S>
{
  public final F first;
  public final S second;
  
  public j(F paramF, S paramS)
  {
    this.first = paramF;
    this.second = paramS;
  }
  
  private static boolean d(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof j)) {}
    do
    {
      return false;
      paramObject = (j)paramObject;
    } while ((!d(paramObject.first, this.first)) || (!d(paramObject.second, this.second)));
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int i;
    if (this.first == null)
    {
      i = 0;
      if (this.second != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = this.first.hashCode();
      break;
      label33:
      j = this.second.hashCode();
    }
  }
  
  public final String toString()
  {
    return "Pair{" + String.valueOf(this.first) + " " + String.valueOf(this.second) + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.f.j
 * JD-Core Version:    0.7.0.1
 */