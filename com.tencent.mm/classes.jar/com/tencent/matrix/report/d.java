package com.tencent.matrix.report;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.f.e;
import com.tencent.matrix.a.a.a.b.a;
import com.tencent.matrix.a.a.a.g.b;
import com.tencent.matrix.a.a.a.g.b.b;
import com.tencent.matrix.a.a.a.i;
import com.tencent.matrix.a.a.a.j.a.a;
import com.tencent.matrix.a.a.a.j.a.c.b;
import com.tencent.matrix.a.a.a.j.a.c.c;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.k.c;
import com.tencent.matrix.a.b.k.c.a;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.z;
import com.tencent.mm.sdk.platformtools.AppBrands;
import com.tencent.mm.sdk.platformtools.AppBrands.AppBrandAppInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class d
{
  public static int VO()
  {
    return cU(AppForegroundDelegate.fby.cQt);
  }
  
  public static String Xs()
  {
    String str = MMApplicationContext.getProcessName();
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    if (str.contains(":"))
    {
      int i = str.lastIndexOf(":");
      return str.substring(":".length() + i);
    }
    return "main";
  }
  
  public static String Xt()
  {
    Object localObject1;
    Object localObject2;
    if (AppBrands.isAppBrandProc())
    {
      localObject1 = AppBrands.getAppBrandInfo();
      if ((localObject1 != null) && (!TextUtils.isEmpty(((AppBrands.AppBrandAppInfo)localObject1).appName))) {
        localObject2 = ((AppBrands.AppBrandAppInfo)localObject1).appName;
      }
    }
    do
    {
      return localObject2;
      localObject1 = AppForegroundDelegate.fby;
      localObject2 = AppForegroundDelegate.aaw();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = com.tencent.matrix.a.cQs.cQu;
      }
      localObject2 = localObject1;
    } while (!((String)localObject1).contains("@"));
    return ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("@"));
  }
  
  @SuppressLint({"RestrictedApi"})
  public static int Xu()
  {
    Context localContext = MMApplicationContext.getContext();
    if (b.bo(localContext)) {
      return 1;
    }
    if (!b.bp(localContext)) {
      return 3;
    }
    if (b.bq(localContext)) {
      return 4;
    }
    return 2;
  }
  
  @SuppressLint({"RestrictedApi"})
  public static int cU(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    if (b.br(MMApplicationContext.getContext())) {
      return 3;
    }
    if (z.abb().abc()) {
      return 4;
    }
    return 2;
  }
  
  public static final class a
  {
    public static void cV(boolean paramBoolean)
    {
      com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Iyx;
      if (paramBoolean) {}
      for (long l = 101L;; l = 100L)
      {
        localf.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void cW(boolean paramBoolean)
    {
      com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Iyx;
      if (paramBoolean) {}
      for (long l = 0L;; l = 1L)
      {
        localf.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void cX(boolean paramBoolean)
    {
      com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Iyx;
      if (paramBoolean) {}
      for (long l = 2L;; l = 3L)
      {
        localf.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void cY(boolean paramBoolean)
    {
      com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Iyx;
      if (paramBoolean) {}
      for (long l = 4L;; l = 5L)
      {
        localf.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void cZ(boolean paramBoolean)
    {
      com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Iyx;
      if (paramBoolean) {}
      for (long l = 63L;; l = 64L)
      {
        localf.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void jD(int paramInt)
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, paramInt, 1L, false);
    }
  }
  
  @SuppressLint({"RestrictedApi"})
  public static final class b
  {
    private static final int cZU;
    private static final int cZV = 1;
    
    static
    {
      com.tencent.matrix.c.a.Xf();
      cZU = 0;
      com.tencent.matrix.c.a.Xf();
    }
    
    static boolean K(String paramString, int paramInt)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = com.tencent.matrix.c.a.WS();
        if (localObject != null)
        {
          localObject = ((com.tencent.matrix.a.c)localObject).cSM.cUb.cTW;
          if (paramInt == Process.myPid()) {
            return (((List)localObject).contains("all")) || (((List)localObject).contains("main"));
          }
          if (((List)localObject).contains("all"))
          {
            localObject = Thread.getAllStackTraces().keySet().iterator();
            do
            {
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
            } while (!((Thread)((Iterator)localObject).next()).getName().contains(paramString));
            return true;
          }
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (((String)((Iterator)localObject).next()).contains(paramString)) {
              return true;
            }
          }
        }
      }
      return false;
    }
    
    private static void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, long paramLong1, String paramString4, long paramLong2, String paramString5, long paramLong3, String paramString6, String paramString7, long paramLong4, long paramLong5, long paramLong6)
    {
      if (paramBoolean) {
        Log.i("Matrix.battery.BatteryReporter", "#kvPost, data: \n\ttype = " + paramInt1 + "\n, version = 5\n, proc = " + paramString1 + "\n, extra = " + paramString2 + "\n, appStat = " + paramInt2 + "\n, devStat = " + paramInt3 + "\n, keyDgt1 = " + paramString3 + "\n, valDgt1 = " + paramLong1 + "\n, keyDgt2 = " + paramString4 + "\n, valDgt2 = " + paramLong2 + "\n, keyDgt3 = " + paramString5 + "\n, valDgt3 " + paramLong3 + "\n, scene = " + paramString6 + "\n, stack = " + paramString7 + "\n, extraDigit1 = " + paramLong4 + "\n, extraDigit2 = " + paramLong5 + "\n, extraDigit3 = " + paramLong6);
      }
      com.tencent.mm.plugin.report.f.Iyx.a(21468, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(5), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Long.valueOf(paramLong1), paramString4, Long.valueOf(paramLong2), paramString5, Long.valueOf(paramLong3), paramString6, paramString7, Long.valueOf(paramLong4), Long.valueOf(paramLong5), Long.valueOf(paramLong6) });
    }
    
    public static String ft(String paramString)
    {
      String str = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        if (!paramString.contains("[GT]ColdPool#")) {
          break label23;
        }
        str = "[GT]ColdPool";
      }
      label23:
      do
      {
        return str;
        if (paramString.contains("[GT]HotPool#")) {
          return "[GT]HotPool";
        }
        str = paramString;
      } while (!paramString.contains("mars::"));
      return "mars::xxx";
    }
    
    static boolean fu(String paramString)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty(paramString)) {
        if (!paramString.contains("[GT]ColdPool#"))
        {
          bool1 = bool2;
          if (!paramString.contains("[GT]HotPool#")) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    
    public static final class a
    {
      public static void a(j.a.a<b.a> parama, String paramString)
      {
        long l1 = Math.max(1L, parama.cWp / 60000L);
        long l2 = ((Long)((b.a)parama.cWo).cUC.cWu).longValue() / l1;
        if (l2 < com.tencent.matrix.c.a.Xb()) {}
        com.tencent.matrix.a.a.a locala;
        do
        {
          return;
          locala = com.tencent.matrix.a.a.a.bl(parama.cWp);
        } while ((!locala.cSY) || (locala.isCharging()) || (locala.cSO <= com.tencent.matrix.c.a.WW()));
        String str = d.Xs();
        int m = locala.VO();
        int n = locala.VP();
        int i = locala.cSV;
        paramString = new StringBuilder(paramString);
        Object localObject = (i)com.tencent.matrix.a.a.Z(i.class);
        int j;
        label286:
        int k;
        if (localObject != null)
        {
          long l3 = ((Long)((b.a)parama.cWo).cUC.cWu).longValue();
          long l4 = ((Long)((b.a)parama.cWn).cUC.cWu).longValue();
          j = ((b.a)parama.cWo).tid;
          if (l4 > 0L) {
            if (((i)localObject).jr(j) != null)
            {
              localObject = ((i)localObject).h(j, l3, l4);
              if ((localObject != null) && (((k.c)localObject).cWl))
              {
                j = 0;
                k.c.a locala1 = ((k.c)localObject).WH();
                if (locala1 != null) {
                  if ((!TextUtils.isEmpty(locala1.key)) && (!locala1.key.equals("thread_pool@idle")))
                  {
                    paramString = new StringBuilder(locala1.key);
                    i = locala1.ratio;
                    j = 1;
                    k = i;
                    localObject = paramString;
                    if (j != 0)
                    {
                      Log.i("Matrix.battery.BatteryReporter", " #overHeat reportJiffies found task: name = " + paramString + ", ratio = " + i);
                      localObject = paramString;
                      k = i;
                    }
                    label332:
                    com.tencent.matrix.c.a.Xg();
                    paramString = (String)localObject;
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          Log.i("Matrix.battery.BatteryReporter", "#reportInternalJiffies");
          d.b.a(d.b.cZV, str, paramString.toString(), m, n, "avgSelfJiffiesException", l2, "matrix_default_", ((Long)((b.a)parama.cWn).cUC.cWu).longValue(), "duringMin", l1, locala.cSU, "", locala.cSO, locala.cSQ, k);
          return;
          localObject = ((k.c)localObject).WI();
          if ((localObject != null) && (!TextUtils.isEmpty(((k.c.a)localObject).key)) && (!((k.c.a)localObject).key.equals("thread_pool@idle")))
          {
            paramString = new StringBuilder(((k.c.a)localObject).key);
            i = ((k.c.a)localObject).ratio;
            j = 1;
            break label286;
          }
          break label286;
          k = i;
          localObject = paramString;
          break label332;
          localObject = null;
          break;
          k = i;
        }
      }
      
      public static void a(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3)
      {
        com.tencent.matrix.a.a.a locala = com.tencent.matrix.a.a.a.bl(paramLong3);
        if (!locala.cSY) {}
        while ((locala.isCharging()) || (locala.cSO <= com.tencent.matrix.c.a.WW())) {
          return;
        }
        String str4 = d.Xs();
        String str1;
        int i;
        int j;
        int k;
        String str2;
        label82:
        long l;
        label89:
        String str3;
        if (paramBoolean)
        {
          str1 = "wifi";
          i = locala.VO();
          j = locala.VP();
          Log.i("Matrix.battery.BatteryReporter", "#reportTrafficException");
          k = d.b.access$100();
          if (!paramBoolean) {
            break label166;
          }
          str2 = "avgWifiException";
          if (!paramBoolean) {
            break label173;
          }
          l = paramLong1;
          if (!paramBoolean) {
            break label179;
          }
          str3 = "avgRadio";
          label97:
          if (!paramBoolean) {
            break label186;
          }
        }
        for (;;)
        {
          d.b.a(k, str4, str1, i, j, str2, l, str3, paramLong2, "duringMin", Math.max(1L, paramLong3 / 60000L), locala.cSU, "", locala.cSO, locala.cSQ, locala.cSV);
          return;
          str1 = "mobile";
          break;
          label166:
          str2 = "avgRadioException";
          break label82;
          label173:
          l = paramLong2;
          break label89;
          label179:
          str3 = "avgWifi";
          break label97;
          label186:
          paramLong2 = paramLong1;
        }
      }
      
      public static void a(boolean paramBoolean, j.a.a<b.a> parama)
      {
        String str = d.Xs();
        Object localObject1 = new StringBuilder();
        int i = ((b.a)parama.cWo).cUD;
        int j = ((b.a)parama.cWo).cUE;
        long l1 = Math.max(1L, parama.cWp / 60000L);
        long l2 = ((Long)((b.a)parama.cWo).cUC.cWu).longValue() / l1;
        Log.i("Matrix.battery.BatteryReporter", "#reportTaskJiffies");
        localObject1 = ((StringBuilder)localObject1).append("finish=").append(((b.a)parama.cWo).isFinished);
        int k = b.bk(MMApplicationContext.getContext());
        ((StringBuilder)localObject1).append("|batTemp=").append(k);
        Object localObject2 = b.WB();
        if (localObject2.length > 0) {
          ((StringBuilder)localObject1).append("|cupFreq=").append(Arrays.toString((int[])localObject2));
        }
        k = d.b.cZV;
        localObject2 = ((StringBuilder)localObject1).toString();
        if (paramBoolean) {}
        for (localObject1 = "avgTaskJiffiesLongException";; localObject1 = "avgTaskJiffiesException")
        {
          d.b.a(k, str, (String)localObject2, i, j, (String)localObject1, l2, ((b.a)parama.cWo).name, ((Long)((b.a)parama.cWn).cUC.cWu).longValue(), "duringMin", l1, ((b.a)parama.cWo).scene, "", ((b.a)parama.cWo).cUF, ((b.a)parama.cWo).cUG, ((b.a)parama.cWo).cUH);
          return;
        }
      }
      
      public static void a(boolean paramBoolean, com.tencent.matrix.a.a.a parama, j.a.a<g.b> parama1)
      {
        if (((g.b)parama1.cWo).cVQ.list.isEmpty())
        {
          Log.w("Matrix.battery.BatteryReporter", "#reportJiffiesException invalid, thread list is empty!");
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1540L, 15L, 1L, false);
          return;
        }
        long l4 = Math.max(1L, parama1.cWp / 60000L);
        int m = parama.VO();
        int n = parama.VP();
        int i = parama.cSV;
        String str1 = d.Xs();
        Object localObject2 = new StringBuilder();
        String str2 = ((g.b.b)((g.b)parama1.cWo).cVQ.list.get(0)).cVV;
        long l5 = ((Long)((g.b)parama1.cWo).cVP.cWu).longValue() / l4;
        long l6 = ((Long)((g.b.b)((g.b)parama1.cWo).cVQ.list.get(0)).cWu).longValue();
        String str3 = ((g.b.b)((g.b)parama1.cWo).cVQ.list.get(0)).name;
        int j = ((g.b.b)((g.b)parama1.cWo).cVQ.list.get(0)).tid;
        long l2 = 0L;
        if (((g.b)parama1.cWo).cVQ.list.size() > 0) {
          ((StringBuilder)localObject2).append("top2-").append(((g.b.b)((g.b)parama1.cWo).cVQ.list.get(1)).name);
        }
        com.tencent.matrix.c.a.Xg();
        long l1;
        Object localObject1;
        k.c.a locala;
        Object localObject3;
        label552:
        int k;
        if ((l6 > 0L) && (!((g.b)parama1.cWn).cVQ.list.isEmpty()))
        {
          long l3 = 0L;
          parama1 = ((g.b)parama1.cWn).cVQ.list.iterator();
          do
          {
            l1 = l3;
            if (!parama1.hasNext()) {
              break;
            }
            localObject1 = (g.b.b)parama1.next();
          } while ((!((g.b.b)localObject1).name.equals(str3)) || (((g.b.b)localObject1).tid != j));
          l1 = ((Long)((j.a.c.b)localObject1).cWu).longValue();
          if (l1 > 0L)
          {
            locala = null;
            localObject3 = null;
            if (d.b.fv(str3))
            {
              localObject1 = (com.tencent.matrix.c.c)com.tencent.matrix.a.a.Z(com.tencent.matrix.c.c.class);
              if (localObject1 != null) {
                if (((com.tencent.matrix.c.c)localObject1).jr(j) != null)
                {
                  parama1 = "mmhandler";
                  localObject1 = ((com.tencent.matrix.c.c)localObject1).h(j, l6, l1);
                }
              }
              for (;;)
              {
                com.tencent.matrix.c.a.Xg();
                if ((localObject1 == null) || (!((k.c)localObject1).cWl)) {
                  break label1020;
                }
                j = 0;
                locala = ((k.c)localObject1).WH();
                if (locala == null) {
                  break label1009;
                }
                if ((TextUtils.isEmpty(locala.key)) || (locala.key.equals("thread_pool@idle"))) {
                  break;
                }
                localObject1 = new StringBuilder(locala.key);
                i = locala.ratio;
                l1 = locala.cXY;
                j = 1;
                localObject2 = localObject1;
                k = i;
                if (j != 0)
                {
                  Log.i("Matrix.battery.BatteryReporter", " #overHeat reportJiffies found task: name = " + localObject1 + ", ratio = " + i + ", statMillis = " + l1 + ", from = " + parama1);
                  k = i;
                  localObject2 = localObject1;
                }
                label623:
                if (!parama.cSY) {
                  break label951;
                }
                Log.i("Matrix.battery.BatteryReporter", "#reportJiffiesException");
                label638:
                if (!z.abb().abc()) {
                  break label1003;
                }
                i = 4;
                label649:
                j = d.b.cZV;
                localObject1 = ((StringBuilder)localObject2).toString();
                if (!paramBoolean) {
                  break label996;
                }
                parama1 = "avgJiffiesLongException";
                label669:
                d.b.a(j, str1, (String)localObject1, i, n, parama1, l5, d.b.ft(str3), l6 / l4, "duringMin", l4, parama.cSU, str2, parama.cSO, parama.cSQ, k);
                return;
                ((StringBuilder)localObject2).append("mmhandler-stamps-empty");
                localObject1 = localObject3;
                parama1 = locala;
                continue;
                ((StringBuilder)localObject2).append("mmhandler-disabled");
                localObject1 = localObject3;
                parama1 = locala;
              }
            }
            if (d.b.fu(str3))
            {
              parama1 = (com.tencent.matrix.c.f)com.tencent.matrix.a.a.Z(com.tencent.matrix.c.f.class);
              if ((parama1 == null) || (parama1.jr(j) == null)) {
                break label1026;
              }
              localObject1 = parama1.h(j, l6, l1);
            }
          }
        }
        for (parama1 = "threadPool";; parama1 = null)
        {
          break;
          localObject1 = localObject3;
          parama1 = locala;
          if (!d.b.K(str3, j)) {
            break;
          }
          i locali = (i)com.tencent.matrix.a.a.Z(i.class);
          localObject1 = localObject3;
          parama1 = locala;
          if (locali == null) {
            break;
          }
          localObject1 = localObject3;
          parama1 = locala;
          if (locali.jr(j) == null) {
            break;
          }
          parama1 = "looperTask";
          localObject1 = locali.h(j, l6, l1);
          break;
          locala = ((k.c)localObject1).WI();
          if ((locala != null) && (!TextUtils.isEmpty(locala.key)) && (!locala.key.equals("thread_pool@idle")))
          {
            localObject1 = new StringBuilder(locala.key);
            i = locala.ratio;
            l1 = locala.cXY;
            j = 1;
            break label552;
            label951:
            localObject2 = new StringBuilder("invalid-").append((CharSequence)localObject2);
            Log.w("Matrix.battery.BatteryReporter", "#reportJiffiesException invalid, appstats = " + parama.toString());
            break label638;
            label996:
            parama1 = "avgJiffiesException";
            break label669;
            label1003:
            i = m;
            break label649;
          }
          label1009:
          localObject1 = localObject2;
          l1 = l2;
          break label552;
          label1020:
          k = i;
          break label623;
          label1026:
          localObject1 = null;
        }
      }
      
      public static void b(boolean paramBoolean, j.a.a<b.a> parama)
      {
        String str1 = d.Xs();
        Object localObject = new StringBuilder();
        int i = ((b.a)parama.cWo).cUD;
        int j = ((b.a)parama.cWo).cUE;
        long l1 = Math.max(1L, parama.cWp / 60000L);
        long l2 = ((Long)((b.a)parama.cWo).cUC.cWu).longValue() / l1;
        Log.i("Matrix.battery.BatteryReporter", "#reportHandlerTaskJiffies");
        localObject = ((StringBuilder)localObject).append("finish=").append(((b.a)parama.cWo).isFinished);
        int k = d.b.cZV;
        String str2 = ((StringBuilder)localObject).toString();
        if (paramBoolean) {}
        for (localObject = "avgHandlerJiffiesLongException";; localObject = "avgHandlerJiffiesException")
        {
          d.b.a(k, str1, str2, i, j, (String)localObject, l2, ((b.a)parama.cWo).name, ((Long)((b.a)parama.cWn).cUC.cWu).longValue(), "duringMin", l1, ((b.a)parama.cWo).scene, "", ((b.a)parama.cWo).cUF, ((b.a)parama.cWo).cUG, ((b.a)parama.cWo).cUH);
          return;
        }
      }
    }
    
    public static final class b
    {
      public static void c(boolean paramBoolean, j.a.a<g.b> parama)
      {
        if (!com.tencent.matrix.c.a.WU()) {}
        while ((((Long)((g.b)parama.cWo).cVP.cWu).longValue() < 100L) || (parama.cWp < 60000L)) {
          return;
        }
        String str1 = d.Xs();
        StringBuilder localStringBuilder = new StringBuilder();
        int j = d.cU(paramBoolean);
        int k = d.Xu();
        String str2 = d.Xt();
        long l2 = Math.max(1L, parama.cWp / 60000L);
        long l3 = ((Long)((g.b)parama.cWo).cVP.cWu).longValue() / l2;
        ArrayList localArrayList = new ArrayList(3);
        int i = 0;
        long l1;
        Object localObject;
        if (i < 3)
        {
          l1 = 0L;
          if (((g.b)parama.cWo).cVQ.list.size() <= i) {
            break label449;
          }
          g.b.b localb = (g.b.b)((g.b)parama.cWo).cVQ.list.get(i);
          if (localb == null) {
            break label449;
          }
          localObject = localb.name;
          l1 = ((Long)localb.cWu).longValue() / l2;
        }
        for (;;)
        {
          localArrayList.add(new e(localObject, Long.valueOf(l1)));
          i += 1;
          break;
          Log.i("Matrix.battery.BatteryReporter", "#statJiffies");
          parama = localStringBuilder.append(d.b.ft((String)((e)localArrayList.get(1)).Mx)).append(":").append(((e)localArrayList.get(1)).My).append(d.b.ft((String)((e)localArrayList.get(2)).Mx)).append(":").append(((e)localArrayList.get(2)).My);
          i = b.bk(MMApplicationContext.getContext());
          parama.append("|batTemp=").append(i);
          localObject = b.WB();
          if (localObject.length > 0) {
            parama.append("|cupFreq=").append(Arrays.toString((int[])localObject));
          }
          d.b.a(d.b.access$100(), str1, parama.toString(), j, k, "avgJiffies", l3, d.b.ft((String)((e)localArrayList.get(0)).Mx), ((Long)((e)localArrayList.get(0)).My).longValue(), "duringMin", l2, str2, "", 0L, 0L, 0L);
          return;
          label449:
          localObject = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.d
 * JD-Core Version:    0.7.0.1
 */