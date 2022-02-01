package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.autogen.chatroom.VoteMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.VoteMsgResponse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/cgi/CgiVoteMsg;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatRoomName", "", "seq", "", "isVote", "", "userName", "reportPositionId", "", "(Ljava/lang/String;JZLjava/lang/String;I)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getReportPositionId", "()Ljava/lang/Integer;", "setReportPositionId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSeq", "()Ljava/lang/Long;", "setSeq", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getRequest", "Lcom/tencent/mm/plugin/game/autogen/chatroom/VoteMsgRequest;", "getResponse", "Lcom/tencent/mm/plugin/game/autogen/chatroom/VoteMsgResponse;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends p
  implements m
{
  public static final a Ijv;
  public Long Ijw;
  public Integer Ijx;
  private com.tencent.mm.am.h callback;
  public c mtC;
  public String userName;
  
  static
  {
    AppMethodBeat.i(275811);
    Ijv = new a((byte)0);
    AppMethodBeat.o(275811);
  }
  
  public t(String paramString1, long paramLong, boolean paramBoolean, String paramString2, int paramInt)
  {
    AppMethodBeat.i(275802);
    Object localObject = new c.a();
    ((c.a)localObject).otE = ((a)new VoteMsgRequest());
    ((c.a)localObject).otF = ((a)new VoteMsgResponse());
    ((c.a)localObject).uri = "/cgi-bin/mmgame-bin/gamegamelifeappsvr/votemsg";
    ((c.a)localObject).funcId = getType();
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localObject = ((c.a)localObject).bEF();
    kotlin.g.b.s.s(localObject, "builder.buildInstance()");
    this.mtC = ((c)localObject);
    localObject = c.b.b(this.mtC.otB);
    if (localObject == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.chatroom.VoteMsgRequest");
      AppMethodBeat.o(275802);
      throw paramString1;
    }
    localObject = (VoteMsgRequest)localObject;
    ((VoteMsgRequest)localObject).chatroom_name = paramString1;
    ((VoteMsgRequest)localObject).seq = paramLong;
    ((VoteMsgRequest)localObject).is_vote = paramBoolean;
    paramString1 = com.tencent.mm.kernel.h.baE().ban().get(at.a.acSV, Integer.valueOf(0));
    if (paramString1 == null)
    {
      paramString1 = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(275802);
      throw paramString1;
    }
    if (Util.nullAsNil(Integer.valueOf(((Integer)paramString1).intValue())) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((VoteMsgRequest)localObject).need_education = bool;
      Log.i("GameChatRoom.CgiVoteMsg", "seq:" + paramLong + ", isVote:" + paramBoolean);
      this.Ijw = Long.valueOf(paramLong);
      this.userName = paramString2;
      this.Ijx = Integer.valueOf(paramInt);
      AppMethodBeat.o(275802);
      return;
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(275830);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.mtC, (m)this);
    AppMethodBeat.o(275830);
    return i;
  }
  
  public final int getType()
  {
    return 4569;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275818);
    Log.i("GameChatRoom.CgiVoteMsg", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    params = this.callback;
    kotlin.g.b.s.checkNotNull(params);
    params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    AppMethodBeat.o(275818);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/cgi/CgiVoteMsg$Companion;", "", "()V", "TAG", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.t
 * JD-Core Version:    0.7.0.1
 */