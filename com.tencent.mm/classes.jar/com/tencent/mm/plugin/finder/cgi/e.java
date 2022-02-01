package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFeedbackResponse;", "feedId", "", "objectNonceId", "", "feedbackType", "", "subType", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "Companion", "plugin-finder_release"})
public final class e
  extends w<Object>
{
  public static final a rPX;
  
  static
  {
    AppMethodBeat.i(165162);
    rPX = new a((byte)0);
    AppMethodBeat.o(165162);
  }
  
  public e(long paramLong, String paramString, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201444);
    b.a locala = new b.a();
    anh localanh = new anh();
    localanh.id = paramLong;
    localanh.objectNonceId = paramString;
    localanh.GFm = 1;
    localanh.GFn = 2;
    paramString = v.rRb;
    localanh.GDR = v.a(paramarn);
    paramString = i.syT;
    if (paramarn != null) {}
    for (int i = paramarn.sch;; i = 0)
    {
      localanh.sessionBuffer = i.I(paramLong, i);
      locala.c((a)localanh);
      paramString = new asi();
      paramString.setBaseResponse(new BaseResponse());
      paramString.getBaseResponse().ErrMsg = new cxn();
      locala.d((a)paramString);
      locala.DN("/cgi-bin/micromsg-bin/finderfeedback");
      locala.oS(3912);
      c(locala.aDS());
      ae.i("CgiFinderFeedBack", "[CgiFinderFeedBack] feedId=" + paramLong + " feedbackType=1 subType=2");
      AppMethodBeat.o(201444);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFeedBack$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.e
 * JD-Core Version:    0.7.0.1
 */