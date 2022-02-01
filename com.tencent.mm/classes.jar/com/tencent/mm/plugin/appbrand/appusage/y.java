package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aa;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class y
  extends k
{
  public static final String[] hlS;
  final y.b jvG;
  public final c jvH;
  public final h jvw;
  
  static
  {
    AppMethodBeat.i(44627);
    hlS = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(y.a.hlR, "AppBrandLauncherLayoutItem") };
    AppMethodBeat.o(44627);
  }
  
  public y(h paramh)
  {
    AppMethodBeat.i(44609);
    this.jvH = new c((byte)0);
    this.jvw = paramh;
    this.jvG = new y.b(paramh);
    AppMethodBeat.o(44609);
  }
  
  private static int F(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44625);
    paramInt1 = String.format(Locale.US, "%s|%d|%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }).hashCode();
    AppMethodBeat.o(44625);
    return paramInt1;
  }
  
  private boolean a(String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(44617);
    if ((bs.isNullOrNil(paramString1)) || (999 == paramInt1))
    {
      AppMethodBeat.o(44617);
      return false;
    }
    Object localObject = String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[] { "updateTime", "AppBrandLauncherLayoutItem", "scene" });
    localObject = this.jvw.a((String)localObject, new String[] { "2" }, 0);
    long l;
    int i;
    label172:
    boolean bool2;
    boolean bool1;
    if (localObject == null)
    {
      l = 0L;
      l = Math.max(l + 1L, bs.aNx());
      int j = F(paramString1, paramInt1, 2);
      localObject = new ContentValues(1);
      ((ContentValues)localObject).put("updateTime", Long.valueOf(l));
      if (this.jvw.update("AppBrandLauncherLayoutItem", (ContentValues)localObject, String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(j) }) <= 0) {
        break label425;
      }
      i = 1;
      if (i != 0) {
        doNotify("single", 3, String.valueOf(j));
      }
      if (i != 0) {
        break label431;
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
      label257:
      if ((bool2) && (paramBoolean1))
      {
        localObject = ((b)com.tencent.mm.plugin.appbrand.app.j.T(b.class)).D(paramString1, 3, paramInt2);
        if (!((Boolean)((Pair)localObject).first).booleanValue()) {
          break label440;
        }
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.AppBrandUsageStorage", "addRecord, addOk TRUE, cgi blocked by username(%s), scene(%d)", new Object[] { paramString1, Integer.valueOf(paramInt2) });
        paramString2 = a.jqG;
        a.A(((Integer)((Pair)localObject).second).intValue(), 165L);
      }
    }
    for (;;)
    {
      if (bool2) {
        aa.aG(paramString1, paramInt1);
      }
      if (bool1) {
        aYY();
      }
      if (bool2) {
        ((n)com.tencent.mm.plugin.appbrand.app.j.T(n.class)).a(paramString1, paramInt1, n.a.juR);
      }
      AppMethodBeat.o(44617);
      return bool2;
      l = 0L;
      if (((Cursor)localObject).moveToFirst()) {
        l = ((Cursor)localObject).getLong(0);
      }
      ((Cursor)localObject).close();
      break;
      label425:
      i = 0;
      break label172;
      label431:
      bool2 = true;
      bool1 = false;
      break label257;
      label440:
      new ac(paramInt2, paramBoolean2, paramInt1, 1, paramString1, paramInt3, paramString2).aBB();
    }
  }
  
  private void aYY()
  {
    AppMethodBeat.i(44618);
    Object localObject1 = this.jvw.a(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[] { "AppBrandLauncherLayoutItem", "scene" }), new String[] { "2" }, 0);
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
        if (bs.gY((List)localObject1))
        {
          AppMethodBeat.o(44618);
          return;
        }
        long l = this.jvw.vE(Thread.currentThread().getId());
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.jvw.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { localObject3 });
        }
        this.jvw.qL(l);
        localObject2 = new ArrayList(localArrayList1.size());
        Object localObject3 = new ArrayList(localArrayList1.size());
        i = 0;
        while (i < localArrayList1.size())
        {
          String str = u.Kl((String)localArrayList1.get(i));
          if (!bs.isNullOrNil(str))
          {
            ((List)localObject2).add(str);
            ((List)localObject3).add(localArrayList2.get(i));
          }
          i += 1;
        }
        if (com.tencent.mm.plugin.appbrand.app.j.aVC() != null) {
          com.tencent.mm.plugin.appbrand.app.j.aVC().e((List)localObject2, (List)localObject3);
        }
        doNotify("batch", 5, localObject1);
      }
    }
    AppMethodBeat.o(44618);
  }
  
  private boolean bd(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44619);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44619);
      return false;
    }
    if (this.jvw.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(F(paramString, paramInt, 2)) }) > 0) {}
    for (;;)
    {
      if (bool) {
        ((n)com.tencent.mm.plugin.appbrand.app.j.T(n.class)).b(paramString, paramInt, n.a.juR);
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
    //   0: ldc_w 379
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +19 -> 26
    //   10: new 290	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 380	java/util/ArrayList:<init>	()V
    //   17: astore_0
    //   18: ldc_w 379
    //   21: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: areturn
    //   26: aload_0
    //   27: invokeinterface 254 1 0
    //   32: ifeq +102 -> 134
    //   35: new 287	java/util/LinkedList
    //   38: dup
    //   39: invokespecial 288	java/util/LinkedList:<init>	()V
    //   42: astore_2
    //   43: new 6	com/tencent/mm/plugin/appbrand/appusage/y$a
    //   46: dup
    //   47: invokespecial 160	com/tencent/mm/plugin/appbrand/appusage/y$a:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual 384	com/tencent/mm/plugin/appbrand/appusage/y$a:convertFrom	(Landroid/database/Cursor;)V
    //   56: aload_1
    //   57: getfield 172	com/tencent/mm/plugin/appbrand/appusage/y$a:field_brandId	Ljava/lang/String;
    //   60: invokestatic 106	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   63: ifne +30 -> 93
    //   66: aload_2
    //   67: aload_1
    //   68: getfield 387	com/tencent/mm/plugin/appbrand/appusage/y$a:field_recordId	I
    //   71: invokestatic 149	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   74: aload_1
    //   75: getfield 172	com/tencent/mm/plugin/appbrand/appusage/y$a:field_brandId	Ljava/lang/String;
    //   78: aload_1
    //   79: getfield 175	com/tencent/mm/plugin/appbrand/appusage/y$a:field_versionType	I
    //   82: aload_1
    //   83: getfield 164	com/tencent/mm/plugin/appbrand/appusage/y$a:field_updateTime	J
    //   86: invokestatic 390	com/tencent/mm/plugin/appbrand/config/u:a	(Ljava/lang/String;Ljava/lang/String;IJ)Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;
    //   89: invokevirtual 391	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: aload_0
    //   94: invokeinterface 303 1 0
    //   99: ifne -48 -> 51
    //   102: new 290	java/util/ArrayList
    //   105: dup
    //   106: aload_2
    //   107: invokevirtual 392	java/util/LinkedList:size	()I
    //   110: invokespecial 291	java/util/ArrayList:<init>	(I)V
    //   113: astore_1
    //   114: aload_1
    //   115: aload_2
    //   116: invokevirtual 396	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   119: pop
    //   120: aload_0
    //   121: invokeinterface 261 1 0
    //   126: ldc_w 379
    //   129: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_1
    //   133: areturn
    //   134: new 290	java/util/ArrayList
    //   137: dup
    //   138: invokespecial 380	java/util/ArrayList:<init>	()V
    //   141: astore_1
    //   142: goto -22 -> 120
    //   145: astore_1
    //   146: ldc 204
    //   148: ldc_w 398
    //   151: iconst_1
    //   152: anewarray 78	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload_1
    //   158: aastore
    //   159: invokestatic 400	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: new 290	java/util/ArrayList
    //   165: dup
    //   166: iconst_0
    //   167: invokespecial 291	java/util/ArrayList:<init>	(I)V
    //   170: astore_1
    //   171: aload_0
    //   172: invokeinterface 261 1 0
    //   177: ldc_w 379
    //   180: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_1
    //   184: areturn
    //   185: astore_1
    //   186: aload_0
    //   187: invokeinterface 261 1 0
    //   192: ldc_w 379
    //   195: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   198: aload_1
    //   199: athrow
    //   200: astore_1
    //   201: goto -55 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramCursor	Cursor
    //   50	92	1	localObject1	Object
    //   145	13	1	localSQLiteDiskIOException	com.tencent.wcdb.database.SQLiteDiskIOException
    //   170	14	1	localArrayList	ArrayList
    //   185	14	1	localObject2	Object
    //   200	1	1	localSQLiteDiskIOException1	android.database.sqlite.SQLiteDiskIOException
    //   42	74	2	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   26	51	145	com/tencent/wcdb/database/SQLiteDiskIOException
    //   51	93	145	com/tencent/wcdb/database/SQLiteDiskIOException
    //   93	120	145	com/tencent/wcdb/database/SQLiteDiskIOException
    //   134	142	145	com/tencent/wcdb/database/SQLiteDiskIOException
    //   26	51	185	finally
    //   51	93	185	finally
    //   93	120	185	finally
    //   134	142	185	finally
    //   146	171	185	finally
    //   26	51	200	android/database/sqlite/SQLiteDiskIOException
    //   51	93	200	android/database/sqlite/SQLiteDiskIOException
    //   93	120	200	android/database/sqlite/SQLiteDiskIOException
    //   134	142	200	android/database/sqlite/SQLiteDiskIOException
  }
  
  public final List<String> Jp(String paramString)
  {
    AppMethodBeat.i(44616);
    LinkedList localLinkedList = new LinkedList();
    if (!bs.isNullOrNil(paramString))
    {
      h localh = this.jvw;
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
      paramArrayOfString = this.jvw.query("AppBrandLauncherLayoutItem", paramArrayOfString, str, arrayOfString, null, null, null);
      AppMethodBeat.o(44613);
      return paramArrayOfString;
      str = String.format(Locale.US, "%s=? and %s=? order by %s desc limit %d offset %d", new Object[] { "scene", "versionType", "updateTime", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      arrayOfString = new String[2];
      arrayOfString[0] = "2";
      arrayOfString[1] = String.valueOf(paramInt3);
    }
  }
  
  final boolean a(y.a parama)
  {
    AppMethodBeat.i(44624);
    if (bs.isNullOrNil(parama.field_brandId))
    {
      AppMethodBeat.o(44624);
      return false;
    }
    long l = this.jvw.a("AppBrandLauncherLayoutItem", "", parama.convertTo());
    if ((l > 0L) || (l == parama.field_recordId))
    {
      AppMethodBeat.o(44624);
      return true;
    }
    AppMethodBeat.o(44624);
    return false;
  }
  
  public final boolean a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(44620);
    paramBoolean = a(paramString1, paramInt1, true, paramBoolean, paramInt2, paramInt3, paramString2);
    if (paramBoolean) {
      i.Jl(paramString2);
    }
    AppMethodBeat.o(44620);
    return paramBoolean;
  }
  
  public final c aYX()
  {
    return this.jvH;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(44610);
    add("MicroMsg.AppBrandUsageStorage.WORKER", parama);
    AppMethodBeat.o(44610);
  }
  
  public final boolean bc(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44611);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44611);
      return false;
    }
    paramString = this.jvw.a(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[] { "AppBrandLauncherLayoutItem", "brandId", "versionType", "scene" }), new String[] { paramString, String.valueOf(paramInt), "2" }, 0);
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
  
  public final void be(String paramString, int paramInt)
  {
    AppMethodBeat.i(44621);
    a(paramString, paramInt, false, false, 0, 0, null);
    AppMethodBeat.o(44621);
  }
  
  public final boolean bf(String paramString, int paramInt)
  {
    AppMethodBeat.i(44622);
    boolean bool = bd(paramString, paramInt);
    if (bool)
    {
      ac.bh(paramString, paramInt).aBB();
      doNotify("single", 5, String.valueOf(F(paramString, paramInt, 2)));
    }
    AppMethodBeat.o(44622);
    return bool;
  }
  
  public final boolean bg(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44623);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(44623);
      return false;
    }
    String str = String.format("select count(*) from %s where %s=?", new Object[] { "AppBrandLauncherLayoutItem", "recordId" });
    paramString = this.jvw.a(str, new String[] { String.valueOf(F(paramString, paramInt, 2)) }, 2);
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
  
  public final ArrayList<AppBrandRecentTaskInfo> rB(int paramInt)
  {
    AppMethodBeat.i(44615);
    ArrayList localArrayList = d(a(null, paramInt, 0));
    AppMethodBeat.o(44615);
    return localArrayList;
  }
  
  public final class c
  {
    private c() {}
    
    public final ArrayList<AppBrandRecentTaskInfo> aYZ()
    {
      AppMethodBeat.i(186343);
      ArrayList localArrayList = g(9223372036854775807L, 30);
      AppMethodBeat.o(186343);
      return localArrayList;
    }
    
    public final ArrayList<AppBrandRecentTaskInfo> g(long paramLong, int paramInt)
    {
      AppMethodBeat.i(186344);
      Object localObject = y.a(y.this);
      String str1 = String.format(Locale.US, "%s=? and %s<? ", new Object[] { "scene", "updateTime" });
      String str2 = String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[] { "updateTime", Integer.valueOf(paramInt) });
      localObject = y.d(((h)localObject).a("AppBrandLauncherLayoutItem", null, str1, new String[] { "2", String.valueOf(paramLong) }, null, null, str2, 2));
      AppMethodBeat.o(186344);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.y
 * JD-Core Version:    0.7.0.1
 */