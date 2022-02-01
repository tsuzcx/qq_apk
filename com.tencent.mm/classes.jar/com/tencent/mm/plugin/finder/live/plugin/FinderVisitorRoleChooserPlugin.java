package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.live.cgi.m;
import com.tencent.mm.plugin.finder.live.cgi.m.a;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bcy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "clickArea", "Landroid/view/View;", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "onRoleChooseListener", "Lkotlin/Function1;", "", "originStatusBarColor", "Ljava/lang/Integer;", "visitorCancel", "Landroid/widget/TextView;", "visitorRoleAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;", "visitorRv", "Landroidx/recyclerview/widget/RecyclerView;", "changeOrResetStatusBar", "isChange", "", "changeRole", "liveIdentity", "initView", "setVisitorRole", "aliasInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "show", "plugin-finder_release"})
public final class FinderVisitorRoleChooserPlugin
  extends RelativeLayout
{
  private final String TAG;
  private View clickArea;
  private LiveBottomSheetPanel kFV;
  private RecyclerView yzR;
  private TextView yzS;
  private kotlin.g.a.b<? super Integer, x> yzT;
  private Integer yzU;
  private com.tencent.mm.plugin.finder.live.view.adapter.z yzV;
  
  public FinderVisitorRoleChooserPlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(277606);
    this.TAG = "FinderLiveVisitorRoleChooserPlugin";
    initView();
    AppMethodBeat.o(277606);
  }
  
  public FinderVisitorRoleChooserPlugin(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(277607);
    this.TAG = "FinderLiveVisitorRoleChooserPlugin";
    initView();
    AppMethodBeat.o(277607);
  }
  
  private final void dCZ()
  {
    AppMethodBeat.i(277605);
    Object localObject = getContext();
    if ((localObject instanceof Activity)) {}
    while (localObject != null)
    {
      Integer localInteger = this.yzU;
      if (localInteger != null)
      {
        int i = ((Number)localInteger).intValue();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(277605);
          throw ((Throwable)localObject);
          localObject = null;
        }
        else
        {
          localObject = ((Activity)localObject).getWindow();
          p.j(localObject, "(it as Activity).window");
          ((Window)localObject).setStatusBarColor(i);
          AppMethodBeat.o(277605);
        }
      }
      else
      {
        AppMethodBeat.o(277605);
        return;
      }
    }
    AppMethodBeat.o(277605);
  }
  
  private final void initView()
  {
    Integer localInteger = null;
    AppMethodBeat.i(277602);
    setId(b.f.finder_choose_role);
    Object localObject1 = ad.kS(getContext()).inflate(b.g.finder_live_visitor_role_choose_ui, (ViewGroup)this);
    this.kFV = ((LiveBottomSheetPanel)((View)localObject1).findViewById(b.f.visitor_role_choose_group));
    Object localObject2 = this.kFV;
    if (localObject2 != null)
    {
      p.j(localObject1, "root");
      ((LiveBottomSheetPanel)localObject2).setTranslationY(ax.au(((View)localObject1).getContext()).y);
      ((LiveBottomSheetPanel)localObject2).setOnVisibilityListener((kotlin.g.a.b)FinderVisitorRoleChooserPlugin.d.yAa);
    }
    this.clickArea = ((View)localObject1).findViewById(b.f.blank_area);
    localObject2 = this.clickArea;
    if (localObject2 != null) {
      ((View)localObject2).setOnClickListener((View.OnClickListener)new e(this));
    }
    this.yzR = ((RecyclerView)((View)localObject1).findViewById(b.f.visitor_rv));
    this.yzS = ((TextView)((View)localObject1).findViewById(b.f.cancel_tv));
    TextView localTextView = this.yzS;
    if (localTextView != null)
    {
      localTextView.setOnClickListener((View.OnClickListener)new b(this));
      localObject2 = localTextView.getLayoutParams();
      localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      if (localObject1 != null) {
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = ax.aB(localTextView.getContext());
      }
    }
    this.yzV = new com.tencent.mm.plugin.finder.live.view.adapter.z();
    localObject1 = this.yzV;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.finder.live.view.adapter.z)localObject1).yZZ = ((kotlin.g.a.b)new c(this));
    }
    localObject1 = this.yzR;
    if (localObject1 != null)
    {
      ((RecyclerView)localObject1).getContext();
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.yzV);
    }
    localObject1 = getContext();
    if ((localObject1 instanceof Activity)) {}
    while (localObject1 != null) {
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.app.Activity");
        AppMethodBeat.o(277602);
        throw ((Throwable)localObject1);
        localObject1 = null;
      }
      else
      {
        localObject1 = ((Activity)localObject1).getWindow();
        p.j(localObject1, "(it as Activity).window");
        localInteger = Integer.valueOf(((Window)localObject1).getStatusBarColor());
      }
    }
    this.yzU = localInteger;
    AppMethodBeat.o(277602);
  }
  
  private final void setVisitorRole(axc paramaxc)
  {
    AppMethodBeat.i(277603);
    final int i = paramaxc.SJy;
    paramaxc = h.aHG();
    p.j(paramaxc, "MMKernel.storage()");
    int j = paramaxc.aHp().getInt(ar.a.VyS, 1);
    Log.i(this.TAG, "setVisitorRole chooseType:" + i + ", curRoleType:" + j);
    if (i != j)
    {
      paramaxc = com.tencent.mm.model.z.bdh();
      p.j(paramaxc, "ConfigStorageLogic.getMyFinderUsername()");
      new m(paramaxc, i, (m.a)new a(this, i)).bhW();
    }
    paramaxc = this.yzT;
    if (paramaxc != null)
    {
      dCZ();
      paramaxc.invoke(Integer.valueOf(i));
      this.yzT = null;
      AppMethodBeat.o(277603);
      return;
    }
    AppMethodBeat.o(277603);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin$changeRole$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSwitchIdentity$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityResponse;", "plugin-finder_release"})
  public static final class a
    implements m.a
  {
    a(int paramInt) {}
    
    public final void a(bcy parambcy)
    {
      AppMethodBeat.i(279687);
      p.k(parambcy, "resp");
      Log.i(this.yzW.getTAG(), "[CgiFinderLiveSwitchIdentity] success");
      d.uiThread((kotlin.g.a.a)new b(this));
      AppMethodBeat.o(279687);
    }
    
    public final void aBO(String paramString)
    {
      AppMethodBeat.i(279688);
      Log.i(this.yzW.getTAG(), "[CgiFinderLiveSwitchIdentity] failed");
      d.uiThread((kotlin.g.a.a)new a(this));
      AppMethodBeat.o(279688);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderVisitorRoleChooserPlugin.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(FinderVisitorRoleChooserPlugin.a parama)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin$initView$3$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderVisitorRoleChooserPlugin paramFinderVisitorRoleChooserPlugin) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279193);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = FinderVisitorRoleChooserPlugin.a(this.yzW);
      if (paramView != null) {
        paramView.hide();
      }
      paramView = FinderVisitorRoleChooserPlugin.b(this.yzW);
      if (paramView != null)
      {
        FinderVisitorRoleChooserPlugin.d(this.yzW);
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        paramView.invoke(Integer.valueOf(((f)localObject).aHp().getInt(ar.a.VyS, 1)));
        FinderVisitorRoleChooserPlugin.c(this.yzW);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(279193);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin$initView$4$1"})
  static final class c
    extends q
    implements kotlin.g.a.b<axc, x>
  {
    c(FinderVisitorRoleChooserPlugin paramFinderVisitorRoleChooserPlugin)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderVisitorRoleChooserPlugin paramFinderVisitorRoleChooserPlugin) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(283884);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = FinderVisitorRoleChooserPlugin.a(this.yzW);
      if (paramView != null) {
        paramView.hide();
      }
      paramView = FinderVisitorRoleChooserPlugin.b(this.yzW);
      if (paramView != null)
      {
        FinderVisitorRoleChooserPlugin.d(this.yzW);
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        paramView.invoke(Integer.valueOf(((f)localObject).aHp().getInt(ar.a.VyS, 1)));
        FinderVisitorRoleChooserPlugin.c(this.yzW);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(283884);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.FinderVisitorRoleChooserPlugin
 * JD-Core Version:    0.7.0.1
 */