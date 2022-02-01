package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
{
  private static e.a mxd = null;
  
  public static void a(a.b paramb)
  {
    AppMethodBeat.i(62479);
    int m = (int)(paramb.mwD - paramb.mwJ);
    int i;
    int n;
    if (HardCoderJNI.isHcEnable())
    {
      i = 1;
      n = HardCoderJNI.isRunning();
      if (m - paramb.UZ > 0) {
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
      l = paramb.mwI;
      i2 = paramb.mwE;
      i3 = paramb.mwG;
      arrayOfInt1 = paramb.mwQ;
      i4 = (int)(paramb.mwK - paramb.startTime);
      i5 = HardCoderJNI.tickRate;
      arrayOfInt2 = paramb.mwO;
      arrayOfInt3 = paramb.mwP;
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
    d.d("Hardcoder.HardCoderReporter", String.format("performanceReport, hash:%s, threadId:%s, enable:%s, engineStatus:%s, cancelInDelay:%s, scene:%s, action:%s, lastCpuLevel:%s, cpuLevel:%s, lastIoLevel:%s, ioLevel:%s, bindCoreIds:%s, executeTime:%s, runtime:%s, phoneHZ:%s, cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[] { Integer.valueOf(paramb.hashCode()), paramb.aYf(), Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Long.valueOf(l), Integer.valueOf(paramb.mwM), Integer.valueOf(i2), Integer.valueOf(paramb.mwN), Integer.valueOf(i3), localStringBuilder1.toString(), Integer.valueOf(i4), Integer.valueOf(m), Integer.valueOf(i5), localStringBuilder2.toString(), localStringBuilder3.toString() }));
    if (mxd != null) {
      mxd.a(paramb.mwH, i, n, j, i1, l, i2, i3, arrayOfInt1, i4, m, i5, arrayOfInt2, arrayOfInt3);
    }
    AppMethodBeat.o(62479);
  }
  
  public static void a(e.a parama)
  {
    AppMethodBeat.i(62478);
    if (mxd == null)
    {
      d.i("Hardcoder.HardCoderReporter", String.format("setReporter[%s]", new Object[] { parama }));
      mxd = parama;
    }
    AppMethodBeat.o(62478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.hardcoder.e
 * JD-Core Version:    0.7.0.1
 */