package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeCommentAction;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class p
  extends an<aup>
{
  private static long ttl;
  public static final a ttm;
  private final String TAG;
  private auo ttj;
  private final com.tencent.mm.plugin.finder.upload.action.l ttk;
  
  static
  {
    AppMethodBeat.i(165168);
    ttm = new a((byte)0);
    AppMethodBeat.o(165168);
  }
  
  public p(com.tencent.mm.plugin.finder.upload.action.l paraml, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242234);
    this.ttk = paraml;
    this.TAG = "Finder.CgiFinderLikeComment";
    long l2 = cl.aWz();
    long l1 = l2;
    if (l2 < ttl)
    {
      l1 = ttl;
      ttl = 1L + l1;
    }
    ttl = l1;
    this.ttj = new auo();
    paraml = this.ttj;
    Object localObject = c.vCb;
    if (c.drg())
    {
      l2 = 0L;
      paraml.hFK = l2;
      this.ttj.objectNonceId = this.ttk.objectNonceId;
      this.ttj.commentId = this.ttk.vUB.dyb().commentId;
      this.ttj.tsR = l1;
      if (this.ttk.scene == 1) {
        this.ttj.username = z.aUg();
      }
      paraml = this.ttj;
      localObject = am.tuw;
      paraml.uli = am.a(parambbn);
      this.ttj.scene = this.ttk.scene;
      paraml = this.ttj;
      if (!this.ttk.vUr) {
        break label420;
      }
      i = 1;
      label211:
      paraml.opType = i;
      paraml = this.ttj;
      parambbn = k.vfA;
      l1 = this.ttk.feedId;
      parambbn = this.ttj.uli;
      if (parambbn == null) {
        break label425;
      }
    }
    label420:
    label425:
    for (int i = parambbn.scene;; i = 0)
    {
      paraml.sessionBuffer = k.G(l1, i);
      paraml = new d.a();
      paraml.c((a)this.ttj);
      parambbn = new aup();
      parambbn.setBaseResponse(new BaseResponse());
      parambbn.getBaseResponse().ErrMsg = new dqi();
      paraml.d((a)parambbn);
      paraml.MB("/cgi-bin/micromsg-bin/finderlike");
      paraml.sG(3710);
      c(paraml.aXF());
      Log.i(this.TAG, "CgiFinderLikeComment init " + this.ttj.hFK + " and userName " + this.ttj.username + " comment:" + this.ttk.vUB);
      AppMethodBeat.o(242234);
      return;
      l2 = this.ttk.feedId;
      break;
      i = 2;
      break label211;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeComment$Companion;", "", "()V", "GlobalLikeCommentId", "", "getGlobalLikeCommentId", "()J", "setGlobalLikeCommentId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.p
 * JD-Core Version:    0.7.0.1
 */