package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.magicbrush.a.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class b
{
  private static final ClassLoader lsd;
  private static boolean lse;
  
  static
  {
    AppMethodBeat.i(45112);
    lsd = b.class.getClassLoader();
    lse = false;
    AppMethodBeat.o(45112);
  }
  
  public static void LW()
  {
    AppMethodBeat.i(45109);
    com.tencent.magicbrush.a.b.a(new b.a()
    {
      public final String dZ(String paramAnonymousString)
      {
        AppMethodBeat.i(226616);
        paramAnonymousString = j.dZ(paramAnonymousString);
        AppMethodBeat.o(226616);
        return paramAnonymousString;
      }
      
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(45105);
        b.YK(paramAnonymousString);
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
          b.bDg();
          j.Ed(paramAnonymousString);
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
    com.tencent.mm.game.a.a.a(new com.tencent.mm.game.a.a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(45107);
        try
        {
          Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", new Object[] { paramAnonymousString });
          b.bDg();
          j.Ed(paramAnonymousString);
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
    com.tencent.mm.websocket.libwcwss.a.a(new com.tencent.mm.websocket.libwcwss.a.a()
    {
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(45108);
        try
        {
          Log.i("MicroMsg.WAGame.MBLoadDelegateRegistryWC", "loadLibrary libName:%s", new Object[] { paramAnonymousString });
          b.bDg();
          j.Ed(paramAnonymousString);
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
    AppMethodBeat.o(45109);
  }
  
  /* Error */
  private static com.tencent.mm.vfs.o di(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 181	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   8: ldc 92
    //   10: iconst_0
    //   11: invokevirtual 238	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   14: invokestatic 242	com/tencent/mm/vfs/o:X	(Ljava/io/File;)Lcom/tencent/mm/vfs/o;
    //   17: astore_2
    //   18: aload_2
    //   19: invokevirtual 245	com/tencent/mm/vfs/o:exists	()Z
    //   22: ifne +25 -> 47
    //   25: aload_2
    //   26: invokevirtual 248	com/tencent/mm/vfs/o:mkdirs	()Z
    //   29: ifne +18 -> 47
    //   32: new 250	java/lang/IllegalStateException
    //   35: dup
    //   36: invokespecial 251	java/lang/IllegalStateException:<init>	()V
    //   39: astore_0
    //   40: ldc 232
    //   42: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_0
    //   46: athrow
    //   47: new 158	com/tencent/mm/vfs/o
    //   50: dup
    //   51: aload_2
    //   52: aload_0
    //   53: invokespecial 254	com/tencent/mm/vfs/o:<init>	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)V
    //   56: astore_0
    //   57: new 256	java/io/BufferedInputStream
    //   60: dup
    //   61: aload_1
    //   62: invokestatic 262	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   65: invokespecial 265	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   68: astore_2
    //   69: new 267	java/io/BufferedOutputStream
    //   72: dup
    //   73: aload_0
    //   74: invokestatic 271	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   77: invokespecial 274	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   80: astore_1
    //   81: aload_2
    //   82: aload_1
    //   83: invokestatic 280	org/apache/commons/a/e:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   86: pop
    //   87: aload_2
    //   88: invokestatic 283	org/apache/commons/a/e:W	(Ljava/io/InputStream;)V
    //   91: aload_1
    //   92: invokestatic 286	org/apache/commons/a/e:e	(Ljava/io/OutputStream;)V
    //   95: ldc 232
    //   97: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_0
    //   101: areturn
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: invokestatic 283	org/apache/commons/a/e:W	(Ljava/io/InputStream;)V
    //   111: aload_1
    //   112: invokestatic 286	org/apache/commons/a/e:e	(Ljava/io/OutputStream;)V
    //   115: ldc 232
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.b
 * JD-Core Version:    0.7.0.1
 */