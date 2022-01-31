package com.tencent.mm.modelcontrol;

public final class f
  implements Comparable
{
  public int fAa;
  public int fAb;
  public int fAc;
  public int fAd;
  public int fAe;
  public int fAf;
  public int fzZ;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.fzZ = paramInt1;
    this.fAa = paramInt2;
    this.fAb = paramInt3;
    this.fAc = paramInt4;
    this.fAd = paramInt5;
    this.fAe = paramInt6;
    this.fAf = paramInt7;
  }
  
  public final int compareTo(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof f)) {
      return 0;
    }
    paramObject = (f)paramObject;
    return this.fzZ - paramObject.fzZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.f
 * JD-Core Version:    0.7.0.1
 */