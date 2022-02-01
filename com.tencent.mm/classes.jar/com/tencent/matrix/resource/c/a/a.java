package com.tencent.matrix.resource.c.a;

public final class a
{
  public final int cAc;
  public final b cAd;
  public final Object cAe;
  
  public a(int paramInt, b paramb, Object paramObject)
  {
    this.cAc = paramInt;
    this.cAd = paramb;
    this.cAe = paramObject;
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
      if (this.cAc != paramObject.cAc) {
        return false;
      }
      if (!this.cAd.equals(paramObject.cAd)) {
        return false;
      }
    } while (((this.cAe == null) || (this.cAe.equals(paramObject.cAe))) && ((paramObject.cAe == null) || (paramObject.cAe.equals(this.cAe))));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.cAd.hashCode() << 31) + this.cAc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.a
 * JD-Core Version:    0.7.0.1
 */