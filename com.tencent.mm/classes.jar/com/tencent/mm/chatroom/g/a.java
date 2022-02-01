package com.tencent.mm.chatroom.g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.chatroom.ui.a.i;
import com.tencent.mm.contact.d;
import com.tencent.mm.k.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xwalk.core.Log;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "chatRoomName", "", "userNameByAdd", "localHistoryInfo", "Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "fakeMsgId", "", "iChatRoomAddContactCallback", "Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;JLcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;)V", "getChatRoomName", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFakeMsgId", "()J", "getIChatRoomAddContactCallback", "()Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "getLocalHistoryInfo", "()Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "member", "Lcom/tencent/mm/storage/ChatRoomMember;", "getMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "setMember", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "getUserNameByAdd", "dealAddChatRoomMember", "", "errType", "", "errCode", "scene", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "sysErrMsg", "desc", "tipResId", "dealNeedVerify", "verifyUserList", "", "memberBlackList", "getDisplayNameInRoom", "username", "getOwnerName", "getString", "resId", "formatArgs", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "goChatroomUpgrade", "Landroid/content/Context;", "roomname", "hardcodeVerifySysMsg", "chatroomName", "inviteChatRoomMember", "list", "isContactExit", "", "userName", "isSupportChatroomUpgradeEntry", "usernameToDisplayName", "memberList", "Companion", "IChatRoomAddContactCallback", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final String TAG;
  public static final a.a lzs;
  private final String hBy;
  final MMActivity lzt;
  private final String lzu;
  private final ChatroomInfoUI.LocalHistoryInfo lzv;
  private final long lzw;
  final b lzx;
  private aj lzy;
  
  static
  {
    AppMethodBeat.i(241547);
    lzs = new a.a((byte)0);
    TAG = "MicroMsg.ChatRoomAddContactProcess";
    AppMethodBeat.o(241547);
  }
  
  public a(MMActivity paramMMActivity, String paramString1, String paramString2, ChatroomInfoUI.LocalHistoryInfo paramLocalHistoryInfo, long paramLong, b paramb)
  {
    AppMethodBeat.i(241466);
    this.lzt = paramMMActivity;
    this.hBy = paramString1;
    this.lzu = paramString2;
    this.lzv = paramLocalHistoryInfo;
    this.lzw = paramLong;
    this.lzx = paramb;
    this.lzy = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.hBy);
    if (this.lzy != null)
    {
      paramMMActivity = this.lzy;
      s.checkNotNull(paramMMActivity);
      int k = paramMMActivity.iZl();
      int j = 0;
      paramMMActivity = this.lzy;
      s.checkNotNull(paramMMActivity);
      int i = j;
      if (!paramMMActivity.aMF())
      {
        if (!au.bwF(this.hBy)) {
          break label240;
        }
        i = j;
        if ((k & 0x1) == 1) {
          i = 1;
        }
      }
      while (i != 0)
      {
        new g.a((Context)this.lzt).bDE(getString(a.i.lHT)).bDI(getString(a.i.app_send)).NF(true).N(Boolean.TRUE).bDJ(getString(a.i.app_cancel)).bDG(getString(a.i.lHN)).c(new a..ExternalSyntheticLambda8(this)).show();
        AppMethodBeat.o(241466);
        return;
        label240:
        i = j;
        if (k == 2) {
          i = 1;
        }
      }
      ak(null, a.i.gpQ);
      AppMethodBeat.o(241466);
      return;
    }
    Log.e(TAG, "member is null!!!");
    AppMethodBeat.o(241466);
  }
  
  private final boolean CW(String paramString)
  {
    AppMethodBeat.i(241474);
    if (s.p(Util.nullAsNil(z.bAM()), paramString))
    {
      AppMethodBeat.o(241474);
      return true;
    }
    Object localObject = v.Il(this.hBy);
    if (localObject == null)
    {
      AppMethodBeat.o(241474);
      return false;
    }
    localObject = ((List)localObject).iterator();
    boolean bool = false;
    while (((Iterator)localObject).hasNext()) {
      if (s.p((String)((Iterator)localObject).next(), paramString)) {
        bool = true;
      }
    }
    AppMethodBeat.o(241474);
    return bool;
  }
  
  private static final void a(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(241504);
    ((y)h.ax(y.class)).aaB(4);
    AppMethodBeat.o(241504);
  }
  
  private static final void a(a parama, int paramInt1, int paramInt2, String paramString, com.tencent.mm.roomsdk.model.b.a parama1)
  {
    AppMethodBeat.i(241517);
    s.u(parama, "this$0");
    parama.lzx.aMd();
    parama.lzx.aMe();
    ((com.tencent.mm.plugin.record.a.f)h.ax(com.tencent.mm.plugin.record.a.f.class)).aa(parama.lzw, parama.hBy);
    AppMethodBeat.o(241517);
  }
  
  private static final void a(a parama, int paramInt1, int paramInt2, String paramString, com.tencent.mm.roomsdk.model.b.b paramb)
  {
    AppMethodBeat.i(241522);
    s.u(parama, "this$0");
    paramString = com.tencent.mm.broadcast.a.CH(paramString);
    if (paramString != null)
    {
      paramString.a((Context)parama.lzt, null, null);
      AppMethodBeat.o(241522);
      return;
    }
    com.tencent.mm.ui.base.k.c((Context)parama.lzt, parama.getString(a.i.gJI), parama.getString(a.i.app_tip), true);
    parama.lzx.aMe();
    AppMethodBeat.o(241522);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(241507);
    s.u(parama, "this$0");
    paramDialogInterface = (Context)parama.lzt;
    if ((paramDialogInterface != null) && (aMc()))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", parama.getString(a.i.chatroom_how_to_upgrade, new Object[] { LocaleUtil.getApplicationLanguage() }));
      localIntent.putExtra("geta8key_username", z.bAM());
      localIntent.putExtra("showShare", false);
      com.tencent.mm.br.c.b(paramDialogInterface, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(241507);
  }
  
  private static final void a(a parama, com.tencent.mm.roomsdk.model.b.c paramc, List paramList1, List paramList2, List paramList3, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(241502);
    s.u(parama, "this$0");
    if (au.bwG(parama.hBy))
    {
      paramc = paramc.chatroomName;
      s.s(paramc, "scene.getChatroomName()");
      parama.c(paramc, paramList1);
    }
    paramc = new ArrayList();
    paramc.addAll((Collection)paramList2);
    paramc.addAll((Collection)paramList3);
    paramc = (List)paramc;
    paramc = com.tencent.mm.roomsdk.model.b.btW(parama.hBy).a(parama.hBy, paramc, parama.lzv);
    paramc.b(new a..ExternalSyntheticLambda6(parama)).c((com.tencent.mm.roomsdk.model.b.a)new a..ExternalSyntheticLambda7(parama));
    paramc.a((Context)parama.lzt, parama.getString(a.i.app_tip), parama.getString(a.i.gTO), true, true, new a..ExternalSyntheticLambda1(paramc));
    ((y)h.ax(y.class)).aaB(1);
    ((com.tencent.mm.plugin.record.a.f)h.ax(com.tencent.mm.plugin.record.a.f.class)).aa(parama.lzw, parama.hBy);
    AppMethodBeat.o(241502);
  }
  
  private static final void a(a parama, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(241496);
    s.u(parama, "this$0");
    if (paramBoolean) {
      parama.ak(paramString, a.i.lHD);
    }
    AppMethodBeat.o(241496);
  }
  
  private static final void a(com.tencent.mm.roomsdk.model.factory.a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(241500);
    parama.cancel();
    AppMethodBeat.o(241500);
  }
  
  private static boolean aMc()
  {
    AppMethodBeat.i(241487);
    if (Util.getInt(i.aRC().getValue("ChatroomGlobalSwitch"), 1) == 1)
    {
      AppMethodBeat.o(241487);
      return true;
    }
    AppMethodBeat.o(241487);
    return false;
  }
  
  private final void ak(String paramString, int paramInt)
  {
    AppMethodBeat.i(241470);
    if ((au.bwG(this.hBy)) && (!ab.II(this.hBy)) && (!u.HZ(this.lzu)))
    {
      com.tencent.mm.ui.base.k.c((Context)this.lzt, getString(a.i.lIz), getString(a.i.app_tip), true);
      AppMethodBeat.o(241470);
      return;
    }
    if (CW(this.lzu))
    {
      com.tencent.mm.ui.base.k.c((Context)this.lzt, getString(a.i.add_room_mem_memberExits), getString(a.i.app_tip), true);
      AppMethodBeat.o(241470);
      return;
    }
    if (this.lzu == null)
    {
      AppMethodBeat.o(241470);
      return;
    }
    Object localObject = (CharSequence)this.lzu;
    localObject = ((Collection)new kotlin.n.k(",").o((CharSequence)localObject, 0)).toArray(new String[0]);
    if (localObject == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(241470);
      throw paramString;
    }
    localObject = Util.stringsToList((String[])localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(241470);
      return;
    }
    paramString = com.tencent.mm.roomsdk.model.b.btW(this.hBy).a(this.hBy, (List)localObject, paramString, this.lzv);
    paramString.d((com.tencent.mm.roomsdk.model.b.a)new c(this));
    paramString.a((Context)this.lzt, getString(a.i.app_tip), getString(paramInt), true, true, new a..ExternalSyntheticLambda0(paramString));
    AppMethodBeat.o(241470);
  }
  
  private static final void b(a parama, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(241511);
    s.u(parama, "this$0");
    parama.lzx.aMd();
    AppMethodBeat.o(241511);
  }
  
  private static final void b(com.tencent.mm.roomsdk.model.factory.a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(241525);
    parama.cancel();
    AppMethodBeat.o(241525);
  }
  
  private static List<String> bs(List<String> paramList)
  {
    AppMethodBeat.i(241479);
    List localList = (List)new LinkedList();
    if (!h.baz())
    {
      AppMethodBeat.o(241479);
      return localList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(241479);
      return localList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      au localau = ((n)h.ax(n.class)).bzA().JE(str);
      paramList = str;
      if (localau != null)
      {
        paramList = str;
        if ((int)localau.maN != 0)
        {
          paramList = localau.aSV();
          s.s(paramList, "ct.displayRemark");
        }
      }
      localList.add(paramList);
    }
    AppMethodBeat.o(241479);
    return localList;
  }
  
  private final void c(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(241483);
    LinkedList localLinkedList;
    int i;
    int k;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localLinkedList = new LinkedList();
      i = 0;
      k = paramList.size() - 1;
      if (k < 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localLinkedList.add(paramList.get(i));
      if (j > k)
      {
        paramList = "weixin://findfriend/verifycontact/" + paramString + '/';
        u.a(paramString, (List)localLinkedList, getString(a.i.chatroom_sys_msg_invite_error_tip), true, paramList);
        AppMethodBeat.o(241483);
        return;
      }
      i = j;
    }
  }
  
  private String getString(int paramInt)
  {
    AppMethodBeat.i(241488);
    String str = this.lzt.getString(paramInt);
    s.s(str, "context.getString(resId)");
    AppMethodBeat.o(241488);
    return str;
  }
  
  private String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(241493);
    s.u(paramVarArgs, "formatArgs");
    paramVarArgs = this.lzt.getString(paramInt, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    s.s(paramVarArgs, "context.getString(resId, *formatArgs)");
    AppMethodBeat.o(241493);
    return paramVarArgs;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "", "onMemberListChanged", "", "updateUI", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void aMd();
    
    public abstract void aMe();
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/chatroom/process/ChatRoomAddContactProcess$dealAddChatRoomMember$1", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "onResult", "", "errType", "", "errCode", "errMsg", "", "detailResult", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.roomsdk.model.b.c
  {
    c(a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.g.a
 * JD-Core Version:    0.7.0.1
 */