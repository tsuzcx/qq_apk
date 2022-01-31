package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.bk;

public final class b
{
  int eIB;
  int eIC;
  int eID;
  int eJm;
  int eJn;
  byte[] mip;
  byte[] miq;
  int mir = 0;
  int mis = 0;
  long mit = bk.UZ();
  int miu;
  boolean miv;
  boolean miw;
  int rotate;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, int paramInt6, byte[] paramArrayOfByte)
  {
    this.eID = paramInt3;
    this.eIB = paramInt4;
    this.eIC = paramInt5;
    this.eJm = paramInt1;
    this.eJn = paramInt2;
    this.miw = paramBoolean2;
    this.miv = paramBoolean1;
    this.rotate = paramInt6;
    this.mip = paramArrayOfByte;
    this.mir = paramArrayOfByte.length;
    this.miq = j.mji.f(Integer.valueOf(paramInt4 * paramInt5 * 3 / 2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.b
 * JD-Core Version:    0.7.0.1
 */