package com.tencent.mm.plugin.game.chatroom.l;

import androidx.lifecycle.af;
import androidx.lifecycle.ag;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.chatroom.AdminInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.ChatroomUserData;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.o;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/viewmodel/ChatroomMemberViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "chatroomName", "", "getChatroomName", "()Ljava/lang/String;", "setChatroomName", "(Ljava/lang/String;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext$delegate", "Lkotlin/Lazy;", "coroutineExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getCoroutineExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler$delegate", "filterUserList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mentionUsersLiveData", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/mm/plugin/game/chatroom/data/MentionUserResultWrapper;", "robotName", "getRobotName", "setRobotName", "searchResultLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mm/plugin/game/chatroom/data/MentionUserWrapper;", "getSearchResultLiveData", "()Landroidx/lifecycle/MutableLiveData;", "simpleUserService", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDao;", "kotlin.jvm.PlatformType", "getSimpleUserService", "()Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDao;", "simpleUserService$delegate", "deleteAllChatroomMember", "", "getCurState", "getMemberFromLocal", "Landroidx/lifecycle/LiveData;", "getMentionUsersLiveData", "insertUsers", "updateUserList", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomUserData;", "adminInfo", "Lcom/tencent/mm/plugin/game/autogen/chatroom/AdminInfo;", "loadMemberFromLocal", "onCleared", "preloadChatroomMember", "adminInfoOrg", "canAtAll", "", "selfUserName", "searchUser", "keyword", "updateAdminUsers", "users", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfo;", "isOwner", "updateAtAll", "robotUserInfo", "Lcom/tencent/mm/plugin/game/chatroom/data/SimpleUserInfo;", "updateOtherMember", "showFooter", "updateRecentlyUsers", "Companion", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends af
{
  public static final a Isy;
  private final kotlin.j Ijj;
  public final x<List<com.tencent.mm.plugin.game.chatroom.d.c>> IsA;
  public String IsB;
  private final ArrayList<String> IsC;
  private final kotlin.j IsD;
  private final kotlin.j IsE;
  public final v<com.tencent.mm.plugin.game.chatroom.d.b> Isz;
  public String chatroomName;
  
  static
  {
    AppMethodBeat.i(276236);
    Isy = new a((byte)0);
    AppMethodBeat.o(276236);
  }
  
  public b()
  {
    AppMethodBeat.i(276095);
    this.Isz = new v();
    this.IsA = new x();
    this.Ijj = kotlin.k.a(o.aiuH, (kotlin.g.a.a)j.IsM);
    this.IsC = new ArrayList();
    this.IsD = kotlin.k.a(o.aiuH, (kotlin.g.a.a)c.IsG);
    this.IsE = kotlin.k.a(o.aiuH, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(276095);
  }
  
  private final com.tencent.mm.plugin.game.chatroom.d.b fDM()
  {
    AppMethodBeat.i(276106);
    com.tencent.mm.plugin.game.chatroom.d.b localb = (com.tencent.mm.plugin.game.chatroom.d.b)this.Isz.getValue();
    if (localb == null)
    {
      localb = new com.tencent.mm.plugin.game.chatroom.d.b();
      AppMethodBeat.o(276106);
      return localb;
    }
    AppMethodBeat.o(276106);
    return localb;
  }
  
  public final void a(String paramString1, final AdminInfo paramAdminInfo, final boolean paramBoolean, final String paramString2)
  {
    AppMethodBeat.i(276269);
    s.u(paramString1, "chatroomName");
    s.u(paramAdminInfo, "adminInfoOrg");
    s.u(paramString2, "selfUserName");
    this.chatroomName = paramString1;
    Object localObject1 = new LinkedList((Collection)paramAdminInfo.admin_username_list);
    ((LinkedList)localObject1).add(paramAdminInfo.owner_username);
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (!s.p((String)localObject3, paramString2)) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject2 = (List)localObject1;
    localObject1 = new AdminInfo();
    ((AdminInfo)localObject1).admin_username_list = new LinkedList((Collection)localObject2);
    ((AdminInfo)localObject1).owner_username = paramAdminInfo.owner_username;
    kotlinx.coroutines.j.a(ag.b((af)this), getCoroutineContext(), null, (m)new g(this, (AdminInfo)localObject1, paramString2, paramBoolean, null), 2);
    localObject2 = a.Ish;
    a.a(paramString1, (com.tencent.mm.plugin.game.chatroom.b.f)new h(this, paramString2, paramAdminInfo));
    a.Ish.b(paramString1, (AdminInfo)localObject1);
    AppMethodBeat.o(276269);
  }
  
  public final void a(List<? extends ChatroomUserData> paramList, final AdminInfo paramAdminInfo)
  {
    AppMethodBeat.i(276298);
    s.u(paramList, "updateUserList");
    final String str = this.chatroomName;
    if (str == null)
    {
      AppMethodBeat.o(276298);
      return;
    }
    kotlinx.coroutines.j.a(ag.b((af)this), getCoroutineContext(), null, (m)new e(paramList, this, str, paramAdminInfo, null), 2);
    AppMethodBeat.o(276298);
  }
  
  public final void fDN()
  {
    AppMethodBeat.i(276279);
    final String str = this.chatroomName;
    if (str != null) {
      kotlinx.coroutines.j.a(ag.b((af)this), getCoroutineContext(), null, (m)new d(this, str, null), 2);
    }
    AppMethodBeat.o(276279);
  }
  
  public final void fDO()
  {
    AppMethodBeat.i(276290);
    kotlinx.coroutines.j.a(ag.b((af)this), getCoroutineContext(), null, (m)new f(this, null), 2);
    AppMethodBeat.o(276290);
  }
  
  public final kotlin.d.f getCoroutineContext()
  {
    AppMethodBeat.i(276246);
    kotlin.d.f localf = (kotlin.d.f)this.IsE.getValue();
    AppMethodBeat.o(276246);
    return localf;
  }
  
  public final void onCleared()
  {
    AppMethodBeat.i(276311);
    String str = this.chatroomName;
    if (str != null)
    {
      a locala = a.Ish;
      s.u(str, "chatroomName");
      a.fDD().remove(str);
      a.fDE().remove(str);
    }
    Log.i("GameChatRoom.ChatroomMemberViewModel", "onCleared");
    super.onCleared();
    AppMethodBeat.o(276311);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/viewmodel/ChatroomMemberViewModel$Companion;", "", "()V", "TAG", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/coroutines/CoroutineContext;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<kotlin.d.f>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlinx/coroutines/CoroutineExceptionHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<CoroutineExceptionHandler>
  {
    public static final c IsG;
    
    static
    {
      AppMethodBeat.i(276147);
      IsG = new c();
      AppMethodBeat.o(276147);
    }
    
    c()
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends kotlin.d.a
      implements CoroutineExceptionHandler
    {
      public a(CoroutineExceptionHandler.a parama)
      {
        super();
        AppMethodBeat.i(276061);
        AppMethodBeat.o(276061);
      }
      
      public final void handleException(kotlin.d.f paramf, Throwable paramThrowable)
      {
        AppMethodBeat.i(276070);
        Log.e("GameChatRoom.ChatroomMemberViewModel", paramThrowable, paramThrowable.getMessage());
        AppMethodBeat.o(276070);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(b paramb, String paramString, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(276134);
      paramObject = (kotlin.d.d)new d(this.IsF, str, paramd);
      AppMethodBeat.o(276134);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(276126);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(276126);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      b.c(this.IsF).aFy(str);
      paramObject = ah.aiuX;
      AppMethodBeat.o(276126);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(List<? extends ChatroomUserData> paramList, b paramb, String paramString, AdminInfo paramAdminInfo, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(276146);
      paramObject = (kotlin.d.d)new e(this.IsH, jdField_this, str, paramAdminInfo, paramd);
      AppMethodBeat.o(276146);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(276140);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(276140);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      long l = System.currentTimeMillis();
      Object localObject2 = (Iterable)this.IsH;
      paramObject = str;
      localObject1 = paramAdminInfo;
      Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ChatroomUserData)((Iterator)localObject2).next();
        com.tencent.mm.plugin.game.chatroom.f.c localc = new com.tencent.mm.plugin.game.chatroom.f.c();
        localc.field_compositionKey = s.X(paramObject, ((ChatroomUserData)localObject3).username);
        localc.field_userName = ((ChatroomUserData)localObject3).username;
        localc.field_nickName = ((ChatroomUserData)localObject3).nickname;
        localc.field_roomName = paramObject;
        localc.field_avatarURL = ((ChatroomUserData)localObject3).avatar;
        com.tencent.mm.plugin.game.chatroom.k.b localb = com.tencent.mm.plugin.game.chatroom.k.b.Ioe;
        localObject3 = ((ChatroomUserData)localObject3).username;
        s.s(localObject3, "it.username");
        localc.field_role = com.tencent.mm.plugin.game.chatroom.k.b.a((String)localObject3, (AdminInfo)localObject1);
        localc.field_updateTime = l;
        localCollection.add(localc);
      }
      paramObject = (List)localCollection;
      b.c(jdField_this).z(paramObject, str);
      paramObject = ah.aiuX;
      AppMethodBeat.o(276140);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    f(b paramb, kotlin.d.d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(276124);
      paramObject = (kotlin.d.d)new f(this.IsF, paramd);
      AppMethodBeat.o(276124);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(276119);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(276119);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.IsF.chatroomName;
      List localList;
      if (paramObject != null)
      {
        localObject = this.IsF;
        localList = b.c((b)localObject).aFx(paramObject);
        long l = b.c((b)localObject).aFw(paramObject);
        Log.i("GameChatRoom.ChatroomMemberViewModel", s.X("getMemberFromLocal localMemberNum = ", kotlin.d.b.a.b.BF(l)));
        if (l <= 400L) {
          break label141;
        }
      }
      label141:
      for (boolean bool = true;; bool = false)
      {
        b.b((b)localObject, localList, bool);
        paramObject = ah.aiuX;
        AppMethodBeat.o(276119);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    g(b paramb, AdminInfo paramAdminInfo, String paramString, boolean paramBoolean, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(276135);
      paramObject = (kotlin.d.d)new g(this.IsF, this.Isu, paramString2, paramBoolean, paramd);
      AppMethodBeat.o(276135);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(276125);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(276125);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.IsF.IsB;
        Object localObject1 = this.Isu.admin_username_list;
        s.s(localObject1, "adminInfo.admin_username_list");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = this.IsF;
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (!b.a((b)localObject1).contains(str)) {
            b.a((b)localObject1).add(str);
          }
        }
        if (!b.a(this.IsF).contains(paramString2)) {
          b.a(this.IsF).add(paramString2);
        }
        if (paramObject == null) {
          break label248;
        }
        localObject1 = a.Ish;
        localObject1 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = a.n(paramObject, (kotlin.d.d)localObject1);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(276125);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (com.tencent.mm.plugin.game.chatroom.d.d)paramObject;
      b.a(this.IsF, paramObject, paramBoolean);
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(276125);
        return paramObject;
        label248:
        b.a(this.IsF, null, paramBoolean);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/game/chatroom/viewmodel/ChatroomMemberViewModel$preloadChatroomMember$2", "Lcom/tencent/mm/plugin/game/chatroom/callback/IPreloadMemberListener;", "onAdminLoaded", "", "users", "", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfo;", "onAllMemberSaved", "onRecentlyMentionedLoaded", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements com.tencent.mm.plugin.game.chatroom.b.f
  {
    h(b paramb, String paramString, AdminInfo paramAdminInfo) {}
    
    public final void fCz()
    {
      AppMethodBeat.i(276131);
      b.b(this.IsF);
      AppMethodBeat.o(276131);
    }
    
    public final void ih(List<? extends com.tencent.mm.plugin.game.chatroom.f.c> paramList)
    {
      AppMethodBeat.i(276116);
      s.u(paramList, "users");
      b.a(this.IsF, paramList);
      AppMethodBeat.o(276116);
    }
    
    public final void ii(List<? extends com.tencent.mm.plugin.game.chatroom.f.c> paramList)
    {
      AppMethodBeat.i(276123);
      s.u(paramList, "users");
      b.a(this.IsF, paramList, s.p(paramString2, paramAdminInfo.owner_username));
      AppMethodBeat.o(276123);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class i
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    public i(b paramb, String paramString1, String paramString2, kotlin.d.d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(276128);
      paramObject = (kotlin.d.d)new i(this.IsF, this.xEv, this.IsL, paramd);
      AppMethodBeat.o(276128);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(276120);
      Object localObject1 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(276120);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      localObject1 = b.c(this.IsF).iP(this.xEv, this.IsL);
      paramObject = this.IsF.IsA;
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((com.tencent.mm.plugin.game.chatroom.f.c)((Iterator)localObject2).next()).fCH();
        s.s(localObject3, "it.getSimpleUserInfo()");
        ((Collection)localObject1).add(new com.tencent.mm.plugin.game.chatroom.d.c(null, (com.tencent.mm.plugin.game.chatroom.d.d)localObject3, false, 701, 5));
      }
      Object localObject3 = (Iterable)localObject1;
      localObject1 = new HashSet();
      localObject2 = new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        if (((HashSet)localObject1).add(((com.tencent.mm.plugin.game.chatroom.d.c)localObject4).Ikl.id)) {
          ((ArrayList)localObject2).add(localObject4);
        }
      }
      paramObject.t((List)localObject2);
      paramObject = ah.aiuX;
      AppMethodBeat.o(276120);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDao;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.game.chatroom.f.d>
  {
    public static final j IsM;
    
    static
    {
      AppMethodBeat.i(276112);
      IsM = new j();
      AppMethodBeat.o(276112);
    }
    
    j()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.l.b
 * JD-Core Version:    0.7.0.1
 */