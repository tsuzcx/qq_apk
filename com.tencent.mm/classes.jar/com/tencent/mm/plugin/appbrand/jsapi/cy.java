package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.n;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class cy
{
  /* Error */
  public static String C(String paramString1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: astore_3
    //   7: aload_1
    //   8: invokestatic 21	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   11: ifeq +6 -> 17
    //   14: ldc 23
    //   16: astore_3
    //   17: getstatic 29	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   20: astore 4
    //   22: iload_2
    //   23: ifne +43 -> 66
    //   26: ldc 31
    //   28: astore_1
    //   29: aload 4
    //   31: ldc 33
    //   33: iconst_4
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_0
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: aload_3
    //   44: aastore
    //   45: dup
    //   46: iconst_2
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_3
    //   51: invokestatic 37	com/tencent/mm/plugin/appbrand/jsapi/cy:aGk	()Ljava/lang/String;
    //   54: aastore
    //   55: invokestatic 43	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   58: astore_1
    //   59: ldc 9
    //   61: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_1
    //   65: areturn
    //   66: iload_2
    //   67: invokestatic 50	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   70: astore_1
    //   71: goto -42 -> 29
    //   74: astore_1
    //   75: getstatic 29	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   78: ldc 52
    //   80: iconst_3
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_1
    //   87: invokevirtual 55	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: aload_0
    //   94: aastore
    //   95: dup
    //   96: iconst_2
    //   97: aload_3
    //   98: invokestatic 59	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokevirtual 63	java/lang/String:length	()I
    //   104: invokestatic 68	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   107: aastore
    //   108: invokestatic 43	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   111: astore_0
    //   112: ldc 70
    //   114: ldc 72
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_0
    //   123: aastore
    //   124: invokestatic 78	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: new 8	java/lang/OutOfMemoryError
    //   130: dup
    //   131: aload_0
    //   132: invokespecial 82	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   135: astore_0
    //   136: ldc 9
    //   138: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString1	String
    //   0	143	1	paramString2	String
    //   0	143	2	paramInt	int
    //   6	92	3	str	String
    //   20	10	4	localLocale	java.util.Locale
    // Exception table:
    //   from	to	target	type
    //   17	22	74	java/lang/OutOfMemoryError
    //   29	59	74	java/lang/OutOfMemoryError
  }
  
  public static void a(o paramo, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(210035);
    if ((paramo instanceof i))
    {
      n localn = (n)((i)paramo).Q(n.class);
      if (localn != null)
      {
        localn.subscribeHandler(paramString1, paramString2, paramInt, aGk());
        AppMethodBeat.o(210035);
        return;
      }
    }
    paramo.evaluateJavascript(C(paramString1, paramString2, paramInt), null);
    AppMethodBeat.o(210035);
  }
  
  public static String aGk()
  {
    AppMethodBeat.i(140650);
    try
    {
      String str = new JSONObject().put("nativeTime", System.currentTimeMillis()).toString();
      AppMethodBeat.o(140650);
      return str;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.JsScriptEvaluator", "makeExtStatJson e = %s", new Object[] { localException });
      AppMethodBeat.o(140650);
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cy
 * JD-Core Version:    0.7.0.1
 */