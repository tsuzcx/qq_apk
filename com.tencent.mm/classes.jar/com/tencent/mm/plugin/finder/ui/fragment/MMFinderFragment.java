package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.findersdk.a.bh;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.mm.ui.component.l;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/fragment/MMFinderFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "()V", "enablePullDown", "", "getCommentScene", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class MMFinderFragment
  extends UIComponentFragment
{
  public int getCommentScene()
  {
    return 0;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    s.u(paramLayoutInflater, "inflater");
    this.rootView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    return this.rootView;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    d.a(0L, (a)new a(this));
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(l.a(ai.cz(bh.class)));
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(MMFinderFragment paramMMFinderFragment)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.fragment.MMFinderFragment
 * JD-Core Version:    0.7.0.1
 */