package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class b$l
  implements b.d.a
{
  final b fqH;
  final String fqJ;
  private final b.f fqK;
  private final b.j fqL;
  private final b.e fqM;
  private final String fqN;
  boolean fqO = true;
  final b.g fqr;
  
  private b$l(String paramString1, b.f paramf, b paramb, b.j paramj, b.g paramg, b.e parame, String paramString2)
  {
    this.fqJ = paramString1;
    this.fqK = paramf;
    this.fqH = paramb;
    this.fqL = paramj;
    this.fqr = paramg;
    this.fqM = parame;
    this.fqN = paramString2;
  }
  
  /* Error */
  private Bitmap acO()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 56
    //   4: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 66	com/tencent/mm/modelappbrand/a/b:acF	()Z
    //   10: ifne +25 -> 35
    //   13: ldc 68
    //   15: ldc 70
    //   17: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: new 78	com/tencent/mm/modelappbrand/a/d$c
    //   23: dup
    //   24: invokespecial 79	com/tencent/mm/modelappbrand/a/d$c:<init>	()V
    //   27: astore_1
    //   28: ldc 56
    //   30: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_1
    //   34: athrow
    //   35: aload_0
    //   36: getfield 33	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   39: ldc 84
    //   41: invokevirtual 90	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   44: ifne +15 -> 59
    //   47: aload_0
    //   48: getfield 33	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   51: ldc 92
    //   53: invokevirtual 90	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   56: ifeq +102 -> 158
    //   59: aload_0
    //   60: getfield 33	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   63: invokestatic 98	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +256 -> 324
    //   71: aload_0
    //   72: aload_1
    //   73: invokespecial 102	com/tencent/mm/modelappbrand/a/b$l:s	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   76: astore_1
    //   77: aload_1
    //   78: ifnull +216 -> 294
    //   81: aload_1
    //   82: invokevirtual 107	android/graphics/Bitmap:isRecycled	()Z
    //   85: ifne +209 -> 294
    //   88: ldc 68
    //   90: ldc 109
    //   92: iconst_3
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_1
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: aload_1
    //   103: invokestatic 114	android/support/v4/graphics/a:d	(Landroid/graphics/Bitmap;)I
    //   106: sipush 1024
    //   109: idiv
    //   110: invokestatic 120	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: dup
    //   115: iconst_2
    //   116: aload_0
    //   117: getfield 33	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   120: aastore
    //   121: invokestatic 123	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: ldc 56
    //   126: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_1
    //   130: areturn
    //   131: astore_1
    //   132: ldc 68
    //   134: aload_1
    //   135: ldc 125
    //   137: iconst_1
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_0
    //   144: getfield 33	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   147: aastore
    //   148: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: ldc 56
    //   153: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: athrow
    //   158: aload_0
    //   159: getfield 41	com/tencent/mm/modelappbrand/a/b$l:fqr	Lcom/tencent/mm/modelappbrand/a/b$g;
    //   162: aload_0
    //   163: getfield 33	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   166: invokestatic 133	com/tencent/mm/modelappbrand/a/b:qB	(Ljava/lang/String;)Ljava/lang/String;
    //   169: invokeinterface 136 2 0
    //   174: astore_3
    //   175: aload_3
    //   176: astore_1
    //   177: aload_3
    //   178: ifnonnull -111 -> 67
    //   181: ldc 68
    //   183: ldc 138
    //   185: iconst_1
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: aload_0
    //   192: getfield 31	com/tencent/mm/modelappbrand/a/b$l:fqO	Z
    //   195: invokestatic 143	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   198: aastore
    //   199: invokestatic 123	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   202: aload_0
    //   203: getfield 31	com/tencent/mm/modelappbrand/a/b$l:fqO	Z
    //   206: ifeq +21 -> 227
    //   209: new 145	com/tencent/mm/modelappbrand/a/b$l$4
    //   212: dup
    //   213: aload_0
    //   214: invokespecial 148	com/tencent/mm/modelappbrand/a/b$l$4:<init>	(Lcom/tencent/mm/modelappbrand/a/b$l;)V
    //   217: ldc 150
    //   219: invokestatic 156	com/tencent/mm/sdk/g/d:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   222: aload_3
    //   223: astore_1
    //   224: goto -157 -> 67
    //   227: aload_0
    //   228: getfield 37	com/tencent/mm/modelappbrand/a/b$l:fqH	Lcom/tencent/mm/modelappbrand/a/b;
    //   231: invokestatic 159	com/tencent/mm/modelappbrand/a/b:d	(Lcom/tencent/mm/modelappbrand/a/b;)Lcom/tencent/mm/modelappbrand/a/b$d;
    //   234: aload_0
    //   235: getfield 33	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   238: invokestatic 133	com/tencent/mm/modelappbrand/a/b:qB	(Ljava/lang/String;)Ljava/lang/String;
    //   241: invokevirtual 165	com/tencent/mm/modelappbrand/a/b$d:qH	(Ljava/lang/String;)V
    //   244: aload_0
    //   245: getfield 37	com/tencent/mm/modelappbrand/a/b$l:fqH	Lcom/tencent/mm/modelappbrand/a/b;
    //   248: invokestatic 159	com/tencent/mm/modelappbrand/a/b:d	(Lcom/tencent/mm/modelappbrand/a/b;)Lcom/tencent/mm/modelappbrand/a/b$d;
    //   251: aload_0
    //   252: getfield 33	com/tencent/mm/modelappbrand/a/b$l:fqJ	Ljava/lang/String;
    //   255: invokestatic 133	com/tencent/mm/modelappbrand/a/b:qB	(Ljava/lang/String;)Ljava/lang/String;
    //   258: invokevirtual 168	com/tencent/mm/modelappbrand/a/b$d:qG	(Ljava/lang/String;)V
    //   261: new 170	com/tencent/mm/modelappbrand/a/d$b
    //   264: dup
    //   265: invokespecial 171	com/tencent/mm/modelappbrand/a/d$b:<init>	()V
    //   268: astore_1
    //   269: ldc 56
    //   271: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aload_1
    //   275: athrow
    //   276: astore_1
    //   277: ldc 68
    //   279: aload_1
    //   280: ldc 173
    //   282: iconst_0
    //   283: anewarray 4	java/lang/Object
    //   286: invokestatic 129	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aload_2
    //   290: astore_1
    //   291: goto -214 -> 77
    //   294: ldc 68
    //   296: ldc 175
    //   298: iconst_1
    //   299: anewarray 4	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: aload_1
    //   305: aastore
    //   306: invokestatic 123	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: new 177	com/tencent/mm/modelappbrand/a/d$a
    //   312: dup
    //   313: invokespecial 178	com/tencent/mm/modelappbrand/a/d$a:<init>	()V
    //   316: astore_1
    //   317: ldc 56
    //   319: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: aload_1
    //   323: athrow
    //   324: ldc 56
    //   326: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: aconst_null
    //   330: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	l
    //   27	103	1	localObject1	Object
    //   131	26	1	localFileNotFoundException	FileNotFoundException
    //   176	99	1	localObject2	Object
    //   276	4	1	localException	java.lang.Exception
    //   290	33	1	localObject3	Object
    //   1	289	2	localObject4	Object
    //   174	49	3	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   59	67	131	java/io/FileNotFoundException
    //   71	77	276	java/lang/Exception
  }
  
  private Bitmap s(InputStream paramInputStream)
  {
    AppMethodBeat.i(77359);
    try
    {
      if (this.fqM != null)
      {
        localBitmap = this.fqM.r(paramInputStream);
        return localBitmap;
      }
      Bitmap localBitmap = com.tencent.mm.sdk.platformtools.d.decodeStream(paramInputStream);
      return localBitmap;
    }
    finally
    {
      bo.b(paramInputStream);
      AppMethodBeat.o(77359);
    }
  }
  
  private Bitmap y(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77356);
    paramBitmap = this.fqK.x(paramBitmap);
    AppMethodBeat.o(77356);
    return paramBitmap;
  }
  
  private void z(Bitmap paramBitmap)
  {
    boolean bool2 = false;
    AppMethodBeat.i(77357);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread bitmap ok %b", new Object[] { Boolean.valueOf(bool1) });
      Bitmap localBitmap = paramBitmap;
      if (this.fqK != null)
      {
        localBitmap = paramBitmap;
        if (paramBitmap != null)
        {
          localBitmap = paramBitmap;
          if (!paramBitmap.isRecycled())
          {
            localBitmap = y(paramBitmap);
            ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", new Object[] { paramBitmap, localBitmap });
            if (localBitmap != paramBitmap) {
              this.fqL.t(paramBitmap);
            }
          }
        }
      }
      this.fqL.c(acM(), localBitmap);
      bool1 = bool2;
      if (localBitmap != null)
      {
        bool1 = bool2;
        if (!localBitmap.isRecycled()) {
          bool1 = true;
        }
      }
      ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b", new Object[] { localBitmap, Boolean.valueOf(bool1) });
      al.d(new b.l.3(this, localBitmap));
      AppMethodBeat.o(77357);
      return;
    }
  }
  
  public final void acI()
  {
    AppMethodBeat.i(77353);
    Object localObject1 = this.fqL.lK(acM());
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", new Object[] { acM() });
      al.d(new b.l.1(this, (Bitmap)localObject1));
      AppMethodBeat.o(77353);
      return;
    }
    if (b.d(this.fqH).qF(b.qB(this.fqJ)))
    {
      b.d locald = b.d(this.fqH);
      String str = b.qB(this.fqJ);
      if (!bo.isNullOrNil(str))
      {
        localObject2 = (List)locald.fqF.get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new LinkedList();
          locald.fqF.put(str, localObject1);
        }
        ((List)localObject1).add(this);
      }
      ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", new Object[] { b.qB(this.fqJ) });
      AppMethodBeat.o(77353);
      return;
    }
    localObject1 = b.d(this.fqH);
    Object localObject2 = b.qB(this.fqJ);
    if (!bo.isNullOrNil((String)localObject2)) {
      ((b.d)localObject1).fqG.put(localObject2, Boolean.TRUE);
    }
    acN();
    AppMethodBeat.o(77353);
  }
  
  public final void acJ()
  {
    AppMethodBeat.i(77354);
    b.i locali = (b.i)b.b(this.fqH).remove(acL());
    if (locali != null) {
      b.a(this.fqH).remove(locali);
    }
    AppMethodBeat.o(77354);
  }
  
  final String acL()
  {
    AppMethodBeat.i(77350);
    String str = b.aw(this.fqN, acM());
    AppMethodBeat.o(77350);
    return str;
  }
  
  final String acM()
  {
    AppMethodBeat.i(77351);
    String str = b.b(this.fqJ, this.fqK, this.fqM);
    AppMethodBeat.o(77351);
    return str;
  }
  
  final void acN()
  {
    AppMethodBeat.i(77352);
    try
    {
      Bitmap localBitmap = acO();
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        b.d(this.fqH).qG(b.qB(this.fqJ));
        b.d(this.fqH).a(b.qB(this.fqJ), this);
        z(localBitmap);
        b.d(this.fqH).qE(b.qB(this.fqJ));
      }
      AppMethodBeat.o(77352);
      return;
    }
    catch (d locald)
    {
      ab.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", new Object[] { locald });
      b.d(this.fqH).qG(b.qB(this.fqJ));
      b.d(this.fqH).qH(b.qB(this.fqJ));
      z(null);
      if ((locald instanceof d.a)) {
        b.e(this.fqH).qD(b.qB(this.fqJ));
      }
      AppMethodBeat.o(77352);
      return;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", localIOException, " doIOJobImpl, io exp ", new Object[0]);
      b.d(this.fqH).qG(b.qB(this.fqJ));
      b.d(this.fqH).a(b.qB(this.fqJ), this);
      b.d(this.fqH).qE(b.qB(this.fqJ));
      if ((localIOException instanceof FileNotFoundException)) {
        z(null);
      }
      AppMethodBeat.o(77352);
    }
  }
  
  final void w(Bitmap paramBitmap)
  {
    AppMethodBeat.i(77355);
    b.i locali = (b.i)b.b(this.fqH).remove(acL());
    if (locali != null)
    {
      locali.w(paramBitmap);
      b.a(this.fqH).remove(locali);
    }
    AppMethodBeat.o(77355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.l
 * JD-Core Version:    0.7.0.1
 */