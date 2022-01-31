package android.support.v4.e;

public final class j<F, S>
{
  public final F first;
  public final S second;
  
  public j(F paramF, S paramS)
  {
    this.first = paramF;
    this.second = paramS;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof j)) {}
    do
    {
      return false;
      paramObject = (j)paramObject;
    } while ((!i.equals(paramObject.first, this.first)) || (!i.equals(paramObject.second, this.second)));
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
 * Qualified Name:     android.support.v4.e.j
 * JD-Core Version:    0.7.0.1
 */