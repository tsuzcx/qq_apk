package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private static final ClassLoader hsQ;
  private static boolean hsR;
  
  static
  {
    AppMethodBeat.i(143130);
    hsQ = b.class.getClassLoader();
    hsR = false;
    AppMethodBeat.o(143130);
  }
  
  /* Error */
  private static java.io.File bW(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: ldc 174
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 139	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   8: ldc 57
    //   10: iconst_0
    //   11: invokevirtual 180	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 183	java/io/File:exists	()Z
    //   19: ifne +25 -> 44
    //   22: aload_2
    //   23: invokevirtual 186	java/io/File:mkdirs	()Z
    //   26: ifne +18 -> 44
    //   29: new 188	java/lang/IllegalStateException
    //   32: dup
    //   33: invokespecial 189	java/lang/IllegalStateException:<init>	()V
    //   36: astore_0
    //   37: ldc 174
    //   39: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: athrow
    //   44: new 123	java/io/File
    //   47: dup
    //   48: aload_2
    //   49: aload_0
    //   50: invokespecial 192	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   53: astore_0
    //   54: new 194	java/io/BufferedInputStream
    //   57: dup
    //   58: new 196	java/io/FileInputStream
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 197	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   66: invokespecial 200	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: astore_2
    //   70: new 202	java/io/BufferedOutputStream
    //   73: dup
    //   74: new 204	java/io/FileOutputStream
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 207	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   82: invokespecial 210	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   85: astore_1
    //   86: aload_2
    //   87: aload_1
    //   88: invokestatic 216	org/apache/commons/a/c:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   91: pop
    //   92: aload_2
    //   93: invokestatic 219	org/apache/commons/a/c:closeQuietly	(Ljava/io/InputStream;)V
    //   96: aload_1
    //   97: invokestatic 221	org/apache/commons/a/c:closeQuietly	(Ljava/io/OutputStream;)V
    //   100: ldc 174
    //   102: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: areturn
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_1
    //   110: aconst_null
    //   111: astore_2
    //   112: aload_2
    //   113: invokestatic 219	org/apache/commons/a/c:closeQuietly	(Ljava/io/InputStream;)V
    //   116: aload_1
    //   117: invokestatic 221	org/apache/commons/a/c:closeQuietly	(Ljava/io/OutputStream;)V
    //   120: ldc 174
    //   122: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_0
    //   126: athrow
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_1
    //   130: goto -18 -> 112
    //   133: astore_0
    //   134: goto -22 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString1	java.lang.String
    //   0	137	1	paramString2	java.lang.String
    //   14	99	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   54	70	107	finally
    //   70	86	127	finally
    //   86	92	133	finally
  }
  
  public static void uD()
  {
    AppMethodBeat.i(143127);
    com.tencent.magicbrush.a.b.a(new b.1());
    com.tencent.mm.udp.libmmudp.a.a(new b.2());
    com.tencent.mm.game.a.a.a(new b.3());
    AppMethodBeat.o(143127);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.c.b
 * JD-Core Version:    0.7.0.1
 */