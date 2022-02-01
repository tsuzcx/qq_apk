package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import junit.framework.Assert;

public final class t
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS videoinfo2 ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int, forward_msg_local_id int,msg_uuid text )", "CREATE INDEX IF NOT EXISTS  video_status_index ON videoinfo2 ( status,downloadtime )", "CREATE TABLE IF NOT EXISTS videoinfo ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int, forward_msg_local_id int, msg_uuid text )", "alter table videoinfo2 add videofuncflag int ;", "alter table videoinfo2 add masssendid long default 0;", "alter table videoinfo2 add masssendlist text ;", "alter table videoinfo2 add videomd5 text ;", "alter table videoinfo2 add streamvideo byte[] ;", "alter table videoinfo2 add statextstr text ;", "alter table videoinfo2 add downloadscene int ;", "alter table videoinfo2 add mmsightextinfo byte[] ;", "alter table videoinfo2 add preloadsize int ;", "alter table videoinfo2 add videoformat int ;", "alter table videoinfo2 add forward_msg_local_id int ;", "alter table videoinfo2 add msg_uuid text ;", "alter table videoinfo add videofuncflag int ;", "alter table videoinfo add masssendid long default 0;", "alter table videoinfo add masssendlist text ;", "alter table videoinfo add videomd5 text ;", "alter table videoinfo add streamvideo byte[] ;", "alter table videoinfo add statextstr text ;", "alter table videoinfo add downloadscene int ;", "alter table videoinfo add mmsightextinfo byte[] ;", "alter table videoinfo add preloadsize int ;", "alter table videoinfo add videoformat int ;", "alter table videoinfo add forward_msg_local_id int ;", "alter table videoinfo add msg_uuid text ;", "insert into videoinfo2 select * from videoinfo ;", "delete from videoinfo ;", "CREATE INDEX IF NOT EXISTS  massSendIdIndex ON videoinfo2 ( masssendid )", "CREATE INDEX IF NOT EXISTS  LastModifyTimeIndex ON videoinfo2 ( lastmodifytime )", "CREATE TABLE IF NOT EXISTS  VideoHash  (size int , CreateTime long, hash text ,  cdnxml text, orgpath text);", "CREATE INDEX IF NOT EXISTS  VideoHashSizeIndex ON VideoHash ( size  )", "CREATE INDEX IF NOT EXISTS  VideoHashTimeIndex ON VideoHash ( CreateTime  )" };
  private static long iaX = 0L;
  public com.tencent.mm.storagebase.h hpA;
  l<a, t.a.a> huf;
  
  public t(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(126967);
    this.huf = new l() {};
    this.hpA = paramh;
    AppMethodBeat.o(126967);
  }
  
  public static String DU(String paramString)
  {
    AppMethodBeat.i(126978);
    long l = System.currentTimeMillis();
    String str2 = new SimpleDateFormat("HHmmssddMMyy").format(new Date(l));
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.length() > 1) {
        str1 = str2 + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()).substring(0, 7);
      }
    }
    paramString = str1 + l % 10000L;
    paramString = new StringBuilder().append(paramString);
    l = iaX;
    iaX = 1L + l;
    paramString = l;
    AppMethodBeat.o(126978);
    return paramString;
  }
  
  public static String DV(String paramString)
  {
    AppMethodBeat.i(126980);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126980);
      return null;
    }
    paramString = getVideoPath() + paramString;
    if (i.eA(paramString))
    {
      AppMethodBeat.o(126980);
      return paramString;
    }
    paramString = paramString + ".mp4";
    AppMethodBeat.o(126980);
    return paramString;
  }
  
  public static String DW(String paramString)
  {
    AppMethodBeat.i(126981);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126981);
      return null;
    }
    paramString = getVideoPath() + paramString + ".jpg";
    AppMethodBeat.o(126981);
    return paramString;
  }
  
  public static int DX(String paramString)
  {
    AppMethodBeat.i(126984);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126984);
      return -1;
    }
    paramString = new com.tencent.mm.vfs.e(paramString);
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
  static int[] DY(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 224
    //   4: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: bipush 33
    //   9: newarray int
    //   11: astore 10
    //   13: invokestatic 227	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   16: lstore 4
    //   18: aload_0
    //   19: invokestatic 231	com/tencent/mm/vfs/i:aSp	(Ljava/lang/String;)J
    //   22: l2i
    //   23: istore_2
    //   24: iload_2
    //   25: ldc 232
    //   27: if_icmplt +9 -> 36
    //   30: iload_2
    //   31: ldc 233
    //   33: if_icmplt +79 -> 112
    //   36: ldc 235
    //   38: ldc 237
    //   40: iconst_2
    //   41: anewarray 4	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: iload_2
    //   47: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: aload_0
    //   54: aastore
    //   55: invokestatic 249	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   58: getstatic 255	com/tencent/mm/plugin/report/service/h:wUl	Lcom/tencent/mm/plugin/report/service/h;
    //   61: astore_0
    //   62: iload_2
    //   63: ldc 232
    //   65: if_icmpge +41 -> 106
    //   68: bipush 10
    //   70: istore_1
    //   71: aload_0
    //   72: sipush 12696
    //   75: iconst_2
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: iload_1
    //   82: bipush 101
    //   84: iadd
    //   85: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: iload_2
    //   92: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: invokevirtual 259	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   99: ldc 224
    //   101: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aconst_null
    //   105: areturn
    //   106: bipush 20
    //   108: istore_1
    //   109: goto -38 -> 71
    //   112: aload 10
    //   114: bipush 32
    //   116: iload_2
    //   117: iastore
    //   118: iload_2
    //   119: sipush 20480
    //   122: isub
    //   123: bipush 32
    //   125: idiv
    //   126: istore_3
    //   127: sipush 512
    //   130: newarray byte
    //   132: astore 11
    //   134: aload_0
    //   135: iconst_0
    //   136: invokestatic 263	com/tencent/mm/vfs/i:cY	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   139: astore 9
    //   141: iload_1
    //   142: bipush 32
    //   144: if_icmpge +66 -> 210
    //   147: iload_1
    //   148: iload_3
    //   149: imul
    //   150: sipush 10240
    //   153: iadd
    //   154: i2l
    //   155: lstore 6
    //   157: aload 9
    //   159: astore 8
    //   161: aload 9
    //   163: lload 6
    //   165: invokevirtual 268	java/io/RandomAccessFile:seek	(J)V
    //   168: aload 9
    //   170: astore 8
    //   172: aload 9
    //   174: aload 11
    //   176: invokevirtual 272	java/io/RandomAccessFile:readFully	([B)V
    //   179: aload 9
    //   181: astore 8
    //   183: aload 10
    //   185: iload_1
    //   186: aload 11
    //   188: sipush 512
    //   191: invokestatic 278	com/tencent/mm/b/i:s	([BI)I
    //   194: ldc_w 279
    //   197: irem
    //   198: ldc_w 279
    //   201: ior
    //   202: iastore
    //   203: iload_1
    //   204: iconst_1
    //   205: iadd
    //   206: istore_1
    //   207: goto -66 -> 141
    //   210: aload 9
    //   212: astore 8
    //   214: aload 9
    //   216: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   219: aload 9
    //   221: astore 8
    //   223: ldc 235
    //   225: ldc_w 284
    //   228: iconst_3
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: lload 4
    //   236: invokestatic 288	com/tencent/mm/sdk/platformtools/bs:Ap	(J)J
    //   239: invokestatic 293	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: iload_2
    //   246: invokestatic 243	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: aastore
    //   250: dup
    //   251: iconst_2
    //   252: aload_0
    //   253: aastore
    //   254: invokestatic 295	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: aload 9
    //   259: ifnull +8 -> 267
    //   262: aload 9
    //   264: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   267: ldc 224
    //   269: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: aload 10
    //   274: areturn
    //   275: astore 10
    //   277: aconst_null
    //   278: astore 9
    //   280: aload 9
    //   282: astore 8
    //   284: ldc 235
    //   286: ldc_w 297
    //   289: iconst_2
    //   290: anewarray 4	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: aload_0
    //   296: aastore
    //   297: dup
    //   298: iconst_1
    //   299: aload 10
    //   301: invokestatic 301	com/tencent/mm/sdk/platformtools/bs:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   304: aastore
    //   305: invokestatic 249	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: aload 9
    //   310: ifnull +8 -> 318
    //   313: aload 9
    //   315: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   318: ldc 224
    //   320: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: aconst_null
    //   324: areturn
    //   325: astore_0
    //   326: aconst_null
    //   327: astore 8
    //   329: aload 8
    //   331: ifnull +8 -> 339
    //   334: aload 8
    //   336: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   339: ldc 224
    //   341: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aload_0
    //   345: athrow
    //   346: astore_0
    //   347: goto -80 -> 267
    //   350: astore_0
    //   351: goto -33 -> 318
    //   354: astore 8
    //   356: goto -17 -> 339
    //   359: astore_0
    //   360: goto -31 -> 329
    //   363: astore 10
    //   365: goto -85 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	paramString	String
    //   1	206	1	i	int
    //   23	223	2	j	int
    //   126	24	3	k	int
    //   16	219	4	l1	long
    //   155	9	6	l2	long
    //   159	176	8	localRandomAccessFile1	java.io.RandomAccessFile
    //   354	1	8	localException1	Exception
    //   139	175	9	localRandomAccessFile2	java.io.RandomAccessFile
    //   11	262	10	arrayOfInt	int[]
    //   275	25	10	localException2	Exception
    //   363	1	10	localException3	Exception
    //   132	55	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   134	141	275	java/lang/Exception
    //   134	141	325	finally
    //   262	267	346	java/lang/Exception
    //   313	318	350	java/lang/Exception
    //   334	339	354	java/lang/Exception
    //   161	168	359	finally
    //   172	179	359	finally
    //   183	203	359	finally
    //   214	219	359	finally
    //   223	257	359	finally
    //   284	308	359	finally
    //   161	168	363	java/lang/Exception
    //   172	179	363	java/lang/Exception
    //   183	203	363	java/lang/Exception
    //   214	219	363	java/lang/Exception
    //   223	257	363	java/lang/Exception
  }
  
  /* Error */
  public static int a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc_w 303
    //   3: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 193	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +47 -> 57
    //   13: ldc 235
    //   15: new 157	java/lang/StringBuilder
    //   18: dup
    //   19: ldc_w 305
    //   22: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   28: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 313
    //   34: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 316	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: invokestatic 319	com/tencent/mm/compatible/util/f:getLine	()I
    //   46: istore_1
    //   47: ldc_w 303
    //   50: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: iconst_0
    //   54: iload_1
    //   55: isub
    //   56: ireturn
    //   57: iload_1
    //   58: ifge +61 -> 119
    //   61: ldc 235
    //   63: new 157	java/lang/StringBuilder
    //   66: dup
    //   67: ldc_w 305
    //   70: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   76: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 321
    //   82: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 323
    //   92: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: iload_1
    //   96: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 316	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: invokestatic 319	com/tencent/mm/compatible/util/f:getLine	()I
    //   108: istore_1
    //   109: ldc_w 303
    //   112: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: iconst_0
    //   116: iload_1
    //   117: isub
    //   118: ireturn
    //   119: aload_2
    //   120: invokestatic 330	com/tencent/mm/sdk/platformtools/bs:cv	([B)Z
    //   123: ifeq +57 -> 180
    //   126: ldc 235
    //   128: new 157	java/lang/StringBuilder
    //   131: dup
    //   132: ldc_w 305
    //   135: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   138: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   141: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc_w 321
    //   147: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: ldc_w 332
    //   157: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 316	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: invokestatic 319	com/tencent/mm/compatible/util/f:getLine	()I
    //   169: istore_1
    //   170: ldc_w 303
    //   173: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: iconst_0
    //   177: iload_1
    //   178: isub
    //   179: ireturn
    //   180: new 334	com/tencent/mm/compatible/util/f$a
    //   183: dup
    //   184: invokespecial 335	com/tencent/mm/compatible/util/f$a:<init>	()V
    //   187: astore 15
    //   189: aconst_null
    //   190: astore 13
    //   192: aconst_null
    //   193: astore 12
    //   195: aload_0
    //   196: iconst_1
    //   197: invokestatic 263	com/tencent/mm/vfs/i:cY	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   200: astore 14
    //   202: aload 14
    //   204: astore 12
    //   206: aload 14
    //   208: astore 13
    //   210: aload 15
    //   212: invokevirtual 338	com/tencent/mm/compatible/util/f$a:YH	()J
    //   215: lstore 4
    //   217: aload 14
    //   219: astore 12
    //   221: aload 14
    //   223: astore 13
    //   225: aload 14
    //   227: iload_1
    //   228: i2l
    //   229: invokevirtual 268	java/io/RandomAccessFile:seek	(J)V
    //   232: aload 14
    //   234: astore 12
    //   236: aload 14
    //   238: astore 13
    //   240: aload 15
    //   242: invokevirtual 338	com/tencent/mm/compatible/util/f$a:YH	()J
    //   245: lstore 6
    //   247: aload 14
    //   249: astore 12
    //   251: aload 14
    //   253: astore 13
    //   255: aload 14
    //   257: aload_2
    //   258: iconst_0
    //   259: aload_2
    //   260: arraylength
    //   261: invokevirtual 342	java/io/RandomAccessFile:write	([BII)V
    //   264: aload 14
    //   266: astore 12
    //   268: aload 14
    //   270: astore 13
    //   272: aload 15
    //   274: invokevirtual 338	com/tencent/mm/compatible/util/f$a:YH	()J
    //   277: lstore 8
    //   279: aload 14
    //   281: astore 12
    //   283: aload 14
    //   285: astore 13
    //   287: aload 14
    //   289: invokevirtual 345	java/io/RandomAccessFile:getFilePointer	()J
    //   292: l2i
    //   293: istore_3
    //   294: aload 14
    //   296: astore 12
    //   298: aload 14
    //   300: astore 13
    //   302: aload 15
    //   304: invokevirtual 338	com/tencent/mm/compatible/util/f$a:YH	()J
    //   307: lstore 10
    //   309: aload 14
    //   311: ifnull +8 -> 319
    //   314: aload 14
    //   316: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   319: ldc 235
    //   321: new 157	java/lang/StringBuilder
    //   324: dup
    //   325: ldc_w 347
    //   328: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   334: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 321
    //   340: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload_0
    //   344: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 349
    //   350: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload_1
    //   354: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: ldc_w 351
    //   360: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_2
    //   364: arraylength
    //   365: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: ldc 235
    //   376: new 157	java/lang/StringBuilder
    //   379: dup
    //   380: ldc_w 347
    //   383: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   386: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   389: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: ldc_w 321
    //   395: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_0
    //   399: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc_w 356
    //   405: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: lload 4
    //   410: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   413: ldc_w 358
    //   416: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: lload 6
    //   421: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   424: ldc_w 360
    //   427: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: lload 8
    //   432: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   435: ldc_w 362
    //   438: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: lload 10
    //   443: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   446: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: ldc_w 303
    //   455: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   458: iload_3
    //   459: ireturn
    //   460: astore_2
    //   461: aload 12
    //   463: astore 13
    //   465: ldc 235
    //   467: new 157	java/lang/StringBuilder
    //   470: dup
    //   471: ldc_w 305
    //   474: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   477: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   480: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: ldc_w 321
    //   486: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_0
    //   490: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc_w 364
    //   496: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: iload_1
    //   500: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: ldc_w 366
    //   506: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload_2
    //   510: invokevirtual 369	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   513: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc_w 371
    //   519: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 316	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload 12
    //   530: astore 13
    //   532: invokestatic 319	com/tencent/mm/compatible/util/f:getLine	()I
    //   535: istore_1
    //   536: aload 12
    //   538: ifnull +8 -> 546
    //   541: aload 12
    //   543: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   546: ldc_w 303
    //   549: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   552: iconst_0
    //   553: iload_1
    //   554: isub
    //   555: ireturn
    //   556: astore_0
    //   557: aload 13
    //   559: ifnull +8 -> 567
    //   562: aload 13
    //   564: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   567: ldc_w 303
    //   570: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   573: aload_0
    //   574: athrow
    //   575: astore 12
    //   577: goto -258 -> 319
    //   580: astore_0
    //   581: goto -35 -> 546
    //   584: astore_2
    //   585: goto -18 -> 567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	paramString	String
    //   0	588	1	paramInt	int
    //   0	588	2	paramArrayOfByte	byte[]
    //   293	166	3	i	int
    //   215	194	4	l1	long
    //   245	175	6	l2	long
    //   277	154	8	l3	long
    //   307	135	10	l4	long
    //   193	349	12	localObject1	Object
    //   575	1	12	localException	Exception
    //   190	373	13	localObject2	Object
    //   200	115	14	localRandomAccessFile	java.io.RandomAccessFile
    //   187	116	15	locala	com.tencent.mm.compatible.util.f.a
    // Exception table:
    //   from	to	target	type
    //   195	202	460	java/lang/Exception
    //   210	217	460	java/lang/Exception
    //   225	232	460	java/lang/Exception
    //   240	247	460	java/lang/Exception
    //   255	264	460	java/lang/Exception
    //   272	279	460	java/lang/Exception
    //   287	294	460	java/lang/Exception
    //   302	309	460	java/lang/Exception
    //   195	202	556	finally
    //   210	217	556	finally
    //   225	232	556	finally
    //   240	247	556	finally
    //   255	264	556	finally
    //   272	279	556	finally
    //   287	294	556	finally
    //   302	309	556	finally
    //   465	528	556	finally
    //   532	536	556	finally
    //   314	319	575	java/lang/Exception
    //   541	546	580	java/lang/Exception
    //   562	567	584	java/lang/Exception
  }
  
  private boolean bx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(126987);
    ac.i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", new Object[] { paramString1, paramString2, bs.eWi() });
    long l1 = bs.eWj();
    if ((bs.isNullOrNil(paramString1)) || (bs.isNullOrNil(paramString2)))
    {
      ac.e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(126987);
      return false;
    }
    Object localObject = DY(paramString1);
    if ((localObject == null) || (localObject.length < 33))
    {
      ac.e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", new Object[] { paramString1 });
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
    localObject = this.hpA.a("select cdnxml from VideoHash where size = " + j + " and hash = \"" + localStringBuffer.toString() + "\"", null, 2);
    Vector localVector = new Vector();
    while (((Cursor)localObject).moveToNext())
    {
      localVector.add(((Cursor)localObject).getString(0));
      ac.v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", new Object[] { Integer.valueOf(localVector.size()), localVector.get(localVector.size() - 1) });
    }
    ((Cursor)localObject).close();
    if ((localVector.size() == 1) && (paramString2.equals(localVector.get(0))))
    {
      ac.w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", new Object[] { Long.valueOf(bs.Ap(l1)), paramString1, paramString2 });
      AppMethodBeat.o(126987);
      return true;
    }
    if (localVector.size() > 0)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(12696, new Object[] { Integer.valueOf(102), Integer.valueOf(j), "", "", Integer.valueOf(localVector.size()) });
      ac.e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", new Object[] { Integer.valueOf(localVector.size()), Integer.valueOf(j) });
      this.hpA.execSQL("VideoHash", "delete from VideoHash where size = " + j + " and hash = \"" + localStringBuffer.toString() + "\"");
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("size", Integer.valueOf(j));
    ((ContentValues)localObject).put("CreateTime", Long.valueOf(bs.aNx()));
    ((ContentValues)localObject).put("hash", localStringBuffer.toString());
    ((ContentValues)localObject).put("cdnxml", paramString2);
    ((ContentValues)localObject).put("orgpath", paramString1);
    long l2 = this.hpA.a("VideoHash", "", (ContentValues)localObject);
    ac.i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", new Object[] { Long.valueOf(bs.Ap(l1)), Long.valueOf(l2), paramString1, localStringBuffer, paramString2 });
    if (l2 < 0L)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(12696, new Object[] { Integer.valueOf(103), Integer.valueOf(j) });
      ac.e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", new Object[] { Long.valueOf(l2), paramString1 });
    }
    AppMethodBeat.o(126987);
    return true;
  }
  
  private static String getVideoPath()
  {
    AppMethodBeat.i(126979);
    String str = com.tencent.mm.kernel.g.agR().ghC + "video/";
    AppMethodBeat.o(126979);
    return str;
  }
  
  /* Error */
  public static b r(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 504
    //   5: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 19	com/tencent/mm/modelvideo/t$b
    //   11: dup
    //   12: invokespecial 505	com/tencent/mm/modelvideo/t$b:<init>	()V
    //   15: astore 16
    //   17: aload_0
    //   18: invokestatic 193	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   21: ifeq +52 -> 73
    //   24: ldc 235
    //   26: new 157	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 305
    //   33: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   39: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 313
    //   45: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 316	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload 16
    //   56: iconst_0
    //   57: invokestatic 319	com/tencent/mm/compatible/util/f:getLine	()I
    //   60: isub
    //   61: putfield 509	com/tencent/mm/modelvideo/t$b:ret	I
    //   64: ldc_w 504
    //   67: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload 16
    //   72: areturn
    //   73: iload_1
    //   74: ifge +66 -> 140
    //   77: ldc 235
    //   79: new 157	java/lang/StringBuilder
    //   82: dup
    //   83: ldc_w 305
    //   86: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   92: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc_w 321
    //   98: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: ldc_w 511
    //   108: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload_1
    //   112: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 316	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload 16
    //   123: iconst_0
    //   124: invokestatic 319	com/tencent/mm/compatible/util/f:getLine	()I
    //   127: isub
    //   128: putfield 509	com/tencent/mm/modelvideo/t$b:ret	I
    //   131: ldc_w 504
    //   134: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload 16
    //   139: areturn
    //   140: iload_2
    //   141: ifgt +62 -> 203
    //   144: ldc 235
    //   146: new 157	java/lang/StringBuilder
    //   149: dup
    //   150: ldc_w 305
    //   153: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   159: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 321
    //   165: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 513
    //   175: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 316	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 16
    //   186: iconst_0
    //   187: invokestatic 319	com/tencent/mm/compatible/util/f:getLine	()I
    //   190: isub
    //   191: putfield 509	com/tencent/mm/modelvideo/t$b:ret	I
    //   194: ldc_w 504
    //   197: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload 16
    //   202: areturn
    //   203: new 334	com/tencent/mm/compatible/util/f$a
    //   206: dup
    //   207: invokespecial 335	com/tencent/mm/compatible/util/f$a:<init>	()V
    //   210: astore 17
    //   212: aconst_null
    //   213: astore 14
    //   215: aconst_null
    //   216: astore 13
    //   218: aload 16
    //   220: iload_2
    //   221: newarray byte
    //   223: putfield 517	com/tencent/mm/modelvideo/t$b:buf	[B
    //   226: aload_0
    //   227: iconst_0
    //   228: invokestatic 263	com/tencent/mm/vfs/i:cY	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   231: astore 15
    //   233: aload 15
    //   235: astore 13
    //   237: aload 15
    //   239: astore 14
    //   241: aload 17
    //   243: invokevirtual 338	com/tencent/mm/compatible/util/f$a:YH	()J
    //   246: lstore 5
    //   248: aload 15
    //   250: astore 13
    //   252: aload 15
    //   254: astore 14
    //   256: aload 15
    //   258: iload_1
    //   259: i2l
    //   260: invokevirtual 268	java/io/RandomAccessFile:seek	(J)V
    //   263: aload 15
    //   265: astore 13
    //   267: aload 15
    //   269: astore 14
    //   271: aload 17
    //   273: invokevirtual 338	com/tencent/mm/compatible/util/f$a:YH	()J
    //   276: lstore 7
    //   278: aload 15
    //   280: astore 13
    //   282: aload 15
    //   284: astore 14
    //   286: aload 15
    //   288: aload 16
    //   290: getfield 517	com/tencent/mm/modelvideo/t$b:buf	[B
    //   293: iconst_0
    //   294: iload_2
    //   295: invokevirtual 521	java/io/RandomAccessFile:read	([BII)I
    //   298: istore 4
    //   300: aload 15
    //   302: astore 13
    //   304: aload 15
    //   306: astore 14
    //   308: aload 17
    //   310: invokevirtual 338	com/tencent/mm/compatible/util/f$a:YH	()J
    //   313: lstore 9
    //   315: aload 15
    //   317: astore 13
    //   319: aload 15
    //   321: astore 14
    //   323: aload 17
    //   325: invokevirtual 338	com/tencent/mm/compatible/util/f$a:YH	()J
    //   328: lstore 11
    //   330: iload 4
    //   332: ifge +324 -> 656
    //   335: aload 15
    //   337: astore 13
    //   339: aload 15
    //   341: astore 14
    //   343: aload 16
    //   345: iload_3
    //   346: putfield 524	com/tencent/mm/modelvideo/t$b:cWy	I
    //   349: aload 15
    //   351: astore 13
    //   353: aload 15
    //   355: astore 14
    //   357: aload 16
    //   359: iload_3
    //   360: iload_1
    //   361: iadd
    //   362: putfield 527	com/tencent/mm/modelvideo/t$b:ibm	I
    //   365: aload 15
    //   367: ifnull +8 -> 375
    //   370: aload 15
    //   372: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   375: ldc 235
    //   377: new 157	java/lang/StringBuilder
    //   380: dup
    //   381: ldc_w 347
    //   384: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   387: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   390: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc_w 321
    //   396: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_0
    //   400: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: ldc_w 349
    //   406: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: iload_1
    //   410: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   413: ldc_w 529
    //   416: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: iload_2
    //   420: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   423: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: ldc 235
    //   431: new 157	java/lang/StringBuilder
    //   434: dup
    //   435: ldc_w 347
    //   438: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   441: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   444: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: ldc_w 321
    //   450: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_0
    //   454: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: ldc_w 356
    //   460: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: lload 5
    //   465: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   468: ldc_w 358
    //   471: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: lload 7
    //   476: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   479: ldc_w 360
    //   482: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: lload 9
    //   487: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   490: ldc_w 362
    //   493: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: lload 11
    //   498: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   501: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 354	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: ldc_w 504
    //   510: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   513: aload 16
    //   515: areturn
    //   516: astore 15
    //   518: aload 13
    //   520: astore 14
    //   522: ldc 235
    //   524: new 157	java/lang/StringBuilder
    //   527: dup
    //   528: ldc_w 305
    //   531: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   534: invokestatic 311	com/tencent/mm/compatible/util/f:YG	()Ljava/lang/String;
    //   537: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: ldc_w 321
    //   543: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload_0
    //   547: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 364
    //   553: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 16
    //   558: getfield 527	com/tencent/mm/modelvideo/t$b:ibm	I
    //   561: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   564: ldc_w 366
    //   567: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload 15
    //   572: invokevirtual 369	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   575: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: ldc_w 371
    //   581: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 316	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   590: aload 13
    //   592: astore 14
    //   594: aload 16
    //   596: iconst_0
    //   597: invokestatic 319	com/tencent/mm/compatible/util/f:getLine	()I
    //   600: isub
    //   601: putfield 509	com/tencent/mm/modelvideo/t$b:ret	I
    //   604: aload 13
    //   606: ifnull +8 -> 614
    //   609: aload 13
    //   611: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   614: ldc_w 504
    //   617: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   620: aload 16
    //   622: areturn
    //   623: astore_0
    //   624: aload 14
    //   626: ifnull +8 -> 634
    //   629: aload 14
    //   631: invokevirtual 282	java/io/RandomAccessFile:close	()V
    //   634: ldc_w 504
    //   637: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   640: aload_0
    //   641: athrow
    //   642: astore 13
    //   644: goto -269 -> 375
    //   647: astore_0
    //   648: goto -34 -> 614
    //   651: astore 13
    //   653: goto -19 -> 634
    //   656: iload 4
    //   658: istore_3
    //   659: goto -324 -> 335
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	paramString	String
    //   0	662	1	paramInt1	int
    //   0	662	2	paramInt2	int
    //   1	658	3	i	int
    //   298	359	4	j	int
    //   246	218	5	l1	long
    //   276	199	7	l2	long
    //   313	173	9	l3	long
    //   328	169	11	l4	long
    //   216	394	13	localObject1	Object
    //   642	1	13	localException1	Exception
    //   651	1	13	localException2	Exception
    //   213	417	14	localObject2	Object
    //   231	140	15	localRandomAccessFile	java.io.RandomAccessFile
    //   516	55	15	localException3	Exception
    //   15	606	16	localb	b
    //   210	114	17	locala	com.tencent.mm.compatible.util.f.a
    // Exception table:
    //   from	to	target	type
    //   226	233	516	java/lang/Exception
    //   241	248	516	java/lang/Exception
    //   256	263	516	java/lang/Exception
    //   271	278	516	java/lang/Exception
    //   286	300	516	java/lang/Exception
    //   308	315	516	java/lang/Exception
    //   323	330	516	java/lang/Exception
    //   343	349	516	java/lang/Exception
    //   357	365	516	java/lang/Exception
    //   226	233	623	finally
    //   241	248	623	finally
    //   256	263	623	finally
    //   271	278	623	finally
    //   286	300	623	finally
    //   308	315	623	finally
    //   323	330	623	finally
    //   343	349	623	finally
    //   357	365	623	finally
    //   522	590	623	finally
    //   594	604	623	finally
    //   370	375	642	java/lang/Exception
    //   609	614	647	java/lang/Exception
    //   629	634	651	java/lang/Exception
  }
  
  public final s DT(String paramString)
  {
    AppMethodBeat.i(126969);
    for (;;)
    {
      try
      {
        paramString = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat,videoinfo2.forward_msg_local_id,videoinfo2.msg_uuid from videoinfo2   where videoinfo2.filename = \"" + bs.aLh(String.valueOf(paramString)) + "\"";
        Cursor localCursor = this.hpA.a(paramString, null, 2);
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
        ac.printErrStackTrace("MicroMsg.VideoInfoStorage", paramString, "getByFileName error[%s]", new Object[] { paramString.toString() });
        AppMethodBeat.o(126969);
        return null;
      }
      paramString = null;
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(126966);
    this.huf.remove(parama);
    AppMethodBeat.o(126966);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(126965);
    this.huf.a(parama, paramLooper);
    AppMethodBeat.o(126965);
  }
  
  public final List<s> aJP()
  {
    AppMethodBeat.i(126971);
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat,videoinfo2.forward_msg_local_id,videoinfo2.msg_uuid from videoinfo2  " + " WHERE status=200 order by masssendid desc";
    ArrayList localArrayList = new ArrayList();
    localObject = this.hpA.a((String)localObject, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext())
    {
      s locals = new s();
      locals.convertFrom((Cursor)localObject);
      localArrayList.add(locals);
      i += 1;
    }
    ((Cursor)localObject).close();
    ac.d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:".concat(String.valueOf(i)));
    AppMethodBeat.o(126971);
    return localArrayList;
  }
  
  public final List<s> aJQ()
  {
    AppMethodBeat.i(126972);
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat,videoinfo2.forward_msg_local_id,videoinfo2.msg_uuid from videoinfo2  " + " WHERE status=198 AND masssendid > 0 order by masssendid desc";
    ArrayList localArrayList = new ArrayList();
    localObject = this.hpA.a((String)localObject, null, 2);
    while (((Cursor)localObject).moveToNext())
    {
      s locals = new s();
      locals.convertFrom((Cursor)localObject);
      localArrayList.add(locals);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(126972);
    return localArrayList;
  }
  
  public final List<String> aJR()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(126974);
    Object localObject1 = "select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE status=112 ORDER BY downloadtime DESC " + " LIMIT 10";
    try
    {
      localObject1 = this.hpA.a((String)localObject1, null, 2);
      boolean bool;
      if (localObject1 == null) {
        break label121;
      }
    }
    finally
    {
      try
      {
        if (((Cursor)localObject1).moveToFirst())
        {
          localArrayList = new ArrayList();
          do
          {
            localArrayList.add(((Cursor)localObject1).getString(0));
            bool = ((Cursor)localObject1).moveToNext();
          } while (bool);
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        AppMethodBeat.o(126974);
        return localArrayList;
      }
      finally
      {
        break label111;
      }
      localObject2 = finally;
      localObject1 = null;
    }
    label111:
    ((Cursor)localObject1).close();
    label121:
    AppMethodBeat.o(126974);
    throw localObject2;
  }
  
  public final List<String> aJS()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(126975);
    Object localObject1 = " SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=122" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " UNION SELECT * FROM ( ";
    localObject1 = (String)localObject1 + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=120" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " ORDER BY downloadtime DESC";
    try
    {
      localObject1 = this.hpA.a((String)localObject1, null, 2);
      boolean bool;
      if (localObject1 == null) {
        break label190;
      }
    }
    finally
    {
      try
      {
        if (((Cursor)localObject1).moveToFirst())
        {
          localArrayList = new ArrayList();
          do
          {
            localArrayList.add(((Cursor)localObject1).getString(0));
            bool = ((Cursor)localObject1).moveToNext();
          } while (bool);
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        AppMethodBeat.o(126975);
        return localArrayList;
      }
      finally
      {
        break label180;
      }
      localObject2 = finally;
      localObject1 = null;
    }
    label180:
    ((Cursor)localObject1).close();
    label190:
    AppMethodBeat.o(126975);
    throw localObject2;
  }
  
  public final List<String> aJT()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(126977);
    Object localObject1 = " SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=103" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " UNION SELECT * FROM ( ";
    localObject1 = (String)localObject1 + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=104" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " ORDER BY downloadtime DESC";
    try
    {
      localObject1 = this.hpA.a((String)localObject1, null, 2);
      boolean bool;
      if (localObject1 == null) {
        break label190;
      }
    }
    finally
    {
      try
      {
        if (((Cursor)localObject1).moveToFirst())
        {
          localArrayList = new ArrayList();
          do
          {
            localArrayList.add(((Cursor)localObject1).getString(0));
            bool = ((Cursor)localObject1).moveToNext();
          } while (bool);
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        AppMethodBeat.o(126977);
        return localArrayList;
      }
      finally
      {
        break label180;
      }
      localObject2 = finally;
      localObject1 = null;
    }
    label180:
    ((Cursor)localObject1).close();
    label190:
    AppMethodBeat.o(126977);
    throw localObject2;
  }
  
  public final boolean b(s params)
  {
    AppMethodBeat.i(126968);
    if (params == null)
    {
      AppMethodBeat.o(126968);
      return false;
    }
    params.drx = -1;
    ContentValues localContentValues = params.convertTo();
    if ((int)this.hpA.a("videoinfo2", "filename", localContentValues) != -1)
    {
      params = new t.a.a(params.getFileName(), t.a.b.ibe, t.a.c.ibi, params.iaP, params.hYX);
      this.huf.dS(params);
      this.huf.doNotify();
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
        break label65;
      }
      bool = true;
      label28:
      Assert.assertTrue(bool);
      localObject = params.convertTo();
      if (((ContentValues)localObject).size() > 0) {
        break label70;
      }
      ac.e("MicroMsg.VideoInfoStorage", "update failed, no values set");
    }
    label65:
    label70:
    while (this.hpA.update("videoinfo2", (ContentValues)localObject, "filename= ?", new String[] { params.getFileName() }) <= 0)
    {
      AppMethodBeat.o(126973);
      return false;
      bool = false;
      break;
      bool = false;
      break label28;
    }
    Object localObject = t.a.c.ibi;
    if (params.status == 112) {}
    for (localObject = t.a.c.ibk;; localObject = t.a.c.ibj) {
      do
      {
        params = new t.a.a(params.getFileName(), t.a.b.ibg, (t.a.c)localObject, params.iaP, params.hYX);
        this.huf.dS(params);
        this.huf.doNotify();
        AppMethodBeat.o(126973);
        return true;
      } while ((params.status != 103) && (params.status != 104));
    }
  }
  
  public final List<s> qs(long paramLong)
  {
    AppMethodBeat.i(126970);
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat,videoinfo2.forward_msg_local_id,videoinfo2.msg_uuid from videoinfo2   where videoinfo2.masssendid = ".concat(String.valueOf(paramLong));
    localObject = this.hpA.a((String)localObject, null, 2);
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
  
  public final boolean r(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(126985);
    boolean bool = bx(paramString1, paramString2 + "##" + paramString3);
    AppMethodBeat.o(126985);
    return bool;
  }
  
  /* Error */
  public final List<s> z(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 710
    //   3: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 157	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 712
    //   13: invokespecial 306	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: iload_1
    //   17: invokevirtual 326	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc_w 714
    //   23: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: lload_2
    //   27: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: ldc_w 716
    //   33: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 5
    //   41: aload_0
    //   42: getfield 123	com/tencent/mm/modelvideo/t:hpA	Lcom/tencent/mm/storagebase/h;
    //   45: aload 5
    //   47: aconst_null
    //   48: iconst_2
    //   49: invokevirtual 408	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   52: astore 6
    //   54: aload 6
    //   56: astore 7
    //   58: aload 6
    //   60: invokeinterface 543 1 0
    //   65: ifeq +194 -> 259
    //   68: aload 6
    //   70: astore 7
    //   72: new 579	java/util/ArrayList
    //   75: dup
    //   76: invokespecial 580	java/util/ArrayList:<init>	()V
    //   79: astore 5
    //   81: aload 6
    //   83: astore 7
    //   85: new 545	com/tencent/mm/modelvideo/s
    //   88: dup
    //   89: invokespecial 546	com/tencent/mm/modelvideo/s:<init>	()V
    //   92: astore 8
    //   94: aload 6
    //   96: astore 7
    //   98: aload 8
    //   100: aload 6
    //   102: invokevirtual 550	com/tencent/mm/modelvideo/s:convertFrom	(Landroid/database/Cursor;)V
    //   105: aload 6
    //   107: astore 7
    //   109: aload 5
    //   111: aload 8
    //   113: invokeinterface 583 2 0
    //   118: pop
    //   119: aload 6
    //   121: astore 7
    //   123: aload 6
    //   125: invokeinterface 416 1 0
    //   130: istore 4
    //   132: iload 4
    //   134: ifne -53 -> 81
    //   137: aload 5
    //   139: astore 7
    //   141: aload 6
    //   143: ifnull +14 -> 157
    //   146: aload 6
    //   148: invokeinterface 436 1 0
    //   153: aload 5
    //   155: astore 7
    //   157: ldc_w 710
    //   160: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload 7
    //   165: areturn
    //   166: astore 8
    //   168: aconst_null
    //   169: astore 5
    //   171: aconst_null
    //   172: astore 6
    //   174: aload 6
    //   176: astore 7
    //   178: ldc 235
    //   180: aload 8
    //   182: ldc_w 718
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 557	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload 5
    //   194: astore 7
    //   196: aload 6
    //   198: ifnull -41 -> 157
    //   201: aload 6
    //   203: invokeinterface 436 1 0
    //   208: aload 5
    //   210: astore 7
    //   212: goto -55 -> 157
    //   215: astore 5
    //   217: aconst_null
    //   218: astore 7
    //   220: aload 7
    //   222: ifnull +10 -> 232
    //   225: aload 7
    //   227: invokeinterface 436 1 0
    //   232: ldc_w 710
    //   235: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload 5
    //   240: athrow
    //   241: astore 5
    //   243: goto -23 -> 220
    //   246: astore 8
    //   248: aconst_null
    //   249: astore 5
    //   251: goto -77 -> 174
    //   254: astore 8
    //   256: goto -82 -> 174
    //   259: aconst_null
    //   260: astore 5
    //   262: goto -125 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	t
    //   0	265	1	paramInt	int
    //   0	265	2	paramLong	long
    //   130	3	4	bool	boolean
    //   39	170	5	localObject1	Object
    //   215	24	5	localObject2	Object
    //   241	1	5	localObject3	Object
    //   249	12	5	localObject4	Object
    //   52	150	6	localCursor	Cursor
    //   56	170	7	localObject5	Object
    //   92	20	8	locals	s
    //   166	15	8	localException1	Exception
    //   246	1	8	localException2	Exception
    //   254	1	8	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   41	54	166	java/lang/Exception
    //   41	54	215	finally
    //   58	68	241	finally
    //   72	81	241	finally
    //   85	94	241	finally
    //   98	105	241	finally
    //   109	119	241	finally
    //   123	132	241	finally
    //   178	192	241	finally
    //   58	68	246	java/lang/Exception
    //   72	81	246	java/lang/Exception
    //   85	94	254	java/lang/Exception
    //   98	105	254	java/lang/Exception
    //   109	119	254	java/lang/Exception
    //   123	132	254	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public static final class a
    {
      public final String fileName;
      public final long hYX;
      public final int iaP;
      public final t.a.b ibc;
      public final t.a.c ibd;
      
      public a(String paramString, t.a.b paramb, t.a.c paramc, int paramInt, long paramLong)
      {
        this.fileName = paramString;
        this.ibc = paramb;
        this.ibd = paramc;
        this.iaP = paramInt;
        this.hYX = paramLong;
      }
    }
    
    public static enum b
    {
      static
      {
        AppMethodBeat.i(126961);
        ibe = new b("INSERT", 0);
        ibf = new b("DELETE", 1);
        ibg = new b("UPDATE", 2);
        ibh = new b[] { ibe, ibf, ibg };
        AppMethodBeat.o(126961);
      }
      
      private b() {}
    }
    
    public static enum c
    {
      static
      {
        AppMethodBeat.i(126964);
        ibi = new c("NORMAL", 0);
        ibj = new c("UPLOAD", 1);
        ibk = new c("DOWNLOAD", 2);
        ibl = new c[] { ibi, ibj, ibk };
        AppMethodBeat.o(126964);
      }
      
      private c() {}
    }
  }
  
  public static final class b
  {
    public byte[] buf = null;
    public int cWy = 0;
    public int ibm = 0;
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.t
 * JD-Core Version:    0.7.0.1
 */