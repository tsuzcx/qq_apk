package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.apo;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderAdLiveNotice;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderAdLiveNoticeResponse;", "userName", "", "noticeId", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "getNoticeId", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/protocal/protobuf/FinderAdLiveNoticeRequest;", "getUserName", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
public final class e
  extends c<app>
{
  private final String TAG;
  private final String fwt;
  private final String userName;
  private apo xat;
  
  public e(String paramString1, String paramString2)
  {
    super(null);
    AppMethodBeat.i(272445);
    this.userName = paramString1;
    this.fwt = paramString2;
    this.TAG = "Finder.CgiFinderAdLiveNotice";
    this.xat = new apo();
    this.xat.finderUsername = this.userName;
    this.xat.fwt = this.fwt;
    paramString1 = new d.a();
    paramString1.c((a)this.xat);
    paramString2 = new app();
    paramString2.setBaseResponse(new jh());
    paramString2.getBaseResponse().Tef = new eaf();
    paramString1.d((a)paramString2);
    paramString1.TW("/cgi-bin/micromsg-bin/finderadlivenotice");
    paramString1.vD(4164);
    c(paramString1.bgN());
    Log.i(this.TAG, "init userName:" + this.userName + ", noticeId:" + this.fwt);
    AppMethodBeat.o(272445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.e
 * JD-Core Version:    0.7.0.1
 */