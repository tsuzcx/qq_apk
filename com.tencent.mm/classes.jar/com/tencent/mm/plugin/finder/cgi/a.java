package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.finder.report.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ahx;
import com.tencent.mm.protocal.protobuf.ahy;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentResponse;", "commentId", "", "feedId", "objectNonceId", "", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JJLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class a
  extends an<ahy>
{
  public static final a qol;
  private long commentId;
  private long feedId;
  
  static
  {
    AppMethodBeat.i(165160);
    qol = new a((byte)0);
    AppMethodBeat.o(165160);
  }
  
  public a(long paramLong1, long paramLong2, String paramString, int paramInt, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197246);
    Object localObject2 = new ahx();
    Object localObject1 = new b.a();
    ((b.a)localObject1).c((com.tencent.mm.bx.a)localObject2);
    localObject2 = new ahy();
    ((ahy)localObject2).setBaseResponse(new BaseResponse());
    ((b.a)localObject1).d((com.tencent.mm.bx.a)localObject2);
    ((b.a)localObject1).nC(2000);
    ((b.a)localObject1).wg("/cgi-bin/micromsg-bin/findercomment");
    ((b.a)localObject1).nB(3906);
    c(((b.a)localObject1).atI());
    ad.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
    this.commentId = paramLong1;
    this.feedId = paramLong2;
    ad.i("MicroMsg.Finder.CgiDeleteFinderComment", "[CgiDeleteFinderComment] commentId=" + paramLong1 + ')');
    localObject1 = new ahx();
    ((ahx)localObject1).commentId = paramLong1;
    ((ahx)localObject1).opType = 1;
    ((ahx)localObject1).objectId = paramLong2;
    ((ahx)localObject1).objectNonceId = paramString;
    ((ahx)localObject1).scene = paramInt;
    paramString = am.KJy;
    ((ahx)localObject1).Dkw = am.a(paramdzp);
    paramString = b.qFq;
    if (paramdzp != null) {}
    for (paramInt = paramdzp.qqE;; paramInt = 0)
    {
      ((ahx)localObject1).sessionBuffer = b.am(paramLong2, paramInt);
      paramString = new b.a();
      paramString.c((com.tencent.mm.bx.a)localObject1);
      paramdzp = new ahy();
      paramdzp.setBaseResponse(new BaseResponse());
      paramString.d((com.tencent.mm.bx.a)paramdzp);
      paramString.nC(2000);
      paramString.wg("/cgi-bin/micromsg-bin/findercomment");
      paramString.nB(3906);
      c(paramString.atI());
      ad.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
      AppMethodBeat.o(197246);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a
 * JD-Core Version:    0.7.0.1
 */