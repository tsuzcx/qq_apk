package com.tencent.mapsdk.internal;

public final class qm
  implements Comparable<qm>
{
  public final int a;
  public final int b;
  public final int c;
  
  public qm(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  private int a(qm paramqm)
  {
    return this.a - paramqm.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qm
 * JD-Core Version:    0.7.0.1
 */