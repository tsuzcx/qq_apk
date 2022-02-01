package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "feedId", "", "objectNonceId", "", "feedbackType", "", "subType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "Companion", "plugin-finder_release"})
public final class e
  extends w<Object>
{
  public static final a rHM;
  
  static
  {
    AppMethodBeat.i(165162);
    rHM = new a((byte)0);
    AppMethodBeat.o(165162);
  }
  
  public e(long paramLong, String paramString, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201022);
    b.a locala = new b.a();
    amv localamv = new amv();
    localamv.id = paramLong;
    localamv.objectNonceId = paramString;
    localamv.Gmk = 1;
    localamv.Gml = 2;
    paramString = v.rIR;
    localamv.Glv = v.a(paramaqy);
    paramString = h.soM;
    if (paramaqy != null) {}
    for (int i = paramaqy.rTD;; i = 0)
    {
      localamv.sessionBuffer = h.I(paramLong, i);
      locala.c((a)localamv);
      paramString = new art();
      paramString.setBaseResponse(new BaseResponse());
      paramString.getBaseResponse().ErrMsg = new cwt();
      locala.d((a)paramString);
      locala.Dl("/cgi-bin/micromsg-bin/finderfeedback");
      locala.oP(3912);
      c(locala.aDC());
      ad.i("CgiFinderFeedBack", "[CgiFinderFeedBack] feedId=" + paramLong + " feedbackType=1 subType=2");
      AppMethodBeat.o(201022);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.e
 * JD-Core Version:    0.7.0.1
 */