package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.b.c;

@Deprecated
public final class AppBrandLocalMediaObjectManager
{
  private static final AppBrandLocalMediaObject uBB;
  private static String uBx;
  private static final Collection<a> uBz;
  
  static
  {
    AppMethodBeat.i(134321);
    Object localObject2 = b.bmz();
    Object localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/")) {
      localObject1 = (String)localObject2 + "/";
    }
    uBx = (String)localObject1 + "wxafiles/";
    localObject2 = u.V(MMApplicationContext.getContext().getExternalCacheDir());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = u.V(MMApplicationContext.getContext().getCacheDir());
    }
    Lb(ah.v(((u)localObject1).jKT()));
    localObject1 = new LinkedList();
    ((Collection)localObject1).add(new b((byte)0));
    uBz = Collections.unmodifiableCollection((Collection)localObject1);
    uBB = new AppBrandLocalMediaObject()
    {
      public String toString()
      {
        return "AppBrandLocalMediaObject::Nil";
      }
    };
    AppMethodBeat.o(134321);
  }
  
  public static void Lb(String paramString)
  {
    AppMethodBeat.i(175562);
    String str = paramString;
    if (!paramString.endsWith("/")) {
      str = paramString + "/";
    }
    uBx = str + "wxafiles/";
    AppMethodBeat.o(175562);
  }
  
  public static long Wa(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(134309);
    paramString = new u(Wd(paramString));
    if ((!paramString.jKS()) || (!paramString.isDirectory())) {}
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
  
  public static long Wb(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(134310);
    paramString = new u(Wd(paramString));
    if ((!paramString.jKS()) || (!paramString.isDirectory())) {}
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
  
  private static String Wc(String paramString)
  {
    AppMethodBeat.i(323259);
    paramString = uBx + paramString + "/";
    AppMethodBeat.o(323259);
    return paramString;
  }
  
  private static String Wd(String paramString)
  {
    AppMethodBeat.i(134315);
    paramString = Wc(paramString);
    FilePathGenerator.checkMkdir(paramString);
    try
    {
      new u(paramString, ".nomedia").jKZ();
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
    if (!y.ZC(paramString2))
    {
      AppMethodBeat.o(134312);
      return null;
    }
    Object localObject1 = c.bKZ(paramString2);
    Object localObject2;
    if (Util.isNullOrNil((String)localObject1))
    {
      Iterator localIterator = uBz.iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = ((a)localIterator.next()).G(paramString1, paramString2, paramString3);
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
      ((AppBrandLocalMediaObject)localObject2).hHB = ((String)((a)localObject1).get(0));
      ((AppBrandLocalMediaObject)localObject2).mimeType = MimeTypeUtil.getMimeTypeByFileExt(paramString3);
      ((AppBrandLocalMediaObject)localObject2).onG = ((String)((a)localObject1).get(1));
      if (Util.isNullOrNil(((AppBrandLocalMediaObject)localObject2).onG))
      {
        Log.e("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
        AppMethodBeat.o(134312);
        return null;
      }
      paramClass = paramString3;
      if (Util.isNullOrNil(paramString3)) {
        paramClass = "unknown";
      }
      ((AppBrandLocalMediaObject)localObject2).lPJ = Util.nullAs((String)((a)localObject1).get(3), paramClass);
      paramClass = ((AppBrandLocalMediaObject)localObject2).onG;
      if ((paramBoolean) && (y.qn(paramString2, paramClass))) {
        i = 1;
      }
      while (i != 0)
      {
        paramString2 = new u(((AppBrandLocalMediaObject)localObject2).onG);
        ((AppBrandLocalMediaObject)localObject2).fileLength = paramString2.length();
        ((AppBrandLocalMediaObject)localObject2).qMk = paramString2.lastModified();
        paramClass = (x)e.U(x.class);
        if (paramClass != null) {
          paramClass.b(paramString1, paramString2);
        }
        AppMethodBeat.o(134312);
        return localObject2;
        if (!paramBoolean)
        {
          long l = y.O(paramString2, paramClass, false);
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
  
  public static String cPU()
  {
    return uBx;
  }
  
  public static AppBrandLocalVideoObject cW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134311);
    paramString1 = (AppBrandLocalVideoObject)a(paramString1, paramString2, AppBrandLocalVideoObject.class, "mp4", false);
    AppMethodBeat.o(134311);
    return paramString1;
  }
  
  @Deprecated
  public static AppBrandLocalMediaObject cY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134316);
    if ((Util.isNullOrNil(paramString2)) || (!paramString2.startsWith("wxfile://")) || (Util.isNullOrNil(paramString1)))
    {
      Log.e("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, invalid args, localId(%s), appId(%s) ", new Object[] { paramString2, paramString1 });
      AppMethodBeat.o(134316);
      return null;
    }
    String str = paramString2.substring(9);
    Iterator localIterator = uBz.iterator();
    paramString2 = null;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      paramString2 = locala.cZ(paramString1, str);
      if (paramString2 != null) {
        Log.i("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString2 });
      }
    }
    for (;;)
    {
      if (uBB == paramString2)
      {
        AppMethodBeat.o(134316);
        return null;
        break;
      }
      AppMethodBeat.o(134316);
      return paramString2;
    }
  }
  
  public static void clear(String paramString)
  {
    AppMethodBeat.i(323236);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(323236);
      return;
    }
    y.ew(Wc(paramString), true);
    AppMethodBeat.o(323236);
  }
  
  public static String genMediaFilePath(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134308);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(134308);
      return null;
    }
    paramString1 = Wd(paramString1) + paramString2;
    AppMethodBeat.o(134308);
    return paramString1;
  }
  
  public static AppBrandLocalMediaObject m(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134313);
    paramString1 = b(paramString1, paramString2, null, paramBoolean);
    AppMethodBeat.o(134313);
    return paramString1;
  }
  
  static abstract interface a
  {
    public abstract a G(String paramString1, String paramString2, String paramString3);
    
    public abstract AppBrandLocalMediaObject cZ(String paramString1, String paramString2);
  }
  
  static final class b
    implements AppBrandLocalMediaObjectManager.a
  {
    /* Error */
    public final a G(String paramString1, String paramString2, String paramString3)
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
      //   21: invokestatic 41	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:We	(Ljava/lang/String;)J
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
      //   54: invokestatic 65	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:hL	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
      //   205: invokestatic 128	com/tencent/mm/vending/j/a:g	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
      //   208: astore_1
      //   209: ldc 21
      //   211: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   214: aload_1
      //   215: areturn
      //   216: ldc 130
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
    
    public final AppBrandLocalMediaObject cZ(String paramString1, String paramString2)
    {
      Object localObject1 = null;
      AppMethodBeat.i(134306);
      if ((!paramString2.startsWith("store_")) && (!paramString2.startsWith("tmp_")))
      {
        AppMethodBeat.o(134306);
        return null;
      }
      String str3 = c.bKZ(paramString2);
      String str2 = paramString2.replaceFirst("store_", "").replaceFirst("tmp_", "");
      String str1 = str2;
      if (!Util.isNullOrNil(str3)) {
        str1 = str2.replaceFirst(".".concat(String.valueOf(str3)), "");
      }
      if (Util.isNullOrNil(str1))
      {
        paramString1 = AppBrandLocalMediaObjectManager.cQG();
        AppMethodBeat.o(134306);
        return paramString1;
      }
      try
      {
        str2 = AppBrandLocalMediaObjectManager.cX(str1, paramString1);
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
        paramString1 = AppBrandLocalMediaObjectManager.cQG();
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
          paramString1 = AppBrandLocalMediaObjectManager.cQG();
          AppMethodBeat.o(134306);
          return paramString1;
        }
        try
        {
          long l2 = AppBrandLocalMediaObjectManager.We(str1);
          if (l1 != l2)
          {
            Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString2, paramString1 });
            paramString1 = AppBrandLocalMediaObjectManager.cQG();
            AppMethodBeat.o(134306);
            return paramString1;
          }
        }
        catch (IOException paramString1)
        {
          Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { Util.stackTraceToString(paramString1) });
          paramString1 = AppBrandLocalMediaObjectManager.cQG();
          AppMethodBeat.o(134306);
          return paramString1;
        }
        paramString1 = new AppBrandLocalMediaObject();
        paramString1.hHB = "wxfile://".concat(String.valueOf(paramString2));
        paramString1.onG = str1;
        paramString1.mimeType = MimeTypeUtil.getMimeTypeByFileExt((String)localObject2);
        paramString1.qMj = ((String)localObject1).equalsIgnoreCase("store_");
        paramString2 = new u(paramString1.onG);
        paramString1.qMk = paramString2.lastModified();
        paramString1.fileLength = paramString2.length();
        AppMethodBeat.o(134306);
      }
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
        paramString1 = AppBrandLocalMediaObjectManager.cQG();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager
 * JD-Core Version:    0.7.0.1
 */