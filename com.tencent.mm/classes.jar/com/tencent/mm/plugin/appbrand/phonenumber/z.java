package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ax;
import d.f;
import d.g;
import d.g.a.a;
import d.g.b.u;
import d.g.b.w;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReporter;", "", "()V", "TAG", "", "mmKv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getMmKv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmKv$delegate", "Lkotlin/Lazy;", "sMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "Lkotlin/collections/HashMap;", "get", "appId", "init", "", "resotre", "save", "uninit", "luggage-wechat-full-sdk_release"})
public final class z
{
  private static final HashMap<String, y> llQ;
  private static final f llR;
  public static final z llS;
  
  static
  {
    AppMethodBeat.i(169650);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(z.class), "mmKv", "getMmKv()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;")) };
    llS = new z();
    llQ = new HashMap();
    llR = g.E((a)z.a.llT);
    AppMethodBeat.o(169650);
  }
  
  private static ax blF()
  {
    AppMethodBeat.i(169651);
    ax localax = (ax)llR.getValue();
    AppMethodBeat.o(169651);
    return localax;
  }
  
  public final void Kx(String paramString)
  {
    try
    {
      AppMethodBeat.i(169652);
      d.g.b.k.h(paramString, "appId");
      y localy = new y((byte)0);
      ((Map)llQ).put(paramString, localy);
      AppMethodBeat.o(169652);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void Ml(String paramString)
  {
    try
    {
      AppMethodBeat.i(169653);
      d.g.b.k.h(paramString, "appId");
      y localy = Mn(paramString);
      if (localy != null) {
        blF().putString(paramString, localy.toString()).commit();
      }
      AppMethodBeat.o(169653);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void Mm(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 157
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 116
    //   10: invokestatic 122	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: invokestatic 141	com/tencent/mm/plugin/appbrand/phonenumber/z:blF	()Lcom/tencent/mm/sdk/platformtools/ax;
    //   16: aload_1
    //   17: ldc 158
    //   19: invokevirtual 162	com/tencent/mm/sdk/platformtools/ax:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 4
    //   24: aload 4
    //   26: astore_3
    //   27: aload 4
    //   29: ifnonnull +6 -> 35
    //   32: ldc 164
    //   34: astore_3
    //   35: aload_3
    //   36: ldc 166
    //   38: invokestatic 169	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   41: aload_3
    //   42: checkcast 171	java/lang/CharSequence
    //   45: invokeinterface 175 1 0
    //   50: ifle +40 -> 90
    //   53: iconst_1
    //   54: istore_2
    //   55: iload_2
    //   56: ifeq +26 -> 82
    //   59: new 124	com/tencent/mm/plugin/appbrand/phonenumber/y
    //   62: dup
    //   63: aload_3
    //   64: invokespecial 177	com/tencent/mm/plugin/appbrand/phonenumber/y:<init>	(Ljava/lang/String;)V
    //   67: astore_3
    //   68: getstatic 80	com/tencent/mm/plugin/appbrand/phonenumber/z:llQ	Ljava/util/HashMap;
    //   71: checkcast 129	java/util/Map
    //   74: aload_1
    //   75: aload_3
    //   76: invokeinterface 133 3 0
    //   81: pop
    //   82: ldc 157
    //   84: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final y Mn(String paramString)
  {
    try
    {
      AppMethodBeat.i(169655);
      d.g.b.k.h(paramString, "appId");
      paramString = (y)llQ.get(paramString);
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
  public final void Mo(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 183
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 116
    //   10: invokestatic 122	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 185	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 187
    //   19: invokespecial 188	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: astore_3
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 139	com/tencent/mm/plugin/appbrand/phonenumber/z:Mn	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/phonenumber/y;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +50 -> 80
    //   33: aload_2
    //   34: invokevirtual 145	com/tencent/mm/plugin/appbrand/phonenumber/y:toString	()Ljava/lang/String;
    //   37: astore_2
    //   38: ldc 190
    //   40: aload_3
    //   41: aload_2
    //   42: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 201	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: getstatic 80	com/tencent/mm/plugin/appbrand/phonenumber/z:llQ	Ljava/util/HashMap;
    //   54: aload_1
    //   55: invokevirtual 204	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: invokestatic 141	com/tencent/mm/plugin/appbrand/phonenumber/z:blF	()Lcom/tencent/mm/sdk/platformtools/ax;
    //   62: aload_1
    //   63: invokevirtual 207	com/tencent/mm/sdk/platformtools/ax:remove	(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   66: invokeinterface 155 1 0
    //   71: pop
    //   72: ldc 183
    //   74: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.z
 * JD-Core Version:    0.7.0.1
 */