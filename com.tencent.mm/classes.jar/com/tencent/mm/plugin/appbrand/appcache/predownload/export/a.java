package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.ae;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.protocal.protobuf.epy;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/PrefetchForNonStandardAppUtils;", "", "()V", "collectBatchSyncVersionReqList", "", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "convertFrom", "", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "values", "Landroid/content/ContentValues;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a nKe;
  
  static
  {
    AppMethodBeat.i(269087);
    nKe = new a();
    AppMethodBeat.o(269087);
  }
  
  public static void a(IAutoDBItem paramIAutoDBItem, ContentValues paramContentValues)
  {
    AppMethodBeat.i(269086);
    p.k(paramIAutoDBItem, "$this$convertFrom");
    p.k(paramContentValues, "values");
    Object localObject = paramContentValues.keySet();
    p.j(localObject, "values.keySet()");
    localObject = ((Collection)localObject).toArray(new String[0]);
    if (localObject == null)
    {
      paramIAutoDBItem = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(269086);
      throw paramIAutoDBItem;
    }
    localObject = (String[])localObject;
    MatrixCursor localMatrixCursor = new MatrixCursor((String[])localObject);
    Object[] arrayOfObject = new Object[localObject.length];
    int k = localObject.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      arrayOfObject[i] = paramContentValues.get(localObject[j]);
      j += 1;
      i += 1;
    }
    localMatrixCursor.addRow(arrayOfObject);
    paramIAutoDBItem.convertFrom((Cursor)localMatrixCursor);
    AppMethodBeat.o(269086);
  }
  
  public static final List<epy> bHZ()
  {
    AppMethodBeat.i(269085);
    Object localObject1 = m.bFP();
    if (localObject1 == null)
    {
      localObject1 = (List)v.aaAd;
      AppMethodBeat.o(269085);
      return localObject1;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = com.tencent.mm.plugin.appbrand.config.t.oak;
    localObject2 = com.tencent.mm.plugin.appbrand.config.t.bLv().iterator();
    label288:
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      Object localObject3 = new ae(str, "", 0).toString();
      p.j(localObject3, "PkgQueryKey(appId, \"\", 0).toString()");
      localObject3 = ((bm)localObject1).c((String)localObject3, 0, new String[] { "pkgPath", "version", "versionMd5", "NewMd5" });
      if (localObject3 != null)
      {
        Object localObject4 = (CharSequence)((bh)localObject3).field_pkgPath;
        if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if ((i != 0) || (!u.agG(((bh)localObject3).field_pkgPath))) {
            break label288;
          }
          if (!bq.a(new q(((bh)localObject3).field_pkgPath), new String[] { ((bh)localObject3).field_versionMd5, ((bh)localObject3).field_NewMd5 }, str, "collectBatchSyncVersionReqList")) {
            break;
          }
          localObject4 = new epy();
          com.tencent.mm.plugin.appbrand.config.t localt = com.tencent.mm.plugin.appbrand.config.t.oak;
          ((epy)localObject4).Txp = ((String)com.tencent.mm.plugin.appbrand.config.t.bLw().get(str));
          ((epy)localObject4).Usv = ((bh)localObject3).field_version;
          ((epy)localObject4).Usw = ((bh)localObject3).field_version;
          ((epy)localObject4).CqK = null;
          ((epy)localObject4).lVG = str;
          localLinkedList.add(localObject4);
          break;
        }
      }
    }
    localObject1 = (List)localLinkedList;
    AppMethodBeat.o(269085);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.a
 * JD-Core Version:    0.7.0.1
 */