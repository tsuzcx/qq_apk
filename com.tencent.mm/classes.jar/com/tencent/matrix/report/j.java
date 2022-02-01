package com.tencent.matrix.report;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.iocanary.a;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.SQLiteLintPlugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

public final class j
{
  private int eYE = 17108;
  private int eYF = 19999;
  private int eYG = 20841;
  private int eYH = 21019;
  
  private static int hh(String paramString)
  {
    if (paramString.equalsIgnoreCase(MMApplicationContext.getApplicationId())) {
      return 1033;
    }
    if (paramString.equalsIgnoreCase(MMApplicationContext.getApplicationId() + ":tools")) {
      return 1187;
    }
    if (paramString.equalsIgnoreCase(MMApplicationContext.getApplicationId() + ":toolsmp")) {
      return 1188;
    }
    if (paramString.equalsIgnoreCase(MMApplicationContext.getApplicationId() + ":push")) {
      return 1189;
    }
    if (paramString.startsWith(MMApplicationContext.getApplicationId() + ":appbrand")) {
      return 1190;
    }
    return 1191;
  }
  
  private static int hi(String paramString)
  {
    if (paramString.equalsIgnoreCase(MMApplicationContext.getApplicationId())) {
      return 1192;
    }
    if (paramString.equalsIgnoreCase(MMApplicationContext.getApplicationId() + ":tools")) {
      return 1193;
    }
    return 1191;
  }
  
  public final void f(String paramString, JSONObject paramJSONObject)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      try
      {
        localObject3 = paramJSONObject.getString("process");
        Log.i("MatrixIdKeyReporter", "[report] tag:%s processName:%s", new Object[] { paramString, localObject3 });
        if (!com.tencent.matrix.c.isInstalled())
        {
          Log.i("MatrixIdKeyReporter", "matrix not installed");
          return;
        }
        localObject1 = null;
        if (paramString != null)
        {
          if (paramString.startsWith("Trace")) {
            localObject1 = com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
          }
        }
        else
        {
          if (localObject1 != null) {
            break;
          }
          Log.e("MatrixIdKeyReporter", "plugin is null");
          return;
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("MatrixIdKeyReporter", paramString, "data:%s", new Object[] { paramJSONObject.toString() });
        return;
      }
      localObject2 = com.tencent.matrix.c.avW().efL.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (com.tencent.matrix.d.b)((Iterator)localObject2).next();
      } while (!((com.tencent.matrix.d.b)localObject1).getTag().equals(paramString));
    }
    boolean bool;
    Object localObject4;
    Object localObject5;
    int j;
    int k;
    int i;
    if ((localObject1 instanceof com.tencent.matrix.trace.b))
    {
      localObject1 = paramJSONObject.getString("tag");
      Log.i("MatrixIdKeyReporter", "[report] _tag:%s", new Object[] { localObject1 });
      if (((String)localObject1).equalsIgnoreCase("Trace_EvilMethod"))
      {
        localObject2 = paramJSONObject.getString("detail");
        if (((String)localObject2).equalsIgnoreCase(a.a.fdW.toString()))
        {
          bool = paramJSONObject.getBoolean("isProcessForeground");
          localObject4 = paramJSONObject.getString("stackKey");
          localObject5 = paramJSONObject.getString("threadStack");
          localObject1 = paramJSONObject.getString("scene");
          h localh = h.OAn;
          j = this.eYE;
          k = d.Yxh;
          if (!bool) {
            break label3774;
          }
          i = 1;
          label270:
          localh.b(j, new Object[] { paramString, Integer.valueOf(k), localObject2, localObject4, localObject1, localObject5, localObject3, Integer.valueOf(i), BuildInfo.REV });
          localh = h.OAn;
          j = this.eYF;
          k = d.Yxh;
          if (!bool) {
            break label3780;
          }
          i = 1;
          label360:
          localh.b(j, new Object[] { Integer.valueOf(k), localObject2, localObject4, localObject1, localObject5, localObject3, Integer.valueOf(i), BuildInfo.REV });
          if (bool) {
            f.Ozc.idkeyStat(hh((String)localObject3), 1L, 1L, true);
          }
          f.Ozc.idkeyStat(hh((String)localObject3), 0L, 1L, true);
          localObject3 = i.eYD;
          s.u(localObject1, "scene");
          if (!i.hc((String)localObject1)) {
            break label3764;
          }
          h.OAn.p(1343L, 100L, 1L);
          break label3764;
        }
      }
    }
    label492:
    long l1;
    for (;;)
    {
      if ((i == 0) && (!paramString.equalsIgnoreCase("io")) && (!paramString.equalsIgnoreCase("sqlitelint")) && (!paramString.equalsIgnoreCase("battery")))
      {
        h.OAn.b(this.eYE, new Object[] { paramString, Integer.valueOf(d.Yxh), localObject1 });
        return;
        if (((String)localObject2).equalsIgnoreCase(a.a.fdV.toString()))
        {
          localObject1 = paramJSONObject.getString("stackKey");
          localObject4 = paramJSONObject.getString("scene");
          f.Ozc.idkeyStat(hh((String)localObject3), 21L, 1L, true);
          h.OAn.b(this.eYE, new Object[] { paramString, Integer.valueOf(d.Yxh), localObject2, localObject1, localObject4, "null", localObject3 });
          i = 1;
          localObject1 = localObject2;
        }
        else
        {
          if ((!((String)localObject2).equalsIgnoreCase(a.a.fdY.toString())) && (!((String)localObject2).equalsIgnoreCase(a.a.feb.toString())))
          {
            localObject1 = localObject2;
            if (!((String)localObject2).equalsIgnoreCase(a.a.fec.toString())) {
              break label3947;
            }
          }
          localObject1 = paramJSONObject.getString("scene");
          if (!paramJSONObject.getBoolean("isProcessForeground")) {
            break label3786;
          }
          localObject4 = paramJSONObject.getString("threadStack");
          i = 0;
          if (((String)localObject2).equalsIgnoreCase(a.a.fec.toString())) {
            i = 1;
          }
          for (;;)
          {
            h.OAn.b(this.eYG, new Object[] { localObject1, localObject4, Integer.valueOf(1), Integer.valueOf(i), Integer.valueOf(0), localObject3, BuildInfo.REV });
            break;
            if (((String)localObject2).equalsIgnoreCase(a.a.feb.toString())) {
              i = 2;
            }
          }
          if (((String)localObject1).equalsIgnoreCase("Trace_StartUp"))
          {
            l1 = paramJSONObject.getLong("startup_duration");
            bool = paramJSONObject.getBoolean("is_warm_start_up");
            Log.i("MatrixIdKeyReporter", "[startup] duration=%s isWarmStartUp=%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(bool) });
            localObject1 = new ArrayList();
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(hi((String)localObject3));
            if (!bool) {
              break label3796;
            }
            i = 3;
            label933:
            ((IDKey)localObject2).SetKey(i);
            ((IDKey)localObject2).SetValue(1L);
            ((ArrayList)localObject1).add(localObject2);
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(hi((String)localObject3));
            if (!bool) {
              break label3802;
            }
            i = 4;
            label981:
            ((IDKey)localObject2).SetKey(i);
            ((IDKey)localObject2).SetValue(l1);
            ((ArrayList)localObject1).add(localObject2);
            localObject2 = new IDKey();
            ((IDKey)localObject2).SetID(hi((String)localObject3));
            ((IDKey)localObject2).SetValue(1L);
            ((ArrayList)localObject1).add(localObject2);
            if (l1 > 3000L) {
              break label3815;
            }
            j = 1;
            if (!bool) {
              break label3808;
            }
            i = 11;
            label1057:
            ((IDKey)localObject2).SetKey(i);
            i = j;
            for (;;)
            {
              f.Ozc.b((ArrayList)localObject1, true);
              f.Ozc.b(this.eYH, new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Integer.valueOf(i), localObject3 });
              i = 0;
              localObject1 = "";
              break;
              label1131:
              ((IDKey)localObject2).SetKey(i);
              i = j;
              continue;
              label1145:
              ((IDKey)localObject2).SetKey(i);
              i = j;
              continue;
              label1159:
              ((IDKey)localObject2).SetKey(i);
              i = j;
              continue;
              label1173:
              ((IDKey)localObject2).SetKey(i);
              i = j;
            }
          }
          if (!((String)localObject1).equalsIgnoreCase("Trace_FPS")) {
            break label3942;
          }
          localObject1 = paramJSONObject.getString("scene");
          localObject2 = i.eYD;
          s.u(localObject1, "scene");
          s.u(paramJSONObject, "content");
          s.u(localObject1, "scene");
          if ((i.hb((String)localObject1)) || (i.hc((String)localObject1)) || (i.he((String)localObject1)) || (i.hd((String)localObject1)) || (i.ha((String)localObject1))) {
            break label3930;
          }
          if (!i.gZ((String)localObject1)) {
            break label3953;
          }
          break label3930;
          label1283:
          double d;
          int m;
          int n;
          float f;
          if (i != 0)
          {
            d = paramJSONObject.getDouble("fps");
            localObject2 = paramJSONObject.getString("machine");
            s.s(localObject2, "content.getString(DeviceUtil.DEVICE_MACHINE)");
            localObject4 = paramJSONObject.getJSONObject("dropLevel");
            s.s(localObject4, "content.getJSONObject(Sh…ginInfo.ISSUE_DROP_LEVEL)");
            ((JSONObject)localObject4).getInt("DROPPED_BEST");
            j = ((JSONObject)localObject4).getInt("DROPPED_NORMAL");
            k = ((JSONObject)localObject4).getInt("DROPPED_MIDDLE");
            m = ((JSONObject)localObject4).getInt("DROPPED_HIGH");
            n = ((JSONObject)localObject4).getInt("DROPPED_FROZEN");
            i = j + k + m + n;
            f = 1.0F * j / i + 14.0F * k / i + 25.0F * m / i + 60.0F * n / i;
            localObject4 = new ArrayList();
            s.u(localObject1, "scene");
            if (n.i((CharSequence)localObject1, (CharSequence)"FinderHomeUI")) {
              break label3936;
            }
            if (!n.i((CharSequence)localObject1, (CharSequence)"FinderHomeAffinityUI")) {
              break label3959;
            }
            break label3936;
            label1492:
            if (i == 0) {
              break label2468;
            }
            localObject5 = new IDKey();
            ((IDKey)localObject5).SetID(1343);
            ((IDKey)localObject5).SetKey(i.hf((String)localObject2) + 0);
            ((IDKey)localObject5).SetValue(d);
            ((ArrayList)localObject4).add(localObject5);
            localObject5 = new IDKey();
            ((IDKey)localObject5).SetID(1343);
            ((IDKey)localObject5).SetKey(i.hf((String)localObject2) + 1);
            ((IDKey)localObject5).SetValue(f);
            ((ArrayList)localObject4).add(localObject5);
            localObject5 = new IDKey();
            ((IDKey)localObject5).SetID(1343);
            ((IDKey)localObject5).SetKey(i.hf((String)localObject2) + 4);
            ((IDKey)localObject5).SetValue(1L);
            ((ArrayList)localObject4).add(localObject5);
            label1629:
            if (((Collection)localObject4).isEmpty()) {
              break label3965;
            }
            i = 1;
            label1645:
            if (i != 0)
            {
              h.OAn.b((ArrayList)localObject4, false);
              h.OAn.b(19508, new Object[] { Long.valueOf(d), localObject2, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Float.valueOf(f), localObject1 });
            }
          }
          m.g((String)localObject1, paramJSONObject);
          i = -1;
          if (((String)localObject1).endsWith("SnsTimeLineUI")) {
            i = 0;
          }
          label2468:
          for (;;)
          {
            label1756:
            if (i >= 0)
            {
              d = paramJSONObject.getDouble("fps");
              localObject2 = paramJSONObject.getJSONObject("dropLevel");
              j = ((JSONObject)localObject2).getInt("DROPPED_BEST");
              k = ((JSONObject)localObject2).getInt("DROPPED_NORMAL");
              m = ((JSONObject)localObject2).getInt("DROPPED_MIDDLE");
              n = ((JSONObject)localObject2).getInt("DROPPED_HIGH");
              int i1 = ((JSONObject)localObject2).getInt("DROPPED_FROZEN");
              Log.i("MatrixIdKeyReporter", "[getKeyOffset] scene:%s fps:%s offset:%s", new Object[] { localObject1, Double.valueOf(d), Integer.valueOf(i) });
              localObject1 = new ArrayList();
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(hh((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 47);
              ((IDKey)localObject2).SetValue(1L);
              ((ArrayList)localObject1).add(localObject2);
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(hh((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 48);
              ((IDKey)localObject2).SetValue(d);
              if (((IDKey)localObject2).GetValue() > 0L) {
                ((ArrayList)localObject1).add(localObject2);
              }
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(hh((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 49);
              ((IDKey)localObject2).SetValue(j);
              if (((IDKey)localObject2).GetValue() > 0L)
              {
                ((ArrayList)localObject1).add(localObject2);
                localObject2 = new IDKey();
                ((IDKey)localObject2).SetID(hh((String)localObject3));
                ((IDKey)localObject2).SetKey(i + 54);
                ((IDKey)localObject2).SetValue(1L);
                ((ArrayList)localObject1).add(localObject2);
              }
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(hh((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 50);
              ((IDKey)localObject2).SetValue(k);
              if (((IDKey)localObject2).GetValue() > 0L)
              {
                ((ArrayList)localObject1).add(localObject2);
                localObject2 = new IDKey();
                ((IDKey)localObject2).SetID(hh((String)localObject3));
                ((IDKey)localObject2).SetKey(i + 55);
                ((IDKey)localObject2).SetValue(1L);
                ((ArrayList)localObject1).add(localObject2);
              }
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(hh((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 51);
              ((IDKey)localObject2).SetValue(m);
              if (((IDKey)localObject2).GetValue() > 0L)
              {
                ((ArrayList)localObject1).add(localObject2);
                localObject2 = new IDKey();
                ((IDKey)localObject2).SetID(hh((String)localObject3));
                ((IDKey)localObject2).SetKey(i + 56);
                ((IDKey)localObject2).SetValue(1L);
                ((ArrayList)localObject1).add(localObject2);
              }
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(hh((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 52);
              ((IDKey)localObject2).SetValue(n);
              if (((IDKey)localObject2).GetValue() > 0L)
              {
                ((ArrayList)localObject1).add(localObject2);
                localObject2 = new IDKey();
                ((IDKey)localObject2).SetID(hh((String)localObject3));
                ((IDKey)localObject2).SetKey(i + 57);
                ((IDKey)localObject2).SetValue(1L);
                ((ArrayList)localObject1).add(localObject2);
              }
              localObject2 = new IDKey();
              ((IDKey)localObject2).SetID(hh((String)localObject3));
              ((IDKey)localObject2).SetKey(i + 53);
              ((IDKey)localObject2).SetValue(i1);
              if (((IDKey)localObject2).GetValue() > 0L)
              {
                ((ArrayList)localObject1).add(localObject2);
                localObject2 = new IDKey();
                ((IDKey)localObject2).SetID(hh((String)localObject3));
                ((IDKey)localObject2).SetKey(i + 58);
                ((IDKey)localObject2).SetValue(1L);
                ((ArrayList)localObject1).add(localObject2);
              }
              f.Ozc.b((ArrayList)localObject1, false);
              break label3942;
              if (i.hb((String)localObject1))
              {
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 30);
                ((IDKey)localObject5).SetValue(d);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 31);
                ((IDKey)localObject5).SetValue(f);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 32);
                ((IDKey)localObject5).SetValue(1L);
                ((ArrayList)localObject4).add(localObject5);
                break label1629;
              }
              if (i.hd((String)localObject1))
              {
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 50);
                ((IDKey)localObject5).SetValue(d);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 51);
                ((IDKey)localObject5).SetValue(f);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 52);
                ((IDKey)localObject5).SetValue(1L);
                ((ArrayList)localObject4).add(localObject5);
                break label1629;
              }
              if (i.he((String)localObject1))
              {
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 70);
                ((IDKey)localObject5).SetValue(d);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 71);
                ((IDKey)localObject5).SetValue(f);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 72);
                ((IDKey)localObject5).SetValue(1L);
                ((ArrayList)localObject4).add(localObject5);
                break label1629;
              }
              if (i.gZ((String)localObject1))
              {
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 110);
                ((IDKey)localObject5).SetValue(d);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 111);
                ((IDKey)localObject5).SetValue(f);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 112);
                ((IDKey)localObject5).SetValue(1L);
                ((ArrayList)localObject4).add(localObject5);
                break label1629;
              }
              if (i.ha((String)localObject1))
              {
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 130);
                ((IDKey)localObject5).SetValue(d);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 131);
                ((IDKey)localObject5).SetValue(f);
                ((ArrayList)localObject4).add(localObject5);
                localObject5 = new IDKey();
                ((IDKey)localObject5).SetID(1343);
                ((IDKey)localObject5).SetKey(i.hg((String)localObject2) + 132);
                ((IDKey)localObject5).SetValue(1L);
                ((ArrayList)localObject4).add(localObject5);
                break label1629;
              }
              if (!i.hc((String)localObject1)) {
                break label1629;
              }
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(i.hf((String)localObject2) + 2);
              ((IDKey)localObject5).SetValue(d);
              ((ArrayList)localObject4).add(localObject5);
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(i.hf((String)localObject2) + 3);
              ((IDKey)localObject5).SetValue(f);
              ((ArrayList)localObject4).add(localObject5);
              localObject5 = new IDKey();
              ((IDKey)localObject5).SetID(1343);
              ((IDKey)localObject5).SetKey(i.hf((String)localObject2) + 5);
              ((IDKey)localObject5).SetValue(1L);
              ((ArrayList)localObject4).add(localObject5);
              break label1629;
              if ((((String)localObject1).endsWith("ChattingUIFragment")) || (((String)localObject1).endsWith("ChattingUI"))) {
                break label3971;
              }
              if (((String)localObject1).endsWith("MainUI"))
              {
                i = 40;
              }
              else
              {
                if ((((String)localObject1).endsWith("FinderHomeUI")) || (((String)localObject1).endsWith("FinderHomeAffinityUI"))) {
                  break label3978;
                }
                if (((String)localObject1).endsWith("FinderProfileUI"))
                {
                  i = 120;
                }
                else if (((String)localObject1).endsWith("FinderTimelineLbsUI"))
                {
                  i = 140;
                }
                else if (((String)localObject1).endsWith("AddressUI"))
                {
                  i = 160;
                  continue;
                  if ((localObject1 instanceof a))
                  {
                    f.Ozc.idkeyStat(hh((String)localObject3), 30L, 1L, false);
                    localObject1 = paramJSONObject.getString("path");
                    localObject2 = paramJSONObject.getString("stack");
                    l1 = paramJSONObject.getLong("cost");
                    long l2 = paramJSONObject.getLong("size");
                    i = paramJSONObject.getInt("opType");
                    f.Ozc.b(23047, new Object[] { localObject1, localObject2, Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
                    i = 0;
                    localObject1 = "";
                    break;
                  }
                  if ((localObject1 instanceof SQLiteLintPlugin))
                  {
                    f.Ozc.idkeyStat(hh((String)localObject3), 31L, 1L, false);
                    if (!"true".equalsIgnoreCase(paramJSONObject.getString("isInMainThread"))) {
                      break label3985;
                    }
                    i = Util.safeParseInt(paramJSONObject.getString("sqlTimeCost"));
                    if (i < 80) {
                      break label3985;
                    }
                    if (i >= 500) {
                      break label3996;
                    }
                    i = 110;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      f.Ozc.idkeyStat(hh((String)localObject3), i, 1L, false);
      break label3985;
      if ((localObject1 instanceof com.tencent.matrix.resource.c))
      {
        f.Ozc.idkeyStat(hh((String)localObject3), 33L, 1L, false);
        if (paramJSONObject.getString("activity").endsWith("SnsTimeLineUI")) {
          f.Ozc.idkeyStat(hh((String)localObject3), 34L, 1L, true);
        }
      }
      i = 0;
      localObject1 = "";
      break label492;
      return;
      localObject1 = null;
      break;
      label3764:
      i = 1;
      localObject1 = localObject2;
      break label492;
      label3774:
      i = 0;
      break label270;
      label3780:
      i = 0;
      break label360;
      label3786:
      i = 0;
      localObject1 = localObject2;
      break label492;
      label3796:
      i = 0;
      break label933;
      label3802:
      i = 1;
      break label981;
      label3808:
      i = 6;
      break label1057;
      label3815:
      if (l1 <= 6000L)
      {
        j = 2;
        if (bool)
        {
          i = 12;
          break label1131;
        }
        i = 7;
        break label1131;
      }
      if (l1 <= 9000L)
      {
        j = 3;
        if (bool)
        {
          i = 13;
          break label1145;
        }
        i = 8;
        break label1145;
      }
      if (l1 <= 12000L)
      {
        j = 4;
        if (bool)
        {
          i = 14;
          break label1159;
        }
        i = 9;
        break label1159;
      }
      j = 5;
      if (bool)
      {
        i = 15;
        break label1173;
      }
      i = 10;
      break label1173;
      label3930:
      i = 1;
      break label1283;
      label3936:
      i = 1;
      break label1492;
      label3942:
      localObject1 = "";
      label3947:
      i = 0;
      break label492;
      label3953:
      i = 0;
      break label1283;
      label3959:
      i = 0;
      break label1492;
      label3965:
      i = 0;
      break label1645;
      label3971:
      i = 20;
      break label1756;
      label3978:
      i = 100;
      break label1756;
      label3985:
      i = 0;
      localObject1 = "";
      break label492;
      label3996:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.j
 * JD-Core Version:    0.7.0.1
 */