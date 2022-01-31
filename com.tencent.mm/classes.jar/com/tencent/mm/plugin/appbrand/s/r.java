package com.tencent.mm.plugin.appbrand.s;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public final class r
{
  public static String F(Map<String, String> paramMap)
  {
    AppMethodBeat.i(93784);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("file://");
    localStringBuffer.append(aLw());
    localStringBuffer.append("/app.html?");
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuffer.append("&");
      localStringBuffer.append((String)localEntry.getKey());
      localStringBuffer.append("=");
      localStringBuffer.append((String)localEntry.getValue());
    }
    if (!paramMap.containsKey("sessionId"))
    {
      localStringBuffer.append("&");
      localStringBuffer.append("sessionId");
      localStringBuffer.append("=");
      localStringBuffer.append(com.tencent.mm.plugin.websearch.api.aa.IZ(bo.apV((String)paramMap.get("scene"))));
    }
    paramMap = localStringBuffer.toString();
    AppMethodBeat.o(93784);
    return paramMap;
  }
  
  /* Error */
  public static Properties J(File paramFile)
  {
    // Byte code:
    //   0: ldc 105
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 107	java/util/Properties
    //   8: dup
    //   9: invokespecial 108	java/util/Properties:<init>	()V
    //   12: astore_3
    //   13: aload_0
    //   14: ifnull +30 -> 44
    //   17: aload_0
    //   18: invokevirtual 113	java/io/File:isFile	()Z
    //   21: ifeq +23 -> 44
    //   24: new 115	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: aload_1
    //   34: astore_0
    //   35: aload_3
    //   36: aload_1
    //   37: invokevirtual 122	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   40: aload_1
    //   41: invokestatic 127	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   44: ldc 105
    //   46: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: aload_3
    //   50: areturn
    //   51: astore_2
    //   52: aconst_null
    //   53: astore_1
    //   54: aload_1
    //   55: astore_0
    //   56: ldc 129
    //   58: aload_2
    //   59: ldc 131
    //   61: iconst_0
    //   62: anewarray 4	java/lang/Object
    //   65: invokestatic 137	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: aload_1
    //   69: invokestatic 127	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   72: goto -28 -> 44
    //   75: astore_1
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: invokestatic 127	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   82: ldc 105
    //   84: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_1
    //   88: athrow
    //   89: astore_1
    //   90: goto -12 -> 78
    //   93: astore_2
    //   94: goto -40 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramFile	File
    //   32	37	1	localFileInputStream	java.io.FileInputStream
    //   75	13	1	localObject1	Object
    //   89	1	1	localObject2	Object
    //   51	8	2	localException1	java.lang.Exception
    //   93	1	2	localException2	java.lang.Exception
    //   12	38	3	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   24	33	51	java/lang/Exception
    //   24	33	75	finally
    //   35	40	89	finally
    //   56	68	89	finally
    //   35	40	93	java/lang/Exception
  }
  
  public static Map<String, String> a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    AppMethodBeat.i(93786);
    HashMap localHashMap = new HashMap();
    localHashMap.put("scene", String.valueOf(paramInt1));
    localHashMap.put("type", String.valueOf(paramInt2));
    localHashMap.put("lang", com.tencent.mm.sdk.platformtools.aa.gP(ah.getContext()));
    localHashMap.put("platform", "android");
    localHashMap.put("version", String.valueOf(aLx()));
    String str;
    if (paramBoolean)
    {
      str = "1";
      localHashMap.put("isHomePage", str);
      localHashMap.put("netType", com.tencent.mm.plugin.websearch.api.aa.bXn());
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put("extParams", paramString);
      }
      paramString = com.tencent.mm.model.c.c.abU().me("100192");
      if ((!paramString.isValid()) || (!"1".equals(paramString.dvN().get("openSearchSuggestion")))) {
        break label247;
      }
    }
    label247:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.WxaFTSExportLogic", "genFTSParams scene = %d, isHomePage = %b, type = %d, isSug = %b", new Object[] { Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (bool) {
        localHashMap.put("isSug", "1");
      }
      AppMethodBeat.o(93786);
      return localHashMap;
      str = "0";
      break;
    }
  }
  
  public static String aLw()
  {
    AppMethodBeat.i(93781);
    Object localObject = new File(agk(), "wxa_fts/res");
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = ((File)localObject).getAbsolutePath();
    AppMethodBeat.o(93781);
    return localObject;
  }
  
  public static int aLx()
  {
    AppMethodBeat.i(93783);
    int i = Integer.valueOf(J(new File(aLw(), "config.conf")).getProperty("version", "0")).intValue();
    AppMethodBeat.o(93783);
    return i;
  }
  
  public static final boolean aNU()
  {
    AppMethodBeat.i(93787);
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100223");
    if (localc.isValid())
    {
      if (bo.getInt((String)localc.dvN().get("switchWeAppTemplate"), 0) == 1)
      {
        AppMethodBeat.o(93787);
        return true;
      }
      AppMethodBeat.o(93787);
      return false;
    }
    AppMethodBeat.o(93787);
    return false;
  }
  
  public static final boolean aNV()
  {
    AppMethodBeat.i(93788);
    Object localObject = com.tencent.mm.model.c.c.abU().me("100435");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).dvN();
      if ((bo.getInt((String)((Map)localObject).get("forceClose"), 0) == 0) && (bo.getInt((String)((Map)localObject).get("open"), 0) == 1))
      {
        AppMethodBeat.o(93788);
        return true;
      }
      AppMethodBeat.o(93788);
      return false;
    }
    AppMethodBeat.o(93788);
    return false;
  }
  
  private static String agk()
  {
    AppMethodBeat.i(93780);
    String str = e.eQw.replace("/data/user/0", "/data/data");
    AppMethodBeat.o(93780);
    return str;
  }
  
  public static Map<String, String> d(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(93785);
    Map localMap = a(paramInt1, paramBoolean, paramInt2, "");
    AppMethodBeat.o(93785);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.r
 * JD-Core Version:    0.7.0.1
 */