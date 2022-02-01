package com.tencent.mm.plugin.game.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.chatroom.e.a;
import java.io.IOException;

public final class c
{
  public static boolean aIO(String paramString)
  {
    AppMethodBeat.i(210711);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@gamelifechatroom");
      AppMethodBeat.o(210711);
      return bool;
    }
    AppMethodBeat.o(210711);
    return false;
  }
  
  public static a b(ChatroomUserData paramChatroomUserData)
  {
    AppMethodBeat.i(210712);
    a locala = new a();
    if (paramChatroomUserData == null)
    {
      AppMethodBeat.o(210712);
      return locala;
    }
    locala.field_userName = paramChatroomUserData.username;
    locala.field_roomName = paramChatroomUserData.chatroom_name;
    locala.field_nickName = paramChatroomUserData.nickname;
    locala.field_avatarURL = paramChatroomUserData.avatar;
    locala.field_sex = paramChatroomUserData.sex;
    locala.field_jumpInfo = paramChatroomUserData.jump_info;
    locala.field_isAuthorized = paramChatroomUserData.is_authorized;
    locala.field_tagInfo = paramChatroomUserData.tag_info;
    locala.field_lbsInfo = paramChatroomUserData.lbs_info;
    locala.field_role = paramChatroomUserData.role;
    locala.field_canBeAt = paramChatroomUserData.can_be_at;
    locala.field_isRobot = paramChatroomUserData.is_robot;
    locala.field_canKickMember = paramChatroomUserData.can_kick_member;
    locala.field_userRole = paramChatroomUserData.user_role;
    locala.field_canBeKicked = paramChatroomUserData.can_be_kicked;
    locala.field_canAtAll = paramChatroomUserData.can_at_all;
    try
    {
      locala.field_rawPbData = paramChatroomUserData.toByteArray();
      label160:
      AppMethodBeat.o(210712);
      return locala;
    }
    catch (IOException paramChatroomUserData)
    {
      break label160;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c
 * JD-Core Version:    0.7.0.1
 */