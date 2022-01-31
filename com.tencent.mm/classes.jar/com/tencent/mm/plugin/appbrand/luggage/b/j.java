package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.e.a.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.io.File;

public final class j
  extends com.tencent.luggage.bridge.impl.a.a
  implements com.tencent.mm.plugin.appbrand.e.b
{
  private final i gRG;
  
  public j(i parami)
  {
    this.gRG = parami;
  }
  
  /* Error */
  public final void a(String paramString, com.tencent.mm.plugin.appbrand.e.a.a parama)
  {
    // Byte code:
    //   0: ldc 21
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_0
    //   6: newarray byte
    //   8: astore 4
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 31	com/tencent/mm/plugin/appbrand/luggage/b/j:match	(Ljava/lang/String;)Z
    //   15: ifeq +161 -> 176
    //   18: aload_0
    //   19: getfield 15	com/tencent/mm/plugin/appbrand/luggage/b/j:gRG	Lcom/tencent/mm/plugin/appbrand/i;
    //   22: invokevirtual 37	com/tencent/mm/plugin/appbrand/i:wX	()Lcom/tencent/mm/plugin/appbrand/appstorage/o;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +149 -> 176
    //   30: aload_3
    //   31: aload_1
    //   32: iconst_0
    //   33: aload_1
    //   34: ldc 39
    //   36: invokevirtual 45	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   39: invokevirtual 49	java/lang/String:substring	(II)Ljava/lang/String;
    //   42: invokeinterface 55 2 0
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +127 -> 176
    //   52: aload_1
    //   53: invokevirtual 61	java/io/File:exists	()Z
    //   56: ifeq +120 -> 176
    //   59: aload_1
    //   60: invokevirtual 65	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   63: astore_3
    //   64: aload_3
    //   65: astore_1
    //   66: aload_3
    //   67: ldc 67
    //   69: invokevirtual 70	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   72: ifne +13 -> 85
    //   75: ldc 67
    //   77: aload_3
    //   78: invokestatic 74	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   81: invokevirtual 78	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_1
    //   85: aload_1
    //   86: invokestatic 84	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   89: astore_3
    //   90: aload_3
    //   91: astore_1
    //   92: aload_3
    //   93: invokestatic 90	com/tencent/luggage/g/i:g	(Ljava/io/InputStream;)[B
    //   96: astore 5
    //   98: aload_3
    //   99: invokestatic 94	com/tencent/luggage/g/i:b	(Ljava/io/Closeable;)V
    //   102: aload 5
    //   104: astore_1
    //   105: aload_2
    //   106: ifnull +10 -> 116
    //   109: aload_2
    //   110: aload_1
    //   111: invokeinterface 100 2 0
    //   116: ldc 21
    //   118: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_3
    //   125: aload_3
    //   126: astore_1
    //   127: ldc 105
    //   129: ldc 107
    //   131: iconst_0
    //   132: anewarray 109	java/lang/Object
    //   135: invokestatic 114	com/tencent/luggage/g/d:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: aload_3
    //   139: invokestatic 94	com/tencent/luggage/g/i:b	(Ljava/io/Closeable;)V
    //   142: aload 4
    //   144: astore_1
    //   145: goto -40 -> 105
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_2
    //   151: aload_2
    //   152: invokestatic 94	com/tencent/luggage/g/i:b	(Ljava/io/Closeable;)V
    //   155: ldc 21
    //   157: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: astore_2
    //   163: aload_1
    //   164: astore_3
    //   165: aload_2
    //   166: astore_1
    //   167: aload_3
    //   168: astore_2
    //   169: goto -18 -> 151
    //   172: astore_1
    //   173: goto -48 -> 125
    //   176: aload 4
    //   178: astore_1
    //   179: goto -74 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	j
    //   0	182	1	paramString	String
    //   0	182	2	parama	com.tencent.mm.plugin.appbrand.e.a.a
    //   25	143	3	localObject	Object
    //   8	169	4	arrayOfByte1	byte[]
    //   96	7	5	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   85	90	122	java/io/FileNotFoundException
    //   85	90	148	finally
    //   92	98	162	finally
    //   127	138	162	finally
    //   92	98	172	java/io/FileNotFoundException
  }
  
  public final boolean a(c paramc, String paramString)
  {
    AppMethodBeat.i(86990);
    if ((paramc == null) || (paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(86990);
      return false;
    }
    boolean bool = paramString.startsWith("wxfile://");
    AppMethodBeat.o(86990);
    return bool;
  }
  
  public final Bitmap b(String paramString, Rect paramRect, a.c paramc)
  {
    paramc = null;
    AppMethodBeat.i(86989);
    if (!match(paramString))
    {
      AppMethodBeat.o(86989);
      return null;
    }
    Object localObject = this.gRG.wX();
    if (localObject == null)
    {
      AppMethodBeat.o(86989);
      return null;
    }
    paramString = ((o)localObject).zg(paramString.substring(0, paramString.lastIndexOf("?appId=")));
    if ((paramString == null) || (!paramString.exists()))
    {
      AppMethodBeat.o(86989);
      return null;
    }
    localObject = paramString.getAbsolutePath();
    paramString = (String)localObject;
    if (!((String)localObject).startsWith("file://")) {
      paramString = "file://".concat(String.valueOf(localObject));
    }
    if (paramRect != null) {
      paramc = new com.tencent.mm.plugin.appbrand.luggage.a.a(paramRect.left, paramRect.top, paramRect.width(), paramRect.height());
    }
    paramString = com.tencent.mm.modelappbrand.a.b.acD().a(paramString, paramc);
    AppMethodBeat.o(86989);
    return paramString;
  }
  
  public final String b(c paramc, String paramString)
  {
    AppMethodBeat.i(86991);
    if (!a(paramc, paramString))
    {
      AppMethodBeat.o(86991);
      return paramString;
    }
    paramc = paramString + "?appId=" + paramc.getAppId();
    AppMethodBeat.o(86991);
    return paramc;
  }
  
  public final boolean match(String paramString)
  {
    AppMethodBeat.i(86988);
    if ((paramString != null) && (paramString.startsWith("wxfile://")))
    {
      AppMethodBeat.o(86988);
      return true;
    }
    AppMethodBeat.o(86988);
    return false;
  }
  
  public final String tX()
  {
    return "WxFileImageReader";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */