package androidx.camera.core.a;

import android.graphics.Rect;
import android.media.ImageWriter;
import android.os.Build.VERSION;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.a.a.a;
import androidx.camera.core.al;
import androidx.camera.core.impl.aa;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  implements aa
{
  private static final Rect Qr;
  private final int Hi;
  public int Qs;
  public int Qt;
  public ImageWriter Qu;
  private Rect Qv;
  public boolean mClosed;
  public final Object mLock;
  
  static
  {
    AppMethodBeat.i(199140);
    Qr = new Rect(0, 0, 0, 0);
    AppMethodBeat.o(199140);
  }
  
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199136);
    this.mLock = new Object();
    this.mClosed = false;
    this.Qt = 0;
    this.Qv = Qr;
    this.Qs = paramInt1;
    this.Hi = paramInt2;
    AppMethodBeat.o(199136);
  }
  
  public final void a(Surface paramSurface, int paramInt)
  {
    AppMethodBeat.i(199146);
    if (paramInt == 256) {}
    for (boolean bool = true;; bool = false)
    {
      f.b(bool, "YuvToJpegProcessor only supports JPEG output format.");
      synchronized (this.mLock)
      {
        if (this.mClosed) {
          break label169;
        }
        if (this.Qu == null) {
          break;
        }
        paramSurface = new IllegalStateException("Output surface already set.");
        AppMethodBeat.o(199146);
        throw paramSurface;
      }
    }
    int i = this.Hi;
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramSurface = ImageWriter.newInstance(paramSurface, i, paramInt);
      this.Qu = paramSurface;
    }
    for (;;)
    {
      AppMethodBeat.o(199146);
      return;
      if (Build.VERSION.SDK_INT >= 26)
      {
        paramSurface = a.b(paramSurface, i, paramInt);
        break;
      }
      paramSurface = new RuntimeException("Unable to call newInstance(Surface, int, int) on API " + Build.VERSION.SDK_INT + ". Version 26 or higher required.");
      AppMethodBeat.o(199146);
      throw paramSurface;
      label169:
      al.R("YuvToJpegProcessor");
    }
  }
  
  /* Error */
  public final void a(androidx.camera.core.impl.am paramam)
  {
    // Byte code:
    //   0: ldc 125
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokeinterface 131 1 0
    //   11: astore 5
    //   13: aload 5
    //   15: invokeinterface 137 1 0
    //   20: iconst_1
    //   21: if_icmpne +159 -> 180
    //   24: iconst_1
    //   25: istore 4
    //   27: iload 4
    //   29: new 97	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 139
    //   35: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: aload 5
    //   40: invokeinterface 137 1 0
    //   45: invokevirtual 104	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 143	androidx/core/f/f:checkArgument	(ZLjava/lang/Object;)V
    //   54: aload_1
    //   55: aload 5
    //   57: iconst_0
    //   58: invokeinterface 147 2 0
    //   63: checkcast 149	java/lang/Integer
    //   66: invokevirtual 152	java/lang/Integer:intValue	()I
    //   69: invokeinterface 156 2 0
    //   74: astore 8
    //   76: aload 8
    //   78: invokeinterface 162 1 0
    //   83: invokestatic 165	androidx/core/f/f:checkArgument	(Z)V
    //   86: aload_0
    //   87: getfield 48	androidx/camera/core/a/i:mLock	Ljava/lang/Object;
    //   90: astore_1
    //   91: aload_1
    //   92: monitorenter
    //   93: aload_0
    //   94: getfield 71	androidx/camera/core/a/i:Qu	Landroid/media/ImageWriter;
    //   97: astore 9
    //   99: aload_0
    //   100: getfield 50	androidx/camera/core/a/i:mClosed	Z
    //   103: ifne +83 -> 186
    //   106: iconst_1
    //   107: istore_2
    //   108: aload_0
    //   109: getfield 54	androidx/camera/core/a/i:Qv	Landroid/graphics/Rect;
    //   112: astore 10
    //   114: iload_2
    //   115: ifeq +13 -> 128
    //   118: aload_0
    //   119: aload_0
    //   120: getfield 52	androidx/camera/core/a/i:Qt	I
    //   123: iconst_1
    //   124: iadd
    //   125: putfield 52	androidx/camera/core/a/i:Qt	I
    //   128: aload_1
    //   129: monitorexit
    //   130: aconst_null
    //   131: astore 5
    //   133: aconst_null
    //   134: astore 7
    //   136: aconst_null
    //   137: astore 6
    //   139: aload 8
    //   141: invokeinterface 168 1 0
    //   146: checkcast 170	androidx/camera/core/ag
    //   149: astore_1
    //   150: iload_2
    //   151: ifne +52 -> 203
    //   154: ldc 116
    //   156: invokestatic 121	androidx/camera/core/al:R	(Ljava/lang/String;)V
    //   159: aload_1
    //   160: invokeinterface 173 1 0
    //   165: aload_0
    //   166: getfield 48	androidx/camera/core/a/i:mLock	Ljava/lang/Object;
    //   169: astore_1
    //   170: aload_1
    //   171: monitorenter
    //   172: aload_1
    //   173: monitorexit
    //   174: ldc 125
    //   176: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: return
    //   180: iconst_0
    //   181: istore 4
    //   183: goto -156 -> 27
    //   186: iconst_0
    //   187: istore_2
    //   188: goto -80 -> 108
    //   191: astore 5
    //   193: aload_1
    //   194: monitorexit
    //   195: ldc 125
    //   197: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload 5
    //   202: athrow
    //   203: aload 9
    //   205: invokevirtual 177	android/media/ImageWriter:dequeueInputImage	()Landroid/media/Image;
    //   208: astore 5
    //   210: aload 5
    //   212: astore 6
    //   214: aload 8
    //   216: invokeinterface 168 1 0
    //   221: checkcast 170	androidx/camera/core/ag
    //   224: astore 8
    //   226: aload 8
    //   228: astore 5
    //   230: aload 8
    //   232: astore 7
    //   234: aload 8
    //   236: invokeinterface 180 1 0
    //   241: bipush 35
    //   243: if_icmpne +332 -> 575
    //   246: iconst_1
    //   247: istore 4
    //   249: aload 8
    //   251: astore 5
    //   253: aload 8
    //   255: astore 7
    //   257: iload 4
    //   259: ldc 182
    //   261: invokestatic 69	androidx/core/f/f:b	(ZLjava/lang/String;)V
    //   264: aload 8
    //   266: astore 5
    //   268: aload 8
    //   270: astore 7
    //   272: new 184	android/graphics/YuvImage
    //   275: dup
    //   276: aload 8
    //   278: invokestatic 190	androidx/camera/core/a/b/a:h	(Landroidx/camera/core/ag;)[B
    //   281: bipush 17
    //   283: aload 8
    //   285: invokeinterface 193 1 0
    //   290: aload 8
    //   292: invokeinterface 196 1 0
    //   297: aconst_null
    //   298: invokespecial 199	android/graphics/YuvImage:<init>	([BIII[I)V
    //   301: astore_1
    //   302: aload 8
    //   304: astore 5
    //   306: aload 8
    //   308: astore 7
    //   310: aload 6
    //   312: invokevirtual 205	android/media/Image:getPlanes	()[Landroid/media/Image$Plane;
    //   315: iconst_0
    //   316: aaload
    //   317: invokevirtual 211	android/media/Image$Plane:getBuffer	()Ljava/nio/ByteBuffer;
    //   320: astore 11
    //   322: aload 8
    //   324: astore 5
    //   326: aload 8
    //   328: astore 7
    //   330: aload 11
    //   332: invokevirtual 216	java/nio/ByteBuffer:position	()I
    //   335: istore_3
    //   336: aload 8
    //   338: astore 5
    //   340: aload 8
    //   342: astore 7
    //   344: new 8	androidx/camera/core/a/i$a
    //   347: dup
    //   348: aload 11
    //   350: invokespecial 219	androidx/camera/core/a/i$a:<init>	(Ljava/nio/ByteBuffer;)V
    //   353: astore 12
    //   355: aload 8
    //   357: astore 5
    //   359: aload 8
    //   361: astore 7
    //   363: invokestatic 225	androidx/camera/core/impl/a/g:kM	()Landroidx/camera/core/impl/a/g$a;
    //   366: astore 13
    //   368: aload 8
    //   370: astore 5
    //   372: aload 8
    //   374: astore 7
    //   376: aload 8
    //   378: invokeinterface 229 1 0
    //   383: aload 13
    //   385: invokeinterface 234 2 0
    //   390: aload 8
    //   392: astore 5
    //   394: aload 8
    //   396: astore 7
    //   398: new 236	androidx/camera/core/impl/a/h
    //   401: dup
    //   402: aload 12
    //   404: aload 13
    //   406: aload 8
    //   408: invokeinterface 193 1 0
    //   413: invokevirtual 242	androidx/camera/core/impl/a/g$a:bc	(I)Landroidx/camera/core/impl/a/g$a;
    //   416: aload 8
    //   418: invokeinterface 196 1 0
    //   423: invokevirtual 245	androidx/camera/core/impl/a/g$a:bd	(I)Landroidx/camera/core/impl/a/g$a;
    //   426: invokevirtual 249	androidx/camera/core/impl/a/g$a:kN	()Landroidx/camera/core/impl/a/g;
    //   429: invokespecial 252	androidx/camera/core/impl/a/h:<init>	(Ljava/io/OutputStream;Landroidx/camera/core/impl/a/g;)V
    //   432: astore 12
    //   434: aload 8
    //   436: astore 5
    //   438: aload 8
    //   440: astore 7
    //   442: aload_1
    //   443: aload 10
    //   445: aload_0
    //   446: getfield 56	androidx/camera/core/a/i:Qs	I
    //   449: aload 12
    //   451: invokevirtual 256	android/graphics/YuvImage:compressToJpeg	(Landroid/graphics/Rect;ILjava/io/OutputStream;)Z
    //   454: pop
    //   455: aload 8
    //   457: astore 5
    //   459: aload 8
    //   461: astore 7
    //   463: aload 8
    //   465: invokeinterface 173 1 0
    //   470: aconst_null
    //   471: astore 8
    //   473: aconst_null
    //   474: astore_1
    //   475: aload_1
    //   476: astore 5
    //   478: aload 8
    //   480: astore 7
    //   482: aload 11
    //   484: aload 11
    //   486: invokevirtual 216	java/nio/ByteBuffer:position	()I
    //   489: invokevirtual 260	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   492: pop
    //   493: aload_1
    //   494: astore 5
    //   496: aload 8
    //   498: astore 7
    //   500: aload 11
    //   502: iload_3
    //   503: invokevirtual 262	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   506: pop
    //   507: aload_1
    //   508: astore 5
    //   510: aload 8
    //   512: astore 7
    //   514: aload 9
    //   516: aload 6
    //   518: invokevirtual 266	android/media/ImageWriter:queueInputImage	(Landroid/media/Image;)V
    //   521: aload_0
    //   522: getfield 48	androidx/camera/core/a/i:mLock	Ljava/lang/Object;
    //   525: astore_1
    //   526: aload_1
    //   527: monitorenter
    //   528: aload_0
    //   529: getfield 52	androidx/camera/core/a/i:Qt	I
    //   532: istore_2
    //   533: aload_0
    //   534: iload_2
    //   535: iconst_1
    //   536: isub
    //   537: putfield 52	androidx/camera/core/a/i:Qt	I
    //   540: iload_2
    //   541: ifne +40 -> 581
    //   544: aload_0
    //   545: getfield 50	androidx/camera/core/a/i:mClosed	Z
    //   548: ifeq +33 -> 581
    //   551: iconst_1
    //   552: istore_2
    //   553: aload_1
    //   554: monitorexit
    //   555: iload_2
    //   556: ifeq +13 -> 569
    //   559: aload 9
    //   561: invokevirtual 267	android/media/ImageWriter:close	()V
    //   564: ldc 116
    //   566: invokestatic 270	androidx/camera/core/al:O	(Ljava/lang/String;)V
    //   569: ldc 125
    //   571: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   574: return
    //   575: iconst_0
    //   576: istore 4
    //   578: goto -329 -> 249
    //   581: iconst_0
    //   582: istore_2
    //   583: goto -30 -> 553
    //   586: astore 5
    //   588: aload_1
    //   589: monitorexit
    //   590: ldc 125
    //   592: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   595: aload 5
    //   597: athrow
    //   598: astore_1
    //   599: aload 7
    //   601: astore 5
    //   603: aload 6
    //   605: astore_1
    //   606: iload_2
    //   607: ifeq +337 -> 944
    //   610: ldc 116
    //   612: invokestatic 273	androidx/camera/core/al:U	(Ljava/lang/String;)V
    //   615: aload 9
    //   617: invokevirtual 177	android/media/ImageWriter:dequeueInputImage	()Landroid/media/Image;
    //   620: astore 6
    //   622: aload 6
    //   624: astore_1
    //   625: aload_1
    //   626: invokevirtual 205	android/media/Image:getPlanes	()[Landroid/media/Image$Plane;
    //   629: iconst_0
    //   630: aaload
    //   631: invokevirtual 211	android/media/Image$Plane:getBuffer	()Ljava/nio/ByteBuffer;
    //   634: astore 6
    //   636: aload 6
    //   638: invokevirtual 277	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   641: pop
    //   642: aload 6
    //   644: iconst_0
    //   645: invokevirtual 260	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   648: pop
    //   649: aload 9
    //   651: aload_1
    //   652: invokevirtual 266	android/media/ImageWriter:queueInputImage	(Landroid/media/Image;)V
    //   655: aload_0
    //   656: getfield 48	androidx/camera/core/a/i:mLock	Ljava/lang/Object;
    //   659: astore 6
    //   661: aload 6
    //   663: monitorenter
    //   664: iload_2
    //   665: ifeq +71 -> 736
    //   668: aload_0
    //   669: getfield 52	androidx/camera/core/a/i:Qt	I
    //   672: istore_2
    //   673: aload_0
    //   674: iload_2
    //   675: iconst_1
    //   676: isub
    //   677: putfield 52	androidx/camera/core/a/i:Qt	I
    //   680: iload_2
    //   681: ifne +55 -> 736
    //   684: aload_0
    //   685: getfield 50	androidx/camera/core/a/i:mClosed	Z
    //   688: ifeq +48 -> 736
    //   691: iconst_1
    //   692: istore_2
    //   693: aload 6
    //   695: monitorexit
    //   696: aload_1
    //   697: ifnull +7 -> 704
    //   700: aload_1
    //   701: invokevirtual 278	android/media/Image:close	()V
    //   704: aload 5
    //   706: ifnull +10 -> 716
    //   709: aload 5
    //   711: invokeinterface 173 1 0
    //   716: iload_2
    //   717: ifeq +13 -> 730
    //   720: aload 9
    //   722: invokevirtual 267	android/media/ImageWriter:close	()V
    //   725: ldc 116
    //   727: invokestatic 270	androidx/camera/core/al:O	(Ljava/lang/String;)V
    //   730: ldc 125
    //   732: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   735: return
    //   736: iconst_0
    //   737: istore_2
    //   738: goto -45 -> 693
    //   741: astore_1
    //   742: aload 6
    //   744: monitorexit
    //   745: ldc 125
    //   747: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   750: aload_1
    //   751: athrow
    //   752: astore_1
    //   753: aconst_null
    //   754: astore 6
    //   756: aload_0
    //   757: getfield 48	androidx/camera/core/a/i:mLock	Ljava/lang/Object;
    //   760: astore 7
    //   762: aload 7
    //   764: monitorenter
    //   765: iload_2
    //   766: ifeq +74 -> 840
    //   769: aload_0
    //   770: getfield 52	androidx/camera/core/a/i:Qt	I
    //   773: istore_2
    //   774: aload_0
    //   775: iload_2
    //   776: iconst_1
    //   777: isub
    //   778: putfield 52	androidx/camera/core/a/i:Qt	I
    //   781: iload_2
    //   782: ifne +58 -> 840
    //   785: aload_0
    //   786: getfield 50	androidx/camera/core/a/i:mClosed	Z
    //   789: ifeq +51 -> 840
    //   792: iconst_1
    //   793: istore_2
    //   794: aload 7
    //   796: monitorexit
    //   797: aload 6
    //   799: ifnull +8 -> 807
    //   802: aload 6
    //   804: invokevirtual 278	android/media/Image:close	()V
    //   807: aload 5
    //   809: ifnull +10 -> 819
    //   812: aload 5
    //   814: invokeinterface 173 1 0
    //   819: iload_2
    //   820: ifeq +13 -> 833
    //   823: aload 9
    //   825: invokevirtual 267	android/media/ImageWriter:close	()V
    //   828: ldc 116
    //   830: invokestatic 270	androidx/camera/core/al:O	(Ljava/lang/String;)V
    //   833: ldc 125
    //   835: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   838: aload_1
    //   839: athrow
    //   840: iconst_0
    //   841: istore_2
    //   842: goto -48 -> 794
    //   845: astore_1
    //   846: aload 7
    //   848: monitorexit
    //   849: ldc 125
    //   851: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   854: aload_1
    //   855: athrow
    //   856: astore 7
    //   858: aconst_null
    //   859: astore 6
    //   861: aload_1
    //   862: astore 5
    //   864: aload 7
    //   866: astore_1
    //   867: goto -111 -> 756
    //   870: astore 5
    //   872: aload_1
    //   873: astore 7
    //   875: aload 5
    //   877: astore_1
    //   878: aload 7
    //   880: astore 5
    //   882: goto -126 -> 756
    //   885: astore_1
    //   886: goto -130 -> 756
    //   889: astore 7
    //   891: aload_1
    //   892: astore 6
    //   894: aload 7
    //   896: astore_1
    //   897: goto -141 -> 756
    //   900: astore 7
    //   902: aload_1
    //   903: astore 6
    //   905: aload 7
    //   907: astore_1
    //   908: goto -152 -> 756
    //   911: astore 5
    //   913: aload_1
    //   914: astore 5
    //   916: aload 6
    //   918: astore_1
    //   919: goto -313 -> 606
    //   922: astore 5
    //   924: aload_1
    //   925: astore 5
    //   927: aload 6
    //   929: astore_1
    //   930: goto -324 -> 606
    //   933: astore_1
    //   934: aload 6
    //   936: astore_1
    //   937: aload 7
    //   939: astore 5
    //   941: goto -335 -> 606
    //   944: goto -289 -> 655
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	947	0	this	i
    //   0	947	1	paramam	androidx.camera.core.impl.am
    //   107	735	2	i	int
    //   335	168	3	j	int
    //   25	552	4	bool	boolean
    //   11	121	5	localList	java.util.List
    //   191	10	5	localObject1	Object
    //   208	301	5	localObject2	Object
    //   586	10	5	localObject3	Object
    //   601	262	5	localObject4	Object
    //   870	6	5	localObject5	Object
    //   880	1	5	localObject6	Object
    //   911	1	5	localException1	java.lang.Exception
    //   914	1	5	localam1	androidx.camera.core.impl.am
    //   922	1	5	localException2	java.lang.Exception
    //   925	15	5	localObject7	Object
    //   137	798	6	localObject8	Object
    //   134	713	7	localObject9	Object
    //   856	9	7	localObject10	Object
    //   873	6	7	localam2	androidx.camera.core.impl.am
    //   889	6	7	localObject11	Object
    //   900	38	7	localObject12	Object
    //   74	437	8	localObject13	Object
    //   97	727	9	localImageWriter	ImageWriter
    //   112	332	10	localRect	Rect
    //   320	181	11	localByteBuffer	java.nio.ByteBuffer
    //   353	97	12	localObject14	Object
    //   366	39	13	locala	androidx.camera.core.impl.a.g.a
    // Exception table:
    //   from	to	target	type
    //   93	106	191	finally
    //   108	114	191	finally
    //   118	128	191	finally
    //   128	130	191	finally
    //   528	540	586	finally
    //   544	551	586	finally
    //   553	555	586	finally
    //   139	150	598	java/lang/Exception
    //   668	680	741	finally
    //   684	691	741	finally
    //   693	696	741	finally
    //   139	150	752	finally
    //   769	781	845	finally
    //   785	792	845	finally
    //   794	797	845	finally
    //   154	165	856	finally
    //   203	210	856	finally
    //   214	226	870	finally
    //   234	246	885	finally
    //   257	264	885	finally
    //   272	302	885	finally
    //   310	322	885	finally
    //   330	336	885	finally
    //   344	355	885	finally
    //   363	368	885	finally
    //   376	390	885	finally
    //   398	434	885	finally
    //   442	455	885	finally
    //   463	470	885	finally
    //   482	493	885	finally
    //   500	507	885	finally
    //   514	521	885	finally
    //   610	622	889	finally
    //   625	655	900	finally
    //   154	165	911	java/lang/Exception
    //   203	210	911	java/lang/Exception
    //   214	226	922	java/lang/Exception
    //   234	246	933	java/lang/Exception
    //   257	264	933	java/lang/Exception
    //   272	302	933	java/lang/Exception
    //   310	322	933	java/lang/Exception
    //   330	336	933	java/lang/Exception
    //   344	355	933	java/lang/Exception
    //   363	368	933	java/lang/Exception
    //   376	390	933	java/lang/Exception
    //   398	434	933	java/lang/Exception
    //   442	455	933	java/lang/Exception
    //   463	470	933	java/lang/Exception
    //   482	493	933	java/lang/Exception
    //   500	507	933	java/lang/Exception
    //   514	521	933	java/lang/Exception
  }
  
  public final void c(Size paramSize)
  {
    AppMethodBeat.i(199166);
    synchronized (this.mLock)
    {
      this.Qv = new Rect(0, 0, paramSize.getWidth(), paramSize.getHeight());
      AppMethodBeat.o(199166);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.core.a.i
 * JD-Core Version:    0.7.0.1
 */