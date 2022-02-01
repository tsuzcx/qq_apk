package com.tencent.mm.audio.mix.e;

import com.tencent.mm.audio.mix.a.e;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public abstract class f
  implements h
{
  protected int fpA = 32767;
  protected int fpB = -32768;
  protected com.tencent.mm.audio.mix.a.b fpC;
  protected short[][] fpv = (short[][])Array.newInstance(Short.TYPE, new int[] { 1, 1 });
  protected int fpw = 1;
  protected int fpx = 1;
  protected short[] fpy = new short[1];
  protected int fpz = 1;
  
  private byte[] aem()
  {
    if (this.fpC != null) {
      return this.fpC.fmy;
    }
    return null;
  }
  
  protected abstract byte[] K(int paramInt1, int paramInt2, int paramInt3);
  
  public final boolean a(com.tencent.mm.audio.mix.a.b paramb, List<e> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.BaseAudioMixAlgorithm", "process list is invalid");
      return false;
    }
    Object localObject1 = new byte[paramList.size()][];
    int i = 0;
    while (i < paramList.size())
    {
      localObject1[i] = ((e)paramList.get(i)).fmy;
      i += 1;
    }
    this.fpC = paramb;
    if (localObject1.length == 0) {
      localObject1 = null;
    }
    while (localObject1 == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.BaseAudioMixAlgorithm", "mixed data is invalid");
      return false;
      Object localObject2 = localObject1[0];
      if ((localObject2 == null) || (localObject2.length == 0))
      {
        localObject1 = null;
      }
      else if (localObject1.length == 1)
      {
        byte[] arrayOfByte = aem();
        if (arrayOfByte != null)
        {
          localObject1 = arrayOfByte;
          if (arrayOfByte.length == localObject2.length) {}
        }
        else
        {
          localObject1 = new byte[localObject2.length];
        }
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      }
      else
      {
        i = 0;
        for (;;)
        {
          if (i >= localObject1.length) {
            break label232;
          }
          if (localObject1[i].length != localObject2.length)
          {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.BaseAudioMixAlgorithm", "column of the road of audio + " + i + " is different.");
            localObject1 = null;
            break;
          }
          i += 1;
        }
        label232:
        int k = localObject1.length;
        int m = localObject2.length / 2;
        if ((k != this.fpw) || (m != this.fpx))
        {
          this.fpv = ((short[][])Array.newInstance(Short.TYPE, new int[] { k, m }));
          this.fpw = k;
          this.fpx = m;
        }
        i = 0;
        while (i < k)
        {
          Arrays.fill(this.fpv[i], 0, m - 1, (short)0);
          int j = 0;
          while (j < m)
          {
            this.fpv[i][j] = ((short)(localObject1[i][(j * 2)] & 0xFF | (localObject1[i][(j * 2 + 1)] & 0xFF) << 8));
            j += 1;
          }
          i += 1;
        }
        if (this.fpz != m)
        {
          this.fpz = m;
          this.fpy = new short[m];
        }
        Arrays.fill(this.fpy, 0, m - 1, (short)0);
        localObject1 = K(k, m, localObject2.length);
      }
    }
    paramb.fmy = ((byte[])localObject1);
    paramb.channels = ((e)paramList.get(0)).channels;
    paramb.sampleRate = ((e)paramList.get(0)).sampleRate;
    return true;
  }
  
  protected final byte[] cB(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte2 = aem();
    byte[] arrayOfByte1;
    if (arrayOfByte2 != null)
    {
      arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2.length == paramInt1) {}
    }
    else
    {
      arrayOfByte1 = new byte[paramInt1];
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      arrayOfByte1[(paramInt1 * 2)] = ((byte)(this.fpy[paramInt1] & 0xFF));
      arrayOfByte1[(paramInt1 * 2 + 1)] = ((byte)((this.fpy[paramInt1] & 0xFF00) >> 8));
      paramInt1 += 1;
    }
    return arrayOfByte1;
  }
  
  protected final short kx(int paramInt)
  {
    if (paramInt > this.fpA) {
      return (short)this.fpA;
    }
    if (paramInt < this.fpB) {
      return (short)this.fpB;
    }
    return (short)paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.e.f
 * JD-Core Version:    0.7.0.1
 */