package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.z;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.protocal.protobuf.bba;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderSvrExptManager;", "", "()V", "TAG", "", "requestInterval", "", "requestTimeMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getHitCache", "exptId", "getSvrExptHitValue", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "setHitCache", "", "value", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
{
  private static int BvC;
  public static final ap Git;
  private static final HashMap<Integer, Integer> Giu;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(333015);
    Git = new ap();
    TAG = "Finder.FinderSvrExptManager";
    Giu = new HashMap();
    BvC = 300;
    AppMethodBeat.o(333015);
  }
  
  private static final ah a(ca.a parama1, int paramInt, ca.a parama2, b.a parama)
  {
    AppMethodBeat.i(333010);
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama1 = (bba)parama.ott;
      if (parama1 == null)
      {
        i = 300;
        BvC = i;
        parama1 = (bba)parama.ott;
        if (parama1 != null)
        {
          parama1 = parama1.ZLR;
          if (parama1 != null)
          {
            Iterator localIterator = ((Iterable)parama1).iterator();
            label73:
            if (!localIterator.hasNext()) {
              break label266;
            }
            parama1 = localIterator.next();
            if (((bws)parama1).expt_id != paramInt) {
              break label260;
            }
            i = 1;
            label105:
            if (i == 0) {
              break label264;
            }
            label110:
            parama1 = (bws)parama1;
            if (parama1 != null)
            {
              i = parama1.hit;
              Log.i(TAG, "setHitCache, exptId:" + paramInt + ", value:" + i);
              if (paramInt == 1) {
                h.baE().ban().set(at.a.ades, Integer.valueOf(i));
              }
              if (parama2 != null) {
                parama2.onCallback(Integer.valueOf(parama1.hit));
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (((parama.errType == 0) && (parama.errCode == 0)) || (parama.errType == 4)) {
        ((Map)Giu).put(Integer.valueOf(paramInt), Integer.valueOf(cn.getSyncServerTimeSecond()));
      }
      parama1 = ah.aiuX;
      AppMethodBeat.o(333010);
      return parama1;
      i = parama1.ZLS;
      break;
      label260:
      i = 0;
      break label105;
      label264:
      break label73;
      label266:
      parama1 = null;
      break label110;
      if (parama1 != null) {
        parama1.onCallback(Integer.valueOf(parama.errCode));
      }
    }
  }
  
  public static int b(ca.a<Integer> parama)
  {
    AppMethodBeat.i(333002);
    Integer localInteger2 = (Integer)Giu.get(Integer.valueOf(1));
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    int i = ((Number)localInteger1).intValue();
    if (cn.getSyncServerTimeSecond() - i > BvC) {
      new z(p.listOf(Integer.valueOf(1))).bFJ().g(new ap..ExternalSyntheticLambda0(null, 1, parama));
    }
    i = h.baE().ban().getInt(at.a.ades, 0);
    AppMethodBeat.o(333002);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ap
 * JD-Core Version:    0.7.0.1
 */