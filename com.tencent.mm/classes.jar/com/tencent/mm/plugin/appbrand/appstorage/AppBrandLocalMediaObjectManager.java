package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.a.d;

@Deprecated
public final class AppBrandLocalMediaObjectManager
{
  private static final Collection<a> oIt;
  private static final AppBrandLocalMediaObject oIu;
  private static String osB;
  
  static
  {
    AppMethodBeat.i(134321);
    Object localObject2 = b.aKJ();
    Object localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/")) {
      localObject1 = (String)localObject2 + "/";
    }
    osB = (String)localObject1 + "wxafiles/";
    localObject2 = o.X(MMApplicationContext.getContext().getExternalCacheDir());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = o.X(MMApplicationContext.getContext().getCacheDir());
    }
    LH(aa.z(((o)localObject1).her()));
    localObject1 = new LinkedList();
    ((Collection)localObject1).add(new b((byte)0));
    oIt = Collections.unmodifiableCollection((Collection)localObject1);
    oIu = new AppBrandLocalMediaObject()
    {
      public final String toString()
      {
        return "AppBrandLocalMediaObject::Nil";
      }
    };
    AppMethodBeat.o(134321);
  }
  
  public static void LH(String paramString)
  {
    AppMethodBeat.i(175562);
    String str = paramString;
    if (!paramString.endsWith("/")) {
      str = paramString + "/";
    }
    osB = str + "wxafiles/";
    AppMethodBeat.o(175562);
  }
  
  public static AppBrandLocalVideoObject O(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134311);
    paramString1 = (AppBrandLocalVideoObject)a(paramString1, paramString2, AppBrandLocalVideoObject.class, "mp4", false);
    AppMethodBeat.o(134311);
    return paramString1;
  }
  
  private static String VQ(String paramString)
  {
    AppMethodBeat.i(196155);
    paramString = osB + paramString + "/";
    AppMethodBeat.o(196155);
    return paramString;
  }
  
  private static String VR(String paramString)
  {
    AppMethodBeat.i(134315);
    paramString = VQ(paramString);
    FilePathGenerator.checkMkdir(paramString);
    try
    {
      new o(paramString, ".nomedia").createNewFile();
      label29:
      AppMethodBeat.o(134315);
      return paramString;
    }
    catch (Exception localException)
    {
      break label29;
    }
  }
  
  private static <T extends AppBrandLocalMediaObject> T a(String paramString1, String paramString2, Class<T> paramClass, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(134312);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(134312);
      return null;
    }
    if (!s.YS(paramString2))
    {
      AppMethodBeat.o(134312);
      return null;
    }
    Object localObject1 = d.getExtension(paramString2);
    Object localObject2;
    if (Util.isNullOrNil((String)localObject1))
    {
      Iterator localIterator = oIt.iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = ((a)localIterator.next()).C(paramString1, paramString2, paramString3);
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
      }
      if ((localObject1 != null) && (((a)localObject1).size() >= 2)) {
        break label167;
      }
      if (localObject1 != null) {
        break label157;
      }
    }
    label157:
    for (int i = -1;; i = ((a)localObject1).size())
    {
      Log.e("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(134312);
      return null;
      paramString3 = (String)localObject1;
      break;
    }
    try
    {
      label167:
      localObject2 = (AppBrandLocalMediaObject)paramClass.newInstance();
      ((AppBrandLocalMediaObject)localObject2).dJX = ((String)((a)localObject1).get(0));
      ((AppBrandLocalMediaObject)localObject2).mimeType = MimeTypeUtil.getMimeTypeByFileExt(paramString3);
      ((AppBrandLocalMediaObject)localObject2).iGf = ((String)((a)localObject1).get(1));
      if (Util.isNullOrNil(((AppBrandLocalMediaObject)localObject2).iGf))
      {
        Log.e("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
        AppMethodBeat.o(134312);
        return null;
      }
      paramClass = paramString3;
      if (Util.isNullOrNil(paramString3)) {
        paramClass = "unknown";
      }
      ((AppBrandLocalMediaObject)localObject2).gCr = Util.nullAs((String)((a)localObject1).get(3), paramClass);
      paramClass = ((AppBrandLocalMediaObject)localObject2).iGf;
      if ((paramBoolean) && (s.nx(paramString2, paramClass))) {
        i = 1;
      }
      while (i != 0)
      {
        paramString2 = new o(((AppBrandLocalMediaObject)localObject2).iGf);
        ((AppBrandLocalMediaObject)localObject2).jPY = paramString2.length();
        ((AppBrandLocalMediaObject)localObject2).kSb = paramString2.lastModified();
        paramClass = (r)e.N(r.class);
        if (paramClass != null) {
          paramClass.b(paramString1, paramString2);
        }
        AppMethodBeat.o(134312);
        return localObject2;
        if (!paramBoolean)
        {
          long l = s.nw(paramString2, paramClass);
          if (l >= 0L)
          {
            i = 1;
            continue;
          }
        }
        i = 0;
      }
      return null;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager", paramString1, "", new Object[0]);
      AppMethodBeat.o(134312);
    }
  }
  
  public static AppBrandLocalMediaObject b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(134314);
    paramString1 = a(paramString1, paramString2, AppBrandLocalMediaObject.class, paramString3, paramBoolean);
    AppMethodBeat.o(134314);
    return paramString1;
  }
  
  public static long bwX(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(134309);
    paramString = new o(VR(paramString));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {}
    for (paramString = null; (paramString == null) || (paramString.length <= 0); paramString = paramString.a(new AppBrandLocalMediaObjectManager.2()))
    {
      AppMethodBeat.o(134309);
      return 0L;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      l += paramString[i].length();
      i += 1;
    }
    AppMethodBeat.o(134309);
    return l;
  }
  
  public static long bwY(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(134310);
    paramString = new o(VR(paramString));
    if ((!paramString.exists()) || (!paramString.isDirectory())) {}
    for (paramString = null; (paramString == null) || (paramString.length <= 0); paramString = paramString.a(new AppBrandLocalMediaObjectManager.1()))
    {
      AppMethodBeat.o(134310);
      return 0L;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      l += paramString[i].length();
      i += 1;
    }
    AppMethodBeat.o(134310);
    return l;
  }
  
  public static String bxo()
  {
    return osB;
  }
  
  public static void clear(String paramString)
  {
    AppMethodBeat.i(196154);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(196154);
      return;
    }
    s.dy(VQ(paramString), true);
    AppMethodBeat.o(196154);
  }
  
  @Deprecated
  public static AppBrandLocalMediaObject cz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134316);
    if ((Util.isNullOrNil(paramString2)) || (!paramString2.startsWith("wxfile://")) || (Util.isNullOrNil(paramString1)))
    {
      Log.e("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, invalid args, localId(%s), appId(%s) ", new Object[] { paramString2, paramString1 });
      AppMethodBeat.o(134316);
      return null;
    }
    String str = paramString2.substring(9);
    Iterator localIterator = oIt.iterator();
    paramString2 = null;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      paramString2 = locala.cD(paramString1, str);
      if (paramString2 != null) {
        Log.i("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString2 });
      }
    }
    for (;;)
    {
      if (oIu == paramString2)
      {
        AppMethodBeat.o(134316);
        return null;
        break;
      }
      AppMethodBeat.o(134316);
      return paramString2;
    }
  }
  
  @Keep
  public static String genMediaFilePath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134308);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(134308);
      return null;
    }
    paramString1 = VR(paramString1) + paramString2;
    AppMethodBeat.o(134308);
    return paramString1;
  }
  
  public static AppBrandLocalMediaObject h(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134313);
    paramString1 = b(paramString1, paramString2, null, paramBoolean);
    AppMethodBeat.o(134313);
    return paramString1;
  }
  
  static abstract interface a
  {
    public abstract a C(String paramString1, String paramString2, String paramString3);
    
    public abstract AppBrandLocalMediaObject cD(String paramString1, String paramString2);
  }
  
  static final class b
    implements AppBrandLocalMediaObjectManager.a
  {
    /* Error */
    public final a C(String paramString1, String paramString2, String paramString3)
    {
      // Byte code:
      //   0: ldc 21
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_3
      //   6: astore 6
      //   8: aload_3
      //   9: invokestatic 33	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifeq +8 -> 20
      //   15: invokestatic 37	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:access$500	()Ljava/lang/String;
      //   18: astore 6
      //   20: aload_2
      //   21: invokestatic 41	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:bwZ	(Ljava/lang/String;)J
      //   24: lstore 4
      //   26: getstatic 47	java/util/Locale:US	Ljava/util/Locale;
      //   29: ldc 49
      //   31: iconst_2
      //   32: anewarray 4	java/lang/Object
      //   35: dup
      //   36: iconst_0
      //   37: lload 4
      //   39: invokestatic 55	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   42: aastore
      //   43: dup
      //   44: iconst_1
      //   45: aload 6
      //   47: aastore
      //   48: invokestatic 61	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   51: astore_2
      //   52: aload_2
      //   53: aload_1
      //   54: invokestatic 65	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:cA	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   57: astore_2
      //   58: aload_2
      //   59: invokestatic 33	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   62: ifeq +54 -> 116
      //   65: ldc 21
      //   67: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   70: aconst_null
      //   71: areturn
      //   72: astore_1
      //   73: ldc 70
      //   75: ldc 72
      //   77: iconst_1
      //   78: anewarray 4	java/lang/Object
      //   81: dup
      //   82: iconst_0
      //   83: aload_1
      //   84: invokestatic 76	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   87: aastore
      //   88: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   91: ldc 21
      //   93: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: aconst_null
      //   97: areturn
      //   98: astore_2
      //   99: ldc 70
      //   101: aload_2
      //   102: ldc 84
      //   104: iconst_0
      //   105: anewarray 4	java/lang/Object
      //   108: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   111: aconst_null
      //   112: astore_2
      //   113: goto -55 -> 58
      //   116: ldc 90
      //   118: aload_2
      //   119: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   122: invokevirtual 97	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   125: astore_3
      //   126: new 99	java/lang/StringBuilder
      //   129: dup
      //   130: invokespecial 100	java/lang/StringBuilder:<init>	()V
      //   133: aload_1
      //   134: invokestatic 103	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:access$300	(Ljava/lang/String;)Ljava/lang/String;
      //   137: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   140: aload_3
      //   141: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   144: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   147: astore_2
      //   148: new 99	java/lang/StringBuilder
      //   151: dup
      //   152: ldc 112
      //   154: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   157: aload_3
      //   158: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   161: astore_3
      //   162: aload 6
      //   164: invokestatic 33	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   167: ifeq +49 -> 216
      //   170: ldc 117
      //   172: astore_1
      //   173: aload_3
      //   174: aload_1
      //   175: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   181: astore_1
      //   182: ldc 70
      //   184: ldc 119
      //   186: iconst_2
      //   187: anewarray 4	java/lang/Object
      //   190: dup
      //   191: iconst_0
      //   192: aload_1
      //   193: aastore
      //   194: dup
      //   195: iconst_1
      //   196: aload_2
      //   197: aastore
      //   198: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   201: aload_1
      //   202: aload_2
      //   203: aload 6
      //   205: invokestatic 127	com/tencent/mm/vending/j/a:i	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
      //   208: astore_1
      //   209: ldc 21
      //   211: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   214: aload_1
      //   215: areturn
      //   216: ldc 129
      //   218: aload 6
      //   220: invokestatic 93	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   223: invokevirtual 97	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   226: astore_1
      //   227: goto -54 -> 173
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	230	0	this	b
      //   0	230	1	paramString1	String
      //   0	230	2	paramString2	String
      //   0	230	3	paramString3	String
      //   24	14	4	l	long
      //   6	213	6	str	String
      // Exception table:
      //   from	to	target	type
      //   20	26	72	java/lang/Exception
      //   52	58	98	java/lang/Exception
    }
    
    public final AppBrandLocalMediaObject cD(String paramString1, String paramString2)
    {
      Object localObject1 = null;
      AppMethodBeat.i(134306);
      if ((!paramString2.startsWith("store_")) && (!paramString2.startsWith("tmp_")))
      {
        AppMethodBeat.o(134306);
        return null;
      }
      String str3 = d.getExtension(paramString2);
      String str2 = paramString2.replaceFirst("store_", "").replaceFirst("tmp_", "");
      String str1 = str2;
      if (!Util.isNullOrNil(str3)) {
        str1 = str2.replaceFirst(".".concat(String.valueOf(str3)), "");
      }
      if (Util.isNullOrNil(str1))
      {
        paramString1 = AppBrandLocalMediaObjectManager.caa();
        AppMethodBeat.o(134306);
        return paramString1;
      }
      try
      {
        str2 = AppBrandLocalMediaObjectManager.cB(str1, paramString1);
        localObject1 = str2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObject, decrypt exp ", new Object[0]);
        }
        Object localObject2 = ((String)localObject1).split("\\|");
        if ((localObject2 != null) && (localObject2.length == 2)) {
          break label194;
        }
        paramString1 = AppBrandLocalMediaObjectManager.caa();
        AppMethodBeat.o(134306);
        return paramString1;
        label194:
        if (!paramString2.startsWith("store_")) {
          break label272;
        }
        long l1;
        label272:
        for (localObject1 = "store_";; localObject1 = "tmp_")
        {
          str1 = AppBrandLocalMediaObjectManager.access$300(paramString1) + (String)localObject1 + str1;
          l1 = Util.getLong(localObject2[0], 0L);
          localObject2 = localObject2[1];
          if (((String)localObject2).equalsIgnoreCase(str3)) {
            break;
          }
          paramString1 = AppBrandLocalMediaObjectManager.caa();
          AppMethodBeat.o(134306);
          return paramString1;
        }
        try
        {
          long l2 = AppBrandLocalMediaObjectManager.bwZ(str1);
          if (l1 != l2)
          {
            Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString2, paramString1 });
            paramString1 = AppBrandLocalMediaObjectManager.caa();
            AppMethodBeat.o(134306);
            return paramString1;
          }
        }
        catch (IOException paramString1)
        {
          Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { Util.stackTraceToString(paramString1) });
          paramString1 = AppBrandLocalMediaObjectManager.caa();
          AppMethodBeat.o(134306);
          return paramString1;
        }
        paramString1 = new AppBrandLocalMediaObject();
        paramString1.dJX = "wxfile://".concat(String.valueOf(paramString2));
        paramString1.iGf = str1;
        paramString1.mimeType = MimeTypeUtil.getMimeTypeByFileExt((String)localObject2);
        paramString1.kSa = ((String)localObject1).equalsIgnoreCase("store_");
        paramString2 = new o(paramString1.iGf);
        paramString1.kSb = paramString2.lastModified();
        paramString1.jPY = paramString2.length();
        AppMethodBeat.o(134306);
      }
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
        paramString1 = AppBrandLocalMediaObjectManager.caa();
        AppMethodBeat.o(134306);
        return paramString1;
      }
      return paramString1;
    }
    
    public final String toString()
    {
      return "V2MediaObjectInfoHandler";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager
 * JD-Core Version:    0.7.0.1
 */