package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.avt;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetSvrExptConfig;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetSvrExptConfigResponse;", "exptIds", "", "", "(Ljava/util/List;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetSvrExptConfigRequest;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class r
  extends c<avu>
{
  private final String TAG;
  private avt xaZ;
  
  public r(List<Integer> paramList)
  {
    super(null);
    AppMethodBeat.i(265894);
    this.TAG = "Finder.CgiFinderGetSvrExptConfig";
    this.xaZ = new avt();
    Object localObject = this.xaZ;
    ao localao = ao.xcj;
    ((avt)localObject).RLM = ao.a(this.xbu);
    this.xaZ.SIj.addAll((Collection)paramList);
    paramList = new d.a();
    paramList.c((a)this.xaZ);
    localObject = new avu();
    ((avu)localObject).setBaseResponse(new jh());
    ((avu)localObject).getBaseResponse().Tef = new eaf();
    paramList.d((a)localObject);
    paramList.TW("/cgi-bin/micromsg-bin/findergetsvrexptconfig");
    paramList.vD(5864);
    c(paramList.bgN());
    Log.i(this.TAG, "init");
    AppMethodBeat.o(265894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.r
 * JD-Core Version:    0.7.0.1
 */