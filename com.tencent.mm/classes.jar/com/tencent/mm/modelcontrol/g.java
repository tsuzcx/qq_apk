package com.tencent.mm.modelcontrol;

public final class g
  implements Comparable
{
  public int oBS;
  public int oBT;
  public int oBU;
  public int oBV;
  public int oBW;
  public int oBX;
  public int oBY;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.oBS = paramInt1;
    this.oBT = paramInt2;
    this.oBU = paramInt3;
    this.oBV = paramInt4;
    this.oBW = paramInt5;
    this.oBX = paramInt6;
    this.oBY = paramInt7;
  }
  
  public final int compareTo(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof g)) {
      return 0;
    }
    paramObject = (g)paramObject;
    return this.oBS - paramObject.oBS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.g
 * JD-Core Version:    0.7.0.1
 */