package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends f
{
  protected final byte[] aa(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136834);
    int j = 0;
    if (j < paramInt2)
    {
      int k = 0;
      float f2 = 0.0F;
      float f3;
      for (float f1 = 0.0F; k < paramInt1; f1 = f3 + f1)
      {
        f2 = (float)(f2 + Math.pow(this.htE[k][j], 2.0D) * Math.signum(this.htE[k][j]));
        f3 = Math.abs(this.htE[k][j]);
        k += 1;
      }
      if (f1 == 0.0F)
      {
        k = 0;
        label111:
        localObject = this.htH;
        if (f1 != 0.0F) {
          break label154;
        }
      }
      label154:
      for (int i = 0;; i = oe(k))
      {
        localObject[j] = i;
        j += 1;
        break;
        k = (int)(f2 / f1);
        break label111;
      }
    }
    Object localObject = dr(paramInt3, paramInt2);
    AppMethodBeat.o(136834);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.a
 * JD-Core Version:    0.7.0.1
 */