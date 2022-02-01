package com.tencent.matrix.resource.c.a;

public final class a
{
  public final int cIg;
  public final b cIh;
  public final Object cIi;
  
  public a(int paramInt, b paramb, Object paramObject)
  {
    this.cIg = paramInt;
    this.cIh = paramb;
    this.cIi = paramObject;
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
      if (this.cIg != paramObject.cIg) {
        return false;
      }
      if (!this.cIh.equals(paramObject.cIh)) {
        return false;
      }
    } while (((this.cIi == null) || (this.cIi.equals(paramObject.cIi))) && ((paramObject.cIi == null) || (paramObject.cIi.equals(this.cIi))));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.cIh.hashCode() << 31) + this.cIg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.a
 * JD-Core Version:    0.7.0.1
 */