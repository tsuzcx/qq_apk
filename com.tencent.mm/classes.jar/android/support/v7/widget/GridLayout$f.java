package android.support.v7.widget;

final class GridLayout$f
{
  public final int max;
  public final int min;
  
  public GridLayout$f(int paramInt1, int paramInt2)
  {
    this.min = paramInt1;
    this.max = paramInt2;
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
      paramObject = (f)paramObject;
      if (this.max != paramObject.max) {
        return false;
      }
    } while (this.min == paramObject.min);
    return false;
  }
  
  public final int hashCode()
  {
    return this.min * 31 + this.max;
  }
  
  final int size()
  {
    return this.max - this.min;
  }
  
  public final String toString()
  {
    return "[" + this.min + ", " + this.max + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.GridLayout.f
 * JD-Core Version:    0.7.0.1
 */