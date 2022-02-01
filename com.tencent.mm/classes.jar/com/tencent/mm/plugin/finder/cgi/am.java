package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bsu;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderPostPreData;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderPostPrevDataResponse;", "dataType", "", "(I)V", "TAG", "", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
  extends c<bsv>
{
  private final String TAG;
  
  public am()
  {
    AppMethodBeat.i(336206);
    this.TAG = "Finder.CgiFinderPoiSearch";
    c.a locala = new c.a();
    Object localObject = new bsu();
    ((bsu)localObject).aaaw = 1;
    ((bsu)localObject).YIZ = z.bAW();
    locala.otE = ((a)localObject);
    localObject = new bsv();
    ((bsv)localObject).setBaseResponse(new kd());
    ((bsv)localObject).getBaseResponse().akjO = new etl();
    locala.otF = ((a)localObject);
    locala.uri = "/cgi-bin/micromsg-bin/findergetpostprevdata";
    locala.funcId = 4139;
    c(locala.bEF());
    Log.i(this.TAG, s.X("[init] dataType:", Integer.valueOf(1)));
    AppMethodBeat.o(336206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.am
 * JD-Core Version:    0.7.0.1
 */