package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;
import junit.framework.Assert;

public final class t
{
  private static AtomicLong ixn;
  public h hKK;
  l<a, t.a.a> hPq;
  
  static
  {
    AppMethodBeat.i(217494);
    ixn = new AtomicLong(1L);
    AppMethodBeat.o(217494);
  }
  
  public t(h paramh)
  {
    AppMethodBeat.i(126967);
    this.hPq = new l() {};
    this.hKK = paramh;
    AppMethodBeat.o(126967);
  }
  
  private static String BX(String paramString)
  {
    AppMethodBeat.i(217485);
    paramString = "select " + paramString + ".filename," + paramString + ".clientid," + paramString + ".msgsvrid," + paramString + ".netoffset," + paramString + ".filenowsize," + paramString + ".totallen," + paramString + ".thumbnetoffset," + paramString + ".thumblen," + paramString + ".status," + paramString + ".createtime," + paramString + ".lastmodifytime," + paramString + ".downloadtime," + paramString + ".videolength," + paramString + ".msglocalid," + paramString + ".nettimes," + paramString + ".cameratype," + paramString + ".user," + paramString + ".human," + paramString + ".reserved1," + paramString + ".reserved2," + paramString + ".reserved3," + paramString + ".reserved4," + paramString + ".videofuncflag," + paramString + ".masssendid," + paramString + ".masssendlist," + paramString + ".videomd5," + paramString + ".streamvideo," + paramString + ".statextstr," + paramString + ".downloadscene," + paramString + ".mmsightextinfo," + paramString + ".preloadsize," + paramString + ".videoformat," + paramString + ".forward_msg_local_id," + paramString + ".msg_uuid from " + paramString + "  ";
    AppMethodBeat.o(217485);
    return paramString;
  }
  
  private static String HC(String paramString)
  {
    AppMethodBeat.i(217486);
    paramString = "select " + paramString + ".filename,downloadtime from " + paramString + "  ";
    AppMethodBeat.o(217486);
    return paramString;
  }
  
  private List<String> HE(String paramString)
  {
    Cursor localCursor = null;
    AppMethodBeat.i(217487);
    paramString = HC(paramString);
    String str = paramString + " WHERE status=112 ORDER BY downloadtime DESC " + " LIMIT 10";
    LinkedList localLinkedList = new LinkedList();
    paramString = localCursor;
    try
    {
      localCursor = this.hKK.a(str, null, 2);
      paramString = localCursor;
      if (localCursor.moveToFirst())
      {
        boolean bool;
        do
        {
          paramString = localCursor;
          localLinkedList.add(localCursor.getString(0));
          paramString = localCursor;
          bool = localCursor.moveToNext();
        } while (bool);
      }
      return localLinkedList;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(217487);
    }
  }
  
  private List<String> HF(String paramString)
  {
    Cursor localCursor = null;
    AppMethodBeat.i(217488);
    Object localObject2 = " SELECT * FROM ( " + HC(paramString) + " WHERE status=122" + " LIMIT 10 )";
    localObject2 = (String)localObject2 + " UNION SELECT * FROM ( ";
    paramString = (String)localObject2 + HC(paramString) + " WHERE status=120" + " LIMIT 10 )";
    String str = paramString + " ORDER BY downloadtime DESC";
    localObject2 = new LinkedList();
    paramString = localCursor;
    try
    {
      localCursor = this.hKK.a(str, null, 2);
      paramString = localCursor;
      if (localCursor.moveToFirst())
      {
        boolean bool;
        do
        {
          paramString = localCursor;
          ((List)localObject2).add(localCursor.getString(0));
          paramString = localCursor;
          bool = localCursor.moveToNext();
        } while (bool);
      }
      return localObject2;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(217488);
    }
  }
  
  @Deprecated
  public static String HH(String paramString)
  {
    AppMethodBeat.i(217491);
    paramString = HI(paramString);
    AppMethodBeat.o(217491);
    return paramString;
  }
  
  public static String HI(String paramString)
  {
    AppMethodBeat.i(126978);
    StringBuilder localStringBuilder = new StringBuilder();
    long l = System.currentTimeMillis();
    localStringBuilder.append(new SimpleDateFormat("yyMMddHHmmss", Locale.ENGLISH).format(new Date(l)));
    String str = String.valueOf(l);
    localStringBuilder.append(str.substring(str.length() - 3));
    localStringBuilder.append(ixn.getAndIncrement());
    if (paramString != null)
    {
      int i = paramString.lastIndexOf("@");
      if (i >= 0) {
        localStringBuilder.append(paramString.substring(i + 1));
      }
    }
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(126978);
    return paramString;
  }
  
  public static String HJ(String paramString)
  {
    AppMethodBeat.i(126980);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126980);
      return null;
    }
    paramString = getVideoPath() + paramString;
    if (o.fB(paramString))
    {
      AppMethodBeat.o(126980);
      return paramString;
    }
    paramString = paramString + ".mp4";
    AppMethodBeat.o(126980);
    return paramString;
  }
  
  public static String HK(String paramString)
  {
    AppMethodBeat.i(126981);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126981);
      return null;
    }
    paramString = getVideoPath() + paramString + ".jpg";
    AppMethodBeat.o(126981);
    return paramString;
  }
  
  public static int HL(String paramString)
  {
    AppMethodBeat.i(126984);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126984);
      return -1;
    }
    paramString = new k(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(126984);
      return 0;
    }
    int i = (int)paramString.length();
    if (i <= 0)
    {
      AppMethodBeat.o(126984);
      return 0;
    }
    AppMethodBeat.o(126984);
    return i;
  }
  
  /* Error */
  static int[] HM(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc_w 307
    //   5: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: bipush 33
    //   10: newarray int
    //   12: astore 10
    //   14: invokestatic 310	com/tencent/mm/sdk/platformtools/bu:fpO	()J
    //   17: lstore 4
    //   19: aload_0
    //   20: invokestatic 314	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   23: l2i
    //   24: istore_2
    //   25: iload_2
    //   26: ldc_w 315
    //   29: if_icmplt +10 -> 39
    //   32: iload_2
    //   33: ldc_w 316
    //   36: if_icmplt +83 -> 119
    //   39: ldc_w 318
    //   42: ldc_w 320
    //   45: iconst_2
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload_2
    //   52: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_0
    //   59: aastore
    //   60: invokestatic 331	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: getstatic 337	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   66: astore_0
    //   67: iload_2
    //   68: ldc_w 315
    //   71: if_icmpge +42 -> 113
    //   74: bipush 10
    //   76: istore_1
    //   77: aload_0
    //   78: sipush 12696
    //   81: iconst_2
    //   82: anewarray 4	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: iload_1
    //   88: bipush 101
    //   90: iadd
    //   91: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: iload_2
    //   98: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: aastore
    //   102: invokevirtual 341	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   105: ldc_w 307
    //   108: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aconst_null
    //   112: areturn
    //   113: bipush 20
    //   115: istore_1
    //   116: goto -39 -> 77
    //   119: aload 10
    //   121: bipush 32
    //   123: iload_2
    //   124: iastore
    //   125: iload_2
    //   126: sipush 20480
    //   129: isub
    //   130: bipush 32
    //   132: idiv
    //   133: istore_3
    //   134: sipush 512
    //   137: newarray byte
    //   139: astore 11
    //   141: aload_0
    //   142: iconst_0
    //   143: invokestatic 345	com/tencent/mm/vfs/o:dg	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   146: astore 9
    //   148: iload_1
    //   149: bipush 32
    //   151: if_icmpge +66 -> 217
    //   154: iload_1
    //   155: iload_3
    //   156: imul
    //   157: sipush 10240
    //   160: iadd
    //   161: i2l
    //   162: lstore 6
    //   164: aload 9
    //   166: astore 8
    //   168: aload 9
    //   170: lload 6
    //   172: invokevirtual 350	java/io/RandomAccessFile:seek	(J)V
    //   175: aload 9
    //   177: astore 8
    //   179: aload 9
    //   181: aload 11
    //   183: invokevirtual 354	java/io/RandomAccessFile:readFully	([B)V
    //   186: aload 9
    //   188: astore 8
    //   190: aload 10
    //   192: iload_1
    //   193: aload 11
    //   195: sipush 512
    //   198: invokestatic 360	com/tencent/mm/b/i:s	([BI)I
    //   201: ldc_w 361
    //   204: irem
    //   205: ldc_w 361
    //   208: ior
    //   209: iastore
    //   210: iload_1
    //   211: iconst_1
    //   212: iadd
    //   213: istore_1
    //   214: goto -66 -> 148
    //   217: aload 9
    //   219: astore 8
    //   221: aload 9
    //   223: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   226: aload 9
    //   228: astore 8
    //   230: ldc_w 318
    //   233: ldc_w 364
    //   236: iconst_3
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: lload 4
    //   244: invokestatic 368	com/tencent/mm/sdk/platformtools/bu:DD	(J)J
    //   247: invokestatic 373	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   250: aastore
    //   251: dup
    //   252: iconst_1
    //   253: iload_2
    //   254: invokestatic 325	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: iconst_2
    //   260: aload_0
    //   261: aastore
    //   262: invokestatic 375	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload 9
    //   267: ifnull +8 -> 275
    //   270: aload 9
    //   272: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   275: ldc_w 307
    //   278: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: aload 10
    //   283: areturn
    //   284: astore 10
    //   286: aconst_null
    //   287: astore 9
    //   289: aload 9
    //   291: astore 8
    //   293: ldc_w 318
    //   296: ldc_w 377
    //   299: iconst_2
    //   300: anewarray 4	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: aload_0
    //   306: aastore
    //   307: dup
    //   308: iconst_1
    //   309: aload 10
    //   311: invokestatic 380	com/tencent/mm/sdk/platformtools/bu:o	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   314: aastore
    //   315: invokestatic 331	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: aload 9
    //   320: ifnull +8 -> 328
    //   323: aload 9
    //   325: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   328: ldc_w 307
    //   331: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   334: aconst_null
    //   335: areturn
    //   336: astore_0
    //   337: aconst_null
    //   338: astore 8
    //   340: aload 8
    //   342: ifnull +8 -> 350
    //   345: aload 8
    //   347: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   350: ldc_w 307
    //   353: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: aload_0
    //   357: athrow
    //   358: astore_0
    //   359: goto -84 -> 275
    //   362: astore_0
    //   363: goto -35 -> 328
    //   366: astore 8
    //   368: goto -18 -> 350
    //   371: astore_0
    //   372: goto -32 -> 340
    //   375: astore 10
    //   377: goto -88 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramString	String
    //   1	213	1	i	int
    //   24	230	2	j	int
    //   133	24	3	k	int
    //   17	226	4	l1	long
    //   162	9	6	l2	long
    //   166	180	8	localRandomAccessFile1	java.io.RandomAccessFile
    //   366	1	8	localException1	Exception
    //   146	178	9	localRandomAccessFile2	java.io.RandomAccessFile
    //   12	270	10	arrayOfInt	int[]
    //   284	26	10	localException2	Exception
    //   375	1	10	localException3	Exception
    //   139	55	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   141	148	284	java/lang/Exception
    //   141	148	336	finally
    //   270	275	358	java/lang/Exception
    //   323	328	362	java/lang/Exception
    //   345	350	366	java/lang/Exception
    //   168	175	371	finally
    //   179	186	371	finally
    //   190	210	371	finally
    //   221	226	371	finally
    //   230	265	371	finally
    //   293	318	371	finally
    //   168	175	375	java/lang/Exception
    //   179	186	375	java/lang/Exception
    //   190	210	375	java/lang/Exception
    //   221	226	375	java/lang/Exception
    //   230	265	375	java/lang/Exception
  }
  
  /* Error */
  public static int a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 485
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 278	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +48 -> 58
    //   13: ldc_w 318
    //   16: new 68	java/lang/StringBuilder
    //   19: dup
    //   20: ldc_w 487
    //   23: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   29: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc_w 494
    //   35: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 497	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokestatic 500	com/tencent/mm/compatible/util/f:getLine	()I
    //   47: istore_1
    //   48: ldc_w 485
    //   51: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: iconst_0
    //   55: iload_1
    //   56: isub
    //   57: ireturn
    //   58: iload_1
    //   59: ifge +62 -> 121
    //   62: ldc_w 318
    //   65: new 68	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 487
    //   72: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   78: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc_w 502
    //   84: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 504
    //   94: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload_1
    //   98: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 497	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: invokestatic 500	com/tencent/mm/compatible/util/f:getLine	()I
    //   110: istore_1
    //   111: ldc_w 485
    //   114: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_0
    //   118: iload_1
    //   119: isub
    //   120: ireturn
    //   121: aload_2
    //   122: invokestatic 511	com/tencent/mm/sdk/platformtools/bu:cF	([B)Z
    //   125: ifeq +58 -> 183
    //   128: ldc_w 318
    //   131: new 68	java/lang/StringBuilder
    //   134: dup
    //   135: ldc_w 487
    //   138: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   144: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 502
    //   150: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc_w 513
    //   160: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 497	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: invokestatic 500	com/tencent/mm/compatible/util/f:getLine	()I
    //   172: istore_1
    //   173: ldc_w 485
    //   176: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: iconst_0
    //   180: iload_1
    //   181: isub
    //   182: ireturn
    //   183: new 515	com/tencent/mm/compatible/util/f$a
    //   186: dup
    //   187: invokespecial 516	com/tencent/mm/compatible/util/f$a:<init>	()V
    //   190: astore 15
    //   192: aconst_null
    //   193: astore 13
    //   195: aconst_null
    //   196: astore 12
    //   198: aload_0
    //   199: iconst_1
    //   200: invokestatic 345	com/tencent/mm/vfs/o:dg	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   203: astore 14
    //   205: aload 14
    //   207: astore 12
    //   209: aload 14
    //   211: astore 13
    //   213: aload 15
    //   215: invokevirtual 519	com/tencent/mm/compatible/util/f$a:abs	()J
    //   218: lstore 4
    //   220: aload 14
    //   222: astore 12
    //   224: aload 14
    //   226: astore 13
    //   228: aload 14
    //   230: iload_1
    //   231: i2l
    //   232: invokevirtual 350	java/io/RandomAccessFile:seek	(J)V
    //   235: aload 14
    //   237: astore 12
    //   239: aload 14
    //   241: astore 13
    //   243: aload 15
    //   245: invokevirtual 519	com/tencent/mm/compatible/util/f$a:abs	()J
    //   248: lstore 6
    //   250: aload 14
    //   252: astore 12
    //   254: aload 14
    //   256: astore 13
    //   258: aload 14
    //   260: aload_2
    //   261: iconst_0
    //   262: aload_2
    //   263: arraylength
    //   264: invokevirtual 523	java/io/RandomAccessFile:write	([BII)V
    //   267: aload 14
    //   269: astore 12
    //   271: aload 14
    //   273: astore 13
    //   275: aload 15
    //   277: invokevirtual 519	com/tencent/mm/compatible/util/f$a:abs	()J
    //   280: lstore 8
    //   282: aload 14
    //   284: astore 12
    //   286: aload 14
    //   288: astore 13
    //   290: aload 14
    //   292: invokevirtual 526	java/io/RandomAccessFile:getFilePointer	()J
    //   295: l2i
    //   296: istore_3
    //   297: aload 14
    //   299: astore 12
    //   301: aload 14
    //   303: astore 13
    //   305: aload 15
    //   307: invokevirtual 519	com/tencent/mm/compatible/util/f$a:abs	()J
    //   310: lstore 10
    //   312: aload 14
    //   314: ifnull +8 -> 322
    //   317: aload 14
    //   319: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   322: ldc_w 318
    //   325: new 68	java/lang/StringBuilder
    //   328: dup
    //   329: ldc_w 528
    //   332: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   335: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   338: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc_w 502
    //   344: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_0
    //   348: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: ldc_w 530
    //   354: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: iload_1
    //   358: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   361: ldc_w 532
    //   364: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_2
    //   368: arraylength
    //   369: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 534	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: ldc_w 318
    //   381: new 68	java/lang/StringBuilder
    //   384: dup
    //   385: ldc_w 528
    //   388: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   391: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   394: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 502
    //   400: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc_w 536
    //   410: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: lload 4
    //   415: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   418: ldc_w 538
    //   421: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: lload 6
    //   426: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   429: ldc_w 540
    //   432: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: lload 8
    //   437: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   440: ldc_w 542
    //   443: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: lload 10
    //   448: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   451: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 534	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   457: ldc_w 485
    //   460: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   463: iload_3
    //   464: ireturn
    //   465: astore_2
    //   466: aload 12
    //   468: astore 13
    //   470: ldc_w 318
    //   473: new 68	java/lang/StringBuilder
    //   476: dup
    //   477: ldc_w 487
    //   480: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   483: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   486: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: ldc_w 502
    //   492: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_0
    //   496: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc_w 544
    //   502: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: iload_1
    //   506: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: ldc_w 546
    //   512: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload_2
    //   516: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   519: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: ldc_w 551
    //   525: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 497	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: aload 12
    //   536: astore 13
    //   538: invokestatic 500	com/tencent/mm/compatible/util/f:getLine	()I
    //   541: istore_1
    //   542: aload 12
    //   544: ifnull +8 -> 552
    //   547: aload 12
    //   549: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   552: ldc_w 485
    //   555: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   558: iconst_0
    //   559: iload_1
    //   560: isub
    //   561: ireturn
    //   562: astore_0
    //   563: aload 13
    //   565: ifnull +8 -> 573
    //   568: aload 13
    //   570: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   573: ldc_w 485
    //   576: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   579: aload_0
    //   580: athrow
    //   581: astore 12
    //   583: goto -261 -> 322
    //   586: astore_0
    //   587: goto -35 -> 552
    //   590: astore_2
    //   591: goto -18 -> 573
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	paramString	String
    //   0	594	1	paramInt	int
    //   0	594	2	paramArrayOfByte	byte[]
    //   296	168	3	i	int
    //   218	196	4	l1	long
    //   248	177	6	l2	long
    //   280	156	8	l3	long
    //   310	137	10	l4	long
    //   196	352	12	localObject1	Object
    //   581	1	12	localException	Exception
    //   193	376	13	localObject2	Object
    //   203	115	14	localRandomAccessFile	java.io.RandomAccessFile
    //   190	116	15	locala	com.tencent.mm.compatible.util.f.a
    // Exception table:
    //   from	to	target	type
    //   198	205	465	java/lang/Exception
    //   213	220	465	java/lang/Exception
    //   228	235	465	java/lang/Exception
    //   243	250	465	java/lang/Exception
    //   258	267	465	java/lang/Exception
    //   275	282	465	java/lang/Exception
    //   290	297	465	java/lang/Exception
    //   305	312	465	java/lang/Exception
    //   198	205	562	finally
    //   213	220	562	finally
    //   228	235	562	finally
    //   243	250	562	finally
    //   258	267	562	finally
    //   275	282	562	finally
    //   290	297	562	finally
    //   305	312	562	finally
    //   470	534	562	finally
    //   538	542	562	finally
    //   317	322	581	java/lang/Exception
    //   547	552	586	java/lang/Exception
    //   568	573	590	java/lang/Exception
  }
  
  private List<s> b(String paramString, int paramInt, long paramLong)
  {
    localObject1 = null;
    Cursor localCursor = null;
    AppMethodBeat.i(217489);
    Object localObject2 = BX(paramString) + " where status=" + paramInt + " AND preloadsize > 0 AND lastmodifytime <= " + paramLong + " ORDER BY createtime LIMIT 1";
    LinkedList localLinkedList = new LinkedList();
    paramString = localCursor;
    try
    {
      localCursor = this.hKK.a((String)localObject2, null, 2);
      paramString = localCursor;
      localObject1 = localCursor;
      if (localCursor.moveToFirst())
      {
        boolean bool;
        do
        {
          paramString = localCursor;
          localObject1 = localCursor;
          localObject2 = new s();
          paramString = localCursor;
          localObject1 = localCursor;
          ((s)localObject2).convertFrom(localCursor);
          paramString = localCursor;
          localObject1 = localCursor;
          localLinkedList.add(localObject2);
          paramString = localCursor;
          localObject1 = localCursor;
          bool = localCursor.moveToNext();
        } while (bool);
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = paramString;
        ae.printErrStackTrace("MicroMsg.VideoInfoStorage", localException, "getNeedDeletePreloadVideo error", new Object[0]);
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (localObject1 == null) {
        break label234;
      }
      ((Cursor)localObject1).close();
      AppMethodBeat.o(217489);
    }
    AppMethodBeat.o(217489);
    return localLinkedList;
  }
  
  private boolean by(String paramString1, String paramString2)
  {
    AppMethodBeat.i(126987);
    ae.i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", new Object[] { paramString1, paramString2, bu.fpN() });
    long l1 = bu.fpO();
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      ae.e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(126987);
      return false;
    }
    Object localObject = HM(paramString1);
    if ((localObject == null) || (localObject.length < 33))
    {
      ae.e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", new Object[] { paramString1 });
      AppMethodBeat.o(126987);
      return false;
    }
    int j = localObject[32];
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 32)
    {
      localStringBuffer.append(Integer.toHexString(localObject[i]));
      i += 1;
    }
    localObject = this.hKK.a("select cdnxml from VideoHash where size = " + j + " and hash = \"" + localStringBuffer.toString() + "\"", null, 2);
    Vector localVector = new Vector();
    while (((Cursor)localObject).moveToNext())
    {
      localVector.add(((Cursor)localObject).getString(0));
      ae.v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", new Object[] { Integer.valueOf(localVector.size()), localVector.get(localVector.size() - 1) });
    }
    ((Cursor)localObject).close();
    if ((localVector.size() == 1) && (paramString2.equals(localVector.get(0))))
    {
      ae.w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", new Object[] { Long.valueOf(bu.DD(l1)), paramString1, paramString2 });
      AppMethodBeat.o(126987);
      return true;
    }
    if (localVector.size() > 0)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(12696, new Object[] { Integer.valueOf(102), Integer.valueOf(j), "", "", Integer.valueOf(localVector.size()) });
      ae.e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", new Object[] { Integer.valueOf(localVector.size()), Integer.valueOf(j) });
      this.hKK.execSQL("VideoHash", "delete from VideoHash where size = " + j + " and hash = \"" + localStringBuffer.toString() + "\"");
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("size", Integer.valueOf(j));
    ((ContentValues)localObject).put("CreateTime", Long.valueOf(bu.aRi()));
    ((ContentValues)localObject).put("hash", localStringBuffer.toString());
    ((ContentValues)localObject).put("cdnxml", paramString2);
    ((ContentValues)localObject).put("orgpath", paramString1);
    long l2 = this.hKK.a("VideoHash", "", (ContentValues)localObject);
    ae.i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", new Object[] { Long.valueOf(bu.DD(l1)), Long.valueOf(l2), paramString1, localStringBuffer, paramString2 });
    if (l2 < 0L)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(12696, new Object[] { Integer.valueOf(103), Integer.valueOf(j) });
      ae.e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", new Object[] { Long.valueOf(l2), paramString1 });
    }
    AppMethodBeat.o(126987);
    return true;
  }
  
  private static String getVideoPath()
  {
    AppMethodBeat.i(126979);
    String str = com.tencent.mm.kernel.g.ajR().gDT + "video/";
    AppMethodBeat.o(126979);
    return str;
  }
  
  /* Error */
  public static b t(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 690
    //   5: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 19	com/tencent/mm/modelvideo/t$b
    //   11: dup
    //   12: invokespecial 691	com/tencent/mm/modelvideo/t$b:<init>	()V
    //   15: astore 16
    //   17: aload_0
    //   18: invokestatic 278	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   21: ifeq +53 -> 74
    //   24: ldc_w 318
    //   27: new 68	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 487
    //   34: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   40: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 494
    //   46: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 497	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: aload 16
    //   57: iconst_0
    //   58: invokestatic 500	com/tencent/mm/compatible/util/f:getLine	()I
    //   61: isub
    //   62: putfield 695	com/tencent/mm/modelvideo/t$b:ret	I
    //   65: ldc_w 690
    //   68: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload 16
    //   73: areturn
    //   74: iload_1
    //   75: ifge +67 -> 142
    //   78: ldc_w 318
    //   81: new 68	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 487
    //   88: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   94: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 502
    //   100: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 697
    //   110: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: iload_1
    //   114: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 497	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload 16
    //   125: iconst_0
    //   126: invokestatic 500	com/tencent/mm/compatible/util/f:getLine	()I
    //   129: isub
    //   130: putfield 695	com/tencent/mm/modelvideo/t$b:ret	I
    //   133: ldc_w 690
    //   136: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload 16
    //   141: areturn
    //   142: iload_2
    //   143: ifgt +63 -> 206
    //   146: ldc_w 318
    //   149: new 68	java/lang/StringBuilder
    //   152: dup
    //   153: ldc_w 487
    //   156: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   162: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 502
    //   168: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc_w 699
    //   178: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 497	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload 16
    //   189: iconst_0
    //   190: invokestatic 500	com/tencent/mm/compatible/util/f:getLine	()I
    //   193: isub
    //   194: putfield 695	com/tencent/mm/modelvideo/t$b:ret	I
    //   197: ldc_w 690
    //   200: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload 16
    //   205: areturn
    //   206: new 515	com/tencent/mm/compatible/util/f$a
    //   209: dup
    //   210: invokespecial 516	com/tencent/mm/compatible/util/f$a:<init>	()V
    //   213: astore 17
    //   215: aconst_null
    //   216: astore 14
    //   218: aconst_null
    //   219: astore 13
    //   221: aload 16
    //   223: iload_2
    //   224: newarray byte
    //   226: putfield 703	com/tencent/mm/modelvideo/t$b:buf	[B
    //   229: aload_0
    //   230: iconst_0
    //   231: invokestatic 345	com/tencent/mm/vfs/o:dg	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   234: astore 15
    //   236: aload 15
    //   238: astore 13
    //   240: aload 15
    //   242: astore 14
    //   244: aload 17
    //   246: invokevirtual 519	com/tencent/mm/compatible/util/f$a:abs	()J
    //   249: lstore 5
    //   251: aload 15
    //   253: astore 13
    //   255: aload 15
    //   257: astore 14
    //   259: aload 15
    //   261: iload_1
    //   262: i2l
    //   263: invokevirtual 350	java/io/RandomAccessFile:seek	(J)V
    //   266: aload 15
    //   268: astore 13
    //   270: aload 15
    //   272: astore 14
    //   274: aload 17
    //   276: invokevirtual 519	com/tencent/mm/compatible/util/f$a:abs	()J
    //   279: lstore 7
    //   281: aload 15
    //   283: astore 13
    //   285: aload 15
    //   287: astore 14
    //   289: aload 15
    //   291: aload 16
    //   293: getfield 703	com/tencent/mm/modelvideo/t$b:buf	[B
    //   296: iconst_0
    //   297: iload_2
    //   298: invokevirtual 707	java/io/RandomAccessFile:read	([BII)I
    //   301: istore 4
    //   303: aload 15
    //   305: astore 13
    //   307: aload 15
    //   309: astore 14
    //   311: aload 17
    //   313: invokevirtual 519	com/tencent/mm/compatible/util/f$a:abs	()J
    //   316: lstore 9
    //   318: aload 15
    //   320: astore 13
    //   322: aload 15
    //   324: astore 14
    //   326: aload 17
    //   328: invokevirtual 519	com/tencent/mm/compatible/util/f$a:abs	()J
    //   331: lstore 11
    //   333: iload 4
    //   335: ifge +327 -> 662
    //   338: aload 15
    //   340: astore 13
    //   342: aload 15
    //   344: astore 14
    //   346: aload 16
    //   348: iload_3
    //   349: putfield 710	com/tencent/mm/modelvideo/t$b:diR	I
    //   352: aload 15
    //   354: astore 13
    //   356: aload 15
    //   358: astore 14
    //   360: aload 16
    //   362: iload_3
    //   363: iload_1
    //   364: iadd
    //   365: putfield 713	com/tencent/mm/modelvideo/t$b:ixC	I
    //   368: aload 15
    //   370: ifnull +8 -> 378
    //   373: aload 15
    //   375: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   378: ldc_w 318
    //   381: new 68	java/lang/StringBuilder
    //   384: dup
    //   385: ldc_w 528
    //   388: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   391: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   394: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 502
    //   400: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc_w 530
    //   410: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: iload_1
    //   414: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: ldc_w 715
    //   420: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: iload_2
    //   424: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   427: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 534	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: ldc_w 318
    //   436: new 68	java/lang/StringBuilder
    //   439: dup
    //   440: ldc_w 528
    //   443: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   446: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   449: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc_w 502
    //   455: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload_0
    //   459: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 536
    //   465: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: lload 5
    //   470: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   473: ldc_w 538
    //   476: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: lload 7
    //   481: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   484: ldc_w 540
    //   487: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: lload 9
    //   492: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   495: ldc_w 542
    //   498: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: lload 11
    //   503: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   506: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 534	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: ldc_w 690
    //   515: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   518: aload 16
    //   520: areturn
    //   521: astore 15
    //   523: aload 13
    //   525: astore 14
    //   527: ldc_w 318
    //   530: new 68	java/lang/StringBuilder
    //   533: dup
    //   534: ldc_w 487
    //   537: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   540: invokestatic 492	com/tencent/mm/compatible/util/f:abr	()Ljava/lang/String;
    //   543: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: ldc_w 502
    //   549: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_0
    //   553: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 544
    //   559: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload 16
    //   564: getfield 713	com/tencent/mm/modelvideo/t$b:ixC	I
    //   567: invokevirtual 507	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   570: ldc_w 546
    //   573: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload 15
    //   578: invokevirtual 549	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   581: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc_w 551
    //   587: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 497	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   596: aload 13
    //   598: astore 14
    //   600: aload 16
    //   602: iconst_0
    //   603: invokestatic 500	com/tencent/mm/compatible/util/f:getLine	()I
    //   606: isub
    //   607: putfield 695	com/tencent/mm/modelvideo/t$b:ret	I
    //   610: aload 13
    //   612: ifnull +8 -> 620
    //   615: aload 13
    //   617: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   620: ldc_w 690
    //   623: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   626: aload 16
    //   628: areturn
    //   629: astore_0
    //   630: aload 14
    //   632: ifnull +8 -> 640
    //   635: aload 14
    //   637: invokevirtual 362	java/io/RandomAccessFile:close	()V
    //   640: ldc_w 690
    //   643: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   646: aload_0
    //   647: athrow
    //   648: astore 13
    //   650: goto -272 -> 378
    //   653: astore_0
    //   654: goto -34 -> 620
    //   657: astore 13
    //   659: goto -19 -> 640
    //   662: iload 4
    //   664: istore_3
    //   665: goto -327 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	668	0	paramString	String
    //   0	668	1	paramInt1	int
    //   0	668	2	paramInt2	int
    //   1	664	3	i	int
    //   301	362	4	j	int
    //   249	220	5	l1	long
    //   279	201	7	l2	long
    //   316	175	9	l3	long
    //   331	171	11	l4	long
    //   219	397	13	localObject1	Object
    //   648	1	13	localException1	Exception
    //   657	1	13	localException2	Exception
    //   216	420	14	localObject2	Object
    //   234	140	15	localRandomAccessFile	java.io.RandomAccessFile
    //   521	56	15	localException3	Exception
    //   15	612	16	localb	b
    //   213	114	17	locala	com.tencent.mm.compatible.util.f.a
    // Exception table:
    //   from	to	target	type
    //   229	236	521	java/lang/Exception
    //   244	251	521	java/lang/Exception
    //   259	266	521	java/lang/Exception
    //   274	281	521	java/lang/Exception
    //   289	303	521	java/lang/Exception
    //   311	318	521	java/lang/Exception
    //   326	333	521	java/lang/Exception
    //   346	352	521	java/lang/Exception
    //   360	368	521	java/lang/Exception
    //   229	236	629	finally
    //   244	251	629	finally
    //   259	266	629	finally
    //   274	281	629	finally
    //   289	303	629	finally
    //   311	318	629	finally
    //   326	333	629	finally
    //   346	352	629	finally
    //   360	368	629	finally
    //   527	596	629	finally
    //   600	610	629	finally
    //   373	378	648	java/lang/Exception
    //   615	620	653	java/lang/Exception
    //   635	640	657	java/lang/Exception
  }
  
  public final List<s> A(int paramInt, long paramLong)
  {
    AppMethodBeat.i(126976);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = d.idw.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.addAll(b(((c)localIterator.next()).table, paramInt, paramLong));
    }
    AppMethodBeat.o(126976);
    return localLinkedList;
  }
  
  public final s HD(String paramString)
  {
    AppMethodBeat.i(126969);
    for (;;)
    {
      try
      {
        paramString = BX(d.HP(paramString)) + " where " + d.HP(paramString) + ".filename = \"" + bu.aSk(String.valueOf(paramString)) + "\"";
        Cursor localCursor = this.hKK.a(paramString, null, 2);
        if (localCursor == null)
        {
          AppMethodBeat.o(126969);
          return null;
        }
        if (localCursor.moveToFirst())
        {
          paramString = new s();
          paramString.convertFrom(localCursor);
          localCursor.close();
          AppMethodBeat.o(126969);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.VideoInfoStorage", paramString, "getByFileName error[%s]", new Object[] { paramString.toString() });
        AppMethodBeat.o(126969);
        return null;
      }
      paramString = null;
    }
  }
  
  public final List<String> HG(String paramString)
  {
    Cursor localCursor = null;
    AppMethodBeat.i(217490);
    Object localObject2 = " SELECT * FROM ( " + HC(paramString) + " WHERE status=103" + " LIMIT 10 )";
    localObject2 = (String)localObject2 + " UNION SELECT * FROM ( ";
    paramString = (String)localObject2 + HC(paramString) + " WHERE status=104" + " LIMIT 10 )";
    String str = paramString + " ORDER BY downloadtime DESC";
    localObject2 = new LinkedList();
    paramString = localCursor;
    try
    {
      localCursor = this.hKK.a(str, null, 2);
      paramString = localCursor;
      if (localCursor.moveToFirst())
      {
        boolean bool;
        do
        {
          paramString = localCursor;
          ((List)localObject2).add(localCursor.getString(0));
          paramString = localCursor;
          bool = localCursor.moveToNext();
        } while (bool);
      }
      return localObject2;
    }
    finally
    {
      if (paramString != null) {
        paramString.close();
      }
      AppMethodBeat.o(217490);
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(126966);
    this.hPq.remove(parama);
    AppMethodBeat.o(126966);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(126965);
    this.hPq.a(parama, paramLooper);
    AppMethodBeat.o(126965);
  }
  
  public final List<String> aNA()
  {
    AppMethodBeat.i(126974);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = d.idw.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.addAll(HE(((c)localIterator.next()).table));
    }
    AppMethodBeat.o(126974);
    return localLinkedList;
  }
  
  public final List<String> aNB()
  {
    AppMethodBeat.i(126975);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = d.idw.iterator();
    while (localIterator.hasNext()) {
      localLinkedList.addAll(HF(((c)localIterator.next()).table));
    }
    AppMethodBeat.o(126975);
    return localLinkedList;
  }
  
  public final List<s> aNy()
  {
    AppMethodBeat.i(126971);
    Object localObject1 = BX("videoinfo2");
    Object localObject2 = (String)localObject1 + " WHERE status=200 order by masssendid desc";
    localObject1 = new ArrayList();
    localObject2 = this.hKK.a((String)localObject2, null, 2);
    int i = 0;
    while (((Cursor)localObject2).moveToNext())
    {
      s locals = new s();
      locals.convertFrom((Cursor)localObject2);
      ((List)localObject1).add(locals);
      i += 1;
    }
    ((Cursor)localObject2).close();
    ae.d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:".concat(String.valueOf(i)));
    AppMethodBeat.o(126971);
    return localObject1;
  }
  
  public final List<s> aNz()
  {
    AppMethodBeat.i(126972);
    Object localObject1 = BX("videoinfo2");
    Object localObject2 = (String)localObject1 + " WHERE status=198 AND masssendid > 0 order by masssendid desc";
    localObject1 = new ArrayList();
    localObject2 = this.hKK.a((String)localObject2, null, 2);
    while (((Cursor)localObject2).moveToNext())
    {
      s locals = new s();
      locals.convertFrom((Cursor)localObject2);
      ((List)localObject1).add(locals);
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(126972);
    return localObject1;
  }
  
  public final boolean b(s params)
  {
    AppMethodBeat.i(126968);
    if (params == null)
    {
      AppMethodBeat.o(126968);
      return false;
    }
    params.dEu = -1;
    ContentValues localContentValues = params.convertTo();
    if ((int)this.hKK.a(d.HP(params.getFileName()), "filename", localContentValues) != -1)
    {
      params = new t.a.a(params.getFileName(), t.a.b.ixu, t.a.c.ixy, params.ixf, params.ivn);
      this.hPq.dW(params);
      this.hPq.doNotify();
      AppMethodBeat.o(126968);
      return true;
    }
    AppMethodBeat.o(126968);
    return false;
  }
  
  public final boolean c(s params)
  {
    AppMethodBeat.i(126973);
    boolean bool;
    if (params != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (params.getFileName().length() <= 0) {
        break label66;
      }
      bool = true;
      label28:
      Assert.assertTrue(bool);
      localObject = params.convertTo();
      if (((ContentValues)localObject).size() > 0) {
        break label71;
      }
      ae.e("MicroMsg.VideoInfoStorage", "update failed, no values set");
    }
    label66:
    label71:
    while (this.hKK.update(d.HP(params.getFileName()), (ContentValues)localObject, "filename= ?", new String[] { params.getFileName() }) <= 0)
    {
      AppMethodBeat.o(126973);
      return false;
      bool = false;
      break;
      bool = false;
      break label28;
    }
    Object localObject = t.a.c.ixy;
    if (params.status == 112) {}
    for (localObject = t.a.c.ixA;; localObject = t.a.c.ixz) {
      do
      {
        params = new t.a.a(params.getFileName(), t.a.b.ixw, (t.a.c)localObject, params.ixf, params.ivn);
        this.hPq.dW(params);
        this.hPq.doNotify();
        AppMethodBeat.o(126973);
        return true;
      } while ((params.status != 103) && (params.status != 104));
    }
  }
  
  public final boolean q(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(126985);
    boolean bool = by(paramString1, paramString2 + "##" + paramString3);
    AppMethodBeat.o(126985);
    return bool;
  }
  
  public final List<s> sE(long paramLong)
  {
    AppMethodBeat.i(126970);
    Object localObject = BX("videoinfo2") + " where videoinfo2.masssendid = " + paramLong;
    localObject = this.hKK.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(126970);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (((Cursor)localObject).moveToNext())
    {
      s locals = new s();
      locals.convertFrom((Cursor)localObject);
      localArrayList.add(locals);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(126970);
    return localArrayList;
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public static final class a
    {
      public final String fileName;
      public final long ivn;
      public final int ixf;
      public final t.a.b ixs;
      public final t.a.c ixt;
      
      public a(String paramString, t.a.b paramb, t.a.c paramc, int paramInt, long paramLong)
      {
        this.fileName = paramString;
        this.ixs = paramb;
        this.ixt = paramc;
        this.ixf = paramInt;
        this.ivn = paramLong;
      }
    }
    
    public static enum b
    {
      static
      {
        AppMethodBeat.i(126961);
        ixu = new b("INSERT", 0);
        ixv = new b("DELETE", 1);
        ixw = new b("UPDATE", 2);
        ixx = new b[] { ixu, ixv, ixw };
        AppMethodBeat.o(126961);
      }
      
      private b() {}
    }
    
    public static enum c
    {
      static
      {
        AppMethodBeat.i(126964);
        ixy = new c("NORMAL", 0);
        ixz = new c("UPLOAD", 1);
        ixA = new c("DOWNLOAD", 2);
        ixB = new c[] { ixy, ixz, ixA };
        AppMethodBeat.o(126964);
      }
      
      private c() {}
    }
  }
  
  public static final class b
  {
    public byte[] buf = null;
    public int diR = 0;
    public int ixC = 0;
    public int ret = 0;
  }
  
  public static final class c
  {
    String ids;
    String[] idt;
    String table;
    
    public c(String paramString1, String paramString2, String[] paramArrayOfString)
    {
      this.table = paramString2;
      this.ids = paramString1;
      this.idt = paramArrayOfString;
    }
  }
  
  public static final class d
  {
    public static final ArrayList<t.c> idw;
    
    static
    {
      AppMethodBeat.i(217484);
      idw = new ArrayList(3);
      a("", "videoinfo2", t.HN("videoinfo2"));
      a("findermsg", "findervideoinfo", t.HO("findervideoinfo"));
      a("gamelifesess", "gamelifevideoinfo", t.HO("gamelifevideoinfo"));
      AppMethodBeat.o(217484);
    }
    
    public static String HP(String paramString)
    {
      AppMethodBeat.i(217483);
      if (paramString == null)
      {
        ae.e("MicroMsg.VideoInfoStorage", "[getTable] fileName is null. %s", new Object[] { bu.fpN() });
        AppMethodBeat.o(217483);
        return "videoinfo2";
      }
      Iterator localIterator = idw.iterator();
      while (localIterator.hasNext())
      {
        t.c localc = (t.c)localIterator.next();
        if ((!localc.ids.isEmpty()) && (paramString.toLowerCase().endsWith(localc.ids)))
        {
          paramString = localc.table;
          AppMethodBeat.o(217483);
          return paramString;
        }
      }
      AppMethodBeat.o(217483);
      return "videoinfo2";
    }
    
    private static void a(String paramString1, String paramString2, String[] paramArrayOfString)
    {
      AppMethodBeat.i(217482);
      idw.add(new t.c(paramString1.toLowerCase(), paramString2, paramArrayOfString));
      AppMethodBeat.o(217482);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.t
 * JD-Core Version:    0.7.0.1
 */