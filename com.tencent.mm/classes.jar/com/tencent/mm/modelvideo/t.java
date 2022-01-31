package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import junit.framework.Assert;

public final class t
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS videoinfo2 ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "CREATE INDEX IF NOT EXISTS  video_status_index ON videoinfo2 ( status,downloadtime )", "CREATE TABLE IF NOT EXISTS videoinfo ( filename text  PRIMARY KEY , clientid text  , msgsvrid int  , netoffset int  , filenowsize int  , totallen int  , thumbnetoffset int  , thumblen int  , status int  , createtime long  , lastmodifytime long  , downloadtime long  , videolength int  , msglocalid int  , nettimes int  , cameratype int  , user text  , human text  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  , videofuncflag int ,masssendid long ,masssendlist text,videomd5 text, streamvideo byte[], statextstr text, downloadscene int, mmsightextinfo byte[], preloadsize int, videoformat int )", "alter table videoinfo2 add videofuncflag int ;", "alter table videoinfo2 add masssendid long default 0;", "alter table videoinfo2 add masssendlist text ;", "alter table videoinfo2 add videomd5 text ;", "alter table videoinfo2 add streamvideo byte[] ;", "alter table videoinfo2 add statextstr text ;", "alter table videoinfo2 add downloadscene int ;", "alter table videoinfo2 add mmsightextinfo byte[] ;", "alter table videoinfo2 add preloadsize int ;", "alter table videoinfo2 add videoformat int ;", "alter table videoinfo add videofuncflag int ;", "alter table videoinfo add masssendid long default 0;", "alter table videoinfo add masssendlist text ;", "alter table videoinfo add videomd5 text ;", "alter table videoinfo add streamvideo byte[] ;", "alter table videoinfo add statextstr text ;", "alter table videoinfo add downloadscene int ;", "alter table videoinfo add mmsightextinfo byte[] ;", "alter table videoinfo add preloadsize int ;", "alter table videoinfo add videoformat int ;", "insert into videoinfo2 select * from videoinfo ;", "delete from videoinfo ;", "CREATE INDEX IF NOT EXISTS  massSendIdIndex ON videoinfo2 ( masssendid )", "CREATE INDEX IF NOT EXISTS  LastModifyTimeIndex ON videoinfo2 ( lastmodifytime )", "CREATE TABLE IF NOT EXISTS  VideoHash  (size int , CreateTime long, hash text ,  cdnxml text, orgpath text);", "CREATE INDEX IF NOT EXISTS  VideoHashSizeIndex ON VideoHash ( size  )", "CREATE INDEX IF NOT EXISTS  VideoHashTimeIndex ON VideoHash ( CreateTime  )" };
  private static long eHS = 0L;
  public com.tencent.mm.cf.h dXo;
  k<t.a, a.a> ebu = new t.1(this);
  
  public t(com.tencent.mm.cf.h paramh)
  {
    this.dXo = paramh;
  }
  
  /* Error */
  public static int a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 111	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifeq +39 -> 43
    //   7: ldc 113
    //   9: new 115	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 117
    //   15: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   21: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 132
    //   26: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 141	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: iconst_0
    //   36: invokestatic 145	com/tencent/mm/compatible/util/g:getLine	()I
    //   39: isub
    //   40: istore_1
    //   41: iload_1
    //   42: ireturn
    //   43: iload_1
    //   44: ifge +50 -> 94
    //   47: ldc 113
    //   49: new 115	java/lang/StringBuilder
    //   52: dup
    //   53: ldc 117
    //   55: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   61: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc 147
    //   66: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 149
    //   75: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload_1
    //   79: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 141	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iconst_0
    //   89: invokestatic 145	com/tencent/mm/compatible/util/g:getLine	()I
    //   92: isub
    //   93: ireturn
    //   94: aload_2
    //   95: invokestatic 156	com/tencent/mm/sdk/platformtools/bk:bE	([B)Z
    //   98: ifeq +46 -> 144
    //   101: ldc 113
    //   103: new 115	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 117
    //   109: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   115: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 147
    //   120: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_0
    //   124: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 158
    //   129: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 141	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: iconst_0
    //   139: invokestatic 145	com/tencent/mm/compatible/util/g:getLine	()I
    //   142: isub
    //   143: ireturn
    //   144: new 160	com/tencent/mm/compatible/util/g$a
    //   147: dup
    //   148: invokespecial 161	com/tencent/mm/compatible/util/g$a:<init>	()V
    //   151: astore 14
    //   153: new 163	java/io/RandomAccessFile
    //   156: dup
    //   157: aload_0
    //   158: ldc 165
    //   160: invokespecial 167	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: astore 13
    //   165: aload 13
    //   167: astore 12
    //   169: aload 14
    //   171: invokevirtual 171	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   174: lstore 4
    //   176: aload 13
    //   178: astore 12
    //   180: aload 13
    //   182: iload_1
    //   183: i2l
    //   184: invokevirtual 175	java/io/RandomAccessFile:seek	(J)V
    //   187: aload 13
    //   189: astore 12
    //   191: aload 14
    //   193: invokevirtual 171	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   196: lstore 6
    //   198: aload 13
    //   200: astore 12
    //   202: aload 13
    //   204: aload_2
    //   205: iconst_0
    //   206: aload_2
    //   207: arraylength
    //   208: invokevirtual 179	java/io/RandomAccessFile:write	([BII)V
    //   211: aload 13
    //   213: astore 12
    //   215: aload 14
    //   217: invokevirtual 171	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   220: lstore 8
    //   222: aload 13
    //   224: astore 12
    //   226: aload 13
    //   228: invokevirtual 182	java/io/RandomAccessFile:getFilePointer	()J
    //   231: l2i
    //   232: istore_3
    //   233: aload 13
    //   235: astore 12
    //   237: aload 14
    //   239: invokevirtual 171	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   242: lstore 10
    //   244: aload 13
    //   246: invokevirtual 185	java/io/RandomAccessFile:close	()V
    //   249: ldc 113
    //   251: new 115	java/lang/StringBuilder
    //   254: dup
    //   255: ldc 187
    //   257: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   263: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: ldc 147
    //   268: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_0
    //   272: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc 189
    //   277: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: iload_1
    //   281: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: ldc 191
    //   286: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_2
    //   290: arraylength
    //   291: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 194	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: ldc 113
    //   302: new 115	java/lang/StringBuilder
    //   305: dup
    //   306: ldc 187
    //   308: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   311: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   314: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc 147
    //   319: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload_0
    //   323: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc 196
    //   328: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: lload 4
    //   333: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   336: ldc 201
    //   338: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: lload 6
    //   343: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   346: ldc 203
    //   348: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: lload 8
    //   353: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   356: ldc 205
    //   358: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: lload 10
    //   363: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   366: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 194	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: iload_3
    //   373: ireturn
    //   374: astore 14
    //   376: aconst_null
    //   377: astore_2
    //   378: aload_2
    //   379: astore 12
    //   381: ldc 113
    //   383: new 115	java/lang/StringBuilder
    //   386: dup
    //   387: ldc 117
    //   389: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   392: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   395: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc 147
    //   400: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc 207
    //   409: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: iload_1
    //   413: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   416: ldc 209
    //   418: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload 14
    //   423: invokevirtual 212	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   426: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: ldc 214
    //   431: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 141	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: aload_2
    //   441: astore 12
    //   443: invokestatic 145	com/tencent/mm/compatible/util/g:getLine	()I
    //   446: istore_1
    //   447: iconst_0
    //   448: iload_1
    //   449: isub
    //   450: istore_3
    //   451: iload_3
    //   452: istore_1
    //   453: aload_2
    //   454: ifnull -413 -> 41
    //   457: aload_2
    //   458: invokevirtual 185	java/io/RandomAccessFile:close	()V
    //   461: iload_3
    //   462: ireturn
    //   463: astore_0
    //   464: iload_3
    //   465: ireturn
    //   466: astore_0
    //   467: aconst_null
    //   468: astore 12
    //   470: aload 12
    //   472: ifnull +8 -> 480
    //   475: aload 12
    //   477: invokevirtual 185	java/io/RandomAccessFile:close	()V
    //   480: aload_0
    //   481: athrow
    //   482: astore 12
    //   484: goto -235 -> 249
    //   487: astore_2
    //   488: goto -8 -> 480
    //   491: astore_0
    //   492: goto -22 -> 470
    //   495: astore 14
    //   497: aload 13
    //   499: astore_2
    //   500: goto -122 -> 378
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	paramString	String
    //   0	503	1	paramInt	int
    //   0	503	2	paramArrayOfByte	byte[]
    //   232	233	3	i	int
    //   174	158	4	l1	long
    //   196	146	6	l2	long
    //   220	132	8	l3	long
    //   242	120	10	l4	long
    //   167	309	12	localObject	Object
    //   482	1	12	localException1	java.lang.Exception
    //   163	335	13	localRandomAccessFile	java.io.RandomAccessFile
    //   151	87	14	locala	com.tencent.mm.compatible.util.g.a
    //   374	48	14	localException2	java.lang.Exception
    //   495	1	14	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   153	165	374	java/lang/Exception
    //   457	461	463	java/lang/Exception
    //   153	165	466	finally
    //   244	249	482	java/lang/Exception
    //   475	480	487	java/lang/Exception
    //   169	176	491	finally
    //   180	187	491	finally
    //   191	198	491	finally
    //   202	211	491	finally
    //   215	222	491	finally
    //   226	233	491	finally
    //   237	244	491	finally
    //   381	440	491	finally
    //   443	447	491	finally
    //   169	176	495	java/lang/Exception
    //   180	187	495	java/lang/Exception
    //   191	198	495	java/lang/Exception
    //   202	211	495	java/lang/Exception
    //   215	222	495	java/lang/Exception
    //   226	233	495	java/lang/Exception
    //   237	244	495	java/lang/Exception
  }
  
  private boolean aG(String paramString1, String paramString2)
  {
    y.i("MicroMsg.VideoInfoStorage", "saveVideoHash path:%s xml:%s stack:%s", new Object[] { paramString1, paramString2, bk.csb() });
    long l1 = bk.UY();
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)))
    {
      y.e("MicroMsg.VideoInfoStorage", "saveVideoHash failed , path:%s xml:%s", new Object[] { paramString1, paramString2 });
      return false;
    }
    Object localObject = nV(paramString1);
    if ((localObject == null) || (localObject.length < 33))
    {
      y.e("MicroMsg.VideoInfoStorage", "saveVideoHash  readHash failed :%s", new Object[] { paramString1 });
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
    localObject = this.dXo.a("select cdnxml from VideoHash where size = " + j + " and hash = \"" + localStringBuffer.toString() + "\"", null, 2);
    Vector localVector = new Vector();
    while (((Cursor)localObject).moveToNext())
    {
      localVector.add(((Cursor)localObject).getString(0));
      y.v("MicroMsg.VideoInfoStorage", "saveVideoHash index:%s get:%s", new Object[] { Integer.valueOf(localVector.size()), localVector.get(localVector.size() - 1) });
    }
    ((Cursor)localObject).close();
    if ((localVector.size() == 1) && (paramString2.equals(localVector.get(0))))
    {
      y.w("MicroMsg.VideoInfoStorage", "saveVideoHash Check exist now return,time:%d,  path:%s xml:%s", new Object[] { Long.valueOf(bk.co(l1)), paramString1, paramString2 });
      return true;
    }
    if (localVector.size() > 0)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(12696, new Object[] { Integer.valueOf(102), Integer.valueOf(j), "", "", Integer.valueOf(localVector.size()) });
      y.e("MicroMsg.VideoInfoStorage", "saveVideoHash Err Check  xml diff OR  select more than one row,  rowCount:%d size:%d ", new Object[] { Integer.valueOf(localVector.size()), Integer.valueOf(j) });
      this.dXo.gk("VideoHash", "delete from VideoHash where size = " + j + " and hash = \"" + localStringBuffer.toString() + "\"");
    }
    localObject = new ContentValues();
    ((ContentValues)localObject).put("size", Integer.valueOf(j));
    ((ContentValues)localObject).put("CreateTime", Long.valueOf(bk.UX()));
    ((ContentValues)localObject).put("hash", localStringBuffer.toString());
    ((ContentValues)localObject).put("cdnxml", paramString2);
    ((ContentValues)localObject).put("orgpath", paramString1);
    long l2 = this.dXo.insert("VideoHash", "", (ContentValues)localObject);
    y.i("MicroMsg.VideoInfoStorage", "summersafecdn saveVideoHash time:%d insert:%d path:%s hash:%s xml:%s", new Object[] { Long.valueOf(bk.co(l1)), Long.valueOf(l2), paramString1, localStringBuffer, paramString2 });
    if (l2 < 0L)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(12696, new Object[] { Integer.valueOf(103), Integer.valueOf(j) });
      y.e("MicroMsg.VideoInfoStorage", "saveVideoHash insert failed :%d  path:%s", new Object[] { Long.valueOf(l2), paramString1 });
    }
    return true;
  }
  
  private static String getVideoPath()
  {
    return com.tencent.mm.kernel.g.DP().dKt + "video/";
  }
  
  /* Error */
  public static t.b k(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 11	com/tencent/mm/modelvideo/t$b
    //   5: dup
    //   6: invokespecial 385	com/tencent/mm/modelvideo/t$b:<init>	()V
    //   9: astore 16
    //   11: aload_0
    //   12: invokestatic 111	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   15: ifeq +44 -> 59
    //   18: ldc 113
    //   20: new 115	java/lang/StringBuilder
    //   23: dup
    //   24: ldc 117
    //   26: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   32: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 132
    //   37: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 141	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload 16
    //   48: iconst_0
    //   49: invokestatic 145	com/tencent/mm/compatible/util/g:getLine	()I
    //   52: isub
    //   53: putfield 389	com/tencent/mm/modelvideo/t$b:ret	I
    //   56: aload 16
    //   58: areturn
    //   59: iload_1
    //   60: ifge +58 -> 118
    //   63: ldc 113
    //   65: new 115	java/lang/StringBuilder
    //   68: dup
    //   69: ldc 117
    //   71: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   77: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 147
    //   82: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 391
    //   92: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: iload_1
    //   96: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 141	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload 16
    //   107: iconst_0
    //   108: invokestatic 145	com/tencent/mm/compatible/util/g:getLine	()I
    //   111: isub
    //   112: putfield 389	com/tencent/mm/modelvideo/t$b:ret	I
    //   115: aload 16
    //   117: areturn
    //   118: iload_2
    //   119: ifgt +54 -> 173
    //   122: ldc 113
    //   124: new 115	java/lang/StringBuilder
    //   127: dup
    //   128: ldc 117
    //   130: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   133: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   136: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 147
    //   141: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_0
    //   145: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc_w 393
    //   151: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 141	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload 16
    //   162: iconst_0
    //   163: invokestatic 145	com/tencent/mm/compatible/util/g:getLine	()I
    //   166: isub
    //   167: putfield 389	com/tencent/mm/modelvideo/t$b:ret	I
    //   170: aload 16
    //   172: areturn
    //   173: new 160	com/tencent/mm/compatible/util/g$a
    //   176: dup
    //   177: invokespecial 161	com/tencent/mm/compatible/util/g$a:<init>	()V
    //   180: astore 15
    //   182: aload 16
    //   184: iload_2
    //   185: newarray byte
    //   187: putfield 397	com/tencent/mm/modelvideo/t$b:buf	[B
    //   190: new 163	java/io/RandomAccessFile
    //   193: dup
    //   194: aload_0
    //   195: ldc_w 399
    //   198: invokespecial 167	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: astore 14
    //   203: aload 14
    //   205: astore 13
    //   207: aload 15
    //   209: invokevirtual 171	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   212: lstore 5
    //   214: aload 14
    //   216: astore 13
    //   218: aload 14
    //   220: iload_1
    //   221: i2l
    //   222: invokevirtual 175	java/io/RandomAccessFile:seek	(J)V
    //   225: aload 14
    //   227: astore 13
    //   229: aload 15
    //   231: invokevirtual 171	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   234: lstore 7
    //   236: aload 14
    //   238: astore 13
    //   240: aload 14
    //   242: aload 16
    //   244: getfield 397	com/tencent/mm/modelvideo/t$b:buf	[B
    //   247: iconst_0
    //   248: iload_2
    //   249: invokevirtual 403	java/io/RandomAccessFile:read	([BII)I
    //   252: istore 4
    //   254: aload 14
    //   256: astore 13
    //   258: aload 15
    //   260: invokevirtual 171	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   263: lstore 9
    //   265: aload 14
    //   267: astore 13
    //   269: aload 15
    //   271: invokevirtual 171	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   274: lstore 11
    //   276: iload 4
    //   278: ifge +294 -> 572
    //   281: aload 14
    //   283: astore 13
    //   285: aload 16
    //   287: iload_3
    //   288: putfield 406	com/tencent/mm/modelvideo/t$b:bDu	I
    //   291: aload 14
    //   293: astore 13
    //   295: aload 16
    //   297: iload_3
    //   298: iload_1
    //   299: iadd
    //   300: putfield 409	com/tencent/mm/modelvideo/t$b:eIh	I
    //   303: aload 14
    //   305: invokevirtual 185	java/io/RandomAccessFile:close	()V
    //   308: ldc 113
    //   310: new 115	java/lang/StringBuilder
    //   313: dup
    //   314: ldc 187
    //   316: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   319: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   322: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc 147
    //   327: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload_0
    //   331: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: ldc 189
    //   336: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload_1
    //   340: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   343: ldc_w 411
    //   346: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: iload_2
    //   350: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 194	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   359: ldc 113
    //   361: new 115	java/lang/StringBuilder
    //   364: dup
    //   365: ldc 187
    //   367: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   370: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   373: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 147
    //   378: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_0
    //   382: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: ldc 196
    //   387: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: lload 5
    //   392: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   395: ldc 201
    //   397: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: lload 7
    //   402: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   405: ldc 203
    //   407: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: lload 9
    //   412: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   415: ldc 205
    //   417: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: lload 11
    //   422: invokevirtual 199	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   425: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 194	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload 16
    //   433: areturn
    //   434: astore 15
    //   436: aconst_null
    //   437: astore 14
    //   439: aload 14
    //   441: astore 13
    //   443: ldc 113
    //   445: new 115	java/lang/StringBuilder
    //   448: dup
    //   449: ldc 117
    //   451: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   454: invokestatic 126	com/tencent/mm/compatible/util/g:zI	()Ljava/lang/String;
    //   457: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc 147
    //   462: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_0
    //   466: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc 207
    //   471: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: aload 16
    //   476: getfield 409	com/tencent/mm/modelvideo/t$b:eIh	I
    //   479: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   482: ldc 209
    //   484: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 15
    //   489: invokevirtual 212	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   492: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc 214
    //   497: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 141	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   506: aload 14
    //   508: astore 13
    //   510: aload 16
    //   512: iconst_0
    //   513: invokestatic 145	com/tencent/mm/compatible/util/g:getLine	()I
    //   516: isub
    //   517: putfield 389	com/tencent/mm/modelvideo/t$b:ret	I
    //   520: aload 14
    //   522: ifnull -466 -> 56
    //   525: aload 14
    //   527: invokevirtual 185	java/io/RandomAccessFile:close	()V
    //   530: aload 16
    //   532: areturn
    //   533: astore_0
    //   534: aload 16
    //   536: areturn
    //   537: astore_0
    //   538: aconst_null
    //   539: astore 13
    //   541: aload 13
    //   543: ifnull +8 -> 551
    //   546: aload 13
    //   548: invokevirtual 185	java/io/RandomAccessFile:close	()V
    //   551: aload_0
    //   552: athrow
    //   553: astore 13
    //   555: goto -247 -> 308
    //   558: astore 13
    //   560: goto -9 -> 551
    //   563: astore_0
    //   564: goto -23 -> 541
    //   567: astore 15
    //   569: goto -130 -> 439
    //   572: iload 4
    //   574: istore_3
    //   575: goto -294 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	paramString	String
    //   0	578	1	paramInt1	int
    //   0	578	2	paramInt2	int
    //   1	574	3	i	int
    //   252	321	4	j	int
    //   212	179	5	l1	long
    //   234	167	7	l2	long
    //   263	148	9	l3	long
    //   274	147	11	l4	long
    //   205	342	13	localRandomAccessFile1	java.io.RandomAccessFile
    //   553	1	13	localException1	java.lang.Exception
    //   558	1	13	localException2	java.lang.Exception
    //   201	325	14	localRandomAccessFile2	java.io.RandomAccessFile
    //   180	90	15	locala	com.tencent.mm.compatible.util.g.a
    //   434	54	15	localException3	java.lang.Exception
    //   567	1	15	localException4	java.lang.Exception
    //   9	526	16	localb	t.b
    // Exception table:
    //   from	to	target	type
    //   190	203	434	java/lang/Exception
    //   525	530	533	java/lang/Exception
    //   190	203	537	finally
    //   303	308	553	java/lang/Exception
    //   546	551	558	java/lang/Exception
    //   207	214	563	finally
    //   218	225	563	finally
    //   229	236	563	finally
    //   240	254	563	finally
    //   258	265	563	finally
    //   269	276	563	finally
    //   285	291	563	finally
    //   295	303	563	finally
    //   443	506	563	finally
    //   510	520	563	finally
    //   207	214	567	java/lang/Exception
    //   218	225	567	java/lang/Exception
    //   229	236	567	java/lang/Exception
    //   240	254	567	java/lang/Exception
    //   258	265	567	java/lang/Exception
    //   269	276	567	java/lang/Exception
    //   285	291	567	java/lang/Exception
    //   295	303	567	java/lang/Exception
  }
  
  public static String nR(String paramString)
  {
    long l = System.currentTimeMillis();
    String str2 = new SimpleDateFormat("HHmmssddMMyy").format(new Date(l));
    String str1 = str2;
    if (paramString != null)
    {
      str1 = str2;
      if (paramString.length() > 1) {
        str1 = str2 + com.tencent.mm.a.g.o(paramString.getBytes()).substring(0, 7);
      }
    }
    paramString = str1 + l % 10000L;
    paramString = new StringBuilder().append(paramString);
    l = eHS;
    eHS = 1L + l;
    return l;
  }
  
  public static String nS(String paramString)
  {
    if (bk.bl(paramString)) {
      paramString = null;
    }
    String str;
    do
    {
      return paramString;
      str = getVideoPath() + paramString;
      paramString = str;
    } while (com.tencent.mm.vfs.e.bK(str));
    return str + ".mp4";
  }
  
  public static String nT(String paramString)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    return getVideoPath() + paramString + ".jpg";
  }
  
  public static int nU(String paramString)
  {
    int j = 0;
    int i;
    if (bk.bl(paramString)) {
      i = -1;
    }
    int k;
    do
    {
      do
      {
        return i;
        paramString = new b(paramString);
        i = j;
      } while (!paramString.exists());
      k = (int)paramString.length();
      i = j;
    } while (k <= 0);
    return k;
  }
  
  /* Error */
  static int[] nV(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: bipush 33
    //   4: newarray int
    //   6: astore 10
    //   8: invokestatic 229	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   11: lstore 4
    //   13: aload_0
    //   14: invokestatic 477	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   17: l2i
    //   18: istore_2
    //   19: iload_2
    //   20: ldc_w 478
    //   23: if_icmplt +10 -> 33
    //   26: iload_2
    //   27: ldc_w 479
    //   30: if_icmplt +76 -> 106
    //   33: ldc 113
    //   35: ldc_w 481
    //   38: iconst_2
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: iload_2
    //   45: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: aload_0
    //   52: aastore
    //   53: invokestatic 233	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: getstatic 319	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   59: astore_0
    //   60: iload_2
    //   61: ldc_w 478
    //   64: if_icmpge +36 -> 100
    //   67: bipush 10
    //   69: istore_1
    //   70: aload_0
    //   71: sipush 12696
    //   74: iconst_2
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: iload_1
    //   81: bipush 101
    //   83: iadd
    //   84: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: iload_2
    //   91: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   94: aastore
    //   95: invokevirtual 325	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   98: aconst_null
    //   99: areturn
    //   100: bipush 20
    //   102: istore_1
    //   103: goto -33 -> 70
    //   106: aload 10
    //   108: bipush 32
    //   110: iload_2
    //   111: iastore
    //   112: iload_2
    //   113: sipush 20480
    //   116: isub
    //   117: bipush 32
    //   119: idiv
    //   120: istore_3
    //   121: sipush 512
    //   124: newarray byte
    //   126: astore 11
    //   128: new 163	java/io/RandomAccessFile
    //   131: dup
    //   132: aload_0
    //   133: ldc_w 399
    //   136: invokespecial 167	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   165: invokevirtual 175	java/io/RandomAccessFile:seek	(J)V
    //   168: aload 9
    //   170: astore 8
    //   172: aload 9
    //   174: aload 11
    //   176: invokevirtual 485	java/io/RandomAccessFile:readFully	([B)V
    //   179: aload 9
    //   181: astore 8
    //   183: aload 10
    //   185: iload_1
    //   186: aload 11
    //   188: sipush 512
    //   191: invokestatic 491	com/tencent/mm/a/h:p	([BI)I
    //   194: ldc_w 492
    //   197: irem
    //   198: ldc_w 492
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
    //   216: invokevirtual 185	java/io/RandomAccessFile:close	()V
    //   219: aload 9
    //   221: astore 8
    //   223: ldc 113
    //   225: ldc_w 494
    //   228: iconst_3
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: lload 4
    //   236: invokestatic 305	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   239: invokestatic 310	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: iload_2
    //   246: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   249: aastore
    //   250: dup
    //   251: iconst_2
    //   252: aload_0
    //   253: aastore
    //   254: invokestatic 226	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: aload 9
    //   259: invokevirtual 185	java/io/RandomAccessFile:close	()V
    //   262: aload 10
    //   264: areturn
    //   265: astore_0
    //   266: aload 10
    //   268: areturn
    //   269: astore 10
    //   271: aconst_null
    //   272: astore 9
    //   274: aload 9
    //   276: astore 8
    //   278: ldc 113
    //   280: ldc_w 496
    //   283: iconst_2
    //   284: anewarray 4	java/lang/Object
    //   287: dup
    //   288: iconst_0
    //   289: aload_0
    //   290: aastore
    //   291: dup
    //   292: iconst_1
    //   293: aload 10
    //   295: invokestatic 500	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   298: aastore
    //   299: invokestatic 233	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: aload 9
    //   304: ifnull +8 -> 312
    //   307: aload 9
    //   309: invokevirtual 185	java/io/RandomAccessFile:close	()V
    //   312: aconst_null
    //   313: areturn
    //   314: astore_0
    //   315: aconst_null
    //   316: astore 8
    //   318: aload 8
    //   320: ifnull +8 -> 328
    //   323: aload 8
    //   325: invokevirtual 185	java/io/RandomAccessFile:close	()V
    //   328: aload_0
    //   329: athrow
    //   330: astore_0
    //   331: goto -19 -> 312
    //   334: astore 8
    //   336: goto -8 -> 328
    //   339: astore_0
    //   340: goto -22 -> 318
    //   343: astore 10
    //   345: goto -71 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramString	String
    //   1	206	1	i	int
    //   18	228	2	j	int
    //   120	30	3	k	int
    //   11	224	4	l1	long
    //   155	9	6	l2	long
    //   159	165	8	localRandomAccessFile1	java.io.RandomAccessFile
    //   334	1	8	localException1	java.lang.Exception
    //   139	169	9	localRandomAccessFile2	java.io.RandomAccessFile
    //   6	261	10	arrayOfInt	int[]
    //   269	25	10	localException2	java.lang.Exception
    //   343	1	10	localException3	java.lang.Exception
    //   126	61	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   257	262	265	java/lang/Exception
    //   128	141	269	java/lang/Exception
    //   128	141	314	finally
    //   307	312	330	java/lang/Exception
    //   323	328	334	java/lang/Exception
    //   161	168	339	finally
    //   172	179	339	finally
    //   183	203	339	finally
    //   214	219	339	finally
    //   223	257	339	finally
    //   278	302	339	finally
    //   161	168	343	java/lang/Exception
    //   172	179	343	java/lang/Exception
    //   183	203	343	java/lang/Exception
    //   214	219	343	java/lang/Exception
    //   223	257	343	java/lang/Exception
  }
  
  public final List<s> SI()
  {
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=200 order by masssendid desc";
    ArrayList localArrayList = new ArrayList();
    localObject = this.dXo.a((String)localObject, null, 2);
    int i = 0;
    while (((Cursor)localObject).moveToNext())
    {
      s locals = new s();
      locals.d((Cursor)localObject);
      localArrayList.add(locals);
      i += 1;
    }
    ((Cursor)localObject).close();
    y.d("MicroMsg.VideoInfoStorage", "getUnfinishMassInfo resCount:" + i);
    return localArrayList;
  }
  
  public final List<s> SJ()
  {
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2  " + " WHERE status=198 AND masssendid > 0 order by masssendid desc";
    ArrayList localArrayList = new ArrayList();
    localObject = this.dXo.a((String)localObject, null, 2);
    while (((Cursor)localObject).moveToNext())
    {
      s locals = new s();
      locals.d((Cursor)localObject);
      localArrayList.add(locals);
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public final List<String> SK()
  {
    ArrayList localArrayList = null;
    Object localObject1 = "select videoinfo2.filename,downloadtime from videoinfo2  " + " WHERE status=112 ORDER BY downloadtime DESC " + " LIMIT 10";
    try
    {
      localObject1 = this.dXo.a((String)localObject1, null, 2);
      boolean bool;
      if (localObject1 == null) {
        break label109;
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
        return localArrayList;
      }
      finally
      {
        break label99;
      }
      localObject2 = finally;
      localObject1 = null;
    }
    label99:
    ((Cursor)localObject1).close();
    label109:
    throw localObject2;
  }
  
  public final List<String> SL()
  {
    ArrayList localArrayList = null;
    Object localObject1 = " SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=122" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " UNION SELECT * FROM ( ";
    localObject1 = (String)localObject1 + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=120" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " ORDER BY downloadtime DESC";
    try
    {
      localObject1 = this.dXo.a((String)localObject1, null, 2);
      boolean bool;
      if (localObject1 == null) {
        break label178;
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
        return localArrayList;
      }
      finally
      {
        break label168;
      }
      localObject2 = finally;
      localObject1 = null;
    }
    label168:
    ((Cursor)localObject1).close();
    label178:
    throw localObject2;
  }
  
  public final List<String> SM()
  {
    ArrayList localArrayList = null;
    Object localObject1 = " SELECT * FROM ( " + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=103" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " UNION SELECT * FROM ( ";
    localObject1 = (String)localObject1 + "select videoinfo2.filename,downloadtime from videoinfo2   WHERE status=104" + " LIMIT 10 )";
    localObject1 = (String)localObject1 + " ORDER BY downloadtime DESC";
    try
    {
      localObject1 = this.dXo.a((String)localObject1, null, 2);
      boolean bool;
      if (localObject1 == null) {
        break label178;
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
        return localArrayList;
      }
      finally
      {
        break label168;
      }
      localObject2 = finally;
      localObject1 = null;
    }
    label168:
    ((Cursor)localObject1).close();
    label178:
    throw localObject2;
  }
  
  public final void a(t.a parama)
  {
    this.ebu.remove(parama);
  }
  
  public final void a(t.a parama, Looper paramLooper)
  {
    this.ebu.a(parama, paramLooper);
  }
  
  public final boolean b(s params)
  {
    if (params == null) {}
    ContentValues localContentValues;
    do
    {
      return false;
      params.bcw = -1;
      localContentValues = params.vf();
    } while ((int)this.dXo.insert("videoinfo2", "filename", localContentValues) == -1);
    params = new a.a(params.getFileName(), t.a.b.eHZ, t.a.c.eId, params.eHO, params.eFV);
    this.ebu.bV(params);
    this.ebu.doNotify();
    return true;
  }
  
  public final boolean c(s params)
  {
    boolean bool;
    if (params != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (params.getFileName().length() <= 0) {
        break label53;
      }
      bool = true;
      label22:
      Assert.assertTrue(bool);
      localObject = params.vf();
      if (((ContentValues)localObject).size() > 0) {
        break label58;
      }
      y.e("MicroMsg.VideoInfoStorage", "update failed, no values set");
    }
    label53:
    label58:
    while (this.dXo.update("videoinfo2", (ContentValues)localObject, "filename= ?", new String[] { params.getFileName() }) <= 0)
    {
      return false;
      bool = false;
      break;
      bool = false;
      break label22;
    }
    Object localObject = t.a.c.eId;
    if (params.status == 112) {}
    for (localObject = t.a.c.eIf;; localObject = t.a.c.eIe) {
      do
      {
        params = new a.a(params.getFileName(), t.a.b.eIb, (t.a.c)localObject, params.eHO, params.eFV);
        this.ebu.bV(params);
        this.ebu.doNotify();
        return true;
      } while ((params.status != 103) && (params.status != 104));
    }
  }
  
  public final List<s> ci(long paramLong)
  {
    Object localObject = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.masssendid = " + paramLong;
    localObject = this.dXo.a((String)localObject, null, 2);
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    while (((Cursor)localObject).moveToNext())
    {
      s locals = new s();
      locals.d((Cursor)localObject);
      localArrayList.add(locals);
    }
    ((Cursor)localObject).close();
    return localArrayList;
  }
  
  public final List<s> m(int paramInt, long paramLong)
  {
    ArrayList localArrayList = null;
    Object localObject1 = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where status=" + paramInt + " AND preloadsize > 0 AND lastmodifytime <= " + paramLong + " ORDER BY createtime LIMIT 1";
    try
    {
      localObject1 = this.dXo.a((String)localObject1, null, 2);
      s locals;
      boolean bool;
      if (localObject1 == null) {
        break label142;
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
            locals = new s();
            locals.d((Cursor)localObject1);
            localArrayList.add(locals);
            bool = ((Cursor)localObject1).moveToNext();
          } while (bool);
        }
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        return localArrayList;
      }
      finally
      {
        break label130;
      }
      localObject2 = finally;
      localObject1 = null;
    }
    label130:
    ((Cursor)localObject1).close();
    label142:
    throw localObject2;
  }
  
  public final s nQ(String paramString)
  {
    Object localObject = null;
    paramString = "select videoinfo2.filename,videoinfo2.clientid,videoinfo2.msgsvrid,videoinfo2.netoffset,videoinfo2.filenowsize,videoinfo2.totallen,videoinfo2.thumbnetoffset,videoinfo2.thumblen,videoinfo2.status,videoinfo2.createtime,videoinfo2.lastmodifytime,videoinfo2.downloadtime,videoinfo2.videolength,videoinfo2.msglocalid,videoinfo2.nettimes,videoinfo2.cameratype,videoinfo2.user,videoinfo2.human,videoinfo2.reserved1,videoinfo2.reserved2,videoinfo2.reserved3,videoinfo2.reserved4,videoinfo2.videofuncflag,videoinfo2.masssendid,videoinfo2.masssendlist,videoinfo2.videomd5,videoinfo2.streamvideo,videoinfo2.statextstr,videoinfo2.downloadscene,videoinfo2.mmsightextinfo,videoinfo2.preloadsize,videoinfo2.videoformat from videoinfo2   where videoinfo2.filename = \"" + bk.pl(paramString) + "\"";
    Cursor localCursor = this.dXo.a(paramString, null, 2);
    if (localCursor == null) {
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new s();
      paramString.d(localCursor);
    }
    localCursor.close();
    return paramString;
  }
  
  public final boolean q(String paramString1, String paramString2, String paramString3)
  {
    return aG(paramString1, paramString2 + "##" + paramString3);
  }
  
  public static final class a$a
  {
    public final long eFV;
    public final int eHO;
    public final t.a.b eHX;
    public final t.a.c eHY;
    public final String fileName;
    
    public a$a(String paramString, t.a.b paramb, t.a.c paramc, int paramInt, long paramLong)
    {
      this.fileName = paramString;
      this.eHX = paramb;
      this.eHY = paramc;
      this.eHO = paramInt;
      this.eFV = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.t
 * JD-Core Version:    0.7.0.1
 */