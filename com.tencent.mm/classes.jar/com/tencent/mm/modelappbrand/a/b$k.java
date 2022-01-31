package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class b$k
  implements b.d.a
{
  final String eaA;
  private final b.f eaB;
  private final b.i eaC;
  private final b.e eaD;
  private final String eaE;
  boolean eaF = true;
  final b.g eaj;
  final b eay;
  
  private b$k(String paramString1, b.f paramf, b paramb, b.i parami, b.g paramg, b.e parame, String paramString2)
  {
    this.eaA = paramString1;
    this.eaB = paramf;
    this.eay = paramb;
    this.eaC = parami;
    this.eaj = paramg;
    this.eaD = parame;
    this.eaE = paramString2;
  }
  
  /* Error */
  private Bitmap JO()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: invokestatic 59	com/tencent/mm/modelappbrand/a/b:JF	()Z
    //   7: ifne +18 -> 25
    //   10: ldc 61
    //   12: ldc 63
    //   14: invokestatic 69	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: new 71	com/tencent/mm/modelappbrand/a/d$b
    //   20: dup
    //   21: invokespecial 72	com/tencent/mm/modelappbrand/a/d$b:<init>	()V
    //   24: athrow
    //   25: aload_0
    //   26: getfield 33	com/tencent/mm/modelappbrand/a/b$k:eaA	Ljava/lang/String;
    //   29: ifnull +110 -> 139
    //   32: aload_0
    //   33: getfield 33	com/tencent/mm/modelappbrand/a/b$k:eaA	Ljava/lang/String;
    //   36: ldc 74
    //   38: invokevirtual 80	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   41: ifeq +98 -> 139
    //   44: new 82	java/io/FileInputStream
    //   47: dup
    //   48: aload_0
    //   49: getfield 33	com/tencent/mm/modelappbrand/a/b$k:eaA	Ljava/lang/String;
    //   52: ldc 74
    //   54: ldc 84
    //   56: invokevirtual 88	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   59: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +58 -> 122
    //   67: aload_0
    //   68: aload_1
    //   69: invokespecial 95	com/tencent/mm/modelappbrand/a/b$k:p	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +196 -> 270
    //   77: aload_1
    //   78: invokevirtual 100	android/graphics/Bitmap:isRecycled	()Z
    //   81: ifne +189 -> 270
    //   84: ldc 61
    //   86: ldc 102
    //   88: iconst_3
    //   89: anewarray 4	java/lang/Object
    //   92: dup
    //   93: iconst_0
    //   94: aload_1
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: aload_1
    //   99: invokestatic 108	android/support/v4/a/a:c	(Landroid/graphics/Bitmap;)I
    //   102: sipush 1024
    //   105: idiv
    //   106: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: aastore
    //   110: dup
    //   111: iconst_2
    //   112: aload_0
    //   113: getfield 33	com/tencent/mm/modelappbrand/a/b$k:eaA	Ljava/lang/String;
    //   116: aastore
    //   117: invokestatic 117	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload_1
    //   121: astore_2
    //   122: aload_2
    //   123: areturn
    //   124: astore_1
    //   125: ldc 61
    //   127: aload_1
    //   128: ldc 119
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokestatic 123	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aconst_null
    //   138: areturn
    //   139: aload_0
    //   140: getfield 41	com/tencent/mm/modelappbrand/a/b$k:eaj	Lcom/tencent/mm/modelappbrand/a/b$g;
    //   143: aload_0
    //   144: getfield 33	com/tencent/mm/modelappbrand/a/b$k:eaA	Ljava/lang/String;
    //   147: invokestatic 127	com/tencent/mm/modelappbrand/a/b:access$1500	(Ljava/lang/String;)Ljava/lang/String;
    //   150: invokeinterface 133 2 0
    //   155: astore 4
    //   157: aload 4
    //   159: astore_1
    //   160: aload 4
    //   162: ifnonnull -99 -> 63
    //   165: ldc 61
    //   167: ldc 135
    //   169: iconst_1
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_0
    //   176: getfield 31	com/tencent/mm/modelappbrand/a/b$k:eaF	Z
    //   179: invokestatic 140	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   182: aastore
    //   183: invokestatic 117	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: aload_0
    //   187: getfield 31	com/tencent/mm/modelappbrand/a/b$k:eaF	Z
    //   190: ifeq +22 -> 212
    //   193: new 142	com/tencent/mm/modelappbrand/a/b$k$4
    //   196: dup
    //   197: aload_0
    //   198: invokespecial 145	com/tencent/mm/modelappbrand/a/b$k$4:<init>	(Lcom/tencent/mm/modelappbrand/a/b$k;)V
    //   201: ldc 147
    //   203: invokestatic 153	com/tencent/mm/sdk/f/e:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   206: aload 4
    //   208: astore_1
    //   209: goto -146 -> 63
    //   212: aload_0
    //   213: getfield 37	com/tencent/mm/modelappbrand/a/b$k:eay	Lcom/tencent/mm/modelappbrand/a/b;
    //   216: invokestatic 156	com/tencent/mm/modelappbrand/a/b:d	(Lcom/tencent/mm/modelappbrand/a/b;)Lcom/tencent/mm/modelappbrand/a/b$d;
    //   219: aload_0
    //   220: getfield 33	com/tencent/mm/modelappbrand/a/b$k:eaA	Ljava/lang/String;
    //   223: invokestatic 127	com/tencent/mm/modelappbrand/a/b:access$1500	(Ljava/lang/String;)Ljava/lang/String;
    //   226: invokevirtual 161	com/tencent/mm/modelappbrand/a/b$d:jO	(Ljava/lang/String;)V
    //   229: aload_0
    //   230: getfield 37	com/tencent/mm/modelappbrand/a/b$k:eay	Lcom/tencent/mm/modelappbrand/a/b;
    //   233: invokestatic 156	com/tencent/mm/modelappbrand/a/b:d	(Lcom/tencent/mm/modelappbrand/a/b;)Lcom/tencent/mm/modelappbrand/a/b$d;
    //   236: aload_0
    //   237: getfield 33	com/tencent/mm/modelappbrand/a/b$k:eaA	Ljava/lang/String;
    //   240: invokestatic 127	com/tencent/mm/modelappbrand/a/b:access$1500	(Ljava/lang/String;)Ljava/lang/String;
    //   243: invokevirtual 164	com/tencent/mm/modelappbrand/a/b$d:jN	(Ljava/lang/String;)V
    //   246: aload 4
    //   248: astore_1
    //   249: goto -186 -> 63
    //   252: astore_1
    //   253: ldc 61
    //   255: aload_1
    //   256: ldc 166
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 123	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload_3
    //   266: astore_1
    //   267: goto -194 -> 73
    //   270: ldc 61
    //   272: ldc 168
    //   274: iconst_1
    //   275: anewarray 4	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: aload_1
    //   281: aastore
    //   282: invokestatic 117	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: new 170	com/tencent/mm/modelappbrand/a/d$a
    //   288: dup
    //   289: invokespecial 171	com/tencent/mm/modelappbrand/a/d$a:<init>	()V
    //   292: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	k
    //   62	59	1	localObject1	Object
    //   124	4	1	localFileNotFoundException	java.io.FileNotFoundException
    //   159	90	1	localObject2	Object
    //   252	4	1	localException	java.lang.Exception
    //   266	15	1	localObject3	Object
    //   1	122	2	localObject4	Object
    //   3	263	3	localObject5	Object
    //   155	92	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   44	63	124	java/io/FileNotFoundException
    //   67	73	252	java/lang/Exception
  }
  
  private Bitmap p(InputStream paramInputStream)
  {
    try
    {
      if (this.eaD != null)
      {
        localBitmap = this.eaD.o(paramInputStream);
        return localBitmap;
      }
      Bitmap localBitmap = c.decodeStream(paramInputStream);
      return localBitmap;
    }
    finally
    {
      bk.b(paramInputStream);
    }
  }
  
  private void r(Bitmap paramBitmap)
  {
    boolean bool2 = false;
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      y.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread bitmap ok %b", new Object[] { Boolean.valueOf(bool1) });
      Bitmap localBitmap = paramBitmap;
      if (this.eaB != null)
      {
        localBitmap = paramBitmap;
        if (paramBitmap != null)
        {
          localBitmap = paramBitmap;
          if (!paramBitmap.isRecycled())
          {
            localBitmap = this.eaB.q(paramBitmap);
            y.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", new Object[] { paramBitmap, localBitmap });
            if (localBitmap != paramBitmap) {
              this.eaC.m(paramBitmap);
            }
          }
        }
      }
      this.eaC.c(JM(), localBitmap);
      bool1 = bool2;
      if (localBitmap != null)
      {
        bool1 = bool2;
        if (!localBitmap.isRecycled()) {
          bool1 = true;
        }
      }
      y.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b", new Object[] { localBitmap, Boolean.valueOf(bool1) });
      ai.d(new b.k.3(this, localBitmap));
      return;
    }
  }
  
  public final void JI()
  {
    Object localObject1 = this.eaC.jK(JM());
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      y.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", new Object[] { JM() });
      ai.d(new b.k.1(this, (Bitmap)localObject1));
      return;
    }
    if (b.d(this.eay).jM(b.access$1500(this.eaA)))
    {
      b.d locald = b.d(this.eay);
      String str = b.access$1500(this.eaA);
      if ((bk.bl(str)) || (this == null)) {}
      for (;;)
      {
        y.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", new Object[] { b.access$1500(this.eaA) });
        return;
        localObject2 = (List)locald.eaw.get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new LinkedList();
          locald.eaw.put(str, localObject1);
        }
        ((List)localObject1).add(this);
      }
    }
    localObject1 = b.d(this.eay);
    Object localObject2 = b.access$1500(this.eaA);
    if (!bk.bl((String)localObject2)) {
      ((b.d)localObject1).eax.put(localObject2, Boolean.valueOf(true));
    }
    JN();
  }
  
  public final void JJ()
  {
    b.h localh = (b.h)b.b(this.eay).remove(JL());
    if (localh != null) {
      b.a(this.eay).remove(localh);
    }
  }
  
  final String JL()
  {
    return b.ag(this.eaE, JM());
  }
  
  final String JM()
  {
    return b.b(this.eaA, this.eaB, this.eaD);
  }
  
  final void JN()
  {
    try
    {
      Bitmap localBitmap = JO();
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        b.d(this.eay).jN(b.access$1500(this.eaA));
        b.d(this.eay).a(b.access$1500(this.eaA), this);
        r(localBitmap);
        b.d(this.eay).jL(b.access$1500(this.eaA));
      }
      return;
    }
    catch (d locald)
    {
      y.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", new Object[] { locald });
      b.d(this.eay).jN(b.access$1500(this.eaA));
      b.d(this.eay).jO(b.access$1500(this.eaA));
      r(null);
      return;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", localIOException, " doIOJobImpl, io exp ", new Object[0]);
      b.d(this.eay).jN(b.access$1500(this.eaA));
      b.d(this.eay).a(b.access$1500(this.eaA), this);
      b.d(this.eay).jL(b.access$1500(this.eaA));
    }
  }
  
  final void p(Bitmap paramBitmap)
  {
    b.h localh = (b.h)b.b(this.eay).remove(JL());
    if (localh != null)
    {
      localh.p(paramBitmap);
      b.a(this.eay).remove(localh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.a.b.k
 * JD-Core Version:    0.7.0.1
 */