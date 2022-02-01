package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.storage.data.a;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.storage.data.i.a;
import com.tencent.mm.plugin.finder.storage.data.i.a.c;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.a.b;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "_db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CONDITION_POST", "", "FAIL_OR_WAITING", "TABLE", "getTABLE", "()Ljava/lang/String;", "db", "localFlagSet", "Ljava/util/ArrayList;", "", "clean", "", "sourceFlag", "deleteByGroupId", "", "objectIds", "", "", "deleteById", "objectId", "deleteByLocalId", "localId", "cleanPage", "drop", "getById", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "id", "getByLocalId", "getFailAndWaitingPostFeed", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "endTime", "getWaitingPostFeed", "insertNewFeed", "finderObj", "printAllItem", "tag", "testDB", "sql", "update", "svrId", "finder", "updateByLocal", "Companion", "plugin-finder_release"})
public final class f
  extends com.tencent.mm.sdk.e.j<cd>
{
  private static final String[] SQL_CREATE;
  public static final f.a rDl;
  private final String TABLE;
  public final com.tencent.mm.sdk.e.e db;
  private String rDi;
  private String rDj;
  private final ArrayList<Integer> rDk;
  
  static
  {
    AppMethodBeat.i(166976);
    rDl = new f.a((byte)0);
    FinderItem.a locala = FinderItem.rDA;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(FinderItem.access$getInfo$cp(), "FinderFeedItem") };
    AppMethodBeat.o(166976);
  }
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, FinderItem.access$getInfo$cp(), "FinderFeedItem", null);
    AppMethodBeat.i(166975);
    this.TABLE = "FinderFeedItem";
    this.db = parame;
    parame = v.rEz;
    parame = d.a.j.listOf(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) });
    k.h(parame, "data");
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
        k.g(localInteger, "i");
        localArrayList.add(Integer.valueOf(i | localInteger.intValue()));
      }
      parame.addAll((Collection)new HashSet((Collection)localArrayList));
      parame.add(localInteger);
    }
    parame.add(Integer.valueOf(0));
    ((ArrayList)localObject1).addAll((Collection)parame);
    this.rDk = ((ArrayList)localObject1);
    parame = new ArrayList();
    localObject1 = this.rDk.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (((((Integer)localObject2).intValue() & 0x1) != 0) && ((((Integer)localObject2).intValue() & 0x2) == 0)) {
        parame.add(localObject2);
      }
    }
    localObject1 = v.rEz;
    this.rDi = v.a.j((List)parame, "localFlag");
    ac.i("Finder.FinderFeedStorage", "CONDITION_POST " + this.rDi);
    parame.clear();
    localObject1 = this.rDk.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (((((Integer)localObject2).intValue() & 0x1) != 0) || ((((Integer)localObject2).intValue() & 0x2) != 0)) {
        parame.add(localObject2);
      }
    }
    localObject1 = v.rEz;
    this.rDj = v.a.j((List)parame, "localFlag");
    ac.i("Finder.FinderFeedStorage", "FAIL_OR_WAITING " + this.rDj);
    AppMethodBeat.o(166975);
  }
  
  public final boolean a(long paramLong, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166968);
    k.h(paramFinderItem, "finderObj");
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
  
  /* Error */
  public final LinkedList<FinderItem> aee(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 273
    //   5: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 274
    //   12: invokestatic 119	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: new 276	com/tencent/mm/ac/b
    //   18: dup
    //   19: ldc_w 277
    //   22: invokespecial 278	com/tencent/mm/ac/b:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: new 211	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 280
    //   33: invokespecial 216	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore_3
    //   40: aload_0
    //   41: getfield 127	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/e/e;
    //   44: aload_3
    //   45: aconst_null
    //   46: iconst_2
    //   47: invokeinterface 283 4 0
    //   52: astore 5
    //   54: ldc 209
    //   56: ldc_w 285
    //   59: aload_1
    //   60: invokestatic 288	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   63: invokevirtual 292	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   66: invokestatic 228	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: new 294	java/util/LinkedList
    //   72: dup
    //   73: invokespecial 295	java/util/LinkedList:<init>	()V
    //   76: astore 4
    //   78: aload 5
    //   80: checkcast 297	java/io/Closeable
    //   83: astore_3
    //   84: aload 5
    //   86: invokeinterface 302 1 0
    //   91: ifeq +45 -> 136
    //   94: new 89	com/tencent/mm/plugin/finder/storage/FinderItem
    //   97: dup
    //   98: invokespecial 303	com/tencent/mm/plugin/finder/storage/FinderItem:<init>	()V
    //   101: astore 6
    //   103: aload 5
    //   105: ldc_w 305
    //   108: invokestatic 182	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   111: aload 6
    //   113: aload 5
    //   115: invokevirtual 309	com/tencent/mm/plugin/finder/storage/FinderItem:convertFrom	(Landroid/database/Cursor;)V
    //   118: aload 4
    //   120: aload 6
    //   122: invokevirtual 310	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   125: pop
    //   126: aload 5
    //   128: invokeinterface 313 1 0
    //   133: ifne -39 -> 94
    //   136: getstatic 319	d/y:KTp	Ld/y;
    //   139: astore 5
    //   141: aload_3
    //   142: aconst_null
    //   143: invokestatic 324	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   146: ldc 209
    //   148: ldc_w 326
    //   151: aload_1
    //   152: invokestatic 288	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   155: invokevirtual 292	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   158: invokestatic 228	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: ldc_w 273
    //   164: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload 4
    //   169: areturn
    //   170: astore_2
    //   171: ldc_w 273
    //   174: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_2
    //   178: athrow
    //   179: astore_1
    //   180: aload_3
    //   181: aload_2
    //   182: invokestatic 324	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   185: ldc_w 273
    //   188: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_1
    //   192: athrow
    //   193: astore_1
    //   194: goto -14 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	f
    //   0	197	1	paramString	String
    //   1	1	2	localObject1	Object
    //   170	12	2	localThrowable	java.lang.Throwable
    //   39	142	3	localObject2	Object
    //   76	92	4	localLinkedList	LinkedList
    //   52	88	5	localObject3	Object
    //   101	20	6	localFinderItem	FinderItem
    // Exception table:
    //   from	to	target	type
    //   84	94	170	java/lang/Throwable
    //   94	136	170	java/lang/Throwable
    //   136	141	170	java/lang/Throwable
    //   171	179	179	finally
    //   84	94	193	finally
    //   94	136	193	finally
    //   136	141	193	finally
  }
  
  public final FinderItem cAx()
  {
    AppMethodBeat.i(166973);
    FinderItem localFinderItem = new FinderItem();
    String str = "SELECT *,localId FROM FinderFeedItem  WHERE " + this.rDi + " ORDER BY " + this.TABLE + ".localId ASC LIMIT 1";
    Cursor localCursor = this.db.a(str, null, 2);
    ac.d("Finder.FinderFeedStorage", "getWaitingPost ".concat(String.valueOf(str)));
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(166973);
      return null;
    }
    k.g(localCursor, "cr");
    localFinderItem.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(166973);
    return localFinderItem;
  }
  
  public final List<FinderItem> cAy()
  {
    AppMethodBeat.i(166974);
    Object localObject = new ArrayList();
    Cursor localCursor = this.db.a("SELECT *,localId FROM FinderFeedItem  WHERE localFlag IN (1, 2);", null, 2);
    while (localCursor.moveToNext())
    {
      FinderItem localFinderItem = new FinderItem();
      k.g(localCursor, "cr");
      localFinderItem.convertFrom(localCursor);
      ((ArrayList)localObject).add(localFinderItem);
    }
    localCursor.close();
    localObject = (List)localObject;
    AppMethodBeat.o(166974);
    return localObject;
  }
  
  public final long e(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166969);
    k.h(paramFinderItem, "finderObj");
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    long l1 = ((com.tencent.mm.kernel.e)localObject).agA().a(ah.a.GTO, 1L);
    localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GTO, Long.valueOf(1L + l1));
    paramFinderItem.setLocalId(l1);
    localObject = paramFinderItem.convertTo();
    long l2 = this.db.insert("FinderFeedItem", "localId", (ContentValues)localObject);
    ac.i("Finder.FinderFeedStorage", "new feed rowId " + l2 + ' ' + com.tencent.mm.ac.f.bD(paramFinderItem.getFeedObject()) + " localID: " + l1);
    AppMethodBeat.o(166969);
    return l1;
  }
  
  public final boolean u(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(166971);
    if (paramBoolean)
    {
      i.a locala = i.rEV;
      i.a.vc(paramLong);
    }
    if (this.db.delete("FinderFeedItem", "localId=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(166971);
      return true;
    }
    AppMethodBeat.o(166971);
    return false;
  }
  
  public final FinderItem uO(long paramLong)
  {
    FinderItem localFinderItem = null;
    AppMethodBeat.i(166966);
    Object localObject = "SELECT *,localId FROM FinderFeedItem  WHERE FinderFeedItem.localId=".concat(String.valueOf(paramLong));
    localObject = this.db.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst())
    {
      localFinderItem = new FinderItem();
      k.g(localObject, "cu");
      localFinderItem.convertFrom((Cursor)localObject);
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(166966);
    return localFinderItem;
  }
  
  public final boolean uP(long paramLong)
  {
    AppMethodBeat.i(166970);
    Object localObject1 = d.rEF;
    boolean bool = d.a.rC(paramLong);
    localObject1 = i.rEV;
    localObject1 = i.cBi();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      int k = ((Number)localObject1[i]).intValue();
      Object localObject2 = i.rEV;
      i.a.Ek(k);
      localObject2 = new d.g.b.v.a();
      ((d.g.b.v.a)localObject2).KUL = false;
      Object localObject3 = i.cBh().Em(k).rEA.uEi;
      if (localObject3 != null)
      {
        localObject3 = (ake)d.a.j.C((List)localObject3, 0);
        if (localObject3 != null)
        {
          localObject3 = ((ake)localObject3).fBS;
          if (localObject3 != null) {
            c.a((LinkedList)localObject3, (b)new i.a.c((d.g.b.v.a)localObject2, paramLong));
          }
        }
      }
      if (((d.g.b.v.a)localObject2).KUL)
      {
        localObject2 = i.rEV;
        i.a.a(i.cBh().Em(k));
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.f
 * JD-Core Version:    0.7.0.1
 */