package com.tencent.mm.plugin.game.chatroom.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.g.a.c;
import com.tencent.mm.plugin.game.chatroom.PluginGameChatRoom;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/loader/ChatRoomAvatarData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getUrl", "getPath", "isLegal", "", "uniqueValue", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  private final String md5;
  final String url;
  
  public a(String paramString)
  {
    AppMethodBeat.i(275864);
    this.url = paramString;
    String str = this.url;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    this.md5 = MD5Util.getMD5String(paramString);
    AppMethodBeat.o(275864);
  }
  
  public final String aUt()
  {
    AppMethodBeat.i(275873);
    String str = s.X("gamechatroom_avatar_", this.md5);
    AppMethodBeat.o(275873);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(275879);
    String str = s.X(((PluginGameChatRoom)h.az(PluginGameChatRoom.class)).AmC, aUt());
    AppMethodBeat.o(275879);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.g.a
 * JD-Core Version:    0.7.0.1
 */