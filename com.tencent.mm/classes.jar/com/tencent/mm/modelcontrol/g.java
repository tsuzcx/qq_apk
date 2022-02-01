package com.tencent.mm.modelcontrol;

public final class g
  implements Comparable
{
  public int lJq;
  public int lJr;
  public int lJs;
  public int lJt;
  public int lJu;
  public int lJv;
  public int lJw;
  
  public g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.lJq = paramInt1;
    this.lJr = paramInt2;
    this.lJs = paramInt3;
    this.lJt = paramInt4;
    this.lJu = paramInt5;
    this.lJv = paramInt6;
    this.lJw = paramInt7;
  }
  
  public final int compareTo(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof g)) {
      return 0;
    }
    paramObject = (g)paramObject;
    return this.lJq - paramObject.lJq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.g
 * JD-Core Version:    0.7.0.1
 */