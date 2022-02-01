package com.tencent.mm.plugin.finder.live.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderAudienceReserveLive;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "userName", "", "noticeId", "optype", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getNoticeId", "()Ljava/lang/String;", "getOptype", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveRequest;", "getUserName", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class a
  extends c<apz>
{
  private final String TAG;
  private final int fSo;
  private final String fwt;
  private final String userName;
  private apy xXM;
  
  public a(String paramString1, String paramString2)
  {
    super(null);
    AppMethodBeat.i(277580);
    this.userName = paramString1;
    this.fwt = paramString2;
    this.fSo = 1;
    this.TAG = "Finder.CgiFinderAudienceReserveLive";
    this.xXM = new apy();
    this.xXM.SDn = this.userName;
    this.xXM.fwt = this.fwt;
    this.xXM.opType = this.fSo;
    paramString1 = new d.a();
    paramString1.c((com.tencent.mm.cd.a)this.xXM);
    paramString2 = new apz();
    paramString2.setBaseResponse(new jh());
    paramString2.getBaseResponse().Tef = new eaf();
    paramString1.d((com.tencent.mm.cd.a)paramString2);
    paramString1.TW("/cgi-bin/micromsg-bin/finderaudiencereservelive");
    paramString1.vD(6276);
    c(paramString1.bgN());
    Log.i(this.TAG, "init userName:" + this.userName + ", noticeId:" + this.fwt + " ,optype:" + this.fSo + ' ');
    AppMethodBeat.o(277580);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.cgi.a
 * JD-Core Version:    0.7.0.1
 */