package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetSvrExptConfig;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetSvrExptConfigResponse;", "exptIds", "", "", "(Ljava/util/List;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetSvrExptConfigRequest;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class o
  extends an<atr>
{
  private final String TAG;
  private atq tti;
  
  public o(List<Integer> paramList)
  {
    super(null);
    AppMethodBeat.i(242232);
    this.TAG = "Finder.CgiFinderGetSvrExptConfig";
    this.tti = new atq();
    Object localObject = this.tti;
    am localam = am.tuw;
    ((atq)localObject).LBM = am.a(this.ttO);
    this.tti.LEB.addAll((Collection)paramList);
    paramList = new d.a();
    paramList.c((a)this.tti);
    localObject = new atr();
    ((atr)localObject).setBaseResponse(new BaseResponse());
    ((atr)localObject).getBaseResponse().ErrMsg = new dqi();
    paramList.d((a)localObject);
    paramList.MB("/cgi-bin/micromsg-bin/findergetsvrexptconfig");
    paramList.sG(5864);
    c(paramList.aXF());
    Log.i(this.TAG, "init");
    AppMethodBeat.o(242232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.o
 * JD-Core Version:    0.7.0.1
 */