package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReporter;", "", "()V", "TAG", "", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmKv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmKv$delegate", "Lkotlin/Lazy;", "sMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "Lkotlin/collections/HashMap;", "get", "appId", "init", "", "resotre", "save", "uninit", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
{
  public static final z tIm;
  private static final HashMap<String, y> tIn;
  private static final j tIo;
  
  static
  {
    AppMethodBeat.i(169650);
    tIm = new z();
    tIn = new HashMap();
    tIo = k.cm((a)z.a.tIp);
    AppMethodBeat.o(169650);
  }
  
  private static MultiProcessMMKV cHC()
  {
    AppMethodBeat.i(169651);
    Object localObject = tIo.getValue();
    s.s(localObject, "<get-mmKv>(...)");
    localObject = (MultiProcessMMKV)localObject;
    AppMethodBeat.o(169651);
    return localObject;
  }
  
  public final void afB(String paramString)
  {
    try
    {
      AppMethodBeat.i(169653);
      s.u(paramString, "appId");
      y localy = afD(paramString);
      if (localy != null) {
        cHC().putString(paramString, localy.toString()).commit();
      }
      AppMethodBeat.o(169653);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void afC(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 129
    //   4: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 102
    //   10: invokestatic 105	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: invokestatic 111	com/tencent/mm/plugin/appbrand/phonenumber/z:cHC	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   16: aload_1
    //   17: ldc 130
    //   19: invokevirtual 134	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 4
    //   24: aload 4
    //   26: astore_3
    //   27: aload 4
    //   29: ifnonnull +6 -> 35
    //   32: ldc 136
    //   34: astore_3
    //   35: aload_3
    //   36: checkcast 138	java/lang/CharSequence
    //   39: invokeinterface 142 1 0
    //   44: ifle +40 -> 84
    //   47: iconst_1
    //   48: istore_2
    //   49: iload_2
    //   50: ifeq +26 -> 76
    //   53: new 113	com/tencent/mm/plugin/appbrand/phonenumber/y
    //   56: dup
    //   57: aload_3
    //   58: invokespecial 144	com/tencent/mm/plugin/appbrand/phonenumber/y:<init>	(Ljava/lang/String;)V
    //   61: astore_3
    //   62: getstatic 59	com/tencent/mm/plugin/appbrand/phonenumber/z:tIn	Ljava/util/HashMap;
    //   65: checkcast 146	java/util/Map
    //   68: aload_1
    //   69: aload_3
    //   70: invokeinterface 150 3 0
    //   75: pop
    //   76: ldc 129
    //   78: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: monitorexit
    //   83: return
    //   84: iconst_0
    //   85: istore_2
    //   86: goto -37 -> 49
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	z
    //   0	94	1	paramString	String
    //   48	38	2	i	int
    //   26	44	3	localObject	Object
    //   22	6	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	24	89	finally
    //   35	47	89	finally
    //   53	76	89	finally
    //   76	81	89	finally
  }
  
  public final y afD(String paramString)
  {
    try
    {
      AppMethodBeat.i(169655);
      s.u(paramString, "appId");
      paramString = (y)tIn.get(paramString);
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
  public final void afE(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 156
    //   4: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 102
    //   10: invokestatic 105	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 109	com/tencent/mm/plugin/appbrand/phonenumber/z:afD	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/phonenumber/y;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnonnull +45 -> 65
    //   23: aconst_null
    //   24: astore_2
    //   25: ldc 158
    //   27: ldc 160
    //   29: aload_2
    //   30: invokestatic 164	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   33: invokestatic 170	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: getstatic 59	com/tencent/mm/plugin/appbrand/phonenumber/z:tIn	Ljava/util/HashMap;
    //   39: aload_1
    //   40: invokevirtual 173	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: invokestatic 111	com/tencent/mm/plugin/appbrand/phonenumber/z:cHC	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   47: aload_1
    //   48: invokevirtual 176	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:remove	(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   51: invokeinterface 127 1 0
    //   56: pop
    //   57: ldc 156
    //   59: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: aload_2
    //   66: invokevirtual 117	com/tencent/mm/plugin/appbrand/phonenumber/y:toString	()Ljava/lang/String;
    //   69: astore_2
    //   70: goto -45 -> 25
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	z
    //   0	78	1	paramString	String
    //   18	52	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	73	finally
    //   25	62	73	finally
    //   65	70	73	finally
  }
  
  public final void init(String paramString)
  {
    try
    {
      AppMethodBeat.i(169652);
      s.u(paramString, "appId");
      y localy = new y();
      ((Map)tIn).put(paramString, localy);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.z
 * JD-Core Version:    0.7.0.1
 */