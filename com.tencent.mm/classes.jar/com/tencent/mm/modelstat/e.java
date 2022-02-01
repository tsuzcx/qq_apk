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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
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
  private static e hVJ;
  private int hVK;
  private int hVL;
  private int hVM;
  private int hVN;
  private int hVO;
  private ArrayList<Pair<Float, Float>> hVP;
  private ArrayList<Pair<Float, Float>> hVQ;
  private long startTime;
  
  public e()
  {
    AppMethodBeat.i(151070);
    this.startTime = 0L;
    this.hVK = -1;
    this.hVL = 20000;
    this.hVM = 3000;
    this.hVN = 1000;
    this.hVO = 20;
    this.hVP = new ArrayList();
    this.hVQ = new ArrayList();
    AppMethodBeat.o(151070);
  }
  
  public static e aIu()
  {
    AppMethodBeat.i(151071);
    if (hVJ == null) {}
    try
    {
      if (hVJ == null) {
        hVJ = new e();
      }
      e locale = hVJ;
      AppMethodBeat.o(151071);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(151071);
    }
  }
  
  public final boolean Dy(String paramString)
  {
    AppMethodBeat.i(151073);
    if (bs.isNullOrNil(paramString))
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
        this.hVK = bs.getInt(arrayOfString1[0], -1);
        if (this.hVK > 101) {
          Assert.assertTrue(false);
        }
        this.hVL = bs.getInt(arrayOfString1[1], 20000);
        this.hVM = bs.getInt(arrayOfString1[2], 3000);
        this.hVN = bs.getInt(arrayOfString1[3], 1000);
        this.hVO = bs.getInt(arrayOfString1[4], 20);
        j = bs.getInt(arrayOfString1[5], 0);
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[(i + 6)].split(";");
          if ("1".equals(arrayOfString2[0])) {
            this.hVP.add(new Pair(Float.valueOf(bs.aLB(arrayOfString2[1])), Float.valueOf(bs.aLB(arrayOfString2[2]))));
          } else {
            this.hVQ.add(new Pair(Float.valueOf(bs.aLB(arrayOfString2[1])), Float.valueOf(bs.aLB(arrayOfString2[2]))));
          }
        }
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", new Object[] { localException.getMessage(), paramString });
        AppMethodBeat.o(151073);
        return false;
      }
      ac.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", new Object[] { Integer.valueOf(this.hVL), Integer.valueOf(this.hVM), Integer.valueOf(this.hVN), Integer.valueOf(this.hVO), Integer.valueOf(j), Integer.valueOf(this.hVP.size()), Integer.valueOf(this.hVQ.size()) });
      AppMethodBeat.o(151073);
      return true;
      i += 1;
    }
  }
  
  public final void a(final int paramInt1, final boolean paramBoolean1, final boolean paramBoolean2, final float paramFloat1, final float paramFloat2, final int paramInt2)
  {
    AppMethodBeat.i(151072);
    ac.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.agP().afY())
    {
      com.tencent.mm.kernel.g.agP();
      if (!a.afS()) {}
    }
    else
    {
      AppMethodBeat.o(151072);
      return;
    }
    com.tencent.mm.bf.b localb = com.tencent.mm.bf.b.aGU();
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      localb.a(paramFloat1, paramFloat2, paramInt2, "", "", i, paramInt1);
      if ((this.hVQ.size() != 0) || (this.hVP.size() != 0) || (Dy(com.tencent.mm.m.g.ZY().getValue("AndroidIndoorSensorReport")))) {
        break;
      }
      AppMethodBeat.o(151072);
      return;
    }
    if (!com.tencent.mm.sdk.a.b.eUk())
    {
      com.tencent.mm.kernel.g.agP();
      i = com.tencent.mm.b.i.cc(a.getUin() + 5, 100);
      if (i > this.hVK)
      {
        com.tencent.mm.kernel.g.agP();
        ac.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", new Object[] { Long.valueOf(new p(a.getUin()).longValue()), Integer.valueOf(i), Integer.valueOf(this.hVK) });
        AppMethodBeat.o(151072);
        return;
      }
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151060);
        for (;;)
        {
          try
          {
            boolean bool;
            if (com.tencent.mm.kernel.g.agP().afY())
            {
              com.tencent.mm.kernel.g.agP();
              bool = a.afS();
              if (!bool) {}
            }
            else
            {
              AppMethodBeat.o(151060);
              return;
            }
            long l = bs.eWj();
            if ((e.a(e.this) != 0L) && (l - e.a(e.this) < 1800000L))
            {
              ac.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", new Object[] { Long.valueOf(l - e.a(e.this)) });
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
              if ((!e.A(paramFloat1, ((Float)((Pair)((List)localObject1).get(i)).first).floatValue())) || (!e.A(paramFloat2, ((Float)((Pair)((List)localObject1).get(i)).second).floatValue()))) {
                break label743;
              }
              localObject1 = (Pair)((List)localObject1).get(i);
              if (localObject1 == null)
              {
                ac.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
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
            com.tencent.mm.kernel.g.agP();
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
                localObject4 = ai.getContext();
                i = e.d(e.this);
                j = e.e(e.this);
                if (localc.bSR == null) {
                  localc.bSR = ((WifiManager)((Context)localObject4).getSystemService("wifi"));
                }
                localc.hWp = i;
                localc.hVO = j;
                localc.startTime = bs.eWj();
                localc.hWq = true;
                localc.cXV = com.tencent.e.h.JZN.aV(localc.csS);
                localObject4 = new e.b(e.this);
                ai.getContext();
                bool = ((e.b)localObject4).py(e.f(e.this));
                if (bool) {
                  continue;
                }
                ac.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", new Object[] { Boolean.TRUE, Boolean.valueOf(bool) });
                ((e.b)localObject4).aIv();
                localc.aIv();
                com.tencent.mm.plugin.report.service.h.wUl.kvStat(13381, (String)localObject1 + (String)localObject3 + ",-10002,ERROR:StartFailed.");
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
            com.tencent.mm.kernel.g.agS();
            new au(com.tencent.mm.kernel.g.agU().GrZ.getLooper(), new au.a()
            {
              boolean hVX = false;
              
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(151059);
                boolean bool = q.cK(ai.getContext());
                long l1 = bs.eWj();
                long l2 = l1 - e.a(e.this);
                if (l2 <= e.g(e.this))
                {
                  if (bool)
                  {
                    this.hVX = false;
                    AppMethodBeat.o(151059);
                    return true;
                  }
                  if (!this.hVX)
                  {
                    this.hVX = true;
                    AppMethodBeat.o(151059);
                    return true;
                  }
                }
                ac.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", new Object[] { Boolean.valueOf(this.hVX), Boolean.valueOf(bool), Long.valueOf(l2) });
                e.a(e.this, 0L);
                String str = this.hVY.aIv();
                Object localObject = localc.aIv();
                try
                {
                  StringBuilder localStringBuilder;
                  if ((bs.isNullOrNil(str)) || (bs.isNullOrNil((String)localObject)))
                  {
                    ac.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", new Object[] { str, localObject });
                    localObject = com.tencent.mm.plugin.report.service.h.wUl;
                    localStringBuilder = new StringBuilder().append(this.hWa).append(this.hWb);
                    if (!bs.isNullOrNil(str)) {}
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
                    localStringBuilder = new StringBuilder().append(this.hWa).append(this.hWb).append("_").append(l1).append("_").append(j).append("_");
                    if (l2 > e.g(e.this)) {}
                    for (str = "1";; str = "2")
                    {
                      str = str + "," + (i + 1) + "," + ((String)localObject).substring(i * 5400, Math.min((i + 1) * 5400, ((String)localObject).length()));
                      ac.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((String)localObject).length()), Integer.valueOf(str.length()), str });
                      com.tencent.mm.plugin.report.service.h.wUl.kvStat(13381, str);
                      i += 1;
                      break;
                    }
                  }
                  return false;
                }
                catch (Exception localException)
                {
                  ac.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", new Object[] { localException.getMessage() });
                  AppMethodBeat.o(151059);
                }
              }
            }, true).au(3000L, 3000L);
            AppMethodBeat.o(151060);
            return;
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", new Object[] { localException.getMessage() });
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
    long gLX;
    long hWd;
    e.a hWe;
    e.a hWf;
    e.a hWg;
    private Long hWh;
    ArrayList<Long> hWi;
    ArrayList<e.a> hWj;
    ArrayList<e.a> hWk;
    ArrayList<e.a> hWl;
    ArrayList<float[]> hWm;
    private SensorEventListener hWn;
    private HandlerThread handlerThread;
    private SensorManager sensorManager;
    
    b()
    {
      AppMethodBeat.i(151063);
      this.hWd = 0L;
      this.handlerThread = null;
      this.hWe = null;
      this.hWf = null;
      this.hWg = null;
      this.hWh = null;
      this.gLX = 0L;
      this.hWi = new ArrayList();
      this.hWj = new ArrayList();
      this.hWk = new ArrayList();
      this.hWl = new ArrayList();
      this.hWm = new ArrayList();
      this.hWn = new SensorEventListener()
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
          long l1 = bs.eWj();
          if (paramAnonymousSensorEvent.sensor.getType() == 1) {
            e.b.this.hWe = new e.a(paramAnonymousSensorEvent);
          }
          for (;;)
          {
            long l2 = l1 - e.b.this.gLX;
            if ((e.b.this.hWe != null) && (e.b.this.hWf != null) && (e.b.this.hWg != null) && ((l2 > e.b.this.hWd) || (l2 < 0L)))
            {
              paramAnonymousSensorEvent = new float[9];
              SensorManager.getRotationMatrix(paramAnonymousSensorEvent, null, e.b.this.hWe.values, e.b.this.hWf.values);
              float[] arrayOfFloat = new float[3];
              SensorManager.getOrientation(paramAnonymousSensorEvent, arrayOfFloat);
              e.b.this.gLX = l1;
              e.b.this.hWi.add(Long.valueOf(l1));
              e.b.this.hWj.add(e.b.this.hWe);
              e.b.this.hWk.add(e.b.this.hWf);
              e.b.this.hWl.add(e.b.this.hWg);
              e.b.this.hWm.add(arrayOfFloat);
              int i = e.b.this.hWj.size() - 1;
              ac.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", new Object[] { Integer.valueOf(e.b.this.hWj.size()), Integer.valueOf(((e.a)e.b.this.hWj.get(i)).accuracy), Float.valueOf(((e.a)e.b.this.hWj.get(i)).values[0]), Float.valueOf(((e.a)e.b.this.hWj.get(i)).values[1]), Float.valueOf(((e.a)e.b.this.hWj.get(i)).values[2]) });
              ac.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", new Object[] { Long.valueOf(l2), Integer.valueOf(e.b.this.hWe.accuracy), Float.valueOf(e.b.this.hWe.values[0]), Float.valueOf(e.b.this.hWe.values[1]), Float.valueOf(e.b.this.hWe.values[2]), Integer.valueOf(e.b.this.hWf.accuracy), Float.valueOf(e.b.this.hWf.values[0]), Float.valueOf(e.b.this.hWf.values[1]), Float.valueOf(e.b.this.hWf.values[2]), Integer.valueOf(e.b.this.hWg.accuracy), Float.valueOf(e.b.this.hWg.values[0]), Float.valueOf(e.b.this.hWg.values[1]), Float.valueOf(e.b.this.hWg.values[2]), Float.valueOf(arrayOfFloat[0]), Float.valueOf(arrayOfFloat[1]), Float.valueOf(arrayOfFloat[2]) });
            }
            AppMethodBeat.o(151062);
            return;
            if (paramAnonymousSensorEvent.sensor.getType() == 2) {
              e.b.this.hWf = new e.a(paramAnonymousSensorEvent);
            } else if (paramAnonymousSensorEvent.sensor.getType() == 4) {
              e.b.this.hWg = new e.a(paramAnonymousSensorEvent);
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
    
    public final String aIv()
    {
      AppMethodBeat.i(151065);
      try
      {
        if (this.sensorManager != null)
        {
          this.sensorManager.unregisterListener(this.hWn);
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
          ac.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", new Object[] { Integer.valueOf(this.hWi.size()) });
          String str = this.hWh + ";" + this.hWi.size() + ";#";
          int i = 0;
          while (i < this.hWi.size())
          {
            str = str + (((Long)this.hWi.get(i)).longValue() - this.hWh.longValue()) + ";";
            str = str + a((e.a)this.hWj.get(i));
            ac.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((e.a)this.hWj.get(i)).accuracy), Float.valueOf(((e.a)this.hWj.get(i)).values[0]), Float.valueOf(((e.a)this.hWj.get(i)).values[1]), Float.valueOf(((e.a)this.hWj.get(i)).values[2]), a((e.a)this.hWj.get(i)) });
            str = str + a((e.a)this.hWl.get(i));
            str = str + a((e.a)this.hWk.get(i));
            str = str + String.format("%.3f;%.3f;%.3f;#", new Object[] { Float.valueOf(((float[])this.hWm.get(i))[0]), Float.valueOf(((float[])this.hWm.get(i))[1]), Float.valueOf(((float[])this.hWm.get(i))[2]) });
            i += 1;
          }
          ac.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", new Object[] { Integer.valueOf(str.length()), str });
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
    
    public final boolean py(int paramInt)
    {
      AppMethodBeat.i(151064);
      try
      {
        if (this.sensorManager == null) {
          this.sensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
        }
        if (this.handlerThread == null)
        {
          this.handlerThread = d.gC("MicroMsg.IndoorReporter", 1);
          this.handlerThread.start();
        }
        Handler localHandler = new Handler(this.handlerThread.getLooper());
        bool1 = this.sensorManager.registerListener(this.hWn, this.sensorManager.getDefaultSensor(1), 3, localHandler);
        boolean bool2 = this.sensorManager.registerListener(this.hWn, this.sensorManager.getDefaultSensor(4), 3, localHandler);
        boolean bool3 = this.sensorManager.registerListener(this.hWn, this.sensorManager.getDefaultSensor(2), 3, localHandler);
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
            this.sensorManager.unregisterListener(this.hWn);
            this.sensorManager = null;
            try
            {
              if (this.handlerThread == null) {
                break label199;
              }
              this.handlerThread.quit();
              this.handlerThread = null;
              this.hWd = paramInt;
              this.hWh = Long.valueOf(bs.eWj());
              AppMethodBeat.o(151064);
              return bool1;
              bool1 = false;
              continue;
              localException1 = localException1;
              ac.e("MicroMsg.IndoorReporter", "start except:%s", new Object[] { localException1.getMessage() });
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
    WifiManager bSR;
    Future cXV;
    Runnable csS;
    int hVO;
    int hWp;
    boolean hWq;
    List<String> hWr;
    long startTime;
    
    c()
    {
      AppMethodBeat.i(151068);
      this.hWp = 0;
      this.hVO = 0;
      this.hWq = false;
      this.startTime = 0L;
      this.hWr = new ArrayList();
      this.csS = new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "MicroMsg.IndoorReporter_WIFI_Scan";
        }
        
        public final void run()
        {
          AppMethodBeat.i(151067);
          ac.i("MicroMsg.IndoorReporter", "start wifi");
          for (;;)
          {
            int k;
            int i;
            try
            {
              if (!e.c.this.hWq) {
                break label411;
              }
              long l = bs.eWj();
              List localList = e.c.this.bSR.getScanResults();
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
                if ((localObject2 == null) || (bs.isNullOrNil(((ScanResult)localObject2).BSSID)) || (bs.isNullOrNil(((ScanResult)localObject2).SSID))) {
                  break label417;
                }
                String str = ((ScanResult)localObject2).SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "");
                localObject2 = (String)localObject1 + str + ";" + ((ScanResult)localObject2).BSSID + ";" + ((ScanResult)localObject2).level + ";";
                i += 1;
                if (i >= e.c.this.hVO) {
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
                ac.i("MicroMsg.IndoorReporter", "%d %s", new Object[] { Integer.valueOf(((String)localObject1).length()), localObject1 });
                e.c.this.hWr.add(localObject1);
                e.c.this.bSR.startScan();
                Thread.sleep(e.c.this.hWp);
                continue;
              }
              i = 0;
            }
            catch (Exception localException)
            {
              ac.e("MicroMsg.IndoorReporter", "Except:%s", new Object[] { localException.getMessage() });
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
    
    public final String aIv()
    {
      AppMethodBeat.i(151069);
      this.hWq = false;
      try
      {
        if ((this.cXV != null) && (!this.cXV.isDone())) {
          this.cXV.get(500L, TimeUnit.MILLISECONDS);
        }
        String str = this.hWr.size() + ";#";
        int i = 0;
        while (i < this.hWr.size())
        {
          str = str + (String)this.hWr.get(i) + "#";
          i += 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", new Object[] { localException.getMessage() });
        }
        AppMethodBeat.o(151069);
        return localException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.e
 * JD-Core Version:    0.7.0.1
 */