package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.axh;
import com.tencent.mm.protocal.protobuf.axi;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "feedId", "", "objectNonceId", "", "feedbackType", "", "subType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends c<axi>
{
  public static final a AyR;
  
  static
  {
    AppMethodBeat.i(165162);
    AyR = new a((byte)0);
    AppMethodBeat.o(165162);
  }
  
  public n(long paramLong, String paramString, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(336450);
    c.a locala = new c.a();
    axh localaxh = new axh();
    localaxh.id = paramLong;
    localaxh.objectNonceId = paramString;
    localaxh.ZIu = 1;
    localaxh.ZIv = 2;
    paramString = bi.ABn;
    localaxh.CJv = bi.a(parambui);
    if (parambui == null) {}
    for (int i = 0;; i = parambui.AJo)
    {
      paramString = z.FrZ;
      localaxh.sessionBuffer = z.p(paramLong, i);
      paramString = bi.ABn;
      bi.a(localaxh.CJv, p.listOf(new r(Integer.valueOf(i), Long.valueOf(paramLong))));
      locala.otE = ((a)localaxh);
      paramString = new axi();
      paramString.setBaseResponse(new kd());
      paramString.getBaseResponse().akjO = new etl();
      locala.otF = ((a)paramString);
      locala.uri = "/cgi-bin/micromsg-bin/finderfeedback";
      locala.funcId = 3912;
      c(locala.bEF());
      Log.i("CgiFinderFeedBack", "[CgiFinderFeedBack] feedId=" + paramLong + " feedbackType=1 subType=2");
      AppMethodBeat.o(336450);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.n
 * JD-Core Version:    0.7.0.1
 */