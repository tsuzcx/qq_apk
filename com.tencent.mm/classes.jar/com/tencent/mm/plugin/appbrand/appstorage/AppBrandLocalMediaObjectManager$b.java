package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;
import org.apache.commons.a.b;

final class AppBrandLocalMediaObjectManager$b
  implements AppBrandLocalMediaObjectManager.a
{
  /* Error */
  public final com.tencent.mm.vending.j.a C(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 21
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: ldc 29
    //   8: invokestatic 35	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_3
    //   12: aload_2
    //   13: invokestatic 39	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:za	(Ljava/lang/String;)J
    //   16: lstore 4
    //   18: getstatic 45	java/util/Locale:US	Ljava/util/Locale;
    //   21: ldc 47
    //   23: iconst_2
    //   24: anewarray 4	java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: lload 4
    //   31: invokestatic 53	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   34: aastore
    //   35: dup
    //   36: iconst_1
    //   37: aload_3
    //   38: aastore
    //   39: invokestatic 59	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   42: astore_2
    //   43: aload_2
    //   44: aload_1
    //   45: invokestatic 62	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:by	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   48: astore_2
    //   49: aload_2
    //   50: invokestatic 66	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   53: ifeq +54 -> 107
    //   56: ldc 21
    //   58: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aconst_null
    //   62: areturn
    //   63: astore_1
    //   64: ldc 71
    //   66: ldc 73
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_1
    //   75: invokestatic 77	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   78: aastore
    //   79: invokestatic 83	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: ldc 21
    //   84: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aconst_null
    //   88: areturn
    //   89: astore_2
    //   90: ldc 71
    //   92: aload_2
    //   93: ldc 85
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aconst_null
    //   103: astore_2
    //   104: goto -55 -> 49
    //   107: ldc 91
    //   109: aload_2
    //   110: invokestatic 94	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   113: invokevirtual 98	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 6
    //   118: new 100	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   125: aload_1
    //   126: invokestatic 104	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:yZ	(Ljava/lang/String;)Ljava/lang/String;
    //   129: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 6
    //   134: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: astore_2
    //   141: new 100	java/lang/StringBuilder
    //   144: dup
    //   145: ldc 114
    //   147: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload 6
    //   152: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: astore 6
    //   157: aload_3
    //   158: invokestatic 66	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   161: ifeq +49 -> 210
    //   164: ldc 119
    //   166: astore_1
    //   167: aload 6
    //   169: aload_1
    //   170: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: astore_1
    //   177: ldc 71
    //   179: ldc 121
    //   181: iconst_2
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_1
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: aload_2
    //   192: aastore
    //   193: invokestatic 124	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload_1
    //   197: aload_2
    //   198: aload_3
    //   199: invokestatic 129	com/tencent/mm/vending/j/a:i	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
    //   202: astore_1
    //   203: ldc 21
    //   205: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_1
    //   209: areturn
    //   210: ldc 131
    //   212: aload_3
    //   213: invokestatic 94	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   216: invokevirtual 98	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   219: astore_1
    //   220: goto -53 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	b
    //   0	223	1	paramString1	String
    //   0	223	2	paramString2	String
    //   0	223	3	paramString3	String
    //   16	14	4	l	long
    //   116	52	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	18	63	java/lang/Exception
    //   43	49	89	java/lang/Exception
  }
  
  public final AppBrandLocalMediaObject bz(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(105344);
    if ((!paramString2.startsWith("store_")) && (!paramString2.startsWith("tmp_")))
    {
      AppMethodBeat.o(105344);
      return null;
    }
    String str3 = b.azG(paramString2);
    String str2 = paramString2.replaceFirst("store_", "").replaceFirst("tmp_", "");
    String str1 = str2;
    if (!bo.isNullOrNil(str3)) {
      str1 = str2.replaceFirst(".".concat(String.valueOf(str3)), "");
    }
    if (bo.isNullOrNil(str1))
    {
      paramString1 = AppBrandLocalMediaObjectManager.aQy();
      AppMethodBeat.o(105344);
      return paramString1;
    }
    try
    {
      str2 = AppBrandLocalMediaObjectManager.bx(str1, paramString1);
      localObject1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObject, decrypt exp ", new Object[0]);
      }
      Object localObject2 = ((String)localObject1).split("\\|");
      if ((localObject2 != null) && (localObject2.length == 2)) {
        break label194;
      }
      paramString1 = AppBrandLocalMediaObjectManager.aQy();
      AppMethodBeat.o(105344);
      return paramString1;
      label194:
      if (!paramString2.startsWith("store_")) {
        break label272;
      }
      long l1;
      label272:
      for (localObject1 = "store_";; localObject1 = "tmp_")
      {
        str1 = AppBrandLocalMediaObjectManager.yZ(paramString1) + (String)localObject1 + str1;
        l1 = bo.getLong(localObject2[0], 0L);
        localObject2 = localObject2[1];
        if (((String)localObject2).equalsIgnoreCase(str3)) {
          break;
        }
        paramString1 = AppBrandLocalMediaObjectManager.aQy();
        AppMethodBeat.o(105344);
        return paramString1;
      }
      try
      {
        long l2 = AppBrandLocalMediaObjectManager.za(str1);
        if (l1 != l2)
        {
          ab.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString2, paramString1 });
          paramString1 = AppBrandLocalMediaObjectManager.aQy();
          AppMethodBeat.o(105344);
          return paramString1;
        }
      }
      catch (IOException paramString1)
      {
        ab.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { bo.l(paramString1) });
        paramString1 = AppBrandLocalMediaObjectManager.aQy();
        AppMethodBeat.o(105344);
        return paramString1;
      }
      paramString1 = new AppBrandLocalMediaObject();
      paramString1.ctV = "wxfile://".concat(String.valueOf(paramString2));
      paramString1.fod = str1;
      paramString1.mimeType = c.aqq((String)localObject2);
      paramString1.gZm = ((String)localObject1).equalsIgnoreCase("store_");
      paramString2 = new File(paramString1.fod);
      paramString1.gZn = paramString2.lastModified();
      paramString1.gmb = paramString2.length();
      AppMethodBeat.o(105344);
    }
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
      paramString1 = AppBrandLocalMediaObjectManager.aQy();
      AppMethodBeat.o(105344);
      return paramString1;
    }
    return paramString1;
  }
  
  public final String toString()
  {
    return "V2MediaObjectInfoHandler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager.b
 * JD-Core Version:    0.7.0.1
 */