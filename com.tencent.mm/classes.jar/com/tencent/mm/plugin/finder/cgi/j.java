package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderCreateLiveNotice;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveNoticeResponse;", "userName", "", "noticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "opType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "request", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveNoticeRequest;", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends c<avy>
{
  public static final a AyH;
  private avx AyI;
  
  static
  {
    AppMethodBeat.i(336337);
    AyH = new a((byte)0);
    AppMethodBeat.o(336337);
  }
  
  public j(String paramString, bkk parambkk, bui parambui)
  {
    AppMethodBeat.i(336331);
    this.AyI = new avx();
    avx localavx = this.AyI;
    bi localbi = bi.ABn;
    localavx.ZEc = bi.dVu();
    this.AyI.finderUsername = paramString;
    this.AyI.liveNoticeInfo = parambkk;
    this.AyI.hYl = 1;
    paramString = this.AyI;
    parambkk = bi.ABn;
    paramString.ZEc = bi.a(parambui);
    paramString = this.AyI.ZEc;
    if (paramString != null) {
      if (parambui != null) {
        break label205;
      }
    }
    label205:
    for (int i = 0;; i = parambui.hLK)
    {
      paramString.scene = i;
      paramString = new c.a();
      paramString.otE = ((a)this.AyI);
      parambkk = new avy();
      parambkk.setBaseResponse(new kd());
      parambkk.getBaseResponse().akjO = new etl();
      paramString.otF = ((a)parambkk);
      paramString.uri = "/cgi-bin/micromsg-bin/findercreatelivenotice";
      paramString.funcId = 6653;
      c(paramString.bEF());
      AppMethodBeat.o(336331);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderCreateLiveNotice$Companion;", "", "()V", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.j
 * JD-Core Version:    0.7.0.1
 */