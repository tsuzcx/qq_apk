package com.tencent.mm.plugin.finder.nearby.newlivesquare;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.j;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.k;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.l;
import com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.m;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bui;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/NewEntranceUtils;", "", "()V", "autoCheckStyleAndAppendToList", "", "targetList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderLiveStreamCard;", "item", "Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/convertdata/SpecialColumnListConvertData;", "reportContextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g ENe;
  
  static
  {
    AppMethodBeat.i(340252);
    ENe = new g();
    AppMethodBeat.o(340252);
  }
  
  public static boolean a(List<cc> paramList, bmz parambmz, m paramm, bui parambui)
  {
    AppMethodBeat.i(340246);
    s.u(paramList, "targetList");
    s.u(parambmz, "card");
    s.u(paramm, "item");
    switch (parambmz.style)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                AppMethodBeat.o(340246);
                return false;
                parambmz = parambmz.ZVG;
              } while (parambmz == null);
              paramList.add(new k(parambmz, paramm.ENs));
              AppMethodBeat.o(340246);
              return true;
              parambmz = parambmz.ENu;
            } while (parambmz == null);
            paramList.add(new com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.convertdata.g(parambmz, paramm.ENs));
            AppMethodBeat.o(340246);
            return true;
            localObject1 = parambmz.ZIo;
          } while (localObject1 == null);
          localObject2 = d.FND;
          localObject1 = p.listOf(localObject1);
          localObject2 = av.GiL;
          parambui = (FinderItem)p.oL(d.a.a((List)localObject1, av.Ui(0), parambui));
        } while (parambui == null);
        paramList.add(new j(parambui, paramm.ENs, parambmz.ZVJ));
        AppMethodBeat.o(340246);
        return true;
        localObject1 = parambmz.ZIo;
      } while (localObject1 == null);
      Object localObject2 = d.FND;
      localObject1 = p.listOf(localObject1);
      localObject2 = av.GiL;
      parambui = (FinderItem)p.oL(d.a.a((List)localObject1, av.Ui(0), parambui));
    } while (parambui == null);
    paramm = paramm.ENs;
    Object localObject1 = parambmz.ZVH;
    s.s(localObject1, "card.relate_living");
    paramList.add(new l(parambui, paramm, (List)localObject1, parambmz.ZVK, parambmz.ZVJ));
    AppMethodBeat.o(340246);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.g
 * JD-Core Version:    0.7.0.1
 */