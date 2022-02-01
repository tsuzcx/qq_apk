package com.tencent.mm.chatroom.g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.q;
import com.tencent.mm.model.w;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.n.k;
import d.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.Log;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "chatRoomName", "", "userNameByAdd", "localHistoryInfo", "Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "fakeMsgId", "", "iChatRoomAddContactCallback", "Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;JLcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;)V", "getChatRoomName", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFakeMsgId", "()J", "getIChatRoomAddContactCallback", "()Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "getLocalHistoryInfo", "()Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "member", "Lcom/tencent/mm/storage/ChatRoomMember;", "getMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "setMember", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "getUserNameByAdd", "dealAddChatRoomMember", "", "errType", "", "errCode", "scene", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "sysErrMsg", "desc", "tipResId", "dealNeedVerify", "verifyUserList", "", "memberBlackList", "getDisplayNameInRoom", "username", "getOwnerName", "getString", "resId", "formatArgs", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "goChatroomUpgrade", "Landroid/content/Context;", "roomname", "hardcodeVerifySysMsg", "chatroomName", "inviteChatRoomMember", "list", "isContactExit", "", "userName", "isSupportChatroomUpgradeEntry", "usernameToDisplayName", "memberList", "Companion", "IChatRoomAddContactCallback", "ui-chatroom_release"})
public final class a
{
  private static final String TAG = "MicroMsg.ChatRoomAddContactProcess";
  public static final a.a fLU;
  final String dAc;
  private ab fLO;
  final MMActivity fLP;
  private final String fLQ;
  private final ChatroomInfoUI.LocalHistoryInfo fLR;
  final long fLS;
  final b fLT;
  
  static
  {
    AppMethodBeat.i(213614);
    fLU = new a.a((byte)0);
    TAG = "MicroMsg.ChatRoomAddContactProcess";
    AppMethodBeat.o(213614);
  }
  
  public a(MMActivity paramMMActivity, String paramString1, String paramString2, ChatroomInfoUI.LocalHistoryInfo paramLocalHistoryInfo, long paramLong, b paramb)
  {
    AppMethodBeat.i(213613);
    this.fLP = paramMMActivity;
    this.dAc = paramString1;
    this.fLQ = paramString2;
    this.fLR = paramLocalHistoryInfo;
    this.fLS = paramLong;
    this.fLT = paramb;
    paramMMActivity = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class);
    d.g.b.p.g(paramMMActivity, "service(IChatroomService::class.java)");
    this.fLO = ((com.tencent.mm.plugin.chatroom.a.c)paramMMActivity).azz().AN(this.dAc);
    if (this.fLO != null)
    {
      paramMMActivity = this.fLO;
      if (paramMMActivity == null) {
        d.g.b.p.gfZ();
      }
      int k = paramMMActivity.fpP();
      int j = 0;
      paramMMActivity = this.fLO;
      if (paramMMActivity == null) {
        d.g.b.p.gfZ();
      }
      int i = j;
      if (!paramMMActivity.YH())
      {
        if (!w.zl(this.dAc)) {
          break label253;
        }
        i = j;
        if ((k & 0x1) == 1) {
          i = 1;
        }
      }
      while (i != 0)
      {
        new f.a((Context)this.fLP).aXO(getString(2131762554)).aXS(getString(2131755884)).yU(true).s(Boolean.TRUE).aXT(getString(2131755691)).aXQ(getString(2131762208)).c((f.c)new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(213597);
            if (paramAnonymousBoolean) {
              a.a(this.fLV, paramAnonymousString);
            }
            AppMethodBeat.o(213597);
          }
        }).show();
        AppMethodBeat.o(213613);
        return;
        label253:
        i = j;
        if (k == 2) {
          i = 1;
        }
      }
      H(null, 2131755168);
      AppMethodBeat.o(213613);
      return;
    }
    Log.e(TAG, "member is null!!!");
    AppMethodBeat.o(213613);
  }
  
  private final void H(String paramString, int paramInt)
  {
    AppMethodBeat.i(213607);
    if ((w.zk(this.dAc)) && (!w.zn(this.dAc)) && (!com.tencent.mm.model.p.yE(this.fLQ)))
    {
      h.T((Context)this.fLP, getString(2131762644), getString(2131755906));
      AppMethodBeat.o(213607);
      return;
    }
    Object localObject1 = this.fLQ;
    int j;
    if (d.g.b.p.i(bt.nullAsNil(com.tencent.mm.model.u.aAm()), localObject1)) {
      j = 1;
    }
    while (j != 0)
    {
      h.T((Context)this.fLP, getString(2131755154), getString(2131755906));
      AppMethodBeat.o(213607);
      return;
      Object localObject2 = q.yQ(this.dAc);
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
          if (!d.g.b.p.i((String)((Iterator)localObject2).next(), localObject1)) {
            break label384;
          }
          i = 1;
        }
      }
    }
    label384:
    for (;;)
    {
      break;
      if (this.fLQ == null)
      {
        AppMethodBeat.o(213607);
        return;
      }
      localObject1 = (CharSequence)this.fLQ;
      localObject1 = ((Collection)new k(",").q((CharSequence)localObject1, 0)).toArray(new String[0]);
      if (localObject1 == null)
      {
        paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(213607);
        throw paramString;
      }
      localObject1 = bt.U((String[])localObject1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(213607);
        return;
      }
      paramString = com.tencent.mm.roomsdk.a.b.aPF(this.dAc).a(this.dAc, (List)localObject1, paramString, this.fLR);
      paramString.d((com.tencent.mm.roomsdk.a.b.a)new c(this));
      localObject1 = (Context)this.fLP;
      getString(2131755906);
      paramString.a((Context)localObject1, getString(paramInt), true, (DialogInterface.OnCancelListener)new d(paramString));
      AppMethodBeat.o(213607);
      return;
    }
  }
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(213608);
    List localList = (List)new LinkedList();
    if (!com.tencent.mm.kernel.g.ajx())
    {
      AppMethodBeat.o(213608);
      return localList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(213608);
      return localList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      d.g.b.p.g(paramList, "MMKernel.service(IMessengerStorage::class.java)");
      am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramList).azp().Bf(str);
      paramList = str;
      if (localam != null)
      {
        paramList = str;
        if (localam.adt() != 0)
        {
          paramList = localam.adv();
          d.g.b.p.g(paramList, "ct.displayRemark");
        }
      }
      localList.add(paramList);
    }
    AppMethodBeat.o(213608);
    return localList;
  }
  
  private static boolean Yk()
  {
    AppMethodBeat.i(213610);
    if (bt.getInt(com.tencent.mm.n.g.acA().getValue("ChatroomGlobalSwitch"), 1) == 1)
    {
      AppMethodBeat.o(213610);
      return true;
    }
    AppMethodBeat.o(213610);
    return false;
  }
  
  private final void b(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(213609);
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
      com.tencent.mm.model.p.a(paramString, (List)localLinkedList, getString(2131757105), true, paramList);
    }
    AppMethodBeat.o(213609);
  }
  
  private String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(213612);
    d.g.b.p.h(paramVarArgs, "formatArgs");
    paramVarArgs = this.fLP.getString(paramInt, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    d.g.b.p.g(paramVarArgs, "context.getString(resId, *formatArgs)");
    AppMethodBeat.o(213612);
    return paramVarArgs;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(213611);
    String str = this.fLP.getString(paramInt);
    d.g.b.p.g(str, "context.getString(resId)");
    AppMethodBeat.o(213611);
    return str;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "", "onMemberListChanged", "", "updateUI", "ui-chatroom_release"})
  public static abstract interface b
  {
    public abstract void Yl();
    
    public abstract void Ym();
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/chatroom/process/ChatRoomAddContactProcess$dealAddChatRoomMember$1", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "onResult", "", "errType", "", "errCode", "errMsg", "", "detailResult", "ui-chatroom_release"})
  public static final class c
    extends com.tencent.mm.roomsdk.a.b.c
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(com.tencent.mm.roomsdk.a.c.a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(213599);
      this.fLW.cancel();
      AppMethodBeat.o(213599);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(a parama, com.tencent.mm.roomsdk.a.b.c paramc, List paramList1, List paramList2, List paramList3) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(213600);
      if (w.zk(this.fLV.dAc))
      {
        paramDialogInterface = this.fLV;
        String str = this.fLX.fij();
        d.g.b.p.g(str, "scene.getChatroomName()");
        a.a(paramDialogInterface, str, this.fLY);
      }
      paramDialogInterface = new ArrayList();
      paramDialogInterface.addAll((Collection)this.fLZ);
      paramDialogInterface.addAll((Collection)this.fMa);
      a.a(this.fLV, (List)paramDialogInterface);
      ((com.tencent.mm.plugin.messenger.foundation.a.u)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.u.class)).JL(1);
      ((f)com.tencent.mm.kernel.g.ab(f.class)).x(this.fLV.fLS, this.fLV.dAc);
      AppMethodBeat.o(213600);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(213602);
      a.a(this.fLV, (Context)this.fLV.fLP);
      AppMethodBeat.o(213602);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    h(a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(213603);
      this.fLV.fLT.Yl();
      AppMethodBeat.o(213603);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "detailResult", "Lcom/tencent/mm/roomsdk/model/callback/RoomCallbackBaseFunc;", "onResult"})
  static final class i<T extends com.tencent.mm.roomsdk.a.b.a<com.tencent.mm.roomsdk.a.b.a<?>>>
    implements com.tencent.mm.roomsdk.a.b.a<com.tencent.mm.roomsdk.a.b.a<?>>
  {
    i(a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.roomsdk.a.b.a<?> parama)
    {
      AppMethodBeat.i(213604);
      this.fLV.fLT.Yl();
      this.fLV.fLT.Ym();
      ((f)com.tencent.mm.kernel.g.ab(f.class)).x(this.fLV.fLS, this.fLV.dAc);
      AppMethodBeat.o(213604);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "detailResult", "Lcom/tencent/mm/roomsdk/model/callback/RoomCallbackFunc;", "onResult"})
  static final class j
    implements com.tencent.mm.roomsdk.a.b.b
  {
    j(a parama) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class k
    implements DialogInterface.OnCancelListener
  {
    k(com.tencent.mm.roomsdk.a.c.a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(213606);
      this.fMc.cancel();
      AppMethodBeat.o(213606);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.g.a
 * JD-Core Version:    0.7.0.1
 */