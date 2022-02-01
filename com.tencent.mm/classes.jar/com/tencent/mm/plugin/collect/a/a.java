package com.tencent.mm.plugin.collect.a;

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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/collect/accessibility/CollectCreateQRCodeNewUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "setMoneyAccessibilityLabel", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(293508);
    AppMethodBeat.o(293508);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(293513);
    root(a.g.mm_activity).disable(a.f.mm_content_fl);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.g.collect_create_qrcode_new);
    localConfigHelper.disable(a.f.root_view);
    localConfigHelper.disable(a.f.collect_create_qrcode_rl);
    localConfigHelper.disable(a.f.aa_remit_main_ui);
    localConfigHelper.view(a.f.collect_main_add_desc).type(ViewType.Button);
    localConfigHelper.view(a.f.collect_main_desc).type(ViewType.Button);
    localConfigHelper = root(a.g.wallet_remittance_form_money);
    localConfigHelper.view(a.f.wallet_content).type(ViewType.TextView).descFormat(a.i.collect_tripple_text3).valueByView(a.f.wallet_title).valueByView(a.f.wallet_content).valueByString(a.i.collect_edit_text);
    localConfigHelper.disable(a.f.wallet_title);
    AppMethodBeat.o(293513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.a.a
 * JD-Core Version:    0.7.0.1
 */