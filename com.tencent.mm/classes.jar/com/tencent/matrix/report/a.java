package com.tencent.matrix.report;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.e.k;
import android.text.TextUtils;
import com.tencent.matrix.a.b.a.e.b;
import com.tencent.matrix.a.b.a.e.b.a;
import com.tencent.matrix.a.b.a.g.a.a;
import com.tencent.matrix.a.b.a.g.a.c.b;
import com.tencent.matrix.a.b.a.g.a.c.c;
import com.tencent.matrix.a.c.c;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.AppBrands;
import com.tencent.mm.sdk.platformtools.AppBrands.AppBrandAppInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class a
{
  public static String SN()
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
  
  public static String SO()
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
      localObject1 = AppForegroundDelegate.djR;
      localObject2 = AppForegroundDelegate.Wb();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = com.tencent.matrix.a.cPA.cPC;
      }
      localObject2 = localObject1;
    } while (!((String)localObject1).contains("@"));
    return ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("@"));
  }
  
  public static int SP()
  {
    return cA(AppForegroundDelegate.djR.cPB);
  }
  
  @SuppressLint({"RestrictedApi"})
  public static int SQ()
  {
    Context localContext = MMApplicationContext.getContext();
    if (c.bc(localContext)) {
      return 1;
    }
    if (!c.bd(localContext)) {
      return 3;
    }
    if (c.be(localContext)) {
      return 4;
    }
    return 2;
  }
  
  @SuppressLint({"RestrictedApi"})
  public static int cA(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    if (c.bf(MMApplicationContext.getContext())) {
      return 3;
    }
    return 2;
  }
  
  public static final class a
  {
    public static void SR()
    {
      e.Cxv.idkeyStat(1540L, 7L, 1L, false);
    }
    
    public static void cB(boolean paramBoolean)
    {
      e locale = e.Cxv;
      if (paramBoolean) {}
      for (long l = 101L;; l = 100L)
      {
        locale.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void cC(boolean paramBoolean)
    {
      e locale = e.Cxv;
      if (paramBoolean) {}
      for (long l = 0L;; l = 1L)
      {
        locale.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void cD(boolean paramBoolean)
    {
      e locale = e.Cxv;
      if (paramBoolean) {}
      for (long l = 2L;; l = 3L)
      {
        locale.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
    
    public static void cE(boolean paramBoolean)
    {
      e locale = e.Cxv;
      if (paramBoolean) {}
      for (long l = 4L;; l = 5L)
      {
        locale.idkeyStat(1540L, l, 1L, false);
        return;
      }
    }
  }
  
  @SuppressLint({"RestrictedApi"})
  public static final class b
  {
    private static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, String paramString3, long paramLong1, String paramString4, long paramLong2, String paramString5, long paramLong3, String paramString6, String paramString7, long paramLong4, long paramLong5, long paramLong6)
    {
      e.Cxv.a(21468, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(4), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString3, Long.valueOf(paramLong1), paramString4, Long.valueOf(paramLong2), paramString5, Long.valueOf(paramLong3), paramString6, paramString7, Long.valueOf(paramLong4), Long.valueOf(paramLong5), Long.valueOf(paramLong6) });
    }
    
    static String eA(String paramString)
    {
      String str = paramString;
      if (!TextUtils.isDigitsOnly(paramString))
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
    
    public static final class a
    {
      public static void a(g.a.a<e.b> parama, long paramLong1, long paramLong2, String paramString, long paramLong3)
      {
        String str = a.SN();
        StringBuilder localStringBuilder = new StringBuilder();
        int j = a.cA(false);
        int k = a.SQ();
        long l2 = Math.max(1L, parama.cTu / 60000L);
        long l3 = ((Long)((e.b)parama.cTt).cTd.cTz).longValue() / l2;
        ArrayList localArrayList = new ArrayList(3);
        int i = 0;
        long l1;
        Object localObject;
        if (i < 3)
        {
          l1 = 0L;
          if (((e.b)parama.cTt).cTe.list.size() <= i) {
            break label409;
          }
          e.b.a locala = (e.b.a)((e.b)parama.cTt).cTe.list.get(i);
          if (locala == null) {
            break label409;
          }
          localObject = locala.name;
          l1 = ((Long)locala.cTz).longValue() / l2;
        }
        for (;;)
        {
          localArrayList.add(new k(localObject, Long.valueOf(l1)));
          i += 1;
          break;
          Log.i("Matrix.battery.BatteryReporter", "#reportJiffiesException");
          parama = localStringBuilder.append(a.b.eA((String)((k)localArrayList.get(1)).first)).append(":").append(((k)localArrayList.get(1)).second).append(a.b.eA((String)((k)localArrayList.get(2)).first)).append(":").append(((k)localArrayList.get(2)).second);
          i = c.ba(MMApplicationContext.getContext());
          parama.append("|batTemp=").append(i);
          localObject = c.Sq();
          if (localObject.length > 0) {
            parama.append("|cupFreq=").append(Arrays.toString((int[])localObject));
          }
          a.b.b(1, str, parama.toString(), j, k, "avgJiffiesException", l3, a.b.eA((String)((k)localArrayList.get(0)).first), ((Long)((k)localArrayList.get(0)).second).longValue(), "duringMin", l2, paramString, "", paramLong1, paramLong2, paramLong3);
          return;
          label409:
          localObject = "";
        }
      }
    }
    
    public static final class b
    {
      public static void a(boolean paramBoolean, g.a.a<e.b> parama)
      {
        if (!com.tencent.matrix.c.a.SA()) {
          return;
        }
        String str1 = a.SN();
        StringBuilder localStringBuilder = new StringBuilder();
        int j = a.cA(paramBoolean);
        int k = a.SQ();
        String str2 = a.SO();
        long l2 = Math.max(1L, parama.cTu / 60000L);
        long l3 = ((Long)((e.b)parama.cTt).cTd.cTz).longValue() / l2;
        ArrayList localArrayList = new ArrayList(3);
        int i = 0;
        long l1;
        Object localObject;
        if (i < 3)
        {
          l1 = 0L;
          if (((e.b)parama.cTt).cTe.list.size() <= i) {
            break label410;
          }
          e.b.a locala = (e.b.a)((e.b)parama.cTt).cTe.list.get(i);
          if (locala == null) {
            break label410;
          }
          localObject = locala.name;
          l1 = ((Long)locala.cTz).longValue() / l2;
        }
        for (;;)
        {
          localArrayList.add(new k(localObject, Long.valueOf(l1)));
          i += 1;
          break;
          Log.i("Matrix.battery.BatteryReporter", "#statJiffies");
          parama = localStringBuilder.append(a.b.eA((String)((k)localArrayList.get(1)).first)).append(":").append(((k)localArrayList.get(1)).second).append(a.b.eA((String)((k)localArrayList.get(2)).first)).append(":").append(((k)localArrayList.get(2)).second);
          i = c.ba(MMApplicationContext.getContext());
          parama.append("|batTemp=").append(i);
          localObject = c.Sq();
          if (localObject.length > 0) {
            parama.append("|cupFreq=").append(Arrays.toString((int[])localObject));
          }
          a.b.b(0, str1, parama.toString(), j, k, "avgJiffies", l3, a.b.eA((String)((k)localArrayList.get(0)).first), ((Long)((k)localArrayList.get(0)).second).longValue(), "duringMin", l2, str2, "", 0L, 0L, 0L);
          return;
          label410:
          localObject = "";
        }
      }
      
      public static void c(int paramInt1, int paramInt2, String paramString)
      {
        if (!com.tencent.matrix.c.a.SA()) {
          return;
        }
        String str1 = a.SN();
        String str2 = c.eu("/proc/" + paramInt1 + "/task/" + paramInt2 + "/stat");
        int i = a.SP();
        int j = a.SQ();
        String str3 = a.SO();
        Log.i("Matrix.battery.BatteryReporter", "#statJiffiesTaskParseError");
        a.b.b(0, str1, str2, i, j, "statError", 1L, "pid", paramInt1, "tid", paramInt2, str3, paramString, 0L, 0L, 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.report.a
 * JD-Core Version:    0.7.0.1
 */