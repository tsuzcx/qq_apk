package com.tencent.mm.modelcontrol;

public final class g
  implements Comparable
{
  public int iSY;
  public int iSZ;
  public int iTa;
  public int iTb;
  public int iTc;
  public int iTd;
  public int iTe;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.iSY = paramInt1;
    this.iSZ = paramInt2;
    this.iTa = paramInt3;
    this.iTb = paramInt4;
    this.iTc = paramInt5;
    this.iTd = paramInt6;
    this.iTe = paramInt7;
  }
  
  public final int compareTo(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof g)) {
      return 0;
    }
    paramObject = (g)paramObject;
    return this.iSY - paramObject.iSY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.g
 * JD-Core Version:    0.7.0.1
 */