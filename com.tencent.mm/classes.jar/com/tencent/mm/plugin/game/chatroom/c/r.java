package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.autogen.chatroom.SyncChatroomMemberRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.SyncChatroomMemberResponse;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/cgi/CgiSyncChatroomMember;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatroomName", "", "lastVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCommReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "commReqResp$delegate", "Lkotlin/Lazy;", "request", "Lcom/tencent/mm/plugin/game/autogen/chatroom/SyncChatroomMemberRequest;", "getRequest", "()Lcom/tencent/mm/plugin/game/autogen/chatroom/SyncChatroomMemberRequest;", "response", "Lcom/tencent/mm/plugin/game/autogen/chatroom/SyncChatroomMemberResponse;", "getResponse", "()Lcom/tencent/mm/plugin/game/autogen/chatroom/SyncChatroomMemberResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends p
  implements m
{
  public static final a Ijs;
  private final j Ijk;
  private final String Ijt;
  private h callback;
  private final String chatroomName;
  
  static
  {
    AppMethodBeat.i(275809);
    Ijs = new a((byte)0);
    AppMethodBeat.o(275809);
  }
  
  public r(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275779);
    this.chatroomName = paramString1;
    this.Ijt = paramString2;
    this.Ijk = k.a(o.aiuH, (a)new b(this));
    AppMethodBeat.o(275779);
  }
  
  private c getCommReqResp()
  {
    AppMethodBeat.i(275787);
    Object localObject = this.Ijk.getValue();
    kotlin.g.b.s.s(localObject, "<get-commReqResp>(...)");
    localObject = (c)localObject;
    AppMethodBeat.o(275787);
    return localObject;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275836);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)getCommReqResp(), (m)this);
    AppMethodBeat.o(275836);
    return i;
  }
  
  public final SyncChatroomMemberResponse fCD()
  {
    AppMethodBeat.i(275816);
    Object localObject = c.c.b(getCommReqResp().otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.chatroom.SyncChatroomMemberResponse");
      AppMethodBeat.o(275816);
      throw ((Throwable)localObject);
    }
    localObject = (SyncChatroomMemberResponse)localObject;
    AppMethodBeat.o(275816);
    return localObject;
  }
  
  public final SyncChatroomMemberRequest fCE()
  {
    AppMethodBeat.i(275823);
    Object localObject = c.b.b(getCommReqResp().otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.chatroom.SyncChatroomMemberRequest");
      AppMethodBeat.o(275823);
      throw ((Throwable)localObject);
    }
    localObject = (SyncChatroomMemberRequest)localObject;
    AppMethodBeat.o(275823);
    return localObject;
  }
  
  public final int getType()
  {
    return 4713;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275844);
    Log.i("GameChatRoom.CgiSyncChatroomMember", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(275844);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/cgi/CgiSyncChatroomMember$Companion;", "", "()V", "CGI_PATH", "", "TAG", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<c>
  {
    b(r paramr)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.r
 * JD-Core Version:    0.7.0.1
 */