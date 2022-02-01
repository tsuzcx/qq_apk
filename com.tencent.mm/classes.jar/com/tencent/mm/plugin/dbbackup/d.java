package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storagebase.f;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.vfs.i;
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
  implements aw
{
  private static final SQLiteCipherSpec oaE;
  private boolean npp;
  private boolean npq;
  private BroadcastReceiver npr;
  private Runnable nps;
  private boolean oaA;
  final SimpleDateFormat oaB;
  private k.a oaC;
  private com.tencent.mm.sdk.b.c oaD;
  private volatile BackupKit oaq;
  private volatile RecoverKit oar;
  private volatile RepairKit oas;
  private volatile boolean oat;
  private boolean oau;
  private boolean oav;
  private long oaw;
  private long oax;
  private long oay;
  private int oaz;
  
  static
  {
    AppMethodBeat.i(23109);
    oaE = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    AppMethodBeat.o(23109);
  }
  
  public d()
  {
    AppMethodBeat.i(23090);
    this.oat = false;
    this.oau = false;
    this.oav = false;
    this.oaw = 0L;
    this.oax = 600000L;
    this.npp = false;
    this.npq = true;
    this.oay = 0L;
    this.oaz = 10;
    this.oaA = false;
    this.oaB = new SimpleDateFormat("HH:mm:ss.SSS");
    AppMethodBeat.o(23090);
  }
  
  /* Error */
  private static long[] Sb(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 7
    //   3: sipush 23092
    //   6: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 125	java/io/BufferedReader
    //   12: dup
    //   13: new 127	com/tencent/mm/vfs/k
    //   16: dup
    //   17: new 129	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   24: aload_0
    //   25: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 136
    //   30: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokespecial 141	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   39: invokespecial 144	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore 10
    //   44: aload 10
    //   46: astore 9
    //   48: aload 10
    //   50: invokevirtual 147	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 11
    //   55: aload 11
    //   57: ifnull +225 -> 282
    //   60: aload 10
    //   62: astore 9
    //   64: aload 11
    //   66: invokestatic 153	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   69: lstore_1
    //   70: aload 10
    //   72: astore 9
    //   74: aload 10
    //   76: invokevirtual 147	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   79: astore 11
    //   81: aload 11
    //   83: ifnull +194 -> 277
    //   86: aload 10
    //   88: astore 9
    //   90: aload 11
    //   92: invokestatic 153	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   95: lstore_3
    //   96: aload 10
    //   98: astore 9
    //   100: aload 10
    //   102: invokevirtual 147	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   105: astore 11
    //   107: aload 11
    //   109: ifnull +162 -> 271
    //   112: aload 10
    //   114: astore 9
    //   116: aload 11
    //   118: invokestatic 153	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   121: lstore 5
    //   123: aload 10
    //   125: astore 9
    //   127: aload 10
    //   129: invokevirtual 147	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   132: astore 11
    //   134: aload 11
    //   136: ifnull +14 -> 150
    //   139: aload 10
    //   141: astore 9
    //   143: aload 11
    //   145: invokestatic 153	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   148: lstore 7
    //   150: aload 10
    //   152: invokevirtual 156	java/io/BufferedReader:close	()V
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
    //   192: ldc 158
    //   194: aload 11
    //   196: ldc 160
    //   198: iconst_1
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_0
    //   205: aastore
    //   206: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: aload 10
    //   211: ifnull +8 -> 219
    //   214: aload 10
    //   216: invokevirtual 156	java/io/BufferedReader:close	()V
    //   219: sipush 23092
    //   222: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aconst_null
    //   226: areturn
    //   227: astore_0
    //   228: aconst_null
    //   229: astore 9
    //   231: aload 9
    //   233: ifnull +8 -> 241
    //   236: aload 9
    //   238: invokevirtual 156	java/io/BufferedReader:close	()V
    //   241: sipush 23092
    //   244: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   183	12	11	localException1	Exception
    //   266	1	11	localException2	Exception
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
    //   0: sipush 23093
    //   3: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 186	com/tencent/mm/vfs/l
    //   9: dup
    //   10: new 129	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   17: aload_0
    //   18: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 136
    //   23: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokespecial 187	com/tencent/mm/vfs/l:<init>	(Ljava/lang/String;)V
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
    //   59: new 129	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   66: lload 4
    //   68: invokestatic 190	java/lang/Long:toString	(J)Ljava/lang/String;
    //   71: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 192
    //   76: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 195	com/tencent/mm/vfs/l:write	(Ljava/lang/String;)V
    //   85: iload_2
    //   86: iconst_1
    //   87: iadd
    //   88: istore_2
    //   89: goto -46 -> 43
    //   92: aload 7
    //   94: invokevirtual 196	com/tencent/mm/vfs/l:close	()V
    //   97: sipush 23093
    //   100: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: iconst_1
    //   104: ireturn
    //   105: astore 8
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: astore 6
    //   112: ldc 158
    //   114: aload 8
    //   116: ldc 198
    //   118: iconst_1
    //   119: anewarray 4	java/lang/Object
    //   122: dup
    //   123: iconst_0
    //   124: aload_0
    //   125: aastore
    //   126: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 196	com/tencent/mm/vfs/l:close	()V
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
    //   156: invokevirtual 196	com/tencent/mm/vfs/l:close	()V
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
    //   32	154	7	locall	com.tencent.mm.vfs.l
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
  
  private static boolean b(SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(23095);
    Object localObject1 = paramSQLiteDatabase.getPath();
    Object localObject2 = (String)localObject1 + ".sm";
    String str = (String)localObject2 + ".tmp";
    localObject1 = com.tencent.mm.kernel.g.afB().afk();
    long l2 = ((ab)localObject1).Wx(237569);
    long l1 = System.currentTimeMillis();
    localObject2 = new com.tencent.mm.vfs.e((String)localObject2);
    if ((((com.tencent.mm.vfs.e)localObject2).exists()) && (l1 - l2 < 86400000L))
    {
      AppMethodBeat.o(23095);
      return true;
    }
    l2 = System.nanoTime();
    Object localObject3 = new StringBuilder().append(com.tencent.mm.compatible.deviceinfo.q.cG(true));
    az.arV();
    byte[] arrayOfByte = com.tencent.mm.b.g.E(com.tencent.mm.model.c.getUin().getBytes());
    localObject3 = new com.tencent.mm.vfs.e(str);
    try
    {
      bool = RepairKit.MasterInfo.save(paramSQLiteDatabase, com.tencent.mm.b.q.k(str, true), arrayOfByte);
      if (bool)
      {
        ((com.tencent.mm.vfs.e)localObject2).delete();
        bool = ((com.tencent.mm.vfs.e)localObject3).af((com.tencent.mm.vfs.e)localObject2);
        ((ab)localObject1).setLong(237569, l1);
        ((ab)localObject1).eKy();
        l1 = System.nanoTime();
        if (!bool) {
          break label322;
        }
        paramSQLiteDatabase = "SUCCEEDED";
        ad.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", new Object[] { paramSQLiteDatabase, Float.valueOf((float)(l1 - l2) / 1.0E+009F) });
        paramSQLiteDatabase = com.tencent.mm.plugin.report.service.h.vKh;
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
        ad.printErrStackTrace("MicroMsg.SubCoreDBBackup", paramSQLiteDatabase, "Failed to backup database master.", new Object[0]);
        boolean bool = false;
        continue;
        ((com.tencent.mm.vfs.e)localObject3).delete();
        continue;
        label322:
        paramSQLiteDatabase = "FAILED";
        continue;
        label329:
        l1 = 25L;
      }
    }
  }
  
  private static void bPU()
  {
    AppMethodBeat.i(23103);
    Object localObject = com.tencent.mm.model.c.d.aty().qu("100274");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).eJy();
      HashMap localHashMap = new HashMap();
      localHashMap.put("flags", Integer.valueOf(bt.getInt((String)((Map)localObject).get("flags"), 0)));
      localHashMap.put("acp", Integer.valueOf(bt.getInt((String)((Map)localObject).get("acp"), 100)));
      f.bK(localHashMap);
    }
    AppMethodBeat.o(23103);
  }
  
  static void bPV()
  {
    AppMethodBeat.i(23104);
    Object localObject = com.tencent.mm.model.c.apO();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject).cOQ();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject).cOS();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.h)localObject).cOR();
    com.tencent.mm.model.c.apR().eLi();
    o.ayF().ayl();
    localObject = com.tencent.mm.model.c.afk();
    ((ab)localObject).set(ae.a.FgA, Integer.valueOf(0));
    ((ab)localObject).set(ae.a.FgB, Integer.valueOf(0));
    ((ab)localObject).set(ae.a.FgC, Integer.valueOf(0));
    AppMethodBeat.o(23104);
  }
  
  public static void bPW()
  {
    AppMethodBeat.i(23106);
    MMAppMgr.vy(true);
    AppMethodBeat.o(23106);
  }
  
  public static void eo(Context paramContext)
  {
    AppMethodBeat.i(23105);
    MMAppMgr.m(paramContext, true);
    AppMethodBeat.o(23105);
  }
  
  @Deprecated
  public final int a(final b paramb)
  {
    AppMethodBeat.i(23100);
    az.arV();
    Object localObject1 = com.tencent.mm.model.c.afe();
    if ((localObject1 == null) || (((String)localObject1).isEmpty()))
    {
      AppMethodBeat.o(23100);
      return -3;
    }
    localObject1 = new com.tencent.mm.vfs.e((String)localObject1);
    if (!((com.tencent.mm.vfs.e)localObject1).canRead())
    {
      AppMethodBeat.o(23100);
      return -3;
    }
    Object localObject2 = new StringBuilder().append(com.tencent.mm.compatible.deviceinfo.q.cG(true));
    az.arV();
    localObject2 = com.tencent.mm.b.g.getMessageDigest(com.tencent.mm.model.c.getUin().getBytes()).substring(0, 7);
    long l1 = ((com.tencent.mm.vfs.e)localObject1).length() * 2L;
    long l2 = bt.eGK();
    ad.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l2 < l1)
    {
      AppMethodBeat.o(23100);
      return -2;
    }
    az.afE().KL();
    az.afE().ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23082);
        try
        {
          Thread.sleep(200L);
          label12:
          az.arV();
          Object localObject2 = com.tencent.mm.model.c.aff();
          Object localObject1 = (String)localObject2 + this.oaW.getName().replace(".db", "temp.db");
          ad.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", new Object[] { localObject1 });
          this.oaW.af(new com.tencent.mm.vfs.e((String)localObject1));
          String str = (String)localObject2 + "sqlTemp.sql";
          List localList = Arrays.asList(new String[] { "getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo" });
          localObject2 = new int[1];
          long l = System.currentTimeMillis();
          az.arV();
          boolean bool = com.tencent.mm.model.c.afg().a((String)localObject1, this.val$key, str, localList, new DBDumpUtil.ExecuteSqlCallback()
          {
            public final String preExecute(String paramAnonymous2String)
            {
              paramAnonymous2String = this.oaX;
              paramAnonymous2String[0] += 1;
              return null;
            }
          });
          if (bool)
          {
            az.arV();
            com.tencent.mm.model.c.apO().cOQ();
            az.arV();
            com.tencent.mm.model.c.apR().eLi();
            az.arV();
            com.tencent.mm.model.c.apO().cOS();
            az.arV();
            com.tencent.mm.model.c.apO().cOR();
            i = 12;
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(181L, i, 1L, true);
            l = System.currentTimeMillis() - l;
            ad.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", new Object[] { Integer.valueOf(localObject2[0]), Long.valueOf(l) });
            localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
            if (!bool) {
              break label390;
            }
            i = 1;
            label312:
            ((com.tencent.mm.plugin.report.service.h)localObject1).f(11224, new Object[] { Integer.valueOf(i), localObject2, Long.valueOf(l) });
            az.afE().eFR();
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
            ((b)localObject1).zN(i);
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
          //   7: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   10: aconst_null
          //   11: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   14: pop
          //   15: invokestatic 55	com/tencent/mm/model/c:apO	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/h;
          //   18: pop
          //   19: invokestatic 59	com/tencent/mm/model/c:apR	()Lcom/tencent/mm/storage/bh;
          //   22: pop
          //   23: invokestatic 65	com/tencent/mm/aw/o:ayF	()Lcom/tencent/mm/aw/g;
          //   26: pop
          //   27: invokestatic 71	com/tencent/mm/modelvideo/o:aCI	()Lcom/tencent/mm/modelvideo/t;
          //   30: pop
          //   31: invokestatic 77	java/lang/System:nanoTime	()J
          //   34: lstore 11
          //   36: new 79	java/lang/StringBuilder
          //   39: dup
          //   40: invokespecial 80	java/lang/StringBuilder:<init>	()V
          //   43: iconst_1
          //   44: invokestatic 86	com/tencent/mm/compatible/deviceinfo/q:cG	(Z)Ljava/lang/String;
          //   47: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   50: invokestatic 94	com/tencent/mm/model/c:getUin	()I
          //   53: invokevirtual 97	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   56: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   59: invokevirtual 107	java/lang/String:getBytes	()[B
          //   62: astore 14
          //   64: aload 14
          //   66: invokestatic 113	com/tencent/mm/b/g:E	([B)[B
          //   69: astore 17
          //   71: aload 14
          //   73: invokestatic 117	com/tencent/mm/b/g:getMessageDigest	([B)Ljava/lang/String;
          //   76: iconst_0
          //   77: bipush 7
          //   79: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
          //   82: invokevirtual 107	java/lang/String:getBytes	()[B
          //   85: astore 14
          //   87: ldc 122
          //   89: istore_1
          //   90: invokestatic 128	com/tencent/mm/storagebase/f:eOb	()Z
          //   93: ifeq +6 -> 99
          //   96: ldc 129
          //   98: istore_1
          //   99: invokestatic 133	com/tencent/mm/model/c:afg	()Lcom/tencent/mm/storagebase/h;
          //   102: invokevirtual 139	com/tencent/mm/storagebase/h:eOh	()Lcom/tencent/wcdb/database/SQLiteDatabase;
          //   105: invokevirtual 144	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
          //   108: aload 14
          //   110: invokestatic 148	com/tencent/mm/plugin/dbbackup/d:bPX	()Lcom/tencent/wcdb/database/SQLiteCipherSpec;
          //   113: aconst_null
          //   114: iload_1
          //   115: aconst_null
          //   116: iconst_0
          //   117: invokestatic 152	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
          //   120: astore 15
          //   122: aload 15
          //   124: astore 16
          //   126: aload_0
          //   127: getfield 29	com/tencent/mm/plugin/dbbackup/d$2:oaS	Ljava/lang/String;
          //   130: ifnull +101 -> 231
          //   133: aload 15
          //   135: astore 16
          //   137: aload_0
          //   138: getfield 29	com/tencent/mm/plugin/dbbackup/d$2:oaS	Ljava/lang/String;
          //   141: astore 14
          //   143: iconst_1
          //   144: anewarray 103	java/lang/String
          //   147: dup
          //   148: iconst_0
          //   149: aload 14
          //   151: aastore
          //   152: astore 14
          //   154: aload 15
          //   156: astore 16
          //   158: aload 14
          //   160: arraylength
          //   161: istore_3
          //   162: iconst_0
          //   163: istore_2
          //   164: bipush 253
          //   166: istore_1
          //   167: lconst_0
          //   168: lstore 7
          //   170: lload 7
          //   172: lstore 9
          //   174: iload_2
          //   175: iload_3
          //   176: if_icmpge +412 -> 588
          //   179: aload 14
          //   181: iload_2
          //   182: aaload
          //   183: astore 18
          //   185: lload 7
          //   187: lstore 9
          //   189: aload 15
          //   191: astore 16
          //   193: new 154	com/tencent/mm/vfs/e
          //   196: dup
          //   197: aload 18
          //   199: invokespecial 157	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
          //   202: astore 19
          //   204: lload 7
          //   206: lstore 9
          //   208: aload 15
          //   210: astore 16
          //   212: aload 19
          //   214: invokevirtual 160	com/tencent/mm/vfs/e:canRead	()Z
          //   217: istore 13
          //   219: iload 13
          //   221: ifne +102 -> 323
          //   224: iload_2
          //   225: iconst_1
          //   226: iadd
          //   227: istore_2
          //   228: goto -58 -> 170
          //   231: aload 15
          //   233: astore 16
          //   235: new 79	java/lang/StringBuilder
          //   238: dup
          //   239: invokespecial 80	java/lang/StringBuilder:<init>	()V
          //   242: invokestatic 163	com/tencent/mm/model/c:afe	()Ljava/lang/String;
          //   245: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   248: ldc 165
          //   250: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   253: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   256: astore 14
          //   258: aload 15
          //   260: astore 16
          //   262: new 79	java/lang/StringBuilder
          //   265: dup
          //   266: invokespecial 80	java/lang/StringBuilder:<init>	()V
          //   269: astore 18
          //   271: aload 15
          //   273: astore 16
          //   275: invokestatic 171	com/tencent/mm/kernel/g:afC	()Lcom/tencent/mm/kernel/g;
          //   278: pop
          //   279: aload 15
          //   281: astore 16
          //   283: aload 18
          //   285: invokestatic 175	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
          //   288: getfield 180	com/tencent/mm/kernel/e:gcW	Ljava/lang/String;
          //   291: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   294: ldc 182
          //   296: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   299: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   302: astore 18
          //   304: iconst_2
          //   305: anewarray 103	java/lang/String
          //   308: dup
          //   309: iconst_0
          //   310: aload 14
          //   312: aastore
          //   313: dup
          //   314: iconst_1
          //   315: aload 18
          //   317: aastore
          //   318: astore 14
          //   320: goto -166 -> 154
          //   323: lload 7
          //   325: lstore 9
          //   327: aload 15
          //   329: astore 16
          //   331: aload 19
          //   333: invokevirtual 185	com/tencent/mm/vfs/e:length	()J
          //   336: lstore 7
          //   338: lload 7
          //   340: lstore 9
          //   342: aload 15
          //   344: astore 16
          //   346: ldc 187
          //   348: ldc 189
          //   350: iconst_2
          //   351: anewarray 4	java/lang/Object
          //   354: dup
          //   355: iconst_0
          //   356: lload 7
          //   358: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   361: aastore
          //   362: dup
          //   363: iconst_1
          //   364: aload_0
          //   365: getfield 31	com/tencent/mm/plugin/dbbackup/d$2:oaT	J
          //   368: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   371: aastore
          //   372: invokestatic 200	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   375: lload 7
          //   377: lstore 9
          //   379: aload 15
          //   381: astore 16
          //   383: aload_0
          //   384: getfield 31	com/tencent/mm/plugin/dbbackup/d$2:oaT	J
          //   387: ldc2_w 201
          //   390: lload 7
          //   392: lmul
          //   393: lcmp
          //   394: ifge +97 -> 491
          //   397: lload 7
          //   399: lstore 9
          //   401: aload 15
          //   403: astore 16
          //   405: aload_0
          //   406: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:oaF	Lcom/tencent/mm/plugin/dbbackup/b;
          //   409: ifnull +22 -> 431
          //   412: lload 7
          //   414: lstore 9
          //   416: aload 15
          //   418: astore 16
          //   420: aload_0
          //   421: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:oaF	Lcom/tencent/mm/plugin/dbbackup/b;
          //   424: bipush 254
          //   426: invokeinterface 207 2 0
          //   431: aload_0
          //   432: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   435: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   438: ifnull +22 -> 460
          //   441: aload_0
          //   442: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   445: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   448: invokevirtual 216	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   451: aload_0
          //   452: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   455: aconst_null
          //   456: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   459: pop
          //   460: aload 15
          //   462: ifnull +8 -> 470
          //   465: aload 15
          //   467: invokevirtual 219	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   470: aload_0
          //   471: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   474: invokestatic 223	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
          //   477: pop
          //   478: invokestatic 229	com/tencent/mm/model/az:afE	()Lcom/tencent/mm/sdk/platformtools/aq;
          //   481: invokevirtual 234	com/tencent/mm/sdk/platformtools/aq:eFR	()V
          //   484: sipush 23079
          //   487: invokestatic 237	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   490: return
          //   491: lload 7
          //   493: lstore 9
          //   495: aload 15
          //   497: astore 16
          //   499: getstatic 243	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
          //   502: sipush 11098
          //   505: iconst_2
          //   506: anewarray 4	java/lang/Object
          //   509: dup
          //   510: iconst_0
          //   511: sipush 10004
          //   514: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   517: aastore
          //   518: dup
          //   519: iconst_1
          //   520: ldc 250
          //   522: iconst_2
          //   523: anewarray 4	java/lang/Object
          //   526: dup
          //   527: iconst_0
          //   528: lload 7
          //   530: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   533: aastore
          //   534: dup
          //   535: iconst_1
          //   536: aload_0
          //   537: getfield 31	com/tencent/mm/plugin/dbbackup/d$2:oaT	J
          //   540: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   543: aastore
          //   544: invokestatic 254	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   547: aastore
          //   548: invokevirtual 258	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
          //   551: lload 7
          //   553: lstore 9
          //   555: aload 15
          //   557: astore 16
          //   559: aload_0
          //   560: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   563: new 213	com/tencent/wcdb/repair/RecoverKit
          //   566: dup
          //   567: aload 15
          //   569: aload 18
          //   571: iconst_0
          //   572: invokestatic 264	com/tencent/mm/b/q:k	(Ljava/lang/String;Z)Ljava/lang/String;
          //   575: aload 17
          //   577: invokespecial 267	com/tencent/wcdb/repair/RecoverKit:<init>	(Lcom/tencent/wcdb/database/SQLiteDatabase;Ljava/lang/String;[B)V
          //   580: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   583: pop
          //   584: lload 7
          //   586: lstore 9
          //   588: aload 15
          //   590: astore 16
          //   592: aload_0
          //   593: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   596: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   599: astore 14
          //   601: aload 14
          //   603: ifnonnull +250 -> 853
          //   606: bipush 253
          //   608: istore_2
          //   609: aload 15
          //   611: astore 14
          //   613: iload_2
          //   614: istore_1
          //   615: aload 15
          //   617: astore 16
          //   619: getstatic 243	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
          //   622: ldc2_w 268
          //   625: ldc2_w 270
          //   628: lconst_1
          //   629: iconst_1
          //   630: invokevirtual 275	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   633: aload 15
          //   635: astore 14
          //   637: iload_2
          //   638: istore_1
          //   639: aload 15
          //   641: astore 16
          //   643: new 277	java/lang/RuntimeException
          //   646: dup
          //   647: invokespecial 278	java/lang/RuntimeException:<init>	()V
          //   650: astore 17
          //   652: aload 15
          //   654: astore 14
          //   656: iload_2
          //   657: istore_1
          //   658: aload 15
          //   660: astore 16
          //   662: sipush 23079
          //   665: invokestatic 237	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   668: aload 15
          //   670: astore 14
          //   672: iload_2
          //   673: istore_1
          //   674: aload 15
          //   676: astore 16
          //   678: aload 17
          //   680: athrow
          //   681: astore 16
          //   683: aload 14
          //   685: astore 15
          //   687: aload 16
          //   689: astore 14
          //   691: aload 15
          //   693: astore 16
          //   695: ldc 187
          //   697: aload 14
          //   699: ldc_w 280
          //   702: iconst_0
          //   703: anewarray 4	java/lang/Object
          //   706: invokestatic 284	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
          //   709: aload 15
          //   711: astore 16
          //   713: aload_0
          //   714: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:oaF	Lcom/tencent/mm/plugin/dbbackup/b;
          //   717: ifnull +17 -> 734
          //   720: aload 15
          //   722: astore 16
          //   724: aload_0
          //   725: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:oaF	Lcom/tencent/mm/plugin/dbbackup/b;
          //   728: iload_1
          //   729: invokeinterface 207 2 0
          //   734: aload 15
          //   736: astore 16
          //   738: getstatic 243	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
          //   741: ldc2_w 268
          //   744: ldc2_w 285
          //   747: lconst_1
          //   748: iconst_1
          //   749: invokevirtual 275	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   752: aload_0
          //   753: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   756: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   759: ifnull +22 -> 781
          //   762: aload_0
          //   763: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   766: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   769: invokevirtual 216	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   772: aload_0
          //   773: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   776: aconst_null
          //   777: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   780: pop
          //   781: aload 15
          //   783: ifnull +8 -> 791
          //   786: aload 15
          //   788: invokevirtual 219	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   791: aload_0
          //   792: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   795: invokestatic 223	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
          //   798: pop
          //   799: invokestatic 229	com/tencent/mm/model/az:afE	()Lcom/tencent/mm/sdk/platformtools/aq;
          //   802: invokevirtual 234	com/tencent/mm/sdk/platformtools/aq:eFR	()V
          //   805: sipush 23079
          //   808: invokestatic 237	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   811: return
          //   812: astore 18
          //   814: aload 15
          //   816: astore 16
          //   818: ldc 187
          //   820: new 79	java/lang/StringBuilder
          //   823: dup
          //   824: ldc_w 288
          //   827: invokespecial 289	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
          //   830: aload 18
          //   832: invokevirtual 292	java/lang/Exception:getMessage	()Ljava/lang/String;
          //   835: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   838: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   841: invokestatic 296	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
          //   844: iconst_m1
          //   845: istore_1
          //   846: lload 9
          //   848: lstore 7
          //   850: goto -626 -> 224
          //   853: aload 15
          //   855: astore 16
          //   857: aload_0
          //   858: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   861: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   864: iconst_0
          //   865: invokevirtual 299	com/tencent/wcdb/repair/RecoverKit:run	(Z)I
          //   868: istore 4
          //   870: aload 15
          //   872: astore 14
          //   874: iload 4
          //   876: istore_1
          //   877: aload 15
          //   879: astore 16
          //   881: invokestatic 302	com/tencent/mm/plugin/dbbackup/d:bPV	()V
          //   884: aload 15
          //   886: astore 14
          //   888: iload 4
          //   890: istore_1
          //   891: aload 15
          //   893: astore 16
          //   895: invokestatic 77	java/lang/System:nanoTime	()J
          //   898: lload 11
          //   900: lsub
          //   901: lstore 7
          //   903: aload 15
          //   905: astore 14
          //   907: iload 4
          //   909: istore_1
          //   910: aload 15
          //   912: astore 16
          //   914: aload_0
          //   915: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   918: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   921: invokevirtual 305	com/tencent/wcdb/repair/RecoverKit:successCount	()I
          //   924: istore 5
          //   926: aload 15
          //   928: astore 14
          //   930: iload 4
          //   932: istore_1
          //   933: aload 15
          //   935: astore 16
          //   937: aload_0
          //   938: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   941: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   944: invokevirtual 308	com/tencent/wcdb/repair/RecoverKit:failureCount	()I
          //   947: istore 6
          //   949: aload 15
          //   951: astore 14
          //   953: iload 4
          //   955: istore_1
          //   956: aload 15
          //   958: astore 16
          //   960: aload_0
          //   961: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   964: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   967: invokevirtual 311	com/tencent/wcdb/repair/RecoverKit:lastError	()Ljava/lang/String;
          //   970: astore 19
          //   972: aload 15
          //   974: astore 14
          //   976: iload 4
          //   978: istore_1
          //   979: aload 15
          //   981: astore 16
          //   983: aload_0
          //   984: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   987: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   990: invokevirtual 216	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   993: aload 15
          //   995: astore 14
          //   997: iload 4
          //   999: istore_1
          //   1000: aload 15
          //   1002: astore 16
          //   1004: aload_0
          //   1005: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1008: aconst_null
          //   1009: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1012: pop
          //   1013: aload 15
          //   1015: astore 14
          //   1017: iload 4
          //   1019: istore_1
          //   1020: aload 15
          //   1022: astore 16
          //   1024: aload 15
          //   1026: invokevirtual 219	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   1029: aconst_null
          //   1030: astore 18
          //   1032: aconst_null
          //   1033: astore 17
          //   1035: iload 4
          //   1037: ifne +275 -> 1312
          //   1040: ldc_w 313
          //   1043: astore 15
          //   1045: aload 17
          //   1047: astore 14
          //   1049: iload 4
          //   1051: istore_1
          //   1052: aload 18
          //   1054: astore 16
          //   1056: ldc 187
          //   1058: ldc_w 315
          //   1061: iconst_4
          //   1062: anewarray 4	java/lang/Object
          //   1065: dup
          //   1066: iconst_0
          //   1067: aload 15
          //   1069: aastore
          //   1070: dup
          //   1071: iconst_1
          //   1072: lload 7
          //   1074: l2f
          //   1075: ldc_w 316
          //   1078: fdiv
          //   1079: invokestatic 321	java/lang/Float:valueOf	(F)Ljava/lang/Float;
          //   1082: aastore
          //   1083: dup
          //   1084: iconst_2
          //   1085: iload 5
          //   1087: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1090: aastore
          //   1091: dup
          //   1092: iconst_3
          //   1093: iload 6
          //   1095: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1098: aastore
          //   1099: invokestatic 200	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1102: iload 4
          //   1104: ifne +374 -> 1478
          //   1107: sipush 10005
          //   1110: istore_3
          //   1111: bipush 22
          //   1113: istore_2
          //   1114: aload 17
          //   1116: astore 14
          //   1118: iload 4
          //   1120: istore_1
          //   1121: aload 18
          //   1123: astore 16
          //   1125: getstatic 243	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
          //   1128: sipush 11098
          //   1131: iconst_2
          //   1132: anewarray 4	java/lang/Object
          //   1135: dup
          //   1136: iconst_0
          //   1137: iload_3
          //   1138: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1141: aastore
          //   1142: dup
          //   1143: iconst_1
          //   1144: ldc_w 323
          //   1147: iconst_4
          //   1148: anewarray 4	java/lang/Object
          //   1151: dup
          //   1152: iconst_0
          //   1153: lload 9
          //   1155: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1158: aastore
          //   1159: dup
          //   1160: iconst_1
          //   1161: lload 7
          //   1163: ldc2_w 324
          //   1166: ldiv
          //   1167: invokestatic 195	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1170: aastore
          //   1171: dup
          //   1172: iconst_2
          //   1173: iload 5
          //   1175: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1178: aastore
          //   1179: dup
          //   1180: iconst_3
          //   1181: iload 6
          //   1183: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1186: aastore
          //   1187: invokestatic 254	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   1190: aastore
          //   1191: invokevirtual 258	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
          //   1194: iload_2
          //   1195: iflt +27 -> 1222
          //   1198: aload 17
          //   1200: astore 14
          //   1202: iload 4
          //   1204: istore_1
          //   1205: aload 18
          //   1207: astore 16
          //   1209: getstatic 243	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
          //   1212: ldc2_w 268
          //   1215: iload_2
          //   1216: i2l
          //   1217: lconst_1
          //   1218: iconst_1
          //   1219: invokevirtual 275	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
          //   1222: aload 17
          //   1224: astore 14
          //   1226: iload 4
          //   1228: istore_1
          //   1229: aload 18
          //   1231: astore 16
          //   1233: aload_0
          //   1234: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:oaF	Lcom/tencent/mm/plugin/dbbackup/b;
          //   1237: ifnull +25 -> 1262
          //   1240: aload 17
          //   1242: astore 14
          //   1244: iload 4
          //   1246: istore_1
          //   1247: aload 18
          //   1249: astore 16
          //   1251: aload_0
          //   1252: getfield 33	com/tencent/mm/plugin/dbbackup/d$2:oaF	Lcom/tencent/mm/plugin/dbbackup/b;
          //   1255: iload 4
          //   1257: invokeinterface 207 2 0
          //   1262: aload_0
          //   1263: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1266: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1269: ifnull +22 -> 1291
          //   1272: aload_0
          //   1273: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1276: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1279: invokevirtual 216	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   1282: aload_0
          //   1283: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1286: aconst_null
          //   1287: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1290: pop
          //   1291: aload_0
          //   1292: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1295: invokestatic 223	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
          //   1298: pop
          //   1299: invokestatic 229	com/tencent/mm/model/az:afE	()Lcom/tencent/mm/sdk/platformtools/aq;
          //   1302: invokevirtual 234	com/tencent/mm/sdk/platformtools/aq:eFR	()V
          //   1305: sipush 23079
          //   1308: invokestatic 237	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1311: return
          //   1312: iload 4
          //   1314: iconst_1
          //   1315: if_icmpne +155 -> 1470
          //   1318: ldc_w 327
          //   1321: astore 15
          //   1323: goto -278 -> 1045
          //   1326: sipush 10007
          //   1329: istore_3
          //   1330: bipush 23
          //   1332: istore_2
          //   1333: aload 17
          //   1335: astore 14
          //   1337: iload 4
          //   1339: istore_1
          //   1340: aload 18
          //   1342: astore 16
          //   1344: getstatic 243	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
          //   1347: ldc_w 329
          //   1350: ldc_w 331
          //   1353: aload 19
          //   1355: invokestatic 334	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
          //   1358: invokevirtual 338	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
          //   1361: aconst_null
          //   1362: invokevirtual 341	com/tencent/mm/plugin/report/service/h:e	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
          //   1365: goto -251 -> 1114
          //   1368: astore 14
          //   1370: aload_0
          //   1371: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1374: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1377: ifnull +22 -> 1399
          //   1380: aload_0
          //   1381: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1384: invokestatic 211	com/tencent/mm/plugin/dbbackup/d:d	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1387: invokevirtual 216	com/tencent/wcdb/repair/RecoverKit:release	()V
          //   1390: aload_0
          //   1391: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1394: aconst_null
          //   1395: invokestatic 49	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RecoverKit;)Lcom/tencent/wcdb/repair/RecoverKit;
          //   1398: pop
          //   1399: aload 16
          //   1401: ifnull +8 -> 1409
          //   1404: aload 16
          //   1406: invokevirtual 219	com/tencent/wcdb/database/SQLiteDatabase:close	()V
          //   1409: aload_0
          //   1410: getfield 25	com/tencent/mm/plugin/dbbackup/d$2:oaR	Lcom/tencent/mm/plugin/dbbackup/d;
          //   1413: invokestatic 223	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
          //   1416: pop
          //   1417: invokestatic 229	com/tencent/mm/model/az:afE	()Lcom/tencent/mm/sdk/platformtools/aq;
          //   1420: invokevirtual 234	com/tencent/mm/sdk/platformtools/aq:eFR	()V
          //   1423: sipush 23079
          //   1426: invokestatic 237	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1429: aload 14
          //   1431: athrow
          //   1432: astore 14
          //   1434: aconst_null
          //   1435: astore 16
          //   1437: goto -67 -> 1370
          //   1440: astore 14
          //   1442: aconst_null
          //   1443: astore 15
          //   1445: iconst_m1
          //   1446: istore_1
          //   1447: goto -756 -> 691
          //   1450: astore 14
          //   1452: iconst_m1
          //   1453: istore_1
          //   1454: goto -763 -> 691
          //   1457: astore 14
          //   1459: bipush 253
          //   1461: istore_1
          //   1462: goto -771 -> 691
          //   1465: astore 14
          //   1467: goto -776 -> 691
          //   1470: ldc_w 343
          //   1473: astore 15
          //   1475: goto -430 -> 1045
          //   1478: iload 4
          //   1480: iconst_1
          //   1481: if_icmpne -155 -> 1326
          //   1484: sipush 10006
          //   1487: istore_3
          //   1488: iconst_m1
          //   1489: istore_2
          //   1490: goto -376 -> 1114
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	1493	0	this	2
          //   89	1373	1	i	int
          //   163	1327	2	j	int
          //   161	1327	3	k	int
          //   868	614	4	m	int
          //   924	250	5	n	int
          //   947	235	6	i1	int
          //   168	994	7	l1	long
          //   172	982	9	l2	long
          //   34	865	11	l3	long
          //   217	3	13	bool	boolean
          //   62	1274	14	localObject1	Object
          //   1368	62	14	localObject2	Object
          //   1432	1	14	localObject3	Object
          //   1440	1	14	localException1	Exception
          //   1450	1	14	localException2	Exception
          //   1457	1	14	localException3	Exception
          //   1465	1	14	localException4	Exception
          //   120	1354	15	localObject4	Object
          //   124	553	16	localObject5	Object
          //   681	7	16	localException5	Exception
          //   693	743	16	localObject6	Object
          //   69	1265	17	localObject7	Object
          //   183	387	18	localObject8	Object
          //   812	19	18	localException6	Exception
          //   1030	311	18	localObject9	Object
          //   202	1152	19	localObject10	Object
          // Exception table:
          //   from	to	target	type
          //   619	633	681	java/lang/Exception
          //   643	652	681	java/lang/Exception
          //   662	668	681	java/lang/Exception
          //   678	681	681	java/lang/Exception
          //   881	884	681	java/lang/Exception
          //   895	903	681	java/lang/Exception
          //   914	926	681	java/lang/Exception
          //   937	949	681	java/lang/Exception
          //   960	972	681	java/lang/Exception
          //   983	993	681	java/lang/Exception
          //   1004	1013	681	java/lang/Exception
          //   1024	1029	681	java/lang/Exception
          //   1056	1102	681	java/lang/Exception
          //   1125	1194	681	java/lang/Exception
          //   1209	1222	681	java/lang/Exception
          //   1233	1240	681	java/lang/Exception
          //   1251	1262	681	java/lang/Exception
          //   1344	1365	681	java/lang/Exception
          //   193	204	812	java/lang/Exception
          //   212	219	812	java/lang/Exception
          //   331	338	812	java/lang/Exception
          //   346	375	812	java/lang/Exception
          //   383	397	812	java/lang/Exception
          //   405	412	812	java/lang/Exception
          //   420	431	812	java/lang/Exception
          //   499	551	812	java/lang/Exception
          //   559	584	812	java/lang/Exception
          //   126	133	1368	finally
          //   137	143	1368	finally
          //   158	162	1368	finally
          //   193	204	1368	finally
          //   212	219	1368	finally
          //   235	258	1368	finally
          //   262	271	1368	finally
          //   275	279	1368	finally
          //   283	304	1368	finally
          //   331	338	1368	finally
          //   346	375	1368	finally
          //   383	397	1368	finally
          //   405	412	1368	finally
          //   420	431	1368	finally
          //   499	551	1368	finally
          //   559	584	1368	finally
          //   592	601	1368	finally
          //   619	633	1368	finally
          //   643	652	1368	finally
          //   662	668	1368	finally
          //   678	681	1368	finally
          //   695	709	1368	finally
          //   713	720	1368	finally
          //   724	734	1368	finally
          //   738	752	1368	finally
          //   818	844	1368	finally
          //   857	870	1368	finally
          //   881	884	1368	finally
          //   895	903	1368	finally
          //   914	926	1368	finally
          //   937	949	1368	finally
          //   960	972	1368	finally
          //   983	993	1368	finally
          //   1004	1013	1368	finally
          //   1024	1029	1368	finally
          //   1056	1102	1368	finally
          //   1125	1194	1368	finally
          //   1209	1222	1368	finally
          //   1233	1240	1368	finally
          //   1251	1262	1368	finally
          //   1344	1365	1368	finally
          //   15	87	1432	finally
          //   90	96	1432	finally
          //   99	122	1432	finally
          //   15	87	1440	java/lang/Exception
          //   90	96	1440	java/lang/Exception
          //   99	122	1440	java/lang/Exception
          //   126	133	1450	java/lang/Exception
          //   137	143	1450	java/lang/Exception
          //   235	258	1450	java/lang/Exception
          //   262	271	1450	java/lang/Exception
          //   275	279	1450	java/lang/Exception
          //   283	304	1450	java/lang/Exception
          //   158	162	1457	java/lang/Exception
          //   592	601	1465	java/lang/Exception
          //   818	844	1465	java/lang/Exception
          //   857	870	1465	java/lang/Exception
        }
      };
      this.oat = true;
      az.afE().KL();
      az.afE().ay(paramString);
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
    if (this.oat)
    {
      ad.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", new Object[] { "backup" });
      AppMethodBeat.o(23096);
      return false;
    }
    final com.tencent.mm.model.c localc = az.arV();
    final String str1 = com.tencent.mm.model.c.afi();
    final SQLiteDatabase localSQLiteDatabase = com.tencent.mm.model.c.afg().eOh();
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
      if (i.eK(str2))
      {
        i = 24;
        i.lC(str2, str3);
        bool = paramBoolean;
      }
    }
    else
    {
      arrayOfLong2 = a(localSQLiteDatabase);
      if (!bool) {
        break label292;
      }
      arrayOfLong1 = Sb(str1);
      arrayOfString = a(arrayOfLong2, arrayOfLong1);
      if (arrayOfLong1 != null) {
        break label301;
      }
    }
    label292:
    label301:
    for (paramBoolean = false;; paramBoolean = bool)
    {
      if (this.oaA) {
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
                paramb.zN(1);
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
                localObject3 = com.tencent.mm.b.g.E((com.tencent.mm.compatible.deviceinfo.q.cG(true) + com.tencent.mm.model.c.getUin()).getBytes());
                Object localObject1 = new com.tencent.mm.vfs.e(str4);
                com.tencent.mm.vfs.e locale;
                if ((!paramBoolean) || (!((com.tencent.mm.vfs.e)localObject1).exists()))
                {
                  boolean bool = RepairKit.MasterInfo.save(localSQLiteDatabase, com.tencent.mm.b.q.k(str5, true), (byte[])localObject3);
                  locale = new com.tencent.mm.vfs.e(str5);
                  if (bool)
                  {
                    ((com.tencent.mm.vfs.e)localObject1).delete();
                    bool = locale.af((com.tencent.mm.vfs.e)localObject1);
                    l1 = System.nanoTime();
                    if (!bool) {
                      break label1109;
                    }
                    localObject1 = "SUCCEEDED";
                    ad.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", new Object[] { localObject1, Float.valueOf((float)(l1 - l2) / 1.0E+009F) });
                    localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
                    if (!bool) {
                      break label1117;
                    }
                    l1 = 24L;
                    ((com.tencent.mm.plugin.report.service.h)localObject1).idkeyStat(181L, l1, 1L, false);
                  }
                }
                else
                {
                  long l3 = new com.tencent.mm.vfs.e(str1).length();
                  long l4 = new com.tencent.mm.vfs.e(str3).length();
                  if (!paramBoolean) {
                    break label1125;
                  }
                  localObject1 = "incremental";
                  if (arrayOfLong1 == null) {
                    break label1133;
                  }
                  l1 = arrayOfLong1[0];
                  ad.i("MicroMsg.SubCoreDBBackup", "Backup started [%s, cursor: %d ~ %d]", new Object[] { localObject1, Long.valueOf(l1), Long.valueOf(arrayOfLong2[0]) });
                  if (!paramBoolean) {
                    break label1139;
                  }
                  i = 10011;
                  com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(i), String.format("%d|%d|%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), d.this.oaB.format(new Date()) }) });
                  d.a(d.this, new BackupKit(localSQLiteDatabase, str3, (byte[])localObject3, i, arrayOfString));
                  k = d.b(d.this).run();
                  l1 = System.nanoTime() - l2;
                  localObject1 = new com.tencent.mm.vfs.e(str3);
                  l2 = ((com.tencent.mm.vfs.e)localObject1).length();
                  if (k != 0) {
                    continue;
                  }
                  d.b(str1, arrayOfLong2);
                  localObject3 = new com.tencent.mm.vfs.e(str2);
                  ((com.tencent.mm.vfs.e)localObject3).delete();
                  ((com.tencent.mm.vfs.e)localObject1).af((com.tencent.mm.vfs.e)localObject3);
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
                  ad.i("MicroMsg.SubCoreDBBackup", "Database %s backup %s, elapsed %.2f seconds.", new Object[] { localObject3, localObject1, Float.valueOf((float)l1 / 1.0E+009F) });
                  com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(181L, i, 1L, false);
                  com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(j), String.format("%d|%d|%d|%d|%d|%s", new Object[] { Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l2), Integer.valueOf(d.b(d.this).statementCount()), Long.valueOf(l1 / 1000000L), d.this.oaB.format(new Date()) }) });
                  if (paramb != null) {
                    paramb.zN(k);
                  }
                  d.b(d.this).release();
                  d.a(d.this, null);
                  localObject1 = new StringBuilder();
                  com.tencent.mm.kernel.g.afC();
                  i.aMF(com.tencent.mm.kernel.g.afB().gcW + "dbback");
                  localObject1 = str4;
                  localObject3 = new StringBuilder();
                  com.tencent.mm.kernel.g.afC();
                  i.lC((String)localObject1, com.tencent.mm.kernel.g.afB().gcW + "dbback/EnMicroMsg.db.sm");
                  return;
                }
                locale.delete();
                continue;
                ((com.tencent.mm.vfs.e)localObject1).delete();
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
                  com.tencent.mm.plugin.report.service.h localh;
                  if (k != 0) {
                    break label1184;
                  }
                }
              }
              catch (Exception localException)
              {
                ad.printErrStackTrace("MicroMsg.SubCoreDBBackup", localException, "Failed to start database backup, path: %s", new Object[] { str1 });
                if (paramb != null) {
                  paramb.zN(-1);
                }
                localh = com.tencent.mm.plugin.report.service.h.vKh;
                if (paramBoolean)
                {
                  l1 = 18L;
                  localh.idkeyStat(181L, l1, 1L, false);
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
        this.oat = true;
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
    //   10: invokestatic 330	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   13: astore 7
    //   15: aload_1
    //   16: astore 6
    //   18: aload_1
    //   19: ifnonnull +8 -> 27
    //   22: invokestatic 558	com/tencent/mm/model/c:afe	()Ljava/lang/String;
    //   25: astore 6
    //   27: invokestatic 580	com/tencent/mm/sdk/platformtools/bt:eGK	()J
    //   30: lstore 4
    //   32: aload 6
    //   34: ifnonnull +29 -> 63
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +10 -> 50
    //   43: aload_1
    //   44: invokevirtual 564	com/tencent/mm/vfs/e:canRead	()Z
    //   47: ifne +34 -> 81
    //   50: bipush 253
    //   52: istore_3
    //   53: sipush 23099
    //   56: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: iload_3
    //   62: ireturn
    //   63: new 309	com/tencent/mm/vfs/e
    //   66: dup
    //   67: aload 6
    //   69: invokespecial 310	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   72: astore_1
    //   73: goto -34 -> 39
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: ldc 158
    //   83: ldc_w 651
    //   86: iconst_2
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload_1
    //   93: invokevirtual 575	com/tencent/mm/vfs/e:length	()J
    //   96: invokestatic 239	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: lload 4
    //   104: invokestatic 239	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   107: aastore
    //   108: invokestatic 388	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: lload 4
    //   113: l2f
    //   114: aload_1
    //   115: invokevirtual 575	com/tencent/mm/vfs/e:length	()J
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
    //   155: putfield 88	com/tencent/mm/plugin/dbbackup/d:oat	Z
    //   158: invokestatic 586	com/tencent/mm/model/az:afE	()Lcom/tencent/mm/sdk/platformtools/aq;
    //   161: invokevirtual 591	com/tencent/mm/sdk/platformtools/aq:KL	()V
    //   164: invokestatic 586	com/tencent/mm/model/az:afE	()Lcom/tencent/mm/sdk/platformtools/aq;
    //   167: aload_1
    //   168: invokevirtual 598	com/tencent/mm/sdk/platformtools/aq:ay	(Ljava/lang/Runnable;)I
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
  public final boolean bPT()
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
    //   12: putfield 88	com/tencent/mm/plugin/dbbackup/d:oat	Z
    //   15: aload_0
    //   16: getfield 172	com/tencent/mm/plugin/dbbackup/d:oaq	Lcom/tencent/wcdb/repair/BackupKit;
    //   19: ifnonnull +13 -> 32
    //   22: sipush 23097
    //   25: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_1
    //   31: ireturn
    //   32: aload_0
    //   33: getfield 172	com/tencent/mm/plugin/dbbackup/d:oaq	Lcom/tencent/wcdb/repair/BackupKit;
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
    az.arV();
    Object localObject1 = com.tencent.mm.model.c.afk();
    SQLiteDatabase localSQLiteDatabase = com.tencent.mm.model.c.afg().eOh();
    this.oay = ((ab)localObject1).Wx(237569);
    this.oaz = ((ab)localObject1).getInt(237570, 10);
    Object localObject2;
    if (((ab)localObject1).getInt(237571, 0) != 0)
    {
      paramBoolean = true;
      this.oaA = paramBoolean;
      localObject1 = aj.getContext();
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
      this.npp = paramBoolean;
      label117:
      this.npq = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.oaC = new k.a()
      {
        public final void a(String paramAnonymousString, m paramAnonymousm)
        {
          AppMethodBeat.i(23085);
          if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0) && ("event_updated".equals(paramAnonymousString))) {
            d.bPY();
          }
          AppMethodBeat.o(23085);
        }
      };
      com.tencent.mm.model.c.d.aty().add(this.oaC);
      bPU();
      this.oaD = new com.tencent.mm.sdk.b.c() {};
      a.ESL.c(this.oaD);
      this.npr = new BroadcastReceiver()
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
            ad.v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", new Object[] { paramAnonymousContext, Boolean.valueOf(d.i(d.this)), Boolean.valueOf(d.j(d.this)) });
            if ((!d.h(d.this)) || (d.k(d.this) != null) || (!d.j(d.this)) || (d.i(d.this))) {
              break label437;
            }
            if (System.currentTimeMillis() - d.l(d.this) >= 86400000L) {
              break label309;
            }
            ad.d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
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
              public final void zN(int paramAnonymous2Int)
              {
                AppMethodBeat.i(23087);
                d.d(d.this, false);
                az.arV();
                ab localab = com.tencent.mm.model.c.afk();
                d.c(d.this, System.currentTimeMillis());
                if (paramAnonymous2Int == 0)
                {
                  localab.setLong(237569, d.l(d.this));
                  if (bool)
                  {
                    d.n(d.this);
                    localab.setInt(237570, d.m(d.this));
                  }
                }
                for (;;)
                {
                  localab.eKy();
                  do
                  {
                    AppMethodBeat.o(23087);
                    return;
                    d.a(d.this, 0);
                    break;
                  } while (paramAnonymous2Int == 1);
                  localab.setLong(237569, d.l(d.this));
                  if (bool)
                  {
                    d.a(d.this, 10);
                    localab.setInt(237570, d.m(d.this));
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
                az.arV();
                long l1 = new com.tencent.mm.vfs.e(com.tencent.mm.model.c.afi()).length();
                long l2 = bt.eGK();
                if (l1 == 0L)
                {
                  ad.i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
                  AppMethodBeat.o(23088);
                  return;
                }
                if ((l1 > d.f(d.this)) || (l1 > l2))
                {
                  ad.i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
                  com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(10008), String.format("%d|%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) }) });
                  AppMethodBeat.o(23088);
                  return;
                }
                d.d(d.this, d.this.a(bool, paramAnonymousContext));
                if (d.o(d.this)) {
                  ad.i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
                }
                AppMethodBeat.o(23088);
              }
            });
            az.afE().m(d.k(d.this), d.g(d.this));
            ad.i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
            com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(10009), d.this.oaB.format(new Date()) });
            AppMethodBeat.o(23089);
            return;
          }
          label437:
          if (d.k(d.this) != null)
          {
            az.afE().cBt().removeCallbacks(d.k(d.this));
            d.a(d.this, null);
            ad.i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
            com.tencent.mm.plugin.report.service.h.vKh.f(11098, new Object[] { Integer.valueOf(10010), d.this.oaB.format(new Date()) });
            AppMethodBeat.o(23089);
            return;
          }
          if (d.o(d.this))
          {
            d.this.bPT();
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
      ((Context)localObject1).registerReceiver(this.npr, (IntentFilter)localObject2);
      com.tencent.mm.pluginsdk.cmd.b.a(new c(this), new String[] { "//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy" });
      if (!this.oav) {
        break label565;
      }
      localObject1 = "enabled";
      label337:
      if (!this.npq) {
        break label572;
      }
      localObject2 = "";
      label349:
      if (!this.npp) {
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
      ad.i("MicroMsg.SubCoreDBBackup", "Auto database backup %s. Device status:%s interactive,%s charging.", new Object[] { localObject1, localObject2, str });
      b(localSQLiteDatabase);
      com.tencent.mm.plugin.dbbackup.a.b.Sf(com.tencent.mm.compatible.deviceinfo.q.cG(true));
      i.deleteFile(com.tencent.mm.kernel.g.afB().gcW + "dbback/EnMicroMsg.db.bak");
      i.deleteFile(com.tencent.mm.kernel.g.afB().gcW + "dbback/corrupted/EnMicroMsg.db.bak");
      i.deleteFile(com.tencent.mm.kernel.g.afB().cachePath + "EnMicroMsg.db.bak");
      i.deleteFile(com.tencent.mm.kernel.g.afB().cachePath + "corrupted/EnMicroMsg.db.bak");
      localObject1 = com.tencent.mm.model.c.aff();
      az.afE().m(new d.6(this, (String)localObject1), 60000L);
      AppMethodBeat.o(23101);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label112;
      this.npp = false;
      break label117;
      localObject1 = "disabled";
      break label337;
      localObject2 = " not";
      break label349;
    }
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(23102);
    bPT();
    this.oau = false;
    if (this.nps != null)
    {
      az.afE().cBt().removeCallbacks(this.nps);
      this.nps = null;
    }
    if (this.oaD != null)
    {
      a.ESL.d(this.oaD);
      this.oaD = null;
    }
    if (this.npr != null)
    {
      aj.getContext().unregisterReceiver(this.npr);
      this.npr = null;
    }
    com.tencent.mm.pluginsdk.cmd.b.Q(new String[] { "//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy" });
    AppMethodBeat.o(23102);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d
 * JD-Core Version:    0.7.0.1
 */