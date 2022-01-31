package com.tencent.matrix.resource.c.a;

public final class a
{
  public final b bpA;
  public final Object bpB;
  public final int bpz;
  
  public a(int paramInt, b paramb, Object paramObject)
  {
    this.bpz = paramInt;
    this.bpA = paramb;
    this.bpB = paramObject;
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
      if (this.bpz != paramObject.bpz) {
        return false;
      }
      if (!this.bpA.equals(paramObject.bpA)) {
        return false;
      }
    } while (((this.bpB == null) || (this.bpB.equals(paramObject.bpB))) && ((paramObject.bpB == null) || (paramObject.bpB.equals(this.bpB))));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.bpA.hashCode() << 31) + this.bpz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.a
 * JD-Core Version:    0.7.0.1
 */