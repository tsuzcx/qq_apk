package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.feed.model.n;
import com.tencent.mm.plugin.finder.upload.action.q;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bcm;
import com.tencent.mm.protocal.protobuf.bcn;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLikeBuzzword;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeBuzzwordResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/WordingLikeAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/WordingLikeAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/WordingLikeAction;", "likeSeq", "", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends c<bcn>
{
  private static long AzB;
  public static final ab.a Azy;
  private long AzA;
  private final q Azz;
  
  static
  {
    AppMethodBeat.i(336277);
    Azy = new ab.a((byte)0);
    AppMethodBeat.o(336277);
  }
  
  public ab(q paramq)
  {
    AppMethodBeat.i(336271);
    this.Azz = paramq;
    this.AzA = cn.bDv();
    if (this.AzA < AzB)
    {
      long l = AzB;
      AzB = 1L + l;
      this.AzA = l;
    }
    AzB = this.AzA;
    paramq = new bcm();
    Object localObject = bi.ABn;
    paramq.YIY = bi.a(this.Auc);
    paramq.object_id = this.Azz.feedId;
    paramq.YZe = this.Azz.GdD.YZe;
    paramq.ZNy = this.AzA;
    if (this.Azz.GaB) {}
    for (int i = 1;; i = 2)
    {
      paramq.op = i;
      localObject = new bcn();
      ((bcn)localObject).setBaseResponse(new kd());
      ((bcn)localObject).getBaseResponse().akjO = new etl();
      c.a locala = new c.a();
      locala.otE = ((a)paramq);
      locala.otF = ((a)localObject);
      locala.uri = "/cgi-bin/micromsg-bin/finderlikebuzzword";
      locala.funcId = 10512;
      c(locala.bEF());
      Log.i("Finder.CgiFinderLikeBuzzword", "[init] feedId = " + this.Azz.feedId + " buzzwordId = " + this.Azz.GdD.YZe + " likeSeq = " + this.AzA + " isLike = " + this.Azz.GaB);
      AppMethodBeat.o(336271);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ab
 * JD-Core Version:    0.7.0.1
 */