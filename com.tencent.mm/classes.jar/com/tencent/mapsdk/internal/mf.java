package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;

public final class mf
{
  public static final String a = "data/";
  private static final String f = "/tencentmapsdk/";
  private static mf g;
  public String b;
  public String c;
  public String d;
  public String e;
  private Context h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  
  private mf(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(223060);
    if (paramContext == null)
    {
      paramContext = new Error("context can not be null");
      AppMethodBeat.o(223060);
      throw paramContext;
    }
    this.h = paramContext.getApplicationContext();
    int i1;
    if (paramTencentMapOptions != null)
    {
      paramContext = paramTencentMapOptions.getCustomCacheRootPath();
      if (TextUtils.isEmpty(paramContext)) {
        break label512;
      }
      paramTencentMapOptions = new File(paramContext);
      if ((!paramTencentMapOptions.isDirectory()) || (!paramTencentMapOptions.canRead()) || (!paramTencentMapOptions.canWrite()) || (e(paramContext) <= 5L)) {
        break label512;
      }
      i1 = 1;
      if (i1 != 0) {
        this.p = paramContext;
      }
    }
    this.n = this.h.getFilesDir().getAbsolutePath();
    this.k = (this.n + "/tencentMapSdk/config/");
    this.o = (this.k + "temp/");
    this.l = (this.n + "/tencentMapSdk/assets/");
    this.m = (this.n + "/tencentMapSdk/dynamicAssets/");
    paramContext = this.h;
    paramTencentMapOptions = me.a(this.h).a("sdkVersion");
    if ((!gz.a(me.a(paramContext).a("sdkVersion"))) && (gw.b("4.1.0", paramTencentMapOptions) > 0))
    {
      md.a(paramContext);
      ka.f(new File(this.k));
      ka.f(new File(this.l));
      ka.f(new File(this.n + "/tencentMapSdk/subKey/"));
    }
    paramContext = a();
    paramTencentMapOptions = ka.a(this.h);
    if (gz.a(paramTencentMapOptions)) {}
    for (this.i = (paramContext + "/tencentmapsdk/");; this.i = (paramContext + "/tencentmapsdk/" + paramTencentMapOptions))
    {
      this.j = (this.i + "/data/v3/render/");
      this.b = (this.i + "/sat/");
      this.c = (this.j + "closeRoadDatas/");
      this.d = (this.j + "events/icons");
      this.e = (this.j + "offlineMaps/");
      AppMethodBeat.o(223060);
      return;
      label512:
      i1 = 0;
      break;
    }
  }
  
  private static mf a(Context paramContext)
  {
    AppMethodBeat.i(223040);
    paramContext = a(paramContext, null);
    AppMethodBeat.o(223040);
    return paramContext;
  }
  
  public static mf a(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(223045);
    if (g == null) {
      g = new mf(paramContext, paramTencentMapOptions);
    }
    paramContext = g;
    AppMethodBeat.o(223045);
    return paramContext;
  }
  
  private void a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(223092);
    if (gz.a(me.a(paramContext).a("sdkVersion")))
    {
      AppMethodBeat.o(223092);
      return;
    }
    if (gw.b("4.1.0", paramString) > 0)
    {
      md.a(paramContext);
      ka.f(new File(this.k));
      ka.f(new File(this.l));
      ka.f(new File(this.n + "/tencentMapSdk/subKey/"));
    }
    AppMethodBeat.o(223092);
  }
  
  private void a(TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(223073);
    if (paramTencentMapOptions != null)
    {
      paramTencentMapOptions = paramTencentMapOptions.getCustomCacheRootPath();
      if (TextUtils.isEmpty(paramTencentMapOptions)) {
        break label79;
      }
      File localFile = new File(paramTencentMapOptions);
      if ((!localFile.isDirectory()) || (!localFile.canRead()) || (!localFile.canWrite()) || (e(paramTencentMapOptions) <= 5L)) {
        break label79;
      }
    }
    label79:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        this.p = paramTencentMapOptions;
      }
      AppMethodBeat.o(223073);
      return;
    }
  }
  
  private static String b(Context paramContext)
  {
    AppMethodBeat.i(223097);
    File localFile = paramContext.getExternalFilesDir(null);
    if (localFile != null)
    {
      paramContext = localFile.getAbsolutePath();
      AppMethodBeat.o(223097);
      return paramContext;
    }
    paramContext = paramContext.getFilesDir().getPath();
    AppMethodBeat.o(223097);
    return paramContext;
  }
  
  private static boolean d(String paramString)
  {
    AppMethodBeat.i(223079);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(223079);
      return false;
    }
    File localFile = new File(paramString);
    if ((localFile.isDirectory()) && (localFile.canRead()) && (localFile.canWrite()) && (e(paramString) > 5L))
    {
      AppMethodBeat.o(223079);
      return true;
    }
    AppMethodBeat.o(223079);
    return false;
  }
  
  private static long e(String paramString)
  {
    AppMethodBeat.i(223105);
    try
    {
      paramString = new StatFs(paramString);
      long l2;
      if (Build.VERSION.SDK_INT < 18) {
        l2 = paramString.getBlockSize();
      }
      for (long l1 = paramString.getAvailableBlocks();; l1 = paramString.getAvailableBlocksLong())
      {
        l1 = l1 * l2 / 1024L / 1024L;
        AppMethodBeat.o(223105);
        return l1;
        l2 = paramString.getBlockSizeLong();
      }
      return 0L;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(223105);
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(223067);
    this.n = this.h.getFilesDir().getAbsolutePath();
    this.k = (this.n + "/tencentMapSdk/config/");
    this.o = (this.k + "temp/");
    this.l = (this.n + "/tencentMapSdk/assets/");
    this.m = (this.n + "/tencentMapSdk/dynamicAssets/");
    Context localContext = this.h;
    String str = me.a(this.h).a("sdkVersion");
    if ((!gz.a(me.a(localContext).a("sdkVersion"))) && (gw.b("4.1.0", str) > 0))
    {
      md.a(localContext);
      ka.f(new File(this.k));
      ka.f(new File(this.l));
      ka.f(new File(this.n + "/tencentMapSdk/subKey/"));
    }
    AppMethodBeat.o(223067);
  }
  
  private void g()
  {
    AppMethodBeat.i(223085);
    String str1 = a();
    String str2 = ka.a(this.h);
    if (gz.a(str2)) {}
    for (this.i = (str1 + "/tencentmapsdk/");; this.i = (str1 + "/tencentmapsdk/" + str2))
    {
      this.j = (this.i + "/data/v3/render/");
      this.b = (this.i + "/sat/");
      this.c = (this.j + "closeRoadDatas/");
      this.d = (this.j + "events/icons");
      this.e = (this.j + "offlineMaps/");
      AppMethodBeat.o(223085);
      return;
    }
  }
  
  private String h()
  {
    AppMethodBeat.i(223110);
    kb.a(this.b);
    String str = this.b;
    AppMethodBeat.o(223110);
    return str;
  }
  
  private String i()
  {
    AppMethodBeat.i(223117);
    kb.a(this.c);
    String str = this.c;
    AppMethodBeat.o(223117);
    return str;
  }
  
  private String j()
  {
    AppMethodBeat.i(223121);
    kb.a(this.d);
    String str = this.d;
    AppMethodBeat.o(223121);
    return str;
  }
  
  private String k()
  {
    AppMethodBeat.i(223126);
    kb.a(this.e);
    String str = this.e;
    AppMethodBeat.o(223126);
    return str;
  }
  
  public final String a()
  {
    AppMethodBeat.i(223132);
    if (!TextUtils.isEmpty(this.p))
    {
      localObject = this.p;
      AppMethodBeat.o(223132);
      return localObject;
    }
    Context localContext = this.h;
    String str = b(localContext);
    Object localObject = str;
    if (e(str) < 5L)
    {
      str = localContext.getFilesDir().getPath();
      localObject = str;
      if (e(str) < 5L) {
        localObject = b(localContext);
      }
    }
    AppMethodBeat.o(223132);
    return localObject;
  }
  
  public final String a(String paramString)
  {
    AppMethodBeat.i(223162);
    if (gz.a(paramString)) {}
    for (paramString = this.k;; paramString = this.n + "/tencentMapSdk/subKey/" + paramString + "/config/")
    {
      kb.a(paramString);
      AppMethodBeat.o(223162);
      return paramString;
    }
  }
  
  public final File b()
  {
    AppMethodBeat.i(223142);
    File localFile = new File(this.i + "/data/");
    AppMethodBeat.o(223142);
    return localFile;
  }
  
  public final String b(String paramString)
  {
    AppMethodBeat.i(223167);
    if (gz.a(paramString)) {}
    for (paramString = this.l;; paramString = this.n + "/tencentMapSdk/subKey/" + paramString + "/assets/")
    {
      kb.a(paramString);
      AppMethodBeat.o(223167);
      return paramString;
    }
  }
  
  public final File c()
  {
    AppMethodBeat.i(223150);
    File localFile = new File(this.i);
    AppMethodBeat.o(223150);
    return localFile;
  }
  
  public final String c(String paramString)
  {
    AppMethodBeat.i(223184);
    if (gz.a(paramString)) {}
    for (paramString = this.o;; paramString = a(paramString) + "temp/")
    {
      kb.a(paramString);
      AppMethodBeat.o(223184);
      return paramString;
    }
  }
  
  public final String d()
  {
    AppMethodBeat.i(223158);
    kb.a(this.j);
    String str = this.j;
    AppMethodBeat.o(223158);
    return str;
  }
  
  public final String e()
  {
    AppMethodBeat.i(223175);
    kb.a(this.m);
    String str = this.m;
    AppMethodBeat.o(223175);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.mf
 * JD-Core Version:    0.7.0.1
 */