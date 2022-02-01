package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.gamelife.b.j;
import com.tencent.mm.plugin.gamelife.b.k;
import java.util.LinkedList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatUserInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatUserInfoResponse;", "userNameList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class d
  extends c<k>
{
  private static final String TAG = "MicroMsg.CgiGetChatUserInfo";
  public static final a ybx;
  
  static
  {
    AppMethodBeat.i(241282);
    ybx = new a((byte)0);
    TAG = "MicroMsg.CgiGetChatUserInfo";
    AppMethodBeat.o(241282);
  }
  
  public d(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(241281);
    com.tencent.mm.ak.d.a locala = new com.tencent.mm.ak.d.a();
    j localj = new j();
    localj.ybk = paramLinkedList;
    locala.c((a)localj);
    locala.d((a)new k());
    locala.MB("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatuserinfo");
    locala.sG(1111);
    c(locala.aXF());
    AppMethodBeat.o(241281);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatUserInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.d
 * JD-Core Version:    0.7.0.1
 */