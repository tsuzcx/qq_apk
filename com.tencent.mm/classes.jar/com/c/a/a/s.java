package com.c.a.a;

import android.location.Location;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class s
{
  private long bPK;
  float bPL;
  private ArrayList<String> bPM;
  private ArrayList<float[]> bPN;
  private ArrayList<double[]> bPO;
  final d bPP;
  Handler bPQ;
  
  public s(d paramd)
  {
    AppMethodBeat.i(88004);
    this.bPM = new ArrayList();
    this.bPN = new ArrayList();
    this.bPO = new ArrayList();
    this.bPP = paramd;
    AppMethodBeat.o(88004);
  }
  
  private void bl(boolean paramBoolean)
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
          if ((!this.bPN.isEmpty()) && (!this.bPO.isEmpty()))
          {
            if (!paramBoolean) {
              break label144;
            }
            k = this.bPO.size();
            i3 = this.bPN.size();
            if (k > 1)
            {
              i = 0;
              m = 1;
              if (m < k) {
                break label158;
              }
              this.bPM.subList(0, i).clear();
              this.bPM.trimToSize();
              this.bPN.subList(0, i).clear();
              this.bPN.trimToSize();
              this.bPO.subList(0, k - 1).clear();
              this.bPO.trimToSize();
            }
          }
          AppMethodBeat.o(88013);
          return;
          k = this.bPO.size() - 1;
          break;
          arrayOfDouble1 = (double[])this.bPO.get(m - 1);
          arrayOfDouble2 = (double[])this.bPO.get(m);
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
          if ((d2 < 1.0F / y.bSE) || (d2 > y.bSE)) {
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
            if (!y.bSu) {
              break label1446;
            }
            writeLog("ref_point," + arrayOfDouble1[0] + ',' + arrayOfDouble1[1] + ',' + arrayOfDouble1[2] + ',' + arrayOfDouble1[8]);
            f1 = 0.0F;
            f2 = 0.0F;
            break label1458;
            if (y.bSu) {
              writeLog("ref_point," + arrayOfDouble2[0] + ',' + arrayOfDouble2[1] + ',' + arrayOfDouble2[2] + ',' + arrayOfDouble2[8]);
            }
            if (i1 > y.bSC) {
              break label1438;
            }
            f2 -= f4;
            if ((f2 <= 0.0F) || ((f1 - f3) * d2 / f2 > y.bSD)) {
              break label1438;
            }
            r.yP().bs(localStringBuilder.toString());
            paramBoolean = true;
            if (y.bSu)
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
            arrayOfFloat = (float[])this.bPN.get(i);
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
              if (y.bSu) {
                writeLog("scan_point," + arrayOfDouble4[0] + ',' + arrayOfDouble4[1] + ',' + arrayOfFloat[3]);
              }
              localObject1 = (String)this.bPM.get(i);
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
        d1 = ((float[])this.bPN.get(i))[2];
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
    if (this.bPQ != null) {
      this.bPQ.post(new d(paramp, (byte)0));
    }
    AppMethodBeat.o(88005);
  }
  
  private static void writeLog(String paramString)
  {
    AppMethodBeat.i(88006);
    o.t("post_processing_log_" + y.bSB, paramString);
    AppMethodBeat.o(88006);
  }
  
  private void za()
  {
    try
    {
      AppMethodBeat.i(88011);
      this.bPO.clear();
      AppMethodBeat.o(88011);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void zb()
  {
    try
    {
      AppMethodBeat.i(88012);
      this.bPM.clear();
      this.bPN.clear();
      AppMethodBeat.o(88012);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(88016);
        int j = this.bPO.size();
        int i = this.bPM.size();
        if (j <= 0)
        {
          this.bPO.add(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, i, paramDouble8 });
          i = 1;
          if (i != 0)
          {
            i = this.bPO.size();
            d(new e(i));
            if (i == 1) {
              zb();
            }
          }
          AppMethodBeat.o(88016);
          return;
        }
        double[] arrayOfDouble1 = (double[])this.bPO.get(j - 1);
        float[] arrayOfFloat;
        if (paramDouble8 - arrayOfDouble1[8] < 30000.0D)
        {
          if (paramDouble4 >= arrayOfDouble1[3])
          {
            arrayOfFloat = new float[1];
            arrayOfFloat[0] = 30.0F;
            if (j > 1)
            {
              double[] arrayOfDouble2 = (double[])this.bPO.get(j - 2);
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
            this.bPO.add(new double[] { paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, i, paramDouble8 });
            i = 1;
            if (j >= 8)
            {
              this.bPO.subList(0, 1).clear();
              this.bPO.trimToSize();
            }
            try
            {
              bl(false);
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
      this.bPM.add(paramString);
      this.bPN.add(new float[] { paramFloat1, paramFloat2, paramFloat3, 0.0F, paramInt, paramFloat4 });
      if (this.bPM.size() > 256)
      {
        this.bPM.subList(0, 1).clear();
        this.bPM.trimToSize();
        if (this.bPN.size() > 256)
        {
          this.bPN.subList(0, 1).clear();
          this.bPN.trimToSize();
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
    if (paramFloat < y.bSF)
    {
      AppMethodBeat.o(88015);
      return false;
    }
    if ((paramLong - this.bPK < 1000L) && (paramFloat <= this.bPL))
    {
      AppMethodBeat.o(88015);
      return false;
    }
    z.b(null).execute(new b(paramDouble1, paramDouble2, paramDouble3, paramFloat, paramDouble4, paramDouble5, paramDouble6, paramLong, (byte)0));
    this.bPK = paramLong;
    this.bPL = paramFloat;
    AppMethodBeat.o(88015);
    return true;
  }
  
  final void reset()
  {
    try
    {
      AppMethodBeat.i(88010);
      za();
      zb();
      AppMethodBeat.o(88010);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final void yX()
  {
    AppMethodBeat.i(88007);
    z.b(null).execute(new c((byte)0));
    AppMethodBeat.o(88007);
  }
  
  final void yY()
  {
    try
    {
      AppMethodBeat.i(88008);
      try
      {
        bl(true);
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
  
  final void yZ()
  {
    AppMethodBeat.i(88009);
    this.bPK = 0L;
    this.bPL = 0.0F;
    z.b(null).execute(new f((byte)0));
    AppMethodBeat.o(88009);
  }
  
  final class a
    implements Runnable
  {
    final int bOX;
    final float bPR;
    final float bPS;
    final String bPT;
    final float x;
    final float y;
    
    private a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, String paramString)
    {
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.bPR = paramFloat3;
      this.bPS = paramFloat4;
      this.bOX = paramInt;
      this.bPT = paramString;
    }
    
    public final void run()
    {
      AppMethodBeat.i(87999);
      s.this.a(this.x, this.y, this.bPR, this.bPS, this.bOX, this.bPT);
      AppMethodBeat.o(87999);
    }
  }
  
  final class b
    implements Runnable
  {
    final double bPV;
    final double bPW;
    final double bPX;
    final double bPY;
    final double bPZ;
    final double bQa;
    final double lat;
    final double lng;
    
    private b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
    {
      this.lat = paramDouble1;
      this.lng = paramDouble2;
      this.bPV = paramDouble3;
      this.bPW = paramDouble4;
      this.bPX = paramDouble5;
      this.bPY = paramDouble6;
      this.bPZ = paramDouble7;
      this.bQa = paramDouble8;
    }
    
    public final void run()
    {
      AppMethodBeat.i(88000);
      s.this.a(this.lat, this.lng, this.bPV, this.bPW, this.bPX, this.bPY, this.bPZ, this.bQa);
      AppMethodBeat.o(88000);
    }
  }
  
  final class c
    implements Runnable
  {
    private c() {}
    
    public final void run()
    {
      AppMethodBeat.i(88001);
      s.this.yY();
      AppMethodBeat.o(88001);
    }
  }
  
  final class d
    implements Runnable
  {
    private final p bMx;
    
    private d(p paramp)
    {
      this.bMx = paramp;
    }
    
    public final void run()
    {
      AppMethodBeat.i(88002);
      s.this.bPP.c(this.bMx);
      AppMethodBeat.o(88002);
    }
  }
  
  static final class e
    extends p
  {
    final int bQb;
    
    e(int paramInt)
    {
      super();
      this.bQb = paramInt;
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
    final boolean bQc;
    
    g(boolean paramBoolean)
    {
      super();
      this.bQc = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.c.a.a.s
 * JD-Core Version:    0.7.0.1
 */