package com.tencent.mm.modelstat;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import junit.framework.Assert;

public class e
{
  private static e fSz;
  private int fSA;
  private int fSB;
  private int fSC;
  private int fSD;
  private int fSE;
  private ArrayList<Pair<Float, Float>> fSF;
  private ArrayList<Pair<Float, Float>> fSG;
  private long startTime;
  
  public e()
  {
    AppMethodBeat.i(78726);
    this.startTime = 0L;
    this.fSA = -1;
    this.fSB = 20000;
    this.fSC = 3000;
    this.fSD = 1000;
    this.fSE = 20;
    this.fSF = new ArrayList();
    this.fSG = new ArrayList();
    AppMethodBeat.o(78726);
  }
  
  public static e akz()
  {
    AppMethodBeat.i(78727);
    if (fSz == null) {}
    try
    {
      if (fSz == null) {
        fSz = new e();
      }
      e locale = fSz;
      AppMethodBeat.o(78727);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(78727);
    }
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, float paramFloat1, float paramFloat2, int paramInt2)
  {
    AppMethodBeat.i(78728);
    ab.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.RJ().QU())
    {
      com.tencent.mm.kernel.g.RJ();
      if (!a.QP()) {}
    }
    else
    {
      AppMethodBeat.o(78728);
      return;
    }
    com.tencent.mm.be.b localb = com.tencent.mm.be.b.aiV();
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      localb.a(paramFloat1, paramFloat2, paramInt2, "", "", i, paramInt1);
      if ((this.fSG.size() != 0) || (this.fSF.size() != 0) || (uG(com.tencent.mm.m.g.Nq().getValue("AndroidIndoorSensorReport")))) {
        break;
      }
      AppMethodBeat.o(78728);
      return;
    }
    if (!com.tencent.mm.sdk.a.b.dsf())
    {
      com.tencent.mm.kernel.g.RJ();
      i = i.bQ(a.getUin() + 5, 100);
      if (i > this.fSA)
      {
        com.tencent.mm.kernel.g.RJ();
        ab.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", new Object[] { Long.valueOf(new p(a.getUin()).longValue()), Integer.valueOf(i), Integer.valueOf(this.fSA) });
        AppMethodBeat.o(78728);
        return;
      }
    }
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RO().ac(new e.1(this, paramBoolean2, paramFloat1, paramFloat2, paramInt1, paramBoolean1, paramInt2));
    AppMethodBeat.o(78728);
  }
  
  public final boolean uG(String paramString)
  {
    AppMethodBeat.i(78729);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(78729);
      return false;
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        String[] arrayOfString1 = paramString.split(",");
        this.fSA = bo.getInt(arrayOfString1[0], -1);
        if (this.fSA > 101) {
          Assert.assertTrue(false);
        }
        this.fSB = bo.getInt(arrayOfString1[1], 20000);
        this.fSC = bo.getInt(arrayOfString1[2], 3000);
        this.fSD = bo.getInt(arrayOfString1[3], 1000);
        this.fSE = bo.getInt(arrayOfString1[4], 20);
        j = bo.getInt(arrayOfString1[5], 0);
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[(i + 6)].split(";");
          if ("1".equals(arrayOfString2[0])) {
            this.fSF.add(new Pair(Float.valueOf(bo.apY(arrayOfString2[1])), Float.valueOf(bo.apY(arrayOfString2[2]))));
          } else {
            this.fSG.add(new Pair(Float.valueOf(bo.apY(arrayOfString2[1])), Float.valueOf(bo.apY(arrayOfString2[2]))));
          }
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", new Object[] { localException.getMessage(), paramString });
        AppMethodBeat.o(78729);
        return false;
      }
      ab.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", new Object[] { Integer.valueOf(this.fSB), Integer.valueOf(this.fSC), Integer.valueOf(this.fSD), Integer.valueOf(this.fSE), Integer.valueOf(j), Integer.valueOf(this.fSF.size()), Integer.valueOf(this.fSG.size()) });
      AppMethodBeat.o(78729);
      return true;
      i += 1;
    }
  }
  
  final class b
  {
    long ePF;
    long fST;
    e.a fSU;
    e.a fSV;
    e.a fSW;
    private Long fSX;
    ArrayList<Long> fSY;
    ArrayList<e.a> fSZ;
    ArrayList<e.a> fTa;
    ArrayList<e.a> fTb;
    ArrayList<float[]> fTc;
    private SensorEventListener fTd;
    private HandlerThread handlerThread;
    private SensorManager sensorManager;
    
    b()
    {
      AppMethodBeat.i(78719);
      this.fST = 0L;
      this.handlerThread = null;
      this.fSU = null;
      this.fSV = null;
      this.fSW = null;
      this.fSX = null;
      this.ePF = 0L;
      this.fSY = new ArrayList();
      this.fSZ = new ArrayList();
      this.fTa = new ArrayList();
      this.fTb = new ArrayList();
      this.fTc = new ArrayList();
      this.fTd = new e.b.1(this);
      AppMethodBeat.o(78719);
    }
    
    private static String a(e.a parama)
    {
      AppMethodBeat.i(78722);
      try
      {
        new String();
        parama = String.format("%d;%.3f;%.3f;%.3f;", new Object[] { Integer.valueOf(parama.accuracy), Float.valueOf(parama.values[0]), Float.valueOf(parama.values[1]), Float.valueOf(parama.values[2]) });
        AppMethodBeat.o(78722);
        return parama;
      }
      catch (Exception parama)
      {
        AppMethodBeat.o(78722);
      }
      return "0;0;0;0;";
    }
    
    public final String akA()
    {
      AppMethodBeat.i(78721);
      try
      {
        if (this.sensorManager != null)
        {
          this.sensorManager.unregisterListener(this.fTd);
          this.sensorManager = null;
        }
        try
        {
          label28:
          if (this.handlerThread != null)
          {
            this.handlerThread.quit();
            this.handlerThread = null;
          }
          label48:
          ab.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", new Object[] { Integer.valueOf(this.fSY.size()) });
          String str = this.fSX + ";" + this.fSY.size() + ";#";
          int i = 0;
          while (i < this.fSY.size())
          {
            str = str + (((Long)this.fSY.get(i)).longValue() - this.fSX.longValue()) + ";";
            str = str + a((e.a)this.fSZ.get(i));
            ab.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((e.a)this.fSZ.get(i)).accuracy), Float.valueOf(((e.a)this.fSZ.get(i)).values[0]), Float.valueOf(((e.a)this.fSZ.get(i)).values[1]), Float.valueOf(((e.a)this.fSZ.get(i)).values[2]), a((e.a)this.fSZ.get(i)) });
            str = str + a((e.a)this.fTb.get(i));
            str = str + a((e.a)this.fTa.get(i));
            str = str + String.format("%.3f;%.3f;%.3f;#", new Object[] { Float.valueOf(((float[])this.fTc.get(i))[0]), Float.valueOf(((float[])this.fTc.get(i))[1]), Float.valueOf(((float[])this.fTc.get(i))[2]) });
            i += 1;
          }
          ab.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", new Object[] { Integer.valueOf(str.length()), str });
          AppMethodBeat.o(78721);
          return str;
        }
        catch (Exception localException1)
        {
          break label48;
        }
      }
      catch (Exception localException2)
      {
        break label28;
      }
    }
    
    public final boolean ma(int paramInt)
    {
      AppMethodBeat.i(151569);
      try
      {
        if (this.sensorManager == null) {
          this.sensorManager = ((SensorManager)ah.getContext().getSystemService("sensor"));
        }
        if (this.handlerThread == null)
        {
          this.handlerThread = d.ey("MicroMsg.IndoorReporter", 1);
          this.handlerThread.start();
        }
        Handler localHandler = new Handler(this.handlerThread.getLooper());
        bool1 = this.sensorManager.registerListener(this.fTd, this.sensorManager.getDefaultSensor(1), 3, localHandler);
        boolean bool2 = this.sensorManager.registerListener(this.fTd, this.sensorManager.getDefaultSensor(4), 3, localHandler);
        boolean bool3 = this.sensorManager.registerListener(this.fTd, this.sensorManager.getDefaultSensor(2), 3, localHandler);
        if ((!bool1) || (!bool2) || (!bool3)) {
          break label222;
        }
        bool1 = true;
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            boolean bool1;
            if (this.sensorManager == null) {
              break label179;
            }
            this.sensorManager.unregisterListener(this.fTd);
            this.sensorManager = null;
            try
            {
              if (this.handlerThread == null) {
                break label199;
              }
              this.handlerThread.quit();
              this.handlerThread = null;
              this.fST = paramInt;
              this.fSX = Long.valueOf(bo.aoy());
              AppMethodBeat.o(151569);
              return bool1;
              bool1 = false;
              continue;
              localException1 = localException1;
              ab.e("MicroMsg.IndoorReporter", "start except:%s", new Object[] { localException1.getMessage() });
              bool1 = false;
            }
            catch (Exception localException2)
            {
              break label199;
            }
          }
        }
        catch (Exception localException3)
        {
          break label179;
        }
      }
      if (bool1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.e
 * JD-Core Version:    0.7.0.1
 */