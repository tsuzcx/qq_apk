package com.tencent.mm.chatroom.g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;
import org.xwalk.core.Log;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "chatRoomName", "", "userNameByAdd", "localHistoryInfo", "Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "fakeMsgId", "", "iChatRoomAddContactCallback", "Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;JLcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;)V", "getChatRoomName", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFakeMsgId", "()J", "getIChatRoomAddContactCallback", "()Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "getLocalHistoryInfo", "()Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "member", "Lcom/tencent/mm/storage/ChatRoomMember;", "getMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "setMember", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "getUserNameByAdd", "dealAddChatRoomMember", "", "errType", "", "errCode", "scene", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "sysErrMsg", "desc", "tipResId", "dealNeedVerify", "verifyUserList", "", "memberBlackList", "getDisplayNameInRoom", "username", "getOwnerName", "getString", "resId", "formatArgs", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "goChatroomUpgrade", "Landroid/content/Context;", "roomname", "hardcodeVerifySysMsg", "chatroomName", "inviteChatRoomMember", "list", "isContactExit", "", "userName", "isSupportChatroomUpgradeEntry", "usernameToDisplayName", "memberList", "Companion", "IChatRoomAddContactCallback", "ui-chatroom_release"})
public final class a
{
  private static final String TAG = "MicroMsg.ChatRoomAddContactProcess";
  public static final a.a iXv;
  final String fwY;
  private ah iXp;
  final MMActivity iXq;
  private final String iXr;
  private final ChatroomInfoUI.LocalHistoryInfo iXs;
  final long iXt;
  final b iXu;
  
  static
  {
    AppMethodBeat.i(187044);
    iXv = new a.a((byte)0);
    TAG = "MicroMsg.ChatRoomAddContactProcess";
    AppMethodBeat.o(187044);
  }
  
  public a(MMActivity paramMMActivity, String paramString1, String paramString2, ChatroomInfoUI.LocalHistoryInfo paramLocalHistoryInfo, long paramLong, b paramb)
  {
    AppMethodBeat.i(187042);
    this.iXq = paramMMActivity;
    this.fwY = paramString1;
    this.iXr = paramString2;
    this.iXs = paramLocalHistoryInfo;
    this.iXt = paramLong;
    this.iXu = paramb;
    paramMMActivity = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class);
    p.j(paramMMActivity, "service(IChatroomService::class.java)");
    this.iXp = ((com.tencent.mm.plugin.chatroom.a.b)paramMMActivity).bbV().Rw(this.fwY);
    if (this.iXp != null)
    {
      paramMMActivity = this.iXp;
      if (paramMMActivity == null) {
        p.iCn();
      }
      int k = paramMMActivity.hxG();
      int j = 0;
      paramMMActivity = this.iXp;
      if (paramMMActivity == null) {
        p.iCn();
      }
      int i = j;
      if (!paramMMActivity.asE())
      {
        if (!ab.PQ(this.fwY)) {
          break label257;
        }
        i = j;
        if ((k & 0x1) == 1) {
          i = 1;
        }
      }
      while (i != 0)
      {
        new f.a((Context)this.iXq).bBl(getString(com.tencent.mm.chatroom.ui.a.i.jfH)).bBp(getString(com.tencent.mm.chatroom.ui.a.i.app_send)).HL(true).B(Boolean.TRUE).bBq(getString(com.tencent.mm.chatroom.ui.a.i.app_cancel)).bBn(getString(com.tencent.mm.chatroom.ui.a.i.jfC)).c((f.c)new f.c()
        {
          public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(193558);
            if (paramAnonymousBoolean) {
              a.a(this.iXw, paramAnonymousString, com.tencent.mm.chatroom.ui.a.i.jfs);
            }
            AppMethodBeat.o(193558);
          }
        }).show();
        AppMethodBeat.o(187042);
        return;
        label257:
        i = j;
        if (k == 2) {
          i = 1;
        }
      }
      ab(null, com.tencent.mm.chatroom.ui.a.i.emP);
      AppMethodBeat.o(187042);
      return;
    }
    Log.e(TAG, "member is null!!!");
    AppMethodBeat.o(187042);
  }
  
  private static List<String> S(List<String> paramList)
  {
    AppMethodBeat.i(187034);
    List localList = (List)new LinkedList();
    if (!com.tencent.mm.kernel.h.aHB())
    {
      AppMethodBeat.o(187034);
      return localList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(187034);
      return localList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = com.tencent.mm.kernel.h.ae(n.class);
      p.j(paramList, "MMKernel.service(IMessengerStorage::class.java)");
      as localas = ((n)paramList).bbL().RG(str);
      paramList = str;
      if (localas != null)
      {
        paramList = str;
        if (localas.ayq() != 0)
        {
          paramList = localas.ays();
          p.j(paramList, "ct.displayRemark");
        }
      }
      localList.add(paramList);
    }
    AppMethodBeat.o(187034);
    return localList;
  }
  
  private final void ab(String paramString, int paramInt)
  {
    AppMethodBeat.i(187031);
    if ((ab.PP(this.fwY)) && (!ab.PT(this.fwY)) && (!u.Pg(this.iXr)))
    {
      com.tencent.mm.ui.base.h.af((Context)this.iXq, getString(com.tencent.mm.chatroom.ui.a.i.jgm), getString(com.tencent.mm.chatroom.ui.a.i.app_tip));
      AppMethodBeat.o(187031);
      return;
    }
    Object localObject1 = this.iXr;
    int j;
    if (p.h(Util.nullAsNil(z.bcZ()), localObject1)) {
      j = 1;
    }
    while (j != 0)
    {
      com.tencent.mm.ui.base.h.af((Context)this.iXq, getString(com.tencent.mm.chatroom.ui.a.i.add_room_mem_memberExits), getString(com.tencent.mm.chatroom.ui.a.i.app_tip));
      AppMethodBeat.o(187031);
      return;
      Object localObject2 = v.Ps(this.fwY);
      if (localObject2 == null)
      {
        j = 0;
      }
      else
      {
        localObject2 = ((List)localObject2).iterator();
        int i = 0;
        j = i;
        if (((Iterator)localObject2).hasNext())
        {
          if (!p.h((String)((Iterator)localObject2).next(), localObject1)) {
            break label380;
          }
          i = 1;
        }
      }
    }
    label380:
    for (;;)
    {
      break;
      if (this.iXr == null)
      {
        AppMethodBeat.o(187031);
        return;
      }
      localObject1 = (CharSequence)this.iXr;
      localObject1 = ((Collection)new k(",").u((CharSequence)localObject1, 0)).toArray(new String[0]);
      if (localObject1 == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(187031);
        throw paramString;
      }
      localObject1 = Util.stringsToList((String[])localObject1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(187031);
        return;
      }
      paramString = com.tencent.mm.roomsdk.a.b.btX(this.fwY).a(this.fwY, (List)localObject1, paramString, this.iXs);
      paramString.d((com.tencent.mm.roomsdk.a.b.a)new c(this));
      paramString.a((Context)this.iXq, getString(com.tencent.mm.chatroom.ui.a.i.app_tip), getString(paramInt), true, true, (DialogInterface.OnCancelListener)new a.d(paramString));
      AppMethodBeat.o(187031);
      return;
    }
  }
  
  private static boolean asi()
  {
    AppMethodBeat.i(187036);
    if (Util.getInt(com.tencent.mm.n.h.axc().getValue("ChatroomGlobalSwitch"), 1) == 1)
    {
      AppMethodBeat.o(187036);
      return true;
    }
    AppMethodBeat.o(187036);
    return false;
  }
  
  private final void b(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(187035);
    if ((paramList != null) && (paramList.size() > 0))
    {
      LinkedList localLinkedList = new LinkedList();
      int j = ((Collection)paramList).size();
      int i = 0;
      while (i < j)
      {
        localLinkedList.add(paramList.get(i));
        i += 1;
      }
      paramList = "weixin://findfriend/verifycontact/" + paramString + "/";
      u.a(paramString, (List)localLinkedList, getString(com.tencent.mm.chatroom.ui.a.i.chatroom_sys_msg_invite_error_tip), true, paramList);
    }
    AppMethodBeat.o(187035);
  }
  
  private String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187039);
    p.k(paramVarArgs, "formatArgs");
    paramVarArgs = this.iXq.getString(paramInt, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    p.j(paramVarArgs, "context.getString(resId, *formatArgs)");
    AppMethodBeat.o(187039);
    return paramVarArgs;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(187038);
    String str = this.iXq.getString(paramInt);
    p.j(str, "context.getString(resId)");
    AppMethodBeat.o(187038);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "", "onMemberListChanged", "", "updateUI", "ui-chatroom_release"})
  public static abstract interface b
  {
    public abstract void asj();
    
    public abstract void ask();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/chatroom/process/ChatRoomAddContactProcess$dealAddChatRoomMember$1", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "onResult", "", "errType", "", "errCode", "errMsg", "", "detailResult", "ui-chatroom_release"})
  public static final class c
    extends c
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(a parama, c paramc, List paramList1, List paramList2, List paramList3) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(187869);
      if (ab.PP(this.iXw.fwY))
      {
        paramDialogInterface = this.iXw;
        String str = this.iXy.hrL();
        p.j(str, "scene.getChatroomName()");
        a.a(paramDialogInterface, str, this.iXz);
      }
      paramDialogInterface = new ArrayList();
      paramDialogInterface.addAll((Collection)this.iXA);
      paramDialogInterface.addAll((Collection)this.iXB);
      a.a(this.iXw, (List)paramDialogInterface);
      ((y)com.tencent.mm.kernel.h.ae(y.class)).Wz(1);
      ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.record.a.f.class)).L(this.iXw.iXt, this.iXw.fwY);
      AppMethodBeat.o(187869);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(189672);
      a.a(this.iXw, (Context)this.iXw.iXq);
      AppMethodBeat.o(189672);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    h(a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(186898);
      this.iXw.iXu.asj();
      AppMethodBeat.o(186898);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "detailResult", "Lcom/tencent/mm/roomsdk/model/callback/RoomCallbackBaseFunc;", "onResult"})
  static final class i<T extends com.tencent.mm.roomsdk.a.b.a<com.tencent.mm.roomsdk.a.b.a<?>>>
    implements com.tencent.mm.roomsdk.a.b.a<com.tencent.mm.roomsdk.a.b.a<?>>
  {
    i(a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.roomsdk.a.b.a<?> parama)
    {
      AppMethodBeat.i(193405);
      this.iXw.iXu.asj();
      this.iXw.iXu.ask();
      ((com.tencent.mm.plugin.record.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.record.a.f.class)).L(this.iXw.iXt, this.iXw.fwY);
      AppMethodBeat.o(193405);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "detailResult", "Lcom/tencent/mm/roomsdk/model/callback/RoomCallbackFunc;", "onResult"})
  static final class j
    implements com.tencent.mm.roomsdk.a.b.b
  {
    j(a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.g.a
 * JD-Core Version:    0.7.0.1
 */