package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;
import org.apache.commons.a.b;

final class LuggageLocalFileObjectManager$b
  implements LuggageLocalFileObjectManager.a
{
  private LuggageLocalFileObjectManager$b(LuggageLocalFileObjectManager paramLuggageLocalFileObjectManager) {}
  
  public final v a(v paramv)
  {
    AppMethodBeat.i(105420);
    if (paramv == null)
    {
      AppMethodBeat.o(105420);
      return null;
    }
    String str = paramv.fod.replaceFirst("tmp_", "store_");
    if (i.bA(paramv.fod, str))
    {
      v localv = new v();
      localv.fod = str;
      localv.ctV = paramv.ctV.replaceFirst("tmp_", "store_");
      localv.gmb = paramv.gmb;
      localv.elt = paramv.elt;
      localv.gZn = new File(localv.fod).lastModified();
      localv.mimeType = paramv.mimeType;
      localv.gZm = true;
      AppMethodBeat.o(105420);
      return localv;
    }
    AppMethodBeat.o(105420);
    return null;
  }
  
  /* Error */
  public final com.tencent.mm.vending.j.a bF(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 91
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ldc 93
    //   8: invokestatic 98	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_2
    //   12: aload_1
    //   13: invokestatic 102	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:zq	(Ljava/lang/String;)J
    //   16: lstore_3
    //   17: getstatic 108	java/util/Locale:US	Ljava/util/Locale;
    //   20: ldc 110
    //   22: iconst_2
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: lload_3
    //   29: invokestatic 116	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: aload_2
    //   36: aastore
    //   37: invokestatic 120	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   40: astore_1
    //   41: aload_1
    //   42: aload_0
    //   43: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:hai	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
    //   46: invokestatic 123	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:a	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
    //   49: invokestatic 126	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:bE	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_1
    //   53: aload_1
    //   54: invokestatic 130	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   57: ifeq +54 -> 111
    //   60: ldc 91
    //   62: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_1
    //   68: ldc 132
    //   70: ldc 134
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: invokestatic 138	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   82: aastore
    //   83: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   86: ldc 91
    //   88: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_1
    //   94: ldc 132
    //   96: aload_1
    //   97: ldc 146
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 150	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aconst_null
    //   107: astore_1
    //   108: goto -55 -> 53
    //   111: ldc 42
    //   113: aload_1
    //   114: invokestatic 153	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   117: invokevirtual 157	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   120: astore_1
    //   121: new 159	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   128: aload_0
    //   129: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:hai	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
    //   132: invokestatic 162	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
    //   135: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_1
    //   139: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 5
    //   147: new 159	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   154: aload_0
    //   155: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:hai	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
    //   158: invokestatic 173	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
    //   161: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: astore 6
    //   170: aload_2
    //   171: invokestatic 130	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   174: ifeq +51 -> 225
    //   177: ldc 175
    //   179: astore_1
    //   180: aload 6
    //   182: aload_1
    //   183: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: astore_1
    //   190: ldc 132
    //   192: ldc 177
    //   194: iconst_2
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload_1
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: aload 5
    //   206: aastore
    //   207: invokestatic 180	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload_1
    //   211: aload 5
    //   213: aload_2
    //   214: invokestatic 185	com/tencent/mm/vending/j/a:i	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
    //   217: astore_1
    //   218: ldc 91
    //   220: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: aload_1
    //   224: areturn
    //   225: ldc 187
    //   227: aload_2
    //   228: invokestatic 153	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   231: invokevirtual 157	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   234: astore_1
    //   235: goto -55 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	b
    //   0	238	1	paramString1	String
    //   0	238	2	paramString2	String
    //   16	13	3	l	long
    //   145	67	5	str	String
    //   168	13	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   12	17	67	java/lang/Exception
    //   41	53	93	java/lang/Exception
  }
  
  public final String toString()
  {
    return "V2MediaObjectInfoHandler";
  }
  
  public final v zr(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(105419);
    if ((!paramString.startsWith("store_")) && (!paramString.startsWith("tmp_")))
    {
      AppMethodBeat.o(105419);
      return null;
    }
    Object localObject3 = b.azG(paramString);
    String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
    String str1 = str2;
    if (!bo.isNullOrNil((String)localObject3)) {
      str1 = str2.replaceFirst(".".concat(String.valueOf(localObject3)), "");
    }
    if (bo.isNullOrNil(str1))
    {
      paramString = LuggageLocalFileObjectManager.awO();
      AppMethodBeat.o(105419);
      return paramString;
    }
    try
    {
      str2 = LuggageLocalFileObjectManager.bD(str1, LuggageLocalFileObjectManager.a(this.hai));
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
        break label200;
      }
      paramString = LuggageLocalFileObjectManager.awO();
      AppMethodBeat.o(105419);
      return paramString;
      label200:
      if (!paramString.startsWith("store_")) {
        break label281;
      }
      long l1;
      label281:
      for (localObject1 = "store_";; localObject1 = "tmp_")
      {
        str1 = LuggageLocalFileObjectManager.b(this.hai) + (String)localObject1 + str1;
        l1 = bo.getLong(localObject2[0], 0L);
        localObject2 = localObject2[1];
        if (((String)localObject2).equalsIgnoreCase((String)localObject3)) {
          break;
        }
        paramString = LuggageLocalFileObjectManager.awO();
        AppMethodBeat.o(105419);
        return paramString;
      }
      try
      {
        long l2 = LuggageLocalFileObjectManager.zq(str1);
        if (l1 != l2)
        {
          ab.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString });
          paramString = LuggageLocalFileObjectManager.awO();
          AppMethodBeat.o(105419);
          return paramString;
        }
      }
      catch (IOException paramString)
      {
        ab.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { bo.l(paramString) });
        paramString = LuggageLocalFileObjectManager.awO();
        AppMethodBeat.o(105419);
        return paramString;
      }
      localObject3 = new v();
      ((v)localObject3).ctV = (LuggageLocalFileObjectManager.c(this.hai) + paramString);
      ((v)localObject3).fod = str1;
      ((v)localObject3).mimeType = c.aqq((String)localObject2);
      ((v)localObject3).gZm = ((String)localObject1).equalsIgnoreCase("store_");
      paramString = new File(((v)localObject3).fod);
      ((v)localObject3).gZn = paramString.lastModified();
      ((v)localObject3).gmb = paramString.length();
      AppMethodBeat.o(105419);
    }
    if (bo.isNullOrNil((String)localObject1))
    {
      ab.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
      paramString = LuggageLocalFileObjectManager.awO();
      AppMethodBeat.o(105419);
      return paramString;
    }
    return localObject3;
  }
  
  public final v zs(String paramString)
  {
    AppMethodBeat.i(105422);
    String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
    Object localObject2;
    try
    {
      String str1 = LuggageLocalFileObjectManager.bD(str2, LuggageLocalFileObjectManager.a(this.hai));
      if (bo.isNullOrNil(str1))
      {
        AppMethodBeat.o(105422);
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
        localObject1 = null;
      }
      localObject1 = ((String)localObject1).split("\\|");
      if ((localObject1 == null) || (localObject1.length != 2))
      {
        AppMethodBeat.o(105422);
        return null;
      }
      localObject1 = localObject1[1];
      localObject2 = new StringBuilder().append(LuggageLocalFileObjectManager.c(this.hai)).append(paramString);
      if (!bo.isNullOrNil((String)localObject1)) {}
    }
    for (Object localObject1 = "";; localObject1 = ".".concat(String.valueOf(localObject1)))
    {
      localObject2 = (String)localObject1;
      localObject1 = new v();
      ((v)localObject1).ctV = ((String)localObject2);
      ((v)localObject1).fod = (LuggageLocalFileObjectManager.b(this.hai) + paramString);
      ((v)localObject1).elt = str2;
      ((v)localObject1).gZm = paramString.startsWith("store_");
      paramString = new File(((v)localObject1).fod);
      ((v)localObject1).gZn = paramString.lastModified();
      ((v)localObject1).gmb = paramString.length();
      AppMethodBeat.o(105422);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.b
 * JD-Core Version:    0.7.0.1
 */