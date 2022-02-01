package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
{
  int duc;
  int gNU;
  int gNV;
  int gNW;
  int ich;
  int ici;
  boolean mvD;
  byte[] uLZ;
  byte[] uMa;
  int uMb;
  int uMc;
  long uMd;
  int uMe;
  boolean uMf;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89471);
    this.uMb = 0;
    this.uMc = 0;
    this.uMd = bs.Gn();
    this.gNW = paramInt3;
    this.gNU = paramInt4;
    this.gNV = paramInt5;
    this.ich = paramInt1;
    this.ici = paramInt2;
    this.uMf = paramBoolean2;
    this.mvD = paramBoolean1;
    this.duc = paramInt6;
    this.uLZ = paramArrayOfByte;
    this.uMb = paramArrayOfByte.length;
    this.uMa = j.uMV.g(Integer.valueOf(paramInt4 * paramInt5 * 3 / 2));
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