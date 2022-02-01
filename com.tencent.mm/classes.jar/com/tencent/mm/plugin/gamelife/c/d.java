package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.plugin.gamelife.b.j;
import com.tencent.mm.plugin.gamelife.b.k;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatUserInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatUserInfoResponse;", "userNameList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class d
  extends com.tencent.mm.ak.a<k>
{
  private static final String TAG = "MicroMsg.CgiGetChatUserInfo";
  public static final a uJg;
  
  static
  {
    AppMethodBeat.i(212042);
    uJg = new a((byte)0);
    TAG = "MicroMsg.CgiGetChatUserInfo";
    AppMethodBeat.o(212042);
  }
  
  public d(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(212041);
    b.a locala = new b.a();
    j localj = new j();
    localj.uIU = paramLinkedList;
    locala.c((com.tencent.mm.bw.a)localj);
    locala.d((com.tencent.mm.bw.a)new k());
    locala.DN("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatuserinfo");
    locala.oS(1111);
    c(locala.aDS());
    AppMethodBeat.o(212041);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatUserInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.d
 * JD-Core Version:    0.7.0.1
 */