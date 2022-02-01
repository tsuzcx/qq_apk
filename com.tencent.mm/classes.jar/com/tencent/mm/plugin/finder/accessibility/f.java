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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderDrawerAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/IFinderDrawerAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
  implements w
{
  public f(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(333995);
    AppMethodBeat.o(333995);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(334009);
    root(e.e.drawer_comment_header_container).view(e.e.close_area_layout).desc(e.h.close_btn);
    Object localObject = root(e.e.feed_comment_layout);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(e.e.feed_comment_layout).desc((b)new a(this));
    localObject = ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(e.e.commend_content);
    ((ViewSetter)localObject).disable();
    ((ViewSetter)localObject).disableChildren();
    localObject = root(e.e.feed_comment_layout_level2);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(e.e.feed_comment_layout_level2).desc((b)new f.b(this));
    localObject = ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(e.e.commend_content);
    ((ViewSetter)localObject).disable();
    ((ViewSetter)localObject).disableChildren();
    localObject = root(e.e.comment_et_layout);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(e.e.comment_et_container).desc((b)new c(this)).disableChildren();
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(e.e.comment_switch_scene_click_layout).desc((b)new d(this)).disableChildren();
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(e.e.smiley_btn).desc(e.h.chat_footer_smiley_btn);
    localObject = root(e.e.drawer_like_header_container);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(e.e.close_area_layout).desc(e.h.close_btn);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(e.e.drawer_more_op).desc(e.h.finder_dont_see_video_he_liked);
    root(e.e.finder_liked_list_item_container).view(e.e.finder_unliked_layout).desc((b)new e(this)).disableChildren();
    AppMethodBeat.o(334009);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<View, String>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<View, String>
  {
    e(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.f
 * JD-Core Version:    0.7.0.1
 */