package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  int colorFormat;
  int dYT;
  int srcHeight;
  int srcWidth;
  int targetHeight;
  int targetWidth;
  long tick;
  boolean whs;
  byte[] zvl;
  byte[] zvm;
  int zvn;
  int zvo;
  int zvp;
  boolean zvq;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89471);
    this.zvn = 0;
    this.zvo = 0;
    this.tick = Util.currentTicks();
    this.colorFormat = paramInt3;
    this.targetWidth = paramInt4;
    this.targetHeight = paramInt5;
    this.srcWidth = paramInt1;
    this.srcHeight = paramInt2;
    this.zvq = paramBoolean2;
    this.whs = paramBoolean1;
    this.dYT = paramInt6;
    this.zvl = paramArrayOfByte;
    this.zvn = paramArrayOfByte.length;
    this.zvm = k.zwi.h(Integer.valueOf(paramInt4 * paramInt5 * 3 / 2));
    AppMethodBeat.o(89471);
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.b
 * JD-Core Version:    0.7.0.1
 */