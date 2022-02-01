package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bwn;
import com.tencent.mm.protocal.protobuf.bwo;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetSurvey;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderSurveyGetResponse;", "objectId", "", "(J)V", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends c<bwo>
{
  public static final a Azw;
  
  static
  {
    AppMethodBeat.i(336470);
    Azw = new a((byte)0);
    AppMethodBeat.o(336470);
  }
  
  public y(long paramLong)
  {
    AppMethodBeat.i(336465);
    bwn localbwn = new bwn();
    Object localObject = bi.ABn;
    localbwn.YIY = bi.a(this.Auc);
    localbwn.object_id = paramLong;
    localObject = new bwo();
    ((bwo)localObject).setBaseResponse(new kd());
    ((bwo)localObject).getBaseResponse().akjO = new etl();
    c.a locala = new c.a();
    locala.otE = ((a)localbwn);
    locala.otF = ((a)localObject);
    locala.uri = "/cgi-bin/micromsg-bin/findersurveyget";
    locala.funcId = 4106;
    c(locala.bEF());
    Log.i("Finder.CgiFinderGetSurvey", "init objectId = " + paramLong + ' ');
    AppMethodBeat.o(336465);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetSurvey$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.y
 * JD-Core Version:    0.7.0.1
 */