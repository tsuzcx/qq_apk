package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  int dGc;
  int hhQ;
  int ivD;
  int ivE;
  boolean mWk;
  int targetHeight;
  int targetWidth;
  byte[] vPf;
  byte[] vPg;
  int vPh;
  int vPi;
  long vPj;
  int vPk;
  boolean vPl;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89471);
    this.vPh = 0;
    this.vPi = 0;
    this.vPj = bt.HI();
    this.hhQ = paramInt3;
    this.targetWidth = paramInt4;
    this.targetHeight = paramInt5;
    this.ivD = paramInt1;
    this.ivE = paramInt2;
    this.vPl = paramBoolean2;
    this.mWk = paramBoolean1;
    this.dGc = paramInt6;
    this.vPf = paramArrayOfByte;
    this.vPh = paramArrayOfByte.length;
    this.vPg = k.vQc.g(Integer.valueOf(paramInt4 * paramInt5 * 3 / 2));
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