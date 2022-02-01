package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.magicbrush.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class b
{
  private static final ClassLoader rqK;
  private static boolean rqL;
  
  static
  {
    AppMethodBeat.i(45112);
    rqK = b.class.getClassLoader();
    rqL = false;
    AppMethodBeat.o(45112);
  }
  
  public static void aoW()
  {
    AppMethodBeat.i(45109);
    com.tencent.magicbrush.a.b.a(new b.a()
    {
      public final String fX(String paramAnonymousString)
      {
        AppMethodBeat.i(318383);
        paramAnonymousString = k.fX(paramAnonymousString);
        AppMethodBeat.o(318383);
        return paramAnonymousString;
      }
      
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(45105);
        b.Zu(paramAnonymousString);
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
          Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", new Object[] { paramAnonymousString });
          b.coR();
          k.DA(paramAnonymousString);
          AppMethodBeat.o(45106);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          Log.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", localUnsatisfiedLinkError, "hy: link %s error!!", new Object[] { paramAnonymousString });
          com.tencent.mm.plugin.appbrand.game.h.b.showDialog(MMApplicationContext.getContext());
          AppMethodBeat.o(45106);
        }
      }
    });
    com.tencent.mm.tcp.libmmtcp.a.a(new com.tencent.mm.tcp.libmmtcp.a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(45107);
        try
        {
          Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", new Object[] { paramAnonymousString });
          b.coR();
          k.DA(paramAnonymousString);
          AppMethodBeat.o(45107);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          Log.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", localUnsatisfiedLinkError, "hy: link %s error!!", new Object[] { paramAnonymousString });
          com.tencent.mm.plugin.appbrand.game.h.b.showDialog(MMApplicationContext.getContext());
          AppMethodBeat.o(45107);
        }
      }
    });
    com.tencent.mm.game.b.a.a(new com.tencent.mm.game.b.a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(45108);
        try
        {
          Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", new Object[] { paramAnonymousString });
          b.coR();
          k.DA(paramAnonymousString);
          AppMethodBeat.o(45108);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          Log.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", localUnsatisfiedLinkError, "hy: link %s error!!", new Object[] { paramAnonymousString });
          com.tencent.mm.plugin.appbrand.game.h.b.showDialog(MMApplicationContext.getContext());
          AppMethodBeat.o(45108);
        }
      }
    });
    com.tencent.mm.websocket.libwcwss.a.a(new com.tencent.mm.websocket.libwcwss.a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(318381);
        try
        {
          Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", new Object[] { paramAnonymousString });
          b.coR();
          k.DA(paramAnonymousString);
          AppMethodBeat.o(318381);
          return;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          Log.printErrStackTrace("MicroMsg.WAGame.MBLoadDelegateRegistryWC", localUnsatisfiedLinkError, "hy: link %s error!!", new Object[] { paramAnonymousString });
          com.tencent.mm.plugin.appbrand.game.h.b.showDialog(MMApplicationContext.getContext());
          AppMethodBeat.o(318381);
        }
      }
    });
    AppMethodBeat.o(45109);
  }
  
  /* Error */
  private static com.tencent.mm.vfs.u dK(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 240
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 156	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   8: ldc 67
    //   10: iconst_0
    //   11: invokevirtual 246	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   14: invokestatic 250	com/tencent/mm/vfs/u:V	(Ljava/io/File;)Lcom/tencent/mm/vfs/u;
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 253	com/tencent/mm/vfs/u:jKS	()Z
    //   22: ifne +25 -> 47
    //   25: aload_2
    //   26: invokevirtual 256	com/tencent/mm/vfs/u:jKY	()Z
    //   29: ifne +18 -> 47
    //   32: new 258	java/lang/IllegalStateException
    //   35: dup
    //   36: invokespecial 259	java/lang/IllegalStateException:<init>	()V
    //   39: astore_0
    //   40: ldc 240
    //   42: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: athrow
    //   47: new 133	com/tencent/mm/vfs/u
    //   50: dup
    //   51: aload_2
    //   52: aload_0
    //   53: invokespecial 262	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   56: astore_0
    //   57: new 264	java/io/BufferedInputStream
    //   60: dup
    //   61: aload_1
    //   62: invokestatic 270	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   65: invokespecial 273	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: astore_2
    //   69: new 275	java/io/BufferedOutputStream
    //   72: dup
    //   73: aload_0
    //   74: invokestatic 279	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   77: invokespecial 282	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   80: astore_1
    //   81: aload_2
    //   82: aload_1
    //   83: invokestatic 288	org/apache/commons/b/d:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   86: pop
    //   87: aload_2
    //   88: invokestatic 291	org/apache/commons/b/d:ai	(Ljava/io/InputStream;)V
    //   91: aload_1
    //   92: invokestatic 294	org/apache/commons/b/d:e	(Ljava/io/OutputStream;)V
    //   95: ldc 240
    //   97: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: areturn
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: invokestatic 291	org/apache/commons/b/d:ai	(Ljava/io/InputStream;)V
    //   111: aload_1
    //   112: invokestatic 294	org/apache/commons/b/d:e	(Ljava/io/OutputStream;)V
    //   115: ldc 240
    //   117: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.b
 * JD-Core Version:    0.7.0.1
 */