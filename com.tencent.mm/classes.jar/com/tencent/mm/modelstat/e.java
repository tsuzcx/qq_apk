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
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.bf.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.GreenManUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e
{
  private static e jnm;
  private int jnn;
  private int jno;
  private int jnp;
  private int jnq;
  private int jnr;
  private ArrayList<Pair<Float, Float>> jns;
  private ArrayList<Pair<Float, Float>> jnt;
  private long startTime;
  
  public e()
  {
    AppMethodBeat.i(151070);
    this.startTime = 0L;
    this.jnn = -1;
    this.jno = 20000;
    this.jnp = 3000;
    this.jnq = 1000;
    this.jnr = 20;
    this.jns = new ArrayList();
    this.jnt = new ArrayList();
    AppMethodBeat.o(151070);
  }
  
  public static e bge()
  {
    AppMethodBeat.i(151071);
    if (jnm == null) {}
    try
    {
      if (jnm == null) {
        jnm = new e();
      }
      e locale = jnm;
      AppMethodBeat.o(151071);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(151071);
    }
  }
  
  public final boolean PS(String paramString)
  {
    AppMethodBeat.i(151073);
    if (Util.isNullOrNil(paramString))
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
        this.jnn = Util.getInt(arrayOfString1[0], -1);
        if (this.jnn > 101) {
          Assert.assertTrue(false);
        }
        this.jno = Util.getInt(arrayOfString1[1], 20000);
        this.jnp = Util.getInt(arrayOfString1[2], 3000);
        this.jnq = Util.getInt(arrayOfString1[3], 1000);
        this.jnr = Util.getInt(arrayOfString1[4], 20);
        j = Util.getInt(arrayOfString1[5], 0);
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[(i + 6)].split(";");
          if ("1".equals(arrayOfString2[0])) {
            this.jns.add(new Pair(Float.valueOf(Util.safeParseFloat(arrayOfString2[1])), Float.valueOf(Util.safeParseFloat(arrayOfString2[2]))));
          } else {
            this.jnt.add(new Pair(Float.valueOf(Util.safeParseFloat(arrayOfString2[1])), Float.valueOf(Util.safeParseFloat(arrayOfString2[2]))));
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", new Object[] { localException.getMessage(), paramString });
        AppMethodBeat.o(151073);
        return false;
      }
      Log.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", new Object[] { Integer.valueOf(this.jno), Integer.valueOf(this.jnp), Integer.valueOf(this.jnq), Integer.valueOf(this.jnr), Integer.valueOf(j), Integer.valueOf(this.jns.size()), Integer.valueOf(this.jnt.size()) });
      AppMethodBeat.o(151073);
      return true;
      i += 1;
    }
  }
  
  public final void a(final int paramInt1, final boolean paramBoolean1, final boolean paramBoolean2, final float paramFloat1, final float paramFloat2, final int paramInt2)
  {
    AppMethodBeat.i(151072);
    Log.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) });
    if (g.aAf().azp())
    {
      g.aAf();
      if (!a.azj()) {}
    }
    else
    {
      AppMethodBeat.o(151072);
      return;
    }
    b localb = b.beB();
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      localb.a(paramFloat1, paramFloat2, paramInt2, "", "", i, paramInt1);
      if ((this.jnt.size() != 0) || (this.jns.size() != 0) || (PS(com.tencent.mm.n.h.aqJ().getValue("AndroidIndoorSensorReport")))) {
        break;
      }
      AppMethodBeat.o(151072);
      return;
    }
    if (!CrashReportFactory.hasDebuger())
    {
      g.aAf();
      i = com.tencent.mm.b.i.ch(a.getUin() + 5, 100);
      if (i > this.jnn)
      {
        g.aAf();
        Log.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", new Object[] { Long.valueOf(new p(a.getUin()).longValue()), Integer.valueOf(i), Integer.valueOf(this.jnn) });
        AppMethodBeat.o(151072);
        return;
      }
    }
    g.aAi();
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151060);
        for (;;)
        {
          try
          {
            boolean bool;
            if (g.aAf().azp())
            {
              g.aAf();
              bool = a.azj();
              if (!bool) {}
            }
            else
            {
              AppMethodBeat.o(151060);
              return;
            }
            long l = Util.nowMilliSecond();
            if ((e.a(e.this) != 0L) && (l - e.a(e.this) < 1800000L))
            {
              Log.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", new Object[] { Long.valueOf(l - e.a(e.this)) });
              AppMethodBeat.o(151060);
              return;
            }
            if (paramBoolean2)
            {
              localObject1 = e.b(e.this);
              break label731;
              if (i >= ((List)localObject1).size()) {
                break label725;
              }
              if ((!e.F(paramFloat1, ((Float)((Pair)((List)localObject1).get(i)).first).floatValue())) || (!e.F(paramFloat2, ((Float)((Pair)((List)localObject1).get(i)).second).floatValue()))) {
                break label736;
              }
              localObject1 = (Pair)((List)localObject1).get(i);
              if (localObject1 == null)
              {
                Log.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
                AppMethodBeat.o(151060);
              }
            }
            else
            {
              localObject1 = e.c(e.this);
              break label731;
            }
            e.a(e.this, l);
            Object localObject3 = new StringBuilder();
            g.aAf();
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
                localObject4 = MMApplicationContext.getContext();
                i = e.d(e.this);
                j = e.e(e.this);
                if (localc.cnK == null) {
                  localc.cnK = ((WifiManager)((Context)localObject4).getSystemService("wifi"));
                }
                localc.jnS = i;
                localc.jnr = j;
                localc.startTime = Util.nowMilliSecond();
                localc.jnT = true;
                localc.dBz = com.tencent.f.h.RTc.ba(localc.dQN);
                localObject4 = new e.b(e.this);
                MMApplicationContext.getContext();
                bool = ((e.b)localObject4).tT(e.f(e.this));
                if (bool) {
                  continue;
                }
                Log.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", new Object[] { Boolean.TRUE, Boolean.valueOf(bool) });
                ((e.b)localObject4).bgf();
                localc.bgf();
                com.tencent.mm.plugin.report.service.h.CyF.kvStat(13381, (String)localObject1 + (String)localObject3 + ",-10002,ERROR:StartFailed.");
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
            g.aAi();
            new MTimerHandler(g.aAk().getLooper(), new MTimerHandler.CallBack()
            {
              boolean jnA = false;
              
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(151059);
                boolean bool = GreenManUtil.isAppOnForeground(MMApplicationContext.getContext());
                long l1 = Util.nowMilliSecond();
                long l2 = l1 - e.a(e.this);
                if (l2 <= e.g(e.this))
                {
                  if (bool)
                  {
                    this.jnA = false;
                    AppMethodBeat.o(151059);
                    return true;
                  }
                  if (!this.jnA)
                  {
                    this.jnA = true;
                    AppMethodBeat.o(151059);
                    return true;
                  }
                }
                Log.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", new Object[] { Boolean.valueOf(this.jnA), Boolean.valueOf(bool), Long.valueOf(l2) });
                e.a(e.this, 0L);
                String str = this.jnB.bgf();
                Object localObject = localc.bgf();
                try
                {
                  StringBuilder localStringBuilder;
                  if ((Util.isNullOrNil(str)) || (Util.isNullOrNil((String)localObject)))
                  {
                    Log.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", new Object[] { str, localObject });
                    localObject = com.tencent.mm.plugin.report.service.h.CyF;
                    localStringBuilder = new StringBuilder().append(this.jnD).append(this.jnE);
                    if (!Util.isNullOrNil(str)) {}
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
                    localStringBuilder = new StringBuilder().append(this.jnD).append(this.jnE).append("_").append(l1).append("_").append(j).append("_");
                    if (l2 > e.g(e.this)) {}
                    for (str = "1";; str = "2")
                    {
                      str = str + "," + (i + 1) + "," + ((String)localObject).substring(i * 5400, Math.min((i + 1) * 5400, ((String)localObject).length()));
                      Log.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((String)localObject).length()), Integer.valueOf(str.length()), str });
                      com.tencent.mm.plugin.report.service.h.CyF.kvStat(13381, str);
                      i += 1;
                      break;
                    }
                  }
                  return false;
                }
                catch (Exception localException)
                {
                  Log.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", new Object[] { localException.getMessage() });
                  AppMethodBeat.o(151059);
                }
              }
            }, true).startTimer(3000L);
            AppMethodBeat.o(151060);
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", new Object[] { localException.getMessage() });
            AppMethodBeat.o(151060);
            return;
          }
          label725:
          Object localObject2 = null;
          continue;
          label731:
          int i = 0;
          continue;
          label736:
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
    long hwQ;
    long jnG;
    e.a jnH;
    e.a jnI;
    e.a jnJ;
    private Long jnK;
    ArrayList<Long> jnL;
    ArrayList<e.a> jnM;
    ArrayList<e.a> jnN;
    ArrayList<e.a> jnO;
    ArrayList<float[]> jnP;
    private SensorEventListener jnQ;
    private SensorManager sensorManager;
    
    b()
    {
      AppMethodBeat.i(151063);
      this.jnG = 0L;
      this.handlerThread = null;
      this.jnH = null;
      this.jnI = null;
      this.jnJ = null;
      this.jnK = null;
      this.hwQ = 0L;
      this.jnL = new ArrayList();
      this.jnM = new ArrayList();
      this.jnN = new ArrayList();
      this.jnO = new ArrayList();
      this.jnP = new ArrayList();
      this.jnQ = new SensorEventListener()
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
          long l1 = Util.nowMilliSecond();
          if (paramAnonymousSensorEvent.sensor.getType() == 1) {
            e.b.this.jnH = new e.a(paramAnonymousSensorEvent);
          }
          for (;;)
          {
            long l2 = l1 - e.b.this.hwQ;
            if ((e.b.this.jnH != null) && (e.b.this.jnI != null) && (e.b.this.jnJ != null) && ((l2 > e.b.this.jnG) || (l2 < 0L)))
            {
              paramAnonymousSensorEvent = new float[9];
              SensorManager.getRotationMatrix(paramAnonymousSensorEvent, null, e.b.this.jnH.values, e.b.this.jnI.values);
              float[] arrayOfFloat = new float[3];
              SensorManager.getOrientation(paramAnonymousSensorEvent, arrayOfFloat);
              e.b.this.hwQ = l1;
              e.b.this.jnL.add(Long.valueOf(l1));
              e.b.this.jnM.add(e.b.this.jnH);
              e.b.this.jnN.add(e.b.this.jnI);
              e.b.this.jnO.add(e.b.this.jnJ);
              e.b.this.jnP.add(arrayOfFloat);
              int i = e.b.this.jnM.size() - 1;
              Log.i("MicroMsg.IndoorReporter", "RES ,  %d  acc[%d,%f,%f,%f]  ", new Object[] { Integer.valueOf(e.b.this.jnM.size()), Integer.valueOf(((e.a)e.b.this.jnM.get(i)).accuracy), Float.valueOf(((e.a)e.b.this.jnM.get(i)).values[0]), Float.valueOf(((e.a)e.b.this.jnM.get(i)).values[1]), Float.valueOf(((e.a)e.b.this.jnM.get(i)).values[2]) });
              Log.v("MicroMsg.IndoorReporter", "Res:%d acc[%d,%f,%f,%f] mag[%d,%f,%f,%f] gyr[%d,%f,%f,%f] ori[%f,%f,%f]", new Object[] { Long.valueOf(l2), Integer.valueOf(e.b.this.jnH.accuracy), Float.valueOf(e.b.this.jnH.values[0]), Float.valueOf(e.b.this.jnH.values[1]), Float.valueOf(e.b.this.jnH.values[2]), Integer.valueOf(e.b.this.jnI.accuracy), Float.valueOf(e.b.this.jnI.values[0]), Float.valueOf(e.b.this.jnI.values[1]), Float.valueOf(e.b.this.jnI.values[2]), Integer.valueOf(e.b.this.jnJ.accuracy), Float.valueOf(e.b.this.jnJ.values[0]), Float.valueOf(e.b.this.jnJ.values[1]), Float.valueOf(e.b.this.jnJ.values[2]), Float.valueOf(arrayOfFloat[0]), Float.valueOf(arrayOfFloat[1]), Float.valueOf(arrayOfFloat[2]) });
            }
            AppMethodBeat.o(151062);
            return;
            if (paramAnonymousSensorEvent.sensor.getType() == 2) {
              e.b.this.jnI = new e.a(paramAnonymousSensorEvent);
            } else if (paramAnonymousSensorEvent.sensor.getType() == 4) {
              e.b.this.jnJ = new e.a(paramAnonymousSensorEvent);
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
    
    public final String bgf()
    {
      AppMethodBeat.i(151065);
      try
      {
        if (this.sensorManager != null)
        {
          this.sensorManager.unregisterListener(this.jnQ);
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
          Log.i("MicroMsg.IndoorReporter", "stop sampling Res Count: %d", new Object[] { Integer.valueOf(this.jnL.size()) });
          String str = this.jnK + ";" + this.jnL.size() + ";#";
          int i = 0;
          while (i < this.jnL.size())
          {
            str = str + (((Long)this.jnL.get(i)).longValue() - this.jnK.longValue()) + ";";
            str = str + a((e.a)this.jnM.get(i));
            Log.i("MicroMsg.IndoorReporter", "%d accResArr [%d,%f,%f,%f]  %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((e.a)this.jnM.get(i)).accuracy), Float.valueOf(((e.a)this.jnM.get(i)).values[0]), Float.valueOf(((e.a)this.jnM.get(i)).values[1]), Float.valueOf(((e.a)this.jnM.get(i)).values[2]), a((e.a)this.jnM.get(i)) });
            str = str + a((e.a)this.jnO.get(i));
            str = str + a((e.a)this.jnN.get(i));
            str = str + String.format("%.3f;%.3f;%.3f;#", new Object[] { Float.valueOf(((float[])this.jnP.get(i))[0]), Float.valueOf(((float[])this.jnP.get(i))[1]), Float.valueOf(((float[])this.jnP.get(i))[2]) });
            i += 1;
          }
          Log.i("MicroMsg.IndoorReporter", "stop  Res: %d [%s]", new Object[] { Integer.valueOf(str.length()), str });
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
    
    public final boolean tT(int paramInt)
    {
      AppMethodBeat.i(151064);
      try
      {
        if (this.sensorManager == null) {
          this.sensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
        }
        if (this.handlerThread == null)
        {
          this.handlerThread = d.hD("MicroMsg.IndoorReporter", 1);
          this.handlerThread.start();
        }
        Handler localHandler = new Handler(this.handlerThread.getLooper());
        bool1 = this.sensorManager.registerListener(this.jnQ, this.sensorManager.getDefaultSensor(1), 3, localHandler);
        boolean bool2 = this.sensorManager.registerListener(this.jnQ, this.sensorManager.getDefaultSensor(4), 3, localHandler);
        boolean bool3 = this.sensorManager.registerListener(this.jnQ, this.sensorManager.getDefaultSensor(2), 3, localHandler);
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
            this.sensorManager.unregisterListener(this.jnQ);
            this.sensorManager = null;
            try
            {
              if (this.handlerThread == null) {
                break label199;
              }
              this.handlerThread.quit();
              this.handlerThread = null;
              this.jnG = paramInt;
              this.jnK = Long.valueOf(Util.nowMilliSecond());
              AppMethodBeat.o(151064);
              return bool1;
              bool1 = false;
              continue;
              localException1 = localException1;
              Log.e("MicroMsg.IndoorReporter", "start except:%s", new Object[] { localException1.getMessage() });
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
    WifiManager cnK;
    Future dBz;
    Runnable dQN;
    int jnS;
    boolean jnT;
    List<String> jnU;
    int jnr;
    long startTime;
    
    c()
    {
      AppMethodBeat.i(151068);
      this.jnS = 0;
      this.jnr = 0;
      this.jnT = false;
      this.startTime = 0L;
      this.jnU = new ArrayList();
      this.dQN = new com.tencent.f.i.h()
      {
        public final String getKey()
        {
          return "MicroMsg.IndoorReporter_WIFI_Scan";
        }
        
        public final void run()
        {
          AppMethodBeat.i(151067);
          Log.i("MicroMsg.IndoorReporter", "start wifi");
          for (;;)
          {
            int k;
            int i;
            try
            {
              if (!e.c.this.jnT) {
                break label411;
              }
              long l = Util.nowMilliSecond();
              List localList = e.c.this.cnK.getScanResults();
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
                if ((localObject2 == null) || (Util.isNullOrNil(((ScanResult)localObject2).BSSID)) || (Util.isNullOrNil(((ScanResult)localObject2).SSID))) {
                  break label417;
                }
                String str = ((ScanResult)localObject2).SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "");
                localObject2 = (String)localObject1 + str + ";" + ((ScanResult)localObject2).BSSID + ";" + ((ScanResult)localObject2).level + ";";
                i += 1;
                if (i >= e.c.this.jnr) {
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
                Log.i("MicroMsg.IndoorReporter", "%d %s", new Object[] { Integer.valueOf(((String)localObject1).length()), localObject1 });
                e.c.this.jnU.add(localObject1);
                e.c.this.cnK.startScan();
                Thread.sleep(e.c.this.jnS);
                continue;
              }
              i = 0;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.IndoorReporter", "Except:%s", new Object[] { localException.getMessage() });
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
    
    public final String bgf()
    {
      AppMethodBeat.i(151069);
      this.jnT = false;
      try
      {
        if ((this.dBz != null) && (!this.dBz.isDone())) {
          this.dBz.get(500L, TimeUnit.MILLISECONDS);
        }
        String str = this.jnU.size() + ";#";
        int i = 0;
        while (i < this.jnU.size())
        {
          str = str + (String)this.jnU.get(i) + "#";
          i += 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", new Object[] { localException.getMessage() });
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