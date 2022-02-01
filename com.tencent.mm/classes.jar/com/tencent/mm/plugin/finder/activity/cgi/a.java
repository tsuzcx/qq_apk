package com.tencent.mm.plugin.finder.activity.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.bbd;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/cgi/FinderGetTopicInfoCgi;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicInfoResponse;", "topicId", "", "encryptedTopicEventId", "", "(JLjava/lang/String;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderGetTopicInfoRequest;", "getKey", "initReqResp", "", "onCgiEnd", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<bbe>
{
  public static final a AtA;
  private bbd AtB;
  
  static
  {
    AppMethodBeat.i(347951);
    AtA = new a((byte)0);
    AppMethodBeat.o(347951);
  }
  
  public a(long paramLong, String paramString)
  {
    AppMethodBeat.i(347945);
    this.AtB = new bbd();
    Object localObject = this.AtB;
    bi localbi = bi.ABn;
    ((bbd)localObject).ZHY = bi.dVu();
    this.AtB.ADo = paramLong;
    this.AtB.ZLT = paramString;
    Log.i("Cgi.FinderGetTopicInfoCgi", s.X("topicId: ", Long.valueOf(paramLong)));
    paramString = new c.a();
    paramString.otE = ((com.tencent.mm.bx.a)this.AtB);
    localObject = new bbe();
    ((bbe)localObject).setBaseResponse(new kd());
    ((bbe)localObject).getBaseResponse().akjO = new etl();
    paramString.otF = ((com.tencent.mm.bx.a)localObject);
    paramString.uri = "/cgi-bin/micromsg-bin/findergettopicinfo";
    paramString.funcId = 6277;
    c(paramString.bEF());
    AppMethodBeat.o(347945);
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(347957);
    String str = "6277+" + this.AtB.ADo + '+' + this.AtB.ZLT;
    AppMethodBeat.o(347957);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/cgi/FinderGetTopicInfoCgi$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.cgi.a
 * JD-Core Version:    0.7.0.1
 */