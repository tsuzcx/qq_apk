package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import kotlin.g.a.b;

public class LuckyMoneyPrepareUI$LuckyMoneyPrepareUIAccessibilityConfig
  extends MMBaseAccessibilityConfig
{
  public LuckyMoneyPrepareUI$LuckyMoneyPrepareUIAccessibilityConfig(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(284556);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper1 = root(a.f.lucky_money_prepare_root);
    localConfigHelper1.disable(a.f.lucky_money_prepare_input_area);
    localConfigHelper1.disable(a.f.lucky_money_sv);
    localConfigHelper1.disable(a.f.lucky_money_sv_content);
    localConfigHelper1.disable(a.f.lucky_money_input_content);
    localConfigHelper1.view(a.f.lucky_money_mode_layout).desc(a.f.lucky_money_mode_title_tv).type(ViewType.Button);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper2 = root(a.f.lucky_money_wish_et);
    localConfigHelper2.view(a.f.lucky_money_text_input_root).disable();
    localConfigHelper2.view(a.f.lucky_money_emoji_bt).desc(a.i.lucky_money_add_expression).type(ViewType.Button);
    localConfigHelper1.view(a.f.lucky_money_exclusive_layout).desc(new b() {}).type(ViewType.Button);
    localConfigHelper1.view(a.f.lucky_money_envelope_layout).desc(new b() {}).type(ViewType.Button);
    AppMethodBeat.o(284556);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(284558);
    super.onResume();
    AppMethodBeat.o(284558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.LuckyMoneyPrepareUIAccessibilityConfig
 * JD-Core Version:    0.7.0.1
 */