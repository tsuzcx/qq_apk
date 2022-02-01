package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.a.a;
import com.tencent.luggage.sdk.b.a.a.a.c;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.af.d;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.InputStream;
import java.util.Locale;

public abstract class AbsReader
  implements ICommLibReader
{
  private volatile String qDF;
  private volatile String qDG;
  private volatile i qDH;
  private volatile a qDI;
  private volatile String versionName;
  
  /* Error */
  private i cfC()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	com/tencent/mm/plugin/appbrand/appcache/AbsReader:qDH	Lcom/tencent/mm/ad/i;
    //   4: ifnonnull +66 -> 70
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 25	com/tencent/mm/plugin/appbrand/appcache/AbsReader:qDH	Lcom/tencent/mm/ad/i;
    //   13: ifnonnull +55 -> 68
    //   16: aload_0
    //   17: ldc 27
    //   19: invokevirtual 31	com/tencent/mm/plugin/appbrand/appcache/AbsReader:UW	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +21 -> 48
    //   30: ldc 39
    //   32: ldc 41
    //   34: iconst_1
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_0
    //   41: invokevirtual 45	com/tencent/mm/plugin/appbrand/appcache/AbsReader:cfI	()Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;
    //   44: aastore
    //   45: invokestatic 51	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: aload_2
    //   49: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +23 -> 75
    //   55: new 53	com/tencent/mm/ad/i
    //   58: dup
    //   59: invokespecial 54	com/tencent/mm/ad/i:<init>	()V
    //   62: astore_1
    //   63: aload_0
    //   64: aload_1
    //   65: putfield 25	com/tencent/mm/plugin/appbrand/appcache/AbsReader:qDH	Lcom/tencent/mm/ad/i;
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_0
    //   71: getfield 25	com/tencent/mm/plugin/appbrand/appcache/AbsReader:qDH	Lcom/tencent/mm/ad/i;
    //   74: areturn
    //   75: new 53	com/tencent/mm/ad/i
    //   78: dup
    //   79: aload_2
    //   80: invokespecial 57	com/tencent/mm/ad/i:<init>	(Ljava/lang/String;)V
    //   83: astore_1
    //   84: goto -21 -> 63
    //   87: astore_1
    //   88: ldc 39
    //   90: aload_1
    //   91: ldc 59
    //   93: iconst_1
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload_2
    //   100: aastore
    //   101: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: new 53	com/tencent/mm/ad/i
    //   107: dup
    //   108: invokespecial 54	com/tencent/mm/ad/i:<init>	()V
    //   111: astore_1
    //   112: aload_0
    //   113: monitorexit
    //   114: aload_1
    //   115: areturn
    //   116: astore_1
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	AbsReader
    //   62	22	1	locali1	i
    //   87	4	1	localg	com.tencent.mm.ad.g
    //   111	4	1	locali2	i
    //   116	4	1	localObject	Object
    //   22	78	2	str	String
    // Exception table:
    //   from	to	target	type
    //   48	63	87	com/tencent/mm/ad/g
    //   63	68	87	com/tencent/mm/ad/g
    //   75	84	87	com/tencent/mm/ad/g
    //   9	48	116	finally
    //   48	63	116	finally
    //   63	68	116	finally
    //   75	84	116	finally
    //   88	114	116	finally
  }
  
  public final String UW(String paramString)
  {
    InputStream localInputStream = Lh(paramString);
    if (localInputStream == null) {
      return null;
    }
    long l = Util.currentTicks();
    String str = d.convertStreamToString(localInputStream);
    Util.qualityClose(localInputStream);
    Log.v("MicroMsg.AppBrand.AbsReader", "readAsString(%s), cost %dms", new Object[] { paramString, Long.valueOf(Util.currentTicks() - l) });
    return str;
  }
  
  public final String UX(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    i locali;
    do
    {
      return null;
      locali = cfC().Ft("features");
    } while (locali == null);
    return locali.optString(paramString, null);
  }
  
  public final String cfD()
  {
    String str2;
    String str1;
    Object localObject1;
    if (TextUtils.isEmpty(this.versionName))
    {
      localObject2 = "";
      str2 = "";
      str1 = str2;
      localObject1 = localObject2;
    }
    try
    {
      i locali = cfC();
      str1 = str2;
      localObject1 = localObject2;
      localObject2 = locali.getString("version");
      str1 = str2;
      localObject1 = localObject2;
      str2 = locali.getString("updateTime");
      str1 = str2;
      localObject1 = localObject2;
      Log.i("MicroMsg.AppBrand.AbsReader", "AbsReader version parsed wx.version[%s | %s]", new Object[] { localObject2, str2 });
      localObject1 = localObject2;
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.AbsReader", localException, "get WAVersion.json failed.", new Object[0]);
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    this.versionName = ((String)localObject2);
    this.qDF = str1;
    this.qDG = String.format(Locale.US, "%s (%s)", new Object[] { this.versionName, this.qDF });
    return this.versionName;
  }
  
  public final String cfE()
  {
    cfD();
    return Util.nullAsNil(this.qDG);
  }
  
  public final String cfF()
  {
    cfD();
    return this.qDF;
  }
  
  public final int cfG()
  {
    return cfI().pkgVersion();
  }
  
  public final a cfH()
  {
    try
    {
      if (this.qDI == null)
      {
        this.qDI = a.c.fp(UX("expt"));
        if (this.qDI == null) {
          this.qDI = a.c.arn();
        }
      }
      a locala = this.qDI;
      return locala;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.AbsReader
 * JD-Core Version:    0.7.0.1
 */