package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;

public class e
{
  private static e irZ;
  private int isa;
  private int isb;
  private int isc;
  private int isd;
  private int ise;
  private ArrayList<Pair<Float, Float>> isf;
  private ArrayList<Pair<Float, Float>> isg;
  private long startTime;
  
  public e()
  {
    AppMethodBeat.i(151070);
    this.startTime = 0L;
    this.isa = -1;
    this.isb = 20000;
    this.isc = 3000;
    this.isd = 1000;
    this.ise = 20;
    this.isf = new ArrayList();
    this.isg = new ArrayList();
    AppMethodBeat.o(151070);
  }
  
  public static e aMb()
  {
    AppMethodBeat.i(151071);
    if (irZ == null) {}
    try
    {
      if (irZ == null) {
        irZ = new e();
      }
      e locale = irZ;
      AppMethodBeat.o(151071);
      return locale;
    }
    finally
    {
      AppMethodBeat.o(151071);
    }
  }
  
  public final boolean Hf(String paramString)
  {
    AppMethodBeat.i(151073);
    if (bu.isNullOrNil(paramString))
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
        this.isa = bu.getInt(arrayOfString1[0], -1);
        if (this.isa > 101) {
          Assert.assertTrue(false);
        }
        this.isb = bu.getInt(arrayOfString1[1], 20000);
        this.isc = bu.getInt(arrayOfString1[2], 3000);
        this.isd = bu.getInt(arrayOfString1[3], 1000);
        this.ise = bu.getInt(arrayOfString1[4], 20);
        j = bu.getInt(arrayOfString1[5], 0);
        i = 0;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[(i + 6)].split(";");
          if ("1".equals(arrayOfString2[0])) {
            this.isf.add(new Pair(Float.valueOf(bu.aSE(arrayOfString2[1])), Float.valueOf(bu.aSE(arrayOfString2[2]))));
          } else {
            this.isg.add(new Pair(Float.valueOf(bu.aSE(arrayOfString2[1])), Float.valueOf(bu.aSE(arrayOfString2[2]))));
          }
        }
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.IndoorReporter", "parseConfig e:%s  [%s]", new Object[] { localException.getMessage(), paramString });
        AppMethodBeat.o(151073);
        return false;
      }
      ae.i("MicroMsg.IndoorReporter", "parseConfig: max:%d wifiFreq:%d sensorFreq:%d maxWifiCount:%d cnt:%d mars:%d earth:%d", new Object[] { Integer.valueOf(this.isb), Integer.valueOf(this.isc), Integer.valueOf(this.isd), Integer.valueOf(this.ise), Integer.valueOf(j), Integer.valueOf(this.isf.size()), Integer.valueOf(this.isg.size()) });
      AppMethodBeat.o(151073);
      return true;
      i += 1;
    }
  }
  
  public final void a(final int paramInt1, final boolean paramBoolean1, final boolean paramBoolean2, final float paramFloat1, final float paramFloat2, final int paramInt2)
  {
    AppMethodBeat.i(151072);
    ae.i("MicroMsg.IndoorReporter", "report scene:%d agps:%b mars:%b lon:%f lat:%f acc:%d", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt2) });
    if (com.tencent.mm.kernel.g.ajP().aiZ())
    {
      com.tencent.mm.kernel.g.ajP();
      if (!a.aiT()) {}
    }
    else
    {
      AppMethodBeat.o(151072);
      return;
    }
    com.tencent.mm.bf.b localb = com.tencent.mm.bf.b.aKy();
    if (paramBoolean2) {}
    for (int i = 1;; i = 0)
    {
      localb.a(paramFloat1, paramFloat2, paramInt2, "", "", i, paramInt1);
      if ((this.isg.size() != 0) || (this.isf.size() != 0) || (Hf(com.tencent.mm.n.g.acL().getValue("AndroidIndoorSensorReport")))) {
        break;
      }
      AppMethodBeat.o(151072);
      return;
    }
    if (!com.tencent.mm.sdk.a.b.fnF())
    {
      com.tencent.mm.kernel.g.ajP();
      i = com.tencent.mm.b.i.cf(a.getUin() + 5, 100);
      if (i > this.isa)
      {
        com.tencent.mm.kernel.g.ajP();
        ae.d("MicroMsg.IndoorReporter", "report uin:%s hash:%d config:%d", new Object[] { Long.valueOf(new p(a.getUin()).longValue()), Integer.valueOf(i), Integer.valueOf(this.isa) });
        AppMethodBeat.o(151072);
        return;
      }
    }
    com.tencent.mm.kernel.g.ajS();
    com.tencent.mm.kernel.g.ajU().aw(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(151060);
        for (;;)
        {
          try
          {
            boolean bool;
            if (com.tencent.mm.kernel.g.ajP().aiZ())
            {
              com.tencent.mm.kernel.g.ajP();
              bool = a.aiT();
              if (!bool) {}
            }
            else
            {
              AppMethodBeat.o(151060);
              return;
            }
            long l = bu.fpO();
            if ((e.a(e.this) != 0L) && (l - e.a(e.this) < 1800000L))
            {
              ae.e("MicroMsg.IndoorReporter", "Ignore this Report,Another Report is Running & not timeout:%d.", new Object[] { Long.valueOf(l - e.a(e.this)) });
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
                ae.d("MicroMsg.IndoorReporter", "Ignore this report, no hit any Point");
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
            com.tencent.mm.kernel.g.ajP();
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
                localObject4 = ak.getContext();
                i = e.d(e.this);
                j = e.e(e.this);
                if (localc.cde == null) {
                  localc.cde = ((WifiManager)((Context)localObject4).getSystemService("wifi"));
                }
                localc.isF = i;
                localc.ise = j;
                localc.startTime = bu.fpO();
                localc.isG = true;
                localc.dkp = com.tencent.e.h.MqF.aR(localc.cEv);
                localObject4 = new e.b(e.this);
                ak.getContext();
                bool = ((e.b)localObject4).qd(e.f(e.this));
                if (bool) {
                  continue;
                }
                ae.e("MicroMsg.IndoorReporter", "Ignore this report. Error:start wifi:%b sensor:%b  ", new Object[] { Boolean.TRUE, Boolean.valueOf(bool) });
                ((e.b)localObject4).aMc();
                localc.aMc();
                com.tencent.mm.plugin.report.service.g.yxI.kvStat(13381, (String)localObject1 + (String)localObject3 + ",-10002,ERROR:StartFailed.");
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
            com.tencent.mm.kernel.g.ajS();
            new aw(com.tencent.mm.kernel.g.ajU().IxZ.getLooper(), new aw.a()
            {
              boolean isn = false;
              
              public final boolean onTimerExpired()
              {
                AppMethodBeat.i(151059);
                boolean bool = s.cJ(ak.getContext());
                long l1 = bu.fpO();
                long l2 = l1 - e.a(e.this);
                if (l2 <= e.g(e.this))
                {
                  if (bool)
                  {
                    this.isn = false;
                    AppMethodBeat.o(151059);
                    return true;
                  }
                  if (!this.isn)
                  {
                    this.isn = true;
                    AppMethodBeat.o(151059);
                    return true;
                  }
                }
                ae.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", new Object[] { Boolean.valueOf(this.isn), Boolean.valueOf(bool), Long.valueOf(l2) });
                e.a(e.this, 0L);
                String str = this.iso.aMc();
                Object localObject = localc.aMc();
                try
                {
                  StringBuilder localStringBuilder;
                  if ((bu.isNullOrNil(str)) || (bu.isNullOrNil((String)localObject)))
                  {
                    ae.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", new Object[] { str, localObject });
                    localObject = com.tencent.mm.plugin.report.service.g.yxI;
                    localStringBuilder = new StringBuilder().append(this.isq).append(this.isr);
                    if (!bu.isNullOrNil(str)) {}
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
                    localStringBuilder = new StringBuilder().append(this.isq).append(this.isr).append("_").append(l1).append("_").append(j).append("_");
                    if (l2 > e.g(e.this)) {}
                    for (str = "1";; str = "2")
                    {
                      str = str + "," + (i + 1) + "," + ((String)localObject).substring(i * 5400, Math.min((i + 1) * 5400, ((String)localObject).length()));
                      ae.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((String)localObject).length()), Integer.valueOf(str.length()), str });
                      com.tencent.mm.plugin.report.service.g.yxI.kvStat(13381, str);
                      i += 1;
                      break;
                    }
                  }
                  return false;
                }
                catch (Exception localException)
                {
                  ae.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", new Object[] { localException.getMessage() });
                  AppMethodBeat.o(151059);
                }
              }
            }, true).ay(3000L, 3000L);
            AppMethodBeat.o(151060);
            return;
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.IndoorReporter", "reprot Start exception:%s", new Object[] { localException.getMessage() });
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
  
  final class c
  {
    Runnable cEv;
    WifiManager cde;
    Future dkp;
    int isF;
    boolean isG;
    List<String> isH;
    int ise;
    long startTime;
    
    c()
    {
      AppMethodBeat.i(151068);
      this.isF = 0;
      this.ise = 0;
      this.isG = false;
      this.startTime = 0L;
      this.isH = new ArrayList();
      this.cEv = new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "MicroMsg.IndoorReporter_WIFI_Scan";
        }
        
        public final void run()
        {
          AppMethodBeat.i(151067);
          ae.i("MicroMsg.IndoorReporter", "start wifi");
          for (;;)
          {
            int k;
            int i;
            try
            {
              if (!e.c.this.isG) {
                break label411;
              }
              long l = bu.fpO();
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
                if ((localObject2 == null) || (bu.isNullOrNil(((ScanResult)localObject2).BSSID)) || (bu.isNullOrNil(((ScanResult)localObject2).SSID))) {
                  break label417;
                }
                String str = ((ScanResult)localObject2).SSID.replace(";", "").replace(" ", "").replace(",", "").replace("#", "");
                localObject2 = (String)localObject1 + str + ";" + ((ScanResult)localObject2).BSSID + ";" + ((ScanResult)localObject2).level + ";";
                i += 1;
                if (i >= e.c.this.ise) {
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
                ae.i("MicroMsg.IndoorReporter", "%d %s", new Object[] { Integer.valueOf(((String)localObject1).length()), localObject1 });
                e.c.this.isH.add(localObject1);
                e.c.this.cde.startScan();
                Thread.sleep(e.c.this.isF);
                continue;
              }
              i = 0;
            }
            catch (Exception localException)
            {
              ae.e("MicroMsg.IndoorReporter", "Except:%s", new Object[] { localException.getMessage() });
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
    
    public final String aMc()
    {
      AppMethodBeat.i(151069);
      this.isG = false;
      try
      {
        if ((this.dkp != null) && (!this.dkp.isDone())) {
          this.dkp.get(500L, TimeUnit.MILLISECONDS);
        }
        String str = this.isH.size() + ";#";
        int i = 0;
        while (i < this.isH.size())
        {
          str = str + (String)this.isH.get(i) + "#";
          i += 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.IndoorReporter", "stop, join Thread failed:%s ", new Object[] { localException.getMessage() });
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