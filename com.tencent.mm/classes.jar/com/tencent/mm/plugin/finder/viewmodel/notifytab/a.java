package com.tencent.mm.plugin.finder.viewmodel.notifytab;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.extension.reddot.p;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.view.tabcomp.d;
import com.tencent.mm.plugin.finder.viewmodel.component.an;
import com.tencent.mm.plugin.finder.viewmodel.component.an.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/notifytab/FinderNotifyTab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderAlignTab;", "titleId", "", "(I)V", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "getCtrlInfo", "()Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "setCtrlInfo", "(Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;)V", "lastTabIndex", "getLastTabIndex", "()I", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "getShowInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "setShowInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;)V", "tabAnchor", "Landroid/view/View;", "tabRedText", "Landroid/widget/TextView;", "underLineStartView", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "firstValidUnSelect", "getAlignView", "getLastSelectTabIndex", "getLayoutId", "getTabMargin", "", "getUnderLineEndView", "getUnderLineStartView", "initRedDotInfo", "onTabInflated", "setTabRedDot", "redDotText", "", "isTabSelected", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends d
{
  private final int GSt;
  private View GWA;
  private View GWB;
  private TextView GWx;
  private p GWy;
  private bxq GWz;
  
  public a(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(337378);
    k localk = k.aeZF;
    this.GSt = ((com.tencent.mm.plugin.finder.viewmodel.g)k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.g.class)).Va(1);
    AppMethodBeat.o(337378);
  }
  
  public final void F(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(337435);
    s.u(paramViewGroup, "tabView");
    super.F(paramViewGroup);
    Object localObject1;
    bxq localbxq;
    Object localObject2;
    if ((paramViewGroup.getContext() instanceof MMActivity))
    {
      localObject1 = av.GiL;
      localObject1 = this.GWy;
      localbxq = this.GWz;
      paramViewGroup = paramViewGroup.getContext();
      if (paramViewGroup == null)
      {
        paramViewGroup = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(337435);
        throw paramViewGroup;
      }
      paramViewGroup = (MMActivity)paramViewGroup;
      localObject2 = aw.Gjk;
      if ((localObject1 != null) && (localbxq != null))
      {
        localObject2 = w.FrV;
        as.a locala = as.GSQ;
        paramViewGroup = as.a.hu((Context)paramViewGroup);
        if (paramViewGroup != null) {
          break label131;
        }
      }
    }
    label131:
    for (paramViewGroup = null;; paramViewGroup = paramViewGroup.fou())
    {
      w.a((w)localObject2, "5", (p)localObject1, localbxq, 3, paramViewGroup, 0, null, 0, 480);
      AppMethodBeat.o(337435);
      return;
    }
  }
  
  public final void H(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(337398);
    Object localObject;
    if (paramViewGroup != null)
    {
      setTitleTv((TextView)paramViewGroup.findViewById(e.e.tabTitle));
      this.GWx = ((TextView)paramViewGroup.findViewById(e.e.tabRedText));
      this.GWB = paramViewGroup.findViewById(e.e.finder_tab_anchor);
      localObject = getTitleTv();
      if (localObject != null) {
        ((TextView)localObject).setTextSize(1, 15.0F);
      }
      localObject = this.GWx;
      if (localObject != null) {
        ((TextView)localObject).setTextSize(1, 12.0F);
      }
    }
    if (paramViewGroup != null)
    {
      localObject = paramViewGroup.getContext();
      s.s(localObject, "it.context");
      paramViewGroup.setContentDescription((CharSequence)ht((Context)localObject));
    }
    Log.i("Finder.FinderTab", "onTabInflated lastTabIndex:" + fpy() + " index:" + this.index);
    if (fpy() != this.index)
    {
      localObject = an.GSs;
      localObject = an.a.Vk(this.index);
      this.GWy = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su((String)localObject);
      this.GWz = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp((String)localObject);
    }
    this.GWA = ((View)paramViewGroup);
    I(paramViewGroup);
    AppMethodBeat.o(337398);
  }
  
  public void J(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(337426);
    s.u(paramViewGroup, "tabView");
    super.J(paramViewGroup);
    Log.i("Finder.FinderTab", "onTabUnSelected real");
    aCK("");
    paramViewGroup = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
    an.a locala = an.GSs;
    paramViewGroup.TL(an.a.Vk(this.index));
    AppMethodBeat.o(337426);
  }
  
  public final void aCK(String paramString)
  {
    AppMethodBeat.i(337404);
    TextView localTextView = this.GWx;
    if (localTextView != null)
    {
      if (Util.isNullOrNil(paramString))
      {
        localTextView.setVisibility(4);
        localTextView.setText((CharSequence)"");
        AppMethodBeat.o(337404);
        return;
      }
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)paramString);
    }
    AppMethodBeat.o(337404);
  }
  
  public final int[] dTO()
  {
    return new int[] { 0, 0 };
  }
  
  public final int fmD()
  {
    AppMethodBeat.i(337439);
    int i = fpy();
    AppMethodBeat.o(337439);
    return i;
  }
  
  public final View fmp()
  {
    return this.GWA;
  }
  
  public final View fmq()
  {
    return this.GWB;
  }
  
  public final View fmr()
  {
    AppMethodBeat.i(337417);
    View localView = (View)getTitleTv();
    AppMethodBeat.o(337417);
    return localView;
  }
  
  protected int fpy()
  {
    return this.GSt;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_msg_notify_tab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.notifytab.a
 * JD-Core Version:    0.7.0.1
 */