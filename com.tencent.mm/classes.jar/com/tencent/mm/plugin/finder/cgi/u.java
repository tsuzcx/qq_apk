package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetLiveNotice;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveNoticeResponse;", "noticeId", "", "appid", "anchorFinderUsername", "lastNoticeStartTime", "", "callBack", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetLiveNotice$Callback;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "order", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderGetLiveNotice$Callback;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;I)V", "TAG", "getAnchorFinderUsername", "()Ljava/lang/String;", "getAppid", "getCallBack", "()Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetLiveNotice$Callback;", "getLastNoticeStartTime", "()I", "getNoticeId", "getOrder", "onCgiEnd", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Callback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends c<azt>
{
  private final String Azl;
  private final int Azm;
  final a Azn;
  private final String TAG;
  private final String appid;
  private final String hAR;
  private final int order;
  
  public u()
  {
    this(null, null, null, 0, null, 0, 127);
  }
  
  private u(String paramString1, String paramString2, String paramString3, int paramInt1, a parama, int paramInt2)
  {
    super(null);
    AppMethodBeat.i(336413);
    this.hAR = paramString1;
    this.appid = paramString2;
    this.Azl = paramString3;
    this.Azm = paramInt1;
    this.Azn = parama;
    this.order = paramInt2;
    this.TAG = "Finder.CgiFinderGetLiveNotice";
    paramString1 = new azs();
    paramString1.YSS = this.hAR;
    paramString2 = (CharSequence)this.appid;
    if ((paramString2 == null) || (paramString2.length() == 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0)
      {
        paramString2 = new bkr();
        paramString2.hUo = 1;
        paramString2.YPU = this.appid;
        paramString3 = ah.aiuX;
        paramString1.ZEk = paramString2;
      }
      paramString1.ZKq = this.Azl;
      paramString1.ZKr = this.Azm;
      paramString1.order = this.order;
      paramString2 = new c.a();
      paramString2.otE = ((com.tencent.mm.bx.a)paramString1);
      paramString1 = new azt();
      paramString1.setBaseResponse(new kd());
      paramString1.getBaseResponse().akjO = new etl();
      paramString2.otF = ((com.tencent.mm.bx.a)paramString1);
      paramString2.uri = "/cgi-bin/micromsg-bin/findergetlivenotice";
      paramString2.funcId = 5872;
      c(paramString2.bEF());
      Log.i(this.TAG, "init noticeId:" + this.hAR + " order:" + this.order + " appid:" + this.appid);
      AppMethodBeat.o(336413);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetLiveNotice$Callback;", "", "onCgiEnd", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLiveNoticeResponse;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, azt paramazt);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(u paramu, int paramInt1, int paramInt2, String paramString, azt paramazt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.u
 * JD-Core Version:    0.7.0.1
 */