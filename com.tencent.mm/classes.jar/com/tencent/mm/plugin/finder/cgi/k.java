package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderEnterPersonalMsg;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/FinderEnterPersonalMsgResponse;", "my_account_type", "", "to_username", "", "session_id", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getTo_username", "()Ljava/lang/String;", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class k
  extends c<asf>
{
  public static final a xaE;
  private final String sWA;
  
  static
  {
    AppMethodBeat.i(283721);
    xaE = new a((byte)0);
    AppMethodBeat.o(283721);
  }
  
  private k(String paramString1, String paramString2)
  {
    AppMethodBeat.i(283720);
    this.sWA = paramString1;
    paramString1 = new ase();
    Object localObject = ao.xcj;
    paramString1.RLM = ao.a(null);
    paramString1.SFD = 1;
    paramString1.sWA = this.sWA;
    paramString1.session_id = paramString2;
    localObject = new d.a();
    ((d.a)localObject).c((a)paramString1);
    paramString1 = new asf();
    paramString1.setBaseResponse(new jh());
    ((d.a)localObject).d((a)paramString1);
    ((d.a)localObject).TW("/cgi-bin/micromsg-bin/finderenterpersonalmsg");
    ((d.a)localObject).vD(6464);
    c(((d.a)localObject).bgN());
    Log.i("Cgi.FinderEnterPersonalMsg", "CgiFinderEnterPersonalMsg init my_account_type=1 to_username=" + this.sWA + " session_id=" + paramString2);
    AppMethodBeat.o(283720);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderEnterPersonalMsg$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.k
 * JD-Core Version:    0.7.0.1
 */