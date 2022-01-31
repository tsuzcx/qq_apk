package com.tencent.mm.modelcontrol;

public final class f
  implements Comparable
{
  public int ejS;
  public int ejT;
  public int ejU;
  public int ejV;
  public int ejW;
  public int ejX;
  public int ejY;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.ejS = paramInt1;
    this.ejT = paramInt2;
    this.ejU = paramInt3;
    this.ejV = paramInt4;
    this.ejW = paramInt5;
    this.ejX = paramInt6;
    this.ejY = paramInt7;
  }
  
  public final int compareTo(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof f)) {
      return 0;
    }
    paramObject = (f)paramObject;
    return this.ejS - paramObject.ejS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.f
 * JD-Core Version:    0.7.0.1
 */