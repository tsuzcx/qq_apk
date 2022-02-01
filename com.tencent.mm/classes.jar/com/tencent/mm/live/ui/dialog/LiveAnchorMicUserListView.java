package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.c.c;
import com.tencent.mm.live.model.a.j;
import com.tencent.mm.live.model.a.k;
import com.tencent.mm.live.model.b.a.a;
import com.tencent.mm.live.model.o;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.am;
import kotlin.g.b.an;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "acceptLiveMicListener", "Lkotlin/Function1;", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "Lkotlin/ParameterName;", "name", "user", "", "adapter", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "callMicListener", "Lkotlin/Function2;", "", "calling", "getCallMicListener", "()Lkotlin/jvm/functions/Function2;", "setCallMicListener", "(Lkotlin/jvm/functions/Function2;)V", "canSelectUser", "hideClickListener", "Lkotlin/Function0;", "getHideClickListener", "()Lkotlin/jvm/functions/Function0;", "setHideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "micPermission", "getMicPermission", "()Z", "setMicPermission", "(Z)V", "micPermissionListener", "enable", "getMicPermissionListener", "()Lkotlin/jvm/functions/Function1;", "setMicPermissionListener", "(Lkotlin/jvm/functions/Function1;)V", "parent", "Landroid/view/View;", "getParent", "()Landroid/view/View;", "setParent", "(Landroid/view/View;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "selectUser", "stopLiveMicListener", "userListView", "Landroidx/recyclerview/widget/RecyclerView;", "waitingMic", "acceptMic", "anchorCloseMic", "callback", "errType", "errCode", "buildBottomSheet", "buildMicCallingItemData", "buildMicWaitingItemData", "users", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "buildNoPermissionItemData", "buildNoUserItemData", "buildPermissionItemData", "clearData", "getSelectUser", "loadOnlineMembers", "playMicHungUpVoice", "refreshListView", "refreshParentsView", "resetMicUser", "sdkStartMic", "setDefaultMicState", "setMicUser", "micUser", "updateMicPermission", "Companion", "LiveAnchorMicUserAdapter", "LiveMicListItem", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveAnchorMicUserListView
  extends RelativeLayout
{
  public static final LiveAnchorMicUserListView.a nlO;
  private f ngn;
  private final com.tencent.mm.plugin.voip.video.e nky;
  private boolean nlP;
  private kotlin.g.a.a<ah> nlQ;
  private m<? super Boolean, ? super a.a, ah> nlR;
  private kotlin.g.a.b<? super Boolean, ah> nlS;
  private final RecyclerView nlT;
  public final b nlU;
  private a.a nlV;
  private boolean nlW;
  public boolean nlX;
  private kotlin.g.a.b<? super a.a, ah> nlY;
  private kotlin.g.a.b<? super a.a, ah> nlZ;
  private View nma;
  
  static
  {
    AppMethodBeat.i(246681);
    nlO = new LiveAnchorMicUserListView.a((byte)0);
    AppMethodBeat.o(246681);
  }
  
  public LiveAnchorMicUserListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(246434);
    this.nky = new com.tencent.mm.plugin.voip.video.e(MMApplicationContext.getContext());
    this.nlP = true;
    this.nlU = new b();
    this.nlW = true;
    this.nlY = ((kotlin.g.a.b)new d(this));
    this.nlZ = ((kotlin.g.a.b)new e(this));
    paramContext = LayoutInflater.from(paramContext).inflate(b.f.live_anchor_mic_list_view, (ViewGroup)this, true);
    kotlin.g.b.s.s(paramContext, "from(context).inflate(R.…ic_list_view, this, true)");
    this.nma = paramContext;
    this.nma.findViewById(b.e.close_img).setOnClickListener(new LiveAnchorMicUserListView..ExternalSyntheticLambda0(this));
    paramContext = this.nma.findViewById(b.e.live_anchor_mic_list);
    kotlin.g.b.s.s(paramContext, "parent.findViewById(R.id.live_anchor_mic_list)");
    this.nlT = ((RecyclerView)paramContext);
    this.nlT.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.nlT.setAdapter((RecyclerView.a)this.nlU);
    this.nlT.setItemViewCacheSize(0);
    AppMethodBeat.o(246434);
  }
  
  private static final void a(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(246589);
    kotlin.g.b.s.u(paramLiveAnchorMicUserListView, "this$0");
    paramp.setHasCallbackToQueue(true);
    paramp = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramLiveAnchorMicUserListView.setMicPermission(true);
      paramLiveAnchorMicUserListView.bkQ();
    }
    for (;;)
    {
      paramString = paramLiveAnchorMicUserListView.getMicPermissionListener();
      if (paramString != null) {
        paramString.invoke(Boolean.valueOf(paramLiveAnchorMicUserListView.getMicPermission()));
      }
      AppMethodBeat.o(246589);
      return;
      paramLiveAnchorMicUserListView.setMicPermission(false);
    }
  }
  
  private static final void a(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(246573);
    kotlin.g.b.s.u(paramLiveAnchorMicUserListView, "this$0");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    default: 
      paramLiveAnchorMicUserListView = paramLiveAnchorMicUserListView.ngn;
      if (paramLiveAnchorMicUserListView != null) {
        paramLiveAnchorMicUserListView.cyW();
      }
      AppMethodBeat.o(246573);
      return;
    case 0: 
      AppMethodBeat.o(246573);
      return;
    }
    paramMenuItem = paramLiveAnchorMicUserListView.ngn;
    if (paramMenuItem != null) {
      paramMenuItem.cyW();
    }
    paramLiveAnchorMicUserListView.gd(false);
    AppMethodBeat.o(246573);
  }
  
  private static final void a(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, View paramView)
  {
    AppMethodBeat.i(246538);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveAnchorMicUserListView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramLiveAnchorMicUserListView, "this$0");
    paramLiveAnchorMicUserListView = paramLiveAnchorMicUserListView.getHideClickListener();
    if (paramLiveAnchorMicUserListView != null) {
      paramLiveAnchorMicUserListView.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246538);
  }
  
  private static final void a(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, a.a parama, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(246555);
    kotlin.g.b.s.u(paramLiveAnchorMicUserListView, "this$0");
    kotlin.g.b.s.u(parama, "$user");
    paramp.setHasCallbackToQueue(true);
    paramp = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", "[cgi]accept mic errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramLiveAnchorMicUserListView.nky.p(b.g.playend, true, 1);
      paramLiveAnchorMicUserListView = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.biN().b(parama);
      AppMethodBeat.o(246555);
      return;
    }
    aa.makeText(paramLiveAnchorMicUserListView.getContext(), (CharSequence)com.tencent.mm.cd.a.bt(paramLiveAnchorMicUserListView.getContext(), b.h.live_room_mic_apply_error), 0).show();
    paramLiveAnchorMicUserListView.nlW = true;
    parama = paramLiveAnchorMicUserListView.getCallMicListener();
    if (parama != null) {
      parama.invoke(Boolean.FALSE, null);
    }
    paramLiveAnchorMicUserListView.bkQ();
    AppMethodBeat.o(246555);
  }
  
  private static final void a(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(246563);
    kotlin.g.b.s.u(paramLiveAnchorMicUserListView, "this$0");
    f localf = paramLiveAnchorMicUserListView.ngn;
    if (localf != null) {
      localf.setFooterView(null);
    }
    params.clear();
    params.a(1, paramLiveAnchorMicUserListView.getContext().getResources().getColor(b.b.live_title_host_close_btn_color), (CharSequence)paramLiveAnchorMicUserListView.getContext().getResources().getString(b.h.live_room_mic_close_permission_item));
    AppMethodBeat.o(246563);
  }
  
  private static final void a(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, m paramm, a.a parama, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(246547);
    kotlin.g.b.s.u(paramLiveAnchorMicUserListView, "this$0");
    kotlin.g.b.s.u(parama, "$this_apply");
    paramp.setHasCallbackToQueue(true);
    paramp = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", "[cgi-ret]anchor close mic :" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      paramLiveAnchorMicUserListView.bkN();
    }
    if (paramm == null)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aa.makeText(paramLiveAnchorMicUserListView.getContext(), (CharSequence)paramLiveAnchorMicUserListView.getContext().getResources().getString(b.h.live_room_mic_user_hand_up), 0).show();
        paramm = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.biN().nbM.remove(parama);
        paramLiveAnchorMicUserListView.bkO();
        paramm = com.tencent.mm.live.model.u.mZl;
        com.tencent.mm.live.model.u.biN().biX();
        paramLiveAnchorMicUserListView.bkQ();
        paramLiveAnchorMicUserListView = paramLiveAnchorMicUserListView.getCallMicListener();
        if (paramLiveAnchorMicUserListView != null)
        {
          paramLiveAnchorMicUserListView.invoke(Boolean.FALSE, null);
          AppMethodBeat.o(246547);
        }
      }
    }
    else {
      paramm.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    }
    AppMethodBeat.o(246547);
  }
  
  private static final void b(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
  {
    AppMethodBeat.i(246580);
    kotlin.g.b.s.u(paramLiveAnchorMicUserListView, "this$0");
    paramLiveAnchorMicUserListView.ngn = null;
    AppMethodBeat.o(246580);
  }
  
  private static final void b(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(246602);
    kotlin.g.b.s.u(paramLiveAnchorMicUserListView, "this$0");
    paramp.setHasCallbackToQueue(true);
    paramp = com.tencent.mm.live.core.debug.a.mUy;
    com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramLiveAnchorMicUserListView.setMicPermission(false);
      paramString = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.model.u.biN().nbM.clear();
      paramLiveAnchorMicUserListView.bkQ();
    }
    for (;;)
    {
      paramString = paramLiveAnchorMicUserListView.getMicPermissionListener();
      if (paramString != null) {
        paramString.invoke(Boolean.valueOf(paramLiveAnchorMicUserListView.getMicPermission()));
      }
      AppMethodBeat.o(246602);
      return;
      paramLiveAnchorMicUserListView.setMicPermission(true);
    }
  }
  
  private void bkP()
  {
    AppMethodBeat.i(246462);
    int i = com.tencent.mm.cd.a.ms(getContext());
    int j = com.tencent.mm.cd.a.mt(getContext());
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, -1);
      localLayoutParams.gravity = 1;
      localLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(getContext(), getContext().getResources().getDimension(b.c.live_anchor_mic_list_view_margin_top));
      this.nma.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(246462);
      return;
    }
  }
  
  public static void bkR()
  {
    AppMethodBeat.i(246469);
    Object localObject1 = com.tencent.mm.live.model.u.mZl;
    Object localObject2 = com.tencent.mm.live.model.u.biN().nbM;
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((a.a)((Iterator)localObject2).next()).mXK);
    }
    localObject2 = o.mZb;
    o.bF((List)localObject1);
    AppMethodBeat.o(246469);
  }
  
  private final void bkS()
  {
    AppMethodBeat.i(246484);
    this.nlU.nmb.add(new LiveAnchorMicUserListView.c(0, null, null, 6));
    AppMethodBeat.o(246484);
  }
  
  private final void bkT()
  {
    AppMethodBeat.i(246493);
    a.a locala = this.nlV;
    if (locala != null)
    {
      this.nlU.nmb.add(new LiveAnchorMicUserListView.c(1, null, com.tencent.mm.cd.a.bt(getContext(), b.h.live_room_mic_calling), 2));
      this.nlU.nmb.add(new LiveAnchorMicUserListView.c(3, locala, null, 4));
    }
    AppMethodBeat.o(246493);
  }
  
  private final void bkU()
  {
    AppMethodBeat.i(246509);
    this.nlU.nmb.add(new LiveAnchorMicUserListView.c(4, null, null, 6));
    AppMethodBeat.o(246509);
  }
  
  private final void bkV()
  {
    AppMethodBeat.i(246517);
    this.nlU.nmb.add(new LiveAnchorMicUserListView.c(5, null, null, 6));
    AppMethodBeat.o(246517);
  }
  
  private final void clearData()
  {
    AppMethodBeat.i(246476);
    this.nlU.nmb.clear();
    AppMethodBeat.o(246476);
  }
  
  private void e(m<? super Integer, ? super Integer, ah> paramm)
  {
    AppMethodBeat.i(246450);
    a.a locala = this.nlV;
    if (locala != null)
    {
      Object localObject = com.tencent.mm.live.core.debug.a.mUy;
      com.tencent.mm.live.core.debug.a.aH("MicroMsg.LiveCoreMic", kotlin.g.b.s.X("[cgi]anchor close mic.", locala));
      localObject = com.tencent.mm.live.model.u.mZl;
      long l = com.tencent.mm.live.model.u.bie().mMJ;
      localObject = com.tencent.mm.live.model.u.mZl;
      new k(l, com.tencent.mm.live.model.u.bhZ(), String.valueOf(System.currentTimeMillis()), locala.mXx, locala.mXH).doScene(h.aZW().oun, new LiveAnchorMicUserListView..ExternalSyntheticLambda4(this, paramm, locala));
    }
    AppMethodBeat.o(246450);
  }
  
  private final void gd(boolean paramBoolean)
  {
    AppMethodBeat.i(246530);
    if (paramBoolean)
    {
      localObject1 = com.tencent.mm.live.model.u.mZl;
      l = com.tencent.mm.live.model.u.bie().mMJ;
      localObject1 = com.tencent.mm.live.model.u.mZl;
      new j(l, com.tencent.mm.live.model.u.bhZ(), false).doScene(h.aZW().oun, new LiveAnchorMicUserListView..ExternalSyntheticLambda1(this));
      localObject1 = com.tencent.mm.live.model.u.mZl;
      localObject1 = com.tencent.mm.live.model.u.bhZ();
      localObject2 = com.tencent.mm.live.model.u.mZl;
      l = com.tencent.mm.live.model.u.bie().mMJ;
      localObject2 = com.tencent.mm.live.model.u.mZl;
      localObject2 = com.tencent.mm.live.model.u.big();
      localu = com.tencent.mm.live.model.u.mZl;
      com.tencent.mm.live.c.e.a((String)localObject1, l, (String)localObject2, 3, 0, com.tencent.mm.live.model.u.bie().ZWw);
      c.bjT();
      AppMethodBeat.o(246530);
      return;
    }
    e((m)new f(this));
    Object localObject1 = com.tencent.mm.live.model.u.mZl;
    long l = com.tencent.mm.live.model.u.bie().mMJ;
    localObject1 = com.tencent.mm.live.model.u.mZl;
    new j(l, com.tencent.mm.live.model.u.bhZ(), true).doScene(h.aZW().oun, new LiveAnchorMicUserListView..ExternalSyntheticLambda2(this));
    localObject1 = com.tencent.mm.live.model.u.mZl;
    localObject1 = com.tencent.mm.live.model.u.bhZ();
    Object localObject2 = com.tencent.mm.live.model.u.mZl;
    l = com.tencent.mm.live.model.u.bie().mMJ;
    localObject2 = com.tencent.mm.live.model.u.mZl;
    localObject2 = com.tencent.mm.live.model.u.big();
    com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
    com.tencent.mm.live.c.e.a((String)localObject1, l, (String)localObject2, 3, 1, com.tencent.mm.live.model.u.bie().ZWw);
    c.bjS();
    AppMethodBeat.o(246530);
  }
  
  private final void q(ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(246505);
    Object localObject1 = this.nlU.nmb;
    Object localObject2 = am.aixg;
    localObject2 = com.tencent.mm.cd.a.bt(getContext(), b.h.live_room_wait_mic_number);
    kotlin.g.b.s.s(localObject2, "getString(context, R.str…ive_room_wait_mic_number)");
    Object localObject3 = com.tencent.mm.live.model.u.mZl;
    localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.live.model.u.biN().nbM.size()) }, 1));
    kotlin.g.b.s.s(localObject2, "java.lang.String.format(format, *args)");
    ((ArrayList)localObject1).add(new LiveAnchorMicUserListView.c(1, null, (String)localObject2, 2));
    localObject1 = ((Iterable)paramArrayList).iterator();
    label178:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      localObject3 = ((a.a)localObject2).mXK;
      paramArrayList = this.nlV;
      if (paramArrayList == null) {}
      for (paramArrayList = null;; paramArrayList = paramArrayList.mXK)
      {
        if (kotlin.g.b.s.p(localObject3, paramArrayList)) {
          break label178;
        }
        this.nlU.nmb.add(new LiveAnchorMicUserListView.c(2, (a.a)localObject2, null, 4));
        break;
      }
    }
    AppMethodBeat.o(246505);
  }
  
  public final void bkN()
  {
    AppMethodBeat.i(246818);
    this.nky.p(b.g.playend, true, 1);
    AppMethodBeat.o(246818);
  }
  
  public final void bkO()
  {
    this.nlW = true;
    this.nlV = null;
  }
  
  public final void bkQ()
  {
    AppMethodBeat.i(246829);
    bkP();
    clearData();
    bkS();
    if (this.nlV != null) {
      bkT();
    }
    if (this.nlP)
    {
      Object localObject = com.tencent.mm.live.model.u.mZl;
      localObject = com.tencent.mm.live.model.u.biN().nbM;
      Collection localCollection = (Collection)localObject;
      a.a locala = this.nlV;
      if (localCollection == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(246829);
        throw ((Throwable)localObject);
      }
      an.hA(localCollection).remove(locala);
      if (((ArrayList)localObject).size() > 0) {
        q((ArrayList)localObject);
      }
    }
    for (;;)
    {
      this.nlU.bZE.notifyChanged();
      AppMethodBeat.o(246829);
      return;
      if (this.nlV == null)
      {
        bkU();
        continue;
        bkV();
      }
    }
  }
  
  public final m<Boolean, a.a, ah> getCallMicListener()
  {
    return this.nlR;
  }
  
  public final kotlin.g.a.a<ah> getHideClickListener()
  {
    return this.nlQ;
  }
  
  public final boolean getMicPermission()
  {
    return this.nlP;
  }
  
  public final kotlin.g.a.b<Boolean, ah> getMicPermissionListener()
  {
    return this.nlS;
  }
  
  public final View getParent()
  {
    return this.nma;
  }
  
  public final a.a getSelectUser()
  {
    return this.nlV;
  }
  
  public final void setCallMicListener(m<? super Boolean, ? super a.a, ah> paramm)
  {
    this.nlR = paramm;
  }
  
  public final void setDefaultMicState(boolean paramBoolean)
  {
    this.nlP = paramBoolean;
  }
  
  public final void setHideClickListener(kotlin.g.a.a<ah> parama)
  {
    this.nlQ = parama;
  }
  
  public final void setMicPermission(boolean paramBoolean)
  {
    this.nlP = paramBoolean;
  }
  
  public final void setMicPermissionListener(kotlin.g.a.b<? super Boolean, ah> paramb)
  {
    this.nlS = paramb;
  }
  
  public final void setMicUser(a.a parama)
  {
    this.nlV = parama;
  }
  
  public final void setParent(View paramView)
  {
    AppMethodBeat.i(246810);
    kotlin.g.b.s.u(paramView, "<set-?>");
    this.nma = paramView;
    AppMethodBeat.o(246810);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;)V", "liveMicItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "Lkotlin/collections/ArrayList;", "getLiveMicItems", "()Ljava/util/ArrayList;", "setLiveMicItems", "(Ljava/util/ArrayList;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "", "uid", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "loadUserInfo", "itemView", "Landroid/view/View;", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<LiveAnchorMicUserListView.c> nmb;
    
    public b()
    {
      AppMethodBeat.i(246369);
      this.nmb = new ArrayList();
      AppMethodBeat.o(246369);
    }
    
    private static void a(View paramView, a.a parama)
    {
      AppMethodBeat.i(246379);
      au localau = ((n)h.ax(n.class)).bzA().JE(parama.mXK);
      a.b.a((ImageView)paramView.findViewById(b.e.live_anchor_mic_user_icon), parama.mXK, 0.1F, false);
      ((TextView)paramView.findViewById(b.e.live_anchor_mic_user_name)).setText((CharSequence)localau.field_nickname);
      AppMethodBeat.o(246379);
    }
    
    private static final void a(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, b paramb, int paramInt, View paramView)
    {
      AppMethodBeat.i(246397);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramLiveAnchorMicUserListView);
      localb.cH(paramb);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramLiveAnchorMicUserListView, "this$0");
      kotlin.g.b.s.u(paramb, "this$1");
      if (LiveAnchorMicUserListView.e(paramLiveAnchorMicUserListView))
      {
        LiveAnchorMicUserListView.i(paramLiveAnchorMicUserListView);
        LiveAnchorMicUserListView.j(paramLiveAnchorMicUserListView).invoke(((LiveAnchorMicUserListView.c)paramb.nmb.get(paramInt)).nmd);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246397);
    }
    
    private static final void b(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, View paramView)
    {
      AppMethodBeat.i(246388);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramLiveAnchorMicUserListView);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramLiveAnchorMicUserListView, "this$0");
      if (paramLiveAnchorMicUserListView.getMicPermission())
      {
        LiveAnchorMicUserListView.f(paramLiveAnchorMicUserListView);
        paramLiveAnchorMicUserListView = LiveAnchorMicUserListView.g(paramLiveAnchorMicUserListView);
        if (paramLiveAnchorMicUserListView != null) {
          paramLiveAnchorMicUserListView.dDn();
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246388);
        return;
        LiveAnchorMicUserListView.h(paramLiveAnchorMicUserListView);
      }
    }
    
    private static final void b(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, b paramb, int paramInt, View paramView)
    {
      AppMethodBeat.i(246407);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramLiveAnchorMicUserListView);
      localb.cH(paramb);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramLiveAnchorMicUserListView, "this$0");
      kotlin.g.b.s.u(paramb, "this$1");
      LiveAnchorMicUserListView.k(paramLiveAnchorMicUserListView).invoke(((LiveAnchorMicUserListView.c)paramb.nmb.get(paramInt)).nmd);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246407);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(246432);
      kotlin.g.b.s.u(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        paramViewGroup = (RecyclerView.v)new g(LayoutInflater.from(this.nmc.getContext()).inflate(b.f.live_anchor_mic_list_title, paramViewGroup, false));
        AppMethodBeat.o(246432);
        return paramViewGroup;
      case 0: 
        paramViewGroup = (RecyclerView.v)new a(LayoutInflater.from(this.nmc.getContext()).inflate(b.f.live_anchor_mic_list_permission, paramViewGroup, false));
        AppMethodBeat.o(246432);
        return paramViewGroup;
      case 1: 
        paramViewGroup = (RecyclerView.v)new b(LayoutInflater.from(this.nmc.getContext()).inflate(b.f.live_anchor_mic_list_title, paramViewGroup, false));
        AppMethodBeat.o(246432);
        return paramViewGroup;
      case 2: 
        paramViewGroup = (RecyclerView.v)new c(LayoutInflater.from(this.nmc.getContext()).inflate(b.f.live_anchor_mic_list_accept, paramViewGroup, false));
        AppMethodBeat.o(246432);
        return paramViewGroup;
      case 3: 
        paramViewGroup = (RecyclerView.v)new d(LayoutInflater.from(this.nmc.getContext()).inflate(b.f.live_anchor_mic_list_calling, paramViewGroup, false));
        AppMethodBeat.o(246432);
        return paramViewGroup;
      case 4: 
        paramViewGroup = (RecyclerView.v)new e(LayoutInflater.from(this.nmc.getContext()).inflate(b.f.live_anchor_mic_list_no_data, paramViewGroup, false));
        AppMethodBeat.o(246432);
        return paramViewGroup;
      }
      paramViewGroup = (RecyclerView.v)new f(LayoutInflater.from(this.nmc.getContext()).inflate(b.f.live_anchor_mic_list_no_permission, paramViewGroup, false));
      AppMethodBeat.o(246432);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(246456);
      kotlin.g.b.s.u(paramv, "holder");
      switch (getItemViewType(paramInt))
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          paramv = paramv.caK;
          kotlin.g.b.s.s(paramv, "holder.itemView");
          if (!LiveAnchorMicUserListView.e(this.nmc)) {
            break;
          }
          paramv.setAlpha(1.0F);
          paramv.setEnabled(true);
          AppMethodBeat.o(246456);
          return;
          localObject1 = (MMSwitchBtn)paramv.caK.findViewById(b.e.live_anchor_permission_switch);
          ((TextView)paramv.caK.findViewById(b.e.live_anchor_permission_switch_mask)).setOnClickListener(new LiveAnchorMicUserListView.b..ExternalSyntheticLambda0(this.nmc));
          ((MMSwitchBtn)localObject1).setCheck(this.nmc.getMicPermission());
          continue;
          ((TextView)paramv.caK).setText((CharSequence)((LiveAnchorMicUserListView.c)this.nmb.get(paramInt)).title);
          continue;
          localObject1 = ((LiveAnchorMicUserListView.c)this.nmb.get(paramInt)).nmd;
          if (localObject1 != null)
          {
            localObject2 = paramv.caK;
            kotlin.g.b.s.s(localObject2, "holder.itemView");
            a((View)localObject2, (a.a)localObject1);
          }
          ((TextView)paramv.caK.findViewById(b.e.live_mic_accept_txt)).setOnClickListener(new LiveAnchorMicUserListView.b..ExternalSyntheticLambda2(this.nmc, this, paramInt));
        }
      }
      Object localObject1 = ((LiveAnchorMicUserListView.c)this.nmb.get(paramInt)).nmd;
      if (localObject1 != null)
      {
        localObject2 = paramv.caK;
        kotlin.g.b.s.s(localObject2, "holder.itemView");
        a((View)localObject2, (a.a)localObject1);
      }
      Object localObject2 = (ImageView)paramv.caK.findViewById(b.e.live_mic_waiting_loading);
      Object localObject3 = (ImageView)paramv.caK.findViewById(b.e.live_mic_waiting_mask_view);
      localObject1 = (TextView)paramv.caK.findViewById(b.e.live_mic_stop_txt);
      if (LiveAnchorMicUserListView.d(this.nmc))
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject2).setVisibility(0);
        localObject3 = ((ImageView)localObject2).getBackground();
        if (localObject3 == null)
        {
          paramv = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(246456);
          throw paramv;
        }
        ((AnimationDrawable)localObject3).stop();
        localObject2 = ((ImageView)localObject2).getBackground();
        if (localObject2 == null)
        {
          paramv = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(246456);
          throw paramv;
        }
        ((AnimationDrawable)localObject2).start();
        ((TextView)localObject1).setBackground(this.nmc.getContext().getResources().getDrawable(b.d.live_gray_rect_btn_bg));
        ((TextView)localObject1).setText((CharSequence)this.nmc.getContext().getResources().getString(b.h.live_room_mic_cancel));
      }
      for (;;)
      {
        ((TextView)localObject1).setOnClickListener(new LiveAnchorMicUserListView.b..ExternalSyntheticLambda1(this.nmc, this, paramInt));
        break;
        ((ImageView)localObject3).setVisibility(4);
        ((ImageView)localObject2).setVisibility(4);
        localObject2 = ((ImageView)localObject2).getBackground();
        if (localObject2 == null)
        {
          paramv = new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(246456);
          throw paramv;
        }
        ((AnimationDrawable)localObject2).stop();
        ((TextView)localObject1).setBackground(this.nmc.getContext().getResources().getDrawable(b.d.live_pink_rect_btn_bg));
        ((TextView)localObject1).setText((CharSequence)this.nmc.getContext().getResources().getString(b.h.live_room_mic_finish));
      }
      if (paramInt >= 3)
      {
        paramv.setAlpha(0.3F);
        paramv.setEnabled(false);
      }
      AppMethodBeat.o(246456);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(246438);
      int i = this.nmb.size();
      AppMethodBeat.o(246438);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(246460);
      paramInt = ((LiveAnchorMicUserListView.c)this.nmb.get(paramInt)).type;
      AppMethodBeat.o(246460);
      return paramInt;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends RecyclerView.v
    {
      a(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$2", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends RecyclerView.v
    {
      b(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$3", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      extends RecyclerView.v
    {
      c(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$4", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class d
      extends RecyclerView.v
    {
      d(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$5", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class e
      extends RecyclerView.v
    {
      e(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$6", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class f
      extends RecyclerView.v
    {
      f(View paramView)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$7", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class g
      extends RecyclerView.v
    {
      g(View paramView)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<a.a, ah>
  {
    d(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<a.a, ah>
  {
    e(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errType", "", "errCode"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements m<Integer, Integer, ah>
  {
    f(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView
 * JD-Core Version:    0.7.0.1
 */