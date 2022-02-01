package com.tencent.matrix.resource.d.a;

public final class a
{
  public final b fbZ;
  public final Object fca;
  public final int typeId;
  
  public a(int paramInt, b paramb, Object paramObject)
  {
    this.typeId = paramInt;
    this.fbZ = paramb;
    this.fca = paramObject;
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
      if (this.typeId != paramObject.typeId) {
        return false;
      }
      if (!this.fbZ.equals(paramObject.fbZ)) {
        return false;
      }
    } while (((this.fca == null) || (this.fca.equals(paramObject.fca))) && ((paramObject.fca == null) || (paramObject.fca.equals(this.fca))));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.fbZ.hashCode() << 31) + this.typeId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.matrix.resource.d.a.a
 * JD-Core Version:    0.7.0.1
 */