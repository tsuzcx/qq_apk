package com.tencent.mm.plugin.finder.wxmessage;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.viewmodel.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/wxmessage/FinderWxNotifyTab;", "Lcom/tencent/mm/plugin/finder/viewmodel/notifytab/FinderNotifyTab;", "titleId", "", "(I)V", "lastTabIndex", "getLastTabIndex", "()I", "firstValidUnSelect", "", "tabView", "Landroid/view/ViewGroup;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.finder.viewmodel.notifytab.a
{
  public static final a Hbq;
  private final int GSt;
  
  static
  {
    AppMethodBeat.i(332443);
    Hbq = new a((byte)0);
    AppMethodBeat.o(332443);
  }
  
  public b(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(332437);
    k localk = k.aeZF;
    this.GSt = ((m)k.cn(PluginFinder.class).q(m.class)).Va(1);
    AppMethodBeat.o(332437);
  }
  
  public final void J(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(332457);
    s.u(paramViewGroup, "tabView");
    super.J(paramViewGroup);
    Log.i("Finder.FinderWxNotifyTab", "onTabUnSelected real");
    aCK("");
    paramViewGroup = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
    a.a locala = a.Hbp;
    paramViewGroup.TL("");
    AppMethodBeat.o(332457);
  }
  
  public final int fpy()
  {
    return this.GSt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/wxmessage/FinderWxNotifyTab$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.wxmessage.b
 * JD-Core Version:    0.7.0.1
 */