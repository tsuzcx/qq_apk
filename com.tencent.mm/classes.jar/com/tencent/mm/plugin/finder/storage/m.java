package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.g;
import com.tencent.mm.f.c.ci;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "_db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CONDITION_POST", "", "FAIL_OR_WAITING", "TABLE", "getTABLE", "()Ljava/lang/String;", "db", "localFlagSet", "Ljava/util/ArrayList;", "", "clean", "", "sourceFlag", "clearAllPostFeed", "", "deleteByGroupId", "objectIds", "", "", "includePostDb", "deleteById", "objectId", "deleteByLocalId", "localId", "cleanPage", "drop", "getAllWaitingPostFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getById", "id", "getByLocalId", "getFailAndWaitingPostFeed", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "endTime", "getWaitingPostFeed", "insertNewFeed", "finderObj", "printAllItem", "tag", "testDB", "sql", "update", "svrId", "finder", "updateByLocal", "Companion", "plugin-finder_release"})
public final class m
  extends MAutoStorage<ci>
{
  public static final a Alj;
  private static final String[] SQL_CREATE;
  public final String Alf;
  public String Alg;
  private String Alh;
  private final ArrayList<Integer> Ali;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(166976);
    Alj = new a((byte)0);
    FinderItem.a locala = FinderItem.Companion;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(FinderItem.a.dYE(), "FinderFeedItem") };
    AppMethodBeat.o(166976);
  }
  
  public m(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, FinderItem.a.dYE(), "FinderFeedItem", ci.INDEX_CREATE);
    AppMethodBeat.i(166975);
    this.Alf = "FinderFeedItem";
    this.db = paramISQLiteDatabase;
    paramISQLiteDatabase = ao.AmN;
    this.Ali = ao.a.eO(j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }));
    paramISQLiteDatabase = new ArrayList();
    localObject = this.Ali.iterator();
    Integer localInteger;
    while (((Iterator)localObject).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject).next();
      if (((localInteger.intValue() & 0x1) != 0) && ((localInteger.intValue() & 0x2) == 0)) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    localObject = ao.AmN;
    this.Alg = ao.a.m((List)paramISQLiteDatabase, "localFlag");
    Log.i("Finder.FinderFeedStorage", "CONDITION_POST " + this.Alg);
    paramISQLiteDatabase.clear();
    localObject = this.Ali.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject).next();
      if (((localInteger.intValue() & 0x1) != 0) || ((localInteger.intValue() & 0x2) != 0)) {
        paramISQLiteDatabase.add(localInteger);
      }
    }
    localObject = ao.AmN;
    this.Alh = ao.a.m((List)paramISQLiteDatabase, "localFlag");
    Log.i("Finder.FinderFeedStorage", "FAIL_OR_WAITING " + this.Alh);
    AppMethodBeat.o(166975);
  }
  
  public final boolean A(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(166971);
    if (paramBoolean)
    {
      k.a locala = k.Anu;
      k.a.MQ(paramLong);
    }
    if (this.db.delete("FinderFeedItem", "localId=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(166971);
      return true;
    }
    AppMethodBeat.o(166971);
    return false;
  }
  
  /* Error */
  public final FinderItem MH(long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 263
    //   6: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc_w 265
    //   12: lload_1
    //   13: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   16: invokevirtual 269	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: astore_3
    //   20: aload_0
    //   21: getfield 136	com/tencent/mm/plugin/finder/storage/m:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   24: aload_3
    //   25: aconst_null
    //   26: iconst_2
    //   27: invokeinterface 273 4 0
    //   32: astore 6
    //   34: new 93	com/tencent/mm/plugin/finder/storage/FinderItem
    //   37: dup
    //   38: invokespecial 274	com/tencent/mm/plugin/finder/storage/FinderItem:<init>	()V
    //   41: astore_3
    //   42: aload 6
    //   44: ifnull +37 -> 81
    //   47: aload 6
    //   49: checkcast 276	java/io/Closeable
    //   52: astore 5
    //   54: aload 6
    //   56: invokeinterface 281 1 0
    //   61: ifeq +9 -> 70
    //   64: aload_3
    //   65: aload 6
    //   67: invokevirtual 285	com/tencent/mm/plugin/finder/storage/FinderItem:convertFrom	(Landroid/database/Cursor;)V
    //   70: getstatic 291	kotlin/x:aazN	Lkotlin/x;
    //   73: astore 6
    //   75: aload 5
    //   77: aconst_null
    //   78: invokestatic 296	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   81: ldc_w 263
    //   84: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload_3
    //   88: areturn
    //   89: astore 4
    //   91: ldc_w 263
    //   94: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload 4
    //   99: athrow
    //   100: astore_3
    //   101: aload 5
    //   103: aload 4
    //   105: invokestatic 296	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   108: ldc_w 263
    //   111: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: aload_3
    //   115: athrow
    //   116: astore_3
    //   117: goto -16 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	m
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
  
  public final FinderItem MI(long paramLong)
  {
    FinderItem localFinderItem = null;
    AppMethodBeat.i(166966);
    Object localObject = "SELECT * FROM FinderFeedItem  WHERE FinderFeedItem.localId=".concat(String.valueOf(paramLong));
    localObject = this.db.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localFinderItem = new FinderItem();
      p.j(localObject, "cu");
      localFinderItem.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(166966);
    return localFinderItem;
  }
  
  public final boolean MJ(long paramLong)
  {
    AppMethodBeat.i(166970);
    Object localObject = e.AmW;
    boolean bool = e.a.Ig(paramLong);
    localObject = k.Anu;
    localObject = k.dZw();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      int k = ((Number)localObject[i]).intValue();
      k.a locala = k.Anu;
      k.a.R(paramLong, k);
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
  
  public final boolean a(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(274897);
    p.k(paramFinderItem, "finder");
    if (paramLong == 0L) {
      Log.printInfoStack("Finder.FinderFeedStorage", "update svrId " + paramLong + ' ' + paramFinderItem.info() + ' ' + Util.getStack(), new Object[0]);
    }
    paramFinderItem = paramFinderItem.convertTo();
    paramFinderItem.remove("rowid");
    if (this.db.update("FinderFeedItem", paramFinderItem, "id=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(274897);
      return true;
    }
    AppMethodBeat.o(274897);
    return false;
  }
  
  /* Error */
  public final java.util.LinkedList<FinderItem> ai(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 381
    //   6: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ldc_w 382
    //   13: invokestatic 123	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: new 384	com/tencent/mm/ae/c
    //   19: dup
    //   20: ldc_w 385
    //   23: invokespecial 386	com/tencent/mm/ae/c:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: new 202	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 388
    //   34: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: iload_2
    //   38: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 393
    //   44: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 395
    //   54: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload_0
    //   63: getfield 136	com/tencent/mm/plugin/finder/storage/m:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   66: aload 5
    //   68: aconst_null
    //   69: iconst_2
    //   70: invokeinterface 273 4 0
    //   75: astore 7
    //   77: ldc 200
    //   79: ldc_w 397
    //   82: aload_1
    //   83: invokestatic 400	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual 269	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: new 402	java/util/LinkedList
    //   95: dup
    //   96: invokespecial 403	java/util/LinkedList:<init>	()V
    //   99: astore 6
    //   101: aload 7
    //   103: checkcast 276	java/io/Closeable
    //   106: astore 5
    //   108: aload 7
    //   110: invokeinterface 281 1 0
    //   115: ifeq +51 -> 166
    //   118: new 93	com/tencent/mm/plugin/finder/storage/FinderItem
    //   121: dup
    //   122: invokespecial 274	com/tencent/mm/plugin/finder/storage/FinderItem:<init>	()V
    //   125: astore 8
    //   127: aload 7
    //   129: ldc_w 302
    //   132: invokestatic 305	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   135: aload 8
    //   137: aload 7
    //   139: invokevirtual 285	com/tencent/mm/plugin/finder/storage/FinderItem:convertFrom	(Landroid/database/Cursor;)V
    //   142: aload 8
    //   144: invokevirtual 407	com/tencent/mm/plugin/finder/storage/FinderItem:getFeedObject	()Lcom/tencent/mm/protocal/protobuf/FinderObject;
    //   147: pop
    //   148: aload 6
    //   150: aload 8
    //   152: invokevirtual 408	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   155: pop
    //   156: aload 7
    //   158: invokeinterface 411 1 0
    //   163: ifne -45 -> 118
    //   166: getstatic 291	kotlin/x:aazN	Lkotlin/x;
    //   169: astore 7
    //   171: aload 5
    //   173: aconst_null
    //   174: invokestatic 296	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   177: ldc 200
    //   179: ldc_w 413
    //   182: aload_1
    //   183: invokestatic 400	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual 269	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: ldc_w 381
    //   195: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload 6
    //   200: areturn
    //   201: astore 4
    //   203: ldc_w 381
    //   206: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aload 4
    //   211: athrow
    //   212: astore_1
    //   213: aload 5
    //   215: aload 4
    //   217: invokestatic 296	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   220: ldc_w 381
    //   223: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_1
    //   227: athrow
    //   228: astore_1
    //   229: goto -16 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	m
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
    p.k(paramFinderItem, "finderObj");
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
  
  public final FinderItem dYC()
  {
    AppMethodBeat.i(166973);
    FinderItem localFinderItem = new FinderItem();
    String str = "SELECT * FROM FinderFeedItem  WHERE " + this.Alg + " ORDER BY " + this.Alf + ".localId ASC LIMIT 1";
    Cursor localCursor = this.db.rawQuery(str, null, 2);
    Log.d("Finder.FinderFeedStorage", "getWaitingPost ".concat(String.valueOf(str)));
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(166973);
      return null;
    }
    p.j(localCursor, "cr");
    localFinderItem.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(166973);
    return localFinderItem;
  }
  
  public final List<FinderItem> dYD()
  {
    AppMethodBeat.i(166974);
    Object localObject = new ArrayList();
    Cursor localCursor = this.db.rawQuery("SELECT * FROM FinderFeedItem  WHERE localFlag IN (1, 2);", null, 2);
    while (localCursor.moveToNext())
    {
      FinderItem localFinderItem = new FinderItem();
      p.j(localCursor, "cr");
      localFinderItem.convertFrom(localCursor);
      ((ArrayList)localObject).add(localFinderItem);
    }
    localCursor.close();
    localObject = (List)localObject;
    AppMethodBeat.o(166974);
    return localObject;
  }
  
  /* Error */
  public final void eN(List<Long> paramList)
  {
    // Byte code:
    //   0: ldc_w 443
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 444
    //   10: invokestatic 123	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: invokestatic 450	android/os/SystemClock:uptimeMillis	()J
    //   16: lstore 5
    //   18: getstatic 241	com/tencent/mm/plugin/finder/storage/data/k:Anu	Lcom/tencent/mm/plugin/finder/storage/data/k$a;
    //   21: astore 9
    //   23: aload_1
    //   24: ldc_w 452
    //   27: invokestatic 123	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   30: aload_1
    //   31: checkcast 454	java/lang/Iterable
    //   34: invokestatic 457	kotlin/a/j:o	(Ljava/lang/Iterable;)Ljava/util/HashSet;
    //   37: pop
    //   38: invokestatic 326	com/tencent/mm/plugin/finder/storage/data/k:dZw	()[Ljava/lang/Integer;
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
    //   58: checkcast 328	java/lang/Number
    //   61: invokevirtual 329	java/lang/Number:intValue	()I
    //   64: istore 4
    //   66: getstatic 241	com/tencent/mm/plugin/finder/storage/data/k:Anu	Lcom/tencent/mm/plugin/finder/storage/data/k$a;
    //   69: astore 9
    //   71: iload 4
    //   73: invokestatic 461	com/tencent/mm/plugin/finder/storage/data/k$a:Qp	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   76: pop
    //   77: invokestatic 465	com/tencent/mm/plugin/finder/storage/data/k:dZv	()Lcom/tencent/mm/plugin/finder/storage/data/p;
    //   80: iload 4
    //   82: invokevirtual 470	com/tencent/mm/plugin/finder/storage/data/p:Qq	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   85: getfield 476	com/tencent/mm/plugin/finder/storage/data/a:AmO	Lcom/tencent/mm/protocal/protobuf/asx;
    //   88: getfield 481	com/tencent/mm/protocal/protobuf/asx:ESJ	Ljava/util/LinkedList;
    //   91: astore 9
    //   93: aload 9
    //   95: ifnull +145 -> 240
    //   98: aload 9
    //   100: checkcast 190	java/util/List
    //   103: iconst_0
    //   104: invokestatic 485	kotlin/a/j:M	(Ljava/util/List;I)Ljava/lang/Object;
    //   107: checkcast 487	com/tencent/mm/protocal/protobuf/ath
    //   110: astore 9
    //   112: aload 9
    //   114: ifnull +126 -> 240
    //   117: aload 9
    //   119: getfield 490	com/tencent/mm/protocal/protobuf/ath:jmy	Ljava/util/LinkedList;
    //   122: astore 9
    //   124: aload 9
    //   126: ifnull +114 -> 240
    //   129: getstatic 496	com/tencent/mm/plugin/finder/storage/data/h:Ang	Lcom/tencent/mm/plugin/finder/storage/data/h;
    //   132: astore 11
    //   134: aload_1
    //   135: aload 9
    //   137: invokestatic 500	com/tencent/mm/plugin/finder/storage/data/h:c	(Ljava/util/List;Ljava/util/LinkedList;)Z
    //   140: ifeq +100 -> 240
    //   143: getstatic 506	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   146: ifeq +78 -> 224
    //   149: new 202	java/lang/StringBuilder
    //   152: dup
    //   153: ldc_w 508
    //   156: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: astore 11
    //   161: invokestatic 465	com/tencent/mm/plugin/finder/storage/data/k:dZv	()Lcom/tencent/mm/plugin/finder/storage/data/p;
    //   164: iload 4
    //   166: invokevirtual 470	com/tencent/mm/plugin/finder/storage/data/p:Qq	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   169: getfield 476	com/tencent/mm/plugin/finder/storage/data/a:AmO	Lcom/tencent/mm/protocal/protobuf/asx;
    //   172: getfield 481	com/tencent/mm/protocal/protobuf/asx:ESJ	Ljava/util/LinkedList;
    //   175: astore 9
    //   177: aload 9
    //   179: ifnull +68 -> 247
    //   182: aload 9
    //   184: checkcast 190	java/util/List
    //   187: iconst_0
    //   188: invokestatic 485	kotlin/a/j:M	(Ljava/util/List;I)Ljava/lang/Object;
    //   191: checkcast 487	com/tencent/mm/protocal/protobuf/ath
    //   194: astore 9
    //   196: aload 9
    //   198: ifnull +49 -> 247
    //   201: aload 9
    //   203: getfield 490	com/tencent/mm/protocal/protobuf/ath:jmy	Ljava/util/LinkedList;
    //   206: astore 9
    //   208: ldc_w 510
    //   211: aload 11
    //   213: aload 9
    //   215: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: getstatic 241	com/tencent/mm/plugin/finder/storage/data/k:Anu	Lcom/tencent/mm/plugin/finder/storage/data/k$a;
    //   227: astore 9
    //   229: invokestatic 465	com/tencent/mm/plugin/finder/storage/data/k:dZv	()Lcom/tencent/mm/plugin/finder/storage/data/p;
    //   232: iload 4
    //   234: invokevirtual 470	com/tencent/mm/plugin/finder/storage/data/p:Qq	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   237: invokestatic 513	com/tencent/mm/plugin/finder/storage/data/k$a:a	(Lcom/tencent/mm/plugin/finder/storage/data/a;)V
    //   240: iload_2
    //   241: iconst_1
    //   242: iadd
    //   243: istore_2
    //   244: goto -195 -> 49
    //   247: aconst_null
    //   248: astore 9
    //   250: goto -42 -> 208
    //   253: new 515	android/util/LongSparseArray
    //   256: dup
    //   257: invokespecial 516	android/util/LongSparseArray:<init>	()V
    //   260: astore 9
    //   262: aload_0
    //   263: getfield 136	com/tencent/mm/plugin/finder/storage/m:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   266: ldc_w 518
    //   269: aconst_null
    //   270: iconst_2
    //   271: invokeinterface 273 4 0
    //   276: checkcast 276	java/io/Closeable
    //   279: astore 10
    //   281: aload 10
    //   283: checkcast 278	android/database/Cursor
    //   286: astore 11
    //   288: aload 11
    //   290: invokeinterface 281 1 0
    //   295: ifeq +88 -> 383
    //   298: aload 11
    //   300: ldc_w 434
    //   303: invokestatic 305	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   306: aload 11
    //   308: invokeinterface 521 1 0
    //   313: ifne +70 -> 383
    //   316: aload 11
    //   318: iconst_0
    //   319: invokeinterface 525 2 0
    //   324: lstore 7
    //   326: lload 7
    //   328: lconst_0
    //   329: lcmp
    //   330: ifeq +15 -> 345
    //   333: aload 9
    //   335: lload 7
    //   337: lload 7
    //   339: invokestatic 530	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   342: invokevirtual 534	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   345: aload 11
    //   347: invokeinterface 411 1 0
    //   352: pop
    //   353: goto -55 -> 298
    //   356: astore 9
    //   358: ldc_w 443
    //   361: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: aload 9
    //   366: athrow
    //   367: astore_1
    //   368: aload 10
    //   370: aload 9
    //   372: invokestatic 296	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   375: ldc_w 443
    //   378: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   381: aload_1
    //   382: athrow
    //   383: getstatic 291	kotlin/x:aazN	Lkotlin/x;
    //   386: astore 11
    //   388: aload 10
    //   390: aconst_null
    //   391: invokestatic 296	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   394: aload_1
    //   395: checkcast 454	java/lang/Iterable
    //   398: invokeinterface 535 1 0
    //   403: astore 10
    //   405: aload 10
    //   407: invokeinterface 176 1 0
    //   412: ifeq +69 -> 481
    //   415: aload 10
    //   417: invokeinterface 180 1 0
    //   422: checkcast 328	java/lang/Number
    //   425: invokevirtual 538	java/lang/Number:longValue	()J
    //   428: lstore 7
    //   430: getstatic 317	com/tencent/mm/plugin/finder/storage/data/e:AmW	Lcom/tencent/mm/plugin/finder/storage/data/e$a;
    //   433: astore 11
    //   435: lload 7
    //   437: invokestatic 322	com/tencent/mm/plugin/finder/storage/data/e$a:Ig	(J)Z
    //   440: pop
    //   441: aload 9
    //   443: lload 7
    //   445: invokevirtual 542	android/util/LongSparseArray:indexOfKey	(J)I
    //   448: iflt -43 -> 405
    //   451: aload_0
    //   452: getfield 136	com/tencent/mm/plugin/finder/storage/m:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   455: ldc 106
    //   457: ldc_w 335
    //   460: iconst_1
    //   461: anewarray 98	java/lang/String
    //   464: dup
    //   465: iconst_0
    //   466: lload 7
    //   468: invokestatic 252	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   471: aastore
    //   472: invokeinterface 258 4 0
    //   477: pop
    //   478: goto -73 -> 405
    //   481: getstatic 506	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   484: ifeq +18 -> 502
    //   487: ldc 200
    //   489: ldc_w 544
    //   492: aload_1
    //   493: invokestatic 400	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   496: invokevirtual 269	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   499: invokestatic 432	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: ldc 200
    //   504: new 202	java/lang/StringBuilder
    //   507: dup
    //   508: ldc_w 546
    //   511: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   514: aload_1
    //   515: invokeinterface 549 1 0
    //   520: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: ldc_w 551
    //   526: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokestatic 450	android/os/SystemClock:uptimeMillis	()J
    //   532: lload 5
    //   534: lsub
    //   535: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   538: ldc_w 553
    //   541: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokestatic 219	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   550: ldc_w 443
    //   553: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   556: return
    //   557: astore_1
    //   558: aconst_null
    //   559: astore 9
    //   561: goto -193 -> 368
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	564	0	this	m
    //   0	564	1	paramList	List<Long>
    //   48	196	2	i	int
    //   46	6	3	j	int
    //   64	169	4	k	int
    //   16	517	5	l1	long
    //   324	143	7	l2	long
    //   21	313	9	localObject1	Object
    //   356	86	9	localThrowable	java.lang.Throwable
    //   559	1	9	localObject2	Object
    //   41	375	10	localObject3	Object
    //   132	302	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   281	298	356	java/lang/Throwable
    //   298	326	356	java/lang/Throwable
    //   333	345	356	java/lang/Throwable
    //   345	353	356	java/lang/Throwable
    //   383	388	356	java/lang/Throwable
    //   358	367	367	finally
    //   281	298	557	finally
    //   298	326	557	finally
    //   333	345	557	finally
    //   345	353	557	finally
    //   383	388	557	finally
  }
  
  public final long l(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166969);
    p.k(paramFinderItem, "finderObj");
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    long l1 = ((f)localObject).aHp().a(ar.a.VxV, 1L);
    localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    ((f)localObject).aHp().set(ar.a.VxV, Long.valueOf(1L + l1));
    paramFinderItem.setLocalId(l1);
    localObject = paramFinderItem.convertTo();
    long l2 = this.db.insert("FinderFeedItem", "localId", (ContentValues)localObject);
    Log.i("Finder.FinderFeedStorage", "new feed rowId " + l2 + ' ' + g.bN(paramFinderItem.getFeedObject()) + " localID: " + l1);
    AppMethodBeat.o(166969);
    return l1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage$Companion;", "", "()V", "FINDER_SELECT_BEGIN", "", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.m
 * JD-Core Version:    0.7.0.1
 */