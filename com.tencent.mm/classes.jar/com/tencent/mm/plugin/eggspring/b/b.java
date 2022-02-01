package com.tencent.mm.plugin.eggspring.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.t.a.i;
import com.tencent.mm.t.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/eggspring/cgi/GetEggRedEnvelopeCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/eggspring/model/GetRedpacketCoverRecvEntranceResp;", "()V", "plugin-eggspring_release"})
public final class b
  extends c<j>
{
  public b()
  {
    AppMethodBeat.i(249664);
    i locali = new i();
    d.a locala = new d.a();
    locala.c((a)locali);
    locala.d((a)new j());
    locala.TW("/cgi-bin/micromsg-bin/getredpacketcoverrecventrance");
    locala.vD(4074);
    c(locala.bgN());
    AppMethodBeat.o(249664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.b.b
 * JD-Core Version:    0.7.0.1
 */