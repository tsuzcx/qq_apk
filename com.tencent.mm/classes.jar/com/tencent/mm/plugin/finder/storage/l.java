package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "_db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CONDITION_POST", "", "FAIL_OR_WAITING", "TABLE", "getTABLE", "()Ljava/lang/String;", "db", "localFlagSet", "Ljava/util/ArrayList;", "", "clean", "", "sourceFlag", "clearAllPostFeed", "", "deleteByGroupId", "objectIds", "", "", "deleteById", "objectId", "deleteByLocalId", "localId", "cleanPage", "drop", "getAllWaitingPostFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getById", "id", "getByLocalId", "getFailAndWaitingPostFeed", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "endTime", "getWaitingPostFeed", "insertNewFeed", "finderObj", "printAllItem", "tag", "testDB", "sql", "update", "svrId", "finder", "updateByLocal", "Companion", "plugin-finder_release"})
public final class l
  extends MAutoStorage<ch>
{
  private static final String[] SQL_CREATE;
  public static final a vDM;
  public final String TABLE;
  public final ISQLiteDatabase db;
  public String vDJ;
  private String vDK;
  private final ArrayList<Integer> vDL;
  
  static
  {
    AppMethodBeat.i(166976);
    vDM = new a((byte)0);
    FinderItem.a locala = FinderItem.Companion;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(FinderItem.access$getInfo$cp(), "FinderFeedItem") };
    AppMethodBeat.o(166976);
  }
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, FinderItem.access$getInfo$cp(), "FinderFeedItem", ch.INDEX_CREATE);
    AppMethodBeat.i(166975);
    this.TABLE = "FinderFeedItem";
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase = ap.vFv;
    this.vDL = ap.a.eu(j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }));
    paramISQLiteDatabase = new ArrayList();
    localObject = this.vDL.iterator();
    Integer localInteger;
    while (((Iterator)localObject).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject).next();
      if (((localInteger.intValue() & 0x1) != 0) && ((localInteger.intValue() & 0x2) == 0)) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    localObject = ap.vFv;
    this.vDJ = ap.a.k((List)paramISQLiteDatabase, "localFlag");
    Log.i("Finder.FinderFeedStorage", "CONDITION_POST " + this.vDJ);
    paramISQLiteDatabase.clear();
    localObject = this.vDL.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject).next();
      if (((localInteger.intValue() & 0x1) != 0) || ((localInteger.intValue() & 0x2) != 0)) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    localObject = ap.vFv;
    this.vDK = ap.a.k((List)paramISQLiteDatabase, "localFlag");
    Log.i("Finder.FinderFeedStorage", "FAIL_OR_WAITING " + this.vDK);
    AppMethodBeat.o(166975);
  }
  
  public final boolean A(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(166971);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.storage.data.l.a locala = com.tencent.mm.plugin.finder.storage.data.l.vGw;
      com.tencent.mm.plugin.finder.storage.data.l.a.FQ(paramLong);
    }
    if (this.db.delete("FinderFeedItem", "localId=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(166971);
      return true;
    }
    AppMethodBeat.o(166971);
    return false;
  }
  
  public final boolean FA(long paramLong)
  {
    AppMethodBeat.i(166970);
    Object localObject = com.tencent.mm.plugin.finder.storage.data.e.vFX;
    boolean bool = e.a.BX(paramLong);
    localObject = com.tencent.mm.plugin.finder.storage.data.l.vGw;
    localObject = com.tencent.mm.plugin.finder.storage.data.l.dyE();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      int k = ((Number)localObject[i]).intValue();
      com.tencent.mm.plugin.finder.storage.data.l.a locala = com.tencent.mm.plugin.finder.storage.data.l.vGw;
      com.tencent.mm.plugin.finder.storage.data.l.a.L(paramLong, k);
      i += 1;
    }
    if (this.db.delete("FinderFeedItem", "id=?", new String[] { String.valueOf(paramLong) }) > 0) {}
    for (i = 1; (bool) || (i != 0); i = 0)
    {
      AppMethodBeat.o(166970);
      return true;
    }
    AppMethodBeat.o(166970);
    return false;
  }
  
  /* Error */
  public final FinderItem Fy(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 286
    //   6: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc_w 288
    //   12: lload_1
    //   13: invokestatic 248	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   16: invokevirtual 292	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_3
    //   20: aload_0
    //   21: getfield 132	com/tencent/mm/plugin/finder/storage/l:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   24: aload_3
    //   25: aconst_null
    //   26: iconst_2
    //   27: invokeinterface 296 4 0
    //   32: astore 6
    //   34: new 91	com/tencent/mm/plugin/finder/storage/FinderItem
    //   37: dup
    //   38: invokespecial 297	com/tencent/mm/plugin/finder/storage/FinderItem:<init>	()V
    //   41: astore_3
    //   42: aload 6
    //   44: ifnull +37 -> 81
    //   47: aload 6
    //   49: checkcast 299	java/io/Closeable
    //   52: astore 5
    //   54: aload 6
    //   56: invokeinterface 304 1 0
    //   61: ifeq +9 -> 70
    //   64: aload_3
    //   65: aload 6
    //   67: invokevirtual 308	com/tencent/mm/plugin/finder/storage/FinderItem:convertFrom	(Landroid/database/Cursor;)V
    //   70: getstatic 314	kotlin/x:SXb	Lkotlin/x;
    //   73: astore 6
    //   75: aload 5
    //   77: aconst_null
    //   78: invokestatic 319	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   81: ldc_w 286
    //   84: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_3
    //   88: areturn
    //   89: astore 4
    //   91: ldc_w 286
    //   94: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload 4
    //   99: athrow
    //   100: astore_3
    //   101: aload 5
    //   103: aload 4
    //   105: invokestatic 319	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   108: ldc_w 286
    //   111: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_3
    //   115: athrow
    //   116: astore_3
    //   117: goto -16 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	l
    //   0	120	1	paramLong	long
    //   19	69	3	localObject1	Object
    //   100	15	3	localObject2	Object
    //   116	1	3	localObject3	Object
    //   1	1	4	localObject4	Object
    //   89	15	4	localThrowable	java.lang.Throwable
    //   52	50	5	localCloseable	java.io.Closeable
    //   32	42	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   54	70	89	java/lang/Throwable
    //   70	75	89	java/lang/Throwable
    //   91	100	100	finally
    //   54	70	116	finally
    //   70	75	116	finally
  }
  
  public final FinderItem Fz(long paramLong)
  {
    FinderItem localFinderItem = null;
    AppMethodBeat.i(166966);
    Object localObject = "SELECT * FROM FinderFeedItem  WHERE FinderFeedItem.localId=".concat(String.valueOf(paramLong));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localFinderItem = new FinderItem();
      p.g(localObject, "cu");
      localFinderItem.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(166966);
    return localFinderItem;
  }
  
  public final boolean a(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(251727);
    p.h(paramFinderItem, "finder");
    if (paramLong == 0L) {
      Log.printInfoStack("Finder.FinderFeedStorage", "update svrId " + paramLong + ' ' + paramFinderItem.info() + ' ' + Util.getStack(), new Object[0]);
    }
    paramFinderItem = paramFinderItem.convertTo();
    paramFinderItem.remove("rowid");
    if (this.db.update("FinderFeedItem", paramFinderItem, "id=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(251727);
      return true;
    }
    AppMethodBeat.o(251727);
    return false;
  }
  
  /* Error */
  public final java.util.LinkedList<FinderItem> af(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 377
    //   6: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ldc_w 378
    //   13: invokestatic 119	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: new 380	com/tencent/mm/ac/c
    //   19: dup
    //   20: ldc_w 381
    //   23: invokespecial 382	com/tencent/mm/ac/c:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: new 198	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 384
    //   34: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: iload_2
    //   38: invokevirtual 387	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 389
    //   44: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 387	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 391
    //   54: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload_0
    //   63: getfield 132	com/tencent/mm/plugin/finder/storage/l:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   66: aload 5
    //   68: aconst_null
    //   69: iconst_2
    //   70: invokeinterface 296 4 0
    //   75: astore 7
    //   77: ldc 196
    //   79: ldc_w 393
    //   82: aload_1
    //   83: invokestatic 396	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual 292	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: new 398	java/util/LinkedList
    //   95: dup
    //   96: invokespecial 399	java/util/LinkedList:<init>	()V
    //   99: astore 6
    //   101: aload 7
    //   103: checkcast 299	java/io/Closeable
    //   106: astore 5
    //   108: aload 7
    //   110: invokeinterface 304 1 0
    //   115: ifeq +51 -> 166
    //   118: new 91	com/tencent/mm/plugin/finder/storage/FinderItem
    //   121: dup
    //   122: invokespecial 297	com/tencent/mm/plugin/finder/storage/FinderItem:<init>	()V
    //   125: astore 8
    //   127: aload 7
    //   129: ldc_w 325
    //   132: invokestatic 328	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   135: aload 8
    //   137: aload 7
    //   139: invokevirtual 308	com/tencent/mm/plugin/finder/storage/FinderItem:convertFrom	(Landroid/database/Cursor;)V
    //   142: aload 8
    //   144: invokevirtual 403	com/tencent/mm/plugin/finder/storage/FinderItem:getFeedObject	()Lcom/tencent/mm/protocal/protobuf/FinderObject;
    //   147: pop
    //   148: aload 6
    //   150: aload 8
    //   152: invokevirtual 404	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   155: pop
    //   156: aload 7
    //   158: invokeinterface 407 1 0
    //   163: ifne -45 -> 118
    //   166: getstatic 314	kotlin/x:SXb	Lkotlin/x;
    //   169: astore 7
    //   171: aload 5
    //   173: aconst_null
    //   174: invokestatic 319	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   177: ldc 196
    //   179: ldc_w 409
    //   182: aload_1
    //   183: invokestatic 396	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual 292	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: ldc_w 377
    //   195: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 6
    //   200: areturn
    //   201: astore 4
    //   203: ldc_w 377
    //   206: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload 4
    //   211: athrow
    //   212: astore_1
    //   213: aload 5
    //   215: aload 4
    //   217: invokestatic 319	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   220: ldc_w 377
    //   223: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_1
    //   227: athrow
    //   228: astore_1
    //   229: goto -16 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	l
    //   0	232	1	paramString	String
    //   0	232	2	paramInt1	int
    //   0	232	3	paramInt2	int
    //   1	1	4	localObject1	Object
    //   201	15	4	localThrowable	java.lang.Throwable
    //   60	154	5	localObject2	Object
    //   99	100	6	localLinkedList	java.util.LinkedList
    //   75	95	7	localObject3	Object
    //   125	26	8	localFinderItem	FinderItem
    // Exception table:
    //   from	to	target	type
    //   108	118	201	java/lang/Throwable
    //   118	166	201	java/lang/Throwable
    //   166	171	201	java/lang/Throwable
    //   203	212	212	finally
    //   108	118	228	finally
    //   118	166	228	finally
    //   166	171	228	finally
  }
  
  public final boolean b(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166968);
    p.h(paramFinderItem, "finderObj");
    paramFinderItem = paramFinderItem.convertTo();
    paramFinderItem.remove("rowid");
    if (this.db.update("FinderFeedItem", paramFinderItem, "localId=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(166968);
      return true;
    }
    AppMethodBeat.o(166968);
    return false;
  }
  
  public final FinderItem dxC()
  {
    AppMethodBeat.i(166973);
    FinderItem localFinderItem = new FinderItem();
    String str = "SELECT * FROM FinderFeedItem  WHERE " + this.vDJ + " ORDER BY " + this.TABLE + ".localId ASC LIMIT 1";
    Cursor localCursor = this.db.rawQuery(str, null, 2);
    Log.d("Finder.FinderFeedStorage", "getWaitingPost ".concat(String.valueOf(str)));
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(166973);
      return null;
    }
    p.g(localCursor, "cr");
    localFinderItem.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(166973);
    return localFinderItem;
  }
  
  public final List<FinderItem> dxD()
  {
    AppMethodBeat.i(166974);
    Object localObject = new ArrayList();
    Cursor localCursor = this.db.rawQuery("SELECT * FROM FinderFeedItem  WHERE localFlag IN (1, 2);", null, 2);
    while (localCursor.moveToNext())
    {
      FinderItem localFinderItem = new FinderItem();
      p.g(localCursor, "cr");
      localFinderItem.convertFrom(localCursor);
      ((ArrayList)localObject).add(localFinderItem);
    }
    localCursor.close();
    localObject = (List)localObject;
    AppMethodBeat.o(166974);
    return localObject;
  }
  
  /* Error */
  public final void et(List<Long> paramList)
  {
    // Byte code:
    //   0: ldc_w 439
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 440
    //   10: invokestatic 119	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: invokestatic 446	android/os/SystemClock:uptimeMillis	()J
    //   16: lstore 5
    //   18: getstatic 237	com/tencent/mm/plugin/finder/storage/data/l:vGw	Lcom/tencent/mm/plugin/finder/storage/data/l$a;
    //   21: astore 9
    //   23: aload_1
    //   24: ldc_w 448
    //   27: invokestatic 119	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   30: aload_1
    //   31: checkcast 450	java/lang/Iterable
    //   34: invokestatic 453	kotlin/a/j:o	(Ljava/lang/Iterable;)Ljava/util/HashSet;
    //   37: pop
    //   38: invokestatic 272	com/tencent/mm/plugin/finder/storage/data/l:dyE	()[Ljava/lang/Integer;
    //   41: astore 10
    //   43: aload 10
    //   45: arraylength
    //   46: istore_3
    //   47: iconst_0
    //   48: istore_2
    //   49: iload_2
    //   50: iload_3
    //   51: if_icmpge +202 -> 253
    //   54: aload 10
    //   56: iload_2
    //   57: aaload
    //   58: checkcast 274	java/lang/Number
    //   61: invokevirtual 275	java/lang/Number:intValue	()I
    //   64: istore 4
    //   66: getstatic 237	com/tencent/mm/plugin/finder/storage/data/l:vGw	Lcom/tencent/mm/plugin/finder/storage/data/l$a;
    //   69: astore 9
    //   71: iload 4
    //   73: invokestatic 457	com/tencent/mm/plugin/finder/storage/data/l$a:Lf	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   76: pop
    //   77: invokestatic 461	com/tencent/mm/plugin/finder/storage/data/l:dyD	()Lcom/tencent/mm/plugin/finder/storage/data/q;
    //   80: iload 4
    //   82: invokevirtual 466	com/tencent/mm/plugin/finder/storage/data/q:Lg	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   85: getfield 472	com/tencent/mm/plugin/finder/storage/data/a:vFP	Lcom/tencent/mm/protocal/protobuf/arb;
    //   88: getfield 477	com/tencent/mm/protocal/protobuf/arb:zns	Ljava/util/LinkedList;
    //   91: astore 9
    //   93: aload 9
    //   95: ifnull +145 -> 240
    //   98: aload 9
    //   100: checkcast 186	java/util/List
    //   103: iconst_0
    //   104: invokestatic 480	kotlin/a/j:L	(Ljava/util/List;I)Ljava/lang/Object;
    //   107: checkcast 482	com/tencent/mm/protocal/protobuf/arl
    //   110: astore 9
    //   112: aload 9
    //   114: ifnull +126 -> 240
    //   117: aload 9
    //   119: getfield 485	com/tencent/mm/protocal/protobuf/arl:gCs	Ljava/util/LinkedList;
    //   122: astore 9
    //   124: aload 9
    //   126: ifnull +114 -> 240
    //   129: getstatic 491	com/tencent/mm/plugin/finder/storage/data/i:vGl	Lcom/tencent/mm/plugin/finder/storage/data/i;
    //   132: astore 11
    //   134: aload_1
    //   135: aload 9
    //   137: invokestatic 494	com/tencent/mm/plugin/finder/storage/data/i:a	(Ljava/util/List;Ljava/util/LinkedList;)Z
    //   140: ifeq +100 -> 240
    //   143: getstatic 500	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   146: ifeq +78 -> 224
    //   149: new 198	java/lang/StringBuilder
    //   152: dup
    //   153: ldc_w 502
    //   156: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: astore 11
    //   161: invokestatic 461	com/tencent/mm/plugin/finder/storage/data/l:dyD	()Lcom/tencent/mm/plugin/finder/storage/data/q;
    //   164: iload 4
    //   166: invokevirtual 466	com/tencent/mm/plugin/finder/storage/data/q:Lg	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   169: getfield 472	com/tencent/mm/plugin/finder/storage/data/a:vFP	Lcom/tencent/mm/protocal/protobuf/arb;
    //   172: getfield 477	com/tencent/mm/protocal/protobuf/arb:zns	Ljava/util/LinkedList;
    //   175: astore 9
    //   177: aload 9
    //   179: ifnull +68 -> 247
    //   182: aload 9
    //   184: checkcast 186	java/util/List
    //   187: iconst_0
    //   188: invokestatic 480	kotlin/a/j:L	(Ljava/util/List;I)Ljava/lang/Object;
    //   191: checkcast 482	com/tencent/mm/protocal/protobuf/arl
    //   194: astore 9
    //   196: aload 9
    //   198: ifnull +49 -> 247
    //   201: aload 9
    //   203: getfield 485	com/tencent/mm/protocal/protobuf/arl:gCs	Ljava/util/LinkedList;
    //   206: astore 9
    //   208: ldc_w 504
    //   211: aload 11
    //   213: aload 9
    //   215: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: getstatic 237	com/tencent/mm/plugin/finder/storage/data/l:vGw	Lcom/tencent/mm/plugin/finder/storage/data/l$a;
    //   227: astore 9
    //   229: invokestatic 461	com/tencent/mm/plugin/finder/storage/data/l:dyD	()Lcom/tencent/mm/plugin/finder/storage/data/q;
    //   232: iload 4
    //   234: invokevirtual 466	com/tencent/mm/plugin/finder/storage/data/q:Lg	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   237: invokestatic 507	com/tencent/mm/plugin/finder/storage/data/l$a:a	(Lcom/tencent/mm/plugin/finder/storage/data/a;)V
    //   240: iload_2
    //   241: iconst_1
    //   242: iadd
    //   243: istore_2
    //   244: goto -195 -> 49
    //   247: aconst_null
    //   248: astore 9
    //   250: goto -42 -> 208
    //   253: new 509	android/util/LongSparseArray
    //   256: dup
    //   257: invokespecial 510	android/util/LongSparseArray:<init>	()V
    //   260: astore 9
    //   262: aload_0
    //   263: getfield 132	com/tencent/mm/plugin/finder/storage/l:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   266: ldc_w 512
    //   269: aconst_null
    //   270: iconst_2
    //   271: invokeinterface 296 4 0
    //   276: checkcast 299	java/io/Closeable
    //   279: astore 10
    //   281: aload 10
    //   283: checkcast 301	android/database/Cursor
    //   286: astore 11
    //   288: aload 11
    //   290: invokeinterface 304 1 0
    //   295: ifeq +73 -> 368
    //   298: aload 11
    //   300: ldc_w 430
    //   303: invokestatic 328	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   306: aload 11
    //   308: invokeinterface 515 1 0
    //   313: ifne +55 -> 368
    //   316: aload 11
    //   318: iconst_0
    //   319: invokeinterface 519 2 0
    //   324: lstore 7
    //   326: aload 9
    //   328: lload 7
    //   330: lload 7
    //   332: invokestatic 524	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   335: invokevirtual 528	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   338: goto -40 -> 298
    //   341: astore 9
    //   343: ldc_w 439
    //   346: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: aload 9
    //   351: athrow
    //   352: astore_1
    //   353: aload 10
    //   355: aload 9
    //   357: invokestatic 319	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   360: ldc_w 439
    //   363: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: aload_1
    //   367: athrow
    //   368: getstatic 314	kotlin/x:SXb	Lkotlin/x;
    //   371: astore 11
    //   373: aload 10
    //   375: aconst_null
    //   376: invokestatic 319	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   379: aload_1
    //   380: checkcast 450	java/lang/Iterable
    //   383: invokeinterface 529 1 0
    //   388: astore 10
    //   390: aload 10
    //   392: invokeinterface 172 1 0
    //   397: ifeq +69 -> 466
    //   400: aload 10
    //   402: invokeinterface 176 1 0
    //   407: checkcast 274	java/lang/Number
    //   410: invokevirtual 532	java/lang/Number:longValue	()J
    //   413: lstore 7
    //   415: getstatic 263	com/tencent/mm/plugin/finder/storage/data/e:vFX	Lcom/tencent/mm/plugin/finder/storage/data/e$a;
    //   418: astore 11
    //   420: lload 7
    //   422: invokestatic 268	com/tencent/mm/plugin/finder/storage/data/e$a:BX	(J)Z
    //   425: pop
    //   426: aload 9
    //   428: lload 7
    //   430: invokevirtual 536	android/util/LongSparseArray:indexOfKey	(J)I
    //   433: iflt -43 -> 390
    //   436: aload_0
    //   437: getfield 132	com/tencent/mm/plugin/finder/storage/l:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   440: ldc 102
    //   442: ldc_w 281
    //   445: iconst_1
    //   446: anewarray 96	java/lang/String
    //   449: dup
    //   450: iconst_0
    //   451: lload 7
    //   453: invokestatic 248	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   456: aastore
    //   457: invokeinterface 254 4 0
    //   462: pop
    //   463: goto -73 -> 390
    //   466: getstatic 500	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   469: ifeq +18 -> 487
    //   472: ldc 196
    //   474: ldc_w 538
    //   477: aload_1
    //   478: invokestatic 396	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   481: invokevirtual 292	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   484: invokestatic 428	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: ldc 196
    //   489: new 198	java/lang/StringBuilder
    //   492: dup
    //   493: ldc_w 540
    //   496: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   499: aload_1
    //   500: invokeinterface 543 1 0
    //   505: invokevirtual 387	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   508: ldc_w 545
    //   511: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokestatic 446	android/os/SystemClock:uptimeMillis	()J
    //   517: lload 5
    //   519: lsub
    //   520: invokevirtual 339	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   523: ldc_w 547
    //   526: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: ldc_w 439
    //   538: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   541: return
    //   542: astore_1
    //   543: aconst_null
    //   544: astore 9
    //   546: goto -193 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	549	0	this	l
    //   0	549	1	paramList	List<Long>
    //   48	196	2	i	int
    //   46	6	3	j	int
    //   64	169	4	k	int
    //   16	502	5	l1	long
    //   324	128	7	l2	long
    //   21	306	9	localObject1	Object
    //   341	86	9	localThrowable	java.lang.Throwable
    //   544	1	9	localObject2	Object
    //   41	360	10	localObject3	Object
    //   132	287	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   281	298	341	java/lang/Throwable
    //   298	338	341	java/lang/Throwable
    //   368	373	341	java/lang/Throwable
    //   343	352	352	finally
    //   281	298	542	finally
    //   298	338	542	finally
    //   368	373	542	finally
  }
  
  public final long k(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166969);
    p.h(paramFinderItem, "finderObj");
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    long l1 = ((com.tencent.mm.kernel.e)localObject).azQ().a(ar.a.OjE, 1L);
    localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).azQ().set(ar.a.OjE, Long.valueOf(1L + l1));
    paramFinderItem.setLocalId(l1);
    localObject = paramFinderItem.convertTo();
    long l2 = this.db.insert("FinderFeedItem", "localId", (ContentValues)localObject);
    Log.i("Finder.FinderFeedStorage", "new feed rowId " + l2 + ' ' + com.tencent.mm.ac.g.bN(paramFinderItem.getFeedObject()) + " localID: " + l1);
    AppMethodBeat.o(166969);
    return l1;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage$Companion;", "", "()V", "FINDER_SELECT_BEGIN", "", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.l
 * JD-Core Version:    0.7.0.1
 */