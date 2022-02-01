package com.tencent.mm.plugin.appbrand.appusage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bm.4;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.b;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.protocal.protobuf.gkl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class w
  extends MStorage
{
  public static final String[] nVW;
  private final w.b qPE;
  public final c qPF;
  public final com.tencent.mm.storagebase.h qPw;
  
  static
  {
    AppMethodBeat.i(44627);
    nVW = new String[] { MAutoStorage.getCreateSQLs(w.a.nVV, "AppBrandLauncherLayoutItem") };
    AppMethodBeat.o(44627);
  }
  
  public w(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(44609);
    this.qPF = new c((byte)0);
    this.qPw = paramh;
    this.qPE = new w.b(paramh);
    AppMethodBeat.o(44609);
  }
  
  private static int O(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44625);
    paramInt1 = String.format(Locale.US, "%s|%d|%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }).hashCode();
    AppMethodBeat.o(44625);
    return paramInt1;
  }
  
  private boolean a(w.a parama)
  {
    AppMethodBeat.i(44624);
    if (Util.isNullOrNil(parama.field_brandId))
    {
      AppMethodBeat.o(44624);
      return false;
    }
    long l = this.qPw.insert("AppBrandLauncherLayoutItem", "", parama.convertTo());
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
    localObject = this.qPw.rawQuery((String)localObject, new String[] { "2" });
    long l;
    int i;
    label190:
    boolean bool2;
    boolean bool1;
    if (localObject == null)
    {
      l = 0L;
      l = Math.max(l + 1L, Util.nowSecond());
      int j = O(paramString1, paramInt1, 2);
      localObject = new ContentValues(1);
      ((ContentValues)localObject).put("updateTime", Long.valueOf(l));
      ((ContentValues)localObject).put("usedInThirdPartyAppRecently", Boolean.FALSE);
      ((ContentValues)localObject).put("thirdPartyAppUsingDesc", "");
      if (this.qPw.update("AppBrandLauncherLayoutItem", (ContentValues)localObject, String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(j) }) <= 0) {
        break label444;
      }
      i = 1;
      if (i != 0) {
        doNotify("single", 3, String.valueOf(j));
      }
      if (i != 0) {
        break label450;
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
      label275:
      if ((bool1) && (paramBoolean1))
      {
        localObject = ((b)n.ag(b.class)).M(paramString1, 3, paramInt2);
        if (!((Boolean)((Pair)localObject).first).booleanValue()) {
          break label459;
        }
        Log.i("MicroMsg.AppBrandUsageStorage", "addRecord, addOk TRUE, cgi blocked by username(%s), scene(%d)", new Object[] { paramString1, Integer.valueOf(paramInt2) });
        paramString2 = a.qJY;
        a.ac(((Integer)((Pair)localObject).second).intValue(), 165L);
      }
    }
    for (;;)
    {
      if (bool1) {
        ae.bA(paramString1, paramInt1);
      }
      if (bool2) {
        cji();
      }
      if (bool1) {
        ((m)n.ag(m.class)).a(paramString1, paramInt1, m.a.qOR);
      }
      AppMethodBeat.o(44617);
      return bool1;
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
      bool1 = true;
      bool2 = false;
      break label275;
      label459:
      aa.a(paramString1, paramInt1, paramBoolean2, paramInt2, paramInt3, paramString2).bFJ();
    }
  }
  
  private boolean bY(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44619);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44619);
      return false;
    }
    if (this.qPw.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { String.valueOf(O(paramString, paramInt, 2)) }) > 0) {}
    for (;;)
    {
      if (bool) {
        ((m)n.ag(m.class)).b(paramString, paramInt, m.a.qOR);
      }
      AppMethodBeat.o(44619);
      return bool;
      bool = false;
    }
  }
  
  private void cji()
  {
    AppMethodBeat.i(44618);
    Object localObject1 = this.qPw.rawQuery(String.format(Locale.US, "select count(*) from %s where %s=?", new Object[] { "AppBrandLauncherLayoutItem", "scene" }), new String[] { "2" });
    int i;
    if (localObject1 == null) {
      i = 0;
    }
    Object localObject3;
    Object localObject2;
    Object localObject4;
    for (;;)
    {
      if (i > 10000)
      {
        localObject3 = a(new String[] { "recordId", "brandId", "versionType" }, 2147483647, 10000);
        if (localObject3 == null)
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
          localObject2 = new ArrayList(i - 10000);
          ArrayList localArrayList = new ArrayList(i - 10000);
          if (((Cursor)localObject3).moveToFirst()) {
            do
            {
              ((List)localObject1).add(String.valueOf(((Cursor)localObject3).getInt(0)));
              ((List)localObject2).add(((Cursor)localObject3).getString(1));
              localArrayList.add(Integer.valueOf(((Cursor)localObject3).getInt(2)));
            } while (((Cursor)localObject3).moveToNext());
          }
          ((Cursor)localObject3).close();
          if (Util.isNullOrNil((List)localObject1))
          {
            AppMethodBeat.o(44618);
            return;
          }
          long l = this.qPw.beginTransaction(Thread.currentThread().getId());
          localObject3 = ((List)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            this.qPw.delete("AppBrandLauncherLayoutItem", String.format(Locale.US, "%s=?", new Object[] { "recordId" }), new String[] { localObject4 });
          }
          this.qPw.endTransaction(l);
          localObject3 = new ArrayList(((List)localObject2).size());
          localObject4 = new ArrayList(((List)localObject2).size());
          i = 0;
          while (i < ((List)localObject2).size())
          {
            String str = ad.XJ((String)((List)localObject2).get(i));
            if (!Util.isNullOrNil(str))
            {
              ((List)localObject3).add(str);
              ((List)localObject4).add((Integer)localArrayList.get(i));
            }
            i += 1;
          }
          if (n.cfm() != null)
          {
            localObject2 = n.cfm();
            if ((((List)localObject3).size() > 0) && (((List)localObject4).size() > 0) && (((List)localObject3).size() == ((List)localObject4).size())) {
              break label533;
            }
          }
        }
      }
    }
    for (;;)
    {
      doNotify("batch", 5, localObject1);
      AppMethodBeat.o(44618);
      return;
      label533:
      Log.i("MicroMsg.AppBrandWxaPkgStorage", "batchDeleteAppPkg, size %d", new Object[] { Integer.valueOf(((List)localObject3).size()) });
      ((bm)localObject2).ai(new bm.4((bm)localObject2, (List)localObject3, (List)localObject4));
    }
  }
  
  /* Error */
  public static ArrayList<AppBrandRecentTaskInfo> g(Cursor paramCursor)
  {
    // Byte code:
    //   0: ldc_w 416
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +19 -> 26
    //   10: new 329	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 417	java/util/ArrayList:<init>	()V
    //   17: astore_0
    //   18: ldc_w 416
    //   21: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: areturn
    //   26: aload_0
    //   27: invokeinterface 283 1 0
    //   32: ifeq +110 -> 142
    //   35: new 326	java/util/LinkedList
    //   38: dup
    //   39: invokespecial 327	java/util/LinkedList:<init>	()V
    //   42: astore_2
    //   43: new 6	com/tencent/mm/plugin/appbrand/appusage/w$a
    //   46: dup
    //   47: invokespecial 197	com/tencent/mm/plugin/appbrand/appusage/w$a:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual 421	com/tencent/mm/plugin/appbrand/appusage/w$a:convertFrom	(Landroid/database/Cursor;)V
    //   56: aload_1
    //   57: getfield 104	com/tencent/mm/plugin/appbrand/appusage/w$a:field_brandId	Ljava/lang/String;
    //   60: invokestatic 110	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   63: ifne +38 -> 101
    //   66: aload_2
    //   67: aload_1
    //   68: getfield 126	com/tencent/mm/plugin/appbrand/appusage/w$a:field_recordId	I
    //   71: invokestatic 186	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   74: aload_1
    //   75: getfield 104	com/tencent/mm/plugin/appbrand/appusage/w$a:field_brandId	Ljava/lang/String;
    //   78: aload_1
    //   79: getfield 207	com/tencent/mm/plugin/appbrand/appusage/w$a:field_versionType	I
    //   82: aload_1
    //   83: getfield 201	com/tencent/mm/plugin/appbrand/appusage/w$a:field_updateTime	J
    //   86: aload_1
    //   87: getfield 425	com/tencent/mm/plugin/appbrand/appusage/w$a:field_usedInThirdPartyAppRecently	Z
    //   90: aload_1
    //   91: getfield 428	com/tencent/mm/plugin/appbrand/appusage/w$a:field_thirdPartyAppUsingDesc	Ljava/lang/String;
    //   94: invokestatic 431	com/tencent/mm/plugin/appbrand/config/ad:a	(Ljava/lang/String;Ljava/lang/String;IJZLjava/lang/String;)Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;
    //   97: invokevirtual 432	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: aload_0
    //   102: invokeinterface 342 1 0
    //   107: ifne -56 -> 51
    //   110: new 329	java/util/ArrayList
    //   113: dup
    //   114: aload_2
    //   115: invokevirtual 433	java/util/LinkedList:size	()I
    //   118: invokespecial 330	java/util/ArrayList:<init>	(I)V
    //   121: astore_1
    //   122: aload_1
    //   123: aload_2
    //   124: invokevirtual 437	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   127: pop
    //   128: aload_0
    //   129: invokeinterface 290 1 0
    //   134: ldc_w 416
    //   137: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_1
    //   141: areturn
    //   142: new 329	java/util/ArrayList
    //   145: dup
    //   146: invokespecial 417	java/util/ArrayList:<init>	()V
    //   149: astore_1
    //   150: goto -22 -> 128
    //   153: astore_1
    //   154: ldc 233
    //   156: ldc_w 439
    //   159: iconst_1
    //   160: anewarray 78	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: aastore
    //   167: invokestatic 442	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: new 329	java/util/ArrayList
    //   173: dup
    //   174: iconst_0
    //   175: invokespecial 330	java/util/ArrayList:<init>	(I)V
    //   178: astore_1
    //   179: aload_0
    //   180: invokeinterface 290 1 0
    //   185: ldc_w 416
    //   188: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aload_1
    //   192: areturn
    //   193: astore_1
    //   194: aload_0
    //   195: invokeinterface 290 1 0
    //   200: ldc_w 416
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
  
  public final List<String> WL(String paramString)
  {
    AppMethodBeat.i(44616);
    LinkedList localLinkedList = new LinkedList();
    if (!Util.isNullOrNil(paramString))
    {
      com.tencent.mm.storagebase.h localh = this.qPw;
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
      paramArrayOfString = this.qPw.query("AppBrandLauncherLayoutItem", paramArrayOfString, str, arrayOfString, null, null, null);
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
    AppMethodBeat.i(319380);
    boolean bool = a(paramString1, paramInt1, true, paramBoolean1, paramInt2, paramInt3, paramString2);
    if (bool) {
      if (paramBoolean2) {
        break label50;
      }
    }
    label50:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      h.b(true, paramBoolean1, paramString2);
      AppMethodBeat.o(319380);
      return bool;
    }
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(44610);
    add("MicroMsg.AppBrandUsageStorage.WORKER", paramIOnStorageChange);
    AppMethodBeat.o(44610);
  }
  
  public final boolean bX(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44611);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44611);
      return false;
    }
    paramString = this.qPw.rawQuery(String.format(Locale.US, "select count(*) from %s where %s=? and %s=? and %s=?", new Object[] { "AppBrandLauncherLayoutItem", "brandId", "versionType", "scene" }), new String[] { paramString, String.valueOf(paramInt), "2" });
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
  
  public final void bZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(44621);
    a(paramString, paramInt, false, false, 0, 0, null);
    AppMethodBeat.o(44621);
  }
  
  final void cT(List<gkl> paramList)
  {
    AppMethodBeat.i(319407);
    w.a locala = new w.a();
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    long l = this.qPw.beginTransaction(Thread.currentThread().getId());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      gkl localgkl = (gkl)paramList.next();
      if (!Util.isNullOrNil(localgkl.username))
      {
        locala.field_brandId = localgkl.username;
        locala.field_versionType = localgkl.Tqb;
        locala.field_scene = 2;
        if (!this.qPE.get(locala, new String[0]))
        {
          locala.field_updateTime = localgkl.update_time;
          locala.field_usedInThirdPartyAppRecently = localgkl.acgp;
          locala.field_thirdPartyAppUsingDesc = localgkl.acgq;
          if (a(locala)) {
            localLinkedList1.add(String.valueOf(locala.field_recordId));
          }
        }
        else
        {
          locala.field_updateTime = Math.max(localgkl.update_time, locala.field_updateTime);
          locala.field_usedInThirdPartyAppRecently = localgkl.acgp;
          locala.field_thirdPartyAppUsingDesc = localgkl.acgq;
          if (this.qPE.update(locala, new String[0])) {
            localLinkedList2.add(String.valueOf(locala.field_recordId));
          }
        }
      }
    }
    this.qPw.endTransaction(l);
    if (!Util.isNullOrNil(localLinkedList1)) {
      doNotify("batch", 2, localLinkedList1);
    }
    if (!Util.isNullOrNil(localLinkedList2)) {
      doNotify("batch", 3, localLinkedList2);
    }
    AppMethodBeat.o(319407);
  }
  
  public final boolean ca(String paramString, int paramInt)
  {
    AppMethodBeat.i(44622);
    boolean bool = bY(paramString, paramInt);
    if (bool)
    {
      aa.cc(paramString, paramInt).bFJ();
      doNotify("single", 5, String.valueOf(O(paramString, paramInt, 2)));
    }
    AppMethodBeat.o(44622);
    return bool;
  }
  
  public final boolean cb(String paramString, int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(44623);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(44623);
      return false;
    }
    String str = String.format("select count(*) from %s where %s=?", new Object[] { "AppBrandLauncherLayoutItem", "recordId" });
    paramString = this.qPw.rawQuery(str, new String[] { String.valueOf(O(paramString, paramInt, 2)) }, 2);
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
  
  public final ArrayList<AppBrandRecentTaskInfo> zx(int paramInt)
  {
    AppMethodBeat.i(44615);
    ArrayList localArrayList = g(a(null, paramInt, 0));
    AppMethodBeat.o(44615);
    return localArrayList;
  }
  
  public final class c
  {
    private c() {}
    
    public final ArrayList<AppBrandRecentTaskInfo> cjj()
    {
      AppMethodBeat.i(319302);
      ArrayList localArrayList = s(9223372036854775807L, 32);
      AppMethodBeat.o(319302);
      return localArrayList;
    }
    
    public final ArrayList<AppBrandRecentTaskInfo> s(long paramLong, int paramInt)
    {
      AppMethodBeat.i(319304);
      Object localObject = w.a(w.this);
      String str1 = String.format(Locale.US, "%s=? and %s<? ", new Object[] { "scene", "updateTime" });
      String str2 = String.format(Locale.US, "%s desc limit %d offset 0 ", new Object[] { "updateTime", Integer.valueOf(paramInt) });
      localObject = w.g(((com.tencent.mm.storagebase.h)localObject).query("AppBrandLauncherLayoutItem", null, str1, new String[] { "2", String.valueOf(paramLong) }, null, null, str2, 2));
      AppMethodBeat.o(319304);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.w
 * JD-Core Version:    0.7.0.1
 */