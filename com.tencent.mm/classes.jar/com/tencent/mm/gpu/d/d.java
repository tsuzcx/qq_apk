package com.tencent.mm.gpu.d;

public final class d
{
  long gwz;
  int id = 0;
  int type = 0;
  
  public d(int paramInt1, int paramInt2, long paramLong)
  {
    this.type = paramInt1;
    this.id = paramInt2;
    this.gwz = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    paramObject = (d)paramObject;
    return (paramObject.type == this.type) && (paramObject.gwz == this.gwz) && (paramObject.id == this.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.gpu.d.d
 * JD-Core Version:    0.7.0.1
 */