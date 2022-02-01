package com.d.a.a;

import android.location.Location;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class s
{
  private long bZX;
  float bZY;
  private ArrayList<String> bZZ;
  private ArrayList<float[]> caa;
  private ArrayList<double[]> cab;
  final d cac;
  Handler cad;
  
  public s(d paramd)
  {
    AppMethodBeat.i(88004);
    this.bZZ = new ArrayList();
    this.caa = new ArrayList();
    this.cab = new ArrayList();
    this.cac = paramd;
    AppMethodBeat.o(88004);
  }
  
  private void Ax()
  {
    try
    {
      AppMethodBeat.i(88011);
      this.cab.clear();
      AppMethodBeat.o(88011);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void Ay()
  {
    try
    {
      AppMethodBeat.i(88012);
      this.bZZ.clear();
      this.caa.clear();
      AppMethodBeat.o(88012);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void bm(boolean paramBoolean)
  {
    label144:
    label1562:
    for (;;)
    {
      int k;
      int i3;
      int i;
      int m;
      label158:
      double[] arrayOfDouble1;
      double[] arrayOfDouble2;
      Object localObject1;
      double d2;
      double d3;
      double d4;
      double d5;
      double d1;
      label232:
      double d6;
      label287:
      label350:
      double d7;
      double[] arrayOfDouble3;
      label510:
      StringBuilder localStringBuilder;
      int i1;
      float f4;
      float f3;
      int j;
      float f1;
      float f2;
      label620:
      float[] arrayOfFloat;
      double[] arrayOfDouble4;
      label1086:
      label1087:
      int n;
      for (;;)
      {
        int i2;
        try
        {
          AppMethodBeat.i(88013);
          if ((!this.caa.isEmpty()) && (!this.cab.isEmpty()))
          {
            if (!paramBoolean) {
              break label144;
            }
            k = this.cab.size();
            i3 = this.caa.size();
            if (k > 1)
            {
              i = 0;
              m = 1;
              if (m < k) {
                break label158;
              }
              this.bZZ.subList(0, i).clear();
              this.bZZ.trimToSize();
              this.caa.subList(0, i).clear();
              this.caa.trimToSize();
              this.cab.subList(0, k - 1).clear();
              this.cab.trimToSize();
            }
          }
          AppMethodBeat.o(88013);
          return;
          k = this.cab.size() - 1;
          break;
          arrayOfDouble1 = (double[])this.cab.get(m - 1);
          arrayOfDouble2 = (double[])this.cab.get(m);
          localObject1 = new float[1];
          d2 = arrayOfDouble1[0];
          d3 = arrayOfDouble1[1];
          d4 = arrayOfDouble1[0];
          d5 = arrayOfDouble1[1];
          if (arrayOfDouble1[1] > 179.0D) {
            break label1477;
          }
          d1 = 1.E-005D;
          Location.distanceBetween(d2, d3, d4, d1 + d5, (float[])localObject1);
          d3 = localObject1[0];
          d2 = arrayOfDouble1[0];
          d4 = arrayOfDouble1[1];
          d5 = arrayOfDouble1[0];
          if (arrayOfDouble1[0] > 89.0D) {
            break label1484;
          }
          d1 = 1.E-005D;
          Location.distanceBetween(d2, d4, d1 + d5, arrayOfDouble1[1], (float[])localObject1);
          d4 = localObject1[0];
          d5 = arrayOfDouble2[0];
          d6 = arrayOfDouble1[0];
          d2 = arrayOfDouble2[1] - arrayOfDouble1[1];
          if (d2 <= 180.0D) {
            break label1491;
          }
          d1 = d2 - 360.0D;
          d1 = d1 / 1.E-005D * d3;
          d5 = (d5 - d6) / 1.E-005D * d4;
          d6 = arrayOfDouble2[4] - arrayOfDouble1[4];
          d7 = arrayOfDouble2[5] - arrayOfDouble1[5];
          d2 = Math.sqrt((d1 * d1 + d5 * d5) / (d6 * d6 + d7 * d7));
          if ((d2 < 1.0F / y.ccR) || (d2 > y.ccR)) {
            break label1455;
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
            f3 = 0.0F;
            j = 1;
            if (!y.ccH) {
              break label1446;
            }
            writeLog("ref_point," + arrayOfDouble1[0] + ',' + arrayOfDouble1[1] + ',' + arrayOfDouble1[2] + ',' + arrayOfDouble1[8]);
            f1 = 0.0F;
            f2 = 0.0F;
            break label1458;
            if (y.ccH) {
              writeLog("ref_point," + arrayOfDouble2[0] + ',' + arrayOfDouble2[1] + ',' + arrayOfDouble2[2] + ',' + arrayOfDouble2[8]);
            }
            if (i1 > y.ccP) {
              break label1438;
            }
            f2 -= f4;
            if ((f2 <= 0.0F) || ((f1 - f3) * d2 / f2 > y.ccQ)) {
              break label1438;
            }
            r.Am().cl(localStringBuilder.toString());
            paramBoolean = true;
            if (y.ccH)
            {
              if (paramBoolean)
              {
                localObject1 = "buffered";
                writeLog((String)localObject1);
              }
            }
            else
            {
              d(new g(paramBoolean));
              break label1468;
            }
          }
          else
          {
            d1 = 1.0D / d2;
            break label510;
            arrayOfFloat = (float[])this.caa.get(i);
            if (arrayOfFloat[2] > arrayOfDouble2[6]) {
              break label620;
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
              break label1513;
              if (y.ccH) {
                writeLog("scan_point," + arrayOfDouble4[0] + ',' + arrayOfDouble4[1] + ',' + arrayOfFloat[3]);
              }
              localObject1 = (String)this.bZZ.get(i);
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
          if (v.b(d6, d7)) {
            break label1315;
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
          break label1443;
        }
        f4 = arrayOfFloat[5];
        f3 = arrayOfFloat[2];
        j = 0;
        break label1539;
        if (arrayOfDouble4[0] >= -90.0D) {
          break label1513;
        }
        arrayOfDouble4[0] = (-180.0D - arrayOfDouble4[0]);
        break label1513;
        if (arrayOfDouble4[1] < -180.0D)
        {
          arrayOfDouble4[1] += 360.0D;
          continue;
          label1315:
          str = "|MD," + d6 + ',' + d7 + ',' + i2 + ',' + i1 + ',' + "";
        }
      }
      str = "discarded";
      continue;
      label1438:
      label1443:
      label1446:
      label1455:
      label1456:
      for (;;)
      {
        d1 = ((float[])this.caa.get(i))[2];
        d2 = arrayOfDouble2[6];
        if (d1 <= d2) {
          i += 1;
        }
        for (;;)
        {
          if (i < i3) {
            break label1456;
          }
          break label1468;
          paramBoolean = false;
          break;
          break label1539;
          f1 = 0.0F;
          f2 = 0.0F;
          break label1458;
        }
      }
      for (;;)
      {
        label1458:
        if (i < i3) {
          break label1562;
        }
        break label620;
        label1468:
        m += 1;
        break;
        label1477:
        d1 = -1.E-005D;
        break label232;
        label1484:
        d1 = -1.E-005D;
        break label287;
        label1491:
        d1 = d2;
        if (d2 >= -180.0D) {
          break label350;
        }
        d1 = d2 + 360.0D;
        break label350;
        label1513:
        if (arrayOfDouble4[1] <= 180.0D) {
          break label1086;
        }
        arrayOfDouble4[1] -= 360.0D;
        break label1087;
        f2 = arrayOfFloat[5];
        f1 = arrayOfFloat[2];
        i += 1;
        i1 = n;
      }
    }
  }
  
  private void d(p paramp)
  {
    AppMethodBeat.i(88005);
    if (this.cad != null) {
      this.cad.post(new s.d(this, paramp, (byte)0));
    }
    AppMethodBeat.o(88005);
  }
  
  private static void writeLog(String paramString)
  {
    AppMethodBeat.i(88006);
    o.t("post_processing_log_" + y.ccO, paramString);
    AppMethodBeat.o(88006);
  }
  
  final void Au()
  {
    AppMethodBeat.i(88007);
    z.b(null).execute(new c((byte)0));
    AppMethodBeat.o(88007);
  }
  
  final void Av()
  {
    try
    {
      AppMethodBeat.i(88008);
      try
      {
        bm(true);
        AppMethodBeat.o(88008);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          AppMethodBeat.o(88008);
        }
      }
      return;
    }
    finally {}
  }
  
  final void Aw()
  {
    AppMethodBeat.i(88009);
    this.bZX = 0L;
    this.bZY = 0.0F;
    z.b(null).execute(new f((byte)0));
    AppMethodBeat.o(88009);
  }
  
  final void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(88016);
        int j = this.cab.size();
        int i = this.bZZ.size();
        if (j <= 0)
        {
          this.cab.add(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, i, paramDouble8 });
          i = 1;
          if (i != 0)
          {
            i = this.cab.size();
            d(new e(i));
            if (i == 1) {
              Ay();
            }
          }
          AppMethodBeat.o(88016);
          return;
        }
        double[] arrayOfDouble1 = (double[])this.cab.get(j - 1);
        float[] arrayOfFloat;
        if (paramDouble8 - arrayOfDouble1[8] < 30000.0D)
        {
          if (paramDouble4 >= arrayOfDouble1[3])
          {
            arrayOfFloat = new float[1];
            arrayOfFloat[0] = 30.0F;
            if (j > 1)
            {
              double[] arrayOfDouble2 = (double[])this.cab.get(j - 2);
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
            this.cab.add(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, i, paramDouble8 });
            i = 1;
            if (j >= 8)
            {
              this.cab.subList(0, 1).clear();
              this.cab.trimToSize();
            }
            try
            {
              bm(false);
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
  
  final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, String paramString)
  {
    try
    {
      AppMethodBeat.i(88014);
      this.bZZ.add(paramString);
      this.caa.add(new float[] { paramFloat1, paramFloat2, paramFloat3, 0.0F, paramInt, paramFloat4 });
      if (this.bZZ.size() > 256)
      {
        this.bZZ.subList(0, 1).clear();
        this.bZZ.trimToSize();
        if (this.caa.size() > 256)
        {
          this.caa.subList(0, 1).clear();
          this.caa.trimToSize();
        }
      }
      AppMethodBeat.o(88014);
      return;
    }
    finally {}
  }
  
  final boolean a(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat, double paramDouble4, double paramDouble5, double paramDouble6, long paramLong)
  {
    AppMethodBeat.i(88015);
    if (paramFloat < y.ccS)
    {
      AppMethodBeat.o(88015);
      return false;
    }
    if ((paramLong - this.bZX < 1000L) && (paramFloat <= this.bZY))
    {
      AppMethodBeat.o(88015);
      return false;
    }
    z.b(null).execute(new s.b(this, paramDouble1, paramDouble2, paramDouble3, paramFloat, paramDouble4, paramDouble5, paramDouble6, paramLong, (byte)0));
    this.bZX = paramLong;
    this.bZY = paramFloat;
    AppMethodBeat.o(88015);
    return true;
  }
  
  final void reset()
  {
    try
    {
      AppMethodBeat.i(88010);
      Ax();
      Ay();
      AppMethodBeat.o(88010);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final class c
    implements Runnable
  {
    private c() {}
    
    public final void run()
    {
      AppMethodBeat.i(88001);
      s.this.Av();
      AppMethodBeat.o(88001);
    }
  }
  
  static final class e
    extends p
  {
    final int cao;
    
    e(int paramInt)
    {
      super();
      this.cao = paramInt;
    }
  }
  
  final class f
    implements Runnable
  {
    private f() {}
    
    public final void run()
    {
      AppMethodBeat.i(88003);
      s.this.reset();
      AppMethodBeat.o(88003);
    }
  }
  
  static final class g
    extends p
  {
    final boolean cap;
    
    g(boolean paramBoolean)
    {
      super();
      this.cap = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.a.s
 * JD-Core Version:    0.7.0.1
 */