package com.tencent.mm.plugin.game.chatroom.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.plugin.game.api.g;
import com.tencent.mm.plugin.game.autogen.chatroom.AdminInfo;
import com.tencent.mm.plugin.game.autogen.chatroom.GetUserAtMemberListRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetUserAtMemberListResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.SyncChatroomMemberRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.SyncChatroomMemberResponse;
import com.tencent.mm.plugin.game.chatroom.b.b.a;
import com.tencent.stubs.logger.Log;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;
import kotlin.o;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/viewmodel/ChatroomMemberPreloadManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "CHATROOM_MEMBER_UPDATE_TIME_IN_DB", "", "CHATROOM_MEMBER_VERSION_SUFFIX_IN_DB", "DEFAULT_MAX_BATCH_SIZE", "", "DEFAULT_MAX_SHOW_MEMBER_NUM", "MAX_BATCH_SIZE", "getMAX_BATCH_SIZE", "()I", "MAX_BATCH_SIZE$delegate", "Lkotlin/Lazy;", "TAG", "adminInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/game/autogen/chatroom/AdminInfo;", "Lkotlin/collections/HashMap;", "getAdminInfoMap", "()Ljava/util/HashMap;", "adminInfoMap$delegate", "listenerMap", "Lcom/tencent/mm/plugin/game/chatroom/callback/IPreloadMemberListener;", "getListenerMap", "listenerMap$delegate", "simpleUserService", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDao;", "kotlin.jvm.PlatformType", "getSimpleUserService", "()Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDao;", "simpleUserService$delegate", "updateVersionMap", "Lkotlin/Pair;", "getUpdateVersionMap", "updateVersionMap$delegate", "usersCacheMap", "", "getUsersCacheMap", "usersCacheMap$delegate", "getQuestUserList", "Ljava/util/LinkedList;", "userNames", "chatroomName", "getSimpleUsersFromDbOrNet", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfo;", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUpdateVersion", "getUserInfoByContact", "Lcom/tencent/mm/plugin/game/chatroom/data/SimpleUserInfo;", "userName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleGetRoomMembersRsp", "", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "handleGetUserAtMembersRsp", "handleSyncChatroomMember", "onSceneEnd", "preload", "adminInfo", "registerCgiListener", "registerPreloadListener", "listener", "unregisterCgiListener", "unregisterPreloadListener", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.am.h
{
  private static final kotlin.j Ijj;
  public static final a Ish;
  private static final kotlin.j Isi;
  private static final kotlin.j Isj;
  private static final kotlin.j Isk;
  private static final kotlin.j Isl;
  private static final kotlin.j Ism;
  
  static
  {
    AppMethodBeat.i(276198);
    Ish = new a();
    Isi = kotlin.k.a(o.aiuH, (kotlin.g.a.a)f.Iss);
    Isj = kotlin.k.a(o.aiuH, (kotlin.g.a.a)b.Iso);
    Isk = kotlin.k.a(o.aiuH, (kotlin.g.a.a)i.Isw);
    Isl = kotlin.k.a(o.aiuH, (kotlin.g.a.a)j.Isx);
    Ijj = kotlin.k.a(o.aiuH, (kotlin.g.a.a)h.Isv);
    Ism = kotlin.k.cm((kotlin.g.a.a)a.Isn);
    AppMethodBeat.o(276198);
  }
  
  private static LinkedList<String> A(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(276127);
    int i = paramList.size();
    if (i > fDI())
    {
      List localList = paramList.subList(fDI(), i);
      ((Map)fDG()).put(paramString, localList);
      paramString = paramList.subList(0, fDI());
      Log.i("GameChatRoom.ChatroomMemberPreloadManager", "handleSyncChatroomMember restList size = " + localList.size() + "  requestSize = " + paramString.size() + "  rawUserSize =" + paramList.size());
      paramList = paramString;
    }
    while ((paramList instanceof LinkedList))
    {
      paramList = (LinkedList)paramList;
      AppMethodBeat.o(276127);
      return paramList;
      fDG().remove(paramString);
    }
    paramList = new LinkedList((Collection)paramList);
    AppMethodBeat.o(276127);
    return paramList;
  }
  
  public static void a(String paramString, com.tencent.mm.plugin.game.chatroom.b.f paramf)
  {
    AppMethodBeat.i(276144);
    kotlin.g.b.s.u(paramString, "chatroomName");
    kotlin.g.b.s.u(paramf, "listener");
    ((Map)fDD()).put(paramString, paramf);
    AppMethodBeat.o(276144);
  }
  
  static HashMap<String, com.tencent.mm.plugin.game.chatroom.b.f> fDD()
  {
    AppMethodBeat.i(276086);
    HashMap localHashMap = (HashMap)Isi.getValue();
    AppMethodBeat.o(276086);
    return localHashMap;
  }
  
  static HashMap<String, AdminInfo> fDE()
  {
    AppMethodBeat.i(276094);
    HashMap localHashMap = (HashMap)Isj.getValue();
    AppMethodBeat.o(276094);
    return localHashMap;
  }
  
  private static HashMap<String, kotlin.r<String, String>> fDF()
  {
    AppMethodBeat.i(276100);
    HashMap localHashMap = (HashMap)Isk.getValue();
    AppMethodBeat.o(276100);
    return localHashMap;
  }
  
  private static HashMap<String, List<String>> fDG()
  {
    AppMethodBeat.i(276105);
    HashMap localHashMap = (HashMap)Isl.getValue();
    AppMethodBeat.o(276105);
    return localHashMap;
  }
  
  private static com.tencent.mm.plugin.game.chatroom.f.d fDH()
  {
    AppMethodBeat.i(276113);
    com.tencent.mm.plugin.game.chatroom.f.d locald = (com.tencent.mm.plugin.game.chatroom.f.d)Ijj.getValue();
    AppMethodBeat.o(276113);
    return locald;
  }
  
  private static int fDI()
  {
    AppMethodBeat.i(276117);
    int i = ((Number)Ism.getValue()).intValue();
    AppMethodBeat.o(276117);
    return i;
  }
  
  public static Object n(String paramString, kotlin.d.d<? super com.tencent.mm.plugin.game.chatroom.d.d> paramd)
  {
    AppMethodBeat.i(276139);
    q localq = new q(kotlin.d.a.b.au(paramd), 1);
    localq.kBA();
    final kotlinx.coroutines.p localp = (kotlinx.coroutines.p)localq;
    ((com.tencent.mm.plugin.game.chatroom.b.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.chatroom.b.b.class)).a(paramString, (b.a)new c(paramString, localp));
    paramString = localq.getResult();
    if (paramString == kotlin.d.a.a.aiwj) {
      kotlin.g.b.s.u(paramd, "frame");
    }
    AppMethodBeat.o(276139);
    return paramString;
  }
  
  public final void b(String paramString, final AdminInfo paramAdminInfo)
  {
    AppMethodBeat.i(276205);
    kotlin.g.b.s.u(paramString, "chatroomName");
    kotlin.g.b.s.u(paramAdminInfo, "adminInfo");
    if (fDE().get(paramString) != null)
    {
      AppMethodBeat.o(276205);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a(5069, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(4713, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(4952, (com.tencent.mm.am.h)this);
    ((Map)fDE()).put(paramString, paramAdminInfo);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new com.tencent.mm.plugin.game.chatroom.c.l(paramString), 0);
    kotlinx.coroutines.j.a(ar.d((kotlin.d.f)bg.kCi()), null, null, (m)new g(paramString, paramAdminInfo, null), 3);
    AppMethodBeat.o(276205);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.am.p paramp)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(276232);
    if (paramp != null) {
      switch (paramp.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(276232);
      return;
      Object localObject1;
      if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof com.tencent.mm.plugin.game.chatroom.c.l)) && ((c.c.b(((com.tencent.mm.plugin.game.chatroom.c.l)paramp).getCommReqResp().otC) instanceof GetUserAtMemberListResponse)))
      {
        paramString = c.c.b(((com.tencent.mm.plugin.game.chatroom.c.l)paramp).getCommReqResp().otC);
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.game.autogen.chatroom.GetUserAtMemberListResponse");
          AppMethodBeat.o(276232);
          throw paramString;
        }
        paramString = ((GetUserAtMemberListResponse)paramString).at_member_username_list;
        Log.i("GameChatRoom.ChatroomMemberPreloadManager", "handleCgiGetUserAtMemberList  atMembers = " + paramString.size() + "  threadId = " + Thread.currentThread().getId() + "   threadName =  " + Thread.currentThread().getName());
        localObject1 = (Collection)paramString;
        if (localObject1 != null)
        {
          paramInt1 = i;
          if (!((Collection)localObject1).isEmpty()) {}
        }
        else
        {
          paramInt1 = 1;
        }
        if (paramInt1 != 0)
        {
          paramString = (com.tencent.mm.plugin.game.chatroom.b.f)fDD().get(((com.tencent.mm.plugin.game.chatroom.c.l)paramp).fCC().chatroom_name);
          if (paramString != null) {
            paramString.ih((List)ab.aivy);
          }
          AppMethodBeat.o(276232);
          return;
        }
        kotlinx.coroutines.j.a(ar.d((kotlin.d.f)bg.kCi()), null, null, (m)new d(paramString, paramp, null), 3);
      }
      AppMethodBeat.o(276232);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof com.tencent.mm.plugin.game.chatroom.c.r)))
      {
        Log.i("GameChatRoom.ChatroomMemberPreloadManager", "handleSyncChatroomMember  rawUserSize = " + ((com.tencent.mm.plugin.game.chatroom.c.r)paramp).fCD().member_username_list.size() + " chatroomName = " + ((com.tencent.mm.plugin.game.chatroom.c.r)paramp).fCE().chatroom_name + "   lastVersion = " + ((com.tencent.mm.plugin.game.chatroom.c.r)paramp).fCE().last_version + "   nextVersion = " + ((com.tencent.mm.plugin.game.chatroom.c.r)paramp).fCD().next_version);
        paramString = (Collection)((com.tencent.mm.plugin.game.chatroom.c.r)paramp).fCD().member_username_list;
        if (paramString != null)
        {
          paramInt1 = j;
          if (!paramString.isEmpty()) {}
        }
        else
        {
          paramInt1 = 1;
        }
        if (paramInt1 != 0)
        {
          paramString = (g)com.tencent.mm.kernel.h.ax(g.class);
          localObject1 = kotlin.g.b.s.X(((com.tencent.mm.plugin.game.chatroom.c.r)paramp).fCE().chatroom_name, "memberVersion");
          paramp = ((com.tencent.mm.plugin.game.chatroom.c.r)paramp).fCD().next_version;
          kotlin.g.b.s.s(paramp, "scene.response.next_version");
          paramp = paramp.getBytes(kotlin.n.d.UTF_8);
          kotlin.g.b.s.s(paramp, "(this as java.lang.String).getBytes(charset)");
          paramString.w((String)localObject1, paramp);
          AppMethodBeat.o(276232);
          return;
        }
        paramString = (Map)fDF();
        localObject1 = ((com.tencent.mm.plugin.game.chatroom.c.r)paramp).fCE().chatroom_name;
        kotlin.g.b.s.s(localObject1, "scene.request.chatroom_name");
        paramString.put(localObject1, new kotlin.r(((com.tencent.mm.plugin.game.chatroom.c.r)paramp).fCE().last_version, ((com.tencent.mm.plugin.game.chatroom.c.r)paramp).fCD().next_version));
        kotlinx.coroutines.j.a(ar.d((kotlin.d.f)bg.kCi()), null, null, (m)new e(paramp, null), 3);
      }
      AppMethodBeat.o(276232);
      return;
      if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof com.tencent.mm.plugin.game.chatroom.c.k)) && (((com.tencent.mm.plugin.game.chatroom.c.k)paramp).Iji))
      {
        paramString = (List)fDG().get(((com.tencent.mm.plugin.game.chatroom.c.k)paramp).chatroomName);
        localObject1 = (Collection)paramString;
        if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {
          paramInt1 = 1;
        }
        for (;;)
        {
          if (paramInt1 != 0)
          {
            Object localObject2 = (kotlin.r)fDF().get(((com.tencent.mm.plugin.game.chatroom.c.k)paramp).chatroomName);
            if (localObject2 != null)
            {
              if (((kotlin.r)localObject2).bsC == null)
              {
                long l = System.currentTimeMillis();
                ((g)com.tencent.mm.kernel.h.ax(g.class)).w(kotlin.g.b.s.X(((com.tencent.mm.plugin.game.chatroom.c.k)paramp).chatroomName, "updateTime"), com.tencent.mm.plugin.game.chatroom.k.d.rC(l));
              }
              paramString = (g)com.tencent.mm.kernel.h.ax(g.class);
              localObject1 = kotlin.g.b.s.X(((com.tencent.mm.plugin.game.chatroom.c.k)paramp).chatroomName, "memberVersion");
              localObject2 = (String)((kotlin.r)localObject2).bsD;
              Charset localCharset = kotlin.n.d.UTF_8;
              if (localObject2 == null)
              {
                paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(276232);
                throw paramString;
                paramInt1 = 0;
              }
              else
              {
                localObject2 = ((String)localObject2).getBytes(localCharset);
                kotlin.g.b.s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
                paramString.w((String)localObject1, (byte[])localObject2);
              }
            }
            else
            {
              fDE().remove(((com.tencent.mm.plugin.game.chatroom.c.k)paramp).chatroomName);
              paramString = (com.tencent.mm.plugin.game.chatroom.b.f)fDD().remove(((com.tencent.mm.plugin.game.chatroom.c.k)paramp).chatroomName);
              if (paramString == null) {
                break;
              }
              paramString.fCz();
              AppMethodBeat.o(276232);
              return;
            }
          }
        }
        paramString = A(paramString, ((com.tencent.mm.plugin.game.chatroom.c.k)paramp).chatroomName);
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new com.tencent.mm.plugin.game.chatroom.c.k(paramString, ((com.tencent.mm.plugin.game.chatroom.c.k)paramp).chatroomName, (AdminInfo)fDE().get(((com.tencent.mm.plugin.game.chatroom.c.k)paramp).chatroomName)), 0);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final a Isn;
    
    static
    {
      AppMethodBeat.i(276103);
      Isn = new a();
      AppMethodBeat.o(276103);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/game/autogen/chatroom/AdminInfo;", "Lkotlin/collections/HashMap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<HashMap<String, AdminInfo>>
  {
    public static final b Iso;
    
    static
    {
      AppMethodBeat.i(276083);
      Iso = new b();
      AppMethodBeat.o(276083);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "contactMap", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/game/chatroom/callback/IGameChatRoomContact;", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    implements b.a
  {
    c(String paramString, kotlinx.coroutines.p<? super com.tencent.mm.plugin.game.chatroom.d.d> paramp) {}
    
    public final void onDone(Map<String, com.tencent.mm.plugin.game.chatroom.b.c> paramMap)
    {
      AppMethodBeat.i(276110);
      Object localObject2 = (com.tencent.mm.plugin.game.chatroom.b.c)paramMap.get(this.pmW);
      if (localObject2 != null)
      {
        paramMap = ((com.tencent.mm.plugin.game.chatroom.b.c)localObject2).getUserName();
        kotlin.g.b.s.s(paramMap, "contact.userName");
        localObject1 = ((com.tencent.mm.plugin.game.chatroom.b.c)localObject2).getNickName();
        kotlin.g.b.s.s(localObject1, "contact.nickName");
        localObject2 = ((com.tencent.mm.plugin.game.chatroom.b.c)localObject2).amx();
        kotlin.g.b.s.s(localObject2, "contact.avatarUrl");
        paramMap = new com.tencent.mm.plugin.game.chatroom.d.d(paramMap, (String)localObject1, (String)localObject2);
        localObject1 = (kotlin.d.d)localp;
        localObject2 = Result.Companion;
        ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(paramMap));
        AppMethodBeat.o(276110);
        return;
      }
      paramMap = (kotlin.d.d)localp;
      Object localObject1 = Result.Companion;
      paramMap.resumeWith(Result.constructor-impl(null));
      AppMethodBeat.o(276110);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(LinkedList<String> paramLinkedList, com.tencent.mm.am.p paramp, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(276099);
      paramObject = (kotlin.d.d)new d(this.Isq, paramp, paramd);
      AppMethodBeat.o(276099);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(276092);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(276092);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.Ish;
        paramObject = this.Isq;
        kotlin.g.b.s.s(paramObject, "userNames");
        paramObject = (List)paramObject;
        localObject = ((com.tencent.mm.plugin.game.chatroom.c.l)paramp).fCC().chatroom_name;
        kotlin.g.b.s.s(localObject, "scene.request.chatroom_name");
        locald = (kotlin.d.d)this;
        this.label = 1;
        localObject = a.a(paramObject, (String)localObject, locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(276092);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        localObject = (List)paramObject;
        Log.i("GameChatRoom.ChatroomMemberPreloadManager", "getSimpleUsersFromDbOrNet  rawUserSize = " + this.Isq.size() + " resultSimpleUsers = " + ((List)localObject).size() + "  threadId = " + Thread.currentThread().getId() + "   threadName =  " + Thread.currentThread().getName());
        paramObject = (kotlin.d.f)bg.kCh();
        localObject = (m)new kotlin.d.b.a.k(paramp, (List)localObject)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(276082);
            paramAnonymousObject = (kotlin.d.d)new 1(this.nhm, this.Isr, paramAnonymousd);
            AppMethodBeat.o(276082);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(276074);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(276074);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = a.Ish;
            paramAnonymousObject = (com.tencent.mm.plugin.game.chatroom.b.f)a.fDK().get(((com.tencent.mm.plugin.game.chatroom.c.l)this.nhm).fCC().chatroom_name);
            if (paramAnonymousObject != null) {
              paramAnonymousObject.ih(this.Isr);
            }
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(276074);
            return paramAnonymousObject;
          }
        };
        locald = (kotlin.d.d)this;
        this.label = 2;
        if (kotlinx.coroutines.l.a(paramObject, (m)localObject, locald) != locala) {
          break label269;
        }
        AppMethodBeat.o(276092);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label269:
      paramObject = ah.aiuX;
      AppMethodBeat.o(276092);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(com.tencent.mm.am.p paramp, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(276096);
      paramObject = (kotlin.d.d)new e(this.nhm, paramd);
      AppMethodBeat.o(276096);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(276087);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(276087);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = a.Ish;
      paramObject = ((com.tencent.mm.plugin.game.chatroom.c.r)this.nhm).fCD().member_username_list;
      kotlin.g.b.s.s(paramObject, "scene.response.member_username_list");
      paramObject = (List)paramObject;
      localObject = ((com.tencent.mm.plugin.game.chatroom.c.r)this.nhm).fCE().chatroom_name;
      kotlin.g.b.s.s(localObject, "scene.request.chatroom_name");
      paramObject = a.B(paramObject, (String)localObject);
      localObject = com.tencent.mm.kernel.h.aZW();
      String str = ((com.tencent.mm.plugin.game.chatroom.c.r)this.nhm).fCE().chatroom_name;
      kotlin.g.b.s.s(str, "scene.request.chatroom_name");
      a locala = a.Ish;
      ((com.tencent.mm.am.s)localObject).a((com.tencent.mm.am.p)new com.tencent.mm.plugin.game.chatroom.c.k(paramObject, str, (AdminInfo)a.fDL().get(((com.tencent.mm.plugin.game.chatroom.c.r)this.nhm).fCE().chatroom_name)), 0);
      paramObject = ah.aiuX;
      AppMethodBeat.o(276087);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/game/chatroom/callback/IPreloadMemberListener;", "Lkotlin/collections/HashMap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<HashMap<String, com.tencent.mm.plugin.game.chatroom.b.f>>
  {
    public static final f Iss;
    
    static
    {
      AppMethodBeat.i(276077);
      Iss = new f();
      AppMethodBeat.o(276077);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    g(String paramString, AdminInfo paramAdminInfo, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(276102);
      paramObject = (kotlin.d.d)new g(this.Ist, paramAdminInfo, paramd);
      AppMethodBeat.o(276102);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(276097);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(276097);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = a.Ish;
        paramObject = a.aFH(this.Ist);
        if (paramObject == null)
        {
          localObject = a.Ish;
          a.fDJ().aFy(this.Ist);
        }
        com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new com.tencent.mm.plugin.game.chatroom.c.r(this.Ist, paramObject), 0);
        paramObject = (Collection)paramAdminInfo.admin_username_list;
        if ((paramObject == null) || (paramObject.isEmpty())) {
          i = 1;
        }
        break;
      }
      for (;;)
      {
        if (i == 0)
        {
          paramObject = a.Ish;
          paramObject = paramAdminInfo.admin_username_list;
          kotlin.g.b.s.s(paramObject, "adminInfo.admin_username_list");
          paramObject = (List)paramObject;
          localObject = this.Ist;
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 1;
          localObject = a.a(paramObject, (String)localObject, locald);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(276097);
            return locala;
            i = 0;
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
          else
          {
            localObject = (List)paramObject;
            Log.i("GameChatRoom.ChatroomMemberPreloadManager", "onAdminLoaded  rawUserSize = " + paramAdminInfo.admin_username_list.size() + " resultSimpleUsers = " + ((List)localObject).size() + "  threadId = " + Thread.currentThread().getId() + "   threadName =  " + Thread.currentThread().getName());
            paramObject = (kotlin.d.f)bg.kCh();
            localObject = (m)new kotlin.d.b.a.k(this.Ist, (List)localObject)
            {
              int label;
              
              public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
              {
                AppMethodBeat.i(276121);
                paramAnonymousObject = (kotlin.d.d)new 1(this.Ist, this.Isr, paramAnonymousd);
                AppMethodBeat.o(276121);
                return paramAnonymousObject;
              }
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(276115);
                kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
                switch (this.label)
                {
                default: 
                  paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(276115);
                  throw paramAnonymousObject;
                }
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = a.Ish;
                paramAnonymousObject = (com.tencent.mm.plugin.game.chatroom.b.f)a.fDK().get(this.Ist);
                if (paramAnonymousObject == null)
                {
                  AppMethodBeat.o(276115);
                  return null;
                }
                paramAnonymousObject.ii(this.Isr);
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(276115);
                return paramAnonymousObject;
              }
            };
            locald = (kotlin.d.d)this;
            this.label = 2;
            if (kotlinx.coroutines.l.a(paramObject, (m)localObject, locald) == locala)
            {
              AppMethodBeat.o(276097);
              return locala;
              ResultKt.throwOnFailure(paramObject);
            }
          }
        }
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(276097);
        return paramObject;
        Log.d("GameChatRoom.ChatroomMemberPreloadManager", "adminInfo.admin_username_list is empty");
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDao;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.game.chatroom.f.d>
  {
    public static final h Isv;
    
    static
    {
      AppMethodBeat.i(276073);
      Isv = new h();
      AppMethodBeat.o(276073);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<HashMap<String, kotlin.r<? extends String, ? extends String>>>
  {
    public static final i Isw;
    
    static
    {
      AppMethodBeat.i(276075);
      Isw = new i();
      AppMethodBeat.o(276075);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<HashMap<String, List<? extends String>>>
  {
    public static final j Isx;
    
    static
    {
      AppMethodBeat.i(276079);
      Isx = new j();
      AppMethodBeat.o(276079);
    }
    
    j()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.l.a
 * JD-Core Version:    0.7.0.1
 */