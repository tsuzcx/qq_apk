package com.tencent.mm.plugin.game.chatroom.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.game.autogen.chatroom.AdminInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.BatchGetSimpleChatroomMemberResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserSimpleData;
import com.tencent.mm.plugin.game.chatroom.k.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.o;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/cgi/CgiGetSimpleChatroomMember;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "userNameList", "Ljava/util/LinkedList;", "", "chatroomName", "adminInfo", "Lcom/tencent/mm/plugin/game/autogen/chatroom/AdminInfo;", "keepBatching", "", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfo;", "(Ljava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/plugin/game/autogen/chatroom/AdminInfo;ZLkotlinx/coroutines/CancellableContinuation;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getChatroomName", "()Ljava/lang/String;", "commReqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "getCommReqResp", "()Lcom/tencent/mm/modelbase/CommReqResp;", "commReqResp$delegate", "Lkotlin/Lazy;", "getKeepBatching", "()Z", "request", "Lcom/tencent/mm/plugin/game/autogen/chatroom/BatchGetSimpleChatroomMemberRequest;", "getRequest", "()Lcom/tencent/mm/plugin/game/autogen/chatroom/BatchGetSimpleChatroomMemberRequest;", "response", "Lcom/tencent/mm/plugin/game/autogen/chatroom/BatchGetSimpleChatroomMemberResponse;", "getResponse", "()Lcom/tencent/mm/plugin/game/autogen/chatroom/BatchGetSimpleChatroomMemberResponse;", "simpleUserService", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDao;", "kotlin.jvm.PlatformType", "getSimpleUserService", "()Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDao;", "simpleUserService$delegate", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getType", "handleGetSimpleChatroomMember", "", "errType", "errCode", "errMsg", "onGYNetEnd", "netId", "rr", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends com.tencent.mm.am.p
  implements m
{
  public static final a Ijg;
  private final AdminInfo Ijh;
  public final boolean Iji;
  private final j Ijj;
  private final j Ijk;
  private final kotlinx.coroutines.p<List<? extends com.tencent.mm.plugin.game.chatroom.f.c>> bgf;
  private h callback;
  public final String chatroomName;
  private final LinkedList<String> osR;
  
  static
  {
    AppMethodBeat.i(275845);
    Ijg = new a((byte)0);
    AppMethodBeat.o(275845);
  }
  
  public k(LinkedList<String> paramLinkedList, String paramString, AdminInfo paramAdminInfo, boolean paramBoolean, kotlinx.coroutines.p<? super List<? extends com.tencent.mm.plugin.game.chatroom.f.c>> paramp)
  {
    AppMethodBeat.i(275803);
    this.osR = paramLinkedList;
    this.chatroomName = paramString;
    this.Ijh = paramAdminInfo;
    this.Iji = paramBoolean;
    this.bgf = paramp;
    this.Ijj = kotlin.k.a(o.aiuH, (a)c.Ijm);
    this.Ijk = kotlin.k.a(o.aiuH, (a)new b(this));
    AppMethodBeat.o(275803);
  }
  
  private com.tencent.mm.am.c getCommReqResp()
  {
    AppMethodBeat.i(275819);
    Object localObject = this.Ijk.getValue();
    kotlin.g.b.s.s(localObject, "<get-commReqResp>(...)");
    localObject = (com.tencent.mm.am.c)localObject;
    AppMethodBeat.o(275819);
    return localObject;
  }
  
  private final void jd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(275832);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      long l = System.currentTimeMillis();
      Object localObject1 = c.c.b(getCommReqResp().otC);
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.chatroom.BatchGetSimpleChatroomMemberResponse");
        AppMethodBeat.o(275832);
        throw ((Throwable)localObject1);
      }
      localObject1 = ((BatchGetSimpleChatroomMemberResponse)localObject1).simple_data_list;
      kotlin.g.b.s.s(localObject1, "response.simple_data_list");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (ChatroomUserSimpleData)((Iterator)localObject2).next();
        localObject3 = new com.tencent.mm.plugin.game.chatroom.f.c();
        ((com.tencent.mm.plugin.game.chatroom.f.c)localObject3).field_compositionKey = kotlin.g.b.s.X(this.chatroomName, ((ChatroomUserSimpleData)localObject4).username);
        ((com.tencent.mm.plugin.game.chatroom.f.c)localObject3).field_userName = ((ChatroomUserSimpleData)localObject4).username;
        ((com.tencent.mm.plugin.game.chatroom.f.c)localObject3).field_nickName = ((ChatroomUserSimpleData)localObject4).nickname;
        ((com.tencent.mm.plugin.game.chatroom.f.c)localObject3).field_roomName = this.chatroomName;
        ((com.tencent.mm.plugin.game.chatroom.f.c)localObject3).field_avatarURL = ((ChatroomUserSimpleData)localObject4).avatar;
        b localb = b.Ioe;
        localObject4 = ((ChatroomUserSimpleData)localObject4).username;
        kotlin.g.b.s.s(localObject4, "it.username");
        ((com.tencent.mm.plugin.game.chatroom.f.c)localObject3).field_role = b.a((String)localObject4, this.Ijh);
        ((com.tencent.mm.plugin.game.chatroom.f.c)localObject3).field_updateTime = l;
        ((Collection)localObject1).add(localObject3);
      }
      localObject1 = (List)localObject1;
      if ((this.bgf != null) && (this.bgf.isActive()))
      {
        localObject2 = (kotlin.d.d)this.bgf;
        localObject3 = Result.Companion;
        ((kotlin.d.d)localObject2).resumeWith(Result.constructor-impl(localObject1));
      }
      ((com.tencent.mm.plugin.game.chatroom.f.d)this.Ijj.getValue()).z((List)localObject1, this.chatroomName);
    }
    AppMethodBeat.o(275832);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(275861);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)getCommReqResp(), (m)this);
    AppMethodBeat.o(275861);
    return i;
  }
  
  public final int getType()
  {
    return 4952;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(275870);
    Log.i("ChatroomMemberPreloadManager.SyncRoomMember", "errType = " + paramInt2 + ", errCode = " + paramInt3 + ", errMsg = " + paramString);
    jd(paramInt2, paramInt3);
    params = this.callback;
    if (params != null) {
      params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
    }
    AppMethodBeat.o(275870);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/cgi/CgiGetSimpleChatroomMember$Companion;", "", "()V", "CGI_PATH", "", "TAG", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<com.tencent.mm.am.c>
  {
    b(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDao;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<com.tencent.mm.plugin.game.chatroom.f.d>
  {
    public static final c Ijm;
    
    static
    {
      AppMethodBeat.i(275758);
      Ijm = new c();
      AppMethodBeat.o(275758);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.c.k
 * JD-Core Version:    0.7.0.1
 */