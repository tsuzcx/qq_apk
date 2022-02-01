package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.ats;
import com.tencent.mm.protocal.protobuf.att;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderAudienceReserveLive;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "userName", "", "noticeId", "optype", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "scene", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;Ljava/lang/Integer;)V", "TAG", "getNoticeId", "()Ljava/lang/String;", "getOptype", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveRequest;", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserName", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c<att>
{
  private final Integer AAE;
  private ats CuS;
  private final String TAG;
  private final String hAR;
  private final int hYl;
  private final String userName;
  
  public a(String paramString1, String paramString2, int paramInt, Integer paramInteger)
  {
    super(null);
    AppMethodBeat.i(351112);
    this.userName = paramString1;
    this.hAR = paramString2;
    this.hYl = paramInt;
    this.AAE = paramInteger;
    this.TAG = "Finder.CgiFinderAudienceReserveLive";
    this.CuS = new ats();
    this.CuS.Azl = this.userName;
    this.CuS.hAR = this.hAR;
    this.CuS.opType = this.hYl;
    paramString1 = this.CuS;
    paramString2 = this.AAE;
    if (paramString2 == null) {}
    for (paramInt = 0;; paramInt = paramString2.intValue())
    {
      paramString1.scene = paramInt;
      paramString1 = new c.a();
      paramString1.otE = ((com.tencent.mm.bx.a)this.CuS);
      paramString2 = new att();
      paramString2.setBaseResponse(new kd());
      paramString2.getBaseResponse().akjO = new etl();
      paramString1.otF = ((com.tencent.mm.bx.a)paramString2);
      paramString1.uri = "/cgi-bin/micromsg-bin/finderaudiencereservelive";
      paramString1.funcId = 6276;
      c(paramString1.bEF());
      Log.i(this.TAG, "init userName:" + this.userName + ", noticeId:" + this.hAR + " ,optype:" + this.hYl + ' ');
      AppMethodBeat.o(351112);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.a
 * JD-Core Version:    0.7.0.1
 */