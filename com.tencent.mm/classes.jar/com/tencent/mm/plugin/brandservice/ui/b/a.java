package com.tencent.mm.plugin.brandservice.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.p.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.f.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.f.c;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.protocal.protobuf.qb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ab;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/util/BizTLUtil;", "", "()V", "TAG", "", "getBizCommItemContext", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortItemContext;", "item", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport$ReportBrandExposeItem;", "posInCard", "", "index", "isClickCard", "", "Ljava/util/LinkedList;", "bizTimeLineInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "sessionItemCache", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport$ReportHashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "getBizRecFeedReqContext", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortContext;", "list", "", "recList", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a vYy;
  
  static
  {
    AppMethodBeat.i(301647);
    vYy = new a();
    AppMethodBeat.o(301647);
  }
  
  public static qa a(List<? extends ab> paramList1, List<? extends ab> paramList2, f.c<String, f.b> paramc)
  {
    AppMethodBeat.i(301645);
    s.u(paramList1, "list");
    s.u(paramList2, "recList");
    s.u(paramc, "sessionItemCache");
    qa localqa = new qa();
    Object localObject1 = com.tencent.mm.model.p.ojc;
    int j = k.qv(p.a.atj().decodeInt("BizmsgContextCnt", 20), 50);
    if (j < 0)
    {
      AppMethodBeat.o(301645);
      return localqa;
    }
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      try
      {
        localObject2 = (Map)paramc;
        localObject1 = new LinkedHashMap();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        if (((f.b)((Map.Entry)localObject3).getValue()).YTH != 1) {
          break label187;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        ((LinkedHashMap)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
        continue;
        AppMethodBeat.o(301645);
      }
      catch (Exception paramList1)
      {
        Log.e("MicroMsg.BizTLUtil", s.X("getBizRecFeedReqContext ex ", paramList1.getMessage()));
      }
      return localqa;
      label187:
      i = 0;
    }
    localObject1 = ((Iterable)((Map)localObject1).values()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (f.b)((Iterator)localObject1).next();
      localObject3 = localqa.YUw;
      s.s(localObject2, "item");
      ((LinkedList)localObject3).add(a((f.b)localObject2, ((f.b)localObject2).YTD, 0, false));
    }
    int k = localqa.YUw.size();
    int i = j - k;
    Log.d("MicroMsg.BizTLUtil", s.X("getBizRecFeedReqContext click size = ", Integer.valueOf(k)));
    if (i <= 0)
    {
      AppMethodBeat.o(301645);
      return localqa;
    }
    if (((Collection)paramList2).isEmpty())
    {
      k = 1;
      label327:
      j = i;
      if (k == 0)
      {
        paramList2 = ((Iterable)kotlin.a.p.oI(paramList2)).iterator();
        label348:
        j = i;
        if (paramList2.hasNext())
        {
          localObject1 = (ab)paramList2.next();
          localObject2 = (f.b)paramc.get(s.X(((ab)localObject1).getId(), "_0"));
          if ((localObject2 == null) || (((f.b)localObject2).YUb != 1)) {
            break label652;
          }
          j = 1;
          label407:
          if (j == 0) {
            break label658;
          }
          localObject1 = a((ab)localObject1, paramc, 0, false);
          localqa.YUw.addAll((Collection)localObject1);
          j = i - 1;
          i = j;
          if (j > 0) {
            break label658;
          }
          AppMethodBeat.o(301645);
          return localqa;
        }
      }
      Log.d("MicroMsg.BizTLUtil", s.X("getBizRecFeedReqContext add rec size = ", Integer.valueOf(localqa.YUw.size())));
      if (j <= 0)
      {
        AppMethodBeat.o(301645);
        return localqa;
      }
      if (!((Collection)paramList1).isEmpty()) {
        break label661;
      }
      i = 1;
      label505:
      if (i == 0) {
        paramList1 = ((Iterable)kotlin.a.p.oI(paramList1)).iterator();
      }
    }
    for (;;)
    {
      if (paramList1.hasNext())
      {
        paramList2 = (ab)paramList1.next();
        localObject1 = (f.b)paramc.get(s.X(paramList2.getId(), "_0"));
        if ((localObject1 == null) || (((f.b)localObject1).YUb != 1)) {
          break label666;
        }
      }
      label652:
      label658:
      label661:
      label666:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label671;
        }
        paramList2 = a(paramList2, paramc, 0, false);
        localqa.YUw.addAll((Collection)paramList2);
        j -= 1;
        i = j;
        if (j > 0) {
          break label674;
        }
        AppMethodBeat.o(301645);
        return localqa;
        Log.d("MicroMsg.BizTLUtil", s.X("getBizRecFeedReqContext all size = ", Integer.valueOf(localqa.YUw.size())));
        break;
        k = 0;
        break label327;
        j = 0;
        break label407;
        break label348;
        i = 0;
        break label505;
      }
      label671:
      i = j;
      label674:
      j = i;
    }
  }
  
  private static qb a(f.b paramb, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(301635);
    s.u(paramb, "item");
    qb localqb = new qb();
    Object localObject1;
    if ((paramBoolean) && (paramInt1 == paramInt2))
    {
      paramBoolean = true;
      localqb.YUA = paramBoolean;
      localqb.YUz = new ael();
      localqb.YUz.Zms = paramb.nSr;
      localqb.YUz.Zmt = ((int)paramb.hCz);
      localObject1 = (Collection)paramb.YTo;
      if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
        break label277;
      }
      paramInt1 = 1;
      label103:
      if (paramInt1 == 0)
      {
        localObject1 = localqb.YUz;
        Object localObject2 = paramb.YTo.get(0);
        s.s(localObject2, "item.idx_list[0]");
        ((ael)localObject1).Zmu = ((Number)localObject2).intValue();
      }
      localqb.YUz.tNW = paramb.tNW;
      localqb.YUz.DVu = paramb.DVu;
      localObject1 = localqb.YUz;
      if (paramb.YTH != 1) {
        break label282;
      }
      paramBoolean = true;
      label186:
      ((ael)localObject1).Zmv = paramBoolean;
      localObject1 = localqb.YUz;
      if (paramb.YTJ != 1) {
        break label287;
      }
    }
    label277:
    label282:
    label287:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((ael)localObject1).Zmw = paramBoolean;
      localqb.YUz.YTW = paramb.YTW;
      localqb.YUz.time = paramb.YTx;
      localqb.YUz.pos = paramb.pos;
      localqb.YUz.style = paramb.style;
      AppMethodBeat.o(301635);
      return localqb;
      paramBoolean = false;
      break;
      paramInt1 = 0;
      break label103;
      paramBoolean = false;
      break label186;
    }
  }
  
  public static final LinkedList<qb> a(ab paramab, f.c<String, f.b> paramc, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(301632);
    s.u(paramab, "bizTimeLineInfo");
    s.u(paramc, "sessionItemCache");
    LinkedList localLinkedList = new LinkedList();
    if (paramab.field_isRead != 1)
    {
      AppMethodBeat.o(301632);
      return localLinkedList;
    }
    int i = 0;
    for (;;)
    {
      f.b localb = (f.b)paramc.get(paramab.getId() + '_' + i);
      if (localb != null)
      {
        localLinkedList.add(a(localb, paramInt, i, paramBoolean));
        if (i != 10) {}
      }
      else
      {
        AppMethodBeat.o(301632);
        return localLinkedList;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.b.a
 * JD-Core Version:    0.7.0.1
 */