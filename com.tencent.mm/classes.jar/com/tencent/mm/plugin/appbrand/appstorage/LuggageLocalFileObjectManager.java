package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.w;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.b.c;

public final class LuggageLocalFileObjectManager
{
  private static final ae qNt;
  public static final w qNy;
  private final String qMG;
  private final String qMH;
  private final String qMI;
  private final Collection<a> qNr;
  
  static
  {
    AppMethodBeat.i(134403);
    qNy = new w()
    {
      public final boolean accept(u paramAnonymousu)
      {
        AppMethodBeat.i(175588);
        boolean bool = LuggageLocalFileObjectManager.e(paramAnonymousu, "store_");
        AppMethodBeat.o(175588);
        return bool;
      }
    };
    qNt = new ae()
    {
      public final String toString()
      {
        return "AppBrandLocalMediaObject::Nil";
      }
    };
    AppMethodBeat.o(134403);
  }
  
  LuggageLocalFileObjectManager(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(134388);
    this.qMI = (ah.v(new u(paramString1).jKT()) + "/");
    this.qMG = paramString2;
    this.qMH = paramString3;
    paramString1 = new LinkedList();
    paramString1.add(new b((byte)0));
    this.qNr = Collections.unmodifiableCollection(paramString1);
    AppMethodBeat.o(134388);
  }
  
  private <T extends ae> T a(String paramString1, Class<T> paramClass, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134393);
    if (!y.ZC(paramString1))
    {
      AppMethodBeat.o(134393);
      return null;
    }
    Object localObject1 = c.bKZ(paramString1);
    Object localObject2;
    if (Util.isNullOrNil((String)localObject1))
    {
      Iterator localIterator = this.qNr.iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = ((a)localIterator.next()).dj(paramString1, paramString2);
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
      }
      if ((localObject1 != null) && (((a)localObject1).size() >= 2)) {
        break label153;
      }
      if (localObject1 != null) {
        break label143;
      }
    }
    label143:
    for (int i = -1;; i = ((a)localObject1).size())
    {
      Log.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(134393);
      return null;
      paramString2 = (String)localObject1;
      break;
    }
    try
    {
      label153:
      localObject2 = (ae)paramClass.newInstance();
      ((ae)localObject2).hHB = ((String)((a)localObject1).get(0));
      ((ae)localObject2).mimeType = MimeTypeUtil.getMimeTypeByFileExt(paramString2);
      ((ae)localObject2).onG = ((String)((a)localObject1).get(1));
      if (Util.isNullOrNil(((ae)localObject2).onG))
      {
        Log.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
        AppMethodBeat.o(134393);
        return null;
      }
      paramClass = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        paramClass = "unknown";
      }
      ((ae)localObject2).lPJ = Util.nullAs((String)((a)localObject1).get(3), paramClass);
      paramClass = ((ae)localObject2).onG;
      if ((paramBoolean) && (q.de(paramString1, paramClass))) {
        i = 1;
      }
      while (i != 0)
      {
        paramString1 = new u(((ae)localObject2).onG);
        ((ae)localObject2).fileLength = paramString1.length();
        ((ae)localObject2).qMk = paramString1.lastModified();
        AppMethodBeat.o(134393);
        return localObject2;
        if (!paramBoolean)
        {
          paramBoolean = FilesCopy.copyFile(paramString1, paramClass);
          if (paramBoolean)
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
      Log.printErrStackTrace("MicroMsg.AppBrand.LuggageLocalFileObjectManager", paramString1, "", new Object[0]);
      AppMethodBeat.o(134393);
    }
  }
  
  static boolean a(u paramu, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(323141);
    if (((!paramBoolean) || (paramu.jKS())) && (!paramu.isDirectory()) && (!Util.isNullOrNil(paramu.getName())) && (paramu.getName().startsWith(paramString)))
    {
      AppMethodBeat.o(323141);
      return true;
    }
    AppMethodBeat.o(323141);
    return false;
  }
  
  private u[] ciq()
  {
    AppMethodBeat.i(175590);
    Object localObject = new u(cin());
    if ((!((u)localObject).jKS()) || (!((u)localObject).isDirectory()))
    {
      AppMethodBeat.o(175590);
      return null;
    }
    localObject = ((u)localObject).a(new w()
    {
      public final boolean accept(u paramAnonymousu)
      {
        AppMethodBeat.i(175589);
        boolean bool = LuggageLocalFileObjectManager.this.c(paramAnonymousu, true);
        AppMethodBeat.o(175589);
        return bool;
      }
    });
    AppMethodBeat.o(175590);
    return localObject;
  }
  
  final ae WA(String paramString)
  {
    AppMethodBeat.i(134398);
    if ((Util.isNullOrNil(paramString)) || (!paramString.startsWith(this.qMH)))
    {
      Log.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", new Object[] { paramString });
      AppMethodBeat.o(134398);
      return null;
    }
    String str = paramString.substring(this.qMH.length());
    Iterator localIterator = this.qNr.iterator();
    paramString = null;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      paramString = locala.WC(str);
      if (paramString != null) {
        Log.i("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString });
      }
    }
    for (;;)
    {
      if (qNt == paramString)
      {
        AppMethodBeat.o(134398);
        return null;
        break;
      }
      AppMethodBeat.o(134398);
      return paramString;
    }
  }
  
  final ae Wz(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(134397);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134397);
      return null;
    }
    Iterator localIterator = this.qNr.iterator();
    while (localIterator.hasNext())
    {
      ae localae = ((a)localIterator.next()).WD(paramString);
      localObject = localae;
      if (localae != null) {
        localObject = localae;
      }
    }
    AppMethodBeat.o(134397);
    return localObject;
  }
  
  final ae a(ae paramae)
  {
    AppMethodBeat.i(134396);
    Object localObject = null;
    Iterator localIterator = this.qNr.iterator();
    while (localIterator.hasNext())
    {
      ae localae = ((a)localIterator.next()).a(paramae);
      localObject = localae;
      if (localae != null) {
        localObject = localae;
      }
    }
    AppMethodBeat.o(134396);
    return localObject;
  }
  
  public final boolean c(u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(323182);
    if ((new u(cin()).equals(new u(paramu.jKO()))) && (a(paramu, "store_", paramBoolean)))
    {
      AppMethodBeat.o(323182);
      return true;
    }
    AppMethodBeat.o(323182);
    return false;
  }
  
  final String cin()
  {
    AppMethodBeat.i(134395);
    FilePathGenerator.checkMkdir(this.qMI);
    try
    {
      new u(this.qMI, ".nomedia").jKZ();
      label32:
      String str = this.qMI;
      AppMethodBeat.o(134395);
      return str;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final List<ae> cip()
  {
    AppMethodBeat.i(134390);
    u[] arrayOfu = ciq();
    if ((arrayOfu == null) || (arrayOfu.length <= 0))
    {
      AppMethodBeat.o(134390);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = arrayOfu.length;
    int i = 0;
    while (i < j)
    {
      ae localae = Wz(arrayOfu[i].getName());
      if (localae != null) {
        localLinkedList.add(localae);
      }
      i += 1;
    }
    AppMethodBeat.o(134390);
    return localLinkedList;
  }
  
  public final List<ae> cir()
  {
    AppMethodBeat.i(134392);
    Object localObject = new u(cin());
    if ((!((u)localObject).jKS()) || (!((u)localObject).isDirectory())) {}
    for (localObject = null; (localObject == null) || (localObject.length <= 0); localObject = ((u)localObject).a(new w()
        {
          public final boolean accept(u paramAnonymousu)
          {
            AppMethodBeat.i(323196);
            if ((new u(LuggageLocalFileObjectManager.this.cin()).equals(new u(paramAnonymousu.jKO()))) && (LuggageLocalFileObjectManager.a(paramAnonymousu, "tmp_", true)))
            {
              AppMethodBeat.o(323196);
              return true;
            }
            AppMethodBeat.o(323196);
            return false;
          }
        }))
    {
      AppMethodBeat.o(134392);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      ae localae = Wz(localObject[i].getName());
      if (localae != null) {
        localLinkedList.add(localae);
      }
      i += 1;
    }
    AppMethodBeat.o(134392);
    return localLinkedList;
  }
  
  public final long cis()
  {
    long l = 0L;
    AppMethodBeat.i(323186);
    u[] arrayOfu = ciq();
    if ((arrayOfu == null) || (arrayOfu.length <= 0))
    {
      AppMethodBeat.o(323186);
      return 0L;
    }
    int j = arrayOfu.length;
    int i = 0;
    while (i < j)
    {
      l += arrayOfu[i].length();
      i += 1;
    }
    AppMethodBeat.o(323186);
    return l;
  }
  
  public final String genMediaFilePath(String paramString)
  {
    AppMethodBeat.i(134389);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134389);
      return null;
    }
    paramString = cin() + paramString;
    AppMethodBeat.o(134389);
    return paramString;
  }
  
  public final ae n(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134394);
    paramString1 = a(paramString1, ae.class, paramString2, paramBoolean);
    AppMethodBeat.o(134394);
    return paramString1;
  }
  
  static abstract interface a
  {
    public abstract ae WC(String paramString);
    
    public abstract ae WD(String paramString);
    
    public abstract ae a(ae paramae);
    
    public abstract a dj(String paramString1, String paramString2);
  }
  
  final class b
    implements LuggageLocalFileObjectManager.a
  {
    private b() {}
    
    public final ae WC(String paramString)
    {
      Object localObject1 = null;
      AppMethodBeat.i(134384);
      if ((!paramString.startsWith("store_")) && (!paramString.startsWith("tmp_")))
      {
        AppMethodBeat.o(134384);
        return null;
      }
      Object localObject3 = c.bKZ(paramString);
      String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
      String str1 = str2;
      if (!Util.isNullOrNil((String)localObject3)) {
        str1 = str2.replaceFirst("\\.".concat(String.valueOf(localObject3)), "");
      }
      if (Util.isNullOrNil(str1))
      {
        paramString = LuggageLocalFileObjectManager.cit();
        AppMethodBeat.o(134384);
        return paramString;
      }
      try
      {
        str2 = LuggageLocalFileObjectManager.dk(str1, LuggageLocalFileObjectManager.a(LuggageLocalFileObjectManager.this));
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
          break label200;
        }
        paramString = LuggageLocalFileObjectManager.cit();
        AppMethodBeat.o(134384);
        return paramString;
        label200:
        if (!paramString.startsWith("store_")) {
          break label281;
        }
        long l1;
        label281:
        for (localObject1 = "store_";; localObject1 = "tmp_")
        {
          str1 = LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + (String)localObject1 + str1;
          l1 = Util.getLong(localObject2[0], 0L);
          localObject2 = localObject2[1];
          if (((String)localObject2).equalsIgnoreCase((String)localObject3)) {
            break;
          }
          paramString = LuggageLocalFileObjectManager.cit();
          AppMethodBeat.o(134384);
          return paramString;
        }
        try
        {
          long l2 = LuggageLocalFileObjectManager.WB(str1);
          if (l1 != l2)
          {
            Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString });
            paramString = LuggageLocalFileObjectManager.cit();
            AppMethodBeat.o(134384);
            return paramString;
          }
        }
        catch (IOException paramString)
        {
          Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { Util.stackTraceToString(paramString) });
          paramString = LuggageLocalFileObjectManager.cit();
          AppMethodBeat.o(134384);
          return paramString;
        }
        localObject3 = new ae();
        ((ae)localObject3).hHB = (LuggageLocalFileObjectManager.c(LuggageLocalFileObjectManager.this) + paramString);
        ((ae)localObject3).onG = str1;
        ((ae)localObject3).mimeType = MimeTypeUtil.getMimeTypeByFileExt((String)localObject2);
        ((ae)localObject3).qMj = ((String)localObject1).equalsIgnoreCase("store_");
        paramString = new u(((ae)localObject3).onG);
        ((ae)localObject3).qMk = paramString.lastModified();
        ((ae)localObject3).fileLength = paramString.length();
        AppMethodBeat.o(134384);
      }
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
        paramString = LuggageLocalFileObjectManager.cit();
        AppMethodBeat.o(134384);
        return paramString;
      }
      return localObject3;
    }
    
    public final ae WD(String paramString)
    {
      AppMethodBeat.i(134387);
      String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
      Object localObject2;
      try
      {
        String str1 = LuggageLocalFileObjectManager.dk(str2, LuggageLocalFileObjectManager.a(LuggageLocalFileObjectManager.this));
        if (Util.isNullOrNil(str1))
        {
          AppMethodBeat.o(134387);
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
          localObject1 = null;
        }
        localObject1 = ((String)localObject1).split("\\|");
        if ((localObject1 == null) || (localObject1.length != 2))
        {
          AppMethodBeat.o(134387);
          return null;
        }
        localObject1 = localObject1[1];
        localObject2 = new StringBuilder().append(LuggageLocalFileObjectManager.c(LuggageLocalFileObjectManager.this)).append(paramString);
        if (!Util.isNullOrNil((String)localObject1)) {}
      }
      for (Object localObject1 = "";; localObject1 = ".".concat(String.valueOf(localObject1)))
      {
        localObject2 = (String)localObject1;
        localObject1 = new ae();
        ((ae)localObject1).hHB = ((String)localObject2);
        ((ae)localObject1).onG = (LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + paramString);
        ((ae)localObject1).lPJ = str2;
        ((ae)localObject1).qMj = paramString.startsWith("store_");
        paramString = new u(((ae)localObject1).onG);
        ((ae)localObject1).qMk = paramString.lastModified();
        ((ae)localObject1).fileLength = paramString.length();
        AppMethodBeat.o(134387);
        return localObject1;
      }
    }
    
    public final ae a(ae paramae)
    {
      AppMethodBeat.i(134385);
      if (paramae == null)
      {
        AppMethodBeat.o(134385);
        return null;
      }
      String str = paramae.onG.replaceFirst("tmp_", "store_");
      if (q.de(paramae.onG, str))
      {
        ae localae = new ae();
        localae.onG = str;
        localae.hHB = paramae.hHB.replaceFirst("tmp_", "store_");
        localae.fileLength = paramae.fileLength;
        localae.lPJ = paramae.lPJ;
        localae.qMk = new u(localae.onG).lastModified();
        localae.mimeType = paramae.mimeType;
        localae.qMj = true;
        AppMethodBeat.o(134385);
        return localae;
      }
      AppMethodBeat.o(134385);
      return null;
    }
    
    /* Error */
    public final a dj(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 212
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_2
      //   6: astore 5
      //   8: aload_2
      //   9: invokestatic 65	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifeq +8 -> 20
      //   15: invokestatic 215	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:ciu	()Ljava/lang/String;
      //   18: astore 5
      //   20: aload_1
      //   21: invokestatic 131	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:WB	(Ljava/lang/String;)J
      //   24: lstore_3
      //   25: getstatic 221	java/util/Locale:US	Ljava/util/Locale;
      //   28: ldc 223
      //   30: iconst_2
      //   31: anewarray 4	java/lang/Object
      //   34: dup
      //   35: iconst_0
      //   36: lload_3
      //   37: invokestatic 138	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   40: aastore
      //   41: dup
      //   42: iconst_1
      //   43: aload 5
      //   45: aastore
      //   46: invokestatic 227	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   49: astore_1
      //   50: ldc 87
      //   52: ldc 229
      //   54: iconst_1
      //   55: anewarray 4	java/lang/Object
      //   58: dup
      //   59: iconst_0
      //   60: aload_1
      //   61: aastore
      //   62: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   65: aload_1
      //   66: aload_0
      //   67: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:qNz	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   70: invokestatic 82	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:a	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   73: invokestatic 234	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:dl	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   76: astore_1
      //   77: aload_1
      //   78: invokestatic 65	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   81: ifeq +54 -> 135
      //   84: ldc 212
      //   86: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   89: aconst_null
      //   90: areturn
      //   91: astore_1
      //   92: ldc 87
      //   94: ldc 236
      //   96: iconst_1
      //   97: anewarray 4	java/lang/Object
      //   100: dup
      //   101: iconst_0
      //   102: aload_1
      //   103: invokestatic 148	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   106: aastore
      //   107: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   110: ldc 212
      //   112: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   115: aconst_null
      //   116: areturn
      //   117: astore_1
      //   118: ldc 87
      //   120: aload_1
      //   121: ldc 238
      //   123: iconst_0
      //   124: anewarray 4	java/lang/Object
      //   127: invokestatic 101	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   130: aconst_null
      //   131: astore_1
      //   132: goto -55 -> 77
      //   135: ldc 45
      //   137: aload_1
      //   138: invokestatic 71	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   141: invokevirtual 74	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   144: astore_1
      //   145: new 109	java/lang/StringBuilder
      //   148: dup
      //   149: invokespecial 110	java/lang/StringBuilder:<init>	()V
      //   152: aload_0
      //   153: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:qNz	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   156: invokestatic 112	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   159: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   162: aload_1
      //   163: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   166: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   169: astore_2
      //   170: new 109	java/lang/StringBuilder
      //   173: dup
      //   174: invokespecial 110	java/lang/StringBuilder:<init>	()V
      //   177: aload_0
      //   178: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:qNz	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   181: invokestatic 154	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   184: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   187: aload_1
      //   188: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: astore 6
      //   193: aload 5
      //   195: invokestatic 65	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   198: ifeq +50 -> 248
      //   201: ldc 56
      //   203: astore_1
      //   204: aload 6
      //   206: aload_1
      //   207: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   210: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   213: astore_1
      //   214: ldc 87
      //   216: ldc 240
      //   218: iconst_2
      //   219: anewarray 4	java/lang/Object
      //   222: dup
      //   223: iconst_0
      //   224: aload_1
      //   225: aastore
      //   226: dup
      //   227: iconst_1
      //   228: aload_2
      //   229: aastore
      //   230: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   233: aload_1
      //   234: aload_2
      //   235: aload 5
      //   237: invokestatic 246	com/tencent/mm/vending/j/a:g	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
      //   240: astore_1
      //   241: ldc 212
      //   243: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   246: aload_1
      //   247: areturn
      //   248: ldc 201
      //   250: aload 5
      //   252: invokestatic 71	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   255: invokevirtual 74	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   258: astore_1
      //   259: goto -55 -> 204
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	262	0	this	b
      //   0	262	1	paramString1	String
      //   0	262	2	paramString2	String
      //   24	13	3	l	long
      //   6	245	5	str	String
      //   191	14	6	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   20	25	91	java/lang/Exception
      //   50	77	117	java/lang/Exception
    }
    
    public final String toString()
    {
      return "V2MediaObjectInfoHandler";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager
 * JD-Core Version:    0.7.0.1
 */