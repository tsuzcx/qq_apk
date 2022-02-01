package com.tencent.mm.modelcontrol;

public final class f
  implements Comparable
{
  public int hcb;
  public int hcc;
  public int hcd;
  public int hce;
  public int hcf;
  public int hcg;
  public int hch;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.hcb = paramInt1;
    this.hcc = paramInt2;
    this.hcd = paramInt3;
    this.hce = paramInt4;
    this.hcf = paramInt5;
    this.hcg = paramInt6;
    this.hch = paramInt7;
  }
  
  public final int compareTo(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof f)) {
      return 0;
    }
    paramObject = (f)paramObject;
    return this.hcb - paramObject.hcb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.f
 * JD-Core Version:    0.7.0.1
 */