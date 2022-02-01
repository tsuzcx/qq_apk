package com.tencent.mm.plugin.honey_pay.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class HoneyPayReceiveCardUI$a
  extends MMBaseAccessibilityConfig
{
  public HoneyPayReceiveCardUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(267318);
    root(a.g.honey_pay_receive_card_ui).view(a.f.hprc_receive_btn).desc(a.f.hprc_receive_btn).type(ViewType.Button);
    focusFirst(a.f.hprc_top_layout);
    AppMethodBeat.o(267318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.a
 * JD-Core Version:    0.7.0.1
 */