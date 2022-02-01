package com.tencent.mm.plugin.finder.extension.reddot;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.br;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotDuplicateChecker;", "", "()V", "RED_DOT_DB_LIMIT", "", "TAG", "", "check", "", "redDotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "reportRedDotExceedLimit", "", "count", "plugin-finder_release"})
public final class d
{
  public static final d tJq;
  
  static
  {
    AppMethodBeat.i(243510);
    tJq = new d();
    AppMethodBeat.o(243510);
  }
  
  public static boolean a(LinkedList<k> paramLinkedList, c paramc)
  {
    int i = 0;
    AppMethodBeat.i(243509);
    p.h(paramLinkedList, "redDotList");
    p.h(paramc, "storage");
    int j = paramLinkedList.size();
    if (j > 100)
    {
      localObject1 = new br();
      ((br)localObject1).jX("1");
      ((br)localObject1).ew(10001L);
      ((br)localObject1).jY(String.valueOf(j));
      ((br)localObject1).bfK();
    }
    Object localObject1 = g.aAh();
    p.g(localObject1, "MMKernel.storage()");
    localObject1 = ((e)localObject1).azQ().get(ar.a.Olv, Boolean.FALSE);
    if (localObject1 == null)
    {
      paramLinkedList = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(243509);
      throw paramLinkedList;
    }
    boolean bool = ((Boolean)localObject1).booleanValue();
    Log.i("Finder.RedDotDuplicateChecker", "[check] isDbDuplicateDeleted=" + bool + ' ');
    if (!bool)
    {
      long l = System.currentTimeMillis();
      localObject1 = new SparseArray();
      Object localObject2 = ((Iterable)paramLinkedList).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        k localk1 = (k)((Iterator)localObject2).next();
        j = localk1.field_ctrInfo.type;
        k localk2 = (k)((SparseArray)localObject1).get(j);
        if (localk2 == null) {
          ((SparseArray)localObject1).put(j, localk1);
        } else if ((localk1.field_time > localk2.field_time) && (!localk1.dbz())) {
          ((SparseArray)localObject1).put(j, localk1);
        }
      }
      paramLinkedList.clear();
      paramc.db.execSQL("FinderRedDotInfo", "delete from FinderRedDotInfo");
      j = ((SparseArray)localObject1).size();
      while (i < j)
      {
        int k = ((SparseArray)localObject1).keyAt(i);
        localObject2 = (k)((SparseArray)localObject1).get(k);
        Log.i("Finder.RedDotDuplicateChecker", " key " + k + ", " + localObject2);
        if (localObject2 != null)
        {
          k.a((k)localObject2, paramc);
          paramLinkedList.add(localObject2);
        }
        i += 1;
      }
      paramLinkedList = g.aAh();
      p.g(paramLinkedList, "MMKernel.storage()");
      paramLinkedList.azQ().set(ar.a.Olv, Boolean.TRUE);
      Log.i("Finder.RedDotDuplicateChecker", "[check] COST=" + (System.currentTimeMillis() - l) + "ms");
      AppMethodBeat.o(243509);
      return true;
    }
    AppMethodBeat.o(243509);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.d
 * JD-Core Version:    0.7.0.1
 */