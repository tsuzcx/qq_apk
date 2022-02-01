package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  boolean Gtm;
  byte[] KWt;
  byte[] KWu;
  int KWv;
  int KWw;
  int KWx;
  boolean KWy;
  int colorFormat;
  int hYK;
  int nxO;
  int nxP;
  int srcHeight;
  int srcWidth;
  long tick;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89471);
    this.KWv = 0;
    this.KWw = 0;
    this.tick = Util.currentTicks();
    this.colorFormat = paramInt3;
    this.nxO = paramInt4;
    this.nxP = paramInt5;
    this.srcWidth = paramInt1;
    this.srcHeight = paramInt2;
    this.KWy = paramBoolean2;
    this.Gtm = paramBoolean1;
    this.hYK = paramInt6;
    this.KWt = paramArrayOfByte;
    this.KWv = paramArrayOfByte.length;
    this.KWu = j.KXq.m(Integer.valueOf(paramInt4 * paramInt5 * 3 / 2));
    AppMethodBeat.o(89471);
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.b
 * JD-Core Version:    0.7.0.1
 */