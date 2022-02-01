package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class e
{
  private static final int iTi;
  private static final int iTj;
  private static final int iTk;
  private static final int iTl;
  private static final int iTm;
  private static final int iTn;
  private static final int iTo;
  private static final int iTp;
  private static final int iTq;
  private static final int iTr;
  private static final int iTs;
  private static final int iTt;
  private static final int iTu;
  
  static
  {
    AppMethodBeat.i(133865);
    iTi = ao(new byte[] { 102, 114, 101, 101 });
    iTj = ao(new byte[] { 106, 117, 110, 107 });
    iTk = ao(new byte[] { 109, 100, 97, 116 });
    iTl = ao(new byte[] { 109, 111, 111, 118 });
    iTm = ao(new byte[] { 112, 110, 111, 116 });
    iTn = ao(new byte[] { 115, 107, 105, 112 });
    iTo = ao(new byte[] { 119, 105, 100, 101 });
    iTp = ao(new byte[] { 80, 73, 67, 84 });
    iTq = ao(new byte[] { 102, 116, 121, 112 });
    iTr = ao(new byte[] { 117, 117, 105, 100 });
    iTs = ao(new byte[] { 99, 109, 111, 118 });
    iTt = ao(new byte[] { 115, 116, 99, 111 });
    iTu = ao(new byte[] { 99, 111, 54, 52 });
    AppMethodBeat.o(133865);
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
  
  private static int ao(byte[] paramArrayOfByte)
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
    //   0: ldc 131
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 133	com/tencent/mm/vfs/k
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 137	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   13: astore 20
    //   15: new 133	com/tencent/mm/vfs/k
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 137	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   23: astore 26
    //   25: aload 20
    //   27: getfield 141	com/tencent/mm/vfs/k:mUri	Landroid/net/Uri;
    //   30: aload 20
    //   32: invokevirtual 145	com/tencent/mm/vfs/k:fTe	()Lcom/tencent/mm/vfs/e$e;
    //   35: invokestatic 151	com/tencent/mm/vfs/o:c	(Landroid/net/Uri;Lcom/tencent/mm/vfs/e$e;)Ljava/nio/channels/ReadableByteChannel;
    //   38: checkcast 97	java/nio/channels/FileChannel
    //   41: astore 21
    //   43: aload 26
    //   45: getfield 141	com/tencent/mm/vfs/k:mUri	Landroid/net/Uri;
    //   48: aload 26
    //   50: invokevirtual 145	com/tencent/mm/vfs/k:fTe	()Lcom/tencent/mm/vfs/e$e;
    //   53: invokestatic 155	com/tencent/mm/vfs/o:d	(Landroid/net/Uri;Lcom/tencent/mm/vfs/e$e;)Ljava/nio/channels/WritableByteChannel;
    //   56: checkcast 97	java/nio/channels/FileChannel
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
    //   80: invokestatic 159	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   83: getstatic 119	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   86: invokevirtual 123	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
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
    //   125: invokestatic 161	com/tencent/mm/plugin/a/e:a	(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;)Z
    //   128: ifeq +1504 -> 1632
    //   131: aload 21
    //   133: astore 22
    //   135: aload 25
    //   137: astore 23
    //   139: aload 27
    //   141: invokevirtual 126	java/nio/ByteBuffer:getInt	()I
    //   144: i2l
    //   145: ldc2_w 162
    //   148: land
    //   149: lstore 10
    //   151: aload 21
    //   153: astore 22
    //   155: aload 25
    //   157: astore 23
    //   159: aload 27
    //   161: invokevirtual 126	java/nio/ByteBuffer:getInt	()I
    //   164: istore 4
    //   166: aload 21
    //   168: astore 22
    //   170: aload 25
    //   172: astore 23
    //   174: iload 4
    //   176: getstatic 71	com/tencent/mm/plugin/a/e:iTq	I
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
    //   197: invokestatic 167	com/tencent/mm/plugin/a/e:sM	(J)I
    //   200: istore 9
    //   202: aload 21
    //   204: astore 22
    //   206: aload 25
    //   208: astore 23
    //   210: iload 9
    //   212: invokestatic 159	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   215: getstatic 119	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   218: invokevirtual 123	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   221: astore 20
    //   223: aload 21
    //   225: astore 22
    //   227: aload 25
    //   229: astore 23
    //   231: aload 27
    //   233: invokevirtual 170	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   236: pop
    //   237: aload 21
    //   239: astore 22
    //   241: aload 25
    //   243: astore 23
    //   245: aload 20
    //   247: aload 27
    //   249: invokevirtual 174	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
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
    //   277: invokevirtual 101	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   280: iload 9
    //   282: bipush 8
    //   284: isub
    //   285: if_icmplt +1347 -> 1632
    //   288: aload 21
    //   290: astore 22
    //   292: aload 25
    //   294: astore 23
    //   296: aload 20
    //   298: invokevirtual 104	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   301: pop
    //   302: aload 21
    //   304: astore 22
    //   306: aload 25
    //   308: astore 23
    //   310: aload 21
    //   312: invokevirtual 178	java/nio/channels/FileChannel:position	()J
    //   315: lstore 14
    //   317: lload 10
    //   319: lstore 12
    //   321: lload 10
    //   323: ldc2_w 179
    //   326: lcmp
    //   327: ifge -225 -> 102
    //   330: aload 21
    //   332: astore 22
    //   334: aload 25
    //   336: astore 23
    //   338: ldc 182
    //   340: ldc 184
    //   342: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   367: invokestatic 194	com/tencent/mm/plugin/a/e:bK	(Ljava/lang/String;Ljava/lang/String;)Z
    //   370: istore 19
    //   372: aload 21
    //   374: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   377: aload 25
    //   379: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   382: iload 19
    //   384: ifne +9 -> 393
    //   387: aload 26
    //   389: invokevirtual 202	com/tencent/mm/vfs/k:delete	()Z
    //   392: pop
    //   393: ldc 131
    //   395: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   398: iload 19
    //   400: ireturn
    //   401: aload 21
    //   403: astore 22
    //   405: aload 25
    //   407: astore 23
    //   409: iload 4
    //   411: getstatic 52	com/tencent/mm/plugin/a/e:iTl	I
    //   414: if_icmpne +111 -> 525
    //   417: aload 21
    //   419: astore 22
    //   421: aload 25
    //   423: astore 23
    //   425: aload 21
    //   427: invokevirtual 178	java/nio/channels/FileChannel:position	()J
    //   430: lstore 12
    //   432: iconst_1
    //   433: istore 6
    //   435: iload 5
    //   437: ifne +37 -> 474
    //   440: aload 21
    //   442: astore 22
    //   444: aload 25
    //   446: astore 23
    //   448: ldc 182
    //   450: ldc 204
    //   452: invokestatic 206	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: aload 21
    //   457: astore 22
    //   459: aload 25
    //   461: astore 23
    //   463: aload_2
    //   464: iconst_1
    //   465: putfield 211	com/tencent/mm/pointers/PInt:value	I
    //   468: iconst_0
    //   469: istore 18
    //   471: goto -123 -> 348
    //   474: aload 21
    //   476: astore 22
    //   478: aload 25
    //   480: astore 23
    //   482: ldc 182
    //   484: ldc 213
    //   486: invokestatic 206	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   489: lload 12
    //   491: ldc2_w 179
    //   494: lsub
    //   495: lstore 12
    //   497: iload 6
    //   499: istore 5
    //   501: goto +1159 -> 1660
    //   504: aload 21
    //   506: astore 22
    //   508: aload 25
    //   510: astore 23
    //   512: ldc 182
    //   514: ldc 215
    //   516: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: iconst_0
    //   520: istore 18
    //   522: goto -174 -> 348
    //   525: aload 21
    //   527: astore 22
    //   529: aload 25
    //   531: astore 23
    //   533: iload 4
    //   535: getstatic 48	com/tencent/mm/plugin/a/e:iTk	I
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
    //   561: invokevirtual 95	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
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
    //   592: invokestatic 161	com/tencent/mm/plugin/a/e:a	(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;)Z
    //   595: ifeq +1037 -> 1632
    //   598: aload 21
    //   600: astore 22
    //   602: aload 25
    //   604: astore 23
    //   606: aload 27
    //   608: invokevirtual 218	java/nio/ByteBuffer:getLong	()J
    //   611: lstore 10
    //   613: lload 10
    //   615: lconst_0
    //   616: lcmp
    //   617: ifge +98 -> 715
    //   620: aload 21
    //   622: astore 22
    //   624: aload 25
    //   626: astore 23
    //   628: new 130	java/lang/Exception
    //   631: dup
    //   632: ldc 220
    //   634: invokespecial 221	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   637: astore_0
    //   638: aload 21
    //   640: astore 22
    //   642: aload 25
    //   644: astore 23
    //   646: ldc 131
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
    //   675: ldc 182
    //   677: new 223	java/lang/StringBuilder
    //   680: dup
    //   681: ldc 225
    //   683: invokespecial 226	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   686: aload_0
    //   687: invokevirtual 230	java/lang/Exception:toString	()Ljava/lang/String;
    //   690: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   696: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   699: aload 21
    //   701: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   704: aload_1
    //   705: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   708: iload 18
    //   710: istore 19
    //   712: goto -330 -> 382
    //   715: aload 21
    //   717: astore 22
    //   719: aload 25
    //   721: astore 23
    //   723: aload 21
    //   725: aload 21
    //   727: invokevirtual 178	java/nio/channels/FileChannel:position	()J
    //   730: lload 10
    //   732: ladd
    //   733: ldc2_w 236
    //   736: lsub
    //   737: invokevirtual 240	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   740: pop
    //   741: goto -424 -> 317
    //   744: astore_0
    //   745: aload 22
    //   747: astore 21
    //   749: aload 21
    //   751: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   754: aload 23
    //   756: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   759: ldc 131
    //   761: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   764: aload_0
    //   765: athrow
    //   766: aload 21
    //   768: astore 22
    //   770: aload 25
    //   772: astore 23
    //   774: aload 21
    //   776: aload 21
    //   778: invokevirtual 178	java/nio/channels/FileChannel:position	()J
    //   781: lload 10
    //   783: ladd
    //   784: ldc2_w 179
    //   787: lsub
    //   788: invokevirtual 240	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   791: pop
    //   792: goto -475 -> 317
    //   795: aload 21
    //   797: astore 22
    //   799: aload 25
    //   801: astore 23
    //   803: iload 4
    //   805: getstatic 52	com/tencent/mm/plugin/a/e:iTl	I
    //   808: if_icmpne +10 -> 818
    //   811: lload 12
    //   813: lconst_0
    //   814: lcmp
    //   815: ifge +24 -> 839
    //   818: aload 21
    //   820: astore 22
    //   822: aload 25
    //   824: astore 23
    //   826: ldc 182
    //   828: ldc 242
    //   830: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   833: iconst_0
    //   834: istore 18
    //   836: goto -488 -> 348
    //   839: aload 21
    //   841: astore 22
    //   843: aload 25
    //   845: astore 23
    //   847: lload 10
    //   849: invokestatic 167	com/tencent/mm/plugin/a/e:sM	(J)I
    //   852: istore 4
    //   854: aload 21
    //   856: astore 22
    //   858: aload 25
    //   860: astore 23
    //   862: iload 4
    //   864: invokestatic 159	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   867: getstatic 119	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   870: invokevirtual 123	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   873: astore_2
    //   874: aload 21
    //   876: astore 22
    //   878: aload 25
    //   880: astore 23
    //   882: aload_2
    //   883: invokevirtual 95	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   886: pop
    //   887: aload 21
    //   889: astore 22
    //   891: aload 25
    //   893: astore 23
    //   895: aload 21
    //   897: aload_2
    //   898: lload 12
    //   900: invokevirtual 245	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;J)I
    //   903: istore_3
    //   904: aload 21
    //   906: astore 22
    //   908: aload 25
    //   910: astore 23
    //   912: aload_2
    //   913: invokevirtual 104	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   916: pop
    //   917: aload 21
    //   919: astore 22
    //   921: aload 25
    //   923: astore 23
    //   925: iload_3
    //   926: aload_2
    //   927: invokevirtual 108	java/nio/ByteBuffer:capacity	()I
    //   930: if_icmpne +742 -> 1672
    //   933: iconst_1
    //   934: istore_3
    //   935: iload_3
    //   936: ifne +24 -> 960
    //   939: aload 21
    //   941: astore 22
    //   943: aload 25
    //   945: astore 23
    //   947: ldc 182
    //   949: ldc 247
    //   951: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   954: iconst_0
    //   955: istore 18
    //   957: goto -609 -> 348
    //   960: aload 21
    //   962: astore 22
    //   964: aload 25
    //   966: astore 23
    //   968: aload_2
    //   969: bipush 12
    //   971: invokevirtual 250	java/nio/ByteBuffer:getInt	(I)I
    //   974: getstatic 76	com/tencent/mm/plugin/a/e:iTs	I
    //   977: if_icmpne +24 -> 1001
    //   980: aload 21
    //   982: astore 22
    //   984: aload 25
    //   986: astore 23
    //   988: ldc 182
    //   990: ldc 252
    //   992: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   995: iconst_0
    //   996: istore 18
    //   998: goto -650 -> 348
    //   1001: aload 21
    //   1003: astore 22
    //   1005: aload 25
    //   1007: astore 23
    //   1009: aload_2
    //   1010: invokevirtual 255	java/nio/ByteBuffer:remaining	()I
    //   1013: bipush 8
    //   1015: if_icmplt +430 -> 1445
    //   1018: aload 21
    //   1020: astore 22
    //   1022: aload 25
    //   1024: astore 23
    //   1026: aload_2
    //   1027: invokevirtual 257	java/nio/ByteBuffer:position	()I
    //   1030: istore 5
    //   1032: aload 21
    //   1034: astore 22
    //   1036: aload 25
    //   1038: astore 23
    //   1040: aload_2
    //   1041: iload 5
    //   1043: iconst_4
    //   1044: iadd
    //   1045: invokevirtual 250	java/nio/ByteBuffer:getInt	(I)I
    //   1048: istore_3
    //   1049: aload 21
    //   1051: astore 22
    //   1053: aload 25
    //   1055: astore 23
    //   1057: iload_3
    //   1058: getstatic 78	com/tencent/mm/plugin/a/e:iTt	I
    //   1061: if_icmpeq +40 -> 1101
    //   1064: aload 21
    //   1066: astore 22
    //   1068: aload 25
    //   1070: astore 23
    //   1072: iload_3
    //   1073: getstatic 82	com/tencent/mm/plugin/a/e:iTu	I
    //   1076: if_icmpeq +25 -> 1101
    //   1079: aload 21
    //   1081: astore 22
    //   1083: aload 25
    //   1085: astore 23
    //   1087: aload_2
    //   1088: aload_2
    //   1089: invokevirtual 257	java/nio/ByteBuffer:position	()I
    //   1092: iconst_1
    //   1093: iadd
    //   1094: invokevirtual 260	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1097: pop
    //   1098: goto -97 -> 1001
    //   1101: aload 21
    //   1103: astore 22
    //   1105: aload 25
    //   1107: astore 23
    //   1109: aload_2
    //   1110: iload 5
    //   1112: invokevirtual 250	java/nio/ByteBuffer:getInt	(I)I
    //   1115: i2l
    //   1116: ldc2_w 162
    //   1119: land
    //   1120: aload_2
    //   1121: invokevirtual 255	java/nio/ByteBuffer:remaining	()I
    //   1124: i2l
    //   1125: lcmp
    //   1126: ifle +25 -> 1151
    //   1129: aload 21
    //   1131: astore 22
    //   1133: aload 25
    //   1135: astore 23
    //   1137: ldc 182
    //   1139: ldc_w 262
    //   1142: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1145: iconst_0
    //   1146: istore 18
    //   1148: goto -800 -> 348
    //   1151: aload 21
    //   1153: astore 22
    //   1155: aload 25
    //   1157: astore 23
    //   1159: aload_2
    //   1160: iload 5
    //   1162: bipush 12
    //   1164: iadd
    //   1165: invokevirtual 260	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1168: pop
    //   1169: aload 21
    //   1171: astore 22
    //   1173: aload 25
    //   1175: astore 23
    //   1177: aload_2
    //   1178: invokevirtual 255	java/nio/ByteBuffer:remaining	()I
    //   1181: iconst_4
    //   1182: if_icmpge +25 -> 1207
    //   1185: aload 21
    //   1187: astore 22
    //   1189: aload 25
    //   1191: astore 23
    //   1193: ldc 182
    //   1195: ldc_w 264
    //   1198: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1201: iconst_0
    //   1202: istore 18
    //   1204: goto -856 -> 348
    //   1207: aload 21
    //   1209: astore 22
    //   1211: aload 25
    //   1213: astore 23
    //   1215: aload_2
    //   1216: invokevirtual 126	java/nio/ByteBuffer:getInt	()I
    //   1219: i2l
    //   1220: invokestatic 167	com/tencent/mm/plugin/a/e:sM	(J)I
    //   1223: istore 5
    //   1225: aload 21
    //   1227: astore 22
    //   1229: aload 25
    //   1231: astore 23
    //   1233: iload_3
    //   1234: getstatic 78	com/tencent/mm/plugin/a/e:iTt	I
    //   1237: if_icmpne +113 -> 1350
    //   1240: aload 21
    //   1242: astore 22
    //   1244: aload 25
    //   1246: astore 23
    //   1248: aload_2
    //   1249: invokevirtual 255	java/nio/ByteBuffer:remaining	()I
    //   1252: iload 5
    //   1254: iconst_4
    //   1255: imul
    //   1256: if_icmpge +421 -> 1677
    //   1259: aload 21
    //   1261: astore 22
    //   1263: aload 25
    //   1265: astore 23
    //   1267: ldc 182
    //   1269: ldc_w 266
    //   1272: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1275: iconst_0
    //   1276: istore 18
    //   1278: goto -930 -> 348
    //   1281: iload_3
    //   1282: iload 5
    //   1284: if_icmpge -283 -> 1001
    //   1287: aload 21
    //   1289: astore 22
    //   1291: aload 25
    //   1293: astore 23
    //   1295: aload_2
    //   1296: aload_2
    //   1297: invokevirtual 257	java/nio/ByteBuffer:position	()I
    //   1300: invokevirtual 250	java/nio/ByteBuffer:getInt	(I)I
    //   1303: istore 6
    //   1305: iload 6
    //   1307: iload 4
    //   1309: iadd
    //   1310: istore 7
    //   1312: iload 6
    //   1314: ifge +14 -> 1328
    //   1317: iload 7
    //   1319: iflt +9 -> 1328
    //   1322: iconst_0
    //   1323: istore 18
    //   1325: goto -977 -> 348
    //   1328: aload 21
    //   1330: astore 22
    //   1332: aload 25
    //   1334: astore 23
    //   1336: aload_2
    //   1337: iload 7
    //   1339: invokevirtual 269	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1342: pop
    //   1343: iload_3
    //   1344: iconst_1
    //   1345: iadd
    //   1346: istore_3
    //   1347: goto -66 -> 1281
    //   1350: aload 21
    //   1352: astore 22
    //   1354: aload 25
    //   1356: astore 23
    //   1358: iload_3
    //   1359: getstatic 82	com/tencent/mm/plugin/a/e:iTu	I
    //   1362: if_icmpne -361 -> 1001
    //   1365: aload 21
    //   1367: astore 22
    //   1369: aload 25
    //   1371: astore 23
    //   1373: aload_2
    //   1374: invokevirtual 255	java/nio/ByteBuffer:remaining	()I
    //   1377: iload 5
    //   1379: bipush 8
    //   1381: imul
    //   1382: if_icmpge +300 -> 1682
    //   1385: aload 21
    //   1387: astore 22
    //   1389: aload 25
    //   1391: astore 23
    //   1393: ldc 182
    //   1395: ldc_w 266
    //   1398: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1401: iconst_0
    //   1402: istore 18
    //   1404: goto -1056 -> 348
    //   1407: iload_3
    //   1408: iload 5
    //   1410: if_icmpge -409 -> 1001
    //   1413: aload 21
    //   1415: astore 22
    //   1417: aload 25
    //   1419: astore 23
    //   1421: aload_2
    //   1422: aload_2
    //   1423: aload_2
    //   1424: invokevirtual 257	java/nio/ByteBuffer:position	()I
    //   1427: invokevirtual 272	java/nio/ByteBuffer:getLong	(I)J
    //   1430: iload 4
    //   1432: i2l
    //   1433: ladd
    //   1434: invokevirtual 276	java/nio/ByteBuffer:putLong	(J)Ljava/nio/ByteBuffer;
    //   1437: pop
    //   1438: iload_3
    //   1439: iconst_1
    //   1440: iadd
    //   1441: istore_3
    //   1442: goto -35 -> 1407
    //   1445: aload 21
    //   1447: astore 22
    //   1449: aload 25
    //   1451: astore 23
    //   1453: aload 21
    //   1455: lload 14
    //   1457: invokevirtual 240	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   1460: pop
    //   1461: aload 20
    //   1463: ifnull +33 -> 1496
    //   1466: aload 21
    //   1468: astore 22
    //   1470: aload 25
    //   1472: astore 23
    //   1474: aload 20
    //   1476: invokevirtual 170	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1479: pop
    //   1480: aload 21
    //   1482: astore 22
    //   1484: aload 25
    //   1486: astore 23
    //   1488: aload 25
    //   1490: aload 20
    //   1492: invokevirtual 279	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   1495: pop
    //   1496: aload 21
    //   1498: astore 22
    //   1500: aload 25
    //   1502: astore 23
    //   1504: aload_2
    //   1505: invokevirtual 170	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1508: pop
    //   1509: aload 21
    //   1511: astore 22
    //   1513: aload 25
    //   1515: astore 23
    //   1517: aload 25
    //   1519: aload_2
    //   1520: invokevirtual 279	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   1523: pop
    //   1524: aload 21
    //   1526: astore 22
    //   1528: aload 25
    //   1530: astore 23
    //   1532: aload 21
    //   1534: lload 14
    //   1536: lload 12
    //   1538: lload 14
    //   1540: lsub
    //   1541: aload 25
    //   1543: invokevirtual 283	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   1546: pop2
    //   1547: aload 21
    //   1549: astore 22
    //   1551: aload 25
    //   1553: astore 23
    //   1555: aload 21
    //   1557: iload 4
    //   1559: i2l
    //   1560: lload 12
    //   1562: ladd
    //   1563: aload 21
    //   1565: invokevirtual 286	java/nio/channels/FileChannel:size	()J
    //   1568: lload 12
    //   1570: lsub
    //   1571: iload 4
    //   1573: i2l
    //   1574: lsub
    //   1575: aload 25
    //   1577: invokevirtual 283	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   1580: pop2
    //   1581: iconst_1
    //   1582: istore 18
    //   1584: goto -1236 -> 348
    //   1587: astore_0
    //   1588: aconst_null
    //   1589: astore 23
    //   1591: aconst_null
    //   1592: astore 21
    //   1594: goto -845 -> 749
    //   1597: astore_0
    //   1598: aconst_null
    //   1599: astore 23
    //   1601: goto -852 -> 749
    //   1604: astore_0
    //   1605: aconst_null
    //   1606: astore_1
    //   1607: aconst_null
    //   1608: astore 21
    //   1610: iconst_0
    //   1611: istore 18
    //   1613: goto -945 -> 668
    //   1616: astore_0
    //   1617: aconst_null
    //   1618: astore_1
    //   1619: iconst_0
    //   1620: istore 18
    //   1622: goto -954 -> 668
    //   1625: astore_0
    //   1626: aload 25
    //   1628: astore_1
    //   1629: goto -961 -> 668
    //   1632: ldc2_w 287
    //   1635: lstore 16
    //   1637: iload 7
    //   1639: istore 4
    //   1641: lload 12
    //   1643: lstore 10
    //   1645: aload 24
    //   1647: astore 20
    //   1649: iload 6
    //   1651: istore_3
    //   1652: lload 16
    //   1654: lstore 12
    //   1656: iload 8
    //   1658: istore 5
    //   1660: iload_3
    //   1661: ifeq -1157 -> 504
    //   1664: iload 5
    //   1666: ifne -871 -> 795
    //   1669: goto -1165 -> 504
    //   1672: iconst_0
    //   1673: istore_3
    //   1674: goto -739 -> 935
    //   1677: iconst_0
    //   1678: istore_3
    //   1679: goto -398 -> 1281
    //   1682: iconst_0
    //   1683: istore_3
    //   1684: goto -277 -> 1407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1687	0	paramString1	java.lang.String
    //   0	1687	1	paramString2	java.lang.String
    //   0	1687	2	paramPInt	com.tencent.mm.pointers.PInt
    //   95	1589	3	i	int
    //   62	1578	4	j	int
    //   97	1568	5	k	int
    //   111	1539	6	m	int
    //   119	1519	7	n	int
    //   100	1557	8	i1	int
    //   200	85	9	i2	int
    //   149	1495	10	l1	long
    //   65	1590	12	l2	long
    //   92	1447	14	l3	long
    //   1635	18	16	l4	long
    //   346	1275	18	bool1	boolean
    //   350	361	19	bool2	boolean
    //   13	1635	20	localObject1	Object
    //   41	1568	21	localObject2	Object
    //   72	1478	22	localObject3	Object
    //   76	1524	23	localObject4	Object
    //   115	1531	24	localObject5	Object
    //   59	1568	25	localFileChannel	FileChannel
    //   23	365	26	localk	com.tencent.mm.vfs.k
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
    //   988	995	661	java/lang/Exception
    //   1009	1018	661	java/lang/Exception
    //   1026	1032	661	java/lang/Exception
    //   1040	1049	661	java/lang/Exception
    //   1057	1064	661	java/lang/Exception
    //   1072	1079	661	java/lang/Exception
    //   1087	1098	661	java/lang/Exception
    //   1109	1129	661	java/lang/Exception
    //   1137	1145	661	java/lang/Exception
    //   1159	1169	661	java/lang/Exception
    //   1177	1185	661	java/lang/Exception
    //   1193	1201	661	java/lang/Exception
    //   1215	1225	661	java/lang/Exception
    //   1233	1240	661	java/lang/Exception
    //   1248	1259	661	java/lang/Exception
    //   1267	1275	661	java/lang/Exception
    //   1295	1305	661	java/lang/Exception
    //   1336	1343	661	java/lang/Exception
    //   1358	1365	661	java/lang/Exception
    //   1373	1385	661	java/lang/Exception
    //   1393	1401	661	java/lang/Exception
    //   1421	1438	661	java/lang/Exception
    //   1453	1461	661	java/lang/Exception
    //   1474	1480	661	java/lang/Exception
    //   1488	1496	661	java/lang/Exception
    //   1504	1509	661	java/lang/Exception
    //   1517	1524	661	java/lang/Exception
    //   1532	1547	661	java/lang/Exception
    //   1555	1581	661	java/lang/Exception
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
    //   988	995	744	finally
    //   1009	1018	744	finally
    //   1026	1032	744	finally
    //   1040	1049	744	finally
    //   1057	1064	744	finally
    //   1072	1079	744	finally
    //   1087	1098	744	finally
    //   1109	1129	744	finally
    //   1137	1145	744	finally
    //   1159	1169	744	finally
    //   1177	1185	744	finally
    //   1193	1201	744	finally
    //   1215	1225	744	finally
    //   1233	1240	744	finally
    //   1248	1259	744	finally
    //   1267	1275	744	finally
    //   1295	1305	744	finally
    //   1336	1343	744	finally
    //   1358	1365	744	finally
    //   1373	1385	744	finally
    //   1393	1401	744	finally
    //   1421	1438	744	finally
    //   1453	1461	744	finally
    //   1474	1480	744	finally
    //   1488	1496	744	finally
    //   1504	1509	744	finally
    //   1517	1524	744	finally
    //   1532	1547	744	finally
    //   1555	1581	744	finally
    //   25	43	1587	finally
    //   43	61	1597	finally
    //   25	43	1604	java/lang/Exception
    //   43	61	1616	java/lang/Exception
    //   365	372	1625	java/lang/Exception
  }
  
  /* Error */
  private static boolean bK(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: ldc_w 289
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 133	com/tencent/mm/vfs/k
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 137	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: new 133	com/tencent/mm/vfs/k
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 137	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   24: astore 7
    //   26: aload 6
    //   28: invokevirtual 292	com/tencent/mm/vfs/k:length	()J
    //   31: aload 7
    //   33: invokevirtual 292	com/tencent/mm/vfs/k:length	()J
    //   36: lcmp
    //   37: ifeq +19 -> 56
    //   40: ldc 182
    //   42: ldc_w 294
    //   45: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc_w 289
    //   51: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: iconst_0
    //   55: ireturn
    //   56: new 296	com/tencent/mm/plugin/a/b
    //   59: dup
    //   60: invokespecial 298	com/tencent/mm/plugin/a/b:<init>	()V
    //   63: aload_0
    //   64: invokevirtual 302	com/tencent/mm/plugin/a/b:Jy	(Ljava/lang/String;)J
    //   67: lstore 4
    //   69: new 304	com/tencent/mm/plugin/a/j
    //   72: dup
    //   73: invokespecial 305	com/tencent/mm/plugin/a/j:<init>	()V
    //   76: astore 9
    //   78: aload 9
    //   80: aload_0
    //   81: lload 4
    //   83: invokevirtual 309	com/tencent/mm/plugin/a/j:L	(Ljava/lang/String;J)Z
    //   86: pop
    //   87: aload 9
    //   89: getfield 312	com/tencent/mm/plugin/a/j:iTC	I
    //   92: istore_3
    //   93: new 296	com/tencent/mm/plugin/a/b
    //   96: dup
    //   97: invokespecial 298	com/tencent/mm/plugin/a/b:<init>	()V
    //   100: aload_1
    //   101: invokevirtual 302	com/tencent/mm/plugin/a/b:Jy	(Ljava/lang/String;)J
    //   104: lstore 4
    //   106: new 304	com/tencent/mm/plugin/a/j
    //   109: dup
    //   110: invokespecial 305	com/tencent/mm/plugin/a/j:<init>	()V
    //   113: astore 8
    //   115: aload 8
    //   117: aload_1
    //   118: lload 4
    //   120: invokevirtual 309	com/tencent/mm/plugin/a/j:L	(Ljava/lang/String;J)Z
    //   123: pop
    //   124: aload 8
    //   126: getfield 312	com/tencent/mm/plugin/a/j:iTC	I
    //   129: istore_2
    //   130: iload_2
    //   131: iload_3
    //   132: if_icmpeq +19 -> 151
    //   135: ldc 182
    //   137: ldc_w 314
    //   140: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: ldc_w 289
    //   146: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: ldc 182
    //   153: new 223	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 316
    //   160: invokespecial 226	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: iload_3
    //   164: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 321
    //   170: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload_2
    //   174: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 206	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: new 323	java/util/Random
    //   186: dup
    //   187: invokespecial 324	java/util/Random:<init>	()V
    //   190: iload_2
    //   191: iconst_1
    //   192: isub
    //   193: invokevirtual 327	java/util/Random:nextInt	(I)I
    //   196: iconst_1
    //   197: iadd
    //   198: istore_3
    //   199: iload_3
    //   200: iconst_1
    //   201: iadd
    //   202: iload_2
    //   203: if_icmple +88 -> 291
    //   206: new 208	com/tencent/mm/pointers/PInt
    //   209: dup
    //   210: invokespecial 328	com/tencent/mm/pointers/PInt:<init>	()V
    //   213: astore_0
    //   214: new 208	com/tencent/mm/pointers/PInt
    //   217: dup
    //   218: invokespecial 328	com/tencent/mm/pointers/PInt:<init>	()V
    //   221: astore 10
    //   223: aload 9
    //   225: iload_3
    //   226: iload_2
    //   227: aload_0
    //   228: aload 10
    //   230: invokevirtual 331	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   233: pop
    //   234: new 208	com/tencent/mm/pointers/PInt
    //   237: dup
    //   238: invokespecial 328	com/tencent/mm/pointers/PInt:<init>	()V
    //   241: astore_1
    //   242: new 208	com/tencent/mm/pointers/PInt
    //   245: dup
    //   246: invokespecial 328	com/tencent/mm/pointers/PInt:<init>	()V
    //   249: astore 9
    //   251: aload 8
    //   253: iload_3
    //   254: iload_2
    //   255: aload_1
    //   256: aload 9
    //   258: invokevirtual 331	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   261: pop
    //   262: aload 9
    //   264: getfield 211	com/tencent/mm/pointers/PInt:value	I
    //   267: aload 10
    //   269: getfield 211	com/tencent/mm/pointers/PInt:value	I
    //   272: if_icmpeq +26 -> 298
    //   275: ldc 182
    //   277: ldc_w 333
    //   280: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: ldc_w 289
    //   286: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: iload_3
    //   292: iconst_1
    //   293: iadd
    //   294: istore_2
    //   295: goto -89 -> 206
    //   298: aload 6
    //   300: invokestatic 337	com/tencent/mm/vfs/o:ai	(Lcom/tencent/mm/vfs/k;)Ljava/io/InputStream;
    //   303: astore 6
    //   305: aload 6
    //   307: aload_0
    //   308: getfield 211	com/tencent/mm/pointers/PInt:value	I
    //   311: i2l
    //   312: invokevirtual 343	java/io/InputStream:skip	(J)J
    //   315: pop2
    //   316: sipush 4096
    //   319: newarray byte
    //   321: astore 8
    //   323: aload 6
    //   325: aload 8
    //   327: invokevirtual 345	java/io/InputStream:read	([B)I
    //   330: pop
    //   331: aload 7
    //   333: invokestatic 337	com/tencent/mm/vfs/o:ai	(Lcom/tencent/mm/vfs/k;)Ljava/io/InputStream;
    //   336: astore_0
    //   337: aload_0
    //   338: aload_1
    //   339: getfield 211	com/tencent/mm/pointers/PInt:value	I
    //   342: i2l
    //   343: invokevirtual 343	java/io/InputStream:skip	(J)J
    //   346: pop2
    //   347: sipush 4096
    //   350: newarray byte
    //   352: astore_1
    //   353: aload 6
    //   355: aload_1
    //   356: invokevirtual 345	java/io/InputStream:read	([B)I
    //   359: pop
    //   360: aload 8
    //   362: aload_1
    //   363: invokestatic 351	java/util/Arrays:equals	([B[B)Z
    //   366: ifeq +28 -> 394
    //   369: ldc 182
    //   371: ldc_w 353
    //   374: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload 6
    //   379: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   382: aload_0
    //   383: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   386: ldc_w 289
    //   389: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: iconst_0
    //   393: ireturn
    //   394: aload 6
    //   396: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   399: aload_0
    //   400: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   403: ldc_w 289
    //   406: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   409: iconst_1
    //   410: ireturn
    //   411: astore_0
    //   412: aconst_null
    //   413: astore_1
    //   414: aconst_null
    //   415: astore 6
    //   417: ldc 182
    //   419: new 223	java/lang/StringBuilder
    //   422: dup
    //   423: ldc 225
    //   425: invokespecial 226	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   428: aload_0
    //   429: invokevirtual 230	java/lang/Exception:toString	()Ljava/lang/String;
    //   432: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 190	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: aload 6
    //   443: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   446: aload_1
    //   447: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   450: goto -47 -> 403
    //   453: astore_0
    //   454: aconst_null
    //   455: astore_1
    //   456: aconst_null
    //   457: astore 6
    //   459: aload 6
    //   461: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   464: aload_1
    //   465: invokestatic 198	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   468: ldc_w 289
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
    //   24	308	7	localk	com.tencent.mm.vfs.k
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
  
  private static int sM(long paramLong)
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
        ae.w("MicroMsg.FastStart", "Failed to close file: ");
      }
    }
    AppMethodBeat.o(133862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.e
 * JD-Core Version:    0.7.0.1
 */