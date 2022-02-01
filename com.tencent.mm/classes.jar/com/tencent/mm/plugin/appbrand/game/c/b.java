package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.magicbrush.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class b
{
  private static final ClassLoader jqy;
  private static boolean jqz;
  
  static
  {
    AppMethodBeat.i(45112);
    jqy = b.class.getClassLoader();
    jqz = false;
    AppMethodBeat.o(45112);
  }
  
  public static void Bu()
  {
    AppMethodBeat.i(45109);
    com.tencent.magicbrush.a.b.a(new b.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(45105);
        b.Ht(paramAnonymousString);
        AppMethodBeat.o(45105);
      }
    });
    com.tencent.mm.udp.libmmudp.a.a(new com.tencent.mm.udp.libmmudp.a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(45106);
        try
        {
          ad.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", new Object[] { paramAnonymousString });
          b.aWH();
          j.pq(paramAnonymousString);
          AppMethodBeat.o(45106);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          ad.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", localUnsatisfiedLinkError, "hy: link %s error!!", new Object[] { paramAnonymousString });
          com.tencent.mm.plugin.appbrand.game.h.b.dg(aj.getContext());
          AppMethodBeat.o(45106);
        }
      }
    });
    com.tencent.mm.game.a.a.a(new com.tencent.mm.game.a.a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(45107);
        try
        {
          ad.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", new Object[] { paramAnonymousString });
          b.aWH();
          j.pq(paramAnonymousString);
          AppMethodBeat.o(45107);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          ad.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", localUnsatisfiedLinkError, "hy: link %s error!!", new Object[] { paramAnonymousString });
          com.tencent.mm.plugin.appbrand.game.h.b.dg(aj.getContext());
          AppMethodBeat.o(45107);
        }
      }
    });
    com.tencent.mm.websocket.libwcwss.a.a(new com.tencent.mm.websocket.libwcwss.a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(45108);
        try
        {
          ad.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", new Object[] { paramAnonymousString });
          b.aWH();
          j.pq(paramAnonymousString);
          AppMethodBeat.o(45108);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          ad.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", localUnsatisfiedLinkError, "hy: link %s error!!", new Object[] { paramAnonymousString });
          com.tencent.mm.plugin.appbrand.game.h.b.dg(aj.getContext());
          AppMethodBeat.o(45108);
        }
      }
    });
    AppMethodBeat.o(45109);
  }
  
  /* Error */
  private static com.tencent.mm.vfs.e cF(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 215
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 181	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   8: ldc 92
    //   10: iconst_0
    //   11: invokevirtual 221	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   14: invokestatic 225	com/tencent/mm/vfs/e:R	(Ljava/io/File;)Lcom/tencent/mm/vfs/e;
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 228	com/tencent/mm/vfs/e:exists	()Z
    //   22: ifne +25 -> 47
    //   25: aload_2
    //   26: invokevirtual 231	com/tencent/mm/vfs/e:mkdirs	()Z
    //   29: ifne +18 -> 47
    //   32: new 233	java/lang/IllegalStateException
    //   35: dup
    //   36: invokespecial 234	java/lang/IllegalStateException:<init>	()V
    //   39: astore_0
    //   40: ldc 215
    //   42: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: athrow
    //   47: new 158	com/tencent/mm/vfs/e
    //   50: dup
    //   51: aload_2
    //   52: aload_0
    //   53: invokespecial 237	com/tencent/mm/vfs/e:<init>	(Lcom/tencent/mm/vfs/e;Ljava/lang/String;)V
    //   56: astore_0
    //   57: new 239	java/io/BufferedInputStream
    //   60: dup
    //   61: aload_1
    //   62: invokestatic 245	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   65: invokespecial 248	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: astore_2
    //   69: new 250	java/io/BufferedOutputStream
    //   72: dup
    //   73: aload_0
    //   74: invokestatic 254	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   77: invokespecial 257	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   80: astore_1
    //   81: aload_2
    //   82: aload_1
    //   83: invokestatic 263	org/apache/commons/a/d:c	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   86: pop
    //   87: aload_2
    //   88: invokestatic 266	org/apache/commons/a/d:X	(Ljava/io/InputStream;)V
    //   91: aload_1
    //   92: invokestatic 269	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   95: ldc 215
    //   97: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: areturn
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: invokestatic 266	org/apache/commons/a/d:X	(Ljava/io/InputStream;)V
    //   111: aload_1
    //   112: invokestatic 269	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   115: ldc 215
    //   117: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -18 -> 107
    //   128: astore_0
    //   129: goto -22 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramString1	String
    //   0	132	1	paramString2	String
    //   17	91	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   57	69	102	finally
    //   69	81	122	finally
    //   81	87	128	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.b
 * JD-Core Version:    0.7.0.1
 */