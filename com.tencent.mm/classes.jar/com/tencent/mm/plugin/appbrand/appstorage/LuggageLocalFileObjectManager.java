package com.tencent.mm.plugin.appbrand.appstorage;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.sdk.platformtools.q;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class LuggageLocalFileObjectManager
{
  private static final y jQt;
  private final String jPH;
  private final String jPI;
  private final String jPJ;
  private final Collection<a> jQr;
  
  static
  {
    AppMethodBeat.i(134403);
    jQt = new y()
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
    this.jPJ = (w.B(new k(paramString1).fTh()) + "/");
    this.jPH = paramString2;
    this.jPI = paramString3;
    paramString1 = new LinkedList();
    paramString1.add(new b((byte)0));
    this.jQr = Collections.unmodifiableCollection(paramString1);
    AppMethodBeat.o(134388);
  }
  
  private <T extends y> T a(String paramString1, Class<T> paramClass, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134393);
    if (!o.fB(paramString1))
    {
      AppMethodBeat.o(134393);
      return null;
    }
    Object localObject1 = org.apache.commons.a.d.getExtension(paramString1);
    Object localObject2;
    if (bu.isNullOrNil((String)localObject1))
    {
      Iterator localIterator = this.jQr.iterator();
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
      ae.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(134393);
      return null;
      paramString2 = (String)localObject1;
      break;
    }
    try
    {
      label153:
      localObject2 = (y)paramClass.newInstance();
      ((y)localObject2).dsN = ((String)((a)localObject1).get(0));
      ((y)localObject2).mimeType = com.tencent.mm.sdk.f.d.aTa(paramString2);
      ((y)localObject2).hLr = ((String)((a)localObject1).get(1));
      if (bu.isNullOrNil(((y)localObject2).hLr))
      {
        ae.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "attachCast appId %s, Null Or Nil fileFullPath");
        AppMethodBeat.o(134393);
        return null;
      }
      paramClass = paramString2;
      if (bu.isNullOrNil(paramString2)) {
        paramClass = "unknown";
      }
      ((y)localObject2).fXl = bu.bI((String)((a)localObject1).get(3), paramClass);
      paramClass = ((y)localObject2).hLr;
      if ((paramBoolean) && (l.cq(paramString1, paramClass))) {
        i = 1;
      }
      while (i != 0)
      {
        paramString1 = new k(((y)localObject2).hLr);
        ((y)localObject2).iTe = paramString1.length();
        ((y)localObject2).jPt = paramString1.lastModified();
        AppMethodBeat.o(134393);
        return localObject2;
        if (!paramBoolean)
        {
          paramBoolean = q.lS(paramString1, paramClass);
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
      ae.printErrStackTrace("MicroMsg.AppBrand.LuggageLocalFileObjectManager", paramString1, "", new Object[0]);
      AppMethodBeat.o(134393);
    }
  }
  
  private String bce()
  {
    AppMethodBeat.i(134395);
    n.aMy(this.jPJ);
    try
    {
      new k(this.jPJ, ".nomedia").createNewFile();
      label32:
      String str = this.jPJ;
      AppMethodBeat.o(134395);
      return str;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  final y Nb(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(134397);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134397);
      return null;
    }
    Iterator localIterator = this.jQr.iterator();
    while (localIterator.hasNext())
    {
      y localy = ((a)localIterator.next()).Nf(paramString);
      localObject = localy;
      if (localy != null) {
        localObject = localy;
      }
    }
    AppMethodBeat.o(134397);
    return localObject;
  }
  
  @Deprecated
  public final y Nc(String paramString)
  {
    AppMethodBeat.i(134398);
    if ((bu.isNullOrNil(paramString)) || (!paramString.startsWith(this.jPI)))
    {
      ae.e("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, invalid args, localId(%s)", new Object[] { paramString });
      AppMethodBeat.o(134398);
      return null;
    }
    String str = paramString.substring(this.jPI.length());
    Iterator localIterator = this.jQr.iterator();
    paramString = null;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      paramString = locala.Ne(str);
      if (paramString != null) {
        ae.i("MicroMsg.AppBrand.LuggageLocalFileObjectManager", "getItemByLocalId, handled by %s, result = %s", new Object[] { locala.toString(), paramString });
      }
    }
    for (;;)
    {
      if (jQt == paramString)
      {
        AppMethodBeat.o(134398);
        return null;
        break;
      }
      AppMethodBeat.o(134398);
      return paramString;
    }
  }
  
  public final y a(y paramy)
  {
    AppMethodBeat.i(134396);
    Object localObject = null;
    Iterator localIterator = this.jQr.iterator();
    while (localIterator.hasNext())
    {
      y localy = ((a)localIterator.next()).a(paramy);
      localObject = localy;
      if (localy != null) {
        localObject = localy;
      }
    }
    AppMethodBeat.o(134396);
    return localObject;
  }
  
  public final List<y> bch()
  {
    AppMethodBeat.i(134390);
    k[] arrayOfk = bci();
    if ((arrayOfk == null) || (arrayOfk.length <= 0))
    {
      AppMethodBeat.o(134390);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      y localy = Nb(arrayOfk[i].getName());
      if (localy != null) {
        localLinkedList.add(localy);
      }
      i += 1;
    }
    AppMethodBeat.o(134390);
    return localLinkedList;
  }
  
  final k[] bci()
  {
    AppMethodBeat.i(175590);
    Object localObject = new k(bce());
    if ((!((k)localObject).exists()) || (!((k)localObject).isDirectory()))
    {
      AppMethodBeat.o(175590);
      return null;
    }
    localObject = ((k)localObject).a(new LuggageLocalFileObjectManager.1(this));
    AppMethodBeat.o(175590);
    return localObject;
  }
  
  public final List<y> bcj()
  {
    AppMethodBeat.i(134392);
    Object localObject = new k(bce());
    if ((!((k)localObject).exists()) || (!((k)localObject).isDirectory())) {}
    for (localObject = null; (localObject == null) || (localObject.length <= 0); localObject = ((k)localObject).a(new LuggageLocalFileObjectManager.2(this)))
    {
      AppMethodBeat.o(134392);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      y localy = Nb(localObject[i].getName());
      if (localy != null) {
        localLinkedList.add(localy);
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
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(134389);
      return null;
    }
    paramString = bce() + paramString;
    AppMethodBeat.o(134389);
    return paramString;
  }
  
  public final y j(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(134394);
    paramString1 = a(paramString1, y.class, paramString2, paramBoolean);
    AppMethodBeat.o(134394);
    return paramString1;
  }
  
  static abstract interface a
  {
    public abstract y Ne(String paramString);
    
    public abstract y Nf(String paramString);
    
    public abstract y a(y paramy);
    
    public abstract a cu(String paramString1, String paramString2);
  }
  
  final class b
    implements LuggageLocalFileObjectManager.a
  {
    private b() {}
    
    public final y Ne(String paramString)
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
      if (!bu.isNullOrNil((String)localObject3)) {
        str1 = str2.replaceFirst("\\.".concat(String.valueOf(localObject3)), "");
      }
      if (bu.isNullOrNil(str1))
      {
        paramString = LuggageLocalFileObjectManager.bck();
        AppMethodBeat.o(134384);
        return paramString;
      }
      try
      {
        str2 = LuggageLocalFileObjectManager.cv(str1, LuggageLocalFileObjectManager.a(LuggageLocalFileObjectManager.this));
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
          break label200;
        }
        paramString = LuggageLocalFileObjectManager.bck();
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
          l1 = bu.getLong(localObject2[0], 0L);
          localObject2 = localObject2[1];
          if (((String)localObject2).equalsIgnoreCase((String)localObject3)) {
            break;
          }
          paramString = LuggageLocalFileObjectManager.bck();
          AppMethodBeat.o(134384);
          return paramString;
        }
        try
        {
          long l2 = LuggageLocalFileObjectManager.Nd(str1);
          if (l1 != l2)
          {
            ae.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s)", new Object[] { Long.valueOf(l2), Long.valueOf(l1), paramString });
            paramString = LuggageLocalFileObjectManager.bck();
            AppMethodBeat.o(134384);
            return paramString;
          }
        }
        catch (IOException paramString)
        {
          ae.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[] { bu.o(paramString) });
          paramString = LuggageLocalFileObjectManager.bck();
          AppMethodBeat.o(134384);
          return paramString;
        }
        localObject3 = new y();
        ((y)localObject3).dsN = (LuggageLocalFileObjectManager.c(LuggageLocalFileObjectManager.this) + paramString);
        ((y)localObject3).hLr = str1;
        ((y)localObject3).mimeType = com.tencent.mm.sdk.f.d.aTa((String)localObject2);
        ((y)localObject3).jPs = ((String)localObject1).equalsIgnoreCase("store_");
        paramString = new k(((y)localObject3).hLr);
        ((y)localObject3).jPt = paramString.lastModified();
        ((y)localObject3).iTe = paramString.length();
        AppMethodBeat.o(134384);
      }
      if (bu.isNullOrNil((String)localObject1))
      {
        ae.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
        paramString = LuggageLocalFileObjectManager.bck();
        AppMethodBeat.o(134384);
        return paramString;
      }
      return localObject3;
    }
    
    public final y Nf(String paramString)
    {
      AppMethodBeat.i(134387);
      String str2 = paramString.replaceFirst("store_", "").replaceFirst("tmp_", "");
      Object localObject2;
      try
      {
        String str1 = LuggageLocalFileObjectManager.cv(str2, LuggageLocalFileObjectManager.a(LuggageLocalFileObjectManager.this));
        if (bu.isNullOrNil(str1))
        {
          AppMethodBeat.o(134387);
          return null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", localException, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
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
        if (!bu.isNullOrNil((String)localObject1)) {}
      }
      for (Object localObject1 = "";; localObject1 = ".".concat(String.valueOf(localObject1)))
      {
        localObject2 = (String)localObject1;
        localObject1 = new y();
        ((y)localObject1).dsN = ((String)localObject2);
        ((y)localObject1).hLr = (LuggageLocalFileObjectManager.b(LuggageLocalFileObjectManager.this) + paramString);
        ((y)localObject1).fXl = str2;
        ((y)localObject1).jPs = paramString.startsWith("store_");
        paramString = new k(((y)localObject1).hLr);
        ((y)localObject1).jPt = paramString.lastModified();
        ((y)localObject1).iTe = paramString.length();
        AppMethodBeat.o(134387);
        return localObject1;
      }
    }
    
    public final y a(y paramy)
    {
      AppMethodBeat.i(134385);
      if (paramy == null)
      {
        AppMethodBeat.o(134385);
        return null;
      }
      String str = paramy.hLr.replaceFirst("tmp_", "store_");
      if (l.cq(paramy.hLr, str))
      {
        y localy = new y();
        localy.hLr = str;
        localy.dsN = paramy.dsN.replaceFirst("tmp_", "store_");
        localy.iTe = paramy.iTe;
        localy.fXl = paramy.fXl;
        localy.jPt = new k(localy.hLr).lastModified();
        localy.mimeType = paramy.mimeType;
        localy.jPs = true;
        AppMethodBeat.o(134385);
        return localy;
      }
      AppMethodBeat.o(134385);
      return null;
    }
    
    /* Error */
    public final a cu(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 211
      //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_2
      //   6: astore 5
      //   8: aload_2
      //   9: invokestatic 65	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifeq +8 -> 20
      //   15: invokestatic 214	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:bcl	()Ljava/lang/String;
      //   18: astore 5
      //   20: aload_1
      //   21: invokestatic 131	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:Nd	(Ljava/lang/String;)J
      //   24: lstore_3
      //   25: getstatic 220	java/util/Locale:US	Ljava/util/Locale;
      //   28: ldc 222
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
      //   46: invokestatic 226	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   49: astore_1
      //   50: ldc 87
      //   52: ldc 228
      //   54: iconst_1
      //   55: anewarray 4	java/lang/Object
      //   58: dup
      //   59: iconst_0
      //   60: aload_1
      //   61: aastore
      //   62: invokestatic 230	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   65: aload_1
      //   66: aload_0
      //   67: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:jQy	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   70: invokestatic 82	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:a	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   73: invokestatic 233	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:cw	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   76: astore_1
      //   77: aload_1
      //   78: invokestatic 65	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
      //   81: ifeq +54 -> 135
      //   84: ldc 211
      //   86: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   89: aconst_null
      //   90: areturn
      //   91: astore_1
      //   92: ldc 87
      //   94: ldc 235
      //   96: iconst_1
      //   97: anewarray 4	java/lang/Object
      //   100: dup
      //   101: iconst_0
      //   102: aload_1
      //   103: invokestatic 147	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   106: aastore
      //   107: invokestatic 142	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   110: ldc 211
      //   112: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   115: aconst_null
      //   116: areturn
      //   117: astore_1
      //   118: ldc 87
      //   120: aload_1
      //   121: ldc 237
      //   123: iconst_0
      //   124: anewarray 4	java/lang/Object
      //   127: invokestatic 101	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   153: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:jQy	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
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
      //   178: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager$b:jQy	Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;
      //   181: invokestatic 153	com/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/LuggageLocalFileObjectManager;)Ljava/lang/String;
      //   184: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   187: aload_1
      //   188: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: astore 6
      //   193: aload 5
      //   195: invokestatic 65	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
      //   198: ifeq +50 -> 248
      //   201: ldc 56
      //   203: astore_1
      //   204: aload 6
      //   206: aload_1
      //   207: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   210: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   213: astore_1
      //   214: ldc 87
      //   216: ldc 239
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
      //   230: invokestatic 230	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   233: aload_1
      //   234: aload_2
      //   235: aload 5
      //   237: invokestatic 244	com/tencent/mm/vending/j/a:i	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
      //   240: astore_1
      //   241: ldc 211
      //   243: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   246: aload_1
      //   247: areturn
      //   248: ldc 200
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.LuggageLocalFileObjectManager
 * JD-Core Version:    0.7.0.1
 */