package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentResponse;", "commentId", "", "feedId", "objectNonceId", "", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JJLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class b
  extends w<amf>
{
  public static final a rPP;
  private long commentId;
  private long duw;
  
  static
  {
    AppMethodBeat.i(165160);
    rPP = new a((byte)0);
    AppMethodBeat.o(165160);
  }
  
  public b(long paramLong1, long paramLong2, String paramString, int paramInt, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201437);
    Object localObject2 = new ame();
    Object localObject1 = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject1).c((a)localObject2);
    localObject2 = new amf();
    ((amf)localObject2).setBaseResponse(new BaseResponse());
    ((com.tencent.mm.ak.b.a)localObject1).d((a)localObject2);
    ((com.tencent.mm.ak.b.a)localObject1).oT(2000);
    ((com.tencent.mm.ak.b.a)localObject1).DN("/cgi-bin/micromsg-bin/findercomment");
    ((com.tencent.mm.ak.b.a)localObject1).oS(3906);
    c(((com.tencent.mm.ak.b.a)localObject1).aDS());
    ae.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
    this.commentId = paramLong1;
    this.duw = paramLong2;
    ae.i("MicroMsg.Finder.CgiDeleteFinderComment", "[CgiDeleteFinderComment] commentId=" + paramLong1 + ')');
    localObject1 = new ame();
    ((ame)localObject1).commentId = paramLong1;
    ((ame)localObject1).opType = 1;
    ((ame)localObject1).rRn = paramLong2;
    ((ame)localObject1).objectNonceId = paramString;
    ((ame)localObject1).scene = paramInt;
    paramString = v.rRb;
    ((ame)localObject1).GDR = v.a(paramarn);
    paramString = i.syT;
    if (paramarn != null) {}
    for (paramInt = paramarn.sch;; paramInt = 0)
    {
      ((ame)localObject1).sessionBuffer = i.I(paramLong2, paramInt);
      paramString = new com.tencent.mm.ak.b.a();
      paramString.c((a)localObject1);
      paramarn = new amf();
      paramarn.setBaseResponse(new BaseResponse());
      paramString.d((a)paramarn);
      paramString.oT(2000);
      paramString.DN("/cgi-bin/micromsg-bin/findercomment");
      paramString.oS(3906);
      c(paramString.aDS());
      ae.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
      AppMethodBeat.o(201437);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.b
 * JD-Core Version:    0.7.0.1
 */