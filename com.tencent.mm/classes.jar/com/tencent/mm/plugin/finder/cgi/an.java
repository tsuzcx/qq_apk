package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderRecommendNickname;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderRecommendNicknameResponse;", "()V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderRecommendNicknameRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
  extends c<bts>
{
  private btr AzX;
  private final String TAG;
  
  public an()
  {
    super(null);
    AppMethodBeat.i(336209);
    this.TAG = "Finder.CgiFinderRecommendNickname";
    this.AzX = new btr();
    c.a locala = new c.a();
    locala.otE = ((a)this.AzX);
    bts localbts = new bts();
    localbts.setBaseResponse(new kd());
    localbts.getBaseResponse().akjO = new etl();
    locala.otF = ((a)localbts);
    locala.uri = "/cgi-bin/micromsg-bin/finderrecommendnickname";
    locala.funcId = 4076;
    c(locala.bEF());
    Log.i(this.TAG, "init");
    AppMethodBeat.o(336209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.an
 * JD-Core Version:    0.7.0.1
 */