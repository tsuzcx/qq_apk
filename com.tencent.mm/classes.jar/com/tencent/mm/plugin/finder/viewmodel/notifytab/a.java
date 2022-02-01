package com.tencent.mm.plugin.finder.viewmodel.notifytab;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.finder.report.j;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.tabcomp.c;
import com.tencent.mm.plugin.finder.view.tabcomp.e;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStateCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderNotifyUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderNotifyUIC.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/notifytab/FinderNotifyTab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "lastTabIndex", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "tabRedText", "Landroid/widget/TextView;", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "firstValidUnSelect", "getLastSelectTabIndex", "getLayoutId", "getTabMargin", "", "onTabInflated", "setTabRedDot", "redDotText", "", "isTabSelected", "", "plugin-finder_release"})
public final class a
  extends c
{
  private TextView wBM;
  private k wBN;
  private bdo wBO;
  private final int wyL;
  
  public a(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(256110);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    this.wyL = ((FinderTabStateCacheVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStateCacheVM.class)).dHU();
    AppMethodBeat.o(256110);
  }
  
  public final void by(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(256107);
    TextView localTextView = this.wBM;
    if (localTextView != null)
    {
      if (Util.isNullOrNil(paramString))
      {
        localTextView.setVisibility(4);
        localTextView.setText((CharSequence)"");
        AppMethodBeat.o(256107);
        return;
      }
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)paramString);
      AppMethodBeat.o(256107);
      return;
    }
    AppMethodBeat.o(256107);
  }
  
  public final int[] cXC()
  {
    return new int[] { 0, 4 };
  }
  
  public final int dHM()
  {
    return this.wyL;
  }
  
  public final int getLayoutId()
  {
    return 2131494541;
  }
  
  public final void t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(256109);
    p.h(paramViewGroup, "tabView");
    super.t(paramViewGroup);
    Object localObject1;
    bdo localbdo;
    if ((paramViewGroup.getContext() instanceof MMActivity))
    {
      localObject1 = y.vXH;
      localObject1 = this.wBN;
      localbdo = this.wBO;
      paramViewGroup = paramViewGroup.getContext();
      if (paramViewGroup == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(256109);
        throw paramViewGroup;
      }
      paramViewGroup = (MMActivity)paramViewGroup;
      if ((localObject1 != null) && (localbdo != null) && (paramViewGroup != null))
      {
        Object localObject2 = j.vft;
        localObject2 = FinderReporterUIC.wzC;
        paramViewGroup = FinderReporterUIC.a.fH((Context)paramViewGroup);
        if (paramViewGroup == null) {
          break label129;
        }
      }
    }
    label129:
    for (paramViewGroup = paramViewGroup.dIx();; paramViewGroup = null)
    {
      j.a("5", (k)localObject1, localbdo, 3, paramViewGroup, 0, 0, 96);
      AppMethodBeat.o(256109);
      return;
    }
  }
  
  public final void u(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(256106);
    if (paramViewGroup != null)
    {
      this.titleTv = ((TextView)paramViewGroup.findViewById(2131308826));
      this.wBM = ((TextView)paramViewGroup.findViewById(2131308824));
    }
    Log.i("Finder.FinderTab", "onTabInflated lastTabIndex:" + this.wyL + " index:" + this.index);
    if (this.wyL != this.index)
    {
      paramViewGroup = FinderNotifyUIC.wyQ;
      paramViewGroup = FinderNotifyUIC.a.My(this.index);
      com.tencent.mm.kernel.b.a locala = g.ah(PluginFinder.class);
      p.g(locala, "MMKernel.plugin(PluginFinder::class.java)");
      this.wBN = ((PluginFinder)locala).getRedDotManager().asX(paramViewGroup);
      locala = g.ah(PluginFinder.class);
      p.g(locala, "MMKernel.plugin(PluginFinder::class.java)");
      this.wBO = ((PluginFinder)locala).getRedDotManager().asW(paramViewGroup);
    }
    AppMethodBeat.o(256106);
  }
  
  public final void v(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(256108);
    p.h(paramViewGroup, "tabView");
    super.v(paramViewGroup);
    paramViewGroup = e.wtE;
    Log.i(e.access$getTAG$cp(), "onTabUnSelected real");
    by("", true);
    paramViewGroup = g.ah(PluginFinder.class);
    p.g(paramViewGroup, "MMKernel.plugin(PluginFinder::class.java)");
    paramViewGroup = ((PluginFinder)paramViewGroup).getRedDotManager();
    FinderNotifyUIC.a locala = FinderNotifyUIC.wyQ;
    paramViewGroup.asV(FinderNotifyUIC.a.My(this.index));
    AppMethodBeat.o(256108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.notifytab.a
 * JD-Core Version:    0.7.0.1
 */