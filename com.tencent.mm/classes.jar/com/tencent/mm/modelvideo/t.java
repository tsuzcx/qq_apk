package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private static long hAw = 0L;
  public com.tencent.mm.storagebase.h gPa;
  l<a, t.a.a> gTG;
  
  public t(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(126967);
    this.gTG = new l() {};
    this.gPa = paramh;
    AppMethodBeat.o(126967);
  }
  
  /* Error */
  public static int a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 130
    //   2: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 136	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +44 -> 53
    //   12: ldc 138
    //   14: new 140	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 142
    //   20: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   26: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 157
    //   31: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: invokestatic 170	com/tencent/mm/compatible/util/f:getLine	()I
    //   43: istore_1
    //   44: ldc 130
    //   46: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_0
    //   50: iload_1
    //   51: isub
    //   52: ireturn
    //   53: iload_1
    //   54: ifge +57 -> 111
    //   57: ldc 138
    //   59: new 140	java/lang/StringBuilder
    //   62: dup
    //   63: ldc 142
    //   65: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   71: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 172
    //   76: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 174
    //   85: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_1
    //   89: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: invokestatic 170	com/tencent/mm/compatible/util/f:getLine	()I
    //   101: istore_1
    //   102: ldc 130
    //   104: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_0
    //   108: iload_1
    //   109: isub
    //   110: ireturn
    //   111: aload_2
    //   112: invokestatic 181	com/tencent/mm/sdk/platformtools/bt:cw	([B)Z
    //   115: ifeq +53 -> 168
    //   118: ldc 138
    //   120: new 140	java/lang/StringBuilder
    //   123: dup
    //   124: ldc 142
    //   126: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   132: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 172
    //   137: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 183
    //   146: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: invokestatic 170	com/tencent/mm/compatible/util/f:getLine	()I
    //   158: istore_1
    //   159: ldc 130
    //   161: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: iconst_0
    //   165: iload_1
    //   166: isub
    //   167: ireturn
    //   168: new 185	com/tencent/mm/compatible/util/f$a
    //   171: dup
    //   172: invokespecial 186	com/tencent/mm/compatible/util/f$a:<init>	()V
    //   175: astore 15
    //   177: aconst_null
    //   178: astore 13
    //   180: aconst_null
    //   181: astore 12
    //   183: aload_0
    //   184: iconst_1
    //   185: invokestatic 192	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   188: astore 14
    //   190: aload 14
    //   192: astore 12
    //   194: aload 14
    //   196: astore 13
    //   198: aload 15
    //   200: invokevirtual 196	com/tencent/mm/compatible/util/f$a:XK	()J
    //   203: lstore 4
    //   205: aload 14
    //   207: astore 12
    //   209: aload 14
    //   211: astore 13
    //   213: aload 14
    //   215: iload_1
    //   216: i2l
    //   217: invokevirtual 202	java/io/RandomAccessFile:seek	(J)V
    //   220: aload 14
    //   222: astore 12
    //   224: aload 14
    //   226: astore 13
    //   228: aload 15
    //   230: invokevirtual 196	com/tencent/mm/compatible/util/f$a:XK	()J
    //   233: lstore 6
    //   235: aload 14
    //   237: astore 12
    //   239: aload 14
    //   241: astore 13
    //   243: aload 14
    //   245: aload_2
    //   246: iconst_0
    //   247: aload_2
    //   248: arraylength
    //   249: invokevirtual 206	java/io/RandomAccessFile:write	([BII)V
    //   252: aload 14
    //   254: astore 12
    //   256: aload 14
    //   258: astore 13
    //   260: aload 15
    //   262: invokevirtual 196	com/tencent/mm/compatible/util/f$a:XK	()J
    //   265: lstore 8
    //   267: aload 14
    //   269: astore 12
    //   271: aload 14
    //   273: astore 13
    //   275: aload 14
    //   277: invokevirtual 209	java/io/RandomAccessFile:getFilePointer	()J
    //   280: l2i
    //   281: istore_3
    //   282: aload 14
    //   284: astore 12
    //   286: aload 14
    //   288: astore 13
    //   290: aload 15
    //   292: invokevirtual 196	com/tencent/mm/compatible/util/f$a:XK	()J
    //   295: lstore 10
    //   297: aload 14
    //   299: ifnull +8 -> 307
    //   302: aload 14
    //   304: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   307: ldc 138
    //   309: new 140	java/lang/StringBuilder
    //   312: dup
    //   313: ldc 214
    //   315: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   318: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   321: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 172
    //   326: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_0
    //   330: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: ldc 216
    //   335: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: iload_1
    //   339: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc 218
    //   344: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload_2
    //   348: arraylength
    //   349: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 221	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   358: ldc 138
    //   360: new 140	java/lang/StringBuilder
    //   363: dup
    //   364: ldc 214
    //   366: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   369: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   372: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: ldc 172
    //   377: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_0
    //   381: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc 223
    //   386: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: lload 4
    //   391: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   394: ldc 228
    //   396: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: lload 6
    //   401: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   404: ldc 230
    //   406: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: lload 8
    //   411: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   414: ldc 232
    //   416: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: lload 10
    //   421: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   424: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 221	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: ldc 130
    //   432: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   435: iload_3
    //   436: ireturn
    //   437: astore_2
    //   438: aload 12
    //   440: astore 13
    //   442: ldc 138
    //   444: new 140	java/lang/StringBuilder
    //   447: dup
    //   448: ldc 142
    //   450: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   453: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   456: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: ldc 172
    //   461: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: aload_0
    //   465: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: ldc 234
    //   470: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: iload_1
    //   474: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   477: ldc 236
    //   479: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_2
    //   483: invokevirtual 239	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   486: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: ldc 241
    //   491: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   500: aload 12
    //   502: astore 13
    //   504: invokestatic 170	com/tencent/mm/compatible/util/f:getLine	()I
    //   507: istore_1
    //   508: aload 12
    //   510: ifnull +8 -> 518
    //   513: aload 12
    //   515: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   518: ldc 130
    //   520: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   523: iconst_0
    //   524: iload_1
    //   525: isub
    //   526: ireturn
    //   527: astore_0
    //   528: aload 13
    //   530: ifnull +8 -> 538
    //   533: aload 13
    //   535: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   538: ldc 130
    //   540: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   543: aload_0
    //   544: athrow
    //   545: astore 12
    //   547: goto -240 -> 307
    //   550: astore_0
    //   551: goto -33 -> 518
    //   554: astore_2
    //   555: goto -17 -> 538
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	558	0	paramString	String
    //   0	558	1	paramInt	int
    //   0	558	2	paramArrayOfByte	byte[]
    //   281	155	3	i	int
    //   203	187	4	l1	long
    //   233	167	6	l2	long
    //   265	145	8	l3	long
    //   295	125	10	l4	long
    //   181	333	12	localObject1	Object
    //   545	1	12	localException	Exception
    //   178	356	13	localObject2	Object
    //   188	115	14	localRandomAccessFile	java.io.RandomAccessFile
    //   175	116	15	locala	com.tencent.mm.compatible.util.f.a
    // Exception table:
    //   from	to	target	type
    //   183	190	437	java/lang/Exception
    //   198	205	437	java/lang/Exception
    //   213	220	437	java/lang/Exception
    //   228	235	437	java/lang/Exception
    //   243	252	437	java/lang/Exception
    //   260	267	437	java/lang/Exception
    //   275	282	437	java/lang/Exception
    //   290	297	437	java/lang/Exception
    //   183	190	527	finally
    //   198	205	527	finally
    //   213	220	527	finally
    //   228	235	527	finally
    //   243	252	527	finally
    //   260	267	527	finally
    //   275	282	527	finally
    //   290	297	527	finally
    //   442	500	527	finally
    //   504	508	527	finally
    //   302	307	545	java/lang/Exception
    //   513	518	550	java/lang/Exception
    //   533	538	554	java/lang/Exception
  }
  
  private boolean bp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(126987);
    ad.i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", new Object[] { paramString1, paramString2, bt.eGN() });
    long l1 = bt.eGO();
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      ad.e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", new Object[] { paramString1, paramString2 });
      AppMethodBeat.o(126987);
      return false;
    }
    Object localObject = zT(paramString1);
    if ((localObject == null) || (localObject.length < 33))
    {
      ad.e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", new Object[] { paramString1 });
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
    localObject = this.gPa.a("select cdnxml from VideoHash where size = " + j + " and hash = \"" + localStringBuffer.toString() + "\"", null, 2);
    Vector localVector = new Vector();
    while (((Cursor)localObject).moveToNext())
    {
      localVector.add(((Cursor)localObject).getString(0));
      ad.v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", new Object[] { Integer.valueOf(localVector.size()), localVector.get(localVector.size() - 1) });
    }
    ((Cursor)localObject).close();
    if ((localVector.size() == 1) && (paramString2.equals(localVector.get(0))))
    {
      ad.w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", new Object[] { Long.valueOf(bt.vM(l1)), paramString1, paramString2 });
      AppMethodBeat.o(126987);
      return true;
    }
    if (localVector.size() > 0)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(12696, new Object[] { Integer.valueOf(102), Integer.valueOf(j), "", "", Integer.valueOf(localVector.size()) });
      ad.e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", new Object[] { Integer.valueOf(localVector.size()), Integer.valueOf(j) });
      this.gPa.execSQL("VideoHash", "delete from VideoHash where size = " + j + " and hash = \"" + localStringBuffer.toString() + "\"");
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("size", Integer.valueOf(j));
    ((ContentValues)localObject).put("CreateTime", Long.valueOf(bt.aGK()));
    ((ContentValues)localObject).put("hash", localStringBuffer.toString());
    ((ContentValues)localObject).put("cdnxml", paramString2);
    ((ContentValues)localObject).put("orgpath", paramString1);
    long l2 = this.gPa.a("VideoHash", "", (ContentValues)localObject);
    ad.i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", new Object[] { Long.valueOf(bt.vM(l1)), Long.valueOf(l2), paramString1, localStringBuffer, paramString2 });
    if (l2 < 0L)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(12696, new Object[] { Integer.valueOf(103), Integer.valueOf(j) });
      ad.e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", new Object[] { Long.valueOf(l2), paramString1 });
    }
    AppMethodBeat.o(126987);
    return true;
  }
  
  private static String getVideoPath()
  {
    AppMethodBeat.i(126979);
    String str = com.tencent.mm.kernel.g.afB().gcW + "video/";
    AppMethodBeat.o(126979);
    return str;
  }
  
  /* Error */
  public static b s(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc_w 412
    //   5: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 19	com/tencent/mm/modelvideo/t$b
    //   11: dup
    //   12: invokespecial 413	com/tencent/mm/modelvideo/t$b:<init>	()V
    //   15: astore 16
    //   17: aload_0
    //   18: invokestatic 136	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   21: ifeq +50 -> 71
    //   24: ldc 138
    //   26: new 140	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 142
    //   32: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   38: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 157
    //   43: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload 16
    //   54: iconst_0
    //   55: invokestatic 170	com/tencent/mm/compatible/util/f:getLine	()I
    //   58: isub
    //   59: putfield 417	com/tencent/mm/modelvideo/t$b:ret	I
    //   62: ldc_w 412
    //   65: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload 16
    //   70: areturn
    //   71: iload_1
    //   72: ifge +64 -> 136
    //   75: ldc 138
    //   77: new 140	java/lang/StringBuilder
    //   80: dup
    //   81: ldc 142
    //   83: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   86: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   89: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 172
    //   94: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_0
    //   98: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc_w 419
    //   104: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: iload_1
    //   108: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 16
    //   119: iconst_0
    //   120: invokestatic 170	com/tencent/mm/compatible/util/f:getLine	()I
    //   123: isub
    //   124: putfield 417	com/tencent/mm/modelvideo/t$b:ret	I
    //   127: ldc_w 412
    //   130: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload 16
    //   135: areturn
    //   136: iload_2
    //   137: ifgt +60 -> 197
    //   140: ldc 138
    //   142: new 140	java/lang/StringBuilder
    //   145: dup
    //   146: ldc 142
    //   148: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   154: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 172
    //   159: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 421
    //   169: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload 16
    //   180: iconst_0
    //   181: invokestatic 170	com/tencent/mm/compatible/util/f:getLine	()I
    //   184: isub
    //   185: putfield 417	com/tencent/mm/modelvideo/t$b:ret	I
    //   188: ldc_w 412
    //   191: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload 16
    //   196: areturn
    //   197: new 185	com/tencent/mm/compatible/util/f$a
    //   200: dup
    //   201: invokespecial 186	com/tencent/mm/compatible/util/f$a:<init>	()V
    //   204: astore 17
    //   206: aconst_null
    //   207: astore 14
    //   209: aconst_null
    //   210: astore 13
    //   212: aload 16
    //   214: iload_2
    //   215: newarray byte
    //   217: putfield 425	com/tencent/mm/modelvideo/t$b:buf	[B
    //   220: aload_0
    //   221: iconst_0
    //   222: invokestatic 192	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   225: astore 15
    //   227: aload 15
    //   229: astore 13
    //   231: aload 15
    //   233: astore 14
    //   235: aload 17
    //   237: invokevirtual 196	com/tencent/mm/compatible/util/f$a:XK	()J
    //   240: lstore 5
    //   242: aload 15
    //   244: astore 13
    //   246: aload 15
    //   248: astore 14
    //   250: aload 15
    //   252: iload_1
    //   253: i2l
    //   254: invokevirtual 202	java/io/RandomAccessFile:seek	(J)V
    //   257: aload 15
    //   259: astore 13
    //   261: aload 15
    //   263: astore 14
    //   265: aload 17
    //   267: invokevirtual 196	com/tencent/mm/compatible/util/f$a:XK	()J
    //   270: lstore 7
    //   272: aload 15
    //   274: astore 13
    //   276: aload 15
    //   278: astore 14
    //   280: aload 15
    //   282: aload 16
    //   284: getfield 425	com/tencent/mm/modelvideo/t$b:buf	[B
    //   287: iconst_0
    //   288: iload_2
    //   289: invokevirtual 429	java/io/RandomAccessFile:read	([BII)I
    //   292: istore 4
    //   294: aload 15
    //   296: astore 13
    //   298: aload 15
    //   300: astore 14
    //   302: aload 17
    //   304: invokevirtual 196	com/tencent/mm/compatible/util/f$a:XK	()J
    //   307: lstore 9
    //   309: aload 15
    //   311: astore 13
    //   313: aload 15
    //   315: astore 14
    //   317: aload 17
    //   319: invokevirtual 196	com/tencent/mm/compatible/util/f$a:XK	()J
    //   322: lstore 11
    //   324: iload 4
    //   326: ifge +310 -> 636
    //   329: aload 15
    //   331: astore 13
    //   333: aload 15
    //   335: astore 14
    //   337: aload 16
    //   339: iload_3
    //   340: putfield 432	com/tencent/mm/modelvideo/t$b:cZc	I
    //   343: aload 15
    //   345: astore 13
    //   347: aload 15
    //   349: astore 14
    //   351: aload 16
    //   353: iload_3
    //   354: iload_1
    //   355: iadd
    //   356: putfield 435	com/tencent/mm/modelvideo/t$b:hAL	I
    //   359: aload 15
    //   361: ifnull +8 -> 369
    //   364: aload 15
    //   366: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   369: ldc 138
    //   371: new 140	java/lang/StringBuilder
    //   374: dup
    //   375: ldc 214
    //   377: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   380: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   383: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: ldc 172
    //   388: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload_0
    //   392: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: ldc 216
    //   397: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: iload_1
    //   401: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   404: ldc_w 437
    //   407: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: iload_2
    //   411: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   414: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 221	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: ldc 138
    //   422: new 140	java/lang/StringBuilder
    //   425: dup
    //   426: ldc 214
    //   428: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   431: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   434: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: ldc 172
    //   439: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload_0
    //   443: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: ldc 223
    //   448: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: lload 5
    //   453: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   456: ldc 228
    //   458: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: lload 7
    //   463: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   466: ldc 230
    //   468: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: lload 9
    //   473: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   476: ldc 232
    //   478: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: lload 11
    //   483: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   486: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 221	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: ldc_w 412
    //   495: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   498: aload 16
    //   500: areturn
    //   501: astore 15
    //   503: aload 13
    //   505: astore 14
    //   507: ldc 138
    //   509: new 140	java/lang/StringBuilder
    //   512: dup
    //   513: ldc 142
    //   515: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   518: invokestatic 151	com/tencent/mm/compatible/util/f:XJ	()Ljava/lang/String;
    //   521: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc 172
    //   526: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_0
    //   530: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc 234
    //   535: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 16
    //   540: getfield 435	com/tencent/mm/modelvideo/t$b:hAL	I
    //   543: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: ldc 236
    //   548: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 15
    //   553: invokevirtual 239	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   556: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: ldc 241
    //   561: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: aload 13
    //   572: astore 14
    //   574: aload 16
    //   576: iconst_0
    //   577: invokestatic 170	com/tencent/mm/compatible/util/f:getLine	()I
    //   580: isub
    //   581: putfield 417	com/tencent/mm/modelvideo/t$b:ret	I
    //   584: aload 13
    //   586: ifnull +8 -> 594
    //   589: aload 13
    //   591: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   594: ldc_w 412
    //   597: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   600: aload 16
    //   602: areturn
    //   603: astore_0
    //   604: aload 14
    //   606: ifnull +8 -> 614
    //   609: aload 14
    //   611: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   614: ldc_w 412
    //   617: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   620: aload_0
    //   621: athrow
    //   622: astore 13
    //   624: goto -255 -> 369
    //   627: astore_0
    //   628: goto -34 -> 594
    //   631: astore 13
    //   633: goto -19 -> 614
    //   636: iload 4
    //   638: istore_3
    //   639: goto -310 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	paramString	String
    //   0	642	1	paramInt1	int
    //   0	642	2	paramInt2	int
    //   1	638	3	i	int
    //   292	345	4	j	int
    //   240	212	5	l1	long
    //   270	192	7	l2	long
    //   307	165	9	l3	long
    //   322	160	11	l4	long
    //   210	380	13	localObject1	Object
    //   622	1	13	localException1	Exception
    //   631	1	13	localException2	Exception
    //   207	403	14	localObject2	Object
    //   225	140	15	localRandomAccessFile	java.io.RandomAccessFile
    //   501	51	15	localException3	Exception
    //   15	586	16	localb	b
    //   204	114	17	locala	com.tencent.mm.compatible.util.f.a
    // Exception table:
    //   from	to	target	type
    //   220	227	501	java/lang/Exception
    //   235	242	501	java/lang/Exception
    //   250	257	501	java/lang/Exception
    //   265	272	501	java/lang/Exception
    //   280	294	501	java/lang/Exception
    //   302	309	501	java/lang/Exception
    //   317	324	501	java/lang/Exception
    //   337	343	501	java/lang/Exception
    //   351	359	501	java/lang/Exception
    //   220	227	603	finally
    //   235	242	603	finally
    //   250	257	603	finally
    //   265	272	603	finally
    //   280	294	603	finally
    //   302	309	603	finally
    //   317	324	603	finally
    //   337	343	603	finally
    //   351	359	603	finally
    //   507	570	603	finally
    //   574	584	603	finally
    //   364	369	622	java/lang/Exception
    //   589	594	627	java/lang/Exception
    //   609	614	631	java/lang/Exception
  }
  
  public static String zP(String paramString)
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
    l = hAw;
    hAw = 1L + l;
    paramString = l;
    AppMethodBeat.o(126978);
    return paramString;
  }
  
  public static String zQ(String paramString)
  {
    AppMethodBeat.i(126980);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126980);
      return null;
    }
    paramString = getVideoPath() + paramString;
    if (i.eK(paramString))
    {
      AppMethodBeat.o(126980);
      return paramString;
    }
    paramString = paramString + ".mp4";
    AppMethodBeat.o(126980);
    return paramString;
  }
  
  public static String zR(String paramString)
  {
    AppMethodBeat.i(126981);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(126981);
      return null;
    }
    paramString = getVideoPath() + paramString + ".jpg";
    AppMethodBeat.o(126981);
    return paramString;
  }
  
  public static int zS(String paramString)
  {
    AppMethodBeat.i(126984);
    if (bt.isNullOrNil(paramString))
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
  static int[] zT(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc_w 502
    //   5: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: bipush 33
    //   10: newarray int
    //   12: astore 10
    //   14: invokestatic 256	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   17: lstore 4
    //   19: aload_0
    //   20: invokestatic 506	com/tencent/mm/vfs/i:aMN	(Ljava/lang/String;)J
    //   23: l2i
    //   24: istore_2
    //   25: iload_2
    //   26: ldc_w 507
    //   29: if_icmplt +10 -> 39
    //   32: iload_2
    //   33: ldc_w 508
    //   36: if_icmplt +82 -> 118
    //   39: ldc 138
    //   41: ldc_w 510
    //   44: iconst_2
    //   45: anewarray 4	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: iload_2
    //   51: invokestatic 315	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: aload_0
    //   58: aastore
    //   59: invokestatic 260	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: getstatic 346	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   65: astore_0
    //   66: iload_2
    //   67: ldc_w 507
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
    //   90: invokestatic 315	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: iload_2
    //   97: invokestatic 315	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: aastore
    //   101: invokevirtual 352	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   104: ldc_w 502
    //   107: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   140: aload_0
    //   141: iconst_0
    //   142: invokestatic 192	com/tencent/mm/vfs/i:cS	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   145: astore 9
    //   147: iload_1
    //   148: bipush 32
    //   150: if_icmpge +66 -> 216
    //   153: iload_1
    //   154: iload_3
    //   155: imul
    //   156: sipush 10240
    //   159: iadd
    //   160: i2l
    //   161: lstore 6
    //   163: aload 9
    //   165: astore 8
    //   167: aload 9
    //   169: lload 6
    //   171: invokevirtual 202	java/io/RandomAccessFile:seek	(J)V
    //   174: aload 9
    //   176: astore 8
    //   178: aload 9
    //   180: aload 11
    //   182: invokevirtual 514	java/io/RandomAccessFile:readFully	([B)V
    //   185: aload 9
    //   187: astore 8
    //   189: aload 10
    //   191: iload_1
    //   192: aload 11
    //   194: sipush 512
    //   197: invokestatic 520	com/tencent/mm/b/i:u	([BI)I
    //   200: ldc_w 521
    //   203: irem
    //   204: ldc_w 521
    //   207: ior
    //   208: iastore
    //   209: iload_1
    //   210: iconst_1
    //   211: iadd
    //   212: istore_1
    //   213: goto -66 -> 147
    //   216: aload 9
    //   218: astore 8
    //   220: aload 9
    //   222: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   225: aload 9
    //   227: astore 8
    //   229: ldc 138
    //   231: ldc_w 523
    //   234: iconst_3
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: lload 4
    //   242: invokestatic 332	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   245: invokestatic 337	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   248: aastore
    //   249: dup
    //   250: iconst_1
    //   251: iload_2
    //   252: invokestatic 315	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: aastore
    //   256: dup
    //   257: iconst_2
    //   258: aload_0
    //   259: aastore
    //   260: invokestatic 253	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload 9
    //   265: ifnull +8 -> 273
    //   268: aload 9
    //   270: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   273: ldc_w 502
    //   276: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aload 10
    //   281: areturn
    //   282: astore 10
    //   284: aconst_null
    //   285: astore 9
    //   287: aload 9
    //   289: astore 8
    //   291: ldc 138
    //   293: ldc_w 525
    //   296: iconst_2
    //   297: anewarray 4	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: aload_0
    //   303: aastore
    //   304: dup
    //   305: iconst_1
    //   306: aload 10
    //   308: invokestatic 529	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   311: aastore
    //   312: invokestatic 260	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: aload 9
    //   317: ifnull +8 -> 325
    //   320: aload 9
    //   322: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   325: ldc_w 502
    //   328: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: aconst_null
    //   332: areturn
    //   333: astore_0
    //   334: aconst_null
    //   335: astore 8
    //   337: aload 8
    //   339: ifnull +8 -> 347
    //   342: aload 8
    //   344: invokevirtual 212	java/io/RandomAccessFile:close	()V
    //   347: ldc_w 502
    //   350: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   353: aload_0
    //   354: athrow
    //   355: astore_0
    //   356: goto -83 -> 273
    //   359: astore_0
    //   360: goto -35 -> 325
    //   363: astore 8
    //   365: goto -18 -> 347
    //   368: astore_0
    //   369: goto -32 -> 337
    //   372: astore 10
    //   374: goto -87 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramString	String
    //   1	212	1	i	int
    //   24	228	2	j	int
    //   132	24	3	k	int
    //   17	224	4	l1	long
    //   161	9	6	l2	long
    //   165	178	8	localRandomAccessFile1	java.io.RandomAccessFile
    //   363	1	8	localException1	Exception
    //   145	176	9	localRandomAccessFile2	java.io.RandomAccessFile
    //   12	268	10	arrayOfInt	int[]
    //   282	25	10	localException2	Exception
    //   372	1	10	localException3	Exception
    //   138	55	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   140	147	282	java/lang/Exception
    //   140	147	333	finally
    //   268	273	355	java/lang/Exception
    //   320	325	359	java/lang/Exception
    //   342	347	363	java/lang/Exception
    //   167	174	368	finally
    //   178	185	368	finally
    //   189	209	368	finally
    //   220	225	368	finally
    //   229	263	368	finally
    //   291	315	368	finally
    //   167	174	372	java/lang/Exception
    //   178	185	372	java/lang/Exception
    //   189	209	372	java/lang/Exception
    //   220	225	372	java/lang/Exception
    //   229	263	372	java/lang/Exception
  }
  
  /* Error */
  public final List<s> A(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc_w 532
    //   3: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 140	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 534
    //   13: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: iload_1
    //   17: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   20: ldc_w 536
    //   23: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: lload_2
    //   27: invokevirtual 226	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   30: ldc_w 538
    //   33: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 5
    //   41: aload_0
    //   42: getfield 123	com/tencent/mm/modelvideo/t:gPa	Lcom/tencent/mm/storagebase/h;
    //   45: aload 5
    //   47: aconst_null
    //   48: iconst_2
    //   49: invokevirtual 290	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   52: astore 6
    //   54: aload 6
    //   56: astore 7
    //   58: aload 6
    //   60: invokeinterface 541 1 0
    //   65: ifeq +194 -> 259
    //   68: aload 6
    //   70: astore 7
    //   72: new 543	java/util/ArrayList
    //   75: dup
    //   76: invokespecial 544	java/util/ArrayList:<init>	()V
    //   79: astore 5
    //   81: aload 6
    //   83: astore 7
    //   85: new 546	com/tencent/mm/modelvideo/s
    //   88: dup
    //   89: invokespecial 547	com/tencent/mm/modelvideo/s:<init>	()V
    //   92: astore 8
    //   94: aload 6
    //   96: astore 7
    //   98: aload 8
    //   100: aload 6
    //   102: invokevirtual 551	com/tencent/mm/modelvideo/s:convertFrom	(Landroid/database/Cursor;)V
    //   105: aload 6
    //   107: astore 7
    //   109: aload 5
    //   111: aload 8
    //   113: invokeinterface 554 2 0
    //   118: pop
    //   119: aload 6
    //   121: astore 7
    //   123: aload 6
    //   125: invokeinterface 299 1 0
    //   130: istore 4
    //   132: iload 4
    //   134: ifne -53 -> 81
    //   137: aload 5
    //   139: astore 7
    //   141: aload 6
    //   143: ifnull +14 -> 157
    //   146: aload 6
    //   148: invokeinterface 323 1 0
    //   153: aload 5
    //   155: astore 7
    //   157: ldc_w 532
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
    //   178: ldc 138
    //   180: aload 8
    //   182: ldc_w 556
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 560	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload 5
    //   194: astore 7
    //   196: aload 6
    //   198: ifnull -41 -> 157
    //   201: aload 6
    //   203: invokeinterface 323 1 0
    //   208: aload 5
    //   210: astore 7
    //   212: goto -55 -> 157
    //   215: astore 5
    //   217: aconst_null
    //   218: astore 7
    //   220: aload 7
    //   222: ifnull +10 -> 232
    //   225: aload 7
    //   227: invokeinterface 323 1 0
    //   232: ldc_w 532
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
  
  public final void a(a parama)
  {
    AppMethodBeat.i(126966);
    this.gTG.remove(parama);
    AppMethodBeat.o(126966);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(126965);
    this.gTG.a(parama, paramLooper);
    AppMethodBeat.o(126965);
  }
  
  public final List<s> aCY()
  {
    AppMethodBeat.i(126971);
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat,videoinfo2.forward_msg_local_id,videoinfo2.msg_uuid from videoinfo2  " + " WHERE status=200 order by masssendid desc";
    ArrayList localArrayList = new ArrayList();
    localObject = this.gPa.a((String)localObject, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext())
    {
      s locals = new s();
      locals.convertFrom((Cursor)localObject);
      localArrayList.add(locals);
      i += 1;
    }
    ((Cursor)localObject).close();
    ad.d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:".concat(String.valueOf(i)));
    AppMethodBeat.o(126971);
    return localArrayList;
  }
  
  public final List<s> aCZ()
  {
    AppMethodBeat.i(126972);
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat,videoinfo2.forward_msg_local_id,videoinfo2.msg_uuid from videoinfo2  " + " WHERE status=198 AND masssendid > 0 order by masssendid desc";
    ArrayList localArrayList = new ArrayList();
    localObject = this.gPa.a((String)localObject, null, 2);
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
  
  public final List<String> aDa()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(126974);
    Object localObject1 = "select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE status=112 ORDER BY downloadtime DESC " + " LIMIT 10";
    try
    {
      localObject1 = this.gPa.a((String)localObject1, null, 2);
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
  
  public final List<String> aDb()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(126975);
    Object localObject1 = " SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=122" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " UNION SELECT * FROM ( ";
    localObject1 = (String)localObject1 + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=120" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " ORDER BY downloadtime DESC";
    try
    {
      localObject1 = this.gPa.a((String)localObject1, null, 2);
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
  
  public final List<String> aDc()
  {
    ArrayList localArrayList = null;
    AppMethodBeat.i(126977);
    Object localObject1 = " SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=103" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " UNION SELECT * FROM ( ";
    localObject1 = (String)localObject1 + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=104" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " ORDER BY downloadtime DESC";
    try
    {
      localObject1 = this.gPa.a((String)localObject1, null, 2);
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
    params.dtM = -1;
    ContentValues localContentValues = params.convertTo();
    if ((int)this.gPa.a("videoinfo2", "filename", localContentValues) != -1)
    {
      params = new t.a.a(params.getFileName(), t.a.b.hAD, t.a.c.hAH, params.hAo, params.hyw);
      this.gTG.dR(params);
      this.gTG.doNotify();
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
      ad.e("MicroMsg.VideoInfoStorage", "update failed, no values set");
    }
    label65:
    label70:
    while (this.gPa.update("videoinfo2", (ContentValues)localObject, "filename= ?", new String[] { params.getFileName() }) <= 0)
    {
      AppMethodBeat.o(126973);
      return false;
      bool = false;
      break;
      bool = false;
      break label28;
    }
    Object localObject = t.a.c.hAH;
    if (params.status == 112) {}
    for (localObject = t.a.c.hAJ;; localObject = t.a.c.hAI) {
      do
      {
        params = new t.a.a(params.getFileName(), t.a.b.hAF, (t.a.c)localObject, params.hAo, params.hyw);
        this.gTG.dR(params);
        this.gTG.doNotify();
        AppMethodBeat.o(126973);
        return true;
      } while ((params.status != 103) && (params.status != 104));
    }
  }
  
  public final List<s> mE(long paramLong)
  {
    AppMethodBeat.i(126970);
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat,videoinfo2.forward_msg_local_id,videoinfo2.msg_uuid from videoinfo2   where videoinfo2.masssendid = ".concat(String.valueOf(paramLong));
    localObject = this.gPa.a((String)localObject, null, 2);
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
    boolean bool = bp(paramString1, paramString2 + "##" + paramString3);
    AppMethodBeat.o(126985);
    return bool;
  }
  
  public final s zO(String paramString)
  {
    AppMethodBeat.i(126969);
    for (;;)
    {
      try
      {
        paramString = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat,videoinfo2.forward_msg_local_id,videoinfo2.msg_uuid from videoinfo2   where videoinfo2.filename = \"" + bt.aFQ(String.valueOf(paramString)) + "\"";
        Cursor localCursor = this.gPa.a(paramString, null, 2);
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
        ad.printErrStackTrace("MicroMsg.VideoInfoStorage", paramString, "getByFileName error[%s]", new Object[] { paramString.toString() });
        AppMethodBeat.o(126969);
        return null;
      }
      paramString = null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public static final class a
    {
      public final String fileName;
      public final t.a.b hAB;
      public final t.a.c hAC;
      public final int hAo;
      public final long hyw;
      
      public a(String paramString, t.a.b paramb, t.a.c paramc, int paramInt, long paramLong)
      {
        this.fileName = paramString;
        this.hAB = paramb;
        this.hAC = paramc;
        this.hAo = paramInt;
        this.hyw = paramLong;
      }
    }
    
    public static enum b
    {
      static
      {
        AppMethodBeat.i(126961);
        hAD = new b("INSERT", 0);
        hAE = new b("DELETE", 1);
        hAF = new b("UPDATE", 2);
        hAG = new b[] { hAD, hAE, hAF };
        AppMethodBeat.o(126961);
      }
      
      private b() {}
    }
    
    public static enum c
    {
      static
      {
        AppMethodBeat.i(126964);
        hAH = new c("NORMAL", 0);
        hAI = new c("UPLOAD", 1);
        hAJ = new c("DOWNLOAD", 2);
        hAK = new c[] { hAH, hAI, hAJ };
        AppMethodBeat.o(126964);
      }
      
      private c() {}
    }
  }
  
  public static final class b
  {
    public byte[] buf = null;
    public int cZc = 0;
    public int hAL = 0;
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.t
 * JD-Core Version:    0.7.0.1
 */