package com.tencent.mm.plugin.game.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f;
import com.tencent.mm.autogen.b.dj;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.mm.plugin.game.autogen.chatroom.JumpInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.TagInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.UserRole;
import com.tencent.mm.plugin.game.chatroom.b.c;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import org.json.JSONObject;

public final class a
  extends dj
  implements c
{
  public static final IAutoDBItem.MAutoDBInfo nVV;
  
  static
  {
    AppMethodBeat.i(275684);
    nVV = dj.aJm();
    AppMethodBeat.o(275684);
  }
  
  private ChatroomUserData fCG()
  {
    AppMethodBeat.i(275678);
    if (this.field_rawPbData != null) {}
    for (;;)
    {
      try
      {
        ChatroomUserData localChatroomUserData = new ChatroomUserData();
        Object localObject = null;
      }
      catch (IOException localIOException1)
      {
        try
        {
          localChatroomUserData.parseFrom(this.field_rawPbData);
          AppMethodBeat.o(275678);
          return localChatroomUserData;
          localIOException1 = localIOException1;
          localObject = null;
        }
        catch (IOException localIOException2) {}
      }
    }
  }
  
  public final String amx()
  {
    return this.field_avatarURL;
  }
  
  public final long dUt()
  {
    return this.field_updateTime;
  }
  
  public final TagInfo fCq()
  {
    return this.field_tagInfo;
  }
  
  public final UserRole fCr()
  {
    return this.field_userRole;
  }
  
  public final boolean fCs()
  {
    return this.field_canBeAt;
  }
  
  public final boolean fCt()
  {
    return this.field_canKickMember;
  }
  
  public final boolean fCu()
  {
    return this.field_canBeKicked;
  }
  
  public final boolean fCv()
  {
    return this.field_canAtAll;
  }
  
  public final JumpInfo fCw()
  {
    return this.field_jumpInfo;
  }
  
  public final String fCx()
  {
    AppMethodBeat.i(275749);
    Object localObject = fCG();
    if (localObject != null)
    {
      localObject = f.dg(localObject);
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).toString();
        AppMethodBeat.o(275749);
        return localObject;
      }
    }
    AppMethodBeat.o(275749);
    return "";
  }
  
  public final boolean fCy()
  {
    return (this.field_role == 1) || (this.field_role == 2);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return nVV;
  }
  
  public final String getNickName()
  {
    return this.field_nickName;
  }
  
  public final String getUserName()
  {
    return this.field_userName;
  }
  
  public final String print()
  {
    AppMethodBeat.i(275696);
    String str = "userName: " + this.field_userName + "; roomName: " + this.field_roomName;
    AppMethodBeat.o(275696);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.f.a
 * JD-Core Version:    0.7.0.1
 */