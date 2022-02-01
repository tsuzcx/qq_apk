package com.tencent.mm.plugin.finder.viewmodel.component;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/IFinderDescPanelItem;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "descPanelUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDescPanelUIC;", "getDescPanelUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDescPanelUIC;", "descPanelUIC$delegate", "Lkotlin/Lazy;", "key", "", "getKey", "()I", "setKey", "(I)V", "adjustSeekLayout", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "disableTimer", "enableTimer", "getContentView", "Landroid/view/View;", "hide", "fromUser", "", "isNeedShow", "notifyShown", "onFocusFeed", "isFirstTime", "lastFeedId", "", "newFeedId", "pauseTimer", "resumeTimer", "show", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class bh
  extends UIComponent
{
  private final kotlin.j GWv = k.cm((a)new a(this));
  int key;
  
  public bh(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public abstract boolean R(com.tencent.mm.view.recyclerview.j paramj);
  
  public abstract View S(com.tencent.mm.view.recyclerview.j paramj);
  
  protected final void ab(com.tencent.mm.view.recyclerview.j paramj)
  {
    s.u(paramj, "holder");
    l locall = fpx();
    if (locall != null) {
      locall.L(paramj);
    }
  }
  
  public void b(com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    s.u(paramj, "holder");
  }
  
  public abstract void d(com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean);
  
  public abstract void e(com.tencent.mm.view.recyclerview.j paramj, boolean paramBoolean);
  
  final l fpx()
  {
    return (l)this.GWv.getValue();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderDescPanelUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<l>
  {
    a(bh parambh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.bh
 * JD-Core Version:    0.7.0.1
 */