package com.google.d;

final class at$a
{
  private final int number;
  private final Object object;
  
  at$a(Object paramObject, int paramInt)
  {
    this.object = paramObject;
    this.number = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {}
    do
    {
      return false;
      paramObject = (a)paramObject;
    } while ((this.object != paramObject.object) || (this.number != paramObject.number));
    return true;
  }
  
  public final int hashCode()
  {
    return System.identityHashCode(this.object) * 65535 + this.number;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.d.at.a
 * JD-Core Version:    0.7.0.1
 */