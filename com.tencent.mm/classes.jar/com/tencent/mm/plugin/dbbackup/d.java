package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.cg.f;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public final class d
  implements at
{
  private static final SQLiteCipherSpec kUa;
  private volatile BackupKit kTM;
  private volatile RecoverKit kTN;
  private volatile RepairKit kTO;
  private volatile boolean kTP;
  private boolean kTQ;
  private boolean kTR;
  private long kTS;
  private long kTT;
  private long kTU;
  private int kTV;
  private boolean kTW;
  final SimpleDateFormat kTX;
  private k.a kTY;
  private com.tencent.mm.sdk.b.c kTZ;
  private boolean kkm;
  private boolean kkn;
  private BroadcastReceiver kko;
  private Runnable kkp;
  
  static
  {
    AppMethodBeat.i(19001);
    kUa = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    AppMethodBeat.o(19001);
  }
  
  public d()
  {
    AppMethodBeat.i(18982);
    this.kTP = false;
    this.kTQ = false;
    this.kTR = false;
    this.kTS = 0L;
    this.kTT = 600000L;
    this.kkm = false;
    this.kkn = true;
    this.kTU = 0L;
    this.kTV = 10;
    this.kTW = false;
    this.kTX = new SimpleDateFormat("HH:mm:ss.SSS");
    AppMethodBeat.o(18982);
  }
  
  /* Error */
  private static long[] Ju(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 7
    //   3: sipush 18984
    //   6: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 103	java/io/BufferedReader
    //   12: dup
    //   13: new 105	com/tencent/mm/vfs/g
    //   16: dup
    //   17: new 107	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   24: aload_0
    //   25: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 114
    //   30: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 119	com/tencent/mm/vfs/g:<init>	(Ljava/lang/String;)V
    //   39: invokespecial 122	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore 10
    //   44: aload 10
    //   46: astore 9
    //   48: aload 10
    //   50: invokevirtual 125	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 11
    //   55: aload 11
    //   57: ifnull +225 -> 282
    //   60: aload 10
    //   62: astore 9
    //   64: aload 11
    //   66: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   69: lstore_1
    //   70: aload 10
    //   72: astore 9
    //   74: aload 10
    //   76: invokevirtual 125	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore 11
    //   81: aload 11
    //   83: ifnull +194 -> 277
    //   86: aload 10
    //   88: astore 9
    //   90: aload 11
    //   92: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   95: lstore_3
    //   96: aload 10
    //   98: astore 9
    //   100: aload 10
    //   102: invokevirtual 125	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   105: astore 11
    //   107: aload 11
    //   109: ifnull +162 -> 271
    //   112: aload 10
    //   114: astore 9
    //   116: aload 11
    //   118: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   121: lstore 5
    //   123: aload 10
    //   125: astore 9
    //   127: aload 10
    //   129: invokevirtual 125	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   132: astore 11
    //   134: aload 11
    //   136: ifnull +14 -> 150
    //   139: aload 10
    //   141: astore 9
    //   143: aload 11
    //   145: invokestatic 131	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   148: lstore 7
    //   150: aload 10
    //   152: invokevirtual 134	java/io/BufferedReader:close	()V
    //   155: sipush 18984
    //   158: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: iconst_4
    //   162: newarray long
    //   164: dup
    //   165: iconst_0
    //   166: lload_1
    //   167: lastore
    //   168: dup
    //   169: iconst_1
    //   170: lload_3
    //   171: lastore
    //   172: dup
    //   173: iconst_2
    //   174: lload 5
    //   176: lastore
    //   177: dup
    //   178: iconst_3
    //   179: lload 7
    //   181: lastore
    //   182: areturn
    //   183: astore 11
    //   185: aconst_null
    //   186: astore 10
    //   188: aload 10
    //   190: astore 9
    //   192: ldc 136
    //   194: aload 11
    //   196: ldc 138
    //   198: iconst_1
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_0
    //   205: aastore
    //   206: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload 10
    //   211: ifnull +8 -> 219
    //   214: aload 10
    //   216: invokevirtual 134	java/io/BufferedReader:close	()V
    //   219: sipush 18984
    //   222: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aconst_null
    //   226: areturn
    //   227: astore_0
    //   228: aconst_null
    //   229: astore 9
    //   231: aload 9
    //   233: ifnull +8 -> 241
    //   236: aload 9
    //   238: invokevirtual 134	java/io/BufferedReader:close	()V
    //   241: sipush 18984
    //   244: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aload_0
    //   248: athrow
    //   249: astore_0
    //   250: goto -95 -> 155
    //   253: astore_0
    //   254: goto -35 -> 219
    //   257: astore 9
    //   259: goto -18 -> 241
    //   262: astore_0
    //   263: goto -32 -> 231
    //   266: astore 11
    //   268: goto -80 -> 188
    //   271: lconst_0
    //   272: lstore 5
    //   274: goto -151 -> 123
    //   277: lconst_0
    //   278: lstore_3
    //   279: goto -183 -> 96
    //   282: lconst_0
    //   283: lstore_1
    //   284: goto -214 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramString	String
    //   69	215	1	l1	long
    //   95	184	3	l2	long
    //   121	152	5	l3	long
    //   1	179	7	l4	long
    //   46	191	9	localBufferedReader1	java.io.BufferedReader
    //   257	1	9	localIOException	java.io.IOException
    //   42	173	10	localBufferedReader2	java.io.BufferedReader
    //   53	91	11	str	String
    //   183	12	11	localException1	java.lang.Exception
    //   266	1	11	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   9	44	183	java/lang/Exception
    //   9	44	227	finally
    //   150	155	249	java/io/IOException
    //   214	219	253	java/io/IOException
    //   236	241	257	java/io/IOException
    //   48	55	262	finally
    //   64	70	262	finally
    //   74	81	262	finally
    //   90	96	262	finally
    //   100	107	262	finally
    //   116	123	262	finally
    //   127	134	262	finally
    //   143	150	262	finally
    //   192	209	262	finally
    //   48	55	266	java/lang/Exception
    //   64	70	266	java/lang/Exception
    //   74	81	266	java/lang/Exception
    //   90	96	266	java/lang/Exception
    //   100	107	266	java/lang/Exception
    //   116	123	266	java/lang/Exception
    //   127	134	266	java/lang/Exception
    //   143	150	266	java/lang/Exception
  }
  
  /* Error */
  private static boolean a(String paramString, long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: sipush 18985
    //   3: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 164	com/tencent/mm/vfs/h
    //   9: dup
    //   10: new 107	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   17: aload_0
    //   18: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 114
    //   23: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 165	com/tencent/mm/vfs/h:<init>	(Ljava/lang/String;)V
    //   32: astore 7
    //   34: aload 7
    //   36: astore 6
    //   38: aload_1
    //   39: arraylength
    //   40: istore_3
    //   41: iconst_0
    //   42: istore_2
    //   43: iload_2
    //   44: iload_3
    //   45: if_icmpge +47 -> 92
    //   48: aload_1
    //   49: iload_2
    //   50: laload
    //   51: lstore 4
    //   53: aload 7
    //   55: astore 6
    //   57: aload 7
    //   59: new 107	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   66: lload 4
    //   68: invokestatic 168	java/lang/Long:toString	(J)Ljava/lang/String;
    //   71: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 170
    //   76: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 173	com/tencent/mm/vfs/h:write	(Ljava/lang/String;)V
    //   85: iload_2
    //   86: iconst_1
    //   87: iadd
    //   88: istore_2
    //   89: goto -46 -> 43
    //   92: aload 7
    //   94: invokevirtual 174	com/tencent/mm/vfs/h:close	()V
    //   97: sipush 18985
    //   100: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iconst_1
    //   104: ireturn
    //   105: astore 8
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: astore 6
    //   112: ldc 136
    //   114: aload 8
    //   116: ldc 176
    //   118: iconst_1
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_0
    //   125: aastore
    //   126: invokestatic 144	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 174	com/tencent/mm/vfs/h:close	()V
    //   137: sipush 18985
    //   140: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_0
    //   146: aconst_null
    //   147: astore 6
    //   149: aload 6
    //   151: ifnull +8 -> 159
    //   154: aload 6
    //   156: invokevirtual 174	com/tencent/mm/vfs/h:close	()V
    //   159: sipush 18985
    //   162: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload_0
    //   166: athrow
    //   167: astore_0
    //   168: goto -71 -> 97
    //   171: astore_0
    //   172: goto -35 -> 137
    //   175: astore_1
    //   176: goto -17 -> 159
    //   179: astore_0
    //   180: goto -31 -> 149
    //   183: astore 8
    //   185: aload 7
    //   187: astore_1
    //   188: goto -79 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramString	String
    //   0	191	1	paramArrayOfLong	long[]
    //   42	47	2	i	int
    //   40	6	3	j	int
    //   51	16	4	l	long
    //   36	119	6	localObject	Object
    //   32	154	7	localh	com.tencent.mm.vfs.h
    //   105	10	8	localIOException1	java.io.IOException
    //   183	1	8	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   6	34	105	java/io/IOException
    //   6	34	145	finally
    //   92	97	167	java/io/IOException
    //   133	137	171	java/io/IOException
    //   154	159	175	java/io/IOException
    //   38	41	179	finally
    //   57	85	179	finally
    //   112	129	179	finally
    //   38	41	183	java/io/IOException
    //   57	85	183	java/io/IOException
  }
  
  private static long[] a(SQLiteDatabase paramSQLiteDatabase)
  {
    long l4 = -1L;
    AppMethodBeat.i(18983);
    com.tencent.wcdb.Cursor localCursor = paramSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(msgId) FROM message;", null, null);
    if (localCursor.moveToFirst()) {}
    for (long l1 = localCursor.getLong(0);; l1 = -1L)
    {
      localCursor.close();
      localCursor = paramSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(id) FROM ImgInfo2;", null, null);
      if (localCursor.moveToFirst()) {}
      for (long l2 = localCursor.getLong(0);; l2 = -1L)
      {
        localCursor.close();
        localCursor = paramSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM videoinfo2;", null, null);
        if (localCursor.moveToFirst()) {}
        for (long l3 = localCursor.getLong(0);; l3 = -1L)
        {
          localCursor.close();
          paramSQLiteDatabase = paramSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM EmojiInfo;", null, null);
          if (paramSQLiteDatabase.moveToFirst()) {
            l4 = paramSQLiteDatabase.getLong(0);
          }
          paramSQLiteDatabase.close();
          AppMethodBeat.o(18983);
          return new long[] { l1, l2, l3, l4 };
        }
      }
    }
  }
  
  private static String[] a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    AppMethodBeat.i(18986);
    if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length >= 4))
    {
      str1 = String.format("msgId > %d AND msgId <= %d", new Object[] { Long.valueOf(paramArrayOfLong2[0]), Long.valueOf(paramArrayOfLong1[0]) });
      str2 = String.format("id > %d AND id <= %d", new Object[] { Long.valueOf(paramArrayOfLong2[1]), Long.valueOf(paramArrayOfLong1[1]) });
      String str3 = String.format("rowid > %d AND rowid <= %d", new Object[] { Long.valueOf(paramArrayOfLong2[2]), Long.valueOf(paramArrayOfLong1[2]) });
      paramArrayOfLong1 = String.format("rowid > %d AND rowid <= %d", new Object[] { Long.valueOf(paramArrayOfLong2[3]), Long.valueOf(paramArrayOfLong1[3]) });
      AppMethodBeat.o(18986);
      return new String[] { "message", str1, "ImgInfo2", str2, "videoinfo2", str3, "EmojiInfo", paramArrayOfLong1, "conversation", null, "rconversation", null };
    }
    paramArrayOfLong2 = "msgId <= " + paramArrayOfLong1[0];
    String str1 = "id <= " + paramArrayOfLong1[1];
    String str2 = "rowid <= " + paramArrayOfLong1[2];
    paramArrayOfLong1 = "rowid <= " + paramArrayOfLong1[3];
    AppMethodBeat.o(18986);
    return new String[] { "message", paramArrayOfLong2, "ImgInfo2", str1, "videoinfo2", str2, "EmojiInfo", paramArrayOfLong1, "conversation", null, "rconversation", null };
  }
  
  private static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(18987);
    Object localObject1 = paramSQLiteDatabase.getPath();
    Object localObject2 = (String)localObject1 + ".sm";
    String str = (String)localObject2 + ".tmp";
    localObject1 = com.tencent.mm.kernel.g.RL().Ru();
    long l2 = ((z)localObject1).Ns(237569);
    long l1 = System.currentTimeMillis();
    localObject2 = new com.tencent.mm.vfs.b((String)localObject2);
    if ((((com.tencent.mm.vfs.b)localObject2).exists()) && (l1 - l2 < 86400000L))
    {
      AppMethodBeat.o(18987);
      return true;
    }
    l2 = System.nanoTime();
    Object localObject3 = new StringBuilder().append(q.bP(true));
    aw.aaz();
    byte[] arrayOfByte = com.tencent.mm.a.g.x(com.tencent.mm.model.c.getUin().getBytes());
    localObject3 = new com.tencent.mm.vfs.b(str);
    try
    {
      bool = RepairKit.MasterInfo.save(paramSQLiteDatabase, str, arrayOfByte);
      if (bool)
      {
        ((com.tencent.mm.vfs.b)localObject2).delete();
        bool = ((com.tencent.mm.vfs.b)localObject3).p((com.tencent.mm.vfs.b)localObject2);
        ((z)localObject1).setLong(237569, l1);
        ((z)localObject1).dww();
        l1 = System.nanoTime();
        if (!bool) {
          break label318;
        }
        paramSQLiteDatabase = "SUCCEEDED";
        ab.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", new Object[] { paramSQLiteDatabase, Float.valueOf((float)(l1 - l2) / 1.0E+009F) });
        paramSQLiteDatabase = com.tencent.mm.plugin.report.service.h.qsU;
        if (!bool) {
          break label325;
        }
        l1 = 24L;
        paramSQLiteDatabase.idkeyStat(181L, l1, 1L, false);
        AppMethodBeat.o(18987);
        return bool;
      }
    }
    catch (RuntimeException paramSQLiteDatabase)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SubCoreDBBackup", paramSQLiteDatabase, "Failed to backup database master.", new Object[0]);
        boolean bool = false;
        continue;
        ((com.tencent.mm.vfs.b)localObject3).delete();
        continue;
        label318:
        paramSQLiteDatabase = "FAILED";
        continue;
        label325:
        l1 = 25L;
      }
    }
  }
  
  private static void biQ()
  {
    AppMethodBeat.i(18995);
    Object localObject = com.tencent.mm.model.c.c.abU().me("100274");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).dvN();
      HashMap localHashMap = new HashMap();
      localHashMap.put("flags", Integer.valueOf(bo.getInt((String)((Map)localObject).get("flags"), 0)));
      localHashMap.put("acp", Integer.valueOf(bo.getInt((String)((Map)localObject).get("acp"), 100)));
      f.aW(localHashMap);
    }
    AppMethodBeat.o(18995);
  }
  
  static void biR()
  {
    AppMethodBeat.i(18996);
    Object localObject = com.tencent.mm.model.c.YC();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject).bPY();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject).bQa();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject).bPZ();
    com.tencent.mm.model.c.YF().dxf();
    o.ahC().ahk();
    localObject = com.tencent.mm.model.c.Ru();
    ((z)localObject).set(ac.a.yyg, Integer.valueOf(0));
    ((z)localObject).set(ac.a.yyh, Integer.valueOf(0));
    ((z)localObject).set(ac.a.yyi, Integer.valueOf(0));
    AppMethodBeat.o(18996);
  }
  
  public static void biS()
  {
    AppMethodBeat.i(18998);
    MMAppMgr.qr(true);
    AppMethodBeat.o(18998);
  }
  
  public static void dG(Context paramContext)
  {
    AppMethodBeat.i(18997);
    MMAppMgr.l(paramContext, true);
    AppMethodBeat.o(18997);
  }
  
  @Deprecated
  public final int a(b paramb)
  {
    AppMethodBeat.i(18992);
    aw.aaz();
    Object localObject1 = com.tencent.mm.model.c.Ro();
    if ((localObject1 == null) || (((String)localObject1).isEmpty()))
    {
      AppMethodBeat.o(18992);
      return -3;
    }
    localObject1 = new com.tencent.mm.vfs.b((String)localObject1);
    if (!((com.tencent.mm.vfs.b)localObject1).canRead())
    {
      AppMethodBeat.o(18992);
      return -3;
    }
    Object localObject2 = new StringBuilder().append(q.bP(true));
    aw.aaz();
    localObject2 = com.tencent.mm.a.g.w(com.tencent.mm.model.c.getUin().getBytes()).substring(0, 7);
    long l1 = ((com.tencent.mm.vfs.b)localObject1).length() * 2L;
    long l2 = bo.dtV();
    ab.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l2 < l1)
    {
      AppMethodBeat.o(18992);
      return -2;
    }
    aw.RO().Bk();
    aw.RO().ad(new d.4(this, (com.tencent.mm.vfs.b)localObject1, (String)localObject2, paramb));
    AppMethodBeat.o(18992);
    return 0;
  }
  
  @Deprecated
  public final int a(String paramString, b paramb)
  {
    try
    {
      AppMethodBeat.i(18990);
      paramString = new d.2(this, aw.aaz(), paramString, bo.dtV(), paramb);
      this.kTP = true;
      aw.RO().Bk();
      aw.RO().ad(paramString);
      AppMethodBeat.o(18990);
      return 0;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean a(boolean paramBoolean, b paramb)
  {
    AppMethodBeat.i(18988);
    if (this.kTP)
    {
      ab.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", new Object[] { "backup" });
      AppMethodBeat.o(18988);
      return false;
    }
    com.tencent.mm.model.c localc = aw.aaz();
    String str1 = com.tencent.mm.model.c.Rs();
    SQLiteDatabase localSQLiteDatabase = com.tencent.mm.model.c.Rq().dzV();
    String str2 = str1 + ".bak";
    String str3 = str2 + ".tmp";
    String str4 = str1 + ".sm";
    String str5 = str4 + ".tmp";
    int j = 8;
    int i = j;
    boolean bool = paramBoolean;
    long[] arrayOfLong2;
    long[] arrayOfLong1;
    label204:
    String[] arrayOfString;
    if (paramBoolean)
    {
      if (com.tencent.mm.vfs.e.cN(str2))
      {
        i = 24;
        com.tencent.mm.vfs.e.C(str2, str3);
        bool = paramBoolean;
      }
    }
    else
    {
      arrayOfLong2 = a(localSQLiteDatabase);
      if (!bool) {
        break label292;
      }
      arrayOfLong1 = Ju(str1);
      arrayOfString = a(arrayOfLong2, arrayOfLong1);
      if (arrayOfLong1 != null) {
        break label301;
      }
    }
    label292:
    label301:
    for (paramBoolean = false;; paramBoolean = bool)
    {
      if (this.kTW) {
        i |= 0x3;
      }
      for (;;)
      {
        paramb = new d.1(this, paramb, localc, str4, paramBoolean, localSQLiteDatabase, str5, str1, str3, arrayOfLong1, arrayOfLong2, i, arrayOfString, str2);
        this.kTP = true;
        com.tencent.mm.sdk.g.d.post(paramb, "DB Backup");
        AppMethodBeat.o(18988);
        return true;
        bool = false;
        i = j;
        break;
        arrayOfLong1 = null;
        break label204;
      }
    }
  }
  
  /* Error */
  @Deprecated
  public final int b(String paramString, b paramb)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: sipush 18991
    //   7: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 308	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   13: astore 7
    //   15: aload_1
    //   16: astore 6
    //   18: aload_1
    //   19: ifnonnull +8 -> 27
    //   22: invokestatic 531	com/tencent/mm/model/c:Ro	()Ljava/lang/String;
    //   25: astore 6
    //   27: invokestatic 553	com/tencent/mm/sdk/platformtools/bo:dtV	()J
    //   30: lstore 4
    //   32: aload 6
    //   34: ifnonnull +29 -> 63
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +10 -> 50
    //   43: aload_1
    //   44: invokevirtual 537	com/tencent/mm/vfs/b:canRead	()Z
    //   47: ifne +34 -> 81
    //   50: bipush 253
    //   52: istore_3
    //   53: sipush 18991
    //   56: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: ireturn
    //   63: new 287	com/tencent/mm/vfs/b
    //   66: dup
    //   67: aload 6
    //   69: invokespecial 288	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   72: astore_1
    //   73: goto -34 -> 39
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: ldc 136
    //   83: ldc_w 631
    //   86: iconst_2
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload_1
    //   93: invokevirtual 548	com/tencent/mm/vfs/b:length	()J
    //   96: invokestatic 217	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: lload 4
    //   104: invokestatic 217	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   107: aastore
    //   108: invokestatic 360	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: lload 4
    //   113: l2f
    //   114: aload_1
    //   115: invokevirtual 548	com/tencent/mm/vfs/b:length	()J
    //   118: l2f
    //   119: ldc_w 632
    //   122: fmul
    //   123: fcmpg
    //   124: ifge +15 -> 139
    //   127: bipush 254
    //   129: istore_3
    //   130: sipush 18991
    //   133: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: goto -77 -> 59
    //   139: new 634	com/tencent/mm/plugin/dbbackup/d$3
    //   142: dup
    //   143: aload_0
    //   144: aload 7
    //   146: aload 6
    //   148: aload_2
    //   149: invokespecial 637	com/tencent/mm/plugin/dbbackup/d$3:<init>	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/mm/model/c;Ljava/lang/String;Lcom/tencent/mm/plugin/dbbackup/b;)V
    //   152: astore_1
    //   153: aload_0
    //   154: iconst_1
    //   155: putfield 66	com/tencent/mm/plugin/dbbackup/d:kTP	Z
    //   158: invokestatic 559	com/tencent/mm/model/aw:RO	()Lcom/tencent/mm/sdk/platformtools/al;
    //   161: invokevirtual 564	com/tencent/mm/sdk/platformtools/al:Bk	()V
    //   164: invokestatic 559	com/tencent/mm/model/aw:RO	()Lcom/tencent/mm/sdk/platformtools/al;
    //   167: aload_1
    //   168: invokevirtual 573	com/tencent/mm/sdk/platformtools/al:ad	(Ljava/lang/Runnable;)I
    //   171: pop
    //   172: sipush 18991
    //   175: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: goto -119 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	d
    //   0	181	1	paramString	String
    //   0	181	2	paramb	b
    //   1	129	3	i	int
    //   30	82	4	l	long
    //   16	131	6	str	String
    //   13	132	7	localc	com.tencent.mm.model.c
    // Exception table:
    //   from	to	target	type
    //   4	15	76	finally
    //   22	27	76	finally
    //   27	32	76	finally
    //   43	50	76	finally
    //   53	59	76	finally
    //   63	73	76	finally
    //   81	127	76	finally
    //   130	136	76	finally
    //   139	178	76	finally
  }
  
  /* Error */
  public final boolean biP()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: sipush 18989
    //   7: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 66	com/tencent/mm/plugin/dbbackup/d:kTP	Z
    //   15: aload_0
    //   16: getfield 150	com/tencent/mm/plugin/dbbackup/d:kTM	Lcom/tencent/wcdb/repair/BackupKit;
    //   19: ifnonnull +13 -> 32
    //   22: sipush 18989
    //   25: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: aload_0
    //   33: getfield 150	com/tencent/mm/plugin/dbbackup/d:kTM	Lcom/tencent/wcdb/repair/BackupKit;
    //   36: invokevirtual 643	com/tencent/wcdb/repair/BackupKit:onCancel	()V
    //   39: iconst_1
    //   40: istore_1
    //   41: sipush 18989
    //   44: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: goto -19 -> 28
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	d
    //   1	40	1	bool	boolean
    //   50	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	28	50	finally
    //   32	39	50	finally
    //   41	47	50	finally
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(18993);
    aw.aaz();
    Object localObject1 = com.tencent.mm.model.c.Ru();
    SQLiteDatabase localSQLiteDatabase = com.tencent.mm.model.c.Rq().dzV();
    this.kTU = ((z)localObject1).Ns(237569);
    this.kTV = ((z)localObject1).getInt(237570, 10);
    Object localObject2;
    if (((z)localObject1).getInt(237571, 0) != 0)
    {
      paramBoolean = true;
      this.kTW = paramBoolean;
      localObject1 = ah.getContext();
      localObject2 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localObject2 == null) {
        break label557;
      }
      int i = ((Intent)localObject2).getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        break label552;
      }
      paramBoolean = true;
      label112:
      this.kkm = paramBoolean;
      label117:
      this.kkn = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.kTY = new d.7(this);
      com.tencent.mm.model.c.c.abU().add(this.kTY);
      biQ();
      this.kTZ = new d.8(this);
      a.ymk.c(this.kTZ);
      this.kko = new d.9(this);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      ((Context)localObject1).registerReceiver(this.kko, (IntentFilter)localObject2);
      com.tencent.mm.pluginsdk.cmd.b.a(new c(this), new String[] { "//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy" });
      if (!this.kTR) {
        break label565;
      }
      localObject1 = "enabled";
      label337:
      if (!this.kkn) {
        break label572;
      }
      localObject2 = "";
      label349:
      if (!this.kkm) {
        break label580;
      }
    }
    label552:
    label557:
    label565:
    label572:
    label580:
    for (String str = "";; str = " not")
    {
      ab.i("MicroMsg.SubCoreDBBackup", "Auto database backup %s. Device status:%s interactive,%s charging.", new Object[] { localObject1, localObject2, str });
      b(localSQLiteDatabase);
      com.tencent.mm.plugin.dbbackup.a.b.Jy(q.bP(true));
      com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.kernel.g.RL().eHR + "dbback/EnMicroMsg.db.bak");
      com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.kernel.g.RL().eHR + "dbback/corrupted/EnMicroMsg.db.bak");
      com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.kernel.g.RL().cachePath + "EnMicroMsg.db.bak");
      com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.kernel.g.RL().cachePath + "corrupted/EnMicroMsg.db.bak");
      localObject1 = com.tencent.mm.model.c.Rp();
      aw.RO().o(new d.6(this, (String)localObject1), 60000L);
      AppMethodBeat.o(18993);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label112;
      this.kkm = false;
      break label117;
      localObject1 = "disabled";
      break label337;
      localObject2 = " not";
      break label349;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(18994);
    biP();
    this.kTQ = false;
    if (this.kkp != null)
    {
      aw.RO().caB().removeCallbacks(this.kkp);
      this.kkp = null;
    }
    if (this.kTZ != null)
    {
      a.ymk.d(this.kTZ);
      this.kTZ = null;
    }
    if (this.kko != null)
    {
      ah.getContext().unregisterReceiver(this.kko);
      this.kko = null;
    }
    com.tencent.mm.pluginsdk.cmd.b.N(new String[] { "//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy" });
    AppMethodBeat.o(18994);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d
 * JD-Core Version:    0.7.0.1
 */