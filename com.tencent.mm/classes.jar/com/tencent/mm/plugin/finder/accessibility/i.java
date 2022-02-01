package com.tencent.mm.plugin.finder.accessibility;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderLiveAnchorAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/FinderLiveBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends j
{
  public i(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(333982);
    AppMethodBeat.o(333982);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(334012);
    super.initConfig();
    Object localObject = MMApplicationContext.getContext();
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(p.e.BFg);
    localConfigHelper.view(p.e.CaW).desc(p.h.finder_live_shopping_entrance_desc);
    localConfigHelper.view(p.e.BFs).desc(p.h.finder_live_link_entrance_desc);
    localConfigHelper.view(p.e.BXD).desc(p.h.finder_live_lottery_entrance_desc);
    localConfigHelper.view(p.e.BIf).desc(p.h.finder_live_camera_opt_entrance_desc);
    localConfigHelper.view(p.e.BYo).desc(p.h.finder_live_music_entrance_desc);
    localConfigHelper.view(p.e.BFY).desc(p.h.finder_live_lucky_money_entrance_desc);
    localConfigHelper = root(p.e.BQJ);
    localConfigHelper.view(p.e.BQV).desc(p.h.finder_live_close_iv_desc);
    localConfigHelper.view(p.e.BQG).desc(p.h.finder_live_game_entrance_desc).type(ViewType.TextView);
    localConfigHelper.view(p.e.BQX).desc(p.h.finder_live_more_btn_desc).type(ViewType.TextView);
    localConfigHelper.view(p.e.BTe).desc((b)new a(this, (Context)localObject)).expand(12, 12, 12, 12).type(ViewType.TextView);
    localConfigHelper.view(p.e.BQD).desc(p.h.finder_live_post_cover_btn_desc);
    localConfigHelper.view(p.e.BQI).desc(p.h.finder_live_post_edit_text_desc).disableChildren();
    localConfigHelper.view(p.e.BSX).expand(12, 4, 12, 4).descFormat(p.h.finder_live_post_tag_layout_desc).valueByView(p.e.BSY).type(ViewType.TextView);
    localConfigHelper.view(p.e.BTC).expand(12, 4, 12, 4);
    localConfigHelper.view(p.e.BNC).expand(12, 4, 12, 4);
    localConfigHelper.view(p.e.post_location_view).expand(12, 4, 12, 4);
    localConfigHelper.view(p.e.BHP).type(ViewType.Button).desc((b)new b(this));
    localConfigHelper.view(p.e.BQH).desc(p.h.finder_live_post_group_desc);
    localConfigHelper = root(p.e.BJa);
    localConfigHelper.view(p.e.BIO).descFormat(p.h.finder_live_format_btn_desc).valueByView(p.e.BIQ).disableChildren();
    localConfigHelper.view(p.e.BIR).descFormat(p.h.finder_live_format_btn_desc).valueByView(p.e.BIT).disableChildren();
    localConfigHelper.view(p.e.BIU).descFormat(p.h.finder_live_format_btn_desc).valueByView(p.e.BIW).disableChildren();
    localConfigHelper.view(p.e.BIX).descFormat(p.h.finder_live_format_btn_desc).valueByView(p.e.BIZ).disableChildren();
    localConfigHelper.view(p.e.BIL).descFormat(p.h.finder_live_open_or_close_camera_btn_desc).valueByView(p.e.BIN).disableChildren();
    focusOrder().next(p.e.BIO).next(p.e.BIR).next(p.e.BIU).next(p.e.BIX).next(p.e.BIL);
    localConfigHelper = root(p.e.BIh);
    localConfigHelper.view(p.e.BIh).disable();
    localConfigHelper.view(p.e.BIw).desc((b)new c((Context)localObject));
    localConfigHelper.view(p.e.BIx).desc((b)new d((Context)localObject));
    localConfigHelper.view(p.e.BIy).desc((b)new e((Context)localObject));
    localConfigHelper.view(p.e.BHI).desc(p.h.finder_live_reset_btn_desc).type(ViewType.TextView);
    localConfigHelper.view(p.e.BHN).disable();
    root(p.e.live_anchor_close_ui_root).view(p.e.live_anchor_close_ui_root).disableChildren().clickAs(p.e.live_visitor_close_btn_group).desc(p.h.finder_live_close_live_desc);
    localObject = root(p.e.BFW);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BTh).desc(p.h.finder_live_audience_link_mic_btn_desc);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BTk).desc(p.h.finder_live_anchor_link_mic_btn_desc);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BFC).desc(p.h.finder_live_close_iv_desc);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BFH).descFormat(p.h.finder_live_format_btn_desc).valueByView(p.e.BFI).disableChildren();
    focusOrder().next(p.e.BFH).next(p.e.BFS);
    localObject = root(p.e.BGm);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BPb).desc(p.h.finder_live_back_btn_desc);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.Ccc).desc(p.h.finder_live_music_volume_btn_desc);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BXW).desc(p.h.finder_live_music_menu_btn_desc).type(ViewType.TextView);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BBq).desc(p.h.finder_live_music_add_btn_desc).type(ViewType.TextView);
    root(p.e.BJU).view(p.e.BGj).desc(p.h.finder_live_music_volume_plugin_desc);
    AppMethodBeat.o(334012);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(i parami, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    c(Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<View, String>
  {
    d(Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<View, String>
  {
    e(Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.i
 * JD-Core Version:    0.7.0.1
 */