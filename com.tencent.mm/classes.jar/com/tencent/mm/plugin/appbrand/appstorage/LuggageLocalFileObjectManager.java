package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.g;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class LuggageLocalFileObjectManager
{
  private static final w jNg;
  private final String jMN;
  private final String jMO;
  private final String jMP;
  private final Collection<a> jNf;
  
  static
  {
    AppMethodBeat.i(134403);
    jNg = new w()
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
    this.jMN = (q.B(new e(paramString1).fOK()) + "/");
    this.jMO = paramString2;
    this.jMP = paramString3;
    paramString1 = new LinkedList();
    paramString1.add(new b((byte)0));
    this.jNf = Collections.unmodifiableCollection(paramString1);
    AppMethodBeat.o(134388);
  }
  
  private <T extends w> T a(String paramString1, Class<T> paramClass, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134393);
    if (!i.fv(paramString1))
    {
      AppMethodBeat.o(134393);
      return null;
    }
    Object localObject1 = org.apache.commons.a.d.getExtension(paramString1);
    Object localObject2;
    if (bt.isNullOrNil((String)localObject1))
    {
      Iterator localIterator = this.jNf.iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = ((a)localIterator.next()).cu(paramString1, paramString2);
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
      ad.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(134393);
      return null;
      paramString2 = (String)localObject1;
      break;
    }
    try
    {
      label153:
      localObject2 = (w)paramClass.newInstance();
      ((w)localObject2).drH = ((String)((a)localObject1).get(0));
      ((w)localObject2).mimeType = com.tencent.mm.sdk.f.d.aRD(paramString2);
      ((w)localObject2).hIy = ((String)((a)localObject1).get(1));
      if (bt.isNullOrNil(((w)localObject2).hIy))
      {
        ad.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
        AppMethodBeat.o(134393);
        return null;
      }
      paramClass = paramString2;
      if (bt.isNullOrNil(paramString2)) {
        paramClass = "unknown";
      }
      ((w)localObject2).fVf = bt.bI((String)((a)localObject1).get(3), paramClass);
      paramClass = ((w)localObject2).hIy;
      if ((paramBoolean) && (k.cp(paramString1, paramClass))) {
        i = 1;
      }
      while (i != 0)
      {
        paramString1 = new e(((w)localObject2).hIy);
        ((w)localObject2).iQl = paramString1.length();
        ((w)localObject2).jMh = paramString1.lastModified();
        AppMethodBeat.o(134393);
        return localObject2;
        if (!paramBoolean)
        {
          paramBoolean = p.lL(paramString1, paramClass);
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
      ad.printErrStackTrace("MicroMsg.AppBrand.LuggageLocalFileObjectManager", paramString1, "", new Object[0]);
      AppMethodBeat.o(134393);
    }
  }
  
  private String bbF()
  {
    AppMethodBeat.i(134395);
    m.aLc(this.jMN);
    try
    {
      new e(this.jMN, ".nomedia").createNewFile();
      label32:
      String str = this.jMN;
      AppMethodBeat.o(134395);
      return str;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  final w Mu(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(134397);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134397);
      return null;
    }
    Iterator localIterator = this.jNf.iterator();
    while (localIterator.hasNext())
    {
      w localw = ((a)localIterator.next()).My(paramString);
      localObject = localw;
      if (localw != null) {
        localObject = localw;
      }
    }
    AppMethodBeat.o(134397);
    return localObject;
  }
  
  @Deprecated
  public final w Mv(String paramString)
  {
    AppMethodBeat.i(134398);
    if ((bt.isNullOrNil(paramString)) || (!paramString.startsWith(this.jMP)))
    {
      ad.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", new Object[] { paramString });
      AppMethodBeat.o(134398);
      return null;
    }
    String str = paramString.substring(this.jMP.length());
    Iterator localIterator = this.jNf.iterator();
    paramString = null;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      paramString = locala.Mx(str);
      if (paramString != null) {
        ad.i("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString });
      }
    }
    for (;;)
    {
      if (jNg == paramString)
      {
        AppMethodBeat.o(134398);
        return null;
        break;
      }
      AppMethodBeat.o(134398);
      return paramString;
    }
  }
  
  public final w a(w paramw)
  {
    AppMethodBeat.i(134396);
    Object localObject = null;
    Iterator localIterator = this.jNf.iterator();
    while (localIterator.hasNext())
    {
      w localw = ((a)localIterator.next()).a(paramw);
      localObject = localw;
      if (localw != null) {
        localObject = localw;
      }
    }
    AppMethodBeat.o(134396);
    return localObject;
  }
  
  public final List<w> bbC()
  {
    AppMethodBeat.i(134390);
    e[] arrayOfe = bbD();
    if ((arrayOfe == null) || (arrayOfe.length <= 0))
    {
      AppMethodBeat.o(134390);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = arrayOfe.length;
    int i = 0;
    while (i < j)
    {
      w localw = Mu(arrayOfe[i].getName());
      if (localw != null) {
        localLinkedList.add(localw);
      }
      i += 1;
    }
    AppMethodBeat.o(134390);
    return localLinkedList;
  }
  
  final e[] bbD()
  {
    AppMethodBeat.i(175590);
    Object localObject = new e(bbF());
    if ((!((e)localObject).exists()) || (!((e)localObject).isDirectory()))
    {
      AppMethodBeat.o(175590);
      return null;
    }
    localObject = ((e)localObject).a(new g()
    {
      public final boolean accept(e paramAnonymouse)
      {
        AppMethodBeat.i(175588);
        if ((paramAnonymouse.exists()) && (!paramAnonymouse.isDirectory()) && (!bt.isNullOrNil(paramAnonymouse.getName())) && (paramAnonymouse.getName().startsWith("store_")))
        {
          AppMethodBeat.o(175588);
          return true;
        }
        AppMethodBeat.o(175588);
        return false;
      }
    });
    AppMethodBeat.o(175590);
    return localObject;
  }
  
  public final List<w> bbE()
  {
    AppMethodBeat.i(134392);
    Object localObject = new e(bbF());
    if ((!((e)localObject).exists()) || (!((e)localObject).isDirectory())) {}
    for (localObject = null; (localObject == null) || (localObject.length <= 0); localObject = ((e)localObject).a(new g()
        {
          public final boolean accept(e paramAnonymouse)
          {
            AppMethodBeat.i(175589);
            if ((paramAnonymouse.exists()) && (!paramAnonymouse.isDirectory()) && (!bt.isNullOrNil(paramAnonymouse.getName())) && (paramAnonymouse.getName().startsWith("tmp_")))
            {
              AppMethodBeat.o(175589);
              return true;
            }
            AppMethodBeat.o(175589);
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
      w localw = Mu(localObject[i].getName());
      if (localw != null) {
        localLinkedList.add(localw);
      }
      i += 1;
    }
    AppMethodBeat.o(134392);
    return localLinkedList;
  }
  
  @Keep
  public final String genMediaFilePath(String paramString)
  {
    AppMethodBeat.i(134389);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134389);
      return null;
    }
    paramString = bbF() + paramString;
    AppMethodBeat.o(134389);
    return paramString;
  }
  
  public final w j(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134394);
    paramString1 = a(paramString1, w.class, paramString2, paramBoolean);
    AppMethodBeat.o(134394);
    return paramString1;
  }
  
  static abstract interface a
  {
    public abstract w Mx(String paramString);
    
    public abstract w My(String paramString);
    
    public abstract w a(w paramw);
    
    public abstract a cu(String paramString1, String paramString2);
  }
  
  final class b
    implements LuggageLocalFileObjectManager.a
  {
    private b() {}
    
    public final w Mx(String paramString)
    {
      Object localObject1 = null;
      AppMethodBeat.i(134384);
      if ((!paramString.startsWith("store_")) && (!paramString.startsWith("tmp_")))
      {
        AppMethodBeat.o(134384);
        return null;
      }
      Object localObject3 = org.apache.commons.a.d.getExtension(paramString);
      String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
      String str1 = str2;
      if (!bt.isNullOrNil((String)localObject3)) {
        str1 = str2.replaceFirst(".".concat(String.valueOf(localObject3)), "");
      }
      if (bt.isNullOrNil(str1))
      {
        paramString = LuggageLocalFileObjectManager.bbG();
        AppMethodBeat.o(134384);
        return paramString;
      }
      try
      {
        str2 = LuggageLocalFileObjectManager.cs(str1, LuggageLocalFileObjectManager.a(LuggageLocalFileObjectManager.this));
        localObject1 = str2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObject, decrypt exp ", new Object[0]);
        }
        Object localObject2 = ((String)localObject1).split("\\|");
        if ((localObject2 != null) && (localObject2.length == 2)) {
          break label200;
        }
        paramString = LuggageLocalFileObjectManager.bbG();
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
          l1 = bt.getLong(localObject2[0], 0L);
          localObject2 = localObject2[1];
          if (((String)localObject2).equalsIgnoreCase((String)localObject3)) {
            break;
          }
          paramString = LuggageLocalFileObjectManager.bbG();
          AppMethodBeat.o(134384);
          return paramString;
        }
        try
        {
          long l2 = LuggageLocalFileObjectManager.Mw(str1);
          if (l1 != l2)
          {
            ad.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString });
            paramString = LuggageLocalFileObjectManager.bbG();
            AppMethodBeat.o(134384);
            return paramString;
          }
        }
        catch (IOException paramString)
        {
          ad.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { bt.n(paramString) });
          paramString = LuggageLocalFileObjectManager.bbG();
          AppMethodBeat.o(134384);
          return paramString;
        }
        localObject3 = new w();
        ((w)localObject3).drH = (LuggageLocalFileObjectManager.c(LuggageLocalFileObjectManager.this) + paramString);
        ((w)localObject3).hIy = str1;
        ((w)localObject3).mimeType = com.tencent.mm.sdk.f.d.aRD((String)localObject2);
        ((w)localObject3).jMg = ((String)localObject1).equalsIgnoreCase("store_");
        paramString = new e(((w)localObject3).hIy);
        ((w)localObject3).jMh = paramString.lastModified();
        ((w)localObject3).iQl = paramString.length();
        AppMethodBeat.o(134384);
      }
      if (bt.isNullOrNil((String)localObject1))
      {
        ad.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
        paramString = LuggageLocalFileObjectManager.bbG();
        AppMethodBeat.o(134384);
        return paramString;
      }
      return localObject3;
    }
    
    public final w My(String paramString)
    {
      AppMethodBeat.i(134387);
      String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
      Object localObject2;
      try
      {
        String str1 = LuggageLocalFileObjectManager.cs(str2, LuggageLocalFileObjectManager.a(LuggageLocalFileObjectManager.this));
        if (bt.isNullOrNil(str1))
        {
          AppMethodBeat.o(134387);
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
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
        if (!bt.isNullOrNil((String)localObject1)) {}
      }
      for (Object localObject1 = "";; localObject1 = ".".concat(String.valueOf(localObject1)))
      {
        localObject2 = (String)localObject1;
        localObject1 = new w();
        ((w)localObject1).drH = ((String)localObject2);
        ((w)localObject1).hIy = (LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + paramString);
        ((w)localObject1).fVf = str2;
        ((w)localObject1).jMg = paramString.startsWith("store_");
        paramString = new e(((w)localObject1).hIy);
        ((w)localObject1).jMh = paramString.lastModified();
        ((w)localObject1).iQl = paramString.length();
        AppMethodBeat.o(134387);
        return localObject1;
      }
    }
    
    public final w a(w paramw)
    {
      AppMethodBeat.i(134385);
      if (paramw == null)
      {
        AppMethodBeat.o(134385);
        return null;
      }
      String str = paramw.hIy.replaceFirst("tmp_", "store_");
      if (k.cp(paramw.hIy, str))
      {
        w localw = new w();
        localw.hIy = str;
        localw.drH = paramw.drH.replaceFirst("tmp_", "store_");
        localw.iQl = paramw.iQl;
        localw.fVf = paramw.fVf;
        localw.jMh = new e(localw.hIy).lastModified();
        localw.mimeType = paramw.mimeType;
        localw.jMg = true;
        AppMethodBeat.o(134385);
        return localw;
      }
      AppMethodBeat.o(134385);
      return null;
    }
    
    /* Error */
    public final a cu(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 210
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_2
      //   6: astore 5
      //   8: aload_2
      //   9: invokestatic 65	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifeq +8 -> 20
      //   15: invokestatic 213	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:bbH	()Ljava/lang/String;
      //   18: astore 5
      //   20: aload_1
      //   21: invokestatic 131	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:Mw	(Ljava/lang/String;)J
      //   24: lstore_3
      //   25: getstatic 219	java/util/Locale:US	Ljava/util/Locale;
      //   28: ldc 221
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
      //   46: invokestatic 225	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   49: astore_1
      //   50: ldc 87
      //   52: ldc 227
      //   54: iconst_1
      //   55: anewarray 4	java/lang/Object
      //   58: dup
      //   59: iconst_0
      //   60: aload_1
      //   61: aastore
      //   62: invokestatic 229	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   65: aload_1
      //   66: aload_0
      //   67: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:jNh	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   70: invokestatic 82	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:a	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   73: invokestatic 232	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:ct	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   76: astore_1
      //   77: aload_1
      //   78: invokestatic 65	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   81: ifeq +54 -> 135
      //   84: ldc 210
      //   86: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   89: aconst_null
      //   90: areturn
      //   91: astore_1
      //   92: ldc 87
      //   94: ldc 234
      //   96: iconst_1
      //   97: anewarray 4	java/lang/Object
      //   100: dup
      //   101: iconst_0
      //   102: aload_1
      //   103: invokestatic 148	com/tencent/mm/sdk/platformtools/bt:n	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   106: aastore
      //   107: invokestatic 142	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   110: ldc 210
      //   112: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   115: aconst_null
      //   116: areturn
      //   117: astore_1
      //   118: ldc 87
      //   120: aload_1
      //   121: ldc 236
      //   123: iconst_0
      //   124: anewarray 4	java/lang/Object
      //   127: invokestatic 101	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   153: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:jNh	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
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
      //   178: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:jNh	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   181: invokestatic 154	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   184: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   187: aload_1
      //   188: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: astore 6
      //   193: aload 5
      //   195: invokestatic 65	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   198: ifeq +50 -> 248
      //   201: ldc 56
      //   203: astore_1
      //   204: aload 6
      //   206: aload_1
      //   207: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   210: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   213: astore_1
      //   214: ldc 87
      //   216: ldc 238
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
      //   230: invokestatic 229	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   233: aload_1
      //   234: aload_2
      //   235: aload 5
      //   237: invokestatic 243	com/tencent/mm/vending/j/a:i	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
      //   240: astore_1
      //   241: ldc 210
      //   243: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   246: aload_1
      //   247: areturn
      //   248: ldc 67
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager
 * JD-Core Version:    0.7.0.1
 */