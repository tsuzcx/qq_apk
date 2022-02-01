package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.gamelife.b.f;
import com.tencent.mm.plugin.gamelife.b.g;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataResponse;", "sessionIdList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "request", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "getRequest", "()Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class b
  extends c<g>
{
  public static final a Dha;
  private final f DgZ;
  
  static
  {
    AppMethodBeat.i(204003);
    Dha = new a((byte)0);
    AppMethodBeat.o(204003);
  }
  
  public b(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(204002);
    this.DgZ = new f();
    d.a locala = new d.a();
    this.DgZ.DgO = paramLinkedList;
    locala.c((a)this.DgZ);
    locala.d((a)new g());
    locala.TW("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessiondata");
    locala.vD(1910);
    c(locala.bgN());
    AppMethodBeat.o(204002);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.b
 * JD-Core Version:    0.7.0.1
 */