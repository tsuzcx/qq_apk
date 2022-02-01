package com.tencent.mm.plugin.appbrand.appstorage;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.a.c;

public final class LuggageLocalFileObjectManager
{
  private static final aa nNA;
  public static final s nNG;
  private final String nMM;
  private final String nMN;
  private final String nMO;
  private final Collection<a> nNy;
  
  static
  {
    AppMethodBeat.i(134403);
    nNG = new s()
    {
      public final boolean accept(q paramAnonymousq)
      {
        AppMethodBeat.i(175588);
        boolean bool = LuggageLocalFileObjectManager.e(paramAnonymousq, "store_");
        AppMethodBeat.o(175588);
        return bool;
      }
    };
    nNA = new aa()
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
    this.nMO = (new q(paramString1).bOF() + "/");
    this.nMM = paramString2;
    this.nMN = paramString3;
    paramString1 = new LinkedList();
    paramString1.add(new b((byte)0));
    this.nNy = Collections.unmodifiableCollection(paramString1);
    AppMethodBeat.o(134388);
  }
  
  private <T extends aa> T a(String paramString1, Class<T> paramClass, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134393);
    if (!u.agG(paramString1))
    {
      AppMethodBeat.o(134393);
      return null;
    }
    Object localObject1 = c.bIf(paramString1);
    Object localObject2;
    if (Util.isNullOrNil((String)localObject1))
    {
      Iterator localIterator = this.nNy.iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = ((a)localIterator.next()).cS(paramString1, paramString2);
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
      localObject2 = (aa)paramClass.newInstance();
      ((aa)localObject2).fCM = ((String)((a)localObject1).get(0));
      ((aa)localObject2).mimeType = MimeTypeUtil.getMimeTypeByFileExt(paramString2);
      ((aa)localObject2).lwh = ((String)((a)localObject1).get(1));
      if (Util.isNullOrNil(((aa)localObject2).lwh))
      {
        Log.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
        AppMethodBeat.o(134393);
        return null;
      }
      paramClass = paramString2;
      if (Util.isNullOrNil(paramString2)) {
        paramClass = "unknown";
      }
      ((aa)localObject2).jmx = Util.nullAs((String)((a)localObject1).get(3), paramClass);
      paramClass = ((aa)localObject2).lwh;
      if ((paramBoolean) && (l.cN(paramString1, paramClass))) {
        i = 1;
      }
      while (i != 0)
      {
        paramString1 = new q(((aa)localObject2).lwh);
        ((aa)localObject2).mHi = paramString1.length();
        ((aa)localObject2).nMj = paramString1.lastModified();
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
  
  static boolean a(q paramq, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(225031);
    if (((!paramBoolean) || (paramq.ifE())) && (!paramq.isDirectory()) && (!Util.isNullOrNil(paramq.getName())) && (paramq.getName().startsWith(paramString)))
    {
      AppMethodBeat.o(225031);
      return true;
    }
    AppMethodBeat.o(225031);
    return false;
  }
  
  private q[] bIM()
  {
    AppMethodBeat.i(175590);
    Object localObject = new q(bII());
    if ((!((q)localObject).ifE()) || (!((q)localObject).isDirectory()))
    {
      AppMethodBeat.o(175590);
      return null;
    }
    localObject = ((q)localObject).a(new s()
    {
      public final boolean accept(q paramAnonymousq)
      {
        AppMethodBeat.i(175589);
        boolean bool = LuggageLocalFileObjectManager.this.c(paramAnonymousq, true);
        AppMethodBeat.o(175589);
        return bool;
      }
    });
    AppMethodBeat.o(175590);
    return localObject;
  }
  
  final aa a(aa paramaa)
  {
    AppMethodBeat.i(134396);
    Object localObject = null;
    Iterator localIterator = this.nNy.iterator();
    while (localIterator.hasNext())
    {
      aa localaa = ((a)localIterator.next()).a(paramaa);
      localObject = localaa;
      if (localaa != null) {
        localObject = localaa;
      }
    }
    AppMethodBeat.o(134396);
    return localObject;
  }
  
  final aa adZ(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(134397);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134397);
      return null;
    }
    Iterator localIterator = this.nNy.iterator();
    while (localIterator.hasNext())
    {
      aa localaa = ((a)localIterator.next()).aed(paramString);
      localObject = localaa;
      if (localaa != null) {
        localObject = localaa;
      }
    }
    AppMethodBeat.o(134397);
    return localObject;
  }
  
  @Deprecated
  public final aa aea(String paramString)
  {
    AppMethodBeat.i(134398);
    if ((Util.isNullOrNil(paramString)) || (!paramString.startsWith(this.nMN)))
    {
      Log.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", new Object[] { paramString });
      AppMethodBeat.o(134398);
      return null;
    }
    String str = paramString.substring(this.nMN.length());
    Iterator localIterator = this.nNy.iterator();
    paramString = null;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      paramString = locala.aec(str);
      if (paramString != null) {
        Log.i("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString });
      }
    }
    for (;;)
    {
      if (nNA == paramString)
      {
        AppMethodBeat.o(134398);
        return null;
        break;
      }
      AppMethodBeat.o(134398);
      return paramString;
    }
  }
  
  final String bII()
  {
    AppMethodBeat.i(134395);
    FilePathGenerator.checkMkdir(this.nMO);
    try
    {
      new q(this.nMO, ".nomedia").ifM();
      label32:
      String str = this.nMO;
      AppMethodBeat.o(134395);
      return str;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final List<aa> bIL()
  {
    AppMethodBeat.i(134390);
    q[] arrayOfq = bIM();
    if ((arrayOfq == null) || (arrayOfq.length <= 0))
    {
      AppMethodBeat.o(134390);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = arrayOfq.length;
    int i = 0;
    while (i < j)
    {
      aa localaa = adZ(arrayOfq[i].getName());
      if (localaa != null) {
        localLinkedList.add(localaa);
      }
      i += 1;
    }
    AppMethodBeat.o(134390);
    return localLinkedList;
  }
  
  public final List<aa> bIN()
  {
    AppMethodBeat.i(134392);
    Object localObject = new q(bII());
    if ((!((q)localObject).ifE()) || (!((q)localObject).isDirectory())) {}
    for (localObject = null; (localObject == null) || (localObject.length <= 0); localObject = ((q)localObject).a(new s()
        {
          public final boolean accept(q paramAnonymousq)
          {
            AppMethodBeat.i(225012);
            if ((new q(LuggageLocalFileObjectManager.this.bII()).equals(new q(paramAnonymousq.ifA()))) && (LuggageLocalFileObjectManager.a(paramAnonymousq, "tmp_", true)))
            {
              AppMethodBeat.o(225012);
              return true;
            }
            AppMethodBeat.o(225012);
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
      aa localaa = adZ(localObject[i].getName());
      if (localaa != null) {
        localLinkedList.add(localaa);
      }
      i += 1;
    }
    AppMethodBeat.o(134392);
    return localLinkedList;
  }
  
  public final long bIO()
  {
    long l = 0L;
    AppMethodBeat.i(225040);
    q[] arrayOfq = bIM();
    if ((arrayOfq == null) || (arrayOfq.length <= 0))
    {
      AppMethodBeat.o(225040);
      return 0L;
    }
    int j = arrayOfq.length;
    int i = 0;
    while (i < j)
    {
      l += arrayOfq[i].length();
      i += 1;
    }
    AppMethodBeat.o(225040);
    return l;
  }
  
  final boolean c(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(225028);
    if ((new q(bII()).equals(new q(paramq.ifA()))) && (a(paramq, "store_", paramBoolean)))
    {
      AppMethodBeat.o(225028);
      return true;
    }
    AppMethodBeat.o(225028);
    return false;
  }
  
  @Keep
  public final String genMediaFilePath(String paramString)
  {
    AppMethodBeat.i(134389);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134389);
      return null;
    }
    paramString = bII() + paramString;
    AppMethodBeat.o(134389);
    return paramString;
  }
  
  public final aa j(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134394);
    paramString1 = a(paramString1, aa.class, paramString2, paramBoolean);
    AppMethodBeat.o(134394);
    return paramString1;
  }
  
  static abstract interface a
  {
    public abstract aa a(aa paramaa);
    
    public abstract aa aec(String paramString);
    
    public abstract aa aed(String paramString);
    
    public abstract a cS(String paramString1, String paramString2);
  }
  
  final class b
    implements LuggageLocalFileObjectManager.a
  {
    private b() {}
    
    public final aa a(aa paramaa)
    {
      AppMethodBeat.i(134385);
      if (paramaa == null)
      {
        AppMethodBeat.o(134385);
        return null;
      }
      String str = paramaa.lwh.replaceFirst("tmp_", "store_");
      if (l.cN(paramaa.lwh, str))
      {
        aa localaa = new aa();
        localaa.lwh = str;
        localaa.fCM = paramaa.fCM.replaceFirst("tmp_", "store_");
        localaa.mHi = paramaa.mHi;
        localaa.jmx = paramaa.jmx;
        localaa.nMj = new q(localaa.lwh).lastModified();
        localaa.mimeType = paramaa.mimeType;
        localaa.nMi = true;
        AppMethodBeat.o(134385);
        return localaa;
      }
      AppMethodBeat.o(134385);
      return null;
    }
    
    public final aa aec(String paramString)
    {
      Object localObject1 = null;
      AppMethodBeat.i(134384);
      if ((!paramString.startsWith("store_")) && (!paramString.startsWith("tmp_")))
      {
        AppMethodBeat.o(134384);
        return null;
      }
      Object localObject3 = c.bIf(paramString);
      String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
      String str1 = str2;
      if (!Util.isNullOrNil((String)localObject3)) {
        str1 = str2.replaceFirst("\\.".concat(String.valueOf(localObject3)), "");
      }
      if (Util.isNullOrNil(str1))
      {
        paramString = LuggageLocalFileObjectManager.bIP();
        AppMethodBeat.o(134384);
        return paramString;
      }
      try
      {
        str2 = LuggageLocalFileObjectManager.cT(str1, LuggageLocalFileObjectManager.a(LuggageLocalFileObjectManager.this));
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
        paramString = LuggageLocalFileObjectManager.bIP();
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
          paramString = LuggageLocalFileObjectManager.bIP();
          AppMethodBeat.o(134384);
          return paramString;
        }
        try
        {
          long l2 = LuggageLocalFileObjectManager.aeb(str1);
          if (l1 != l2)
          {
            Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString });
            paramString = LuggageLocalFileObjectManager.bIP();
            AppMethodBeat.o(134384);
            return paramString;
          }
        }
        catch (IOException paramString)
        {
          Log.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { Util.stackTraceToString(paramString) });
          paramString = LuggageLocalFileObjectManager.bIP();
          AppMethodBeat.o(134384);
          return paramString;
        }
        localObject3 = new aa();
        ((aa)localObject3).fCM = (LuggageLocalFileObjectManager.c(LuggageLocalFileObjectManager.this) + paramString);
        ((aa)localObject3).lwh = str1;
        ((aa)localObject3).mimeType = MimeTypeUtil.getMimeTypeByFileExt((String)localObject2);
        ((aa)localObject3).nMi = ((String)localObject1).equalsIgnoreCase("store_");
        paramString = new q(((aa)localObject3).lwh);
        ((aa)localObject3).nMj = paramString.lastModified();
        ((aa)localObject3).mHi = paramString.length();
        AppMethodBeat.o(134384);
      }
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
        paramString = LuggageLocalFileObjectManager.bIP();
        AppMethodBeat.o(134384);
        return paramString;
      }
      return localObject3;
    }
    
    public final aa aed(String paramString)
    {
      AppMethodBeat.i(134387);
      String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
      Object localObject2;
      try
      {
        String str1 = LuggageLocalFileObjectManager.cT(str2, LuggageLocalFileObjectManager.a(LuggageLocalFileObjectManager.this));
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
        localObject1 = new aa();
        ((aa)localObject1).fCM = ((String)localObject2);
        ((aa)localObject1).lwh = (LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + paramString);
        ((aa)localObject1).jmx = str2;
        ((aa)localObject1).nMi = paramString.startsWith("store_");
        paramString = new q(((aa)localObject1).lwh);
        ((aa)localObject1).nMj = paramString.lastModified();
        ((aa)localObject1).mHi = paramString.length();
        AppMethodBeat.o(134387);
        return localObject1;
      }
    }
    
    /* Error */
    public final a cS(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 212
      //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_2
      //   6: astore 5
      //   8: aload_2
      //   9: invokestatic 110	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifeq +8 -> 20
      //   15: invokestatic 215	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:bIQ	()Ljava/lang/String;
      //   18: astore 5
      //   20: aload_1
      //   21: invokestatic 175	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:aeb	(Ljava/lang/String;)J
      //   24: lstore_3
      //   25: getstatic 221	java/util/Locale:US	Ljava/util/Locale;
      //   28: ldc 223
      //   30: iconst_2
      //   31: anewarray 4	java/lang/Object
      //   34: dup
      //   35: iconst_0
      //   36: lload_3
      //   37: invokestatic 182	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   40: aastore
      //   41: dup
      //   42: iconst_1
      //   43: aload 5
      //   45: aastore
      //   46: invokestatic 227	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   49: astore_1
      //   50: ldc 131
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
      //   67: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:nNH	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   70: invokestatic 126	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:a	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   73: invokestatic 234	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:cU	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   76: astore_1
      //   77: aload_1
      //   78: invokestatic 110	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   81: ifeq +54 -> 135
      //   84: ldc 212
      //   86: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   89: aconst_null
      //   90: areturn
      //   91: astore_1
      //   92: ldc 131
      //   94: ldc 236
      //   96: iconst_1
      //   97: anewarray 4	java/lang/Object
      //   100: dup
      //   101: iconst_0
      //   102: aload_1
      //   103: invokestatic 192	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   106: aastore
      //   107: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   110: ldc 212
      //   112: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   115: aconst_null
      //   116: areturn
      //   117: astore_1
      //   118: ldc 131
      //   120: aload_1
      //   121: ldc 238
      //   123: iconst_0
      //   124: anewarray 4	java/lang/Object
      //   127: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   130: aconst_null
      //   131: astore_1
      //   132: goto -55 -> 77
      //   135: ldc 42
      //   137: aload_1
      //   138: invokestatic 116	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   141: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   144: astore_1
      //   145: new 153	java/lang/StringBuilder
      //   148: dup
      //   149: invokespecial 154	java/lang/StringBuilder:<init>	()V
      //   152: aload_0
      //   153: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:nNH	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   156: invokestatic 156	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   159: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   162: aload_1
      //   163: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   166: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   169: astore_2
      //   170: new 153	java/lang/StringBuilder
      //   173: dup
      //   174: invokespecial 154	java/lang/StringBuilder:<init>	()V
      //   177: aload_0
      //   178: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:nNH	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   181: invokestatic 195	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   184: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   187: aload_1
      //   188: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: astore 6
      //   193: aload 5
      //   195: invokestatic 110	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   198: ifeq +50 -> 248
      //   201: ldc 105
      //   203: astore_1
      //   204: aload 6
      //   206: aload_1
      //   207: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   210: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   213: astore_1
      //   214: ldc 131
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
      //   237: invokestatic 246	com/tencent/mm/vending/j/a:h	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
      //   240: astore_1
      //   241: ldc 212
      //   243: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   246: aload_1
      //   247: areturn
      //   248: ldc 209
      //   250: aload 5
      //   252: invokestatic 116	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   255: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager
 * JD-Core Version:    0.7.0.1
 */