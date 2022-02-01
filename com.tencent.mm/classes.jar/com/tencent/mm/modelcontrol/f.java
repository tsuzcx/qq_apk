package com.tencent.mm.modelcontrol;

public final class f
  implements Comparable
{
  public int hYa;
  public int hYb;
  public int hYc;
  public int hYd;
  public int hYe;
  public int hYf;
  public int hYg;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.hYa = paramInt1;
    this.hYb = paramInt2;
    this.hYc = paramInt3;
    this.hYd = paramInt4;
    this.hYe = paramInt5;
    this.hYf = paramInt6;
    this.hYg = paramInt7;
  }
  
  public final int compareTo(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof f)) {
      return 0;
    }
    paramObject = (f)paramObject;
    return this.hYa - paramObject.hYa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.f
 * JD-Core Version:    0.7.0.1
 */