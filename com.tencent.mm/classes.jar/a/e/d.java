package a.e;

public final class d
  extends b
  implements a<Integer>
{
  private static final d xoE = new d(1, 0);
  public static final d.a xoF = new d.a((byte)0);
  
  public d(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof d)) && (((isEmpty()) && (((d)paramObject).isEmpty())) || ((this.first == ((d)paramObject).first) && (this.xoz == ((d)paramObject).xoz)));
  }
  
  public final int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return this.first * 31 + this.xoz;
  }
  
  public final boolean isEmpty()
  {
    return this.first > this.xoz;
  }
  
  public final String toString()
  {
    return this.first + ".." + this.xoz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.e.d
 * JD-Core Version:    0.7.0.1
 */