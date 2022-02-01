package com.tencent.mm.plugin.game.chatroom.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.plugin.game.chatroom.PluginGameChatRoom;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/chatroom/loader/ChatRoomAvatarData;", "Lcom/tencent/mm/loader/model/data/ILoaderData;", "url", "", "(Ljava/lang/String;)V", "md5", "kotlin.jvm.PlatformType", "getMd5", "()Ljava/lang/String;", "getUrl", "getPath", "isLegal", "", "uniqueValue", "game-chatroom_release"})
public final class a
  implements c
{
  private final String md5;
  final String url;
  
  public a(String paramString)
  {
    AppMethodBeat.i(211464);
    this.url = paramString;
    String str = this.url;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    this.md5 = MD5Util.getMD5String(paramString);
    AppMethodBeat.o(211464);
  }
  
  public final String aBv()
  {
    AppMethodBeat.i(211459);
    String str = "gamechatroom_avatar_" + this.md5;
    AppMethodBeat.o(211459);
    return str;
  }
  
  public final String getPath()
  {
    AppMethodBeat.i(211461);
    String str = ((PluginGameChatRoom)h.ag(PluginGameChatRoom.class)).wQa + aBv();
    AppMethodBeat.o(211461);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.f.a
 * JD-Core Version:    0.7.0.1
 */