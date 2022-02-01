package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.als;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentResponse;", "commentId", "", "feedId", "objectNonceId", "", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JJLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class b
  extends w<alt>
{
  public static final a rHE;
  private long commentId;
  private long dtq;
  
  static
  {
    AppMethodBeat.i(165160);
    rHE = new a((byte)0);
    AppMethodBeat.o(165160);
  }
  
  public b(long paramLong1, long paramLong2, String paramString, int paramInt, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201015);
    Object localObject2 = new als();
    Object localObject1 = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject1).c((a)localObject2);
    localObject2 = new alt();
    ((alt)localObject2).setBaseResponse(new BaseResponse());
    ((com.tencent.mm.al.b.a)localObject1).d((a)localObject2);
    ((com.tencent.mm.al.b.a)localObject1).oQ(2000);
    ((com.tencent.mm.al.b.a)localObject1).Dl("/cgi-bin/micromsg-bin/findercomment");
    ((com.tencent.mm.al.b.a)localObject1).oP(3906);
    c(((com.tencent.mm.al.b.a)localObject1).aDC());
    ad.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
    this.commentId = paramLong1;
    this.dtq = paramLong2;
    ad.i("MicroMsg.Finder.CgiDeleteFinderComment", "[CgiDeleteFinderComment] commentId=" + paramLong1 + ')');
    localObject1 = new als();
    ((als)localObject1).commentId = paramLong1;
    ((als)localObject1).opType = 1;
    ((als)localObject1).rIZ = paramLong2;
    ((als)localObject1).objectNonceId = paramString;
    ((als)localObject1).scene = paramInt;
    paramString = v.rIR;
    ((als)localObject1).Glv = v.a(paramaqy);
    paramString = h.soM;
    if (paramaqy != null) {}
    for (paramInt = paramaqy.rTD;; paramInt = 0)
    {
      ((als)localObject1).sessionBuffer = h.I(paramLong2, paramInt);
      paramString = new com.tencent.mm.al.b.a();
      paramString.c((a)localObject1);
      paramaqy = new alt();
      paramaqy.setBaseResponse(new BaseResponse());
      paramString.d((a)paramaqy);
      paramString.oQ(2000);
      paramString.Dl("/cgi-bin/micromsg-bin/findercomment");
      paramString.oP(3906);
      c(paramString.aDC());
      ad.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
      AppMethodBeat.o(201015);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.b
 * JD-Core Version:    0.7.0.1
 */