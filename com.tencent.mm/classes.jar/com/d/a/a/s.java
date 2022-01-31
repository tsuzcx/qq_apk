package com.d.a.a;

import android.location.Location;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

final class s
{
  private long aZb;
  float aZc;
  private ArrayList<String> aZd = new ArrayList();
  private ArrayList<float[]> aZe = new ArrayList();
  private ArrayList<double[]> aZf = new ArrayList();
  final d aZg;
  Handler aZh;
  
  public s(d paramd)
  {
    this.aZg = paramd;
  }
  
  private void aI(boolean paramBoolean)
  {
    label134:
    label1552:
    for (;;)
    {
      int k;
      int i3;
      int i;
      int m;
      label148:
      double[] arrayOfDouble1;
      double[] arrayOfDouble2;
      Object localObject1;
      double d2;
      double d3;
      double d4;
      double d5;
      double d1;
      label222:
      double d6;
      label277:
      label340:
      double d7;
      double[] arrayOfDouble3;
      label500:
      StringBuilder localStringBuilder;
      int i1;
      float f4;
      float f2;
      float f3;
      int j;
      float f1;
      label610:
      float[] arrayOfFloat;
      double[] arrayOfDouble4;
      label1076:
      label1077:
      int n;
      for (;;)
      {
        int i2;
        try
        {
          if ((!this.aZe.isEmpty()) && (!this.aZf.isEmpty()))
          {
            if (!paramBoolean) {
              break label134;
            }
            k = this.aZf.size();
            i3 = this.aZe.size();
            if (k > 1)
            {
              i = 0;
              m = 1;
              if (m < k) {
                break label148;
              }
              this.aZd.subList(0, i).clear();
              this.aZd.trimToSize();
              this.aZe.subList(0, i).clear();
              this.aZe.trimToSize();
              this.aZf.subList(0, k - 1).clear();
              this.aZf.trimToSize();
            }
          }
          return;
          k = this.aZf.size() - 1;
          break;
          arrayOfDouble1 = (double[])this.aZf.get(m - 1);
          arrayOfDouble2 = (double[])this.aZf.get(m);
          localObject1 = new float[1];
          d2 = arrayOfDouble1[0];
          d3 = arrayOfDouble1[1];
          d4 = arrayOfDouble1[0];
          d5 = arrayOfDouble1[1];
          if (arrayOfDouble1[1] > 179.0D) {
            break label1467;
          }
          d1 = 1.E-005D;
          Location.distanceBetween(d2, d3, d4, d1 + d5, (float[])localObject1);
          d3 = localObject1[0];
          d2 = arrayOfDouble1[0];
          d4 = arrayOfDouble1[1];
          d5 = arrayOfDouble1[0];
          if (arrayOfDouble1[0] > 89.0D) {
            break label1474;
          }
          d1 = 1.E-005D;
          Location.distanceBetween(d2, d4, d1 + d5, arrayOfDouble1[1], (float[])localObject1);
          d4 = localObject1[0];
          d5 = arrayOfDouble2[0];
          d6 = arrayOfDouble1[0];
          d2 = arrayOfDouble2[1] - arrayOfDouble1[1];
          if (d2 <= 180.0D) {
            break label1481;
          }
          d1 = d2 - 360.0D;
          d1 = d1 / 1.E-005D * d3;
          d5 = (d5 - d6) / 1.E-005D * d4;
          d6 = arrayOfDouble2[4] - arrayOfDouble1[4];
          d7 = arrayOfDouble2[5] - arrayOfDouble1[5];
          d2 = Math.sqrt((d1 * d1 + d5 * d5) / (d6 * d6 + d7 * d7));
          if ((d2 < 1.0F / y.bbV) || (d2 > y.bbV)) {
            break label1445;
          }
          d5 = Math.atan2(d5, d1) - Math.atan2(d7, d6);
          d1 = Math.cos(d5);
          d5 = Math.sin(d5);
          arrayOfDouble3 = new double[4];
          arrayOfDouble3[0] = d1;
          arrayOfDouble3[1] = (-d5);
          arrayOfDouble3[2] = d5;
          arrayOfDouble3[3] = d1;
          if (d2 < 1.0D)
          {
            d1 = d2;
            d1 *= 10.0D;
            d5 = 1.0D + Math.abs(d5);
            localStringBuilder = new StringBuilder();
            i1 = 0;
            f4 = 0.0F;
            f2 = 0.0F;
            f3 = 0.0F;
            if (!y.bbL) {
              break label1436;
            }
            writeLog("ref_point," + arrayOfDouble1[0] + ',' + arrayOfDouble1[1] + ',' + arrayOfDouble1[2] + ',' + arrayOfDouble1[8]);
            j = 1;
            f1 = 0.0F;
            break label1448;
            if (y.bbL) {
              writeLog("ref_point," + arrayOfDouble2[0] + ',' + arrayOfDouble2[1] + ',' + arrayOfDouble2[2] + ',' + arrayOfDouble2[8]);
            }
            if (i1 > y.bbT) {
              break label1428;
            }
            f3 -= f4;
            if ((f3 <= 0.0F) || ((f1 - f2) * d2 / f3 > y.bbU)) {
              break label1428;
            }
            r.pi().aO(localStringBuilder.toString());
            paramBoolean = true;
            if (y.bbL)
            {
              if (paramBoolean)
              {
                localObject1 = "buffered";
                writeLog((String)localObject1);
              }
            }
            else
            {
              d(new s.g(paramBoolean));
              break label1458;
            }
          }
          else
          {
            d1 = 1.0D / d2;
            break label500;
            arrayOfFloat = (float[])this.aZe.get(i);
            if (arrayOfFloat[2] > arrayOfDouble2[6]) {
              break label610;
            }
            arrayOfFloat[3] = Double.valueOf(Math.max(6.0D, Math.min(Math.abs((arrayOfFloat[2] - arrayOfDouble1[6]) / d1) * d5 + arrayOfDouble1[2], Math.abs((arrayOfFloat[2] - arrayOfDouble2[6]) / d1) * d5 + arrayOfDouble2[2]))).floatValue();
            arrayOfDouble4 = new double[2];
            arrayOfDouble4[0] = (arrayOfFloat[0] - arrayOfDouble1[4]);
            arrayOfDouble4[1] = (arrayOfFloat[1] - arrayOfDouble1[5]);
            localObject1 = new double[2];
            arrayOfDouble4[0] *= d2;
            arrayOfDouble4[1] *= d2;
            arrayOfDouble4 = new double[2];
            arrayOfDouble4[0] = (localObject1[0] * arrayOfDouble3[0] + localObject1[1] * arrayOfDouble3[1]);
            arrayOfDouble4[1] = (localObject1[0] * arrayOfDouble3[2] + localObject1[1] * arrayOfDouble3[3]);
            localObject1 = new double[2];
            arrayOfDouble4[0] += 0.0D;
            arrayOfDouble4[1] += 0.0D;
            arrayOfDouble4 = new double[2];
            arrayOfDouble4[0] = (1.E-005D * localObject1[1] / d4 + arrayOfDouble1[0]);
            arrayOfDouble4[1] = (1.E-005D * localObject1[0] / d3 + arrayOfDouble1[1]);
            if (arrayOfDouble4[0] > 90.0D)
            {
              arrayOfDouble4[0] = (180.0D - arrayOfDouble4[0]);
              break label1503;
              if (y.bbL) {
                writeLog("scan_point," + arrayOfDouble4[0] + ',' + arrayOfDouble4[1] + ',' + arrayOfFloat[3]);
              }
              localObject1 = (String)this.aZd.get(i);
              i2 = Math.round(arrayOfFloat[3]);
              n = i1;
              if (i2 > i1) {
                n = i2;
              }
              i1 = Math.round(arrayOfFloat[4]);
              if (localObject1 == null) {}
            }
          }
        }
        finally {}
        try
        {
          localStringBuilder.append((String)localObject1);
          d6 = arrayOfDouble4[0];
          d7 = arrayOfDouble4[1];
          if (v.e(d6, d7)) {
            break label1305;
          }
          localObject1 = "";
          localStringBuilder.append((String)localObject1);
        }
        catch (Error localError)
        {
          String str;
          continue;
        }
        if (j == 0) {
          break label1433;
        }
        f4 = arrayOfFloat[5];
        f2 = arrayOfFloat[2];
        j = 0;
        break label1529;
        if (arrayOfDouble4[0] >= -90.0D) {
          break label1503;
        }
        arrayOfDouble4[0] = (-180.0D - arrayOfDouble4[0]);
        break label1503;
        if (arrayOfDouble4[1] < -180.0D)
        {
          arrayOfDouble4[1] += 360.0D;
          continue;
          label1305:
          str = "|MD," + d6 + ',' + d7 + ',' + i2 + ',' + i1 + ',' + "";
        }
      }
      str = "discarded";
      continue;
      label1428:
      label1433:
      label1436:
      label1445:
      label1446:
      for (;;)
      {
        d1 = ((float[])this.aZe.get(i))[2];
        d2 = arrayOfDouble2[6];
        if (d1 <= d2) {
          i += 1;
        }
        for (;;)
        {
          if (i < i3) {
            break label1446;
          }
          break label1458;
          paramBoolean = false;
          break;
          break label1529;
          j = 1;
          f1 = 0.0F;
          break label1448;
        }
      }
      for (;;)
      {
        label1448:
        if (i < i3) {
          break label1552;
        }
        break label610;
        label1458:
        m += 1;
        break;
        label1467:
        d1 = -1.E-005D;
        break label222;
        label1474:
        d1 = -1.E-005D;
        break label277;
        label1481:
        d1 = d2;
        if (d2 >= -180.0D) {
          break label340;
        }
        d1 = d2 + 360.0D;
        break label340;
        label1503:
        if (arrayOfDouble4[1] <= 180.0D) {
          break label1076;
        }
        arrayOfDouble4[1] -= 360.0D;
        break label1077;
        label1529:
        f3 = arrayOfFloat[5];
        f1 = arrayOfFloat[2];
        i += 1;
        i1 = n;
      }
    }
  }
  
  private void d(p paramp)
  {
    if (this.aZh != null) {
      this.aZh.post(new s.d(this, paramp, (byte)0));
    }
  }
  
  private void pt()
  {
    try
    {
      this.aZf.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void pu()
  {
    try
    {
      this.aZd.clear();
      this.aZe.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static void writeLog(String paramString)
  {
    o.m("post_processing_log_" + y.bbS, paramString);
  }
  
  final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, String paramString)
  {
    try
    {
      this.aZd.add(paramString);
      this.aZe.add(new float[] { paramFloat1, paramFloat2, paramFloat3, 0.0F, paramInt, paramFloat4 });
      if (this.aZd.size() > 256)
      {
        this.aZd.subList(0, 1).clear();
        this.aZd.trimToSize();
        if (this.aZe.size() > 256)
        {
          this.aZe.subList(0, 1).clear();
          this.aZe.trimToSize();
        }
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final boolean a(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, double paramDouble4, double paramDouble5, double paramDouble6, long paramLong)
  {
    if (paramFloat < y.bbW) {
      return false;
    }
    if ((paramLong - this.aZb < 1000L) && (paramFloat <= this.aZc)) {
      return false;
    }
    z.b(null).execute(new s.b(this, paramDouble1, paramDouble2, paramDouble3, paramFloat, paramDouble4, paramDouble5, paramDouble6, paramLong, (byte)0));
    this.aZb = paramLong;
    this.aZc = paramFloat;
    return true;
  }
  
  final void b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
  {
    for (;;)
    {
      try
      {
        int j = this.aZf.size();
        int i = this.aZd.size();
        if (j <= 0)
        {
          this.aZf.add(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, i, paramDouble8 });
          i = 1;
          if (i != 0)
          {
            i = this.aZf.size();
            d(new s.e(i));
            if (i == 1) {
              pu();
            }
          }
          return;
        }
        double[] arrayOfDouble1 = (double[])this.aZf.get(j - 1);
        float[] arrayOfFloat;
        if (paramDouble8 - arrayOfDouble1[8] < 30000.0D)
        {
          if (paramDouble4 >= arrayOfDouble1[3])
          {
            arrayOfFloat = new float[1];
            arrayOfFloat[0] = 30.0F;
            if (j > 1)
            {
              double[] arrayOfDouble2 = (double[])this.aZf.get(j - 2);
              Location.distanceBetween(arrayOfDouble2[0], arrayOfDouble2[1], paramDouble1, paramDouble2, arrayOfFloat);
            }
            if (arrayOfFloat[0] >= 30.0F)
            {
              double d = i;
              i = arrayOfDouble1.length;
              System.arraycopy(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, d, paramDouble8 }, 0, arrayOfDouble1, 0, i);
              i = 1;
            }
          }
        }
        else
        {
          arrayOfFloat = new float[1];
          Location.distanceBetween(arrayOfDouble1[0], arrayOfDouble1[1], paramDouble1, paramDouble2, arrayOfFloat);
          if (arrayOfFloat[0] >= 30.0F)
          {
            this.aZf.add(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, i, paramDouble8 });
            i = 1;
            if (j >= 8)
            {
              this.aZf.subList(0, 1).clear();
              this.aZf.trimToSize();
            }
            try
            {
              aI(false);
            }
            catch (Exception localException) {}
            continue;
          }
        }
        i = 0;
      }
      finally {}
    }
  }
  
  final void pq()
  {
    z.b(null).execute(new s.c(this, (byte)0));
  }
  
  /* Error */
  final void pr()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: invokespecial 305	com/d/a/a/s:aI	(Z)V
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: goto -4 -> 7
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	19	0	this	s
    //   10	1	1	localException	Exception
    //   14	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	10	java/lang/Exception
    //   2	7	14	finally
  }
  
  final void ps()
  {
    this.aZb = 0L;
    this.aZc = 0.0F;
    z.b(null).execute(new s.f(this, (byte)0));
  }
  
  final void reset()
  {
    try
    {
      pt();
      pu();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.d.a.a.s
 * JD-Core Version:    0.7.0.1
 */