package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.aa.d;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.InputStream;
import java.util.Locale;

public abstract class AbsReader
  implements ICommLibReader
{
  private volatile String iLa;
  private volatile String iLb;
  private volatile i iLc;
  private volatile String versionName;
  
  /* Error */
  private i aOZ()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/mm/plugin/appbrand/appcache/AbsReader:iLc	Lcom/tencent/mm/ac/i;
    //   4: ifnonnull +41 -> 45
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 23	com/tencent/mm/plugin/appbrand/appcache/AbsReader:iLc	Lcom/tencent/mm/ac/i;
    //   13: ifnonnull +30 -> 43
    //   16: aload_0
    //   17: ldc 25
    //   19: invokevirtual 29	com/tencent/mm/plugin/appbrand/appcache/AbsReader:DH	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore_2
    //   23: aload_2
    //   24: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +23 -> 50
    //   30: new 37	com/tencent/mm/ac/i
    //   33: dup
    //   34: invokespecial 38	com/tencent/mm/ac/i:<init>	()V
    //   37: astore_1
    //   38: aload_0
    //   39: aload_1
    //   40: putfield 23	com/tencent/mm/plugin/appbrand/appcache/AbsReader:iLc	Lcom/tencent/mm/ac/i;
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_0
    //   46: getfield 23	com/tencent/mm/plugin/appbrand/appcache/AbsReader:iLc	Lcom/tencent/mm/ac/i;
    //   49: areturn
    //   50: new 37	com/tencent/mm/ac/i
    //   53: dup
    //   54: aload_2
    //   55: invokespecial 41	com/tencent/mm/ac/i:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: goto -21 -> 38
    //   62: astore_1
    //   63: ldc 43
    //   65: aload_1
    //   66: ldc 45
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_2
    //   75: aastore
    //   76: invokestatic 51	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: new 37	com/tencent/mm/ac/i
    //   82: dup
    //   83: invokespecial 38	com/tencent/mm/ac/i:<init>	()V
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: areturn
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	AbsReader
    //   37	22	1	locali1	i
    //   62	4	1	localg	com.tencent.mm.ac.g
    //   86	4	1	locali2	i
    //   91	4	1	localObject	Object
    //   22	53	2	str	String
    // Exception table:
    //   from	to	target	type
    //   23	38	62	com/tencent/mm/ac/g
    //   38	43	62	com/tencent/mm/ac/g
    //   50	59	62	com/tencent/mm/ac/g
    //   9	23	91	finally
    //   23	38	91	finally
    //   38	43	91	finally
    //   43	45	91	finally
    //   50	59	91	finally
    //   63	89	91	finally
    //   92	94	91	finally
  }
  
  public final String DH(String paramString)
  {
    InputStream localInputStream = openRead(paramString);
    if (localInputStream == null) {
      return null;
    }
    long l = bt.GC();
    String str = d.convertStreamToString(localInputStream);
    bt.d(localInputStream);
    ad.v("MicroMsg.AppBrand.AbsReader", "readAsString(%s), cost %dms", new Object[] { paramString, Long.valueOf(bt.GC() - l) });
    return str;
  }
  
  public final String DI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    i locali;
    do
    {
      return null;
      locali = aOZ().qK("features");
    } while (locali == null);
    return locali.optString(paramString, null);
  }
  
  public final String aPa()
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
      i locali = aOZ();
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
    this.iLa = str1;
    this.iLb = String.format(Locale.US, "%s (%s)", new Object[] { this.versionName, this.iLa });
    return this.versionName;
  }
  
  public final String aPb()
  {
    aPa();
    return bt.nullAsNil(this.iLb);
  }
  
  public final int aPc()
  {
    return aPd().pkgVersion();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.AbsReader
 * JD-Core Version:    0.7.0.1
 */