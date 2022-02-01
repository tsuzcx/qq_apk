package com.tencent.mm.plugin.appbrand.appcache.predownload.export;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.protocal.protobuf.flb;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/export/PrefetchForNonStandardAppUtils;", "", "()V", "FORCE_SYNC_APPID_WHITE_LIST", "", "", "[Ljava/lang/String;", "collectBatchSyncVersionReqList", "", "Lcom/tencent/mm/protocal/protobuf/SyncVersionSingleReqInfo;", "convertFrom", "", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "values", "Landroid/content/ContentValues;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a qJN;
  private static final String[] uxw;
  
  static
  {
    AppMethodBeat.i(320552);
    qJN = new a();
    uxw = new String[] { "wx1975249228c5cea8", "wx6509e7dc7bdc968d" };
    AppMethodBeat.o(320552);
  }
  
  public static void a(IAutoDBItem paramIAutoDBItem, ContentValues paramContentValues)
  {
    AppMethodBeat.i(320546);
    s.u(paramIAutoDBItem, "<this>");
    s.u(paramContentValues, "values");
    Object localObject = paramContentValues.keySet();
    s.s(localObject, "values.keySet()");
    localObject = ((Collection)localObject).toArray(new String[0]);
    if (localObject == null)
    {
      paramIAutoDBItem = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(320546);
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
    AppMethodBeat.o(320546);
  }
  
  public static final List<flb> chv()
  {
    AppMethodBeat.i(320538);
    bm localbm = n.cfm();
    if (localbm == null)
    {
      localObject1 = (List)ab.aivy;
      AppMethodBeat.o(320538);
      return localObject1;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = w.raK;
    Iterator localIterator = w.ckS().iterator();
    Object localObject3;
    String str;
    Object localObject4;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label371;
      }
      localObject3 = (String)localIterator.next();
      localObject1 = w.raK;
      str = (String)w.ckT().get(localObject3);
      try
      {
        bool = ((j)n.ag(j.class)).WI(str);
        if (!bool)
        {
          localObject1 = new af((String)localObject3, "", 0).toString();
          s.s(localObject1, "PkgQueryKey(appId, \"\", 0).toString()");
          localObject1 = localbm.c((String)localObject1, 0, new String[] { "pkgPath", "version", "versionMd5", "NewMd5" });
          if (localObject1 == null)
          {
            localObject1 = null;
            if ((localObject1 != null) || (!k.contains(uxw, localObject3))) {
              continue;
            }
            localObject1 = new flb();
            ((flb)localObject1).aaLU = str;
            ((flb)localObject1).oOI = ((String)localObject3);
            localObject3 = ah.aiuX;
            localLinkedList.add(localObject1);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool = false;
        }
        localObject4 = (CharSequence)localException.field_pkgPath;
        if (localObject4 == null) {
          break label244;
        }
      }
    }
    if (((CharSequence)localObject4).length() == 0) {}
    label244:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (y.ZC(localException.field_pkgPath))) {
        if (bq.a(new u(localException.field_pkgPath), new String[] { localException.field_versionMd5, localException.field_NewMd5 }, (String)localObject3, "collectBatchSyncVersionReqList"))
        {
          localObject4 = new flb();
          ((flb)localObject4).aaLU = str;
          ((flb)localObject4).abLC = localException.field_version;
          ((flb)localObject4).abLD = localException.field_version;
          ((flb)localObject4).IcT = null;
          ((flb)localObject4).oOI = ((String)localObject3);
          localObject2 = ah.aiuX;
          localLinkedList.add(localObject4);
        }
      }
      localObject2 = ah.aiuX;
      break;
    }
    label371:
    Object localObject2 = (List)localLinkedList;
    AppMethodBeat.o(320538);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.export.a
 * JD-Core Version:    0.7.0.1
 */