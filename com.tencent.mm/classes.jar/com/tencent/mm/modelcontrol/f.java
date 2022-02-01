package com.tencent.mm.modelcontrol;

public final class f
  implements Comparable
{
  public int hCD;
  public int hCE;
  public int hCF;
  public int hCG;
  public int hCH;
  public int hCI;
  public int hCJ;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.hCD = paramInt1;
    this.hCE = paramInt2;
    this.hCF = paramInt3;
    this.hCG = paramInt4;
    this.hCH = paramInt5;
    this.hCI = paramInt6;
    this.hCJ = paramInt7;
  }
  
  public final int compareTo(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof f)) {
      return 0;
    }
    paramObject = (f)paramObject;
    return this.hCD - paramObject.hCD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.f
 * JD-Core Version:    0.7.0.1
 */