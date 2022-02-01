package com.tencent.mm.plugin.fts.ui.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/accessibility/FtsAddFriendUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(265667);
    AppMethodBeat.o(265667);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(265686);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(p.e.fts_add_friend_ui);
    localConfigHelper.view(p.d.search_bar_container).clickAs(p.d.search_icon_fts_main_key);
    localConfigHelper.disable(p.d.search_icon_fts_main_key);
    root(p.e.fts_actionbar_searchview).disable(p.d.search_icon);
    AppMethodBeat.o(265686);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.a
 * JD-Core Version:    0.7.0.1
 */