package com.b.a.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$d
{
  private float brA = 0.0F;
  private float brB = 0.0F;
  private float brC = 0.0F;
  private float brD = 0.0F;
  private float brv = 0.0F;
  private float brw = 0.0F;
  private float brx = 0.0F;
  private float bry = 0.0F;
  private float brz = 0.0F;
  private int count = 0;
  
  final u.b a(float[][] paramArrayOfFloat)
  {
    int i = 0;
    for (;;)
    {
      u.b localb;
      try
      {
        AppMethodBeat.i(55631);
        if ((this.count <= 0) || (paramArrayOfFloat.length < 3))
        {
          paramArrayOfFloat = null;
          AppMethodBeat.o(55631);
          return paramArrayOfFloat;
        }
        localb = new u.b((byte)0);
        localb.time = SystemClock.elapsedRealtime();
        if (i > 5)
        {
          localb.bre = (this.brv / this.count);
          localb.brf = (this.brw / this.count);
          localb.brg = (this.brx / this.count);
          localb.brh = (this.bry / this.count);
          localb.bri = (this.brz / this.count);
          localb.brj = (this.brA / this.count);
          localb.brk = (this.brB / this.count);
          localb.brl = (this.brC / this.count);
          localb.brm = (this.brD / this.count);
          localb.bro = ((float)Math.sqrt(localb.bre * localb.bre + localb.brf * localb.brf));
          reset();
          AppMethodBeat.o(55631);
          paramArrayOfFloat = localb;
          continue;
        }
        localb.brp[i] = paramArrayOfFloat[i][0];
      }
      finally {}
      localb.brq[i] = paramArrayOfFloat[i][1];
      localb.brr[i] = paramArrayOfFloat[i][2];
      localb.brs[i] = ((float)Math.sin(localb.brp[i]));
      localb.brt[i] = ((float)Math.cos(localb.brp[i]));
      i += 1;
    }
  }
  
  final void a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    try
    {
      if (paramArrayOfFloat1.length >= 3)
      {
        this.count += 1;
        this.brv += paramArrayOfFloat1[0];
        this.brw += paramArrayOfFloat1[1];
        this.brx += paramArrayOfFloat1[2];
        this.bry += paramArrayOfFloat2[0];
        this.brz += paramArrayOfFloat2[1];
        this.brA += paramArrayOfFloat2[2];
        this.brB += paramArrayOfFloat3[0];
        this.brC += paramArrayOfFloat3[1];
        this.brD += paramArrayOfFloat3[2];
      }
      return;
    }
    finally
    {
      paramArrayOfFloat1 = finally;
      throw paramArrayOfFloat1;
    }
  }
  
  final void reset()
  {
    try
    {
      this.count = 0;
      this.brv = 0.0F;
      this.brw = 0.0F;
      this.brx = 0.0F;
      this.bry = 0.0F;
      this.brz = 0.0F;
      this.brA = 0.0F;
      this.brB = 0.0F;
      this.brC = 0.0F;
      this.brD = 0.0F;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.b.a.a.u.d
 * JD-Core Version:    0.7.0.1
 */