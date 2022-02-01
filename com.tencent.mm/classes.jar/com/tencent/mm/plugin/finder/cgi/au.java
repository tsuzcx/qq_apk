package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderUserPoi;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPoiResponse;", "finderUsername", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "TAG", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class au
  extends c<byp>
{
  private final String TAG;
  
  public au(String paramString, com.tencent.mm.bx.b paramb)
  {
    AppMethodBeat.i(336210);
    this.TAG = "Finder.CgiFinderPoiSearch";
    c.a locala = new c.a();
    byo localbyo = new byo();
    localbyo.YIZ = paramString;
    localbyo.ZEQ = paramb;
    paramb = k.aeZF;
    paramb = ((com.tencent.mm.plugin.finder.viewmodel.b)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
    localbyo.longitude = ((Number)paramb.bsC).floatValue();
    localbyo.latitude = ((Number)paramb.bsD).floatValue();
    locala.otE = ((a)localbyo);
    paramb = new byp();
    paramb.setBaseResponse(new kd());
    paramb.getBaseResponse().akjO = new etl();
    locala.otF = ((a)paramb);
    locala.uri = "/cgi-bin/micromsg-bin/finderuserpoi";
    locala.funcId = 4035;
    c(locala.bEF());
    Log.i(this.TAG, s.X("[init] finder_username:", paramString));
    AppMethodBeat.o(336210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.au
 * JD-Core Version:    0.7.0.1
 */