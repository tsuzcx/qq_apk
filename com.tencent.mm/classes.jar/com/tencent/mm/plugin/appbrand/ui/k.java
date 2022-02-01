package com.tencent.mm.plugin.appbrand.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandProfileAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends MMBaseAccessibilityConfig
{
  public k(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(322206);
    AppMethodBeat.o(322206);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(322213);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(ba.g.app_brand_profile_ui_header);
    localConfigHelper.view(ba.f.profile_icon).disable();
    localConfigHelper.view(ba.f.more_info_layout).type(ViewType.Button).desc(ba.i.appbrand_profile_talk_back_action_see_more_info);
    localConfigHelper.view(ba.f.profile_biz_layout).type(ViewType.Button).desc(ba.i.appbrand_profile_talk_back_action_see_related_biz);
    localConfigHelper.view(ba.f.profile_wxa_layout).type(ViewType.Button).desc(ba.i.appbrand_profile_talk_back_action_see_related_wxa);
    root(ba.g.app_brand_profile_relieved_buy_lite_layout).view(ba.f.profile_relieved_buy_lite_layout).type(ViewType.Button);
    root(ba.g.app_brand_profile_relieved_buy_full_layout).view(ba.f.profile_relieved_buy_full_layout).type(ViewType.Button).descFormat(ba.i.appbrand_profile_talk_back_state_relieved_buy_full_format).valueByView(ba.f.profile_relieved_buy_full_info);
    AppMethodBeat.o(322213);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.k
 * JD-Core Version:    0.7.0.1
 */