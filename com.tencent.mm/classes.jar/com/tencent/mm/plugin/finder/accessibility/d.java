package com.tencent.mm.plugin.finder.accessibility;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.h;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderCommonAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/IFinderCommonAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
  implements v
{
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(333936);
    AppMethodBeat.o(333936);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(333946);
    root(e.e.topic_container).view(e.e.topic_container).desc((b)new a(this)).expand(4, 4, 4, 4).disableChildren();
    root(e.e.feed_round_corner_media_item_container).view(e.e.feed_round_corner_media_item_container).desc((b)new b(this)).disableChildren();
    root(e.e.location_info_frame).view(e.e.location_navigate_iv).desc(e.h.finder_poi_navigation);
    root(e.e.fans_main_layout).view(e.e.fans_main_layout).desc(e.e.nickname_tv);
    root(e.e.finder_conversation_item_container).view(e.e.finder_conversation_item_container).desc((b)new c(this));
    AppMethodBeat.o(333946);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    c(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.d
 * JD-Core Version:    0.7.0.1
 */