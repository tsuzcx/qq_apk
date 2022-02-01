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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.live.b.a.k;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "acceptLiveMicListener", "Lkotlin/Function1;", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "Lkotlin/ParameterName;", "name", "user", "", "adapter", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "callMicListener", "Lkotlin/Function2;", "", "calling", "getCallMicListener", "()Lkotlin/jvm/functions/Function2;", "setCallMicListener", "(Lkotlin/jvm/functions/Function2;)V", "canSelectUser", "hideClickListener", "Lkotlin/Function0;", "getHideClickListener", "()Lkotlin/jvm/functions/Function0;", "setHideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "micPermission", "getMicPermission", "()Z", "setMicPermission", "(Z)V", "micPermissionListener", "enable", "getMicPermissionListener", "()Lkotlin/jvm/functions/Function1;", "setMicPermissionListener", "(Lkotlin/jvm/functions/Function1;)V", "parent", "Landroid/view/View;", "getParent", "()Landroid/view/View;", "setParent", "(Landroid/view/View;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "selectUser", "stopLiveMicListener", "userListView", "Landroid/support/v7/widget/RecyclerView;", "waitingMic", "acceptMic", "anchorCloseMic", "callback", "errType", "errCode", "buildBottomSheet", "buildMicCallingItemData", "buildMicWaitingItemData", "users", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "buildNoPermissionItemData", "buildNoUserItemData", "buildPermissionItemData", "clearData", "getSelectUser", "loadOnlineMembers", "playMicHungUpVoice", "refreshListView", "refreshParentsView", "resetMicUser", "sdkStartMic", "setDefaultMicState", "setMicUser", "micUser", "updateMicPermission", "Companion", "LiveAnchorMicUserAdapter", "LiveMicListItem", "plugin-logic_release"})
public final class LiveAnchorMicUserListView
  extends RelativeLayout
{
  public static final LiveAnchorMicUserListView.a hck;
  private e gVB;
  private final com.tencent.mm.plugin.voip.video.i haq;
  private boolean hbY;
  private d.g.a.a<z> hbZ;
  private m<? super Boolean, ? super a.a, z> hca;
  private d.g.a.b<? super Boolean, z> hcb;
  private final RecyclerView hcc;
  public final b hcd;
  private a.a hce;
  private boolean hcf;
  public boolean hcg;
  private d.g.a.b<? super a.a, z> hch;
  private d.g.a.b<? super a.a, z> hci;
  private View hcj;
  
  static
  {
    AppMethodBeat.i(216506);
    hck = new LiveAnchorMicUserListView.a((byte)0);
    AppMethodBeat.o(216506);
  }
  
  public LiveAnchorMicUserListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216505);
    this.haq = new com.tencent.mm.plugin.voip.video.i(ak.getContext());
    this.hbY = true;
    this.hcd = new b();
    this.hcf = true;
    this.hch = ((d.g.a.b)new d(this));
    this.hci = ((d.g.a.b)new j(this));
    paramContext = LayoutInflater.from(paramContext).inflate(2131496296, (ViewGroup)this, true);
    p.g(paramContext, "LayoutInflater.from(cont…ic_list_view, this, true)");
    this.hcj = paramContext;
    this.hcj.findViewById(2131298372).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(216468);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = this.hcl.getHideClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216468);
      }
    });
    paramContext = this.hcj.findViewById(2131307558);
    p.g(paramContext, "parent.findViewById(R.id.live_anchor_mic_list)");
    this.hcc = ((RecyclerView)paramContext);
    this.hcc.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.hcc.setAdapter((RecyclerView.a)this.hcd);
    this.hcc.setItemViewCacheSize(0);
    AppMethodBeat.o(216505);
  }
  
  private void a(final m<? super Integer, ? super Integer, z> paramm)
  {
    AppMethodBeat.i(216494);
    a.a locala = this.hce;
    if (locala != null)
    {
      Object localObject = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "[cgi]anchor close mic.".concat(String.valueOf(locala)));
      localObject = com.tencent.mm.live.b.g.gQZ;
      long l = com.tencent.mm.live.b.g.anH().FKy;
      localObject = com.tencent.mm.live.b.g.gQZ;
      localObject = new k(l, com.tencent.mm.live.b.g.anC(), String.valueOf(System.currentTimeMillis()), locala.gTA, locala.gTC);
      com.tencent.mm.ak.q localq = com.tencent.mm.kernel.g.ajj();
      p.g(localq, "MMKernel.getNetSceneQueue()");
      ((k)localObject).doScene(localq.ajn(), (f)new f(locala, this, paramm));
      AppMethodBeat.o(216494);
      return;
    }
    AppMethodBeat.o(216494);
  }
  
  private void aqG()
  {
    AppMethodBeat.i(216496);
    int i = com.tencent.mm.cb.a.iu(getContext());
    int j = com.tencent.mm.cb.a.iv(getContext());
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
      localLayoutParams.topMargin = com.tencent.mm.cb.a.h(localContext1, localContext2.getResources().getDimension(2131167038));
      this.hcj.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(216496);
      return;
    }
  }
  
  public static void aqI()
  {
    AppMethodBeat.i(216498);
    Object localObject1 = com.tencent.mm.live.b.g.gQZ;
    Object localObject2 = com.tencent.mm.live.b.g.aos().gTw;
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((a.a)((Iterator)localObject2).next()).gTB);
    }
    localObject2 = com.tencent.mm.live.b.i.gRP;
    com.tencent.mm.live.b.i.Y((List)localObject1);
    AppMethodBeat.o(216498);
  }
  
  private final void aqJ()
  {
    AppMethodBeat.i(216500);
    this.hcd.hcm.add(new LiveAnchorMicUserListView.c(0, null, null, 6));
    AppMethodBeat.o(216500);
  }
  
  private final void aqK()
  {
    AppMethodBeat.i(216501);
    a.a locala = this.hce;
    if (locala != null)
    {
      this.hcd.hcm.add(new LiveAnchorMicUserListView.c(1, null, com.tencent.mm.cb.a.az(getContext(), 2131766681), 2));
      this.hcd.hcm.add(new LiveAnchorMicUserListView.c(3, locala, null, 4));
      AppMethodBeat.o(216501);
      return;
    }
    AppMethodBeat.o(216501);
  }
  
  private final void aqL()
  {
    AppMethodBeat.i(216503);
    this.hcd.hcm.add(new LiveAnchorMicUserListView.c(4, null, null, 6));
    AppMethodBeat.o(216503);
  }
  
  private final void aqM()
  {
    AppMethodBeat.i(216504);
    this.hcd.hcm.add(new LiveAnchorMicUserListView.c(5, null, null, 6));
    AppMethodBeat.o(216504);
  }
  
  private final void clearData()
  {
    AppMethodBeat.i(216499);
    this.hcd.hcm.clear();
    AppMethodBeat.o(216499);
  }
  
  private final void j(ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(216502);
    Object localObject1 = this.hcd.hcm;
    Object localObject2 = ad.Njc;
    localObject2 = com.tencent.mm.cb.a.az(getContext(), 2131766716);
    p.g(localObject2, "ResourceHelper.getString…ive_room_wait_mic_number)");
    Object localObject3 = com.tencent.mm.live.b.g.gQZ;
    localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.live.b.g.aos().gTw.size()) }, 1));
    p.g(localObject2, "java.lang.String.format(format, *args)");
    ((ArrayList)localObject1).add(new LiveAnchorMicUserListView.c(1, null, (String)localObject2, 2));
    localObject1 = ((Iterable)paramArrayList).iterator();
    label180:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      localObject3 = ((a.a)localObject2).gTB;
      paramArrayList = this.hce;
      if (paramArrayList != null) {}
      for (paramArrayList = paramArrayList.gTB;; paramArrayList = null)
      {
        if (!(p.i(localObject3, paramArrayList) ^ true)) {
          break label180;
        }
        this.hcd.hcm.add(new LiveAnchorMicUserListView.c(2, (a.a)localObject2, null, 4));
        break;
      }
    }
    AppMethodBeat.o(216502);
  }
  
  public final void aqE()
  {
    AppMethodBeat.i(216493);
    this.haq.X(true, 1);
    AppMethodBeat.o(216493);
  }
  
  public final void aqF()
  {
    this.hcf = true;
    this.hce = null;
  }
  
  public final void aqH()
  {
    AppMethodBeat.i(216497);
    aqG();
    clearData();
    aqJ();
    if (this.hce != null) {
      aqK();
    }
    if (this.hbY)
    {
      Object localObject = com.tencent.mm.live.b.g.gQZ;
      localObject = com.tencent.mm.live.b.g.aos().gTw;
      Collection localCollection = (Collection)localObject;
      a.a locala = this.hce;
      if (localCollection == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(216497);
        throw ((Throwable)localObject);
      }
      ae.eU(localCollection).remove(locala);
      if (((ArrayList)localObject).size() > 0) {
        j((ArrayList)localObject);
      }
    }
    for (;;)
    {
      this.hcd.notifyDataSetChanged();
      AppMethodBeat.o(216497);
      return;
      if (this.hce == null)
      {
        aqL();
        continue;
        aqM();
      }
    }
  }
  
  public final m<Boolean, a.a, z> getCallMicListener()
  {
    return this.hca;
  }
  
  public final d.g.a.a<z> getHideClickListener()
  {
    return this.hbZ;
  }
  
  public final boolean getMicPermission()
  {
    return this.hbY;
  }
  
  public final d.g.a.b<Boolean, z> getMicPermissionListener()
  {
    return this.hcb;
  }
  
  public final View getParent()
  {
    return this.hcj;
  }
  
  public final a.a getSelectUser()
  {
    return this.hce;
  }
  
  public final void setCallMicListener(m<? super Boolean, ? super a.a, z> paramm)
  {
    this.hca = paramm;
  }
  
  public final void setDefaultMicState(boolean paramBoolean)
  {
    this.hbY = paramBoolean;
  }
  
  public final void setHideClickListener(d.g.a.a<z> parama)
  {
    this.hbZ = parama;
  }
  
  public final void setMicPermission(boolean paramBoolean)
  {
    this.hbY = paramBoolean;
  }
  
  public final void setMicPermissionListener(d.g.a.b<? super Boolean, z> paramb)
  {
    this.hcb = paramb;
  }
  
  public final void setMicUser(a.a parama)
  {
    this.hce = parama;
  }
  
  public final void setParent(View paramView)
  {
    AppMethodBeat.i(216492);
    p.h(paramView, "<set-?>");
    this.hcj = paramView;
    AppMethodBeat.o(216492);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;)V", "liveMicItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "Lkotlin/collections/ArrayList;", "getLiveMicItems", "()Ljava/util/ArrayList;", "setLiveMicItems", "(Ljava/util/ArrayList;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "", "uid", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "loadUserInfo", "itemView", "Landroid/view/View;", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-logic_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.w>
  {
    ArrayList<LiveAnchorMicUserListView.c> hcm;
    
    public b()
    {
      AppMethodBeat.i(216477);
      this.hcm = new ArrayList();
      AppMethodBeat.o(216477);
    }
    
    private static void a(View paramView, a.a parama)
    {
      AppMethodBeat.i(216476);
      Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "service<IMessengerStorag…engerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azF().BH(parama.gTB);
      a.b.d((ImageView)paramView.findViewById(2131307568), parama.gTB, 0.1F);
      paramView = paramView.findViewById(2131307572);
      p.g(paramView, "itemView.findViewById<Te…ive_anchor_mic_user_name)");
      paramView = (TextView)paramView;
      p.g(localObject, "contact");
      paramView.setText((CharSequence)((an)localObject).VK());
      AppMethodBeat.o(216476);
    }
    
    public final RecyclerView.w a(final ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(216472);
      p.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        paramViewGroup = (RecyclerView.w)new j(this, paramViewGroup, LayoutInflater.from(this.hcl.getContext()).inflate(2131496295, paramViewGroup, false));
        AppMethodBeat.o(216472);
        return paramViewGroup;
      case 0: 
        paramViewGroup = (RecyclerView.w)new d(this, paramViewGroup, LayoutInflater.from(this.hcl.getContext()).inflate(2131496294, paramViewGroup, false));
        AppMethodBeat.o(216472);
        return paramViewGroup;
      case 1: 
        paramViewGroup = (RecyclerView.w)new e(this, paramViewGroup, LayoutInflater.from(this.hcl.getContext()).inflate(2131496295, paramViewGroup, false));
        AppMethodBeat.o(216472);
        return paramViewGroup;
      case 2: 
        paramViewGroup = (RecyclerView.w)new f(this, paramViewGroup, LayoutInflater.from(this.hcl.getContext()).inflate(2131496290, paramViewGroup, false));
        AppMethodBeat.o(216472);
        return paramViewGroup;
      case 3: 
        paramViewGroup = (RecyclerView.w)new g(this, paramViewGroup, LayoutInflater.from(this.hcl.getContext()).inflate(2131496291, paramViewGroup, false));
        AppMethodBeat.o(216472);
        return paramViewGroup;
      case 4: 
        paramViewGroup = (RecyclerView.w)new h(this, paramViewGroup, LayoutInflater.from(this.hcl.getContext()).inflate(2131496292, paramViewGroup, false));
        AppMethodBeat.o(216472);
        return paramViewGroup;
      }
      paramViewGroup = (RecyclerView.w)new i(this, paramViewGroup, LayoutInflater.from(this.hcl.getContext()).inflate(2131496293, paramViewGroup, false));
      AppMethodBeat.o(216472);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(216474);
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
          if (!LiveAnchorMicUserListView.e(this.hcl)) {
            break;
          }
          paramw.setAlpha(1.0F);
          paramw.setEnabled(true);
          AppMethodBeat.o(216474);
          return;
          localObject1 = (MMSwitchBtn)paramw.auu.findViewById(2131307576);
          ((TextView)paramw.auu.findViewById(2131307577)).setOnClickListener((View.OnClickListener)new a(this));
          p.g(localObject1, "switchView");
          ((MMSwitchBtn)localObject1).setCheck(this.hcl.getMicPermission());
          continue;
          localObject1 = paramw.auu;
          if (localObject1 == null)
          {
            paramw = new v("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(216474);
            throw paramw;
          }
          ((TextView)localObject1).setText((CharSequence)((LiveAnchorMicUserListView.c)this.hcm.get(paramInt)).title);
          continue;
          localObject1 = ((LiveAnchorMicUserListView.c)this.hcm.get(paramInt)).hcp;
          if (localObject1 != null)
          {
            localObject2 = paramw.auu;
            p.g(localObject2, "holder.itemView");
            a((View)localObject2, (a.a)localObject1);
          }
          ((TextView)paramw.auu.findViewById(2131307692)).setOnClickListener((View.OnClickListener)new b(this, paramInt));
        }
      }
      Object localObject1 = ((LiveAnchorMicUserListView.c)this.hcm.get(paramInt)).hcp;
      if (localObject1 != null)
      {
        localObject2 = paramw.auu;
        p.g(localObject2, "holder.itemView");
        a((View)localObject2, (a.a)localObject1);
      }
      Object localObject2 = (ImageView)paramw.auu.findViewById(2131307713);
      Object localObject3 = (ImageView)paramw.auu.findViewById(2131307714);
      localObject1 = (TextView)paramw.auu.findViewById(2131307706);
      if (LiveAnchorMicUserListView.f(this.hcl))
      {
        p.g(localObject3, "maskView");
        ((ImageView)localObject3).setVisibility(0);
        p.g(localObject2, "loadingView");
        ((ImageView)localObject2).setVisibility(0);
        localObject3 = ((ImageView)localObject2).getBackground();
        if (localObject3 == null)
        {
          paramw = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(216474);
          throw paramw;
        }
        ((AnimationDrawable)localObject3).stop();
        localObject2 = ((ImageView)localObject2).getBackground();
        if (localObject2 == null)
        {
          paramw = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(216474);
          throw paramw;
        }
        ((AnimationDrawable)localObject2).start();
        p.g(localObject1, "btn");
        localObject2 = this.hcl.getContext();
        p.g(localObject2, "context");
        ((TextView)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131234913));
        localObject2 = this.hcl.getContext();
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
          AppMethodBeat.o(216474);
          throw paramw;
        }
        ((AnimationDrawable)localObject2).stop();
        p.g(localObject1, "btn");
        localObject2 = this.hcl.getContext();
        p.g(localObject2, "context");
        ((TextView)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131234934));
        localObject2 = this.hcl.getContext();
        p.g(localObject2, "context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131766690));
      }
      if (paramInt >= 3)
      {
        paramw.setAlpha(0.3F);
        paramw.setEnabled(false);
      }
      AppMethodBeat.o(216474);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(216473);
      int i = this.hcm.size();
      AppMethodBeat.o(216473);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(216475);
      paramInt = ((LiveAnchorMicUserListView.c)this.hcm.get(paramInt)).type;
      AppMethodBeat.o(216475);
      return paramInt;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(LiveAnchorMicUserListView.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(216469);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (this.hcn.hcl.getMicPermission())
        {
          LiveAnchorMicUserListView.b(this.hcn.hcl);
          paramView = LiveAnchorMicUserListView.c(this.hcn.hcl);
          if (paramView != null) {
            paramView.cPF();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(216469);
          return;
          LiveAnchorMicUserListView.a(this.hcn.hcl, true);
        }
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(216470);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (LiveAnchorMicUserListView.e(this.hcn.hcl))
        {
          LiveAnchorMicUserListView.g(this.hcn.hcl);
          LiveAnchorMicUserListView.h(this.hcn.hcl).invoke(((LiveAnchorMicUserListView.c)this.hcn.hcm.get(paramInt)).hcp);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216470);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(216471);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        LiveAnchorMicUserListView.i(this.hcn.hcl).invoke(((LiveAnchorMicUserListView.c)this.hcn.hcm.get(paramInt)).hcp);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216471);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class d
      extends RecyclerView.w
    {
      d(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$2", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class e
      extends RecyclerView.w
    {
      e(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$3", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class f
      extends RecyclerView.w
    {
      f(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$4", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class g
      extends RecyclerView.w
    {
      g(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$5", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class h
      extends RecyclerView.w
    {
      h(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$6", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class i
      extends RecyclerView.w
    {
      i(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$7", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class j
      extends RecyclerView.w
    {
      j(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<a.a, z>
  {
    d(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements f
  {
    e(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, a.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(216483);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "[cgi]accept mic errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        LiveAnchorMicUserListView.j(this.hcl).X(true, 1);
        paramString = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.g.aos().a(this.gTF);
        AppMethodBeat.o(216483);
        return;
      }
      t.makeText(this.hcl.getContext(), (CharSequence)com.tencent.mm.cb.a.az(this.hcl.getContext(), 2131766680), 0).show();
      LiveAnchorMicUserListView.b(this.hcl, true);
      paramString = this.hcl.getCallMicListener();
      if (paramString != null) {
        paramString.p(Boolean.FALSE, null);
      }
      this.hcl.aqH();
      AppMethodBeat.o(216483);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$anchorCloseMic$1$1"})
  static final class f
    implements f
  {
    f(a.a parama, LiveAnchorMicUserListView paramLiveAnchorMicUserListView, m paramm) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(216484);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "[cgi-ret]anchor close mic :" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        jdField_this.aqE();
      }
      if (paramm == null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = jdField_this.getContext();
          paramn = jdField_this.getContext();
          p.g(paramn, "context");
          t.makeText(paramString, (CharSequence)paramn.getResources().getString(2131766703), 0).show();
          paramString = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.b.g.aos().gTw.remove(this.hcq);
          jdField_this.aqF();
          paramString = com.tencent.mm.live.b.g.gQZ;
          com.tencent.mm.live.b.g.aos().aoJ();
          jdField_this.aqH();
          paramString = jdField_this.getCallMicListener();
          if (paramString != null)
          {
            paramString.p(Boolean.FALSE, null);
            AppMethodBeat.o(216484);
            return;
          }
          AppMethodBeat.o(216484);
        }
      }
      else {
        paramm.p(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      AppMethodBeat.o(216484);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements n.d
  {
    g(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(216485);
      Object localObject = LiveAnchorMicUserListView.c(this.hcl);
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paraml.clear();
      localObject = this.hcl.getContext();
      p.g(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(2131101209);
      localObject = this.hcl.getContext();
      p.g(localObject, "context");
      paraml.a(1, i, (CharSequence)((Context)localObject).getResources().getString(2131766684));
      AppMethodBeat.o(216485);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
  static final class h
    implements n.e
  {
    h(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(216486);
      p.h(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      default: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.hcl);
        if (paramMenuItem != null)
        {
          paramMenuItem.bqD();
          AppMethodBeat.o(216486);
          return;
        }
        break;
      case 0: 
        AppMethodBeat.o(216486);
        return;
      case 1: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.hcl);
        if (paramMenuItem != null) {
          paramMenuItem.bqD();
        }
        LiveAnchorMicUserListView.a(this.hcl, false);
        AppMethodBeat.o(216486);
        return;
      }
      AppMethodBeat.o(216486);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onDismiss"})
  static final class i
    implements e.b
  {
    i(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(216487);
      LiveAnchorMicUserListView.d(this.hcl);
      AppMethodBeat.o(216487);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.b<a.a, z>
  {
    j(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class k
    implements f
  {
    k(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(216489);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.hcl.setMicPermission(true);
        this.hcl.aqH();
      }
      for (;;)
      {
        paramString = this.hcl.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.invoke(Boolean.valueOf(this.hcl.getMicPermission()));
        AppMethodBeat.o(216489);
        return;
        this.hcl.setMicPermission(false);
      }
      AppMethodBeat.o(216489);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "invoke"})
  static final class l
    extends d.g.b.q
    implements m<Integer, Integer, z>
  {
    l(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class m
    implements f
  {
    m(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(216491);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gMY;
      com.tencent.mm.live.core.debug.a.as("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.hcl.setMicPermission(false);
        paramString = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.g.aos().gTw.clear();
        this.hcl.aqH();
      }
      for (;;)
      {
        paramString = this.hcl.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.invoke(Boolean.valueOf(this.hcl.getMicPermission()));
        AppMethodBeat.o(216491);
        return;
        this.hcl.setMicPermission(true);
      }
      AppMethodBeat.o(216491);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView
 * JD-Core Version:    0.7.0.1
 */