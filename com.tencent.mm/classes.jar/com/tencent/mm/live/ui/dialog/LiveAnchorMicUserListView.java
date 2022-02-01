package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.b.a.k;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.ae;
import kotlin.g.b.af;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "acceptLiveMicListener", "Lkotlin/Function1;", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "Lkotlin/ParameterName;", "name", "user", "", "adapter", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "callMicListener", "Lkotlin/Function2;", "", "calling", "getCallMicListener", "()Lkotlin/jvm/functions/Function2;", "setCallMicListener", "(Lkotlin/jvm/functions/Function2;)V", "canSelectUser", "hideClickListener", "Lkotlin/Function0;", "getHideClickListener", "()Lkotlin/jvm/functions/Function0;", "setHideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "micPermission", "getMicPermission", "()Z", "setMicPermission", "(Z)V", "micPermissionListener", "enable", "getMicPermissionListener", "()Lkotlin/jvm/functions/Function1;", "setMicPermissionListener", "(Lkotlin/jvm/functions/Function1;)V", "parent", "Landroid/view/View;", "getParent", "()Landroid/view/View;", "setParent", "(Landroid/view/View;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "selectUser", "stopLiveMicListener", "userListView", "Landroid/support/v7/widget/RecyclerView;", "waitingMic", "acceptMic", "anchorCloseMic", "callback", "errType", "errCode", "buildBottomSheet", "buildMicCallingItemData", "buildMicWaitingItemData", "users", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "buildNoPermissionItemData", "buildNoUserItemData", "buildPermissionItemData", "clearData", "getSelectUser", "loadOnlineMembers", "playMicHungUpVoice", "refreshListView", "refreshParentsView", "resetMicUser", "sdkStartMic", "setDefaultMicState", "setMicUser", "micUser", "updateMicPermission", "Companion", "LiveAnchorMicUserAdapter", "LiveMicListItem", "plugin-logic_release"})
public final class LiveAnchorMicUserListView
  extends RelativeLayout
{
  public static final a hVe;
  private com.tencent.mm.ui.widget.a.e hOv;
  private final com.tencent.mm.plugin.voip.video.e hTl;
  private boolean hUS;
  private kotlin.g.a.a<kotlin.x> hUT;
  private kotlin.g.a.m<? super Boolean, ? super a.a, kotlin.x> hUU;
  private kotlin.g.a.b<? super Boolean, kotlin.x> hUV;
  private final RecyclerView hUW;
  public final b hUX;
  private a.a hUY;
  private boolean hUZ;
  public boolean hVa;
  private kotlin.g.a.b<? super a.a, kotlin.x> hVb;
  private kotlin.g.a.b<? super a.a, kotlin.x> hVc;
  private View hVd;
  
  static
  {
    AppMethodBeat.i(208467);
    hVe = new a((byte)0);
    AppMethodBeat.o(208467);
  }
  
  public LiveAnchorMicUserListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208466);
    this.hTl = new com.tencent.mm.plugin.voip.video.e(MMApplicationContext.getContext());
    this.hUS = true;
    this.hUX = new b();
    this.hUZ = true;
    this.hVb = ((kotlin.g.a.b)new d(this));
    this.hVc = ((kotlin.g.a.b)new j(this));
    paramContext = LayoutInflater.from(paramContext).inflate(2131495235, (ViewGroup)this, true);
    p.g(paramContext, "LayoutInflater.from(cont…ic_list_view, this, true)");
    this.hVd = paramContext;
    this.hVd.findViewById(2131298781).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208429);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = this.hVf.getHideClickListener();
        if (paramAnonymousView != null) {
          paramAnonymousView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208429);
      }
    });
    paramContext = this.hVd.findViewById(2131303318);
    p.g(paramContext, "parent.findViewById(R.id.live_anchor_mic_list)");
    this.hUW = ((RecyclerView)paramContext);
    this.hUW.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    this.hUW.setAdapter((RecyclerView.a)this.hUX);
    this.hUW.setItemViewCacheSize(0);
    AppMethodBeat.o(208466);
  }
  
  private void a(final kotlin.g.a.m<? super Integer, ? super Integer, kotlin.x> paramm)
  {
    AppMethodBeat.i(208455);
    a.a locala = this.hUY;
    if (locala != null)
    {
      Object localObject = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[cgi]anchor close mic.".concat(String.valueOf(locala)));
      localObject = com.tencent.mm.live.b.x.hJf;
      long l = com.tencent.mm.live.b.x.aGr().hyH;
      localObject = com.tencent.mm.live.b.x.hJf;
      localObject = new k(l, com.tencent.mm.live.b.x.aGm(), String.valueOf(System.currentTimeMillis()), locala.hFz, locala.hFG);
      com.tencent.mm.ak.t localt = g.azz();
      p.g(localt, "MMKernel.getNetSceneQueue()");
      ((k)localObject).doScene(localt.azD(), (i)new f(locala, this, paramm));
      AppMethodBeat.o(208455);
      return;
    }
    AppMethodBeat.o(208455);
  }
  
  private void aJe()
  {
    AppMethodBeat.i(208457);
    int i = com.tencent.mm.cb.a.jn(getContext());
    int j = com.tencent.mm.cb.a.jo(getContext());
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
      localLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(localContext1, localContext2.getResources().getDimension(2131166575));
      this.hVd.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(208457);
      return;
    }
  }
  
  public static void aJg()
  {
    AppMethodBeat.i(208459);
    Object localObject1 = com.tencent.mm.live.b.x.hJf;
    Object localObject2 = com.tencent.mm.live.b.x.aHa().hKT;
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((a.a)((Iterator)localObject2).next()).hFJ);
    }
    localObject2 = r.hIg;
    r.ag((List)localObject1);
    AppMethodBeat.o(208459);
  }
  
  private final void aJh()
  {
    AppMethodBeat.i(208461);
    this.hUX.hVg.add(new c(0, null, null, 6));
    AppMethodBeat.o(208461);
  }
  
  private final void aJi()
  {
    AppMethodBeat.i(208462);
    a.a locala = this.hUY;
    if (locala != null)
    {
      this.hUX.hVg.add(new c(1, null, com.tencent.mm.cb.a.aI(getContext(), 2131762378), 2));
      this.hUX.hVg.add(new c(3, locala, null, 4));
      AppMethodBeat.o(208462);
      return;
    }
    AppMethodBeat.o(208462);
  }
  
  private final void aJj()
  {
    AppMethodBeat.i(208464);
    this.hUX.hVg.add(new c(4, null, null, 6));
    AppMethodBeat.o(208464);
  }
  
  private final void aJk()
  {
    AppMethodBeat.i(208465);
    this.hUX.hVg.add(new c(5, null, null, 6));
    AppMethodBeat.o(208465);
  }
  
  private final void clearData()
  {
    AppMethodBeat.i(208460);
    this.hUX.hVg.clear();
    AppMethodBeat.o(208460);
  }
  
  private final void n(ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(208463);
    Object localObject1 = this.hUX.hVg;
    Object localObject2 = ae.SYK;
    localObject2 = com.tencent.mm.cb.a.aI(getContext(), 2131762413);
    p.g(localObject2, "ResourceHelper.getString…ive_room_wait_mic_number)");
    Object localObject3 = com.tencent.mm.live.b.x.hJf;
    localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(com.tencent.mm.live.b.x.aHa().hKT.size()) }, 1));
    p.g(localObject2, "java.lang.String.format(format, *args)");
    ((ArrayList)localObject1).add(new c(1, null, (String)localObject2, 2));
    localObject1 = ((Iterable)paramArrayList).iterator();
    label180:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      localObject3 = ((a.a)localObject2).hFJ;
      paramArrayList = this.hUY;
      if (paramArrayList != null) {}
      for (paramArrayList = paramArrayList.hFJ;; paramArrayList = null)
      {
        if (!(p.j(localObject3, paramArrayList) ^ true)) {
          break label180;
        }
        this.hUX.hVg.add(new c(2, (a.a)localObject2, null, 4));
        break;
      }
    }
    AppMethodBeat.o(208463);
  }
  
  public final void aJc()
  {
    AppMethodBeat.i(208454);
    this.hTl.g(2131691334, true, 1);
    AppMethodBeat.o(208454);
  }
  
  public final void aJd()
  {
    this.hUZ = true;
    this.hUY = null;
  }
  
  public final void aJf()
  {
    AppMethodBeat.i(208458);
    aJe();
    clearData();
    aJh();
    if (this.hUY != null) {
      aJi();
    }
    if (this.hUS)
    {
      Object localObject = com.tencent.mm.live.b.x.hJf;
      localObject = com.tencent.mm.live.b.x.aHa().hKT;
      Collection localCollection = (Collection)localObject;
      a.a locala = this.hUY;
      if (localCollection == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(208458);
        throw ((Throwable)localObject);
      }
      af.eV(localCollection).remove(locala);
      if (((ArrayList)localObject).size() > 0) {
        n((ArrayList)localObject);
      }
    }
    for (;;)
    {
      this.hUX.notifyDataSetChanged();
      AppMethodBeat.o(208458);
      return;
      if (this.hUY == null)
      {
        aJj();
        continue;
        aJk();
      }
    }
  }
  
  public final kotlin.g.a.m<Boolean, a.a, kotlin.x> getCallMicListener()
  {
    return this.hUU;
  }
  
  public final kotlin.g.a.a<kotlin.x> getHideClickListener()
  {
    return this.hUT;
  }
  
  public final boolean getMicPermission()
  {
    return this.hUS;
  }
  
  public final kotlin.g.a.b<Boolean, kotlin.x> getMicPermissionListener()
  {
    return this.hUV;
  }
  
  public final View getParent()
  {
    return this.hVd;
  }
  
  public final a.a getSelectUser()
  {
    return this.hUY;
  }
  
  public final void setCallMicListener(kotlin.g.a.m<? super Boolean, ? super a.a, kotlin.x> paramm)
  {
    this.hUU = paramm;
  }
  
  public final void setDefaultMicState(boolean paramBoolean)
  {
    this.hUS = paramBoolean;
  }
  
  public final void setHideClickListener(kotlin.g.a.a<kotlin.x> parama)
  {
    this.hUT = parama;
  }
  
  public final void setMicPermission(boolean paramBoolean)
  {
    this.hUS = paramBoolean;
  }
  
  public final void setMicPermissionListener(kotlin.g.a.b<? super Boolean, kotlin.x> paramb)
  {
    this.hUV = paramb;
  }
  
  public final void setMicUser(a.a parama)
  {
    this.hUY = parama;
  }
  
  public final void setParent(View paramView)
  {
    AppMethodBeat.i(208453);
    p.h(paramView, "<set-?>");
    this.hVd = paramView;
    AppMethodBeat.o(208453);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$Companion;", "", "()V", "MIC_ACCEPT", "", "MIC_CALLING", "MIC_NO_DATA", "MIC_NO_PERMISSION", "MIC_PERMISSION", "MIC_TITLE", "plugin-logic_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;)V", "liveMicItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "Lkotlin/collections/ArrayList;", "getLiveMicItems", "()Ljava/util/ArrayList;", "setLiveMicItems", "(Ljava/util/ArrayList;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "", "uid", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "loadUserInfo", "itemView", "Landroid/view/View;", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-logic_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<LiveAnchorMicUserListView.c> hVg;
    
    public b()
    {
      AppMethodBeat.i(208438);
      this.hVg = new ArrayList();
      AppMethodBeat.o(208438);
    }
    
    private static void a(View paramView, a.a parama)
    {
      AppMethodBeat.i(208437);
      Object localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "service<IMessengerStorag…engerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(parama.hFJ);
      a.b.d((ImageView)paramView.findViewById(2131303328), parama.hFJ, 0.1F);
      paramView = paramView.findViewById(2131303332);
      p.g(paramView, "itemView.findViewById<Te…ive_anchor_mic_user_name)");
      paramView = (TextView)paramView;
      p.g(localObject, "contact");
      paramView.setText((CharSequence)((as)localObject).getNickname());
      AppMethodBeat.o(208437);
    }
    
    public final RecyclerView.v a(final ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(208433);
      p.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        paramViewGroup = (RecyclerView.v)new j(this, paramViewGroup, LayoutInflater.from(this.hVf.getContext()).inflate(2131495234, paramViewGroup, false));
        AppMethodBeat.o(208433);
        return paramViewGroup;
      case 0: 
        paramViewGroup = (RecyclerView.v)new d(this, paramViewGroup, LayoutInflater.from(this.hVf.getContext()).inflate(2131495233, paramViewGroup, false));
        AppMethodBeat.o(208433);
        return paramViewGroup;
      case 1: 
        paramViewGroup = (RecyclerView.v)new e(this, paramViewGroup, LayoutInflater.from(this.hVf.getContext()).inflate(2131495234, paramViewGroup, false));
        AppMethodBeat.o(208433);
        return paramViewGroup;
      case 2: 
        paramViewGroup = (RecyclerView.v)new f(this, paramViewGroup, LayoutInflater.from(this.hVf.getContext()).inflate(2131495229, paramViewGroup, false));
        AppMethodBeat.o(208433);
        return paramViewGroup;
      case 3: 
        paramViewGroup = (RecyclerView.v)new g(this, paramViewGroup, LayoutInflater.from(this.hVf.getContext()).inflate(2131495230, paramViewGroup, false));
        AppMethodBeat.o(208433);
        return paramViewGroup;
      case 4: 
        paramViewGroup = (RecyclerView.v)new h(this, paramViewGroup, LayoutInflater.from(this.hVf.getContext()).inflate(2131495231, paramViewGroup, false));
        AppMethodBeat.o(208433);
        return paramViewGroup;
      }
      paramViewGroup = (RecyclerView.v)new i(this, paramViewGroup, LayoutInflater.from(this.hVf.getContext()).inflate(2131495232, paramViewGroup, false));
      AppMethodBeat.o(208433);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(208435);
      p.h(paramv, "holder");
      switch (getItemViewType(paramInt))
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          paramv = paramv.aus;
          p.g(paramv, "holder.itemView");
          if (!LiveAnchorMicUserListView.e(this.hVf)) {
            break;
          }
          paramv.setAlpha(1.0F);
          paramv.setEnabled(true);
          AppMethodBeat.o(208435);
          return;
          localObject1 = (MMSwitchBtn)paramv.aus.findViewById(2131303336);
          ((TextView)paramv.aus.findViewById(2131303337)).setOnClickListener((View.OnClickListener)new a(this));
          p.g(localObject1, "switchView");
          ((MMSwitchBtn)localObject1).setCheck(this.hVf.getMicPermission());
          continue;
          localObject1 = paramv.aus;
          if (localObject1 == null)
          {
            paramv = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(208435);
            throw paramv;
          }
          ((TextView)localObject1).setText((CharSequence)((LiveAnchorMicUserListView.c)this.hVg.get(paramInt)).title);
          continue;
          localObject1 = ((LiveAnchorMicUserListView.c)this.hVg.get(paramInt)).hVj;
          if (localObject1 != null)
          {
            localObject2 = paramv.aus;
            p.g(localObject2, "holder.itemView");
            a((View)localObject2, (a.a)localObject1);
          }
          ((TextView)paramv.aus.findViewById(2131303476)).setOnClickListener((View.OnClickListener)new b(this, paramInt));
        }
      }
      Object localObject1 = ((LiveAnchorMicUserListView.c)this.hVg.get(paramInt)).hVj;
      if (localObject1 != null)
      {
        localObject2 = paramv.aus;
        p.g(localObject2, "holder.itemView");
        a((View)localObject2, (a.a)localObject1);
      }
      Object localObject2 = (ImageView)paramv.aus.findViewById(2131303497);
      Object localObject3 = (ImageView)paramv.aus.findViewById(2131303498);
      localObject1 = (TextView)paramv.aus.findViewById(2131303490);
      if (LiveAnchorMicUserListView.f(this.hVf))
      {
        p.g(localObject3, "maskView");
        ((ImageView)localObject3).setVisibility(0);
        p.g(localObject2, "loadingView");
        ((ImageView)localObject2).setVisibility(0);
        localObject3 = ((ImageView)localObject2).getBackground();
        if (localObject3 == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(208435);
          throw paramv;
        }
        ((AnimationDrawable)localObject3).stop();
        localObject2 = ((ImageView)localObject2).getBackground();
        if (localObject2 == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(208435);
          throw paramv;
        }
        ((AnimationDrawable)localObject2).start();
        p.g(localObject1, "btn");
        localObject2 = this.hVf.getContext();
        p.g(localObject2, "context");
        ((TextView)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131233349));
        localObject2 = this.hVf.getContext();
        p.g(localObject2, "context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131762379));
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
          paramv = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(208435);
          throw paramv;
        }
        ((AnimationDrawable)localObject2).stop();
        p.g(localObject1, "btn");
        localObject2 = this.hVf.getContext();
        p.g(localObject2, "context");
        ((TextView)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(2131233496));
        localObject2 = this.hVf.getContext();
        p.g(localObject2, "context");
        ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getResources().getString(2131762387));
      }
      if (paramInt >= 3)
      {
        paramv.setAlpha(0.3F);
        paramv.setEnabled(false);
      }
      AppMethodBeat.o(208435);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(208434);
      int i = this.hVg.size();
      AppMethodBeat.o(208434);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(208436);
      paramInt = ((LiveAnchorMicUserListView.c)this.hVg.get(paramInt)).type;
      AppMethodBeat.o(208436);
      return paramInt;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(LiveAnchorMicUserListView.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208430);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.hVh.hVf.getMicPermission())
        {
          LiveAnchorMicUserListView.b(this.hVh.hVf);
          paramView = LiveAnchorMicUserListView.c(this.hVh.hVf);
          if (paramView != null) {
            paramView.dGm();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208430);
          return;
          LiveAnchorMicUserListView.a(this.hVh.hVf, true);
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208431);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (LiveAnchorMicUserListView.e(this.hVh.hVf))
        {
          LiveAnchorMicUserListView.g(this.hVh.hVf);
          LiveAnchorMicUserListView.h(this.hVh.hVf).invoke(((LiveAnchorMicUserListView.c)this.hVh.hVg.get(paramInt)).hVj);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208431);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(208432);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        LiveAnchorMicUserListView.i(this.hVh.hVf).invoke(((LiveAnchorMicUserListView.c)this.hVh.hVg.get(paramInt)).hVj);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onBindViewHolder$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208432);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class d
      extends RecyclerView.v
    {
      d(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$2", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class e
      extends RecyclerView.v
    {
      e(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$3", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class f
      extends RecyclerView.v
    {
      f(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$4", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class g
      extends RecyclerView.v
    {
      g(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$5", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class h
      extends RecyclerView.v
    {
      h(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$6", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class i
      extends RecyclerView.v
    {
      i(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$7", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class j
      extends RecyclerView.v
    {
      j(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "", "type", "", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "title", "", "(ILcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getUser", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "setUser", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
  public static final class c
  {
    a.a hVj;
    String title;
    int type;
    
    private c(int paramInt, a.a parama, String paramString)
    {
      this.type = paramInt;
      this.hVj = parama;
      this.title = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(208442);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.type != paramObject.type) || (!p.j(this.hVj, paramObject.hVj)) || (!p.j(this.title, paramObject.title))) {}
        }
      }
      else
      {
        AppMethodBeat.o(208442);
        return true;
      }
      AppMethodBeat.o(208442);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(208441);
      int k = this.type;
      Object localObject = this.hVj;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.title;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(208441);
        return (i + k * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(208440);
      String str = "LiveMicListItem(type=" + this.type + ", user=" + this.hVj + ", title=" + this.title + ")";
      AppMethodBeat.o(208440);
      return str;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<a.a, kotlin.x>
  {
    d(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements i
  {
    e(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, a.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(208444);
      paramq.setHasCallbackToQueue(true);
      paramq = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[cgi]accept mic errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        LiveAnchorMicUserListView.j(this.hVf).g(2131691334, true, 1);
        paramString = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aHa().a(this.hKZ);
        AppMethodBeat.o(208444);
        return;
      }
      u.makeText(this.hVf.getContext(), (CharSequence)com.tencent.mm.cb.a.aI(this.hVf.getContext(), 2131762377), 0).show();
      LiveAnchorMicUserListView.b(this.hVf, true);
      paramString = this.hVf.getCallMicListener();
      if (paramString != null) {
        paramString.invoke(Boolean.FALSE, null);
      }
      this.hVf.aJf();
      AppMethodBeat.o(208444);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$anchorCloseMic$1$1"})
  static final class f
    implements i
  {
    f(a.a parama, LiveAnchorMicUserListView paramLiveAnchorMicUserListView, kotlin.g.a.m paramm) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(208445);
      paramq.setHasCallbackToQueue(true);
      paramq = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "[cgi-ret]anchor close mic :" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        jdField_this.aJc();
      }
      if (paramm == null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = jdField_this.getContext();
          paramq = jdField_this.getContext();
          p.g(paramq, "context");
          u.makeText(paramString, (CharSequence)paramq.getResources().getString(2131762400), 0).show();
          paramString = com.tencent.mm.live.b.x.hJf;
          com.tencent.mm.live.b.x.aHa().hKT.remove(this.hVk);
          jdField_this.aJd();
          paramString = com.tencent.mm.live.b.x.hJf;
          com.tencent.mm.live.b.x.aHa().aHk();
          jdField_this.aJf();
          paramString = jdField_this.getCallMicListener();
          if (paramString != null)
          {
            paramString.invoke(Boolean.FALSE, null);
            AppMethodBeat.o(208445);
            return;
          }
          AppMethodBeat.o(208445);
        }
      }
      else {
        paramm.invoke(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      AppMethodBeat.o(208445);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements o.f
  {
    g(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(208446);
      Object localObject = LiveAnchorMicUserListView.c(this.hVf);
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paramm.clear();
      localObject = this.hVf.getContext();
      p.g(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(2131100712);
      localObject = this.hVf.getContext();
      p.g(localObject, "context");
      paramm.a(1, i, (CharSequence)((Context)localObject).getResources().getString(2131762381));
      AppMethodBeat.o(208446);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
  static final class h
    implements o.g
  {
    h(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(208447);
      p.h(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      default: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.hVf);
        if (paramMenuItem != null)
        {
          paramMenuItem.bMo();
          AppMethodBeat.o(208447);
          return;
        }
        break;
      case 0: 
        AppMethodBeat.o(208447);
        return;
      case 1: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.hVf);
        if (paramMenuItem != null) {
          paramMenuItem.bMo();
        }
        LiveAnchorMicUserListView.a(this.hVf, false);
        AppMethodBeat.o(208447);
        return;
      }
      AppMethodBeat.o(208447);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class i
    implements e.b
  {
    i(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(208448);
      LiveAnchorMicUserListView.d(this.hVf);
      AppMethodBeat.o(208448);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.b<a.a, kotlin.x>
  {
    j(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class k
    implements i
  {
    k(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(208450);
      paramq.setHasCallbackToQueue(true);
      paramq = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.hVf.setMicPermission(true);
        this.hVf.aJf();
      }
      for (;;)
      {
        paramString = this.hVf.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.invoke(Boolean.valueOf(this.hVf.getMicPermission()));
        AppMethodBeat.o(208450);
        return;
        this.hVf.setMicPermission(false);
      }
      AppMethodBeat.o(208450);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Integer, Integer, kotlin.x>
  {
    l(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class m
    implements i
  {
    m(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(208452);
      paramq.setHasCallbackToQueue(true);
      paramq = com.tencent.mm.live.core.debug.a.hCA;
      com.tencent.mm.live.core.debug.a.au("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.hVf.setMicPermission(false);
        paramString = com.tencent.mm.live.b.x.hJf;
        com.tencent.mm.live.b.x.aHa().hKT.clear();
        this.hVf.aJf();
      }
      for (;;)
      {
        paramString = this.hVf.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.invoke(Boolean.valueOf(this.hVf.getMicPermission()));
        AppMethodBeat.o(208452);
        return;
        this.hVf.setMicPermission(true);
      }
      AppMethodBeat.o(208452);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView
 * JD-Core Version:    0.7.0.1
 */