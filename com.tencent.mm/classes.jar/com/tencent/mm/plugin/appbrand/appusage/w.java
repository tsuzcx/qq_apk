package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.appcache.b.e.b;
import com.tencent.mm.plugin.appbrand.appcache.x;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.t.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class w
  extends k
{
  public static final String[] fkl;
  public final h hce;
  final w.b hco;
  public final w.c hcp;
  
  static
  {
    AppMethodBeat.i(129694);
    fkl = new String[] { j.getCreateSQLs(w.a.fkk, "AppBrandLauncherLayoutItem") };
    AppMethodBeat.o(129694);
  }
  
  public w(h paramh)
  {
    AppMethodBeat.i(129675);
    this.hcp = new w.c(this, (byte)0);
    this.hce = paramh;
    this.hco = new w.b(paramh);
    AppMethodBeat.o(129675);
  }
  
  private static int J(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129692);
    paramInt1 = String.format(Locale.US, "%s|%d|%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }).hashCode();
    AppMethodBeat.o(129692);
    return paramInt1;
  }
  
  private boolean a(String paramString1, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(129684);
    if ((bo.isNullOrNil(paramString1)) || (999 == paramInt1))
    {
      AppMethodBeat.o(129684);
      return false;
    }
    Object localObject = String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[] { "updateTime", "AppBrandLauncherLayoutItem", "scene" });
    localObject = this.hce.a((String)localObject, new String[] { "2" }, 0);
    long l;
    int i;
    label172:
    boolean bool2;
    boolean bool1;
    if (localObject == null)
    {
      l = 0L;
      l = Math.max(l + 1L, bo.aox());
      int j = J(paramString1, paramInt1, 2);
      localObject = new ContentValues(1);
      ((ContentValues)localObject).put("updateTime", Long.valueOf(l));
      if (this.hce.update("AppBrandLauncherLayoutItem", (ContentValues)localObject, String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(j) }) <= 0) {
        break label425;
      }
      i = 1;
      if (i != 0) {
        doNotify("single", 3, String.valueOf(j));
      }
      if (i != 0) {
        break label431;
      }
      localObject = new w.a();
      ((w.a)localObject).field_updateTime = l;
      ((w.a)localObject).field_scene = 2;
      ((w.a)localObject).field_brandId = paramString1;
      ((w.a)localObject).field_versionType = paramInt1;
      bool2 = a((w.a)localObject);
      if (bool2) {
        doNotify("single", 2, String.valueOf(j));
      }
      bool1 = bool2;
      label257:
      if ((bool2) && (paramBoolean1))
      {
        localObject = ((b)g.w(b.class)).H(paramString1, 3, paramInt2);
        if (!((Boolean)((Pair)localObject).first).booleanValue()) {
          break label440;
        }
        ab.i("MicroMsg.AppBrandUsageStorage", "addRecord, addOk TRUE, cgi blocked by username(%s), scene(%d)", new Object[] { paramString1, Integer.valueOf(paramInt2) });
        paramString2 = a.gXW;
        a.B(((Integer)((Pair)localObject).second).intValue(), 165L);
      }
    }
    for (;;)
    {
      if (bool2) {
        x.ao(paramString1, paramInt1);
      }
      if (bool1) {
        axB();
      }
      if (bool2) {
        ((n)g.w(n.class)).a(paramString1, paramInt1, n.a.hbv);
      }
      AppMethodBeat.o(129684);
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
      new aa(paramInt2, paramBoolean2, paramInt1, 1, paramString1, paramInt3, paramString2).adl();
    }
  }
  
  private boolean aK(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(129686);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129686);
      return false;
    }
    if (this.hce.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(J(paramString, paramInt, 2)) }) > 0) {}
    for (;;)
    {
      if (bool) {
        ((n)g.w(n.class)).b(paramString, paramInt, n.a.hbv);
      }
      AppMethodBeat.o(129686);
      return bool;
      bool = false;
    }
  }
  
  private void axB()
  {
    AppMethodBeat.i(129685);
    Object localObject1 = this.hce.a(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[] { "AppBrandLauncherLayoutItem", "scene" }), new String[] { "2" }, 0);
    int i;
    if (localObject1 == null) {
      i = 0;
    }
    while (i > 10000)
    {
      Object localObject2 = a(new String[] { "recordId", "brandId", "versionType" }, 2147483647, 10000);
      if (localObject2 == null)
      {
        AppMethodBeat.o(129685);
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
        if (bo.es((List)localObject1))
        {
          AppMethodBeat.o(129685);
          return;
        }
        long l = this.hce.kr(Thread.currentThread().getId());
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.hce.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { localObject3 });
        }
        this.hce.nY(l);
        localObject2 = new ArrayList(localArrayList1.size());
        Object localObject3 = new ArrayList(localArrayList1.size());
        i = 0;
        while (i < localArrayList1.size())
        {
          String str = q.Aq((String)localArrayList1.get(i));
          if (!bo.isNullOrNil(str))
          {
            ((List)localObject2).add(str);
            ((List)localObject3).add(localArrayList2.get(i));
          }
          i += 1;
        }
        if (g.auM() != null) {
          g.auM().d((List)localObject2, (List)localObject3);
        }
        doNotify("batch", 5, localObject1);
      }
    }
    AppMethodBeat.o(129685);
  }
  
  /* Error */
  public static ArrayList<AppBrandRecentTaskInfo> d(Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc_w 376
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +19 -> 26
    //   10: new 298	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 377	java/util/ArrayList:<init>	()V
    //   17: astore_0
    //   18: ldc_w 376
    //   21: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: areturn
    //   26: aload_0
    //   27: invokeinterface 252 1 0
    //   32: ifeq +102 -> 134
    //   35: new 295	java/util/LinkedList
    //   38: dup
    //   39: invokespecial 296	java/util/LinkedList:<init>	()V
    //   42: astore_2
    //   43: new 6	com/tencent/mm/plugin/appbrand/appusage/w$a
    //   46: dup
    //   47: invokespecial 159	com/tencent/mm/plugin/appbrand/appusage/w$a:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual 381	com/tencent/mm/plugin/appbrand/appusage/w$a:convertFrom	(Landroid/database/Cursor;)V
    //   56: aload_1
    //   57: getfield 170	com/tencent/mm/plugin/appbrand/appusage/w$a:field_brandId	Ljava/lang/String;
    //   60: invokestatic 105	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   63: ifne +30 -> 93
    //   66: aload_2
    //   67: aload_1
    //   68: getfield 384	com/tencent/mm/plugin/appbrand/appusage/w$a:field_recordId	I
    //   71: invokestatic 148	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   74: aload_1
    //   75: getfield 170	com/tencent/mm/plugin/appbrand/appusage/w$a:field_brandId	Ljava/lang/String;
    //   78: aload_1
    //   79: getfield 173	com/tencent/mm/plugin/appbrand/appusage/w$a:field_versionType	I
    //   82: aload_1
    //   83: getfield 162	com/tencent/mm/plugin/appbrand/appusage/w$a:field_updateTime	J
    //   86: invokestatic 387	com/tencent/mm/plugin/appbrand/config/q:a	(Ljava/lang/String;Ljava/lang/String;IJ)Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;
    //   89: invokevirtual 388	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: aload_0
    //   94: invokeinterface 311 1 0
    //   99: ifne -48 -> 51
    //   102: new 298	java/util/ArrayList
    //   105: dup
    //   106: aload_2
    //   107: invokevirtual 389	java/util/LinkedList:size	()I
    //   110: invokespecial 299	java/util/ArrayList:<init>	(I)V
    //   113: astore_1
    //   114: aload_1
    //   115: aload_2
    //   116: invokevirtual 393	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   119: pop
    //   120: aload_0
    //   121: invokeinterface 259 1 0
    //   126: ldc_w 376
    //   129: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_1
    //   133: areturn
    //   134: new 298	java/util/ArrayList
    //   137: dup
    //   138: invokespecial 377	java/util/ArrayList:<init>	()V
    //   141: astore_1
    //   142: goto -22 -> 120
    //   145: astore_1
    //   146: ldc 202
    //   148: ldc_w 395
    //   151: iconst_1
    //   152: anewarray 77	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload_1
    //   158: aastore
    //   159: invokestatic 398	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: new 298	java/util/ArrayList
    //   165: dup
    //   166: iconst_0
    //   167: invokespecial 299	java/util/ArrayList:<init>	(I)V
    //   170: astore_1
    //   171: aload_0
    //   172: invokeinterface 259 1 0
    //   177: ldc_w 376
    //   180: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_1
    //   184: areturn
    //   185: astore_1
    //   186: aload_0
    //   187: invokeinterface 259 1 0
    //   192: ldc_w 376
    //   195: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  final Cursor a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(129678);
    paramArrayOfString = this.hce.query("AppBrandLauncherLayoutItem", paramArrayOfString, String.format(Locale.US, "%s=? order by %s desc limit %d offset %d", new Object[] { "scene", "updateTime", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }), new String[] { "2" }, null, null, null);
    AppMethodBeat.o(129678);
    return paramArrayOfString;
  }
  
  final boolean a(w.a parama)
  {
    AppMethodBeat.i(129691);
    if (bo.isNullOrNil(parama.field_brandId))
    {
      AppMethodBeat.o(129691);
      return false;
    }
    long l = this.hce.a("AppBrandLauncherLayoutItem", "", parama.convertTo());
    if ((l > 0L) || (l == parama.field_recordId))
    {
      AppMethodBeat.o(129691);
      return true;
    }
    AppMethodBeat.o(129691);
    return false;
  }
  
  public final boolean a(String paramString1, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(129687);
    paramBoolean = a(paramString1, paramInt1, true, paramBoolean, paramInt2, paramInt3, paramString2);
    if (paramBoolean) {
      i.zu(paramString2);
    }
    AppMethodBeat.o(129687);
    return paramBoolean;
  }
  
  public final boolean aJ(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(129677);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129677);
      return false;
    }
    paramString = this.hce.a(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[] { "AppBrandLauncherLayoutItem", "brandId", "versionType", "scene" }), new String[] { paramString, String.valueOf(paramInt), "2" }, 0);
    if (paramString == null)
    {
      AppMethodBeat.o(129677);
      return false;
    }
    if (paramString.moveToFirst()) {
      if (paramString.getInt(0) <= 0) {}
    }
    for (;;)
    {
      paramString.close();
      AppMethodBeat.o(129677);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final void aL(String paramString, int paramInt)
  {
    AppMethodBeat.i(129688);
    a(paramString, paramInt, false, false, 0, 0, null);
    AppMethodBeat.o(129688);
  }
  
  public final boolean aM(String paramString, int paramInt)
  {
    AppMethodBeat.i(129689);
    boolean bool = aK(paramString, paramInt);
    if (bool)
    {
      aa.aO(paramString, paramInt).adl();
      doNotify("single", 5, String.valueOf(J(paramString, paramInt, 2)));
    }
    AppMethodBeat.o(129689);
    return bool;
  }
  
  public final boolean aN(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(129690);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(129690);
      return false;
    }
    String str = String.format("select count(*) from %s where %s=?", new Object[] { "AppBrandLauncherLayoutItem", "recordId" });
    paramString = this.hce.a(str, new String[] { String.valueOf(J(paramString, paramInt, 2)) }, 2);
    if ((paramString == null) || (paramString.isClosed()))
    {
      AppMethodBeat.o(129690);
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
      AppMethodBeat.o(129690);
    }
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(129676);
    add(parama, e.aNS().oNc.getLooper());
    AppMethodBeat.o(129676);
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> nx(int paramInt)
  {
    AppMethodBeat.i(129680);
    ArrayList localArrayList = d(a(null, paramInt, 0));
    AppMethodBeat.o(129680);
    return localArrayList;
  }
  
  public final AppBrandRecentTaskInfo zx(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(129682);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129682);
      return null;
    }
    Cursor localCursor = this.hce.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "scene", "recordId" }), new String[] { "2", paramString }, null, null, null);
    if (localCursor == null)
    {
      AppMethodBeat.o(129682);
      return null;
    }
    paramString = localObject;
    if (localCursor.moveToFirst())
    {
      w.a locala = new w.a();
      locala.convertFrom(localCursor);
      paramString = localObject;
      if (!bo.isNullOrNil(locala.field_brandId)) {
        paramString = q.a(String.valueOf(locala.field_recordId), locala.field_brandId, locala.field_versionType, locala.field_updateTime);
      }
    }
    localCursor.close();
    AppMethodBeat.o(129682);
    return paramString;
  }
  
  public final List<String> zy(String paramString)
  {
    AppMethodBeat.i(129683);
    LinkedList localLinkedList = new LinkedList();
    if (!bo.isNullOrNil(paramString))
    {
      h localh = this.hce;
      String str = String.format(Locale.US, "%s=? and %s=?", new Object[] { "scene", "brandId" });
      paramString = localh.query("AppBrandLauncherLayoutItem", new String[] { "recordId" }, str, new String[] { "2", paramString }, null, null, null);
      if (paramString == null)
      {
        AppMethodBeat.o(129683);
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
    AppMethodBeat.o(129683);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w
 * JD-Core Version:    0.7.0.1
 */