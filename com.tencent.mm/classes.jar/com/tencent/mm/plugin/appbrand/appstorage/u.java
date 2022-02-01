package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class u
{
  private static final y kTc;
  private k kEy;
  private f kSY;
  private i.a kSZ;
  private final String kSp;
  private final String kSq;
  private final String kSr;
  private final Collection<a> kTa;
  private final Map<String, o> kTb;
  
  static
  {
    AppMethodBeat.i(196177);
    kTc = new y()
    {
      public final String toString()
      {
        return "AppBrandLocalMediaObject::Nil";
      }
    };
    AppMethodBeat.o(196177);
  }
  
  u(String paramString1, String paramString2, String paramString3, i.a parama)
  {
    AppMethodBeat.i(196169);
    this.kTb = new ConcurrentHashMap();
    this.kSr = (aa.z(new o(paramString1).her()) + "/");
    this.kSp = paramString2;
    this.kSq = paramString3;
    this.kSZ = parama;
    paramString1 = new LinkedList();
    paramString1.add(new b((byte)0));
    this.kTa = Collections.unmodifiableCollection(paramString1);
    AppMethodBeat.o(196169);
  }
  
  private String bxt()
  {
    AppMethodBeat.i(196172);
    FilePathGenerator.checkMkdir(this.kSr);
    try
    {
      new o(this.kSr, ".nomedia").createNewFile();
      label30:
      String str = this.kSr;
      AppMethodBeat.o(196172);
      return str;
    }
    catch (Exception localException)
    {
      break label30;
    }
  }
  
  public final o Wi(String paramString)
  {
    AppMethodBeat.i(196171);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(196171);
      return null;
    }
    ByteBuffer localByteBuffer = dI(paramString);
    boolean bool = this.kTb.containsKey(paramString);
    if ((localByteBuffer == null) && (bool))
    {
      paramString = (o)this.kTb.remove(paramString);
      if ((paramString != null) && (paramString.exists())) {
        paramString.delete();
      }
      AppMethodBeat.o(196171);
      return null;
    }
    Object localObject1 = (o)this.kTb.get(paramString);
    if ((bool) && (localObject1 != null) && (((o)localObject1).exists()))
    {
      AppMethodBeat.o(196171);
      return localObject1;
    }
    Iterator localIterator = this.kTa.iterator();
    localObject1 = null;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = ((a)localIterator.next()).cI(paramString, "unknown");
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    if ((localObject1 == null) || (((a)localObject1).size() < 2))
    {
      if (localObject1 == null) {}
      for (int i = -1;; i = ((a)localObject1).size())
      {
        Log.e("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "createTempLocalFile, no handler return correct info, attach.size = %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(196171);
        return null;
      }
    }
    try
    {
      localObject1 = (String)((a)localObject1).get(1);
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.e("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "createTempLocalFile appId %s, Null Or Nil fileFullPath");
        AppMethodBeat.o(196171);
        return null;
      }
      if (localByteBuffer != null)
      {
        Log.i("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "get buffer success");
        localObject2 = d.p(localByteBuffer);
        s.f((String)localObject1, (byte[])localObject2, localObject2.length);
        localObject1 = new o((String)localObject1);
        this.kTb.put(paramString, localObject1);
        AppMethodBeat.o(196171);
        return localObject1;
      }
      Log.e("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "get buffer fail");
      AppMethodBeat.o(196171);
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.LuggageBlobFileObjectManager", paramString, "", new Object[0]);
      AppMethodBeat.o(196171);
    }
    return null;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(196170);
    this.kTb.clear();
    s.dy(this.kSr, true);
    AppMethodBeat.o(196170);
  }
  
  public final ByteBuffer dI(String paramString)
  {
    AppMethodBeat.i(196173);
    if (this.kEy == null)
    {
      if (this.kSY == null)
      {
        if (this.kSZ != null) {
          this.kSY = this.kSZ.bxr();
        }
        if (this.kSY == null)
        {
          Log.e("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "service is null");
          AppMethodBeat.o(196173);
          return null;
        }
      }
      this.kEy = ((k)this.kSY.getJsRuntime().R(k.class));
    }
    if ((this.kEy == null) || (this.kEy.bMF() == null))
    {
      if (this.kEy == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.e("MicroMsg.AppBrand.LuggageBlobFileObjectManager", "getBuffer failed, mBufferAddon == null?: [%b]", new Object[] { Boolean.valueOf(bool) });
        AppMethodBeat.o(196173);
        return null;
      }
    }
    paramString = this.kEy.bMF().dI(paramString);
    AppMethodBeat.o(196173);
    return paramString;
  }
  
  static abstract interface a
  {
    public abstract a cI(String paramString1, String paramString2);
  }
  
  final class b
    implements u.a
  {
    private b() {}
    
    /* Error */
    public final a cI(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 27
      //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_2
      //   6: astore 5
      //   8: aload_2
      //   9: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   12: ifeq +8 -> 20
      //   15: invokestatic 43	com/tencent/mm/plugin/appbrand/appstorage/u:bxu	()Ljava/lang/String;
      //   18: astore 5
      //   20: aload_0
      //   21: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/u$b:kTd	Lcom/tencent/mm/plugin/appbrand/appstorage/u;
      //   24: aload_1
      //   25: invokestatic 47	com/tencent/mm/plugin/appbrand/appstorage/u:a	(Lcom/tencent/mm/plugin/appbrand/appstorage/u;Ljava/lang/String;)J
      //   28: lstore_3
      //   29: getstatic 53	java/util/Locale:US	Ljava/util/Locale;
      //   32: ldc 55
      //   34: iconst_2
      //   35: anewarray 4	java/lang/Object
      //   38: dup
      //   39: iconst_0
      //   40: lload_3
      //   41: invokestatic 61	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   44: aastore
      //   45: dup
      //   46: iconst_1
      //   47: aload 5
      //   49: aastore
      //   50: invokestatic 67	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   53: astore_1
      //   54: ldc 69
      //   56: ldc 71
      //   58: iconst_1
      //   59: anewarray 4	java/lang/Object
      //   62: dup
      //   63: iconst_0
      //   64: aload_1
      //   65: aastore
      //   66: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   69: aload_1
      //   70: aload_0
      //   71: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/u$b:kTd	Lcom/tencent/mm/plugin/appbrand/appstorage/u;
      //   74: invokestatic 80	com/tencent/mm/plugin/appbrand/appstorage/u:a	(Lcom/tencent/mm/plugin/appbrand/appstorage/u;)Ljava/lang/String;
      //   77: invokestatic 84	com/tencent/mm/plugin/appbrand/appstorage/u:cH	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   80: astore_1
      //   81: aload_1
      //   82: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   85: ifeq +54 -> 139
      //   88: ldc 27
      //   90: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   93: aconst_null
      //   94: areturn
      //   95: astore_1
      //   96: ldc 69
      //   98: ldc 89
      //   100: iconst_1
      //   101: anewarray 4	java/lang/Object
      //   104: dup
      //   105: iconst_0
      //   106: aload_1
      //   107: invokestatic 93	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   110: aastore
      //   111: invokestatic 96	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   114: ldc 27
      //   116: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   119: aconst_null
      //   120: areturn
      //   121: astore_1
      //   122: ldc 69
      //   124: aload_1
      //   125: ldc 98
      //   127: iconst_0
      //   128: anewarray 4	java/lang/Object
      //   131: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   134: aconst_null
      //   135: astore_1
      //   136: goto -55 -> 81
      //   139: ldc 104
      //   141: aload_1
      //   142: invokestatic 107	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   145: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   148: astore_1
      //   149: new 113	java/lang/StringBuilder
      //   152: dup
      //   153: invokespecial 114	java/lang/StringBuilder:<init>	()V
      //   156: aload_0
      //   157: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/u$b:kTd	Lcom/tencent/mm/plugin/appbrand/appstorage/u;
      //   160: invokestatic 116	com/tencent/mm/plugin/appbrand/appstorage/u:b	(Lcom/tencent/mm/plugin/appbrand/appstorage/u;)Ljava/lang/String;
      //   163: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   166: aload_1
      //   167: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   170: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   173: astore_2
      //   174: new 113	java/lang/StringBuilder
      //   177: dup
      //   178: invokespecial 114	java/lang/StringBuilder:<init>	()V
      //   181: aload_0
      //   182: getfield 15	com/tencent/mm/plugin/appbrand/appstorage/u$b:kTd	Lcom/tencent/mm/plugin/appbrand/appstorage/u;
      //   185: invokestatic 126	com/tencent/mm/plugin/appbrand/appstorage/u:c	(Lcom/tencent/mm/plugin/appbrand/appstorage/u;)Ljava/lang/String;
      //   188: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   191: aload_1
      //   192: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   195: astore 6
      //   197: aload 5
      //   199: invokestatic 39	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   202: ifeq +50 -> 252
      //   205: ldc 128
      //   207: astore_1
      //   208: aload 6
      //   210: aload_1
      //   211: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   214: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   217: astore_1
      //   218: ldc 69
      //   220: ldc 130
      //   222: iconst_2
      //   223: anewarray 4	java/lang/Object
      //   226: dup
      //   227: iconst_0
      //   228: aload_1
      //   229: aastore
      //   230: dup
      //   231: iconst_1
      //   232: aload_2
      //   233: aastore
      //   234: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   237: aload_1
      //   238: aload_2
      //   239: aload 5
      //   241: invokestatic 135	com/tencent/mm/vending/j/a:i	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/tencent/mm/vending/j/d;
      //   244: astore_1
      //   245: ldc 27
      //   247: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   250: aload_1
      //   251: areturn
      //   252: ldc 137
      //   254: aload 5
      //   256: invokestatic 107	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   259: invokevirtual 111	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   262: astore_1
      //   263: goto -55 -> 208
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	266	0	this	b
      //   0	266	1	paramString1	String
      //   0	266	2	paramString2	String
      //   28	13	3	l	long
      //   6	249	5	str	String
      //   195	14	6	localStringBuilder	java.lang.StringBuilder
      // Exception table:
      //   from	to	target	type
      //   20	29	95	java/lang/Exception
      //   54	81	121	java/lang/Exception
    }
    
    public final String toString()
    {
      return "V2MediaObjectInfoHandler";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.u
 * JD-Core Version:    0.7.0.1
 */