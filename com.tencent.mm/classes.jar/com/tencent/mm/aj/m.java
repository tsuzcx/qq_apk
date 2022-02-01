package com.tencent.mm.aj;

import androidx.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.enk;
import com.tencent.mm.protocal.protobuf.enl;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import java.io.IOException;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private int bNu;
  private com.tencent.mm.ak.i callback;
  private String dRr;
  private int iKP;
  private int iKQ;
  private String iLf;
  private String iLg;
  private String username;
  
  public m(int paramInt, String paramString)
  {
    this(1, paramString, (byte)0);
  }
  
  public m(int paramInt, String paramString, byte paramByte)
  {
    AppMethodBeat.i(223535);
    this.username = null;
    if (Util.isNullOrNil(null))
    {
      this.username = z.aTY();
      if (paramInt == 2) {
        this.username = as.bjz(this.username);
      }
    }
    p.aYn();
    this.iLf = e.M(this.username, true);
    String str = this.iLf + ".tmp";
    if (bd(paramString, str) == 0)
    {
      this.dRr = str;
      this.iKQ = paramInt;
      p.aYn();
      this.iLg = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.vfs.s.aW(e.L(this.username, true), 0, -1));
      this.iKP = 0;
      this.bNu = 0;
    }
    AppMethodBeat.o(223535);
  }
  
  private static boolean Mz(String paramString)
  {
    AppMethodBeat.i(223534);
    try
    {
      Object localObject = new a(paramString);
      paramString = ((a)localObject).getAttribute("GPSLongitude");
      String str1 = ((a)localObject).getAttribute("GPSLatitude");
      String str2 = ((a)localObject).getAttribute("GPSLongitudeRef");
      String str3 = ((a)localObject).getAttribute("GPSLatitudeRef");
      String str4 = ((a)localObject).getAttribute("GPSDestLongitude");
      localObject = ((a)localObject).getAttribute("GPSDestLongitudeRef");
      if ((paramString != null) || (str1 != null) || (str2 != null) || (str3 != null) || (str4 != null) || (localObject != null))
      {
        AppMethodBeat.o(223534);
        return true;
      }
      AppMethodBeat.o(223534);
      return false;
    }
    catch (IOException paramString)
    {
      AppMethodBeat.o(223534);
    }
    return false;
  }
  
  /* Error */
  private static int bd(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 138
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 144	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   9: astore 17
    //   11: new 146	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 147	java/util/ArrayList:<init>	()V
    //   18: astore 11
    //   20: aload 11
    //   22: new 149	com/tencent/mars/smc/IDKey
    //   25: dup
    //   26: sipush 1515
    //   29: iconst_0
    //   30: iconst_1
    //   31: invokespecial 152	com/tencent/mars/smc/IDKey:<init>	(III)V
    //   34: invokevirtual 156	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload 17
    //   40: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   43: sipush 640
    //   46: if_icmpge +219 -> 265
    //   49: aload 17
    //   51: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   54: sipush 640
    //   57: if_icmpge +208 -> 265
    //   60: iconst_1
    //   61: istore 4
    //   63: aload_0
    //   64: invokestatic 166	com/tencent/mm/aj/m:Mz	(Ljava/lang/String;)Z
    //   67: istore 10
    //   69: iload 4
    //   71: ifeq +206 -> 277
    //   74: iload 10
    //   76: ifeq +195 -> 271
    //   79: iconst_1
    //   80: istore 4
    //   82: aload 11
    //   84: new 149	com/tencent/mars/smc/IDKey
    //   87: dup
    //   88: sipush 1515
    //   91: iload 4
    //   93: iconst_1
    //   94: invokespecial 152	com/tencent/mars/smc/IDKey:<init>	(III)V
    //   97: invokevirtual 156	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: getstatic 172	com/tencent/mm/plugin/report/e:Cxv	Lcom/tencent/mm/plugin/report/e;
    //   104: aload 11
    //   106: iconst_0
    //   107: invokevirtual 176	com/tencent/mm/plugin/report/e:b	(Ljava/util/ArrayList;Z)V
    //   110: aload 17
    //   112: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   115: sipush 640
    //   118: if_icmpge +838 -> 956
    //   121: aload 17
    //   123: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   126: sipush 640
    //   129: if_icmpge +827 -> 956
    //   132: aload_0
    //   133: aload_1
    //   134: invokestatic 180	com/tencent/mm/vfs/s:nw	(Ljava/lang/String;Ljava/lang/String;)J
    //   137: pop2
    //   138: new 117	androidx/a/a/a
    //   141: dup
    //   142: aload_1
    //   143: invokespecial 120	androidx/a/a/a:<init>	(Ljava/lang/String;)V
    //   146: astore 18
    //   148: aload 18
    //   150: ldc 122
    //   152: invokevirtual 183	androidx/a/a/a:K	(Ljava/lang/String;)V
    //   155: aload 18
    //   157: ldc 127
    //   159: invokevirtual 183	androidx/a/a/a:K	(Ljava/lang/String;)V
    //   162: aload 18
    //   164: ldc 129
    //   166: invokevirtual 183	androidx/a/a/a:K	(Ljava/lang/String;)V
    //   169: aload 18
    //   171: ldc 131
    //   173: invokevirtual 183	androidx/a/a/a:K	(Ljava/lang/String;)V
    //   176: aload 18
    //   178: ldc 133
    //   180: invokevirtual 183	androidx/a/a/a:K	(Ljava/lang/String;)V
    //   183: aload 18
    //   185: ldc 135
    //   187: invokevirtual 183	androidx/a/a/a:K	(Ljava/lang/String;)V
    //   190: aload 18
    //   192: getfield 187	androidx/a/a/a:zq	Z
    //   195: ifeq +12 -> 207
    //   198: aload 18
    //   200: getfield 190	androidx/a/a/a:zb	I
    //   203: iconst_4
    //   204: if_icmpeq +90 -> 294
    //   207: new 114	java/io/IOException
    //   210: dup
    //   211: ldc 192
    //   213: invokespecial 193	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   216: astore_0
    //   217: ldc 138
    //   219: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload_0
    //   223: athrow
    //   224: astore_0
    //   225: ldc 195
    //   227: ldc 197
    //   229: iconst_2
    //   230: anewarray 199	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload 17
    //   237: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   240: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: aastore
    //   244: dup
    //   245: iconst_1
    //   246: aload 17
    //   248: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   251: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: aastore
    //   255: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: ldc 138
    //   260: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: iconst_0
    //   264: ireturn
    //   265: iconst_0
    //   266: istore 4
    //   268: goto -205 -> 63
    //   271: iconst_2
    //   272: istore 4
    //   274: goto -192 -> 82
    //   277: iload 10
    //   279: ifeq +9 -> 288
    //   282: iconst_3
    //   283: istore 4
    //   285: goto -203 -> 82
    //   288: iconst_4
    //   289: istore 4
    //   291: goto -209 -> 82
    //   294: aload 18
    //   296: getfield 214	androidx/a/a/a:aBn	Ljava/io/FileDescriptor;
    //   299: ifnonnull +28 -> 327
    //   302: aload 18
    //   304: getfield 217	androidx/a/a/a:yZ	Ljava/lang/String;
    //   307: ifnonnull +20 -> 327
    //   310: new 114	java/io/IOException
    //   313: dup
    //   314: ldc 219
    //   316: invokespecial 193	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   319: astore_0
    //   320: ldc 138
    //   322: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   325: aload_0
    //   326: athrow
    //   327: aload 18
    //   329: iconst_1
    //   330: putfield 222	androidx/a/a/a:aBo	Z
    //   333: aload 18
    //   335: aload 18
    //   337: invokevirtual 226	androidx/a/a/a:getThumbnail	()[B
    //   340: putfield 230	androidx/a/a/a:zj	[B
    //   343: aconst_null
    //   344: astore 12
    //   346: aconst_null
    //   347: astore 11
    //   349: aconst_null
    //   350: astore_1
    //   351: aconst_null
    //   352: astore 13
    //   354: aconst_null
    //   355: astore 15
    //   357: aload 18
    //   359: getfield 217	androidx/a/a/a:yZ	Ljava/lang/String;
    //   362: ifnull +17 -> 379
    //   365: new 232	java/io/File
    //   368: dup
    //   369: aload 18
    //   371: getfield 217	androidx/a/a/a:yZ	Ljava/lang/String;
    //   374: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   377: astore 15
    //   379: aload 18
    //   381: getfield 217	androidx/a/a/a:yZ	Ljava/lang/String;
    //   384: ifnull +147 -> 531
    //   387: new 232	java/io/File
    //   390: dup
    //   391: new 69	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   398: aload 18
    //   400: getfield 217	androidx/a/a/a:yZ	Ljava/lang/String;
    //   403: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: ldc 76
    //   408: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokespecial 233	java/io/File:<init>	(Ljava/lang/String;)V
    //   417: astore_0
    //   418: aload 15
    //   420: aload_0
    //   421: invokevirtual 237	java/io/File:renameTo	(Ljava/io/File;)Z
    //   424: ifne +1767 -> 2191
    //   427: new 114	java/io/IOException
    //   430: dup
    //   431: new 69	java/lang/StringBuilder
    //   434: dup
    //   435: ldc 239
    //   437: invokespecial 240	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   440: aload_0
    //   441: invokevirtual 243	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   444: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokespecial 193	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   453: astore_0
    //   454: ldc 138
    //   456: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   459: aload_0
    //   460: athrow
    //   461: astore 12
    //   463: aconst_null
    //   464: astore_0
    //   465: aload 13
    //   467: astore_1
    //   468: aload_0
    //   469: astore 11
    //   471: new 114	java/io/IOException
    //   474: dup
    //   475: ldc 245
    //   477: aload 12
    //   479: invokespecial 248	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   482: astore 12
    //   484: aload 13
    //   486: astore_1
    //   487: aload_0
    //   488: astore 11
    //   490: ldc 138
    //   492: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   495: aload 13
    //   497: astore_1
    //   498: aload_0
    //   499: astore 11
    //   501: aload 12
    //   503: athrow
    //   504: astore 12
    //   506: aload 11
    //   508: astore_0
    //   509: aload_1
    //   510: astore 11
    //   512: aload 12
    //   514: astore_1
    //   515: aload_0
    //   516: invokestatic 252	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   519: aload 11
    //   521: invokestatic 252	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   524: ldc 138
    //   526: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   529: aload_1
    //   530: athrow
    //   531: getstatic 257	android/os/Build$VERSION:SDK_INT	I
    //   534: bipush 21
    //   536: if_icmplt +1641 -> 2177
    //   539: aload 18
    //   541: getfield 214	androidx/a/a/a:aBn	Ljava/io/FileDescriptor;
    //   544: ifnull +1633 -> 2177
    //   547: ldc_w 259
    //   550: ldc_w 261
    //   553: invokestatic 265	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   556: astore 14
    //   558: aload 18
    //   560: getfield 214	androidx/a/a/a:aBn	Ljava/io/FileDescriptor;
    //   563: lconst_0
    //   564: getstatic 270	android/system/OsConstants:SEEK_SET	I
    //   567: invokestatic 276	android/system/Os:lseek	(Ljava/io/FileDescriptor;JI)J
    //   570: pop2
    //   571: new 278	java/io/FileInputStream
    //   574: dup
    //   575: aload 18
    //   577: getfield 214	androidx/a/a/a:aBn	Ljava/io/FileDescriptor;
    //   580: invokespecial 281	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   583: astore_0
    //   584: aload 12
    //   586: astore_1
    //   587: aload_0
    //   588: astore 11
    //   590: new 283	java/io/FileOutputStream
    //   593: dup
    //   594: aload 14
    //   596: invokespecial 286	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   599: astore 12
    //   601: aload_0
    //   602: aload 12
    //   604: invokestatic 290	androidx/a/a/a:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   607: pop
    //   608: aload 14
    //   610: astore 11
    //   612: aload_0
    //   613: astore_1
    //   614: aload 11
    //   616: astore_0
    //   617: aload 12
    //   619: astore 11
    //   621: aload_1
    //   622: invokestatic 252	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   625: aload 11
    //   627: invokestatic 252	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   630: aconst_null
    //   631: astore_1
    //   632: aconst_null
    //   633: astore 11
    //   635: aconst_null
    //   636: astore 12
    //   638: aconst_null
    //   639: astore 16
    //   641: new 278	java/io/FileInputStream
    //   644: dup
    //   645: aload_0
    //   646: invokespecial 291	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   649: astore 14
    //   651: aload 18
    //   653: getfield 217	androidx/a/a/a:yZ	Ljava/lang/String;
    //   656: ifnull +72 -> 728
    //   659: new 283	java/io/FileOutputStream
    //   662: dup
    //   663: aload 18
    //   665: getfield 217	androidx/a/a/a:yZ	Ljava/lang/String;
    //   668: invokespecial 292	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   671: astore 13
    //   673: new 294	java/io/BufferedInputStream
    //   676: dup
    //   677: aload 14
    //   679: invokespecial 297	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   682: astore_1
    //   683: aload_1
    //   684: astore 12
    //   686: new 299	java/io/BufferedOutputStream
    //   689: dup
    //   690: aload 13
    //   692: invokespecial 302	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   695: astore 13
    //   697: aload 18
    //   699: aload_1
    //   700: aload 13
    //   702: invokevirtual 305	androidx/a/a/a:b	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   705: aload_1
    //   706: invokestatic 252	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   709: aload 13
    //   711: invokestatic 252	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   714: aload_0
    //   715: invokevirtual 309	java/io/File:delete	()Z
    //   718: pop
    //   719: aload 18
    //   721: aconst_null
    //   722: putfield 230	androidx/a/a/a:zj	[B
    //   725: goto -500 -> 225
    //   728: aload_1
    //   729: astore 13
    //   731: getstatic 257	android/os/Build$VERSION:SDK_INT	I
    //   734: bipush 21
    //   736: if_icmplt -63 -> 673
    //   739: aload_1
    //   740: astore 13
    //   742: aload 18
    //   744: getfield 214	androidx/a/a/a:aBn	Ljava/io/FileDescriptor;
    //   747: ifnull -74 -> 673
    //   750: aload 18
    //   752: getfield 214	androidx/a/a/a:aBn	Ljava/io/FileDescriptor;
    //   755: lconst_0
    //   756: getstatic 270	android/system/OsConstants:SEEK_SET	I
    //   759: invokestatic 276	android/system/Os:lseek	(Ljava/io/FileDescriptor;JI)J
    //   762: pop2
    //   763: new 283	java/io/FileOutputStream
    //   766: dup
    //   767: aload 18
    //   769: getfield 214	androidx/a/a/a:aBn	Ljava/io/FileDescriptor;
    //   772: invokespecial 310	java/io/FileOutputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   775: astore 13
    //   777: goto -104 -> 673
    //   780: astore 14
    //   782: aconst_null
    //   783: astore_1
    //   784: aload 16
    //   786: astore 13
    //   788: aload 13
    //   790: astore 11
    //   792: aload_1
    //   793: astore 12
    //   795: aload 18
    //   797: getfield 217	androidx/a/a/a:yZ	Ljava/lang/String;
    //   800: ifnull +113 -> 913
    //   803: aload 13
    //   805: astore 11
    //   807: aload_1
    //   808: astore 12
    //   810: aload_0
    //   811: aload 15
    //   813: invokevirtual 237	java/io/File:renameTo	(Ljava/io/File;)Z
    //   816: ifne +97 -> 913
    //   819: aload 13
    //   821: astore 11
    //   823: aload_1
    //   824: astore 12
    //   826: new 114	java/io/IOException
    //   829: dup
    //   830: new 69	java/lang/StringBuilder
    //   833: dup
    //   834: ldc_w 312
    //   837: invokespecial 240	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   840: aload 15
    //   842: invokevirtual 243	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   845: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokespecial 193	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   854: astore 14
    //   856: aload 13
    //   858: astore 11
    //   860: aload_1
    //   861: astore 12
    //   863: ldc 138
    //   865: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   868: aload 13
    //   870: astore 11
    //   872: aload_1
    //   873: astore 12
    //   875: aload 14
    //   877: athrow
    //   878: astore 13
    //   880: aload 12
    //   882: astore_1
    //   883: aload 11
    //   885: astore 12
    //   887: aload 13
    //   889: astore 11
    //   891: aload_1
    //   892: invokestatic 252	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   895: aload 12
    //   897: invokestatic 252	androidx/a/a/a:closeQuietly	(Ljava/io/Closeable;)V
    //   900: aload_0
    //   901: invokevirtual 309	java/io/File:delete	()Z
    //   904: pop
    //   905: ldc 138
    //   907: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   910: aload 11
    //   912: athrow
    //   913: aload 13
    //   915: astore 11
    //   917: aload_1
    //   918: astore 12
    //   920: new 114	java/io/IOException
    //   923: dup
    //   924: ldc_w 314
    //   927: aload 14
    //   929: invokespecial 248	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   932: astore 14
    //   934: aload 13
    //   936: astore 11
    //   938: aload_1
    //   939: astore 12
    //   941: ldc 138
    //   943: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   946: aload 13
    //   948: astore 11
    //   950: aload_1
    //   951: astore 12
    //   953: aload 14
    //   955: athrow
    //   956: bipush 50
    //   958: istore 4
    //   960: invokestatic 320	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   963: invokestatic 326	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   966: ifeq +436 -> 1402
    //   969: ldc_w 328
    //   972: invokestatic 334	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   975: checkcast 328	com/tencent/mm/plugin/zero/b/a
    //   978: invokeinterface 338 1 0
    //   983: ldc_w 340
    //   986: invokevirtual 345	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   989: bipush 50
    //   991: invokestatic 349	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   994: istore 5
    //   996: iload 5
    //   998: istore 4
    //   1000: iconst_0
    //   1001: istore 7
    //   1003: iconst_0
    //   1004: istore 6
    //   1006: iload 6
    //   1008: istore 5
    //   1010: invokestatic 320	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1013: invokestatic 326	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   1016: ifeq +506 -> 1522
    //   1019: iload 6
    //   1021: istore 5
    //   1023: ldc_w 328
    //   1026: invokestatic 334	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1029: checkcast 328	com/tencent/mm/plugin/zero/b/a
    //   1032: invokeinterface 338 1 0
    //   1037: ldc_w 351
    //   1040: invokevirtual 345	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1043: astore 11
    //   1045: iload 6
    //   1047: istore 5
    //   1049: aload 11
    //   1051: ldc_w 353
    //   1054: invokevirtual 359	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1057: istore 8
    //   1059: iload 7
    //   1061: istore 5
    //   1063: iconst_m1
    //   1064: iload 8
    //   1066: if_icmpeq +571 -> 1637
    //   1069: iload 6
    //   1071: istore 5
    //   1073: aload 11
    //   1075: iconst_0
    //   1076: iload 8
    //   1078: invokevirtual 363	java/lang/String:substring	(II)Ljava/lang/String;
    //   1081: invokestatic 366	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1084: invokevirtual 370	java/lang/Integer:intValue	()I
    //   1087: istore 6
    //   1089: iload 6
    //   1091: istore 5
    //   1093: aload 11
    //   1095: iload 8
    //   1097: iconst_1
    //   1098: iadd
    //   1099: invokevirtual 373	java/lang/String:substring	(I)Ljava/lang/String;
    //   1102: invokestatic 366	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1105: invokevirtual 370	java/lang/Integer:intValue	()I
    //   1108: istore 7
    //   1110: iload 6
    //   1112: istore 5
    //   1114: iload 7
    //   1116: istore 6
    //   1118: iload 5
    //   1120: ifgt +525 -> 1645
    //   1123: iload 6
    //   1125: ifgt +520 -> 1645
    //   1128: iconst_0
    //   1129: istore 6
    //   1131: sipush 1080
    //   1134: istore 5
    //   1136: aload 17
    //   1138: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   1141: aload 17
    //   1143: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   1146: if_icmple +542 -> 1688
    //   1149: aload 17
    //   1151: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   1154: istore 7
    //   1156: aload 17
    //   1158: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   1161: aload 17
    //   1163: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   1166: if_icmpge +532 -> 1698
    //   1169: aload 17
    //   1171: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   1174: istore 8
    //   1176: ldc 195
    //   1178: ldc_w 375
    //   1181: iconst_5
    //   1182: anewarray 199	java/lang/Object
    //   1185: dup
    //   1186: iconst_0
    //   1187: iload 6
    //   1189: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1192: aastore
    //   1193: dup
    //   1194: iconst_1
    //   1195: iload 5
    //   1197: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1200: aastore
    //   1201: dup
    //   1202: iconst_2
    //   1203: iload 4
    //   1205: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1208: aastore
    //   1209: dup
    //   1210: iconst_3
    //   1211: aload 17
    //   1213: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   1216: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1219: aastore
    //   1220: dup
    //   1221: iconst_4
    //   1222: aload 17
    //   1224: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   1227: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1230: aastore
    //   1231: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1234: iload 5
    //   1236: ifle +472 -> 1708
    //   1239: iload 8
    //   1241: iload 5
    //   1243: idiv
    //   1244: istore 7
    //   1246: aload 17
    //   1248: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   1251: iload 5
    //   1253: imul
    //   1254: iload 8
    //   1256: idiv
    //   1257: istore 6
    //   1259: iload 5
    //   1261: aload 17
    //   1263: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   1266: imul
    //   1267: iload 8
    //   1269: idiv
    //   1270: istore 5
    //   1272: iload 6
    //   1274: istore 9
    //   1276: iload 5
    //   1278: istore 8
    //   1280: iload 6
    //   1282: iload 5
    //   1284: imul
    //   1285: ldc_w 376
    //   1288: if_icmple +33 -> 1321
    //   1291: ldc2_w 377
    //   1294: iload 6
    //   1296: iload 5
    //   1298: imul
    //   1299: i2d
    //   1300: ddiv
    //   1301: invokestatic 384	java/lang/Math:sqrt	(D)D
    //   1304: dstore_2
    //   1305: iload 6
    //   1307: i2d
    //   1308: dload_2
    //   1309: ddiv
    //   1310: d2i
    //   1311: istore 9
    //   1313: iload 5
    //   1315: i2d
    //   1316: dload_2
    //   1317: ddiv
    //   1318: d2i
    //   1319: istore 8
    //   1321: new 158	android/graphics/BitmapFactory$Options
    //   1324: dup
    //   1325: invokespecial 385	android/graphics/BitmapFactory$Options:<init>	()V
    //   1328: astore 11
    //   1330: aload 11
    //   1332: getstatic 391	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1335: putfield 394	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   1338: iload 7
    //   1340: iconst_2
    //   1341: if_icmplt +10 -> 1351
    //   1344: aload 11
    //   1346: iload 7
    //   1348: putfield 397	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1351: aload_0
    //   1352: aload 11
    //   1354: invokestatic 401	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1357: astore 13
    //   1359: aload 13
    //   1361: ifnonnull +395 -> 1756
    //   1364: ldc 195
    //   1366: ldc_w 403
    //   1369: iconst_1
    //   1370: anewarray 199	java/lang/Object
    //   1373: dup
    //   1374: iconst_0
    //   1375: aload 11
    //   1377: getfield 397	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1380: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1383: aastore
    //   1384: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1387: invokestatic 411	com/tencent/mm/compatible/util/f:getLine	()I
    //   1390: istore 4
    //   1392: ldc 138
    //   1394: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1397: iconst_0
    //   1398: iload 4
    //   1400: isub
    //   1401: ireturn
    //   1402: invokestatic 320	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1405: invokestatic 414	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   1408: ifeq +37 -> 1445
    //   1411: ldc_w 328
    //   1414: invokestatic 334	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1417: checkcast 328	com/tencent/mm/plugin/zero/b/a
    //   1420: invokeinterface 338 1 0
    //   1425: ldc_w 416
    //   1428: invokevirtual 345	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1431: bipush 50
    //   1433: invokestatic 349	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1436: istore 5
    //   1438: iload 5
    //   1440: istore 4
    //   1442: goto -442 -> 1000
    //   1445: invokestatic 320	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1448: invokestatic 419	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   1451: ifeq +37 -> 1488
    //   1454: ldc_w 328
    //   1457: invokestatic 334	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1460: checkcast 328	com/tencent/mm/plugin/zero/b/a
    //   1463: invokeinterface 338 1 0
    //   1468: ldc_w 421
    //   1471: invokevirtual 345	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1474: bipush 50
    //   1476: invokestatic 349	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1479: istore 5
    //   1481: iload 5
    //   1483: istore 4
    //   1485: goto -485 -> 1000
    //   1488: ldc_w 328
    //   1491: invokestatic 334	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1494: checkcast 328	com/tencent/mm/plugin/zero/b/a
    //   1497: invokeinterface 338 1 0
    //   1502: ldc_w 423
    //   1505: invokevirtual 345	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1508: bipush 50
    //   1510: invokestatic 349	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1513: istore 5
    //   1515: iload 5
    //   1517: istore 4
    //   1519: goto -519 -> 1000
    //   1522: iload 6
    //   1524: istore 5
    //   1526: invokestatic 320	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1529: invokestatic 414	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   1532: ifeq +32 -> 1564
    //   1535: iload 6
    //   1537: istore 5
    //   1539: ldc_w 328
    //   1542: invokestatic 334	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1545: checkcast 328	com/tencent/mm/plugin/zero/b/a
    //   1548: invokeinterface 338 1 0
    //   1553: ldc_w 425
    //   1556: invokevirtual 345	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1559: astore 11
    //   1561: goto -516 -> 1045
    //   1564: iload 6
    //   1566: istore 5
    //   1568: invokestatic 320	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1571: invokestatic 419	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   1574: ifeq +32 -> 1606
    //   1577: iload 6
    //   1579: istore 5
    //   1581: ldc_w 328
    //   1584: invokestatic 334	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1587: checkcast 328	com/tencent/mm/plugin/zero/b/a
    //   1590: invokeinterface 338 1 0
    //   1595: ldc_w 427
    //   1598: invokevirtual 345	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1601: astore 11
    //   1603: goto -558 -> 1045
    //   1606: iload 6
    //   1608: istore 5
    //   1610: ldc_w 328
    //   1613: invokestatic 334	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   1616: checkcast 328	com/tencent/mm/plugin/zero/b/a
    //   1619: invokeinterface 338 1 0
    //   1624: ldc_w 429
    //   1627: invokevirtual 345	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1630: astore 11
    //   1632: goto -587 -> 1045
    //   1635: astore 11
    //   1637: sipush 1080
    //   1640: istore 6
    //   1642: goto -524 -> 1118
    //   1645: iload 6
    //   1647: sipush 2160
    //   1650: if_icmplt +14 -> 1664
    //   1653: iconst_0
    //   1654: istore 6
    //   1656: sipush 1080
    //   1659: istore 5
    //   1661: goto -525 -> 1136
    //   1664: iload 6
    //   1666: ifgt +496 -> 2162
    //   1669: iload 5
    //   1671: sipush 3240
    //   1674: if_icmple +488 -> 2162
    //   1677: sipush 1620
    //   1680: istore 6
    //   1682: iconst_0
    //   1683: istore 5
    //   1685: goto -549 -> 1136
    //   1688: aload 17
    //   1690: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   1693: istore 7
    //   1695: goto -539 -> 1156
    //   1698: aload 17
    //   1700: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   1703: istore 8
    //   1705: goto -529 -> 1176
    //   1708: iload 7
    //   1710: iload 6
    //   1712: idiv
    //   1713: istore 8
    //   1715: aload 17
    //   1717: getfield 161	android/graphics/BitmapFactory$Options:outHeight	I
    //   1720: iload 6
    //   1722: imul
    //   1723: iload 7
    //   1725: idiv
    //   1726: istore 5
    //   1728: iload 6
    //   1730: aload 17
    //   1732: getfield 164	android/graphics/BitmapFactory$Options:outWidth	I
    //   1735: imul
    //   1736: iload 7
    //   1738: idiv
    //   1739: istore 7
    //   1741: iload 5
    //   1743: istore 6
    //   1745: iload 7
    //   1747: istore 5
    //   1749: iload 8
    //   1751: istore 7
    //   1753: goto -481 -> 1272
    //   1756: ldc 195
    //   1758: ldc_w 431
    //   1761: iconst_2
    //   1762: anewarray 199	java/lang/Object
    //   1765: dup
    //   1766: iconst_0
    //   1767: aload 13
    //   1769: invokevirtual 436	android/graphics/Bitmap:getWidth	()I
    //   1772: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1775: aastore
    //   1776: dup
    //   1777: iconst_1
    //   1778: aload 13
    //   1780: invokevirtual 439	android/graphics/Bitmap:getHeight	()I
    //   1783: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1786: aastore
    //   1787: invokestatic 442	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1790: iload 7
    //   1792: iconst_1
    //   1793: if_icmple +79 -> 1872
    //   1796: aload 13
    //   1798: iload 8
    //   1800: iload 9
    //   1802: iconst_1
    //   1803: invokestatic 446	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   1806: astore 11
    //   1808: aload 13
    //   1810: aload 11
    //   1812: if_acmpeq +28 -> 1840
    //   1815: ldc 195
    //   1817: ldc_w 448
    //   1820: iconst_1
    //   1821: anewarray 199	java/lang/Object
    //   1824: dup
    //   1825: iconst_0
    //   1826: aload 13
    //   1828: invokevirtual 449	java/lang/Object:toString	()Ljava/lang/String;
    //   1831: aastore
    //   1832: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1835: aload 13
    //   1837: invokevirtual 452	android/graphics/Bitmap:recycle	()V
    //   1840: aload 11
    //   1842: astore 13
    //   1844: aload 11
    //   1846: ifnonnull +26 -> 1872
    //   1849: ldc 195
    //   1851: ldc_w 454
    //   1854: invokestatic 457	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1857: invokestatic 411	com/tencent/mm/compatible/util/f:getLine	()I
    //   1860: istore 4
    //   1862: ldc 138
    //   1864: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1867: iconst_0
    //   1868: iload 4
    //   1870: isub
    //   1871: ireturn
    //   1872: aconst_null
    //   1873: astore 12
    //   1875: aconst_null
    //   1876: astore 11
    //   1878: aload_1
    //   1879: iconst_0
    //   1880: invokestatic 461	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   1883: astore 14
    //   1885: aload 14
    //   1887: astore 11
    //   1889: aload 14
    //   1891: astore 12
    //   1893: aload 13
    //   1895: getstatic 467	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1898: iload 4
    //   1900: aload 14
    //   1902: invokevirtual 471	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   1905: pop
    //   1906: aload 14
    //   1908: ifnull +8 -> 1916
    //   1911: aload 14
    //   1913: invokevirtual 476	java/io/OutputStream:close	()V
    //   1916: ldc 195
    //   1918: ldc_w 478
    //   1921: iconst_3
    //   1922: anewarray 199	java/lang/Object
    //   1925: dup
    //   1926: iconst_0
    //   1927: aload 13
    //   1929: invokevirtual 449	java/lang/Object:toString	()Ljava/lang/String;
    //   1932: aastore
    //   1933: dup
    //   1934: iconst_1
    //   1935: aload_0
    //   1936: invokestatic 482	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   1939: invokestatic 487	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1942: aastore
    //   1943: dup
    //   1944: iconst_2
    //   1945: aload_1
    //   1946: invokestatic 482	com/tencent/mm/vfs/s:boW	(Ljava/lang/String;)J
    //   1949: invokestatic 487	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1952: aastore
    //   1953: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1956: aload 13
    //   1958: invokevirtual 452	android/graphics/Bitmap:recycle	()V
    //   1961: ldc 138
    //   1963: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1966: iconst_0
    //   1967: ireturn
    //   1968: astore_0
    //   1969: aload 11
    //   1971: astore 12
    //   1973: ldc 195
    //   1975: ldc_w 489
    //   1978: invokestatic 457	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1981: aload 11
    //   1983: astore 12
    //   1985: ldc 195
    //   1987: ldc_w 491
    //   1990: iconst_1
    //   1991: anewarray 199	java/lang/Object
    //   1994: dup
    //   1995: iconst_0
    //   1996: aload_0
    //   1997: invokestatic 495	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2000: aastore
    //   2001: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2004: aload 11
    //   2006: astore 12
    //   2008: ldc 195
    //   2010: ldc_w 448
    //   2013: iconst_1
    //   2014: anewarray 199	java/lang/Object
    //   2017: dup
    //   2018: iconst_0
    //   2019: aload 13
    //   2021: invokevirtual 449	java/lang/Object:toString	()Ljava/lang/String;
    //   2024: aastore
    //   2025: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2028: aload 11
    //   2030: astore 12
    //   2032: aload 13
    //   2034: invokevirtual 452	android/graphics/Bitmap:recycle	()V
    //   2037: aload 11
    //   2039: astore 12
    //   2041: invokestatic 411	com/tencent/mm/compatible/util/f:getLine	()I
    //   2044: istore 4
    //   2046: aload 11
    //   2048: ifnull +8 -> 2056
    //   2051: aload 11
    //   2053: invokevirtual 476	java/io/OutputStream:close	()V
    //   2056: ldc 138
    //   2058: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2061: iconst_0
    //   2062: iload 4
    //   2064: isub
    //   2065: ireturn
    //   2066: astore_0
    //   2067: aload 12
    //   2069: ifnull +8 -> 2077
    //   2072: aload 12
    //   2074: invokevirtual 476	java/io/OutputStream:close	()V
    //   2077: ldc 138
    //   2079: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2082: aload_0
    //   2083: athrow
    //   2084: astore 11
    //   2086: goto -170 -> 1916
    //   2089: astore_0
    //   2090: goto -34 -> 2056
    //   2093: astore_1
    //   2094: goto -17 -> 2077
    //   2097: astore 11
    //   2099: goto -1099 -> 1000
    //   2102: astore 11
    //   2104: aconst_null
    //   2105: astore_1
    //   2106: goto -1215 -> 891
    //   2109: astore 11
    //   2111: aload 13
    //   2113: astore 12
    //   2115: goto -1224 -> 891
    //   2118: astore 14
    //   2120: aload 16
    //   2122: astore 13
    //   2124: goto -1336 -> 788
    //   2127: astore 14
    //   2129: goto -1341 -> 788
    //   2132: astore_1
    //   2133: aconst_null
    //   2134: astore_0
    //   2135: goto -1620 -> 515
    //   2138: astore_1
    //   2139: aload 12
    //   2141: astore 11
    //   2143: goto -1628 -> 515
    //   2146: astore 12
    //   2148: goto -1683 -> 465
    //   2151: astore_1
    //   2152: aload 12
    //   2154: astore 13
    //   2156: aload_1
    //   2157: astore 12
    //   2159: goto -1694 -> 465
    //   2162: iload 5
    //   2164: istore 7
    //   2166: iload 6
    //   2168: istore 5
    //   2170: iload 7
    //   2172: istore 6
    //   2174: goto -1038 -> 1136
    //   2177: aconst_null
    //   2178: astore_0
    //   2179: aconst_null
    //   2180: astore 12
    //   2182: aload_1
    //   2183: astore 11
    //   2185: aload 12
    //   2187: astore_1
    //   2188: goto -1567 -> 621
    //   2191: aconst_null
    //   2192: astore 12
    //   2194: aload_1
    //   2195: astore 11
    //   2197: aload 12
    //   2199: astore_1
    //   2200: goto -1579 -> 621
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2203	0	paramString1	String
    //   0	2203	1	paramString2	String
    //   1304	13	2	d	double
    //   61	2004	4	i	int
    //   994	1175	5	j	int
    //   1004	1169	6	k	int
    //   1001	1170	7	m	int
    //   1057	742	8	n	int
    //   1274	527	9	i1	int
    //   67	211	10	bool	boolean
    //   18	1613	11	localObject1	Object
    //   1635	1	11	localException1	Exception
    //   1806	246	11	localObject2	Object
    //   2084	1	11	localIOException1	IOException
    //   2097	1	11	localException2	Exception
    //   2102	1	11	localObject3	Object
    //   2109	1	11	localObject4	Object
    //   2141	55	11	localObject5	Object
    //   344	1	12	localObject6	Object
    //   461	17	12	localException3	Exception
    //   482	20	12	localIOException2	IOException
    //   504	81	12	localObject7	Object
    //   599	1541	12	localObject8	Object
    //   2146	7	12	localException4	Exception
    //   2157	41	12	str	String
    //   352	517	13	localObject9	Object
    //   878	69	13	localObject10	Object
    //   1357	798	13	localObject11	Object
    //   556	122	14	localObject12	Object
    //   780	1	14	localException5	Exception
    //   854	1058	14	localObject13	Object
    //   2118	1	14	localException6	Exception
    //   2127	1	14	localException7	Exception
    //   355	486	15	localFile	java.io.File
    //   639	1482	16	localObject14	Object
    //   9	1722	17	localOptions	android.graphics.BitmapFactory.Options
    //   146	650	18	locala	a
    // Exception table:
    //   from	to	target	type
    //   138	207	224	java/io/IOException
    //   207	224	224	java/io/IOException
    //   294	327	224	java/io/IOException
    //   327	343	224	java/io/IOException
    //   357	379	224	java/io/IOException
    //   515	531	224	java/io/IOException
    //   621	630	224	java/io/IOException
    //   705	725	224	java/io/IOException
    //   891	913	224	java/io/IOException
    //   379	461	461	java/lang/Exception
    //   531	584	461	java/lang/Exception
    //   471	484	504	finally
    //   490	495	504	finally
    //   501	504	504	finally
    //   590	601	504	finally
    //   641	673	780	java/lang/Exception
    //   673	683	780	java/lang/Exception
    //   731	739	780	java/lang/Exception
    //   742	777	780	java/lang/Exception
    //   686	697	878	finally
    //   795	803	878	finally
    //   810	819	878	finally
    //   826	856	878	finally
    //   863	868	878	finally
    //   875	878	878	finally
    //   920	934	878	finally
    //   941	946	878	finally
    //   953	956	878	finally
    //   1010	1019	1635	java/lang/Exception
    //   1023	1045	1635	java/lang/Exception
    //   1049	1059	1635	java/lang/Exception
    //   1073	1089	1635	java/lang/Exception
    //   1093	1110	1635	java/lang/Exception
    //   1526	1535	1635	java/lang/Exception
    //   1539	1561	1635	java/lang/Exception
    //   1568	1577	1635	java/lang/Exception
    //   1581	1603	1635	java/lang/Exception
    //   1610	1632	1635	java/lang/Exception
    //   1878	1885	1968	java/lang/Exception
    //   1893	1906	1968	java/lang/Exception
    //   1878	1885	2066	finally
    //   1893	1906	2066	finally
    //   1973	1981	2066	finally
    //   1985	2004	2066	finally
    //   2008	2028	2066	finally
    //   2032	2037	2066	finally
    //   2041	2046	2066	finally
    //   1911	1916	2084	java/io/IOException
    //   2051	2056	2089	java/io/IOException
    //   2072	2077	2093	java/io/IOException
    //   960	996	2097	java/lang/Exception
    //   1402	1438	2097	java/lang/Exception
    //   1445	1481	2097	java/lang/Exception
    //   1488	1515	2097	java/lang/Exception
    //   641	673	2102	finally
    //   673	683	2102	finally
    //   731	739	2102	finally
    //   742	777	2102	finally
    //   697	705	2109	finally
    //   686	697	2118	java/lang/Exception
    //   697	705	2127	java/lang/Exception
    //   379	461	2132	finally
    //   531	584	2132	finally
    //   601	608	2138	finally
    //   590	601	2146	java/lang/Exception
    //   601	608	2151	java/lang/Exception
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(150309);
    super.cancel();
    AppMethodBeat.o(150309);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(150306);
    this.callback = parami;
    if ((this.dRr == null) || (this.dRr.length() == 0))
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
      AppMethodBeat.o(150306);
      return -1;
    }
    if (!com.tencent.mm.vfs.s.YS(this.dRr))
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.dRr);
      AppMethodBeat.o(150306);
      return -1;
    }
    if (this.iKP == 0) {
      this.iKP = ((int)com.tencent.mm.vfs.s.boW(this.dRr));
    }
    int i = Math.min(this.iKP - this.bNu, 8192);
    Object localObject = com.tencent.mm.vfs.s.aW(this.dRr, this.bNu, i);
    if (localObject == null)
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
      AppMethodBeat.o(150306);
      return -1;
    }
    Log.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(localObject.length), Integer.valueOf(this.iKP) });
    parami = new d.a();
    parami.iLN = new enk();
    parami.iLO = new enl();
    parami.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
    parami.funcId = 157;
    parami.iLP = 46;
    parami.respCmdId = 1000000046;
    parami = parami.aXF();
    enk localenk = (enk)parami.iLK.iLR;
    localenk.BsF = this.iKP;
    localenk.BsG = this.bNu;
    localenk.LWp = this.iKQ;
    localenk.BsI = new SKBuiltinBuffer_t().setBuffer((byte[])localObject);
    localenk.Nll = this.iLg;
    localenk.UserName = this.username;
    try
    {
      localObject = new ewf();
      ((ewf)localObject).NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exJ());
      localenk.KLQ = new SKBuiltinBuffer_t().setBuffer(((ewf)localObject).toByteArray());
      label374:
      i = dispatch(paramg, parami, this);
      AppMethodBeat.o(150306);
      return i;
    }
    catch (Throwable localThrowable)
    {
      break label374;
    }
  }
  
  public final int getType()
  {
    return 157;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150308);
    paramArrayOfByte = (enl)((com.tencent.mm.ak.d)params).iLL.iLR;
    Log.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 4) && (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150308);
      return;
    }
    if ((paramInt2 == 4) || (paramInt2 == 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(150308);
      return;
    }
    paramInt1 = params.getRespObj().getRetCode();
    if (paramInt1 == -4) {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", new Object[] { Integer.valueOf(paramInt1) });
    }
    for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150308);
      return;
    }
    this.bNu = paramArrayOfByte.BsG;
    if (this.bNu < this.iKP)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        Log.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
        this.callback.onSceneEnd(3, -1, "", this);
      }
      Log.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
      AppMethodBeat.o(150308);
      return;
    }
    try
    {
      com.tencent.mm.vfs.s.nx(this.dRr, this.iLf);
      com.tencent.mm.kernel.g.aAh().azQ().set(12297, paramArrayOfByte.Nlm);
      p.aYn().e(this.username, BitmapUtil.getBitmapNative(this.iLf));
      params = z.aTY();
      if (!Util.isNullOrNil(params))
      {
        paramArrayOfByte = new i();
        paramArrayOfByte.username = params;
        paramArrayOfByte.fv(true);
        paramArrayOfByte.cSx = 32;
        paramArrayOfByte.fuz = 3;
        paramArrayOfByte.cSx = 34;
        p.aYB().b(paramArrayOfByte);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(150308);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + paramString.getMessage());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(150308);
    }
  }
  
  public final int securityLimitCount()
  {
    return 200;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(150307);
    if ((this.dRr == null) || (this.dRr.length() == 0))
    {
      params = q.b.iMr;
      AppMethodBeat.o(150307);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(150307);
    return params;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.m
 * JD-Core Version:    0.7.0.1
 */