package com.tencent.mm.modelcontrol;

public final class f
  implements Comparable
{
  public int hVi;
  public int hVj;
  public int hVk;
  public int hVl;
  public int hVm;
  public int hVn;
  public int hVo;
  
  public f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    this.hVi = paramInt1;
    this.hVj = paramInt2;
    this.hVk = paramInt3;
    this.hVl = paramInt4;
    this.hVm = paramInt5;
    this.hVn = paramInt6;
    this.hVo = paramInt7;
  }
  
  public final int compareTo(Object paramObject)
  {
    if (paramObject == null) {}
    while (!(paramObject instanceof f)) {
      return 0;
    }
    paramObject = (f)paramObject;
    return this.hVi - paramObject.hVi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelcontrol.f
 * JD-Core Version:    0.7.0.1
 */