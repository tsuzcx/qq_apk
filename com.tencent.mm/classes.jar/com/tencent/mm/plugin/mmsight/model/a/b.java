package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  int dwp;
  int gnh;
  int gni;
  int gnk;
  int hBG;
  int hBH;
  boolean lTB;
  byte[] tDE;
  byte[] tDF;
  int tDG;
  int tDH;
  long tDI;
  int tDJ;
  boolean tDK;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89471);
    this.tDG = 0;
    this.tDH = 0;
    this.tDI = bt.GC();
    this.gnk = paramInt3;
    this.gnh = paramInt4;
    this.gni = paramInt5;
    this.hBG = paramInt1;
    this.hBH = paramInt2;
    this.tDK = paramBoolean2;
    this.lTB = paramBoolean1;
    this.dwp = paramInt6;
    this.tDE = paramArrayOfByte;
    this.tDG = paramArrayOfByte.length;
    this.tDF = j.tEA.g(Integer.valueOf(paramInt4 * paramInt5 * 3 / 2));
    AppMethodBeat.o(89471);
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.b
 * JD-Core Version:    0.7.0.1
 */