package com.davemorrissey.labs.subscaleview.b;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.a.c;
import com.davemorrissey.labs.subscaleview.a.d;
import com.davemorrissey.labs.subscaleview.c.b;
import com.davemorrissey.labs.subscaleview.c.e;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import java.lang.ref.WeakReference;

final class c$a
  extends AsyncTask<Void, Void, Bitmap>
  implements b
{
  private final WeakReference<SubsamplingScaleImageView> aoA;
  private c aoE;
  private final WeakReference<d> aoH;
  private final WeakReference<e> aoI;
  private Exception exception;
  private long mStartTime = -1L;
  
  c$a(SubsamplingScaleImageView paramSubsamplingScaleImageView, d paramd, e parame)
  {
    this.aoA = new WeakReference(paramSubsamplingScaleImageView);
    this.aoH = new WeakReference(paramd);
    this.aoI = new WeakReference(parame);
    parame.aoK = true;
  }
  
  private void a(SubsamplingScaleImageView paramSubsamplingScaleImageView, e parame)
  {
    if ((paramSubsamplingScaleImageView != null) && (parame != null) && (this.mStartTime != -1L) && (paramSubsamplingScaleImageView.getFullImageSampleSize() == parame.sampleSize)) {
      paramSubsamplingScaleImageView.cx((int)(System.currentTimeMillis() - this.mStartTime));
    }
  }
  
  /* Error */
  @android.annotation.SuppressLint({"LongLogTag"})
  private Bitmap jw()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/davemorrissey/labs/subscaleview/b/c$a:aoA	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 84	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: ifnull +49 -> 56
    //   10: aload_0
    //   11: getfield 43	com/davemorrissey/labs/subscaleview/b/c$a:aoI	Ljava/lang/ref/WeakReference;
    //   14: invokevirtual 84	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   17: ifnull +39 -> 56
    //   20: aload_0
    //   21: getfield 39	com/davemorrissey/labs/subscaleview/b/c$a:aoA	Ljava/lang/ref/WeakReference;
    //   24: invokevirtual 84	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   27: checkcast 53	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView
    //   30: invokevirtual 57	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getFullImageSampleSize	()I
    //   33: aload_0
    //   34: getfield 43	com/davemorrissey/labs/subscaleview/b/c$a:aoI	Ljava/lang/ref/WeakReference;
    //   37: invokevirtual 84	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   40: checkcast 45	com/davemorrissey/labs/subscaleview/c/e
    //   43: getfield 61	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   46: if_icmpne +10 -> 56
    //   49: aload_0
    //   50: invokestatic 67	java/lang/System:currentTimeMillis	()J
    //   53: putfield 32	com/davemorrissey/labs/subscaleview/b/c$a:mStartTime	J
    //   56: aload_0
    //   57: getfield 39	com/davemorrissey/labs/subscaleview/b/c$a:aoA	Ljava/lang/ref/WeakReference;
    //   60: invokevirtual 84	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   63: checkcast 53	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 41	com/davemorrissey/labs/subscaleview/b/c$a:aoH	Ljava/lang/ref/WeakReference;
    //   71: invokevirtual 84	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   74: checkcast 86	com/davemorrissey/labs/subscaleview/a/d
    //   77: astore_3
    //   78: aload_0
    //   79: getfield 43	com/davemorrissey/labs/subscaleview/b/c$a:aoI	Ljava/lang/ref/WeakReference;
    //   82: invokevirtual 84	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   85: checkcast 45	com/davemorrissey/labs/subscaleview/c/e
    //   88: astore_2
    //   89: aload_3
    //   90: ifnull +479 -> 569
    //   93: aload_2
    //   94: ifnull +475 -> 569
    //   97: aload_1
    //   98: ifnull +471 -> 569
    //   101: aload_3
    //   102: invokeinterface 90 1 0
    //   107: ifeq +462 -> 569
    //   110: aload_2
    //   111: getfield 93	com/davemorrissey/labs/subscaleview/c/e:aoL	Z
    //   114: ifeq +455 -> 569
    //   117: ldc 95
    //   119: ldc 97
    //   121: iconst_2
    //   122: anewarray 99	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_2
    //   128: getfield 103	com/davemorrissey/labs/subscaleview/c/e:aoJ	Landroid/graphics/Rect;
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: aload_2
    //   135: getfield 61	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   138: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: aastore
    //   142: invokestatic 115	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_1
    //   146: invokevirtual 119	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getDecoderLock	()Ljava/util/concurrent/locks/ReadWriteLock;
    //   149: invokeinterface 125 1 0
    //   154: invokeinterface 130 1 0
    //   159: aload_3
    //   160: invokeinterface 90 1 0
    //   165: ifeq +333 -> 498
    //   168: aload_2
    //   169: getfield 103	com/davemorrissey/labs/subscaleview/c/e:aoJ	Landroid/graphics/Rect;
    //   172: astore 4
    //   174: aload_2
    //   175: getfield 133	com/davemorrissey/labs/subscaleview/c/e:aoN	Landroid/graphics/Rect;
    //   178: astore 5
    //   180: aload_1
    //   181: invokevirtual 136	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getRequiredRotation	()I
    //   184: ifne +96 -> 280
    //   187: aload 5
    //   189: aload 4
    //   191: invokevirtual 142	android/graphics/Rect:set	(Landroid/graphics/Rect;)V
    //   194: aload_1
    //   195: invokevirtual 146	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getsRegion	()Landroid/graphics/Rect;
    //   198: ifnull +24 -> 222
    //   201: aload_2
    //   202: getfield 133	com/davemorrissey/labs/subscaleview/c/e:aoN	Landroid/graphics/Rect;
    //   205: aload_1
    //   206: invokevirtual 146	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getsRegion	()Landroid/graphics/Rect;
    //   209: getfield 149	android/graphics/Rect:left	I
    //   212: aload_1
    //   213: invokevirtual 146	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getsRegion	()Landroid/graphics/Rect;
    //   216: getfield 152	android/graphics/Rect:top	I
    //   219: invokevirtual 156	android/graphics/Rect:offset	(II)V
    //   222: ldc 95
    //   224: ldc 158
    //   226: iconst_1
    //   227: anewarray 99	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_2
    //   233: getfield 61	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   236: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: invokestatic 115	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: aload_3
    //   244: aload_2
    //   245: getfield 133	com/davemorrissey/labs/subscaleview/c/e:aoN	Landroid/graphics/Rect;
    //   248: aload_2
    //   249: getfield 61	com/davemorrissey/labs/subscaleview/c/e:sampleSize	I
    //   252: invokeinterface 162 3 0
    //   257: astore_3
    //   258: aload_0
    //   259: aload_1
    //   260: aload_2
    //   261: invokespecial 164	com/davemorrissey/labs/subscaleview/b/c$a:a	(Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView;Lcom/davemorrissey/labs/subscaleview/c/e;)V
    //   264: aload_1
    //   265: invokevirtual 119	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getDecoderLock	()Ljava/util/concurrent/locks/ReadWriteLock;
    //   268: invokeinterface 125 1 0
    //   273: invokeinterface 167 1 0
    //   278: aload_3
    //   279: areturn
    //   280: aload_1
    //   281: invokevirtual 136	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getRequiredRotation	()I
    //   284: bipush 90
    //   286: if_icmpne +116 -> 402
    //   289: aload 5
    //   291: aload 4
    //   293: getfield 152	android/graphics/Rect:top	I
    //   296: aload_1
    //   297: getfield 170	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aoU	I
    //   300: aload 4
    //   302: getfield 173	android/graphics/Rect:right	I
    //   305: isub
    //   306: aload 4
    //   308: getfield 176	android/graphics/Rect:bottom	I
    //   311: aload_1
    //   312: getfield 170	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aoU	I
    //   315: aload 4
    //   317: getfield 149	android/graphics/Rect:left	I
    //   320: isub
    //   321: invokevirtual 179	android/graphics/Rect:set	(IIII)V
    //   324: goto -130 -> 194
    //   327: astore_2
    //   328: aload_1
    //   329: invokevirtual 119	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getDecoderLock	()Ljava/util/concurrent/locks/ReadWriteLock;
    //   332: invokeinterface 125 1 0
    //   337: invokeinterface 167 1 0
    //   342: aload_2
    //   343: athrow
    //   344: astore_1
    //   345: ldc 95
    //   347: aload_1
    //   348: ldc 181
    //   350: iconst_0
    //   351: anewarray 99	java/lang/Object
    //   354: invokestatic 185	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: aload_0
    //   358: aload_1
    //   359: putfield 187	com/davemorrissey/labs/subscaleview/b/c$a:exception	Ljava/lang/Exception;
    //   362: aload_0
    //   363: new 189	com/davemorrissey/labs/subscaleview/a/c
    //   366: dup
    //   367: iconst_5
    //   368: ldc 191
    //   370: invokespecial 194	com/davemorrissey/labs/subscaleview/a/c:<init>	(ILjava/lang/String;)V
    //   373: putfield 196	com/davemorrissey/labs/subscaleview/b/c$a:aoE	Lcom/davemorrissey/labs/subscaleview/a/c;
    //   376: aload_0
    //   377: aload_0
    //   378: getfield 39	com/davemorrissey/labs/subscaleview/b/c$a:aoA	Ljava/lang/ref/WeakReference;
    //   381: invokevirtual 84	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   384: checkcast 53	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView
    //   387: aload_0
    //   388: getfield 43	com/davemorrissey/labs/subscaleview/b/c$a:aoI	Ljava/lang/ref/WeakReference;
    //   391: invokevirtual 84	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   394: checkcast 45	com/davemorrissey/labs/subscaleview/c/e
    //   397: invokespecial 164	com/davemorrissey/labs/subscaleview/b/c$a:a	(Lcom/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView;Lcom/davemorrissey/labs/subscaleview/c/e;)V
    //   400: aconst_null
    //   401: areturn
    //   402: aload_1
    //   403: invokevirtual 136	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getRequiredRotation	()I
    //   406: sipush 180
    //   409: if_icmpne +51 -> 460
    //   412: aload 5
    //   414: aload_1
    //   415: getfield 199	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aoT	I
    //   418: aload 4
    //   420: getfield 173	android/graphics/Rect:right	I
    //   423: isub
    //   424: aload_1
    //   425: getfield 170	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aoU	I
    //   428: aload 4
    //   430: getfield 176	android/graphics/Rect:bottom	I
    //   433: isub
    //   434: aload_1
    //   435: getfield 199	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aoT	I
    //   438: aload 4
    //   440: getfield 149	android/graphics/Rect:left	I
    //   443: isub
    //   444: aload_1
    //   445: getfield 170	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aoU	I
    //   448: aload 4
    //   450: getfield 152	android/graphics/Rect:top	I
    //   453: isub
    //   454: invokevirtual 179	android/graphics/Rect:set	(IIII)V
    //   457: goto -263 -> 194
    //   460: aload 5
    //   462: aload_1
    //   463: getfield 199	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aoT	I
    //   466: aload 4
    //   468: getfield 176	android/graphics/Rect:bottom	I
    //   471: isub
    //   472: aload 4
    //   474: getfield 149	android/graphics/Rect:left	I
    //   477: aload_1
    //   478: getfield 199	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:aoT	I
    //   481: aload 4
    //   483: getfield 152	android/graphics/Rect:top	I
    //   486: isub
    //   487: aload 4
    //   489: getfield 173	android/graphics/Rect:right	I
    //   492: invokevirtual 179	android/graphics/Rect:set	(IIII)V
    //   495: goto -301 -> 194
    //   498: aload_2
    //   499: iconst_0
    //   500: putfield 49	com/davemorrissey/labs/subscaleview/c/e:aoK	Z
    //   503: aload_1
    //   504: invokevirtual 119	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:getDecoderLock	()Ljava/util/concurrent/locks/ReadWriteLock;
    //   507: invokeinterface 125 1 0
    //   512: invokeinterface 167 1 0
    //   517: goto -141 -> 376
    //   520: astore_1
    //   521: ldc 95
    //   523: aload_1
    //   524: ldc 201
    //   526: iconst_0
    //   527: anewarray 99	java/lang/Object
    //   530: invokestatic 185	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   533: aload_0
    //   534: new 203	java/lang/RuntimeException
    //   537: dup
    //   538: aload_1
    //   539: invokespecial 206	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   542: putfield 187	com/davemorrissey/labs/subscaleview/b/c$a:exception	Ljava/lang/Exception;
    //   545: aload_0
    //   546: new 189	com/davemorrissey/labs/subscaleview/a/c
    //   549: dup
    //   550: bipush 6
    //   552: ldc 208
    //   554: invokespecial 194	com/davemorrissey/labs/subscaleview/a/c:<init>	(ILjava/lang/String;)V
    //   557: putfield 196	com/davemorrissey/labs/subscaleview/b/c$a:aoE	Lcom/davemorrissey/labs/subscaleview/a/c;
    //   560: getstatic 214	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   563: invokestatic 218	com/davemorrissey/labs/subscaleview/view/SubsamplingScaleImageView:setPreferredBitmapConfig	(Landroid/graphics/Bitmap$Config;)V
    //   566: goto -190 -> 376
    //   569: aload_2
    //   570: ifnull -194 -> 376
    //   573: aload_2
    //   574: iconst_0
    //   575: putfield 49	com/davemorrissey/labs/subscaleview/c/e:aoK	Z
    //   578: goto -202 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	this	a
    //   66	263	1	localSubsamplingScaleImageView	SubsamplingScaleImageView
    //   344	160	1	localException	Exception
    //   520	19	1	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   88	173	2	locale	e
    //   327	247	2	localObject1	java.lang.Object
    //   77	202	3	localObject2	java.lang.Object
    //   172	316	4	localRect1	android.graphics.Rect
    //   178	283	5	localRect2	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   159	194	327	finally
    //   194	222	327	finally
    //   222	264	327	finally
    //   280	324	327	finally
    //   402	457	327	finally
    //   460	495	327	finally
    //   498	503	327	finally
    //   56	89	344	java/lang/Exception
    //   101	159	344	java/lang/Exception
    //   264	278	344	java/lang/Exception
    //   328	344	344	java/lang/Exception
    //   503	517	344	java/lang/Exception
    //   573	578	344	java/lang/Exception
    //   56	89	520	java/lang/OutOfMemoryError
    //   101	159	520	java/lang/OutOfMemoryError
    //   264	278	520	java/lang/OutOfMemoryError
    //   328	344	520	java/lang/OutOfMemoryError
    //   503	517	520	java/lang/OutOfMemoryError
    //   573	578	520	java/lang/OutOfMemoryError
  }
  
  public final void ju()
  {
    executeOnExecutor(((SubsamplingScaleImageView)this.aoA.get()).aqE, new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.b.c.a
 * JD-Core Version:    0.7.0.1
 */