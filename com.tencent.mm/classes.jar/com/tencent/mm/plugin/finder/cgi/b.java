package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentResponse;", "commentId", "", "feedId", "objectNonceId", "", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JJLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class b
  extends r<ajd>
{
  public static final b.a qWI;
  private long commentId;
  private long dig;
  
  static
  {
    AppMethodBeat.i(165160);
    qWI = new b.a((byte)0);
    AppMethodBeat.o(165160);
  }
  
  public b(long paramLong1, long paramLong2, String paramString, int paramInt, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201099);
    Object localObject2 = new ajc();
    Object localObject1 = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject1).c((a)localObject2);
    localObject2 = new ajd();
    ((ajd)localObject2).setBaseResponse(new BaseResponse());
    ((com.tencent.mm.ak.b.a)localObject1).d((a)localObject2);
    ((com.tencent.mm.ak.b.a)localObject1).oq(2000);
    ((com.tencent.mm.ak.b.a)localObject1).Am("/cgi-bin/micromsg-bin/findercomment");
    ((com.tencent.mm.ak.b.a)localObject1).op(3906);
    c(((com.tencent.mm.ak.b.a)localObject1).aAz());
    ac.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
    this.commentId = paramLong1;
    this.dig = paramLong2;
    ac.i("MicroMsg.Finder.CgiDeleteFinderComment", "[CgiDeleteFinderComment] commentId=" + paramLong1 + ')');
    localObject1 = new ajc();
    ((ajc)localObject1).commentId = paramLong1;
    ((ajc)localObject1).opType = 1;
    ((ajc)localObject1).qXP = paramLong2;
    ((ajc)localObject1).objectNonceId = paramString;
    ((ajc)localObject1).scene = paramInt;
    paramString = q.qXH;
    ((ajc)localObject1).EDL = q.a(paramanm);
    paramString = d.rxr;
    if (paramanm != null) {}
    for (paramInt = paramanm.rfR;; paramInt = 0)
    {
      ((ajc)localObject1).sessionBuffer = d.G(paramLong2, paramInt);
      paramString = new com.tencent.mm.ak.b.a();
      paramString.c((a)localObject1);
      paramanm = new ajd();
      paramanm.setBaseResponse(new BaseResponse());
      paramString.d((a)paramanm);
      paramString.oq(2000);
      paramString.Am("/cgi-bin/micromsg-bin/findercomment");
      paramString.op(3906);
      c(paramString.aAz());
      ac.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
      AppMethodBeat.o(201099);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.b
 * JD-Core Version:    0.7.0.1
 */