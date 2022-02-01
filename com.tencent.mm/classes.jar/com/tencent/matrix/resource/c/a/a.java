package com.tencent.matrix.resource.c.a;

public final class a
{
  public final int cIP;
  public final b cIQ;
  public final Object cIR;
  
  public a(int paramInt, b paramb, Object paramObject)
  {
    this.cIP = paramInt;
    this.cIQ = paramb;
    this.cIR = paramObject;
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
      if (this.cIP != paramObject.cIP) {
        return false;
      }
      if (!this.cIQ.equals(paramObject.cIQ)) {
        return false;
      }
    } while (((this.cIR == null) || (this.cIR.equals(paramObject.cIR))) && ((paramObject.cIR == null) || (paramObject.cIR.equals(this.cIR))));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.cIQ.hashCode() << 31) + this.cIP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.a
 * JD-Core Version:    0.7.0.1
 */