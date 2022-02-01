package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.gamelife.b.j;
import com.tencent.mm.plugin.gamelife.b.k;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatUserInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatUserInfoResponse;", "userNameList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends b<k>
{
  public static final a JaW;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(268213);
    JaW = new a((byte)0);
    TAG = "MicroMsg.CgiGetChatUserInfo";
    AppMethodBeat.o(268213);
  }
  
  public d(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(268200);
    c.a locala = new c.a();
    j localj = new j();
    localj.username_list = paramLinkedList;
    locala.otE = ((a)localj);
    locala.otF = ((a)new k());
    locala.uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatuserinfo";
    locala.funcId = 1111;
    c(locala.bEF());
    AppMethodBeat.o(268200);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatUserInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.d
 * JD-Core Version:    0.7.0.1
 */