package com.tencent.mm.hardcoder;

public final class h
{
  private static i dFh = null;
  
  public static void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    if (dFh != null) {
      dFh.a(paramInt1, paramLong, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public static void a(a.b paramb)
  {
    int n = (int)(paramb.dEF - paramb.dEp);
    int j;
    int i1;
    int k;
    label37:
    int i2;
    long l1;
    int i3;
    int i4;
    int[] arrayOfInt1;
    int i5;
    int i6;
    int i;
    if (HardCoderJNI.hcEnable)
    {
      j = 1;
      i1 = HardCoderJNI.isRunning();
      if (n - paramb.delay > 0) {
        break label223;
      }
      k = 1;
      i2 = paramb.scene;
      l1 = paramb.dEo;
      i3 = paramb.dEl;
      i4 = paramb.dEm;
      arrayOfInt1 = paramb.dEw;
      i5 = (int)(paramb.dEq - paramb.startTime);
      i6 = paramb.dEA;
      i = 0;
      if (paramb.dEC != null) {
        i = (int)(0L + paramb.dEC.dFo);
      }
      if (paramb.dED == null) {
        break label625;
      }
      i = (int)(i + paramb.dED.dFo);
    }
    label223:
    label625:
    for (;;)
    {
      int i7 = HardCoderJNI.TICK_RATE;
      long l2 = paramb.dEB;
      int[] arrayOfInt2 = paramb.dEu;
      int[] arrayOfInt3 = paramb.dEv;
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
            break label37;
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
      if ((paramb.dEn != 0) && (HardCoderJNI.hcDebug)) {
        c.i("HardCoder.HardCoderReporter", String.format("[oneliang]performance report,hash:%s,threadId:%s,enable:%s, engineStatus:%s,cancelInDelay:%s,scene:%s,action:%s,lastCpuLevel:%s,cpuLevel:%s,lastIoLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[] { Integer.valueOf(paramb.hashCode()), Integer.valueOf(paramb.dEn), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(i2), Long.valueOf(l1), Integer.valueOf(paramb.dEs), Integer.valueOf(i3), Integer.valueOf(paramb.dEt), Integer.valueOf(i4), localStringBuilder1.toString(), Integer.valueOf(i5), Integer.valueOf(n), Integer.valueOf(i6), Integer.valueOf(i), Integer.valueOf(i7), Long.valueOf(l2), localStringBuilder2.toString(), localStringBuilder3.toString() }));
      }
      if (dFh != null) {
        dFh.a(paramb.dEn, j, i1, k, i2, l1, i3, i4, arrayOfInt1, i5, n, i6, i, i7, l2, arrayOfInt2, arrayOfInt3);
      }
      return;
    }
  }
  
  public static void a(i parami)
  {
    if (dFh == null)
    {
      c.i("HardCoder.HardCoderReporter", String.format("hardcoder setReporter[%s]", new Object[] { parami }));
      dFh = parami;
    }
  }
  
  public static void reportInfo(e parame)
  {
    if (dFh != null) {
      dFh.reportInfo(parame);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.h
 * JD-Core Version:    0.7.0.1
 */