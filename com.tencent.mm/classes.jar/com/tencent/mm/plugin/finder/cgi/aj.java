package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.upload.action.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiLikeMegaVideo;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLikeResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/LikeAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/MegaVideoLikeRequest;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class aj
  extends an<cob>
{
  private static long tsS;
  public static final a tus;
  private long tsR;
  private final i ttn;
  private coa tur;
  
  static
  {
    AppMethodBeat.i(242315);
    tus = new a((byte)0);
    AppMethodBeat.o(242315);
  }
  
  public aj(i parami, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242314);
    this.ttn = parami;
    this.tsR = cl.aWz();
    if (this.tsR < tsS)
    {
      l = tsS;
      tsS = 1L + l;
      this.tsR = l;
    }
    tsS = this.tsR;
    this.tur = new coa();
    parami = this.tur;
    ap localap = ap.tuF;
    parami.MtV = ap.b(parambbn);
    parami = this.tur;
    int i;
    if (this.ttn.vUr)
    {
      i = 1;
      parami.opType = i;
      this.tur.tsR = this.tsR;
      parami = this.tur;
      parambbn = c.vCb;
      if (!c.drg()) {
        break label425;
      }
    }
    label425:
    for (long l = 0L;; l = this.ttn.feedId)
    {
      parami.twG = l;
      this.tur.LOd = this.ttn.objectNonceId;
      Log.i("CgiLikeMegaVideo", "likeId:" + this.tsR + " opType:" + this.tur.opType + " likeId:" + this.tur.tsR + " action:" + this.ttn.vUr);
      parami = new d.a();
      parami.c((a)this.tur);
      parambbn = new cob();
      parambbn.setBaseResponse(new BaseResponse());
      parambbn.getBaseResponse().ErrMsg = new dqi();
      parami.d((a)parambbn);
      parami.MB("/cgi-bin/micromsg-bin/megavideolike");
      parami.sG(5232);
      c(parami.aXF());
      Log.i("CgiLikeMegaVideo", "likeId:" + this.tsR + " CgiLikeMegaVideo init " + this.tur.twG + " and userName " + this.ttn.vTS.getUserName() + " nickname " + this.ttn.vTS.getNickName() + " totalCount:" + this.ttn.vTS.getLikeCount());
      AppMethodBeat.o(242314);
      return;
      i = 2;
      break;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiLikeMegaVideo$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aj
 * JD-Core Version:    0.7.0.1
 */