package com.tencent.mm.plugin.finder.accessibility;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderSearchAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends a
{
  public q(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(334021);
    AppMethodBeat.o(334021);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(334032);
    root(e.e.finder_search_history_item).view(e.e.close_iv).desc(e.h.finder_clear_search_history);
    root(e.e.finder_search_history_item).view(e.e.finder_search_history_item).desc((b)new a(this));
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(e.e.more_view);
    localConfigHelper.view(e.e.more_view).desc(e.h.finder_title);
    localConfigHelper.view(e.e.more_action_container).desc(e.h.finder_more_account);
    root(e.e.finder_mix_search_media_item_container).view(e.e.finder_mix_search_media_item_container).desc((b)new b(this)).disableChildren();
    focusFirst(e.e.more_view);
    focusOrder().next(e.e.more_view).next(e.e.more_action_container).next(e.e.history_lv).next(e.e.suggestion_lv);
    AppMethodBeat.o(334032);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(q paramq)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.q
 * JD-Core Version:    0.7.0.1
 */