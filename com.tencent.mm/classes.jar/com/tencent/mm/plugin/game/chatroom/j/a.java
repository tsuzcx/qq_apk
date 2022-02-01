package com.tencent.mm.plugin.game.chatroom.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.LocalMyChatRoom;
import com.tencent.mm.plugin.game.autogen.chatroom.MyChatroomNotice;
import com.tencent.mm.plugin.game.chatroom.b.c;
import com.tencent.mm.plugin.game.chatroom.h.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/service/MyChatRoomPreFetchService;", "Lcom/tencent/mm/plugin/game/chatroom/callback/IChatRoomCgiCallback;", "Lcom/tencent/mm/plugin/game/autogen/chatroom/LocalMyChatRoom;", "()V", "mGetMyChatRoomKeepAliveService", "Lcom/tencent/mm/plugin/game/chatroom/longpolling/GetMyChatRoomKeepAliveService;", "mHasUnreadMsg", "", "mLocalMyChatRoom", "mMyChatroomNotice", "Lcom/tencent/mm/plugin/game/autogen/chatroom/MyChatroomNotice;", "getChatRoomNotice", "getLocalMyChatRoom", "hasUnreadMsg", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "type", "Lcom/tencent/mm/plugin/game/chatroom/ConstantsChatRoom$KeepLiveType;", "data", "pauseService", "resumeService", "setScene", "scene", "startService", "topChatRoomName", "stopService", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.plugin.game.chatroom.b.a<LocalMyChatRoom>
{
  public static final a Imu;
  private static b Imv;
  private static LocalMyChatRoom Imw;
  private static boolean Imx;
  private static MyChatroomNotice Imy;
  
  static
  {
    AppMethodBeat.i(275834);
    Imu = new a();
    Imv = new b(b.c.Ieb, (com.tencent.mm.plugin.game.chatroom.b.a)Imu);
    AppMethodBeat.o(275834);
  }
  
  public static void dyq()
  {
    AppMethodBeat.i(275784);
    Imv.fCK();
    AppMethodBeat.o(275784);
  }
  
  public static void fCV()
  {
    AppMethodBeat.i(275772);
    Imv.fCL();
    AppMethodBeat.o(275772);
  }
  
  public static LocalMyChatRoom fCW()
  {
    return Imw;
  }
  
  public static MyChatroomNotice fCX()
  {
    return Imy;
  }
  
  public static boolean fCY()
  {
    return Imx;
  }
  
  public static void setScene(int paramInt)
  {
    Imv.mScene = paramInt;
  }
  
  public static void stopService()
  {
    AppMethodBeat.i(275765);
    Imv.fCJ();
    Imw = null;
    Imy = null;
    Imx = false;
    AppMethodBeat.o(275765);
  }
  
  public final void startService(String paramString)
  {
    AppMethodBeat.i(275846);
    Imv.IkG = ((com.tencent.mm.plugin.game.chatroom.b.a)this);
    Imv.aFA(paramString);
    AppMethodBeat.o(275846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.j.a
 * JD-Core Version:    0.7.0.1
 */