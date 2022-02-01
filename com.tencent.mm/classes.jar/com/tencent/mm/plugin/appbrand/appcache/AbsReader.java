package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.InputStream;
import java.util.Locale;

public abstract class AbsReader
  implements ICommLibReader
{
  private volatile String jEX;
  private volatile String jEY;
  private volatile i jEZ;
  private volatile String versionName;
  
  /* Error */
  private i aZm()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/mm/plugin/appbrand/appcache/AbsReader:jEZ	Lcom/tencent/mm/ac/i;
    //   4: ifnonnull +66 -> 70
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 23	com/tencent/mm/plugin/appbrand/appcache/AbsReader:jEZ	Lcom/tencent/mm/ac/i;
    //   13: ifnonnull +55 -> 68
    //   16: aload_0
    //   17: ldc 25
    //   19: invokevirtual 29	com/tencent/mm/plugin/appbrand/appcache/AbsReader:Ld	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +21 -> 48
    //   30: ldc 37
    //   32: ldc 39
    //   34: iconst_1
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_0
    //   41: invokevirtual 43	com/tencent/mm/plugin/appbrand/appcache/AbsReader:aZq	()Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;
    //   44: aastore
    //   45: invokestatic 49	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   48: aload_2
    //   49: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   52: ifeq +23 -> 75
    //   55: new 51	com/tencent/mm/ac/i
    //   58: dup
    //   59: invokespecial 52	com/tencent/mm/ac/i:<init>	()V
    //   62: astore_1
    //   63: aload_0
    //   64: aload_1
    //   65: putfield 23	com/tencent/mm/plugin/appbrand/appcache/AbsReader:jEZ	Lcom/tencent/mm/ac/i;
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_0
    //   71: getfield 23	com/tencent/mm/plugin/appbrand/appcache/AbsReader:jEZ	Lcom/tencent/mm/ac/i;
    //   74: areturn
    //   75: new 51	com/tencent/mm/ac/i
    //   78: dup
    //   79: aload_2
    //   80: invokespecial 55	com/tencent/mm/ac/i:<init>	(Ljava/lang/String;)V
    //   83: astore_1
    //   84: goto -21 -> 63
    //   87: astore_1
    //   88: ldc 37
    //   90: aload_1
    //   91: ldc 57
    //   93: iconst_1
    //   94: anewarray 4	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: aload_2
    //   100: aastore
    //   101: invokestatic 61	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   104: new 51	com/tencent/mm/ac/i
    //   107: dup
    //   108: invokespecial 52	com/tencent/mm/ac/i:<init>	()V
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
    //   87	4	1	localg	com.tencent.mm.ac.g
    //   111	4	1	locali2	i
    //   116	4	1	localObject	Object
    //   22	78	2	str	String
    // Exception table:
    //   from	to	target	type
    //   48	63	87	com/tencent/mm/ac/g
    //   63	68	87	com/tencent/mm/ac/g
    //   75	84	87	com/tencent/mm/ac/g
    //   9	48	116	finally
    //   48	63	116	finally
    //   63	68	116	finally
    //   68	70	116	finally
    //   75	84	116	finally
    //   88	114	116	finally
    //   117	119	116	finally
  }
  
  public final String Ld(String paramString)
  {
    InputStream localInputStream = openRead(paramString);
    if (localInputStream == null) {
      return null;
    }
    long l = bt.HI();
    String str = d.convertStreamToString(localInputStream);
    bt.d(localInputStream);
    ad.v("MicroMsg.AppBrand.AbsReader", "readAsString(%s), cost %dms", new Object[] { paramString, Long.valueOf(bt.HI() - l) });
    return str;
  }
  
  public final String Le(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    i locali;
    do
    {
      return null;
      locali = aZm().wP("features");
    } while (locali == null);
    return locali.optString(paramString, null);
  }
  
  public final String aZn()
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
      i locali = aZm();
      str1 = str2;
      localObject1 = localObject2;
      localObject2 = locali.getString("version");
      str1 = str2;
      localObject1 = localObject2;
      str2 = locali.getString("updateTime");
      str1 = str2;
      localObject1 = localObject2;
      ad.i("MicroMsg.AppBrand.AbsReader", "AbsReader version parsed wx.version[%s | %s]", new Object[] { localObject2, str2 });
      localObject1 = localObject2;
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppBrand.AbsReader", localException, "get WAVersion.json failed.", new Object[0]);
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    this.versionName = ((String)localObject2);
    this.jEX = str1;
    this.jEY = String.format(Locale.US, "%s (%s)", new Object[] { this.versionName, this.jEX });
    return this.versionName;
  }
  
  public final String aZo()
  {
    aZn();
    return bt.nullAsNil(this.jEY);
  }
  
  public final int aZp()
  {
    return aZq().pkgVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.AbsReader
 * JD-Core Version:    0.7.0.1
 */