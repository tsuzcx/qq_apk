package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.bhs;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderRecommendNickname;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderRecommendNicknameResponse;", "()V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderRecommendNicknameRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class y
  extends c<bhs>
{
  private final String TAG;
  private bhr xbm;
  
  public y()
  {
    super(null);
    AppMethodBeat.i(226168);
    this.TAG = "Finder.CgiFinderRecommendNickname";
    this.xbm = new bhr();
    d.a locala = new d.a();
    locala.c((a)this.xbm);
    bhs localbhs = new bhs();
    localbhs.setBaseResponse(new jh());
    localbhs.getBaseResponse().Tef = new eaf();
    locala.d((a)localbhs);
    locala.TW("/cgi-bin/micromsg-bin/finderrecommendnickname");
    locala.vD(4076);
    c(locala.bgN());
    Log.i(this.TAG, "init");
    AppMethodBeat.o(226168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.y
 * JD-Core Version:    0.7.0.1
 */