package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  boolean ARi;
  byte[] FaK;
  byte[] FaL;
  int FaM;
  int FaN;
  int FaO;
  boolean FaP;
  int colorFormat;
  int fSM;
  int srcHeight;
  int srcWidth;
  int targetHeight;
  int targetWidth;
  long tick;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89471);
    this.FaM = 0;
    this.FaN = 0;
    this.tick = Util.currentTicks();
    this.colorFormat = paramInt3;
    this.targetWidth = paramInt4;
    this.targetHeight = paramInt5;
    this.srcWidth = paramInt1;
    this.srcHeight = paramInt2;
    this.FaP = paramBoolean2;
    this.ARi = paramBoolean1;
    this.fSM = paramInt6;
    this.FaK = paramArrayOfByte;
    this.FaM = paramArrayOfByte.length;
    this.FaL = j.FbH.k(Integer.valueOf(paramInt4 * paramInt5 * 3 / 2));
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