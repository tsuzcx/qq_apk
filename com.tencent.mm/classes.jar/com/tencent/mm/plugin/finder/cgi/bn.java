package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/MegaVideoBaseRequestFactory;", "", "()V", "create", "Lcom/tencent/mm/protocal/protobuf/MegaVideoBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bn
{
  public static final bn ABz;
  
  static
  {
    AppMethodBeat.i(336443);
    ABz = new bn();
    AppMethodBeat.o(336443);
  }
  
  public static dnf b(bui parambui)
  {
    AppMethodBeat.i(336430);
    dnf localdnf = new dnf();
    localdnf.aaUA = h.baE().ban().getInt(at.a.adcY, 0);
    if (parambui != null) {
      localdnf.scene = parambui.AJo;
    }
    AppMethodBeat.o(336430);
    return localdnf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bn
 * JD-Core Version:    0.7.0.1
 */