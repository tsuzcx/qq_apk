package com.tencent.matrix.resource.c.a;

public final class a
{
  public final int bPA;
  public final b bPB;
  public final Object bPC;
  
  public a(int paramInt, b paramb, Object paramObject)
  {
    this.bPA = paramInt;
    this.bPB = paramb;
    this.bPC = paramObject;
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
      if (this.bPA != paramObject.bPA) {
        return false;
      }
      if (!this.bPB.equals(paramObject.bPB)) {
        return false;
      }
    } while (((this.bPC == null) || (this.bPC.equals(paramObject.bPC))) && ((paramObject.bPC == null) || (paramObject.bPC.equals(this.bPC))));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.bPB.hashCode() << 31) + this.bPA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.a
 * JD-Core Version:    0.7.0.1
 */