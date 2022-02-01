package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.gamelife.b.j;
import com.tencent.mm.plugin.gamelife.b.k;
import java.util.LinkedList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatUserInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatUserInfoResponse;", "userNameList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class d
  extends c<k>
{
  public static final a Dhc;
  private static final String TAG = "MicroMsg.CgiGetChatUserInfo";
  
  static
  {
    AppMethodBeat.i(204148);
    Dhc = new a((byte)0);
    TAG = "MicroMsg.CgiGetChatUserInfo";
    AppMethodBeat.o(204148);
  }
  
  public d(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(204147);
    com.tencent.mm.an.d.a locala = new com.tencent.mm.an.d.a();
    j localj = new j();
    localj.username_list = paramLinkedList;
    locala.c((a)localj);
    locala.d((a)new k());
    locala.TW("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatuserinfo");
    locala.vD(1111);
    c(locala.bgN());
    AppMethodBeat.o(204147);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatUserInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.d
 * JD-Core Version:    0.7.0.1
 */