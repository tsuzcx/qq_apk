package com.tencent.mm.live.ui.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.live.b.a.j;
import com.tencent.mm.live.b.b.a.a;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.h;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "acceptLiveMicListener", "Lkotlin/Function1;", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "Lkotlin/ParameterName;", "name", "user", "", "adapter", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "callMicListener", "Lkotlin/Function2;", "", "calling", "getCallMicListener", "()Lkotlin/jvm/functions/Function2;", "setCallMicListener", "(Lkotlin/jvm/functions/Function2;)V", "canSelectUser", "hideClickListener", "Lkotlin/Function0;", "getHideClickListener", "()Lkotlin/jvm/functions/Function0;", "setHideClickListener", "(Lkotlin/jvm/functions/Function0;)V", "micPermission", "getMicPermission", "()Z", "setMicPermission", "(Z)V", "micPermissionListener", "enable", "getMicPermissionListener", "()Lkotlin/jvm/functions/Function1;", "setMicPermissionListener", "(Lkotlin/jvm/functions/Function1;)V", "parent", "Landroid/view/View;", "getParent", "()Landroid/view/View;", "setParent", "(Landroid/view/View;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "selectUser", "stopLiveMicListener", "userListView", "Landroid/support/v7/widget/RecyclerView;", "waitingMic", "acceptMic", "anchorCloseMic", "callback", "errType", "errCode", "buildBottomSheet", "buildMicCallingItemData", "buildMicWaitingItemData", "users", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "buildNoPermissionItemData", "buildNoUserItemData", "buildPermissionItemData", "clearData", "loadOnlineMembers", "playMicHungUpVoice", "refreshListView", "refreshParentsView", "resetMicUser", "sdkStartMic", "setDefaultMicState", "updateMicPermission", "Companion", "LiveAnchorMicUserAdapter", "LiveMicListItem", "plugin-logic_release"})
public final class LiveAnchorMicUserListView
  extends RelativeLayout
{
  public static final a Kzf;
  private e IIx;
  private boolean KyU;
  private d.g.a.a<y> KyV;
  private m<? super Boolean, ? super a.a, y> KyW;
  private b<? super Boolean, y> KyX;
  private final RecyclerView KyY;
  public final b KyZ;
  private a.a Kza;
  private boolean Kzb;
  public boolean Kzc;
  private b<? super a.a, y> Kzd;
  private b<? super a.a, y> Kze;
  private View mZe;
  private final i sAC;
  
  static
  {
    AppMethodBeat.i(203347);
    Kzf = new a((byte)0);
    AppMethodBeat.o(203347);
  }
  
  public LiveAnchorMicUserListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203346);
    this.sAC = new i(aj.getContext());
    this.KyU = true;
    this.KyZ = new b();
    this.Kzb = true;
    this.Kzd = ((b)new d(this));
    this.Kze = ((b)new j(this));
    paramContext = LayoutInflater.from(paramContext).inflate(2131496287, (ViewGroup)this, true);
    d.g.b.k.g(paramContext, "LayoutInflater.from(cont…ic_list_view, this, true)");
    this.mZe = paramContext;
    this.mZe.findViewById(2131298372).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203309);
        paramAnonymousView = this.Kzg.getHideClickListener();
        if (paramAnonymousView != null)
        {
          paramAnonymousView.invoke();
          AppMethodBeat.o(203309);
          return;
        }
        AppMethodBeat.o(203309);
      }
    });
    paramContext = this.mZe.findViewById(2131307482);
    d.g.b.k.g(paramContext, "parent.findViewById(R.id.live_anchor_mic_list)");
    this.KyY = ((RecyclerView)paramContext);
    this.KyY.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    this.KyY.setAdapter((RecyclerView.a)this.KyZ);
    this.KyY.setItemViewCacheSize(0);
    AppMethodBeat.o(203346);
  }
  
  private final void aJ(ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(203343);
    Object localObject1 = this.KyZ.Kzh;
    Object localObject2 = z.Jhz;
    localObject2 = com.tencent.mm.cd.a.aq(getContext(), 2131766681);
    d.g.b.k.g(localObject2, "ResourceHelper.getString…ive_room_wait_mic_number)");
    Object localObject3 = f.rGw;
    localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { Integer.valueOf(f.fOz().ytb.size()) }, 1));
    d.g.b.k.g(localObject2, "java.lang.String.format(format, *args)");
    ((ArrayList)localObject1).add(new c(1, null, (String)localObject2, 2));
    localObject1 = ((Iterable)paramArrayList).iterator();
    label180:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a.a)((Iterator)localObject1).next();
      localObject3 = ((a.a)localObject2).CaG;
      paramArrayList = this.Kza;
      if (paramArrayList != null) {}
      for (paramArrayList = paramArrayList.CaG;; paramArrayList = null)
      {
        if (!(d.g.b.k.g(localObject3, paramArrayList) ^ true)) {
          break label180;
        }
        this.KyZ.Kzh.add(new c(2, (a.a)localObject2, null, 4));
        break;
      }
    }
    AppMethodBeat.o(203343);
  }
  
  private final void clearData()
  {
    AppMethodBeat.i(203340);
    this.KyZ.Kzh.clear();
    AppMethodBeat.o(203340);
  }
  
  private void fQs()
  {
    AppMethodBeat.i(203337);
    int i = com.tencent.mm.cd.a.hV(getContext());
    int j = com.tencent.mm.cd.a.hW(getContext());
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
      localLayoutParams.topMargin = com.tencent.mm.cd.a.g(localContext1, localContext2.getResources().getDimension(2131167037));
      this.mZe.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
      AppMethodBeat.o(203337);
      return;
    }
  }
  
  public static void fQu()
  {
    AppMethodBeat.i(203339);
    Object localObject1 = f.rGw;
    Object localObject2 = f.fOz().ytb;
    localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add(((a.a)((Iterator)localObject2).next()).CaG);
    }
    localObject2 = h.xfu;
    h.bG((List)localObject1);
    AppMethodBeat.o(203339);
  }
  
  private final void fQv()
  {
    AppMethodBeat.i(203341);
    this.KyZ.Kzh.add(new c(0, null, null, 6));
    AppMethodBeat.o(203341);
  }
  
  private final void fQw()
  {
    AppMethodBeat.i(203342);
    a.a locala = this.Kza;
    if (locala != null)
    {
      this.KyZ.Kzh.add(new c(1, null, com.tencent.mm.cd.a.aq(getContext(), 2131766646), 2));
      this.KyZ.Kzh.add(new c(3, locala, null, 4));
      AppMethodBeat.o(203342);
      return;
    }
    AppMethodBeat.o(203342);
  }
  
  private final void fQx()
  {
    AppMethodBeat.i(203344);
    this.KyZ.Kzh.add(new c(4, null, null, 6));
    AppMethodBeat.o(203344);
  }
  
  private final void fQy()
  {
    AppMethodBeat.i(203345);
    this.KyZ.Kzh.add(new c(5, null, null, 6));
    AppMethodBeat.o(203345);
  }
  
  private void h(final m<? super Integer, ? super Integer, y> paramm)
  {
    AppMethodBeat.i(203335);
    a.a locala = this.Kza;
    if (locala != null)
    {
      Object localObject = com.tencent.mm.live.core.debug.a.qOL;
      com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "[cgi]anchor close mic.".concat(String.valueOf(locala)));
      localObject = f.rGw;
      long l = f.eNG().LwA;
      localObject = f.rGw;
      localObject = new j(l, f.eNB(), String.valueOf(System.currentTimeMillis()), locala.BQP, locala.Csx);
      q localq = com.tencent.mm.kernel.g.aeS();
      d.g.b.k.g(localq, "MMKernel.getNetSceneQueue()");
      ((j)localObject).doScene(localq.aeW(), (com.tencent.mm.al.g)new f(locala, this, paramm));
      AppMethodBeat.o(203335);
      return;
    }
    AppMethodBeat.o(203335);
  }
  
  public final void fQq()
  {
    AppMethodBeat.i(203334);
    this.sAC.Y(true, 1);
    AppMethodBeat.o(203334);
  }
  
  public final void fQr()
  {
    this.Kzb = true;
    this.Kza = null;
  }
  
  public final void fQt()
  {
    AppMethodBeat.i(203338);
    fQs();
    clearData();
    fQv();
    if (this.Kza != null) {
      fQw();
    }
    if (this.KyU)
    {
      Object localObject = f.rGw;
      localObject = f.fOz().ytb;
      Collection localCollection = (Collection)localObject;
      a.a locala = this.Kza;
      if (localCollection == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(203338);
        throw ((Throwable)localObject);
      }
      aa.eL(localCollection).remove(locala);
      if (((ArrayList)localObject).size() > 0) {
        aJ((ArrayList)localObject);
      }
    }
    for (;;)
    {
      this.KyZ.notifyDataSetChanged();
      AppMethodBeat.o(203338);
      return;
      if (this.Kza == null)
      {
        fQx();
        continue;
        fQy();
      }
    }
  }
  
  public final m<Boolean, a.a, y> getCallMicListener()
  {
    return this.KyW;
  }
  
  public final d.g.a.a<y> getHideClickListener()
  {
    return this.KyV;
  }
  
  public final boolean getMicPermission()
  {
    return this.KyU;
  }
  
  public final b<Boolean, y> getMicPermissionListener()
  {
    return this.KyX;
  }
  
  public final View getParent()
  {
    return this.mZe;
  }
  
  public final void setCallMicListener(m<? super Boolean, ? super a.a, y> paramm)
  {
    this.KyW = paramm;
  }
  
  public final void setDefaultMicState(boolean paramBoolean)
  {
    this.KyU = paramBoolean;
  }
  
  public final void setHideClickListener(d.g.a.a<y> parama)
  {
    this.KyV = parama;
  }
  
  public final void setMicPermission(boolean paramBoolean)
  {
    this.KyU = paramBoolean;
  }
  
  public final void setMicPermissionListener(b<? super Boolean, y> paramb)
  {
    this.KyX = paramb;
  }
  
  public final void setParent(View paramView)
  {
    AppMethodBeat.i(203333);
    d.g.b.k.h(paramView, "<set-?>");
    this.mZe = paramView;
    AppMethodBeat.o(203333);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$Companion;", "", "()V", "MIC_ACCEPT", "", "MIC_CALLING", "MIC_NO_DATA", "MIC_NO_PERMISSION", "MIC_PERMISSION", "MIC_TITLE", "plugin-logic_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView;)V", "liveMicItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "Lkotlin/collections/ArrayList;", "getLiveMicItems", "()Ljava/util/ArrayList;", "setLiveMicItems", "(Ljava/util/ArrayList;)V", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "", "uid", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "loadUserInfo", "itemView", "Landroid/view/View;", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-logic_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    ArrayList<LiveAnchorMicUserListView.c> Kzh;
    
    public b()
    {
      AppMethodBeat.i(203318);
      this.Kzh = new ArrayList();
      AppMethodBeat.o(203318);
    }
    
    private static void a(View paramView, a.a parama)
    {
      AppMethodBeat.i(203317);
      Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "service<IMessengerStorag…engerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apM().aHY(parama.CaG);
      a.b.d((ImageView)paramView.findViewById(2131307490), parama.CaG, 0.1F);
      paramView = paramView.findViewById(2131307494);
      d.g.b.k.g(paramView, "itemView.findViewById<Te…ive_anchor_mic_user_name)");
      paramView = (TextView)paramView;
      d.g.b.k.g(localObject, "contact");
      paramView.setText((CharSequence)((af)localObject).Su());
      AppMethodBeat.o(203317);
    }
    
    public final RecyclerView.v a(final ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(203313);
      d.g.b.k.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        paramViewGroup = (RecyclerView.v)new j(this, paramViewGroup, LayoutInflater.from(this.Kzg.getContext()).inflate(2131496286, paramViewGroup, false));
        AppMethodBeat.o(203313);
        return paramViewGroup;
      case 0: 
        paramViewGroup = (RecyclerView.v)new d(this, paramViewGroup, LayoutInflater.from(this.Kzg.getContext()).inflate(2131496285, paramViewGroup, false));
        AppMethodBeat.o(203313);
        return paramViewGroup;
      case 1: 
        paramViewGroup = (RecyclerView.v)new e(this, paramViewGroup, LayoutInflater.from(this.Kzg.getContext()).inflate(2131496286, paramViewGroup, false));
        AppMethodBeat.o(203313);
        return paramViewGroup;
      case 2: 
        paramViewGroup = (RecyclerView.v)new f(this, paramViewGroup, LayoutInflater.from(this.Kzg.getContext()).inflate(2131496281, paramViewGroup, false));
        AppMethodBeat.o(203313);
        return paramViewGroup;
      case 3: 
        paramViewGroup = (RecyclerView.v)new g(this, paramViewGroup, LayoutInflater.from(this.Kzg.getContext()).inflate(2131496282, paramViewGroup, false));
        AppMethodBeat.o(203313);
        return paramViewGroup;
      case 4: 
        paramViewGroup = (RecyclerView.v)new h(this, paramViewGroup, LayoutInflater.from(this.Kzg.getContext()).inflate(2131496283, paramViewGroup, false));
        AppMethodBeat.o(203313);
        return paramViewGroup;
      }
      paramViewGroup = (RecyclerView.v)new i(this, paramViewGroup, LayoutInflater.from(this.Kzg.getContext()).inflate(2131496284, paramViewGroup, false));
      AppMethodBeat.o(203313);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(203315);
      d.g.b.k.h(paramv, "holder");
      switch (getItemViewType(paramInt))
      {
      default: 
      case 0: 
      case 1: 
      case 2: 
        for (;;)
        {
          paramv = paramv.arI;
          d.g.b.k.g(paramv, "holder.itemView");
          if (!LiveAnchorMicUserListView.e(this.Kzg)) {
            break;
          }
          paramv.setAlpha(1.0F);
          paramv.setEnabled(true);
          AppMethodBeat.o(203315);
          return;
          localObject1 = (MMSwitchBtn)paramv.arI.findViewById(2131307498);
          ((TextView)paramv.arI.findViewById(2131307499)).setOnClickListener((View.OnClickListener)new a(this));
          d.g.b.k.g(localObject1, "switchView");
          ((MMSwitchBtn)localObject1).setCheck(this.Kzg.getMicPermission());
          continue;
          localObject1 = paramv.arI;
          if (localObject1 == null)
          {
            paramv = new v("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(203315);
            throw paramv;
          }
          ((TextView)localObject1).setText((CharSequence)((LiveAnchorMicUserListView.c)this.Kzh.get(paramInt)).title);
          continue;
          localObject1 = ((LiveAnchorMicUserListView.c)this.Kzh.get(paramInt)).Kzk;
          if (localObject1 != null)
          {
            localObject2 = paramv.arI;
            d.g.b.k.g(localObject2, "holder.itemView");
            a((View)localObject2, (a.a)localObject1);
          }
          ((TextView)paramv.arI.findViewById(2131307609)).setOnClickListener((View.OnClickListener)new b(this, paramInt));
        }
      }
      Object localObject1 = ((LiveAnchorMicUserListView.c)this.Kzh.get(paramInt)).Kzk;
      if (localObject1 != null)
      {
        localObject2 = paramv.arI;
        d.g.b.k.g(localObject2, "holder.itemView");
        a((View)localObject2, (a.a)localObject1);
      }
      localObject1 = (ImageView)paramv.arI.findViewById(2131307630);
      Object localObject2 = (ImageView)paramv.arI.findViewById(2131307631);
      if (LiveAnchorMicUserListView.f(this.Kzg))
      {
        d.g.b.k.g(localObject2, "maskView");
        ((ImageView)localObject2).setVisibility(0);
        d.g.b.k.g(localObject1, "loadingView");
        ((ImageView)localObject1).setVisibility(0);
        localObject2 = ((ImageView)localObject1).getBackground();
        if (localObject2 == null)
        {
          paramv = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(203315);
          throw paramv;
        }
        ((AnimationDrawable)localObject2).stop();
        localObject1 = ((ImageView)localObject1).getBackground();
        if (localObject1 == null)
        {
          paramv = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(203315);
          throw paramv;
        }
        ((AnimationDrawable)localObject1).start();
      }
      for (;;)
      {
        ((TextView)paramv.arI.findViewById(2131307623)).setOnClickListener((View.OnClickListener)new c(this, paramInt));
        break;
        d.g.b.k.g(localObject2, "maskView");
        ((ImageView)localObject2).setVisibility(4);
        d.g.b.k.g(localObject1, "loadingView");
        ((ImageView)localObject1).setVisibility(4);
        localObject1 = ((ImageView)localObject1).getBackground();
        if (localObject1 == null)
        {
          paramv = new v("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
          AppMethodBeat.o(203315);
          throw paramv;
        }
        ((AnimationDrawable)localObject1).stop();
      }
      if (paramInt >= 3)
      {
        paramv.setAlpha(0.3F);
        paramv.setEnabled(false);
      }
      AppMethodBeat.o(203315);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(203314);
      int i = this.Kzh.size();
      AppMethodBeat.o(203314);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(203316);
      paramInt = ((LiveAnchorMicUserListView.c)this.Kzh.get(paramInt)).type;
      AppMethodBeat.o(203316);
      return paramInt;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(LiveAnchorMicUserListView.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(203310);
        if (this.Kzi.Kzg.getMicPermission())
        {
          LiveAnchorMicUserListView.b(this.Kzi.Kzg);
          paramView = LiveAnchorMicUserListView.c(this.Kzi.Kzg);
          if (paramView != null)
          {
            paramView.csG();
            AppMethodBeat.o(203310);
            return;
          }
          AppMethodBeat.o(203310);
          return;
        }
        LiveAnchorMicUserListView.a(this.Kzi.Kzg, true);
        AppMethodBeat.o(203310);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(203311);
        if (LiveAnchorMicUserListView.e(this.Kzi.Kzg))
        {
          LiveAnchorMicUserListView.g(this.Kzi.Kzg);
          LiveAnchorMicUserListView.h(this.Kzi.Kzg).aA(((LiveAnchorMicUserListView.c)this.Kzi.Kzh.get(paramInt)).Kzk);
        }
        AppMethodBeat.o(203311);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(LiveAnchorMicUserListView.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(203312);
        LiveAnchorMicUserListView.i(this.Kzi.Kzg).aA(((LiveAnchorMicUserListView.c)this.Kzi.Kzh.get(paramInt)).Kzk);
        AppMethodBeat.o(203312);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$1", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class d
      extends RecyclerView.v
    {
      d(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$2", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class e
      extends RecyclerView.v
    {
      e(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$3", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class f
      extends RecyclerView.v
    {
      f(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$4", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class g
      extends RecyclerView.v
    {
      g(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$5", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class h
      extends RecyclerView.v
    {
      h(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$6", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class i
      extends RecyclerView.v
    {
      i(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveAnchorMicUserAdapter$onCreateViewHolder$7", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "plugin-logic_release"})
    public static final class j
      extends RecyclerView.v
    {
      j(ViewGroup paramViewGroup, View paramView)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "", "type", "", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "title", "", "(ILcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getUser", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "setUser", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
  public static final class c
  {
    a.a Kzk;
    String title;
    int type;
    
    private c(int paramInt, a.a parama, String paramString)
    {
      this.type = paramInt;
      this.Kzk = parama;
      this.title = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203322);
      if (this != paramObject)
      {
        if ((paramObject instanceof c))
        {
          paramObject = (c)paramObject;
          if ((this.type != paramObject.type) || (!d.g.b.k.g(this.Kzk, paramObject.Kzk)) || (!d.g.b.k.g(this.title, paramObject.title))) {}
        }
      }
      else
      {
        AppMethodBeat.o(203322);
        return true;
      }
      AppMethodBeat.o(203322);
      return false;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(203321);
      int k = this.type;
      Object localObject = this.Kzk;
      if (localObject != null) {}
      for (int i = localObject.hashCode();; i = 0)
      {
        localObject = this.title;
        if (localObject != null) {
          j = localObject.hashCode();
        }
        AppMethodBeat.o(203321);
        return (i + k * 31) * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203320);
      String str = "LiveMicListItem(type=" + this.type + ", user=" + this.Kzk + ", title=" + this.title + ")";
      AppMethodBeat.o(203320);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<a.a, y>
  {
    d(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class e
    implements com.tencent.mm.al.g
  {
    e(LiveAnchorMicUserListView paramLiveAnchorMicUserListView, a.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(203324);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.qOL;
      com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "[cgi]accept mic errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        LiveAnchorMicUserListView.j(this.Kzg).Y(true, 1);
        paramString = f.rGw;
        f.fOz().a(this.Kzl);
        AppMethodBeat.o(203324);
        return;
      }
      t.makeText(this.Kzg.getContext(), (CharSequence)com.tencent.mm.cd.a.aq(this.Kzg.getContext(), 2131766645), 0).show();
      LiveAnchorMicUserListView.b(this.Kzg, true);
      paramString = this.Kzg.getCallMicListener();
      if (paramString != null) {
        paramString.n(Boolean.FALSE, null);
      }
      this.Kzg.fQt();
      AppMethodBeat.o(203324);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd", "com/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$anchorCloseMic$1$1"})
  static final class f
    implements com.tencent.mm.al.g
  {
    f(a.a parama, LiveAnchorMicUserListView paramLiveAnchorMicUserListView, m paramm) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(203325);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.qOL;
      com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "[cgi-ret]anchor close mic :" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        jdField_this.fQq();
      }
      if (paramm == null)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = f.rGw;
          f.fOz().ytb.remove(this.Kzm);
          jdField_this.fQr();
          paramString = f.rGw;
          f.fOz().fOJ();
          jdField_this.fQt();
          paramString = jdField_this.getCallMicListener();
          if (paramString != null)
          {
            paramString.n(Boolean.FALSE, null);
            AppMethodBeat.o(203325);
            return;
          }
          AppMethodBeat.o(203325);
        }
      }
      else {
        paramm.n(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
      }
      AppMethodBeat.o(203325);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class g
    implements n.c
  {
    g(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(203326);
      Object localObject = LiveAnchorMicUserListView.c(this.Kzg);
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paraml.clear();
      localObject = this.Kzg.getContext();
      d.g.b.k.g(localObject, "context");
      int i = ((Context)localObject).getResources().getColor(2131099662);
      localObject = this.Kzg.getContext();
      d.g.b.k.g(localObject, "context");
      paraml.a(0, i, (CharSequence)((Context)localObject).getResources().getString(2131766650));
      localObject = this.Kzg.getContext();
      d.g.b.k.g(localObject, "context");
      i = ((Context)localObject).getResources().getColor(2131101208);
      localObject = this.Kzg.getContext();
      d.g.b.k.g(localObject, "context");
      paraml.a(1, i, (CharSequence)((Context)localObject).getResources().getString(2131766649));
      AppMethodBeat.o(203326);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "i", "", "onMMMenuItemSelected"})
  static final class h
    implements n.d
  {
    h(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(203327);
      d.g.b.k.h(paramMenuItem, "menuItem");
      switch (paramInt)
      {
      default: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.Kzg);
        if (paramMenuItem != null)
        {
          paramMenuItem.bfo();
          AppMethodBeat.o(203327);
          return;
        }
        break;
      case 0: 
        AppMethodBeat.o(203327);
        return;
      case 1: 
        paramMenuItem = LiveAnchorMicUserListView.c(this.Kzg);
        if (paramMenuItem != null) {
          paramMenuItem.bfo();
        }
        LiveAnchorMicUserListView.a(this.Kzg, false);
        AppMethodBeat.o(203327);
        return;
      }
      AppMethodBeat.o(203327);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onDismiss"})
  static final class i
    implements e.b
  {
    i(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(203328);
      LiveAnchorMicUserListView.d(this.Kzg);
      AppMethodBeat.o(203328);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "invoke"})
  static final class j
    extends d.g.b.l
    implements b<a.a, y>
  {
    j(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class k
    implements com.tencent.mm.al.g
  {
    k(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(203330);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.qOL;
      com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Kzg.setMicPermission(true);
        this.Kzg.fQt();
      }
      for (;;)
      {
        paramString = this.Kzg.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.aA(Boolean.valueOf(this.Kzg.getMicPermission()));
        AppMethodBeat.o(203330);
        return;
        this.Kzg.setMicPermission(false);
      }
      AppMethodBeat.o(203330);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "invoke"})
  static final class l
    extends d.g.b.l
    implements m<Integer, Integer, y>
  {
    l(LiveAnchorMicUserListView paramLiveAnchorMicUserListView)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class m
    implements com.tencent.mm.al.g
  {
    m(LiveAnchorMicUserListView paramLiveAnchorMicUserListView) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(203332);
      paramn.setHasCallbackToQueue(true);
      paramn = com.tencent.mm.live.core.debug.a.qOL;
      com.tencent.mm.live.core.debug.a.bZ("MicroMsg.LiveCoreMic", "anchor close mic permission:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.Kzg.setMicPermission(false);
        paramString = f.rGw;
        f.fOz().ytb.clear();
        this.Kzg.fQt();
      }
      for (;;)
      {
        paramString = this.Kzg.getMicPermissionListener();
        if (paramString == null) {
          break;
        }
        paramString.aA(Boolean.valueOf(this.Kzg.getMicPermission()));
        AppMethodBeat.o(203332);
        return;
        this.Kzg.setMicPermission(true);
      }
      AppMethodBeat.o(203332);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView
 * JD-Core Version:    0.7.0.1
 */