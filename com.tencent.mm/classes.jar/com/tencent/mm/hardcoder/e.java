package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private static a eCG = null;
  
  public static void a(a.b paramb)
  {
    AppMethodBeat.i(93932);
    int n = (int)(paramb.eBL - paramb.eBS);
    int j;
    int i1;
    int k;
    label42:
    int i2;
    long l1;
    int i3;
    int i4;
    int[] arrayOfInt1;
    int i5;
    int i6;
    int i;
    if (HardCoderJNI.isHcEnable())
    {
      j = 1;
      i1 = HardCoderJNI.isRunning();
      if (n - paramb.delay > 0) {
        break label228;
      }
      k = 1;
      i2 = paramb.scene;
      l1 = paramb.eBR;
      i3 = paramb.eBN;
      i4 = paramb.eBP;
      arrayOfInt1 = paramb.eBZ;
      i5 = (int)(paramb.eBT - paramb.startTime);
      i6 = paramb.eCd;
      i = 0;
      if (paramb.eCf != null) {
        i = (int)(0L + paramb.eCf.eCN);
      }
      if (paramb.eCg == null) {
        break label619;
      }
      i = (int)(i + paramb.eCg.eCN);
    }
    label228:
    label619:
    for (;;)
    {
      int i7 = HardCoderJNI.tickRate;
      long l2 = paramb.eCe;
      int[] arrayOfInt2 = paramb.eBX;
      int[] arrayOfInt3 = paramb.eBY;
      StringBuilder localStringBuilder1 = new StringBuilder();
      int i8;
      int m;
      int i9;
      if (arrayOfInt1 != null)
      {
        i8 = arrayOfInt1.length;
        m = 0;
        for (;;)
        {
          if (m < i8)
          {
            i9 = arrayOfInt1[m];
            localStringBuilder1.append(i9 + "#");
            m += 1;
            continue;
            j = 0;
            break;
            k = 0;
            break label42;
          }
        }
      }
      StringBuilder localStringBuilder2 = new StringBuilder();
      if (arrayOfInt2 != null)
      {
        i8 = arrayOfInt2.length;
        m = 0;
        while (m < i8)
        {
          i9 = arrayOfInt2[m];
          localStringBuilder2.append(i9 + "#");
          m += 1;
        }
      }
      StringBuilder localStringBuilder3 = new StringBuilder();
      if (arrayOfInt3 != null)
      {
        i8 = arrayOfInt3.length;
        m = 0;
        while (m < i8)
        {
          i9 = arrayOfInt3[m];
          localStringBuilder3.append(i9 + "#");
          m += 1;
        }
      }
      c.d("HardCoder.HardCoderReporter", String.format("[oneliang]performance report,hash:%s,threadId:%s,enable:%s, engineStatus:%s,cancelInDelay:%s,scene:%s,action:%s,lastCpuLevel:%s,cpuLevel:%s,lastIoLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[] { Integer.valueOf(paramb.hashCode()), paramb.PD(), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(i2), Long.valueOf(l1), Integer.valueOf(paramb.eBV), Integer.valueOf(i3), Integer.valueOf(paramb.eBW), Integer.valueOf(i4), localStringBuilder1.toString(), Integer.valueOf(i5), Integer.valueOf(n), Integer.valueOf(i6), Integer.valueOf(i), Integer.valueOf(i7), Long.valueOf(l2), localStringBuilder2.toString(), localStringBuilder3.toString() }));
      if (eCG != null) {
        eCG.a(paramb.eBQ, j, i1, k, i2, l1, i3, i4, arrayOfInt1, i5, n, i6, i, i7, l2, arrayOfInt2, arrayOfInt3);
      }
      AppMethodBeat.o(93932);
      return;
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(93931);
    if (eCG == null)
    {
      c.i("HardCoder.HardCoderReporter", String.format("hardcoder setReporter[%s]", new Object[] { parama }));
      eCG = parama;
    }
    AppMethodBeat.o(93931);
  }
  
  public static abstract interface a
  {
    public abstract void a(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, int paramInt6, int[] paramArrayOfInt2, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, long paramLong2, int[] paramArrayOfInt3, int[] paramArrayOfInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.e
 * JD-Core Version:    0.7.0.1
 */