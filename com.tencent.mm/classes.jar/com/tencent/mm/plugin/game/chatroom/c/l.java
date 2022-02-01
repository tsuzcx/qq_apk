package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.autogen.chatroom.GetUserAtMemberListRequest;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/cgi/CgiGetUserAtMemberList;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "chatroomName", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCommReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "commReqResp$delegate", "Lkotlin/Lazy;", "request", "Lcom/tencent/mm/plugin/game/autogen/chatroom/GetUserAtMemberListRequest;", "getRequest", "()Lcom/tencent/mm/plugin/game/autogen/chatroom/GetUserAtMemberListRequest;", "response", "Lcom/tencent/mm/plugin/game/autogen/chatroom/GetUserAtMemberListResponse;", "getResponse", "()Lcom/tencent/mm/plugin/game/autogen/chatroom/GetUserAtMemberListResponse;", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends p
  implements m
{
  public static final a Ijn;
  private final j Ijk;
  private h callback;
  private final String chatroomName;
  
  static
  {
    AppMethodBeat.i(275847);
    Ijn = new a((byte)0);
    AppMethodBeat.o(275847);
  }
  
  public l(String paramString)
  {
    AppMethodBeat.i(275831);
    this.chatroomName = paramString;
    this.Ijk = k.a(o.aiuH, (a)new b(this));
    AppMethodBeat.o(275831);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275875);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)getCommReqResp(), (m)this);
    AppMethodBeat.o(275875);
    return i;
  }
  
  public final GetUserAtMemberListRequest fCC()
  {
    AppMethodBeat.i(275863);
    Object localObject = c.b.b(getCommReqResp().otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.chatroom.GetUserAtMemberListRequest");
      AppMethodBeat.o(275863);
      throw ((Throwable)localObject);
    }
    localObject = (GetUserAtMemberListRequest)localObject;
    AppMethodBeat.o(275863);
    return localObject;
  }
  
  public final c getCommReqResp()
  {
    AppMethodBeat.i(275856);
    Object localObject = this.Ijk.getValue();
    kotlin.g.b.s.s(localObject, "<get-commReqResp>(...)");
    localObject = (c)localObject;
    AppMethodBeat.o(275856);
    return localObject;
  }
  
  public final int getType()
  {
    return 5069;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275883);
    Log.i("GameChatRoom.CgiGetUserAtMemberList", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
    }
    AppMethodBeat.o(275883);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/cgi/CgiGetUserAtMemberList$Companion;", "", "()V", "CGI_PATH", "", "TAG", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<c>
  {
    b(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.l
 * JD-Core Version:    0.7.0.1
 */