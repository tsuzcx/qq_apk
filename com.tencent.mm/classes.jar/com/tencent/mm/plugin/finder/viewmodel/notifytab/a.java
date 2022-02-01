package com.tencent.mm.plugin.finder.viewmodel.notifytab;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.view.tabcomp.c;
import com.tencent.mm.plugin.finder.viewmodel.component.ag;
import com.tencent.mm.plugin.finder.viewmodel.component.ag.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/notifytab/FinderNotifyTab;", "Lcom/tencent/mm/plugin/finder/view/tabcomp/FinderTab;", "titleId", "", "(I)V", "ctrlInfo", "Lcom/tencent/mm/plugin/finder/extension/reddot/LocalFinderRedDotCtrInfo;", "lastTabIndex", "showInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTipsShowInfo;", "tabRedText", "Landroid/widget/TextView;", "firstValidSelect", "", "tabView", "Landroid/view/ViewGroup;", "firstValidUnSelect", "getLastSelectTabIndex", "getLayoutId", "getTabMargin", "", "onTabInflated", "setTabRedDot", "redDotText", "", "isTabSelected", "", "plugin-finder_release"})
public final class a
  extends c
{
  private final int Bmy;
  private TextView BpP;
  private com.tencent.mm.plugin.finder.extension.reddot.l BpQ;
  private bkn BpR;
  
  public a(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(274849);
    g localg = g.Xox;
    this.Bmy = ((com.tencent.mm.plugin.finder.viewmodel.e)g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.e.class)).eke();
    AppMethodBeat.o(274849);
  }
  
  public final void A(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(274845);
    p.k(paramViewGroup, "tabView");
    super.A(paramViewGroup);
    paramViewGroup = com.tencent.mm.plugin.finder.view.tabcomp.e.BfV;
    Log.i(com.tencent.mm.plugin.finder.view.tabcomp.e.access$getTAG$cp(), "onTabUnSelected real");
    aGC("");
    paramViewGroup = h.ag(PluginFinder.class);
    p.j(paramViewGroup, "MMKernel.plugin(PluginFinder::class.java)");
    paramViewGroup = ((PluginFinder)paramViewGroup).getRedDotManager();
    ag.a locala = ag.BmD;
    paramViewGroup.aBd(ag.a.RS(this.index));
    AppMethodBeat.o(274845);
  }
  
  public final void aGC(String paramString)
  {
    AppMethodBeat.i(274844);
    TextView localTextView = this.BpP;
    if (localTextView != null)
    {
      if (Util.isNullOrNil(paramString))
      {
        localTextView.setVisibility(4);
        localTextView.setText((CharSequence)"");
        AppMethodBeat.o(274844);
        return;
      }
      localTextView.setVisibility(0);
      localTextView.setText((CharSequence)paramString);
      AppMethodBeat.o(274844);
      return;
    }
    AppMethodBeat.o(274844);
  }
  
  public final int[] dmU()
  {
    return new int[] { 0, 4 };
  }
  
  public final int ejX()
  {
    return this.Bmy;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_msg_notify_tab;
  }
  
  public final void y(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(274846);
    p.k(paramViewGroup, "tabView");
    super.y(paramViewGroup);
    Object localObject1;
    bkn localbkn;
    if ((paramViewGroup.getContext() instanceof MMActivity))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject1 = this.BpQ;
      localbkn = this.BpR;
      paramViewGroup = paramViewGroup.getContext();
      if (paramViewGroup == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(274846);
        throw paramViewGroup;
      }
      paramViewGroup = (MMActivity)paramViewGroup;
      if ((localObject1 != null) && (localbkn != null) && (paramViewGroup != null))
      {
        Object localObject2 = com.tencent.mm.plugin.finder.report.l.zWx;
        localObject2 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramViewGroup = aj.a.fZ((Context)paramViewGroup);
        if (paramViewGroup == null) {
          break label131;
        }
      }
    }
    label131:
    for (paramViewGroup = paramViewGroup.ekY();; paramViewGroup = null)
    {
      com.tencent.mm.plugin.finder.report.l.a("5", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject1, localbkn, 3, paramViewGroup, 0, 0, null, 224);
      AppMethodBeat.o(274846);
      return;
    }
  }
  
  public final void z(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(274843);
    if (paramViewGroup != null)
    {
      w((TextView)paramViewGroup.findViewById(b.f.tabTitle));
      this.BpP = ((TextView)paramViewGroup.findViewById(b.f.tabRedText));
    }
    Log.i("Finder.FinderTab", "onTabInflated lastTabIndex:" + this.Bmy + " index:" + this.index);
    if (this.Bmy != this.index)
    {
      paramViewGroup = ag.BmD;
      paramViewGroup = ag.a.RS(this.index);
      com.tencent.mm.kernel.b.a locala = h.ag(PluginFinder.class);
      p.j(locala, "MMKernel.plugin(PluginFinder::class.java)");
      this.BpQ = ((PluginFinder)locala).getRedDotManager().aBf(paramViewGroup);
      locala = h.ag(PluginFinder.class);
      p.j(locala, "MMKernel.plugin(PluginFinder::class.java)");
      this.BpR = ((PluginFinder)locala).getRedDotManager().aBe(paramViewGroup);
    }
    AppMethodBeat.o(274843);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.notifytab.a
 * JD-Core Version:    0.7.0.1
 */