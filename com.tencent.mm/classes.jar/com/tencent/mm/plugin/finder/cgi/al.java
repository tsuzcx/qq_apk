package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.viewmodel.b;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderPoiSearch;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderPoiSearchResponse;", "query", "", "finderUsername", "(Ljava/lang/String;Ljava/lang/String;)V", "TAG", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends c<bsi>
{
  private final String TAG;
  
  public al(String paramString1, String paramString2)
  {
    AppMethodBeat.i(336241);
    this.TAG = "Finder.CgiFinderPoiSearch";
    c.a locala = new c.a();
    Object localObject1 = new bsh();
    ((bsh)localObject1).query = paramString1;
    ((bsh)localObject1).YIZ = paramString2;
    Object localObject2 = k.aeZF;
    localObject2 = ((b)k.cn(PluginFinder.class).q(b.class)).dUh();
    ((bsh)localObject1).longitude = ((Number)((r)localObject2).bsC).floatValue();
    ((bsh)localObject1).latitude = ((Number)((r)localObject2).bsD).floatValue();
    locala.otE = ((a)localObject1);
    localObject1 = new bsi();
    ((bsi)localObject1).setBaseResponse(new kd());
    ((bsi)localObject1).getBaseResponse().akjO = new etl();
    locala.otF = ((a)localObject1);
    locala.uri = "/cgi-bin/micromsg-bin/finderpoisearch";
    locala.funcId = 5884;
    c(locala.bEF());
    Log.i(this.TAG, "[init] query:" + paramString1 + ", finder_username:" + paramString2);
    AppMethodBeat.o(336241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.al
 * JD-Core Version:    0.7.0.1
 */