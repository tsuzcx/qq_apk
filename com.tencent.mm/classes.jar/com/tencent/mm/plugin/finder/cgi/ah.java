package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.atp;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedListResp;", "feedId", "", "nonceId", "", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getFeedId", "()J", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class ah
  extends c<atp>
{
  private static final boolean cWq;
  public static final a tup;
  private final long feedId;
  private final String hwg;
  private final atn tuo;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(242306);
    tup = new a((byte)0);
    if ((BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.IS_FLAVOR_RED) || (CrashReportFactory.hasDebuger())) {
      bool = true;
    }
    cWq = bool;
    AppMethodBeat.o(242306);
  }
  
  public ah(long paramLong, String paramString, atn paramatn, bbn parambbn)
  {
    AppMethodBeat.i(242305);
    this.feedId = paramLong;
    this.hwg = paramString;
    this.tuo = paramatn;
    paramString = g.aAh();
    p.g(paramString, "MMKernel.storage()");
    paramString = paramString.azQ();
    paramatn = y.vXH;
    paramString = paramString.get(y.LK(4), "");
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.String");
      AppMethodBeat.o(242305);
      throw paramString;
    }
    paramatn = b.cD(Util.decodeHexString((String)paramString));
    d.a locala = new d.a();
    locala.sG(3688);
    paramString = new ato();
    paramString.hFK = this.feedId;
    paramString.objectNonceId = this.hwg;
    am localam = am.tuw;
    paramString.LAI = am.a(parambbn);
    paramString.scene = 4;
    paramString.dLS = 4;
    paramString.txf = paramatn;
    paramString.LEs = this.tuo;
    locala.c((a)paramString);
    locala.d((a)new atp());
    locala.MB("/cgi-bin/micromsg-bin/findergetrelatedlist");
    c(locala.aXF());
    paramatn = new StringBuilder("feedId=").append(d.zs(this.feedId)).append(" objectNonceId=").append(this.hwg).append(" streamLastBuffer=").append(paramatn).append(" related_entrance_info=");
    if (paramString.LEs == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("CgiGetHotRelatedList", bool);
      AppMethodBeat.o(242305);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/CgiGetHotRelatedList$Companion;", "", "()V", "TAG", "", "isDebug", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ah
 * JD-Core Version:    0.7.0.1
 */