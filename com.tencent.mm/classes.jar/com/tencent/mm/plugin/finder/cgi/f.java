package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAdLiveNotice;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderAdLiveNoticeResponse;", "userName", "", "noticeId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getNoticeId", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderAdLiveNoticeRequest;", "getUserName", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends c<atj>
{
  private ati Ayx;
  private final String TAG;
  private final String hAR;
  private final String userName;
  
  public f(String paramString1, String paramString2)
  {
    super(null);
    AppMethodBeat.i(336373);
    this.userName = paramString1;
    this.hAR = paramString2;
    this.TAG = "Finder.CgiFinderAdLiveNotice";
    this.Ayx = new ati();
    this.Ayx.finderUsername = this.userName;
    this.Ayx.hAR = this.hAR;
    paramString1 = new c.a();
    paramString1.otE = ((a)this.Ayx);
    paramString2 = new atj();
    paramString2.setBaseResponse(new kd());
    paramString2.getBaseResponse().akjO = new etl();
    paramString1.otF = ((a)paramString2);
    paramString1.uri = "/cgi-bin/micromsg-bin/finderadlivenotice";
    paramString1.funcId = 4164;
    c(paramString1.bEF());
    Log.i(this.TAG, "init userName:" + this.userName + ", noticeId:" + this.hAR);
    AppMethodBeat.o(336373);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.f
 * JD-Core Version:    0.7.0.1
 */