package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.br;
import com.tencent.mm.storagebase.f;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d
  implements az
{
  private static final SQLiteCipherSpec poj;
  private boolean oCl;
  private boolean oCm;
  private BroadcastReceiver oCn;
  private Runnable oCo;
  private volatile BackupKit pnV;
  private volatile RecoverKit pnW;
  private volatile RepairKit pnX;
  private volatile boolean pnY;
  private boolean pnZ;
  private boolean poa;
  private long pob;
  private long poc;
  private long pod;
  private int poe;
  private boolean pof;
  final SimpleDateFormat pog;
  private k.a poh;
  private com.tencent.mm.sdk.b.c poi;
  
  static
  {
    AppMethodBeat.i(23109);
    poj = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    AppMethodBeat.o(23109);
  }
  
  public d()
  {
    AppMethodBeat.i(23090);
    this.pnY = false;
    this.pnZ = false;
    this.poa = false;
    this.pob = 0L;
    this.poc = 600000L;
    this.oCl = false;
    this.oCm = true;
    this.pod = 0L;
    this.poe = 10;
    this.pof = false;
    this.pog = new SimpleDateFormat("HH:mm:ss.SSS");
    AppMethodBeat.o(23090);
  }
  
  /* Error */
  private static boolean a(String paramString, long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: sipush 23093
    //   3: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 139	com/tencent/mm/vfs/r
    //   9: dup
    //   10: new 141	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   17: aload_0
    //   18: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 148
    //   23: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 153	com/tencent/mm/vfs/r:<init>	(Ljava/lang/String;)V
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
    //   59: new 141	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   66: lload 4
    //   68: invokestatic 158	java/lang/Long:toString	(J)Ljava/lang/String;
    //   71: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 160
    //   76: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 163	com/tencent/mm/vfs/r:write	(Ljava/lang/String;)V
    //   85: iload_2
    //   86: iconst_1
    //   87: iadd
    //   88: istore_2
    //   89: goto -46 -> 43
    //   92: aload 7
    //   94: invokevirtual 166	com/tencent/mm/vfs/r:close	()V
    //   97: sipush 23093
    //   100: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iconst_1
    //   104: ireturn
    //   105: astore 8
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: astore 6
    //   112: ldc 168
    //   114: aload 8
    //   116: ldc 170
    //   118: iconst_1
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_0
    //   125: aastore
    //   126: invokestatic 176	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 166	com/tencent/mm/vfs/r:close	()V
    //   137: sipush 23093
    //   140: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_0
    //   146: aconst_null
    //   147: astore 6
    //   149: aload 6
    //   151: ifnull +8 -> 159
    //   154: aload 6
    //   156: invokevirtual 166	com/tencent/mm/vfs/r:close	()V
    //   159: sipush 23093
    //   162: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   32	154	7	localr	com.tencent.mm.vfs.r
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
    AppMethodBeat.i(23091);
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
          AppMethodBeat.o(23091);
          return new long[] { l1, l2, l3, l4 };
        }
      }
    }
  }
  
  private static String[] a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    AppMethodBeat.i(23094);
    if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length >= 4))
    {
      str1 = String.format("msgId > %d AND msgId <= %d", new Object[] { Long.valueOf(paramArrayOfLong2[0]), Long.valueOf(paramArrayOfLong1[0]) });
      str2 = String.format("id > %d AND id <= %d", new Object[] { Long.valueOf(paramArrayOfLong2[1]), Long.valueOf(paramArrayOfLong1[1]) });
      String str3 = String.format("rowid > %d AND rowid <= %d", new Object[] { Long.valueOf(paramArrayOfLong2[2]), Long.valueOf(paramArrayOfLong1[2]) });
      paramArrayOfLong1 = String.format("rowid > %d AND rowid <= %d", new Object[] { Long.valueOf(paramArrayOfLong2[3]), Long.valueOf(paramArrayOfLong1[3]) });
      AppMethodBeat.o(23094);
      return new String[] { "message", str1, "ImgInfo2", str2, "videoinfo2", str3, "EmojiInfo", paramArrayOfLong1, "conversation", null, "rconversation", null };
    }
    paramArrayOfLong2 = "msgId <= " + paramArrayOfLong1[0];
    String str1 = "id <= " + paramArrayOfLong1[1];
    String str2 = "rowid <= " + paramArrayOfLong1[2];
    paramArrayOfLong1 = "rowid <= " + paramArrayOfLong1[3];
    AppMethodBeat.o(23094);
    return new String[] { "message", paramArrayOfLong2, "ImgInfo2", str1, "videoinfo2", str2, "EmojiInfo", paramArrayOfLong1, "conversation", null, "rconversation", null };
  }
  
  /* Error */
  private static long[] aaL(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 7
    //   3: sipush 23092
    //   6: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 255	java/io/BufferedReader
    //   12: dup
    //   13: new 257	com/tencent/mm/vfs/q
    //   16: dup
    //   17: new 141	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   24: aload_0
    //   25: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 148
    //   30: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 258	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   39: invokespecial 261	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore 10
    //   44: aload 10
    //   46: astore 9
    //   48: aload 10
    //   50: invokevirtual 264	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 11
    //   55: aload 11
    //   57: ifnull +226 -> 283
    //   60: aload 10
    //   62: astore 9
    //   64: aload 11
    //   66: invokestatic 268	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   69: lstore_1
    //   70: aload 10
    //   72: astore 9
    //   74: aload 10
    //   76: invokevirtual 264	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore 11
    //   81: aload 11
    //   83: ifnull +195 -> 278
    //   86: aload 10
    //   88: astore 9
    //   90: aload 11
    //   92: invokestatic 268	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   95: lstore_3
    //   96: aload 10
    //   98: astore 9
    //   100: aload 10
    //   102: invokevirtual 264	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   105: astore 11
    //   107: aload 11
    //   109: ifnull +163 -> 272
    //   112: aload 10
    //   114: astore 9
    //   116: aload 11
    //   118: invokestatic 268	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   121: lstore 5
    //   123: aload 10
    //   125: astore 9
    //   127: aload 10
    //   129: invokevirtual 264	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   132: astore 11
    //   134: aload 11
    //   136: ifnull +14 -> 150
    //   139: aload 10
    //   141: astore 9
    //   143: aload 11
    //   145: invokestatic 268	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   148: lstore 7
    //   150: aload 10
    //   152: invokevirtual 269	java/io/BufferedReader:close	()V
    //   155: sipush 23092
    //   158: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   192: ldc 168
    //   194: aload 11
    //   196: ldc_w 271
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_0
    //   206: aastore
    //   207: invokestatic 176	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload 10
    //   212: ifnull +8 -> 220
    //   215: aload 10
    //   217: invokevirtual 269	java/io/BufferedReader:close	()V
    //   220: sipush 23092
    //   223: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aconst_null
    //   227: areturn
    //   228: astore_0
    //   229: aconst_null
    //   230: astore 9
    //   232: aload 9
    //   234: ifnull +8 -> 242
    //   237: aload 9
    //   239: invokevirtual 269	java/io/BufferedReader:close	()V
    //   242: sipush 23092
    //   245: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_0
    //   249: athrow
    //   250: astore_0
    //   251: goto -96 -> 155
    //   254: astore_0
    //   255: goto -35 -> 220
    //   258: astore 9
    //   260: goto -18 -> 242
    //   263: astore_0
    //   264: goto -32 -> 232
    //   267: astore 11
    //   269: goto -81 -> 188
    //   272: lconst_0
    //   273: lstore 5
    //   275: goto -152 -> 123
    //   278: lconst_0
    //   279: lstore_3
    //   280: goto -184 -> 96
    //   283: lconst_0
    //   284: lstore_1
    //   285: goto -215 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	paramString	String
    //   69	216	1	l1	long
    //   95	185	3	l2	long
    //   121	153	5	l3	long
    //   1	179	7	l4	long
    //   46	192	9	localBufferedReader1	java.io.BufferedReader
    //   258	1	9	localIOException	java.io.IOException
    //   42	174	10	localBufferedReader2	java.io.BufferedReader
    //   53	91	11	str	String
    //   183	12	11	localException1	Exception
    //   267	1	11	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   9	44	183	java/lang/Exception
    //   9	44	228	finally
    //   150	155	250	java/io/IOException
    //   215	220	254	java/io/IOException
    //   237	242	258	java/io/IOException
    //   48	55	263	finally
    //   64	70	263	finally
    //   74	81	263	finally
    //   90	96	263	finally
    //   100	107	263	finally
    //   116	123	263	finally
    //   127	134	263	finally
    //   143	150	263	finally
    //   192	210	263	finally
    //   48	55	267	java/lang/Exception
    //   64	70	267	java/lang/Exception
    //   74	81	267	java/lang/Exception
    //   90	96	267	java/lang/Exception
    //   100	107	267	java/lang/Exception
    //   116	123	267	java/lang/Exception
    //   127	134	267	java/lang/Exception
    //   143	150	267	java/lang/Exception
  }
  
  private static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(23095);
    Object localObject1 = paramSQLiteDatabase.getPath();
    Object localObject2 = (String)localObject1 + ".sm";
    String str = (String)localObject2 + ".tmp";
    localObject1 = com.tencent.mm.kernel.g.ajR().ajA();
    long l2 = ((aj)localObject1).aby(237569);
    long l1 = System.currentTimeMillis();
    localObject2 = new k((String)localObject2);
    if ((((k)localObject2).exists()) && (l1 - l2 < 86400000L))
    {
      AppMethodBeat.o(23095);
      return true;
    }
    l2 = System.nanoTime();
    Object localObject3 = new StringBuilder().append(com.tencent.mm.compatible.deviceinfo.q.cH(true));
    bc.aCg();
    byte[] arrayOfByte = com.tencent.mm.b.g.C(com.tencent.mm.model.c.getUin().getBytes());
    localObject3 = new k(str);
    try
    {
      bool = RepairKit.MasterInfo.save(paramSQLiteDatabase, com.tencent.mm.b.q.k(str, true), arrayOfByte);
      if (bool)
      {
        ((k)localObject2).delete();
        bool = ((k)localObject3).ag((k)localObject2);
        ((aj)localObject1).setLong(237569, l1);
        ((aj)localObject1).fuc();
        l1 = System.nanoTime();
        if (!bool) {
          break label322;
        }
        paramSQLiteDatabase = "SUCCEEDED";
        ae.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", new Object[] { paramSQLiteDatabase, Float.valueOf((float)(l1 - l2) / 1.0E+009F) });
        paramSQLiteDatabase = com.tencent.mm.plugin.report.service.g.yxI;
        if (!bool) {
          break label329;
        }
        l1 = 24L;
        paramSQLiteDatabase.idkeyStat(181L, l1, 1L, false);
        AppMethodBeat.o(23095);
        return bool;
      }
    }
    catch (RuntimeException paramSQLiteDatabase)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.SubCoreDBBackup", paramSQLiteDatabase, "Failed to backup database master.", new Object[0]);
        boolean bool = false;
        continue;
        ((k)localObject3).delete();
        continue;
        label322:
        paramSQLiteDatabase = "FAILED";
        continue;
        label329:
        l1 = 25L;
      }
    }
  }
  
  private static void cdc()
  {
    AppMethodBeat.i(23103);
    Object localObject = com.tencent.mm.model.c.d.aDI().xi("100274");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).fsy();
      HashMap localHashMap = new HashMap();
      localHashMap.put("flags", Integer.valueOf(bu.getInt((String)((Map)localObject).get("flags"), 0)));
      localHashMap.put("acp", Integer.valueOf(bu.getInt((String)((Map)localObject).get("acp"), 100)));
      f.bZ(localHashMap);
    }
    AppMethodBeat.o(23103);
  }
  
  static void cdd()
  {
    AppMethodBeat.i(23104);
    Object localObject = com.tencent.mm.model.c.azI();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject).doS();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject).doU();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.i)localObject).doT();
    com.tencent.mm.model.c.azL().fuN();
    com.tencent.mm.av.q.aIX().aIE();
    localObject = com.tencent.mm.model.c.ajA();
    ((aj)localObject).set(am.a.ILd, Integer.valueOf(0));
    ((aj)localObject).set(am.a.ILe, Integer.valueOf(0));
    ((aj)localObject).set(am.a.ILf, Integer.valueOf(0));
    AppMethodBeat.o(23104);
  }
  
  public static void cde()
  {
    AppMethodBeat.i(23106);
    MMAppMgr.xu(true);
    AppMethodBeat.o(23106);
  }
  
  public static void eA(Context paramContext)
  {
    AppMethodBeat.i(23105);
    MMAppMgr.m(paramContext, true);
    AppMethodBeat.o(23105);
  }
  
  @Deprecated
  public final int a(final b paramb)
  {
    AppMethodBeat.i(23100);
    bc.aCg();
    Object localObject1 = com.tencent.mm.model.c.ajv();
    if ((localObject1 == null) || (((String)localObject1).isEmpty()))
    {
      AppMethodBeat.o(23100);
      return -3;
    }
    localObject1 = new k((String)localObject1);
    if (!((k)localObject1).canRead())
    {
      AppMethodBeat.o(23100);
      return -3;
    }
    Object localObject2 = new StringBuilder().append(com.tencent.mm.compatible.deviceinfo.q.cH(true));
    bc.aCg();
    localObject2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.model.c.getUin().getBytes()).substring(0, 7);
    long l1 = ((k)localObject1).length() * 2L;
    long l2 = bu.fpK();
    ae.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l2 < l1)
    {
      AppMethodBeat.o(23100);
      return -2;
    }
    bc.ajU().Mh();
    bc.ajU().ax(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23082);
        try
        {
          Thread.sleep(200L);
          label12:
          bc.aCg();
          Object localObject2 = com.tencent.mm.model.c.ajw();
          Object localObject1 = (String)localObject2 + this.poC.getName().replace(".db", "temp.db");
          ae.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", new Object[] { localObject1 });
          this.poC.ag(new k((String)localObject1));
          String str = (String)localObject2 + "sqlTemp.sql";
          List localList = Arrays.asList(new String[] { "getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo" });
          localObject2 = new int[1];
          long l = System.currentTimeMillis();
          bc.aCg();
          boolean bool = com.tencent.mm.model.c.getDataDB().a((String)localObject1, this.val$key, str, localList, new DBDumpUtil.ExecuteSqlCallback()
          {
            public final String preExecute(String paramAnonymous2String)
            {
              paramAnonymous2String = this.poD;
              paramAnonymous2String[0] += 1;
              return null;
            }
          });
          if (bool)
          {
            bc.aCg();
            com.tencent.mm.model.c.azI().doS();
            bc.aCg();
            com.tencent.mm.model.c.azL().fuN();
            bc.aCg();
            com.tencent.mm.model.c.azI().doU();
            bc.aCg();
            com.tencent.mm.model.c.azI().doT();
            i = 12;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(181L, i, 1L, true);
            l = System.currentTimeMillis() - l;
            ae.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", new Object[] { Integer.valueOf(localObject2[0]), Long.valueOf(l) });
            localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
            if (!bool) {
              break label390;
            }
            i = 1;
            label312:
            ((com.tencent.mm.plugin.report.service.g)localObject1).f(11224, new Object[] { Integer.valueOf(i), localObject2, Long.valueOf(l) });
            bc.ajU().foO();
            if (paramb != null)
            {
              localObject1 = paramb;
              if (!bool) {
                break label395;
              }
            }
          }
          label390:
          label395:
          for (int i = 0;; i = -1)
          {
            ((b)localObject1).BA(i);
            AppMethodBeat.o(23082);
            return;
            i = 15;
            break;
            i = 0;
            break label312;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label12;
        }
      }
    });
    AppMethodBeat.o(23100);
    return 0;
  }
  
  @Deprecated
  public final int a(final String paramString, b paramb)
  {
    try
    {
      AppMethodBeat.i(23098);
      paramString = new Runnable()
      {
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: sipush 23079
          //   3: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   6: aload_0
          //   7: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   10: aconst_null
          //   11: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   14: pop
          //   15: invokestatic 55	com/tencent/mm/model/c:azI	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
          //   18: pop
          //   19: invokestatic 59	com/tencent/mm/model/c:azL	()Lcom/tencent/mm/storage/br;
          //   22: pop
          //   23: invokestatic 65	com/tencent/mm/av/q:aIX	()Lcom/tencent/mm/av/i;
          //   26: pop
          //   27: invokestatic 71	com/tencent/mm/modelvideo/o:aNh	()Lcom/tencent/mm/modelvideo/t;
          //   30: pop
          //   31: invokestatic 77	java/lang/System:nanoTime	()J
          //   34: lstore 11
          //   36: new 79	java/lang/StringBuilder
          //   39: dup
          //   40: invokespecial 80	java/lang/StringBuilder:<init>	()V
          //   43: iconst_1
          //   44: invokestatic 86	com/tencent/mm/compatible/deviceinfo/q:cH	(Z)Ljava/lang/String;
          //   47: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   50: invokestatic 94	com/tencent/mm/model/c:getUin	()I
          //   53: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   56: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   59: invokevirtual 107	java/lang/String:getBytes	()[B
          //   62: astore 14
          //   64: aload 14
          //   66: invokestatic 113	com/tencent/mm/b/g:C	([B)[B
          //   69: astore 17
          //   71: aload 14
          //   73: invokestatic 117	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
          //   76: iconst_0
          //   77: bipush 7
          //   79: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
          //   82: invokevirtual 107	java/lang/String:getBytes	()[B
          //   85: astore 14
          //   87: invokestatic 127	com/tencent/mm/storagebase/f:fxO	()Z
          //   90: pop
          //   91: invokestatic 131	com/tencent/mm/model/c:getDataDB	()Lcom/tencent/mm/storagebase/h;
          //   94: invokevirtual 137	com/tencent/mm/storagebase/h:fxU	()Lcom/tencent/wcdb/database/SQLiteDatabase;
          //   97: invokevirtual 142	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
          //   100: aload 14
          //   102: invokestatic 146	com/tencent/mm/plugin/dbbackup/d:cdf	()Lcom/tencent/wcdb/database/SQLiteCipherSpec;
          //   105: aconst_null
          //   106: ldc 147
          //   108: aconst_null
          //   109: iconst_0
          //   110: invokestatic 151	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
          //   113: astore 15
          //   115: aload 15
          //   117: astore 16
          //   119: aload_0
          //   120: getfield 29	com/tencent/mm/plugin/dbbackup/d$2:poy	Ljava/lang/String;
          //   123: ifnull +101 -> 224
          //   126: aload 15
          //   128: astore 16
          //   130: aload_0
          //   131: getfield 29	com/tencent/mm/plugin/dbbackup/d$2:poy	Ljava/lang/String;
          //   134: astore 14
          //   136: iconst_1
          //   137: anewarray 103	java/lang/String
          //   140: dup
          //   141: iconst_0
          //   142: aload 14
          //   144: aastore
          //   145: astore 14
          //   147: aload 15
          //   149: astore 16
          //   151: aload 14
          //   153: arraylength
          //   154: istore_3
          //   155: iconst_0
          //   156: istore_2
          //   157: bipush 253
          //   159: istore_1
          //   160: lconst_0
          //   161: lstore 7
          //   163: lload 7
          //   165: lstore 9
          //   167: iload_2
          //   168: iload_3
          //   169: if_icmpge +412 -> 581
          //   172: aload 14
          //   174: iload_2
          //   175: aaload
          //   176: astore 18
          //   178: lload 7
          //   180: lstore 9
          //   182: aload 15
          //   184: astore 16
          //   186: new 153	com/tencent/mm/vfs/k
          //   189: dup
          //   190: aload 18
          //   192: invokespecial 156	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
          //   195: astore 19
          //   197: lload 7
          //   199: lstore 9
          //   201: aload 15
          //   203: astore 16
          //   205: aload 19
          //   207: invokevirtual 159	com/tencent/mm/vfs/k:canRead	()Z
          //   210: istore 13
          //   212: iload 13
          //   214: ifne +102 -> 316
          //   217: iload_2
          //   218: iconst_1
          //   219: iadd
          //   220: istore_2
          //   221: goto -58 -> 163
          //   224: aload 15
          //   226: astore 16
          //   228: new 79	java/lang/StringBuilder
          //   231: dup
          //   232: invokespecial 80	java/lang/StringBuilder:<init>	()V
          //   235: invokestatic 162	com/tencent/mm/model/c:ajv	()Ljava/lang/String;
          //   238: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   241: ldc 164
          //   243: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   246: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   249: astore 14
          //   251: aload 15
          //   253: astore 16
          //   255: new 79	java/lang/StringBuilder
          //   258: dup
          //   259: invokespecial 80	java/lang/StringBuilder:<init>	()V
          //   262: astore 18
          //   264: aload 15
          //   266: astore 16
          //   268: invokestatic 170	com/tencent/mm/kernel/g:ajS	()Lcom/tencent/mm/kernel/g;
          //   271: pop
          //   272: aload 15
          //   274: astore 16
          //   276: aload 18
          //   278: invokestatic 174	com/tencent/mm/kernel/g:ajR	()Lcom/tencent/mm/kernel/e;
          //   281: getfield 179	com/tencent/mm/kernel/e:gDT	Ljava/lang/String;
          //   284: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   287: ldc 181
          //   289: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   292: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   295: astore 18
          //   297: iconst_2
          //   298: anewarray 103	java/lang/String
          //   301: dup
          //   302: iconst_0
          //   303: aload 14
          //   305: aastore
          //   306: dup
          //   307: iconst_1
          //   308: aload 18
          //   310: aastore
          //   311: astore 14
          //   313: goto -166 -> 147
          //   316: lload 7
          //   318: lstore 9
          //   320: aload 15
          //   322: astore 16
          //   324: aload 19
          //   326: invokevirtual 184	com/tencent/mm/vfs/k:length	()J
          //   329: lstore 7
          //   331: lload 7
          //   333: lstore 9
          //   335: aload 15
          //   337: astore 16
          //   339: ldc 186
          //   341: ldc 188
          //   343: iconst_2
          //   344: anewarray 4	java/lang/Object
          //   347: dup
          //   348: iconst_0
          //   349: lload 7
          //   351: invokestatic 194	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   354: aastore
          //   355: dup
          //   356: iconst_1
          //   357: aload_0
          //   358: getfield 31	com/tencent/mm/plugin/dbbackup/d$2:poz	J
          //   361: invokestatic 194	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   364: aastore
          //   365: invokestatic 199	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   368: lload 7
          //   370: lstore 9
          //   372: aload 15
          //   374: astore 16
          //   376: aload_0
          //   377: getfield 31	com/tencent/mm/plugin/dbbackup/d$2:poz	J
          //   380: ldc2_w 200
          //   383: lload 7
          //   385: lmul
          //   386: lcmp
          //   387: ifge +97 -> 484
          //   390: lload 7
          //   392: lstore 9
          //   394: aload 15
          //   396: astore 16
          //   398: aload_0
          //   399: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:pok	Lcom/tencent/mm/plugin/dbbackup/b;
          //   402: ifnull +22 -> 424
          //   405: lload 7
          //   407: lstore 9
          //   409: aload 15
          //   411: astore 16
          //   413: aload_0
          //   414: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:pok	Lcom/tencent/mm/plugin/dbbackup/b;
          //   417: bipush 254
          //   419: invokeinterface 206 2 0
          //   424: aload_0
          //   425: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   428: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   431: ifnull +22 -> 453
          //   434: aload_0
          //   435: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   438: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   441: invokevirtual 215	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   444: aload_0
          //   445: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   448: aconst_null
          //   449: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   452: pop
          //   453: aload 15
          //   455: ifnull +8 -> 463
          //   458: aload 15
          //   460: invokevirtual 218	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   463: aload_0
          //   464: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   467: invokestatic 222	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
          //   470: pop
          //   471: invokestatic 228	com/tencent/mm/model/bc:ajU	()Lcom/tencent/mm/sdk/platformtools/ar;
          //   474: invokevirtual 233	com/tencent/mm/sdk/platformtools/ar:foO	()V
          //   477: sipush 23079
          //   480: invokestatic 236	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   483: return
          //   484: lload 7
          //   486: lstore 9
          //   488: aload 15
          //   490: astore 16
          //   492: getstatic 242	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
          //   495: sipush 11098
          //   498: iconst_2
          //   499: anewarray 4	java/lang/Object
          //   502: dup
          //   503: iconst_0
          //   504: sipush 10004
          //   507: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   510: aastore
          //   511: dup
          //   512: iconst_1
          //   513: ldc 249
          //   515: iconst_2
          //   516: anewarray 4	java/lang/Object
          //   519: dup
          //   520: iconst_0
          //   521: lload 7
          //   523: invokestatic 194	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   526: aastore
          //   527: dup
          //   528: iconst_1
          //   529: aload_0
          //   530: getfield 31	com/tencent/mm/plugin/dbbackup/d$2:poz	J
          //   533: invokestatic 194	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   536: aastore
          //   537: invokestatic 253	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   540: aastore
          //   541: invokevirtual 257	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
          //   544: lload 7
          //   546: lstore 9
          //   548: aload 15
          //   550: astore 16
          //   552: aload_0
          //   553: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   556: new 212	com/tencent/wcdb/repair/RecoverKit
          //   559: dup
          //   560: aload 15
          //   562: aload 18
          //   564: iconst_0
          //   565: invokestatic 263	com/tencent/mm/b/q:k	(Ljava/lang/String;Z)Ljava/lang/String;
          //   568: aload 17
          //   570: invokespecial 266	com/tencent/wcdb/repair/RecoverKit:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[B)V
          //   573: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   576: pop
          //   577: lload 7
          //   579: lstore 9
          //   581: aload 15
          //   583: astore 16
          //   585: aload_0
          //   586: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   589: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   592: astore 14
          //   594: aload 14
          //   596: ifnonnull +250 -> 846
          //   599: bipush 253
          //   601: istore_2
          //   602: aload 15
          //   604: astore 14
          //   606: iload_2
          //   607: istore_1
          //   608: aload 15
          //   610: astore 16
          //   612: getstatic 242	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
          //   615: ldc2_w 267
          //   618: ldc2_w 269
          //   621: lconst_1
          //   622: iconst_1
          //   623: invokevirtual 274	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
          //   626: aload 15
          //   628: astore 14
          //   630: iload_2
          //   631: istore_1
          //   632: aload 15
          //   634: astore 16
          //   636: new 276	java/lang/RuntimeException
          //   639: dup
          //   640: invokespecial 277	java/lang/RuntimeException:<init>	()V
          //   643: astore 17
          //   645: aload 15
          //   647: astore 14
          //   649: iload_2
          //   650: istore_1
          //   651: aload 15
          //   653: astore 16
          //   655: sipush 23079
          //   658: invokestatic 236	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   661: aload 15
          //   663: astore 14
          //   665: iload_2
          //   666: istore_1
          //   667: aload 15
          //   669: astore 16
          //   671: aload 17
          //   673: athrow
          //   674: astore 16
          //   676: aload 14
          //   678: astore 15
          //   680: aload 16
          //   682: astore 14
          //   684: aload 15
          //   686: astore 16
          //   688: ldc 186
          //   690: aload 14
          //   692: ldc_w 279
          //   695: iconst_0
          //   696: anewarray 4	java/lang/Object
          //   699: invokestatic 283	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   702: aload 15
          //   704: astore 16
          //   706: aload_0
          //   707: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:pok	Lcom/tencent/mm/plugin/dbbackup/b;
          //   710: ifnull +17 -> 727
          //   713: aload 15
          //   715: astore 16
          //   717: aload_0
          //   718: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:pok	Lcom/tencent/mm/plugin/dbbackup/b;
          //   721: iload_1
          //   722: invokeinterface 206 2 0
          //   727: aload 15
          //   729: astore 16
          //   731: getstatic 242	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
          //   734: ldc2_w 267
          //   737: ldc2_w 284
          //   740: lconst_1
          //   741: iconst_1
          //   742: invokevirtual 274	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
          //   745: aload_0
          //   746: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   749: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   752: ifnull +22 -> 774
          //   755: aload_0
          //   756: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   759: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   762: invokevirtual 215	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   765: aload_0
          //   766: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   769: aconst_null
          //   770: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   773: pop
          //   774: aload 15
          //   776: ifnull +8 -> 784
          //   779: aload 15
          //   781: invokevirtual 218	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   784: aload_0
          //   785: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   788: invokestatic 222	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
          //   791: pop
          //   792: invokestatic 228	com/tencent/mm/model/bc:ajU	()Lcom/tencent/mm/sdk/platformtools/ar;
          //   795: invokevirtual 233	com/tencent/mm/sdk/platformtools/ar:foO	()V
          //   798: sipush 23079
          //   801: invokestatic 236	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   804: return
          //   805: astore 18
          //   807: aload 15
          //   809: astore 16
          //   811: ldc 186
          //   813: new 79	java/lang/StringBuilder
          //   816: dup
          //   817: ldc_w 287
          //   820: invokespecial 288	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   823: aload 18
          //   825: invokevirtual 291	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   828: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   831: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   834: invokestatic 295	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   837: iconst_m1
          //   838: istore_1
          //   839: lload 9
          //   841: lstore 7
          //   843: goto -626 -> 217
          //   846: aload 15
          //   848: astore 16
          //   850: aload_0
          //   851: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   854: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   857: iconst_0
          //   858: invokevirtual 298	com/tencent/wcdb/repair/RecoverKit:run	(Z)I
          //   861: istore 4
          //   863: aload 15
          //   865: astore 14
          //   867: iload 4
          //   869: istore_1
          //   870: aload 15
          //   872: astore 16
          //   874: invokestatic 301	com/tencent/mm/plugin/dbbackup/d:cdd	()V
          //   877: aload 15
          //   879: astore 14
          //   881: iload 4
          //   883: istore_1
          //   884: aload 15
          //   886: astore 16
          //   888: invokestatic 77	java/lang/System:nanoTime	()J
          //   891: lload 11
          //   893: lsub
          //   894: lstore 7
          //   896: aload 15
          //   898: astore 14
          //   900: iload 4
          //   902: istore_1
          //   903: aload 15
          //   905: astore 16
          //   907: aload_0
          //   908: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   911: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   914: invokevirtual 304	com/tencent/wcdb/repair/RecoverKit:successCount	()I
          //   917: istore 5
          //   919: aload 15
          //   921: astore 14
          //   923: iload 4
          //   925: istore_1
          //   926: aload 15
          //   928: astore 16
          //   930: aload_0
          //   931: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   934: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   937: invokevirtual 307	com/tencent/wcdb/repair/RecoverKit:failureCount	()I
          //   940: istore 6
          //   942: aload 15
          //   944: astore 14
          //   946: iload 4
          //   948: istore_1
          //   949: aload 15
          //   951: astore 16
          //   953: aload_0
          //   954: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   957: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   960: invokevirtual 310	com/tencent/wcdb/repair/RecoverKit:lastError	()Ljava/lang/String;
          //   963: astore 19
          //   965: aload 15
          //   967: astore 14
          //   969: iload 4
          //   971: istore_1
          //   972: aload 15
          //   974: astore 16
          //   976: aload_0
          //   977: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   980: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   983: invokevirtual 215	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   986: aload 15
          //   988: astore 14
          //   990: iload 4
          //   992: istore_1
          //   993: aload 15
          //   995: astore 16
          //   997: aload_0
          //   998: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1001: aconst_null
          //   1002: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1005: pop
          //   1006: aload 15
          //   1008: astore 14
          //   1010: iload 4
          //   1012: istore_1
          //   1013: aload 15
          //   1015: astore 16
          //   1017: aload 15
          //   1019: invokevirtual 218	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   1022: aconst_null
          //   1023: astore 18
          //   1025: aconst_null
          //   1026: astore 17
          //   1028: iload 4
          //   1030: ifne +275 -> 1305
          //   1033: ldc_w 312
          //   1036: astore 15
          //   1038: aload 17
          //   1040: astore 14
          //   1042: iload 4
          //   1044: istore_1
          //   1045: aload 18
          //   1047: astore 16
          //   1049: ldc 186
          //   1051: ldc_w 314
          //   1054: iconst_4
          //   1055: anewarray 4	java/lang/Object
          //   1058: dup
          //   1059: iconst_0
          //   1060: aload 15
          //   1062: aastore
          //   1063: dup
          //   1064: iconst_1
          //   1065: lload 7
          //   1067: l2f
          //   1068: ldc_w 315
          //   1071: fdiv
          //   1072: invokestatic 320	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   1075: aastore
          //   1076: dup
          //   1077: iconst_2
          //   1078: iload 5
          //   1080: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1083: aastore
          //   1084: dup
          //   1085: iconst_3
          //   1086: iload 6
          //   1088: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1091: aastore
          //   1092: invokestatic 199	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1095: iload 4
          //   1097: ifne +374 -> 1471
          //   1100: sipush 10005
          //   1103: istore_3
          //   1104: bipush 22
          //   1106: istore_2
          //   1107: aload 17
          //   1109: astore 14
          //   1111: iload 4
          //   1113: istore_1
          //   1114: aload 18
          //   1116: astore 16
          //   1118: getstatic 242	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
          //   1121: sipush 11098
          //   1124: iconst_2
          //   1125: anewarray 4	java/lang/Object
          //   1128: dup
          //   1129: iconst_0
          //   1130: iload_3
          //   1131: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1134: aastore
          //   1135: dup
          //   1136: iconst_1
          //   1137: ldc_w 322
          //   1140: iconst_4
          //   1141: anewarray 4	java/lang/Object
          //   1144: dup
          //   1145: iconst_0
          //   1146: lload 9
          //   1148: invokestatic 194	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1151: aastore
          //   1152: dup
          //   1153: iconst_1
          //   1154: lload 7
          //   1156: ldc2_w 323
          //   1159: ldiv
          //   1160: invokestatic 194	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1163: aastore
          //   1164: dup
          //   1165: iconst_2
          //   1166: iload 5
          //   1168: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1171: aastore
          //   1172: dup
          //   1173: iconst_3
          //   1174: iload 6
          //   1176: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1179: aastore
          //   1180: invokestatic 253	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   1183: aastore
          //   1184: invokevirtual 257	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
          //   1187: iload_2
          //   1188: iflt +27 -> 1215
          //   1191: aload 17
          //   1193: astore 14
          //   1195: iload 4
          //   1197: istore_1
          //   1198: aload 18
          //   1200: astore 16
          //   1202: getstatic 242	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
          //   1205: ldc2_w 267
          //   1208: iload_2
          //   1209: i2l
          //   1210: lconst_1
          //   1211: iconst_1
          //   1212: invokevirtual 274	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
          //   1215: aload 17
          //   1217: astore 14
          //   1219: iload 4
          //   1221: istore_1
          //   1222: aload 18
          //   1224: astore 16
          //   1226: aload_0
          //   1227: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:pok	Lcom/tencent/mm/plugin/dbbackup/b;
          //   1230: ifnull +25 -> 1255
          //   1233: aload 17
          //   1235: astore 14
          //   1237: iload 4
          //   1239: istore_1
          //   1240: aload 18
          //   1242: astore 16
          //   1244: aload_0
          //   1245: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:pok	Lcom/tencent/mm/plugin/dbbackup/b;
          //   1248: iload 4
          //   1250: invokeinterface 206 2 0
          //   1255: aload_0
          //   1256: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1259: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1262: ifnull +22 -> 1284
          //   1265: aload_0
          //   1266: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1269: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1272: invokevirtual 215	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   1275: aload_0
          //   1276: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1279: aconst_null
          //   1280: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1283: pop
          //   1284: aload_0
          //   1285: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1288: invokestatic 222	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
          //   1291: pop
          //   1292: invokestatic 228	com/tencent/mm/model/bc:ajU	()Lcom/tencent/mm/sdk/platformtools/ar;
          //   1295: invokevirtual 233	com/tencent/mm/sdk/platformtools/ar:foO	()V
          //   1298: sipush 23079
          //   1301: invokestatic 236	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1304: return
          //   1305: iload 4
          //   1307: iconst_1
          //   1308: if_icmpne +155 -> 1463
          //   1311: ldc_w 326
          //   1314: astore 15
          //   1316: goto -278 -> 1038
          //   1319: sipush 10007
          //   1322: istore_3
          //   1323: bipush 23
          //   1325: istore_2
          //   1326: aload 17
          //   1328: astore 14
          //   1330: iload 4
          //   1332: istore_1
          //   1333: aload 18
          //   1335: astore 16
          //   1337: getstatic 242	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
          //   1340: ldc_w 328
          //   1343: ldc_w 330
          //   1346: aload 19
          //   1348: invokestatic 333	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   1351: invokevirtual 337	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   1354: aconst_null
          //   1355: invokevirtual 341	com/tencent/mm/plugin/report/service/g:g	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
          //   1358: goto -251 -> 1107
          //   1361: astore 14
          //   1363: aload_0
          //   1364: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1367: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1370: ifnull +22 -> 1392
          //   1373: aload_0
          //   1374: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1377: invokestatic 210	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1380: invokevirtual 215	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   1383: aload_0
          //   1384: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1387: aconst_null
          //   1388: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1391: pop
          //   1392: aload 16
          //   1394: ifnull +8 -> 1402
          //   1397: aload 16
          //   1399: invokevirtual 218	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   1402: aload_0
          //   1403: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:pox	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1406: invokestatic 222	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
          //   1409: pop
          //   1410: invokestatic 228	com/tencent/mm/model/bc:ajU	()Lcom/tencent/mm/sdk/platformtools/ar;
          //   1413: invokevirtual 233	com/tencent/mm/sdk/platformtools/ar:foO	()V
          //   1416: sipush 23079
          //   1419: invokestatic 236	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1422: aload 14
          //   1424: athrow
          //   1425: astore 14
          //   1427: aconst_null
          //   1428: astore 16
          //   1430: goto -67 -> 1363
          //   1433: astore 14
          //   1435: aconst_null
          //   1436: astore 15
          //   1438: iconst_m1
          //   1439: istore_1
          //   1440: goto -756 -> 684
          //   1443: astore 14
          //   1445: iconst_m1
          //   1446: istore_1
          //   1447: goto -763 -> 684
          //   1450: astore 14
          //   1452: bipush 253
          //   1454: istore_1
          //   1455: goto -771 -> 684
          //   1458: astore 14
          //   1460: goto -776 -> 684
          //   1463: ldc_w 343
          //   1466: astore 15
          //   1468: goto -430 -> 1038
          //   1471: iload 4
          //   1473: iconst_1
          //   1474: if_icmpne -155 -> 1319
          //   1477: sipush 10006
          //   1480: istore_3
          //   1481: iconst_m1
          //   1482: istore_2
          //   1483: goto -376 -> 1107
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	1486	0	this	2
          //   159	1296	1	i	int
          //   156	1327	2	j	int
          //   154	1327	3	k	int
          //   861	614	4	m	int
          //   917	250	5	n	int
          //   940	235	6	i1	int
          //   161	994	7	l1	long
          //   165	982	9	l2	long
          //   34	858	11	l3	long
          //   210	3	13	bool	boolean
          //   62	1267	14	localObject1	Object
          //   1361	62	14	localObject2	Object
          //   1425	1	14	localObject3	Object
          //   1433	1	14	localException1	Exception
          //   1443	1	14	localException2	Exception
          //   1450	1	14	localException3	Exception
          //   1458	1	14	localException4	Exception
          //   113	1354	15	localObject4	Object
          //   117	553	16	localObject5	Object
          //   674	7	16	localException5	Exception
          //   686	743	16	localObject6	Object
          //   69	1258	17	localObject7	Object
          //   176	387	18	localObject8	Object
          //   805	19	18	localException6	Exception
          //   1023	311	18	localObject9	Object
          //   195	1152	19	localObject10	Object
          // Exception table:
          //   from	to	target	type
          //   612	626	674	java/lang/Exception
          //   636	645	674	java/lang/Exception
          //   655	661	674	java/lang/Exception
          //   671	674	674	java/lang/Exception
          //   874	877	674	java/lang/Exception
          //   888	896	674	java/lang/Exception
          //   907	919	674	java/lang/Exception
          //   930	942	674	java/lang/Exception
          //   953	965	674	java/lang/Exception
          //   976	986	674	java/lang/Exception
          //   997	1006	674	java/lang/Exception
          //   1017	1022	674	java/lang/Exception
          //   1049	1095	674	java/lang/Exception
          //   1118	1187	674	java/lang/Exception
          //   1202	1215	674	java/lang/Exception
          //   1226	1233	674	java/lang/Exception
          //   1244	1255	674	java/lang/Exception
          //   1337	1358	674	java/lang/Exception
          //   186	197	805	java/lang/Exception
          //   205	212	805	java/lang/Exception
          //   324	331	805	java/lang/Exception
          //   339	368	805	java/lang/Exception
          //   376	390	805	java/lang/Exception
          //   398	405	805	java/lang/Exception
          //   413	424	805	java/lang/Exception
          //   492	544	805	java/lang/Exception
          //   552	577	805	java/lang/Exception
          //   119	126	1361	finally
          //   130	136	1361	finally
          //   151	155	1361	finally
          //   186	197	1361	finally
          //   205	212	1361	finally
          //   228	251	1361	finally
          //   255	264	1361	finally
          //   268	272	1361	finally
          //   276	297	1361	finally
          //   324	331	1361	finally
          //   339	368	1361	finally
          //   376	390	1361	finally
          //   398	405	1361	finally
          //   413	424	1361	finally
          //   492	544	1361	finally
          //   552	577	1361	finally
          //   585	594	1361	finally
          //   612	626	1361	finally
          //   636	645	1361	finally
          //   655	661	1361	finally
          //   671	674	1361	finally
          //   688	702	1361	finally
          //   706	713	1361	finally
          //   717	727	1361	finally
          //   731	745	1361	finally
          //   811	837	1361	finally
          //   850	863	1361	finally
          //   874	877	1361	finally
          //   888	896	1361	finally
          //   907	919	1361	finally
          //   930	942	1361	finally
          //   953	965	1361	finally
          //   976	986	1361	finally
          //   997	1006	1361	finally
          //   1017	1022	1361	finally
          //   1049	1095	1361	finally
          //   1118	1187	1361	finally
          //   1202	1215	1361	finally
          //   1226	1233	1361	finally
          //   1244	1255	1361	finally
          //   1337	1358	1361	finally
          //   15	115	1425	finally
          //   15	115	1433	java/lang/Exception
          //   119	126	1443	java/lang/Exception
          //   130	136	1443	java/lang/Exception
          //   228	251	1443	java/lang/Exception
          //   255	264	1443	java/lang/Exception
          //   268	272	1443	java/lang/Exception
          //   276	297	1443	java/lang/Exception
          //   151	155	1450	java/lang/Exception
          //   585	594	1458	java/lang/Exception
          //   811	837	1458	java/lang/Exception
          //   850	863	1458	java/lang/Exception
        }
      };
      this.pnY = true;
      bc.ajU().Mh();
      bc.ajU().ax(paramString);
      AppMethodBeat.o(23098);
      return 0;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean a(final boolean paramBoolean, final b paramb)
  {
    AppMethodBeat.i(23096);
    if (this.pnY)
    {
      ae.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", new Object[] { "backup" });
      AppMethodBeat.o(23096);
      return false;
    }
    final com.tencent.mm.model.c localc = bc.aCg();
    final String str1 = com.tencent.mm.model.c.ajy();
    final SQLiteDatabase localSQLiteDatabase = com.tencent.mm.model.c.getDataDB().fxU();
    final String str2 = str1 + ".bak";
    final String str3 = str2 + ".tmp";
    final String str4 = str1 + ".sm";
    final String str5 = str4 + ".tmp";
    int j = 8;
    final int i = j;
    boolean bool = paramBoolean;
    final long[] arrayOfLong2;
    final long[] arrayOfLong1;
    label204:
    final String[] arrayOfString;
    if (paramBoolean)
    {
      if (o.fB(str2))
      {
        i = 24;
        o.mF(str2, str3);
        bool = paramBoolean;
      }
    }
    else
    {
      arrayOfLong2 = a(localSQLiteDatabase);
      if (!bool) {
        break label292;
      }
      arrayOfLong1 = aaL(str1);
      arrayOfString = a(arrayOfLong2, arrayOfLong1);
      if (arrayOfLong1 != null) {
        break label301;
      }
    }
    label292:
    label301:
    for (paramBoolean = false;; paramBoolean = bool)
    {
      if (this.pof) {
        i |= 0x3;
      }
      for (;;)
      {
        paramb = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(23078);
            if (!d.a(d.this))
            {
              if (paramb != null) {
                paramb.BA(1);
              }
              AppMethodBeat.o(23078);
              return;
            }
            d.a(d.this, null);
            for (;;)
            {
              Object localObject3;
              long l1;
              label225:
              int i;
              label280:
              label295:
              label342:
              int k;
              int j;
              try
              {
                long l2 = System.nanoTime();
                localObject3 = com.tencent.mm.b.g.C((com.tencent.mm.compatible.deviceinfo.q.cH(true) + com.tencent.mm.model.c.getUin()).getBytes());
                Object localObject1 = new k(str4);
                k localk;
                if ((!paramBoolean) || (!((k)localObject1).exists()))
                {
                  boolean bool = RepairKit.MasterInfo.save(localSQLiteDatabase, com.tencent.mm.b.q.k(str5, true), (byte[])localObject3);
                  localk = new k(str5);
                  if (bool)
                  {
                    ((k)localObject1).delete();
                    bool = localk.ag((k)localObject1);
                    l1 = System.nanoTime();
                    if (!bool) {
                      break label1109;
                    }
                    localObject1 = "SUCCEEDED";
                    ae.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", new Object[] { localObject1, Float.valueOf((float)(l1 - l2) / 1.0E+009F) });
                    localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
                    if (!bool) {
                      break label1117;
                    }
                    l1 = 24L;
                    ((com.tencent.mm.plugin.report.service.g)localObject1).idkeyStat(181L, l1, 1L, false);
                  }
                }
                else
                {
                  long l3 = new k(str1).length();
                  long l4 = new k(str3).length();
                  if (!paramBoolean) {
                    break label1125;
                  }
                  localObject1 = "incremental";
                  if (arrayOfLong1 == null) {
                    break label1133;
                  }
                  l1 = arrayOfLong1[0];
                  ae.i("MicroMsg.SubCoreDBBackup", "Backup started [%s, cursor: %d ~ %d]", new Object[] { localObject1, Long.valueOf(l1), Long.valueOf(arrayOfLong2[0]) });
                  if (!paramBoolean) {
                    break label1139;
                  }
                  i = 10011;
                  com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(i), String.format("%d|%d|%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), d.this.pog.format(new Date()) }) });
                  d.a(d.this, new BackupKit(localSQLiteDatabase, str3, (byte[])localObject3, i, arrayOfString));
                  k = d.b(d.this).run();
                  l1 = System.nanoTime() - l2;
                  localObject1 = new k(str3);
                  l2 = ((k)localObject1).length();
                  if (k != 0) {
                    continue;
                  }
                  d.b(str1, arrayOfLong2);
                  localObject3 = new k(str2);
                  ((k)localObject3).delete();
                  ((k)localObject1).ag((k)localObject3);
                  if (!paramBoolean) {
                    break label1146;
                  }
                  i = 19;
                  j = 10012;
                  label539:
                  if (!paramBoolean) {
                    break label1176;
                  }
                  localObject3 = "incremental";
                  break label1097;
                  label553:
                  ae.i("MicroMsg.SubCoreDBBackup", "Database %s backup %s, elapsed %.2f seconds.", new Object[] { localObject3, localObject1, Float.valueOf((float)l1 / 1.0E+009F) });
                  com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(181L, i, 1L, false);
                  com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(j), String.format("%d|%d|%d|%d|%d|%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l2), Integer.valueOf(d.b(d.this).statementCount()), Long.valueOf(l1 / 1000000L), d.this.pog.format(new Date()) }) });
                  if (paramb != null) {
                    paramb.BA(k);
                  }
                  d.b(d.this).release();
                  d.a(d.this, null);
                  localObject1 = new StringBuilder();
                  com.tencent.mm.kernel.g.ajS();
                  o.aZI(com.tencent.mm.kernel.g.ajR().gDT + "dbback");
                  localObject1 = str4;
                  localObject3 = new StringBuilder();
                  com.tencent.mm.kernel.g.ajS();
                  o.mF((String)localObject1, com.tencent.mm.kernel.g.ajR().gDT + "dbback/EnMicroMsg.db.sm");
                  return;
                }
                localk.delete();
                continue;
                ((k)localObject1).delete();
                if (k == 1)
                {
                  if (paramBoolean)
                  {
                    i = 20;
                    j = 10013;
                  }
                }
                else
                {
                  if (!paramBoolean) {
                    break label1166;
                  }
                  i = 21;
                  j = 10014;
                  continue;
                  localObject1 = "failed";
                  continue;
                  com.tencent.mm.plugin.report.service.g localg;
                  if (k != 0) {
                    break label1184;
                  }
                }
              }
              catch (Exception localException)
              {
                ae.printErrStackTrace("MicroMsg.SubCoreDBBackup", localException, "Failed to start database backup, path: %s", new Object[] { str1 });
                if (paramb != null) {
                  paramb.BA(-1);
                }
                localg = com.tencent.mm.plugin.report.service.g.yxI;
                if (paramBoolean)
                {
                  l1 = 18L;
                  localg.idkeyStat(181L, l1, 1L, false);
                  return;
                }
                l1 = 21L;
                continue;
              }
              finally
              {
                if (d.b(d.this) != null)
                {
                  d.b(d.this).release();
                  d.a(d.this, null);
                }
                d.c(d.this);
                AppMethodBeat.o(23078);
              }
              label1097:
              String str;
              for (;;)
              {
                str = "succeeded";
                break label553;
                label1109:
                str = "FAILED";
                break;
                label1117:
                l1 = 25L;
                break label225;
                label1125:
                str = "new";
                break label280;
                label1133:
                l1 = 0L;
                break label295;
                label1139:
                i = 10000;
                break label342;
                label1146:
                i = 16;
                j = 10001;
                break label539;
                i = 17;
                j = 10002;
                break label539;
                label1166:
                i = 18;
                j = 10003;
                break label539;
                label1176:
                localObject3 = "new";
              }
              label1184:
              if (k == 1) {
                str = "canceled";
              }
            }
          }
        };
        this.pnY = true;
        com.tencent.mm.sdk.g.b.c(paramb, "DB Backup");
        AppMethodBeat.o(23096);
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
  public final int b(String paramString, final b paramb)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: sipush 23099
    //   7: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 330	com/tencent/mm/model/bc:aCg	()Lcom/tencent/mm/model/c;
    //   13: astore 7
    //   15: aload_1
    //   16: astore 6
    //   18: aload_1
    //   19: ifnonnull +8 -> 27
    //   22: invokestatic 558	com/tencent/mm/model/c:ajv	()Ljava/lang/String;
    //   25: astore 6
    //   27: invokestatic 580	com/tencent/mm/sdk/platformtools/bu:fpK	()J
    //   30: lstore 4
    //   32: aload 6
    //   34: ifnonnull +29 -> 63
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +10 -> 50
    //   43: aload_1
    //   44: invokevirtual 564	com/tencent/mm/vfs/k:canRead	()Z
    //   47: ifne +34 -> 81
    //   50: bipush 253
    //   52: istore_3
    //   53: sipush 23099
    //   56: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: ireturn
    //   63: new 309	com/tencent/mm/vfs/k
    //   66: dup
    //   67: aload 6
    //   69: invokespecial 310	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   72: astore_1
    //   73: goto -34 -> 39
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: ldc 168
    //   83: ldc_w 651
    //   86: iconst_2
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload_1
    //   93: invokevirtual 575	com/tencent/mm/vfs/k:length	()J
    //   96: invokestatic 217	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: lload 4
    //   104: invokestatic 217	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   107: aastore
    //   108: invokestatic 388	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: lload 4
    //   113: l2f
    //   114: aload_1
    //   115: invokevirtual 575	com/tencent/mm/vfs/k:length	()J
    //   118: l2f
    //   119: ldc_w 652
    //   122: fmul
    //   123: fcmpg
    //   124: ifge +15 -> 139
    //   127: bipush 254
    //   129: istore_3
    //   130: sipush 23099
    //   133: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: goto -77 -> 59
    //   139: new 12	com/tencent/mm/plugin/dbbackup/d$3
    //   142: dup
    //   143: aload_0
    //   144: aload 7
    //   146: aload 6
    //   148: aload_2
    //   149: invokespecial 655	com/tencent/mm/plugin/dbbackup/d$3:<init>	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/mm/model/c;Ljava/lang/String;Lcom/tencent/mm/plugin/dbbackup/b;)V
    //   152: astore_1
    //   153: aload_0
    //   154: iconst_1
    //   155: putfield 88	com/tencent/mm/plugin/dbbackup/d:pnY	Z
    //   158: invokestatic 586	com/tencent/mm/model/bc:ajU	()Lcom/tencent/mm/sdk/platformtools/ar;
    //   161: invokevirtual 591	com/tencent/mm/sdk/platformtools/ar:Mh	()V
    //   164: invokestatic 586	com/tencent/mm/model/bc:ajU	()Lcom/tencent/mm/sdk/platformtools/ar;
    //   167: aload_1
    //   168: invokevirtual 598	com/tencent/mm/sdk/platformtools/ar:ax	(Ljava/lang/Runnable;)I
    //   171: pop
    //   172: sipush 23099
    //   175: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public final boolean cdb()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: sipush 23097
    //   7: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: iconst_0
    //   12: putfield 88	com/tencent/mm/plugin/dbbackup/d:pnY	Z
    //   15: aload_0
    //   16: getfield 123	com/tencent/mm/plugin/dbbackup/d:pnV	Lcom/tencent/wcdb/repair/BackupKit;
    //   19: ifnonnull +13 -> 32
    //   22: sipush 23097
    //   25: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: aload_0
    //   33: getfield 123	com/tencent/mm/plugin/dbbackup/d:pnV	Lcom/tencent/wcdb/repair/BackupKit;
    //   36: invokevirtual 661	com/tencent/wcdb/repair/BackupKit:onCancel	()V
    //   39: iconst_1
    //   40: istore_1
    //   41: sipush 23097
    //   44: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(23101);
    bc.aCg();
    Object localObject1 = com.tencent.mm.model.c.ajA();
    SQLiteDatabase localSQLiteDatabase = com.tencent.mm.model.c.getDataDB().fxU();
    this.pod = ((aj)localObject1).aby(237569);
    this.poe = ((aj)localObject1).getInt(237570, 10);
    Object localObject2;
    if (((aj)localObject1).getInt(237571, 0) != 0)
    {
      paramBoolean = true;
      this.pof = paramBoolean;
      localObject1 = ak.getContext();
      localObject2 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localObject2 == null) {
        break label564;
      }
      int i = ((Intent)localObject2).getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        break label559;
      }
      paramBoolean = true;
      label112:
      this.oCl = paramBoolean;
      label117:
      this.oCm = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.poh = new k.a()
      {
        public final void a(String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(23085);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
            d.cdg();
          }
          AppMethodBeat.o(23085);
        }
      };
      com.tencent.mm.model.c.d.aDI().add(this.poh);
      cdc();
      this.poi = new com.tencent.mm.sdk.b.c() {};
      a.IvT.c(this.poi);
      this.oCn = new BroadcastReceiver()
      {
        public final void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(23089);
          paramAnonymousContext = paramAnonymousIntent.getAction();
          int i = -1;
          switch (paramAnonymousContext.hashCode())
          {
          default: 
            switch (i)
            {
            }
            break;
          }
          for (;;)
          {
            ae.v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", new Object[] { paramAnonymousContext, Boolean.valueOf(d.i(d.this)), Boolean.valueOf(d.j(d.this)) });
            if ((!d.h(d.this)) || (d.k(d.this) != null) || (!d.j(d.this)) || (d.i(d.this))) {
              break label437;
            }
            if (System.currentTimeMillis() - d.l(d.this) >= 86400000L) {
              break label309;
            }
            ae.d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
            AppMethodBeat.o(23089);
            return;
            if (!paramAnonymousContext.equals("android.intent.action.SCREEN_ON")) {
              break;
            }
            i = 0;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.SCREEN_OFF")) {
              break;
            }
            i = 1;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
              break;
            }
            i = 2;
            break;
            if (!paramAnonymousContext.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
              break;
            }
            i = 3;
            break;
            d.b(d.this, true);
            continue;
            d.b(d.this, false);
            continue;
            d.c(d.this, true);
            continue;
            d.c(d.this, false);
          }
          label309:
          if (d.m(d.this) < 10) {}
          for (final boolean bool = true;; bool = false)
          {
            paramAnonymousContext = new b()
            {
              public final void BA(int paramAnonymous2Int)
              {
                AppMethodBeat.i(23087);
                d.d(d.this, false);
                bc.aCg();
                aj localaj = com.tencent.mm.model.c.ajA();
                d.c(d.this, System.currentTimeMillis());
                if (paramAnonymous2Int == 0)
                {
                  localaj.setLong(237569, d.l(d.this));
                  if (bool)
                  {
                    d.n(d.this);
                    localaj.setInt(237570, d.m(d.this));
                  }
                }
                for (;;)
                {
                  localaj.fuc();
                  do
                  {
                    AppMethodBeat.o(23087);
                    return;
                    d.a(d.this, 0);
                    break;
                  } while (paramAnonymous2Int == 1);
                  localaj.setLong(237569, d.l(d.this));
                  if (bool)
                  {
                    d.a(d.this, 10);
                    localaj.setInt(237570, d.m(d.this));
                  }
                }
              }
            };
            d.a(d.this, new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(23088);
                d.a(d.this, null);
                bc.aCg();
                long l1 = new k(com.tencent.mm.model.c.ajy()).length();
                long l2 = bu.fpK();
                if (l1 == 0L)
                {
                  ae.i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
                  AppMethodBeat.o(23088);
                  return;
                }
                if ((l1 > d.f(d.this)) || (l1 > l2))
                {
                  ae.i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
                  com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(10008), String.format("%d|%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }) });
                  AppMethodBeat.o(23088);
                  return;
                }
                d.d(d.this, d.this.a(bool, paramAnonymousContext));
                if (d.o(d.this)) {
                  ae.i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
                }
                AppMethodBeat.o(23088);
              }
            });
            bc.ajU().n(d.k(d.this), d.g(d.this));
            ae.i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
            com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(10009), d.this.pog.format(new Date()) });
            AppMethodBeat.o(23089);
            return;
          }
          label437:
          if (d.k(d.this) != null)
          {
            bc.ajU().cZF().removeCallbacks(d.k(d.this));
            d.a(d.this, null);
            ae.i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
            com.tencent.mm.plugin.report.service.g.yxI.f(11098, new Object[] { Integer.valueOf(10010), d.this.pog.format(new Date()) });
            AppMethodBeat.o(23089);
            return;
          }
          if (d.o(d.this))
          {
            d.this.cdb();
            d.d(d.this, false);
          }
          AppMethodBeat.o(23089);
        }
      };
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      ((Context)localObject1).registerReceiver(this.oCn, (IntentFilter)localObject2);
      com.tencent.mm.pluginsdk.cmd.b.a(new c(this), new String[] { "//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy", "//fixdb" });
      if (!this.poa) {
        break label572;
      }
      localObject1 = "enabled";
      label344:
      if (!this.oCm) {
        break label579;
      }
      localObject2 = "";
      label356:
      if (!this.oCl) {
        break label587;
      }
    }
    label559:
    label564:
    label572:
    label579:
    label587:
    for (String str = "";; str = " not")
    {
      ae.i("MicroMsg.SubCoreDBBackup", "Auto database backup %s. Device status:%s interactive,%s charging.", new Object[] { localObject1, localObject2, str });
      b(localSQLiteDatabase);
      com.tencent.mm.plugin.dbbackup.a.b.aaP(com.tencent.mm.compatible.deviceinfo.q.cH(true));
      o.deleteFile(com.tencent.mm.kernel.g.ajR().gDT + "dbback/EnMicroMsg.db.bak");
      o.deleteFile(com.tencent.mm.kernel.g.ajR().gDT + "dbback/corrupted/EnMicroMsg.db.bak");
      o.deleteFile(com.tencent.mm.kernel.g.ajR().cachePath + "EnMicroMsg.db.bak");
      o.deleteFile(com.tencent.mm.kernel.g.ajR().cachePath + "corrupted/EnMicroMsg.db.bak");
      localObject1 = com.tencent.mm.model.c.ajw();
      bc.ajU().n(new d.6(this, (String)localObject1), 60000L);
      AppMethodBeat.o(23101);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label112;
      this.oCl = false;
      break label117;
      localObject1 = "disabled";
      break label344;
      localObject2 = " not";
      break label356;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(23102);
    cdb();
    this.pnZ = false;
    if (this.oCo != null)
    {
      bc.ajU().cZF().removeCallbacks(this.oCo);
      this.oCo = null;
    }
    if (this.poi != null)
    {
      a.IvT.d(this.poi);
      this.poi = null;
    }
    if (this.oCn != null)
    {
      ak.getContext().unregisterReceiver(this.oCn);
      this.oCn = null;
    }
    com.tencent.mm.pluginsdk.cmd.b.S(new String[] { "//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy", "//fixdb" });
    AppMethodBeat.o(23102);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d
 * JD-Core Version:    0.7.0.1
 */