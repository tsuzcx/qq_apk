package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.upload.action.b;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.aqu;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFavResp;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/upload/action/FavAction;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FavAction;", "likeId", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderFavReq;", "initCommReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class h
  extends an<aqu>
{
  private static long tsS;
  public static final a tsT;
  private final String TAG;
  private final b tsI;
  private aqt tsQ;
  private long tsR;
  
  static
  {
    AppMethodBeat.i(242214);
    tsT = new a((byte)0);
    AppMethodBeat.o(242214);
  }
  
  public h(b paramb, bbn parambbn)
  {
    super(parambbn);
    AppMethodBeat.i(242213);
    this.tsI = paramb;
    this.TAG = "Finder.CgiFinderFavFeed";
    this.tsR = cl.aWz();
    long l;
    if (this.tsR < tsS)
    {
      l = tsS;
      tsS = 1L + l;
      this.tsR = l;
    }
    tsS = this.tsR;
    this.tsQ = new aqt();
    paramb = this.tsQ;
    Object localObject = c.vCb;
    if (c.drg())
    {
      l = 0L;
      paramb.hFK = l;
      this.tsQ.objectNonceId = this.tsI.objectNonceId;
      this.tsQ.tal = this.tsR;
      this.tsQ.finderUsername = z.aUg();
      paramb = this.tsQ;
      if (!this.tsI.vTT) {
        break label519;
      }
      i = 1;
      label158:
      paramb.dYx = i;
      paramb = this.tsQ;
      localObject = am.tuw;
      paramb.LAI = am.a(parambbn);
      paramb = this.tsQ;
      localObject = k.vfA;
      l = this.tsI.feedId;
      if (parambbn == null) {
        break label524;
      }
    }
    label519:
    label524:
    for (int i = parambbn.tCE;; i = 0)
    {
      paramb.sessionBuffer = k.G(l, i);
      Log.i(this.TAG, "likeId:" + this.tsR + " objectId:" + this.tsQ.hFK + " opType:" + this.tsQ.dYx + " likeId:" + this.tsQ.tal + " username:" + this.tsQ.finderUsername + " action:" + this.tsI.vTT);
      paramb = new d.a();
      paramb.c((a)this.tsQ);
      parambbn = new aqu();
      parambbn.setBaseResponse(new BaseResponse());
      parambbn.getBaseResponse().ErrMsg = new dqi();
      paramb.d((a)parambbn);
      paramb.MB("/cgi-bin/micromsg-bin/finderfav");
      paramb.sG(3715);
      c(paramb.aXF());
      Log.i(this.TAG, "likeId:" + this.tsR + " CgiFinderLikeComment init " + this.tsQ.hFK + " and userName " + this.tsI.vTS.getUserName() + " nickname " + this.tsI.vTS.getNickName() + " totalCount:" + this.tsI.vTS.getLikeCount());
      AppMethodBeat.o(242213);
      return;
      l = this.tsI.feedId;
      break;
      i = 2;
      break label158;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFavFeed$Companion;", "", "()V", "GlobalLikeFeedId", "", "getGlobalLikeFeedId", "()J", "setGlobalLikeFeedId", "(J)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.h
 * JD-Core Version:    0.7.0.1
 */