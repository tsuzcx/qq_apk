package com.tencent.mm.plugin.finder.accessibility;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderProfileAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends a
{
  public o(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(334033);
    AppMethodBeat.o(334033);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(334047);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(e.f.finder_profile_ui_header);
    localConfigHelper.view(e.e.finder_profile_header_container).disable();
    localConfigHelper.view(e.e.finder_profile_avatar_container).desc(e.h.finder_avatar_desc).clickAs(e.e.finder_profile_avatar_btn).disableChildren();
    localConfigHelper.view(e.e.finder_profile_follow_btn).desc((b)new a(this));
    localConfigHelper.view(e.e.finder_profile_edit_ll).desc(e.h.finder_profile_edit_desc);
    localConfigHelper.view(e.e.sendMsgBtn).descFormat(e.h.finder_live_format_btn_desc).valueByView(e.e.finder_profile_send_msg_btn_tv);
    localConfigHelper.view(e.e.finder_profile_auth_accessibility_container).desc((b)new b(this)).disableChildren();
    localConfigHelper.view(e.e.finder_profile_friend_follow_layout).desc(e.e.finder_profile_friend_follow_tv).disableChildren();
    localConfigHelper.view(e.e.finder_profile_fans_layout).desc(e.e.finder_profile_fans_tv).disableChildren();
    localConfigHelper.view(e.e.media_entrance).desc(e.e.media_entrance_name).disableChildren();
    localConfigHelper.view(e.e.finder_profile_poi_layout).desc(e.e.finder_profile_poi_name).disableChildren();
    localConfigHelper.view(e.e.finder_profile_mini_program_layout).desc(e.e.finder_profile_mini_program_name).disableChildren();
    localConfigHelper.view(e.e.finder_profile_enterprise_add_layout).desc(e.e.finder_profile_enterprise_add_name).disableChildren();
    localConfigHelper.view(e.e.finder_live_notice_info_layout).desc((b)new c(this));
    localConfigHelper.view(e.e.finder_live_notice_btn).desc((b)new d(this));
    localConfigHelper.view(e.e.finder_live_op_btn).desc(e.h.finder_live_notice_more_action_desc);
    localConfigHelper.view(e.e.profile_activity_info_container).desc((b)new e(this));
    root(e.e.profile_media_item_container).view(e.e.profile_media_item_container).desc((b)new f(this));
    root(e.e.profile_qq_music_container).view(e.e.profile_qq_music_container).desc((b)new g(this));
    root(e.e.profile_music_container).view(e.e.profile_music_container).desc((b)new h(this));
    root(e.e.profile_draft_item_container).view(e.e.profile_draft_item_container).desc((b)new o.i(this));
    localConfigHelper = root(e.e.profile_feed_at_header_container);
    localConfigHelper.view(e.e.finder_profile_feed_at_item_text).desc((b)new j(this));
    localConfigHelper.view(e.e.profile_feed_at_more_text).desc(e.h.finder_profile_mentioned_more);
    root(e.e.profile_shop_item_container).view(e.e.profile_shop_item_container).desc((b)new o.k(this));
    localConfigHelper = root(e.e.myActionBar);
    localConfigHelper.view(e.e.postBtn).desc(e.h.finder_profile_post_btn_desc);
    localConfigHelper.view(e.e.moreBtn).desc(e.h.finder_profile_more_btn_desc);
    root(e.e.finder_grid_feed_item_layout_container).view(e.e.finder_grid_feed_item_layout_container).desc((b)new l(this));
    focusFirst(e.e.backBtn);
    focusOrder().next(e.e.backBtn).next(e.e.btn_group).next(e.e.finder_profile_avatar_container).next(e.e.finder_profile_name_tv);
    AppMethodBeat.o(334047);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    c(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<View, String>
  {
    d(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<View, String>
  {
    e(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<View, String>
  {
    f(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements b<View, String>
  {
    g(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements b<View, String>
  {
    h(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements b<View, String>
  {
    j(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements b<View, String>
  {
    l(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.o
 * JD-Core Version:    0.7.0.1
 */