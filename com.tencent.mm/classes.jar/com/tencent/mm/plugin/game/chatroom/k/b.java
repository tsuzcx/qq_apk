package com.tencent.mm.plugin.game.chatroom.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.AdminInfo;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/utils/ChatroomUserUtil;", "", "()V", "getUserRole", "", "userName", "", "adminInfo", "Lcom/tencent/mm/plugin/game/autogen/chatroom/AdminInfo;", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b Ioe;
  
  static
  {
    AppMethodBeat.i(275720);
    Ioe = new b();
    AppMethodBeat.o(275720);
  }
  
  public static int a(String paramString, AdminInfo paramAdminInfo)
  {
    int i = 1;
    AppMethodBeat.i(275711);
    s.u(paramString, "userName");
    if (paramAdminInfo == null) {}
    for (Object localObject = null; s.p(localObject, paramString); localObject = paramAdminInfo.owner_username)
    {
      AppMethodBeat.o(275711);
      return 1;
    }
    if (paramAdminInfo != null)
    {
      paramAdminInfo = paramAdminInfo.admin_username_list;
      if ((paramAdminInfo == null) || (paramAdminInfo.contains(paramString) != true)) {}
    }
    while (i != 0)
    {
      AppMethodBeat.o(275711);
      return 2;
      i = 0;
    }
    AppMethodBeat.o(275711);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.k.b
 * JD-Core Version:    0.7.0.1
 */