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
import com.tencent.mm.sdk.platformtools.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e
{
  private static e ipe;
  private int ipf;
  private int ipg;
  private int iph;
  private int ipi;
  private int ipj;
  private ArrayList<Pair<Float, Float>> ipk;
  private ArrayList<Pair<Float, Float>> ipl;
  private long startTime;
  
  public e()
  {
    AppMethodBeat.i(151070);
    this.startTime = 0L;
    this.ipf = -1;
    this.ipg = 20000;
    this.iph = 3000;
    this.ipi = 1000;
    this.ipj = 20;
    this.ipk = new ArrayList();
    this.ipl = new ArrayList();
    AppMethodBeat.o(151070);
  }
  
  public static e aLE()
  {
    AppMethodBeat.i(151071);
    if (ipe == null) {}
    try
    {
      if (ipe == null) {
        ipe = new e();
      }
      e locale = ipe;
      AppMethodBeat.o(151071);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(151071);
    }
  }
  
  public final boolean GD(String paramString)
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
        this.ipf = bt.getInt(arrayOfString1[0], -1);
        if (this.ipf > 101) {
          Assert.assertTrue(false);
        }
        this.ipg = bt.getInt(arrayOfString1[1], 20000);
        this.iph = bt.getInt(arrayOfString1[2], 3000);
        this.ipi = bt.getInt(arrayOfString1[3], 1000);
        this.ipj = bt.getInt(arrayOfString1[4], 20);
        j = bt.getInt(arrayOfString1[5], 0);
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[(i + 6)].split(";");
          if ("1".equals(arrayOfString2[0])) {
            this.ipk.add(new Pair(Float.valueOf(bt.aRh(arrayOfString2[1])), Float.valueOf(bt.aRh(arrayOfString2[2]))));
          } else {
            this.ipl.add(new Pair(Float.valueOf(bt.aRh(arrayOfString2[1])), Float.valueOf(bt.aRh(arrayOfString2[2]))));
          }
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", new Object[] { localException.getMessage(), paramString });
        AppMethodBeat.o(151073);
        return false;
      }
      ad.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", new Object[] { Integer.valueOf(this.ipg), Integer.valueOf(this.iph), Integer.valueOf(this.ipi), Integer.valueOf(this.ipj), Integer.valueOf(j), Integer.valueOf(this.ipk.size()), Integer.valueOf(this.ipl.size()) });
      AppMethodBeat.o(151073);
      return true;
      i += 1;
    }
  }
  
  public final void a(final int paramInt1, final boolean paramBoolean1, final boolean paramBoolean2, final float paramFloat1, final float paramFloat2, final int paramInt2)
  {
    AppMethodBeat.i(151072);
    ad.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.ajA().aiK())
    {
      com.tencent.mm.kernel.g.ajA();
      if (!a.aiE()) {}
    }
    else
    {
      AppMethodBeat.o(151072);
      return;
    }
    com.tencent.mm.bg.b localb = com.tencent.mm.bg.b.aKf();
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      localb.a(paramFloat1, paramFloat2, paramInt2, "", "", i, paramInt1);
      if ((this.ipl.size() != 0) || (this.ipk.size() != 0) || (GD(com.tencent.mm.n.g.acA().getValue("AndroidIndoorSensorReport")))) {
        break;
      }
      AppMethodBeat.o(151072);
      return;
    }
    if (!com.tencent.mm.sdk.a.b.fjN())
    {
      com.tencent.mm.kernel.g.ajA();
      i = com.tencent.mm.b.i.ce(a.getUin() + 5, 100);
      if (i > this.ipf)
      {
        com.tencent.mm.kernel.g.ajA();
        ad.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", new Object[] { Long.valueOf(new p(a.getUin()).longValue()), Integer.valueOf(i), Integer.valueOf(this.ipf) });
        AppMethodBeat.o(151072);
        return;
      }
    }
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajF().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151060);
        for (;;)
        {
          try
          {
            boolean bool;
            if (com.tencent.mm.kernel.g.ajA().aiK())
            {
              com.tencent.mm.kernel.g.ajA();
              bool = a.aiE();
              if (!bool) {}
            }
            else
            {
              AppMethodBeat.o(151060);
              return;
            }
            long l = bt.flT();
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
              if ((!e.B(paramFloat1, ((Float)((Pair)((List)localObject1).get(i)).first).floatValue())) || (!e.B(paramFloat2, ((Float)((Pair)((List)localObject1).get(i)).second).floatValue()))) {
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
            com.tencent.mm.kernel.g.ajA();
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
                if (localc.cde == null) {
                  localc.cde = ((WifiManager)((Context)localObject4).getSystemService("wifi"));
                }
                localc.ipK = i;
                localc.ipj = j;
                localc.startTime = bt.flT();
                localc.ipL = true;
                localc.djn = com.tencent.e.h.LTJ.aU(localc.cDO);
                localObject4 = new e.b(e.this);
                aj.getContext();
                bool = ((e.b)localObject4).qa(e.f(e.this));
                if (bool) {
                  continue;
                }
                ad.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", new Object[] { Boolean.TRUE, Boolean.valueOf(bool) });
                ((e.b)localObject4).aLF();
                localc.aLF();
                com.tencent.mm.plugin.report.service.g.yhR.kvStat(13381, (String)localObject1 + (String)localObject3 + ",-10002,ERROR:StartFailed.");
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
            com.tencent.mm.kernel.g.ajD();
            new av(com.tencent.mm.kernel.g.ajF().IdO.getLooper(), new av.a()
            {
              boolean ips = false;
              
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(151059);
                boolean bool = r.cH(aj.getContext());
                long l1 = bt.flT();
                long l2 = l1 - e.a(e.this);
                if (l2 <= e.g(e.this))
                {
                  if (bool)
                  {
                    this.ips = false;
                    AppMethodBeat.o(151059);
                    return true;
                  }
                  if (!this.ips)
                  {
                    this.ips = true;
                    AppMethodBeat.o(151059);
                    return true;
                  }
                }
                ad.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", new Object[] { Boolean.valueOf(this.ips), Boolean.valueOf(bool), Long.valueOf(l2) });
                e.a(e.this, 0L);
                String str = this.ipt.aLF();
                Object localObject = localc.aLF();
                try
                {
                  StringBuilder localStringBuilder;
                  if ((bt.isNullOrNil(str)) || (bt.isNullOrNil((String)localObject)))
                  {
                    ad.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", new Object[] { str, localObject });
                    localObject = com.tencent.mm.plugin.report.service.g.yhR;
                    localStringBuilder = new StringBuilder().append(this.ipv).append(this.ipw);
                    if (!bt.isNullOrNil(str)) {}
                    for (str = ",-10011,ERROR:StopFailed.";; str = ",-10012,ERROR:StopFailed.")
                    {
                      ((com.tencent.mm.plugin.report.service.g)localObject).kvStat(13381, str);
                      AppMethodBeat.o(151059);
                      return false;
                    }
                  }
                  localObject = str + (String)localObject;
                  int j = (int)Math.ceil(((String)localObject).length() / 5400.0D);
                  int i = 0;
                  if (i < j)
                  {
                    localStringBuilder = new StringBuilder().append(this.ipv).append(this.ipw).append("_").append(l1).append("_").append(j).append("_");
                    if (l2 > e.g(e.this)) {}
                    for (str = "1";; str = "2")
                    {
                      str = str + "," + (i + 1) + "," + ((String)localObject).substring(i * 5400, Math.min((i + 1) * 5400, ((String)localObject).length()));
                      ad.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((String)localObject).length()), Integer.valueOf(str.length()), str });
                      com.tencent.mm.plugin.report.service.g.yhR.kvStat(13381, str);
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
            }, true).az(3000L, 3000L);
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
    private HandlerThread handlerThread;
    long hfU;
    e.a ipA;
    e.a ipB;
    private Long ipC;
    ArrayList<Long> ipD;
    ArrayList<e.a> ipE;
    ArrayList<e.a> ipF;
    ArrayList<e.a> ipG;
    ArrayList<float[]> ipH;
    private SensorEventListener ipI;
    long ipy;
    e.a ipz;
    private SensorManager sensorManager;
    
    b()
    {
      AppMethodBeat.i(151063);
      this.ipy = 0L;
      this.handlerThread = null;
      this.ipz = null;
      this.ipA = null;
      this.ipB = null;
      this.ipC = null;
      this.hfU = 0L;
      this.ipD = new ArrayList();
      this.ipE = new ArrayList();
      this.ipF = new ArrayList();
      this.ipG = new ArrayList();
      this.ipH = new ArrayList();
      this.ipI = new SensorEventListener()
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
          long l1 = bt.flT();
          if (paramAnonymousSensorEvent.sensor.getType() == 1) {
            e.b.this.ipz = new e.a(paramAnonymousSensorEvent);
          }
          for (;;)
          {
            long l2 = l1 - e.b.this.hfU;
            if ((e.b.this.ipz != null) && (e.b.this.ipA != null) && (e.b.this.ipB != null) && ((l2 > e.b.this.ipy) || (l2 < 0L)))
            {
              paramAnonymousSensorEvent = new float[9];
              SensorManager.getRotationMatrix(paramAnonymousSensorEvent, null, e.b.this.ipz.values, e.b.this.ipA.values);
              float[] arrayOfFloat = new float[3];
              SensorManager.getOrientation(paramAnonymousSensorEvent, arrayOfFloat);
              e.b.this.hfU = l1;
              e.b.this.ipD.add(Long.valueOf(l1));
              e.b.this.ipE.add(e.b.this.ipz);
              e.b.this.ipF.add(e.b.this.ipA);
              e.b.this.ipG.add(e.b.this.ipB);
              e.b.this.ipH.add(arrayOfFloat);
              int i = e.b.this.ipE.size() - 1;
              ad.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", new Object[] { Integer.valueOf(e.b.this.ipE.size()), Integer.valueOf(((e.a)e.b.this.ipE.get(i)).accuracy), Float.valueOf(((e.a)e.b.this.ipE.get(i)).values[0]), Float.valueOf(((e.a)e.b.this.ipE.get(i)).values[1]), Float.valueOf(((e.a)e.b.this.ipE.get(i)).values[2]) });
              ad.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", new Object[] { Long.valueOf(l2), Integer.valueOf(e.b.this.ipz.accuracy), Float.valueOf(e.b.this.ipz.values[0]), Float.valueOf(e.b.this.ipz.values[1]), Float.valueOf(e.b.this.ipz.values[2]), Integer.valueOf(e.b.this.ipA.accuracy), Float.valueOf(e.b.this.ipA.values[0]), Float.valueOf(e.b.this.ipA.values[1]), Float.valueOf(e.b.this.ipA.values[2]), Integer.valueOf(e.b.this.ipB.accuracy), Float.valueOf(e.b.this.ipB.values[0]), Float.valueOf(e.b.this.ipB.values[1]), Float.valueOf(e.b.this.ipB.values[2]), Float.valueOf(arrayOfFloat[0]), Float.valueOf(arrayOfFloat[1]), Float.valueOf(arrayOfFloat[2]) });
            }
            AppMethodBeat.o(151062);
            return;
            if (paramAnonymousSensorEvent.sensor.getType() == 2) {
              e.b.this.ipA = new e.a(paramAnonymousSensorEvent);
            } else if (paramAnonymousSensorEvent.sensor.getType() == 4) {
              e.b.this.ipB = new e.a(paramAnonymousSensorEvent);
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
    
    public final String aLF()
    {
      AppMethodBeat.i(151065);
      try
      {
        if (this.sensorManager != null)
        {
          this.sensorManager.unregisterListener(this.ipI);
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
          ad.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", new Object[] { Integer.valueOf(this.ipD.size()) });
          String str = this.ipC + ";" + this.ipD.size() + ";#";
          int i = 0;
          while (i < this.ipD.size())
          {
            str = str + (((Long)this.ipD.get(i)).longValue() - this.ipC.longValue()) + ";";
            str = str + a((e.a)this.ipE.get(i));
            ad.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((e.a)this.ipE.get(i)).accuracy), Float.valueOf(((e.a)this.ipE.get(i)).values[0]), Float.valueOf(((e.a)this.ipE.get(i)).values[1]), Float.valueOf(((e.a)this.ipE.get(i)).values[2]), a((e.a)this.ipE.get(i)) });
            str = str + a((e.a)this.ipG.get(i));
            str = str + a((e.a)this.ipF.get(i));
            str = str + String.format("%.3f;%.3f;%.3f;#", new Object[] { Float.valueOf(((float[])this.ipH.get(i))[0]), Float.valueOf(((float[])this.ipH.get(i))[1]), Float.valueOf(((float[])this.ipH.get(i))[2]) });
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
    
    public final boolean qa(int paramInt)
    {
      AppMethodBeat.i(151064);
      try
      {
        if (this.sensorManager == null) {
          this.sensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
        }
        if (this.handlerThread == null)
        {
          this.handlerThread = d.ha("MicroMsg.IndoorReporter", 1);
          this.handlerThread.start();
        }
        Handler localHandler = new Handler(this.handlerThread.getLooper());
        bool1 = this.sensorManager.registerListener(this.ipI, this.sensorManager.getDefaultSensor(1), 3, localHandler);
        boolean bool2 = this.sensorManager.registerListener(this.ipI, this.sensorManager.getDefaultSensor(4), 3, localHandler);
        boolean bool3 = this.sensorManager.registerListener(this.ipI, this.sensorManager.getDefaultSensor(2), 3, localHandler);
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
            this.sensorManager.unregisterListener(this.ipI);
            this.sensorManager = null;
            try
            {
              if (this.handlerThread == null) {
                break label199;
              }
              this.handlerThread.quit();
              this.handlerThread = null;
              this.ipy = paramInt;
              this.ipC = Long.valueOf(bt.flT());
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
    Runnable cDO;
    WifiManager cde;
    Future djn;
    int ipK;
    boolean ipL;
    List<String> ipM;
    int ipj;
    long startTime;
    
    c()
    {
      AppMethodBeat.i(151068);
      this.ipK = 0;
      this.ipj = 0;
      this.ipL = false;
      this.startTime = 0L;
      this.ipM = new ArrayList();
      this.cDO = new com.tencent.e.i.h()
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
              if (!e.c.this.ipL) {
                break label411;
              }
              long l = bt.flT();
              List localList = e.c.this.cde.getScanResults();
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
                if (i >= e.c.this.ipj) {
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
                e.c.this.ipM.add(localObject1);
                e.c.this.cde.startScan();
                Thread.sleep(e.c.this.ipK);
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
    
    public final String aLF()
    {
      AppMethodBeat.i(151069);
      this.ipL = false;
      try
      {
        if ((this.djn != null) && (!this.djn.isDone())) {
          this.djn.get(500L, TimeUnit.MILLISECONDS);
        }
        String str = this.ipM.size() + ";#";
        int i = 0;
        while (i < this.ipM.size())
        {
          str = str + (String)this.ipM.get(i) + "#";
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