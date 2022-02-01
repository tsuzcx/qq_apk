package com.tencent.mm.plugin.mall.ui;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.plugin.wxpay.a.f;

public class MallWalletUI$a
  extends MMBaseAccessibilityConfig
{
  public MallWalletUI$a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(262433);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.f.mwui_root_scrollview);
    localConfigHelper.disable(a.f.mwui_root_scrollview);
    localConfigHelper.disable(a.f.mwui_root_relativelayout);
    localConfigHelper.disable(a.f.mwui_root_layout);
    localConfigHelper.disable(a.f.mwui_bottom_layout);
    AppMethodBeat.o(262433);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(262434);
    super.onResume();
    AppMethodBeat.o(262434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletUI.a
 * JD-Core Version:    0.7.0.1
 */