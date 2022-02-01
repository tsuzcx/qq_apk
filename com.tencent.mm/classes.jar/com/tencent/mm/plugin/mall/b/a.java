package com.tencent.mm.plugin.mall.b;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mall/util/MallIndexAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(262360);
    AppMethodBeat.o(262360);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(262364);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.mall_index_new_header_stub_v2);
    localConfigHelper.view(a.f.minh_pos_layout).type(ViewType.Button).desc(a.i.wallet_index_ui_offline_entrance);
    localConfigHelper.view(a.f.minh_wallet_layout).type(ViewType.Button).descFormat(a.i.wallet_tripple_text_accessibility).valueByView(a.f.minh_wallet_title).valueByView(a.f.wallet_bottom_text_tv).valueByView(a.f.mlv_money_tv);
    localConfigHelper.focusFirst(a.f.minh_pos_layout);
    localConfigHelper.disable(a.f.minh_wallet_title);
    localConfigHelper.disable(a.f.wallet_bottom_text_tv);
    localConfigHelper.disable(a.f.mlv_money_tv);
    localConfigHelper.disable(a.f.wallet_bottom_text_layout);
    root(a.g.money_loading_view).disable(a.f.mlv_money_tv);
    root(a.g.mall_function_list_line_v2).view(a.f.mall_fucntion_list_section_title).desc((b)a.a.KNd);
    localConfigHelper = root(a.g.mall_index_function_item_v2);
    localConfigHelper.view(a.f.mall_index_function_item_main).type(ViewType.Button).desc((b)new a.b(this));
    localConfigHelper.disable(a.f.mall_index_function_item_container);
    root(a.g.action_option_view).view(a.f.action_option_icon).desc(a.i.wallet_menu_more);
    AppMethodBeat.o(262364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.b.a
 * JD-Core Version:    0.7.0.1
 */