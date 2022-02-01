package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.gamelife.b.f;
import com.tencent.mm.plugin.gamelife.b.g;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataResponse;", "sessionIdList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "request", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "getRequest", "()Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.am.b<g>
{
  public static final a JaT;
  private final f JaU;
  
  static
  {
    AppMethodBeat.i(268219);
    JaT = new a((byte)0);
    AppMethodBeat.o(268219);
  }
  
  public b(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(268208);
    this.JaU = new f();
    c.a locala = new c.a();
    this.JaU.JaI = paramLinkedList;
    locala.otE = ((a)this.JaU);
    locala.otF = ((a)new g());
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessiondata";
    locala.funcId = 1910;
    c(locala.bEF());
    AppMethodBeat.o(268208);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.b
 * JD-Core Version:    0.7.0.1
 */