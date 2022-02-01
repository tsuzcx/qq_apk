package com.tencent.mm.plugin.finder.order.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.flk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/order/cgi/CgiFinderLiveEcCustomerGetAllTabOrderCnt$Companion;", "", "()V", "getTabCount", "", "tabType", "", "tabTypeList", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public static List<Integer> hi(List<Integer> paramList)
  {
    AppMethodBeat.i(332305);
    s.u(paramList, "tabTypeList");
    Object localObject3 = h.baE().ban().b(at.a.acZX, "");
    Object localObject1 = (a)new alo();
    localObject3 = Util.decodeHexString((String)localObject3);
    try
    {
      ((a)localObject1).parseFrom((byte[])localObject3);
      localObject1 = (alo)localObject1;
      paramList = (Iterable)paramList;
      localObject3 = (Collection)new ArrayList(p.a(paramList, 10));
      Iterator localIterator1 = paramList.iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label246;
        }
        j = ((Number)localIterator1.next()).intValue();
        if (localObject1 != null) {
          break;
        }
        i = 0;
        ((Collection)localObject3).add(Integer.valueOf(i));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j;
        int i;
        Log.printDebugStack("safeParser", "", new Object[] { localException });
        Object localObject2 = null;
        continue;
        paramList = localObject2.ZsH;
        if (paramList == null)
        {
          i = 0;
        }
        else
        {
          Iterator localIterator2 = ((Iterable)paramList).iterator();
          label179:
          if (localIterator2.hasNext())
          {
            paramList = localIterator2.next();
            if (((flk)paramList).tab_type == j)
            {
              i = 1;
              label210:
              if (i == 0) {
                break label231;
              }
            }
          }
          for (;;)
          {
            paramList = (flk)paramList;
            if (paramList != null) {
              break label238;
            }
            i = 0;
            break;
            i = 0;
            break label210;
            label231:
            break label179;
            paramList = null;
          }
          label238:
          i = paramList.abLQ;
        }
      }
      label246:
      paramList = (List)localObject3;
      AppMethodBeat.o(332305);
    }
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.order.cgi.a.a
 * JD-Core Version:    0.7.0.1
 */