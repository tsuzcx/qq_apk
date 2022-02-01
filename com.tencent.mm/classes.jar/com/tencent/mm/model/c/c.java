package com.tencent.mm.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "Lcom/tencent/mm/kernel/plugin/IPin;", "()V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV_NAME", "", "PROVIDER", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "getPROVIDER", "()Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "PROVIDER$delegate", "Lkotlin/Lazy;", "TAG", "mmAbTestStorageChangeListener", "com/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1;", "getAbTestItem", "Lcom/tencent/mm/storage/ABTestItem;", "id", "getLayerKey", "onAccountInitialized", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "resetAllExp", "storage", "Lcom/tencent/mm/storage/ABTestStorage;", "marshallFrom", "mmkv", "toUinString", "", "unmarshallTo", "ClientProvider", "MMProvider", "Provider", "plugin-abtest_release"})
public final class c
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  private static final e lxj;
  private static final f lxk;
  public static final c lxl;
  
  static
  {
    AppMethodBeat.i(153176);
    lxl = new c();
    lxj = new e();
    lxk = g.ar((a)c.lxo);
    AppMethodBeat.o(153176);
  }
  
  public static com.tencent.mm.storage.c Sz(String paramString)
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
    paramString = aal();
    kotlin.g.b.p.j(paramString, "MMKV");
    String str = "layer_" + ((com.tencent.mm.storage.c)localObject).field_layerId;
    ((com.tencent.mm.storage.c)localObject).field_rawXML = paramString.getString(str + "_rawXML", "");
    ((com.tencent.mm.storage.c)localObject).field_startTime = paramString.getLong(str + "_startTime", Util.nowSecond());
    ((com.tencent.mm.storage.c)localObject).field_endTime = paramString.getLong(str + "_endTime", Util.nowSecond());
    AppMethodBeat.o(153182);
    return localObject;
  }
  
  private static MultiProcessMMKV aal()
  {
    AppMethodBeat.i(153181);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(vy(bgy().bgz()) + "_PluginABTest_NewABTestMMKV");
    AppMethodBeat.o(153181);
    return localMultiProcessMMKV;
  }
  
  private static d bgy()
  {
    AppMethodBeat.i(153180);
    d locald = (d)lxk.getValue();
    AppMethodBeat.o(153180);
    return locald;
  }
  
  private static String vy(int paramInt)
  {
    AppMethodBeat.i(153183);
    String str = new com.tencent.mm.b.p(paramInt).toString();
    kotlin.g.b.p.j(str, "com.tencent.mm.algorithm.UIN(this).toString()");
    AppMethodBeat.o(153183);
    return str;
  }
  
  /* Error */
  public final void a(com.tencent.mm.storage.d paramd)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 222
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 223
    //   11: invokestatic 226	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: invokestatic 130	com/tencent/mm/model/c/c:aal	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   17: astore 6
    //   19: aload 6
    //   21: invokevirtual 230	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:clear	()Landroid/content/SharedPreferences$Editor;
    //   24: pop
    //   25: aload_1
    //   26: invokevirtual 236	com/tencent/mm/storage/d:getAll	()Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +262 -> 293
    //   34: aload_1
    //   35: checkcast 238	java/io/Closeable
    //   38: astore 5
    //   40: aload 5
    //   42: checkcast 240	android/database/Cursor
    //   45: astore_1
    //   46: aload_1
    //   47: invokeinterface 244 1 0
    //   52: istore_3
    //   53: iload_3
    //   54: ifne +15 -> 69
    //   57: aload 5
    //   59: aconst_null
    //   60: invokestatic 249	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   63: ldc 222
    //   65: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: return
    //   69: new 122	com/tencent/mm/storage/c
    //   72: dup
    //   73: invokespecial 123	com/tencent/mm/storage/c:<init>	()V
    //   76: astore 7
    //   78: aload 7
    //   80: aload_1
    //   81: invokevirtual 253	com/tencent/mm/storage/c:convertFrom	(Landroid/database/Cursor;)V
    //   84: aload 7
    //   86: getfield 127	com/tencent/mm/storage/c:field_layerId	Ljava/lang/String;
    //   89: checkcast 116	java/lang/CharSequence
    //   92: astore 8
    //   94: aload 8
    //   96: ifnull +207 -> 303
    //   99: aload 8
    //   101: invokeinterface 120 1 0
    //   106: ifne +157 -> 263
    //   109: goto +194 -> 303
    //   112: iload_2
    //   113: ifne +125 -> 238
    //   116: aload 6
    //   118: ldc 254
    //   120: invokestatic 137	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   123: new 139	java/lang/StringBuilder
    //   126: dup
    //   127: ldc 141
    //   129: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: aload 7
    //   134: getfield 127	com/tencent/mm/storage/c:field_layerId	Ljava/lang/String;
    //   137: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: astore 8
    //   145: aload 6
    //   147: new 139	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   154: aload 8
    //   156: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: ldc 155
    //   161: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: aload 7
    //   169: getfield 165	com/tencent/mm/storage/c:field_rawXML	Ljava/lang/String;
    //   172: invokevirtual 258	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   175: pop
    //   176: aload 6
    //   178: new 139	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   185: aload 8
    //   187: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: ldc 167
    //   192: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: aload 7
    //   200: getfield 181	com/tencent/mm/storage/c:field_startTime	J
    //   203: invokevirtual 262	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   206: pop
    //   207: aload 6
    //   209: new 139	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   216: aload 8
    //   218: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc 183
    //   223: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: aload 7
    //   231: getfield 186	com/tencent/mm/storage/c:field_endTime	J
    //   234: invokevirtual 262	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putLong	(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   237: pop
    //   238: aload_1
    //   239: invokeinterface 265 1 0
    //   244: ifne -166 -> 78
    //   247: getstatic 271	kotlin/x:aazN	Lkotlin/x;
    //   250: astore_1
    //   251: aload 5
    //   253: aconst_null
    //   254: invokestatic 249	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   257: ldc 222
    //   259: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: return
    //   263: iconst_0
    //   264: istore_2
    //   265: goto -153 -> 112
    //   268: astore 4
    //   270: ldc 222
    //   272: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload 4
    //   277: athrow
    //   278: astore_1
    //   279: aload 5
    //   281: aload 4
    //   283: invokestatic 249	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   286: ldc 222
    //   288: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   291: aload_1
    //   292: athrow
    //   293: ldc 222
    //   295: invokestatic 109	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: return
    //   299: astore_1
    //   300: goto -21 -> 279
    //   303: iconst_1
    //   304: istore_2
    //   305: goto -193 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	c
    //   0	308	1	paramd	com.tencent.mm.storage.d
    //   112	193	2	i	int
    //   52	2	3	bool	boolean
    //   1	1	4	localObject1	Object
    //   268	14	4	localThrowable	java.lang.Throwable
    //   38	242	5	localCloseable	java.io.Closeable
    //   17	191	6	localMultiProcessMMKV	MultiProcessMMKV
    //   76	154	7	localc	com.tencent.mm.storage.c
    //   92	125	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	53	268	java/lang/Throwable
    //   69	78	268	java/lang/Throwable
    //   78	94	268	java/lang/Throwable
    //   99	109	268	java/lang/Throwable
    //   116	238	268	java/lang/Throwable
    //   238	251	268	java/lang/Throwable
    //   270	278	278	finally
    //   40	53	299	finally
    //   69	78	299	finally
    //   78	94	299	finally
    //   99	109	299	finally
    //   116	238	299	finally
    //   238	251	299	finally
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(153177);
    paramc = new StringBuilder("onAccountInitialized uin[");
    kotlin.g.b.p.j(h.aHE(), "MMKernel.account()");
    Log.i("MicroMsg.PluginABTest.NewABTestMMKV", vy(b.getUin()) + ']');
    d.bgB().add("MicroMsg.PluginABTest.NewABTestMMKV", (MStorage.IOnStorageChange)lxj);
    paramc = d.bgB();
    kotlin.g.b.p.j(paramc, "SubCoreNewABTest.getABTestStorage()");
    a(paramc);
    AppMethodBeat.o(153177);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(153178);
    d.bgB().remove((MStorage.IOnStorageChange)lxj);
    AppMethodBeat.o(153178);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$ClientProvider;", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "()V", "UIN", "", "getUIN", "()I", "UIN$delegate", "Lkotlin/Lazy;", "provideUIN", "plugin-abtest_release"})
  static final class a
    implements c.d
  {
    private final f lxm;
    
    public a()
    {
      AppMethodBeat.i(153171);
      this.lxm = g.ar((a)a.lxn);
      AppMethodBeat.o(153171);
    }
    
    public final int bgz()
    {
      AppMethodBeat.i(153170);
      int i = ((Number)this.lxm.getValue()).intValue();
      AppMethodBeat.o(153170);
      return i;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<Integer>
    {
      public static final a lxn;
      
      static
      {
        AppMethodBeat.i(153168);
        lxn = new a();
        AppMethodBeat.o(153168);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$MMProvider;", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "()V", "provideUIN", "", "plugin-abtest_release"})
  static final class b
    implements c.d
  {
    public final int bgz()
    {
      AppMethodBeat.i(153172);
      kotlin.g.b.p.j(h.aHE(), "MMKernel.account()");
      int i = b.getUin();
      AppMethodBeat.o(153172);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "invoke"})
  static final class c
    extends q
    implements a<c.d>
  {
    public static final c lxo;
    
    static
    {
      AppMethodBeat.i(153174);
      lxo = new c();
      AppMethodBeat.o(153174);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/model/newabtest/NewABTestMMKV$Provider;", "", "provideUIN", "", "plugin-abtest_release"})
  static abstract interface d
  {
    public abstract int bgz();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/model/newabtest/NewABTestMMKV$mmAbTestStorageChangeListener$1", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "onNotifyChange", "", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "plugin-abtest_release"})
  public static final class e
    implements MStorage.IOnStorageChange
  {
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      AppMethodBeat.i(153175);
      if (kotlin.g.b.p.h("event_updated", paramString))
      {
        paramString = c.lxl;
        paramMStorageEventData = d.bgB();
        kotlin.g.b.p.j(paramMStorageEventData, "SubCoreNewABTest.getABTestStorage()");
        paramString.a(paramMStorageEventData);
      }
      AppMethodBeat.o(153175);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.c
 * JD-Core Version:    0.7.0.1
 */