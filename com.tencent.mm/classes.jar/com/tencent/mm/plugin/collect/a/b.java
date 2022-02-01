package com.tencent.mm.plugin.collect.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/collect/accessibility/CollectMainAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MMBaseAccessibilityConfig
{
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(293510);
    AppMethodBeat.o(293510);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(293517);
    root(a.g.collect_main).disable(16908298);
    root(a.g.collect_pay_info_bottom_corner_preference).view(a.f.pay_info_bottom_corner_ll).disableChildren().desc((kotlin.g.a.b)new b.a(this));
    root(a.g.collect_main_footer).disable(a.f.collect_main_footer_container);
    root(a.g.collect_half_dialog_head_x).view(a.f.back_cion).type(ViewType.Button).desc(a.i.close_btn);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.collect_main_header);
    localConfigHelper.disable(a.f.collect_main_receive_toast);
    localConfigHelper.disable(a.f.collect_main_header_root_rl);
    localConfigHelper.view(a.f.collect_menu_more_btn_layout).type(ViewType.Button).desc(a.i.chatting_more);
    localConfigHelper.view(a.f.collect_main_ftf_pay_qrcode).type(ViewType.Button).desc(a.i.qrcode_image);
    localConfigHelper.view(a.f.collect_set_money_tv).type(ViewType.Button);
    localConfigHelper.view(a.f.collect_main_save_qrcode).type(ViewType.Button);
    localConfigHelper.view(a.f.collect_assist_layout).type(ViewType.Button).desc(a.i.collect_main_pay_account_book).disableChildren();
    localConfigHelper.view(a.f.collect_main_fixed_fee).descFormat(a.i.collect_tripple_text2).valueByView(a.f.collect_main_fixed_fee_currency).valueByView(a.f.collect_main_fixed_fee);
    root(a.g.new_menu_sheet_dialog).view(a.f.touch_outside).type(ViewType.Button).desc(a.i.close_btn);
    root(a.g.design_bottom_sheet_dialog).view(a.f.touch_outside).type(ViewType.Button).desc(a.i.close_btn);
    focusOrder().next(a.f.text1);
    AppMethodBeat.o(293517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.b
 * JD-Core Version:    0.7.0.1
 */