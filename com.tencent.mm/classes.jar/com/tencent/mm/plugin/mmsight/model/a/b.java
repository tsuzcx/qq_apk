package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  int dHi;
  int hkE;
  int iyw;
  int iyx;
  boolean nbq;
  int targetHeight;
  int targetWidth;
  byte[] wbi;
  byte[] wbj;
  int wbk;
  int wbl;
  long wbm;
  int wbn;
  boolean wbo;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89471);
    this.wbk = 0;
    this.wbl = 0;
    this.wbm = bu.HQ();
    this.hkE = paramInt3;
    this.targetWidth = paramInt4;
    this.targetHeight = paramInt5;
    this.iyw = paramInt1;
    this.iyx = paramInt2;
    this.wbo = paramBoolean2;
    this.nbq = paramBoolean1;
    this.dHi = paramInt6;
    this.wbi = paramArrayOfByte;
    this.wbk = paramArrayOfByte.length;
    this.wbj = k.wcg.h(Integer.valueOf(paramInt4 * paramInt5 * 3 / 2));
    AppMethodBeat.o(89471);
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.b
 * JD-Core Version:    0.7.0.1
 */