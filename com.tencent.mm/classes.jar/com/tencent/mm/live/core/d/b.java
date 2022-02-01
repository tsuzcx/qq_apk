package com.tencent.mm.live.core.d;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.core.a.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/util/LiveFilterUtil;", "", "()V", "ASSETS_ROOT", "", "FILTERS_PATH", "TAG", "filterCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getFilterCache", "()Ljava/util/HashMap;", "checkFilterPath", "", "checkFiltersPath", "copyAssets", "assets", "Landroid/content/res/AssetManager;", "assetsPath", "localPath", "filterId", "path", "filterName", "filter", "filterPath", "FilterInfo", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b mWI;
  private static final String mWJ;
  private static final HashMap<Integer, String> mWK;
  
  static
  {
    AppMethodBeat.i(247702);
    mWI = new b();
    mWJ = s.X(com.tencent.mm.loader.i.b.bms(), "live/filters");
    mWK = new HashMap();
    AppMethodBeat.o(247702);
  }
  
  public static int Ge(String paramString)
  {
    AppMethodBeat.i(247678);
    if (s.p(paramString, s.X(mWJ, "/ziran")))
    {
      AppMethodBeat.o(247678);
      return 0;
    }
    if (s.p(paramString, s.X(mWJ, "/baixi")))
    {
      AppMethodBeat.o(247678);
      return 1;
    }
    if (s.p(paramString, s.X(mWJ, "/qiuri")))
    {
      AppMethodBeat.o(247678);
      return 7;
    }
    if (s.p(paramString, s.X(mWJ, "/meishi")))
    {
      AppMethodBeat.o(247678);
      return 8;
    }
    if (s.p(paramString, s.X(mWJ, "/fanchaleng")))
    {
      AppMethodBeat.o(247678);
      return 9;
    }
    if (s.p(paramString, s.X(mWJ, "/yuanqi")))
    {
      AppMethodBeat.o(247678);
      return 2;
    }
    if (s.p(paramString, s.X(mWJ, "/fennen")))
    {
      AppMethodBeat.o(247678);
      return 3;
    }
    if (s.p(paramString, s.X(mWJ, "/qingche")))
    {
      AppMethodBeat.o(247678);
      return 4;
    }
    if (s.p(paramString, s.X(mWJ, "/luori")))
    {
      AppMethodBeat.o(247678);
      return 5;
    }
    if (s.p(paramString, s.X(mWJ, "/shensui")))
    {
      AppMethodBeat.o(247678);
      return 6;
    }
    AppMethodBeat.o(247678);
    return -1;
  }
  
  /* Error */
  private static void a(android.content.res.AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 122
    //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 124
    //   7: new 126	java/lang/StringBuilder
    //   10: dup
    //   11: ldc 128
    //   13: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 137
    //   22: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 145	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 151	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   40: astore 5
    //   42: aload 5
    //   44: ifnonnull +9 -> 53
    //   47: ldc 122
    //   49: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: return
    //   53: aload 5
    //   55: arraylength
    //   56: ifne +96 -> 152
    //   59: iconst_1
    //   60: istore_3
    //   61: iload_3
    //   62: ifeq +139 -> 201
    //   65: aload_0
    //   66: aload_1
    //   67: invokevirtual 155	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   70: checkcast 157	java/io/Closeable
    //   73: astore_0
    //   74: aload_0
    //   75: checkcast 159	java/io/InputStream
    //   78: astore 5
    //   80: aload_2
    //   81: iconst_0
    //   82: invokestatic 165	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   85: checkcast 157	java/io/Closeable
    //   88: astore_1
    //   89: aload_1
    //   90: checkcast 167	java/io/OutputStream
    //   93: astore_2
    //   94: aload 5
    //   96: ldc 169
    //   98: invokestatic 173	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   101: aload_2
    //   102: ldc 175
    //   104: invokestatic 173	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   107: aload 5
    //   109: aload_2
    //   110: invokestatic 181	kotlin/f/a:j	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   113: pop2
    //   114: aload_1
    //   115: aconst_null
    //   116: invokestatic 186	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   119: aload_0
    //   120: aconst_null
    //   121: invokestatic 186	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   124: ldc 122
    //   126: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: return
    //   130: astore_0
    //   131: ldc 124
    //   133: aload_0
    //   134: checkcast 188	java/lang/Throwable
    //   137: ldc 189
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: ldc 122
    //   148: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: iconst_0
    //   153: istore_3
    //   154: goto -93 -> 61
    //   157: astore_2
    //   158: ldc 122
    //   160: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload_2
    //   164: athrow
    //   165: astore 5
    //   167: aload_1
    //   168: aload_2
    //   169: invokestatic 186	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   172: ldc 122
    //   174: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload 5
    //   179: athrow
    //   180: astore_1
    //   181: ldc 122
    //   183: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_1
    //   187: athrow
    //   188: astore_2
    //   189: aload_0
    //   190: aload_1
    //   191: invokestatic 186	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   194: ldc 122
    //   196: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload_2
    //   200: athrow
    //   201: aload_2
    //   202: invokestatic 197	com/tencent/mm/vfs/y:bDX	(Ljava/lang/String;)Z
    //   205: pop
    //   206: aload 5
    //   208: arraylength
    //   209: istore 4
    //   211: iconst_0
    //   212: istore_3
    //   213: iload_3
    //   214: iload 4
    //   216: if_icmpge +68 -> 284
    //   219: aload 5
    //   221: iload_3
    //   222: aaload
    //   223: astore 6
    //   225: aload_0
    //   226: new 126	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   233: aload_1
    //   234: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: bipush 47
    //   239: invokevirtual 201	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   242: aload 6
    //   244: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: new 126	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   257: aload_2
    //   258: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: bipush 47
    //   263: invokevirtual 201	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   266: aload 6
    //   268: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 206	com/tencent/mm/live/core/d/b:a	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;)V
    //   277: iload_3
    //   278: iconst_1
    //   279: iadd
    //   280: istore_3
    //   281: goto -68 -> 213
    //   284: ldc 122
    //   286: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	paramAssetManager	android.content.res.AssetManager
    //   0	290	1	paramString1	String
    //   0	290	2	paramString2	String
    //   60	221	3	i	int
    //   209	8	4	j	int
    //   40	68	5	localObject1	Object
    //   165	55	5	localObject2	Object
    //   223	44	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   35	42	130	java/lang/Exception
    //   47	52	130	java/lang/Exception
    //   53	59	130	java/lang/Exception
    //   65	74	130	java/lang/Exception
    //   119	129	130	java/lang/Exception
    //   189	201	130	java/lang/Exception
    //   201	211	130	java/lang/Exception
    //   225	277	130	java/lang/Exception
    //   89	114	157	finally
    //   158	165	165	finally
    //   74	89	180	finally
    //   114	119	180	finally
    //   167	180	180	finally
    //   181	188	188	finally
  }
  
  public static HashMap<Integer, String> bgW()
  {
    return mWK;
  }
  
  public static void bgX()
  {
    AppMethodBeat.i(247640);
    d.B((a)b.mWL);
    AppMethodBeat.o(247640);
  }
  
  public static String tw(int paramInt)
  {
    AppMethodBeat.i(247666);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(247666);
      return "";
    case 0: 
      str = MMApplicationContext.getContext().getResources().getString(a.g.finder_live_filter_default);
      s.s(str, "{\n                MMAppl…er_default)\n            }");
      AppMethodBeat.o(247666);
      return str;
    case 1: 
      str = MMApplicationContext.getContext().getResources().getString(a.g.finder_live_filter_baixi);
      s.s(str, "{\n                MMAppl…lter_baixi)\n            }");
      AppMethodBeat.o(247666);
      return str;
    case 7: 
      str = MMApplicationContext.getContext().getResources().getString(a.g.finder_live_filter_qiuri);
      s.s(str, "{\n                MMAppl…lter_qiuri)\n            }");
      AppMethodBeat.o(247666);
      return str;
    case 8: 
      str = MMApplicationContext.getContext().getResources().getString(a.g.finder_live_filter_meishi);
      s.s(str, "{\n                MMAppl…ter_meishi)\n            }");
      AppMethodBeat.o(247666);
      return str;
    case 9: 
      str = MMApplicationContext.getContext().getResources().getString(a.g.finder_live_filter_fanchaleng);
      s.s(str, "{\n                MMAppl…fanchaleng)\n            }");
      AppMethodBeat.o(247666);
      return str;
    case 2: 
      str = MMApplicationContext.getContext().getResources().getString(a.g.finder_live_filter_yuanqi);
      s.s(str, "{\n                MMAppl…ter_yuanqi)\n            }");
      AppMethodBeat.o(247666);
      return str;
    case 3: 
      str = MMApplicationContext.getContext().getResources().getString(a.g.finder_live_filter_fennen);
      s.s(str, "{\n                MMAppl…ter_fennen)\n            }");
      AppMethodBeat.o(247666);
      return str;
    case 4: 
      str = MMApplicationContext.getContext().getResources().getString(a.g.finder_live_filter_qingche);
      s.s(str, "{\n                MMAppl…er_qingche)\n            }");
      AppMethodBeat.o(247666);
      return str;
    case 5: 
      str = MMApplicationContext.getContext().getResources().getString(a.g.finder_live_filter_luori);
      s.s(str, "{\n                MMAppl…lter_luori)\n            }");
      AppMethodBeat.o(247666);
      return str;
    }
    String str = MMApplicationContext.getContext().getResources().getString(a.g.finder_live_filter_shensui);
    s.s(str, "{\n                MMAppl…er_shensui)\n            }");
    AppMethodBeat.o(247666);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    public static final b mWL;
    
    static
    {
      AppMethodBeat.i(247630);
      mWL = new b();
      AppMethodBeat.o(247630);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.d.b
 * JD-Core Version:    0.7.0.1
 */