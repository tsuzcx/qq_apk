package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.v.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.IOException;
import org.a.a.a.a;

final class LuggageLocalFileObjectManager$c
  implements LuggageLocalFileObjectManager.a
{
  private LuggageLocalFileObjectManager$c(LuggageLocalFileObjectManager paramLuggageLocalFileObjectManager) {}
  
  /* Error */
  public final com.tencent.mm.vending.j.a be(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 28
    //   3: invokestatic 34	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aload_0
    //   8: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$c:fHp	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
    //   11: aload_1
    //   12: invokestatic 38	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:access$600	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;Ljava/lang/String;)J
    //   15: lstore_3
    //   16: getstatic 44	java/util/Locale:US	Ljava/util/Locale;
    //   19: ldc 46
    //   21: iconst_2
    //   22: anewarray 4	java/lang/Object
    //   25: dup
    //   26: iconst_0
    //   27: lload_3
    //   28: invokestatic 52	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: aload_2
    //   35: aastore
    //   36: invokestatic 58	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$c:fHp	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
    //   44: aload_1
    //   45: aload_0
    //   46: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$c:fHp	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
    //   49: invokestatic 62	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:access$300	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
    //   52: invokestatic 66	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:access$800	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_1
    //   56: aload_1
    //   57: invokestatic 70	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   60: ifeq +44 -> 104
    //   63: aconst_null
    //   64: areturn
    //   65: astore_1
    //   66: ldc 72
    //   68: ldc 74
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_1
    //   77: invokestatic 78	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   80: aastore
    //   81: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_1
    //   87: ldc 72
    //   89: aload_1
    //   90: ldc 86
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 90	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aconst_null
    //   100: astore_1
    //   101: goto -45 -> 56
    //   104: new 92	java/lang/StringBuilder
    //   107: dup
    //   108: ldc 94
    //   110: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   113: aload_1
    //   114: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore_1
    //   121: new 92	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   128: aload_0
    //   129: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$c:fHp	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
    //   132: invokestatic 109	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:access$500	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
    //   135: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_1
    //   139: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 5
    //   147: new 92	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   154: aload_0
    //   155: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$c:fHp	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
    //   158: invokestatic 112	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:access$700	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
    //   161: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: astore 6
    //   170: aload_2
    //   171: invokestatic 70	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   174: ifeq +44 -> 218
    //   177: ldc 114
    //   179: astore_1
    //   180: aload 6
    //   182: aload_1
    //   183: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: astore_1
    //   190: ldc 72
    //   192: ldc 116
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
    //   207: invokestatic 119	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload_1
    //   211: aload 5
    //   213: aload_2
    //   214: invokestatic 124	com/tencent/mm/vending/j/a:d	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
    //   217: areturn
    //   218: new 92	java/lang/StringBuilder
    //   221: dup
    //   222: ldc 126
    //   224: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: aload_2
    //   228: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: astore_1
    //   235: goto -55 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	c
    //   0	238	1	paramString1	String
    //   0	238	2	paramString2	String
    //   15	13	3	l	long
    //   145	67	5	str	String
    //   168	13	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   7	16	65	java/lang/Exception
    //   40	56	86	java/lang/Exception
  }
  
  public final o markPermanent(o paramo)
  {
    if (paramo == null) {}
    String str;
    do
    {
      return null;
      str = paramo.dXY.replaceFirst("tmp_", "store_");
    } while (!g.bd(paramo.dXY, str));
    o localo = new o();
    localo.dXY = str;
    localo.bMB = paramo.bMB.replaceFirst("tmp_", "store_");
    localo.eUd = paramo.eUd;
    localo.fGv = paramo.fGv;
    localo.fGx = new File(localo.dXY).lastModified();
    localo.mimeType = paramo.mimeType;
    localo.fGw = true;
    return localo;
  }
  
  public final o rC(String paramString)
  {
    Object localObject1 = null;
    if ((!paramString.startsWith("store_")) && (!paramString.startsWith("tmp_"))) {
      return null;
    }
    Object localObject3 = a.aho(paramString);
    String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
    String str1 = str2;
    if (!bk.bl((String)localObject3)) {
      str1 = str2.replaceFirst("." + (String)localObject3, "");
    }
    if (bk.bl(str1)) {
      return LuggageLocalFileObjectManager.access$200();
    }
    try
    {
      str2 = LuggageLocalFileObjectManager.access$400(this.fHp, str1, LuggageLocalFileObjectManager.access$300(this.fHp));
      localObject1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObject, decrypt exp ", new Object[0]);
      }
      Object localObject2 = ((String)localObject1).split("\\|");
      if ((localObject2 != null) && (localObject2.length == 2)) {
        break label180;
      }
      return LuggageLocalFileObjectManager.access$200();
      label180:
      if (!paramString.startsWith("store_")) {
        break label254;
      }
      long l1;
      label254:
      for (localObject1 = "store_";; localObject1 = "tmp_")
      {
        str1 = LuggageLocalFileObjectManager.access$500(this.fHp) + (String)localObject1 + str1;
        l1 = bk.getLong(localObject2[0], 0L);
        localObject2 = localObject2[1];
        if (((String)localObject2).equalsIgnoreCase((String)localObject3)) {
          break;
        }
        return LuggageLocalFileObjectManager.access$200();
      }
      try
      {
        long l2 = LuggageLocalFileObjectManager.access$600(this.fHp, str1);
        if (l1 != l2)
        {
          y.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString });
          paramString = LuggageLocalFileObjectManager.access$200();
          return paramString;
        }
      }
      catch (IOException paramString)
      {
        y.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { bk.j(paramString) });
        return LuggageLocalFileObjectManager.access$200();
      }
      localObject3 = new o();
      ((o)localObject3).bMB = (LuggageLocalFileObjectManager.access$700(this.fHp) + paramString);
      ((o)localObject3).dXY = str1;
      ((o)localObject3).mimeType = m.wJ((String)localObject2);
      ((o)localObject3).fGw = ((String)localObject1).equalsIgnoreCase("store_");
      paramString = new File(((o)localObject3).dXY);
      ((o)localObject3).fGx = paramString.lastModified();
      ((o)localObject3).eUd = paramString.length();
    }
    if (bk.bl((String)localObject1))
    {
      y.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
      return LuggageLocalFileObjectManager.access$200();
    }
    return localObject3;
  }
  
  public final o rD(String paramString)
  {
    String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
    Object localObject2;
    try
    {
      String str1 = LuggageLocalFileObjectManager.access$400(this.fHp, str2, LuggageLocalFileObjectManager.access$300(this.fHp));
      if (bk.bl(str1)) {
        return null;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
          localObject1 = null;
        }
        localObject1 = ((String)localObject1).split("\\|");
      } while ((localObject1 == null) || (localObject1.length != 2));
      localObject1 = localObject1[1];
      localObject2 = new StringBuilder().append(LuggageLocalFileObjectManager.access$700(this.fHp)).append(paramString);
      if (!bk.bl((String)localObject1)) {}
    }
    for (Object localObject1 = "";; localObject1 = "." + (String)localObject1)
    {
      localObject2 = (String)localObject1;
      localObject1 = new o();
      ((o)localObject1).bMB = ((String)localObject2);
      ((o)localObject1).dXY = (LuggageLocalFileObjectManager.access$500(this.fHp) + paramString);
      ((o)localObject1).fGv = str2;
      ((o)localObject1).fGw = paramString.startsWith("store_");
      paramString = new File(((o)localObject1).dXY);
      ((o)localObject1).fGx = paramString.lastModified();
      ((o)localObject1).eUd = paramString.length();
      return localObject1;
    }
  }
  
  public final String toString()
  {
    return "V2MediaObjectInfoHandler";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager.c
 * JD-Core Version:    0.7.0.1
 */