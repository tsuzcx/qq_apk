package com.tencent.mm.modelstat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e
{
  private static e hvi;
  private int hvj;
  private int hvk;
  private int hvl;
  private int hvm;
  private int hvn;
  private ArrayList<Pair<Float, Float>> hvo;
  private ArrayList<Pair<Float, Float>> hvp;
  private long startTime;
  
  public e()
  {
    AppMethodBeat.i(151070);
    this.startTime = 0L;
    this.hvj = -1;
    this.hvk = 20000;
    this.hvl = 3000;
    this.hvm = 1000;
    this.hvn = 20;
    this.hvo = new ArrayList();
    this.hvp = new ArrayList();
    AppMethodBeat.o(151070);
  }
  
  public static e aBE()
  {
    AppMethodBeat.i(151071);
    if (hvi == null) {}
    try
    {
      if (hvi == null) {
        hvi = new e();
      }
      e locale = hvi;
      AppMethodBeat.o(151071);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(151071);
    }
  }
  
  public final void a(final int paramInt1, final boolean paramBoolean1, final boolean paramBoolean2, final float paramFloat1, final float paramFloat2, final int paramInt2)
  {
    AppMethodBeat.i(151072);
    ad.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.afz().aeI())
    {
      com.tencent.mm.kernel.g.afz();
      if (!a.aeC()) {}
    }
    else
    {
      AppMethodBeat.o(151072);
      return;
    }
    com.tencent.mm.bg.b localb = com.tencent.mm.bg.b.aAe();
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      localb.a(paramFloat1, paramFloat2, paramInt2, "", "", i, paramInt1);
      if ((this.hvp.size() != 0) || (this.hvo.size() != 0) || (zt(com.tencent.mm.m.g.Zd().getValue("AndroidIndoorSensorReport")))) {
        break;
      }
      AppMethodBeat.o(151072);
      return;
    }
    if (!com.tencent.mm.sdk.a.b.eEQ())
    {
      com.tencent.mm.kernel.g.afz();
      i = com.tencent.mm.b.i.cf(a.getUin() + 5, 100);
      if (i > this.hvj)
      {
        com.tencent.mm.kernel.g.afz();
        ad.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", new Object[] { Long.valueOf(new p(a.getUin()).longValue()), Integer.valueOf(i), Integer.valueOf(this.hvj) });
        AppMethodBeat.o(151072);
        return;
      }
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afE().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151060);
        for (;;)
        {
          try
          {
            boolean bool;
            if (com.tencent.mm.kernel.g.afz().aeI())
            {
              com.tencent.mm.kernel.g.afz();
              bool = a.aeC();
              if (!bool) {}
            }
            else
            {
              AppMethodBeat.o(151060);
              return;
            }
            long l = bt.eGO();
            if ((e.a(e.this) != 0L) && (l - e.a(e.this) < 1800000L))
            {
              ad.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", new Object[] { Long.valueOf(l - e.a(e.this)) });
              AppMethodBeat.o(151060);
              return;
            }
            if (paramBoolean2)
            {
              localObject1 = e.b(e.this);
              break label738;
              if (i >= ((List)localObject1).size()) {
                break label732;
              }
              if ((!e.x(paramFloat1, ((Float)((Pair)((List)localObject1).get(i)).first).floatValue())) || (!e.x(paramFloat2, ((Float)((Pair)((List)localObject1).get(i)).second).floatValue()))) {
                break label743;
              }
              localObject1 = (Pair)((List)localObject1).get(i);
              if (localObject1 == null)
              {
                ad.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
                AppMethodBeat.o(151060);
              }
            }
            else
            {
              localObject1 = e.c(e.this);
              break label738;
            }
            e.a(e.this, l);
            Object localObject3 = new StringBuilder();
            com.tencent.mm.kernel.g.afz();
            localObject3 = new p(a.getUin()).toString() + "_" + e.a(e.this);
            Object localObject1 = new StringBuilder().append(((Pair)localObject1).first).append(",").append(((Pair)localObject1).second).append(",").append(paramInt1).append(",");
            final e.c localc;
            Object localObject4;
            if (paramBoolean1)
            {
              i = 1;
              if (paramBoolean2)
              {
                j = 10;
                localObject1 = j + i + "," + paramFloat1 + "," + paramFloat2 + ",0," + paramInt2 + "," + e.a(e.this) + ",";
                localc = new e.c(e.this);
                localObject4 = aj.getContext();
                i = e.d(e.this);
                j = e.e(e.this);
                if (localc.bVj == null) {
                  localc.bVj = ((WifiManager)((Context)localObject4).getSystemService("wifi"));
                }
                localc.hvO = i;
                localc.hvn = j;
                localc.startTime = bt.eGO();
                localc.hvP = true;
                localc.daz = com.tencent.e.h.Iye.aS(localc.cvK);
                localObject4 = new e.b(e.this);
                aj.getContext();
                bool = ((e.b)localObject4).oJ(e.f(e.this));
                if (bool) {
                  continue;
                }
                ad.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", new Object[] { Boolean.TRUE, Boolean.valueOf(bool) });
                ((e.b)localObject4).aBF();
                localc.aBF();
                com.tencent.mm.plugin.report.service.h.vKh.kvStat(13381, (String)localObject1 + (String)localObject3 + ",-10002,ERROR:StartFailed.");
                AppMethodBeat.o(151060);
              }
            }
            else
            {
              i = 2;
              continue;
            }
            int j = 20;
            continue;
            com.tencent.mm.kernel.g.afC();
            new av(com.tencent.mm.kernel.g.afE().EUN.getLooper(), new av.a()
            {
              boolean hvw = false;
              
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(151059);
                boolean bool = q.cB(aj.getContext());
                long l1 = bt.eGO();
                long l2 = l1 - e.a(e.this);
                if (l2 <= e.g(e.this))
                {
                  if (bool)
                  {
                    this.hvw = false;
                    AppMethodBeat.o(151059);
                    return true;
                  }
                  if (!this.hvw)
                  {
                    this.hvw = true;
                    AppMethodBeat.o(151059);
                    return true;
                  }
                }
                ad.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", new Object[] { Boolean.valueOf(this.hvw), Boolean.valueOf(bool), Long.valueOf(l2) });
                e.a(e.this, 0L);
                String str = this.hvx.aBF();
                Object localObject = localc.aBF();
                try
                {
                  StringBuilder localStringBuilder;
                  if ((bt.isNullOrNil(str)) || (bt.isNullOrNil((String)localObject)))
                  {
                    ad.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", new Object[] { str, localObject });
                    localObject = com.tencent.mm.plugin.report.service.h.vKh;
                    localStringBuilder = new StringBuilder().append(this.hvz).append(this.hvA);
                    if (!bt.isNullOrNil(str)) {}
                    for (str = ",-10011,ERROR:StopFailed.";; str = ",-10012,ERROR:StopFailed.")
                    {
                      ((com.tencent.mm.plugin.report.service.h)localObject).kvStat(13381, str);
                      AppMethodBeat.o(151059);
                      return false;
                    }
                  }
                  localObject = str + (String)localObject;
                  int j = (int)Math.ceil(((String)localObject).length() / 5400.0D);
                  int i = 0;
                  if (i < j)
                  {
                    localStringBuilder = new StringBuilder().append(this.hvz).append(this.hvA).append("_").append(l1).append("_").append(j).append("_");
                    if (l2 > e.g(e.this)) {}
                    for (str = "1";; str = "2")
                    {
                      str = str + "," + (i + 1) + "," + ((String)localObject).substring(i * 5400, Math.min((i + 1) * 5400, ((String)localObject).length()));
                      ad.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((String)localObject).length()), Integer.valueOf(str.length()), str });
                      com.tencent.mm.plugin.report.service.h.vKh.kvStat(13381, str);
                      i += 1;
                      break;
                    }
                  }
                  return false;
                }
                catch (Exception localException)
                {
                  ad.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", new Object[] { localException.getMessage() });
                  AppMethodBeat.o(151059);
                }
              }
            }, true).av(3000L, 3000L);
            AppMethodBeat.o(151060);
            return;
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(151060);
            return;
          }
          label732:
          Object localObject2 = null;
          continue;
          label738:
          int i = 0;
          continue;
          label743:
          i += 1;
        }
      }
    });
    AppMethodBeat.o(151072);
  }
  
  public final boolean zt(String paramString)
  {
    AppMethodBeat.i(151073);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(151073);
      return false;
    }
    for (;;)
    {
      int j;
      int i;
      try
      {
        String[] arrayOfString1 = paramString.split(",");
        this.hvj = bt.getInt(arrayOfString1[0], -1);
        if (this.hvj > 101) {
          Assert.assertTrue(false);
        }
        this.hvk = bt.getInt(arrayOfString1[1], 20000);
        this.hvl = bt.getInt(arrayOfString1[2], 3000);
        this.hvm = bt.getInt(arrayOfString1[3], 1000);
        this.hvn = bt.getInt(arrayOfString1[4], 20);
        j = bt.getInt(arrayOfString1[5], 0);
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[(i + 6)].split(";");
          if ("1".equals(arrayOfString2[0])) {
            this.hvo.add(new Pair(Float.valueOf(bt.aGk(arrayOfString2[1])), Float.valueOf(bt.aGk(arrayOfString2[2]))));
          } else {
            this.hvp.add(new Pair(Float.valueOf(bt.aGk(arrayOfString2[1])), Float.valueOf(bt.aGk(arrayOfString2[2]))));
          }
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", new Object[] { localException.getMessage(), paramString });
        AppMethodBeat.o(151073);
        return false;
      }
      ad.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", new Object[] { Integer.valueOf(this.hvk), Integer.valueOf(this.hvl), Integer.valueOf(this.hvm), Integer.valueOf(this.hvn), Integer.valueOf(j), Integer.valueOf(this.hvo.size()), Integer.valueOf(this.hvp.size()) });
      AppMethodBeat.o(151073);
      return true;
      i += 1;
    }
  }
  
  static final class a
  {
    public int accuracy;
    public float[] values;
    
    public a(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(151061);
      this.accuracy = 0;
      if (paramSensorEvent != null)
      {
        this.accuracy = paramSensorEvent.accuracy;
        this.values = new float[paramSensorEvent.values.length];
        System.arraycopy(paramSensorEvent.values, 0, this.values, 0, paramSensorEvent.values.length);
      }
      AppMethodBeat.o(151061);
    }
  }
  
  final class b
  {
    long glk;
    private HandlerThread handlerThread;
    long hvC;
    e.a hvD;
    e.a hvE;
    e.a hvF;
    private Long hvG;
    ArrayList<Long> hvH;
    ArrayList<e.a> hvI;
    ArrayList<e.a> hvJ;
    ArrayList<e.a> hvK;
    ArrayList<float[]> hvL;
    private SensorEventListener hvM;
    private SensorManager sensorManager;
    
    b()
    {
      AppMethodBeat.i(151063);
      this.hvC = 0L;
      this.handlerThread = null;
      this.hvD = null;
      this.hvE = null;
      this.hvF = null;
      this.hvG = null;
      this.glk = 0L;
      this.hvH = new ArrayList();
      this.hvI = new ArrayList();
      this.hvJ = new ArrayList();
      this.hvK = new ArrayList();
      this.hvL = new ArrayList();
      this.hvM = new SensorEventListener()
      {
        public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
        
        public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
        {
          AppMethodBeat.i(151062);
          if (paramAnonymousSensorEvent == null)
          {
            AppMethodBeat.o(151062);
            return;
          }
          long l1 = bt.eGO();
          if (paramAnonymousSensorEvent.sensor.getType() == 1) {
            e.b.this.hvD = new e.a(paramAnonymousSensorEvent);
          }
          for (;;)
          {
            long l2 = l1 - e.b.this.glk;
            if ((e.b.this.hvD != null) && (e.b.this.hvE != null) && (e.b.this.hvF != null) && ((l2 > e.b.this.hvC) || (l2 < 0L)))
            {
              paramAnonymousSensorEvent = new float[9];
              SensorManager.getRotationMatrix(paramAnonymousSensorEvent, null, e.b.this.hvD.values, e.b.this.hvE.values);
              float[] arrayOfFloat = new float[3];
              SensorManager.getOrientation(paramAnonymousSensorEvent, arrayOfFloat);
              e.b.this.glk = l1;
              e.b.this.hvH.add(Long.valueOf(l1));
              e.b.this.hvI.add(e.b.this.hvD);
              e.b.this.hvJ.add(e.b.this.hvE);
              e.b.this.hvK.add(e.b.this.hvF);
              e.b.this.hvL.add(arrayOfFloat);
              int i = e.b.this.hvI.size() - 1;
              ad.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", new Object[] { Integer.valueOf(e.b.this.hvI.size()), Integer.valueOf(((e.a)e.b.this.hvI.get(i)).accuracy), Float.valueOf(((e.a)e.b.this.hvI.get(i)).values[0]), Float.valueOf(((e.a)e.b.this.hvI.get(i)).values[1]), Float.valueOf(((e.a)e.b.this.hvI.get(i)).values[2]) });
              ad.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", new Object[] { Long.valueOf(l2), Integer.valueOf(e.b.this.hvD.accuracy), Float.valueOf(e.b.this.hvD.values[0]), Float.valueOf(e.b.this.hvD.values[1]), Float.valueOf(e.b.this.hvD.values[2]), Integer.valueOf(e.b.this.hvE.accuracy), Float.valueOf(e.b.this.hvE.values[0]), Float.valueOf(e.b.this.hvE.values[1]), Float.valueOf(e.b.this.hvE.values[2]), Integer.valueOf(e.b.this.hvF.accuracy), Float.valueOf(e.b.this.hvF.values[0]), Float.valueOf(e.b.this.hvF.values[1]), Float.valueOf(e.b.this.hvF.values[2]), Float.valueOf(arrayOfFloat[0]), Float.valueOf(arrayOfFloat[1]), Float.valueOf(arrayOfFloat[2]) });
            }
            AppMethodBeat.o(151062);
            return;
            if (paramAnonymousSensorEvent.sensor.getType() == 2) {
              e.b.this.hvE = new e.a(paramAnonymousSensorEvent);
            } else if (paramAnonymousSensorEvent.sensor.getType() == 4) {
              e.b.this.hvF = new e.a(paramAnonymousSensorEvent);
            }
          }
        }
      };
      AppMethodBeat.o(151063);
    }
    
    private static String a(e.a parama)
    {
      AppMethodBeat.i(151066);
      try
      {
        new String();
        parama = String.format("%d;%.3f;%.3f;%.3f;", new Object[] { Integer.valueOf(parama.accuracy), Float.valueOf(parama.values[0]), Float.valueOf(parama.values[1]), Float.valueOf(parama.values[2]) });
        AppMethodBeat.o(151066);
        return parama;
      }
      catch (Exception parama)
      {
        AppMethodBeat.o(151066);
      }
      return "0;0;0;0;";
    }
    
    public final String aBF()
    {
      AppMethodBeat.i(151065);
      try
      {
        if (this.sensorManager != null)
        {
          this.sensorManager.unregisterListener(this.hvM);
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
          ad.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", new Object[] { Integer.valueOf(this.hvH.size()) });
          String str = this.hvG + ";" + this.hvH.size() + ";#";
          int i = 0;
          while (i < this.hvH.size())
          {
            str = str + (((Long)this.hvH.get(i)).longValue() - this.hvG.longValue()) + ";";
            str = str + a((e.a)this.hvI.get(i));
            ad.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((e.a)this.hvI.get(i)).accuracy), Float.valueOf(((e.a)this.hvI.get(i)).values[0]), Float.valueOf(((e.a)this.hvI.get(i)).values[1]), Float.valueOf(((e.a)this.hvI.get(i)).values[2]), a((e.a)this.hvI.get(i)) });
            str = str + a((e.a)this.hvK.get(i));
            str = str + a((e.a)this.hvJ.get(i));
            str = str + String.format("%.3f;%.3f;%.3f;#", new Object[] { Float.valueOf(((float[])this.hvL.get(i))[0]), Float.valueOf(((float[])this.hvL.get(i))[1]), Float.valueOf(((float[])this.hvL.get(i))[2]) });
            i += 1;
          }
          ad.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", new Object[] { Integer.valueOf(str.length()), str });
          AppMethodBeat.o(151065);
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
    
    public final boolean oJ(int paramInt)
    {
      AppMethodBeat.i(151064);
      try
      {
        if (this.sensorManager == null) {
          this.sensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
        }
        if (this.handlerThread == null)
        {
          this.handlerThread = d.gy("MicroMsg.IndoorReporter", 1);
          this.handlerThread.start();
        }
        Handler localHandler = new Handler(this.handlerThread.getLooper());
        bool1 = this.sensorManager.registerListener(this.hvM, this.sensorManager.getDefaultSensor(1), 3, localHandler);
        boolean bool2 = this.sensorManager.registerListener(this.hvM, this.sensorManager.getDefaultSensor(4), 3, localHandler);
        boolean bool3 = this.sensorManager.registerListener(this.hvM, this.sensorManager.getDefaultSensor(2), 3, localHandler);
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
            this.sensorManager.unregisterListener(this.hvM);
            this.sensorManager = null;
            try
            {
              if (this.handlerThread == null) {
                break label199;
              }
              this.handlerThread.quit();
              this.handlerThread = null;
              this.hvC = paramInt;
              this.hvG = Long.valueOf(bt.eGO());
              AppMethodBeat.o(151064);
              return bool1;
              bool1 = false;
              continue;
              localException1 = localException1;
              ad.e("MicroMsg.IndoorReporter", "start except:%s", new Object[] { localException1.getMessage() });
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
  
  final class c
  {
    WifiManager bVj;
    Runnable cvK;
    Future daz;
    int hvO;
    boolean hvP;
    List<String> hvQ;
    int hvn;
    long startTime;
    
    c()
    {
      AppMethodBeat.i(151068);
      this.hvO = 0;
      this.hvn = 0;
      this.hvP = false;
      this.startTime = 0L;
      this.hvQ = new ArrayList();
      this.cvK = new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "MicroMsg.IndoorReporter_WIFI_Scan";
        }
        
        public final void run()
        {
          AppMethodBeat.i(151067);
          ad.i("MicroMsg.IndoorReporter", "start wifi");
          for (;;)
          {
            int k;
            int i;
            try
            {
              if (!e.c.this.hvP) {
                break label411;
              }
              long l = bt.eGO();
              List localList = e.c.this.bVj.getScanResults();
              Object localObject1 = "";
              if ((localList == null) || (localList.size() <= 0)) {
                break label420;
              }
              Collections.sort(localList, new Comparator() {});
              k = 0;
              i = 0;
              j = i;
              localObject2 = localObject1;
              if (k < localList.size())
              {
                localObject2 = (ScanResult)localList.get(k);
                if ((localObject2 == null) || (bt.isNullOrNil(((ScanResult)localObject2).BSSID)) || (bt.isNullOrNil(((ScanResult)localObject2).SSID))) {
                  break label417;
                }
                String str = ((ScanResult)localObject2).SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "");
                localObject2 = (String)localObject1 + str + ";" + ((ScanResult)localObject2).BSSID + ";" + ((ScanResult)localObject2).level + ";";
                i += 1;
                if (i >= e.c.this.hvn) {
                  break label436;
                }
                localObject1 = localObject2;
                break label429;
              }
              localObject1 = new StringBuilder().append(l - e.c.this.startTime).append(";");
              if (localList != null)
              {
                i = localList.size();
                localObject1 = i + ";" + j + ";" + (String)localObject2;
                ad.i("MicroMsg.IndoorReporter", "%d %s", new Object[] { Integer.valueOf(((String)localObject1).length()), localObject1 });
                e.c.this.hvQ.add(localObject1);
                e.c.this.bVj.startScan();
                Thread.sleep(e.c.this.hvO);
                continue;
              }
              i = 0;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.IndoorReporter", "Except:%s", new Object[] { localException.getMessage() });
              AppMethodBeat.o(151067);
              return;
            }
            continue;
            label411:
            AppMethodBeat.o(151067);
            return;
            label417:
            break label429;
            label420:
            int j = 0;
            Object localObject2 = localException;
            continue;
            label429:
            k += 1;
            continue;
            label436:
            j = i;
          }
        }
      };
      AppMethodBeat.o(151068);
    }
    
    public final String aBF()
    {
      AppMethodBeat.i(151069);
      this.hvP = false;
      try
      {
        if ((this.daz != null) && (!this.daz.isDone())) {
          this.daz.get(500L, TimeUnit.MILLISECONDS);
        }
        String str = this.hvQ.size() + ";#";
        int i = 0;
        while (i < this.hvQ.size())
        {
          str = str + (String)this.hvQ.get(i) + "#";
          i += 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", new Object[] { localException.getMessage() });
        }
        AppMethodBeat.o(151069);
        return localException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.e
 * JD-Core Version:    0.7.0.1
 */