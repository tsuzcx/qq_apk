package com.tencent.matrix.resource.c.a;

public final class a
{
  public final int cxl;
  public final b cxm;
  public final Object cxn;
  
  public a(int paramInt, b paramb, Object paramObject)
  {
    this.cxl = paramInt;
    this.cxm = paramb;
    this.cxn = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.cxl != paramObject.cxl) {
        return false;
      }
      if (!this.cxm.equals(paramObject.cxm)) {
        return false;
      }
    } while (((this.cxn == null) || (this.cxn.equals(paramObject.cxn))) && ((paramObject.cxn == null) || (paramObject.cxn.equals(this.cxn))));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.cxm.hashCode() << 31) + this.cxl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.a
 * JD-Core Version:    0.7.0.1
 */