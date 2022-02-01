package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vfs.e;
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
  private static final w jtm;
  private final String jsT;
  private final String jsU;
  private final String jsV;
  private final Collection<a> jtl;
  
  static
  {
    AppMethodBeat.i(134403);
    jtm = new w()
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
    this.jsT = (q.B(new e(paramString1).fxV()) + "/");
    this.jsU = paramString2;
    this.jsV = paramString3;
    paramString1 = new LinkedList();
    paramString1.add(new b((byte)0));
    this.jtl = Collections.unmodifiableCollection(paramString1);
    AppMethodBeat.o(134388);
  }
  
  private <T extends w> T a(String paramString1, Class<T> paramClass, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134393);
    if (!i.eA(paramString1))
    {
      AppMethodBeat.o(134393);
      return null;
    }
    Object localObject1 = org.apache.commons.a.d.getExtension(paramString1);
    Object localObject2;
    if (bs.isNullOrNil((String)localObject1))
    {
      Iterator localIterator = this.jtl.iterator();
      localObject1 = null;
      while (localIterator.hasNext())
      {
        localObject2 = ((a)localIterator.next()).cs(paramString1, paramString2);
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
      ac.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(134393);
      return null;
      paramString2 = (String)localObject1;
      break;
    }
    try
    {
      label153:
      localObject2 = (w)paramClass.newInstance();
      ((w)localObject2).dgl = ((String)((a)localObject1).get(0));
      ((w)localObject2).mimeType = com.tencent.mm.sdk.f.d.aLW(paramString2);
      ((w)localObject2).hqg = ((String)((a)localObject1).get(1));
      if (bs.isNullOrNil(((w)localObject2).hqg))
      {
        ac.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
        AppMethodBeat.o(134393);
        return null;
      }
      paramClass = paramString2;
      if (bs.isNullOrNil(paramString2)) {
        paramClass = "unknown";
      }
      ((w)localObject2).fBR = bs.bG((String)((a)localObject1).get(3), paramClass);
      paramClass = ((w)localObject2).hqg;
      if ((paramBoolean) && (k.cn(paramString1, paramClass))) {
        i = 1;
      }
      while (i != 0)
      {
        paramString1 = new e(((w)localObject2).hqg);
        ((w)localObject2).ixc = paramString1.length();
        ((w)localObject2).jsn = paramString1.lastModified();
        AppMethodBeat.o(134393);
        return localObject2;
        if (!paramBoolean)
        {
          paramBoolean = o.lm(paramString1, paramClass);
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
      ac.printErrStackTrace("MicroMsg.AppBrand.LuggageLocalFileObjectManager", paramString1, "", new Object[0]);
      AppMethodBeat.o(134393);
    }
  }
  
  private String aYh()
  {
    AppMethodBeat.i(134395);
    l.aFC(this.jsT);
    try
    {
      new e(this.jsT, ".nomedia").createNewFile();
      label32:
      String str = this.jsT;
      AppMethodBeat.o(134395);
      return str;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  final w Jd(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(134397);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134397);
      return null;
    }
    Iterator localIterator = this.jtl.iterator();
    while (localIterator.hasNext())
    {
      w localw = ((a)localIterator.next()).Jh(paramString);
      localObject = localw;
      if (localw != null) {
        localObject = localw;
      }
    }
    AppMethodBeat.o(134397);
    return localObject;
  }
  
  @Deprecated
  public final w Je(String paramString)
  {
    AppMethodBeat.i(134398);
    if ((bs.isNullOrNil(paramString)) || (!paramString.startsWith(this.jsV)))
    {
      ac.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", new Object[] { paramString });
      AppMethodBeat.o(134398);
      return null;
    }
    String str = paramString.substring(this.jsV.length());
    Iterator localIterator = this.jtl.iterator();
    paramString = null;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      paramString = locala.Jg(str);
      if (paramString != null) {
        ac.i("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString });
      }
    }
    for (;;)
    {
      if (jtm == paramString)
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
    Iterator localIterator = this.jtl.iterator();
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
  
  public final List<w> aYe()
  {
    AppMethodBeat.i(134390);
    e[] arrayOfe = aYf();
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
      w localw = Jd(arrayOfe[i].getName());
      if (localw != null) {
        localLinkedList.add(localw);
      }
      i += 1;
    }
    AppMethodBeat.o(134390);
    return localLinkedList;
  }
  
  final e[] aYf()
  {
    AppMethodBeat.i(175590);
    Object localObject = new e(aYh());
    if ((!((e)localObject).exists()) || (!((e)localObject).isDirectory()))
    {
      AppMethodBeat.o(175590);
      return null;
    }
    localObject = ((e)localObject).a(new LuggageLocalFileObjectManager.1(this));
    AppMethodBeat.o(175590);
    return localObject;
  }
  
  public final List<w> aYg()
  {
    AppMethodBeat.i(134392);
    Object localObject = new e(aYh());
    if ((!((e)localObject).exists()) || (!((e)localObject).isDirectory())) {}
    for (localObject = null; (localObject == null) || (localObject.length <= 0); localObject = ((e)localObject).a(new LuggageLocalFileObjectManager.2(this)))
    {
      AppMethodBeat.o(134392);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      w localw = Jd(localObject[i].getName());
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
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134389);
      return null;
    }
    paramString = aYh() + paramString;
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
    public abstract w Jg(String paramString);
    
    public abstract w Jh(String paramString);
    
    public abstract w a(w paramw);
    
    public abstract a cs(String paramString1, String paramString2);
  }
  
  final class b
    implements LuggageLocalFileObjectManager.a
  {
    private b() {}
    
    public final w Jg(String paramString)
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
      if (!bs.isNullOrNil((String)localObject3)) {
        str1 = str2.replaceFirst(".".concat(String.valueOf(localObject3)), "");
      }
      if (bs.isNullOrNil(str1))
      {
        paramString = LuggageLocalFileObjectManager.aYi();
        AppMethodBeat.o(134384);
        return paramString;
      }
      try
      {
        str2 = LuggageLocalFileObjectManager.cq(str1, LuggageLocalFileObjectManager.a(LuggageLocalFileObjectManager.this));
        localObject1 = str2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObject, decrypt exp ", new Object[0]);
        }
        Object localObject2 = ((String)localObject1).split("\\|");
        if ((localObject2 != null) && (localObject2.length == 2)) {
          break label200;
        }
        paramString = LuggageLocalFileObjectManager.aYi();
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
          l1 = bs.getLong(localObject2[0], 0L);
          localObject2 = localObject2[1];
          if (((String)localObject2).equalsIgnoreCase((String)localObject3)) {
            break;
          }
          paramString = LuggageLocalFileObjectManager.aYi();
          AppMethodBeat.o(134384);
          return paramString;
        }
        try
        {
          long l2 = LuggageLocalFileObjectManager.Jf(str1);
          if (l1 != l2)
          {
            ac.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString });
            paramString = LuggageLocalFileObjectManager.aYi();
            AppMethodBeat.o(134384);
            return paramString;
          }
        }
        catch (IOException paramString)
        {
          ac.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { bs.m(paramString) });
          paramString = LuggageLocalFileObjectManager.aYi();
          AppMethodBeat.o(134384);
          return paramString;
        }
        localObject3 = new w();
        ((w)localObject3).dgl = (LuggageLocalFileObjectManager.c(LuggageLocalFileObjectManager.this) + paramString);
        ((w)localObject3).hqg = str1;
        ((w)localObject3).mimeType = com.tencent.mm.sdk.f.d.aLW((String)localObject2);
        ((w)localObject3).jsm = ((String)localObject1).equalsIgnoreCase("store_");
        paramString = new e(((w)localObject3).hqg);
        ((w)localObject3).jsn = paramString.lastModified();
        ((w)localObject3).ixc = paramString.length();
        AppMethodBeat.o(134384);
      }
      if (bs.isNullOrNil((String)localObject1))
      {
        ac.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
        paramString = LuggageLocalFileObjectManager.aYi();
        AppMethodBeat.o(134384);
        return paramString;
      }
      return localObject3;
    }
    
    public final w Jh(String paramString)
    {
      AppMethodBeat.i(134387);
      String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
      Object localObject2;
      try
      {
        String str1 = LuggageLocalFileObjectManager.cq(str2, LuggageLocalFileObjectManager.a(LuggageLocalFileObjectManager.this));
        if (bs.isNullOrNil(str1))
        {
          AppMethodBeat.o(134387);
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
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
        if (!bs.isNullOrNil((String)localObject1)) {}
      }
      for (Object localObject1 = "";; localObject1 = ".".concat(String.valueOf(localObject1)))
      {
        localObject2 = (String)localObject1;
        localObject1 = new w();
        ((w)localObject1).dgl = ((String)localObject2);
        ((w)localObject1).hqg = (LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + paramString);
        ((w)localObject1).fBR = str2;
        ((w)localObject1).jsm = paramString.startsWith("store_");
        paramString = new e(((w)localObject1).hqg);
        ((w)localObject1).jsn = paramString.lastModified();
        ((w)localObject1).ixc = paramString.length();
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
      String str = paramw.hqg.replaceFirst("tmp_", "store_");
      if (k.cn(paramw.hqg, str))
      {
        w localw = new w();
        localw.hqg = str;
        localw.dgl = paramw.dgl.replaceFirst("tmp_", "store_");
        localw.ixc = paramw.ixc;
        localw.fBR = paramw.fBR;
        localw.jsn = new e(localw.hqg).lastModified();
        localw.mimeType = paramw.mimeType;
        localw.jsm = true;
        AppMethodBeat.o(134385);
        return localw;
      }
      AppMethodBeat.o(134385);
      return null;
    }
    
    /* Error */
    public final a cs(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 210
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_2
      //   6: astore 5
      //   8: aload_2
      //   9: invokestatic 65	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifeq +8 -> 20
      //   15: invokestatic 213	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:aYj	()Ljava/lang/String;
      //   18: astore 5
      //   20: aload_1
      //   21: invokestatic 131	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:Jf	(Ljava/lang/String;)J
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
      //   62: invokestatic 229	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   65: aload_1
      //   66: aload_0
      //   67: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:jtn	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   70: invokestatic 82	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:a	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   73: invokestatic 232	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:cr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   76: astore_1
      //   77: aload_1
      //   78: invokestatic 65	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
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
      //   103: invokestatic 148	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   106: aastore
      //   107: invokestatic 142	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   127: invokestatic 101	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   153: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:jtn	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
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
      //   178: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:jtn	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   181: invokestatic 154	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   184: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   187: aload_1
      //   188: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: astore 6
      //   193: aload 5
      //   195: invokestatic 65	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
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
      //   230: invokestatic 229	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager
 * JD-Core Version:    0.7.0.1
 */