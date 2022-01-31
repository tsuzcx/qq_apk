package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  private static final String eak;
  private final Map<b.h, String> eae = new ConcurrentHashMap();
  private final Map<String, b.h> eaf = new ConcurrentHashMap();
  private final Map<Integer, String> eag = new ConcurrentHashMap();
  public final b.d eah = new b.d(new ah(new ai("AppBrandSimpleImageLoaderDiskIOHandlerThread").mnU.getLooper()), (byte)0);
  private final b.i eai = new b.c();
  public final g eaj = new b.a((byte)0);
  
  static
  {
    String str2 = e.bkH;
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    eak = str1;
    h.Vu(str1);
  }
  
  public static b JD()
  {
    return b.l.eaK;
  }
  
  private static String a(String paramString, b.f paramf, e parame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    if (paramf != null)
    {
      localStringBuilder.append("|transformation:");
      localStringBuilder.append(paramf.pU());
    }
    if (parame != null)
    {
      localStringBuilder.append("|decoder:");
      localStringBuilder.append(parame.pU());
    }
    return localStringBuilder.toString();
  }
  
  private static String af(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  public static String jH(String paramString)
  {
    String str = null;
    if (!bk.bl(paramString)) {
      str = g.o(paramString.getBytes());
    }
    return str;
  }
  
  /* Error */
  public final Bitmap a(String paramString, e parame)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 177	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_1
    //   10: aconst_null
    //   11: aload_2
    //   12: invokestatic 169	com/tencent/mm/modelappbrand/a/b:a	(Ljava/lang/String;Lcom/tencent/mm/modelappbrand/a/b$f;Lcom/tencent/mm/modelappbrand/a/b$e;)Ljava/lang/String;
    //   15: astore 5
    //   17: aload_0
    //   18: getfield 99	com/tencent/mm/modelappbrand/a/b:eai	Lcom/tencent/mm/modelappbrand/a/b$i;
    //   21: aload 5
    //   23: invokeinterface 196 2 0
    //   28: astore 4
    //   30: aload 4
    //   32: ifnull +6 -> 38
    //   35: aload 4
    //   37: areturn
    //   38: aload_1
    //   39: ldc 198
    //   41: invokevirtual 201	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   44: istore_3
    //   45: iload_3
    //   46: ifeq +73 -> 119
    //   49: new 203	java/io/FileInputStream
    //   52: dup
    //   53: aload_1
    //   54: ldc 198
    //   56: ldc 205
    //   58: invokevirtual 208	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: invokespecial 209	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   64: astore_1
    //   65: aload_2
    //   66: ifnull +70 -> 136
    //   69: aload_1
    //   70: astore 4
    //   72: aload_2
    //   73: aload_1
    //   74: invokeinterface 212 2 0
    //   79: astore_2
    //   80: aload_2
    //   81: ifnull +18 -> 99
    //   84: aload_1
    //   85: astore 4
    //   87: aload_0
    //   88: getfield 99	com/tencent/mm/modelappbrand/a/b:eai	Lcom/tencent/mm/modelappbrand/a/b$i;
    //   91: aload 5
    //   93: aload_2
    //   94: invokeinterface 215 3 0
    //   99: aload_1
    //   100: invokestatic 218	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   103: aload_2
    //   104: areturn
    //   105: astore_1
    //   106: ldc 220
    //   108: ldc 222
    //   110: invokestatic 227	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aconst_null
    //   114: invokestatic 218	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   117: aconst_null
    //   118: areturn
    //   119: aload_0
    //   120: getfield 104	com/tencent/mm/modelappbrand/a/b:eaj	Lcom/tencent/mm/modelappbrand/a/b$g;
    //   123: aload_1
    //   124: invokestatic 161	com/tencent/mm/modelappbrand/a/b:jH	(Ljava/lang/String;)Ljava/lang/String;
    //   127: invokeinterface 231 2 0
    //   132: astore_1
    //   133: goto -68 -> 65
    //   136: aload_1
    //   137: astore 4
    //   139: aload_1
    //   140: invokestatic 236	com/tencent/mm/sdk/platformtools/c:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   143: astore_2
    //   144: goto -64 -> 80
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: astore 4
    //   153: ldc 220
    //   155: aload_2
    //   156: ldc 238
    //   158: iconst_0
    //   159: anewarray 4	java/lang/Object
    //   162: invokestatic 242	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aload_1
    //   166: invokestatic 218	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_1
    //   172: aconst_null
    //   173: astore 4
    //   175: aload 4
    //   177: invokestatic 218	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: goto -8 -> 175
    //   186: astore_2
    //   187: goto -37 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	b
    //   0	190	1	paramString	String
    //   0	190	2	parame	e
    //   44	2	3	bool	boolean
    //   28	148	4	localObject	Object
    //   15	77	5	str	String
    // Exception table:
    //   from	to	target	type
    //   49	65	105	java/io/FileNotFoundException
    //   38	45	147	java/lang/Exception
    //   49	65	147	java/lang/Exception
    //   106	113	147	java/lang/Exception
    //   119	133	147	java/lang/Exception
    //   38	45	171	finally
    //   49	65	171	finally
    //   106	113	171	finally
    //   119	133	171	finally
    //   72	80	182	finally
    //   87	99	182	finally
    //   139	144	182	finally
    //   153	165	182	finally
    //   72	80	186	java/lang/Exception
    //   87	99	186	java/lang/Exception
    //   139	144	186	java/lang/Exception
  }
  
  public final String a(ImageView paramImageView, String paramString, Drawable paramDrawable, b.f paramf)
  {
    return a(paramImageView, paramString, paramDrawable, paramf, null);
  }
  
  public final String a(ImageView paramImageView, String paramString, Drawable paramDrawable, b.f paramf, e parame)
  {
    if (paramImageView == null) {
      paramString = null;
    }
    Object localObject;
    do
    {
      return paramString;
      if (paramImageView != null)
      {
        localObject = (String)this.eag.get(Integer.valueOf(paramImageView.hashCode()));
        if (localObject != null)
        {
          localObject = (b.h)this.eaf.get(localObject);
          if (localObject != null)
          {
            localObject = (String)this.eae.get(localObject);
            if (!bk.bl((String)localObject)) {
              this.eaf.remove(localObject);
            }
          }
        }
      }
      if (bk.bl(paramString))
      {
        if (paramDrawable != null) {
          paramImageView.setImageDrawable(paramDrawable);
        }
        return null;
      }
      localObject = new b.2(this, paramImageView, this, paramDrawable);
      paramDrawable = a((b.h)localObject, paramString, paramf, parame);
      paramString = paramDrawable;
    } while (((b.j)localObject).eaz);
    this.eag.put(Integer.valueOf(paramImageView.hashCode()), af(((b.j)localObject).key, paramDrawable));
    return paramDrawable;
  }
  
  public final String a(b.h paramh, String paramString, b.f paramf)
  {
    return a(paramh, paramString, paramf, null);
  }
  
  public final String a(b.h paramh, String paramString, b.f paramf, e parame)
  {
    if (paramh == null) {
      return null;
    }
    if (bk.bl(paramString))
    {
      paramh.JH();
      return null;
    }
    y.d("MicroMsg.AppBrandSimpleImageLoader", "load before start LoadTask url %s", new Object[] { paramString });
    parame = new b.k(paramString, paramf, this, this.eai, this.eaj, parame, paramh.pU(), (byte)0);
    paramf = parame.JM();
    paramh = new b.1(this, paramf, paramh, paramString, parame);
    if (ai.isMainThread())
    {
      paramh.run();
      return paramf;
    }
    ai.d(paramh);
    return paramf;
  }
  
  public final Bitmap jG(String paramString)
  {
    Bitmap localBitmap = this.eai.jK(paramString);
    if (localBitmap != null)
    {
      paramString = localBitmap;
      if (!localBitmap.isRecycled()) {}
    }
    else
    {
      paramString = null;
    }
    return paramString;
  }
  
  static abstract interface d$a
  {
    public abstract void JI();
    
    public abstract void JJ();
  }
  
  public static abstract interface e
    extends c
  {
    public abstract Bitmap o(InputStream paramInputStream);
  }
  
  public static abstract interface g
  {
    public abstract OutputStream jI(String paramString);
    
    public abstract boolean jJ(String paramString);
    
    public abstract InputStream openRead(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b
 * JD-Core Version:    0.7.0.1
 */