package a;

import java.io.Serializable;

public final class g<A, B>
  implements Serializable
{
  public final A first;
  public final B second;
  
  public g(A paramA, B paramB)
  {
    this.first = paramA;
    this.second = paramB;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
        if ((!a.d.b.g.e(this.first, paramObject.first)) || (!a.d.b.g.e(this.second, paramObject.second))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    Object localObject = this.first;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.second;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    return "(" + this.first + ", " + this.second + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.g
 * JD-Core Version:    0.7.0.1
 */