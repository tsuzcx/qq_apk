package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.p;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.b;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storagebase.h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class x
  extends MStorage
{
  public static final String[] iBh;
  private final b kVA;
  public final c kVB;
  public final h kVs;
  
  static
  {
    AppMethodBeat.i(44627);
    iBh = new String[] { MAutoStorage.getCreateSQLs(a.iBg, "AppBrandLauncherLayoutItem") };
    AppMethodBeat.o(44627);
  }
  
  public x(h paramh)
  {
    AppMethodBeat.i(44609);
    this.kVB = new c((byte)0);
    this.kVs = paramh;
    this.kVA = new b(paramh);
    AppMethodBeat.o(44609);
  }
  
  private static int K(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44625);
    paramInt1 = String.format(Locale.US, "%s|%d|%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }).hashCode();
    AppMethodBeat.o(44625);
    return paramInt1;
  }
  
  private boolean a(a parama)
  {
    AppMethodBeat.i(44624);
    if (Util.isNullOrNil(parama.field_brandId))
    {
      AppMethodBeat.o(44624);
      return false;
    }
    long l = this.kVs.insert("AppBrandLauncherLayoutItem", "", parama.convertTo());
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
    if ((Util.isNullOrNil(paramString1)) || (999 == paramInt1))
    {
      AppMethodBeat.o(44617);
      return false;
    }
    Object localObject = String.format(Locale.US, "select max(%s) from %s where %s=?", new Object[] { "updateTime", "AppBrandLauncherLayoutItem", "scene" });
    localObject = this.kVs.rawQuery((String)localObject, new String[] { "2" });
    long l;
    int i;
    label190:
    boolean bool2;
    boolean bool1;
    if (localObject == null)
    {
      l = 0L;
      l = Math.max(l + 1L, Util.nowSecond());
      int j = K(paramString1, paramInt1, 2);
      localObject = new ContentValues(1);
      ((ContentValues)localObject).put("updateTime", Long.valueOf(l));
      ((ContentValues)localObject).put("usedInThirdPartyAppRecently", Boolean.FALSE);
      ((ContentValues)localObject).put("thirdPartyAppUsingDesc", "");
      if (this.kVs.update("AppBrandLauncherLayoutItem", (ContentValues)localObject, String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(j) }) <= 0) {
        break label444;
      }
      i = 1;
      if (i != 0) {
        doNotify("single", 3, String.valueOf(j));
      }
      if (i != 0) {
        break label450;
      }
      localObject = new a();
      ((a)localObject).field_updateTime = l;
      ((a)localObject).field_scene = 2;
      ((a)localObject).field_brandId = paramString1;
      ((a)localObject).field_versionType = paramInt1;
      bool2 = a((a)localObject);
      if (bool2) {
        doNotify("single", 2, String.valueOf(j));
      }
      bool1 = bool2;
      label275:
      if ((bool2) && (paramBoolean1))
      {
        localObject = ((b)com.tencent.mm.plugin.appbrand.app.n.W(b.class)).I(paramString1, 3, paramInt2);
        if (!((Boolean)((Pair)localObject).first).booleanValue()) {
          break label459;
        }
        Log.i("MicroMsg.AppBrandUsageStorage", "addRecord, addOk TRUE, cgi blocked by username(%s), scene(%d)", new Object[] { paramString1, Integer.valueOf(paramInt2) });
        paramString2 = a.kQt;
        a.F(((Integer)((Pair)localObject).second).intValue(), 165L);
      }
    }
    for (;;)
    {
      if (bool2) {
        ac.aR(paramString1, paramInt1);
      }
      if (bool1) {
        byq();
      }
      if (bool2) {
        ((n)com.tencent.mm.plugin.appbrand.app.n.W(n.class)).a(paramString1, paramInt1, n.a.kUM);
      }
      AppMethodBeat.o(44617);
      return bool2;
      l = 0L;
      if (((Cursor)localObject).moveToFirst()) {
        l = ((Cursor)localObject).getLong(0);
      }
      ((Cursor)localObject).close();
      break;
      label444:
      i = 0;
      break label190;
      label450:
      bool2 = true;
      bool1 = false;
      break label275;
      label459:
      new ab(paramInt2, paramBoolean2, paramInt1, 1, paramString1, paramInt3, paramString2).aYI();
    }
  }
  
  private boolean bn(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44619);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44619);
      return false;
    }
    if (this.kVs.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(K(paramString, paramInt, 2)) }) > 0) {}
    for (;;)
    {
      if (bool) {
        ((n)com.tencent.mm.plugin.appbrand.app.n.W(n.class)).b(paramString, paramInt, n.a.kUM);
      }
      AppMethodBeat.o(44619);
      return bool;
      bool = false;
    }
  }
  
  private void byq()
  {
    AppMethodBeat.i(44618);
    Object localObject1 = this.kVs.rawQuery(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[] { "AppBrandLauncherLayoutItem", "scene" }), new String[] { "2" });
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
        if (Util.isNullOrNil((List)localObject1))
        {
          AppMethodBeat.o(44618);
          return;
        }
        long l = this.kVs.beginTransaction(Thread.currentThread().getId());
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          this.kVs.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { localObject3 });
        }
        this.kVs.endTransaction(l);
        localObject2 = new ArrayList(localArrayList1.size());
        Object localObject3 = new ArrayList(localArrayList1.size());
        i = 0;
        while (i < localArrayList1.size())
        {
          String str = y.Xw((String)localArrayList1.get(i));
          if (!Util.isNullOrNil(str))
          {
            ((List)localObject2).add(str);
            ((List)localObject3).add(localArrayList2.get(i));
          }
          i += 1;
        }
        if (com.tencent.mm.plugin.appbrand.app.n.buL() != null) {
          com.tencent.mm.plugin.appbrand.app.n.buL().f((List)localObject2, (List)localObject3);
        }
        doNotify("batch", 5, localObject1);
      }
    }
    AppMethodBeat.o(44618);
  }
  
  /* Error */
  public static ArrayList<AppBrandRecentTaskInfo> d(Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc_w 406
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +19 -> 26
    //   10: new 328	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 407	java/util/ArrayList:<init>	()V
    //   17: astore_0
    //   18: ldc_w 406
    //   21: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: areturn
    //   26: aload_0
    //   27: invokeinterface 283 1 0
    //   32: ifeq +110 -> 142
    //   35: new 325	java/util/LinkedList
    //   38: dup
    //   39: invokespecial 326	java/util/LinkedList:<init>	()V
    //   42: astore_2
    //   43: new 6	com/tencent/mm/plugin/appbrand/appusage/x$a
    //   46: dup
    //   47: invokespecial 198	com/tencent/mm/plugin/appbrand/appusage/x$a:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual 411	com/tencent/mm/plugin/appbrand/appusage/x$a:convertFrom	(Landroid/database/Cursor;)V
    //   56: aload_1
    //   57: getfield 105	com/tencent/mm/plugin/appbrand/appusage/x$a:field_brandId	Ljava/lang/String;
    //   60: invokestatic 111	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   63: ifne +38 -> 101
    //   66: aload_2
    //   67: aload_1
    //   68: getfield 127	com/tencent/mm/plugin/appbrand/appusage/x$a:field_recordId	I
    //   71: invokestatic 187	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   74: aload_1
    //   75: getfield 105	com/tencent/mm/plugin/appbrand/appusage/x$a:field_brandId	Ljava/lang/String;
    //   78: aload_1
    //   79: getfield 208	com/tencent/mm/plugin/appbrand/appusage/x$a:field_versionType	I
    //   82: aload_1
    //   83: getfield 202	com/tencent/mm/plugin/appbrand/appusage/x$a:field_updateTime	J
    //   86: aload_1
    //   87: getfield 415	com/tencent/mm/plugin/appbrand/appusage/x$a:field_usedInThirdPartyAppRecently	Z
    //   90: aload_1
    //   91: getfield 418	com/tencent/mm/plugin/appbrand/appusage/x$a:field_thirdPartyAppUsingDesc	Ljava/lang/String;
    //   94: invokestatic 421	com/tencent/mm/plugin/appbrand/config/y:a	(Ljava/lang/String;Ljava/lang/String;IJZLjava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;
    //   97: invokevirtual 422	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: aload_0
    //   102: invokeinterface 341 1 0
    //   107: ifne -56 -> 51
    //   110: new 328	java/util/ArrayList
    //   113: dup
    //   114: aload_2
    //   115: invokevirtual 423	java/util/LinkedList:size	()I
    //   118: invokespecial 329	java/util/ArrayList:<init>	(I)V
    //   121: astore_1
    //   122: aload_1
    //   123: aload_2
    //   124: invokevirtual 427	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   127: pop
    //   128: aload_0
    //   129: invokeinterface 290 1 0
    //   134: ldc_w 406
    //   137: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_1
    //   141: areturn
    //   142: new 328	java/util/ArrayList
    //   145: dup
    //   146: invokespecial 407	java/util/ArrayList:<init>	()V
    //   149: astore_1
    //   150: goto -22 -> 128
    //   153: astore_1
    //   154: ldc 233
    //   156: ldc_w 429
    //   159: iconst_1
    //   160: anewarray 80	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: aastore
    //   167: invokestatic 432	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: new 328	java/util/ArrayList
    //   173: dup
    //   174: iconst_0
    //   175: invokespecial 329	java/util/ArrayList:<init>	(I)V
    //   178: astore_1
    //   179: aload_0
    //   180: invokeinterface 290 1 0
    //   185: ldc_w 406
    //   188: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_1
    //   192: areturn
    //   193: astore_1
    //   194: aload_0
    //   195: invokeinterface 290 1 0
    //   200: ldc_w 406
    //   203: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final List<String> Ww(String paramString)
  {
    AppMethodBeat.i(44616);
    LinkedList localLinkedList = new LinkedList();
    if (!Util.isNullOrNil(paramString))
    {
      h localh = this.kVs;
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
      paramArrayOfString = this.kVs.query("AppBrandLauncherLayoutItem", paramArrayOfString, str, arrayOfString, null, null, null);
      AppMethodBeat.o(44613);
      return paramArrayOfString;
      str = String.format(Locale.US, "%s=? and %s=? order by %s desc limit %d offset %d", new Object[] { "scene", "versionType", "updateTime", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      arrayOfString = new String[2];
      arrayOfString[0] = "2";
      arrayOfString[1] = String.valueOf(paramInt3);
    }
  }
  
  public final boolean a(String paramString1, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    AppMethodBeat.i(226396);
    boolean bool = a(paramString1, paramInt1, true, paramBoolean1, paramInt2, paramInt3, paramString2);
    if (bool) {
      if (paramBoolean2) {
        break label50;
      }
    }
    label50:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      i.b(true, paramBoolean1, paramString2);
      AppMethodBeat.o(226396);
      return bool;
    }
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(44610);
    add("MicroMsg.AppBrandUsageStorage.WORKER", paramIOnStorageChange);
    AppMethodBeat.o(44610);
  }
  
  final void bk(List<fcn> paramList)
  {
    AppMethodBeat.i(226397);
    a locala = new a();
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    long l = this.kVs.beginTransaction(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      fcn localfcn = (fcn)paramList.next();
      if (!Util.isNullOrNil(localfcn.username))
      {
        locala.field_brandId = localfcn.username;
        locala.field_versionType = localfcn.KXC;
        locala.field_scene = 2;
        if (!this.kVA.get(locala, new String[0]))
        {
          locala.field_updateTime = localfcn.KWR;
          locala.field_usedInThirdPartyAppRecently = localfcn.Nyt;
          locala.field_thirdPartyAppUsingDesc = localfcn.Nyu;
          if (a(locala)) {
            localLinkedList1.add(String.valueOf(locala.field_recordId));
          }
        }
        else
        {
          locala.field_updateTime = Math.max(localfcn.KWR, locala.field_updateTime);
          locala.field_usedInThirdPartyAppRecently = localfcn.Nyt;
          locala.field_thirdPartyAppUsingDesc = localfcn.Nyu;
          if (this.kVA.update(locala, new String[0])) {
            localLinkedList2.add(String.valueOf(locala.field_recordId));
          }
        }
      }
    }
    this.kVs.endTransaction(l);
    if (!Util.isNullOrNil(localLinkedList1)) {
      doNotify("batch", 2, localLinkedList1);
    }
    if (!Util.isNullOrNil(localLinkedList2)) {
      doNotify("batch", 3, localLinkedList2);
    }
    AppMethodBeat.o(226397);
  }
  
  public final boolean bm(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44611);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44611);
      return false;
    }
    paramString = this.kVs.rawQuery(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[] { "AppBrandLauncherLayoutItem", "brandId", "versionType", "scene" }), new String[] { paramString, String.valueOf(paramInt), "2" });
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
  
  public final void bo(String paramString, int paramInt)
  {
    AppMethodBeat.i(44621);
    a(paramString, paramInt, false, false, 0, 0, null);
    AppMethodBeat.o(44621);
  }
  
  public final boolean bp(String paramString, int paramInt)
  {
    AppMethodBeat.i(44622);
    boolean bool = bn(paramString, paramInt);
    if (bool)
    {
      ab.br(paramString, paramInt).aYI();
      doNotify("single", 5, String.valueOf(K(paramString, paramInt, 2)));
    }
    AppMethodBeat.o(44622);
    return bool;
  }
  
  public final boolean bq(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44623);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(44623);
      return false;
    }
    String str = String.format("select count(*) from %s where %s=?", new Object[] { "AppBrandLauncherLayoutItem", "recordId" });
    paramString = this.kVs.rawQuery(str, new String[] { String.valueOf(K(paramString, paramInt, 2)) }, 2);
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
  
  public final c byp()
  {
    return this.kVB;
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> vZ(int paramInt)
  {
    AppMethodBeat.i(44615);
    ArrayList localArrayList = d(a(null, paramInt, 0));
    AppMethodBeat.o(44615);
    return localArrayList;
  }
  
  public static final class a
    extends p
  {
    static final IAutoDBItem.MAutoDBInfo iBg;
    static final String[] kJX;
    
    static
    {
      AppMethodBeat.i(44607);
      kJX = new String[] { "brandId", "versionType", "scene" };
      IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
      localMAutoDBInfo.fields = new Field[7];
      localMAutoDBInfo.columns = new String[8];
      StringBuilder localStringBuilder = new StringBuilder();
      localMAutoDBInfo.columns[0] = "recordId";
      localMAutoDBInfo.colsMap.put("recordId", "INTEGER PRIMARY KEY ");
      localStringBuilder.append(" recordId INTEGER PRIMARY KEY ");
      localStringBuilder.append(", ");
      localMAutoDBInfo.primaryKey = "recordId";
      localMAutoDBInfo.columns[1] = "brandId";
      localMAutoDBInfo.colsMap.put("brandId", "TEXT");
      localStringBuilder.append(" brandId TEXT");
      localStringBuilder.append(", ");
      localMAutoDBInfo.columns[2] = "versionType";
      localMAutoDBInfo.colsMap.put("versionType", "INTEGER");
      localStringBuilder.append(" versionType INTEGER");
      localStringBuilder.append(", ");
      localMAutoDBInfo.columns[3] = "updateTime";
      localMAutoDBInfo.colsMap.put("updateTime", "LONG");
      localStringBuilder.append(" updateTime LONG");
      localStringBuilder.append(", ");
      localMAutoDBInfo.columns[4] = "scene";
      localMAutoDBInfo.colsMap.put("scene", "INTEGER");
      localStringBuilder.append(" scene INTEGER");
      localStringBuilder.append(", ");
      localMAutoDBInfo.columns[5] = "usedInThirdPartyAppRecently";
      localMAutoDBInfo.colsMap.put("usedInThirdPartyAppRecently", "INTEGER default 'false' ");
      localStringBuilder.append(" usedInThirdPartyAppRecently INTEGER default 'false' ");
      localStringBuilder.append(", ");
      localMAutoDBInfo.columns[6] = "thirdPartyAppUsingDesc";
      localMAutoDBInfo.colsMap.put("thirdPartyAppUsingDesc", "TEXT");
      localStringBuilder.append(" thirdPartyAppUsingDesc TEXT");
      localMAutoDBInfo.columns[7] = "rowid";
      localMAutoDBInfo.sql = localStringBuilder.toString();
      iBg = localMAutoDBInfo;
      AppMethodBeat.o(44607);
    }
    
    public final ContentValues convertTo()
    {
      AppMethodBeat.i(44606);
      this.systemRowid = 0L;
      ContentValues localContentValues = super.convertTo();
      int i = x.L(this.field_brandId, this.field_versionType, this.field_scene);
      this.field_recordId = i;
      localContentValues.put("recordId", Integer.valueOf(i));
      AppMethodBeat.o(44606);
      return localContentValues;
    }
    
    public final IAutoDBItem.MAutoDBInfo getDBInfo()
    {
      return iBg;
    }
  }
  
  static final class b
    extends MAutoStorage<x.a>
  {
    b(ISQLiteDatabase paramISQLiteDatabase)
    {
      super(x.a.iBg, "AppBrandLauncherLayoutItem", x.a.INDEX_CREATE);
    }
  }
  
  public final class c
  {
    private c() {}
    
    public final ArrayList<AppBrandRecentTaskInfo> byr()
    {
      AppMethodBeat.i(226394);
      ArrayList localArrayList = g(9223372036854775807L, 30);
      AppMethodBeat.o(226394);
      return localArrayList;
    }
    
    public final ArrayList<AppBrandRecentTaskInfo> g(long paramLong, int paramInt)
    {
      AppMethodBeat.i(226395);
      Object localObject = x.a(x.this);
      String str1 = String.format(Locale.US, "%s=? and %s<? ", new Object[] { "scene", "updateTime" });
      String str2 = String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[] { "updateTime", Integer.valueOf(paramInt) });
      localObject = x.d(((h)localObject).query("AppBrandLauncherLayoutItem", null, str1, new String[] { "2", String.valueOf(paramLong) }, null, null, str2, 2));
      AppMethodBeat.o(226395);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.x
 * JD-Core Version:    0.7.0.1
 */