package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.upload.action.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class q
  extends an<aup>
{
  private static long tsS;
  public static final a tto;
  private final String TAG;
  private long tsR;
  private auo ttj;
  private final i ttn;
  
  static
  {
    AppMethodBeat.i(165171);
    tto = new a((byte)0);
    AppMethodBeat.o(165171);
  }
  
  public q(i parami, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242236);
    this.ttn = parami;
    this.TAG = "Finder.CgiFinderLikeFeed";
    this.tsR = cl.aWz();
    long l;
    if (this.tsR < tsS)
    {
      l = tsS;
      tsS = 1L + l;
      this.tsR = l;
    }
    tsS = this.tsR;
    this.ttj = new auo();
    parami = this.ttj;
    Object localObject = c.vCb;
    if (c.drg())
    {
      l = 0L;
      parami.hFK = l;
      this.ttj.objectNonceId = this.ttn.objectNonceId;
      this.ttj.tsR = this.tsR;
      this.ttj.username = z.aUg();
      this.ttj.scene = this.ttn.scene;
      parami = this.ttj;
      if (!this.ttn.vUr) {
        break label584;
      }
      i = 3;
      label175:
      parami.opType = i;
      parami = this.ttj;
      if (!this.ttn.vUk) {
        break label589;
      }
    }
    label584:
    label589:
    for (int i = 1;; i = 0)
    {
      parami.vkk = i;
      parami = this.ttj;
      localObject = am.tuw;
      parami.uli = am.a(parambbn);
      parami = this.ttj;
      parambbn = k.vfA;
      l = this.ttn.feedId;
      parambbn = this.ttj.uli;
      i = j;
      if (parambbn != null) {
        i = parambbn.scene;
      }
      parami.sessionBuffer = k.G(l, i);
      Log.i(this.TAG, "likeId:" + this.tsR + " objectId:" + this.ttj.hFK + " opType:" + this.ttj.opType + " likeId:" + this.ttj.tsR + " username:" + this.ttj.username + " action:" + this.ttn.vUr + ", private:" + this.ttn.vUk);
      parami = new d.a();
      parami.c((a)this.ttj);
      parambbn = new aup();
      parambbn.setBaseResponse(new BaseResponse());
      parambbn.getBaseResponse().ErrMsg = new dqi();
      parami.d((a)parambbn);
      parami.MB("/cgi-bin/micromsg-bin/finderlike");
      parami.sG(3710);
      c(parami.aXF());
      Log.i(this.TAG, "likeId:" + this.tsR + " CgiFinderLikeComment init " + this.ttj.hFK + " and userName " + this.ttn.vTS.getUserName() + " nickname " + this.ttn.vTS.getNickName() + " totalCount:" + this.ttn.vTS.getLikeCount());
      AppMethodBeat.o(242236);
      return;
      l = this.ttn.feedId;
      break;
      i = 4;
      break label175;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.q
 * JD-Core Version:    0.7.0.1
 */