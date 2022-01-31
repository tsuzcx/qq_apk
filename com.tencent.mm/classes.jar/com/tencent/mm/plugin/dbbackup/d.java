package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.PowerManager;
import com.tencent.mm.as.o;
import com.tencent.mm.cf.f;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  implements ar
{
  private static final SQLiteCipherSpec iNa = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
  private volatile BackupKit iMM;
  private volatile RecoverKit iMN;
  private volatile RepairKit iMO;
  private volatile boolean iMP = false;
  private boolean iMQ = false;
  private boolean iMR = false;
  private long iMS = 0L;
  private long iMT = 600000L;
  private long iMU = 0L;
  private int iMV = 10;
  private boolean iMW = false;
  final SimpleDateFormat iMX = new SimpleDateFormat("HH:mm:ss.SSS");
  private j.a iMY;
  private com.tencent.mm.sdk.b.c iMZ;
  private boolean ijm = false;
  private boolean ijn = true;
  private BroadcastReceiver ijo;
  private Runnable ijp;
  
  /* Error */
  private static boolean a(String paramString, long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: new 108	com/tencent/mm/vfs/h
    //   3: dup
    //   4: new 110	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   11: aload_0
    //   12: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: ldc 117
    //   17: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokespecial 122	com/tencent/mm/vfs/h:<init>	(Ljava/lang/String;)V
    //   26: astore 7
    //   28: aload 7
    //   30: astore 6
    //   32: aload_1
    //   33: arraylength
    //   34: istore_3
    //   35: iconst_0
    //   36: istore_2
    //   37: iload_2
    //   38: iload_3
    //   39: if_icmpge +47 -> 86
    //   42: aload_1
    //   43: iload_2
    //   44: laload
    //   45: lstore 4
    //   47: aload 7
    //   49: astore 6
    //   51: aload 7
    //   53: new 110	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   60: lload 4
    //   62: invokestatic 127	java/lang/Long:toString	(J)Ljava/lang/String;
    //   65: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: ldc 129
    //   70: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokevirtual 132	com/tencent/mm/vfs/h:write	(Ljava/lang/String;)V
    //   79: iload_2
    //   80: iconst_1
    //   81: iadd
    //   82: istore_2
    //   83: goto -46 -> 37
    //   86: aload 7
    //   88: invokevirtual 135	com/tencent/mm/vfs/h:close	()V
    //   91: iconst_1
    //   92: ireturn
    //   93: astore 8
    //   95: aconst_null
    //   96: astore_1
    //   97: aload_1
    //   98: astore 6
    //   100: ldc 137
    //   102: aload 8
    //   104: ldc 139
    //   106: iconst_1
    //   107: anewarray 4	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: aastore
    //   114: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 135	com/tencent/mm/vfs/h:close	()V
    //   125: iconst_0
    //   126: ireturn
    //   127: astore_0
    //   128: aconst_null
    //   129: astore 6
    //   131: aload 6
    //   133: ifnull +8 -> 141
    //   136: aload 6
    //   138: invokevirtual 135	com/tencent/mm/vfs/h:close	()V
    //   141: aload_0
    //   142: athrow
    //   143: astore_0
    //   144: iconst_1
    //   145: ireturn
    //   146: astore_0
    //   147: goto -22 -> 125
    //   150: astore_1
    //   151: goto -10 -> 141
    //   154: astore_0
    //   155: goto -24 -> 131
    //   158: astore 8
    //   160: aload 7
    //   162: astore_1
    //   163: goto -66 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramString	String
    //   0	166	1	paramArrayOfLong	long[]
    //   36	47	2	i	int
    //   34	6	3	j	int
    //   45	16	4	l	long
    //   30	107	6	localObject	Object
    //   26	135	7	localh	com.tencent.mm.vfs.h
    //   93	10	8	localIOException1	java.io.IOException
    //   158	1	8	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	28	93	java/io/IOException
    //   0	28	127	finally
    //   86	91	143	java/io/IOException
    //   121	125	146	java/io/IOException
    //   136	141	150	java/io/IOException
    //   32	35	154	finally
    //   51	79	154	finally
    //   100	117	154	finally
    //   32	35	158	java/io/IOException
    //   51	79	158	java/io/IOException
  }
  
  private static void aFx()
  {
    Object localObject = com.tencent.mm.model.c.c.IX().fJ("100274");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      localObject = ((com.tencent.mm.storage.c)localObject).ctr();
      HashMap localHashMap = new HashMap();
      localHashMap.put("flags", Integer.valueOf(bk.getInt((String)((Map)localObject).get("flags"), 0)));
      localHashMap.put("acp", Integer.valueOf(bk.getInt((String)((Map)localObject).get("acp"), 100)));
      f.ax(localHashMap);
    }
  }
  
  static void aFy()
  {
    Object localObject = com.tencent.mm.model.c.Fy();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject).bhW();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject).bhY();
    ((com.tencent.mm.plugin.messenger.foundation.a.a.g)localObject).bhX();
    com.tencent.mm.model.c.FB().cuF();
    o.OJ().Ot();
    localObject = com.tencent.mm.model.c.Dz();
    ((z)localObject).c(ac.a.uon, Integer.valueOf(0));
    ((z)localObject).c(ac.a.uoo, Integer.valueOf(0));
    ((z)localObject).c(ac.a.uop, Integer.valueOf(0));
  }
  
  public static void aFz()
  {
    MMAppMgr.mU(true);
  }
  
  public static void cT(Context paramContext)
  {
    MMAppMgr.i(paramContext, true);
  }
  
  /* Error */
  private static long[] zA(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 7
    //   3: new 311	java/io/BufferedReader
    //   6: dup
    //   7: new 313	com/tencent/mm/vfs/g
    //   10: dup
    //   11: new 110	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 117
    //   24: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 314	com/tencent/mm/vfs/g:<init>	(Ljava/lang/String;)V
    //   33: invokespecial 317	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   36: astore 10
    //   38: aload 10
    //   40: astore 9
    //   42: aload 10
    //   44: invokevirtual 320	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore 11
    //   49: aload 11
    //   51: ifnull +220 -> 271
    //   54: aload 10
    //   56: astore 9
    //   58: aload 11
    //   60: invokestatic 324	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   63: lstore_1
    //   64: aload 10
    //   66: astore 9
    //   68: aload 10
    //   70: invokevirtual 320	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore 11
    //   75: aload 11
    //   77: ifnull +189 -> 266
    //   80: aload 10
    //   82: astore 9
    //   84: aload 11
    //   86: invokestatic 324	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   89: lstore_3
    //   90: aload 10
    //   92: astore 9
    //   94: aload 10
    //   96: invokevirtual 320	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   99: astore 11
    //   101: aload 11
    //   103: ifnull +157 -> 260
    //   106: aload 10
    //   108: astore 9
    //   110: aload 11
    //   112: invokestatic 324	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   115: lstore 5
    //   117: aload 10
    //   119: astore 9
    //   121: aload 10
    //   123: invokevirtual 320	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   126: astore 11
    //   128: aload 11
    //   130: ifnull +14 -> 144
    //   133: aload 10
    //   135: astore 9
    //   137: aload 11
    //   139: invokestatic 324	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   142: lstore 7
    //   144: aload 10
    //   146: astore 9
    //   148: iconst_4
    //   149: newarray long
    //   151: astore 11
    //   153: aload 11
    //   155: iconst_0
    //   156: lload_1
    //   157: lastore
    //   158: aload 11
    //   160: iconst_1
    //   161: lload_3
    //   162: lastore
    //   163: aload 11
    //   165: iconst_2
    //   166: lload 5
    //   168: lastore
    //   169: aload 11
    //   171: iconst_3
    //   172: lload 7
    //   174: lastore
    //   175: aload 10
    //   177: invokevirtual 325	java/io/BufferedReader:close	()V
    //   180: aload 11
    //   182: areturn
    //   183: astore 11
    //   185: aconst_null
    //   186: astore 10
    //   188: aload 10
    //   190: astore 9
    //   192: ldc 137
    //   194: aload 11
    //   196: ldc_w 327
    //   199: iconst_1
    //   200: anewarray 4	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: aload_0
    //   206: aastore
    //   207: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: aload 10
    //   212: ifnull +8 -> 220
    //   215: aload 10
    //   217: invokevirtual 325	java/io/BufferedReader:close	()V
    //   220: aconst_null
    //   221: areturn
    //   222: astore_0
    //   223: aconst_null
    //   224: astore 9
    //   226: aload 9
    //   228: ifnull +8 -> 236
    //   231: aload 9
    //   233: invokevirtual 325	java/io/BufferedReader:close	()V
    //   236: aload_0
    //   237: athrow
    //   238: astore_0
    //   239: aload 11
    //   241: areturn
    //   242: astore_0
    //   243: goto -23 -> 220
    //   246: astore 9
    //   248: goto -12 -> 236
    //   251: astore_0
    //   252: goto -26 -> 226
    //   255: astore 11
    //   257: goto -69 -> 188
    //   260: lconst_0
    //   261: lstore 5
    //   263: goto -146 -> 117
    //   266: lconst_0
    //   267: lstore_3
    //   268: goto -178 -> 90
    //   271: lconst_0
    //   272: lstore_1
    //   273: goto -209 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramString	String
    //   63	210	1	l1	long
    //   89	179	3	l2	long
    //   115	147	5	l3	long
    //   1	172	7	l4	long
    //   40	192	9	localBufferedReader1	java.io.BufferedReader
    //   246	1	9	localIOException	java.io.IOException
    //   36	180	10	localBufferedReader2	java.io.BufferedReader
    //   47	134	11	localObject	Object
    //   183	57	11	localException1	java.lang.Exception
    //   255	1	11	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	38	183	java/lang/Exception
    //   3	38	222	finally
    //   175	180	238	java/io/IOException
    //   215	220	242	java/io/IOException
    //   231	236	246	java/io/IOException
    //   42	49	251	finally
    //   58	64	251	finally
    //   68	75	251	finally
    //   84	90	251	finally
    //   94	101	251	finally
    //   110	117	251	finally
    //   121	128	251	finally
    //   137	144	251	finally
    //   148	153	251	finally
    //   192	210	251	finally
    //   42	49	255	java/lang/Exception
    //   58	64	255	java/lang/Exception
    //   68	75	255	java/lang/Exception
    //   84	90	255	java/lang/Exception
    //   94	101	255	java/lang/Exception
    //   110	117	255	java/lang/Exception
    //   121	128	255	java/lang/Exception
    //   137	144	255	java/lang/Exception
    //   148	153	255	java/lang/Exception
  }
  
  @Deprecated
  public final int a(b paramb)
  {
    au.Hx();
    Object localObject1 = com.tencent.mm.model.c.Du();
    if ((localObject1 == null) || (((String)localObject1).isEmpty())) {}
    do
    {
      return -3;
      localObject1 = new com.tencent.mm.vfs.b((String)localObject1);
    } while (!((com.tencent.mm.vfs.b)localObject1).canRead());
    Object localObject2 = new StringBuilder().append(q.zf());
    au.Hx();
    localObject2 = com.tencent.mm.a.g.o(com.tencent.mm.model.c.CK().getBytes()).substring(0, 7);
    long l1 = ((com.tencent.mm.vfs.b)localObject1).length() * 2L;
    long l2 = bk.crY();
    y.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    if (l2 < l1) {
      return -2;
    }
    au.DS().sQ();
    au.DS().R(new d.4(this, (com.tencent.mm.vfs.b)localObject1, (String)localObject2, paramb));
    return 0;
  }
  
  @Deprecated
  public final int a(String paramString, b paramb)
  {
    try
    {
      paramString = new d.2(this, au.Hx(), paramString, bk.crY(), paramb);
      this.iMP = true;
      au.DS().sQ();
      au.DS().R(paramString);
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
    if (this.iMP)
    {
      y.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", new Object[] { "backup" });
      return false;
    }
    com.tencent.mm.model.c localc = au.Hx();
    String str1 = com.tencent.mm.model.c.Dx();
    SQLiteDatabase localSQLiteDatabase = com.tencent.mm.model.c.Dv().cxg();
    String str2 = str1 + ".bak";
    String str3 = str2 + ".tmp";
    String str4 = str1 + ".sm";
    String str5 = str4 + ".tmp";
    int j = 8;
    int i = j;
    boolean bool = paramBoolean;
    long l2;
    long l3;
    long l4;
    Object localObject;
    if (paramBoolean)
    {
      if (com.tencent.mm.vfs.e.bK(str2))
      {
        i = 24;
        com.tencent.mm.vfs.e.r(str2, str3);
        bool = paramBoolean;
      }
    }
    else
    {
      l2 = -1L;
      l3 = -1L;
      l4 = -1L;
      localObject = localSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(msgId) FROM message;", null, null);
      if (!((Cursor)localObject).moveToFirst()) {
        break label862;
      }
    }
    label397:
    label689:
    label856:
    label862:
    for (long l1 = ((Cursor)localObject).getLong(0);; l1 = -1L)
    {
      ((Cursor)localObject).close();
      localObject = localSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(id) FROM ImgInfo2;", null, null);
      if (((Cursor)localObject).moveToFirst()) {
        l2 = ((Cursor)localObject).getLong(0);
      }
      ((Cursor)localObject).close();
      localObject = localSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM videoinfo2;", null, null);
      if (((Cursor)localObject).moveToFirst()) {
        l3 = ((Cursor)localObject).getLong(0);
      }
      ((Cursor)localObject).close();
      localObject = localSQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM EmojiInfo;", null, null);
      if (((Cursor)localObject).moveToFirst()) {
        l4 = ((Cursor)localObject).getLong(0);
      }
      ((Cursor)localObject).close();
      long[] arrayOfLong = new long[4];
      arrayOfLong[0] = l1;
      arrayOfLong[1] = l2;
      arrayOfLong[2] = l3;
      arrayOfLong[3] = l4;
      String[] arrayOfString;
      if (bool)
      {
        localObject = zA(str1);
        if ((localObject == null) || (localObject.length < 4)) {
          break label689;
        }
        arrayOfString = new String[12];
        arrayOfString[0] = "message";
        arrayOfString[1] = String.format("msgId > %d AND msgId <= %d", new Object[] { Long.valueOf(localObject[0]), Long.valueOf(arrayOfLong[0]) });
        arrayOfString[2] = "ImgInfo2";
        arrayOfString[3] = String.format("id > %d AND id <= %d", new Object[] { Long.valueOf(localObject[1]), Long.valueOf(arrayOfLong[1]) });
        arrayOfString[4] = "videoinfo2";
        arrayOfString[5] = String.format("rowid > %d AND rowid <= %d", new Object[] { Long.valueOf(localObject[2]), Long.valueOf(arrayOfLong[2]) });
        arrayOfString[6] = "EmojiInfo";
        arrayOfString[7] = String.format("rowid > %d AND rowid <= %d", new Object[] { Long.valueOf(localObject[3]), Long.valueOf(arrayOfLong[3]) });
        arrayOfString[8] = "conversation";
        arrayOfString[9] = null;
        arrayOfString[10] = "rconversation";
        arrayOfString[11] = null;
        label610:
        if (localObject != null) {
          break label856;
        }
      }
      for (paramBoolean = false;; paramBoolean = bool)
      {
        if (this.iMW) {
          i |= 0x3;
        }
        for (;;)
        {
          paramb = new d.1(this, paramb, localc, str4, paramBoolean, localSQLiteDatabase, str5, str1, str3, (long[])localObject, arrayOfLong, i, arrayOfString, str2);
          this.iMP = true;
          com.tencent.mm.sdk.f.e.post(paramb, "DB Backup");
          return true;
          bool = false;
          i = j;
          break;
          localObject = null;
          break label397;
          arrayOfString = new String[12];
          arrayOfString[0] = "message";
          arrayOfString[1] = ("msgId <= " + arrayOfLong[0]);
          arrayOfString[2] = "ImgInfo2";
          arrayOfString[3] = ("id <= " + arrayOfLong[1]);
          arrayOfString[4] = "videoinfo2";
          arrayOfString[5] = ("rowid <= " + arrayOfLong[2]);
          arrayOfString[6] = "EmojiInfo";
          arrayOfString[7] = ("rowid <= " + arrayOfLong[3]);
          arrayOfString[8] = "conversation";
          arrayOfString[9] = null;
          arrayOfString[10] = "rconversation";
          arrayOfString[11] = null;
          break label610;
        }
      }
    }
  }
  
  /* Error */
  public final boolean aFw()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 57	com/tencent/mm/plugin/dbbackup/d:iMP	Z
    //   9: aload_0
    //   10: getfield 92	com/tencent/mm/plugin/dbbackup/d:iMM	Lcom/tencent/wcdb/repair/BackupKit;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +7 -> 22
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 92	com/tencent/mm/plugin/dbbackup/d:iMM	Lcom/tencent/wcdb/repair/BackupKit;
    //   26: invokevirtual 533	com/tencent/wcdb/repair/BackupKit:onCancel	()V
    //   29: iconst_1
    //   30: istore_1
    //   31: goto -13 -> 18
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	d
    //   1	30	1	bool	boolean
    //   13	2	2	localBackupKit	BackupKit
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	14	34	finally
    //   22	29	34	finally
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
    //   4: invokestatic 335	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   7: astore 8
    //   9: aload_1
    //   10: astore 7
    //   12: aload_1
    //   13: ifnonnull +8 -> 21
    //   16: invokestatic 338	com/tencent/mm/model/c:Du	()Ljava/lang/String;
    //   19: astore 7
    //   21: invokestatic 381	com/tencent/mm/sdk/platformtools/bk:crY	()J
    //   24: lstore 4
    //   26: aload 7
    //   28: ifnonnull +27 -> 55
    //   31: aconst_null
    //   32: astore_1
    //   33: aload_1
    //   34: ifnull +14 -> 48
    //   37: aload_1
    //   38: invokevirtual 347	com/tencent/mm/vfs/b:canRead	()Z
    //   41: istore 6
    //   43: iload 6
    //   45: ifne +28 -> 73
    //   48: bipush 253
    //   50: istore_3
    //   51: aload_0
    //   52: monitorexit
    //   53: iload_3
    //   54: ireturn
    //   55: new 343	com/tencent/mm/vfs/b
    //   58: dup
    //   59: aload 7
    //   61: invokespecial 344	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   64: astore_1
    //   65: goto -32 -> 33
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    //   73: ldc 137
    //   75: ldc_w 535
    //   78: iconst_2
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_1
    //   85: invokevirtual 376	com/tencent/mm/vfs/b:length	()J
    //   88: invokestatic 386	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   91: aastore
    //   92: dup
    //   93: iconst_1
    //   94: lload 4
    //   96: invokestatic 386	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   99: aastore
    //   100: invokestatic 389	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: lload 4
    //   105: l2f
    //   106: aload_1
    //   107: invokevirtual 376	com/tencent/mm/vfs/b:length	()J
    //   110: l2f
    //   111: ldc_w 536
    //   114: fmul
    //   115: fcmpg
    //   116: ifge +9 -> 125
    //   119: bipush 254
    //   121: istore_3
    //   122: goto -71 -> 51
    //   125: new 538	com/tencent/mm/plugin/dbbackup/d$3
    //   128: dup
    //   129: aload_0
    //   130: aload 8
    //   132: aload 7
    //   134: aload_2
    //   135: invokespecial 541	com/tencent/mm/plugin/dbbackup/d$3:<init>	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/mm/model/c;Ljava/lang/String;Lcom/tencent/mm/plugin/dbbackup/b;)V
    //   138: astore_1
    //   139: aload_0
    //   140: iconst_1
    //   141: putfield 57	com/tencent/mm/plugin/dbbackup/d:iMP	Z
    //   144: invokestatic 393	com/tencent/mm/model/au:DS	()Lcom/tencent/mm/sdk/platformtools/ai;
    //   147: invokevirtual 398	com/tencent/mm/sdk/platformtools/ai:sQ	()V
    //   150: invokestatic 393	com/tencent/mm/model/au:DS	()Lcom/tencent/mm/sdk/platformtools/ai;
    //   153: aload_1
    //   154: invokevirtual 407	com/tencent/mm/sdk/platformtools/ai:R	(Ljava/lang/Runnable;)I
    //   157: pop
    //   158: goto -107 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	d
    //   0	161	1	paramString	String
    //   0	161	2	paramb	b
    //   1	121	3	i	int
    //   24	80	4	l	long
    //   41	3	6	bool	boolean
    //   10	123	7	str	String
    //   7	124	8	localc	com.tencent.mm.model.c
    // Exception table:
    //   from	to	target	type
    //   4	9	68	finally
    //   16	21	68	finally
    //   21	26	68	finally
    //   37	43	68	finally
    //   55	65	68	finally
    //   73	119	68	finally
    //   125	158	68	finally
  }
  
  public final void bh(boolean paramBoolean)
  {
    au.Hx();
    Object localObject1 = com.tencent.mm.model.c.Dz();
    SQLiteDatabase localSQLiteDatabase = com.tencent.mm.model.c.Dv().cxg();
    this.iMU = ((z)localObject1).Fm(237569);
    this.iMV = ((z)localObject1).getInt(237570, 10);
    Object localObject2;
    label112:
    label117:
    Object localObject3;
    if (((z)localObject1).getInt(237571, 0) != 0)
    {
      paramBoolean = true;
      this.iMW = paramBoolean;
      localObject1 = ae.getContext();
      localObject2 = ((Context)localObject1).registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (localObject2 == null) {
        break label803;
      }
      int i = ((Intent)localObject2).getIntExtra("status", -1);
      if ((i != 2) && (i != 5)) {
        break label798;
      }
      paramBoolean = true;
      this.ijm = paramBoolean;
      this.ijn = ((PowerManager)((Context)localObject1).getSystemService("power")).isScreenOn();
      this.iMY = new d.7(this);
      com.tencent.mm.model.c.c.IX().c(this.iMY);
      aFx();
      this.iMZ = new d.8(this);
      a.udP.c(this.iMZ);
      this.ijo = new d.9(this);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_ON");
      ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_CONNECTED");
      ((IntentFilter)localObject2).addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      ((Context)localObject1).registerReceiver(this.ijo, (IntentFilter)localObject2);
      com.tencent.mm.pluginsdk.cmd.b.a(new c(this), new String[] { "//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status" });
      if (!this.iMR) {
        break label811;
      }
      localObject1 = "enabled";
      label333:
      if (!this.ijn) {
        break label819;
      }
      localObject2 = "";
      label345:
      if (!this.ijm) {
        break label827;
      }
      localObject3 = "";
      label357:
      y.i("MicroMsg.SubCoreDBBackup", "Auto database backup %s. Device status:%s interactive,%s charging.", new Object[] { localObject1, localObject2, localObject3 });
      localObject1 = localSQLiteDatabase.getPath();
      localObject3 = (String)localObject1 + ".sm";
      localObject2 = (String)localObject3 + ".tmp";
      localObject1 = com.tencent.mm.kernel.g.DP().Dz();
      long l2 = ((z)localObject1).Fm(237569);
      l1 = System.currentTimeMillis();
      localObject3 = new com.tencent.mm.vfs.b((String)localObject3);
      if ((!((com.tencent.mm.vfs.b)localObject3).isFile()) || (l1 - l2 <= 86400000L))
      {
        l2 = System.nanoTime();
        StringBuilder localStringBuilder = new StringBuilder().append(q.zf());
        au.Hx();
        paramBoolean = RepairKit.MasterInfo.save(localSQLiteDatabase, (String)localObject2, com.tencent.mm.a.g.p(com.tencent.mm.model.c.CK().getBytes()));
        localObject2 = new com.tencent.mm.vfs.b((String)localObject2);
        if (!paramBoolean) {
          break label835;
        }
        ((com.tencent.mm.vfs.b)localObject3).delete();
        paramBoolean = ((com.tencent.mm.vfs.b)localObject2).n((com.tencent.mm.vfs.b)localObject3);
        ((z)localObject1).setLong(237569, l1);
        ((z)localObject1).mC(false);
        label582:
        l1 = System.nanoTime();
        if (!paramBoolean) {
          break label844;
        }
        localObject1 = "SUCCEEDED";
        label595:
        y.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", new Object[] { localObject1, Float.valueOf((float)(l1 - l2) / 1.0E+009F) });
        localObject1 = com.tencent.mm.plugin.report.service.h.nFQ;
        if (!paramBoolean) {
          break label852;
        }
      }
    }
    label798:
    label803:
    label811:
    label819:
    label827:
    label835:
    label844:
    label852:
    for (long l1 = 24L;; l1 = 25L)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject1).a(181L, l1, 1L, false);
      com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.kernel.g.DP().dKt + "dbback/EnMicroMsg.db.bak");
      com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.kernel.g.DP().dKt + "dbback/corrupted/EnMicroMsg.db.bak");
      com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.kernel.g.DP().cachePath + "EnMicroMsg.db.bak");
      com.tencent.mm.vfs.e.deleteFile(com.tencent.mm.kernel.g.DP().cachePath + "corrupted/EnMicroMsg.db.bak");
      localObject1 = com.tencent.mm.model.c.FT();
      au.DS().k(new d.6(this, (String)localObject1), 60000L);
      return;
      paramBoolean = false;
      break;
      paramBoolean = false;
      break label112;
      this.ijm = false;
      break label117;
      localObject1 = "disabled";
      break label333;
      localObject2 = " not";
      break label345;
      localObject3 = " not";
      break label357;
      ((com.tencent.mm.vfs.b)localObject2).delete();
      break label582;
      localObject1 = "FAILED";
      break label595;
    }
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    aFw();
    this.iMQ = false;
    if (this.ijp != null)
    {
      au.DS().crf().removeCallbacks(this.ijp);
      this.ijp = null;
    }
    if (this.iMZ != null)
    {
      a.udP.d(this.iMZ);
      this.iMZ = null;
    }
    if (this.ijo != null)
    {
      ae.getContext().unregisterReceiver(this.ijo);
      this.ijo = null;
    }
    com.tencent.mm.pluginsdk.cmd.b.E(new String[] { "//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status" });
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d
 * JD-Core Version:    0.7.0.1
 */