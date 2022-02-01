package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
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
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b;
import com.tencent.mm.live.b.c;
import com.tencent.mm.live.b.d;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.a.k;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.u;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "acceptLiveMicListener", "Lkotlin/Function1;", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "Lkotlin/ParameterName;", "name", "user", "", "adapter", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "callMicListener", "Lkotlin/Function2;", "", "calling", "getCallMicListener", "()Lkotlin/jvm/functions/Function2;", "setCallMicListener", "(Lkotlin/jvm/functions/Function2;)V", "canSelectUser", "hideClickListener", "Lkotlin/Function0;", "getHideClickListener", "()Lkotlin/jvm/functions/Function0;", "setHideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "micPermission", "getMicPermission", "()Z", "setMicPermission", "(Z)V", "micPermissionListener", "enable", "getMicPermissionListener", "()Lkotlin/jvm/functions/Function1;", "setMicPermissionListener", "(Lkotlin/jvm/functions/Function1;)V", "parent", "Landroid/view/View;", "getParent", "()Landroid/view/View;", "setParent", "(Landroid/view/View;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "selectUser", "stopLiveMicListener", "userListView", "Landroidx/recyclerview/widget/RecyclerView;", "waitingMic", "acceptMic", "anchorCloseMic", "callback", "errType", "errCode", "buildBottomSheet", "buildMicCallingItemData", "buildMicWaitingItemData", "users", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "buildNoPermissionItemData", "buildNoUserItemData", "buildPermissionItemData", "clearData", "getSelectUser", "loadOnlineMembers", "playMicHungUpVoice", "refreshListView", "refreshParentsView", "resetMicUser", "sdkStartMic", "setDefaultMicState", "setMicUser", "micUser", "updateMicPermission", "Companion", "LiveAnchorMicUserAdapter", "LiveMicListItem", "plugin-logic_release"})
public final class LiveAnchorMicUserListView
  extends RelativeLayout
{
  public static final a kJD;
  private com.tencent.mm.ui.widget.a.e kCR;
  private final com.tencent.mm.plugin.voip.video.e kHI;
  private kotlin.g.a.b<? super a.a, x> kJA;
  private kotlin.g.a.b<? super a.a, x> kJB;
  private View kJC;
  private boolean kJr;
  private kotlin.g.a.a<x> kJs;
  private m<? super Boolean, ? super a.a, x> kJt;
  private kotlin.g.a.b<? super Boolean, x> kJu;
  private final RecyclerView kJv;
  public final b kJw;
  private a.a kJx;
  private boolean kJy;
  public boolean kJz;
  
  static
  {
    AppMethodBeat.i(190929);
    kJD = new a((byte)0);
    AppMethodBeat.o(190929);
  }
  
  public LiveAnchorMicUserListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190927);
    this.kHI = new com.tencent.mm.plugin.voip.video.e(MMApplicationContext.getContext());
    this.kJr = true;
    this.kJw = new b();
    this.kJy = true;
    this.kJA = ((kotlin.g.a.b)new d(this));
    this.kJB = ((kotlin.g.a.b)new j(this));
    paramContext = LayoutInflater.from(paramContext).inflate(b.f.live_anchor_mic_list_view, (ViewGroup)this, true);
    p.j(paramContext, "LayoutInflater.from(cont…ic_list_view, this, true)");
    this.kJC = paramContext;
    this.kJC.findViewById(b.e.close_img).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188574);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.kJE.getHideClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(188574);
      }
    });
    paramContext = this.kJC.findViewById(b.e.live_anchor_mic_list);
    p.j(paramContext, "parent.findViewById(R.id.live_anchor_mic_list)");
    this.kJv = ((RecyclerView)paramContext);
    this.kJv.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.kJv.setAdapter((RecyclerView.a)this.kJw);
    this.kJv.setItemViewCacheSize(0);
    AppMethodBeat.o(190927);
  }
  
  private void a(final m<? super Integer, ? super Integer, x> paramm)
  {
    AppMethodBeat.i(190884);
    a.a locala = this.kJx;
    if (locala != null)
    {
      Object localObject = com.tencent.mm.live.core.debug.a.kqB;
      com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", "[cgi]anchor close mic.".concat(String.valueOf(locala)));
      localObject = u.kwz;
      long l = u.aOr().klE;
      localObject = u.kwz;
      localObject = new k(l, u.aOm(), String.valueOf(System.currentTimeMillis()), locala.ktE, locala.ktN);
      com.tencent.mm.an.t localt = h.aGY();
      p.j(localt, "MMKernel.getNetSceneQueue()");
      ((k)localObject).doScene(localt.aHc(), (i)new f(locala, this, paramm));
      AppMethodBeat.o(190884);
      return;
    }
    AppMethodBeat.o(190884);
  }
  
  private void aRc()
  {
    AppMethodBeat.i(190891);
    int i = com.tencent.mm.ci.a.kr(getContext());
    int j = com.tencent.mm.ci.a.ks(getContext());
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, -1);
      localLayoutParams.gravity = 1;
      Context localContext1 = getContext();
      Context localContext2 = getContext();
      p.j(localContext2, "context");
      localLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(localContext1, localContext2.getResources().getDimension(b.c.live_anchor_mic_list_view_margin_top));
      this.kJC.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(190891);
      return;
    }
  }
  
  public static void aRe()
  {
    AppMethodBeat.i(190900);
    Object localObject1 = u.kwz;
    Object localObject2 = u.aPa().kyn;
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((a.a)((Iterator)localObject2).next()).ktQ);
    }
    localObject2 = com.tencent.mm.live.b.o.kvA;
    com.tencent.mm.live.b.o.ae((List)localObject1);
    AppMethodBeat.o(190900);
  }
  
  private final void aRf()
  {
    AppMethodBeat.i(190903);
    this.kJw.kJF.add(new c(0, null, null, 6));
    AppMethodBeat.o(190903);
  }
  
  private final void aRg()
  {
    AppMethodBeat.i(190910);
    a.a locala = this.kJx;
    if (locala != null)
    {
      this.kJw.kJF.add(new c(1, null, com.tencent.mm.ci.a.ba(getContext(), b.h.live_room_mic_calling), 2));
      this.kJw.kJF.add(new c(3, locala, null, 4));
      AppMethodBeat.o(190910);
      return;
    }
    AppMethodBeat.o(190910);
  }
  
  private final void aRh()
  {
    AppMethodBeat.i(190921);
    this.kJw.kJF.add(new c(4, null, null, 6));
    AppMethodBeat.o(190921);
  }
  
  private final void aRi()
  {
    AppMethodBeat.i(190924);
    this.kJw.kJF.add(new c(5, null, null, 6));
    AppMethodBeat.o(190924);
  }
  
  private final void clearData()
  {
    AppMethodBeat.i(190901);
    this.kJw.kJF.clear();
    AppMethodBeat.o(190901);
  }
  
  private final void n(ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(190916);
    Object localObject1 = this.kJw.kJF;
    Object localObject2 = af.aaBG;
    localObject2 = com.tencent.mm.ci.a.ba(getContext(), b.h.live_room_wait_mic_number);
    p.j(localObject2, "ResourceHelper.getString…ive_room_wait_mic_number)");
    Object localObject3 = u.kwz;
    localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(u.aPa().kyn.size()) }, 1));
    p.j(localObject2, "java.lang.String.format(format, *args)");
    ((ArrayList)localObject1).add(new c(1, null, (String)localObject2, 2));
    localObject1 = ((Iterable)paramArrayList).iterator();
    label180:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      localObject3 = ((a.a)localObject2).ktQ;
      paramArrayList = this.kJx;
      if (paramArrayList != null) {}
      for (paramArrayList = paramArrayList.ktQ;; paramArrayList = null)
      {
        if (!(p.h(localObject3, paramArrayList) ^ true)) {
          break label180;
        }
        this.kJw.kJF.add(new c(2, (a.a)localObject2, null, 4));
        break;
      }
    }
    AppMethodBeat.o(190916);
  }
  
  public final void aRa()
  {
    AppMethodBeat.i(190879);
    this.kHI.i(b.g.playend, true, 1);
    AppMethodBeat.o(190879);
  }
  
  public final void aRb()
  {
    this.kJy = true;
    this.kJx = null;
  }
  
  public final void aRd()
  {
    AppMethodBeat.i(190896);
    aRc();
    clearData();
    aRf();
    if (this.kJx != null) {
      aRg();
    }
    if (this.kJr)
    {
      Object localObject = u.kwz;
      localObject = u.aPa().kyn;
      Collection localCollection = (Collection)localObject;
      a.a locala = this.kJx;
      if (localCollection == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(190896);
        throw ((Throwable)localObject);
      }
      ag.fc(localCollection).remove(locala);
      if (((ArrayList)localObject).size() > 0) {
        n((ArrayList)localObject);
      }
    }
    for (;;)
    {
      this.kJw.notifyDataSetChanged();
      AppMethodBeat.o(190896);
      return;
      if (this.kJx == null)
      {
        aRh();
        continue;
        aRi();
      }
    }
  }
  
  public final m<Boolean, a.a, x> getCallMicListener()
  {
    return this.kJt;
  }
  
  public final kotlin.g.a.a<x> getHideClickListener()
  {
    return this.kJs;
  }
  
  public final boolean getMicPermission()
  {
    return this.kJr;
  }
  
  public final kotlin.g.a.b<Boolean, x> getMicPermissionListener()
  {
    return this.kJu;
  }
  
  public final View getParent()
  {
    return this.kJC;
  }
  
  public final a.a getSelectUser()
  {
    return this.kJx;
  }
  
  public final void setCallMicListener(m<? super Boolean, ? super a.a, x> paramm)
  {
    this.kJt = paramm;
  }
  
  public final void setDefaultMicState(boolean paramBoolean)
  {
    this.kJr = paramBoolean;
  }
  
  public final void setHideClickListener(kotlin.g.a.a<x> parama)
  {
    this.kJs = parama;
  }
  
  public final void setMicPermission(boolean paramBoolean)
  {
    this.kJr = paramBoolean;
  }
  
  public final void setMicPermissionListener(kotlin.g.a.b<? super Boolean, x> paramb)
  {
    this.kJu = paramb;
  }
  
  public final void setMicUser(a.a parama)
  {
    this.kJx = parama;
  }
  
  public final void setParent(View paramView)
  {
    AppMethodBeat.i(190875);
    p.k(paramView, "<set-?>");
    this.kJC = paramView;
    AppMethodBeat.o(190875);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$Companion;", "", "()V", "MIC_ACCEPT", "", "MIC_CALLING", "MIC_NO_DATA", "MIC_NO_PERMISSION", "MIC_PERMISSION", "MIC_TITLE", "plugin-logic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;)V", "liveMicItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "Lkotlin/collections/ArrayList;", "getLiveMicItems", "()Ljava/util/ArrayList;", "setLiveMicItems", "(Ljava/util/ArrayList;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "", "uid", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "loadUserInfo", "itemView", "Landroid/view/View;", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-logic_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<LiveAnchorMicUserListView.c> kJF;
    
    public b()
    {
      AppMethodBeat.i(193583);
      this.kJF = new ArrayList();
      AppMethodBeat.o(193583);
    }
    
    private static void a(View paramView, a.a parama)
    {
      AppMethodBeat.i(193579);
      Object localObject = h.ae(n.class);
      p.j(localObject, "service<IMessengerStorag…engerStorage::class.java)");
      localObject = ((n)localObject).bbL().RG(parama.ktQ);
      a.b.d((ImageView)paramView.findViewById(b.e.live_anchor_mic_user_icon), parama.ktQ, 0.1F);
      paramView = paramView.findViewById(b.e.live_anchor_mic_user_name);
      p.j(paramView, "itemView.findViewById<Te…ive_anchor_mic_user_name)");
      paramView = (TextView)paramView;
      p.j(localObject, "contact");
      paramView.setText((CharSequence)((as)localObject).getNickname());
      AppMethodBeat.o(193579);
    }
    
    public final RecyclerView.v b(final ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(193570);
      p.k(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        paramViewGroup = (RecyclerView.v)new j(this, paramViewGroup, LayoutInflater.from(this.kJE.getContext()).inflate(b.f.live_anchor_mic_list_title, paramViewGroup, false));
        AppMethodBeat.o(193570);
        return paramViewGroup;
      case 0: 
        paramViewGroup = (RecyclerView.v)new d(this, paramViewGroup, LayoutInflater.from(this.kJE.getContext()).inflate(b.f.live_anchor_mic_list_permission, paramViewGroup, false));
        AppMethodBeat.o(193570);
        return paramViewGroup;
      case 1: 
        paramViewGroup = (RecyclerView.v)new e(this, paramViewGroup, LayoutInflater.from(this.kJE.getContext()).inflate(b.f.live_anchor_mic_list_title, paramViewGroup, false));
        AppMethodBeat.o(193570);
        return paramViewGroup;
      case 2: 
        paramViewGroup = (RecyclerView.v)new f(this, paramViewGroup, LayoutInflater.from(this.kJE.getContext()).inflate(b.f.live_anchor_mic_list_accept, paramViewGroup, false));
        AppMethodBeat.o(193570);
        return paramViewGroup;
      case 3: 
        paramViewGroup = (RecyclerView.v)new g(this, paramViewGroup, LayoutInflater.from(this.kJE.getContext()).inflate(b.f.live_anchor_mic_list_calling, paramViewGroup, false));
        AppMethodBeat.o(193570);
        return paramViewGroup;
      case 4: 
        paramViewGroup = (RecyclerView.v)new h(this, paramViewGroup, LayoutInflater.from(this.kJE.getContext()).inflate(b.f.live_anchor_mic_list_no_data, paramViewGroup, false));
        AppMethodBeat.o(193570);
        return paramViewGroup;
      }
      paramViewGroup = (RecyclerView.v)new i(this, paramViewGroup, LayoutInflater.from(this.kJE.getContext()).inflate(b.f.live_anchor_mic_list_no_permission, paramViewGroup, false));
      AppMethodBeat.o(193570);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(193574);
      p.k(paramv, "holder");
      switch (getItemViewType(paramInt))
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          paramv = paramv.amk;
          p.j(paramv, "holder.itemView");
          if (!LiveAnchorMicUserListView.e(this.kJE)) {
            break;
          }
          paramv.setAlpha(1.0F);
          paramv.setEnabled(true);
          AppMethodBeat.o(193574);
          return;
          localObject1 = (MMSwitchBtn)paramv.amk.findViewById(b.e.live_anchor_permission_switch);
          ((TextView)paramv.amk.findViewById(b.e.live_anchor_permission_switch_mask)).setOnClickListener((View.OnClickListener)new a(this));
          p.j(localObject1, "switchView");
          ((MMSwitchBtn)localObject1).setCheck(this.kJE.getMicPermission());
          continue;
          localObject1 = paramv.amk;
          if (localObject1 == null)
          {
            paramv = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(193574);
            throw paramv;
          }
          ((TextView)localObject1).setText((CharSequence)((LiveAnchorMicUserListView.c)this.kJF.get(paramInt)).title);
          continue;
          localObject1 = ((LiveAnchorMicUserListView.c)this.kJF.get(paramInt)).kJI;
          if (localObject1 != null)
          {
            localObject2 = paramv.amk;
            p.j(localObject2, "holder.itemView");
            a((View)localObject2, (a.a)localObject1);
          }
          ((TextView)paramv.amk.findViewById(b.e.live_mic_accept_txt)).setOnClickListener((View.OnClickListener)new b(this, paramInt));
        }
      }
      Object localObject1 = ((LiveAnchorMicUserListView.c)this.kJF.get(paramInt)).kJI;
      if (localObject1 != null)
      {
        localObject2 = paramv.amk;
        p.j(localObject2, "holder.itemView");
        a((View)localObject2, (a.a)localObject1);
      }
      Object localObject2 = (ImageView)paramv.amk.findViewById(b.e.live_mic_waiting_loading);
      Object localObject3 = (ImageView)paramv.amk.findViewById(b.e.live_mic_waiting_mask_view);
      localObject1 = (TextView)paramv.amk.findViewById(b.e.live_mic_stop_txt);
      if (LiveAnchorMicUserListView.f(this.kJE))
      {
        p.j(localObject3, "maskView");
        ((ImageView)localObject3).setVisibility(0);
        p.j(localObject2, "loadingView");
        ((ImageView)localObject2).setVisibility(0);
        localObject3 = ((ImageView)localObject2).getBackground();
        if (localObject3 == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(193574);
          throw paramv;
        }
        ((AnimationDrawable)localObject3).stop();
        localObject2 = ((ImageView)localObject2).getBackground();
        if (localObject2 == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(193574);
          throw paramv;
        }
        ((AnimationDrawable)localObject2).start();
        p.j(localObject1, "btn");
        localObject2 = this.kJE.getContext();
        p.j(localObject2, "context");
        ((TextView)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(b.d.live_gray_rect_btn_bg));
        localObject2 = this.kJE.getContext();
        p.j(localObject2, "context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(b.h.live_room_mic_cancel));
      }
      for (;;)
      {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new c(this, paramInt));
        break;
        p.j(localObject3, "maskView");
        ((ImageView)localObject3).setVisibility(4);
        p.j(localObject2, "loadingView");
        ((ImageView)localObject2).setVisibility(4);
        localObject2 = ((ImageView)localObject2).getBackground();
        if (localObject2 == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(193574);
          throw paramv;
        }
        ((AnimationDrawable)localObject2).stop();
        p.j(localObject1, "btn");
        localObject2 = this.kJE.getContext();
        p.j(localObject2, "context");
        ((TextView)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(b.d.live_pink_rect_btn_bg));
        localObject2 = this.kJE.getContext();
        p.j(localObject2, "context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(b.h.live_room_mic_finish));
      }
      if (paramInt >= 3)
      {
        paramv.setAlpha(0.3F);
        paramv.setEnabled(false);
      }
      AppMethodBeat.o(193574);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(193571);
      int i = this.kJF.size();
      AppMethodBeat.o(193571);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(193577);
      paramInt = ((LiveAnchorMicUserListView.c)this.kJF.get(paramInt)).type;
      AppMethodBeat.o(193577);
      return paramInt;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(LiveAnchorMicUserListView.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(202164);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.kJG.kJE.getMicPermission())
        {
          LiveAnchorMicUserListView.b(this.kJG.kJE);
          paramView = LiveAnchorMicUserListView.c(this.kJG.kJE);
          if (paramView != null) {
            paramView.eik();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(202164);
          return;
          LiveAnchorMicUserListView.a(this.kJG.kJE, true);
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(200221);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (LiveAnchorMicUserListView.e(this.kJG.kJE))
        {
          LiveAnchorMicUserListView.g(this.kJG.kJE);
          LiveAnchorMicUserListView.h(this.kJG.kJE).invoke(((LiveAnchorMicUserListView.c)this.kJG.kJF.get(paramInt)).kJI);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(200221);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(199603);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        LiveAnchorMicUserListView.i(this.kJG.kJE).invoke(((LiveAnchorMicUserListView.c)this.kJG.kJF.get(paramInt)).kJI);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(199603);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class d
      extends RecyclerView.v
    {
      d(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$2", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class e
      extends RecyclerView.v
    {
      e(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$3", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class f
      extends RecyclerView.v
    {
      f(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$4", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class g
      extends RecyclerView.v
    {
      g(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$5", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class h
      extends RecyclerView.v
    {
      h(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$6", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class i
      extends RecyclerView.v
    {
      i(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$7", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class j
      extends RecyclerView.v
    {
      j(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "", "type", "", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "title", "", "(ILcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getUser", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "setUser", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
  public static final class c
  {
    a.a kJI;
    String title;
    int type;
    
    private c(int paramInt, a.a parama, String paramString)
    {
      this.type = paramInt;
      this.kJI = parama;
      this.title = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196336);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.type != paramObject.type) || (!p.h(this.kJI, paramObject.kJI)) || (!p.h(this.title, paramObject.title))) {}
        }
      }
      else
      {
        AppMethodBeat.o(196336);
        return true;
      }
      AppMethodBeat.o(196336);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(196332);
      int k = this.type;
      Object localObject = this.kJI;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.title;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(196332);
        return (i + k * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(196328);
      String str = "LiveMicListItem(type=" + this.type + ", user=" + this.kJI + ", title=" + this.title + ")";
      AppMethodBeat.o(196328);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<a.a, x>
  {
    d(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements i
  {
    e(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, a.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(188751);
      paramq.setHasCallbackToQueue(true);
      paramq = com.tencent.mm.live.core.debug.a.kqB;
      com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", "[cgi]accept mic errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        LiveAnchorMicUserListView.j(this.kJE).i(b.g.playend, true, 1);
        paramString = u.kwz;
        u.aPa().a(this.kyt);
        AppMethodBeat.o(188751);
        return;
      }
      w.makeText(this.kJE.getContext(), (CharSequence)com.tencent.mm.ci.a.ba(this.kJE.getContext(), b.h.live_room_mic_apply_error), 0).show();
      LiveAnchorMicUserListView.b(this.kJE, true);
      paramString = this.kJE.getCallMicListener();
      if (paramString != null) {
        paramString.invoke(Boolean.FALSE, null);
      }
      this.kJE.aRd();
      AppMethodBeat.o(188751);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$anchorCloseMic$1$1"})
  static final class f
    implements i
  {
    f(a.a parama, LiveAnchorMicUserListView paramLiveAnchorMicUserListView, m paramm) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(193546);
      paramq.setHasCallbackToQueue(true);
      paramq = com.tencent.mm.live.core.debug.a.kqB;
      com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", "[cgi-ret]anchor close mic :" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        jdField_this.aRa();
      }
      if (paramm == null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = jdField_this.getContext();
          paramq = jdField_this.getContext();
          p.j(paramq, "context");
          w.makeText(paramString, (CharSequence)paramq.getResources().getString(b.h.live_room_mic_user_hand_up), 0).show();
          paramString = u.kwz;
          u.aPa().kyn.remove(this.kJJ);
          jdField_this.aRb();
          paramString = u.kwz;
          u.aPa().aPk();
          jdField_this.aRd();
          paramString = jdField_this.getCallMicListener();
          if (paramString != null)
          {
            paramString.invoke(Boolean.FALSE, null);
            AppMethodBeat.o(193546);
            return;
          }
          AppMethodBeat.o(193546);
        }
      }
      else {
        paramm.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      AppMethodBeat.o(193546);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements q.f
  {
    g(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramo)
    {
      AppMethodBeat.i(201354);
      Object localObject = LiveAnchorMicUserListView.c(this.kJE);
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paramo.clear();
      localObject = this.kJE.getContext();
      p.j(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(b.b.live_title_host_close_btn_color);
      localObject = this.kJE.getContext();
      p.j(localObject, "context");
      paramo.a(1, i, (CharSequence)((Context)localObject).getResources().getString(b.h.live_room_mic_close_permission_item));
      AppMethodBeat.o(201354);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
  static final class h
    implements q.g
  {
    h(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(199222);
      p.k(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      default: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.kJE);
        if (paramMenuItem != null)
        {
          paramMenuItem.bYF();
          AppMethodBeat.o(199222);
          return;
        }
        break;
      case 0: 
        AppMethodBeat.o(199222);
        return;
      case 1: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.kJE);
        if (paramMenuItem != null) {
          paramMenuItem.bYF();
        }
        LiveAnchorMicUserListView.a(this.kJE, false);
        AppMethodBeat.o(199222);
        return;
      }
      AppMethodBeat.o(199222);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class i
    implements e.b
  {
    i(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(199679);
      LiveAnchorMicUserListView.d(this.kJE);
      AppMethodBeat.o(199679);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<a.a, x>
  {
    j(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class k
    implements i
  {
    k(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(197182);
      paramq.setHasCallbackToQueue(true);
      paramq = com.tencent.mm.live.core.debug.a.kqB;
      com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.kJE.setMicPermission(true);
        this.kJE.aRd();
      }
      for (;;)
      {
        paramString = this.kJE.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.invoke(Boolean.valueOf(this.kJE.getMicPermission()));
        AppMethodBeat.o(197182);
        return;
        this.kJE.setMicPermission(false);
      }
      AppMethodBeat.o(197182);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements m<Integer, Integer, x>
  {
    l(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class m
    implements i
  {
    m(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(197812);
      paramq.setHasCallbackToQueue(true);
      paramq = com.tencent.mm.live.core.debug.a.kqB;
      com.tencent.mm.live.core.debug.a.ay("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.kJE.setMicPermission(false);
        paramString = u.kwz;
        u.aPa().kyn.clear();
        this.kJE.aRd();
      }
      for (;;)
      {
        paramString = this.kJE.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.invoke(Boolean.valueOf(this.kJE.getMicPermission()));
        AppMethodBeat.o(197812);
        return;
        this.kJE.setMicPermission(true);
      }
      AppMethodBeat.o(197812);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView
 * JD-Core Version:    0.7.0.1
 */