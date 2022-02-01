package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import d.g.a.a;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadWAFileSync;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "Companion", "luggage-wechat-full-sdk_release"})
public final class y
  extends com.tencent.mm.plugin.appbrand.jsapi.y<d>
{
  public static final int CTRL_INDEX = -1;
  private static final String NAME = "loadWAFileSync";
  public static final a kQd;
  
  static
  {
    AppMethodBeat.i(220968);
    kQd = new a((byte)0);
    AppMethodBeat.o(220968);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadWAFileSync$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "invokeSync", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "TAG", "data", "Lorg/json/JSONObject;", "invokeSync$luggage_wechat_full_sdk_release", "toDirectByteBuffer", "Ljava/nio/ByteBuffer;", "Ljava/io/InputStream;", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    /* Error */
    public static m.a a(d paramd, final String paramString, final org.json.JSONObject paramJSONObject)
    {
      // Byte code:
      //   0: ldc 44
      //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: ldc 52
      //   8: invokestatic 58	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: aload_1
      //   12: ldc 59
      //   14: invokestatic 58	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   17: aload_2
      //   18: ifnull +90 -> 108
      //   21: aload_2
      //   22: ldc 61
      //   24: invokevirtual 67	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   27: astore_2
      //   28: aload_1
      //   29: new 69	java/lang/StringBuilder
      //   32: dup
      //   33: ldc 71
      //   35: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   38: aload_2
      //   39: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   42: ldc 80
      //   44: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: aload_0
      //   48: invokevirtual 86	com/tencent/mm/plugin/appbrand/d:getAppId	()Ljava/lang/String;
      //   51: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   54: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   57: invokestatic 94	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   60: aload_2
      //   61: checkcast 96	java/lang/CharSequence
      //   64: astore 4
      //   66: aload 4
      //   68: ifnull +13 -> 81
      //   71: aload 4
      //   73: invokeinterface 100 1 0
      //   78: ifne +35 -> 113
      //   81: iconst_1
      //   82: istore_3
      //   83: iload_3
      //   84: ifeq +34 -> 118
      //   87: new 102	com/tencent/mm/plugin/appbrand/jsapi/m$a
      //   90: dup
      //   91: ldc 104
      //   93: iconst_0
      //   94: anewarray 4	java/lang/Object
      //   97: invokespecial 107	com/tencent/mm/plugin/appbrand/jsapi/m$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   100: astore_0
      //   101: ldc 44
      //   103: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   106: aload_0
      //   107: areturn
      //   108: aconst_null
      //   109: astore_2
      //   110: goto -82 -> 28
      //   113: iconst_0
      //   114: istore_3
      //   115: goto -32 -> 83
      //   118: aload_0
      //   119: invokevirtual 114	com/tencent/mm/plugin/appbrand/d:aWe	()Lcom/tencent/mm/plugin/appbrand/appstorage/ICommLibReader;
      //   122: astore 4
      //   124: aload 4
      //   126: ifnonnull +31 -> 157
      //   129: new 11	com/tencent/mm/plugin/appbrand/jsapi/file/y$a$b
      //   132: dup
      //   133: aload_0
      //   134: aload_1
      //   135: invokespecial 117	com/tencent/mm/plugin/appbrand/jsapi/file/y$a$b:<init>	(Lcom/tencent/mm/plugin/appbrand/d;Ljava/lang/String;)V
      //   138: checkcast 119	d/g/a/a
      //   141: invokeinterface 123 1 0
      //   146: checkcast 102	com/tencent/mm/plugin/appbrand/jsapi/m$a
      //   149: astore_0
      //   150: ldc 44
      //   152: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   155: aload_0
      //   156: areturn
      //   157: aload 4
      //   159: ldc 125
      //   161: invokestatic 128	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   164: aload 4
      //   166: aload_2
      //   167: invokeinterface 134 2 0
      //   172: astore 4
      //   174: aload 4
      //   176: ifnull +131 -> 307
      //   179: aload 4
      //   181: checkcast 136	java/io/Closeable
      //   184: astore_2
      //   185: aload_2
      //   186: checkcast 138	java/io/InputStream
      //   189: astore_0
      //   190: getstatic 142	com/tencent/mm/plugin/appbrand/jsapi/file/y:kQd	Lcom/tencent/mm/plugin/appbrand/jsapi/file/y$a;
      //   193: astore_1
      //   194: aload_0
      //   195: ldc 144
      //   197: invokestatic 128	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   200: aload_0
      //   201: invokevirtual 147	java/io/InputStream:available	()I
      //   204: invokestatic 153	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
      //   207: astore_1
      //   208: aload_0
      //   209: instanceof 155
      //   212: ifeq +59 -> 271
      //   215: aload_1
      //   216: aload_0
      //   217: checkcast 155	com/tencent/luggage/h/a
      //   220: invokevirtual 159	com/tencent/luggage/h/a:Fw	()Ljava/nio/ByteBuffer;
      //   223: invokevirtual 163	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
      //   226: pop
      //   227: aload_1
      //   228: ldc 165
      //   230: invokestatic 128	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   233: new 102	com/tencent/mm/plugin/appbrand/jsapi/m$a
      //   236: dup
      //   237: ldc 167
      //   239: iconst_1
      //   240: anewarray 4	java/lang/Object
      //   243: dup
      //   244: iconst_0
      //   245: ldc 169
      //   247: aload_1
      //   248: invokestatic 175	d/u:R	(Ljava/lang/Object;Ljava/lang/Object;)Ld/o;
      //   251: invokestatic 181	d/a/ae:c	(Ld/o;)Ljava/util/Map;
      //   254: aastore
      //   255: invokespecial 107	com/tencent/mm/plugin/appbrand/jsapi/m$a:<init>	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   258: astore_0
      //   259: aload_2
      //   260: aconst_null
      //   261: invokestatic 186	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   264: ldc 44
      //   266: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   269: aload_0
      //   270: areturn
      //   271: aload_1
      //   272: aload_0
      //   273: invokestatic 192	com/tencent/mm/plugin/appbrand/y/d:I	(Ljava/io/InputStream;)[B
      //   276: invokestatic 196	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
      //   279: invokevirtual 163	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
      //   282: pop
      //   283: goto -56 -> 227
      //   286: astore_1
      //   287: ldc 44
      //   289: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   292: aload_1
      //   293: athrow
      //   294: astore_0
      //   295: aload_2
      //   296: aload_1
      //   297: invokestatic 186	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   300: ldc 44
      //   302: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   305: aload_0
      //   306: athrow
      //   307: new 9	com/tencent/mm/plugin/appbrand/jsapi/file/y$a$a
      //   310: dup
      //   311: aload_0
      //   312: aload_1
      //   313: aload_2
      //   314: invokespecial 199	com/tencent/mm/plugin/appbrand/jsapi/file/y$a$a:<init>	(Lcom/tencent/mm/plugin/appbrand/d;Ljava/lang/String;Ljava/lang/String;)V
      //   317: checkcast 119	d/g/a/a
      //   320: invokeinterface 123 1 0
      //   325: checkcast 102	com/tencent/mm/plugin/appbrand/jsapi/m$a
      //   328: astore_0
      //   329: ldc 44
      //   331: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   334: aload_0
      //   335: areturn
      //   336: astore_0
      //   337: aconst_null
      //   338: astore_1
      //   339: goto -44 -> 295
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	342	0	paramd	d
      //   0	342	1	paramString	String
      //   0	342	2	paramJSONObject	org.json.JSONObject
      //   82	33	3	i	int
      //   64	116	4	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   185	227	286	java/lang/Throwable
      //   227	259	286	java/lang/Throwable
      //   271	283	286	java/lang/Throwable
      //   287	294	294	finally
      //   185	227	336	finally
      //   227	259	336	finally
      //   271	283	336	finally
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "invoke"})
    static final class a
      extends q
      implements a<m.a>
    {
      a(d paramd, String paramString1, String paramString2)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "invoke"})
    static final class b
      extends q
      implements a<m.a>
    {
      b(d paramd, String paramString)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.y
 * JD-Core Version:    0.7.0.1
 */