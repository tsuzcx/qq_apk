package com.d.a.a;

import android.os.SystemClock;

final class u$d
{
  private float baP = 0.0F;
  private float baQ = 0.0F;
  private float baR = 0.0F;
  private float baS = 0.0F;
  private float baT = 0.0F;
  private float baU = 0.0F;
  private float baV = 0.0F;
  private float baW = 0.0F;
  private float baX = 0.0F;
  private int count = 0;
  
  final u.b a(float[][] paramArrayOfFloat)
  {
    int i = 0;
    for (;;)
    {
      u.b localb;
      try
      {
        if (this.count > 0)
        {
          int j = paramArrayOfFloat.length;
          if (j >= 3) {}
        }
        else
        {
          paramArrayOfFloat = null;
          return paramArrayOfFloat;
        }
        localb = new u.b((byte)0);
        localb.time = SystemClock.elapsedRealtime();
        if (i > 5)
        {
          localb.bay = (this.baP / this.count);
          localb.baz = (this.baQ / this.count);
          localb.baA = (this.baR / this.count);
          localb.baB = (this.baS / this.count);
          localb.baC = (this.baT / this.count);
          localb.baD = (this.baU / this.count);
          localb.baE = (this.baV / this.count);
          localb.baF = (this.baW / this.count);
          localb.baG = (this.baX / this.count);
          localb.baI = ((float)Math.sqrt(localb.bay * localb.bay + localb.baz * localb.baz));
          reset();
          paramArrayOfFloat = localb;
          continue;
        }
        localb.baJ[i] = paramArrayOfFloat[i][0];
      }
      finally {}
      localb.baK[i] = paramArrayOfFloat[i][1];
      localb.baL[i] = paramArrayOfFloat[i][2];
      localb.baM[i] = ((float)Math.sin(localb.baJ[i]));
      localb.baN[i] = ((float)Math.cos(localb.baJ[i]));
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
        this.baP += paramArrayOfFloat1[0];
        this.baQ += paramArrayOfFloat1[1];
        this.baR += paramArrayOfFloat1[2];
        this.baS += paramArrayOfFloat2[0];
        this.baT += paramArrayOfFloat2[1];
        this.baU += paramArrayOfFloat2[2];
        this.baV += paramArrayOfFloat3[0];
        this.baW += paramArrayOfFloat3[1];
        this.baX += paramArrayOfFloat3[2];
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
      this.baP = 0.0F;
      this.baQ = 0.0F;
      this.baR = 0.0F;
      this.baS = 0.0F;
      this.baT = 0.0F;
      this.baU = 0.0F;
      this.baV = 0.0F;
      this.baW = 0.0F;
      this.baX = 0.0F;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.d.a.a.u.d
 * JD-Core Version:    0.7.0.1
 */