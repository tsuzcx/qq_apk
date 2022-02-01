package com.tencent.mm.plugin.findersdk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.protocal.protobuf.bgp;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/FinderLiveEntranceVerify;", "Lcom/tencent/mm/plugin/findersdk/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveEntranceVerifyResponse;", "dynamicStatus", "", "callback", "Lkotlin/Function1;", "", "", "(ILkotlin/jvm/functions/Function1;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "getDynamicStatus", "()I", "onCgiEnd", "errType", "errCode", "errMsg", "", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "run", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Companion", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends c<bgp>
{
  public static final a HcL;
  private final int HcM;
  private final b<Boolean, ah> callback;
  
  static
  {
    AppMethodBeat.i(273895);
    HcL = new a((byte)0);
    AppMethodBeat.o(273895);
  }
  
  public d(int paramInt, b<? super Boolean, ah> paramb)
  {
    super(null);
    AppMethodBeat.i(273889);
    this.HcM = paramInt;
    this.callback = paramb;
    paramb = new c.a();
    paramb.uri = "/cgi-bin/micromsg-bin/finderliveentranceverify";
    paramb.funcId = 6826;
    bgo localbgo = new bgo();
    localbgo.ZQd = this.HcM;
    paramb.otE = ((a)localbgo);
    paramb.otF = ((a)new bgp());
    c(paramb.bEF());
    AppMethodBeat.o(273889);
  }
  
  public final f<b.a<bgp>> bFJ()
  {
    AppMethodBeat.i(273904);
    Log.i("FinderLiveEntranceVerif", s.X("FinderLiveEntranceVerify run dynamicStatus: ", Integer.valueOf(this.HcM)));
    f localf = super.bFJ();
    AppMethodBeat.o(273904);
    return localf;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/FinderLiveEntranceVerify$Companion;", "", "()V", "TAG", "", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.d
 * JD-Core Version:    0.7.0.1
 */