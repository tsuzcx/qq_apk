package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.protocal.protobuf.efw;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/PrefetchForNonStandardAppUtils;", "", "()V", "collectBatchSyncVersionReqList", "", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "convertFrom", "", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "values", "Landroid/content/ContentValues;", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a kPZ;
  
  static
  {
    AppMethodBeat.i(228043);
    kPZ = new a();
    AppMethodBeat.o(228043);
  }
  
  public static void a(IAutoDBItem paramIAutoDBItem, ContentValues paramContentValues)
  {
    AppMethodBeat.i(228042);
    p.h(paramIAutoDBItem, "$this$convertFrom");
    p.h(paramContentValues, "values");
    Object localObject = paramContentValues.keySet();
    p.g(localObject, "values.keySet()");
    localObject = ((Collection)localObject).toArray(new String[0]);
    if (localObject == null)
    {
      paramIAutoDBItem = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(228042);
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
    AppMethodBeat.o(228042);
  }
  
  public static final List<efw> bwS()
  {
    AppMethodBeat.i(228041);
    Object localObject1 = n.buL();
    if (localObject1 == null)
    {
      localObject1 = (List)v.SXr;
      AppMethodBeat.o(228041);
      return localObject1;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject2 = com.tencent.mm.plugin.appbrand.config.t.lfL;
    localObject2 = com.tencent.mm.plugin.appbrand.config.t.bAf().iterator();
    label290:
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      Object localObject3 = new ad(str, "", 0).toString();
      p.g(localObject3, "PkgQueryKey(appId, \"\", 0).toString()");
      localObject3 = ((bh)localObject1).a((String)localObject3, 0, new String[] { "pkgPath", "version", "versionMd5", "NewMd5" });
      if (localObject3 != null)
      {
        Object localObject4 = (CharSequence)((bd)localObject3).field_pkgPath;
        if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if ((i != 0) || (!s.YS(((bd)localObject3).field_pkgPath))) {
            break label290;
          }
          if (!bj.a(new o(((bd)localObject3).field_pkgPath), new String[] { ((bd)localObject3).field_versionMd5, ((bd)localObject3).field_NewMd5 }, str, "collectBatchSyncVersionReqList")) {
            break;
          }
          localObject4 = new efw();
          com.tencent.mm.plugin.appbrand.config.t localt = com.tencent.mm.plugin.appbrand.config.t.lfL;
          ((efw)localObject4).Mmv = ((String)com.tencent.mm.plugin.appbrand.config.t.bAg().get(str));
          ((efw)localObject4).NfQ = ((bd)localObject3).field_version;
          ((efw)localObject4).NfR = ((bd)localObject3).field_version;
          ((efw)localObject4).xut = null;
          ((efw)localObject4).jfi = str;
          localLinkedList.add(localObject4);
          break;
        }
      }
    }
    localObject1 = (List)localLinkedList;
    AppMethodBeat.o(228041);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.a
 * JD-Core Version:    0.7.0.1
 */