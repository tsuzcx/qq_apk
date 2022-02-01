package com.tencent.mm.plugin.honey_pay.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.wxpay.a.f;

public class HoneyPayModifyQuotaUI$a
  extends MMBaseAccessibilityConfig
{
  public HoneyPayModifyQuotaUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(267325);
    root(a.f.hpmq_root_layout).view(a.f.wallet_title).disable();
    AppMethodBeat.o(267325);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI.a
 * JD-Core Version:    0.7.0.1
 */