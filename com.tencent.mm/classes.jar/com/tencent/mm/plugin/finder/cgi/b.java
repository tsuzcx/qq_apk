package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ail;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "feedId", "", "objectNonceId", "", "feedbackType", "", "subType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "Companion", "plugin-finder_release"})
public final class b
  extends an<Object>
{
  public static final a qom;
  
  static
  {
    AppMethodBeat.i(165162);
    qom = new a((byte)0);
    AppMethodBeat.o(165162);
  }
  
  public b(long paramLong, String paramString, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197250);
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    ail localail = new ail();
    localail.id = paramLong;
    localail.objectNonceId = paramString;
    localail.Dld = 1;
    localail.Dle = 2;
    paramString = am.KJy;
    localail.Dkw = am.a(paramdzp);
    paramString = com.tencent.mm.plugin.finder.report.b.qFq;
    if (paramdzp != null) {}
    for (int i = paramdzp.qqE;; i = 0)
    {
      localail.sessionBuffer = com.tencent.mm.plugin.finder.report.b.am(paramLong, i);
      locala.c((a)localail);
      paramString = new alj();
      paramString.setBaseResponse(new BaseResponse());
      paramString.getBaseResponse().ErrMsg = new cmf();
      locala.d((a)paramString);
      locala.wg("/cgi-bin/micromsg-bin/finderfeedback");
      locala.nB(3912);
      c(locala.atI());
      ad.i("CgiFinderFeedBack", "[CgiFinderFeedBack] feedId=" + paramLong + " feedbackType=1 subType=2");
      AppMethodBeat.o(197250);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.b
 * JD-Core Version:    0.7.0.1
 */