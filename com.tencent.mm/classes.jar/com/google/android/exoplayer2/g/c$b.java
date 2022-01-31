package com.google.android.exoplayer2.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$b
{
  public final String aXQ = null;
  public final String aXR = null;
  public final int aXS = 2147483647;
  public final int aXT = 2147483647;
  public final int aXU = 2147483647;
  public final boolean aXV = true;
  public final boolean aXW = true;
  public final boolean aXX = false;
  public final boolean aXY = true;
  public final boolean aXZ = true;
  public final int viewportHeight = 2147483647;
  public final int viewportWidth = 2147483647;
  
  public c$b()
  {
    this((byte)0);
  }
  
  private c$b(byte paramByte) {}
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95763);
    if (this == paramObject)
    {
      AppMethodBeat.o(95763);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95763);
      return false;
    }
    paramObject = (b)paramObject;
    if ((this.aXX == paramObject.aXX) && (this.aXY == paramObject.aXY) && (this.aXS == paramObject.aXS) && (this.aXT == paramObject.aXT) && (this.aXV == paramObject.aXV) && (this.aXZ == paramObject.aXZ) && (this.aXW == paramObject.aXW) && (this.viewportWidth == paramObject.viewportWidth) && (this.viewportHeight == paramObject.viewportHeight) && (this.aXU == paramObject.aXU) && (TextUtils.equals(this.aXQ, paramObject.aXQ)) && (TextUtils.equals(this.aXR, paramObject.aXR)))
    {
      AppMethodBeat.o(95763);
      return true;
    }
    AppMethodBeat.o(95763);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 1;
    AppMethodBeat.i(95764);
    int i1 = this.aXQ.hashCode();
    int i2 = this.aXR.hashCode();
    int i;
    int j;
    label44:
    int i3;
    int i4;
    int i5;
    int k;
    label71:
    int m;
    if (this.aXX)
    {
      i = 1;
      if (!this.aXY) {
        break label176;
      }
      j = 1;
      i3 = this.aXS;
      i4 = this.aXT;
      i5 = this.aXU;
      if (!this.aXV) {
        break label181;
      }
      k = 1;
      if (!this.aXZ) {
        break label186;
      }
      m = 1;
      label81:
      if (!this.aXW) {
        break label192;
      }
    }
    for (;;)
    {
      int i6 = this.viewportWidth;
      int i7 = this.viewportHeight;
      AppMethodBeat.o(95764);
      return (((m + (k + ((((j + (i + (i1 * 31 + i2) * 31) * 31) * 31 + i3) * 31 + i4) * 31 + i5) * 31) * 31) * 31 + n) * 31 + i6) * 31 + i7;
      i = 0;
      break;
      label176:
      j = 0;
      break label44;
      label181:
      k = 0;
      break label71;
      label186:
      m = 0;
      break label81;
      label192:
      n = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.g.c.b
 * JD-Core Version:    0.7.0.1
 */