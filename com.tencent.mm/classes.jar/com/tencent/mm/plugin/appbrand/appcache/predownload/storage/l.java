package com.tencent.mm.plugin.appbrand.appcache.predownload.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.vfs.y;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentProvider;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "storageInvalidCode", "com/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentStorage$storageInvalidCode$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentStorage$storageInvalidCode$1;", "storageInvalidContact", "com/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentStorage$storageInvalidContact$1", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentStorage$storageInvalidContact$1;", "evictUselessInvalidCodeCommands", "", "wxaPkgStorage", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorage;", "getInvalidCodeReportIdForAppId", "", "appId", "", "getInvalidCodeTimestampForAppId", "", "getInvalidContactReportIdForUsername", "username", "getInvalidContactTimestampForUsername", "removeInvalidCodeTimestampForAppId", "", "removeInvalidContactTimestampForUsername", "resolveInvalidCodeRecord", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/PersistentWxaSyncCmdInvalidCode;", "updateInvalidCodeTimestampForAppId", "reportId", "updateInvalidContactTimestampForUsername", "Companion", "IReporter", "IServerTimeHelper", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final String[] nVW;
  public static final l.a qKn;
  public static c qKq;
  private static b qKr;
  private final ISQLiteDatabase db;
  public final d qKo;
  public final e qKp;
  
  static
  {
    AppMethodBeat.i(320452);
    qKn = new l.a((byte)0);
    nVW = new String[] { MAutoStorage.getCreateSQLs(g.DB_INFO, "PersistentWxaSyncInvalidCodeCmd"), MAutoStorage.getCreateSQLs(h.DB_INFO, "PersistentWxaSyncInvalidContactCmd") };
    AppMethodBeat.o(320452);
  }
  
  public l(ISQLiteDatabase paramISQLiteDatabase)
  {
    AppMethodBeat.i(320437);
    this.db = paramISQLiteDatabase;
    new WxaSyncCmdPersistentStorage.1(this, f.hfK).alive();
    this.qKo = new d(this.db, g.DB_INFO, g.INDEX_CREATE);
    this.qKp = new e(this.db, h.DB_INFO, h.INDEX_CREATE);
    AppMethodBeat.o(320437);
  }
  
  public final long VO(String paramString)
  {
    AppMethodBeat.i(320457);
    paramString = VP(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(320457);
      return -1L;
    }
    long l = paramString.field_timestamp;
    AppMethodBeat.o(320457);
    return l;
  }
  
  public final g VP(String paramString)
  {
    AppMethodBeat.i(320465);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320465);
      return null;
    }
    localObject = new g();
    ((g)localObject).field_appId = paramString;
    i = n.a((CharSequence)paramString, '$', 0, false, 6);
    if (i >= 0)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.WxaSyncCmdPersistentStorage", "getInvalidCodeTimestampForAppId get invalid appId(" + paramString + "), stack:" + android.util.Log.getStackTraceString(new Throwable()));
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(320465);
        throw paramString;
      }
      paramString = paramString.substring(0, i);
      s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      ((g)localObject).field_appId = paramString;
      paramString = (CharSequence)((g)localObject).field_appId;
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(320465);
        return null;
      }
    }
    if (this.qKo.get((IAutoDBItem)localObject, new String[0]))
    {
      AppMethodBeat.o(320465);
      return localObject;
    }
    AppMethodBeat.o(320465);
    return null;
  }
  
  public final boolean VQ(String paramString)
  {
    AppMethodBeat.i(320473);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320473);
      return false;
    }
    localObject = new g();
    ((g)localObject).field_appId = paramString;
    if (this.qKo.get((IAutoDBItem)localObject, new String[0]))
    {
      i = ((g)localObject).field_reportId;
      boolean bool = this.qKo.delete((IAutoDBItem)localObject, new String[0]);
      if (bool)
      {
        paramString = qKr;
        if (paramString != null) {
          paramString.zj(i);
        }
      }
      AppMethodBeat.o(320473);
      return bool;
    }
    AppMethodBeat.o(320473);
    return true;
  }
  
  public final boolean VR(String paramString)
  {
    AppMethodBeat.i(320486);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320486);
      return false;
    }
    localObject = new h();
    ((h)localObject).field_username = paramString;
    if (this.qKp.get((IAutoDBItem)localObject, new String[0]))
    {
      i = ((h)localObject).field_reportId;
      boolean bool = this.qKp.delete((IAutoDBItem)localObject, new String[0]);
      if (bool)
      {
        paramString = qKr;
        if (paramString != null) {
          paramString.zi(i);
        }
      }
      AppMethodBeat.o(320486);
      return bool;
    }
    AppMethodBeat.o(320486);
    return true;
  }
  
  public final int VS(String paramString)
  {
    AppMethodBeat.i(320488);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(320488);
      return -1;
    }
    localObject = new h();
    ((h)localObject).field_username = paramString;
    if (this.qKp.get((IAutoDBItem)localObject, new String[0]))
    {
      i = ((h)localObject).field_reportId;
      AppMethodBeat.o(320488);
      return i;
    }
    AppMethodBeat.o(320488);
    return -1;
  }
  
  public final void b(bm parambm)
  {
    AppMethodBeat.i(320478);
    s.u(parambm, "wxaPkgStorage");
    Object localObject2 = new LinkedList();
    Object localObject1 = this.qKo.getAll();
    if (localObject1 != null) {
      localObject1 = (Closeable)localObject1;
    }
    for (;;)
    {
      try
      {
        localObject4 = (Cursor)localObject1;
        if (((Cursor)localObject4).moveToFirst())
        {
          localObject5 = new g();
          ((g)localObject5).convertFrom((Cursor)localObject4);
          localObject6 = ah.aiuX;
          ((LinkedList)localObject2).add(localObject5);
          if (((Cursor)localObject4).moveToNext()) {
            continue;
          }
        }
        localObject4 = ah.aiuX;
        b.a((Closeable)localObject1, null);
        localObject2 = ((Iterable)localObject2).iterator();
      }
      finally
      {
        Object localObject4;
        Object localObject5;
        long l;
        try
        {
          Object localObject6;
          AppMethodBeat.o(320478);
          throw parambm;
        }
        finally
        {
          b.a((Closeable)localObject1, parambm);
          AppMethodBeat.o(320478);
        }
        int i = 0;
        continue;
        localObject1 = null;
        continue;
        localObject1 = (Long)p.x((Iterable)localObject5);
        if ((localObject1 == null) || (((Long)localObject1).longValue() <= l)) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.WxaSyncCmdPersistentStorage", "evictUselessInvalidCodeCommands >> appId:" + ((g)localObject4).field_appId + ", maxFileLastModified:" + localObject1 + ", invalidUntilTimestamp:" + l);
        VQ(((g)localObject4).field_appId);
        continue;
        AppMethodBeat.o(320478);
      }
      if (((Iterator)localObject2).hasNext())
      {
        localObject4 = (g)((Iterator)localObject2).next();
        if (((g)localObject4).field_timestamp <= 0L) {
          continue;
        }
        localObject1 = parambm.chb();
        l = 1000L * ((g)localObject4).field_timestamp;
        s.s(localObject1, "pkgRecords");
        localObject1 = (Iterable)localObject1;
        localObject5 = (Collection)new ArrayList();
        localObject6 = ((Iterable)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject6).hasNext()) {
            break label338;
          }
          localObject1 = (bh)((Iterator)localObject6).next();
          CharSequence localCharSequence = (CharSequence)((bh)localObject1).field_pkgPath;
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break;
          }
          i = 1;
          if ((i != 0) || (!y.ZC(((bh)localObject1).field_pkgPath))) {
            break label332;
          }
          localObject1 = Long.valueOf(y.bEm(((bh)localObject1).field_pkgPath));
          if (localObject1 != null) {
            ((Collection)localObject5).add(localObject1);
          }
        }
      }
    }
    label332:
    label338:
    return;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentStorage$IReporter;", "", "reportDeleteInvalidCodeCmd", "", "appId", "", "reportId", "", "reportDeleteInvalidContactCmd", "username", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void zi(int paramInt);
    
    public abstract void zj(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentStorage$IServerTimeHelper;", "", "getServerTimeInSecond", "", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract long cev();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentStorage$storageInvalidCode$1", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/PersistentWxaSyncCmdInvalidCode;", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends MAutoStorage<g>
  {
    d(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String[] paramArrayOfString)
    {
      super(paramMAutoDBInfo, "PersistentWxaSyncInvalidCodeCmd", paramArrayOfString);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/appcache/predownload/storage/WxaSyncCmdPersistentStorage$storageInvalidContact$1", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/storage/PersistentWxaSyncCmdInvalidContact;", "data-storage_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends MAutoStorage<h>
  {
    e(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String[] paramArrayOfString)
    {
      super(paramMAutoDBInfo, "PersistentWxaSyncInvalidContactCmd", paramArrayOfString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.storage.l
 * JD-Core Version:    0.7.0.1
 */