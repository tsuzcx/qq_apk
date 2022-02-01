package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.live.model.l.k;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.view.adapter.n;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.a.h.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.d;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveBaseWidget;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_PANEL_HEIGHT", "", "backBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "backImage", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog;", "clickArea", "contentArea", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "empty", "Landroid/widget/TextView;", "fansList", "Landroidx/recyclerview/widget/RecyclerView;", "fansListAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFansListAdapter;", "fansName", "infoGroup", "isLand", "", "lastBottomSheet", "listBottomPage", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget$ListBottomPage;", "getListBottomPage", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget$ListBottomPage;", "listBottomPage$delegate", "Lkotlin/Lazy;", "loading", "Landroid/widget/ProgressBar;", "loadingMore", "modifyTv", "modifyWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansModifyWidget;", "value", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetFanClubMembersResponse;", "resp", "setResp", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveGetFanClubMembersResponse;)V", "root", "showModify", "setShowModify", "(Z)V", "titleGroup", "titleTv", "adjustShowModifyView", "", "hide", "initContent", "initListener", "loadMembers", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lkotlin/ParameterName;", "name", "modifyFansName", "onClick", "v", "onKeyboardHeightChanged", "height", "show", "pop", "showPanel", "tryLoadMore", "lastVisiblePosition", "unMount", "updateContent", "updateFansListLayoutParams", "Companion", "ListBottomPage", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends p
  implements View.OnClickListener
{
  public static final a EpD;
  private boolean CVX;
  private int CwP;
  private final View CxW;
  private final LiveBottomSheetPanel EoS;
  private com.tencent.mm.ui.widget.a.h EpE;
  private final kotlin.j EpF;
  private final boolean EpG;
  private final View EpH;
  private final WeImageView EpI;
  private final TextView EpJ;
  private final TextView EpK;
  private final TextView EpL;
  private final RecyclerView EpM;
  private ab EpN;
  private n EpO;
  private bhr EpP;
  private boolean EpQ;
  private com.tencent.mm.ui.widget.a.h Epc;
  private final View clickArea;
  private final View lBX;
  private final View njm;
  private final ProgressBar sIX;
  private final TextView titleTv;
  
  static
  {
    AppMethodBeat.i(361924);
    EpD = new a((byte)0);
    AppMethodBeat.o(361924);
  }
  
  public aa(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(361781);
    this.EpF = kotlin.k.cm((kotlin.g.a.a)new f(this));
    boolean bool;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      bool = true;
      this.EpG = bool;
      if (!this.EpG) {
        break label523;
      }
    }
    label523:
    float f;
    for (int i = (int)(kotlin.k.k.bu(getHEIGHT(), getWIDTH()) - MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_3A));; i = (int)(f * (com.tencent.d.a.a.a.a.a.jTt() / 100.0F)))
    {
      this.CwP = i;
      paramContext = LayoutInflater.from(paramContext).inflate(p.f.CdH, (ViewGroup)this, true);
      s.s(paramContext, "from(context).inflate(R.…st_widget_ui, this, true)");
      this.lBX = paramContext;
      this.clickArea = this.lBX.findViewById(p.e.BDv);
      this.EoS = ((LiveBottomSheetPanel)this.lBX.findViewById(p.e.BDw));
      this.sIX = ((ProgressBar)this.EoS.findViewById(p.e.BDC));
      this.njm = this.EoS.findViewById(p.e.BDF);
      this.EpH = this.EoS.findViewById(p.e.BDB);
      this.CxW = this.EoS.findViewById(p.e.BDA);
      this.EpI = ((WeImageView)this.EoS.findViewById(p.e.BDz));
      this.titleTv = ((TextView)this.EoS.findViewById(p.e.BDG));
      this.EpJ = ((TextView)this.EoS.findViewById(p.e.BDD));
      this.EpK = ((TextView)this.EoS.findViewById(p.e.BDE));
      this.EpL = ((TextView)this.EoS.findViewById(p.e.BDy));
      this.EpM = ((RecyclerView)this.EoS.findViewById(p.e.BDx));
      paramContext = new n();
      paramContext.nod = ((kotlin.g.a.b)c.EpS);
      Object localObject = ah.aiuX;
      this.EpO = paramContext;
      paramContext = this.EoS;
      paramContext.getLayoutParams().height = this.CwP;
      paramContext.setOnVisibilityListener((kotlin.g.a.b)new d(this));
      paramContext = this.EpM;
      this.lBX.getContext();
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      paramContext.setAdapter((RecyclerView.a)this.EpO);
      paramContext.a((RecyclerView.l)new e(this));
      this.clickArea.setOnClickListener((View.OnClickListener)this);
      this.EoS.setOnClickListener((View.OnClickListener)this);
      this.CxW.setOnClickListener((View.OnClickListener)this);
      this.EpJ.setOnClickListener((View.OnClickListener)this);
      Log.i("FinderLiveFansListWidget", "init isLand:" + this.EpG + ", DEFAULT_PANEL_HEIGHT:" + this.CwP);
      AppMethodBeat.o(361781);
      return;
      bool = false;
      break;
      f = getHEIGHT();
      localObject = com.tencent.d.a.a.a.a.a.ahiX;
    }
  }
  
  private static final ah a(aa paramaa, kotlin.g.a.b paramb, b.a parama)
  {
    AppMethodBeat.i(361861);
    s.u(paramaa, "this$0");
    s.u(paramb, "$callback");
    paramaa.sIX.setVisibility(8);
    s.s(parama, "it");
    paramb.invoke(parama);
    paramaa = ah.aiuX;
    AppMethodBeat.o(361861);
    return paramaa;
  }
  
  private final void a(com.tencent.mm.ui.widget.a.h paramh)
  {
    AppMethodBeat.i(361852);
    if (paramh == null)
    {
      paramh = new com.tencent.mm.ui.widget.a.h(this.lBX.getContext());
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.gg(this.lBX);
      paramh.d(this.lBX, new FrameLayout.LayoutParams(-1, -1));
      paramh.fkh();
      paramh.dDn();
      localObject = ah.aiuX;
      this.Epc = paramh;
      AppMethodBeat.o(361852);
      return;
    }
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.gg((View)this);
    paramh.a((h.b)getListBottomPage());
    AppMethodBeat.o(361852);
  }
  
  private final void aq(kotlin.g.a.b<? super b.a<bhr>, ah> paramb)
  {
    Object localObject2 = null;
    long l2 = 0L;
    AppMethodBeat.i(361831);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    int i;
    label56:
    com.tencent.mm.bx.b localb;
    long l1;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      localObject1 = l.k.mYO;
      i = l.k.bhG();
      localObject1 = aj.CGT;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 != null) {
        break label180;
      }
      localObject1 = null;
      localb = com.tencent.mm.bx.b.cX((byte[])localObject1);
      localObject1 = aj.CGT;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 != null) {
        break label190;
      }
      l1 = 0L;
      label86:
      localObject1 = aj.CGT;
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 != null) {
        break label216;
      }
      label107:
      localObject1 = this.EpP;
      if (localObject1 != null) {
        break label226;
      }
    }
    label180:
    label190:
    label216:
    label226:
    for (localObject1 = localObject2;; localObject1 = ((bhr)localObject1).ZEQ)
    {
      this.sIX.setVisibility(0);
      new com.tencent.mm.plugin.finder.live.cgi.j(localb, l1, l2, (com.tencent.mm.bx.b)localObject1, i).bFJ().g(new aa..ExternalSyntheticLambda0(this, paramb));
      AppMethodBeat.o(361831);
      return;
      localObject1 = l.k.mYO;
      i = l.k.bhH();
      break;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).mZp;
      break label56;
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        l1 = 0L;
        break label86;
      }
      l1 = ((bip)localObject1).liveId;
      break label86;
      l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).hKN;
      break label107;
    }
  }
  
  private final void eAJ()
  {
    AppMethodBeat.i(361810);
    if (this.EpQ)
    {
      this.EpJ.setVisibility(0);
      this.EpH.setVisibility(0);
      this.titleTv.setVisibility(8);
      AppMethodBeat.o(361810);
      return;
    }
    this.EpJ.setVisibility(8);
    this.EpH.setVisibility(8);
    this.titleTv.setVisibility(0);
    AppMethodBeat.o(361810);
  }
  
  private final void eAK()
  {
    Object localObject2 = null;
    AppMethodBeat.i(361818);
    RecyclerView localRecyclerView = this.EpM;
    Object localObject1 = this.njm.getLayoutParams();
    int j;
    label50:
    int k;
    label89:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label168;
      }
      j = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_8A);
      k = bf.bk(this.lBX.getContext());
      if (this.EpH.getVisibility() != 0) {
        break label199;
      }
      localObject1 = this.EpH.getLayoutParams();
      if (localObject1 != null) {
        break label177;
      }
      localObject1 = localObject2;
      if (localObject1 != null) {
        break label190;
      }
      i = d.e(MMApplicationContext.getContext(), 150.0F);
    }
    for (;;)
    {
      localRecyclerView.getLayoutParams().height = (this.CwP - k - j - i);
      localObject1 = localRecyclerView.getLayoutParams();
      if (localObject1 != null) {
        break label204;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(361818);
      throw ((Throwable)localObject1);
      localObject1 = Integer.valueOf(((ViewGroup.LayoutParams)localObject1).height);
      break;
      label168:
      j = ((Integer)localObject1).intValue();
      break label50;
      label177:
      localObject1 = Integer.valueOf(((ViewGroup.LayoutParams)localObject1).height);
      break label89;
      label190:
      i = ((Integer)localObject1).intValue();
      continue;
      label199:
      i = 0;
    }
    label204:
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin += k;
    AppMethodBeat.o(361818);
  }
  
  private final void eAL()
  {
    AppMethodBeat.i(361841);
    aq((kotlin.g.a.b)new i(this));
    if (this.EpE == null)
    {
      this.EpI.setRotation(90.0F);
      AppMethodBeat.o(361841);
      return;
    }
    this.CxW.setRotation(180.0F);
    AppMethodBeat.o(361841);
  }
  
  private final b getListBottomPage()
  {
    AppMethodBeat.i(361788);
    b localb = (b)this.EpF.getValue();
    AppMethodBeat.o(361788);
    return localb;
  }
  
  private final void setResp(bhr parambhr)
  {
    AppMethodBeat.i(361793);
    if (parambhr == null) {}
    for (Object localObject = "";; localObject = parambhr)
    {
      Log.i("FinderLiveFansListWidget", String.valueOf(com.tencent.mm.ae.f.dg(localObject)));
      this.EpP = parambhr;
      AppMethodBeat.o(361793);
      return;
    }
  }
  
  private final void setShowModify(boolean paramBoolean)
  {
    AppMethodBeat.i(361802);
    Log.i("FinderLiveFansListWidget", s.X("showModify:", Boolean.valueOf(paramBoolean)));
    this.EpQ = paramBoolean;
    AppMethodBeat.o(361802);
  }
  
  public final void a(com.tencent.mm.ui.widget.a.h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(361940);
    setShowModify(paramBoolean);
    this.EpE = paramh;
    eAJ();
    eAK();
    eAL();
    a(paramh);
    paramh = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      paramh = g.ElM;
      g.a.report("4");
    }
    AppMethodBeat.o(361940);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(361947);
    com.tencent.mm.ui.widget.a.h localh;
    if (this.EpE == null)
    {
      localh = this.Epc;
      if (localh != null) {
        localh.cyW();
      }
      this.Epc = null;
    }
    for (;;)
    {
      this.EoS.setTranslationY(0.0F);
      AppMethodBeat.o(361947);
      return;
      localh = getListBottomPage().JfN;
      if (localh != null) {
        localh.cyW();
      }
      this.EpE = null;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(361975);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = p.e.BDv;
      if (paramView != null) {
        break label103;
      }
      label53:
      i = p.e.BDA;
      if (paramView != null) {
        break label118;
      }
      label61:
      i = p.e.BDD;
      if (paramView != null) {
        break label163;
      }
    }
    label103:
    label118:
    while (paramView.intValue() != i) {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(361975);
        return;
        paramView = Integer.valueOf(paramView.getId());
        break;
        if (paramView.intValue() != i) {
          break label53;
        }
        hide();
        continue;
        if (paramView.intValue() != i) {
          break label61;
        }
        if (this.EpE == null)
        {
          hide();
        }
        else
        {
          getListBottomPage().jHR();
          this.EpE = null;
          this.EoS.setTranslationY(0.0F);
        }
      }
    }
    label163:
    if (this.EpN == null)
    {
      paramView = getContext();
      s.s(paramView, "context");
      paramView = new ab(paramView);
      paramView.setBackClickListener((kotlin.g.a.a)new g(this));
      localObject = ah.aiuX;
      this.EpN = paramView;
    }
    paramView = getBasePlugin();
    if (paramView != null)
    {
      localObject = this.EpN;
      if (localObject != null) {
        ((ab)localObject).c(paramView);
      }
    }
    ab localab = this.EpN;
    com.tencent.mm.ui.widget.a.h localh;
    if (localab != null)
    {
      localh = this.Epc;
      paramView = aj.CGT;
      paramView = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.h)aj.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.h.class);
      if (paramView != null) {
        break label350;
      }
      paramView = "";
    }
    for (;;)
    {
      localab.EpZ = paramView;
      localab.EoT.setHint((CharSequence)localab.EpZ);
      paramView = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.gg((View)localab);
      if (localh != null) {
        localh.a((h.b)localab.getModifyBottomPage());
      }
      paramView = g.ElM;
      g.a.report("5");
      break;
      label350:
      paramView = paramView.Efg;
      if (paramView == null)
      {
        paramView = "";
      }
      else
      {
        localObject = paramView.ZQn;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
      }
    }
  }
  
  public final void sA(boolean paramBoolean)
  {
    AppMethodBeat.i(361961);
    ab localab = this.EpN;
    if (localab != null) {
      localab.sA(paramBoolean);
    }
    AppMethodBeat.o(361961);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(361953);
    super.unMount();
    hide();
    ab localab = this.EpN;
    if (localab != null) {
      localab.unMount();
    }
    this.EoS.setOnVisibilityListener(null);
    AppMethodBeat.o(361953);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget$Companion;", "", "()V", "LOAD_MORE_THRESHOLD", "", "TAG", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget$ListBottomPage;", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog$CustomBottomSheetPage;", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget;)V", "getView", "Landroid/view/View;", "root", "Landroid/view/ViewGroup;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends h.b
  {
    public b()
    {
      AppMethodBeat.i(362084);
      AppMethodBeat.o(362084);
    }
    
    public final View E(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(362093);
      s.u(paramViewGroup, "root");
      paramViewGroup = (View)this.EpR;
      AppMethodBeat.o(362093);
      return paramViewGroup;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<bgh, ah>
  {
    public static final c EpS;
    
    static
    {
      AppMethodBeat.i(362059);
      EpS = new c();
      AppMethodBeat.o(362059);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "show", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    d(aa paramaa)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget$initContent$2$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    e(aa paramaa) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(362045);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget$initContent$2$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      s.u(paramRecyclerView, "recyclerView");
      localObject = aa.c(this.EpR);
      if ((localObject != null) && (((bhr)localObject).BeA == 1)) {
        paramInt = 1;
      }
      while ((paramInt != 0) && (!aa.d(this.EpR)))
      {
        localObject = this.EpR;
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView == null)
        {
          paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
          AppMethodBeat.o(362045);
          throw paramRecyclerView;
          paramInt = 0;
        }
        else
        {
          aa.a((aa)localObject, ((LinearLayoutManager)paramRecyclerView).Jx());
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget$initContent$2$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(362045);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(362050);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget$initContent$2$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget$initContent$2$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(362050);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget$ListBottomPage;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveFansListWidget;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<aa.b>
  {
    f(aa paramaa)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(aa paramaa)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetFanClubMembersResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<b.a<bhr>, ah>
  {
    h(aa paramaa)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetFanClubMembersResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<b.a<bhr>, ah>
  {
    i(aa paramaa)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.aa
 * JD-Core Version:    0.7.0.1
 */