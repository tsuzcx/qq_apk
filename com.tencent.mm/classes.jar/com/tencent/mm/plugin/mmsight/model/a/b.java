package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  int eRu;
  int eRv;
  int eRx;
  int fYR;
  int fYS;
  boolean jdF;
  long oIA;
  int oIB;
  boolean oIC;
  byte[] oIw;
  byte[] oIx;
  int oIy;
  int oIz;
  int rotate;
  
  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean1, boolean paramBoolean2, int paramInt6, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(76570);
    this.oIy = 0;
    this.oIz = 0;
    this.oIA = bo.yB();
    this.eRx = paramInt3;
    this.eRu = paramInt4;
    this.eRv = paramInt5;
    this.fYR = paramInt1;
    this.fYS = paramInt2;
    this.oIC = paramBoolean2;
    this.jdF = paramBoolean1;
    this.rotate = paramInt6;
    this.oIw = paramArrayOfByte;
    this.oIy = paramArrayOfByte.length;
    this.oIx = j.oJp.f(Integer.valueOf(paramInt4 * paramInt5 * 3 / 2));
    AppMethodBeat.o(76570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.b
 * JD-Core Version:    0.7.0.1
 */