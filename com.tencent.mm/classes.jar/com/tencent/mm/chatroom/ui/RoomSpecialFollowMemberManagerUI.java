package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.mmdata.rpt.hg;
import com.tencent.mm.chatroom.d.c;
import com.tencent.mm.cp.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.cn;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.k.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatroom/ui/RoomSpecialFollowMemberManagerUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "Lcom/tencent/mm/chatroom/ui/RoomFollowMemberViewHolder$IFollowMemberCallback;", "()V", "contact", "Lcom/tencent/mm/storage/Contact;", "enterFollowMembers", "Ljava/util/ArrayList;", "", "enterTime", "", "exitFollowMembers", "hasClickedMinus", "", "hasClickedPlus", "mEditButton", "Landroid/widget/Button;", "getMEditButton", "()Landroid/widget/Button;", "mEditButton$delegate", "Lkotlin/Lazy;", "mFollowDescTv", "Landroid/widget/TextView;", "getMFollowDescTv", "()Landroid/widget/TextView;", "mFollowDescTv$delegate", "mFollowMemeberRv", "Landroidx/recyclerview/widget/RecyclerView;", "getMFollowMemeberRv", "()Landroidx/recyclerview/widget/RecyclerView;", "mFollowMemeberRv$delegate", "mLine1", "Landroid/widget/ImageView;", "getMLine1", "()Landroid/widget/ImageView;", "mLine1$delegate", "mLine2", "getMLine2", "mLine2$delegate", "mRoomName", "member", "Lcom/tencent/mm/storage/ChatRoomMember;", "memberList", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getData", "", "getLayoutId", "", "getStringToList", "Ljava/util/LinkedList;", "userListString", "split", "goFollowMemberUI", "goToContactInfo", "userName", "remarkName", "nickName", "hideFooter", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyChange", "event", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "report", "updateButton", "updateChatroomMember", "usernameList", "updateRoomFollowMember", "Companion", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public class RoomSpecialFollowMemberManagerUI
  extends MMActivity
  implements c.a, MStorage.IOnStorageChange
{
  private static final String TAG;
  public static final RoomSpecialFollowMemberManagerUI.a lLe;
  private com.tencent.mm.storage.au contact;
  private long enterTime;
  private final ArrayList<com.tencent.mm.storage.au> lKN;
  private String lKh;
  private final boolean lLf;
  private final boolean lLg;
  private final ArrayList<String> lLh;
  private final ArrayList<String> lLi;
  private final j lLj;
  private final j lLk;
  private final j lLl;
  private final j lLm;
  private final j lLn;
  private aj lzy;
  private w tipDialog;
  
  static
  {
    AppMethodBeat.i(241539);
    lLe = new RoomSpecialFollowMemberManagerUI.a((byte)0);
    TAG = "MicroMsg.RoomSpecialFollowMemberManagerUI";
    AppMethodBeat.o(241539);
  }
  
  public RoomSpecialFollowMemberManagerUI()
  {
    AppMethodBeat.i(241501);
    this.lLh = new ArrayList();
    this.lLi = new ArrayList();
    this.lKN = new ArrayList();
    this.lLj = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.lLk = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.lLl = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.lLm = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.lLn = kotlin.k.cm((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(241501);
  }
  
  private static final Void a(RoomSpecialFollowMemberManagerUI paramRoomSpecialFollowMemberManagerUI, LinkedList paramLinkedList, b.a parama)
  {
    AppMethodBeat.i(241537);
    s.u(paramRoomSpecialFollowMemberManagerUI, "this$0");
    s.u(paramLinkedList, "$list");
    Log.i(TAG, "scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[] { Integer.valueOf(447), Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType), Util.nullAsNil(parama.errMsg) });
    Object localObject = paramRoomSpecialFollowMemberManagerUI.tipDialog;
    if (localObject != null) {
      ((w)localObject).dismiss();
    }
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      Log.i(TAG, "[updateRoomFollowMember] roomName:%s size:%s", new Object[] { paramRoomSpecialFollowMemberManagerUI.lKh, Integer.valueOf(paramLinkedList.size()) });
      paramRoomSpecialFollowMemberManagerUI.lKN.clear();
      parama = paramRoomSpecialFollowMemberManagerUI.aNa().getAdapter();
      if (parama != null) {
        parama.bZE.notifyChanged();
      }
      parama = paramLinkedList.iterator();
      while (parama.hasNext())
      {
        localObject = (String)parama.next();
        localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)localObject);
        paramRoomSpecialFollowMemberManagerUI.lKN.add(localObject);
      }
      parama = new LinkedList();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        localObject = (String)paramLinkedList.next();
        zi localzi = new zi();
        localzi.UserName = ((String)localObject);
        parama.add(localzi);
      }
      paramLinkedList = new djd();
      paramLinkedList.YGJ = parama.size();
      paramLinkedList.YGK = parama;
      parama = paramRoomSpecialFollowMemberManagerUI.lzy;
      s.checkNotNull(parama);
      parama.a(paramLinkedList);
      boolean bool = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().replace((IAutoDBItem)paramRoomSpecialFollowMemberManagerUI.lzy);
      paramLinkedList = paramRoomSpecialFollowMemberManagerUI.aNa().getAdapter();
      if (paramLinkedList != null) {
        paramLinkedList.bZE.notifyChanged();
      }
      Log.i(TAG, "[updateRoomFollowMember] ret:%s", new Object[] { Boolean.valueOf(bool) });
      paramRoomSpecialFollowMemberManagerUI.aNe();
    }
    for (;;)
    {
      AppMethodBeat.o(241537);
      return null;
      com.tencent.mm.ui.base.k.c((Context)paramRoomSpecialFollowMemberManagerUI.getContext(), Util.nullAs(parama.errMsg, paramRoomSpecialFollowMemberManagerUI.getString(a.i.try_again)), paramRoomSpecialFollowMemberManagerUI.getString(a.i.app_tip), true);
    }
  }
  
  private static final void a(RoomSpecialFollowMemberManagerUI paramRoomSpecialFollowMemberManagerUI, View paramView)
  {
    AppMethodBeat.i(241529);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRoomSpecialFollowMemberManagerUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/RoomSpecialFollowMemberManagerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRoomSpecialFollowMemberManagerUI, "this$0");
    Log.i(TAG, "goFollowMemberUI()");
    paramView = new Intent((Context)paramRoomSpecialFollowMemberManagerUI, SelectRoomFollowMemberManagerUI.class);
    paramView.putExtra("RoomInfo_Id", paramRoomSpecialFollowMemberManagerUI.lKh);
    paramView.putExtra("selectRoomMemberNoOpenIm", true);
    paramRoomSpecialFollowMemberManagerUI.startActivityForResult(paramView, 1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/chatroom/ui/RoomSpecialFollowMemberManagerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241529);
  }
  
  private static final boolean a(RoomSpecialFollowMemberManagerUI paramRoomSpecialFollowMemberManagerUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(241520);
    s.u(paramRoomSpecialFollowMemberManagerUI, "this$0");
    paramRoomSpecialFollowMemberManagerUI.finish();
    AppMethodBeat.o(241520);
    return true;
  }
  
  private final RecyclerView aNa()
  {
    AppMethodBeat.i(241503);
    Object localObject = this.lLk.getValue();
    s.s(localObject, "<get-mFollowMemeberRv>(...)");
    localObject = (RecyclerView)localObject;
    AppMethodBeat.o(241503);
    return localObject;
  }
  
  private final Button aNb()
  {
    AppMethodBeat.i(241505);
    Object localObject = this.lLl.getValue();
    s.s(localObject, "<get-mEditButton>(...)");
    localObject = (Button)localObject;
    AppMethodBeat.o(241505);
    return localObject;
  }
  
  private final ImageView aNc()
  {
    AppMethodBeat.i(241506);
    Object localObject = this.lLm.getValue();
    s.s(localObject, "<get-mLine1>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(241506);
    return localObject;
  }
  
  private final ImageView aNd()
  {
    AppMethodBeat.i(241510);
    Object localObject = this.lLn.getValue();
    s.s(localObject, "<get-mLine2>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(241510);
    return localObject;
  }
  
  private final void aNe()
  {
    AppMethodBeat.i(241516);
    if (this.lKN.size() == 0)
    {
      aNb().setText(a.i.app_add);
      aNc().setVisibility(8);
      aNd().setVisibility(8);
      AppMethodBeat.o(241516);
      return;
    }
    aNb().setText(a.i.app_edit);
    aNc().setVisibility(0);
    aNd().setVisibility(0);
    AppMethodBeat.o(241516);
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public int getLayoutId()
  {
    return a.f.lGu;
  }
  
  public void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(241580);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.b.BG_2));
    setBackGroundColorResource(a.b.BG_2);
    setBackBtn(new RoomSpecialFollowMemberManagerUI..ExternalSyntheticLambda0(this));
    Object localObject1 = this.lzy;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null) {
        break label284;
      }
      localObject1 = this.lzy;
      if (localObject1 != null) {
        break label262;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 == null) {
        break label284;
      }
      localObject1 = this.lzy;
      if (localObject1 == null) {
        break label284;
      }
      localObject2 = ((aj)localObject1).field_localChatRoomWatchMembers;
      if (localObject2 == null) {
        break label284;
      }
      localObject2 = ((djd)localObject2).YGK;
      if (localObject2 == null) {
        break label284;
      }
      localObject2 = ((LinkedList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (zi)((Iterator)localObject2).next();
        if ((!Util.isNullOrNil(((zi)localObject3).UserName)) && (!this.lLh.contains(((zi)localObject3).UserName)) && (((aj)localObject1).bHw().contains(((zi)localObject3).UserName)))
        {
          Log.i(TAG, "[resetData] Room Manager:%s", new Object[] { ((zi)localObject3).UserName });
          com.tencent.mm.storage.au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(((zi)localObject3).UserName);
          this.lKN.add(localau);
          this.lLh.add(((zi)localObject3).UserName);
        }
      }
      localObject1 = ((aj)localObject1).field_localChatRoomWatchMembers;
      break;
      label262:
      Object localObject3 = ((aj)localObject1).field_localChatRoomWatchMembers;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((djd)localObject3).YGK;
      }
    }
    label284:
    localObject1 = this.lLj.getValue();
    s.s(localObject1, "<get-mFollowDescTv>(...)");
    ((TextView)localObject1).setText((CharSequence)getString(a.i.lIT, new Object[] { Integer.valueOf(RoomSpecialFollowMemberManagerUI.a.aNf()) }));
    aNa().setAdapter((RecyclerView.a)new b(this.lKN, this.lzy, (c.a)this));
    localObject1 = new WxLinearLayoutManager((Context)getContext());
    ((WxLinearLayoutManager)localObject1).setOrientation(1);
    aNa().setLayoutManager((RecyclerView.LayoutManager)localObject1);
    localObject1 = aNa();
    localObject2 = getContext();
    s.s(localObject2, "context");
    localObject2 = new k.a((Context)localObject2).a(e.agNS).aGi(a.b.FG_3).aGj(a.b.transparent).aGh(a.c.bottomsheet_dividing_line_height);
    int i = a.c.Edge_7A;
    ((k.a)localObject2).agOo = ((k.a)localObject2).mResources.getDimensionPixelSize(i);
    ((RecyclerView)localObject1).a((RecyclerView.h)((k.a)localObject2).jNn());
    aNe();
    aNb().setOnClickListener(new RoomSpecialFollowMemberManagerUI..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(241580);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(241596);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramIntent == null) || (paramInt2 != -1))
    {
      localObject = TAG;
      if (paramIntent == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w((String)localObject, "[onActivityResult] data is null? %s resultCode:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2) });
        AppMethodBeat.o(241596);
        return;
      }
    }
    paramIntent = paramIntent.getStringExtra("Select_Contact");
    Log.i(TAG, "[onActivityResult] roomName:%s requestCode:%s userListString:%s", new Object[] { this.lKh, Integer.valueOf(paramInt1), paramIntent });
    s.checkNotNull(paramIntent);
    paramIntent = ((Collection)kotlin.n.n.a((CharSequence)paramIntent, new String[] { "," })).toArray(new String[0]);
    if (paramIntent == null)
    {
      paramIntent = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(241596);
      throw paramIntent;
    }
    Object localObject = (String[])paramIntent;
    paramIntent = new LinkedList();
    int i = localObject.length;
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      String str = localObject[paramInt1];
      paramInt2 = paramInt1 + 1;
      paramInt1 = paramInt2;
      if (!Util.isNullOrNil(str))
      {
        paramIntent.add(str);
        paramInt1 = paramInt2;
      }
    }
    localObject = (Context)getContext();
    getString(a.i.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.k.a((Context)localObject, getString(a.i.loading), false, null);
    new c(this.lKh, paramIntent).bFJ().a((com.tencent.mm.vending.e.b)this).b(new RoomSpecialFollowMemberManagerUI..ExternalSyntheticLambda2(this, paramIntent));
    AppMethodBeat.o(241596);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(241560);
    super.onCreate(paramBundle);
    this.enterTime = cn.bDu();
    getWindow().setSoftInputMode(32);
    ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().add((MStorage.IOnStorageChange)this);
    this.lKh = getIntent().getStringExtra("RoomInfo_Id");
    Log.i(TAG, "roomName:%s", new Object[] { Util.nullAs(this.lKh, "") });
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.lKh);
    this.lzy = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(Util.nullAsNil(this.lKh));
    if (this.lzy == null)
    {
      finish();
      Log.e(TAG, "member is null");
      AppMethodBeat.o(241560);
      return;
    }
    initView();
    AppMethodBeat.o(241560);
  }
  
  public void onDestroy()
  {
    int k = 1;
    int j = 1;
    int m = 0;
    AppMethodBeat.i(241570);
    super.onDestroy();
    Object localObject1 = new hg();
    ((hg)localObject1).iNB = ((hg)localObject1).F("roomid", this.lKh, true);
    ((hg)localObject1).iNC = this.enterTime;
    ((hg)localObject1).iND = cn.bDu();
    if (this.lLf)
    {
      i = 1;
      ((hg)localObject1).iNE = i;
      if (!this.lLg) {
        break label424;
      }
    }
    Object localObject3;
    String str;
    label424:
    for (int i = 1;; i = 0)
    {
      ((hg)localObject1).iNF = i;
      localObject2 = this.lzy;
      s.checkNotNull(localObject2);
      if (((aj)localObject2).field_localChatRoomWatchMembers == null) {
        break label512;
      }
      localObject2 = this.lzy;
      s.checkNotNull(localObject2);
      if (((aj)localObject2).field_localChatRoomWatchMembers.YGK == null) {
        break label512;
      }
      localObject2 = this.lzy;
      s.checkNotNull(localObject2);
      i = ((aj)localObject2).field_localChatRoomWatchMembers.YGK.size();
      if (i == this.lLh.size()) {
        break label429;
      }
      ((hg)localObject1).iNG = j;
      ((hg)localObject1).iNH = this.lLh.size();
      ((hg)localObject1).iNI = i;
      ((hg)localObject1).bMH();
      localObject1 = new com.tencent.mm.autogen.mmdata.rpt.au();
      ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).ipB = 3;
      ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).kI(this.lKh);
      ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).ipC = this.lLh.size();
      localObject2 = this.lzy;
      s.checkNotNull(localObject2);
      if (((aj)localObject2).field_localChatRoomWatchMembers == null) {
        break label640;
      }
      localObject2 = this.lzy;
      s.checkNotNull(localObject2);
      if (((aj)localObject2).field_localChatRoomWatchMembers.YGK == null) {
        break label640;
      }
      localObject2 = this.lzy;
      s.checkNotNull(localObject2);
      localObject2 = ((aj)localObject2).field_localChatRoomWatchMembers.YGK.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (zi)((Iterator)localObject2).next();
        this.lLi.add(((zi)localObject3).UserName);
        if (!this.lLh.contains(((zi)localObject3).UserName))
        {
          str = ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).ipD;
          s.checkNotNull(str);
          if (str.length() > 0) {
            ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).kJ(s.X(((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).ipD, "|"));
          }
          ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).kJ(s.X(((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).ipD, ((zi)localObject3).UserName));
          ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).ipF += 1;
        }
      }
      i = 0;
      break;
    }
    label429:
    Object localObject2 = this.lzy;
    s.checkNotNull(localObject2);
    localObject2 = ((aj)localObject2).field_localChatRoomWatchMembers.YGK.iterator();
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject3 = (zi)((Iterator)localObject2).next();
    } while (this.lLh.contains(((zi)localObject3).UserName));
    for (j = 1;; j = 0)
    {
      if (j != 0) {}
      for (j = k;; j = 0)
      {
        ((hg)localObject1).iNG = j;
        break;
      }
      label512:
      if (this.lLh.size() == 0)
      {
        j = 0;
        i = 0;
        break;
        localObject2 = this.lLh.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (!this.lLi.contains(localObject3))
          {
            str = ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).ipE;
            s.checkNotNull(str);
            if (str.length() > 0) {
              ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).kK(s.X(((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).ipE, "|"));
            }
            ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).kK(s.X(((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).ipE, localObject3));
            ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).ipG += 1;
          }
        }
        ((com.tencent.mm.autogen.mmdata.rpt.au)localObject1).bMH();
        ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().remove((MStorage.IOnStorageChange)this);
        AppMethodBeat.o(241570);
        return;
      }
      label640:
      i = m;
      break;
    }
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(241590);
    if (paramMStorageEventData != null) {
      Log.i(TAG, "[onNotifyChange] event:%s [%s:%s]", new Object[] { paramString, paramMStorageEventData.event, Integer.valueOf(paramMStorageEventData.eventId) });
    }
    AppMethodBeat.o(241590);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Button>
  {
    b(RoomSpecialFollowMemberManagerUI paramRoomSpecialFollowMemberManagerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(RoomSpecialFollowMemberManagerUI paramRoomSpecialFollowMemberManagerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    d(RoomSpecialFollowMemberManagerUI paramRoomSpecialFollowMemberManagerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    e(RoomSpecialFollowMemberManagerUI paramRoomSpecialFollowMemberManagerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    f(RoomSpecialFollowMemberManagerUI paramRoomSpecialFollowMemberManagerUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomSpecialFollowMemberManagerUI
 * JD-Core Version:    0.7.0.1
 */