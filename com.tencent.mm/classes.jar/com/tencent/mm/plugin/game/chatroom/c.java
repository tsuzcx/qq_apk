package com.tencent.mm.plugin.game.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.chatroom.f.a;
import java.io.IOException;

public final class c
{
  public static boolean aFp(String paramString)
  {
    AppMethodBeat.i(275615);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@gamelifechatroom");
      AppMethodBeat.o(275615);
      return bool;
    }
    AppMethodBeat.o(275615);
    return false;
  }
  
  public static a b(ChatroomUserData paramChatroomUserData)
  {
    AppMethodBeat.i(275623);
    a locala = new a();
    if (paramChatroomUserData == null)
    {
      AppMethodBeat.o(275623);
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
      AppMethodBeat.o(275623);
      return locala;
    }
    catch (IOException paramChatroomUserData)
    {
      break label160;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c
 * JD-Core Version:    0.7.0.1
 */