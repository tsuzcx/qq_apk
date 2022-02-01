package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAudienceReserveLive;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveResponse;", "userName", "", "noticeId", "optype", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getNoticeId", "()Ljava/lang/String;", "getOptype", "()I", "request", "Lcom/tencent/mm/protocal/protobuf/FinderAudienceReserveLiveRequest;", "getUserName", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class e
  extends an<aos>
{
  private final String TAG;
  private final String dDJ;
  private final int dYx;
  private aor tsM;
  private final String userName;
  
  public e(String paramString1, String paramString2)
  {
    super(null);
    AppMethodBeat.i(242206);
    this.userName = paramString1;
    this.dDJ = paramString2;
    this.dYx = 1;
    this.TAG = "Finder.CgiFinderAudienceReserveLive";
    this.tsM = new aor();
    this.tsM.LAN = this.userName;
    this.tsM.dDJ = this.dDJ;
    this.tsM.opType = this.dYx;
    paramString1 = new d.a();
    paramString1.c((a)this.tsM);
    paramString2 = new aos();
    paramString2.setBaseResponse(new BaseResponse());
    paramString2.getBaseResponse().ErrMsg = new dqi();
    paramString1.d((a)paramString2);
    paramString1.MB("/cgi-bin/micromsg-bin/finderaudiencereservelive");
    paramString1.sG(6276);
    c(paramString1.aXF());
    Log.i(this.TAG, "init userName:" + this.userName + ", noticeId:" + this.dDJ + " ,optype:" + this.dYx + ' ');
    AppMethodBeat.o(242206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.e
 * JD-Core Version:    0.7.0.1
 */