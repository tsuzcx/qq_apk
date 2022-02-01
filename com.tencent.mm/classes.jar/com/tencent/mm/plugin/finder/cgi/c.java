package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.j;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCommentResponse;", "commentId", "", "feedId", "objectNonceId", "", "scene", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JJLjava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class c
  extends com.tencent.mm.plugin.findersdk.b.c<aqy>
{
  public static final a xao;
  private long commentId;
  private long feedId;
  
  static
  {
    AppMethodBeat.i(165160);
    xao = new a((byte)0);
    AppMethodBeat.o(165160);
  }
  
  public c(long paramLong1, long paramLong2, String paramString, int paramInt, bid parambid)
  {
    super(parambid);
    AppMethodBeat.i(279390);
    Object localObject2 = new aqx();
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((a)localObject2);
    localObject2 = new aqy();
    ((aqy)localObject2).setBaseResponse(new jh());
    ((d.a)localObject1).d((a)localObject2);
    ((d.a)localObject1).vE(2000);
    ((d.a)localObject1).TW("/cgi-bin/micromsg-bin/findercomment");
    ((d.a)localObject1).vD(3906);
    c(((d.a)localObject1).bgN());
    Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
    this.commentId = paramLong1;
    this.feedId = paramLong2;
    Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "[CgiDeleteFinderComment] commentId=" + paramLong1 + ')');
    localObject1 = new aqx();
    ((aqx)localObject1).commentId = paramLong1;
    ((aqx)localObject1).opType = 1;
    ((aqx)localObject1).xbk = paramLong2;
    ((aqx)localObject1).objectNonceId = paramString;
    ((aqx)localObject1).scene = paramInt;
    paramString = ao.xcj;
    ((aqx)localObject1).yjp = ao.a(parambid);
    paramString = n.zWF;
    if (parambid != null) {}
    for (paramInt = parambid.xkX;; paramInt = 0)
    {
      ((aqx)localObject1).sessionBuffer = n.N(paramLong2, paramInt);
      paramString = new d.a();
      paramString.c((a)localObject1);
      localObject2 = new aqy();
      ((aqy)localObject2).setBaseResponse(new jh());
      paramString.d((a)localObject2);
      paramString.vE(2000);
      localObject2 = ao.xcj;
      localObject1 = ((aqx)localObject1).yjp;
      paramInt = i;
      if (parambid != null) {
        paramInt = parambid.fGo;
      }
      ao.a((aqe)localObject1, j.listOf(new o(Integer.valueOf(paramInt), Long.valueOf(paramLong2))));
      paramString.TW("/cgi-bin/micromsg-bin/findercomment");
      paramString.vD(3906);
      c(paramString.bgN());
      Log.i("MicroMsg.Finder.CgiDeleteFinderComment", "CgiReplyFinderComment init");
      AppMethodBeat.o(279390);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiDeleteFinderComment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.c
 * JD-Core Version:    0.7.0.1
 */