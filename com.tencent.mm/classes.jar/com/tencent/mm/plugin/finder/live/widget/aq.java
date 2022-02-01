package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShadeView;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicBottomStateWidget;", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveMicStateWidget;", "root", "Landroid/view/ViewGroup;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "shadeView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShadeView;)V", "confirmBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "micBottomActionCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "itemId", "", "micBottomClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "buildMicBottomActionSheet", "callback", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "refreshMuteState", "showToast", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class aq
  extends as
{
  public static final aq.a Esr = new aq.a((byte)0);
  private f Ess;
  private kotlin.g.a.b<? super Integer, ah> Est;
  private u.i Esu = new aq..ExternalSyntheticLambda1(this);
  
  public aq(ViewGroup paramViewGroup, com.tencent.mm.plugin.finder.live.plugin.b paramb, FinderLiveShadeView paramFinderLiveShadeView)
  {
    super(paramViewGroup, paramb, paramFinderLiveShadeView);
  }
  
  private static final void a(aq paramaq, MenuItem paramMenuItem, int paramInt)
  {
    kotlin.g.b.s.u(paramaq, "this$0");
    kotlin.g.a.b localb = paramaq.Est;
    if (localb != null) {
      if (paramMenuItem != null) {
        break label46;
      }
    }
    label46:
    for (paramInt = -1;; paramInt = paramMenuItem.getItemId())
    {
      localb.invoke(Integer.valueOf(paramInt));
      paramaq = paramaq.Ess;
      if (paramaq != null) {
        paramaq.cyW();
      }
      return;
    }
  }
  
  private static final void a(aq paramaq, com.tencent.mm.ui.base.s params)
  {
    kotlin.g.b.s.u(paramaq, "this$0");
    f localf = paramaq.Ess;
    if (localf != null) {
      localf.setFooterView(null);
    }
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    params.a(1, paramaq.mJe.getContext().getResources().getColor(p.b.live_title_host_close_btn_color), (CharSequence)paramaq.mJe.getContext().getResources().getString(p.h.ClF));
  }
  
  private static final void b(aq paramaq)
  {
    kotlin.g.b.s.u(paramaq, "this$0");
    paramaq.Ess = null;
  }
  
  protected final void ar(kotlin.g.a.b<? super Integer, ah> paramb)
  {
    if (this.Ess == null)
    {
      this.Ess = new f(this.mJe.getContext(), 1, true);
      localf = this.Ess;
      if (localf != null) {
        localf.NyV = true;
      }
    }
    f localf = this.Ess;
    if (localf != null) {
      localf.NE(true);
    }
    localf = this.Ess;
    if (localf != null) {
      localf.agfb = true;
    }
    localf = this.Ess;
    if (localf != null) {
      localf.Vtg = new aq..ExternalSyntheticLambda0(this);
    }
    localf = this.Ess;
    if (localf != null) {
      localf.GAC = this.Esu;
    }
    localf = this.Ess;
    if (localf != null) {
      localf.aeLi = new aq..ExternalSyntheticLambda2(this);
    }
    this.Est = paramb;
    paramb = this.Ess;
    if (paramb != null) {
      paramb.dDn();
    }
  }
  
  public abstract void sD(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.aq
 * JD-Core Version:    0.7.0.1
 */