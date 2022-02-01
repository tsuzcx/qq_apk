package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "_db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CONDITION_POST", "", "FAIL_OR_WAITING", "TABLE", "getTABLE", "()Ljava/lang/String;", "db", "localFlagSet", "Ljava/util/ArrayList;", "", "clean", "", "sourceFlag", "deleteByGroupId", "", "objectIds", "", "", "deleteById", "objectId", "deleteByLocalId", "localId", "cleanPage", "drop", "getAllWaitingPostFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getById", "id", "getByLocalId", "getFailAndWaitingPostFeed", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "endTime", "getWaitingPostFeed", "insertNewFeed", "finderObj", "printAllItem", "tag", "testDB", "sql", "update", "svrId", "finder", "updateByLocal", "Companion", "plugin-finder_release"})
public final class i
  extends com.tencent.mm.sdk.e.j<cf>
{
  private static final String[] SQL_CREATE;
  public static final a sxU;
  public final String TABLE;
  public final com.tencent.mm.sdk.e.e db;
  public String sxR;
  private String sxS;
  private final ArrayList<Integer> sxT;
  
  static
  {
    AppMethodBeat.i(166976);
    sxU = new a((byte)0);
    FinderItem.a locala = FinderItem.syk;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(FinderItem.access$getInfo$cp(), "FinderFeedItem") };
    AppMethodBeat.o(166976);
  }
  
  public i(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, FinderItem.access$getInfo$cp(), "FinderFeedItem", cf.INDEX_CREATE);
    AppMethodBeat.i(166975);
    this.TABLE = "FinderFeedItem";
    this.db = parame;
    parame = ad.szt;
    parame = d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) });
    p.h(parame, "data");
    Object localObject2 = new ArrayList((Collection)parame);
    parame = new HashSet();
    localObject1 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject2).next();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = parame.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        p.g(localInteger, "i");
        localArrayList.add(Integer.valueOf(i | localInteger.intValue()));
      }
      parame.addAll((Collection)new HashSet((Collection)localArrayList));
      parame.add(localInteger);
    }
    parame.add(Integer.valueOf(0));
    ((ArrayList)localObject1).addAll((Collection)parame);
    this.sxT = ((ArrayList)localObject1);
    parame = new ArrayList();
    localObject1 = this.sxT.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (((((Integer)localObject2).intValue() & 0x1) != 0) && ((((Integer)localObject2).intValue() & 0x2) == 0)) {
        parame.add(localObject2);
      }
    }
    localObject1 = ad.szt;
    this.sxR = ad.a.i((List)parame, "localFlag");
    com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderFeedStorage", "CONDITION_POST " + this.sxR);
    parame.clear();
    localObject1 = this.sxT.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (((((Integer)localObject2).intValue() & 0x1) != 0) || ((((Integer)localObject2).intValue() & 0x2) != 0)) {
        parame.add(localObject2);
      }
    }
    localObject1 = ad.szt;
    this.sxS = ad.a.i((List)parame, "localFlag");
    com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderFeedStorage", "FAIL_OR_WAITING " + this.sxS);
    AppMethodBeat.o(166975);
  }
  
  public final boolean a(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(203659);
    p.h(paramFinderItem, "finder");
    if (paramLong == 0L) {
      com.tencent.mm.sdk.platformtools.ad.m("Finder.FinderFeedStorage", "update svrId " + paramLong + ' ' + paramFinderItem.info() + ' ' + bt.flS(), new Object[0]);
    }
    paramFinderItem = paramFinderItem.convertTo();
    paramFinderItem.remove("rowid");
    if (this.db.update("FinderFeedItem", paramFinderItem, "id=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(203659);
      return true;
    }
    AppMethodBeat.o(203659);
    return false;
  }
  
  /* Error */
  public final java.util.LinkedList<FinderItem> ad(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 304
    //   6: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ldc_w 305
    //   13: invokestatic 121	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   16: new 307	com/tencent/mm/ad/b
    //   19: dup
    //   20: ldc_w 308
    //   23: invokespecial 309	com/tencent/mm/ad/b:<init>	(Ljava/lang/String;)V
    //   26: astore_1
    //   27: new 217	java/lang/StringBuilder
    //   30: dup
    //   31: ldc_w 311
    //   34: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: iload_2
    //   38: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 316
    //   44: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: iload_3
    //   48: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: ldc_w 318
    //   54: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 5
    //   62: aload_0
    //   63: getfield 134	com/tencent/mm/plugin/finder/storage/i:db	Lcom/tencent/mm/sdk/e/e;
    //   66: aload 5
    //   68: aconst_null
    //   69: iconst_2
    //   70: invokeinterface 321 4 0
    //   75: astore 7
    //   77: ldc 215
    //   79: ldc_w 323
    //   82: aload_1
    //   83: invokestatic 326	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual 330	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 234	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: new 332	java/util/LinkedList
    //   95: dup
    //   96: invokespecial 333	java/util/LinkedList:<init>	()V
    //   99: astore 6
    //   101: aload 7
    //   103: checkcast 335	java/io/Closeable
    //   106: astore 5
    //   108: aload 7
    //   110: invokeinterface 340 1 0
    //   115: ifeq +45 -> 160
    //   118: new 91	com/tencent/mm/plugin/finder/storage/FinderItem
    //   121: dup
    //   122: invokespecial 341	com/tencent/mm/plugin/finder/storage/FinderItem:<init>	()V
    //   125: astore 8
    //   127: aload 7
    //   129: ldc_w 343
    //   132: invokestatic 189	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   135: aload 8
    //   137: aload 7
    //   139: invokevirtual 347	com/tencent/mm/plugin/finder/storage/FinderItem:convertFrom	(Landroid/database/Cursor;)V
    //   142: aload 6
    //   144: aload 8
    //   146: invokevirtual 348	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   149: pop
    //   150: aload 7
    //   152: invokeinterface 351 1 0
    //   157: ifne -39 -> 118
    //   160: getstatic 357	d/z:MKo	Ld/z;
    //   163: astore 7
    //   165: aload 5
    //   167: aconst_null
    //   168: invokestatic 362	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   171: ldc 215
    //   173: ldc_w 364
    //   176: aload_1
    //   177: invokestatic 326	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   180: invokevirtual 330	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokestatic 234	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: ldc_w 304
    //   189: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload 6
    //   194: areturn
    //   195: astore 4
    //   197: ldc_w 304
    //   200: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: aload 4
    //   205: athrow
    //   206: astore_1
    //   207: aload 5
    //   209: aload 4
    //   211: invokestatic 362	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   214: ldc_w 304
    //   217: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: goto -16 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	i
    //   0	226	1	paramString	String
    //   0	226	2	paramInt1	int
    //   0	226	3	paramInt2	int
    //   1	1	4	localObject1	Object
    //   195	15	4	localThrowable	java.lang.Throwable
    //   60	148	5	localObject2	Object
    //   99	94	6	localLinkedList	java.util.LinkedList
    //   75	89	7	localObject3	Object
    //   125	20	8	localFinderItem	FinderItem
    // Exception table:
    //   from	to	target	type
    //   108	118	195	java/lang/Throwable
    //   118	160	195	java/lang/Throwable
    //   160	165	195	java/lang/Throwable
    //   197	206	206	finally
    //   108	118	222	finally
    //   118	160	222	finally
    //   160	165	222	finally
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
  
  public final FinderItem cIs()
  {
    AppMethodBeat.i(166973);
    FinderItem localFinderItem = new FinderItem();
    String str = "SELECT *,localId FROM FinderFeedItem  WHERE " + this.sxR + " ORDER BY " + this.TABLE + ".localId ASC LIMIT 1";
    Cursor localCursor = this.db.a(str, null, 2);
    com.tencent.mm.sdk.platformtools.ad.d("Finder.FinderFeedStorage", "getWaitingPost ".concat(String.valueOf(str)));
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
  
  public final List<FinderItem> cIt()
  {
    AppMethodBeat.i(166974);
    Object localObject = new ArrayList();
    Cursor localCursor = this.db.a("SELECT *,localId FROM FinderFeedItem  WHERE localFlag IN (1, 2);", null, 2);
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
  public final void dI(List<Long> paramList)
  {
    // Byte code:
    //   0: ldc_w 399
    //   3: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 400
    //   10: invokestatic 121	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: invokestatic 406	android/os/SystemClock:uptimeMillis	()J
    //   16: lstore 5
    //   18: getstatic 412	com/tencent/mm/plugin/finder/storage/data/k:sAe	Lcom/tencent/mm/plugin/finder/storage/data/k$a;
    //   21: astore 9
    //   23: aload_1
    //   24: ldc_w 414
    //   27: invokestatic 121	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   30: aload_1
    //   31: checkcast 416	java/lang/Iterable
    //   34: invokestatic 420	d/a/j:k	(Ljava/lang/Iterable;)Ljava/util/HashSet;
    //   37: pop
    //   38: invokestatic 424	com/tencent/mm/plugin/finder/storage/data/k:cJi	()[Ljava/lang/Integer;
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
    //   58: checkcast 426	java/lang/Number
    //   61: invokevirtual 427	java/lang/Number:intValue	()I
    //   64: istore 4
    //   66: getstatic 412	com/tencent/mm/plugin/finder/storage/data/k:sAe	Lcom/tencent/mm/plugin/finder/storage/data/k$a;
    //   69: astore 9
    //   71: iload 4
    //   73: invokestatic 433	com/tencent/mm/plugin/finder/storage/data/k$a:Ft	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   76: pop
    //   77: invokestatic 437	com/tencent/mm/plugin/finder/storage/data/k:cJh	()Lcom/tencent/mm/plugin/finder/storage/data/m;
    //   80: iload 4
    //   82: invokevirtual 442	com/tencent/mm/plugin/finder/storage/data/m:Fv	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   85: getfield 448	com/tencent/mm/plugin/finder/storage/data/a:szD	Lcom/tencent/mm/protocal/protobuf/amw;
    //   88: getfield 453	com/tencent/mm/protocal/protobuf/amw:vHi	Ljava/util/LinkedList;
    //   91: astore 9
    //   93: aload 9
    //   95: ifnull +145 -> 240
    //   98: aload 9
    //   100: checkcast 204	java/util/List
    //   103: iconst_0
    //   104: invokestatic 457	d/a/j:E	(Ljava/util/List;I)Ljava/lang/Object;
    //   107: checkcast 459	com/tencent/mm/protocal/protobuf/and
    //   110: astore 9
    //   112: aload 9
    //   114: ifnull +126 -> 240
    //   117: aload 9
    //   119: getfield 462	com/tencent/mm/protocal/protobuf/and:fVg	Ljava/util/LinkedList;
    //   122: astore 9
    //   124: aload 9
    //   126: ifnull +114 -> 240
    //   129: getstatic 468	com/tencent/mm/plugin/finder/storage/data/h:szU	Lcom/tencent/mm/plugin/finder/storage/data/h;
    //   132: astore 11
    //   134: aload_1
    //   135: aload 9
    //   137: invokestatic 471	com/tencent/mm/plugin/finder/storage/data/h:a	(Ljava/util/List;Ljava/util/LinkedList;)Z
    //   140: ifeq +100 -> 240
    //   143: getstatic 477	com/tencent/mm/sdk/platformtools/i:DEBUG	Z
    //   146: ifeq +78 -> 224
    //   149: new 217	java/lang/StringBuilder
    //   152: dup
    //   153: ldc_w 479
    //   156: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: astore 11
    //   161: invokestatic 437	com/tencent/mm/plugin/finder/storage/data/k:cJh	()Lcom/tencent/mm/plugin/finder/storage/data/m;
    //   164: iload 4
    //   166: invokevirtual 442	com/tencent/mm/plugin/finder/storage/data/m:Fv	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   169: getfield 448	com/tencent/mm/plugin/finder/storage/data/a:szD	Lcom/tencent/mm/protocal/protobuf/amw;
    //   172: getfield 453	com/tencent/mm/protocal/protobuf/amw:vHi	Ljava/util/LinkedList;
    //   175: astore 9
    //   177: aload 9
    //   179: ifnull +68 -> 247
    //   182: aload 9
    //   184: checkcast 204	java/util/List
    //   187: iconst_0
    //   188: invokestatic 457	d/a/j:E	(Ljava/util/List;I)Ljava/lang/Object;
    //   191: checkcast 459	com/tencent/mm/protocal/protobuf/and
    //   194: astore 9
    //   196: aload 9
    //   198: ifnull +49 -> 247
    //   201: aload 9
    //   203: getfield 462	com/tencent/mm/protocal/protobuf/and:fVg	Ljava/util/LinkedList;
    //   206: astore 9
    //   208: ldc_w 481
    //   211: aload 11
    //   213: aload 9
    //   215: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 234	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: getstatic 412	com/tencent/mm/plugin/finder/storage/data/k:sAe	Lcom/tencent/mm/plugin/finder/storage/data/k$a;
    //   227: astore 9
    //   229: invokestatic 437	com/tencent/mm/plugin/finder/storage/data/k:cJh	()Lcom/tencent/mm/plugin/finder/storage/data/m;
    //   232: iload 4
    //   234: invokevirtual 442	com/tencent/mm/plugin/finder/storage/data/m:Fv	(I)Lcom/tencent/mm/plugin/finder/storage/data/a;
    //   237: invokestatic 484	com/tencent/mm/plugin/finder/storage/data/k$a:a	(Lcom/tencent/mm/plugin/finder/storage/data/a;)V
    //   240: iload_2
    //   241: iconst_1
    //   242: iadd
    //   243: istore_2
    //   244: goto -195 -> 49
    //   247: aconst_null
    //   248: astore 9
    //   250: goto -42 -> 208
    //   253: new 486	android/util/LongSparseArray
    //   256: dup
    //   257: invokespecial 487	android/util/LongSparseArray:<init>	()V
    //   260: astore 9
    //   262: aload_0
    //   263: getfield 134	com/tencent/mm/plugin/finder/storage/i:db	Lcom/tencent/mm/sdk/e/e;
    //   266: ldc_w 489
    //   269: aconst_null
    //   270: iconst_2
    //   271: invokeinterface 321 4 0
    //   276: checkcast 335	java/io/Closeable
    //   279: astore 10
    //   281: aload 10
    //   283: checkcast 337	android/database/Cursor
    //   286: astore 11
    //   288: aload 11
    //   290: invokeinterface 340 1 0
    //   295: ifeq +73 -> 368
    //   298: aload 11
    //   300: ldc_w 390
    //   303: invokestatic 189	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   306: aload 11
    //   308: invokeinterface 492 1 0
    //   313: ifne +55 -> 368
    //   316: aload 11
    //   318: iconst_0
    //   319: invokeinterface 496 2 0
    //   324: lstore 7
    //   326: aload 9
    //   328: lload 7
    //   330: lload 7
    //   332: invokestatic 501	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   335: invokevirtual 505	android/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   338: goto -40 -> 298
    //   341: astore 9
    //   343: ldc_w 399
    //   346: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   349: aload 9
    //   351: athrow
    //   352: astore_1
    //   353: aload 10
    //   355: aload 9
    //   357: invokestatic 362	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   360: ldc_w 399
    //   363: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: aload_1
    //   367: athrow
    //   368: getstatic 357	d/z:MKo	Ld/z;
    //   371: astore 11
    //   373: aload 10
    //   375: aconst_null
    //   376: invokestatic 362	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   379: aload_1
    //   380: checkcast 416	java/lang/Iterable
    //   383: invokeinterface 506 1 0
    //   388: astore 10
    //   390: aload 10
    //   392: invokeinterface 176 1 0
    //   397: ifeq +69 -> 466
    //   400: aload 10
    //   402: invokeinterface 180 1 0
    //   407: checkcast 426	java/lang/Number
    //   410: invokevirtual 509	java/lang/Number:longValue	()J
    //   413: lstore 7
    //   415: getstatic 515	com/tencent/mm/plugin/finder/storage/data/d:szI	Lcom/tencent/mm/plugin/finder/storage/data/d$a;
    //   418: astore 11
    //   420: lload 7
    //   422: invokestatic 521	com/tencent/mm/plugin/finder/storage/data/d$a:tB	(J)Z
    //   425: pop
    //   426: aload 9
    //   428: lload 7
    //   430: invokevirtual 525	android/util/LongSparseArray:indexOfKey	(J)I
    //   433: iflt -43 -> 390
    //   436: aload_0
    //   437: getfield 134	com/tencent/mm/plugin/finder/storage/i:db	Lcom/tencent/mm/sdk/e/e;
    //   440: ldc 103
    //   442: ldc_w 291
    //   445: iconst_1
    //   446: anewarray 97	java/lang/String
    //   449: dup
    //   450: iconst_0
    //   451: lload 7
    //   453: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   456: aastore
    //   457: invokeinterface 529 4 0
    //   462: pop
    //   463: goto -73 -> 390
    //   466: getstatic 477	com/tencent/mm/sdk/platformtools/i:DEBUG	Z
    //   469: ifeq +18 -> 487
    //   472: ldc 215
    //   474: ldc_w 531
    //   477: aload_1
    //   478: invokestatic 326	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   481: invokevirtual 330	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   484: invokestatic 385	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: ldc 215
    //   489: new 217	java/lang/StringBuilder
    //   492: dup
    //   493: ldc_w 533
    //   496: invokespecial 222	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   499: aload_1
    //   500: invokeinterface 536 1 0
    //   505: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   508: ldc_w 538
    //   511: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokestatic 406	android/os/SystemClock:uptimeMillis	()J
    //   517: lload 5
    //   519: lsub
    //   520: invokevirtual 257	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   523: ldc_w 540
    //   526: invokevirtual 226	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 234	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: ldc_w 399
    //   538: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   541: return
    //   542: astore_1
    //   543: aconst_null
    //   544: astore 9
    //   546: goto -193 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	549	0	this	i
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
  
  public final long e(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166969);
    p.h(paramFinderItem, "finderObj");
    Object localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    long l1 = ((com.tencent.mm.kernel.e)localObject).ajl().a(al.a.IGu, 1L);
    localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IGu, Long.valueOf(1L + l1));
    paramFinderItem.setLocalId(l1);
    localObject = paramFinderItem.convertTo();
    long l2 = this.db.insert("FinderFeedItem", "localId", (ContentValues)localObject);
    com.tencent.mm.sdk.platformtools.ad.i("Finder.FinderFeedStorage", "new feed rowId " + l2 + ' ' + f.bF(paramFinderItem.getFeedObject()) + " localID: " + l1);
    AppMethodBeat.o(166969);
    return l1;
  }
  
  public final boolean u(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(166971);
    if (paramBoolean)
    {
      k.a locala = k.sAe;
      k.a.xe(paramLong);
    }
    if (this.db.delete("FinderFeedItem", "localId=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(166971);
      return true;
    }
    AppMethodBeat.o(166971);
    return false;
  }
  
  public final FinderItem wP(long paramLong)
  {
    FinderItem localFinderItem = null;
    AppMethodBeat.i(166966);
    Object localObject = "SELECT *,localId FROM FinderFeedItem  WHERE FinderFeedItem.localId=".concat(String.valueOf(paramLong));
    localObject = this.db.a((String)localObject, null, 2);
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
  
  public final boolean wQ(long paramLong)
  {
    AppMethodBeat.i(166970);
    Object localObject = d.szI;
    boolean bool = d.a.tB(paramLong);
    localObject = k.sAe;
    localObject = k.cJi();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      int k = ((Number)localObject[i]).intValue();
      k.a locala = k.sAe;
      k.a.M(paramLong, k);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage$Companion;", "", "()V", "FINDER_SELECT_BEGIN", "", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.i
 * JD-Core Version:    0.7.0.1
 */