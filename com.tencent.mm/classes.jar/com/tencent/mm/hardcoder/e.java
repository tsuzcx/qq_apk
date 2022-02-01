package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private static a gyN = null;
  
  public static void a(a.b paramb)
  {
    AppMethodBeat.i(62479);
    int m = (int)(paramb.gyn - paramb.gyt);
    int i;
    int n;
    if (HardCoderJNI.isHcEnable())
    {
      i = 1;
      n = HardCoderJNI.isRunning();
      if (m - paramb.delay > 0) {
        break label172;
      }
    }
    int i1;
    long l;
    int i2;
    int i3;
    int[] arrayOfInt1;
    int i4;
    int i5;
    int[] arrayOfInt2;
    int[] arrayOfInt3;
    StringBuilder localStringBuilder1;
    int i6;
    int k;
    int i7;
    label172:
    for (int j = 1;; j = 0)
    {
      i1 = paramb.scene;
      l = paramb.gys;
      i2 = paramb.gyo;
      i3 = paramb.gyq;
      arrayOfInt1 = paramb.gyA;
      i4 = (int)(paramb.gyu - paramb.startTime);
      i5 = HardCoderJNI.tickRate;
      arrayOfInt2 = paramb.gyy;
      arrayOfInt3 = paramb.gyz;
      localStringBuilder1 = new StringBuilder();
      if (arrayOfInt1 == null) {
        break label177;
      }
      i6 = arrayOfInt1.length;
      k = 0;
      while (k < i6)
      {
        i7 = arrayOfInt1[k];
        localStringBuilder1.append(i7 + "#");
        k += 1;
      }
      i = 0;
      break;
    }
    label177:
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (arrayOfInt2 != null)
    {
      i6 = arrayOfInt2.length;
      k = 0;
      while (k < i6)
      {
        i7 = arrayOfInt2[k];
        localStringBuilder2.append(i7 + "#");
        k += 1;
      }
    }
    StringBuilder localStringBuilder3 = new StringBuilder();
    if (arrayOfInt3 != null)
    {
      i6 = arrayOfInt3.length;
      k = 0;
      while (k < i6)
      {
        i7 = arrayOfInt3[k];
        localStringBuilder3.append(i7 + "#");
        k += 1;
      }
    }
    d.d("Hardcoder.HardCoderReporter", String.format("performanceReport, hash:%s, threadId:%s, enable:%s, engineStatus:%s, cancelInDelay:%s, scene:%s, action:%s, lastCpuLevel:%s, cpuLevel:%s, lastIoLevel:%s, ioLevel:%s, bindCoreIds:%s, executeTime:%s, runtime:%s, phoneHZ:%s, cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[] { Integer.valueOf(paramb.hashCode()), paramb.ahB(), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l), Integer.valueOf(paramb.gyw), Integer.valueOf(i2), Integer.valueOf(paramb.gyx), Integer.valueOf(i3), localStringBuilder1.toString(), Integer.valueOf(i4), Integer.valueOf(m), Integer.valueOf(i5), localStringBuilder2.toString(), localStringBuilder3.toString() }));
    if (gyN != null) {
      gyN.a(paramb.gyr, i, n, j, i1, l, i2, i3, arrayOfInt1, i4, m, i5, arrayOfInt2, arrayOfInt3);
    }
    AppMethodBeat.o(62479);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(62478);
    if (gyN == null)
    {
      d.i("Hardcoder.HardCoderReporter", String.format("setReporter[%s]", new Object[] { parama }));
      gyN = parama;
    }
    AppMethodBeat.o(62478);
  }
  
  public static abstract interface a
  {
    public abstract void a(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5, int paramInt6, int[] paramArrayOfInt2, int paramInt7, int paramInt8, int paramInt9, int[] paramArrayOfInt3, int[] paramArrayOfInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.e
 * JD-Core Version:    0.7.0.1
 */