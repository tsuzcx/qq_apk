package com.tencent.matrix.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import d.g.b.k;
import d.n.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public final class f
{
  private int cuj = 17108;
  private int cuk = 19999;
  
  private static int cR(String paramString)
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
  
  private static int cS(String paramString)
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
        ac.i("MatrixIdKeyReporter", "[report] tag:%s processName:%s", new Object[] { paramString, localObject3 });
        if (!com.tencent.matrix.b.Gp())
        {
          ac.i("MatrixIdKeyReporter", "matrix not installed");
          return;
        }
        localObject1 = null;
        if (paramString != null)
        {
          if (paramString.startsWith("Trace")) {
            localObject1 = com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class);
          }
        }
        else
        {
          if (localObject1 != null) {
            break;
          }
          ac.e("MatrixIdKeyReporter", "plugin is null");
          return;
        }
      }
      catch (Exception paramString)
      {
        ac.printErrStackTrace("MatrixIdKeyReporter", paramString, "data:%s", new Object[] { paramJSONObject.toString() });
        return;
      }
      localObject2 = com.tencent.matrix.b.Gq().cqk.iterator();
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
      ac.i("MatrixIdKeyReporter", "[report] _tag:%s", new Object[] { localObject1 });
      if (((String)localObject1).equalsIgnoreCase("Trace_EvilMethod"))
      {
        localObject2 = paramJSONObject.getString("detail");
        if (((String)localObject2).equalsIgnoreCase(a.a.cyS.toString()))
        {
          bool = paramJSONObject.getBoolean("isProcessForeground");
          localObject4 = paramJSONObject.getString("stackKey");
          localObject5 = paramJSONObject.getString("threadStack");
          localObject1 = paramJSONObject.getString("scene");
          h localh = h.wUl;
          j = this.cuj;
          k = d.DIc;
          if (!bool) {
            break label2733;
          }
          i = 1;
          label270:
          localh.f(j, new Object[] { paramString, Integer.valueOf(k), localObject2, localObject4, localObject1, localObject5, localObject3, Integer.valueOf(i) });
          localh = h.wUl;
          j = this.cuk;
          k = d.DIc;
          if (!bool) {
            break label2739;
          }
          i = 1;
          label353:
          localh.f(j, new Object[] { Integer.valueOf(k), localObject2, localObject4, localObject1, localObject5, localObject3, Integer.valueOf(i) });
          if (bool) {
            com.tencent.mm.plugin.report.e.wTc.idkeyStat(cR((String)localObject3), 1L, 1L, true);
          }
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(cR((String)localObject3), 0L, 1L, true);
          localObject3 = e.cui;
          k.h(localObject1, "scene");
          if (!e.cO((String)localObject1)) {
            break label2723;
          }
          h.wUl.n(1343L, 100L, 1L);
          break label2723;
        }
      }
    }
    label478:
    long l;
    for (;;)
    {
      if ((i == 0) && (!paramString.equalsIgnoreCase("io")) && (!paramString.equalsIgnoreCase("sqlitelint")) && (!paramString.equalsIgnoreCase("battery")))
      {
        h.wUl.f(this.cuj, new Object[] { paramString, Integer.valueOf(d.DIc), localObject1 });
        return;
        localObject1 = localObject2;
        if (!((String)localObject2).equalsIgnoreCase(a.a.cyR.toString())) {
          break label2884;
        }
        localObject1 = paramJSONObject.getString("stackKey");
        localObject4 = paramJSONObject.getString("scene");
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(cR((String)localObject3), 21L, 1L, true);
        h.wUl.f(this.cuj, new Object[] { paramString, Integer.valueOf(d.DIc), localObject2, localObject1, localObject4, "null", localObject3 });
        i = 1;
        localObject1 = localObject2;
        continue;
        if (((String)localObject1).equalsIgnoreCase("Trace_StartUp"))
        {
          l = paramJSONObject.getLong("startup_duration");
          bool = paramJSONObject.getBoolean("is_warm_start_up");
          ac.i("MatrixIdKeyReporter", "[startup] duration=%s isWarmStartUp=%s", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
          localObject1 = new ArrayList();
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(cS((String)localObject3));
          if (!bool) {
            break label2745;
          }
          i = 3;
          label747:
          ((IDKey)localObject2).SetKey(i);
          ((IDKey)localObject2).SetValue(1L);
          ((ArrayList)localObject1).add(localObject2);
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(cS((String)localObject3));
          if (!bool) {
            break label2751;
          }
          i = 4;
          label795:
          ((IDKey)localObject2).SetKey(i);
          ((IDKey)localObject2).SetValue(l);
          ((ArrayList)localObject1).add(localObject2);
          localObject2 = new IDKey();
          ((IDKey)localObject2).SetID(cS((String)localObject3));
          ((IDKey)localObject2).SetValue(1L);
          ((ArrayList)localObject1).add(localObject2);
          if (l > 3000L) {
            break label2764;
          }
          if (!bool) {
            break label2757;
          }
          i = 11;
          label868:
          ((IDKey)localObject2).SetKey(i);
          for (;;)
          {
            com.tencent.mm.plugin.report.e.wTc.b((ArrayList)localObject1, true);
            i = 0;
            localObject1 = "";
            break;
            label895:
            ((IDKey)localObject2).SetKey(i);
            continue;
            label905:
            ((IDKey)localObject2).SetKey(i);
            continue;
            label915:
            ((IDKey)localObject2).SetKey(i);
            continue;
            label925:
            ((IDKey)localObject2).SetKey(i);
          }
        }
        if (!((String)localObject1).equalsIgnoreCase("Trace_FPS")) {
          break label2879;
        }
        localObject1 = paramJSONObject.getString("scene");
        localObject2 = e.cui;
        k.h(localObject1, "scene");
        k.h(paramJSONObject, "content");
        k.h(localObject1, "scene");
        if (e.cN((String)localObject1)) {
          break label2867;
        }
        if (!e.cO((String)localObject1)) {
          break label2890;
        }
        break label2867;
        label999:
        double d;
        int m;
        int n;
        float f;
        if (i != 0)
        {
          d = paramJSONObject.getDouble("fps");
          localObject2 = paramJSONObject.getString("machine");
          k.g(localObject2, "content.getString(DeviceUtil.DEVICE_MACHINE)");
          localObject4 = paramJSONObject.getJSONObject("dropLevel");
          k.g(localObject4, "content.getJSONObject(Sh…ginInfo.ISSUE_DROP_LEVEL)");
          ((JSONObject)localObject4).getInt("DROPPED_BEST");
          j = ((JSONObject)localObject4).getInt("DROPPED_NORMAL");
          k = ((JSONObject)localObject4).getInt("DROPPED_MIDDLE");
          m = ((JSONObject)localObject4).getInt("DROPPED_HIGH");
          n = ((JSONObject)localObject4).getInt("DROPPED_FROZEN");
          i = j + k + m + n;
          f = 1.0F * j / i + 14.0F * k / i + 25.0F * m / i + 60.0F * n / i;
          localObject4 = new ArrayList();
          k.h(localObject1, "scene");
          if (n.e((CharSequence)localObject1, (CharSequence)"FinderTimelineUI")) {
            break label2873;
          }
          if (!n.e((CharSequence)localObject1, (CharSequence)"FinderHomeUI")) {
            break label2896;
          }
          break label2873;
          label1208:
          if (i != 0)
          {
            localObject5 = new IDKey();
            ((IDKey)localObject5).SetID(1343);
            ((IDKey)localObject5).SetKey(e.cP((String)localObject2) + 0);
            ((IDKey)localObject5).SetValue(d);
            ((ArrayList)localObject4).add(localObject5);
            localObject5 = new IDKey();
            ((IDKey)localObject5).SetID(1343);
            ((IDKey)localObject5).SetKey(e.cP((String)localObject2) + 1);
            ((IDKey)localObject5).SetValue(f);
            ((ArrayList)localObject4).add(localObject5);
            localObject5 = new IDKey();
            ((IDKey)localObject5).SetID(1343);
            ((IDKey)localObject5).SetKey(e.cP((String)localObject2) + 4);
            ((IDKey)localObject5).SetValue(1L);
            ((ArrayList)localObject4).add(localObject5);
            label1345:
            h.wUl.b((ArrayList)localObject4, false);
            h.wUl.f(19508, new Object[] { Long.valueOf(d), localObject2, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Float.valueOf(f) });
          }
        }
        else
        {
          i = -1;
          if (!((String)localObject1).endsWith("SnsTimeLineUI")) {
            break label2440;
          }
          i = 0;
        }
        label2440:
        for (;;)
        {
          label1439:
          if (i >= 0)
          {
            d = paramJSONObject.getDouble("fps");
            localObject2 = paramJSONObject.getJSONObject("dropLevel");
            j = ((JSONObject)localObject2).getInt("DROPPED_BEST");
            k = ((JSONObject)localObject2).getInt("DROPPED_NORMAL");
            m = ((JSONObject)localObject2).getInt("DROPPED_MIDDLE");
            n = ((JSONObject)localObject2).getInt("DROPPED_HIGH");
            int i1 = ((JSONObject)localObject2).getInt("DROPPED_FROZEN");
            ac.i("MatrixIdKeyReporter", "[getKeyOffset] scene:%s fps:%s offset:%s", new Object[] { localObject1, Double.valueOf(d), Integer.valueOf(i) });
            localObject1 = new ArrayList();
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(cR((String)localObject3));
            ((IDKey)localObject2).SetKey(i + 47);
            ((IDKey)localObject2).SetValue(1L);
            ((ArrayList)localObject1).add(localObject2);
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(cR((String)localObject3));
            ((IDKey)localObject2).SetKey(i + 48);
            ((IDKey)localObject2).SetValue(d);
            if (((IDKey)localObject2).GetValue() > 0L) {
              ((ArrayList)localObject1).add(localObject2);
            }
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(cR((String)localObject3));
            ((IDKey)localObject2).SetKey(i + 49);
            ((IDKey)localObject2).SetValue(j);
            if (((IDKey)localObject2).GetValue() > 0L)
            {
              ((ArrayList)localObject1).add(localObject2);
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(cR((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 54);
              ((IDKey)localObject2).SetValue(1L);
              ((ArrayList)localObject1).add(localObject2);
            }
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(cR((String)localObject3));
            ((IDKey)localObject2).SetKey(i + 50);
            ((IDKey)localObject2).SetValue(k);
            if (((IDKey)localObject2).GetValue() > 0L)
            {
              ((ArrayList)localObject1).add(localObject2);
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(cR((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 55);
              ((IDKey)localObject2).SetValue(1L);
              ((ArrayList)localObject1).add(localObject2);
            }
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(cR((String)localObject3));
            ((IDKey)localObject2).SetKey(i + 51);
            ((IDKey)localObject2).SetValue(m);
            if (((IDKey)localObject2).GetValue() > 0L)
            {
              ((ArrayList)localObject1).add(localObject2);
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(cR((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 56);
              ((IDKey)localObject2).SetValue(1L);
              ((ArrayList)localObject1).add(localObject2);
            }
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(cR((String)localObject3));
            ((IDKey)localObject2).SetKey(i + 52);
            ((IDKey)localObject2).SetValue(n);
            if (((IDKey)localObject2).GetValue() > 0L)
            {
              ((ArrayList)localObject1).add(localObject2);
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(cR((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 57);
              ((IDKey)localObject2).SetValue(1L);
              ((ArrayList)localObject1).add(localObject2);
            }
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(cR((String)localObject3));
            ((IDKey)localObject2).SetKey(i + 53);
            ((IDKey)localObject2).SetValue(i1);
            if (((IDKey)localObject2).GetValue() > 0L)
            {
              ((ArrayList)localObject1).add(localObject2);
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(cR((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 58);
              ((IDKey)localObject2).SetValue(1L);
              ((ArrayList)localObject1).add(localObject2);
            }
            com.tencent.mm.plugin.report.e.wTc.b((ArrayList)localObject1, false);
            break label2879;
            if (e.cO((String)localObject1))
            {
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(e.cP((String)localObject2) + 2);
              ((IDKey)localObject5).SetValue(d);
              ((ArrayList)localObject4).add(localObject5);
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(e.cP((String)localObject2) + 3);
              ((IDKey)localObject5).SetValue(f);
              ((ArrayList)localObject4).add(localObject5);
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(e.cP((String)localObject2) + 5);
              ((IDKey)localObject5).SetValue(1L);
              ((ArrayList)localObject4).add(localObject5);
              break label1345;
            }
            if (!e.cN((String)localObject1)) {
              break label1345;
            }
            localObject5 = new IDKey();
            ((IDKey)localObject5).SetID(1343);
            ((IDKey)localObject5).SetKey(e.cQ((String)localObject2) + 30);
            ((IDKey)localObject5).SetValue(d);
            ((ArrayList)localObject4).add(localObject5);
            localObject5 = new IDKey();
            ((IDKey)localObject5).SetID(1343);
            ((IDKey)localObject5).SetKey(e.cQ((String)localObject2) + 31);
            ((IDKey)localObject5).SetValue(f);
            ((ArrayList)localObject4).add(localObject5);
            localObject5 = new IDKey();
            ((IDKey)localObject5).SetID(1343);
            ((IDKey)localObject5).SetKey(e.cQ((String)localObject2) + 32);
            ((IDKey)localObject5).SetValue(1L);
            ((ArrayList)localObject4).add(localObject5);
            break label1345;
            if ((((String)localObject1).endsWith("ChattingUIFragment")) || (((String)localObject1).endsWith("ChattingUI"))) {
              break label2902;
            }
            if (((String)localObject1).endsWith("MainUI"))
            {
              i = 40;
              continue;
              if ((localObject1 instanceof com.tencent.matrix.iocanary.a))
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(cR((String)localObject3), 30L, 1L, false);
                i = 0;
                localObject1 = "";
                break;
              }
              if ((localObject1 instanceof SQLiteLintPlugin))
              {
                com.tencent.mm.plugin.report.e.wTc.idkeyStat(cR((String)localObject3), 31L, 1L, false);
                if (!"true".equalsIgnoreCase(paramJSONObject.getString("isInMainThread"))) {
                  break label2909;
                }
                i = bs.aLy(paramJSONObject.getString("sqlTimeCost"));
                if (i < 80) {
                  break label2909;
                }
                if (i >= 500) {
                  break label2920;
                }
                i = 110;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(cR((String)localObject3), i, 1L, false);
      break label2909;
      if ((localObject1 instanceof com.tencent.matrix.a.a))
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(cR((String)localObject3), 32L, 1L, false);
        i = 0;
        localObject1 = "";
        break label478;
      }
      if ((localObject1 instanceof com.tencent.matrix.resource.b))
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(cR((String)localObject3), 33L, 1L, false);
        if (paramJSONObject.getString("activity").endsWith("SnsTimeLineUI")) {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(cR((String)localObject3), 34L, 1L, true);
        }
      }
      i = 0;
      localObject1 = "";
      break label478;
      return;
      localObject1 = null;
      break;
      label2723:
      i = 1;
      localObject1 = localObject2;
      break label478;
      label2733:
      i = 0;
      break label270;
      label2739:
      i = 0;
      break label353;
      label2745:
      i = 0;
      break label747;
      label2751:
      i = 1;
      break label795;
      label2757:
      i = 6;
      break label868;
      label2764:
      if (l <= 6000L)
      {
        if (bool)
        {
          i = 12;
          break label895;
        }
        i = 7;
        break label895;
      }
      if (l <= 9000L)
      {
        if (bool)
        {
          i = 13;
          break label905;
        }
        i = 8;
        break label905;
      }
      if (l <= 12000L)
      {
        if (bool)
        {
          i = 14;
          break label915;
        }
        i = 9;
        break label915;
      }
      if (bool)
      {
        i = 15;
        break label925;
      }
      i = 10;
      break label925;
      label2867:
      i = 1;
      break label999;
      label2873:
      i = 1;
      break label1208;
      label2879:
      localObject1 = "";
      label2884:
      i = 0;
      break label478;
      label2890:
      i = 0;
      break label999;
      label2896:
      i = 0;
      break label1208;
      label2902:
      i = 20;
      break label1439;
      label2909:
      i = 0;
      localObject1 = "";
      break label478;
      label2920:
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