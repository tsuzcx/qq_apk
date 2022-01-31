package a.d.b;

import a.d.a;

public final class c
  implements b, a.f.b<Object>
{
  private final Class<?> xor;
  
  public c(Class<?> paramClass)
  {
    this.xor = paramClass;
  }
  
  public final Class<?> cUj()
  {
    return this.xor;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof c)) && (g.e(a.a(this), a.a((a.f.b)paramObject)));
  }
  
  public final int hashCode()
  {
    return a.a(this).hashCode();
  }
  
  public final String toString()
  {
    return this.xor.toString() + " (Kotlin reflection is not available)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.d.b.c
 * JD-Core Version:    0.7.0.1
 */