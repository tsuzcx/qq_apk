package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class e
{
  private static final int jQc;
  private static final int jQd;
  private static final int jQe;
  private static final int jQf;
  private static final int jQg;
  private static final int jQh;
  private static final int jQi;
  private static final int jQj;
  private static final int jQk;
  private static final int jQl;
  private static final int jQm;
  private static final int jQn;
  private static final int jQo;
  
  static
  {
    AppMethodBeat.i(133865);
    jQc = aF(new byte[] { 102, 114, 101, 101 });
    jQd = aF(new byte[] { 106, 117, 110, 107 });
    jQe = aF(new byte[] { 109, 100, 97, 116 });
    jQf = aF(new byte[] { 109, 111, 111, 118 });
    jQg = aF(new byte[] { 112, 110, 111, 116 });
    jQh = aF(new byte[] { 115, 107, 105, 112 });
    jQi = aF(new byte[] { 119, 105, 100, 101 });
    jQj = aF(new byte[] { 80, 73, 67, 84 });
    jQk = aF(new byte[] { 102, 116, 121, 112 });
    jQl = aF(new byte[] { 117, 117, 105, 100 });
    jQm = aF(new byte[] { 99, 109, 111, 118 });
    jQn = aF(new byte[] { 115, 116, 99, 111 });
    jQo = aF(new byte[] { 99, 111, 54, 52 });
    AppMethodBeat.o(133865);
  }
  
  private static int AR(long paramLong)
  {
    AppMethodBeat.i(133860);
    if ((paramLong > 2147483647L) || (paramLong < 0L))
    {
      Exception localException = new Exception("uint32 value is too large");
      AppMethodBeat.o(133860);
      throw localException;
    }
    int i = (int)paramLong;
    AppMethodBeat.o(133860);
    return i;
  }
  
  private static boolean a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(133861);
    paramByteBuffer.clear();
    int i = paramFileChannel.read(paramByteBuffer);
    paramByteBuffer.flip();
    if (i == paramByteBuffer.capacity())
    {
      AppMethodBeat.o(133861);
      return true;
    }
    AppMethodBeat.o(133861);
    return false;
  }
  
  private static int aF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133859);
    int i = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN).getInt();
    AppMethodBeat.o(133859);
    return i;
  }
  
  /* Error */
  public static boolean b(java.lang.String paramString1, java.lang.String paramString2, com.tencent.mm.pointers.PInt paramPInt)
  {
    // Byte code:
    //   0: ldc 142
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 144	com/tencent/mm/vfs/o
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 145	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   13: astore 20
    //   15: new 144	com/tencent/mm/vfs/o
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 145	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   23: astore 26
    //   25: aload 20
    //   27: getfield 149	com/tencent/mm/vfs/o:mUri	Landroid/net/Uri;
    //   30: aload 20
    //   32: invokevirtual 153	com/tencent/mm/vfs/o:heo	()Lcom/tencent/mm/vfs/g$e;
    //   35: invokestatic 159	com/tencent/mm/vfs/s:c	(Landroid/net/Uri;Lcom/tencent/mm/vfs/g$e;)Ljava/nio/channels/ReadableByteChannel;
    //   38: checkcast 110	java/nio/channels/FileChannel
    //   41: astore 21
    //   43: aload 26
    //   45: getfield 149	com/tencent/mm/vfs/o:mUri	Landroid/net/Uri;
    //   48: aload 26
    //   50: invokevirtual 153	com/tencent/mm/vfs/o:heo	()Lcom/tencent/mm/vfs/g$e;
    //   53: invokestatic 163	com/tencent/mm/vfs/s:d	(Landroid/net/Uri;Lcom/tencent/mm/vfs/g$e;)Ljava/nio/channels/WritableByteChannel;
    //   56: checkcast 110	java/nio/channels/FileChannel
    //   59: astore 25
    //   61: iconst_0
    //   62: istore 4
    //   64: lconst_0
    //   65: lstore 12
    //   67: aconst_null
    //   68: astore 20
    //   70: aload 21
    //   72: astore 22
    //   74: aload 25
    //   76: astore 23
    //   78: bipush 8
    //   80: invokestatic 167	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   83: getstatic 132	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   86: invokevirtual 136	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   89: astore 27
    //   91: lconst_0
    //   92: lstore 14
    //   94: iconst_0
    //   95: istore_3
    //   96: iconst_0
    //   97: istore 5
    //   99: iconst_0
    //   100: istore 8
    //   102: aload 21
    //   104: astore 22
    //   106: aload 25
    //   108: astore 23
    //   110: iload_3
    //   111: istore 6
    //   113: aload 20
    //   115: astore 24
    //   117: iload 4
    //   119: istore 7
    //   121: aload 21
    //   123: aload 27
    //   125: invokestatic 169	com/tencent/mm/plugin/a/e:a	(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;)Z
    //   128: ifeq +1505 -> 1633
    //   131: aload 21
    //   133: astore 22
    //   135: aload 25
    //   137: astore 23
    //   139: aload 27
    //   141: invokevirtual 139	java/nio/ByteBuffer:getInt	()I
    //   144: i2l
    //   145: ldc2_w 170
    //   148: land
    //   149: lstore 10
    //   151: aload 21
    //   153: astore 22
    //   155: aload 25
    //   157: astore 23
    //   159: aload 27
    //   161: invokevirtual 139	java/nio/ByteBuffer:getInt	()I
    //   164: istore 4
    //   166: aload 21
    //   168: astore 22
    //   170: aload 25
    //   172: astore 23
    //   174: iload 4
    //   176: getstatic 71	com/tencent/mm/plugin/a/e:jQk	I
    //   179: if_icmpne +222 -> 401
    //   182: iconst_1
    //   183: istore 6
    //   185: iconst_1
    //   186: istore_3
    //   187: aload 21
    //   189: astore 22
    //   191: aload 25
    //   193: astore 23
    //   195: lload 10
    //   197: invokestatic 173	com/tencent/mm/plugin/a/e:AR	(J)I
    //   200: istore 9
    //   202: aload 21
    //   204: astore 22
    //   206: aload 25
    //   208: astore 23
    //   210: iload 9
    //   212: invokestatic 167	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   215: getstatic 132	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   218: invokevirtual 136	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   221: astore 20
    //   223: aload 21
    //   225: astore 22
    //   227: aload 25
    //   229: astore 23
    //   231: aload 27
    //   233: invokevirtual 176	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   236: pop
    //   237: aload 21
    //   239: astore 22
    //   241: aload 25
    //   243: astore 23
    //   245: aload 20
    //   247: aload 27
    //   249: invokevirtual 180	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   252: pop
    //   253: aload 21
    //   255: astore 22
    //   257: aload 25
    //   259: astore 23
    //   261: aload 20
    //   263: astore 24
    //   265: lload 10
    //   267: lstore 12
    //   269: iload 4
    //   271: istore 7
    //   273: aload 21
    //   275: aload 20
    //   277: invokevirtual 114	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   280: iload 9
    //   282: bipush 8
    //   284: isub
    //   285: if_icmplt +1348 -> 1633
    //   288: aload 21
    //   290: astore 22
    //   292: aload 25
    //   294: astore 23
    //   296: aload 20
    //   298: invokevirtual 117	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   301: pop
    //   302: aload 21
    //   304: astore 22
    //   306: aload 25
    //   308: astore 23
    //   310: aload 21
    //   312: invokevirtual 184	java/nio/channels/FileChannel:position	()J
    //   315: lstore 14
    //   317: lload 10
    //   319: lstore 12
    //   321: lload 10
    //   323: ldc2_w 185
    //   326: lcmp
    //   327: ifge -225 -> 102
    //   330: aload 21
    //   332: astore 22
    //   334: aload 25
    //   336: astore 23
    //   338: ldc 188
    //   340: ldc 190
    //   342: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: iconst_0
    //   346: istore 18
    //   348: iload 18
    //   350: istore 19
    //   352: iload 18
    //   354: ifeq +18 -> 372
    //   357: aload 21
    //   359: astore 22
    //   361: aload 25
    //   363: astore 23
    //   365: aload_0
    //   366: aload_1
    //   367: invokestatic 200	com/tencent/mm/plugin/a/e:bT	(Ljava/lang/String;Ljava/lang/String;)Z
    //   370: istore 19
    //   372: aload 21
    //   374: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   377: aload 25
    //   379: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   382: iload 19
    //   384: ifne +9 -> 393
    //   387: aload 26
    //   389: invokevirtual 208	com/tencent/mm/vfs/o:delete	()Z
    //   392: pop
    //   393: ldc 142
    //   395: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   398: iload 19
    //   400: ireturn
    //   401: aload 21
    //   403: astore 22
    //   405: aload 25
    //   407: astore 23
    //   409: iload 4
    //   411: getstatic 52	com/tencent/mm/plugin/a/e:jQf	I
    //   414: if_icmpne +111 -> 525
    //   417: aload 21
    //   419: astore 22
    //   421: aload 25
    //   423: astore 23
    //   425: aload 21
    //   427: invokevirtual 184	java/nio/channels/FileChannel:position	()J
    //   430: lstore 12
    //   432: iconst_1
    //   433: istore 6
    //   435: iload 5
    //   437: ifne +37 -> 474
    //   440: aload 21
    //   442: astore 22
    //   444: aload 25
    //   446: astore 23
    //   448: ldc 188
    //   450: ldc 210
    //   452: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: aload 21
    //   457: astore 22
    //   459: aload 25
    //   461: astore 23
    //   463: aload_2
    //   464: iconst_1
    //   465: putfield 217	com/tencent/mm/pointers/PInt:value	I
    //   468: iconst_0
    //   469: istore 18
    //   471: goto -123 -> 348
    //   474: aload 21
    //   476: astore 22
    //   478: aload 25
    //   480: astore 23
    //   482: ldc 188
    //   484: ldc 219
    //   486: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: lload 12
    //   491: ldc2_w 185
    //   494: lsub
    //   495: lstore 12
    //   497: iload 6
    //   499: istore 5
    //   501: goto +1160 -> 1661
    //   504: aload 21
    //   506: astore 22
    //   508: aload 25
    //   510: astore 23
    //   512: ldc 188
    //   514: ldc 221
    //   516: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: iconst_0
    //   520: istore 18
    //   522: goto -174 -> 348
    //   525: aload 21
    //   527: astore 22
    //   529: aload 25
    //   531: astore 23
    //   533: iload 4
    //   535: getstatic 48	com/tencent/mm/plugin/a/e:jQe	I
    //   538: if_icmpne +6 -> 544
    //   541: iconst_1
    //   542: istore 5
    //   544: lload 10
    //   546: lconst_1
    //   547: lcmp
    //   548: ifne +218 -> 766
    //   551: aload 21
    //   553: astore 22
    //   555: aload 25
    //   557: astore 23
    //   559: aload 27
    //   561: invokevirtual 108	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   564: pop
    //   565: aload 21
    //   567: astore 22
    //   569: aload 25
    //   571: astore 23
    //   573: iload_3
    //   574: istore 6
    //   576: aload 20
    //   578: astore 24
    //   580: lload 10
    //   582: lstore 12
    //   584: iload 4
    //   586: istore 7
    //   588: aload 21
    //   590: aload 27
    //   592: invokestatic 169	com/tencent/mm/plugin/a/e:a	(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;)Z
    //   595: ifeq +1038 -> 1633
    //   598: aload 21
    //   600: astore 22
    //   602: aload 25
    //   604: astore 23
    //   606: aload 27
    //   608: invokevirtual 224	java/nio/ByteBuffer:getLong	()J
    //   611: lstore 10
    //   613: lload 10
    //   615: lconst_0
    //   616: lcmp
    //   617: ifge +98 -> 715
    //   620: aload 21
    //   622: astore 22
    //   624: aload 25
    //   626: astore 23
    //   628: new 93	java/lang/Exception
    //   631: dup
    //   632: ldc 226
    //   634: invokespecial 99	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   637: astore_0
    //   638: aload 21
    //   640: astore 22
    //   642: aload 25
    //   644: astore 23
    //   646: ldc 142
    //   648: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   651: aload 21
    //   653: astore 22
    //   655: aload 25
    //   657: astore 23
    //   659: aload_0
    //   660: athrow
    //   661: astore_0
    //   662: iconst_0
    //   663: istore 18
    //   665: aload 25
    //   667: astore_1
    //   668: aload 21
    //   670: astore 22
    //   672: aload_1
    //   673: astore 23
    //   675: ldc 188
    //   677: new 228	java/lang/StringBuilder
    //   680: dup
    //   681: ldc 230
    //   683: invokespecial 231	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   686: aload_0
    //   687: invokevirtual 235	java/lang/Exception:toString	()Ljava/lang/String;
    //   690: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   699: aload 21
    //   701: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   704: aload_1
    //   705: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   708: iload 18
    //   710: istore 19
    //   712: goto -330 -> 382
    //   715: aload 21
    //   717: astore 22
    //   719: aload 25
    //   721: astore 23
    //   723: aload 21
    //   725: aload 21
    //   727: invokevirtual 184	java/nio/channels/FileChannel:position	()J
    //   730: lload 10
    //   732: ladd
    //   733: ldc2_w 241
    //   736: lsub
    //   737: invokevirtual 245	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   740: pop
    //   741: goto -424 -> 317
    //   744: astore_0
    //   745: aload 22
    //   747: astore 21
    //   749: aload 21
    //   751: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   754: aload 23
    //   756: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   759: ldc 142
    //   761: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   764: aload_0
    //   765: athrow
    //   766: aload 21
    //   768: astore 22
    //   770: aload 25
    //   772: astore 23
    //   774: aload 21
    //   776: aload 21
    //   778: invokevirtual 184	java/nio/channels/FileChannel:position	()J
    //   781: lload 10
    //   783: ladd
    //   784: ldc2_w 185
    //   787: lsub
    //   788: invokevirtual 245	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   791: pop
    //   792: goto -475 -> 317
    //   795: aload 21
    //   797: astore 22
    //   799: aload 25
    //   801: astore 23
    //   803: iload 4
    //   805: getstatic 52	com/tencent/mm/plugin/a/e:jQf	I
    //   808: if_icmpne +10 -> 818
    //   811: lload 12
    //   813: lconst_0
    //   814: lcmp
    //   815: ifge +24 -> 839
    //   818: aload 21
    //   820: astore 22
    //   822: aload 25
    //   824: astore 23
    //   826: ldc 188
    //   828: ldc 247
    //   830: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   833: iconst_0
    //   834: istore 18
    //   836: goto -488 -> 348
    //   839: aload 21
    //   841: astore 22
    //   843: aload 25
    //   845: astore 23
    //   847: lload 10
    //   849: invokestatic 173	com/tencent/mm/plugin/a/e:AR	(J)I
    //   852: istore 4
    //   854: aload 21
    //   856: astore 22
    //   858: aload 25
    //   860: astore 23
    //   862: iload 4
    //   864: invokestatic 167	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   867: getstatic 132	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   870: invokevirtual 136	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   873: astore_2
    //   874: aload 21
    //   876: astore 22
    //   878: aload 25
    //   880: astore 23
    //   882: aload_2
    //   883: invokevirtual 108	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   886: pop
    //   887: aload 21
    //   889: astore 22
    //   891: aload 25
    //   893: astore 23
    //   895: aload 21
    //   897: aload_2
    //   898: lload 12
    //   900: invokevirtual 250	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;J)I
    //   903: istore_3
    //   904: aload 21
    //   906: astore 22
    //   908: aload 25
    //   910: astore 23
    //   912: aload_2
    //   913: invokevirtual 117	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   916: pop
    //   917: aload 21
    //   919: astore 22
    //   921: aload 25
    //   923: astore 23
    //   925: iload_3
    //   926: aload_2
    //   927: invokevirtual 121	java/nio/ByteBuffer:capacity	()I
    //   930: if_icmpne +743 -> 1673
    //   933: iconst_1
    //   934: istore_3
    //   935: iload_3
    //   936: ifne +24 -> 960
    //   939: aload 21
    //   941: astore 22
    //   943: aload 25
    //   945: astore 23
    //   947: ldc 188
    //   949: ldc 252
    //   951: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   954: iconst_0
    //   955: istore 18
    //   957: goto -609 -> 348
    //   960: aload 21
    //   962: astore 22
    //   964: aload 25
    //   966: astore 23
    //   968: aload_2
    //   969: bipush 12
    //   971: invokevirtual 255	java/nio/ByteBuffer:getInt	(I)I
    //   974: getstatic 76	com/tencent/mm/plugin/a/e:jQm	I
    //   977: if_icmpne +25 -> 1002
    //   980: aload 21
    //   982: astore 22
    //   984: aload 25
    //   986: astore 23
    //   988: ldc 188
    //   990: ldc_w 257
    //   993: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   996: iconst_0
    //   997: istore 18
    //   999: goto -651 -> 348
    //   1002: aload 21
    //   1004: astore 22
    //   1006: aload 25
    //   1008: astore 23
    //   1010: aload_2
    //   1011: invokevirtual 260	java/nio/ByteBuffer:remaining	()I
    //   1014: bipush 8
    //   1016: if_icmplt +430 -> 1446
    //   1019: aload 21
    //   1021: astore 22
    //   1023: aload 25
    //   1025: astore 23
    //   1027: aload_2
    //   1028: invokevirtual 262	java/nio/ByteBuffer:position	()I
    //   1031: istore 5
    //   1033: aload 21
    //   1035: astore 22
    //   1037: aload 25
    //   1039: astore 23
    //   1041: aload_2
    //   1042: iload 5
    //   1044: iconst_4
    //   1045: iadd
    //   1046: invokevirtual 255	java/nio/ByteBuffer:getInt	(I)I
    //   1049: istore_3
    //   1050: aload 21
    //   1052: astore 22
    //   1054: aload 25
    //   1056: astore 23
    //   1058: iload_3
    //   1059: getstatic 78	com/tencent/mm/plugin/a/e:jQn	I
    //   1062: if_icmpeq +40 -> 1102
    //   1065: aload 21
    //   1067: astore 22
    //   1069: aload 25
    //   1071: astore 23
    //   1073: iload_3
    //   1074: getstatic 82	com/tencent/mm/plugin/a/e:jQo	I
    //   1077: if_icmpeq +25 -> 1102
    //   1080: aload 21
    //   1082: astore 22
    //   1084: aload 25
    //   1086: astore 23
    //   1088: aload_2
    //   1089: aload_2
    //   1090: invokevirtual 262	java/nio/ByteBuffer:position	()I
    //   1093: iconst_1
    //   1094: iadd
    //   1095: invokevirtual 265	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1098: pop
    //   1099: goto -97 -> 1002
    //   1102: aload 21
    //   1104: astore 22
    //   1106: aload 25
    //   1108: astore 23
    //   1110: aload_2
    //   1111: iload 5
    //   1113: invokevirtual 255	java/nio/ByteBuffer:getInt	(I)I
    //   1116: i2l
    //   1117: ldc2_w 170
    //   1120: land
    //   1121: aload_2
    //   1122: invokevirtual 260	java/nio/ByteBuffer:remaining	()I
    //   1125: i2l
    //   1126: lcmp
    //   1127: ifle +25 -> 1152
    //   1130: aload 21
    //   1132: astore 22
    //   1134: aload 25
    //   1136: astore 23
    //   1138: ldc 188
    //   1140: ldc_w 267
    //   1143: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1146: iconst_0
    //   1147: istore 18
    //   1149: goto -801 -> 348
    //   1152: aload 21
    //   1154: astore 22
    //   1156: aload 25
    //   1158: astore 23
    //   1160: aload_2
    //   1161: iload 5
    //   1163: bipush 12
    //   1165: iadd
    //   1166: invokevirtual 265	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1169: pop
    //   1170: aload 21
    //   1172: astore 22
    //   1174: aload 25
    //   1176: astore 23
    //   1178: aload_2
    //   1179: invokevirtual 260	java/nio/ByteBuffer:remaining	()I
    //   1182: iconst_4
    //   1183: if_icmpge +25 -> 1208
    //   1186: aload 21
    //   1188: astore 22
    //   1190: aload 25
    //   1192: astore 23
    //   1194: ldc 188
    //   1196: ldc_w 269
    //   1199: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1202: iconst_0
    //   1203: istore 18
    //   1205: goto -857 -> 348
    //   1208: aload 21
    //   1210: astore 22
    //   1212: aload 25
    //   1214: astore 23
    //   1216: aload_2
    //   1217: invokevirtual 139	java/nio/ByteBuffer:getInt	()I
    //   1220: i2l
    //   1221: invokestatic 173	com/tencent/mm/plugin/a/e:AR	(J)I
    //   1224: istore 5
    //   1226: aload 21
    //   1228: astore 22
    //   1230: aload 25
    //   1232: astore 23
    //   1234: iload_3
    //   1235: getstatic 78	com/tencent/mm/plugin/a/e:jQn	I
    //   1238: if_icmpne +113 -> 1351
    //   1241: aload 21
    //   1243: astore 22
    //   1245: aload 25
    //   1247: astore 23
    //   1249: aload_2
    //   1250: invokevirtual 260	java/nio/ByteBuffer:remaining	()I
    //   1253: iload 5
    //   1255: iconst_4
    //   1256: imul
    //   1257: if_icmpge +421 -> 1678
    //   1260: aload 21
    //   1262: astore 22
    //   1264: aload 25
    //   1266: astore 23
    //   1268: ldc 188
    //   1270: ldc_w 271
    //   1273: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1276: iconst_0
    //   1277: istore 18
    //   1279: goto -931 -> 348
    //   1282: iload_3
    //   1283: iload 5
    //   1285: if_icmpge -283 -> 1002
    //   1288: aload 21
    //   1290: astore 22
    //   1292: aload 25
    //   1294: astore 23
    //   1296: aload_2
    //   1297: aload_2
    //   1298: invokevirtual 262	java/nio/ByteBuffer:position	()I
    //   1301: invokevirtual 255	java/nio/ByteBuffer:getInt	(I)I
    //   1304: istore 6
    //   1306: iload 6
    //   1308: iload 4
    //   1310: iadd
    //   1311: istore 7
    //   1313: iload 6
    //   1315: ifge +14 -> 1329
    //   1318: iload 7
    //   1320: iflt +9 -> 1329
    //   1323: iconst_0
    //   1324: istore 18
    //   1326: goto -978 -> 348
    //   1329: aload 21
    //   1331: astore 22
    //   1333: aload 25
    //   1335: astore 23
    //   1337: aload_2
    //   1338: iload 7
    //   1340: invokevirtual 274	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1343: pop
    //   1344: iload_3
    //   1345: iconst_1
    //   1346: iadd
    //   1347: istore_3
    //   1348: goto -66 -> 1282
    //   1351: aload 21
    //   1353: astore 22
    //   1355: aload 25
    //   1357: astore 23
    //   1359: iload_3
    //   1360: getstatic 82	com/tencent/mm/plugin/a/e:jQo	I
    //   1363: if_icmpne -361 -> 1002
    //   1366: aload 21
    //   1368: astore 22
    //   1370: aload 25
    //   1372: astore 23
    //   1374: aload_2
    //   1375: invokevirtual 260	java/nio/ByteBuffer:remaining	()I
    //   1378: iload 5
    //   1380: bipush 8
    //   1382: imul
    //   1383: if_icmpge +300 -> 1683
    //   1386: aload 21
    //   1388: astore 22
    //   1390: aload 25
    //   1392: astore 23
    //   1394: ldc 188
    //   1396: ldc_w 271
    //   1399: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1402: iconst_0
    //   1403: istore 18
    //   1405: goto -1057 -> 348
    //   1408: iload_3
    //   1409: iload 5
    //   1411: if_icmpge -409 -> 1002
    //   1414: aload 21
    //   1416: astore 22
    //   1418: aload 25
    //   1420: astore 23
    //   1422: aload_2
    //   1423: aload_2
    //   1424: aload_2
    //   1425: invokevirtual 262	java/nio/ByteBuffer:position	()I
    //   1428: invokevirtual 277	java/nio/ByteBuffer:getLong	(I)J
    //   1431: iload 4
    //   1433: i2l
    //   1434: ladd
    //   1435: invokevirtual 281	java/nio/ByteBuffer:putLong	(J)Ljava/nio/ByteBuffer;
    //   1438: pop
    //   1439: iload_3
    //   1440: iconst_1
    //   1441: iadd
    //   1442: istore_3
    //   1443: goto -35 -> 1408
    //   1446: aload 21
    //   1448: astore 22
    //   1450: aload 25
    //   1452: astore 23
    //   1454: aload 21
    //   1456: lload 14
    //   1458: invokevirtual 245	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   1461: pop
    //   1462: aload 20
    //   1464: ifnull +33 -> 1497
    //   1467: aload 21
    //   1469: astore 22
    //   1471: aload 25
    //   1473: astore 23
    //   1475: aload 20
    //   1477: invokevirtual 176	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1480: pop
    //   1481: aload 21
    //   1483: astore 22
    //   1485: aload 25
    //   1487: astore 23
    //   1489: aload 25
    //   1491: aload 20
    //   1493: invokevirtual 284	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   1496: pop
    //   1497: aload 21
    //   1499: astore 22
    //   1501: aload 25
    //   1503: astore 23
    //   1505: aload_2
    //   1506: invokevirtual 176	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1509: pop
    //   1510: aload 21
    //   1512: astore 22
    //   1514: aload 25
    //   1516: astore 23
    //   1518: aload 25
    //   1520: aload_2
    //   1521: invokevirtual 284	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   1524: pop
    //   1525: aload 21
    //   1527: astore 22
    //   1529: aload 25
    //   1531: astore 23
    //   1533: aload 21
    //   1535: lload 14
    //   1537: lload 12
    //   1539: lload 14
    //   1541: lsub
    //   1542: aload 25
    //   1544: invokevirtual 288	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   1547: pop2
    //   1548: aload 21
    //   1550: astore 22
    //   1552: aload 25
    //   1554: astore 23
    //   1556: aload 21
    //   1558: iload 4
    //   1560: i2l
    //   1561: lload 12
    //   1563: ladd
    //   1564: aload 21
    //   1566: invokevirtual 291	java/nio/channels/FileChannel:size	()J
    //   1569: lload 12
    //   1571: lsub
    //   1572: iload 4
    //   1574: i2l
    //   1575: lsub
    //   1576: aload 25
    //   1578: invokevirtual 288	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   1581: pop2
    //   1582: iconst_1
    //   1583: istore 18
    //   1585: goto -1237 -> 348
    //   1588: astore_0
    //   1589: aconst_null
    //   1590: astore 23
    //   1592: aconst_null
    //   1593: astore 21
    //   1595: goto -846 -> 749
    //   1598: astore_0
    //   1599: aconst_null
    //   1600: astore 23
    //   1602: goto -853 -> 749
    //   1605: astore_0
    //   1606: aconst_null
    //   1607: astore_1
    //   1608: aconst_null
    //   1609: astore 21
    //   1611: iconst_0
    //   1612: istore 18
    //   1614: goto -946 -> 668
    //   1617: astore_0
    //   1618: aconst_null
    //   1619: astore_1
    //   1620: iconst_0
    //   1621: istore 18
    //   1623: goto -955 -> 668
    //   1626: astore_0
    //   1627: aload 25
    //   1629: astore_1
    //   1630: goto -962 -> 668
    //   1633: ldc2_w 292
    //   1636: lstore 16
    //   1638: iload 7
    //   1640: istore 4
    //   1642: lload 12
    //   1644: lstore 10
    //   1646: aload 24
    //   1648: astore 20
    //   1650: iload 6
    //   1652: istore_3
    //   1653: lload 16
    //   1655: lstore 12
    //   1657: iload 8
    //   1659: istore 5
    //   1661: iload_3
    //   1662: ifeq -1158 -> 504
    //   1665: iload 5
    //   1667: ifne -872 -> 795
    //   1670: goto -1166 -> 504
    //   1673: iconst_0
    //   1674: istore_3
    //   1675: goto -740 -> 935
    //   1678: iconst_0
    //   1679: istore_3
    //   1680: goto -398 -> 1282
    //   1683: iconst_0
    //   1684: istore_3
    //   1685: goto -277 -> 1408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1688	0	paramString1	java.lang.String
    //   0	1688	1	paramString2	java.lang.String
    //   0	1688	2	paramPInt	com.tencent.mm.pointers.PInt
    //   95	1590	3	i	int
    //   62	1579	4	j	int
    //   97	1569	5	k	int
    //   111	1540	6	m	int
    //   119	1520	7	n	int
    //   100	1558	8	i1	int
    //   200	85	9	i2	int
    //   149	1496	10	l1	long
    //   65	1591	12	l2	long
    //   92	1448	14	l3	long
    //   1636	18	16	l4	long
    //   346	1276	18	bool1	boolean
    //   350	361	19	bool2	boolean
    //   13	1636	20	localObject1	Object
    //   41	1569	21	localObject2	Object
    //   72	1479	22	localObject3	Object
    //   76	1525	23	localObject4	Object
    //   115	1532	24	localObject5	Object
    //   59	1569	25	localFileChannel	FileChannel
    //   23	365	26	localo	com.tencent.mm.vfs.o
    //   89	518	27	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   78	91	661	java/lang/Exception
    //   121	131	661	java/lang/Exception
    //   139	151	661	java/lang/Exception
    //   159	166	661	java/lang/Exception
    //   174	182	661	java/lang/Exception
    //   195	202	661	java/lang/Exception
    //   210	223	661	java/lang/Exception
    //   231	237	661	java/lang/Exception
    //   245	253	661	java/lang/Exception
    //   273	288	661	java/lang/Exception
    //   296	302	661	java/lang/Exception
    //   310	317	661	java/lang/Exception
    //   338	345	661	java/lang/Exception
    //   409	417	661	java/lang/Exception
    //   425	432	661	java/lang/Exception
    //   448	455	661	java/lang/Exception
    //   463	468	661	java/lang/Exception
    //   482	489	661	java/lang/Exception
    //   512	519	661	java/lang/Exception
    //   533	541	661	java/lang/Exception
    //   559	565	661	java/lang/Exception
    //   588	598	661	java/lang/Exception
    //   606	613	661	java/lang/Exception
    //   628	638	661	java/lang/Exception
    //   646	651	661	java/lang/Exception
    //   659	661	661	java/lang/Exception
    //   723	741	661	java/lang/Exception
    //   774	792	661	java/lang/Exception
    //   803	811	661	java/lang/Exception
    //   826	833	661	java/lang/Exception
    //   847	854	661	java/lang/Exception
    //   862	874	661	java/lang/Exception
    //   882	887	661	java/lang/Exception
    //   895	904	661	java/lang/Exception
    //   912	917	661	java/lang/Exception
    //   925	933	661	java/lang/Exception
    //   947	954	661	java/lang/Exception
    //   968	980	661	java/lang/Exception
    //   988	996	661	java/lang/Exception
    //   1010	1019	661	java/lang/Exception
    //   1027	1033	661	java/lang/Exception
    //   1041	1050	661	java/lang/Exception
    //   1058	1065	661	java/lang/Exception
    //   1073	1080	661	java/lang/Exception
    //   1088	1099	661	java/lang/Exception
    //   1110	1130	661	java/lang/Exception
    //   1138	1146	661	java/lang/Exception
    //   1160	1170	661	java/lang/Exception
    //   1178	1186	661	java/lang/Exception
    //   1194	1202	661	java/lang/Exception
    //   1216	1226	661	java/lang/Exception
    //   1234	1241	661	java/lang/Exception
    //   1249	1260	661	java/lang/Exception
    //   1268	1276	661	java/lang/Exception
    //   1296	1306	661	java/lang/Exception
    //   1337	1344	661	java/lang/Exception
    //   1359	1366	661	java/lang/Exception
    //   1374	1386	661	java/lang/Exception
    //   1394	1402	661	java/lang/Exception
    //   1422	1439	661	java/lang/Exception
    //   1454	1462	661	java/lang/Exception
    //   1475	1481	661	java/lang/Exception
    //   1489	1497	661	java/lang/Exception
    //   1505	1510	661	java/lang/Exception
    //   1518	1525	661	java/lang/Exception
    //   1533	1548	661	java/lang/Exception
    //   1556	1582	661	java/lang/Exception
    //   78	91	744	finally
    //   121	131	744	finally
    //   139	151	744	finally
    //   159	166	744	finally
    //   174	182	744	finally
    //   195	202	744	finally
    //   210	223	744	finally
    //   231	237	744	finally
    //   245	253	744	finally
    //   273	288	744	finally
    //   296	302	744	finally
    //   310	317	744	finally
    //   338	345	744	finally
    //   365	372	744	finally
    //   409	417	744	finally
    //   425	432	744	finally
    //   448	455	744	finally
    //   463	468	744	finally
    //   482	489	744	finally
    //   512	519	744	finally
    //   533	541	744	finally
    //   559	565	744	finally
    //   588	598	744	finally
    //   606	613	744	finally
    //   628	638	744	finally
    //   646	651	744	finally
    //   659	661	744	finally
    //   675	699	744	finally
    //   723	741	744	finally
    //   774	792	744	finally
    //   803	811	744	finally
    //   826	833	744	finally
    //   847	854	744	finally
    //   862	874	744	finally
    //   882	887	744	finally
    //   895	904	744	finally
    //   912	917	744	finally
    //   925	933	744	finally
    //   947	954	744	finally
    //   968	980	744	finally
    //   988	996	744	finally
    //   1010	1019	744	finally
    //   1027	1033	744	finally
    //   1041	1050	744	finally
    //   1058	1065	744	finally
    //   1073	1080	744	finally
    //   1088	1099	744	finally
    //   1110	1130	744	finally
    //   1138	1146	744	finally
    //   1160	1170	744	finally
    //   1178	1186	744	finally
    //   1194	1202	744	finally
    //   1216	1226	744	finally
    //   1234	1241	744	finally
    //   1249	1260	744	finally
    //   1268	1276	744	finally
    //   1296	1306	744	finally
    //   1337	1344	744	finally
    //   1359	1366	744	finally
    //   1374	1386	744	finally
    //   1394	1402	744	finally
    //   1422	1439	744	finally
    //   1454	1462	744	finally
    //   1475	1481	744	finally
    //   1489	1497	744	finally
    //   1505	1510	744	finally
    //   1518	1525	744	finally
    //   1533	1548	744	finally
    //   1556	1582	744	finally
    //   25	43	1588	finally
    //   43	61	1598	finally
    //   25	43	1605	java/lang/Exception
    //   43	61	1617	java/lang/Exception
    //   365	372	1626	java/lang/Exception
  }
  
  /* Error */
  private static boolean bT(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: ldc_w 294
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 144	com/tencent/mm/vfs/o
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 145	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: new 144	com/tencent/mm/vfs/o
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 145	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   24: astore 7
    //   26: aload 6
    //   28: invokevirtual 297	com/tencent/mm/vfs/o:length	()J
    //   31: aload 7
    //   33: invokevirtual 297	com/tencent/mm/vfs/o:length	()J
    //   36: lcmp
    //   37: ifeq +19 -> 56
    //   40: ldc 188
    //   42: ldc_w 299
    //   45: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc_w 294
    //   51: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: iconst_0
    //   55: ireturn
    //   56: new 301	com/tencent/mm/plugin/a/b
    //   59: dup
    //   60: invokespecial 303	com/tencent/mm/plugin/a/b:<init>	()V
    //   63: aload_0
    //   64: invokevirtual 307	com/tencent/mm/plugin/a/b:Sw	(Ljava/lang/String;)J
    //   67: lstore 4
    //   69: new 309	com/tencent/mm/plugin/a/j
    //   72: dup
    //   73: invokespecial 310	com/tencent/mm/plugin/a/j:<init>	()V
    //   76: astore 9
    //   78: aload 9
    //   80: aload_0
    //   81: lload 4
    //   83: invokevirtual 314	com/tencent/mm/plugin/a/j:L	(Ljava/lang/String;J)Z
    //   86: pop
    //   87: aload 9
    //   89: getfield 317	com/tencent/mm/plugin/a/j:jQw	I
    //   92: istore_3
    //   93: new 301	com/tencent/mm/plugin/a/b
    //   96: dup
    //   97: invokespecial 303	com/tencent/mm/plugin/a/b:<init>	()V
    //   100: aload_1
    //   101: invokevirtual 307	com/tencent/mm/plugin/a/b:Sw	(Ljava/lang/String;)J
    //   104: lstore 4
    //   106: new 309	com/tencent/mm/plugin/a/j
    //   109: dup
    //   110: invokespecial 310	com/tencent/mm/plugin/a/j:<init>	()V
    //   113: astore 8
    //   115: aload 8
    //   117: aload_1
    //   118: lload 4
    //   120: invokevirtual 314	com/tencent/mm/plugin/a/j:L	(Ljava/lang/String;J)Z
    //   123: pop
    //   124: aload 8
    //   126: getfield 317	com/tencent/mm/plugin/a/j:jQw	I
    //   129: istore_2
    //   130: iload_2
    //   131: iload_3
    //   132: if_icmpeq +19 -> 151
    //   135: ldc 188
    //   137: ldc_w 319
    //   140: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: ldc_w 294
    //   146: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: ldc 188
    //   153: new 228	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 321
    //   160: invokespecial 231	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: iload_3
    //   164: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 326
    //   170: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload_2
    //   174: invokevirtual 324	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 212	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: new 328	java/util/Random
    //   186: dup
    //   187: invokespecial 329	java/util/Random:<init>	()V
    //   190: iload_2
    //   191: iconst_1
    //   192: isub
    //   193: invokevirtual 332	java/util/Random:nextInt	(I)I
    //   196: iconst_1
    //   197: iadd
    //   198: istore_3
    //   199: iload_3
    //   200: iconst_1
    //   201: iadd
    //   202: iload_2
    //   203: if_icmple +88 -> 291
    //   206: new 214	com/tencent/mm/pointers/PInt
    //   209: dup
    //   210: invokespecial 333	com/tencent/mm/pointers/PInt:<init>	()V
    //   213: astore_0
    //   214: new 214	com/tencent/mm/pointers/PInt
    //   217: dup
    //   218: invokespecial 333	com/tencent/mm/pointers/PInt:<init>	()V
    //   221: astore 10
    //   223: aload 9
    //   225: iload_3
    //   226: iload_2
    //   227: aload_0
    //   228: aload 10
    //   230: invokevirtual 336	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   233: pop
    //   234: new 214	com/tencent/mm/pointers/PInt
    //   237: dup
    //   238: invokespecial 333	com/tencent/mm/pointers/PInt:<init>	()V
    //   241: astore_1
    //   242: new 214	com/tencent/mm/pointers/PInt
    //   245: dup
    //   246: invokespecial 333	com/tencent/mm/pointers/PInt:<init>	()V
    //   249: astore 9
    //   251: aload 8
    //   253: iload_3
    //   254: iload_2
    //   255: aload_1
    //   256: aload 9
    //   258: invokevirtual 336	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   261: pop
    //   262: aload 9
    //   264: getfield 217	com/tencent/mm/pointers/PInt:value	I
    //   267: aload 10
    //   269: getfield 217	com/tencent/mm/pointers/PInt:value	I
    //   272: if_icmpeq +26 -> 298
    //   275: ldc 188
    //   277: ldc_w 338
    //   280: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: ldc_w 294
    //   286: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: iload_3
    //   292: iconst_1
    //   293: iadd
    //   294: istore_2
    //   295: goto -89 -> 206
    //   298: aload 6
    //   300: invokestatic 342	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   303: astore 6
    //   305: aload 6
    //   307: aload_0
    //   308: getfield 217	com/tencent/mm/pointers/PInt:value	I
    //   311: i2l
    //   312: invokevirtual 348	java/io/InputStream:skip	(J)J
    //   315: pop2
    //   316: sipush 4096
    //   319: newarray byte
    //   321: astore 8
    //   323: aload 6
    //   325: aload 8
    //   327: invokevirtual 350	java/io/InputStream:read	([B)I
    //   330: pop
    //   331: aload 7
    //   333: invokestatic 342	com/tencent/mm/vfs/s:ao	(Lcom/tencent/mm/vfs/o;)Ljava/io/InputStream;
    //   336: astore_0
    //   337: aload_0
    //   338: aload_1
    //   339: getfield 217	com/tencent/mm/pointers/PInt:value	I
    //   342: i2l
    //   343: invokevirtual 348	java/io/InputStream:skip	(J)J
    //   346: pop2
    //   347: sipush 4096
    //   350: newarray byte
    //   352: astore_1
    //   353: aload 6
    //   355: aload_1
    //   356: invokevirtual 350	java/io/InputStream:read	([B)I
    //   359: pop
    //   360: aload 8
    //   362: aload_1
    //   363: invokestatic 356	java/util/Arrays:equals	([B[B)Z
    //   366: ifeq +28 -> 394
    //   369: ldc 188
    //   371: ldc_w 358
    //   374: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload 6
    //   379: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   382: aload_0
    //   383: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   386: ldc_w 294
    //   389: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: iconst_0
    //   393: ireturn
    //   394: aload 6
    //   396: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   399: aload_0
    //   400: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   403: ldc_w 294
    //   406: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   409: iconst_1
    //   410: ireturn
    //   411: astore_0
    //   412: aconst_null
    //   413: astore_1
    //   414: aconst_null
    //   415: astore 6
    //   417: ldc 188
    //   419: new 228	java/lang/StringBuilder
    //   422: dup
    //   423: ldc 230
    //   425: invokespecial 231	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   428: aload_0
    //   429: invokevirtual 235	java/lang/Exception:toString	()Ljava/lang/String;
    //   432: invokevirtual 239	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: aload 6
    //   443: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   446: aload_1
    //   447: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   450: goto -47 -> 403
    //   453: astore_0
    //   454: aconst_null
    //   455: astore_1
    //   456: aconst_null
    //   457: astore 6
    //   459: aload 6
    //   461: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   464: aload_1
    //   465: invokestatic 204	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   468: ldc_w 294
    //   471: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   474: aload_0
    //   475: athrow
    //   476: astore_0
    //   477: aconst_null
    //   478: astore_1
    //   479: goto -20 -> 459
    //   482: astore 7
    //   484: aload_0
    //   485: astore_1
    //   486: aload 7
    //   488: astore_0
    //   489: goto -30 -> 459
    //   492: astore_0
    //   493: goto -34 -> 459
    //   496: astore_0
    //   497: aconst_null
    //   498: astore_1
    //   499: goto -82 -> 417
    //   502: astore 7
    //   504: aload_0
    //   505: astore_1
    //   506: aload 7
    //   508: astore_0
    //   509: goto -92 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	paramString1	java.lang.String
    //   0	512	1	paramString2	java.lang.String
    //   129	166	2	i	int
    //   92	202	3	j	int
    //   67	52	4	l	long
    //   14	446	6	localObject1	Object
    //   24	308	7	localo	com.tencent.mm.vfs.o
    //   482	5	7	localObject2	Object
    //   502	5	7	localException	Exception
    //   113	248	8	localObject3	Object
    //   76	187	9	localObject4	Object
    //   221	47	10	localPInt	com.tencent.mm.pointers.PInt
    // Exception table:
    //   from	to	target	type
    //   298	305	411	java/lang/Exception
    //   298	305	453	finally
    //   305	337	476	finally
    //   337	377	482	finally
    //   417	441	492	finally
    //   305	337	496	java/lang/Exception
    //   337	377	502	java/lang/Exception
  }
  
  private static void safeClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(133862);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(133862);
        return;
      }
      catch (IOException paramCloseable)
      {
        Log.w("MicroMsg.FastStart", "Failed to close file: ");
      }
    }
    AppMethodBeat.o(133862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.a.e
 * JD-Core Version:    0.7.0.1
 */