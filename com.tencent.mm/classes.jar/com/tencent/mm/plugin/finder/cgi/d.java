package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "feedId", "", "objectNonceId", "", "feedbackType", "", "subType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "Companion", "plugin-finder_release"})
public final class d
  extends r<Object>
{
  public static final d.a qWO;
  
  static
  {
    AppMethodBeat.i(165162);
    qWO = new d.a((byte)0);
    AppMethodBeat.o(165162);
  }
  
  public d(long paramLong, String paramString, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201103);
    b.a locala = new b.a();
    ajx localajx = new ajx();
    localajx.id = paramLong;
    localajx.objectNonceId = paramString;
    localajx.EEu = 1;
    localajx.EEv = 2;
    paramString = q.qXH;
    localajx.EDL = q.a(paramanm);
    paramString = com.tencent.mm.plugin.finder.report.d.rxr;
    if (paramanm != null) {}
    for (int i = paramanm.rfR;; i = 0)
    {
      localajx.sessionBuffer = com.tencent.mm.plugin.finder.report.d.G(paramLong, i);
      locala.c((a)localajx);
      paramString = new aoe();
      paramString.setBaseResponse(new BaseResponse());
      paramString.getBaseResponse().ErrMsg = new crm();
      locala.d((a)paramString);
      locala.Am("/cgi-bin/micromsg-bin/finderfeedback");
      locala.op(3912);
      c(locala.aAz());
      ac.i("CgiFinderFeedBack", "[CgiFinderFeedBack] feedId=" + paramLong + " feedbackType=1 subType=2");
      AppMethodBeat.o(201103);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.d
 * JD-Core Version:    0.7.0.1
 */