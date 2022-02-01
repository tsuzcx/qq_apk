package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderRecommendNickname;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderRecommendNicknameResponse;", "()V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderRecommendNicknameRequest;", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class y
  extends an<bbe>
{
  private final String TAG;
  private bbd ttG;
  
  public y()
  {
    super(null);
    AppMethodBeat.i(242256);
    this.TAG = "Finder.CgiFinderRecommendNickname";
    this.ttG = new bbd();
    d.a locala = new d.a();
    locala.c((a)this.ttG);
    bbe localbbe = new bbe();
    localbbe.setBaseResponse(new BaseResponse());
    localbbe.getBaseResponse().ErrMsg = new dqi();
    locala.d((a)localbbe);
    locala.MB("/cgi-bin/micromsg-bin/finderrecommendnickname");
    locala.sG(4076);
    c(locala.aXF());
    Log.i(this.TAG, "init");
    AppMethodBeat.o(242256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.y
 * JD-Core Version:    0.7.0.1
 */