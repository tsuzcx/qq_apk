package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.gamelife.b.f;
import com.tencent.mm.plugin.gamelife.b.g;
import java.util.LinkedList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataResponse;", "sessionIdList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "request", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "getRequest", "()Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionDataRequest;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class b
  extends c<g>
{
  public static final a ybv;
  private final f ybu;
  
  static
  {
    AppMethodBeat.i(241276);
    ybv = new a((byte)0);
    AppMethodBeat.o(241276);
  }
  
  public b(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(241275);
    this.ybu = new f();
    d.a locala = new d.a();
    this.ybu.ybg = paramLinkedList;
    locala.c((a)this.ybu);
    locala.d((a)new g());
    locala.MB("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatsessiondata");
    locala.sG(1910);
    c(locala.aXF());
    AppMethodBeat.o(241275);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatSessionData$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.b
 * JD-Core Version:    0.7.0.1
 */