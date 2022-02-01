package com.tencent.mm.plugin.gamelife.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.plugin.gamelife.b.i;
import com.tencent.mm.plugin.gamelife.b.j;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatUserInfo;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatUserInfoResponse;", "userNameList", "Ljava/util/LinkedList;", "", "(Ljava/util/LinkedList;)V", "onCgiBack", "", "errType", "", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-gamelife_release"})
public final class d
  extends com.tencent.mm.al.a<j>
{
  private static final String TAG = "MicroMsg.CgiGetChatUserInfo";
  public static final a uxD;
  
  static
  {
    AppMethodBeat.i(211275);
    uxD = new a((byte)0);
    TAG = "MicroMsg.CgiGetChatUserInfo";
    AppMethodBeat.o(211275);
  }
  
  public d(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(211274);
    b.a locala = new b.a();
    i locali = new i();
    locali.uxr = paramLinkedList;
    locala.c((com.tencent.mm.bx.a)locali);
    locala.d((com.tencent.mm.bx.a)new j());
    locala.Dl("/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatuserinfo");
    locala.oP(1111);
    c(locala.aDC());
    AppMethodBeat.o(211274);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/cgi/CgiGetChatUserInfo$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.c.d
 * JD-Core Version:    0.7.0.1
 */