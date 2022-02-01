package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import d.f;
import d.g.b.u;
import d.g.b.w;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/plugin/IPin;", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_NAME", "", "PROVIDER", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "getPROVIDER", "()Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "PROVIDER$delegate", "Lkotlin/Lazy;", "TAG", "mmAbTestStorageChangeListener", "com/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1;", "getAbTestItem", "Lcom/tencent/mm/storage/ABTestItem;", "id", "getLayerKey", "onAccountInitialized", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "resetAllExp", "storage", "Lcom/tencent/mm/storage/ABTestStorage;", "marshallFrom", "mmkv", "toUinString", "", "unmarshallTo", "ClientProvider", "MMProvider", "Provider", "plugin-abtest_release"})
public final class c
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  private static final e hqT;
  private static final f hqU;
  public static final c hqV;
  
  static
  {
    AppMethodBeat.i(153176);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(c.class), "PROVIDER", "getPROVIDER()Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;")) };
    hqV = new c();
    hqT = new e();
    hqU = d.g.K((d.g.a.a)c.hqY);
    AppMethodBeat.o(153176);
  }
  
  private static aw JW()
  {
    AppMethodBeat.i(153181);
    aw localaw = aw.aKT(ok(aAm().aAn()) + "_PluginABTest_NewABTestMMKV");
    AppMethodBeat.o(153181);
    return localaw;
  }
  
  /* Error */
  public static void a(com.tencent.mm.storage.d paramd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 172
    //   4: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 173
    //   10: invokestatic 179	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: invokestatic 181	com/tencent/mm/model/c/c:JW	()Lcom/tencent/mm/sdk/platformtools/aw;
    //   16: astore 5
    //   18: aload 5
    //   20: invokevirtual 185	com/tencent/mm/sdk/platformtools/aw:clear	()Landroid/content/SharedPreferences$Editor;
    //   23: pop
    //   24: aload_0
    //   25: invokevirtual 191	com/tencent/mm/storage/d:getAll	()Landroid/database/Cursor;
    //   28: astore_0
    //   29: aload_0
    //   30: ifnull +259 -> 289
    //   33: aload_0
    //   34: checkcast 193	java/io/Closeable
    //   37: astore 4
    //   39: aload 4
    //   41: checkcast 195	android/database/Cursor
    //   44: astore_0
    //   45: aload_0
    //   46: invokeinterface 199 1 0
    //   51: istore_2
    //   52: iload_2
    //   53: ifne +15 -> 68
    //   56: aload 4
    //   58: aconst_null
    //   59: invokestatic 204	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   62: ldc 172
    //   64: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: return
    //   68: new 206	com/tencent/mm/storage/c
    //   71: dup
    //   72: invokespecial 207	com/tencent/mm/storage/c:<init>	()V
    //   75: astore 6
    //   77: aload 6
    //   79: aload_0
    //   80: invokevirtual 211	com/tencent/mm/storage/c:convertFrom	(Landroid/database/Cursor;)V
    //   83: aload 6
    //   85: getfield 215	com/tencent/mm/storage/c:field_layerId	Ljava/lang/String;
    //   88: checkcast 217	java/lang/CharSequence
    //   91: astore 7
    //   93: aload 7
    //   95: ifnull +204 -> 299
    //   98: aload 7
    //   100: invokeinterface 220 1 0
    //   105: ifne +157 -> 262
    //   108: goto +191 -> 299
    //   111: iload_1
    //   112: ifne +125 -> 237
    //   115: aload 5
    //   117: ldc 221
    //   119: invokestatic 224	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   122: new 139	java/lang/StringBuilder
    //   125: dup
    //   126: ldc 226
    //   128: invokespecial 229	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload 6
    //   133: getfield 215	com/tencent/mm/storage/c:field_layerId	Ljava/lang/String;
    //   136: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: astore 7
    //   144: aload 5
    //   146: new 139	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   153: aload 7
    //   155: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 231
    //   160: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: aload 6
    //   168: getfield 234	com/tencent/mm/storage/c:field_rawXML	Ljava/lang/String;
    //   171: invokevirtual 238	com/tencent/mm/sdk/platformtools/aw:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   174: pop
    //   175: aload 5
    //   177: new 139	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   184: aload 7
    //   186: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc 240
    //   191: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: aload 6
    //   199: getfield 244	com/tencent/mm/storage/c:field_startTime	J
    //   202: invokevirtual 248	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   205: pop
    //   206: aload 5
    //   208: new 139	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   215: aload 7
    //   217: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc 250
    //   222: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: aload 6
    //   230: getfield 253	com/tencent/mm/storage/c:field_endTime	J
    //   233: invokevirtual 248	com/tencent/mm/sdk/platformtools/aw:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   236: pop
    //   237: aload_0
    //   238: invokeinterface 256 1 0
    //   243: ifne -166 -> 77
    //   246: getstatic 262	d/y:KTp	Ld/y;
    //   249: astore_0
    //   250: aload 4
    //   252: aconst_null
    //   253: invokestatic 204	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   256: ldc 172
    //   258: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   261: return
    //   262: iconst_0
    //   263: istore_1
    //   264: goto -153 -> 111
    //   267: astore_3
    //   268: ldc 172
    //   270: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: aload_3
    //   274: athrow
    //   275: astore_0
    //   276: aload 4
    //   278: aload_3
    //   279: invokestatic 204	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   282: ldc 172
    //   284: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   287: aload_0
    //   288: athrow
    //   289: ldc 172
    //   291: invokestatic 132	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: return
    //   295: astore_0
    //   296: goto -20 -> 276
    //   299: iconst_1
    //   300: istore_1
    //   301: goto -190 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramd	com.tencent.mm.storage.d
    //   111	190	1	i	int
    //   51	2	2	bool	boolean
    //   1	1	3	localObject1	Object
    //   267	12	3	localThrowable	java.lang.Throwable
    //   37	240	4	localCloseable	java.io.Closeable
    //   16	191	5	localaw	aw
    //   75	154	6	localc	com.tencent.mm.storage.c
    //   91	125	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   39	52	267	java/lang/Throwable
    //   68	77	267	java/lang/Throwable
    //   77	93	267	java/lang/Throwable
    //   98	108	267	java/lang/Throwable
    //   115	237	267	java/lang/Throwable
    //   237	250	267	java/lang/Throwable
    //   268	275	275	finally
    //   39	52	295	finally
    //   68	77	295	finally
    //   77	93	295	finally
    //   98	108	295	finally
    //   115	237	295	finally
    //   237	250	295	finally
  }
  
  private static d aAm()
  {
    AppMethodBeat.i(153180);
    d locald = (d)hqU.getValue();
    AppMethodBeat.o(153180);
    return locald;
  }
  
  private static String ok(int paramInt)
  {
    AppMethodBeat.i(153183);
    String str = new p(paramInt).toString();
    d.g.b.k.g(str, "com.tencent.mm.algorithm.UIN(this).toString()");
    AppMethodBeat.o(153183);
    return str;
  }
  
  public static com.tencent.mm.storage.c yU(String paramString)
  {
    AppMethodBeat.i(153182);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(153182);
      return null;
    }
    localObject = new com.tencent.mm.storage.c();
    ((com.tencent.mm.storage.c)localObject).field_layerId = paramString;
    paramString = JW();
    d.g.b.k.g(paramString, "MMKV");
    String str = "layer_" + ((com.tencent.mm.storage.c)localObject).field_layerId;
    ((com.tencent.mm.storage.c)localObject).field_rawXML = paramString.getString(str + "_rawXML", "");
    ((com.tencent.mm.storage.c)localObject).field_startTime = paramString.getLong(str + "_startTime", bs.aNx());
    ((com.tencent.mm.storage.c)localObject).field_endTime = paramString.getLong(str + "_endTime", bs.aNx());
    AppMethodBeat.o(153182);
    return localObject;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(153177);
    paramc = new StringBuilder("onAccountInitialized uin[");
    d.g.b.k.g(com.tencent.mm.kernel.g.agP(), "MMKernel.account()");
    ac.i("MicroMsg.PluginABTest.NewABTestMMKV", ok(com.tencent.mm.kernel.a.getUin()) + ']');
    d.aAp().add("MicroMsg.PluginABTest.NewABTestMMKV", (k.a)hqT);
    paramc = d.aAp();
    d.g.b.k.g(paramc, "SubCoreNewABTest.getABTestStorage()");
    a(paramc);
    AppMethodBeat.o(153177);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(153178);
    d.aAp().remove((k.a)hqT);
    AppMethodBeat.o(153178);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$ClientProvider;", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "()V", "UIN", "", "getUIN", "()I", "UIN$delegate", "Lkotlin/Lazy;", "provideUIN", "plugin-abtest_release"})
  static final class a
    implements c.d
  {
    private final f hqW;
    
    static
    {
      AppMethodBeat.i(153169);
      $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(a.class), "UIN", "getUIN()I")) };
      AppMethodBeat.o(153169);
    }
    
    public a()
    {
      AppMethodBeat.i(153171);
      this.hqW = d.g.K((d.g.a.a)a.hqX);
      AppMethodBeat.o(153171);
    }
    
    public final int aAn()
    {
      AppMethodBeat.i(153170);
      int i = ((Number)this.hqW.getValue()).intValue();
      AppMethodBeat.o(153170);
      return i;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<Integer>
    {
      public static final a hqX;
      
      static
      {
        AppMethodBeat.i(153168);
        hqX = new a();
        AppMethodBeat.o(153168);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$MMProvider;", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "()V", "provideUIN", "", "plugin-abtest_release"})
  static final class b
    implements c.d
  {
    public final int aAn()
    {
      AppMethodBeat.i(153172);
      d.g.b.k.g(com.tencent.mm.kernel.g.agP(), "MMKernel.account()");
      int i = com.tencent.mm.kernel.a.getUin();
      AppMethodBeat.o(153172);
      return i;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<c.d>
  {
    public static final c hqY;
    
    static
    {
      AppMethodBeat.i(153174);
      hqY = new c();
      AppMethodBeat.o(153174);
    }
    
    c()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "", "provideUIN", "", "plugin-abtest_release"})
  static abstract interface d
  {
    public abstract int aAn();
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onNotifyChange", "", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "plugin-abtest_release"})
  public static final class e
    implements k.a
  {
    public final void a(String paramString, m paramm)
    {
      AppMethodBeat.i(153175);
      if (d.g.b.k.g("event_updated", paramString))
      {
        paramString = c.hqV;
        paramString = d.aAp();
        d.g.b.k.g(paramString, "SubCoreNewABTest.getABTestStorage()");
        c.a(paramString);
      }
      AppMethodBeat.o(153175);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.c
 * JD-Core Version:    0.7.0.1
 */