package com.tencent.mm.plugin.appbrand.appstorage;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

@Deprecated
public final class AppBrandLocalMediaObjectManager
{
  private static String mYa;
  private static final Collection<a> mYb;
  private static final AppBrandLocalMediaObject mYc;
  
  static
  {
    AppMethodBeat.i(134321);
    Object localObject2 = b.asj();
    Object localObject1 = localObject2;
    if (!((String)localObject2).endsWith("/")) {
      localObject1 = (String)localObject2 + "/";
    }
    mYa = (String)localObject1 + "wxafiles/";
    localObject2 = k.W(ak.getContext().getExternalCacheDir());
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = k.W(ak.getContext().getCacheDir());
    }
    CW(w.B(((k)localObject1).fTh()));
    localObject1 = new LinkedList();
    ((Collection)localObject1).add(new b((byte)0));
    mYb = Collections.unmodifiableCollection((Collection)localObject1);
    mYc = new AppBrandLocalMediaObjectManager.3();
    AppMethodBeat.o(134321);
  }
  
  public static void CW(String paramString)
  {
    AppMethodBeat.i(175562);
    String str = paramString;
    if (!paramString.endsWith("/")) {
      str = paramString + "/";
    }
    mYa = str + "wxafiles/";
    AppMethodBeat.o(175562);
  }
  
  public static long MF(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(134309);
    paramString = new k(MI(paramString));
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
  
  public static long MG(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(134310);
    paramString = new k(MI(paramString));
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
  
  private static String MH(String paramString)
  {
    AppMethodBeat.i(195066);
    paramString = mYa + paramString + "/";
    AppMethodBeat.o(195066);
    return paramString;
  }
  
  private static String MI(String paramString)
  {
    AppMethodBeat.i(134315);
    paramString = MH(paramString);
    n.aMy(paramString);
    try
    {
      new k(paramString, ".nomedia").createNewFile();
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
    if (bu.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(134312);
      return null;
    }
    if (!o.fB(paramString2))
    {
      AppMethodBeat.o(134312);
      return null;
    }
    Object localObject1 = org.apache.commons.a.d.getExtension(paramString2);
    Object localObject2;
    if (bu.isNullOrNil((String)localObject1))
    {
      Iterator localIterator = mYb.iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = ((a)localIterator.next()).A(paramString1, paramString2, paramString3);
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
      ae.e("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(134312);
      return null;
      paramString3 = (String)localObject1;
      break;
    }
    try
    {
      label167:
      localObject2 = (AppBrandLocalMediaObject)paramClass.newInstance();
      ((AppBrandLocalMediaObject)localObject2).dsN = ((String)((a)localObject1).get(0));
      ((AppBrandLocalMediaObject)localObject2).mimeType = com.tencent.mm.sdk.f.d.aTa(paramString3);
      ((AppBrandLocalMediaObject)localObject2).hLr = ((String)((a)localObject1).get(1));
      if (bu.isNullOrNil(((AppBrandLocalMediaObject)localObject2).hLr))
      {
        ae.e("MicroMsg.AppBrand.LocalMediaObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
        AppMethodBeat.o(134312);
        return null;
      }
      paramClass = paramString3;
      if (bu.isNullOrNil(paramString3)) {
        paramClass = "unknown";
      }
      ((AppBrandLocalMediaObject)localObject2).fXl = bu.bI((String)((a)localObject1).get(3), paramClass);
      paramClass = ((AppBrandLocalMediaObject)localObject2).hLr;
      if ((paramBoolean) && (o.mG(paramString2, paramClass))) {
        i = 1;
      }
      while (i != 0)
      {
        paramString2 = new k(((AppBrandLocalMediaObject)localObject2).hLr);
        ((AppBrandLocalMediaObject)localObject2).iTe = paramString2.length();
        ((AppBrandLocalMediaObject)localObject2).jPt = paramString2.lastModified();
        paramClass = (r)e.L(r.class);
        if (paramClass != null) {
          paramClass.b(paramString1, paramString2);
        }
        AppMethodBeat.o(134312);
        return localObject2;
        if (!paramBoolean)
        {
          long l = o.mF(paramString2, paramClass);
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
      ae.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager", paramString1, "", new Object[0]);
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
  
  public static String bbX()
  {
    return mYa;
  }
  
  public static AppBrandLocalVideoObject cl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134311);
    paramString1 = (AppBrandLocalVideoObject)a(paramString1, paramString2, AppBrandLocalVideoObject.class, "mp4", false);
    AppMethodBeat.o(134311);
    return paramString1;
  }
  
  public static void clear(String paramString)
  {
    AppMethodBeat.i(195065);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(195065);
      return;
    }
    o.dd(MH(paramString), true);
    AppMethodBeat.o(195065);
  }
  
  @Deprecated
  public static AppBrandLocalMediaObject cm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(134316);
    if ((bu.isNullOrNil(paramString2)) || (!paramString2.startsWith("wxfile://")) || (bu.isNullOrNil(paramString1)))
    {
      ae.e("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, invalid args, localId(%s), appId(%s) ", new Object[] { paramString2, paramString1 });
      AppMethodBeat.o(134316);
      return null;
    }
    String str = paramString2.substring(9);
    Iterator localIterator = mYb.iterator();
    paramString2 = null;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      paramString2 = locala.cp(paramString1, str);
      if (paramString2 != null) {
        ae.i("MicroMsg.AppBrand.LocalMediaObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString2 });
      }
    }
    for (;;)
    {
      if (mYc == paramString2)
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
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(134308);
      return null;
    }
    paramString1 = MI(paramString1) + paramString2;
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
    public abstract a A(String paramString1, String paramString2, String paramString3);
    
    public abstract AppBrandLocalMediaObject cp(String paramString1, String paramString2);
  }
  
  static final class b
    implements AppBrandLocalMediaObjectManager.a
  {
    /* Error */
    public final a A(String paramString1, String paramString2, String paramString3)
    {
      // Byte code:
      //   0: ldc 21
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_3
      //   6: astore 6
      //   8: aload_3
      //   9: invokestatic 33	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifeq +8 -> 20
      //   15: invokestatic 37	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:bbZ	()Ljava/lang/String;
      //   18: astore 6
      //   20: aload_2
      //   21: invokestatic 41	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:MJ	(Ljava/lang/String;)J
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
      //   54: invokestatic 65	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:co	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   57: astore_2
      //   58: aload_2
      //   59: invokestatic 33	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
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
      //   84: invokestatic 75	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   87: aastore
      //   88: invokestatic 81	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   91: ldc 21
      //   93: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   96: aconst_null
      //   97: areturn
      //   98: astore_2
      //   99: ldc 70
      //   101: aload_2
      //   102: ldc 83
      //   104: iconst_0
      //   105: anewarray 4	java/lang/Object
      //   108: invokestatic 87	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   111: aconst_null
      //   112: astore_2
      //   113: goto -55 -> 58
      //   116: ldc 89
      //   118: aload_2
      //   119: invokestatic 92	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   122: invokevirtual 96	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   125: astore_3
      //   126: new 98	java/lang/StringBuilder
      //   129: dup
      //   130: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   133: aload_1
      //   134: invokestatic 102	com/tencent/mm/plugin/appbrand/appstorage/AppBrandLocalMediaObjectManager:access$300	(Ljava/lang/String;)Ljava/lang/String;
      //   137: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   140: aload_3
      //   141: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   144: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   147: astore_2
      //   148: new 98	java/lang/StringBuilder
      //   151: dup
      //   152: ldc 111
      //   154: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   157: aload_3
      //   158: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   161: astore_3
      //   162: aload 6
      //   164: invokestatic 33	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
      //   167: ifeq +49 -> 216
      //   170: ldc 116
      //   172: astore_1
      //   173: aload_3
      //   174: aload_1
      //   175: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   181: astore_1
      //   182: ldc 70
      //   184: ldc 118
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
      //   198: invokestatic 121	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   201: aload_1
      //   202: aload_2
      //   203: aload 6
      //   205: invokestatic 126	com/tencent/mm/vending/j/a:i	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
      //   208: astore_1
      //   209: ldc 21
      //   211: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   214: aload_1
      //   215: areturn
      //   216: ldc 128
      //   218: aload 6
      //   220: invokestatic 92	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   223: invokevirtual 96	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
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
    
    public final AppBrandLocalMediaObject cp(String paramString1, String paramString2)
    {
      Object localObject1 = null;
      AppMethodBeat.i(134306);
      if ((!paramString2.startsWith("store_")) && (!paramString2.startsWith("tmp_")))
      {
        AppMethodBeat.o(134306);
        return null;
      }
      String str3 = org.apache.commons.a.d.getExtension(paramString2);
      String str2 = paramString2.replaceFirst("store_", "").replaceFirst("tmp_", "");
      String str1 = str2;
      if (!bu.isNullOrNil(str3)) {
        str1 = str2.replaceFirst(".".concat(String.valueOf(str3)), "");
      }
      if (bu.isNullOrNil(str1))
      {
        paramString1 = AppBrandLocalMediaObjectManager.bbY();
        AppMethodBeat.o(134306);
        return paramString1;
      }
      try
      {
        str2 = AppBrandLocalMediaObjectManager.cn(str1, paramString1);
        localObject1 = str2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObject, decrypt exp ", new Object[0]);
        }
        Object localObject2 = ((String)localObject1).split("\\|");
        if ((localObject2 != null) && (localObject2.length == 2)) {
          break label194;
        }
        paramString1 = AppBrandLocalMediaObjectManager.bbY();
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
          l1 = bu.getLong(localObject2[0], 0L);
          localObject2 = localObject2[1];
          if (((String)localObject2).equalsIgnoreCase(str3)) {
            break;
          }
          paramString1 = AppBrandLocalMediaObjectManager.bbY();
          AppMethodBeat.o(134306);
          return paramString1;
        }
        try
        {
          long l2 = AppBrandLocalMediaObjectManager.MJ(str1);
          if (l1 != l2)
          {
            ae.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString2, paramString1 });
            paramString1 = AppBrandLocalMediaObjectManager.bbY();
            AppMethodBeat.o(134306);
            return paramString1;
          }
        }
        catch (IOException paramString1)
        {
          ae.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { bu.o(paramString1) });
          paramString1 = AppBrandLocalMediaObjectManager.bbY();
          AppMethodBeat.o(134306);
          return paramString1;
        }
        paramString1 = new AppBrandLocalMediaObject();
        paramString1.dsN = "wxfile://".concat(String.valueOf(paramString2));
        paramString1.hLr = str1;
        paramString1.mimeType = com.tencent.mm.sdk.f.d.aTa((String)localObject2);
        paramString1.jPs = ((String)localObject1).equalsIgnoreCase("store_");
        paramString2 = new k(paramString1.hLr);
        paramString1.jPt = paramString2.lastModified();
        paramString1.iTe = paramString2.length();
        AppMethodBeat.o(134306);
      }
      if (bu.isNullOrNil((String)localObject1))
      {
        ae.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
        paramString1 = AppBrandLocalMediaObjectManager.bbY();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager
 * JD-Core Version:    0.7.0.1
 */