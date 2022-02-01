package com.tencent.mm.plugin.aa.model;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.FocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/aa/model/AAAccessibilityConfig;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "Companion", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  private static final String TAG;
  public static final a.a pFC;
  
  static
  {
    AppMethodBeat.i(268387);
    pFC = new a.a((byte)0);
    TAG = "AA.Accessibility";
    AppMethodBeat.o(268387);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(268386);
    AppMethodBeat.o(268386);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(268389);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.aa_entrance_ui);
    localConfigHelper.focusFirst(a.f.title_desc_ll);
    localConfigHelper.view(a.f.check_aa_record_tv).type(ViewType.Button);
    root(a.g.launch_aa_form_money).disable(a.f.wallet_content);
    localConfigHelper = root(a.g.launch_aa_ui_new);
    localConfigHelper.disable(a.f.launch_aa_total_amount_hint);
    localConfigHelper.disable(a.f.launch_aa_amount_unit);
    localConfigHelper.disable(a.f.launch_aa_amount);
    localConfigHelper.disable(a.f.launch_aa_switch_mode);
    localConfigHelper.focusFirst(a.f.launch_aa_switch_ll);
    localConfigHelper.view(a.f.launch_aa_switch_ll).type(ViewType.Button);
    localConfigHelper.view(a.f.launch_aa_total_amount_edit_form).type(ViewType.EditText).descFormat(a.i.launch_aa_amount_edit_text_accessibility).valueByKey("LAUNCH_AA_TOTAL_MONEY_EDIT_FORM_VALUE_KEY").valueByView(a.f.launch_aa_total_amount_currency_symbol);
    localConfigHelper.view(a.f.launch_aa_by_person_select_header_layout).type(ViewType.Button).descFormat(a.i.talkback_placehodler_2).valueByView(a.f.launch_aa_by_person_select_title).valueByView(a.f.launch_aa_by_person_user_select);
    localConfigHelper.view(a.f.launch_by_money_total_usernumber_content_layout).type(ViewType.Button).descFormat(a.i.talkback_placehodler_2).valueByView(a.f.launch_aa_by_money_user_select_hint).valueByView(a.f.launch_aa_by_money_user_select);
    localConfigHelper.view(a.f.launch_aa_title_edit_wrapper_ll).clickAs(a.f.launch_aa_title_edit);
    localConfigHelper.view(a.f.launch_by_person_fill_in_select_layout_tips).desc((b)a.b.pFD);
    localConfigHelper.view(a.f.content_iv).type(ViewType.Button).desc(a.i.launch_aa_image_added_accessibility);
    root(a.g.launch_aa_by_person_name_amount_row).view(a.f.row_ll).descFormat(a.i.talkback_placehodler_2).valueByView(a.f.username).valueByView(a.f.amount);
    root(a.g.contact_header).disable(a.f.header_parent);
    localConfigHelper = root(a.g.actionbar_title_center);
    localConfigHelper.view(a.f.title_ll).descFormat(a.i.talkback_placehodler).valueByView(a.f.text1);
    localConfigHelper.disable(a.f.text1);
    localConfigHelper.focusOrder().next(a.f.actionbar_up_indicator).next(a.f.title_ll);
    root(a.g.launch_aa_by_person_amount_select_ui).view(a.f.clear_amount).type(ViewType.Button);
    localConfigHelper = root(a.g.launch_aa_by_person_amount_select_row);
    localConfigHelper.disable(a.f.root);
    localConfigHelper.disable(a.f.avatar);
    localConfigHelper.disable(a.f.launch_aa_by_person_money_unit);
    localConfigHelper.view(a.f.username_ll).type(ViewType.TextView).descFormat(a.i.talkback_placehodler_2).valueByView(a.f.username).valueByView(a.f.subname);
    localConfigHelper = root(a.g.paylist_aa_ui);
    localConfigHelper.disable(a.f.paylist_aa_content_layout);
    localConfigHelper.disable(a.f.paylist_aa_avatar_iv);
    localConfigHelper.focusFirst(a.f.paylist_aa_nick_name);
    localConfigHelper.view(a.f.paylist_aa_instant_pay_amount_ll).descFormat(a.i.talkback_placehodler_2).valueByView(a.f.paylist_aa_instant_pay_tip_tv).valueByView(a.f.need_pay_amount_tv);
    localConfigHelper.view(a.f.paylist_aa_send_tip_tv).type(ViewType.Button);
    localConfigHelper.view(a.f.paylist_aa_bottom_tip_tv).type(ViewType.Button);
    localConfigHelper.view(a.f.paylist_aa_add_desc).type(ViewType.Button);
    root(a.g.paylist_aa_memeber_item).disable(a.f.paylist_aa_member_avatar_iv);
    localConfigHelper = root(a.g.aa_remittance_ui);
    localConfigHelper.disable(a.f.aa_remit_logo);
    localConfigHelper.disable(a.f.root_content_rl);
    localConfigHelper.view(a.f.add_remittance_desc).type(ViewType.Button);
    localConfigHelper.view(a.f.aa_remit_money_et).type(ViewType.EditText).descFormat(a.i.biz_timeline_placeholder).valueByKey("REMITTANCE_AA_MONEY_EDIT_FORM_VALUE_KEY");
    localConfigHelper = root(a.g.wallet_remittance_form_money);
    localConfigHelper.disable(a.f.wallet_title);
    localConfigHelper.disable(a.f.wallet_content);
    root(a.g.action_option_view).view(a.f.action_option_icon).desc(a.i.wallet_menu_more);
    root(a.g.aa_record_list_h5url_footer).view(a.f.aa_record_bottom_link_tv).type(ViewType.Button).desc(a.i.aa_list_record_bottom_link_text);
    AppMethodBeat.o(268389);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.a
 * JD-Core Version:    0.7.0.1
 */