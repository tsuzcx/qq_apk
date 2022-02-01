package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.r.a.i;
import com.tencent.mm.r.a.j;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/eggspring/cgi/GetEggRedEnvelopeCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetRedpacketCoverRecvEntranceResp;", "sessionId", "", "(Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "plugin-eggspring_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.am.b<j>
{
  private final String sessionId;
  
  public b(String paramString)
  {
    AppMethodBeat.i(369738);
    this.sessionId = paramString;
    paramString = new i();
    paramString.session_id = this.sessionId;
    c.a locala = new c.a();
    locala.otE = ((a)paramString);
    locala.otF = ((a)new j());
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketcoverrecventrance";
    locala.funcId = 4074;
    c(locala.bEF());
    AppMethodBeat.o(369738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.b
 * JD-Core Version:    0.7.0.1
 */