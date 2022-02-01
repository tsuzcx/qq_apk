package com.tencent.mm.plugin.finder.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.af;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.data.w;
import com.tencent.mm.plugin.finder.storage.y;
import com.tencent.mm.plugin.finder.storage.y.a;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.bpm;
import com.tencent.mm.protocal.protobuf.bsg;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/PagePoiItem;", "Lcom/tencent/mm/plugin/finder/storage/data/PageItem;", "source", "Lcom/tencent/mm/protocal/protobuf/FinderFPItem;", "(Lcom/tencent/mm/protocal/protobuf/FinderFPItem;)V", "type", "", "finderPoiInfo", "Lcom/tencent/mm/protocal/protobuf/FinderPoiInfo;", "(ILcom/tencent/mm/protocal/protobuf/FinderPoiInfo;)V", "extract", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "targetDataType", "toRVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.finder.storage.data.s
{
  public f(axb paramaxb)
  {
    super(paramaxb);
    AppMethodBeat.i(348192);
    AppMethodBeat.o(348192);
  }
  
  public f(bsg parambsg)
  {
    AppMethodBeat.i(348207);
    axb localaxb = this.FNr;
    localaxb.type = 262144;
    localaxb.ZIs = parambsg;
    parambsg = w.FNw;
    localaxb.dataType = w.fac();
    AppMethodBeat.o(348207);
  }
  
  public final cc eIE()
  {
    AppMethodBeat.i(348225);
    Object localObject1 = w.FNw;
    localObject1 = this.FNr;
    kotlin.g.b.s.u(localObject1, "data");
    int i;
    Object localObject2;
    if (((axb)localObject1).dataType == w.fac())
    {
      i = 1;
      if (i == 0) {
        break label102;
      }
      localObject1 = ((axb)localObject1).ZIs;
      if (localObject1 == null) {
        break label102;
      }
      localObject2 = af.AWY;
      kotlin.g.b.s.u(localObject1, "poiInfo");
      localObject2 = new bpm();
      y.a locala = y.FLJ;
      ((bpm)localObject2).dataType = y.eZy();
      ((bpm)localObject2).ZIs = ((bsg)localObject1);
    }
    label102:
    for (localObject1 = af.a((bpm)localObject2);; localObject1 = null)
    {
      localObject1 = (cc)localObject1;
      AppMethodBeat.o(348225);
      return localObject1;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.f
 * JD-Core Version:    0.7.0.1
 */