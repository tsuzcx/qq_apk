package com.tencent.mm.plugin.finder.accessibility;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderLiveBaseAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "specialCommentMsgType", "", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public class j
  extends a
{
  public j(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(333992);
    AppMethodBeat.o(333992);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(334041);
    final Context localContext = MMApplicationContext.getContext();
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(p.e.live_title_ui_root);
    localConfigHelper.view(p.e.live_title_info_avatar_icon).desc(p.h.finder_live_title_avatar_desc).type(ViewType.TextView).disExpand();
    localConfigHelper.view(p.e.live_title_info_desc_group).disExpand();
    localConfigHelper.view(p.e.live_title_info_name_tv).disExpand().desc((b)new a(this, localContext));
    root(p.e.BOR).view(p.e.BOR).disableChildren().clickAs(p.e.BOQ).desc(p.h.finder_live_more_action_desc);
    root(p.e.live_visitor_close_ui_root).view(p.e.live_visitor_close_ui_root).disableChildren().clickAs(p.e.live_visitor_close_btn_group).desc(p.h.finder_live_close_live_desc);
    root(p.e.BXh).view(p.e.BXh).disableChildren().clickAs(p.e.BXg).desc(p.h.finder_live_mini_window_desc);
    root(p.e.live_common_info_ui_root).view(p.e.live_common_info_members_group).desc((b)new d(this, localContext)).disableChildren().disExpand();
    localConfigHelper = root(p.e.BJU);
    localConfigHelper.view(p.e.live_comment_item_content_tv).desc((b)new e(this, localContext));
    localConfigHelper.view(p.e.BJT).disable().disExpand();
    localConfigHelper.view(p.e.live_comment_list_tip_group).valueByView(p.e.live_comment_list_tip_tv).disableChildren();
    localConfigHelper.view(p.e.BBT).desc((b)new f(localContext));
    localConfigHelper = root(p.e.live_members_list_ui_root);
    localConfigHelper.view(p.e.BNQ).desc(p.h.finder_live_close_iv_desc);
    localConfigHelper.view(p.e.BNP).desc(p.h.finder_live_members_list_help_btn_desc);
    localConfigHelper.view(p.e.BMG).desc((b)new g(this, localContext));
    localConfigHelper = root(p.e.BNs);
    localConfigHelper.view(p.e.BNr).desc(p.h.finder_live_lottery_desc);
    localConfigHelper.view(p.e.lvD).disable();
    localConfigHelper = root(p.e.BNu);
    localConfigHelper.view(p.e.close).desc(p.h.finder_live_close_iv_desc).type(ViewType.TextView);
    localConfigHelper.view(p.e.BBD).disExpand();
    localConfigHelper.view(p.e.card).desc((b)new h(this, localContext));
    root(p.e.BOp).view(p.e.BOb).desc(p.h.finder_live_close_iv_desc);
    localConfigHelper = root(p.e.BSz);
    localConfigHelper.view(p.e.BSm).desc(p.h.finder_live_close_iv_desc);
    localConfigHelper.view(p.e.BSA).expand(12, 12, 12, 12);
    localConfigHelper.view(p.e.BSv).expand(12, 12, 12, 12);
    localConfigHelper = root(p.e.BSs);
    localConfigHelper.view(p.e.BSs).desc((b)new b(this, localContext));
    localConfigHelper.view(p.e.BZN).disable();
    localConfigHelper.view(p.e.BZM).disExpand();
    localConfigHelper = root(p.f.CfL);
    int i = bd.fromDPToPix(localContext, 8);
    localConfigHelper.view(p.e.close).desc(p.h.finder_live_close_iv_desc).type(ViewType.TextView).expand(i, i, i, i);
    localConfigHelper.view(p.e.BCk).desc(p.h.finder_live_close_iv_desc).type(ViewType.TextView);
    localConfigHelper.view(p.e.BSI).desc((b)new c(this, localContext));
    localConfigHelper.view(p.e.BZN).disable();
    root(p.f.mm_bottom_sheet_grid_menu_item).view(p.e.icon_bg).disable();
    root(p.e.live_common_info_ui_root).view(p.e.BKc).disable();
    root(p.e.BNE).view(p.e.BXR).desc(p.h.finder_live_lucky_money_desc);
    AppMethodBeat.o(334041);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(j paramj, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(j paramj, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    c(j paramj, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<View, String>
  {
    d(j paramj, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<View, String>
  {
    e(j paramj, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<View, String>
  {
    f(Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements b<View, String>
  {
    g(j paramj, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements b<View, String>
  {
    h(j paramj, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.j
 * JD-Core Version:    0.7.0.1
 */