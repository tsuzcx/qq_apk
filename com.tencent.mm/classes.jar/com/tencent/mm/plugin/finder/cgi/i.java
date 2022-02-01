package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "feedId", "", "objectNonceId", "", "feedbackType", "", "subType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class i
  extends an<aqy>
{
  public static final a tsU;
  
  static
  {
    AppMethodBeat.i(165162);
    tsU = new a((byte)0);
    AppMethodBeat.o(165162);
  }
  
  public i(long paramLong, String paramString, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242216);
    d.a locala = new d.a();
    aqx localaqx = new aqx();
    localaqx.id = paramLong;
    localaqx.objectNonceId = paramString;
    localaqx.LCJ = 1;
    localaqx.LCK = 2;
    paramString = am.tuw;
    localaqx.uli = am.a(parambbn);
    paramString = k.vfA;
    if (parambbn != null) {}
    for (int i = parambbn.tCE;; i = 0)
    {
      localaqx.sessionBuffer = k.G(paramLong, i);
      locala.c((a)localaqx);
      paramString = new aqy();
      paramString.setBaseResponse(new BaseResponse());
      paramString.getBaseResponse().ErrMsg = new dqi();
      locala.d((a)paramString);
      locala.MB("/cgi-bin/micromsg-bin/finderfeedback");
      locala.sG(3912);
      c(locala.aXF());
      Log.i("CgiFinderFeedBack", "[CgiFinderFeedBack] feedId=" + paramLong + " feedbackType=1 subType=2");
      AppMethodBeat.o(242216);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.i
 * JD-Core Version:    0.7.0.1
 */