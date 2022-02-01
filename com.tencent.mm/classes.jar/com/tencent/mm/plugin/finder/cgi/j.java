package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.upload.action.f;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.protocal.protobuf.api;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiBack", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class j
  extends w<api>
{
  private static long rPV;
  public static final a rQm;
  private final String TAG;
  private long rPT;
  private aph rQh;
  private final f rQl;
  
  static
  {
    AppMethodBeat.i(165171);
    rQm = new a((byte)0);
    AppMethodBeat.o(165171);
  }
  
  public j(f paramf, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201453);
    this.rQl = paramf;
    this.TAG = "Finder.CgiFinderLikeFeed";
    this.rPT = ch.aDb();
    long l;
    if (this.rPT < rPV)
    {
      l = rPV;
      rPV = 1L + l;
      this.rPT = l;
    }
    rPV = this.rPT;
    this.rQh = new aph();
    paramf = this.rQh;
    Object localObject = b.sHP;
    if (b.cHv())
    {
      l = 0L;
      paramf.rRn = l;
      this.rQh.objectNonceId = this.rQl.objectNonceId;
      this.rQh.rPT = this.rPT;
      this.rQh.username = com.tencent.mm.model.v.aAK();
      this.rQh.scene = this.rQl.scene;
      paramf = this.rQh;
      if (!this.rQl.sVp) {
        break label583;
      }
      i = 3;
      label175:
      paramf.opType = i;
      paramf = this.rQh;
      if (!this.rQl.sVq) {
        break label588;
      }
    }
    label583:
    label588:
    for (int i = 1;; i = 0)
    {
      paramf.GGx = i;
      paramf = this.rQh;
      localObject = v.rRb;
      paramf.GDR = v.a(paramarn);
      paramf = this.rQh;
      paramarn = i.syT;
      l = this.rQl.duw;
      paramarn = this.rQh.GDR;
      i = j;
      if (paramarn != null) {
        i = paramarn.scene;
      }
      paramf.sessionBuffer = i.I(l, i);
      ae.i(this.TAG, "likeId:" + this.rPT + " objectId:" + this.rQh.rRn + " opType:" + this.rQh.opType + " likeId:" + this.rQh.rPT + " username:" + this.rQh.username + " action:" + this.rQl.sVp + ", private:" + this.rQl.sVq);
      paramf = new b.a();
      paramf.c((a)this.rQh);
      paramarn = new api();
      paramarn.setBaseResponse(new BaseResponse());
      paramarn.getBaseResponse().ErrMsg = new cxn();
      paramf.d((a)paramarn);
      paramf.DN("/cgi-bin/micromsg-bin/finderlike");
      paramf.oS(3710);
      c(paramf.aDS());
      ae.i(this.TAG, "likeId:" + this.rPT + " CgiFinderLikeComment init " + this.rQh.rRn + " and userName " + this.rQl.sUY.getUserName() + " nickname " + this.rQl.sUY.getNickName() + " totalCount:" + this.rQl.sUY.getLikeCount());
      AppMethodBeat.o(201453);
      return;
      l = this.rQl.duw;
      break;
      i = 4;
      break label175;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.j
 * JD-Core Version:    0.7.0.1
 */