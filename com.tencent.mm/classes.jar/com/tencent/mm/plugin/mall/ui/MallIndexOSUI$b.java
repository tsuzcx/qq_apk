package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.GlobalFocusOrderHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.accessibility.type.ViewType;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import kotlin.g.a.b;

public class MallIndexOSUI$b
  extends MMBaseAccessibilityConfig
{
  public MallIndexOSUI$b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
  }
  
  public void initConfig()
  {
    AppMethodBeat.i(262423);
    focusOrder().next(a.f.offline_area);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(a.f.header_content_layout);
    localConfigHelper.view(a.f.offline_area).type(ViewType.Button).descFormat(a.i.accessibility_wallet_btn_suffix_text).valueByView(a.f.offline_wording);
    localConfigHelper.view(a.f.balance_area).type(ViewType.Button).descFormat(a.i.accessibility_wallet_btn_suffix_text2).valueByView(a.f.balance_wording).valueByView(a.f.balance_num);
    localConfigHelper.view(a.f.bankcard_area).type(ViewType.Button).descFormat(a.i.accessibility_wallet_btn_suffix_text).valueByView(a.f.bankcard_tv);
    root(a.f.mall_index_function_item_container).view(a.f.mall_index_function_item_main).type(ViewType.Button).desc(new b() {});
    AppMethodBeat.o(262423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI.b
 * JD-Core Version:    0.7.0.1
 */