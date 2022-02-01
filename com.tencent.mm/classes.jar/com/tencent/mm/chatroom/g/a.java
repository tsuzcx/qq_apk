package com.tencent.mm.chatroom.g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.u;
import com.tencent.mm.model.z;
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
import kotlin.n.k;
import kotlin.t;
import org.xwalk.core.Log;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "chatRoomName", "", "userNameByAdd", "localHistoryInfo", "Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "fakeMsgId", "", "iChatRoomAddContactCallback", "Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;JLcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;)V", "getChatRoomName", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFakeMsgId", "()J", "getIChatRoomAddContactCallback", "()Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "getLocalHistoryInfo", "()Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "member", "Lcom/tencent/mm/storage/ChatRoomMember;", "getMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "setMember", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "getUserNameByAdd", "dealAddChatRoomMember", "", "errType", "", "errCode", "scene", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "sysErrMsg", "desc", "tipResId", "dealNeedVerify", "verifyUserList", "", "memberBlackList", "getDisplayNameInRoom", "username", "getOwnerName", "getString", "resId", "formatArgs", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "goChatroomUpgrade", "Landroid/content/Context;", "roomname", "hardcodeVerifySysMsg", "chatroomName", "inviteChatRoomMember", "list", "isContactExit", "", "userName", "isSupportChatroomUpgradeEntry", "usernameToDisplayName", "memberList", "Companion", "IChatRoomAddContactCallback", "ui-chatroom_release"})
public final class a
{
  private static final String TAG = "MicroMsg.ChatRoomAddContactProcess";
  public static final a.a gtj;
  final String dSW;
  private ah gtd;
  final MMActivity gte;
  private final String gtf;
  private final ChatroomInfoUI.LocalHistoryInfo gtg;
  final long gth;
  final b gti;
  
  static
  {
    AppMethodBeat.i(193981);
    gtj = new a.a((byte)0);
    TAG = "MicroMsg.ChatRoomAddContactProcess";
    AppMethodBeat.o(193981);
  }
  
  public a(MMActivity paramMMActivity, String paramString1, String paramString2, ChatroomInfoUI.LocalHistoryInfo paramLocalHistoryInfo, long paramLong, b paramb)
  {
    AppMethodBeat.i(193980);
    this.gte = paramMMActivity;
    this.dSW = paramString1;
    this.gtf = paramString2;
    this.gtg = paramLocalHistoryInfo;
    this.gth = paramLong;
    this.gti = paramb;
    paramMMActivity = g.af(com.tencent.mm.plugin.chatroom.a.c.class);
    p.g(paramMMActivity, "service(IChatroomService::class.java)");
    this.gtd = ((com.tencent.mm.plugin.chatroom.a.c)paramMMActivity).aSX().Kd(this.dSW);
    if (this.gtd != null)
    {
      paramMMActivity = this.gtd;
      if (paramMMActivity == null) {
        p.hyc();
      }
      int k = paramMMActivity.gBv();
      int j = 0;
      paramMMActivity = this.gtd;
      if (paramMMActivity == null) {
        p.hyc();
      }
      int i = j;
      if (!paramMMActivity.amD())
      {
        if (!ab.Iy(this.dSW)) {
          break label253;
        }
        i = j;
        if ((k & 0x1) == 1) {
          i = 1;
        }
      }
      while (i != 0)
      {
        new f.a((Context)this.gte).bow(getString(2131764621)).boA(getString(2131755976)).Dq(true).u(Boolean.TRUE).boB(getString(2131755761)).boy(getString(2131764230)).c((f.c)new f.c()
        {
          public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(193963);
            if (paramAnonymousBoolean) {
              a.a(this.gtk, paramAnonymousString);
            }
            AppMethodBeat.o(193963);
          }
        }).show();
        AppMethodBeat.o(193980);
        return;
        label253:
        i = j;
        if (k == 2) {
          i = 1;
        }
      }
      J(null, 2131755186);
      AppMethodBeat.o(193980);
      return;
    }
    Log.e(TAG, "member is null!!!");
    AppMethodBeat.o(193980);
  }
  
  private final void J(String paramString, int paramInt)
  {
    AppMethodBeat.i(193974);
    if ((ab.Ix(this.dSW)) && (!ab.IB(this.dSW)) && (!u.HQ(this.gtf)))
    {
      com.tencent.mm.ui.base.h.X((Context)this.gte, getString(2131764727), getString(2131755998));
      AppMethodBeat.o(193974);
      return;
    }
    Object localObject1 = this.gtf;
    int j;
    if (p.j(Util.nullAsNil(z.aTY()), localObject1)) {
      j = 1;
    }
    while (j != 0)
    {
      com.tencent.mm.ui.base.h.X((Context)this.gte, getString(2131755172), getString(2131755998));
      AppMethodBeat.o(193974);
      return;
      Object localObject2 = com.tencent.mm.model.v.Ic(this.dSW);
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
          if (!p.j((String)((Iterator)localObject2).next(), localObject1)) {
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
      if (this.gtf == null)
      {
        AppMethodBeat.o(193974);
        return;
      }
      localObject1 = (CharSequence)this.gtf;
      localObject1 = ((Collection)new k(",").q((CharSequence)localObject1, 0)).toArray(new String[0]);
      if (localObject1 == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(193974);
        throw paramString;
      }
      localObject1 = Util.stringsToList((String[])localObject1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(193974);
        return;
      }
      paramString = com.tencent.mm.roomsdk.a.b.bhF(this.dSW).a(this.dSW, (List)localObject1, paramString, this.gtg);
      paramString.d((com.tencent.mm.roomsdk.a.b.a)new c(this));
      paramString.a((Context)this.gte, getString(2131755998), getString(paramInt), true, true, (DialogInterface.OnCancelListener)new d(paramString));
      AppMethodBeat.o(193974);
      return;
    }
  }
  
  private static List<String> V(List<String> paramList)
  {
    AppMethodBeat.i(193975);
    List localList = (List)new LinkedList();
    if (!g.aAc())
    {
      AppMethodBeat.o(193975);
      return localList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(193975);
      return localList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramList, "MMKernel.service(IMessengerStorage::class.java)");
      as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramList).aSN().Kn(str);
      paramList = str;
      if (localas != null)
      {
        paramList = str;
        if (localas.arH() != 0)
        {
          paramList = localas.arJ();
          p.g(paramList, "ct.displayRemark");
        }
      }
      localList.add(paramList);
    }
    AppMethodBeat.o(193975);
    return localList;
  }
  
  private static boolean amh()
  {
    AppMethodBeat.i(193977);
    if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("ChatroomGlobalSwitch"), 1) == 1)
    {
      AppMethodBeat.o(193977);
      return true;
    }
    AppMethodBeat.o(193977);
    return false;
  }
  
  private final void b(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(193976);
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
      u.a(paramString, (List)localLinkedList, getString(2131757306), true, paramList);
    }
    AppMethodBeat.o(193976);
  }
  
  private String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(193979);
    p.h(paramVarArgs, "formatArgs");
    paramVarArgs = this.gte.getString(paramInt, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    p.g(paramVarArgs, "context.getString(resId, *formatArgs)");
    AppMethodBeat.o(193979);
    return paramVarArgs;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(193978);
    String str = this.gte.getString(paramInt);
    p.g(str, "context.getString(resId)");
    AppMethodBeat.o(193978);
    return str;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "", "onMemberListChanged", "", "updateUI", "ui-chatroom_release"})
  public static abstract interface b
  {
    public abstract void ami();
    
    public abstract void amj();
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/chatroom/process/ChatRoomAddContactProcess$dealAddChatRoomMember$1", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "onResult", "", "errType", "", "errCode", "errMsg", "", "detailResult", "ui-chatroom_release"})
  public static final class c
    extends com.tencent.mm.roomsdk.a.b.c
  {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(com.tencent.mm.roomsdk.a.c.a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(193965);
      this.gtl.cancel();
      AppMethodBeat.o(193965);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(a parama, com.tencent.mm.roomsdk.a.b.c paramc, List paramList1, List paramList2, List paramList3) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(193966);
      if (ab.Ix(this.gtk.dSW))
      {
        paramDialogInterface = this.gtk;
        String str = this.gtm.gvN();
        p.g(str, "scene.getChatroomName()");
        a.a(paramDialogInterface, str, this.gtn);
      }
      paramDialogInterface = new ArrayList();
      paramDialogInterface.addAll((Collection)this.gto);
      paramDialogInterface.addAll((Collection)this.gtp);
      a.a(this.gtk, (List)paramDialogInterface);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)g.af(com.tencent.mm.plugin.messenger.foundation.a.v.class)).Qm(1);
      ((com.tencent.mm.plugin.record.a.f)g.af(com.tencent.mm.plugin.record.a.f.class)).D(this.gtk.gth, this.gtk.dSW);
      AppMethodBeat.o(193966);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
  static final class f
    implements DialogInterface.OnClickListener
  {
    public static final f gtq;
    
    static
    {
      AppMethodBeat.i(193968);
      gtq = new f();
      AppMethodBeat.o(193968);
    }
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(193967);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)g.af(com.tencent.mm.plugin.messenger.foundation.a.v.class)).Qm(4);
      AppMethodBeat.o(193967);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(193969);
      a.a(this.gtk, (Context)this.gtk.gte);
      AppMethodBeat.o(193969);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    h(a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(193970);
      this.gtk.gti.ami();
      AppMethodBeat.o(193970);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "detailResult", "Lcom/tencent/mm/roomsdk/model/callback/RoomCallbackBaseFunc;", "onResult"})
  static final class i<T extends com.tencent.mm.roomsdk.a.b.a<com.tencent.mm.roomsdk.a.b.a<?>>>
    implements com.tencent.mm.roomsdk.a.b.a<com.tencent.mm.roomsdk.a.b.a<?>>
  {
    i(a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.roomsdk.a.b.a<?> parama)
    {
      AppMethodBeat.i(193971);
      this.gtk.gti.ami();
      this.gtk.gti.amj();
      ((com.tencent.mm.plugin.record.a.f)g.af(com.tencent.mm.plugin.record.a.f.class)).D(this.gtk.gth, this.gtk.dSW);
      AppMethodBeat.o(193971);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "detailResult", "Lcom/tencent/mm/roomsdk/model/callback/RoomCallbackFunc;", "onResult"})
  static final class j
    implements com.tencent.mm.roomsdk.a.b.b
  {
    j(a parama) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class k
    implements DialogInterface.OnCancelListener
  {
    k(com.tencent.mm.roomsdk.a.c.a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(193973);
      this.gtr.cancel();
      AppMethodBeat.o(193973);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.g.a
 * JD-Core Version:    0.7.0.1
 */