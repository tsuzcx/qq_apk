package c.t.m.g;

public final class cp
{
  public final int a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  
  public cp(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (cp)paramObject;
    } while ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     c.t.m.g.cp
 * JD-Core Version:    0.7.0.1
 */