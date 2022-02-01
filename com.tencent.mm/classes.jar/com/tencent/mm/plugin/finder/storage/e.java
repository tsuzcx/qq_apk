package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.g.c.cb;
import com.tencent.mm.plugin.finder.storage.data.b.a;
import com.tencent.mm.plugin.finder.storage.data.f.a;
import com.tencent.mm.plugin.finder.storage.data.f.a.d;
import com.tencent.mm.protocal.protobuf.aim;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.g.b.k;
import d.g.b.v.a;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseFinderFeedItem;", "_db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "CONDITION_POST", "", "FAIL_OR_WAITING", "TABLE", "getTABLE", "()Ljava/lang/String;", "db", "localFlagSet", "Ljava/util/ArrayList;", "", "clean", "", "sourceFlag", "deleteByGroupId", "", "objectIds", "", "", "deleteById", "objectId", "deleteByLocalId", "localId", "cleanPage", "drop", "getById", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "id", "getByLocalId", "getFailAndWaitingPostFeed", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "endTime", "getWaitingPostFeed", "insertNewFeed", "finderObj", "printAllItem", "tag", "testDB", "sql", "update", "svrId", "finder", "updateByLocal", "Companion", "plugin-finder_release"})
public final class e
  extends com.tencent.mm.sdk.e.j<cb>
{
  private static final String[] SQL_CREATE;
  public static final a qJO;
  private final String TABLE;
  public final com.tencent.mm.sdk.e.e db;
  private String qJL;
  private String qJM;
  private final ArrayList<Integer> qJN;
  
  static
  {
    AppMethodBeat.i(166976);
    qJO = new a((byte)0);
    FinderItem.a locala = FinderItem.qJU;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(FinderItem.access$getInfo$cp(), "FinderFeedItem") };
    AppMethodBeat.o(166976);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, FinderItem.access$getInfo$cp(), "FinderFeedItem", null);
    AppMethodBeat.i(166975);
    this.TABLE = "FinderFeedItem";
    this.db = parame;
    parame = m.qKj;
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
    this.qJN = ((ArrayList)localObject1);
    parame = new ArrayList();
    localObject1 = this.qJN.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (((((Integer)localObject2).intValue() & 0x1) != 0) && ((((Integer)localObject2).intValue() & 0x2) == 0)) {
        parame.add(localObject2);
      }
    }
    localObject1 = m.qKj;
    this.qJL = m.a.j((List)parame, "localFlag");
    ad.i("Finder.FinderFeedStorage", "CONDITION_POST " + this.qJL);
    parame.clear();
    localObject1 = this.qJN.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      if (((((Integer)localObject2).intValue() & 0x1) != 0) || ((((Integer)localObject2).intValue() & 0x2) != 0)) {
        parame.add(localObject2);
      }
    }
    localObject1 = m.qKj;
    this.qJM = m.a.j((List)parame, "localFlag");
    ad.i("Finder.FinderFeedStorage", "FAIL_OR_WAITING " + this.qJM);
    AppMethodBeat.o(166975);
  }
  
  /* Error */
  public final LinkedList<FinderItem> Zw(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 249
    //   4: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 250
    //   10: invokestatic 120	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 252	com/tencent/mm/ad/b
    //   16: dup
    //   17: ldc 253
    //   19: invokespecial 254	com/tencent/mm/ad/b:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: new 212	java/lang/StringBuilder
    //   26: dup
    //   27: ldc_w 256
    //   30: invokespecial 217	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_3
    //   37: aload_0
    //   38: getfield 128	com/tencent/mm/plugin/finder/storage/e:db	Lcom/tencent/mm/sdk/e/e;
    //   41: aload_3
    //   42: aconst_null
    //   43: iconst_2
    //   44: invokeinterface 261 4 0
    //   49: astore 5
    //   51: ldc 210
    //   53: ldc_w 263
    //   56: aload_1
    //   57: invokestatic 266	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   60: invokevirtual 270	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokestatic 229	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: new 272	java/util/LinkedList
    //   69: dup
    //   70: invokespecial 273	java/util/LinkedList:<init>	()V
    //   73: astore 4
    //   75: aload 5
    //   77: checkcast 275	java/io/Closeable
    //   80: astore_3
    //   81: aload 5
    //   83: invokeinterface 280 1 0
    //   88: ifeq +45 -> 133
    //   91: new 90	com/tencent/mm/plugin/finder/storage/FinderItem
    //   94: dup
    //   95: invokespecial 281	com/tencent/mm/plugin/finder/storage/FinderItem:<init>	()V
    //   98: astore 6
    //   100: aload 5
    //   102: ldc_w 283
    //   105: invokestatic 183	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   108: aload 6
    //   110: aload 5
    //   112: invokevirtual 287	com/tencent/mm/plugin/finder/storage/FinderItem:convertFrom	(Landroid/database/Cursor;)V
    //   115: aload 4
    //   117: aload 6
    //   119: invokevirtual 288	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   122: pop
    //   123: aload 5
    //   125: invokeinterface 291 1 0
    //   130: ifne -39 -> 91
    //   133: getstatic 297	d/y:JfV	Ld/y;
    //   136: astore 5
    //   138: aload_3
    //   139: aconst_null
    //   140: invokestatic 302	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   143: ldc 210
    //   145: ldc_w 304
    //   148: aload_1
    //   149: invokestatic 266	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   152: invokevirtual 270	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokestatic 229	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: ldc 249
    //   160: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: aload 4
    //   165: areturn
    //   166: astore_2
    //   167: ldc 249
    //   169: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_2
    //   173: athrow
    //   174: astore_1
    //   175: aload_3
    //   176: aload_2
    //   177: invokestatic 302	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   180: ldc 249
    //   182: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   185: aload_1
    //   186: athrow
    //   187: astore_1
    //   188: goto -13 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	e
    //   0	191	1	paramString	String
    //   1	1	2	localObject1	Object
    //   166	11	2	localThrowable	java.lang.Throwable
    //   36	140	3	localObject2	Object
    //   73	91	4	localLinkedList	LinkedList
    //   49	88	5	localObject3	Object
    //   98	20	6	localFinderItem	FinderItem
    // Exception table:
    //   from	to	target	type
    //   81	91	166	java/lang/Throwable
    //   91	133	166	java/lang/Throwable
    //   133	138	166	java/lang/Throwable
    //   167	174	174	finally
    //   81	91	187	finally
    //   91	133	187	finally
    //   133	138	187	finally
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
  
  public final FinderItem cqn()
  {
    AppMethodBeat.i(166973);
    FinderItem localFinderItem = new FinderItem();
    String str = "SELECT *,localId FROM FinderFeedItem  WHERE " + this.qJL + " ORDER BY " + this.TABLE + ".localId ASC LIMIT 1";
    Cursor localCursor = this.db.a(str, null, 2);
    ad.d("Finder.FinderFeedStorage", "getWaitingPost ".concat(String.valueOf(str)));
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
  
  public final List<FinderItem> cqo()
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
  
  public final long d(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(166969);
    k.h(paramFinderItem, "finderObj");
    Object localObject = com.tencent.mm.kernel.g.afB();
    k.g(localObject, "MMKernel.storage()");
    long l1 = ((com.tencent.mm.kernel.e)localObject).afk().a(ae.a.FvU, 1L);
    localObject = com.tencent.mm.kernel.g.afB();
    k.g(localObject, "MMKernel.storage()");
    ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.FvU, Long.valueOf(1L + l1));
    paramFinderItem.setLocalId(l1);
    localObject = paramFinderItem.convertTo();
    long l2 = this.db.insert("FinderFeedItem", "localId", (ContentValues)localObject);
    ad.i("Finder.FinderFeedStorage", "new feed rowId " + l2 + ' ' + com.tencent.mm.ad.f.bG(paramFinderItem.getFeedObject()) + " localID: " + l1);
    AppMethodBeat.o(166969);
    return l1;
  }
  
  public final FinderItem qy(long paramLong)
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
  
  public final boolean qz(long paramLong)
  {
    AppMethodBeat.i(166970);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.data.b.qKl;
    boolean bool = b.a.nQ(paramLong);
    localObject1 = com.tencent.mm.plugin.finder.storage.data.f.qKv;
    localObject1 = com.tencent.mm.plugin.finder.storage.data.f.cqI();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      int k = ((Number)localObject1[i]).intValue();
      Object localObject2 = com.tencent.mm.plugin.finder.storage.data.f.qKv;
      f.a.ahz(k);
      localObject2 = new v.a();
      ((v.a)localObject2).Jhs = false;
      Object localObject3 = com.tencent.mm.plugin.finder.storage.data.f.fVf().ahA(k).KXo.tvP;
      if (localObject3 != null)
      {
        localObject3 = (ais)d.a.j.C((List)localObject3, 0);
        if (localObject3 != null)
        {
          localObject3 = ((ais)localObject3).fyl;
          if (localObject3 != null) {
            c.a((LinkedList)localObject3, (d.g.a.b)new f.a.d((v.a)localObject2, paramLong));
          }
        }
      }
      if (((v.a)localObject2).Jhs)
      {
        localObject2 = com.tencent.mm.plugin.finder.storage.data.f.qKv;
        f.a.a(com.tencent.mm.plugin.finder.storage.data.f.fVf().ahA(k));
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
  
  public final boolean u(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(166971);
    if (paramBoolean)
    {
      f.a locala = com.tencent.mm.plugin.finder.storage.data.f.qKv;
      f.a.qE(paramLong);
    }
    if (this.db.delete("FinderFeedItem", "localId=?", new String[] { String.valueOf(paramLong) }) > 0)
    {
      AppMethodBeat.o(166971);
      return true;
    }
    AppMethodBeat.o(166971);
    return false;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/FinderFeedStorage$Companion;", "", "()V", "FINDER_SELECT_BEGIN", "", "SQL_CREATE", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.e
 * JD-Core Version:    0.7.0.1
 */