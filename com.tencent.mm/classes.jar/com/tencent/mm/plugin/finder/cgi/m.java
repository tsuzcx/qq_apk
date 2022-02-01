package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "feedId", "", "objectNonceId", "", "feedbackType", "", "subType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class m
  extends c<asu>
{
  public static final a xaJ;
  
  static
  {
    AppMethodBeat.i(165162);
    xaJ = new a((byte)0);
    AppMethodBeat.o(165162);
  }
  
  public m(long paramLong, String paramString, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(291789);
    d.a locala = new d.a();
    ast localast = new ast();
    localast.id = paramLong;
    localast.objectNonceId = paramString;
    localast.SFV = 1;
    localast.SFW = 2;
    paramString = ao.xcj;
    localast.yjp = ao.a(parambid);
    if (parambid != null) {}
    for (int i = parambid.xkX;; i = 0)
    {
      paramString = n.zWF;
      localast.sessionBuffer = n.N(paramLong, i);
      paramString = ao.xcj;
      ao.a(localast.yjp, j.listOf(new o(Integer.valueOf(i), Long.valueOf(paramLong))));
      locala.c((a)localast);
      paramString = new asu();
      paramString.setBaseResponse(new jh());
      paramString.getBaseResponse().Tef = new eaf();
      locala.d((a)paramString);
      locala.TW("/cgi-bin/micromsg-bin/finderfeedback");
      locala.vD(3912);
      c(locala.bgN());
      Log.i("CgiFinderFeedBack", "[CgiFinderFeedBack] feedId=" + paramLong + " feedbackType=1 subType=2");
      AppMethodBeat.o(291789);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.m
 * JD-Core Version:    0.7.0.1
 */