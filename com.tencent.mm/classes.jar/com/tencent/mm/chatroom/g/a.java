package com.tencent.mm.chatroom.g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.model.al;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.p;
import d.n.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.Log;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess;", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "chatRoomName", "", "userNameByAdd", "localHistoryInfo", "Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "fakeMsgId", "", "iChatRoomAddContactCallback", "Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "(Lcom/tencent/mm/ui/MMActivity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;JLcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;)V", "getChatRoomName", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFakeMsgId", "()J", "getIChatRoomAddContactCallback", "()Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "getLocalHistoryInfo", "()Lcom/tencent/mm/chatroom/ui/ChatroomInfoUI$LocalHistoryInfo;", "member", "Lcom/tencent/mm/storage/ChatRoomMember;", "getMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "setMember", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "getUserNameByAdd", "dealAddChatRoomMember", "", "errType", "", "errCode", "scene", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "sysErrMsg", "desc", "tipResId", "dealNeedVerify", "verifyUserList", "", "memberBlackList", "getDisplayNameInRoom", "username", "getOwnerName", "getString", "resId", "formatArgs", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "goChatroomUpgrade", "Landroid/content/Context;", "roomname", "hardcodeVerifySysMsg", "chatroomName", "inviteChatRoomMember", "list", "isContactExit", "", "userName", "isSupportChatroomUpgradeEntry", "usernameToDisplayName", "memberList", "Companion", "IChatRoomAddContactCallback", "ui-chatroom_release"})
public final class a
{
  private static final String TAG = "MicroMsg.ChatRoomAddContactProcess";
  public static final a.a fNY;
  final String dBh;
  private ac fNS;
  final MMActivity fNT;
  private final String fNU;
  private final ChatroomInfoUI.LocalHistoryInfo fNV;
  final long fNW;
  final b fNX;
  
  static
  {
    AppMethodBeat.i(217332);
    fNY = new a.a((byte)0);
    TAG = "MicroMsg.ChatRoomAddContactProcess";
    AppMethodBeat.o(217332);
  }
  
  public a(MMActivity paramMMActivity, String paramString1, String paramString2, ChatroomInfoUI.LocalHistoryInfo paramLocalHistoryInfo, long paramLong, b paramb)
  {
    AppMethodBeat.i(217331);
    this.fNT = paramMMActivity;
    this.dBh = paramString1;
    this.fNU = paramString2;
    this.fNV = paramLocalHistoryInfo;
    this.fNW = paramLong;
    this.fNX = paramb;
    paramMMActivity = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class);
    p.g(paramMMActivity, "service(IChatroomService::class.java)");
    this.fNS = ((com.tencent.mm.plugin.chatroom.a.c)paramMMActivity).azP().Bx(this.dBh);
    if (this.fNS != null)
    {
      paramMMActivity = this.fNS;
      if (paramMMActivity == null) {
        p.gkB();
      }
      int k = paramMMActivity.ftP();
      int j = 0;
      paramMMActivity = this.fNS;
      if (paramMMActivity == null) {
        p.gkB();
      }
      int i = j;
      if (!paramMMActivity.YQ())
      {
        if (!x.zV(this.dBh)) {
          break label253;
        }
        i = j;
        if ((k & 0x1) == 1) {
          i = 1;
        }
      }
      while (i != 0)
      {
        new f.a((Context)this.fNT).aZq(getString(2131762554)).aZu(getString(2131755884)).zi(true).s(Boolean.TRUE).aZv(getString(2131755691)).aZs(getString(2131762208)).c((f.c)new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(217314);
            if (paramAnonymousBoolean) {
              a.a(this.fNZ, paramAnonymousString);
            }
            AppMethodBeat.o(217314);
          }
        }).show();
        AppMethodBeat.o(217331);
        return;
        label253:
        i = j;
        if (k == 2) {
          i = 1;
        }
      }
      I(null, 2131755168);
      AppMethodBeat.o(217331);
      return;
    }
    Log.e(TAG, "member is null!!!");
    AppMethodBeat.o(217331);
  }
  
  private final void I(String paramString, int paramInt)
  {
    AppMethodBeat.i(217325);
    if ((x.zU(this.dBh)) && (!x.zX(this.dBh)) && (!q.zo(this.fNU)))
    {
      h.T((Context)this.fNT, getString(2131762644), getString(2131755906));
      AppMethodBeat.o(217325);
      return;
    }
    Object localObject1 = this.fNU;
    int j;
    if (p.i(bu.nullAsNil(com.tencent.mm.model.v.aAC()), localObject1)) {
      j = 1;
    }
    while (j != 0)
    {
      h.T((Context)this.fNT, getString(2131755154), getString(2131755906));
      AppMethodBeat.o(217325);
      return;
      Object localObject2 = r.zA(this.dBh);
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
          if (!p.i((String)((Iterator)localObject2).next(), localObject1)) {
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
      if (this.fNU == null)
      {
        AppMethodBeat.o(217325);
        return;
      }
      localObject1 = (CharSequence)this.fNU;
      localObject1 = ((Collection)new k(",").q((CharSequence)localObject1, 0)).toArray(new String[0]);
      if (localObject1 == null)
      {
        paramString = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(217325);
        throw paramString;
      }
      localObject1 = bu.U((String[])localObject1);
      if (localObject1 == null)
      {
        AppMethodBeat.o(217325);
        return;
      }
      paramString = com.tencent.mm.roomsdk.a.b.aRc(this.dBh).a(this.dBh, (List)localObject1, paramString, this.fNV);
      paramString.d((com.tencent.mm.roomsdk.a.b.a)new c(this));
      localObject1 = (Context)this.fNT;
      getString(2131755906);
      paramString.a((Context)localObject1, getString(paramInt), true, (DialogInterface.OnCancelListener)new d(paramString));
      AppMethodBeat.o(217325);
      return;
    }
  }
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(217326);
    List localList = (List)new LinkedList();
    if (!com.tencent.mm.kernel.g.ajM())
    {
      AppMethodBeat.o(217326);
      return localList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(217326);
      return localList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramList = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(paramList, "MMKernel.service(IMessengerStorage::class.java)");
      an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramList).azF().BH(str);
      paramList = str;
      if (localan != null)
      {
        paramList = str;
        if (localan.adE() != 0)
        {
          paramList = localan.adG();
          p.g(paramList, "ct.displayRemark");
        }
      }
      localList.add(paramList);
    }
    AppMethodBeat.o(217326);
    return localList;
  }
  
  private static boolean Yu()
  {
    AppMethodBeat.i(217328);
    if (bu.getInt(com.tencent.mm.n.g.acL().getValue("ChatroomGlobalSwitch"), 1) == 1)
    {
      AppMethodBeat.o(217328);
      return true;
    }
    AppMethodBeat.o(217328);
    return false;
  }
  
  private final void b(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(217327);
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
      q.a(paramString, (List)localLinkedList, getString(2131757105), true, paramList);
    }
    AppMethodBeat.o(217327);
  }
  
  private String getString(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217330);
    p.h(paramVarArgs, "formatArgs");
    paramVarArgs = this.fNT.getString(paramInt, Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    p.g(paramVarArgs, "context.getString(resId, *formatArgs)");
    AppMethodBeat.o(217330);
    return paramVarArgs;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(217329);
    String str = this.fNT.getString(paramInt);
    p.g(str, "context.getString(resId)");
    AppMethodBeat.o(217329);
    return str;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/chatroom/process/ChatRoomAddContactProcess$IChatRoomAddContactCallback;", "", "onMemberListChanged", "", "updateUI", "ui-chatroom_release"})
  public static abstract interface b
  {
    public abstract void Yv();
    
    public abstract void Yw();
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/chatroom/process/ChatRoomAddContactProcess$dealAddChatRoomMember$1", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "onResult", "", "errType", "", "errCode", "errMsg", "", "detailResult", "ui-chatroom_release"})
  public static final class c
    extends com.tencent.mm.roomsdk.a.b.c
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class d
    implements DialogInterface.OnCancelListener
  {
    d(com.tencent.mm.roomsdk.a.c.a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(217316);
      this.fOa.cancel();
      AppMethodBeat.o(217316);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
  static final class e
    implements DialogInterface.OnClickListener
  {
    e(a parama, com.tencent.mm.roomsdk.a.b.c paramc, List paramList1, List paramList2, List paramList3) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(217317);
      if (x.zU(this.fNZ.dBh))
      {
        paramDialogInterface = this.fNZ;
        String str = this.fOb.fmb();
        p.g(str, "scene.getChatroomName()");
        a.a(paramDialogInterface, str, this.fOc);
      }
      paramDialogInterface = new ArrayList();
      paramDialogInterface.addAll((Collection)this.fOd);
      paramDialogInterface.addAll((Collection)this.fOe);
      a.a(this.fNZ, (List)paramDialogInterface);
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.v.class)).Kk(1);
      ((f)com.tencent.mm.kernel.g.ab(f.class)).y(this.fNZ.fNW, this.fNZ.dBh);
      AppMethodBeat.o(217317);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class g
    implements DialogInterface.OnClickListener
  {
    g(a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(217320);
      a.a(this.fNZ, (Context)this.fNZ.fNT);
      AppMethodBeat.o(217320);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class h
    implements DialogInterface.OnClickListener
  {
    h(a parama) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(217321);
      this.fNZ.fNX.Yv();
      AppMethodBeat.o(217321);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "detailResult", "Lcom/tencent/mm/roomsdk/model/callback/RoomCallbackBaseFunc;", "onResult"})
  static final class i<T extends com.tencent.mm.roomsdk.a.b.a<com.tencent.mm.roomsdk.a.b.a<?>>>
    implements com.tencent.mm.roomsdk.a.b.a<com.tencent.mm.roomsdk.a.b.a<?>>
  {
    i(a parama) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.roomsdk.a.b.a<?> parama)
    {
      AppMethodBeat.i(217322);
      this.fNZ.fNX.Yv();
      this.fNZ.fNX.Yw();
      ((f)com.tencent.mm.kernel.g.ab(f.class)).y(this.fNZ.fNW, this.fNZ.dBh);
      AppMethodBeat.o(217322);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "detailResult", "Lcom/tencent/mm/roomsdk/model/callback/RoomCallbackFunc;", "onResult"})
  static final class j
    implements com.tencent.mm.roomsdk.a.b.b
  {
    j(a parama) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class k
    implements DialogInterface.OnCancelListener
  {
    k(com.tencent.mm.roomsdk.a.c.a parama) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(217324);
      this.fOg.cancel();
      AppMethodBeat.o(217324);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.g.a
 * JD-Core Version:    0.7.0.1
 */