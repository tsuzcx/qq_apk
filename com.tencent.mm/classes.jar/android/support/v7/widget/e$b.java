package android.support.v7.widget;

final class e$b
{
  int Zl;
  Object Zm;
  int Zn;
  int uC;
  
  e$b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    this.uC = paramInt1;
    this.Zl = paramInt2;
    this.Zn = paramInt3;
    this.Zm = paramObject;
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
          if (this.uC != paramObject.uC) {
            return false;
          }
        } while ((this.uC == 8) && (Math.abs(this.Zn - this.Zl) == 1) && (this.Zn == paramObject.Zl) && (this.Zl == paramObject.Zn));
        if (this.Zn != paramObject.Zn) {
          return false;
        }
        if (this.Zl != paramObject.Zl) {
          return false;
        }
        if (this.Zm == null) {
          break;
        }
      } while (this.Zm.equals(paramObject.Zm));
      return false;
    } while (paramObject.Zm == null);
    return false;
  }
  
  public final int hashCode()
  {
    return (this.uC * 31 + this.Zl) * 31 + this.Zn;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
    String str;
    switch (this.uC)
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
      return str + ",s:" + this.Zl + "c:" + this.Zn + ",p:" + this.Zm + "]";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.e.b
 * JD-Core Version:    0.7.0.1
 */