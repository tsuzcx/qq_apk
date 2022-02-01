package com.tencent.mm.plugin.finder.extension.reddot;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.di;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotDuplicateChecker;", "", "()V", "RED_DOT_DB_LIMIT", "", "TAG", "", "check", "", "redDotList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "storage", "Lcom/tencent/mm/plugin/finder/extension/reddot/FinderRedDotCtrInfoStorage;", "reportRedDotExceedLimit", "", "count", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g AQm;
  
  static
  {
    AppMethodBeat.i(366784);
    AQm = new g();
    AppMethodBeat.o(366784);
  }
  
  public static boolean a(LinkedList<p> paramLinkedList, f paramf)
  {
    AppMethodBeat.i(366777);
    s.u(paramLinkedList, "redDotList");
    s.u(paramf, "storage");
    int i = paramLinkedList.size();
    if (i > 100)
    {
      localObject1 = new di();
      ((di)localObject1).nq("1");
      ((di)localObject1).izr = 10001L;
      ((di)localObject1).izs = ((di)localObject1).F("exceptionValue", String.valueOf(i), true);
      ((di)localObject1).bMH();
    }
    Object localObject1 = h.baE().ban().get(at.a.adcH, Boolean.FALSE);
    if (localObject1 == null)
    {
      paramLinkedList = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(366777);
      throw paramLinkedList;
    }
    boolean bool = ((Boolean)localObject1).booleanValue();
    Log.i("Finder.RedDotDuplicateChecker", "[check] isDbDuplicateDeleted=" + bool + ' ');
    long l;
    Object localObject2;
    int k;
    if (!bool)
    {
      l = System.currentTimeMillis();
      localObject1 = new SparseArray();
      localObject2 = ((Iterable)paramLinkedList).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        p localp1 = (p)((Iterator)localObject2).next();
        i = localp1.field_ctrInfo.type;
        p localp2 = (p)((SparseArray)localObject1).get(i);
        if (localp2 == null) {
          ((SparseArray)localObject1).put(i, localp1);
        } else if ((localp1.field_time > localp2.field_time) && (!localp1.eax())) {
          ((SparseArray)localObject1).put(i, localp1);
        }
      }
      paramLinkedList.clear();
      paramf.db.execSQL("FinderRedDotInfo", "delete from FinderRedDotInfo");
      i = 0;
      k = ((SparseArray)localObject1).size();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      i = ((SparseArray)localObject1).keyAt(i);
      localObject2 = (p)((SparseArray)localObject1).get(i);
      Log.i("Finder.RedDotDuplicateChecker", " key " + i + ", " + localObject2);
      if (localObject2 != null)
      {
        p.a((p)localObject2, (MAutoStorage)paramf);
        paramLinkedList.add(localObject2);
      }
      if (j >= k)
      {
        h.baE().ban().set(at.a.adcH, Boolean.TRUE);
        Log.i("Finder.RedDotDuplicateChecker", "[check] COST=" + (System.currentTimeMillis() - l) + "ms");
        AppMethodBeat.o(366777);
        return true;
        AppMethodBeat.o(366777);
        return false;
      }
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.g
 * JD-Core Version:    0.7.0.1
 */