package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.live.b.a.k;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.a.m;
import d.g.b.ad;
import d.g.b.ae;
import d.g.b.p;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "acceptLiveMicListener", "Lkotlin/Function1;", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "Lkotlin/ParameterName;", "name", "user", "", "adapter", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "callMicListener", "Lkotlin/Function2;", "", "calling", "getCallMicListener", "()Lkotlin/jvm/functions/Function2;", "setCallMicListener", "(Lkotlin/jvm/functions/Function2;)V", "canSelectUser", "hideClickListener", "Lkotlin/Function0;", "getHideClickListener", "()Lkotlin/jvm/functions/Function0;", "setHideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "micPermission", "getMicPermission", "()Z", "setMicPermission", "(Z)V", "micPermissionListener", "enable", "getMicPermissionListener", "()Lkotlin/jvm/functions/Function1;", "setMicPermissionListener", "(Lkotlin/jvm/functions/Function1;)V", "parent", "Landroid/view/View;", "getParent", "()Landroid/view/View;", "setParent", "(Landroid/view/View;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "selectUser", "stopLiveMicListener", "userListView", "Landroid/support/v7/widget/RecyclerView;", "waitingMic", "acceptMic", "anchorCloseMic", "callback", "errType", "errCode", "buildBottomSheet", "buildMicCallingItemData", "buildMicWaitingItemData", "users", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "buildNoPermissionItemData", "buildNoUserItemData", "buildPermissionItemData", "clearData", "getSelectUser", "loadOnlineMembers", "playMicHungUpVoice", "refreshListView", "refreshParentsView", "resetMicUser", "sdkStartMic", "setDefaultMicState", "setMicUser", "micUser", "updateMicPermission", "Companion", "LiveAnchorMicUserAdapter", "LiveMicListItem", "plugin-logic_release"})
public final class LiveAnchorMicUserListView
  extends RelativeLayout
{
  public static final LiveAnchorMicUserListView.a gZx;
  private e gSS;
  private final com.tencent.mm.plugin.voip.video.i gXE;
  private boolean gZl;
  private d.g.a.a<z> gZm;
  private m<? super Boolean, ? super a.a, z> gZn;
  private d.g.a.b<? super Boolean, z> gZo;
  private final RecyclerView gZp;
  public final b gZq;
  private a.a gZr;
  private boolean gZs;
  public boolean gZt;
  private d.g.a.b<? super a.a, z> gZu;
  private d.g.a.b<? super a.a, z> gZv;
  private View gZw;
  
  static
  {
    AppMethodBeat.i(212878);
    gZx = new LiveAnchorMicUserListView.a((byte)0);
    AppMethodBeat.o(212878);
  }
  
  public LiveAnchorMicUserListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(212877);
    this.gXE = new com.tencent.mm.plugin.voip.video.i(aj.getContext());
    this.gZl = true;
    this.gZq = new b();
    this.gZs = true;
    this.gZu = ((d.g.a.b)new d(this));
    this.gZv = ((d.g.a.b)new j(this));
    paramContext = LayoutInflater.from(paramContext).inflate(2131496296, (ViewGroup)this, true);
    p.g(paramContext, "LayoutInflater.from(cont…ic_list_view, this, true)");
    this.gZw = paramContext;
    this.gZw.findViewById(2131298372).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212840);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = this.gZy.getHideClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212840);
      }
    });
    paramContext = this.gZw.findViewById(2131307558);
    p.g(paramContext, "parent.findViewById(R.id.live_anchor_mic_list)");
    this.gZp = ((RecyclerView)paramContext);
    this.gZp.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.gZp.setAdapter((RecyclerView.a)this.gZq);
    this.gZp.setItemViewCacheSize(0);
    AppMethodBeat.o(212877);
  }
  
  private void a(final m<? super Integer, ? super Integer, z> paramm)
  {
    AppMethodBeat.i(212866);
    a.a locala = this.gZr;
    if (locala != null)
    {
      Object localObject = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "[cgi]anchor close mic.".concat(String.valueOf(locala)));
      localObject = com.tencent.mm.live.b.g.gOr;
      long l = com.tencent.mm.live.b.g.ans().Fsa;
      localObject = com.tencent.mm.live.b.g.gOr;
      localObject = new k(l, com.tencent.mm.live.b.g.anm(), String.valueOf(System.currentTimeMillis()), locala.gQS, locala.gQU);
      com.tencent.mm.al.q localq = com.tencent.mm.kernel.g.aiU();
      p.g(localq, "MMKernel.getNetSceneQueue()");
      ((k)localObject).doScene(localq.aiY(), (f)new f(locala, this, paramm));
      AppMethodBeat.o(212866);
      return;
    }
    AppMethodBeat.o(212866);
  }
  
  private void aqr()
  {
    AppMethodBeat.i(212868);
    int i = com.tencent.mm.cc.a.ip(getContext());
    int j = com.tencent.mm.cc.a.iq(getContext());
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, -1);
      localLayoutParams.gravity = 1;
      Context localContext1 = getContext();
      Context localContext2 = getContext();
      p.g(localContext2, "context");
      localLayoutParams.topMargin = com.tencent.mm.cc.a.g(localContext1, localContext2.getResources().getDimension(2131167038));
      this.gZw.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(212868);
      return;
    }
  }
  
  public static void aqt()
  {
    AppMethodBeat.i(212870);
    Object localObject1 = com.tencent.mm.live.b.g.gOr;
    Object localObject2 = com.tencent.mm.live.b.g.aod().gQO;
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((a.a)((Iterator)localObject2).next()).gQT);
    }
    localObject2 = com.tencent.mm.live.b.i.gPh;
    com.tencent.mm.live.b.i.Y((List)localObject1);
    AppMethodBeat.o(212870);
  }
  
  private final void aqu()
  {
    AppMethodBeat.i(212872);
    this.gZq.gZz.add(new LiveAnchorMicUserListView.c(0, null, null, 6));
    AppMethodBeat.o(212872);
  }
  
  private final void aqv()
  {
    AppMethodBeat.i(212873);
    a.a locala = this.gZr;
    if (locala != null)
    {
      this.gZq.gZz.add(new LiveAnchorMicUserListView.c(1, null, com.tencent.mm.cc.a.az(getContext(), 2131766681), 2));
      this.gZq.gZz.add(new LiveAnchorMicUserListView.c(3, locala, null, 4));
      AppMethodBeat.o(212873);
      return;
    }
    AppMethodBeat.o(212873);
  }
  
  private final void aqw()
  {
    AppMethodBeat.i(212875);
    this.gZq.gZz.add(new LiveAnchorMicUserListView.c(4, null, null, 6));
    AppMethodBeat.o(212875);
  }
  
  private final void aqx()
  {
    AppMethodBeat.i(212876);
    this.gZq.gZz.add(new LiveAnchorMicUserListView.c(5, null, null, 6));
    AppMethodBeat.o(212876);
  }
  
  private final void clearData()
  {
    AppMethodBeat.i(212871);
    this.gZq.gZz.clear();
    AppMethodBeat.o(212871);
  }
  
  private final void j(ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(212874);
    Object localObject1 = this.gZq.gZz;
    Object localObject2 = ad.MLZ;
    localObject2 = com.tencent.mm.cc.a.az(getContext(), 2131766716);
    p.g(localObject2, "ResourceHelper.getString…ive_room_wait_mic_number)");
    Object localObject3 = com.tencent.mm.live.b.g.gOr;
    localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.live.b.g.aod().gQO.size()) }, 1));
    p.g(localObject2, "java.lang.String.format(format, *args)");
    ((ArrayList)localObject1).add(new LiveAnchorMicUserListView.c(1, null, (String)localObject2, 2));
    localObject1 = ((Iterable)paramArrayList).iterator();
    label180:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      localObject3 = ((a.a)localObject2).gQT;
      paramArrayList = this.gZr;
      if (paramArrayList != null) {}
      for (paramArrayList = paramArrayList.gQT;; paramArrayList = null)
      {
        if (!(p.i(localObject3, paramArrayList) ^ true)) {
          break label180;
        }
        this.gZq.gZz.add(new LiveAnchorMicUserListView.c(2, (a.a)localObject2, null, 4));
        break;
      }
    }
    AppMethodBeat.o(212874);
  }
  
  public final void aqp()
  {
    AppMethodBeat.i(212865);
    this.gXE.U(true, 1);
    AppMethodBeat.o(212865);
  }
  
  public final void aqq()
  {
    this.gZs = true;
    this.gZr = null;
  }
  
  public final void aqs()
  {
    AppMethodBeat.i(212869);
    aqr();
    clearData();
    aqu();
    if (this.gZr != null) {
      aqv();
    }
    if (this.gZl)
    {
      Object localObject = com.tencent.mm.live.b.g.gOr;
      localObject = com.tencent.mm.live.b.g.aod().gQO;
      Collection localCollection = (Collection)localObject;
      a.a locala = this.gZr;
      if (localCollection == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(212869);
        throw ((Throwable)localObject);
      }
      ae.eR(localCollection).remove(locala);
      if (((ArrayList)localObject).size() > 0) {
        j((ArrayList)localObject);
      }
    }
    for (;;)
    {
      this.gZq.notifyDataSetChanged();
      AppMethodBeat.o(212869);
      return;
      if (this.gZr == null)
      {
        aqw();
        continue;
        aqx();
      }
    }
  }
  
  public final m<Boolean, a.a, z> getCallMicListener()
  {
    return this.gZn;
  }
  
  public final d.g.a.a<z> getHideClickListener()
  {
    return this.gZm;
  }
  
  public final boolean getMicPermission()
  {
    return this.gZl;
  }
  
  public final d.g.a.b<Boolean, z> getMicPermissionListener()
  {
    return this.gZo;
  }
  
  public final View getParent()
  {
    return this.gZw;
  }
  
  public final a.a getSelectUser()
  {
    return this.gZr;
  }
  
  public final void setCallMicListener(m<? super Boolean, ? super a.a, z> paramm)
  {
    this.gZn = paramm;
  }
  
  public final void setDefaultMicState(boolean paramBoolean)
  {
    this.gZl = paramBoolean;
  }
  
  public final void setHideClickListener(d.g.a.a<z> parama)
  {
    this.gZm = parama;
  }
  
  public final void setMicPermission(boolean paramBoolean)
  {
    this.gZl = paramBoolean;
  }
  
  public final void setMicPermissionListener(d.g.a.b<? super Boolean, z> paramb)
  {
    this.gZo = paramb;
  }
  
  public final void setMicUser(a.a parama)
  {
    this.gZr = parama;
  }
  
  public final void setParent(View paramView)
  {
    AppMethodBeat.i(212864);
    p.h(paramView, "<set-?>");
    this.gZw = paramView;
    AppMethodBeat.o(212864);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;)V", "liveMicItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "Lkotlin/collections/ArrayList;", "getLiveMicItems", "()Ljava/util/ArrayList;", "setLiveMicItems", "(Ljava/util/ArrayList;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "", "uid", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "loadUserInfo", "itemView", "Landroid/view/View;", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-logic_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.w>
  {
    ArrayList<LiveAnchorMicUserListView.c> gZz;
    
    public b()
    {
      AppMethodBeat.i(212849);
      this.gZz = new ArrayList();
      AppMethodBeat.o(212849);
    }
    
    private static void a(View paramView, a.a parama)
    {
      AppMethodBeat.i(212848);
      Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "service<IMessengerStorag…engerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().Bf(parama.gQT);
      a.b.d((ImageView)paramView.findViewById(2131307568), parama.gQT, 0.1F);
      paramView = paramView.findViewById(2131307572);
      p.g(paramView, "itemView.findViewById<Te…ive_anchor_mic_user_name)");
      paramView = (TextView)paramView;
      p.g(localObject, "contact");
      paramView.setText((CharSequence)((am)localObject).VC());
      AppMethodBeat.o(212848);
    }
    
    public final RecyclerView.w a(final ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(212844);
      p.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        paramViewGroup = (RecyclerView.w)new j(this, paramViewGroup, LayoutInflater.from(this.gZy.getContext()).inflate(2131496295, paramViewGroup, false));
        AppMethodBeat.o(212844);
        return paramViewGroup;
      case 0: 
        paramViewGroup = (RecyclerView.w)new d(this, paramViewGroup, LayoutInflater.from(this.gZy.getContext()).inflate(2131496294, paramViewGroup, false));
        AppMethodBeat.o(212844);
        return paramViewGroup;
      case 1: 
        paramViewGroup = (RecyclerView.w)new e(this, paramViewGroup, LayoutInflater.from(this.gZy.getContext()).inflate(2131496295, paramViewGroup, false));
        AppMethodBeat.o(212844);
        return paramViewGroup;
      case 2: 
        paramViewGroup = (RecyclerView.w)new f(this, paramViewGroup, LayoutInflater.from(this.gZy.getContext()).inflate(2131496290, paramViewGroup, false));
        AppMethodBeat.o(212844);
        return paramViewGroup;
      case 3: 
        paramViewGroup = (RecyclerView.w)new g(this, paramViewGroup, LayoutInflater.from(this.gZy.getContext()).inflate(2131496291, paramViewGroup, false));
        AppMethodBeat.o(212844);
        return paramViewGroup;
      case 4: 
        paramViewGroup = (RecyclerView.w)new h(this, paramViewGroup, LayoutInflater.from(this.gZy.getContext()).inflate(2131496292, paramViewGroup, false));
        AppMethodBeat.o(212844);
        return paramViewGroup;
      }
      paramViewGroup = (RecyclerView.w)new i(this, paramViewGroup, LayoutInflater.from(this.gZy.getContext()).inflate(2131496293, paramViewGroup, false));
      AppMethodBeat.o(212844);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(212846);
      p.h(paramw, "holder");
      switch (getItemViewType(paramInt))
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          paramw = paramw.auu;
          p.g(paramw, "holder.itemView");
          if (!LiveAnchorMicUserListView.e(this.gZy)) {
            break;
          }
          paramw.setAlpha(1.0F);
          paramw.setEnabled(true);
          AppMethodBeat.o(212846);
          return;
          localObject1 = (MMSwitchBtn)paramw.auu.findViewById(2131307576);
          ((TextView)paramw.auu.findViewById(2131307577)).setOnClickListener((View.OnClickListener)new a(this));
          p.g(localObject1, "switchView");
          ((MMSwitchBtn)localObject1).setCheck(this.gZy.getMicPermission());
          continue;
          localObject1 = paramw.auu;
          if (localObject1 == null)
          {
            paramw = new v("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(212846);
            throw paramw;
          }
          ((TextView)localObject1).setText((CharSequence)((LiveAnchorMicUserListView.c)this.gZz.get(paramInt)).title);
          continue;
          localObject1 = ((LiveAnchorMicUserListView.c)this.gZz.get(paramInt)).gZC;
          if (localObject1 != null)
          {
            localObject2 = paramw.auu;
            p.g(localObject2, "holder.itemView");
            a((View)localObject2, (a.a)localObject1);
          }
          ((TextView)paramw.auu.findViewById(2131307692)).setOnClickListener((View.OnClickListener)new b(this, paramInt));
        }
      }
      Object localObject1 = ((LiveAnchorMicUserListView.c)this.gZz.get(paramInt)).gZC;
      if (localObject1 != null)
      {
        localObject2 = paramw.auu;
        p.g(localObject2, "holder.itemView");
        a((View)localObject2, (a.a)localObject1);
      }
      Object localObject2 = (ImageView)paramw.auu.findViewById(2131307713);
      Object localObject3 = (ImageView)paramw.auu.findViewById(2131307714);
      localObject1 = (TextView)paramw.auu.findViewById(2131307706);
      if (LiveAnchorMicUserListView.f(this.gZy))
      {
        p.g(localObject3, "maskView");
        ((ImageView)localObject3).setVisibility(0);
        p.g(localObject2, "loadingView");
        ((ImageView)localObject2).setVisibility(0);
        localObject3 = ((ImageView)localObject2).getBackground();
        if (localObject3 == null)
        {
          paramw = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(212846);
          throw paramw;
        }
        ((AnimationDrawable)localObject3).stop();
        localObject2 = ((ImageView)localObject2).getBackground();
        if (localObject2 == null)
        {
          paramw = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(212846);
          throw paramw;
        }
        ((AnimationDrawable)localObject2).start();
        p.g(localObject1, "btn");
        localObject2 = this.gZy.getContext();
        p.g(localObject2, "context");
        ((TextView)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131234913));
        localObject2 = this.gZy.getContext();
        p.g(localObject2, "context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131766682));
      }
      for (;;)
      {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new c(this, paramInt));
        break;
        p.g(localObject3, "maskView");
        ((ImageView)localObject3).setVisibility(4);
        p.g(localObject2, "loadingView");
        ((ImageView)localObject2).setVisibility(4);
        localObject2 = ((ImageView)localObject2).getBackground();
        if (localObject2 == null)
        {
          paramw = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(212846);
          throw paramw;
        }
        ((AnimationDrawable)localObject2).stop();
        p.g(localObject1, "btn");
        localObject2 = this.gZy.getContext();
        p.g(localObject2, "context");
        ((TextView)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131234934));
        localObject2 = this.gZy.getContext();
        p.g(localObject2, "context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131766690));
      }
      if (paramInt >= 3)
      {
        paramw.setAlpha(0.3F);
        paramw.setEnabled(false);
      }
      AppMethodBeat.o(212846);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(212845);
      int i = this.gZz.size();
      AppMethodBeat.o(212845);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(212847);
      paramInt = ((LiveAnchorMicUserListView.c)this.gZz.get(paramInt)).type;
      AppMethodBeat.o(212847);
      return paramInt;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(LiveAnchorMicUserListView.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(212841);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (this.gZA.gZy.getMicPermission())
        {
          LiveAnchorMicUserListView.b(this.gZA.gZy);
          paramView = LiveAnchorMicUserListView.c(this.gZA.gZy);
          if (paramView != null) {
            paramView.cMW();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(212841);
          return;
          LiveAnchorMicUserListView.a(this.gZA.gZy, true);
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(212842);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (LiveAnchorMicUserListView.e(this.gZA.gZy))
        {
          LiveAnchorMicUserListView.g(this.gZA.gZy);
          LiveAnchorMicUserListView.h(this.gZA.gZy).invoke(((LiveAnchorMicUserListView.c)this.gZA.gZz.get(paramInt)).gZC);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212842);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(212843);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        LiveAnchorMicUserListView.i(this.gZA.gZy).invoke(((LiveAnchorMicUserListView.c)this.gZA.gZz.get(paramInt)).gZC);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212843);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class d
      extends RecyclerView.w
    {
      d(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$2", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class e
      extends RecyclerView.w
    {
      e(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$3", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class f
      extends RecyclerView.w
    {
      f(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$4", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class g
      extends RecyclerView.w
    {
      g(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$5", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class h
      extends RecyclerView.w
    {
      h(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$6", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class i
      extends RecyclerView.w
    {
      i(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$7", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class j
      extends RecyclerView.w
    {
      j(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<a.a, z>
  {
    d(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements f
  {
    e(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, a.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(212855);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "[cgi]accept mic errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        LiveAnchorMicUserListView.j(this.gZy).U(true, 1);
        paramString = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.g.aod().a(this.gQX);
        AppMethodBeat.o(212855);
        return;
      }
      t.makeText(this.gZy.getContext(), (CharSequence)com.tencent.mm.cc.a.az(this.gZy.getContext(), 2131766680), 0).show();
      LiveAnchorMicUserListView.b(this.gZy, true);
      paramString = this.gZy.getCallMicListener();
      if (paramString != null) {
        paramString.p(Boolean.FALSE, null);
      }
      this.gZy.aqs();
      AppMethodBeat.o(212855);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$anchorCloseMic$1$1"})
  static final class f
    implements f
  {
    f(a.a parama, LiveAnchorMicUserListView paramLiveAnchorMicUserListView, m paramm) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(212856);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "[cgi-ret]anchor close mic :" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        jdField_this.aqp();
      }
      if (paramm == null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = jdField_this.getContext();
          paramn = jdField_this.getContext();
          p.g(paramn, "context");
          t.makeText(paramString, (CharSequence)paramn.getResources().getString(2131766703), 0).show();
          paramString = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.b.g.aod().gQO.remove(this.gZD);
          jdField_this.aqq();
          paramString = com.tencent.mm.live.b.g.gOr;
          com.tencent.mm.live.b.g.aod().aou();
          jdField_this.aqs();
          paramString = jdField_this.getCallMicListener();
          if (paramString != null)
          {
            paramString.p(Boolean.FALSE, null);
            AppMethodBeat.o(212856);
            return;
          }
          AppMethodBeat.o(212856);
        }
      }
      else {
        paramm.p(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      AppMethodBeat.o(212856);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements n.d
  {
    g(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(212857);
      Object localObject = LiveAnchorMicUserListView.c(this.gZy);
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paraml.clear();
      localObject = this.gZy.getContext();
      p.g(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(2131101209);
      localObject = this.gZy.getContext();
      p.g(localObject, "context");
      paraml.a(1, i, (CharSequence)((Context)localObject).getResources().getString(2131766684));
      AppMethodBeat.o(212857);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
  static final class h
    implements n.e
  {
    h(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(212858);
      p.h(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      default: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.gZy);
        if (paramMenuItem != null)
        {
          paramMenuItem.bpT();
          AppMethodBeat.o(212858);
          return;
        }
        break;
      case 0: 
        AppMethodBeat.o(212858);
        return;
      case 1: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.gZy);
        if (paramMenuItem != null) {
          paramMenuItem.bpT();
        }
        LiveAnchorMicUserListView.a(this.gZy, false);
        AppMethodBeat.o(212858);
        return;
      }
      AppMethodBeat.o(212858);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss"})
  static final class i
    implements e.b
  {
    i(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(212859);
      LiveAnchorMicUserListView.d(this.gZy);
      AppMethodBeat.o(212859);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.b<a.a, z>
  {
    j(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class k
    implements f
  {
    k(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(212861);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.gZy.setMicPermission(true);
        this.gZy.aqs();
      }
      for (;;)
      {
        paramString = this.gZy.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.invoke(Boolean.valueOf(this.gZy.getMicPermission()));
        AppMethodBeat.o(212861);
        return;
        this.gZy.setMicPermission(false);
      }
      AppMethodBeat.o(212861);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "invoke"})
  static final class l
    extends d.g.b.q
    implements m<Integer, Integer, z>
  {
    l(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class m
    implements f
  {
    m(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(212863);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gKp;
      com.tencent.mm.live.core.debug.a.ar("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.gZy.setMicPermission(false);
        paramString = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.g.aod().gQO.clear();
        this.gZy.aqs();
      }
      for (;;)
      {
        paramString = this.gZy.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.invoke(Boolean.valueOf(this.gZy.getMicPermission()));
        AppMethodBeat.o(212863);
        return;
        this.gZy.setMicPermission(true);
      }
      AppMethodBeat.o(212863);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView
 * JD-Core Version:    0.7.0.1
 */