package android.support.v7.widget;

final class d$b
{
  int ZW;
  Object ZX;
  int ZY;
  int vA;
  
  d$b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    this.vA = paramInt1;
    this.ZW = paramInt2;
    this.ZY = paramInt3;
    this.ZX = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        do
        {
          return true;
          if ((paramObject == null) || (getClass() != paramObject.getClass())) {
            return false;
          }
          paramObject = (b)paramObject;
          if (this.vA != paramObject.vA) {
            return false;
          }
        } while ((this.vA == 8) && (Math.abs(this.ZY - this.ZW) == 1) && (this.ZY == paramObject.ZW) && (this.ZW == paramObject.ZY));
        if (this.ZY != paramObject.ZY) {
          return false;
        }
        if (this.ZW != paramObject.ZW) {
          return false;
        }
        if (this.ZX == null) {
          break;
        }
      } while (this.ZX.equals(paramObject.ZX));
      return false;
    } while (paramObject.ZX == null);
    return false;
  }
  
  public final int hashCode()
  {
    return (this.vA * 31 + this.ZW) * 31 + this.ZY;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
    String str;
    switch (this.vA)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      str = "??";
    }
    for (;;)
    {
      return str + ",s:" + this.ZW + "c:" + this.ZY + ",p:" + this.ZX + "]";
      str = "add";
      continue;
      str = "rm";
      continue;
      str = "up";
      continue;
      str = "mv";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.d.b
 * JD-Core Version:    0.7.0.1
 */