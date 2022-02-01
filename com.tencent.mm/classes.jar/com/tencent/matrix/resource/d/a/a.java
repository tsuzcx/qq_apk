package com.tencent.matrix.resource.d.a;

public final class a
{
  public final int ddx;
  public final b ddy;
  public final Object ddz;
  
  public a(int paramInt, b paramb, Object paramObject)
  {
    this.ddx = paramInt;
    this.ddy = paramb;
    this.ddz = paramObject;
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
      if (this.ddx != paramObject.ddx) {
        return false;
      }
      if (!this.ddy.equals(paramObject.ddy)) {
        return false;
      }
    } while (((this.ddz == null) || (this.ddz.equals(paramObject.ddz))) && ((paramObject.ddz == null) || (paramObject.ddz.equals(this.ddz))));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.ddy.hashCode() << 31) + this.ddx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.resource.d.a.a
 * JD-Core Version:    0.7.0.1
 */