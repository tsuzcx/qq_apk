package com.tencent.mm.plugin.finder.accessibility;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderLiveGamePostAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends a
{
  public k(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(333971);
    AppMethodBeat.o(333971);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(333985);
    Object localObject = MMApplicationContext.getContext();
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(p.e.BVi);
    localConfigHelper.view(p.e.BVj).desc(p.h.finder_live_back_btn_desc);
    localConfigHelper.view(p.e.BKO).desc(p.h.finder_live_search_btn_desc).disableChildren();
    localConfigHelper.view(p.e.ok_btn).type(ViewType.Button);
    localConfigHelper.view(p.e.BES).desc((b)new a(this, (Context)localObject));
    localObject = root(p.e.BVb);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BVe).desc(p.h.finder_live_back_btn_desc);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BUY).desc(p.h.finder_live_game_post_view_cover_desc);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BVf).desc(p.h.finder_live_game_post_replace_cover_desc);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.post_desc_edt).desc(p.h.finder_live_game_post_edit_desc).type(ViewType.TextView);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.textcount_hint).descFormat(p.h.finder_live_game_post_edit_count_desc).valueByView(p.e.textcount_hint);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BVq).desc(p.h.finder_live_game_team_condition_desc);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BZm).type(ViewType.Button);
    ((MMBaseAccessibilityConfig.ConfigHelper)localObject).view(p.e.BVa).disable();
    focusFirst(p.e.BVe);
    focusOrder().next(p.e.BVe).next(p.e.BVd).next(p.e.BUY);
    AppMethodBeat.o(333985);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, String>
  {
    a(k paramk, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.k
 * JD-Core Version:    0.7.0.1
 */