package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReporter;", "", "()V", "TAG", "", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmKv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmKv$delegate", "Lkotlin/Lazy;", "sMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "Lkotlin/collections/HashMap;", "get", "appId", "init", "", "resotre", "save", "uninit", "luggage-wechat-full-sdk_release"})
public final class z
{
  private static final HashMap<String, y> nBe;
  private static final f nBf;
  public static final z nBg;
  
  static
  {
    AppMethodBeat.i(169650);
    nBg = new z();
    nBe = new HashMap();
    nBf = g.ah((a)z.a.nBh);
    AppMethodBeat.o(169650);
  }
  
  private static MultiProcessMMKV bTA()
  {
    AppMethodBeat.i(169651);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)nBf.getValue();
    AppMethodBeat.o(169651);
    return localMultiProcessMMKV;
  }
  
  public final void aev(String paramString)
  {
    try
    {
      AppMethodBeat.i(169653);
      p.h(paramString, "appId");
      y localy = aex(paramString);
      if (localy != null) {
        bTA().putString(paramString, localy.toString()).commit();
      }
      AppMethodBeat.o(169653);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void aew(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 121
    //   4: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 91
    //   10: invokestatic 97	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: invokestatic 103	com/tencent/mm/plugin/appbrand/phonenumber/z:bTA	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   16: aload_1
    //   17: ldc 122
    //   19: invokevirtual 126	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 4
    //   24: aload 4
    //   26: astore_3
    //   27: aload 4
    //   29: ifnonnull +6 -> 35
    //   32: ldc 128
    //   34: astore_3
    //   35: aload_3
    //   36: ldc 130
    //   38: invokestatic 133	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   41: aload_3
    //   42: checkcast 135	java/lang/CharSequence
    //   45: invokeinterface 139 1 0
    //   50: ifle +40 -> 90
    //   53: iconst_1
    //   54: istore_2
    //   55: iload_2
    //   56: ifeq +26 -> 82
    //   59: new 105	com/tencent/mm/plugin/appbrand/phonenumber/y
    //   62: dup
    //   63: aload_3
    //   64: invokespecial 141	com/tencent/mm/plugin/appbrand/phonenumber/y:<init>	(Ljava/lang/String;)V
    //   67: astore_3
    //   68: getstatic 56	com/tencent/mm/plugin/appbrand/phonenumber/z:nBe	Ljava/util/HashMap;
    //   71: checkcast 143	java/util/Map
    //   74: aload_1
    //   75: aload_3
    //   76: invokeinterface 147 3 0
    //   81: pop
    //   82: ldc 121
    //   84: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_0
    //   88: monitorexit
    //   89: return
    //   90: iconst_0
    //   91: istore_2
    //   92: goto -37 -> 55
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	z
    //   0	100	1	paramString	String
    //   54	38	2	i	int
    //   26	50	3	localObject	Object
    //   22	6	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	24	95	finally
    //   35	53	95	finally
    //   59	82	95	finally
    //   82	87	95	finally
  }
  
  public final y aex(String paramString)
  {
    try
    {
      AppMethodBeat.i(169655);
      p.h(paramString, "appId");
      paramString = (y)nBe.get(paramString);
      AppMethodBeat.o(169655);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final void aey(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 153
    //   4: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 91
    //   10: invokestatic 97	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 155	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 157
    //   19: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: astore_3
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 101	com/tencent/mm/plugin/appbrand/phonenumber/z:aex	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/phonenumber/y;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +50 -> 80
    //   33: aload_2
    //   34: invokevirtual 109	com/tencent/mm/plugin/appbrand/phonenumber/y:toString	()Ljava/lang/String;
    //   37: astore_2
    //   38: ldc 160
    //   40: aload_3
    //   41: aload_2
    //   42: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: getstatic 56	com/tencent/mm/plugin/appbrand/phonenumber/z:nBe	Ljava/util/HashMap;
    //   54: aload_1
    //   55: invokevirtual 174	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: invokestatic 103	com/tencent/mm/plugin/appbrand/phonenumber/z:bTA	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   62: aload_1
    //   63: invokevirtual 177	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:remove	(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   66: invokeinterface 119 1 0
    //   71: pop
    //   72: ldc 153
    //   74: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: aconst_null
    //   81: astore_2
    //   82: goto -44 -> 38
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	z
    //   0	90	1	paramString	String
    //   28	54	2	localObject	Object
    //   22	19	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	29	85	finally
    //   33	38	85	finally
    //   38	77	85	finally
  }
  
  public final void init(String paramString)
  {
    try
    {
      AppMethodBeat.i(169652);
      p.h(paramString, "appId");
      y localy = new y((byte)0);
      ((Map)nBe).put(paramString, localy);
      AppMethodBeat.o(169652);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.z
 * JD-Core Version:    0.7.0.1
 */