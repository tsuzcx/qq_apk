package com.tencent.mm.plugin.finder.live.plugin;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.cgi.w;
import com.tencent.mm.plugin.finder.live.cgi.w.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.view.adapter.ai;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "clickArea", "Landroid/view/View;", "contentGroup", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "onRoleChooseListener", "Lkotlin/Function1;", "", "originStatusBarColor", "Ljava/lang/Integer;", "visitorCancel", "Landroid/widget/TextView;", "visitorRoleAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveVisitorRoleAdapter;", "visitorRv", "Landroidx/recyclerview/widget/RecyclerView;", "changeOrResetStatusBar", "isChange", "", "changeRole", "liveIdentity", "initView", "setVisitorRole", "aliasInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "show", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderVisitorRoleChooserPlugin
  extends RelativeLayout
{
  private RecyclerView DmN;
  private TextView DmO;
  private kotlin.g.a.b<? super Integer, ah> DmP;
  private Integer DmQ;
  private ai DmR;
  private final String TAG;
  private View clickArea;
  private LiveBottomSheetPanel niX;
  
  public FinderVisitorRoleChooserPlugin(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(355794);
    this.TAG = "FinderLiveVisitorRoleChooserPlugin";
    initView();
    AppMethodBeat.o(355794);
  }
  
  public FinderVisitorRoleChooserPlugin(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(355804);
    this.TAG = "FinderLiveVisitorRoleChooserPlugin";
    initView();
    AppMethodBeat.o(355804);
  }
  
  private static final void a(FinderVisitorRoleChooserPlugin paramFinderVisitorRoleChooserPlugin, View paramView)
  {
    AppMethodBeat.i(355885);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderVisitorRoleChooserPlugin);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderVisitorRoleChooserPlugin, "this$0");
    paramView = paramFinderVisitorRoleChooserPlugin.niX;
    if (paramView != null) {
      paramView.hide();
    }
    paramView = paramFinderVisitorRoleChooserPlugin.DmP;
    if (paramView != null)
    {
      paramFinderVisitorRoleChooserPlugin.esY();
      paramView.invoke(Integer.valueOf(h.baE().ban().getInt(at.a.adaO, 1)));
      paramFinderVisitorRoleChooserPlugin.DmP = null;
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355885);
  }
  
  private static final void b(FinderVisitorRoleChooserPlugin paramFinderVisitorRoleChooserPlugin, View paramView)
  {
    AppMethodBeat.i(355902);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderVisitorRoleChooserPlugin);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderVisitorRoleChooserPlugin, "this$0");
    paramView = paramFinderVisitorRoleChooserPlugin.niX;
    if (paramView != null) {
      paramView.hide();
    }
    paramView = paramFinderVisitorRoleChooserPlugin.DmP;
    if (paramView != null)
    {
      paramFinderVisitorRoleChooserPlugin.esY();
      paramView.invoke(Integer.valueOf(h.baE().ban().getInt(at.a.adaO, 1)));
      paramFinderVisitorRoleChooserPlugin.DmP = null;
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(355902);
  }
  
  private final void esY()
  {
    AppMethodBeat.i(355866);
    Object localObject = getContext();
    if ((localObject instanceof Activity)) {}
    for (;;)
    {
      if (localObject != null)
      {
        Integer localInteger = this.DmQ;
        if (localInteger != null)
        {
          int i = ((Number)localInteger).intValue();
          localObject = ((Activity)localObject).getWindow();
          s.s(localObject, "it as Activity).window");
          ((Window)localObject).setStatusBarColor(i);
        }
      }
      AppMethodBeat.o(355866);
      return;
      localObject = null;
    }
  }
  
  private final void initView()
  {
    AppMethodBeat.i(355828);
    setId(p.e.finder_choose_role);
    Object localObject1 = af.mU(getContext()).inflate(p.f.Cga, (ViewGroup)this);
    this.niX = ((LiveBottomSheetPanel)((View)localObject1).findViewById(p.e.Ccb));
    Object localObject2 = this.niX;
    if (localObject2 != null)
    {
      ((LiveBottomSheetPanel)localObject2).setTranslationY(bf.bf(((View)localObject1).getContext()).y);
      ((LiveBottomSheetPanel)localObject2).setOnVisibilityListener((kotlin.g.a.b)FinderVisitorRoleChooserPlugin.b.DmU);
    }
    this.clickArea = ((View)localObject1).findViewById(p.e.BBP);
    localObject2 = this.clickArea;
    if (localObject2 != null) {
      ((View)localObject2).setOnClickListener(new FinderVisitorRoleChooserPlugin..ExternalSyntheticLambda1(this));
    }
    this.DmN = ((RecyclerView)((View)localObject1).findViewById(p.e.visitor_rv));
    this.DmO = ((TextView)((View)localObject1).findViewById(p.e.BBU));
    localObject2 = this.DmO;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setOnClickListener(new FinderVisitorRoleChooserPlugin..ExternalSyntheticLambda0(this));
      localObject1 = ((TextView)localObject2).getLayoutParams();
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        break label310;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      if (localObject1 != null) {
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = bf.bk(((TextView)localObject2).getContext());
      }
    }
    this.DmR = new ai();
    localObject1 = this.DmR;
    if (localObject1 != null) {
      ((ai)localObject1).DTG = ((kotlin.g.a.b)new c(this));
    }
    localObject1 = this.DmN;
    if (localObject1 != null)
    {
      ((RecyclerView)localObject1).getContext();
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.DmR);
    }
    localObject1 = getContext();
    if (Boolean.valueOf(localObject1 instanceof Activity).booleanValue()) {
      label285:
      if (localObject1 != null) {
        break label320;
      }
    }
    label310:
    label320:
    for (localObject1 = null;; localObject1 = Integer.valueOf(((Activity)localObject1).getWindow().getStatusBarColor()))
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = null;
      }
      this.DmQ = ((Integer)localObject2);
      AppMethodBeat.o(355828);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label285;
    }
  }
  
  private final void setVisitorRole(bcz parambcz)
  {
    AppMethodBeat.i(355849);
    final int i = parambcz.ZNI;
    int j = h.baE().ban().getInt(at.a.adaO, 1);
    Log.i(this.TAG, "setVisitorRole chooseType:" + i + ", curRoleType:" + j);
    if (i != j)
    {
      parambcz = z.bAW();
      s.s(parambcz, "getMyFinderUsername()");
      new w(parambcz, i, (w.a)new a(this, i)).bFJ();
    }
    parambcz = this.DmP;
    if (parambcz != null)
    {
      esY();
      parambcz.invoke(Integer.valueOf(i));
      this.DmP = null;
    }
    AppMethodBeat.o(355849);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderVisitorRoleChooserPlugin$changeRole$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSwitchIdentity$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements w.a
  {
    a(FinderVisitorRoleChooserPlugin paramFinderVisitorRoleChooserPlugin, int paramInt) {}
    
    public final void a(bni parambni)
    {
      AppMethodBeat.i(353631);
      s.u(parambni, "resp");
      Log.i(this.DmS.getTAG(), "[CgiFinderLiveSwitchIdentity] success");
      d.uiThread((kotlin.g.a.a)new b(i, this.DmS));
      AppMethodBeat.o(353631);
    }
    
    public final void awj(String paramString)
    {
      AppMethodBeat.i(353636);
      Log.i(this.DmS.getTAG(), "[CgiFinderLiveSwitchIdentity] failed");
      d.uiThread((kotlin.g.a.a)new a(this.DmS));
      AppMethodBeat.o(353636);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderVisitorRoleChooserPlugin paramFinderVisitorRoleChooserPlugin)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(int paramInt, FinderVisitorRoleChooserPlugin paramFinderVisitorRoleChooserPlugin)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<bcz, ah>
  {
    c(FinderVisitorRoleChooserPlugin paramFinderVisitorRoleChooserPlugin)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.FinderVisitorRoleChooserPlugin
 * JD-Core Version:    0.7.0.1
 */