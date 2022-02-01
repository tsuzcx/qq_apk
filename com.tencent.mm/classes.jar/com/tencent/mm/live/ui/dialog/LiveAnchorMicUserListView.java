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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import d.g.a.b;
import d.g.a.m;
import d.g.b.aa;
import d.g.b.z;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "acceptLiveMicListener", "Lkotlin/Function1;", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "Lkotlin/ParameterName;", "name", "user", "", "adapter", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "callMicListener", "Lkotlin/Function2;", "", "calling", "getCallMicListener", "()Lkotlin/jvm/functions/Function2;", "setCallMicListener", "(Lkotlin/jvm/functions/Function2;)V", "canSelectUser", "hideClickListener", "Lkotlin/Function0;", "getHideClickListener", "()Lkotlin/jvm/functions/Function0;", "setHideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "micPermission", "getMicPermission", "()Z", "setMicPermission", "(Z)V", "micPermissionListener", "enable", "getMicPermissionListener", "()Lkotlin/jvm/functions/Function1;", "setMicPermissionListener", "(Lkotlin/jvm/functions/Function1;)V", "parent", "Landroid/view/View;", "getParent", "()Landroid/view/View;", "setParent", "(Landroid/view/View;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "selectUser", "stopLiveMicListener", "userListView", "Landroid/support/v7/widget/RecyclerView;", "waitingMic", "acceptMic", "anchorCloseMic", "callback", "errType", "errCode", "buildBottomSheet", "buildMicCallingItemData", "buildMicWaitingItemData", "users", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "buildNoPermissionItemData", "buildNoUserItemData", "buildPermissionItemData", "clearData", "getSelectUser", "loadOnlineMembers", "playMicHungUpVoice", "refreshListView", "refreshParentsView", "resetMicUser", "sdkStartMic", "setDefaultMicState", "setMicUser", "micUser", "updateMicPermission", "Companion", "LiveAnchorMicUserAdapter", "LiveMicListItem", "plugin-logic_release"})
public final class LiveAnchorMicUserListView
  extends RelativeLayout
{
  public static final LiveAnchorMicUserListView.a gFN;
  private final com.tencent.mm.plugin.voip.video.i gDU;
  private boolean gFB;
  private d.g.a.a<y> gFC;
  private m<? super Boolean, ? super a.a, y> gFD;
  private b<? super Boolean, y> gFE;
  private final RecyclerView gFF;
  public final b gFG;
  private a.a gFH;
  private boolean gFI;
  public boolean gFJ;
  private b<? super a.a, y> gFK;
  private b<? super a.a, y> gFL;
  private View gFM;
  private e gzh;
  
  static
  {
    AppMethodBeat.i(190588);
    gFN = new LiveAnchorMicUserListView.a((byte)0);
    AppMethodBeat.o(190588);
  }
  
  public LiveAnchorMicUserListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190587);
    this.gDU = new com.tencent.mm.plugin.voip.video.i(com.tencent.mm.sdk.platformtools.ai.getContext());
    this.gFB = true;
    this.gFG = new b();
    this.gFI = true;
    this.gFK = ((b)new d(this));
    this.gFL = ((b)new j(this));
    paramContext = LayoutInflater.from(paramContext).inflate(2131496296, (ViewGroup)this, true);
    d.g.b.k.g(paramContext, "LayoutInflater.from(cont…ic_list_view, this, true)");
    this.gFM = paramContext;
    this.gFM.findViewById(2131298372).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190550);
        paramAnonymousView = this.gFO.getHideClickListener();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(190550);
          return;
        }
        AppMethodBeat.o(190550);
      }
    });
    paramContext = this.gFM.findViewById(2131307558);
    d.g.b.k.g(paramContext, "parent.findViewById(R.id.live_anchor_mic_list)");
    this.gFF = ((RecyclerView)paramContext);
    this.gFF.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.gFF.setAdapter((RecyclerView.a)this.gFG);
    this.gFF.setItemViewCacheSize(0);
    AppMethodBeat.o(190587);
  }
  
  private void a(final m<? super Integer, ? super Integer, y> paramm)
  {
    AppMethodBeat.i(190576);
    a.a locala = this.gFH;
    if (locala != null)
    {
      Object localObject = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "[cgi]anchor close mic.".concat(String.valueOf(locala)));
      localObject = com.tencent.mm.live.b.g.guG;
      long l = com.tencent.mm.live.b.g.akF().DMV;
      localObject = com.tencent.mm.live.b.g.guG;
      localObject = new com.tencent.mm.live.b.a.k(l, com.tencent.mm.live.b.g.akA(), String.valueOf(System.currentTimeMillis()), locala.gxh, locala.gxj);
      q localq = com.tencent.mm.kernel.g.agi();
      d.g.b.k.g(localq, "MMKernel.getNetSceneQueue()");
      ((com.tencent.mm.live.b.a.k)localObject).doScene(localq.agm(), (com.tencent.mm.ak.g)new f(locala, this, paramm));
      AppMethodBeat.o(190576);
      return;
    }
    AppMethodBeat.o(190576);
  }
  
  private void anF()
  {
    AppMethodBeat.i(190578);
    int i = com.tencent.mm.cc.a.ig(getContext());
    int j = com.tencent.mm.cc.a.ih(getContext());
    if (i > j) {
      i = j;
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, -1);
      localLayoutParams.gravity = 1;
      Context localContext1 = getContext();
      Context localContext2 = getContext();
      d.g.b.k.g(localContext2, "context");
      localLayoutParams.topMargin = com.tencent.mm.cc.a.g(localContext1, localContext2.getResources().getDimension(2131167038));
      this.gFM.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(190578);
      return;
    }
  }
  
  public static void anH()
  {
    AppMethodBeat.i(190580);
    Object localObject1 = com.tencent.mm.live.b.g.guG;
    Object localObject2 = com.tencent.mm.live.b.g.alq().gxd;
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((a.a)((Iterator)localObject2).next()).gxi);
    }
    localObject2 = com.tencent.mm.live.b.i.gvw;
    com.tencent.mm.live.b.i.X((List)localObject1);
    AppMethodBeat.o(190580);
  }
  
  private final void anI()
  {
    AppMethodBeat.i(190582);
    this.gFG.gFP.add(new LiveAnchorMicUserListView.c(0, null, null, 6));
    AppMethodBeat.o(190582);
  }
  
  private final void anJ()
  {
    AppMethodBeat.i(190583);
    a.a locala = this.gFH;
    if (locala != null)
    {
      this.gFG.gFP.add(new LiveAnchorMicUserListView.c(1, null, com.tencent.mm.cc.a.aw(getContext(), 2131766681), 2));
      this.gFG.gFP.add(new LiveAnchorMicUserListView.c(3, locala, null, 4));
      AppMethodBeat.o(190583);
      return;
    }
    AppMethodBeat.o(190583);
  }
  
  private final void anK()
  {
    AppMethodBeat.i(190585);
    this.gFG.gFP.add(new LiveAnchorMicUserListView.c(4, null, null, 6));
    AppMethodBeat.o(190585);
  }
  
  private final void anL()
  {
    AppMethodBeat.i(190586);
    this.gFG.gFP.add(new LiveAnchorMicUserListView.c(5, null, null, 6));
    AppMethodBeat.o(190586);
  }
  
  private final void clearData()
  {
    AppMethodBeat.i(190581);
    this.gFG.gFP.clear();
    AppMethodBeat.o(190581);
  }
  
  private final void j(ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(190584);
    Object localObject1 = this.gFG.gFP;
    Object localObject2 = z.KUT;
    localObject2 = com.tencent.mm.cc.a.aw(getContext(), 2131766716);
    d.g.b.k.g(localObject2, "ResourceHelper.getString…ive_room_wait_mic_number)");
    Object localObject3 = com.tencent.mm.live.b.g.guG;
    localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.live.b.g.alq().gxd.size()) }, 1));
    d.g.b.k.g(localObject2, "java.lang.String.format(format, *args)");
    ((ArrayList)localObject1).add(new LiveAnchorMicUserListView.c(1, null, (String)localObject2, 2));
    localObject1 = ((Iterable)paramArrayList).iterator();
    label180:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      localObject3 = ((a.a)localObject2).gxi;
      paramArrayList = this.gFH;
      if (paramArrayList != null) {}
      for (paramArrayList = paramArrayList.gxi;; paramArrayList = null)
      {
        if (!(d.g.b.k.g(localObject3, paramArrayList) ^ true)) {
          break label180;
        }
        this.gFG.gFP.add(new LiveAnchorMicUserListView.c(2, (a.a)localObject2, null, 4));
        break;
      }
    }
    AppMethodBeat.o(190584);
  }
  
  public final void anD()
  {
    AppMethodBeat.i(190575);
    this.gDU.T(true, 1);
    AppMethodBeat.o(190575);
  }
  
  public final void anE()
  {
    this.gFI = true;
    this.gFH = null;
  }
  
  public final void anG()
  {
    AppMethodBeat.i(190579);
    anF();
    clearData();
    anI();
    if (this.gFH != null) {
      anJ();
    }
    if (this.gFB)
    {
      Object localObject = com.tencent.mm.live.b.g.guG;
      localObject = com.tencent.mm.live.b.g.alq().gxd;
      Collection localCollection = (Collection)localObject;
      a.a locala = this.gFH;
      if (localCollection == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(190579);
        throw ((Throwable)localObject);
      }
      aa.eO(localCollection).remove(locala);
      if (((ArrayList)localObject).size() > 0) {
        j((ArrayList)localObject);
      }
    }
    for (;;)
    {
      this.gFG.notifyDataSetChanged();
      AppMethodBeat.o(190579);
      return;
      if (this.gFH == null)
      {
        anK();
        continue;
        anL();
      }
    }
  }
  
  public final m<Boolean, a.a, y> getCallMicListener()
  {
    return this.gFD;
  }
  
  public final d.g.a.a<y> getHideClickListener()
  {
    return this.gFC;
  }
  
  public final boolean getMicPermission()
  {
    return this.gFB;
  }
  
  public final b<Boolean, y> getMicPermissionListener()
  {
    return this.gFE;
  }
  
  public final View getParent()
  {
    return this.gFM;
  }
  
  public final a.a getSelectUser()
  {
    return this.gFH;
  }
  
  public final void setCallMicListener(m<? super Boolean, ? super a.a, y> paramm)
  {
    this.gFD = paramm;
  }
  
  public final void setDefaultMicState(boolean paramBoolean)
  {
    this.gFB = paramBoolean;
  }
  
  public final void setHideClickListener(d.g.a.a<y> parama)
  {
    this.gFC = parama;
  }
  
  public final void setMicPermission(boolean paramBoolean)
  {
    this.gFB = paramBoolean;
  }
  
  public final void setMicPermissionListener(b<? super Boolean, y> paramb)
  {
    this.gFE = paramb;
  }
  
  public final void setMicUser(a.a parama)
  {
    this.gFH = parama;
  }
  
  public final void setParent(View paramView)
  {
    AppMethodBeat.i(190574);
    d.g.b.k.h(paramView, "<set-?>");
    this.gFM = paramView;
    AppMethodBeat.o(190574);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;)V", "liveMicItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "Lkotlin/collections/ArrayList;", "getLiveMicItems", "()Ljava/util/ArrayList;", "setLiveMicItems", "(Ljava/util/ArrayList;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "", "uid", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "loadUserInfo", "itemView", "Landroid/view/View;", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-logic_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.w>
  {
    ArrayList<LiveAnchorMicUserListView.c> gFP;
    
    public b()
    {
      AppMethodBeat.i(190559);
      this.gFP = new ArrayList();
      AppMethodBeat.o(190559);
    }
    
    private static void a(View paramView, a.a parama)
    {
      AppMethodBeat.i(190558);
      Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "service<IMessengerStorag…engerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNt(parama.gxi);
      a.b.d((ImageView)paramView.findViewById(2131307568), parama.gxi, 0.1F);
      paramView = paramView.findViewById(2131307572);
      d.g.b.k.g(paramView, "itemView.findViewById<Te…ive_anchor_mic_user_name)");
      paramView = (TextView)paramView;
      d.g.b.k.g(localObject, "contact");
      paramView.setText((CharSequence)((com.tencent.mm.storage.ai)localObject).Tn());
      AppMethodBeat.o(190558);
    }
    
    public final RecyclerView.w a(final ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(190554);
      d.g.b.k.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        paramViewGroup = (RecyclerView.w)new j(this, paramViewGroup, LayoutInflater.from(this.gFO.getContext()).inflate(2131496295, paramViewGroup, false));
        AppMethodBeat.o(190554);
        return paramViewGroup;
      case 0: 
        paramViewGroup = (RecyclerView.w)new d(this, paramViewGroup, LayoutInflater.from(this.gFO.getContext()).inflate(2131496294, paramViewGroup, false));
        AppMethodBeat.o(190554);
        return paramViewGroup;
      case 1: 
        paramViewGroup = (RecyclerView.w)new e(this, paramViewGroup, LayoutInflater.from(this.gFO.getContext()).inflate(2131496295, paramViewGroup, false));
        AppMethodBeat.o(190554);
        return paramViewGroup;
      case 2: 
        paramViewGroup = (RecyclerView.w)new f(this, paramViewGroup, LayoutInflater.from(this.gFO.getContext()).inflate(2131496290, paramViewGroup, false));
        AppMethodBeat.o(190554);
        return paramViewGroup;
      case 3: 
        paramViewGroup = (RecyclerView.w)new g(this, paramViewGroup, LayoutInflater.from(this.gFO.getContext()).inflate(2131496291, paramViewGroup, false));
        AppMethodBeat.o(190554);
        return paramViewGroup;
      case 4: 
        paramViewGroup = (RecyclerView.w)new h(this, paramViewGroup, LayoutInflater.from(this.gFO.getContext()).inflate(2131496292, paramViewGroup, false));
        AppMethodBeat.o(190554);
        return paramViewGroup;
      }
      paramViewGroup = (RecyclerView.w)new i(this, paramViewGroup, LayoutInflater.from(this.gFO.getContext()).inflate(2131496293, paramViewGroup, false));
      AppMethodBeat.o(190554);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(190556);
      d.g.b.k.h(paramw, "holder");
      switch (getItemViewType(paramInt))
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          paramw = paramw.asD;
          d.g.b.k.g(paramw, "holder.itemView");
          if (!LiveAnchorMicUserListView.e(this.gFO)) {
            break;
          }
          paramw.setAlpha(1.0F);
          paramw.setEnabled(true);
          AppMethodBeat.o(190556);
          return;
          localObject1 = (MMSwitchBtn)paramw.asD.findViewById(2131307576);
          ((TextView)paramw.asD.findViewById(2131307577)).setOnClickListener((View.OnClickListener)new a(this));
          d.g.b.k.g(localObject1, "switchView");
          ((MMSwitchBtn)localObject1).setCheck(this.gFO.getMicPermission());
          continue;
          localObject1 = paramw.asD;
          if (localObject1 == null)
          {
            paramw = new v("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(190556);
            throw paramw;
          }
          ((TextView)localObject1).setText((CharSequence)((LiveAnchorMicUserListView.c)this.gFP.get(paramInt)).title);
          continue;
          localObject1 = ((LiveAnchorMicUserListView.c)this.gFP.get(paramInt)).gFS;
          if (localObject1 != null)
          {
            localObject2 = paramw.asD;
            d.g.b.k.g(localObject2, "holder.itemView");
            a((View)localObject2, (a.a)localObject1);
          }
          ((TextView)paramw.asD.findViewById(2131307692)).setOnClickListener((View.OnClickListener)new b(this, paramInt));
        }
      }
      Object localObject1 = ((LiveAnchorMicUserListView.c)this.gFP.get(paramInt)).gFS;
      if (localObject1 != null)
      {
        localObject2 = paramw.asD;
        d.g.b.k.g(localObject2, "holder.itemView");
        a((View)localObject2, (a.a)localObject1);
      }
      Object localObject2 = (ImageView)paramw.asD.findViewById(2131307713);
      Object localObject3 = (ImageView)paramw.asD.findViewById(2131307714);
      localObject1 = (TextView)paramw.asD.findViewById(2131307706);
      if (LiveAnchorMicUserListView.f(this.gFO))
      {
        d.g.b.k.g(localObject3, "maskView");
        ((ImageView)localObject3).setVisibility(0);
        d.g.b.k.g(localObject2, "loadingView");
        ((ImageView)localObject2).setVisibility(0);
        localObject3 = ((ImageView)localObject2).getBackground();
        if (localObject3 == null)
        {
          paramw = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(190556);
          throw paramw;
        }
        ((AnimationDrawable)localObject3).stop();
        localObject2 = ((ImageView)localObject2).getBackground();
        if (localObject2 == null)
        {
          paramw = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(190556);
          throw paramw;
        }
        ((AnimationDrawable)localObject2).start();
        d.g.b.k.g(localObject1, "btn");
        localObject2 = this.gFO.getContext();
        d.g.b.k.g(localObject2, "context");
        ((TextView)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131234913));
        localObject2 = this.gFO.getContext();
        d.g.b.k.g(localObject2, "context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131766682));
      }
      for (;;)
      {
        ((TextView)localObject1).setOnClickListener((View.OnClickListener)new c(this, paramInt));
        break;
        d.g.b.k.g(localObject3, "maskView");
        ((ImageView)localObject3).setVisibility(4);
        d.g.b.k.g(localObject2, "loadingView");
        ((ImageView)localObject2).setVisibility(4);
        localObject2 = ((ImageView)localObject2).getBackground();
        if (localObject2 == null)
        {
          paramw = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(190556);
          throw paramw;
        }
        ((AnimationDrawable)localObject2).stop();
        d.g.b.k.g(localObject1, "btn");
        localObject2 = this.gFO.getContext();
        d.g.b.k.g(localObject2, "context");
        ((TextView)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131234934));
        localObject2 = this.gFO.getContext();
        d.g.b.k.g(localObject2, "context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131766690));
      }
      if (paramInt >= 3)
      {
        paramw.setAlpha(0.3F);
        paramw.setEnabled(false);
      }
      AppMethodBeat.o(190556);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(190555);
      int i = this.gFP.size();
      AppMethodBeat.o(190555);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(190557);
      paramInt = ((LiveAnchorMicUserListView.c)this.gFP.get(paramInt)).type;
      AppMethodBeat.o(190557);
      return paramInt;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(LiveAnchorMicUserListView.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(190551);
        if (this.gFQ.gFO.getMicPermission())
        {
          LiveAnchorMicUserListView.b(this.gFQ.gFO);
          paramView = LiveAnchorMicUserListView.c(this.gFQ.gFO);
          if (paramView != null)
          {
            paramView.cED();
            AppMethodBeat.o(190551);
            return;
          }
          AppMethodBeat.o(190551);
          return;
        }
        LiveAnchorMicUserListView.a(this.gFQ.gFO, true);
        AppMethodBeat.o(190551);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(190552);
        if (LiveAnchorMicUserListView.e(this.gFQ.gFO))
        {
          LiveAnchorMicUserListView.g(this.gFQ.gFO);
          LiveAnchorMicUserListView.h(this.gFQ.gFO).ay(((LiveAnchorMicUserListView.c)this.gFQ.gFP.get(paramInt)).gFS);
        }
        AppMethodBeat.o(190552);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(190553);
        LiveAnchorMicUserListView.i(this.gFQ.gFO).ay(((LiveAnchorMicUserListView.c)this.gFQ.gFP.get(paramInt)).gFS);
        AppMethodBeat.o(190553);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class d
      extends RecyclerView.w
    {
      d(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$2", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class e
      extends RecyclerView.w
    {
      e(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$3", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class f
      extends RecyclerView.w
    {
      f(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$4", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class g
      extends RecyclerView.w
    {
      g(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$5", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class h
      extends RecyclerView.w
    {
      h(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$6", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class i
      extends RecyclerView.w
    {
      i(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$7", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class j
      extends RecyclerView.w
    {
      j(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<a.a, y>
  {
    d(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements com.tencent.mm.ak.g
  {
    e(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, a.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(190565);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "[cgi]accept mic errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        LiveAnchorMicUserListView.j(this.gFO).T(true, 1);
        paramString = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.alq().a(this.gxm);
        AppMethodBeat.o(190565);
        return;
      }
      t.makeText(this.gFO.getContext(), (CharSequence)com.tencent.mm.cc.a.aw(this.gFO.getContext(), 2131766680), 0).show();
      LiveAnchorMicUserListView.b(this.gFO, true);
      paramString = this.gFO.getCallMicListener();
      if (paramString != null) {
        paramString.n(Boolean.FALSE, null);
      }
      this.gFO.anG();
      AppMethodBeat.o(190565);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$anchorCloseMic$1$1"})
  static final class f
    implements com.tencent.mm.ak.g
  {
    f(a.a parama, LiveAnchorMicUserListView paramLiveAnchorMicUserListView, m paramm) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(190566);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "[cgi-ret]anchor close mic :" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        jdField_this.anD();
      }
      if (paramm == null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = jdField_this.getContext();
          paramn = jdField_this.getContext();
          d.g.b.k.g(paramn, "context");
          t.makeText(paramString, (CharSequence)paramn.getResources().getString(2131766703), 0).show();
          paramString = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.g.alq().gxd.remove(this.gFT);
          jdField_this.anE();
          paramString = com.tencent.mm.live.b.g.guG;
          com.tencent.mm.live.b.g.alq().alH();
          jdField_this.anG();
          paramString = jdField_this.getCallMicListener();
          if (paramString != null)
          {
            paramString.n(Boolean.FALSE, null);
            AppMethodBeat.o(190566);
            return;
          }
          AppMethodBeat.o(190566);
        }
      }
      else {
        paramm.n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      AppMethodBeat.o(190566);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements n.c
  {
    g(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(190567);
      Object localObject = LiveAnchorMicUserListView.c(this.gFO);
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paraml.clear();
      localObject = this.gFO.getContext();
      d.g.b.k.g(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(2131101209);
      localObject = this.gFO.getContext();
      d.g.b.k.g(localObject, "context");
      paraml.a(1, i, (CharSequence)((Context)localObject).getResources().getString(2131766684));
      AppMethodBeat.o(190567);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
  static final class h
    implements n.d
  {
    h(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(190568);
      d.g.b.k.h(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      default: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.gFO);
        if (paramMenuItem != null)
        {
          paramMenuItem.bmi();
          AppMethodBeat.o(190568);
          return;
        }
        break;
      case 0: 
        AppMethodBeat.o(190568);
        return;
      case 1: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.gFO);
        if (paramMenuItem != null) {
          paramMenuItem.bmi();
        }
        LiveAnchorMicUserListView.a(this.gFO, false);
        AppMethodBeat.o(190568);
        return;
      }
      AppMethodBeat.o(190568);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onDismiss"})
  static final class i
    implements e.b
  {
    i(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(190569);
      LiveAnchorMicUserListView.d(this.gFO);
      AppMethodBeat.o(190569);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class j
    extends d.g.b.l
    implements b<a.a, y>
  {
    j(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class k
    implements com.tencent.mm.ak.g
  {
    k(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(190571);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.gFO.setMicPermission(true);
        this.gFO.anG();
      }
      for (;;)
      {
        paramString = this.gFO.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.ay(Boolean.valueOf(this.gFO.getMicPermission()));
        AppMethodBeat.o(190571);
        return;
        this.gFO.setMicPermission(false);
      }
      AppMethodBeat.o(190571);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "invoke"})
  static final class l
    extends d.g.b.l
    implements m<Integer, Integer, y>
  {
    l(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class m
    implements com.tencent.mm.ak.g
  {
    m(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(190573);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.gqF;
      com.tencent.mm.live.core.debug.a.aq("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.gFO.setMicPermission(false);
        paramString = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.alq().gxd.clear();
        this.gFO.anG();
      }
      for (;;)
      {
        paramString = this.gFO.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.ay(Boolean.valueOf(this.gFO.getMicPermission()));
        AppMethodBeat.o(190573);
        return;
        this.gFO.setMicPermission(true);
      }
      AppMethodBeat.o(190573);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView
 * JD-Core Version:    0.7.0.1
 */