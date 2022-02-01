package com.tencent.mm.gpu.d;

public final class b
{
  long id;
  int type;
  
  public b(int paramInt, long paramLong)
  {
    this.type = paramInt;
    this.id = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    paramObject = (d)paramObject;
    return (paramObject.type == this.type) && (paramObject.id == this.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.d.b
 * JD-Core Version:    0.7.0.1
 */