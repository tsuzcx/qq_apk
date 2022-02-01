package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.feed.model.n;
import com.tencent.mm.plugin.finder.upload.action.r;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderOpBuzzword;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderOpBuzzwordResponse;", "action", "Lcom/tencent/mm/plugin/finder/upload/action/WordingOpAction;", "(Lcom/tencent/mm/plugin/finder/upload/action/WordingOpAction;)V", "getAction", "()Lcom/tencent/mm/plugin/finder/upload/action/WordingOpAction;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  extends c<bru>
{
  public static final a AzV;
  private final r AzW;
  
  static
  {
    AppMethodBeat.i(336244);
    AzV = new a((byte)0);
    AppMethodBeat.o(336244);
  }
  
  public ak(r paramr)
  {
    AppMethodBeat.i(336236);
    this.AzW = paramr;
    paramr = new brt();
    Object localObject = bi.ABn;
    paramr.YIY = bi.a(this.Auc);
    paramr.object_id = this.AzW.feedId;
    paramr.YZe = this.AzW.GdD.YZe;
    paramr.op = this.AzW.op;
    localObject = new bru();
    ((bru)localObject).setBaseResponse(new kd());
    ((bru)localObject).getBaseResponse().akjO = new etl();
    c.a locala = new c.a();
    locala.otE = ((a)paramr);
    locala.otF = ((a)localObject);
    locala.uri = "/cgi-bin/micromsg-bin/finderopbuzzword";
    locala.funcId = 11259;
    c(locala.bEF());
    AppMethodBeat.o(336236);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderOpBuzzword$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ak
 * JD-Core Version:    0.7.0.1
 */