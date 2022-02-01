package com.tencent.mm.plugin.appbrand.appcache.predownload.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.c;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStatStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/predownload/statistitcs/PredownloadGetCodeStats;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "checkReportOnLocalPkgFound", "", "appLaunchInstanceId", "", "appId", "version", "", "packageType", "packageKey", "checkReportOnLocalPkgFoundInternal", "delete", "", "pruneOutdatedRecords", "setSource", "source", "reportId", "print", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<b>
{
  public static final String[] nVW;
  public static final a.a qKe;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(50208);
    qKe = new a.a((byte)0);
    nVW = new String[] { MAutoStorage.getCreateSQLs(b.nVV, "AppBrandWxaPkgPreDownloadStatistics2"), "DROP TABLE IF EXISTS AppBrandWxaPkgPreDownloadStatistics" };
    AppMethodBeat.o(50208);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.nVV, "AppBrandWxaPkgPreDownloadStatistics2", b.INDEX_CREATE);
    AppMethodBeat.i(50207);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(50207);
  }
  
  public static String a(b paramb)
  {
    AppMethodBeat.i(320603);
    paramb = "appId:" + paramb.field_appId + ", version:" + paramb.field_version + ", packageType:" + paramb.field_packageType + ", packageKey:" + paramb.field_packageKey + ", source:" + paramb.field_source + ", reportId:" + paramb.field_reportId;
    AppMethodBeat.o(320603);
    return paramb;
  }
  
  public final void chz()
  {
    AppMethodBeat.i(50204);
    localCloseable = (Closeable)getAll();
    for (;;)
    {
      try
      {
        localObject1 = (Cursor)localCloseable;
        if ((localObject1 == null) || (!((Cursor)localObject1).moveToFirst()))
        {
          localObject1 = ah.aiuX;
          kotlin.f.b.a(localCloseable, null);
          AppMethodBeat.o(50204);
          return;
        }
        localObject2 = new LinkedList();
        localb = new b();
        localb.convertFrom((Cursor)localObject1);
        localObject4 = ah.aiuX;
        ((LinkedList)localObject2).add(localb);
        if (((Cursor)localObject1).moveToNext()) {
          continue;
        }
        localObject2 = ((Iterable)localObject2).iterator();
      }
      finally
      {
        b localb;
        Object localObject4;
        try
        {
          Object localObject1;
          Object localObject2;
          AppMethodBeat.o(50204);
          throw localThrowable;
        }
        finally
        {
          kotlin.f.b.a(localCloseable, localThrowable);
          AppMethodBeat.o(50204);
        }
        bh localbh = ((bm)localObject4).b(localThrowable.toString(), localb.field_version, 0, new String[] { "pkgPath" });
        continue;
        int i = 0;
        continue;
        i = 1;
        if (i == 0) {
          continue;
        }
        continue;
      }
      if (((Iterator)localObject2).hasNext())
      {
        localb = (b)((Iterator)localObject2).next();
        localObject1 = new af(localb.field_appId, localb.field_packageKey, localb.field_packageType);
        localObject4 = n.cfm();
        if (localObject4 != null) {
          continue;
        }
        localObject1 = null;
        if (localObject1 != null)
        {
          localObject1 = (CharSequence)((bh)localObject1).field_pkgPath;
          if (localObject1 == null) {
            continue;
          }
          if (((CharSequence)localObject1).length() != 0) {
            continue;
          }
          continue;
        }
        super.delete((IAutoDBItem)localb, new String[0]);
      }
    }
  }
  
  public final boolean iP(String paramString)
  {
    AppMethodBeat.i(50203);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(50203);
      return false;
    }
    if (this.db.delete("AppBrandWxaPkgPreDownloadStatistics2", "appId=?", new String[] { paramString }) > 0)
    {
      AppMethodBeat.o(50203);
      return true;
    }
    AppMethodBeat.o(50203);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public b(a parama, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.d.a
 * JD-Core Version:    0.7.0.1
 */