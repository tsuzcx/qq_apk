package com.tencent.mm.modelstat;

import android.util.Pair;
import com.tencent.mm.a.h;
import com.tencent.mm.a.o;
import com.tencent.mm.bd.b.1;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import junit.framework.Assert;

public class e
{
  private static e eCI;
  private int eCJ = -1;
  private int eCK = 20000;
  private int eCL = 3000;
  private int eCM = 1000;
  private int eCN = 20;
  private ArrayList<Pair<Float, Float>> eCO = new ArrayList();
  private ArrayList<Pair<Float, Float>> eCP = new ArrayList();
  private long startTime = 0L;
  
  public static e Rq()
  {
    if (eCI == null) {}
    try
    {
      if (eCI == null) {
        eCI = new e();
      }
      return eCI;
    }
    finally {}
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, float paramFloat1, float paramFloat2, int paramInt2)
  {
    y.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.DN().Dc())
    {
      com.tencent.mm.kernel.g.DN();
      if (!a.CW()) {
        break label77;
      }
    }
    label267:
    for (;;)
    {
      return;
      label77:
      com.tencent.mm.bd.b localb = com.tencent.mm.bd.b.PQ();
      int i;
      if (paramBoolean2)
      {
        i = 1;
        if (com.tencent.mm.kernel.g.DN().Dc())
        {
          com.tencent.mm.kernel.g.DN();
          if (!a.CW()) {
            break label233;
          }
        }
      }
      for (;;)
      {
        if ((this.eCP.size() == 0) && (this.eCO.size() == 0) && (!ns(com.tencent.mm.m.g.AA().getValue("AndroidIndoorSensorReport")))) {
          break label267;
        }
        if (com.tencent.mm.sdk.a.b.cqk()) {
          break label269;
        }
        com.tencent.mm.kernel.g.DN();
        i = h.aT(a.CK() + 5, 100);
        if (i <= this.eCJ) {
          break label269;
        }
        com.tencent.mm.kernel.g.DN();
        y.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", new Object[] { Long.valueOf(new o(a.CK()).longValue()), Integer.valueOf(i), Integer.valueOf(this.eCJ) });
        return;
        i = 0;
        break;
        label233:
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DS().O(new b.1(localb, i, paramFloat1, paramFloat2, paramInt1, paramInt2, "", ""));
      }
    }
    label269:
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new e.1(this, paramBoolean2, paramFloat1, paramFloat2, paramInt1, paramBoolean1, paramInt2));
  }
  
  public final boolean ns(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        String[] arrayOfString1 = paramString.split(",");
        this.eCJ = bk.getInt(arrayOfString1[0], -1);
        if (this.eCJ > 101) {
          Assert.assertTrue(false);
        }
        this.eCK = bk.getInt(arrayOfString1[1], 20000);
        this.eCL = bk.getInt(arrayOfString1[2], 3000);
        this.eCM = bk.getInt(arrayOfString1[3], 1000);
        this.eCN = bk.getInt(arrayOfString1[4], 20);
        j = bk.getInt(arrayOfString1[5], 0);
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[(i + 6)].split(";");
          if ("1".equals(arrayOfString2[0])) {
            this.eCO.add(new Pair(Float.valueOf(bk.ZU(arrayOfString2[1])), Float.valueOf(bk.ZU(arrayOfString2[2]))));
          } else {
            this.eCP.add(new Pair(Float.valueOf(bk.ZU(arrayOfString2[1])), Float.valueOf(bk.ZU(arrayOfString2[2]))));
          }
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", new Object[] { localException.getMessage(), paramString });
        return false;
      }
      y.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", new Object[] { Integer.valueOf(this.eCK), Integer.valueOf(this.eCL), Integer.valueOf(this.eCM), Integer.valueOf(this.eCN), Integer.valueOf(j), Integer.valueOf(this.eCO.size()), Integer.valueOf(this.eCP.size()) });
      return true;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.e
 * JD-Core Version:    0.7.0.1
 */