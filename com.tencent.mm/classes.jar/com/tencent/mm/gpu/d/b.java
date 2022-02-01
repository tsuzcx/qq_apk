package com.tencent.mm.gpu.d;

public final class b
{
  long gaq;
  int id = 0;
  int type = 0;
  
  public b(int paramInt1, int paramInt2, long paramLong)
  {
    this.type = paramInt1;
    this.id = paramInt2;
    this.gaq = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    paramObject = (b)paramObject;
    return (paramObject.type == this.type) && (paramObject.gaq == this.gaq) && (paramObject.id == this.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.gpu.d.b
 * JD-Core Version:    0.7.0.1
 */