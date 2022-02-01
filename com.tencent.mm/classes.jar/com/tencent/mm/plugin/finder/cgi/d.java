package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aoj;
import com.tencent.mm.protocal.protobuf.aok;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAdLiveNotice;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderAdLiveNoticeResponse;", "userName", "", "noticeId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getNoticeId", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderAdLiveNoticeRequest;", "getUserName", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class d
  extends an<aok>
{
  private final String TAG;
  private final String dDJ;
  private aoj tsL;
  private final String userName;
  
  public d(String paramString1, String paramString2)
  {
    super(null);
    AppMethodBeat.i(242204);
    this.userName = paramString1;
    this.dDJ = paramString2;
    this.TAG = "Finder.CgiFinderAdLiveNotice";
    this.tsL = new aoj();
    this.tsL.finderUsername = this.userName;
    this.tsL.dDJ = this.dDJ;
    paramString1 = new d.a();
    paramString1.c((a)this.tsL);
    paramString2 = new aok();
    paramString2.setBaseResponse(new BaseResponse());
    paramString2.getBaseResponse().ErrMsg = new dqi();
    paramString1.d((a)paramString2);
    paramString1.MB("/cgi-bin/micromsg-bin/finderadlivenotice");
    paramString1.sG(4164);
    c(paramString1.aXF());
    Log.i(this.TAG, "init userName:" + this.userName + ", noticeId:" + this.dDJ);
    AppMethodBeat.o(242204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.d
 * JD-Core Version:    0.7.0.1
 */