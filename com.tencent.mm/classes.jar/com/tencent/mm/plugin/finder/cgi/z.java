package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.bba;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetSvrExptConfig;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetSvrExptConfigResponse;", "exptIds", "", "", "(Ljava/util/List;)V", "TAG", "", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetSvrExptConfigRequest;", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends c<bba>
{
  private baz Azx;
  private final String TAG;
  
  public z(List<Integer> paramList)
  {
    super(null);
    AppMethodBeat.i(336464);
    this.TAG = "Finder.CgiFinderGetSvrExptConfig";
    this.Azx = new baz();
    Object localObject = this.Azx;
    bi localbi = bi.ABn;
    ((baz)localObject).YIY = bi.a(this.Auc);
    this.Azx.ZLQ.addAll((Collection)paramList);
    paramList = new c.a();
    paramList.otE = ((a)this.Azx);
    localObject = new bba();
    ((bba)localObject).setBaseResponse(new kd());
    ((bba)localObject).getBaseResponse().akjO = new etl();
    paramList.otF = ((a)localObject);
    paramList.uri = "/cgi-bin/micromsg-bin/findergetsvrexptconfig";
    paramList.funcId = 5864;
    c(paramList.bEF());
    Log.i(this.TAG, "init");
    AppMethodBeat.o(336464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.z
 * JD-Core Version:    0.7.0.1
 */