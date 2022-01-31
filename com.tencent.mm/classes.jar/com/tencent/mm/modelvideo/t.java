package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import junit.framework.Assert;

public final class t
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS videoinfo2 ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "CREATE INDEX IF NOT EXISTS  video_status_index ON videoinfo2 ( status,downloadtime )", "CREATE TABLE IF NOT EXISTS videoinfo ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "alter table videoinfo2 add videofuncflag int ;", "alter table videoinfo2 add masssendid long default 0;", "alter table videoinfo2 add masssendlist text ;", "alter table videoinfo2 add videomd5 text ;", "alter table videoinfo2 add streamvideo byte[] ;", "alter table videoinfo2 add statextstr text ;", "alter table videoinfo2 add downloadscene int ;", "alter table videoinfo2 add mmsightextinfo byte[] ;", "alter table videoinfo2 add preloadsize int ;", "alter table videoinfo2 add videoformat int ;", "alter table videoinfo add videofuncflag int ;", "alter table videoinfo add masssendid long default 0;", "alter table videoinfo add masssendlist text ;", "alter table videoinfo add videomd5 text ;", "alter table videoinfo add streamvideo byte[] ;", "alter table videoinfo add statextstr text ;", "alter table videoinfo add downloadscene int ;", "alter table videoinfo add mmsightextinfo byte[] ;", "alter table videoinfo add preloadsize int ;", "alter table videoinfo add videoformat int ;", "insert into videoinfo2 select * from videoinfo ;", "delete from videoinfo ;", "CREATE INDEX IF NOT EXISTS  massSendIdIndex ON videoinfo2 ( masssendid )", "CREATE INDEX IF NOT EXISTS  LastModifyTimeIndex ON videoinfo2 ( lastmodifytime )", "CREATE TABLE IF NOT EXISTS  VideoHash  (size int , CreateTime long, hash text ,  cdnxml text, orgpath text);", "CREATE INDEX IF NOT EXISTS  VideoHashSizeIndex ON VideoHash ( size  )", "CREATE INDEX IF NOT EXISTS  VideoHashTimeIndex ON VideoHash ( CreateTime  )" };
  private static long fXI = 0L;
  public com.tencent.mm.cg.h fnw;
  l<t.a, a.a> frK;
  
  public t(com.tencent.mm.cg.h paramh)
  {
    AppMethodBeat.i(50800);
    this.frK = new t.1(this);
    this.fnw = paramh;
    AppMethodBeat.o(50800);
  }
  
  /* Error */
  public static int a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 119
    //   2: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 125	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +44 -> 53
    //   12: ldc 127
    //   14: new 129	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 131
    //   20: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   26: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 146
    //   31: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 155	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: invokestatic 159	com/tencent/mm/compatible/util/g:getLine	()I
    //   43: istore_1
    //   44: ldc 119
    //   46: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_0
    //   50: iload_1
    //   51: isub
    //   52: ireturn
    //   53: iload_1
    //   54: ifge +57 -> 111
    //   57: ldc 127
    //   59: new 129	java/lang/StringBuilder
    //   62: dup
    //   63: ldc 131
    //   65: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   71: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 161
    //   76: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 163
    //   85: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_1
    //   89: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 155	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: invokestatic 159	com/tencent/mm/compatible/util/g:getLine	()I
    //   101: istore_1
    //   102: ldc 119
    //   104: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_0
    //   108: iload_1
    //   109: isub
    //   110: ireturn
    //   111: aload_2
    //   112: invokestatic 170	com/tencent/mm/sdk/platformtools/bo:ce	([B)Z
    //   115: ifeq +53 -> 168
    //   118: ldc 127
    //   120: new 129	java/lang/StringBuilder
    //   123: dup
    //   124: ldc 131
    //   126: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   132: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 161
    //   137: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 172
    //   146: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 155	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: invokestatic 159	com/tencent/mm/compatible/util/g:getLine	()I
    //   158: istore_1
    //   159: ldc 119
    //   161: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: iconst_0
    //   165: iload_1
    //   166: isub
    //   167: ireturn
    //   168: new 174	com/tencent/mm/compatible/util/g$a
    //   171: dup
    //   172: invokespecial 175	com/tencent/mm/compatible/util/g$a:<init>	()V
    //   175: astore 14
    //   177: new 177	java/io/RandomAccessFile
    //   180: dup
    //   181: aload_0
    //   182: ldc 179
    //   184: invokespecial 181	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: astore 13
    //   189: aload 13
    //   191: astore 12
    //   193: aload 14
    //   195: invokevirtual 185	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   198: lstore 4
    //   200: aload 13
    //   202: astore 12
    //   204: aload 13
    //   206: iload_1
    //   207: i2l
    //   208: invokevirtual 189	java/io/RandomAccessFile:seek	(J)V
    //   211: aload 13
    //   213: astore 12
    //   215: aload 14
    //   217: invokevirtual 185	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   220: lstore 6
    //   222: aload 13
    //   224: astore 12
    //   226: aload 13
    //   228: aload_2
    //   229: iconst_0
    //   230: aload_2
    //   231: arraylength
    //   232: invokevirtual 193	java/io/RandomAccessFile:write	([BII)V
    //   235: aload 13
    //   237: astore 12
    //   239: aload 14
    //   241: invokevirtual 185	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   244: lstore 8
    //   246: aload 13
    //   248: astore 12
    //   250: aload 13
    //   252: invokevirtual 196	java/io/RandomAccessFile:getFilePointer	()J
    //   255: l2i
    //   256: istore_3
    //   257: aload 13
    //   259: astore 12
    //   261: aload 14
    //   263: invokevirtual 185	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   266: lstore 10
    //   268: aload 13
    //   270: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   273: ldc 127
    //   275: new 129	java/lang/StringBuilder
    //   278: dup
    //   279: ldc 201
    //   281: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   284: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   287: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc 161
    //   292: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_0
    //   296: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc 203
    //   301: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: iload_1
    //   305: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc 205
    //   310: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_2
    //   314: arraylength
    //   315: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: ldc 127
    //   326: new 129	java/lang/StringBuilder
    //   329: dup
    //   330: ldc 201
    //   332: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   335: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   338: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: ldc 161
    //   343: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_0
    //   347: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc 210
    //   352: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: lload 4
    //   357: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   360: ldc 215
    //   362: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: lload 6
    //   367: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   370: ldc 217
    //   372: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: lload 8
    //   377: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: ldc 219
    //   382: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: lload 10
    //   387: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   390: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: ldc 119
    //   398: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: iload_3
    //   402: ireturn
    //   403: astore 14
    //   405: aconst_null
    //   406: astore_2
    //   407: aload_2
    //   408: astore 12
    //   410: ldc 127
    //   412: new 129	java/lang/StringBuilder
    //   415: dup
    //   416: ldc 131
    //   418: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   421: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   424: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: ldc 161
    //   429: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_0
    //   433: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: ldc 221
    //   438: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: iload_1
    //   442: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: ldc 223
    //   447: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 14
    //   452: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   455: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: ldc 228
    //   460: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 155	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: aload_2
    //   470: astore 12
    //   472: invokestatic 159	com/tencent/mm/compatible/util/g:getLine	()I
    //   475: istore_1
    //   476: aload_2
    //   477: ifnull +7 -> 484
    //   480: aload_2
    //   481: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   484: ldc 119
    //   486: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   489: iconst_0
    //   490: iload_1
    //   491: isub
    //   492: ireturn
    //   493: astore_0
    //   494: aconst_null
    //   495: astore 12
    //   497: aload 12
    //   499: ifnull +8 -> 507
    //   502: aload 12
    //   504: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   507: ldc 119
    //   509: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   512: aload_0
    //   513: athrow
    //   514: astore 12
    //   516: goto -243 -> 273
    //   519: astore_0
    //   520: goto -36 -> 484
    //   523: astore_2
    //   524: goto -17 -> 507
    //   527: astore_0
    //   528: goto -31 -> 497
    //   531: astore 14
    //   533: aload 13
    //   535: astore_2
    //   536: goto -129 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	539	0	paramString	String
    //   0	539	1	paramInt	int
    //   0	539	2	paramArrayOfByte	byte[]
    //   256	146	3	i	int
    //   198	158	4	l1	long
    //   220	146	6	l2	long
    //   244	132	8	l3	long
    //   266	120	10	l4	long
    //   191	312	12	localObject	Object
    //   514	1	12	localException1	Exception
    //   187	347	13	localRandomAccessFile	java.io.RandomAccessFile
    //   175	87	14	locala	com.tencent.mm.compatible.util.g.a
    //   403	48	14	localException2	Exception
    //   531	1	14	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   177	189	403	java/lang/Exception
    //   177	189	493	finally
    //   268	273	514	java/lang/Exception
    //   480	484	519	java/lang/Exception
    //   502	507	523	java/lang/Exception
    //   193	200	527	finally
    //   204	211	527	finally
    //   215	222	527	finally
    //   226	235	527	finally
    //   239	246	527	finally
    //   250	257	527	finally
    //   261	268	527	finally
    //   410	469	527	finally
    //   472	476	527	finally
    //   193	200	531	java/lang/Exception
    //   204	211	531	java/lang/Exception
    //   215	222	531	java/lang/Exception
    //   226	235	531	java/lang/Exception
    //   239	246	531	java/lang/Exception
    //   250	257	531	java/lang/Exception
    //   261	268	531	java/lang/Exception
  }
  
  private boolean aZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(50820);
    ab.i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", new Object[] { paramString1, paramString2, bo.dtY() });
    long l1 = bo.aoy();
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      ab.e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(50820);
      return false;
    }
    Object localObject = vi(paramString1);
    if ((localObject == null) || (localObject.length < 33))
    {
      ab.e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", new Object[] { paramString1 });
      AppMethodBeat.o(50820);
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
    localObject = this.fnw.a("select cdnxml from VideoHash where size = " + j + " and hash = \"" + localStringBuffer.toString() + "\"", null, 2);
    Vector localVector = new Vector();
    while (((Cursor)localObject).moveToNext())
    {
      localVector.add(((Cursor)localObject).getString(0));
      ab.v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", new Object[] { Integer.valueOf(localVector.size()), localVector.get(localVector.size() - 1) });
    }
    ((Cursor)localObject).close();
    if ((localVector.size() == 1) && (paramString2.equals(localVector.get(0))))
    {
      ab.w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", new Object[] { Long.valueOf(bo.hl(l1)), paramString1, paramString2 });
      AppMethodBeat.o(50820);
      return true;
    }
    if (localVector.size() > 0)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(12696, new Object[] { Integer.valueOf(102), Integer.valueOf(j), "", "", Integer.valueOf(localVector.size()) });
      ab.e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", new Object[] { Integer.valueOf(localVector.size()), Integer.valueOf(j) });
      this.fnw.execSQL("VideoHash", "delete from VideoHash where size = " + j + " and hash = \"" + localStringBuffer.toString() + "\"");
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("size", Integer.valueOf(j));
    ((ContentValues)localObject).put("CreateTime", Long.valueOf(bo.aox()));
    ((ContentValues)localObject).put("hash", localStringBuffer.toString());
    ((ContentValues)localObject).put("cdnxml", paramString2);
    ((ContentValues)localObject).put("orgpath", paramString1);
    long l2 = this.fnw.a("VideoHash", "", (ContentValues)localObject);
    ab.i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", new Object[] { Long.valueOf(bo.hl(l1)), Long.valueOf(l2), paramString1, localStringBuffer, paramString2 });
    if (l2 < 0L)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(12696, new Object[] { Integer.valueOf(103), Integer.valueOf(j) });
      ab.e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", new Object[] { Long.valueOf(l2), paramString1 });
    }
    AppMethodBeat.o(50820);
    return true;
  }
  
  private static String getVideoPath()
  {
    AppMethodBeat.i(50812);
    String str = com.tencent.mm.kernel.g.RL().eHR + "video/";
    AppMethodBeat.o(50812);
    return str;
  }
  
  /* Error */
  public static t.b u(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 398
    //   5: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 14	com/tencent/mm/modelvideo/t$b
    //   11: dup
    //   12: invokespecial 399	com/tencent/mm/modelvideo/t$b:<init>	()V
    //   15: astore 16
    //   17: aload_0
    //   18: invokestatic 125	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   21: ifeq +50 -> 71
    //   24: ldc 127
    //   26: new 129	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 131
    //   32: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   38: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 146
    //   43: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 155	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload 16
    //   54: iconst_0
    //   55: invokestatic 159	com/tencent/mm/compatible/util/g:getLine	()I
    //   58: isub
    //   59: putfield 403	com/tencent/mm/modelvideo/t$b:ret	I
    //   62: ldc_w 398
    //   65: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload 16
    //   70: areturn
    //   71: iload_1
    //   72: ifge +64 -> 136
    //   75: ldc 127
    //   77: new 129	java/lang/StringBuilder
    //   80: dup
    //   81: ldc 131
    //   83: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   89: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 161
    //   94: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 405
    //   104: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: iload_1
    //   108: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 155	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 16
    //   119: iconst_0
    //   120: invokestatic 159	com/tencent/mm/compatible/util/g:getLine	()I
    //   123: isub
    //   124: putfield 403	com/tencent/mm/modelvideo/t$b:ret	I
    //   127: ldc_w 398
    //   130: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload 16
    //   135: areturn
    //   136: iload_2
    //   137: ifgt +60 -> 197
    //   140: ldc 127
    //   142: new 129	java/lang/StringBuilder
    //   145: dup
    //   146: ldc 131
    //   148: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   154: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 161
    //   159: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 407
    //   169: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 155	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload 16
    //   180: iconst_0
    //   181: invokestatic 159	com/tencent/mm/compatible/util/g:getLine	()I
    //   184: isub
    //   185: putfield 403	com/tencent/mm/modelvideo/t$b:ret	I
    //   188: ldc_w 398
    //   191: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload 16
    //   196: areturn
    //   197: new 174	com/tencent/mm/compatible/util/g$a
    //   200: dup
    //   201: invokespecial 175	com/tencent/mm/compatible/util/g$a:<init>	()V
    //   204: astore 15
    //   206: aload 16
    //   208: iload_2
    //   209: newarray byte
    //   211: putfield 411	com/tencent/mm/modelvideo/t$b:buf	[B
    //   214: new 177	java/io/RandomAccessFile
    //   217: dup
    //   218: aload_0
    //   219: ldc_w 413
    //   222: invokespecial 181	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: astore 14
    //   227: aload 14
    //   229: astore 13
    //   231: aload 15
    //   233: invokevirtual 185	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   236: lstore 5
    //   238: aload 14
    //   240: astore 13
    //   242: aload 14
    //   244: iload_1
    //   245: i2l
    //   246: invokevirtual 189	java/io/RandomAccessFile:seek	(J)V
    //   249: aload 14
    //   251: astore 13
    //   253: aload 15
    //   255: invokevirtual 185	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   258: lstore 7
    //   260: aload 14
    //   262: astore 13
    //   264: aload 14
    //   266: aload 16
    //   268: getfield 411	com/tencent/mm/modelvideo/t$b:buf	[B
    //   271: iconst_0
    //   272: iload_2
    //   273: invokevirtual 417	java/io/RandomAccessFile:read	([BII)I
    //   276: istore 4
    //   278: aload 14
    //   280: astore 13
    //   282: aload 15
    //   284: invokevirtual 185	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   287: lstore 9
    //   289: aload 14
    //   291: astore 13
    //   293: aload 15
    //   295: invokevirtual 185	com/tencent/mm/compatible/util/g$a:Mm	()J
    //   298: lstore 11
    //   300: iload 4
    //   302: ifge +312 -> 614
    //   305: aload 14
    //   307: astore 13
    //   309: aload 16
    //   311: iload_3
    //   312: putfield 420	com/tencent/mm/modelvideo/t$b:ckj	I
    //   315: aload 14
    //   317: astore 13
    //   319: aload 16
    //   321: iload_3
    //   322: iload_1
    //   323: iadd
    //   324: putfield 423	com/tencent/mm/modelvideo/t$b:fXX	I
    //   327: aload 14
    //   329: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   332: ldc 127
    //   334: new 129	java/lang/StringBuilder
    //   337: dup
    //   338: ldc 201
    //   340: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   343: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   346: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc 161
    //   351: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_0
    //   355: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: ldc 203
    //   360: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: iload_1
    //   364: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: ldc_w 425
    //   370: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload_2
    //   374: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   377: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: ldc 127
    //   385: new 129	java/lang/StringBuilder
    //   388: dup
    //   389: ldc 201
    //   391: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   397: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc 161
    //   402: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload_0
    //   406: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: ldc 210
    //   411: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: lload 5
    //   416: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   419: ldc 215
    //   421: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: lload 7
    //   426: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   429: ldc 217
    //   431: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: lload 9
    //   436: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   439: ldc 219
    //   441: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: lload 11
    //   446: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   449: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 208	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   455: ldc_w 398
    //   458: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   461: aload 16
    //   463: areturn
    //   464: astore 15
    //   466: aconst_null
    //   467: astore 14
    //   469: aload 14
    //   471: astore 13
    //   473: ldc 127
    //   475: new 129	java/lang/StringBuilder
    //   478: dup
    //   479: ldc 131
    //   481: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   484: invokestatic 140	com/tencent/mm/compatible/util/g:Ml	()Ljava/lang/String;
    //   487: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: ldc 161
    //   492: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_0
    //   496: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: ldc 221
    //   501: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload 16
    //   506: getfield 423	com/tencent/mm/modelvideo/t$b:fXX	I
    //   509: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: ldc 223
    //   514: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload 15
    //   519: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   522: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc 228
    //   527: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 155	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: aload 14
    //   538: astore 13
    //   540: aload 16
    //   542: iconst_0
    //   543: invokestatic 159	com/tencent/mm/compatible/util/g:getLine	()I
    //   546: isub
    //   547: putfield 403	com/tencent/mm/modelvideo/t$b:ret	I
    //   550: aload 14
    //   552: ifnull +8 -> 560
    //   555: aload 14
    //   557: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   560: ldc_w 398
    //   563: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   566: aload 16
    //   568: areturn
    //   569: astore_0
    //   570: aconst_null
    //   571: astore 13
    //   573: aload 13
    //   575: ifnull +8 -> 583
    //   578: aload 13
    //   580: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   583: ldc_w 398
    //   586: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   589: aload_0
    //   590: athrow
    //   591: astore 13
    //   593: goto -261 -> 332
    //   596: astore_0
    //   597: goto -37 -> 560
    //   600: astore 13
    //   602: goto -19 -> 583
    //   605: astore_0
    //   606: goto -33 -> 573
    //   609: astore 15
    //   611: goto -142 -> 469
    //   614: iload 4
    //   616: istore_3
    //   617: goto -312 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	620	0	paramString	String
    //   0	620	1	paramInt1	int
    //   0	620	2	paramInt2	int
    //   1	616	3	i	int
    //   276	339	4	j	int
    //   236	179	5	l1	long
    //   258	167	7	l2	long
    //   287	148	9	l3	long
    //   298	147	11	l4	long
    //   229	350	13	localRandomAccessFile1	java.io.RandomAccessFile
    //   591	1	13	localException1	Exception
    //   600	1	13	localException2	Exception
    //   225	331	14	localRandomAccessFile2	java.io.RandomAccessFile
    //   204	90	15	locala	com.tencent.mm.compatible.util.g.a
    //   464	54	15	localException3	Exception
    //   609	1	15	localException4	Exception
    //   15	552	16	localb	t.b
    // Exception table:
    //   from	to	target	type
    //   214	227	464	java/lang/Exception
    //   214	227	569	finally
    //   327	332	591	java/lang/Exception
    //   555	560	596	java/lang/Exception
    //   578	583	600	java/lang/Exception
    //   231	238	605	finally
    //   242	249	605	finally
    //   253	260	605	finally
    //   264	278	605	finally
    //   282	289	605	finally
    //   293	300	605	finally
    //   309	315	605	finally
    //   319	327	605	finally
    //   473	536	605	finally
    //   540	550	605	finally
    //   231	238	609	java/lang/Exception
    //   242	249	609	java/lang/Exception
    //   253	260	609	java/lang/Exception
    //   264	278	609	java/lang/Exception
    //   282	289	609	java/lang/Exception
    //   293	300	609	java/lang/Exception
    //   309	315	609	java/lang/Exception
    //   319	327	609	java/lang/Exception
  }
  
  public static String ve(String paramString)
  {
    AppMethodBeat.i(50811);
    long l = System.currentTimeMillis();
    String str2 = new SimpleDateFormat("HHmmssddMMyy").format(new Date(l));
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.length() > 1) {
        str1 = str2 + com.tencent.mm.a.g.w(paramString.getBytes()).substring(0, 7);
      }
    }
    paramString = str1 + l % 10000L;
    paramString = new StringBuilder().append(paramString);
    l = fXI;
    fXI = 1L + l;
    paramString = l;
    AppMethodBeat.o(50811);
    return paramString;
  }
  
  public static String vf(String paramString)
  {
    AppMethodBeat.i(50813);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50813);
      return null;
    }
    paramString = getVideoPath() + paramString;
    if (com.tencent.mm.vfs.e.cN(paramString))
    {
      AppMethodBeat.o(50813);
      return paramString;
    }
    paramString = paramString + ".mp4";
    AppMethodBeat.o(50813);
    return paramString;
  }
  
  public static String vg(String paramString)
  {
    AppMethodBeat.i(50814);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50814);
      return null;
    }
    paramString = getVideoPath() + paramString + ".jpg";
    AppMethodBeat.o(50814);
    return paramString;
  }
  
  public static int vh(String paramString)
  {
    AppMethodBeat.i(50817);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(50817);
      return -1;
    }
    paramString = new b(paramString);
    if (!paramString.exists())
    {
      AppMethodBeat.o(50817);
      return 0;
    }
    int i = (int)paramString.length();
    if (i <= 0)
    {
      AppMethodBeat.o(50817);
      return 0;
    }
    AppMethodBeat.o(50817);
    return i;
  }
  
  /* Error */
  static int[] vi(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc_w 491
    //   5: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: bipush 33
    //   10: newarray int
    //   12: astore 10
    //   14: invokestatic 243	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   17: lstore 4
    //   19: aload_0
    //   20: invokestatic 495	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   23: l2i
    //   24: istore_2
    //   25: iload_2
    //   26: ldc_w 496
    //   29: if_icmplt +10 -> 39
    //   32: iload_2
    //   33: ldc_w 497
    //   36: if_icmplt +82 -> 118
    //   39: ldc 127
    //   41: ldc_w 499
    //   44: iconst_2
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: iload_2
    //   51: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: aload_0
    //   58: aastore
    //   59: invokestatic 247	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: getstatic 333	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   65: astore_0
    //   66: iload_2
    //   67: ldc_w 496
    //   70: if_icmpge +42 -> 112
    //   73: bipush 10
    //   75: istore_1
    //   76: aload_0
    //   77: sipush 12696
    //   80: iconst_2
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: iload_1
    //   87: bipush 101
    //   89: iadd
    //   90: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: iload_2
    //   97: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: aastore
    //   101: invokevirtual 338	com/tencent/mm/plugin/report/service/h:e	(I[Ljava/lang/Object;)V
    //   104: ldc_w 491
    //   107: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: aconst_null
    //   111: areturn
    //   112: bipush 20
    //   114: istore_1
    //   115: goto -39 -> 76
    //   118: aload 10
    //   120: bipush 32
    //   122: iload_2
    //   123: iastore
    //   124: iload_2
    //   125: sipush 20480
    //   128: isub
    //   129: bipush 32
    //   131: idiv
    //   132: istore_3
    //   133: sipush 512
    //   136: newarray byte
    //   138: astore 11
    //   140: new 177	java/io/RandomAccessFile
    //   143: dup
    //   144: aload_0
    //   145: ldc_w 413
    //   148: invokespecial 181	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: astore 9
    //   153: iload_1
    //   154: bipush 32
    //   156: if_icmpge +66 -> 222
    //   159: iload_1
    //   160: iload_3
    //   161: imul
    //   162: sipush 10240
    //   165: iadd
    //   166: i2l
    //   167: lstore 6
    //   169: aload 9
    //   171: astore 8
    //   173: aload 9
    //   175: lload 6
    //   177: invokevirtual 189	java/io/RandomAccessFile:seek	(J)V
    //   180: aload 9
    //   182: astore 8
    //   184: aload 9
    //   186: aload 11
    //   188: invokevirtual 503	java/io/RandomAccessFile:readFully	([B)V
    //   191: aload 9
    //   193: astore 8
    //   195: aload 10
    //   197: iload_1
    //   198: aload 11
    //   200: sipush 512
    //   203: invokestatic 509	com/tencent/mm/a/i:q	([BI)I
    //   206: ldc_w 510
    //   209: irem
    //   210: ldc_w 510
    //   213: ior
    //   214: iastore
    //   215: iload_1
    //   216: iconst_1
    //   217: iadd
    //   218: istore_1
    //   219: goto -66 -> 153
    //   222: aload 9
    //   224: astore 8
    //   226: aload 9
    //   228: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   231: aload 9
    //   233: astore 8
    //   235: ldc 127
    //   237: ldc_w 512
    //   240: iconst_3
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: lload 4
    //   248: invokestatic 319	com/tencent/mm/sdk/platformtools/bo:hl	(J)J
    //   251: invokestatic 324	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: iload_2
    //   258: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   261: aastore
    //   262: dup
    //   263: iconst_2
    //   264: aload_0
    //   265: aastore
    //   266: invokestatic 240	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: aload 9
    //   271: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   274: ldc_w 491
    //   277: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload 10
    //   282: areturn
    //   283: astore 10
    //   285: aconst_null
    //   286: astore 9
    //   288: aload 9
    //   290: astore 8
    //   292: ldc 127
    //   294: ldc_w 514
    //   297: iconst_2
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: aload_0
    //   304: aastore
    //   305: dup
    //   306: iconst_1
    //   307: aload 10
    //   309: invokestatic 518	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   312: aastore
    //   313: invokestatic 247	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: aload 9
    //   318: ifnull +8 -> 326
    //   321: aload 9
    //   323: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   326: ldc_w 491
    //   329: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   332: aconst_null
    //   333: areturn
    //   334: astore_0
    //   335: aconst_null
    //   336: astore 8
    //   338: aload 8
    //   340: ifnull +8 -> 348
    //   343: aload 8
    //   345: invokevirtual 199	java/io/RandomAccessFile:close	()V
    //   348: ldc_w 491
    //   351: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aload_0
    //   355: athrow
    //   356: astore_0
    //   357: goto -83 -> 274
    //   360: astore_0
    //   361: goto -35 -> 326
    //   364: astore 8
    //   366: goto -18 -> 348
    //   369: astore_0
    //   370: goto -32 -> 338
    //   373: astore 10
    //   375: goto -87 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramString	String
    //   1	218	1	i	int
    //   24	234	2	j	int
    //   132	30	3	k	int
    //   17	230	4	l1	long
    //   167	9	6	l2	long
    //   171	173	8	localRandomAccessFile1	java.io.RandomAccessFile
    //   364	1	8	localException1	Exception
    //   151	171	9	localRandomAccessFile2	java.io.RandomAccessFile
    //   12	269	10	arrayOfInt	int[]
    //   283	25	10	localException2	Exception
    //   373	1	10	localException3	Exception
    //   138	61	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   140	153	283	java/lang/Exception
    //   140	153	334	finally
    //   269	274	356	java/lang/Exception
    //   321	326	360	java/lang/Exception
    //   343	348	364	java/lang/Exception
    //   173	180	369	finally
    //   184	191	369	finally
    //   195	215	369	finally
    //   226	231	369	finally
    //   235	269	369	finally
    //   292	316	369	finally
    //   173	180	373	java/lang/Exception
    //   184	191	373	java/lang/Exception
    //   195	215	373	java/lang/Exception
    //   226	231	373	java/lang/Exception
    //   235	269	373	java/lang/Exception
  }
  
  public final void a(t.a parama)
  {
    AppMethodBeat.i(50799);
    this.frK.remove(parama);
    AppMethodBeat.o(50799);
  }
  
  public final void a(t.a parama, Looper paramLooper)
  {
    AppMethodBeat.i(50798);
    this.frK.a(parama, paramLooper);
    AppMethodBeat.o(50798);
  }
  
  public final List<s> alU()
  {
    AppMethodBeat.i(50804);
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=200 order by masssendid desc";
    ArrayList localArrayList = new ArrayList();
    localObject = this.fnw.a((String)localObject, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext())
    {
      s locals = new s();
      locals.convertFrom((Cursor)localObject);
      localArrayList.add(locals);
      i += 1;
    }
    ((Cursor)localObject).close();
    ab.d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:".concat(String.valueOf(i)));
    AppMethodBeat.o(50804);
    return localArrayList;
  }
  
  public final List<s> alV()
  {
    AppMethodBeat.i(50805);
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=198 AND masssendid > 0 order by masssendid desc";
    ArrayList localArrayList = new ArrayList();
    localObject = this.fnw.a((String)localObject, null, 2);
    while (((Cursor)localObject).moveToNext())
    {
      s locals = new s();
      locals.convertFrom((Cursor)localObject);
      localArrayList.add(locals);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(50805);
    return localArrayList;
  }
  
  public final List<String> alW()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(50807);
    Object localObject1 = "select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE status=112 ORDER BY downloadtime DESC " + " LIMIT 10";
    try
    {
      localObject1 = this.fnw.a((String)localObject1, null, 2);
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
        AppMethodBeat.o(50807);
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
    AppMethodBeat.o(50807);
    throw localObject2;
  }
  
  public final List<String> alX()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(50808);
    Object localObject1 = " SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=122" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " UNION SELECT * FROM ( ";
    localObject1 = (String)localObject1 + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=120" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " ORDER BY downloadtime DESC";
    try
    {
      localObject1 = this.fnw.a((String)localObject1, null, 2);
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
        AppMethodBeat.o(50808);
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
    AppMethodBeat.o(50808);
    throw localObject2;
  }
  
  public final List<String> alY()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(50810);
    Object localObject1 = " SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=103" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " UNION SELECT * FROM ( ";
    localObject1 = (String)localObject1 + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=104" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " ORDER BY downloadtime DESC";
    try
    {
      localObject1 = this.fnw.a((String)localObject1, null, 2);
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
        AppMethodBeat.o(50810);
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
    AppMethodBeat.o(50810);
    throw localObject2;
  }
  
  public final boolean b(s params)
  {
    AppMethodBeat.i(50801);
    if (params == null)
    {
      AppMethodBeat.o(50801);
      return false;
    }
    params.bsY = -1;
    ContentValues localContentValues = params.convertTo();
    if ((int)this.fnw.a("videoinfo2", "filename", localContentValues) != -1)
    {
      params = new a.a(params.getFileName(), t.a.b.fXP, a.c.fXT, params.fXE, params.fVM);
      this.frK.cy(params);
      this.frK.doNotify();
      AppMethodBeat.o(50801);
      return true;
    }
    AppMethodBeat.o(50801);
    return false;
  }
  
  public final boolean c(s params)
  {
    AppMethodBeat.i(50806);
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
      ab.e("MicroMsg.VideoInfoStorage", "update failed, no values set");
    }
    label65:
    label70:
    while (this.fnw.update("videoinfo2", (ContentValues)localObject, "filename= ?", new String[] { params.getFileName() }) <= 0)
    {
      AppMethodBeat.o(50806);
      return false;
      bool = false;
      break;
      bool = false;
      break label28;
    }
    Object localObject = a.c.fXT;
    if (params.status == 112) {}
    for (localObject = a.c.fXV;; localObject = a.c.fXU) {
      do
      {
        params = new a.a(params.getFileName(), t.a.b.fXR, (a.c)localObject, params.fXE, params.fVM);
        this.frK.cy(params);
        this.frK.doNotify();
        AppMethodBeat.o(50806);
        return true;
      } while ((params.status != 103) && (params.status != 104));
    }
  }
  
  public final List<s> he(long paramLong)
  {
    AppMethodBeat.i(50803);
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.masssendid = ".concat(String.valueOf(paramLong));
    localObject = this.fnw.a((String)localObject, null, 2);
    if (localObject == null)
    {
      AppMethodBeat.o(50803);
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
    AppMethodBeat.o(50803);
    return localArrayList;
  }
  
  public final boolean s(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(50818);
    boolean bool = aZ(paramString1, paramString2 + "##" + paramString3);
    AppMethodBeat.o(50818);
    return bool;
  }
  
  public final s vd(String paramString)
  {
    AppMethodBeat.i(50802);
    for (;;)
    {
      try
      {
        paramString = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.filename = \"" + bo.wC(String.valueOf(paramString)) + "\"";
        Cursor localCursor = this.fnw.a(paramString, null, 2);
        if (localCursor == null)
        {
          AppMethodBeat.o(50802);
          return null;
        }
        if (localCursor.moveToFirst())
        {
          paramString = new s();
          paramString.convertFrom(localCursor);
          localCursor.close();
          AppMethodBeat.o(50802);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.VideoInfoStorage", paramString, "getByFileName error[%s]", new Object[] { paramString.toString() });
        AppMethodBeat.o(50802);
        return null;
      }
      paramString = null;
    }
  }
  
  /* Error */
  public final List<s> x(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 703
    //   3: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 129	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 705
    //   13: invokespecial 134	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: iload_1
    //   17: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc_w 707
    //   23: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: lload_2
    //   27: invokevirtual 213	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: ldc_w 709
    //   33: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 5
    //   41: aload_0
    //   42: getfield 112	com/tencent/mm/modelvideo/t:fnw	Lcom/tencent/mm/cg/h;
    //   45: aload 5
    //   47: aconst_null
    //   48: iconst_2
    //   49: invokevirtual 277	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   52: astore 6
    //   54: aload 6
    //   56: astore 7
    //   58: aload 6
    //   60: invokeinterface 575 1 0
    //   65: ifeq +194 -> 259
    //   68: aload 6
    //   70: astore 7
    //   72: new 540	java/util/ArrayList
    //   75: dup
    //   76: invokespecial 541	java/util/ArrayList:<init>	()V
    //   79: astore 5
    //   81: aload 6
    //   83: astore 7
    //   85: new 543	com/tencent/mm/modelvideo/s
    //   88: dup
    //   89: invokespecial 544	com/tencent/mm/modelvideo/s:<init>	()V
    //   92: astore 8
    //   94: aload 6
    //   96: astore 7
    //   98: aload 8
    //   100: aload 6
    //   102: invokevirtual 548	com/tencent/mm/modelvideo/s:convertFrom	(Landroid/database/Cursor;)V
    //   105: aload 6
    //   107: astore 7
    //   109: aload 5
    //   111: aload 8
    //   113: invokeinterface 551 2 0
    //   118: pop
    //   119: aload 6
    //   121: astore 7
    //   123: aload 6
    //   125: invokeinterface 286 1 0
    //   130: istore 4
    //   132: iload 4
    //   134: ifne -53 -> 81
    //   137: aload 5
    //   139: astore 7
    //   141: aload 6
    //   143: ifnull +14 -> 157
    //   146: aload 6
    //   148: invokeinterface 310 1 0
    //   153: aload 5
    //   155: astore 7
    //   157: ldc_w 703
    //   160: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload 7
    //   165: areturn
    //   166: astore 8
    //   168: aconst_null
    //   169: astore 5
    //   171: aconst_null
    //   172: astore 6
    //   174: aload 6
    //   176: astore 7
    //   178: ldc 127
    //   180: aload 8
    //   182: ldc_w 711
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 700	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload 5
    //   194: astore 7
    //   196: aload 6
    //   198: ifnull -41 -> 157
    //   201: aload 6
    //   203: invokeinterface 310 1 0
    //   208: aload 5
    //   210: astore 7
    //   212: goto -55 -> 157
    //   215: astore 5
    //   217: aconst_null
    //   218: astore 7
    //   220: aload 7
    //   222: ifnull +10 -> 232
    //   225: aload 7
    //   227: invokeinterface 310 1 0
    //   232: ldc_w 703
    //   235: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static final class a$a
  {
    public final long fVM;
    public final int fXE;
    public final t.a.b fXN;
    public final t.a.c fXO;
    public final String fileName;
    
    public a$a(String paramString, t.a.b paramb, t.a.c paramc, int paramInt, long paramLong)
    {
      this.fileName = paramString;
      this.fXN = paramb;
      this.fXO = paramc;
      this.fXE = paramInt;
      this.fVM = paramLong;
    }
  }
  
  public static enum a$c
  {
    static
    {
      AppMethodBeat.i(50797);
      fXT = new c("NORMAL", 0);
      fXU = new c("UPLOAD", 1);
      fXV = new c("DOWNLOAD", 2);
      fXW = new c[] { fXT, fXU, fXV };
      AppMethodBeat.o(50797);
    }
    
    private a$c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.t
 * JD-Core Version:    0.7.0.1
 */