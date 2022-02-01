package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomPanelRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomPanelResponse;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/cgi/CgiGetChatRoomPanel;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoomName", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "reportPositionId", "", "getReportPositionId", "()Ljava/lang/Integer;", "setReportPositionId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "seq", "", "getSeq", "()Ljava/lang/Long;", "setSeq", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "userName", "getUserName", "()Ljava/lang/String;", "setUserName", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getResponse", "Lcom/tencent/mm/plugin/game/autogen/chatroom/GetChatroomPanelResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends p
  implements m
{
  public static final a Ijf;
  private h callback;
  public c mtC;
  
  static
  {
    AppMethodBeat.i(275855);
    Ijf = new a((byte)0);
    AppMethodBeat.o(275855);
  }
  
  public f(String paramString)
  {
    AppMethodBeat.i(275849);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new GetChatroomPanelRequest());
    ((c.a)localObject).otF = ((a)new GetChatroomPanelResponse());
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/getchatroompanel";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.mtC = ((c)localObject);
    localObject = c.b.b(this.mtC.otB);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomPanelRequest");
      AppMethodBeat.o(275849);
      throw paramString;
    }
    ((GetChatroomPanelRequest)localObject).chatroom_name = paramString;
    AppMethodBeat.o(275849);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275869);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.mtC, (m)this);
    AppMethodBeat.o(275869);
    return i;
  }
  
  public final int getType()
  {
    return 5072;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275876);
    Log.i("GameChatRoom.CgiVoteMsg", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    params = this.callback;
    kotlin.g.b.s.checkNotNull(params);
    params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    AppMethodBeat.o(275876);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/cgi/CgiGetChatRoomPanel$Companion;", "", "()V", "TAG", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.f
 * JD-Core Version:    0.7.0.1
 */