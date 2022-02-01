package com.tencent.mapsdk.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class gw
{
  private static a A;
  private static final String B;
  private static final String C;
  private static String D;
  private static String E;
  private static String F;
  private static String G;
  private static String H;
  private static String I;
  private static int J = 0;
  private static String K;
  private static String L;
  private static float M = 0.0F;
  private static final int N = 100;
  private static final int O = 4000000;
  private static final int P = 53500000;
  private static final int Q = 73670000;
  private static final int R = 135100000;
  private static final int S = -85000000;
  private static final int T = 85000000;
  private static final int U = -180000000;
  private static final int V = 180000000;
  private static int W = 0;
  private static int X = 0;
  private static float Y = 0.0F;
  private static final int Z = 20;
  public static final File a;
  private static final double aa = 6378137.0D;
  private static final double ab = 40075016.685578488D;
  private static final double ac = 0.0174532925199433D;
  private static final double ad = 268435456.0D;
  public static final File b;
  public static final File c;
  public static final String d = "tencentmap/mapsdk_vector/";
  public static final int e = -1;
  public static final int f = 0;
  public static final int g = 1;
  public static final int h = 2;
  public static int i = 0;
  public static int j = 0;
  public static int k = 0;
  public static int l = 0;
  public static final int m = 1;
  public static final int n = 2;
  public static final int o = 3;
  public static int p = 0;
  public static int q = 0;
  public static int r = 0;
  public static int s = 0;
  public static int t = 0;
  private static final String u = "Tencent";
  private static final String v = "MapSDK";
  private static final String w = "Caches";
  private static String x;
  private static String y;
  private static String z;
  
  static
  {
    AppMethodBeat.i(226162);
    a = new File(Environment.getExternalStorageDirectory(), "Tencent");
    b = new File(a, "MapSDK");
    c = new File(b, "Caches");
    x = null;
    y = null;
    z = null;
    B = ry.j;
    C = ry.j + "." + ry.i;
    D = null;
    E = null;
    F = null;
    G = null;
    H = null;
    I = null;
    J = 0;
    K = null;
    L = "undefined";
    M = 1.0F;
    i = 2;
    j = 0;
    k = 0;
    l = 0;
    p = 2;
    q = 4000000;
    r = 53500000;
    s = 73670000;
    t = 135100000;
    W = 0;
    X = 160;
    Y = 0.0F;
    AppMethodBeat.o(226162);
  }
  
  private static Date E()
  {
    AppMethodBeat.i(225760);
    Date localDate = Calendar.getInstance().getTime();
    AppMethodBeat.o(225760);
    return localDate;
  }
  
  private static String F()
  {
    AppMethodBeat.i(225847);
    if ((L().a) || (F == null))
    {
      AppMethodBeat.o(225847);
      return "";
    }
    String str = F;
    AppMethodBeat.o(225847);
    return str;
  }
  
  private static void G()
  {
    AppMethodBeat.i(225960);
    if (X <= 120)
    {
      p = 1;
      AppMethodBeat.o(225960);
      return;
    }
    if (X <= 160)
    {
      p = 2;
      AppMethodBeat.o(225960);
      return;
    }
    if (X <= 240)
    {
      p = 3;
      AppMethodBeat.o(225960);
      return;
    }
    H();
    AppMethodBeat.o(225960);
  }
  
  private static void H()
  {
    if (W > 153600)
    {
      p = 3;
      return;
    }
    if (W < 153600)
    {
      p = 1;
      return;
    }
    p = 2;
  }
  
  private static String I()
  {
    return "Tencent";
  }
  
  private static String J()
  {
    return "MapSDK";
  }
  
  private static String K()
  {
    return "Caches";
  }
  
  private static a L()
  {
    AppMethodBeat.i(226054);
    if (A != null)
    {
      locala = A;
      AppMethodBeat.o(226054);
      return locala;
    }
    a locala = new a(false, (byte)0);
    AppMethodBeat.o(226054);
    return locala;
  }
  
  private static a M()
  {
    AppMethodBeat.i(226060);
    a locala = new a(false, (byte)0);
    AppMethodBeat.o(226060);
    return locala;
  }
  
  public static double a(double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(226007);
    paramDouble1 = 6.698324247899813D * paramDouble1 / Math.cos(0.0174532925199433D * paramDouble2);
    AppMethodBeat.o(226007);
    return paramDouble1;
  }
  
  private static float a(int paramInt)
  {
    return paramInt / 255.0F;
  }
  
  public static String a()
  {
    AppMethodBeat.i(225768);
    L();
    if ((y != null) && (!y.equals(x)))
    {
      str = y;
      AppMethodBeat.o(225768);
      return str;
    }
    String str = x;
    AppMethodBeat.o(225768);
    return str;
  }
  
  public static String a(String paramString)
  {
    AppMethodBeat.i(225914);
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (!TextUtils.isEmpty(G))
    {
      localStringBuilder.append("&suid=");
      localStringBuilder.append(d());
    }
    if (!TextUtils.isEmpty(I))
    {
      localStringBuilder.append("&appid=");
      localStringBuilder.append(k());
    }
    if (!TextUtils.isEmpty(B))
    {
      localStringBuilder.append("&sdkver=");
      L();
      localStringBuilder.append(B);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append("&ui=");
      localStringBuilder.append(paramString);
    }
    if (!TextUtils.isEmpty(L)) {
      localStringBuilder.append("&appsuid=");
    }
    try
    {
      localStringBuilder.append(URLEncoder.encode(L, "UTF-8"));
      localStringBuilder.append("&cuid=");
      localStringBuilder.append(L);
      localStringBuilder.append("&api_key=" + a());
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(225914);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        localStringBuilder.append(c(L));
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(225905);
    if (!gz.a(paramString1)) {}
    for (;;)
    {
      if (!gz.a(paramString2)) {}
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder(256);
        paramString1 = localStringBuilder.append("key=").append(a()).append("&pid=").append(k()).append("&key2=").append(paramString1).append("&pid2=").append(paramString2).append("&psv=").append(j()).append("&ver=");
        L();
        paramString1 = paramString1.append(C).append("&pf=");
        L();
        paramString2 = paramString1.append("androidsdk&hm=").append(g()).append("&suid=").append(d()).append("&os=").append(i()).append("&dip=");
        if ((L().a) || (F == null)) {
          paramString1 = "";
        }
        for (;;)
        {
          paramString2.append(paramString1).append("&nt=").append(f()).append("&channel=1&output=json");
          if (!TextUtils.isEmpty(L)) {}
          try
          {
            paramString1 = URLEncoder.encode(L, "UTF-8");
            localStringBuilder.append("&cuid=");
            localStringBuilder.append(paramString1);
            localStringBuilder.append("&uuid=");
            localStringBuilder.append(paramString1);
            paramString1 = localStringBuilder.toString();
            AppMethodBeat.o(225905);
            return paramString1;
            paramString1 = F;
          }
          catch (UnsupportedEncodingException paramString1)
          {
            for (;;)
            {
              paramString1 = c(L);
            }
          }
        }
        paramString2 = "";
      }
      paramString1 = "";
    }
  }
  
  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(225931);
    StringBuilder localStringBuilder = new StringBuilder();
    int i2 = paramArrayOfByte.length;
    int i1 = 0;
    while (i1 < i2)
    {
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[i1] & 0xFF)).append(paramString);
      i1 += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(225931);
    return paramArrayOfByte;
  }
  
  private static void a(Context paramContext)
  {
    AppMethodBeat.i(225978);
    if (paramContext == null)
    {
      AppMethodBeat.o(225978);
      return;
    }
    paramContext = paramContext.getResources().getDisplayMetrics();
    W = paramContext.widthPixels * paramContext.heightPixels;
    if (Build.VERSION.SDK_INT < 24)
    {
      a(paramContext);
      AppMethodBeat.o(225978);
      return;
    }
    X = paramContext.densityDpi;
    G();
    AppMethodBeat.o(225978);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(225891);
    ka.d = c;
    y = paramString1;
    z = paramString2;
    L = paramString3;
    if ((W == 0) && (paramContext != null))
    {
      paramString1 = paramContext.getResources().getDisplayMetrics();
      W = paramString1.widthPixels * paramString1.heightPixels;
      if (Build.VERSION.SDK_INT >= 24) {
        break label392;
      }
      a(paramString1);
    }
    for (;;)
    {
      if (K == null) {}
      try
      {
        paramString1 = Build.MODEL;
        K = paramString1;
        paramString1 = b(paramString1);
        K = paramString1;
        K = URLEncoder.encode(paramString1, "utf-8");
        label99:
        if (J == 0) {
          J = Build.VERSION.SDK_INT;
        }
        if (I == null) {}
        try
        {
          paramString1 = paramContext.getPackageName();
          I = paramString1;
          paramString1 = b(paramString1);
          I = paramString1;
          I = URLEncoder.encode(paramString1, "utf-8");
          label145:
          if (D == null) {}
          try
          {
            paramString1 = ha.e(paramContext);
            D = paramString1;
            paramString1 = b(paramString1);
            D = paramString1;
            D = URLEncoder.encode(paramString1, "utf-8");
            label179:
            if (E == null) {}
            try
            {
              paramString1 = ha.d(paramContext);
              E = paramString1;
              paramString1 = b(paramString1);
              E = paramString1;
              E = URLEncoder.encode(paramString1, "utf-8");
              label213:
              if (F == null) {}
              try
              {
                paramString1 = ha.f(paramContext);
                F = paramString1;
                paramString1 = b(paramString1);
                F = paramString1;
                F = URLEncoder.encode(paramString1, "utf-8");
                label247:
                if (G == null) {}
                try
                {
                  paramString1 = Util.getMD5String(Util.getIMei(paramContext));
                  G = paramString1;
                  paramString1 = b(paramString1);
                  G = paramString1;
                  G = URLEncoder.encode(paramString1, "utf-8");
                  label284:
                  if (H == null) {}
                  try
                  {
                    paramString1 = NetUtil.getNetTypeStr(paramContext);
                    H = paramString1;
                    paramString1 = b(paramString1);
                    H = paramString1;
                    H = URLEncoder.encode(paramString1, "utf-8");
                    label318:
                    if (x == null) {}
                    try
                    {
                      paramString1 = ha.a(paramContext, "TencentMapSDK");
                      x = paramString1;
                      x = URLEncoder.encode(paramString1, "utf-8");
                      label346:
                      if (M == 1.0F) {
                        M = 320.0F / paramContext.getResources().getDisplayMetrics().densityDpi;
                      }
                      Y = paramContext.getResources().getDisplayMetrics().density;
                      AppMethodBeat.o(225891);
                      return;
                      label392:
                      X = paramString1.densityDpi;
                      G();
                    }
                    catch (Exception paramString1)
                    {
                      break label346;
                    }
                  }
                  catch (Exception paramString1)
                  {
                    break label318;
                  }
                }
                catch (Exception paramString1)
                {
                  break label284;
                }
              }
              catch (Exception paramString1)
              {
                break label247;
              }
            }
            catch (Exception paramString1)
            {
              break label213;
            }
          }
          catch (Exception paramString1)
          {
            break label179;
          }
        }
        catch (Exception paramString1)
        {
          break label145;
        }
      }
      catch (Exception paramString1)
      {
        break label99;
      }
    }
  }
  
  private static void a(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(225941);
    Object localObject = null;
    try
    {
      Field localField = paramDisplayMetrics.getClass().getField("densityDpi");
      localObject = localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label21;
    }
    catch (SecurityException localSecurityException)
    {
      label21:
      break label21;
    }
    if (localObject != null) {
      try
      {
        X = localObject.getInt(paramDisplayMetrics);
        G();
        AppMethodBeat.o(225941);
        return;
      }
      catch (IllegalArgumentException paramDisplayMetrics)
      {
        AppMethodBeat.o(225941);
        return;
      }
      catch (IllegalAccessException paramDisplayMetrics)
      {
        AppMethodBeat.o(225941);
        return;
      }
    }
    H();
    AppMethodBeat.o(225941);
  }
  
  public static void a(boolean paramBoolean)
  {
    AppMethodBeat.i(226070);
    A = new a(paramBoolean, (byte)0);
    AppMethodBeat.o(226070);
  }
  
  private static boolean a(Context paramContext, byte[] paramArrayOfByte, String paramString)
  {
    AppMethodBeat.i(226015);
    paramContext = paramContext.getFileStreamPath("tecentmap");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    paramContext = paramContext.getPath() + "/" + paramString;
    if (TextUtils.isEmpty(paramContext)) {}
    for (int i1 = 0; i1 == 0; i1 = kb.a(paramArrayOfByte, new File(paramContext)))
    {
      AppMethodBeat.o(226015);
      return false;
    }
    AppMethodBeat.o(226015);
    return true;
  }
  
  private static byte[] a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(226021);
    paramContext = paramContext.getFileStreamPath("tecentmap");
    paramContext = kb.b(paramContext.getPath() + "/" + paramString);
    paramString = kb.b(paramContext);
    kb.a(paramContext);
    AppMethodBeat.o(226021);
    return paramString;
  }
  
  public static float b()
  {
    AppMethodBeat.i(225777);
    L();
    float f1 = M;
    AppMethodBeat.o(225777);
    return f1;
  }
  
  public static int b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226033);
    if (gz.a(paramString2))
    {
      AppMethodBeat.o(226033);
      return 1;
    }
    if (gz.a(paramString1))
    {
      AppMethodBeat.o(226033);
      return -1;
    }
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    int i2 = arrayOfString1.length;
    int i1 = i2;
    if (i2 > arrayOfString2.length) {
      i1 = arrayOfString2.length;
    }
    i2 = 0;
    while (i2 < i1)
    {
      paramString2 = arrayOfString2[i2];
      String str = arrayOfString1[i2];
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "0";
      }
      paramString2 = str;
      if (TextUtils.isEmpty(str)) {
        paramString2 = "0";
      }
      if (Integer.valueOf(paramString1).intValue() < Integer.valueOf(paramString2).intValue())
      {
        AppMethodBeat.o(226033);
        return 1;
      }
      if (Integer.valueOf(paramString1).intValue() > Integer.valueOf(paramString2).intValue())
      {
        AppMethodBeat.o(226033);
        return -1;
      }
      i2 += 1;
    }
    if (arrayOfString1.length > arrayOfString2.length)
    {
      AppMethodBeat.o(226033);
      return 1;
    }
    if (arrayOfString1.length == arrayOfString2.length)
    {
      AppMethodBeat.o(226033);
      return 0;
    }
    AppMethodBeat.o(226033);
    return -1;
  }
  
  private static String b(Context paramContext)
  {
    AppMethodBeat.i(225993);
    if (paramContext == null)
    {
      AppMethodBeat.o(225993);
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = null;
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.loadLabel(localPackageManager);
        try
        {
          paramContext = URLEncoder.encode(paramContext.toString(), "utf-8");
          AppMethodBeat.o(225993);
          return paramContext;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext = "can't find app name";
          }
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
        continue;
        paramContext = "can't find app name";
      }
    }
  }
  
  private static String b(String paramString)
  {
    AppMethodBeat.i(225872);
    if (paramString == null)
    {
      AppMethodBeat.o(225872);
      return "";
    }
    paramString = paramString.replace("&", "").replace("#", "").replace("?", "");
    AppMethodBeat.o(225872);
    return paramString;
  }
  
  private static void b(DisplayMetrics paramDisplayMetrics)
  {
    AppMethodBeat.i(225949);
    X = paramDisplayMetrics.densityDpi;
    G();
    AppMethodBeat.o(225949);
  }
  
  public static String c()
  {
    AppMethodBeat.i(225786);
    L();
    AppMethodBeat.o(225786);
    return "androidsdk";
  }
  
  private static String c(String paramString)
  {
    AppMethodBeat.i(225877);
    paramString = Pattern.compile("[^a-zA-Z0-9]").matcher(paramString).replaceAll("").trim();
    AppMethodBeat.o(225877);
    return paramString;
  }
  
  public static String d()
  {
    AppMethodBeat.i(225794);
    if ((L().a) || (G == null))
    {
      AppMethodBeat.o(225794);
      return "";
    }
    String str = G;
    AppMethodBeat.o(225794);
    return str;
  }
  
  private static String d(String paramString)
  {
    AppMethodBeat.i(225923);
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = ((MessageDigest)localObject).digest();
      StringBuilder localStringBuilder = new StringBuilder();
      int i2 = localObject.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localStringBuilder.append(Integer.toHexString(localObject[i1] & 0xFF)).append("");
        i1 += 1;
      }
      localObject = localStringBuilder.toString();
      AppMethodBeat.o(225923);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(225923);
    }
    return paramString;
  }
  
  public static int e()
  {
    AppMethodBeat.i(225803);
    L();
    int i1 = W;
    AppMethodBeat.o(225803);
    return i1;
  }
  
  private static String[] e(String paramString)
  {
    AppMethodBeat.i(226026);
    String[] arrayOfString = new String[3];
    try
    {
      paramString = new JSONObject(paramString);
      arrayOfString[0] = paramString.optString("version");
      arrayOfString[1] = paramString.optString("data");
      arrayOfString[2] = paramString.optString("otherDistrict");
      label50:
      AppMethodBeat.o(226026);
      return arrayOfString;
    }
    catch (JSONException paramString)
    {
      break label50;
    }
  }
  
  public static String f()
  {
    AppMethodBeat.i(225812);
    if ((L().a) || (H == null))
    {
      AppMethodBeat.o(225812);
      return "";
    }
    String str = H;
    AppMethodBeat.o(225812);
    return str;
  }
  
  public static String g()
  {
    AppMethodBeat.i(225815);
    if ((L().a) || (K == null))
    {
      AppMethodBeat.o(225815);
      return "";
    }
    String str = K;
    AppMethodBeat.o(225815);
    return str;
  }
  
  public static String h()
  {
    AppMethodBeat.i(225824);
    L();
    String str = B;
    AppMethodBeat.o(225824);
    return str;
  }
  
  public static int i()
  {
    AppMethodBeat.i(225831);
    if (L().a)
    {
      AppMethodBeat.o(225831);
      return 0;
    }
    int i1 = J;
    AppMethodBeat.o(225831);
    return i1;
  }
  
  public static String j()
  {
    AppMethodBeat.i(225838);
    L();
    if (E == null)
    {
      AppMethodBeat.o(225838);
      return "";
    }
    String str = E;
    AppMethodBeat.o(225838);
    return str;
  }
  
  public static String k()
  {
    AppMethodBeat.i(225853);
    L();
    if ((z != null) && (!TextUtils.isEmpty(z)) && (!z.equals(I)))
    {
      str = z;
      AppMethodBeat.o(225853);
      return str;
    }
    if (I == null)
    {
      AppMethodBeat.o(225853);
      return "";
    }
    String str = I;
    AppMethodBeat.o(225853);
    return str;
  }
  
  public static String l()
  {
    AppMethodBeat.i(225858);
    L();
    String str = C;
    AppMethodBeat.o(225858);
    return str;
  }
  
  public static float m()
  {
    AppMethodBeat.i(225865);
    L();
    float f1 = Y;
    AppMethodBeat.o(225865);
    return f1;
  }
  
  public static void n()
  {
    s = 73670000;
    t = 135100000;
    r = 53500000;
    q = 4000000;
  }
  
  public static void o()
  {
    A = null;
    z = null;
    y = null;
  }
  
  public static final class a
  {
    final boolean a;
    
    private a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    private String a()
    {
      AppMethodBeat.i(221836);
      if ((this.a) || (gw.p() == null))
      {
        AppMethodBeat.o(221836);
        return "";
      }
      String str = gw.p();
      AppMethodBeat.o(221836);
      return str;
    }
    
    private static String b()
    {
      return "androidsdk";
    }
    
    private String c()
    {
      AppMethodBeat.i(221850);
      if ((this.a) || (gw.q() == null))
      {
        AppMethodBeat.o(221850);
        return "";
      }
      String str = gw.q();
      AppMethodBeat.o(221850);
      return str;
    }
    
    private int d()
    {
      AppMethodBeat.i(221859);
      if (this.a)
      {
        AppMethodBeat.o(221859);
        return 0;
      }
      int i = gw.r();
      AppMethodBeat.o(221859);
      return i;
    }
    
    private String e()
    {
      AppMethodBeat.i(221865);
      if ((this.a) || (gw.s() == null))
      {
        AppMethodBeat.o(221865);
        return "";
      }
      String str = gw.s();
      AppMethodBeat.o(221865);
      return str;
    }
    
    private static int f()
    {
      AppMethodBeat.i(221875);
      int i = gw.t();
      AppMethodBeat.o(221875);
      return i;
    }
    
    private String g()
    {
      AppMethodBeat.i(221882);
      if ((this.a) || (gw.u() == null))
      {
        AppMethodBeat.o(221882);
        return "";
      }
      String str = gw.u();
      AppMethodBeat.o(221882);
      return str;
    }
    
    private static String h()
    {
      AppMethodBeat.i(221890);
      if ((gw.v() != null) && (!TextUtils.isEmpty(gw.v())) && (!gw.v().equals(gw.w())))
      {
        str = gw.v();
        AppMethodBeat.o(221890);
        return str;
      }
      if (gw.w() == null)
      {
        AppMethodBeat.o(221890);
        return "";
      }
      String str = gw.w();
      AppMethodBeat.o(221890);
      return str;
    }
    
    private static String i()
    {
      AppMethodBeat.i(221897);
      String str = gw.x();
      AppMethodBeat.o(221897);
      return str;
    }
    
    private static String j()
    {
      AppMethodBeat.i(221907);
      if (gw.y() == null)
      {
        AppMethodBeat.o(221907);
        return "";
      }
      String str = gw.y();
      AppMethodBeat.o(221907);
      return str;
    }
    
    private static String k()
    {
      AppMethodBeat.i(221914);
      String str = gw.z();
      AppMethodBeat.o(221914);
      return str;
    }
    
    private static float l()
    {
      AppMethodBeat.i(221920);
      float f = gw.A();
      AppMethodBeat.o(221920);
      return f;
    }
    
    private static float m()
    {
      AppMethodBeat.i(221925);
      float f = gw.B();
      AppMethodBeat.o(221925);
      return f;
    }
    
    private static String n()
    {
      AppMethodBeat.i(221931);
      if ((gw.C() != null) && (!gw.C().equals(gw.D())))
      {
        str = gw.C();
        AppMethodBeat.o(221931);
        return str;
      }
      String str = gw.D();
      AppMethodBeat.o(221931);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.gw
 * JD-Core Version:    0.7.0.1
 */