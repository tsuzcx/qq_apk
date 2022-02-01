package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gamelife.b.e;
import com.tencent.mm.plugin.gamelife.b.f;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataResponse;", "sessionIdList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "request", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "getRequest", "()Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class b
  extends com.tencent.mm.al.a<f>
{
  public static final a uxB;
  private final e uxA;
  
  static
  {
    AppMethodBeat.i(211269);
    uxB = new a((byte)0);
    AppMethodBeat.o(211269);
  }
  
  public b(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(211268);
    this.uxA = new e();
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    this.uxA.uxp = paramLinkedList;
    locala.c((com.tencent.mm.bx.a)this.uxA);
    locala.d((com.tencent.mm.bx.a)new f());
    locala.Dl("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessiondata");
    locala.oP(1910);
    c(locala.aDC());
    AppMethodBeat.o(211268);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.b
 * JD-Core Version:    0.7.0.1
 */