package com.tencent.matrix.resource.c.a;

public final class a
{
  public final int cZm;
  public final b cZn;
  public final Object cZo;
  
  public a(int paramInt, b paramb, Object paramObject)
  {
    this.cZm = paramInt;
    this.cZn = paramb;
    this.cZo = paramObject;
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
      if (this.cZm != paramObject.cZm) {
        return false;
      }
      if (!this.cZn.equals(paramObject.cZn)) {
        return false;
      }
    } while (((this.cZo == null) || (this.cZo.equals(paramObject.cZo))) && ((paramObject.cZo == null) || (paramObject.cZo.equals(this.cZo))));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.cZn.hashCode() << 31) + this.cZm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.a
 * JD-Core Version:    0.7.0.1
 */