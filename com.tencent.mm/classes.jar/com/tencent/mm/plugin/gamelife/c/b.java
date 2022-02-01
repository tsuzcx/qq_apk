package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.b.f;
import com.tencent.mm.plugin.gamelife.b.g;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataResponse;", "sessionIdList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "request", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "getRequest", "()Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class b
  extends com.tencent.mm.ak.a<g>
{
  public static final a uJe;
  private final f uJd;
  
  static
  {
    AppMethodBeat.i(212036);
    uJe = new a((byte)0);
    AppMethodBeat.o(212036);
  }
  
  public b(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(212035);
    this.uJd = new f();
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    this.uJd.uIR = paramLinkedList;
    locala.c((com.tencent.mm.bw.a)this.uJd);
    locala.d((com.tencent.mm.bw.a)new g());
    locala.DN("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessiondata");
    locala.oS(1910);
    c(locala.aDS());
    AppMethodBeat.o(212035);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.b
 * JD-Core Version:    0.7.0.1
 */