package com.tencent.mm.live.core.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.core.a.f;
import com.tencent.mm.live.core.core.e.f;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/util/LiveFilterUtil;", "", "()V", "ASSETS_ROOT", "", "FILTERS_PATH", "TAG", "filterCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getFilterCache", "()Ljava/util/HashMap;", "checkFilterPath", "", "checkFiltersPath", "copyAssets", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "filterId", "path", "filterName", "filter", "filterPath", "FilterInfo", "plugin-core_release"})
public final class a
{
  private static final String ksQ;
  private static final HashMap<Integer, String> ksR;
  public static final a ksS;
  
  static
  {
    AppMethodBeat.i(198836);
    ksS = new a();
    ksQ = b.aSE() + "live/filters";
    ksR = new HashMap();
    AppMethodBeat.o(198836);
  }
  
  public static int NQ(String paramString)
  {
    AppMethodBeat.i(198829);
    int i;
    if (p.h(paramString, ksQ + "/ziran"))
    {
      paramString = e.f.kkj;
      i = e.f.aKj();
      AppMethodBeat.o(198829);
      return i;
    }
    if (p.h(paramString, ksQ + "/baixi"))
    {
      paramString = e.f.kkj;
      i = e.f.aKk();
      AppMethodBeat.o(198829);
      return i;
    }
    if (p.h(paramString, ksQ + "/huaijiu"))
    {
      paramString = e.f.kkj;
      i = e.f.aKq();
      AppMethodBeat.o(198829);
      return i;
    }
    if (p.h(paramString, ksQ + "/qiuri"))
    {
      paramString = e.f.kkj;
      i = e.f.aKl();
      AppMethodBeat.o(198829);
      return i;
    }
    if (p.h(paramString, ksQ + "/meishi"))
    {
      paramString = e.f.kkj;
      i = e.f.aKm();
      AppMethodBeat.o(198829);
      return i;
    }
    if (p.h(paramString, ksQ + "/fanchaleng"))
    {
      paramString = e.f.kkj;
      i = e.f.aKn();
      AppMethodBeat.o(198829);
      return i;
    }
    if (p.h(paramString, ksQ + "/gangfeng"))
    {
      paramString = e.f.kkj;
      i = e.f.aKp();
      AppMethodBeat.o(198829);
      return i;
    }
    if (p.h(paramString, ksQ + "/jiaojuan"))
    {
      paramString = e.f.kkj;
      i = e.f.aKo();
      AppMethodBeat.o(198829);
      return i;
    }
    AppMethodBeat.o(198829);
    return -1;
  }
  
  /* Error */
  private static void a(android.content.res.AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 154
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 156
    //   10: new 64	java/lang/StringBuilder
    //   13: dup
    //   14: ldc 158
    //   16: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 163
    //   25: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_2
    //   29: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 174	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   43: astore 6
    //   45: aload 6
    //   47: ifnonnull +9 -> 56
    //   50: ldc 154
    //   52: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: aload 6
    //   58: ldc 176
    //   60: invokestatic 180	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   63: aload 6
    //   65: arraylength
    //   66: ifne +95 -> 161
    //   69: iconst_1
    //   70: istore_3
    //   71: iload_3
    //   72: ifeq +137 -> 209
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual 184	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   80: checkcast 186	java/io/Closeable
    //   83: astore 6
    //   85: aload 6
    //   87: checkcast 188	java/io/InputStream
    //   90: astore_0
    //   91: aload_2
    //   92: invokestatic 194	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   95: checkcast 186	java/io/Closeable
    //   98: astore_2
    //   99: aload_2
    //   100: checkcast 196	java/io/OutputStream
    //   103: astore_1
    //   104: aload_0
    //   105: ldc 198
    //   107: invokestatic 180	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   110: aload_1
    //   111: ldc 200
    //   113: invokestatic 180	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   116: aload_0
    //   117: aload_1
    //   118: invokestatic 206	kotlin/f/a:g	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   121: pop2
    //   122: aload_2
    //   123: aconst_null
    //   124: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   127: aload 6
    //   129: aconst_null
    //   130: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   133: ldc 154
    //   135: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: return
    //   139: astore_0
    //   140: ldc 156
    //   142: aload_0
    //   143: checkcast 153	java/lang/Throwable
    //   146: ldc 212
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: ldc 154
    //   157: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: return
    //   161: iconst_0
    //   162: istore_3
    //   163: goto -92 -> 71
    //   166: astore_1
    //   167: ldc 154
    //   169: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_1
    //   173: athrow
    //   174: astore_0
    //   175: aload_2
    //   176: aload_1
    //   177: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   180: ldc 154
    //   182: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload_0
    //   186: athrow
    //   187: astore_1
    //   188: ldc 154
    //   190: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload_1
    //   194: athrow
    //   195: astore_0
    //   196: aload 6
    //   198: aload_1
    //   199: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   202: ldc 154
    //   204: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload_0
    //   208: athrow
    //   209: aload_2
    //   210: invokestatic 220	com/tencent/mm/vfs/u:bBD	(Ljava/lang/String;)Z
    //   213: pop
    //   214: aload 6
    //   216: arraylength
    //   217: istore 4
    //   219: iconst_0
    //   220: istore_3
    //   221: iload_3
    //   222: iload 4
    //   224: if_icmpge +68 -> 292
    //   227: aload 6
    //   229: iload_3
    //   230: aaload
    //   231: astore 5
    //   233: aload_0
    //   234: new 64	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   241: aload_1
    //   242: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: bipush 47
    //   247: invokevirtual 223	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   250: aload 5
    //   252: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: new 64	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   265: aload_2
    //   266: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: bipush 47
    //   271: invokevirtual 223	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   274: aload 5
    //   276: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 225	com/tencent/mm/live/core/d/a:a	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V
    //   285: iload_3
    //   286: iconst_1
    //   287: iadd
    //   288: istore_3
    //   289: goto -68 -> 221
    //   292: ldc 154
    //   294: invokestatic 90	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: return
    //   298: astore_0
    //   299: aload 5
    //   301: astore_1
    //   302: goto -106 -> 196
    //   305: astore_0
    //   306: aconst_null
    //   307: astore_1
    //   308: goto -133 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramAssetManager	android.content.res.AssetManager
    //   0	311	1	paramString1	String
    //   0	311	2	paramString2	String
    //   70	219	3	i	int
    //   217	8	4	j	int
    //   1	299	5	str	String
    //   43	185	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   38	45	139	java/lang/Exception
    //   50	55	139	java/lang/Exception
    //   56	69	139	java/lang/Exception
    //   75	85	139	java/lang/Exception
    //   127	138	139	java/lang/Exception
    //   196	209	139	java/lang/Exception
    //   209	219	139	java/lang/Exception
    //   233	285	139	java/lang/Exception
    //   99	122	166	java/lang/Throwable
    //   167	174	174	finally
    //   85	99	187	java/lang/Throwable
    //   122	127	187	java/lang/Throwable
    //   175	187	187	java/lang/Throwable
    //   188	195	195	finally
    //   85	99	298	finally
    //   122	127	298	finally
    //   175	187	298	finally
    //   99	122	305	finally
  }
  
  public static HashMap<Integer, String> aNl()
  {
    return ksR;
  }
  
  public static void aNm()
  {
    AppMethodBeat.i(198796);
    d.h((kotlin.g.a.a)b.ksT);
    AppMethodBeat.o(198796);
  }
  
  public static String tB(int paramInt)
  {
    AppMethodBeat.i(198817);
    Object localObject = e.f.kkj;
    if (paramInt == e.f.aKj())
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(a.f.finder_live_filter_default);
      p.j(localObject, "MMApplicationContext.get…nder_live_filter_default)");
      AppMethodBeat.o(198817);
      return localObject;
    }
    localObject = e.f.kkj;
    if (paramInt == e.f.aKk())
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(a.f.finder_live_filter_baixi);
      p.j(localObject, "MMApplicationContext.get…finder_live_filter_baixi)");
      AppMethodBeat.o(198817);
      return localObject;
    }
    localObject = e.f.kkj;
    if (paramInt == e.f.aKq())
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(a.f.finder_live_filter_huaijiu);
      p.j(localObject, "MMApplicationContext.get…nder_live_filter_huaijiu)");
      AppMethodBeat.o(198817);
      return localObject;
    }
    localObject = e.f.kkj;
    if (paramInt == e.f.aKl())
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(a.f.finder_live_filter_qiuri);
      p.j(localObject, "MMApplicationContext.get…finder_live_filter_qiuri)");
      AppMethodBeat.o(198817);
      return localObject;
    }
    localObject = e.f.kkj;
    if (paramInt == e.f.aKm())
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(a.f.finder_live_filter_meishi);
      p.j(localObject, "MMApplicationContext.get…inder_live_filter_meishi)");
      AppMethodBeat.o(198817);
      return localObject;
    }
    localObject = e.f.kkj;
    if (paramInt == e.f.aKn())
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(a.f.finder_live_filter_fanchaleng);
      p.j(localObject, "MMApplicationContext.get…r_live_filter_fanchaleng)");
      AppMethodBeat.o(198817);
      return localObject;
    }
    localObject = e.f.kkj;
    if (paramInt == e.f.aKp())
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(a.f.finder_live_filter_gangfeng);
      p.j(localObject, "MMApplicationContext.get…der_live_filter_gangfeng)");
      AppMethodBeat.o(198817);
      return localObject;
    }
    localObject = e.f.kkj;
    if (paramInt == e.f.aKo())
    {
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getString(a.f.finder_live_filter_jiaojuan);
      p.j(localObject, "MMApplicationContext.get…der_live_filter_jiaojuan)");
      AppMethodBeat.o(198817);
      return localObject;
    }
    AppMethodBeat.o(198817);
    return "";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/util/LiveFilterUtil$FilterInfo;", "", "key", "", "path", "", "title", "value", "(ILjava/lang/String;Ljava/lang/String;I)V", "getKey", "()I", "getPath", "()Ljava/lang/String;", "getTitle", "getValue", "setValue", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "plugin-core_release"})
  public static final class a
  {
    public final int key;
    public final String path;
    public final String title;
    public int value;
    
    public a(int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(200350);
      this.key = paramInt1;
      this.path = paramString1;
      this.title = paramString2;
      this.value = paramInt2;
      AppMethodBeat.o(200350);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(200358);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.key != paramObject.key) || (!p.h(this.path, paramObject.path)) || (!p.h(this.title, paramObject.title)) || (this.value != paramObject.value)) {}
        }
      }
      else
      {
        AppMethodBeat.o(200358);
        return true;
      }
      AppMethodBeat.o(200358);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(200357);
      int k = this.key;
      String str = this.path;
      if (str != null) {}
      for (int i = str.hashCode();; i = 0)
      {
        str = this.title;
        if (str != null) {
          j = str.hashCode();
        }
        int m = this.value;
        AppMethodBeat.o(200357);
        return ((i + k * 31) * 31 + j) * 31 + m;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200355);
      String str = "FilterInfo(key=" + this.key + ", path=" + this.path + ", title=" + this.title + ", value=" + this.value + ")";
      AppMethodBeat.o(200355);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final b ksT;
    
    static
    {
      AppMethodBeat.i(200173);
      ksT = new b();
      AppMethodBeat.o(200173);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.d.a
 * JD-Core Version:    0.7.0.1
 */