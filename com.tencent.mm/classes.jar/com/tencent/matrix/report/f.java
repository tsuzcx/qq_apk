package com.tencent.matrix.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import d.g.b.p;
import d.n.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public final class f
{
  private int cFe = 17108;
  private int cFf = 19999;
  private int cUF = 20841;
  
  private static int dU(String paramString)
  {
    if (paramString.equalsIgnoreCase("com.tencent.mm")) {
      return 1033;
    }
    if (paramString.equalsIgnoreCase("com.tencent.mm:tools")) {
      return 1187;
    }
    if (paramString.equalsIgnoreCase("com.tencent.mm:toolsmp")) {
      return 1188;
    }
    if (paramString.equalsIgnoreCase("com.tencent.mm:push")) {
      return 1189;
    }
    if (paramString.startsWith("com.tencent.mm:appbrand")) {
      return 1190;
    }
    return 1191;
  }
  
  private static int dV(String paramString)
  {
    if (paramString.equalsIgnoreCase("com.tencent.mm")) {
      return 1192;
    }
    if (paramString.equalsIgnoreCase("com.tencent.mm:tools")) {
      return 1193;
    }
    return 1191;
  }
  
  public final void d(String paramString, JSONObject paramJSONObject)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject3 = paramJSONObject.getString("process");
        ad.i("MatrixIdKeyReporter", "[report] tag:%s processName:%s", new Object[] { paramString, localObject3 });
        if (!com.tencent.matrix.b.HK())
        {
          ad.i("MatrixIdKeyReporter", "matrix not installed");
          return;
        }
        localObject1 = null;
        if (paramString != null)
        {
          if (paramString.startsWith("Trace")) {
            localObject1 = com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class);
          }
        }
        else
        {
          if (localObject1 != null) {
            break;
          }
          ad.e("MatrixIdKeyReporter", "plugin is null");
          return;
        }
      }
      catch (Exception paramString)
      {
        ad.printErrStackTrace("MatrixIdKeyReporter", paramString, "data:%s", new Object[] { paramJSONObject.toString() });
        return;
      }
      localObject2 = com.tencent.matrix.b.HL().cBc.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (com.tencent.matrix.e.b)((Iterator)localObject2).next();
      } while (!((com.tencent.matrix.e.b)localObject1).getTag().equals(paramString));
    }
    boolean bool;
    Object localObject4;
    Object localObject5;
    int j;
    int k;
    int i;
    if ((localObject1 instanceof com.tencent.matrix.trace.a))
    {
      localObject1 = paramJSONObject.getString("tag");
      ad.i("MatrixIdKeyReporter", "[report] _tag:%s", new Object[] { localObject1 });
      if (((String)localObject1).equalsIgnoreCase("Trace_EvilMethod"))
      {
        localObject2 = paramJSONObject.getString("detail");
        if (((String)localObject2).equalsIgnoreCase(a.a.cJN.toString()))
        {
          bool = paramJSONObject.getBoolean("isProcessForeground");
          localObject4 = paramJSONObject.getString("stackKey");
          localObject5 = paramJSONObject.getString("threadStack");
          localObject1 = paramJSONObject.getString("scene");
          g localg = g.yhR;
          j = this.cFe;
          k = d.Fnj;
          if (!bool) {
            break label2852;
          }
          i = 1;
          label270:
          localg.f(j, new Object[] { paramString, Integer.valueOf(k), localObject2, localObject4, localObject1, localObject5, localObject3, Integer.valueOf(i) });
          localg = g.yhR;
          j = this.cFf;
          k = d.Fnj;
          if (!bool) {
            break label2858;
          }
          i = 1;
          label353:
          localg.f(j, new Object[] { Integer.valueOf(k), localObject2, localObject4, localObject1, localObject5, localObject3, Integer.valueOf(i) });
          if (bool) {
            com.tencent.mm.plugin.report.e.ygI.idkeyStat(dU((String)localObject3), 1L, 1L, true);
          }
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(dU((String)localObject3), 0L, 1L, true);
          localObject3 = e.cFd;
          p.h(localObject1, "scene");
          if (!e.dR((String)localObject1)) {
            break label2842;
          }
          g.yhR.n(1343L, 100L, 1L);
          break label2842;
        }
      }
    }
    label478:
    long l;
    for (;;)
    {
      if ((i == 0) && (!paramString.equalsIgnoreCase("io")) && (!paramString.equalsIgnoreCase("sqlitelint")) && (!paramString.equalsIgnoreCase("battery")))
      {
        g.yhR.f(this.cFe, new Object[] { paramString, Integer.valueOf(d.Fnj), localObject1 });
        return;
        if (((String)localObject2).equalsIgnoreCase(a.a.cJM.toString()))
        {
          localObject1 = paramJSONObject.getString("stackKey");
          localObject4 = paramJSONObject.getString("scene");
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(dU((String)localObject3), 21L, 1L, true);
          g.yhR.f(this.cFe, new Object[] { paramString, Integer.valueOf(d.Fnj), localObject2, localObject1, localObject4, "null", localObject3 });
          i = 1;
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localObject2;
          if (!((String)localObject2).equalsIgnoreCase(a.a.cJP.toString())) {
            break label3013;
          }
          localObject1 = paramJSONObject.getString("scene");
          if (!((String)localObject1).contains("Finder")) {
            break label2864;
          }
          localObject3 = paramJSONObject.getString("threadStack");
          bool = paramJSONObject.getBoolean("isProcessForeground");
          g.yhR.f(this.cUF, new Object[] { localObject1, localObject3, Boolean.valueOf(bool) });
          break label2864;
          if (((String)localObject1).equalsIgnoreCase("Trace_StartUp"))
          {
            l = paramJSONObject.getLong("startup_duration");
            bool = paramJSONObject.getBoolean("is_warm_start_up");
            ad.i("MatrixIdKeyReporter", "[startup] duration=%s isWarmStartUp=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
            localObject1 = new ArrayList();
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(dV((String)localObject3));
            if (!bool) {
              break label2874;
            }
            i = 3;
            label830:
            ((IDKey)localObject2).SetKey(i);
            ((IDKey)localObject2).SetValue(1L);
            ((ArrayList)localObject1).add(localObject2);
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(dV((String)localObject3));
            if (!bool) {
              break label2880;
            }
            i = 4;
            label878:
            ((IDKey)localObject2).SetKey(i);
            ((IDKey)localObject2).SetValue(l);
            ((ArrayList)localObject1).add(localObject2);
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(dV((String)localObject3));
            ((IDKey)localObject2).SetValue(1L);
            ((ArrayList)localObject1).add(localObject2);
            if (l > 3000L) {
              break label2893;
            }
            if (!bool) {
              break label2886;
            }
            i = 11;
            label951:
            ((IDKey)localObject2).SetKey(i);
            for (;;)
            {
              com.tencent.mm.plugin.report.e.ygI.b((ArrayList)localObject1, true);
              i = 0;
              localObject1 = "";
              break;
              label978:
              ((IDKey)localObject2).SetKey(i);
              continue;
              label988:
              ((IDKey)localObject2).SetKey(i);
              continue;
              label998:
              ((IDKey)localObject2).SetKey(i);
              continue;
              label1008:
              ((IDKey)localObject2).SetKey(i);
            }
          }
          if (!((String)localObject1).equalsIgnoreCase("Trace_FPS")) {
            break label3008;
          }
          localObject1 = paramJSONObject.getString("scene");
          localObject2 = e.cFd;
          p.h(localObject1, "scene");
          p.h(paramJSONObject, "content");
          p.h(localObject1, "scene");
          if (e.dQ((String)localObject1)) {
            break label2996;
          }
          if (!e.dR((String)localObject1)) {
            break label3019;
          }
          break label2996;
          label1082:
          double d;
          int m;
          int n;
          float f;
          if (i != 0)
          {
            d = paramJSONObject.getDouble("fps");
            localObject2 = paramJSONObject.getString("machine");
            p.g(localObject2, "content.getString(DeviceUtil.DEVICE_MACHINE)");
            localObject4 = paramJSONObject.getJSONObject("dropLevel");
            p.g(localObject4, "content.getJSONObject(Sh…ginInfo.ISSUE_DROP_LEVEL)");
            ((JSONObject)localObject4).getInt("DROPPED_BEST");
            j = ((JSONObject)localObject4).getInt("DROPPED_NORMAL");
            k = ((JSONObject)localObject4).getInt("DROPPED_MIDDLE");
            m = ((JSONObject)localObject4).getInt("DROPPED_HIGH");
            n = ((JSONObject)localObject4).getInt("DROPPED_FROZEN");
            i = j + k + m + n;
            f = 1.0F * j / i + 14.0F * k / i + 25.0F * m / i + 60.0F * n / i;
            localObject4 = new ArrayList();
            p.h(localObject1, "scene");
            if (n.e((CharSequence)localObject1, (CharSequence)"FinderTimelineUI")) {
              break label3002;
            }
            if (!n.e((CharSequence)localObject1, (CharSequence)"FinderHomeUI")) {
              break label3025;
            }
            break label3002;
            label1291:
            if (i != 0)
            {
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(e.dS((String)localObject2) + 0);
              ((IDKey)localObject5).SetValue(d);
              ((ArrayList)localObject4).add(localObject5);
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(e.dS((String)localObject2) + 1);
              ((IDKey)localObject5).SetValue(f);
              ((ArrayList)localObject4).add(localObject5);
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(e.dS((String)localObject2) + 4);
              ((IDKey)localObject5).SetValue(1L);
              ((ArrayList)localObject4).add(localObject5);
              label1428:
              g.yhR.b((ArrayList)localObject4, false);
              g.yhR.f(19508, new Object[] { Long.valueOf(d), localObject2, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Float.valueOf(f) });
            }
          }
          else
          {
            i = -1;
            if (!((String)localObject1).endsWith("SnsTimeLineUI")) {
              break label2523;
            }
            i = 0;
          }
          label2523:
          for (;;)
          {
            label1522:
            if (i >= 0)
            {
              d = paramJSONObject.getDouble("fps");
              localObject2 = paramJSONObject.getJSONObject("dropLevel");
              j = ((JSONObject)localObject2).getInt("DROPPED_BEST");
              k = ((JSONObject)localObject2).getInt("DROPPED_NORMAL");
              m = ((JSONObject)localObject2).getInt("DROPPED_MIDDLE");
              n = ((JSONObject)localObject2).getInt("DROPPED_HIGH");
              int i1 = ((JSONObject)localObject2).getInt("DROPPED_FROZEN");
              ad.i("MatrixIdKeyReporter", "[getKeyOffset] scene:%s fps:%s offset:%s", new Object[] { localObject1, Double.valueOf(d), Integer.valueOf(i) });
              localObject1 = new ArrayList();
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(dU((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 47);
              ((IDKey)localObject2).SetValue(1L);
              ((ArrayList)localObject1).add(localObject2);
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(dU((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 48);
              ((IDKey)localObject2).SetValue(d);
              if (((IDKey)localObject2).GetValue() > 0L) {
                ((ArrayList)localObject1).add(localObject2);
              }
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(dU((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 49);
              ((IDKey)localObject2).SetValue(j);
              if (((IDKey)localObject2).GetValue() > 0L)
              {
                ((ArrayList)localObject1).add(localObject2);
                localObject2 = new IDKey();
                ((IDKey)localObject2).SetID(dU((String)localObject3));
                ((IDKey)localObject2).SetKey(i + 54);
                ((IDKey)localObject2).SetValue(1L);
                ((ArrayList)localObject1).add(localObject2);
              }
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(dU((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 50);
              ((IDKey)localObject2).SetValue(k);
              if (((IDKey)localObject2).GetValue() > 0L)
              {
                ((ArrayList)localObject1).add(localObject2);
                localObject2 = new IDKey();
                ((IDKey)localObject2).SetID(dU((String)localObject3));
                ((IDKey)localObject2).SetKey(i + 55);
                ((IDKey)localObject2).SetValue(1L);
                ((ArrayList)localObject1).add(localObject2);
              }
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(dU((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 51);
              ((IDKey)localObject2).SetValue(m);
              if (((IDKey)localObject2).GetValue() > 0L)
              {
                ((ArrayList)localObject1).add(localObject2);
                localObject2 = new IDKey();
                ((IDKey)localObject2).SetID(dU((String)localObject3));
                ((IDKey)localObject2).SetKey(i + 56);
                ((IDKey)localObject2).SetValue(1L);
                ((ArrayList)localObject1).add(localObject2);
              }
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(dU((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 52);
              ((IDKey)localObject2).SetValue(n);
              if (((IDKey)localObject2).GetValue() > 0L)
              {
                ((ArrayList)localObject1).add(localObject2);
                localObject2 = new IDKey();
                ((IDKey)localObject2).SetID(dU((String)localObject3));
                ((IDKey)localObject2).SetKey(i + 57);
                ((IDKey)localObject2).SetValue(1L);
                ((ArrayList)localObject1).add(localObject2);
              }
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(dU((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 53);
              ((IDKey)localObject2).SetValue(i1);
              if (((IDKey)localObject2).GetValue() > 0L)
              {
                ((ArrayList)localObject1).add(localObject2);
                localObject2 = new IDKey();
                ((IDKey)localObject2).SetID(dU((String)localObject3));
                ((IDKey)localObject2).SetKey(i + 58);
                ((IDKey)localObject2).SetValue(1L);
                ((ArrayList)localObject1).add(localObject2);
              }
              com.tencent.mm.plugin.report.e.ygI.b((ArrayList)localObject1, false);
              break label3008;
              if (e.dR((String)localObject1))
              {
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(e.dS((String)localObject2) + 2);
                ((IDKey)localObject5).SetValue(d);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(e.dS((String)localObject2) + 3);
                ((IDKey)localObject5).SetValue(f);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(e.dS((String)localObject2) + 5);
                ((IDKey)localObject5).SetValue(1L);
                ((ArrayList)localObject4).add(localObject5);
                break label1428;
              }
              if (!e.dQ((String)localObject1)) {
                break label1428;
              }
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(e.dT((String)localObject2) + 30);
              ((IDKey)localObject5).SetValue(d);
              ((ArrayList)localObject4).add(localObject5);
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(e.dT((String)localObject2) + 31);
              ((IDKey)localObject5).SetValue(f);
              ((ArrayList)localObject4).add(localObject5);
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(e.dT((String)localObject2) + 32);
              ((IDKey)localObject5).SetValue(1L);
              ((ArrayList)localObject4).add(localObject5);
              break label1428;
              if ((((String)localObject1).endsWith("ChattingUIFragment")) || (((String)localObject1).endsWith("ChattingUI"))) {
                break label3031;
              }
              if (((String)localObject1).endsWith("MainUI"))
              {
                i = 40;
              }
              else if (((String)localObject1).endsWith("FinderHomeUI"))
              {
                i = 100;
              }
              else if (((String)localObject1).endsWith("FinderProfileUI"))
              {
                i = 120;
                continue;
                if ((localObject1 instanceof com.tencent.matrix.iocanary.a))
                {
                  com.tencent.mm.plugin.report.e.ygI.idkeyStat(dU((String)localObject3), 30L, 1L, false);
                  i = 0;
                  localObject1 = "";
                  break;
                }
                if ((localObject1 instanceof SQLiteLintPlugin))
                {
                  com.tencent.mm.plugin.report.e.ygI.idkeyStat(dU((String)localObject3), 31L, 1L, false);
                  if (!"true".equalsIgnoreCase(paramJSONObject.getString("isInMainThread"))) {
                    break label3038;
                  }
                  i = bt.aRe(paramJSONObject.getString("sqlTimeCost"));
                  if (i < 80) {
                    break label3038;
                  }
                  if (i >= 500) {
                    break label3049;
                  }
                  i = 110;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(dU((String)localObject3), i, 1L, false);
      break label3038;
      if ((localObject1 instanceof com.tencent.matrix.a.a))
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(dU((String)localObject3), 32L, 1L, false);
        i = 0;
        localObject1 = "";
        break label478;
      }
      if ((localObject1 instanceof com.tencent.matrix.resource.b))
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(dU((String)localObject3), 33L, 1L, false);
        if (paramJSONObject.getString("activity").endsWith("SnsTimeLineUI")) {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(dU((String)localObject3), 34L, 1L, true);
        }
      }
      i = 0;
      localObject1 = "";
      break label478;
      return;
      localObject1 = null;
      break;
      label2842:
      i = 1;
      localObject1 = localObject2;
      break label478;
      label2852:
      i = 0;
      break label270;
      label2858:
      i = 0;
      break label353;
      label2864:
      i = 0;
      localObject1 = localObject2;
      break label478;
      label2874:
      i = 0;
      break label830;
      label2880:
      i = 1;
      break label878;
      label2886:
      i = 6;
      break label951;
      label2893:
      if (l <= 6000L)
      {
        if (bool)
        {
          i = 12;
          break label978;
        }
        i = 7;
        break label978;
      }
      if (l <= 9000L)
      {
        if (bool)
        {
          i = 13;
          break label988;
        }
        i = 8;
        break label988;
      }
      if (l <= 12000L)
      {
        if (bool)
        {
          i = 14;
          break label998;
        }
        i = 9;
        break label998;
      }
      if (bool)
      {
        i = 15;
        break label1008;
      }
      i = 10;
      break label1008;
      label2996:
      i = 1;
      break label1082;
      label3002:
      i = 1;
      break label1291;
      label3008:
      localObject1 = "";
      label3013:
      i = 0;
      break label478;
      label3019:
      i = 0;
      break label1082;
      label3025:
      i = 0;
      break label1291;
      label3031:
      i = 20;
      break label1522;
      label3038:
      i = 0;
      localObject1 = "";
      break label478;
      label3049:
      if (i < 1000) {
        i = 111;
      } else if (i < 3000) {
        i = 112;
      } else if (i < 5000) {
        i = 113;
      } else {
        i = 114;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.f
 * JD-Core Version:    0.7.0.1
 */