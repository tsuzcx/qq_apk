package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class i
  extends w<api>
{
  private static long rQj;
  public static final a rQk;
  private final String TAG;
  private aph rQh;
  private final com.tencent.mm.plugin.finder.upload.action.i rQi;
  
  static
  {
    AppMethodBeat.i(165168);
    rQk = new a((byte)0);
    AppMethodBeat.o(165168);
  }
  
  public i(com.tencent.mm.plugin.finder.upload.action.i parami, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201452);
    this.rQi = parami;
    this.TAG = "Finder.CgiFinderLikeComment";
    long l2 = ch.aDb();
    long l1 = l2;
    if (l2 < rQj)
    {
      l1 = rQj;
      rQj = 1L + l1;
    }
    rQj = l1;
    this.rQh = new aph();
    parami = this.rQh;
    Object localObject = b.sHP;
    if (b.cHv())
    {
      l2 = 0L;
      parami.rRn = l2;
      this.rQh.objectNonceId = this.rQi.objectNonceId;
      this.rQh.commentId = this.rQi.sVA.cLl().commentId;
      this.rQh.rPT = l1;
      if (this.rQi.scene == 1) {
        this.rQh.username = com.tencent.mm.model.v.aAK();
      }
      parami = this.rQh;
      localObject = v.rRb;
      parami.GDR = v.a(paramarn);
      this.rQh.scene = this.rQi.scene;
      parami = this.rQh;
      if (!this.rQi.sVp) {
        break label420;
      }
      i = 1;
      label211:
      parami.opType = i;
      parami = this.rQh;
      paramarn = com.tencent.mm.plugin.finder.report.i.syT;
      l1 = this.rQi.duw;
      paramarn = this.rQh.GDR;
      if (paramarn == null) {
        break label425;
      }
    }
    label420:
    label425:
    for (int i = paramarn.scene;; i = 0)
    {
      parami.sessionBuffer = com.tencent.mm.plugin.finder.report.i.I(l1, i);
      parami = new b.a();
      parami.c((a)this.rQh);
      paramarn = new api();
      paramarn.setBaseResponse(new BaseResponse());
      paramarn.getBaseResponse().ErrMsg = new cxn();
      parami.d((a)paramarn);
      parami.DN("/cgi-bin/micromsg-bin/finderlike");
      parami.oS(3710);
      c(parami.aDS());
      ae.i(this.TAG, "CgiFinderLikeComment init " + this.rQh.rRn + " and userName " + this.rQh.username + " comment:" + this.rQi.sVA);
      AppMethodBeat.o(201452);
      return;
      l2 = this.rQi.duw;
      break;
      i = 2;
      break label211;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment$Companion;", "", "()V", "GlobalLikeCommentId", "", "getGlobalLikeCommentId", "()J", "setGlobalLikeCommentId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.i
 * JD-Core Version:    0.7.0.1
 */