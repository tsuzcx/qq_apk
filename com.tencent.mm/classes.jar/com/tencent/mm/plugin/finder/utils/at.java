package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.cwp;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"toFinder", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoExtendedReading;", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLocation;", "toMega", "plugin-finder_release"})
public final class at
{
  public static final cwp a(bdm parambdm)
  {
    AppMethodBeat.i(292277);
    p.k(parambdm, "$this$toMega");
    cwp localcwp = new cwp();
    localcwp.longitude = parambdm.longitude;
    localcwp.latitude = parambdm.latitude;
    localcwp.city = parambdm.city;
    localcwp.poiName = parambdm.poiName;
    localcwp.KFu = parambdm.KFu;
    localcwp.SOz = parambdm.SOz;
    localcwp.KFw = parambdm.KFw;
    localcwp.province = parambdm.province;
    localcwp.region = parambdm.region;
    localcwp.country = parambdm.country;
    AppMethodBeat.o(292277);
    return localcwp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.at
 * JD-Core Version:    0.7.0.1
 */