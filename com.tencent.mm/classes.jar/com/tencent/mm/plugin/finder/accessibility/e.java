package com.tencent.mm.plugin.finder.accessibility;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.plugin.finder.accessibility.base.a;
import com.tencent.mm.plugin.finder.e.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/accessibility/FinderCreateContactAccessibility;", "Lcom/tencent/mm/plugin/finder/accessibility/base/MMFinderBaseAccessibility;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(334001);
    AppMethodBeat.o(334001);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(334013);
    focusFirst(e.e.finder_create_title);
    focusOrder().next(e.e.finder_create_title).next(e.e.finder_change_avatar).next(e.e.nickname_container).next(e.e.finder_nick_tv).next(e.e.sex_layout).next(e.e.finder_sex_tv).next(e.e.district_layout).next(e.e.finder_district_tv).next(e.e.wxprofile_setting).next(e.e.wxprofile_setting_switch_btn).next(e.e.tips_container).next(e.e.finder_contact_create_btn);
    AppMethodBeat.o(334013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.accessibility.e
 * JD-Core Version:    0.7.0.1
 */