package com.tencent.mm.chatroom.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.k.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatroom/ui/RoomSpecialFollowMemberManagerUI$Companion;", "", "()V", "REQUEST_CODE_FOLLOW_MEMBER", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "getRoomLimitWatchMemberMax", "isSupportAssociateRoomFollowMember", "", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RoomSpecialFollowMemberManagerUI$a
{
  public static int aNf()
  {
    AppMethodBeat.i(241554);
    int i = Util.getInt(((a)h.ax(a.class)).aRC().getValue("RoomLimitWatchMemberMax"), 4);
    AppMethodBeat.o(241554);
    return i;
  }
  
  public static boolean aNg()
  {
    AppMethodBeat.i(241561);
    if (Util.getInt(((a)h.ax(a.class)).aRC().getValue("WeComWatchMemberEntry"), 0) == 1)
    {
      AppMethodBeat.o(241561);
      return true;
    }
    AppMethodBeat.o(241561);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomSpecialFollowMemberManagerUI.a
 * JD-Core Version:    0.7.0.1
 */