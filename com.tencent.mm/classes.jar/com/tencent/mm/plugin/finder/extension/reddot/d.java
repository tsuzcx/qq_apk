package com.tencent.mm.plugin.finder.extension.reddot;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ch;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotDuplicateChecker;", "", "()V", "RED_DOT_DB_LIMIT", "", "TAG", "", "check", "", "redDotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "reportRedDotExceedLimit", "", "count", "plugin-finder_release"})
public final class d
{
  public static final d xsB;
  
  static
  {
    AppMethodBeat.i(284102);
    xsB = new d();
    AppMethodBeat.o(284102);
  }
  
  public static boolean a(LinkedList<l> paramLinkedList, c paramc)
  {
    int i = 0;
    AppMethodBeat.i(284101);
    p.k(paramLinkedList, "redDotList");
    p.k(paramc, "storage");
    int j = paramLinkedList.size();
    if (j > 100)
    {
      localObject1 = new ch();
      ((ch)localObject1).mh("1");
      ((ch)localObject1).fk(10001L);
      ((ch)localObject1).mi(String.valueOf(j));
      ((ch)localObject1).bpa();
    }
    Object localObject1 = h.aHG();
    p.j(localObject1, "MMKernel.storage()");
    localObject1 = ((f)localObject1).aHp().get(ar.a.VAq, Boolean.FALSE);
    if (localObject1 == null)
    {
      paramLinkedList = new t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(284101);
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
        l locall1 = (l)((Iterator)localObject2).next();
        j = locall1.field_ctrInfo.type;
        l locall2 = (l)((SparseArray)localObject1).get(j);
        if (locall2 == null) {
          ((SparseArray)localObject1).put(j, locall1);
        } else if ((locall1.field_time > locall2.field_time) && (!locall1.drI())) {
          ((SparseArray)localObject1).put(j, locall1);
        }
      }
      paramLinkedList.clear();
      paramc.db.execSQL("FinderRedDotInfo", "delete from FinderRedDotInfo");
      j = ((SparseArray)localObject1).size();
      while (i < j)
      {
        int k = ((SparseArray)localObject1).keyAt(i);
        localObject2 = (l)((SparseArray)localObject1).get(k);
        Log.i("Finder.RedDotDuplicateChecker", " key " + k + ", " + localObject2);
        if (localObject2 != null)
        {
          l.a((l)localObject2, paramc);
          paramLinkedList.add(localObject2);
        }
        i += 1;
      }
      paramLinkedList = h.aHG();
      p.j(paramLinkedList, "MMKernel.storage()");
      paramLinkedList.aHp().set(ar.a.VAq, Boolean.TRUE);
      Log.i("Finder.RedDotDuplicateChecker", "[check] COST=" + (System.currentTimeMillis() - l) + "ms");
      AppMethodBeat.o(284101);
      return true;
    }
    AppMethodBeat.o(284101);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.d
 * JD-Core Version:    0.7.0.1
 */