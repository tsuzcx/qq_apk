package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f.a;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.plugin.finder.upload.action.f;
import com.tencent.mm.plugin.finder.utils.c;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderFollow;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderFollowResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;)V", "TAG", "", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/FollowAction;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class k
  extends an<arg>
{
  private final String TAG;
  private final f tsY;
  
  public k(f paramf)
  {
    super(paramf.ttO);
    AppMethodBeat.i(242222);
    this.tsY = paramf;
    this.TAG = "Finder.CgiFinderFollow";
    Object localObject2 = new arf();
    ((arf)localObject2).LCo = this.tsY.dNc;
    ((arf)localObject2).opType = this.tsY.opType;
    ((arf)localObject2).refObjectId = this.tsY.feedId;
    paramf = am.tuw;
    ((arf)localObject2).uli = am.a(this.ttO);
    Object localObject3 = ((arf)localObject2).uli;
    boolean bool;
    label160:
    int i;
    if (localObject3 != null)
    {
      paramf = this.ttO;
      if (paramf != null)
      {
        paramf = Integer.valueOf(paramf.tyh);
        ((aov)localObject3).scene = paramf.intValue();
      }
    }
    else
    {
      paramf = c.vVc;
      localObject3 = this.ttO;
      if ((localObject3 != null) && (((bbn)localObject3).tyh == 0)) {
        break label462;
      }
      bool = true;
      f.a.a(paramf, "NetSceneFinderFollow_fromCommentScene_0", bool, false, (kotlin.g.a.a)1.tsZ, 12);
      paramf = com.tencent.mm.plugin.finder.report.k.vfA;
      long l = this.tsY.feedId;
      paramf = ((arf)localObject2).uli;
      if (paramf == null) {
        break label468;
      }
      i = paramf.scene;
      label205:
      ((arf)localObject2).sessionBuffer = com.tencent.mm.plugin.finder.report.k.G(l, i);
      paramf = this.ttO;
      i = j;
      if (paramf != null) {
        i = paramf.wyY;
      }
      ((arf)localObject2).vkj = i;
      paramf = new d.a();
      paramf.c((com.tencent.mm.bw.a)localObject2);
      localObject2 = new arg();
      ((arg)localObject2).setBaseResponse(new BaseResponse());
      ((arg)localObject2).getBaseResponse().ErrMsg = new dqi();
      paramf.d((com.tencent.mm.bw.a)localObject2);
      paramf.MB("/cgi-bin/micromsg-bin/finderfollow");
      paramf.sG(3867);
      c(paramf.aXF());
      localObject2 = this.TAG;
      localObject3 = new StringBuilder("CgiFinderFollow init, ").append(this.tsY.dNc).append(" opType ").append(this.tsY.opType).append(" scene ");
      paramf = this.ttO;
      if (paramf == null) {
        break label473;
      }
    }
    label462:
    label468:
    label473:
    for (paramf = Integer.valueOf(paramf.tyh);; paramf = null)
    {
      localObject3 = ((StringBuilder)localObject3).append(paramf).append(" feedId ").append(this.tsY.feedId).append(" enterType");
      bbn localbbn = this.ttO;
      paramf = localObject1;
      if (localbbn != null) {
        paramf = Integer.valueOf(localbbn.wyY);
      }
      Log.i((String)localObject2, paramf);
      AppMethodBeat.o(242222);
      return;
      paramf = null;
      break;
      bool = false;
      break label160;
      i = 0;
      break label205;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.k
 * JD-Core Version:    0.7.0.1
 */