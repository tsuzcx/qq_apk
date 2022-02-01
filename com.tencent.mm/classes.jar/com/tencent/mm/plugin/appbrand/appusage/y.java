package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class y
  extends k
{
  public static final String[] hEf;
  private final y.b jPA;
  public final c jPB;
  public final h jPq;
  
  static
  {
    AppMethodBeat.i(44627);
    hEf = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(y.a.hEe, "AppBrandLauncherLayoutItem") };
    AppMethodBeat.o(44627);
  }
  
  public y(h paramh)
  {
    AppMethodBeat.i(44609);
    this.jPB = new c((byte)0);
    this.jPq = paramh;
    this.jPA = new y.b(paramh);
    AppMethodBeat.o(44609);
  }
  
  private static int H(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44625);
    paramInt1 = String.format(Locale.US, "%s|%d|%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }).hashCode();
    AppMethodBeat.o(44625);
    return paramInt1;
  }
  
  private boolean a(y.a parama)
  {
    AppMethodBeat.i(44624);
    if (bt.isNullOrNil(parama.field_brandId))
    {
      AppMethodBeat.o(44624);
      return false;
    }
    long l = this.jPq.a("AppBrandLauncherLayoutItem", "", parama.convertTo());
    if ((l > 0L) || (l == parama.field_recordId))
    {
      AppMethodBeat.o(44624);
      return true;
    }
    AppMethodBeat.o(44624);
    return false;
  }
  
  private boolean a(String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(44617);
    if ((bt.isNullOrNil(paramString1)) || (999 == paramInt1))
    {
      AppMethodBeat.o(44617);
      return false;
    }
    Object localObject = String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[] { "updateTime", "AppBrandLauncherLayoutItem", "scene" });
    localObject = this.jPq.a((String)localObject, new String[] { "2" }, 0);
    long l;
    int i;
    label191:
    boolean bool2;
    boolean bool1;
    if (localObject == null)
    {
      l = 0L;
      l = Math.max(l + 1L, bt.aQJ());
      int j = H(paramString1, paramInt1, 2);
      localObject = new ContentValues(1);
      ((ContentValues)localObject).put("updateTime", Long.valueOf(l));
      ((ContentValues)localObject).put("usedInThirdPartyAppRecently", Boolean.FALSE);
      ((ContentValues)localObject).put("thirdPartyAppUsingDesc", "");
      if (this.jPq.update("AppBrandLauncherLayoutItem", (ContentValues)localObject, String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(j) }) <= 0) {
        break label445;
      }
      i = 1;
      if (i != 0) {
        doNotify("single", 3, String.valueOf(j));
      }
      if (i != 0) {
        break label451;
      }
      localObject = new y.a();
      ((y.a)localObject).field_updateTime = l;
      ((y.a)localObject).field_scene = 2;
      ((y.a)localObject).field_brandId = paramString1;
      ((y.a)localObject).field_versionType = paramInt1;
      bool2 = a((y.a)localObject);
      if (bool2) {
        doNotify("single", 2, String.valueOf(j));
      }
      bool1 = bool2;
      label276:
      if ((bool2) && (paramBoolean1))
      {
        localObject = ((b)com.tencent.mm.plugin.appbrand.app.j.T(b.class)).F(paramString1, 3, paramInt2);
        if (!((Boolean)((Pair)localObject).first).booleanValue()) {
          break label460;
        }
        ad.i("MicroMsg.AppBrandUsageStorage", "addRecord, addOk TRUE, cgi blocked by username(%s), scene(%d)", new Object[] { paramString1, Integer.valueOf(paramInt2) });
        paramString2 = a.jKA;
        a.A(((Integer)((Pair)localObject).second).intValue(), 165L);
      }
    }
    for (;;)
    {
      if (bool2) {
        ab.aI(paramString1, paramInt1);
      }
      if (bool1) {
        bcw();
      }
      if (bool2) {
        ((n)com.tencent.mm.plugin.appbrand.app.j.T(n.class)).a(paramString1, paramInt1, n.a.jOK);
      }
      AppMethodBeat.o(44617);
      return bool2;
      l = 0L;
      if (((Cursor)localObject).moveToFirst()) {
        l = ((Cursor)localObject).getLong(0);
      }
      ((Cursor)localObject).close();
      break;
      label445:
      i = 0;
      break label191;
      label451:
      bool2 = true;
      bool1 = false;
      break label276;
      label460:
      new ac(paramInt2, paramBoolean2, paramInt1, 1, paramString1, paramInt3, paramString2).aED();
    }
  }
  
  private void bcw()
  {
    AppMethodBeat.i(44618);
    Object localObject1 = this.jPq.a(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[] { "AppBrandLauncherLayoutItem", "scene" }), new String[] { "2" }, 0);
    int i;
    if (localObject1 == null) {
      i = 0;
    }
    while (i > 10000)
    {
      Object localObject2 = a(new String[] { "recordId", "brandId", "versionType" }, 2147483647, 10000);
      if (localObject2 == null)
      {
        AppMethodBeat.o(44618);
        return;
        i = 0;
        if (((Cursor)localObject1).moveToFirst()) {
          i = ((Cursor)localObject1).getInt(0);
        }
        ((Cursor)localObject1).close();
      }
      else
      {
        localObject1 = new LinkedList();
        ArrayList localArrayList1 = new ArrayList(i - 10000);
        ArrayList localArrayList2 = new ArrayList(i - 10000);
        if (((Cursor)localObject2).moveToFirst()) {
          do
          {
            ((List)localObject1).add(String.valueOf(((Cursor)localObject2).getInt(0)));
            localArrayList1.add(((Cursor)localObject2).getString(1));
            localArrayList2.add(Integer.valueOf(((Cursor)localObject2).getInt(2)));
          } while (((Cursor)localObject2).moveToNext());
        }
        ((Cursor)localObject2).close();
        if (bt.hj((List)localObject1))
        {
          AppMethodBeat.o(44618);
          return;
        }
        long l = this.jPq.xO(Thread.currentThread().getId());
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.jPq.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { localObject3 });
        }
        this.jPq.sJ(l);
        localObject2 = new ArrayList(localArrayList1.size());
        Object localObject3 = new ArrayList(localArrayList1.size());
        i = 0;
        while (i < localArrayList1.size())
        {
          String str = v.NE((String)localArrayList1.get(i));
          if (!bt.isNullOrNil(str))
          {
            ((List)localObject2).add(str);
            ((List)localObject3).add(localArrayList2.get(i));
          }
          i += 1;
        }
        if (com.tencent.mm.plugin.appbrand.app.j.aYX() != null) {
          com.tencent.mm.plugin.appbrand.app.j.aYX().e((List)localObject2, (List)localObject3);
        }
        doNotify("batch", 5, localObject1);
      }
    }
    AppMethodBeat.o(44618);
  }
  
  private boolean bf(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44619);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44619);
      return false;
    }
    if (this.jPq.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(H(paramString, paramInt, 2)) }) > 0) {}
    for (;;)
    {
      if (bool) {
        ((n)com.tencent.mm.plugin.appbrand.app.j.T(n.class)).b(paramString, paramInt, n.a.jOK);
      }
      AppMethodBeat.o(44619);
      return bool;
      bool = false;
    }
  }
  
  /* Error */
  public static ArrayList<AppBrandRecentTaskInfo> d(Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc_w 405
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +19 -> 26
    //   10: new 316	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 406	java/util/ArrayList:<init>	()V
    //   17: astore_0
    //   18: ldc_w 405
    //   21: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: areturn
    //   26: aload_0
    //   27: invokeinterface 280 1 0
    //   32: ifeq +110 -> 142
    //   35: new 313	java/util/LinkedList
    //   38: dup
    //   39: invokespecial 314	java/util/LinkedList:<init>	()V
    //   42: astore_2
    //   43: new 6	com/tencent/mm/plugin/appbrand/appusage/y$a
    //   46: dup
    //   47: invokespecial 194	com/tencent/mm/plugin/appbrand/appusage/y$a:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual 410	com/tencent/mm/plugin/appbrand/appusage/y$a:convertFrom	(Landroid/database/Cursor;)V
    //   56: aload_1
    //   57: getfield 104	com/tencent/mm/plugin/appbrand/appusage/y$a:field_brandId	Ljava/lang/String;
    //   60: invokestatic 110	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   63: ifne +38 -> 101
    //   66: aload_2
    //   67: aload_1
    //   68: getfield 124	com/tencent/mm/plugin/appbrand/appusage/y$a:field_recordId	I
    //   71: invokestatic 183	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   74: aload_1
    //   75: getfield 104	com/tencent/mm/plugin/appbrand/appusage/y$a:field_brandId	Ljava/lang/String;
    //   78: aload_1
    //   79: getfield 204	com/tencent/mm/plugin/appbrand/appusage/y$a:field_versionType	I
    //   82: aload_1
    //   83: getfield 198	com/tencent/mm/plugin/appbrand/appusage/y$a:field_updateTime	J
    //   86: aload_1
    //   87: getfield 414	com/tencent/mm/plugin/appbrand/appusage/y$a:field_usedInThirdPartyAppRecently	Z
    //   90: aload_1
    //   91: getfield 417	com/tencent/mm/plugin/appbrand/appusage/y$a:field_thirdPartyAppUsingDesc	Ljava/lang/String;
    //   94: invokestatic 420	com/tencent/mm/plugin/appbrand/config/v:a	(Ljava/lang/String;Ljava/lang/String;IJZLjava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;
    //   97: invokevirtual 421	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: aload_0
    //   102: invokeinterface 329 1 0
    //   107: ifne -56 -> 51
    //   110: new 316	java/util/ArrayList
    //   113: dup
    //   114: aload_2
    //   115: invokevirtual 422	java/util/LinkedList:size	()I
    //   118: invokespecial 317	java/util/ArrayList:<init>	(I)V
    //   121: astore_1
    //   122: aload_1
    //   123: aload_2
    //   124: invokevirtual 426	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   127: pop
    //   128: aload_0
    //   129: invokeinterface 287 1 0
    //   134: ldc_w 405
    //   137: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_1
    //   141: areturn
    //   142: new 316	java/util/ArrayList
    //   145: dup
    //   146: invokespecial 406	java/util/ArrayList:<init>	()V
    //   149: astore_1
    //   150: goto -22 -> 128
    //   153: astore_1
    //   154: ldc 230
    //   156: ldc_w 428
    //   159: iconst_1
    //   160: anewarray 78	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: aastore
    //   167: invokestatic 430	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: new 316	java/util/ArrayList
    //   173: dup
    //   174: iconst_0
    //   175: invokespecial 317	java/util/ArrayList:<init>	(I)V
    //   178: astore_1
    //   179: aload_0
    //   180: invokeinterface 287 1 0
    //   185: ldc_w 405
    //   188: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_1
    //   192: areturn
    //   193: astore_1
    //   194: aload_0
    //   195: invokeinterface 287 1 0
    //   200: ldc_w 405
    //   203: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_1
    //   207: athrow
    //   208: astore_1
    //   209: goto -55 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramCursor	Cursor
    //   50	100	1	localObject1	Object
    //   153	13	1	localSQLiteDiskIOException	com.tencent.wcdb.database.SQLiteDiskIOException
    //   178	14	1	localArrayList	ArrayList
    //   193	14	1	localObject2	Object
    //   208	1	1	localSQLiteDiskIOException1	android.database.sqlite.SQLiteDiskIOException
    //   42	82	2	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   26	51	153	com/tencent/wcdb/database/SQLiteDiskIOException
    //   51	101	153	com/tencent/wcdb/database/SQLiteDiskIOException
    //   101	128	153	com/tencent/wcdb/database/SQLiteDiskIOException
    //   142	150	153	com/tencent/wcdb/database/SQLiteDiskIOException
    //   26	51	193	finally
    //   51	101	193	finally
    //   101	128	193	finally
    //   142	150	193	finally
    //   154	179	193	finally
    //   26	51	208	android/database/sqlite/SQLiteDiskIOException
    //   51	101	208	android/database/sqlite/SQLiteDiskIOException
    //   101	128	208	android/database/sqlite/SQLiteDiskIOException
    //   142	150	208	android/database/sqlite/SQLiteDiskIOException
  }
  
  public final List<String> MI(String paramString)
  {
    AppMethodBeat.i(44616);
    LinkedList localLinkedList = new LinkedList();
    if (!bt.isNullOrNil(paramString))
    {
      h localh = this.jPq;
      String str = String.format(Locale.US, "%s=? and %s=?", new Object[] { "scene", "brandId" });
      paramString = localh.query("AppBrandLauncherLayoutItem", new String[] { "recordId" }, str, new String[] { "2", paramString }, null, null, null);
      if (paramString == null)
      {
        AppMethodBeat.o(44616);
        return null;
      }
      if (paramString.moveToFirst()) {
        do
        {
          localLinkedList.add(String.valueOf(paramString.getInt(paramString.getColumnIndex("recordId"))));
        } while (paramString.moveToNext());
      }
      paramString.close();
    }
    AppMethodBeat.o(44616);
    return localLinkedList;
  }
  
  final Cursor a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44612);
    paramArrayOfString = a(paramArrayOfString, paramInt1, paramInt2, 2147483647);
    AppMethodBeat.o(44612);
    return paramArrayOfString;
  }
  
  final Cursor a(String[] paramArrayOfString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(44613);
    String str;
    String[] arrayOfString;
    if (paramInt3 == 2147483647)
    {
      str = String.format(Locale.US, "%s=? order by %s desc limit %d offset %d", new Object[] { "scene", "updateTime", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      arrayOfString = new String[1];
      arrayOfString[0] = "2";
    }
    for (;;)
    {
      paramArrayOfString = this.jPq.query("AppBrandLauncherLayoutItem", paramArrayOfString, str, arrayOfString, null, null, null);
      AppMethodBeat.o(44613);
      return paramArrayOfString;
      str = String.format(Locale.US, "%s=? and %s=? order by %s desc limit %d offset %d", new Object[] { "scene", "versionType", "updateTime", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      arrayOfString = new String[2];
      arrayOfString[0] = "2";
      arrayOfString[1] = String.valueOf(paramInt3);
    }
  }
  
  public final boolean a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(44620);
    paramBoolean = a(paramString1, paramInt1, true, paramBoolean, paramInt2, paramInt3, paramString2);
    if (paramBoolean) {
      i.MC(paramString2);
    }
    AppMethodBeat.o(44620);
    return paramBoolean;
  }
  
  final void aX(List<ege> paramList)
  {
    AppMethodBeat.i(188037);
    y.a locala = new y.a();
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    long l = this.jPq.xO(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ege localege = (ege)paramList.next();
      if (!bt.isNullOrNil(localege.username))
      {
        locala.field_brandId = localege.username;
        locala.field_versionType = localege.FKM;
        locala.field_scene = 2;
        if (!this.jPA.get(locala, new String[0]))
        {
          locala.field_updateTime = localege.FKm;
          locala.field_usedInThirdPartyAppRecently = localege.HRk;
          locala.field_thirdPartyAppUsingDesc = localege.HRl;
          if (a(locala)) {
            localLinkedList1.add(String.valueOf(locala.field_recordId));
          }
        }
        else
        {
          locala.field_updateTime = Math.max(localege.FKm, locala.field_updateTime);
          locala.field_usedInThirdPartyAppRecently = localege.HRk;
          locala.field_thirdPartyAppUsingDesc = localege.HRl;
          if (this.jPA.update(locala, new String[0])) {
            localLinkedList2.add(String.valueOf(locala.field_recordId));
          }
        }
      }
    }
    this.jPq.sJ(l);
    if (!bt.hj(localLinkedList1)) {
      doNotify("batch", 2, localLinkedList1);
    }
    if (!bt.hj(localLinkedList2)) {
      doNotify("batch", 3, localLinkedList2);
    }
    AppMethodBeat.o(188037);
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(44610);
    add("MicroMsg.AppBrandUsageStorage.WORKER", parama);
    AppMethodBeat.o(44610);
  }
  
  public final c bcv()
  {
    return this.jPB;
  }
  
  public final boolean be(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44611);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44611);
      return false;
    }
    paramString = this.jPq.a(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[] { "AppBrandLauncherLayoutItem", "brandId", "versionType", "scene" }), new String[] { paramString, String.valueOf(paramInt), "2" }, 0);
    if (paramString == null)
    {
      AppMethodBeat.o(44611);
      return false;
    }
    if (paramString.moveToFirst()) {
      if (paramString.getInt(0) <= 0) {}
    }
    for (;;)
    {
      paramString.close();
      AppMethodBeat.o(44611);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final void bg(String paramString, int paramInt)
  {
    AppMethodBeat.i(44621);
    a(paramString, paramInt, false, false, 0, 0, null);
    AppMethodBeat.o(44621);
  }
  
  public final boolean bh(String paramString, int paramInt)
  {
    AppMethodBeat.i(44622);
    boolean bool = bf(paramString, paramInt);
    if (bool)
    {
      ac.bj(paramString, paramInt).aED();
      doNotify("single", 5, String.valueOf(H(paramString, paramInt, 2)));
    }
    AppMethodBeat.o(44622);
    return bool;
  }
  
  public final boolean bi(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44623);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(44623);
      return false;
    }
    String str = String.format("select count(*) from %s where %s=?", new Object[] { "AppBrandLauncherLayoutItem", "recordId" });
    paramString = this.jPq.a(str, new String[] { String.valueOf(H(paramString, paramInt, 2)) }, 2);
    if ((paramString == null) || (paramString.isClosed()))
    {
      AppMethodBeat.o(44623);
      return false;
    }
    try
    {
      if (paramString.moveToFirst())
      {
        paramInt = paramString.getInt(0);
        if (paramInt > 0) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      return false;
    }
    finally
    {
      paramString.close();
      AppMethodBeat.o(44623);
    }
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> sb(int paramInt)
  {
    AppMethodBeat.i(44615);
    ArrayList localArrayList = d(a(null, paramInt, 0));
    AppMethodBeat.o(44615);
    return localArrayList;
  }
  
  public final class c
  {
    private c() {}
    
    public final ArrayList<AppBrandRecentTaskInfo> bcx()
    {
      AppMethodBeat.i(188035);
      ArrayList localArrayList = g(9223372036854775807L, 30);
      AppMethodBeat.o(188035);
      return localArrayList;
    }
    
    public final ArrayList<AppBrandRecentTaskInfo> g(long paramLong, int paramInt)
    {
      AppMethodBeat.i(188036);
      Object localObject = y.a(y.this);
      String str1 = String.format(Locale.US, "%s=? and %s<? ", new Object[] { "scene", "updateTime" });
      String str2 = String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[] { "updateTime", Integer.valueOf(paramInt) });
      localObject = y.d(((h)localObject).a("AppBrandLauncherLayoutItem", null, str1, new String[] { "2", String.valueOf(paramLong) }, null, null, str2, 2));
      AppMethodBeat.o(188036);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.y
 * JD-Core Version:    0.7.0.1
 */