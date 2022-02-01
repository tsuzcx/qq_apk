package com.tencent.matrix.report;

import android.text.TextUtils;
import androidx.core.f.d;
import com.tencent.matrix.a.a.a.b.a;
import com.tencent.matrix.a.a.a.j.b;
import com.tencent.matrix.a.a.a.j.b.a;
import com.tencent.matrix.a.a.a.l;
import com.tencent.matrix.a.a.a.m.a.a;
import com.tencent.matrix.a.a.a.m.a.c.b;
import com.tencent.matrix.a.a.a.m.a.c.c;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.e.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.sdk.platformtools.AppBrands;
import com.tencent.mm.sdk.platformtools.AppBrands.AppBrandAppInfo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class e
{
  public static String ayY()
  {
    Object localObject = AppForegroundDelegate.heY;
    String str = AppForegroundDelegate.aCa();
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = com.tencent.matrix.a.eLw.eLy;
    }
    return gW((String)localObject);
  }
  
  public static String gW(String paramString)
  {
    Object localObject;
    if (AppBrands.isAppBrandProc())
    {
      localObject = AppBrands.getAppBrandInfo();
      if ((localObject != null) && (!TextUtils.isEmpty(((AppBrands.AppBrandAppInfo)localObject).appName))) {
        localObject = ((AppBrands.AppBrandAppInfo)localObject).appName;
      }
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (!paramString.contains("@"));
    return paramString.substring(0, paramString.lastIndexOf("@"));
  }
  
  public static final class a
  {
    public static void dE(boolean paramBoolean)
    {
      com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Ozc;
      if (paramBoolean) {}
      for (long l = 101L;; l = 100L)
      {
        localf.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void dF(boolean paramBoolean)
    {
      com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Ozc;
      if (paramBoolean) {}
      for (long l = 0L;; l = 1L)
      {
        localf.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void dG(boolean paramBoolean)
    {
      com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Ozc;
      if (paramBoolean) {}
      for (long l = 2L;; l = 3L)
      {
        localf.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void dH(boolean paramBoolean)
    {
      com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Ozc;
      if (paramBoolean) {}
      for (long l = 4L;; l = 5L)
      {
        localf.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void dI(boolean paramBoolean)
    {
      com.tencent.mm.plugin.report.f localf = com.tencent.mm.plugin.report.f.Ozc;
      if (paramBoolean) {}
      for (long l = 63L;; l = 64L)
      {
        localf.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void ns(int paramInt)
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1540L, paramInt, 1L, false);
    }
  }
  
  public static final class b
  {
    private static final int eYu;
    private static final int eYv;
    
    static
    {
      int j = 100;
      if (com.tencent.matrix.c.a.aym())
      {
        i = 100;
        eYu = i + 0;
        if (!com.tencent.matrix.c.a.aym()) {
          break label38;
        }
      }
      label38:
      for (int i = j;; i = 0)
      {
        eYv = i + 1;
        return;
        i = 0;
        break;
      }
    }
    
    static String a(androidx.core.f.a<Map<String, Object>> parama)
    {
      HashMap localHashMap = new HashMap();
      parama.accept(localHashMap);
      return l(localHashMap);
    }
    
    private static void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, long paramLong1, String paramString4, long paramLong2, String paramString5, long paramLong3, String paramString6, String paramString7, long paramLong4, long paramLong5, long paramLong6, String paramString8)
    {
      if (paramBoolean) {
        Log.i("Matrix.battery.BatteryReporter", "#kvPost, data: \n\ttype = " + paramInt1 + "\n, version = 5\n, proc = " + paramString1 + "\n, extra = " + paramString2 + "\n, appStat = " + paramInt2 + "\n, devStat = " + paramInt3 + "\n, keyDgt1 = " + paramString3 + "\n, valDgt1 = " + paramLong1 + "\n, keyDgt2 = " + paramString4 + "\n, valDgt2 = " + paramLong2 + "\n, keyDgt3 = " + paramString5 + "\n, valDgt3 " + paramLong3 + "\n, scene = " + paramString6 + "\n, stack = " + paramString7 + "\n, extraDigit1 = " + paramLong4 + "\n, extraDigit2 = " + paramLong5 + "\n, extraDigit3 = " + paramLong6 + "\n, stackR = " + paramString8);
      }
      com.tencent.mm.plugin.report.f.Ozc.b(21468, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(5), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Long.valueOf(paramLong1), paramString4, Long.valueOf(paramLong2), paramString5, Long.valueOf(paramLong3), paramString6, paramString7, Long.valueOf(paramLong4), Long.valueOf(paramLong5), Long.valueOf(paramLong6), paramString8, BuildInfo.REV });
    }
    
    static String l(Map<String, Object> paramMap)
    {
      try
      {
        paramMap = new JSONObject(paramMap).toString().replace(",", ";");
        return paramMap;
      }
      catch (Exception paramMap)
      {
        c.printErrStackTrace("Matrix.battery.BatteryReporter", paramMap, "json error", new Object[0]);
      }
      return paramMap.getMessage();
    }
    
    public static final class a
    {
      public static void a(com.tencent.matrix.a.a.a parama, m.a.a<b.a> parama1, String paramString)
      {
        long l1 = Math.max(1L, parama1.eSi / 60000L);
        long l2 = ((Long)((b.a)parama1.eSh).eQc.eSn).longValue() / l1;
        if (l2 < com.tencent.matrix.c.a.aye()) {}
        while ((parama.isCharging()) || (parama.eOe <= com.tencent.matrix.c.a.axZ())) {
          return;
        }
        String str4 = c.a.ayX();
        int j = parama.awy();
        int k = parama.awz();
        int i = parama.eOl;
        String str2 = "";
        String str3 = "";
        Object localObject = c.a.b(l.class, parama1);
        if (!TextUtils.isEmpty((CharSequence)((d)localObject).bsC))
        {
          paramString = (String)((d)localObject).bsC;
          if (((d)localObject).bsD == null) {
            i = 0;
          }
        }
        for (;;)
        {
          String str1 = str2;
          localObject = str3;
          if (com.tencent.matrix.c.a.ayq())
          {
            str1 = str2;
            localObject = str3;
            if (l1 >= 5L)
            {
              str1 = str2;
              localObject = str3;
              if (l2 >= 3000L)
              {
                localObject = c.b.nr(((b.a)parama1.eSh).tid);
                str1 = (String)((d)localObject).bsC;
                localObject = (String)((d)localObject).bsD;
                Log.i("Matrix.battery.BatteryReporter", " #overHeat matrix internal thread, stack = \n".concat(String.valueOf(str1)));
              }
            }
          }
          Log.i("Matrix.battery.BatteryReporter", "#reportInternalJiffies");
          e.b.a(e.b.access$300(), str4, paramString, j, k, "avgSelfJiffiesException", l2, "matrix_default_", ((Long)((b.a)parama1.eSg).eQc.eSn).longValue(), "duringMin", l1, parama.eOk, str1, parama.eOe, parama.eOg, i, (String)localObject);
          return;
          i = ((Integer)((d)localObject).bsD).intValue();
        }
      }
      
      public static void a(com.tencent.matrix.a.a.a parama, boolean paramBoolean, long paramLong1, long paramLong2)
      {
        if ((parama.isCharging()) || (parama.eOe <= com.tencent.matrix.c.a.axZ())) {
          return;
        }
        String str4 = c.a.ayX();
        String str1;
        int i;
        int j;
        int k;
        String str2;
        label66:
        long l;
        label73:
        String str3;
        if (paramBoolean)
        {
          str1 = "wifi";
          i = parama.awy();
          j = parama.awz();
          Log.i("Matrix.battery.BatteryReporter", "#reportTrafficException");
          k = e.b.access$300();
          if (!paramBoolean) {
            break label154;
          }
          str2 = "avgWifiException";
          if (!paramBoolean) {
            break label162;
          }
          l = paramLong1;
          if (!paramBoolean) {
            break label169;
          }
          str3 = "avgRadio";
          label82:
          if (!paramBoolean) {
            break label177;
          }
        }
        for (;;)
        {
          e.b.a(k, str4, str1, i, j, str2, l, str3, paramLong2, "duringMin", Math.max(1L, parama.eOb / 60000L), parama.eOk, "", parama.eOe, parama.eOg, parama.eOl, "");
          return;
          str1 = "mobile";
          break;
          label154:
          str2 = "avgRadioException";
          break label66;
          label162:
          l = paramLong2;
          break label73;
          label169:
          str3 = "avgWifi";
          break label82;
          label177:
          paramLong2 = paramLong1;
        }
      }
      
      public static void a(String paramString, com.tencent.matrix.a.a.a.f paramf, boolean paramBoolean)
      {
        if ((!paramString.equals("canary")) && (!paramString.equals("module"))) {
          return;
        }
        paramf.a(new e.b.a..ExternalSyntheticLambda1(paramf, paramString, paramBoolean));
      }
      
      public static void a(boolean paramBoolean, String paramString, m.a.a<b.a> parama)
      {
        String str = c.a.ayX();
        StringBuilder localStringBuilder = new StringBuilder();
        int i = ((b.a)parama.eSh).eQd;
        int j = ((b.a)parama.eSh).eQe;
        long l1 = Math.max(1L, parama.eSi / 60000L);
        long l2 = ((Long)((b.a)parama.eSh).eQc.eSn).longValue() / l1;
        Log.i("Matrix.battery.BatteryReporter", "#reportTaskJiffiesException, feat = ".concat(String.valueOf(paramString)));
        localStringBuilder = localStringBuilder.append("finish=").append(((b.a)parama.eSh).isFinished);
        int k = b.bU(MMApplicationContext.getContext());
        localStringBuilder.append("|batTemp=").append(k);
        Object localObject = b.axq();
        if (localObject.length > 0) {
          localStringBuilder.append("|cupFreq=").append(Arrays.toString((int[])localObject));
        }
        localObject = new StringBuilder();
        if (paramString.equals("threadPool"))
        {
          paramString = "avgTaskJiffies";
          localObject = ((StringBuilder)localObject).append(paramString);
          if (!paramBoolean) {
            break label340;
          }
        }
        label340:
        for (paramString = "LongException";; paramString = "Exception")
        {
          paramString = paramString;
          e.b.a(e.b.access$300(), str, localStringBuilder.toString(), i, j, paramString, l2, ((b.a)parama.eSh).name, ((Long)((b.a)parama.eSg).eQc.eSn).longValue(), "duringMin", l1, ((b.a)parama.eSh).scene, "", ((b.a)parama.eSh).eQf, ((b.a)parama.eSh).eQg, ((b.a)parama.eSh).eQh, "");
          return;
          paramString = "avg" + c.a.capitalize(paramString) + "TaskJiffies";
          break;
        }
      }
    }
    
    public static final class b
    {
      public static void S(String paramString1, String paramString2)
      {
        if (!com.tencent.matrix.c.a.ayn()) {
          return;
        }
        String str = c.a.ayX();
        Log.i("Matrix.battery.BatteryReporter", "#statMetricsCompat, type = ".concat(String.valueOf(paramString1)));
        e.b.a(e.b.access$300(), str, "", 0, 0, "metricsCompat", 0L, paramString1, 0L, paramString2, 0L, "", "", 0L, 0L, 0L, "");
      }
      
      public static void a(int paramInt, b.b paramb)
      {
        if (!com.tencent.matrix.c.a.ayn()) {}
        com.tencent.matrix.a.a.a locala;
        do
        {
          return;
          locala = com.tencent.matrix.a.a.a.dD(paramb.awv());
        } while (!locala.clZ);
        long l2 = Math.max(1L, paramb.awv() / 60000L);
        int i = locala.awy();
        int j = locala.awz();
        String str = c.a.ayX();
        Log.i("Matrix.battery.BatteryReporter", "#statResUpdateInfo");
        int k = e.b.access$000();
        long l3 = paramInt;
        if (paramb.isForeground()) {}
        for (long l1 = 0L;; l1 = 1L)
        {
          e.b.a(k, str, "", i, j, "bgResUpdate", l3, "bg", l1, "duringMin", l2, locala.eOk, "", locala.eOe, locala.eOg, locala.eOl, "");
          return;
        }
      }
      
      public static void a(String paramString, com.tencent.matrix.a.a.a.f paramf)
      {
        if (!com.tencent.matrix.c.a.ayn()) {
          return;
        }
        paramf.a(new e.b.b..ExternalSyntheticLambda1(paramf, paramString));
      }
      
      public static void a(boolean paramBoolean, m.a.a<j.b> parama)
      {
        if (!com.tencent.matrix.c.a.axX()) {}
        while ((((Long)((j.b)parama.eSh).eRI.eSn).longValue() < 100L) || (parama.eSi < 60000L)) {
          return;
        }
        String str1 = c.a.ayX();
        StringBuilder localStringBuilder = new StringBuilder();
        int j = c.a.dD(paramBoolean);
        int k = b.bW(MMApplicationContext.getContext());
        String str2 = e.ayY();
        long l2 = Math.max(1L, parama.eSi / 60000L);
        long l3 = ((Long)((j.b)parama.eSh).eRI.eSn).longValue() / l2;
        ArrayList localArrayList = new ArrayList(3);
        int i = 0;
        long l1;
        Object localObject;
        if (i < 3)
        {
          l1 = 0L;
          if (((j.b)parama.eSh).eRJ.list.size() <= i) {
            break label460;
          }
          j.b.a locala = (j.b.a)((j.b)parama.eSh).eRJ.list.get(i);
          if (locala == null) {
            break label460;
          }
          localObject = locala.name;
          l1 = ((Long)locala.eSn).longValue() / l2;
        }
        for (;;)
        {
          localArrayList.add(new d(localObject, Long.valueOf(l1)));
          i += 1;
          break;
          Log.i("Matrix.battery.BatteryReporter", "#statJiffies");
          parama = localStringBuilder.append(c.a.gS((String)((d)localArrayList.get(1)).bsC)).append(":").append(((d)localArrayList.get(1)).bsD).append(c.a.gS((String)((d)localArrayList.get(2)).bsC)).append(":").append(((d)localArrayList.get(2)).bsD);
          i = b.bU(MMApplicationContext.getContext());
          parama.append("|batTemp=").append(i);
          localObject = b.axq();
          if (localObject.length > 0) {
            parama.append("|cupFreq=").append(Arrays.toString((int[])localObject));
          }
          e.b.a(e.b.access$000(), str1, parama.toString(), j, k, "avgJiffies", l3, c.a.gS((String)((d)localArrayList.get(0)).bsC), ((Long)((d)localArrayList.get(0)).bsD).longValue(), "duringMin", l2, str2, "", 0L, 0L, 0L, "");
          return;
          label460:
          localObject = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.e
 * JD-Core Version:    0.7.0.1
 */