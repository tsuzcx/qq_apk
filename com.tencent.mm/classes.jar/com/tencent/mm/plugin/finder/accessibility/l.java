package com.tencent.mm.plugin.finder.accessibility;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderLiveVisitorAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/FinderLiveBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends j
{
  public l(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(333980);
    AppMethodBeat.o(333980);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(334002);
    super.initConfig();
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(p.e.BTG);
    localConfigHelper.view(p.e.BKT).desc(p.h.finder_live_game_team_entrance_desc);
    localConfigHelper.view(p.e.CaW).desc(p.h.finder_live_shopping_entrance_desc);
    localConfigHelper.view(p.e.BVZ).desc(p.h.finder_live_visitor_link_entrance_desc);
    localConfigHelper.view(p.e.BNA).desc(p.h.finder_live_lucky_money_entrance_desc);
    localConfigHelper.view(p.e.BVy).desc(p.h.finder_live_gift_entrance_desc);
    localConfigHelper.view(p.e.BMA).desc(p.h.finder_live_like_entrance_desc);
    localConfigHelper.view(p.e.BME).descFormat(p.h.finder_live_visitor_like_tv_desc).valueByView(p.e.BME);
    root(p.f.CdO).view(p.e.close_iv).desc(p.h.finder_live_close_iv_desc).type(ViewType.TextView);
    root(p.e.BLh).view(p.e.BLc).desc(p.h.finder_live_close_iv_desc);
    root(p.e.BTQ).view(p.e.BTQ).desc(p.h.finder_live_post_comment_desc).disableChildren();
    localConfigHelper = root(p.e.live_input_ui_root);
    localConfigHelper.view(p.e.BWP).clickAs(p.e.live_input_txt).disableChildren();
    localConfigHelper.view(p.e.BWR).desc(p.h.finder_live_send_fast_comment);
    localConfigHelper.view(p.e.BWo).desc(p.h.finder_live_at_someone_desc);
    localConfigHelper.view(p.e.live_input_emoji).desc(p.h.finder_live_input_emoji_desc);
    root(p.e.live_title_ui_root).view(p.e.BWM).disableChildren().clickAs(p.e.BWJ).desc((b)new b(this));
    root(p.e.BTV).view(p.e.BTN).desc(p.h.finder_live_music_entrance_desc);
    root(p.e.BPn).view(p.e.BPe).desc(p.h.finder_live_collapse_btn_desc);
    root(p.e.BTJ).view(p.e.BTA).clickAs(p.e.CbT).desc(p.h.finder_live_video_orientation_desc);
    localConfigHelper = root(p.e.BTx);
    localConfigHelper.view(p.e.CbR).desc(p.h.finder_live_switch_camera_btn_desc);
    localConfigHelper.view(p.e.CbP).desc(p.h.finder_live_mute_btn_desc);
    root(p.e.BOB).view(p.e.BOD).desc(p.h.finder_live_mute_btn_desc);
    localConfigHelper = root(p.e.BLJ);
    localConfigHelper.view(p.e.BLG).desc(p.h.finder_live_close_iv_desc).disableChildren().clickAs(p.e.BLF);
    localConfigHelper.view(p.e.BLM).descFormat(p.h.finder_live_wecoin_balance_desc_v2).valueByView(p.e.BLP).disExpand();
    localConfigHelper.view(p.e.BLB).desc((b)new a(this));
    AppMethodBeat.o(334002);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.l
 * JD-Core Version:    0.7.0.1
 */