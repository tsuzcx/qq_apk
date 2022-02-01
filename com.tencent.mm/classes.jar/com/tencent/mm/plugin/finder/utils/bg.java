package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.protocal.protobuf.dnu;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"toFinder", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoExtendedReading;", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLocation;", "toMega", "plugin-finder_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class bg
{
  public static final dnl a(axa paramaxa)
  {
    AppMethodBeat.i(333041);
    s.u(paramaxa, "<this>");
    dnl localdnl = new dnl();
    localdnl.link = paramaxa.link;
    localdnl.title = paramaxa.title;
    AppMethodBeat.o(333041);
    return localdnl;
  }
  
  public static final dnu b(boi paramboi)
  {
    AppMethodBeat.i(333035);
    s.u(paramboi, "<this>");
    dnu localdnu = new dnu();
    localdnu.longitude = paramboi.longitude;
    localdnu.latitude = paramboi.latitude;
    localdnu.city = paramboi.city;
    localdnu.poiName = paramboi.poiName;
    localdnu.ReU = paramboi.ReU;
    localdnu.ZWG = paramboi.ZWG;
    localdnu.ReW = paramboi.ReW;
    localdnu.province = paramboi.province;
    localdnu.region = paramboi.region;
    localdnu.country = paramboi.country;
    AppMethodBeat.o(333035);
    return localdnu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.bg
 * JD-Core Version:    0.7.0.1
 */