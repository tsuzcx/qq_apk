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
  private static final int mHm;
  private static final int mHn;
  private static final int mHo;
  private static final int mHp;
  private static final int mHq;
  private static final int mHr;
  private static final int mHs;
  private static final int mHt;
  private static final int mHu;
  private static final int mHv;
  private static final int mHw;
  private static final int mHx;
  private static final int mHy;
  
  static
  {
    AppMethodBeat.i(133865);
    mHm = aQ(new byte[] { 102, 114, 101, 101 });
    mHn = aQ(new byte[] { 106, 117, 110, 107 });
    mHo = aQ(new byte[] { 109, 100, 97, 116 });
    mHp = aQ(new byte[] { 109, 111, 111, 118 });
    mHq = aQ(new byte[] { 112, 110, 111, 116 });
    mHr = aQ(new byte[] { 115, 107, 105, 112 });
    mHs = aQ(new byte[] { 119, 105, 100, 101 });
    mHt = aQ(new byte[] { 80, 73, 67, 84 });
    mHu = aQ(new byte[] { 102, 116, 121, 112 });
    mHv = aQ(new byte[] { 117, 117, 105, 100 });
    mHw = aQ(new byte[] { 99, 109, 111, 118 });
    mHx = aQ(new byte[] { 115, 116, 99, 111 });
    mHy = aQ(new byte[] { 99, 111, 54, 52 });
    AppMethodBeat.o(133865);
  }
  
  private static int Ha(long paramLong)
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
  
  private static int aQ(byte[] paramArrayOfByte)
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
    //   5: new 144	com/tencent/mm/vfs/q
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 145	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   13: astore 20
    //   15: new 144	com/tencent/mm/vfs/q
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 145	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   23: astore 26
    //   25: aload 20
    //   27: invokestatic 151	com/tencent/mm/vfs/u:am	(Lcom/tencent/mm/vfs/q;)Ljava/nio/channels/ReadableByteChannel;
    //   30: checkcast 110	java/nio/channels/FileChannel
    //   33: astore 21
    //   35: aload 26
    //   37: invokestatic 155	com/tencent/mm/vfs/u:ao	(Lcom/tencent/mm/vfs/q;)Ljava/nio/channels/WritableByteChannel;
    //   40: checkcast 110	java/nio/channels/FileChannel
    //   43: astore 25
    //   45: iconst_0
    //   46: istore 4
    //   48: lconst_0
    //   49: lstore 12
    //   51: aconst_null
    //   52: astore 20
    //   54: aload 21
    //   56: astore 22
    //   58: aload 25
    //   60: astore 23
    //   62: bipush 8
    //   64: invokestatic 159	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   67: getstatic 132	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   70: invokevirtual 136	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   73: astore 27
    //   75: lconst_0
    //   76: lstore 14
    //   78: iconst_0
    //   79: istore_3
    //   80: iconst_0
    //   81: istore 5
    //   83: iconst_0
    //   84: istore 8
    //   86: aload 21
    //   88: astore 22
    //   90: aload 25
    //   92: astore 23
    //   94: iload_3
    //   95: istore 6
    //   97: aload 20
    //   99: astore 24
    //   101: iload 4
    //   103: istore 7
    //   105: aload 21
    //   107: aload 27
    //   109: invokestatic 161	com/tencent/mm/plugin/a/e:a	(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;)Z
    //   112: ifeq +1504 -> 1616
    //   115: aload 21
    //   117: astore 22
    //   119: aload 25
    //   121: astore 23
    //   123: aload 27
    //   125: invokevirtual 139	java/nio/ByteBuffer:getInt	()I
    //   128: i2l
    //   129: ldc2_w 162
    //   132: land
    //   133: lstore 10
    //   135: aload 21
    //   137: astore 22
    //   139: aload 25
    //   141: astore 23
    //   143: aload 27
    //   145: invokevirtual 139	java/nio/ByteBuffer:getInt	()I
    //   148: istore 4
    //   150: aload 21
    //   152: astore 22
    //   154: aload 25
    //   156: astore 23
    //   158: iload 4
    //   160: getstatic 71	com/tencent/mm/plugin/a/e:mHu	I
    //   163: if_icmpne +222 -> 385
    //   166: iconst_1
    //   167: istore 6
    //   169: iconst_1
    //   170: istore_3
    //   171: aload 21
    //   173: astore 22
    //   175: aload 25
    //   177: astore 23
    //   179: lload 10
    //   181: invokestatic 165	com/tencent/mm/plugin/a/e:Ha	(J)I
    //   184: istore 9
    //   186: aload 21
    //   188: astore 22
    //   190: aload 25
    //   192: astore 23
    //   194: iload 9
    //   196: invokestatic 159	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   199: getstatic 132	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   202: invokevirtual 136	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   205: astore 20
    //   207: aload 21
    //   209: astore 22
    //   211: aload 25
    //   213: astore 23
    //   215: aload 27
    //   217: invokevirtual 168	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   220: pop
    //   221: aload 21
    //   223: astore 22
    //   225: aload 25
    //   227: astore 23
    //   229: aload 20
    //   231: aload 27
    //   233: invokevirtual 172	java/nio/ByteBuffer:put	(Ljava/nio/ByteBuffer;)Ljava/nio/ByteBuffer;
    //   236: pop
    //   237: aload 21
    //   239: astore 22
    //   241: aload 25
    //   243: astore 23
    //   245: aload 20
    //   247: astore 24
    //   249: lload 10
    //   251: lstore 12
    //   253: iload 4
    //   255: istore 7
    //   257: aload 21
    //   259: aload 20
    //   261: invokevirtual 114	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   264: iload 9
    //   266: bipush 8
    //   268: isub
    //   269: if_icmplt +1347 -> 1616
    //   272: aload 21
    //   274: astore 22
    //   276: aload 25
    //   278: astore 23
    //   280: aload 20
    //   282: invokevirtual 117	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   285: pop
    //   286: aload 21
    //   288: astore 22
    //   290: aload 25
    //   292: astore 23
    //   294: aload 21
    //   296: invokevirtual 176	java/nio/channels/FileChannel:position	()J
    //   299: lstore 14
    //   301: lload 10
    //   303: lstore 12
    //   305: lload 10
    //   307: ldc2_w 177
    //   310: lcmp
    //   311: ifge -225 -> 86
    //   314: aload 21
    //   316: astore 22
    //   318: aload 25
    //   320: astore 23
    //   322: ldc 180
    //   324: ldc 182
    //   326: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: iconst_0
    //   330: istore 18
    //   332: iload 18
    //   334: istore 19
    //   336: iload 18
    //   338: ifeq +18 -> 356
    //   341: aload 21
    //   343: astore 22
    //   345: aload 25
    //   347: astore 23
    //   349: aload_0
    //   350: aload_1
    //   351: invokestatic 192	com/tencent/mm/plugin/a/e:bY	(Ljava/lang/String;Ljava/lang/String;)Z
    //   354: istore 19
    //   356: aload 21
    //   358: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   361: aload 25
    //   363: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   366: iload 19
    //   368: ifne +9 -> 377
    //   371: aload 26
    //   373: invokevirtual 200	com/tencent/mm/vfs/q:cFq	()Z
    //   376: pop
    //   377: ldc 142
    //   379: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: iload 19
    //   384: ireturn
    //   385: aload 21
    //   387: astore 22
    //   389: aload 25
    //   391: astore 23
    //   393: iload 4
    //   395: getstatic 52	com/tencent/mm/plugin/a/e:mHp	I
    //   398: if_icmpne +111 -> 509
    //   401: aload 21
    //   403: astore 22
    //   405: aload 25
    //   407: astore 23
    //   409: aload 21
    //   411: invokevirtual 176	java/nio/channels/FileChannel:position	()J
    //   414: lstore 12
    //   416: iconst_1
    //   417: istore 6
    //   419: iload 5
    //   421: ifne +37 -> 458
    //   424: aload 21
    //   426: astore 22
    //   428: aload 25
    //   430: astore 23
    //   432: ldc 180
    //   434: ldc 202
    //   436: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   439: aload 21
    //   441: astore 22
    //   443: aload 25
    //   445: astore 23
    //   447: aload_2
    //   448: iconst_1
    //   449: putfield 210	com/tencent/mm/pointers/PInt:value	I
    //   452: iconst_0
    //   453: istore 18
    //   455: goto -123 -> 332
    //   458: aload 21
    //   460: astore 22
    //   462: aload 25
    //   464: astore 23
    //   466: ldc 180
    //   468: ldc 212
    //   470: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   473: lload 12
    //   475: ldc2_w 177
    //   478: lsub
    //   479: lstore 12
    //   481: iload 6
    //   483: istore 5
    //   485: goto +1159 -> 1644
    //   488: aload 21
    //   490: astore 22
    //   492: aload 25
    //   494: astore 23
    //   496: ldc 180
    //   498: ldc 214
    //   500: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: iconst_0
    //   504: istore 18
    //   506: goto -174 -> 332
    //   509: aload 21
    //   511: astore 22
    //   513: aload 25
    //   515: astore 23
    //   517: iload 4
    //   519: getstatic 48	com/tencent/mm/plugin/a/e:mHo	I
    //   522: if_icmpne +6 -> 528
    //   525: iconst_1
    //   526: istore 5
    //   528: lload 10
    //   530: lconst_1
    //   531: lcmp
    //   532: ifne +218 -> 750
    //   535: aload 21
    //   537: astore 22
    //   539: aload 25
    //   541: astore 23
    //   543: aload 27
    //   545: invokevirtual 108	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   548: pop
    //   549: aload 21
    //   551: astore 22
    //   553: aload 25
    //   555: astore 23
    //   557: iload_3
    //   558: istore 6
    //   560: aload 20
    //   562: astore 24
    //   564: lload 10
    //   566: lstore 12
    //   568: iload 4
    //   570: istore 7
    //   572: aload 21
    //   574: aload 27
    //   576: invokestatic 161	com/tencent/mm/plugin/a/e:a	(Ljava/nio/channels/FileChannel;Ljava/nio/ByteBuffer;)Z
    //   579: ifeq +1037 -> 1616
    //   582: aload 21
    //   584: astore 22
    //   586: aload 25
    //   588: astore 23
    //   590: aload 27
    //   592: invokevirtual 217	java/nio/ByteBuffer:getLong	()J
    //   595: lstore 10
    //   597: lload 10
    //   599: lconst_0
    //   600: lcmp
    //   601: ifge +98 -> 699
    //   604: aload 21
    //   606: astore 22
    //   608: aload 25
    //   610: astore 23
    //   612: new 93	java/lang/Exception
    //   615: dup
    //   616: ldc 219
    //   618: invokespecial 99	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   621: astore_0
    //   622: aload 21
    //   624: astore 22
    //   626: aload 25
    //   628: astore 23
    //   630: ldc 142
    //   632: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   635: aload 21
    //   637: astore 22
    //   639: aload 25
    //   641: astore 23
    //   643: aload_0
    //   644: athrow
    //   645: astore_0
    //   646: iconst_0
    //   647: istore 18
    //   649: aload 25
    //   651: astore_1
    //   652: aload 21
    //   654: astore 22
    //   656: aload_1
    //   657: astore 23
    //   659: ldc 180
    //   661: new 221	java/lang/StringBuilder
    //   664: dup
    //   665: ldc 223
    //   667: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   670: aload_0
    //   671: invokevirtual 228	java/lang/Exception:toString	()Ljava/lang/String;
    //   674: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: aload 21
    //   685: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   688: aload_1
    //   689: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   692: iload 18
    //   694: istore 19
    //   696: goto -330 -> 366
    //   699: aload 21
    //   701: astore 22
    //   703: aload 25
    //   705: astore 23
    //   707: aload 21
    //   709: aload 21
    //   711: invokevirtual 176	java/nio/channels/FileChannel:position	()J
    //   714: lload 10
    //   716: ladd
    //   717: ldc2_w 234
    //   720: lsub
    //   721: invokevirtual 238	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   724: pop
    //   725: goto -424 -> 301
    //   728: astore_0
    //   729: aload 22
    //   731: astore 21
    //   733: aload 21
    //   735: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   738: aload 23
    //   740: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   743: ldc 142
    //   745: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   748: aload_0
    //   749: athrow
    //   750: aload 21
    //   752: astore 22
    //   754: aload 25
    //   756: astore 23
    //   758: aload 21
    //   760: aload 21
    //   762: invokevirtual 176	java/nio/channels/FileChannel:position	()J
    //   765: lload 10
    //   767: ladd
    //   768: ldc2_w 177
    //   771: lsub
    //   772: invokevirtual 238	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   775: pop
    //   776: goto -475 -> 301
    //   779: aload 21
    //   781: astore 22
    //   783: aload 25
    //   785: astore 23
    //   787: iload 4
    //   789: getstatic 52	com/tencent/mm/plugin/a/e:mHp	I
    //   792: if_icmpne +10 -> 802
    //   795: lload 12
    //   797: lconst_0
    //   798: lcmp
    //   799: ifge +24 -> 823
    //   802: aload 21
    //   804: astore 22
    //   806: aload 25
    //   808: astore 23
    //   810: ldc 180
    //   812: ldc 240
    //   814: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   817: iconst_0
    //   818: istore 18
    //   820: goto -488 -> 332
    //   823: aload 21
    //   825: astore 22
    //   827: aload 25
    //   829: astore 23
    //   831: lload 10
    //   833: invokestatic 165	com/tencent/mm/plugin/a/e:Ha	(J)I
    //   836: istore 4
    //   838: aload 21
    //   840: astore 22
    //   842: aload 25
    //   844: astore 23
    //   846: iload 4
    //   848: invokestatic 159	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   851: getstatic 132	java/nio/ByteOrder:BIG_ENDIAN	Ljava/nio/ByteOrder;
    //   854: invokevirtual 136	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   857: astore_2
    //   858: aload 21
    //   860: astore 22
    //   862: aload 25
    //   864: astore 23
    //   866: aload_2
    //   867: invokevirtual 108	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   870: pop
    //   871: aload 21
    //   873: astore 22
    //   875: aload 25
    //   877: astore 23
    //   879: aload 21
    //   881: aload_2
    //   882: lload 12
    //   884: invokevirtual 243	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;J)I
    //   887: istore_3
    //   888: aload 21
    //   890: astore 22
    //   892: aload 25
    //   894: astore 23
    //   896: aload_2
    //   897: invokevirtual 117	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   900: pop
    //   901: aload 21
    //   903: astore 22
    //   905: aload 25
    //   907: astore 23
    //   909: iload_3
    //   910: aload_2
    //   911: invokevirtual 121	java/nio/ByteBuffer:capacity	()I
    //   914: if_icmpne +742 -> 1656
    //   917: iconst_1
    //   918: istore_3
    //   919: iload_3
    //   920: ifne +24 -> 944
    //   923: aload 21
    //   925: astore 22
    //   927: aload 25
    //   929: astore 23
    //   931: ldc 180
    //   933: ldc 245
    //   935: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   938: iconst_0
    //   939: istore 18
    //   941: goto -609 -> 332
    //   944: aload 21
    //   946: astore 22
    //   948: aload 25
    //   950: astore 23
    //   952: aload_2
    //   953: bipush 12
    //   955: invokevirtual 248	java/nio/ByteBuffer:getInt	(I)I
    //   958: getstatic 76	com/tencent/mm/plugin/a/e:mHw	I
    //   961: if_icmpne +24 -> 985
    //   964: aload 21
    //   966: astore 22
    //   968: aload 25
    //   970: astore 23
    //   972: ldc 180
    //   974: ldc 250
    //   976: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   979: iconst_0
    //   980: istore 18
    //   982: goto -650 -> 332
    //   985: aload 21
    //   987: astore 22
    //   989: aload 25
    //   991: astore 23
    //   993: aload_2
    //   994: invokevirtual 253	java/nio/ByteBuffer:remaining	()I
    //   997: bipush 8
    //   999: if_icmplt +430 -> 1429
    //   1002: aload 21
    //   1004: astore 22
    //   1006: aload 25
    //   1008: astore 23
    //   1010: aload_2
    //   1011: invokevirtual 255	java/nio/ByteBuffer:position	()I
    //   1014: istore 5
    //   1016: aload 21
    //   1018: astore 22
    //   1020: aload 25
    //   1022: astore 23
    //   1024: aload_2
    //   1025: iload 5
    //   1027: iconst_4
    //   1028: iadd
    //   1029: invokevirtual 248	java/nio/ByteBuffer:getInt	(I)I
    //   1032: istore_3
    //   1033: aload 21
    //   1035: astore 22
    //   1037: aload 25
    //   1039: astore 23
    //   1041: iload_3
    //   1042: getstatic 78	com/tencent/mm/plugin/a/e:mHx	I
    //   1045: if_icmpeq +40 -> 1085
    //   1048: aload 21
    //   1050: astore 22
    //   1052: aload 25
    //   1054: astore 23
    //   1056: iload_3
    //   1057: getstatic 82	com/tencent/mm/plugin/a/e:mHy	I
    //   1060: if_icmpeq +25 -> 1085
    //   1063: aload 21
    //   1065: astore 22
    //   1067: aload 25
    //   1069: astore 23
    //   1071: aload_2
    //   1072: aload_2
    //   1073: invokevirtual 255	java/nio/ByteBuffer:position	()I
    //   1076: iconst_1
    //   1077: iadd
    //   1078: invokevirtual 258	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1081: pop
    //   1082: goto -97 -> 985
    //   1085: aload 21
    //   1087: astore 22
    //   1089: aload 25
    //   1091: astore 23
    //   1093: aload_2
    //   1094: iload 5
    //   1096: invokevirtual 248	java/nio/ByteBuffer:getInt	(I)I
    //   1099: i2l
    //   1100: ldc2_w 162
    //   1103: land
    //   1104: aload_2
    //   1105: invokevirtual 253	java/nio/ByteBuffer:remaining	()I
    //   1108: i2l
    //   1109: lcmp
    //   1110: ifle +25 -> 1135
    //   1113: aload 21
    //   1115: astore 22
    //   1117: aload 25
    //   1119: astore 23
    //   1121: ldc 180
    //   1123: ldc_w 260
    //   1126: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1129: iconst_0
    //   1130: istore 18
    //   1132: goto -800 -> 332
    //   1135: aload 21
    //   1137: astore 22
    //   1139: aload 25
    //   1141: astore 23
    //   1143: aload_2
    //   1144: iload 5
    //   1146: bipush 12
    //   1148: iadd
    //   1149: invokevirtual 258	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1152: pop
    //   1153: aload 21
    //   1155: astore 22
    //   1157: aload 25
    //   1159: astore 23
    //   1161: aload_2
    //   1162: invokevirtual 253	java/nio/ByteBuffer:remaining	()I
    //   1165: iconst_4
    //   1166: if_icmpge +25 -> 1191
    //   1169: aload 21
    //   1171: astore 22
    //   1173: aload 25
    //   1175: astore 23
    //   1177: ldc 180
    //   1179: ldc_w 262
    //   1182: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1185: iconst_0
    //   1186: istore 18
    //   1188: goto -856 -> 332
    //   1191: aload 21
    //   1193: astore 22
    //   1195: aload 25
    //   1197: astore 23
    //   1199: aload_2
    //   1200: invokevirtual 139	java/nio/ByteBuffer:getInt	()I
    //   1203: i2l
    //   1204: invokestatic 165	com/tencent/mm/plugin/a/e:Ha	(J)I
    //   1207: istore 5
    //   1209: aload 21
    //   1211: astore 22
    //   1213: aload 25
    //   1215: astore 23
    //   1217: iload_3
    //   1218: getstatic 78	com/tencent/mm/plugin/a/e:mHx	I
    //   1221: if_icmpne +113 -> 1334
    //   1224: aload 21
    //   1226: astore 22
    //   1228: aload 25
    //   1230: astore 23
    //   1232: aload_2
    //   1233: invokevirtual 253	java/nio/ByteBuffer:remaining	()I
    //   1236: iload 5
    //   1238: iconst_4
    //   1239: imul
    //   1240: if_icmpge +421 -> 1661
    //   1243: aload 21
    //   1245: astore 22
    //   1247: aload 25
    //   1249: astore 23
    //   1251: ldc 180
    //   1253: ldc_w 264
    //   1256: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1259: iconst_0
    //   1260: istore 18
    //   1262: goto -930 -> 332
    //   1265: iload_3
    //   1266: iload 5
    //   1268: if_icmpge -283 -> 985
    //   1271: aload 21
    //   1273: astore 22
    //   1275: aload 25
    //   1277: astore 23
    //   1279: aload_2
    //   1280: aload_2
    //   1281: invokevirtual 255	java/nio/ByteBuffer:position	()I
    //   1284: invokevirtual 248	java/nio/ByteBuffer:getInt	(I)I
    //   1287: istore 6
    //   1289: iload 6
    //   1291: iload 4
    //   1293: iadd
    //   1294: istore 7
    //   1296: iload 6
    //   1298: ifge +14 -> 1312
    //   1301: iload 7
    //   1303: iflt +9 -> 1312
    //   1306: iconst_0
    //   1307: istore 18
    //   1309: goto -977 -> 332
    //   1312: aload 21
    //   1314: astore 22
    //   1316: aload 25
    //   1318: astore 23
    //   1320: aload_2
    //   1321: iload 7
    //   1323: invokevirtual 267	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   1326: pop
    //   1327: iload_3
    //   1328: iconst_1
    //   1329: iadd
    //   1330: istore_3
    //   1331: goto -66 -> 1265
    //   1334: aload 21
    //   1336: astore 22
    //   1338: aload 25
    //   1340: astore 23
    //   1342: iload_3
    //   1343: getstatic 82	com/tencent/mm/plugin/a/e:mHy	I
    //   1346: if_icmpne -361 -> 985
    //   1349: aload 21
    //   1351: astore 22
    //   1353: aload 25
    //   1355: astore 23
    //   1357: aload_2
    //   1358: invokevirtual 253	java/nio/ByteBuffer:remaining	()I
    //   1361: iload 5
    //   1363: bipush 8
    //   1365: imul
    //   1366: if_icmpge +300 -> 1666
    //   1369: aload 21
    //   1371: astore 22
    //   1373: aload 25
    //   1375: astore 23
    //   1377: ldc 180
    //   1379: ldc_w 264
    //   1382: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1385: iconst_0
    //   1386: istore 18
    //   1388: goto -1056 -> 332
    //   1391: iload_3
    //   1392: iload 5
    //   1394: if_icmpge -409 -> 985
    //   1397: aload 21
    //   1399: astore 22
    //   1401: aload 25
    //   1403: astore 23
    //   1405: aload_2
    //   1406: aload_2
    //   1407: aload_2
    //   1408: invokevirtual 255	java/nio/ByteBuffer:position	()I
    //   1411: invokevirtual 270	java/nio/ByteBuffer:getLong	(I)J
    //   1414: iload 4
    //   1416: i2l
    //   1417: ladd
    //   1418: invokevirtual 274	java/nio/ByteBuffer:putLong	(J)Ljava/nio/ByteBuffer;
    //   1421: pop
    //   1422: iload_3
    //   1423: iconst_1
    //   1424: iadd
    //   1425: istore_3
    //   1426: goto -35 -> 1391
    //   1429: aload 21
    //   1431: astore 22
    //   1433: aload 25
    //   1435: astore 23
    //   1437: aload 21
    //   1439: lload 14
    //   1441: invokevirtual 238	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
    //   1444: pop
    //   1445: aload 20
    //   1447: ifnull +33 -> 1480
    //   1450: aload 21
    //   1452: astore 22
    //   1454: aload 25
    //   1456: astore 23
    //   1458: aload 20
    //   1460: invokevirtual 168	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1463: pop
    //   1464: aload 21
    //   1466: astore 22
    //   1468: aload 25
    //   1470: astore 23
    //   1472: aload 25
    //   1474: aload 20
    //   1476: invokevirtual 277	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   1479: pop
    //   1480: aload 21
    //   1482: astore 22
    //   1484: aload 25
    //   1486: astore 23
    //   1488: aload_2
    //   1489: invokevirtual 168	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1492: pop
    //   1493: aload 21
    //   1495: astore 22
    //   1497: aload 25
    //   1499: astore 23
    //   1501: aload 25
    //   1503: aload_2
    //   1504: invokevirtual 277	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   1507: pop
    //   1508: aload 21
    //   1510: astore 22
    //   1512: aload 25
    //   1514: astore 23
    //   1516: aload 21
    //   1518: lload 14
    //   1520: lload 12
    //   1522: lload 14
    //   1524: lsub
    //   1525: aload 25
    //   1527: invokevirtual 281	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   1530: pop2
    //   1531: aload 21
    //   1533: astore 22
    //   1535: aload 25
    //   1537: astore 23
    //   1539: aload 21
    //   1541: iload 4
    //   1543: i2l
    //   1544: lload 12
    //   1546: ladd
    //   1547: aload 21
    //   1549: invokevirtual 284	java/nio/channels/FileChannel:size	()J
    //   1552: lload 12
    //   1554: lsub
    //   1555: iload 4
    //   1557: i2l
    //   1558: lsub
    //   1559: aload 25
    //   1561: invokevirtual 281	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   1564: pop2
    //   1565: iconst_1
    //   1566: istore 18
    //   1568: goto -1236 -> 332
    //   1571: astore_0
    //   1572: aconst_null
    //   1573: astore 23
    //   1575: aconst_null
    //   1576: astore 21
    //   1578: goto -845 -> 733
    //   1581: astore_0
    //   1582: aconst_null
    //   1583: astore 23
    //   1585: goto -852 -> 733
    //   1588: astore_0
    //   1589: aconst_null
    //   1590: astore_1
    //   1591: aconst_null
    //   1592: astore 21
    //   1594: iconst_0
    //   1595: istore 18
    //   1597: goto -945 -> 652
    //   1600: astore_0
    //   1601: aconst_null
    //   1602: astore_1
    //   1603: iconst_0
    //   1604: istore 18
    //   1606: goto -954 -> 652
    //   1609: astore_0
    //   1610: aload 25
    //   1612: astore_1
    //   1613: goto -961 -> 652
    //   1616: ldc2_w 285
    //   1619: lstore 16
    //   1621: iload 7
    //   1623: istore 4
    //   1625: lload 12
    //   1627: lstore 10
    //   1629: aload 24
    //   1631: astore 20
    //   1633: iload 6
    //   1635: istore_3
    //   1636: lload 16
    //   1638: lstore 12
    //   1640: iload 8
    //   1642: istore 5
    //   1644: iload_3
    //   1645: ifeq -1157 -> 488
    //   1648: iload 5
    //   1650: ifne -871 -> 779
    //   1653: goto -1165 -> 488
    //   1656: iconst_0
    //   1657: istore_3
    //   1658: goto -739 -> 919
    //   1661: iconst_0
    //   1662: istore_3
    //   1663: goto -398 -> 1265
    //   1666: iconst_0
    //   1667: istore_3
    //   1668: goto -277 -> 1391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1671	0	paramString1	java.lang.String
    //   0	1671	1	paramString2	java.lang.String
    //   0	1671	2	paramPInt	com.tencent.mm.pointers.PInt
    //   79	1589	3	i	int
    //   46	1578	4	j	int
    //   81	1568	5	k	int
    //   95	1539	6	m	int
    //   103	1519	7	n	int
    //   84	1557	8	i1	int
    //   184	85	9	i2	int
    //   133	1495	10	l1	long
    //   49	1590	12	l2	long
    //   76	1447	14	l3	long
    //   1619	18	16	l4	long
    //   330	1275	18	bool1	boolean
    //   334	361	19	bool2	boolean
    //   13	1619	20	localObject1	Object
    //   33	1560	21	localObject2	Object
    //   56	1478	22	localObject3	Object
    //   60	1524	23	localObject4	Object
    //   99	1531	24	localObject5	Object
    //   43	1568	25	localFileChannel	FileChannel
    //   23	349	26	localq	com.tencent.mm.vfs.q
    //   73	518	27	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   62	75	645	java/lang/Exception
    //   105	115	645	java/lang/Exception
    //   123	135	645	java/lang/Exception
    //   143	150	645	java/lang/Exception
    //   158	166	645	java/lang/Exception
    //   179	186	645	java/lang/Exception
    //   194	207	645	java/lang/Exception
    //   215	221	645	java/lang/Exception
    //   229	237	645	java/lang/Exception
    //   257	272	645	java/lang/Exception
    //   280	286	645	java/lang/Exception
    //   294	301	645	java/lang/Exception
    //   322	329	645	java/lang/Exception
    //   393	401	645	java/lang/Exception
    //   409	416	645	java/lang/Exception
    //   432	439	645	java/lang/Exception
    //   447	452	645	java/lang/Exception
    //   466	473	645	java/lang/Exception
    //   496	503	645	java/lang/Exception
    //   517	525	645	java/lang/Exception
    //   543	549	645	java/lang/Exception
    //   572	582	645	java/lang/Exception
    //   590	597	645	java/lang/Exception
    //   612	622	645	java/lang/Exception
    //   630	635	645	java/lang/Exception
    //   643	645	645	java/lang/Exception
    //   707	725	645	java/lang/Exception
    //   758	776	645	java/lang/Exception
    //   787	795	645	java/lang/Exception
    //   810	817	645	java/lang/Exception
    //   831	838	645	java/lang/Exception
    //   846	858	645	java/lang/Exception
    //   866	871	645	java/lang/Exception
    //   879	888	645	java/lang/Exception
    //   896	901	645	java/lang/Exception
    //   909	917	645	java/lang/Exception
    //   931	938	645	java/lang/Exception
    //   952	964	645	java/lang/Exception
    //   972	979	645	java/lang/Exception
    //   993	1002	645	java/lang/Exception
    //   1010	1016	645	java/lang/Exception
    //   1024	1033	645	java/lang/Exception
    //   1041	1048	645	java/lang/Exception
    //   1056	1063	645	java/lang/Exception
    //   1071	1082	645	java/lang/Exception
    //   1093	1113	645	java/lang/Exception
    //   1121	1129	645	java/lang/Exception
    //   1143	1153	645	java/lang/Exception
    //   1161	1169	645	java/lang/Exception
    //   1177	1185	645	java/lang/Exception
    //   1199	1209	645	java/lang/Exception
    //   1217	1224	645	java/lang/Exception
    //   1232	1243	645	java/lang/Exception
    //   1251	1259	645	java/lang/Exception
    //   1279	1289	645	java/lang/Exception
    //   1320	1327	645	java/lang/Exception
    //   1342	1349	645	java/lang/Exception
    //   1357	1369	645	java/lang/Exception
    //   1377	1385	645	java/lang/Exception
    //   1405	1422	645	java/lang/Exception
    //   1437	1445	645	java/lang/Exception
    //   1458	1464	645	java/lang/Exception
    //   1472	1480	645	java/lang/Exception
    //   1488	1493	645	java/lang/Exception
    //   1501	1508	645	java/lang/Exception
    //   1516	1531	645	java/lang/Exception
    //   1539	1565	645	java/lang/Exception
    //   62	75	728	finally
    //   105	115	728	finally
    //   123	135	728	finally
    //   143	150	728	finally
    //   158	166	728	finally
    //   179	186	728	finally
    //   194	207	728	finally
    //   215	221	728	finally
    //   229	237	728	finally
    //   257	272	728	finally
    //   280	286	728	finally
    //   294	301	728	finally
    //   322	329	728	finally
    //   349	356	728	finally
    //   393	401	728	finally
    //   409	416	728	finally
    //   432	439	728	finally
    //   447	452	728	finally
    //   466	473	728	finally
    //   496	503	728	finally
    //   517	525	728	finally
    //   543	549	728	finally
    //   572	582	728	finally
    //   590	597	728	finally
    //   612	622	728	finally
    //   630	635	728	finally
    //   643	645	728	finally
    //   659	683	728	finally
    //   707	725	728	finally
    //   758	776	728	finally
    //   787	795	728	finally
    //   810	817	728	finally
    //   831	838	728	finally
    //   846	858	728	finally
    //   866	871	728	finally
    //   879	888	728	finally
    //   896	901	728	finally
    //   909	917	728	finally
    //   931	938	728	finally
    //   952	964	728	finally
    //   972	979	728	finally
    //   993	1002	728	finally
    //   1010	1016	728	finally
    //   1024	1033	728	finally
    //   1041	1048	728	finally
    //   1056	1063	728	finally
    //   1071	1082	728	finally
    //   1093	1113	728	finally
    //   1121	1129	728	finally
    //   1143	1153	728	finally
    //   1161	1169	728	finally
    //   1177	1185	728	finally
    //   1199	1209	728	finally
    //   1217	1224	728	finally
    //   1232	1243	728	finally
    //   1251	1259	728	finally
    //   1279	1289	728	finally
    //   1320	1327	728	finally
    //   1342	1349	728	finally
    //   1357	1369	728	finally
    //   1377	1385	728	finally
    //   1405	1422	728	finally
    //   1437	1445	728	finally
    //   1458	1464	728	finally
    //   1472	1480	728	finally
    //   1488	1493	728	finally
    //   1501	1508	728	finally
    //   1516	1531	728	finally
    //   1539	1565	728	finally
    //   25	35	1571	finally
    //   35	45	1581	finally
    //   25	35	1588	java/lang/Exception
    //   35	45	1600	java/lang/Exception
    //   349	356	1609	java/lang/Exception
  }
  
  /* Error */
  private static boolean bY(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: ldc_w 287
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 144	com/tencent/mm/vfs/q
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 145	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: new 144	com/tencent/mm/vfs/q
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 145	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   24: astore 7
    //   26: aload 6
    //   28: invokevirtual 290	com/tencent/mm/vfs/q:length	()J
    //   31: aload 7
    //   33: invokevirtual 290	com/tencent/mm/vfs/q:length	()J
    //   36: lcmp
    //   37: ifeq +19 -> 56
    //   40: ldc 180
    //   42: ldc_w 292
    //   45: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc_w 287
    //   51: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: iconst_0
    //   55: ireturn
    //   56: new 294	com/tencent/mm/plugin/a/b
    //   59: dup
    //   60: invokespecial 296	com/tencent/mm/plugin/a/b:<init>	()V
    //   63: aload_0
    //   64: invokevirtual 300	com/tencent/mm/plugin/a/b:ZY	(Ljava/lang/String;)J
    //   67: lstore 4
    //   69: new 302	com/tencent/mm/plugin/a/j
    //   72: dup
    //   73: invokespecial 303	com/tencent/mm/plugin/a/j:<init>	()V
    //   76: astore 9
    //   78: aload 9
    //   80: aload_0
    //   81: lload 4
    //   83: invokevirtual 307	com/tencent/mm/plugin/a/j:K	(Ljava/lang/String;J)Z
    //   86: pop
    //   87: aload 9
    //   89: getfield 310	com/tencent/mm/plugin/a/j:mHG	I
    //   92: istore_3
    //   93: new 294	com/tencent/mm/plugin/a/b
    //   96: dup
    //   97: invokespecial 296	com/tencent/mm/plugin/a/b:<init>	()V
    //   100: aload_1
    //   101: invokevirtual 300	com/tencent/mm/plugin/a/b:ZY	(Ljava/lang/String;)J
    //   104: lstore 4
    //   106: new 302	com/tencent/mm/plugin/a/j
    //   109: dup
    //   110: invokespecial 303	com/tencent/mm/plugin/a/j:<init>	()V
    //   113: astore 8
    //   115: aload 8
    //   117: aload_1
    //   118: lload 4
    //   120: invokevirtual 307	com/tencent/mm/plugin/a/j:K	(Ljava/lang/String;J)Z
    //   123: pop
    //   124: aload 8
    //   126: getfield 310	com/tencent/mm/plugin/a/j:mHG	I
    //   129: istore_2
    //   130: iload_2
    //   131: iload_3
    //   132: if_icmpeq +19 -> 151
    //   135: ldc 180
    //   137: ldc_w 312
    //   140: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: ldc_w 287
    //   146: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: ldc 180
    //   153: new 221	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 314
    //   160: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: iload_3
    //   164: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 319
    //   170: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload_2
    //   174: invokevirtual 317	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: new 321	java/util/Random
    //   186: dup
    //   187: invokespecial 322	java/util/Random:<init>	()V
    //   190: iload_2
    //   191: iconst_1
    //   192: isub
    //   193: invokevirtual 325	java/util/Random:nextInt	(I)I
    //   196: iconst_1
    //   197: iadd
    //   198: istore_3
    //   199: iload_3
    //   200: iconst_1
    //   201: iadd
    //   202: iload_2
    //   203: if_icmple +88 -> 291
    //   206: new 207	com/tencent/mm/pointers/PInt
    //   209: dup
    //   210: invokespecial 326	com/tencent/mm/pointers/PInt:<init>	()V
    //   213: astore_0
    //   214: new 207	com/tencent/mm/pointers/PInt
    //   217: dup
    //   218: invokespecial 326	com/tencent/mm/pointers/PInt:<init>	()V
    //   221: astore 10
    //   223: aload 9
    //   225: iload_3
    //   226: iload_2
    //   227: aload_0
    //   228: aload 10
    //   230: invokevirtual 329	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   233: pop
    //   234: new 207	com/tencent/mm/pointers/PInt
    //   237: dup
    //   238: invokespecial 326	com/tencent/mm/pointers/PInt:<init>	()V
    //   241: astore_1
    //   242: new 207	com/tencent/mm/pointers/PInt
    //   245: dup
    //   246: invokespecial 326	com/tencent/mm/pointers/PInt:<init>	()V
    //   249: astore 9
    //   251: aload 8
    //   253: iload_3
    //   254: iload_2
    //   255: aload_1
    //   256: aload 9
    //   258: invokevirtual 329	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   261: pop
    //   262: aload 9
    //   264: getfield 210	com/tencent/mm/pointers/PInt:value	I
    //   267: aload 10
    //   269: getfield 210	com/tencent/mm/pointers/PInt:value	I
    //   272: if_icmpeq +26 -> 298
    //   275: ldc 180
    //   277: ldc_w 331
    //   280: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: ldc_w 287
    //   286: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: iload_3
    //   292: iconst_1
    //   293: iadd
    //   294: istore_2
    //   295: goto -89 -> 206
    //   298: aload 6
    //   300: invokestatic 335	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   303: astore 6
    //   305: aload 6
    //   307: aload_0
    //   308: getfield 210	com/tencent/mm/pointers/PInt:value	I
    //   311: i2l
    //   312: invokevirtual 341	java/io/InputStream:skip	(J)J
    //   315: pop2
    //   316: sipush 4096
    //   319: newarray byte
    //   321: astore 8
    //   323: aload 6
    //   325: aload 8
    //   327: invokevirtual 343	java/io/InputStream:read	([B)I
    //   330: pop
    //   331: aload 7
    //   333: invokestatic 335	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
    //   336: astore_0
    //   337: aload_0
    //   338: aload_1
    //   339: getfield 210	com/tencent/mm/pointers/PInt:value	I
    //   342: i2l
    //   343: invokevirtual 341	java/io/InputStream:skip	(J)J
    //   346: pop2
    //   347: sipush 4096
    //   350: newarray byte
    //   352: astore_1
    //   353: aload 6
    //   355: aload_1
    //   356: invokevirtual 343	java/io/InputStream:read	([B)I
    //   359: pop
    //   360: aload 8
    //   362: aload_1
    //   363: invokestatic 349	java/util/Arrays:equals	([B[B)Z
    //   366: ifeq +28 -> 394
    //   369: ldc 180
    //   371: ldc_w 351
    //   374: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload 6
    //   379: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   382: aload_0
    //   383: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   386: ldc_w 287
    //   389: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: iconst_0
    //   393: ireturn
    //   394: aload 6
    //   396: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   399: aload_0
    //   400: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   403: ldc_w 287
    //   406: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   409: iconst_1
    //   410: ireturn
    //   411: astore_0
    //   412: aconst_null
    //   413: astore_1
    //   414: aconst_null
    //   415: astore 6
    //   417: ldc 180
    //   419: new 221	java/lang/StringBuilder
    //   422: dup
    //   423: ldc 223
    //   425: invokespecial 224	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   428: aload_0
    //   429: invokevirtual 228	java/lang/Exception:toString	()Ljava/lang/String;
    //   432: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: aload 6
    //   443: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   446: aload_1
    //   447: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   450: goto -47 -> 403
    //   453: astore_0
    //   454: aconst_null
    //   455: astore_1
    //   456: aconst_null
    //   457: astore 6
    //   459: aload 6
    //   461: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   464: aload_1
    //   465: invokestatic 196	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   468: ldc_w 287
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
    //   24	308	7	localq	com.tencent.mm.vfs.q
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.e
 * JD-Core Version:    0.7.0.1
 */